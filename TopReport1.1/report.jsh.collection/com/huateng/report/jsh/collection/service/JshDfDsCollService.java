package com.huateng.report.jsh.collection.service;

import java.util.Date;

import resource.bean.report.MtsJshDefgDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class JshDfDsCollService {
	
	public static synchronized JshDfDsCollService getInstance() {
		return (JshDfDsCollService) ApplicationContextUtils.getBean(JshDfDsCollService.class.getName());
	}
	
	/*
	 * 外汇账户内结汇补录基础信息新增
	 */
	public void collBasicAdd(MtsJshDefgDs ds) throws CommonException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		//开始插入逻辑
		String rec_id = ReportUtils.getUUID();
		//状态变化等信息
		/*
		 * 操作状态=A-创建
		 * 记录状态=02-编辑待确认
		 * 审核状态=00-未审核
		 * 回执状态=00-未返回
		 * 是否已成功上报=0-否
		 */
		ds.setId(rec_id);
		ds.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		ds.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		ds.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		ds.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//必输项
		ds.setApptype(TopReportConstants.REPORT_APP_TYPE_JSH);
		ds.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_D);
		//其他字段
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		ds.setLstUpdTlr(globalInfo.getTlrno());
		ds.setLstUpdTm(new Date());
		ds.setCrtTm(new Date());
		//机构号
		ds.setBrNo(globalInfo.getBrno());
		//工作日期当天
		ds.setWorkDate(DateUtil.getWorkDate());
		//默认未上报
		ds.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//保存前后台验证
		ReportDataVaildUtil.executeVaild(ds.getApptype(), ds.getCurrentfile(), ds);
		dao.save(ds);
		//数据处理记录表(业务编号存的是rptno,人民币结构性存款编号)
		String appType = TopReportConstants.REPORT_APP_TYPE_JSH;
		String currentFile = TopReportConstants.REPORT_FILE_TYPE_JSH_D;
		String recId = rec_id;
		String busiNo = ds.getRptno();
		String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT;
		String execResult = "新增";
		String execRemark = "基础信息新增";
		ReportCommonService.getInstance().saveBiDataProcessLog(appType, currentFile, recId, busiNo, execType, execResult, execRemark);
	}
	/*
	 * 外汇账户内结汇补录基础信息修改
	 */
	public void collBasicMod(MtsJshDefgDs ds) throws CommonException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		MtsJshDefgDs mtsJshDefgDs = getBeanById(ds.getId());
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//修改逻辑开始
		//第一步判断记录状态是否为01-可编辑或者02编辑待确认
		String recStatus = mtsJshDefgDs.getRecStatus();
		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStatus) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStatus)) {
			//不是01或者02不能删除
			ExceptionUtil.throwCommonException("该数据已被修改，请刷新!");
		}
		//第二步根据是否已成功上报判断操作状态,记录相应的状态
		String subSuccess = mtsJshDefgDs.getSubSuccess();
		//记录系统信息
		String rActiontype = null;
		String rRecStatus = null;
		String rApproveStatus = null;
		String rRepStatus = null;
		//拷贝页面信息
		mtsJshDefgDs.setBuscode(ds.getBuscode());
		mtsJshDefgDs.setCustype(ds.getCustype());
		mtsJshDefgDs.setCustcod(ds.getCustcod());
		mtsJshDefgDs.setIdcode(ds.getIdcode());
		mtsJshDefgDs.setCustnm(ds.getCustnm());
		mtsJshDefgDs.setFcyacc(ds.getFcyacc());
		mtsJshDefgDs.setLcyacc(ds.getLcyacc());
		mtsJshDefgDs.setOppuser(ds.getOppuser());
		mtsJshDefgDs.setOppbank(ds.getOppbank());
		mtsJshDefgDs.setFcyamt(ds.getFcyamt());
		mtsJshDefgDs.setFcyccy(ds.getFcyccy());
		mtsJshDefgDs.setExrate(ds.getExrate());
		mtsJshDefgDs.setFiller2(ds.getFiller2());
		//是否已成功上报状态不做变化，这里省略
		if(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES.equals(subSuccess)) {
			rActiontype = TopReportConstants.REPORT_ACTIONTYPE_C;
			rRecStatus = TopReportConstants.REPORT_RECSTATUS_02;
			rApproveStatus = TopReportConstants.REPORT_APPROVESTATUS_00;
			rRepStatus = TopReportConstants.REPORT_REPSTATUS_00;
		}
		if(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO.equals(subSuccess)) {
			rActiontype = TopReportConstants.REPORT_ACTIONTYPE_A;
			rRecStatus = TopReportConstants.REPORT_RECSTATUS_02;
			rApproveStatus = TopReportConstants.REPORT_APPROVESTATUS_00;
			rRepStatus = TopReportConstants.REPORT_REPSTATUS_00;
		}
		mtsJshDefgDs.setActiontype(rActiontype);
		mtsJshDefgDs.setRecStatus(rRecStatus);
		mtsJshDefgDs.setApproveStatus(rApproveStatus);
		mtsJshDefgDs.setRepStatus(rRepStatus);
		mtsJshDefgDs.setLstUpdTlr(globalInfo.getTlrno());
		mtsJshDefgDs.setLstUpdTm(new Date());
		mtsJshDefgDs.setBrNo(globalInfo.getBrno());
		//workdate一起更新
		mtsJshDefgDs.setWorkDate(DateUtil.getWorkDate());
		//保存前后台验证
		ReportDataVaildUtil.executeVaild(ds.getApptype(), ds.getCurrentfile(), ds);
		//记录到业务表
		ROOTDAOUtils.getROOTDAO().update(mtsJshDefgDs);
		//记录数据到数据处理记录表
		String appType = TopReportConstants.REPORT_APP_TYPE_JSH;
		String currentFile = TopReportConstants.REPORT_FILE_TYPE_JSH_D;
		String recId = mtsJshDefgDs.getId();
		String busiNo = mtsJshDefgDs.getRptno();
		String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT;
		String execResult = "修改";
		String execRemark = "基础信息修改";
		ReportCommonService.getInstance().saveBiDataProcessLog(appType, currentFile, recId, busiNo, execType, execResult, execRemark);
	}
	/*
	 * 外汇账户内结汇补录基础信息删除
	 */
	public void collBasicDel(MtsJshDefgDs ds) throws CommonException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		//删除逻辑开始
		//第一步判断记录状态是否为01-可编辑或者02编辑待确认
		MtsJshDefgDs ds2 = getBeanById(ds.getId());
		String recStatus = ds2.getRecStatus();
		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStatus) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStatus)) {
			//不是01或者02不能删除
			ExceptionUtil.throwCommonException("该数据已被修改，请刷新!");
		}
		//第二步判断业务是否能删除
		boolean flag1 = delJshDfDsCollAvailable(ds.getId());
		if(!flag1) {
			//提示不能删除
			ExceptionUtil.throwCommonException("该数据存在申报信息或者管理信息，不能删除!");
		}
		//记录系统信息
		/*
		 * 操作状态=D-删除
		 * 记录状态=02-编辑待确认
		 * 审核状态=00-未审核
		 * 回执状态=00-未返回
		 * 是否已成功上报=不变化
		 */
		ds2.setActiondesc(ds.getActiondesc());
		ds2.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		ds2.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		ds2.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		ds2.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		//其他字段
		ds2.setLstUpdTlr(globalInfo.getTlrno());
		ds2.setLstUpdTm(new Date());
		ds2.setBrNo(globalInfo.getBrno());
		//更新workdate
		ds2.setWorkDate(DateUtil.getWorkDate());
		dao.update(ds2);
		//记录数据到数据处理记录表
		String appType = TopReportConstants.REPORT_APP_TYPE_JSH;
		String currentFile = TopReportConstants.REPORT_FILE_TYPE_JSH_D;
		String recId = ds2.getId();
		String busiNo = ds2.getRptno();
		String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL;
		String execResult = "删除";
		String execRemark = "基础信息删除";
		ReportCommonService.getInstance().saveBiDataProcessLog(appType, currentFile, recId, busiNo, execType, execResult, execRemark);
		//删除逻辑完成
	}
	/*
	 * 判断基础信息是否能删除
	 */
	private boolean delJshDfDsCollAvailable(String id) throws CommonException {
		// TODO Auto-generated method stub
		String hql = " select count(ds) from MtsJshDefgDs ds where ds.apptype = '"+TopReportConstants.REPORT_APP_TYPE_JSH+"'";
		hql += " and ds.filler1 = '"+id+"'";
		hql += " and ds.currentfile != '"+TopReportConstants.REPORT_FILE_TYPE_JSH_D+"'";
		hql += " and ds.actiontype != '"+TopReportConstants.REPORT_ACTIONTYPE_D+"'";
		return ROOTDAOUtils.getROOTDAO().queryByHqlToCount(hql) == 0 ? true : false;
	}

	/*
	 * 获得该数据
	 */
	private MtsJshDefgDs getBeanById(String id) throws CommonException {
		// TODO Auto-generated method stub
		MtsJshDefgDs ds = ROOTDAOUtils.getROOTDAO().query(MtsJshDefgDs.class, id);
		if(ds == null) {
			throw new CommonException("该数据已经不存在！请刷新!");
		} else {
			return ds;
		}
	}
	/*
	 * 管理信息新增
	 */
	public void collManageAdd(MtsJshDefgDs ds) throws CommonException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String uuid = ReportUtils.getUUID();
		ds.setId(uuid);
		ds.setApptype(TopReportConstants.REPORT_APP_TYPE_JSH);
		ds.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_F);
		//系统信息记录
		ds.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		ds.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		ds.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		ds.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//其他字段
		ds.setLstUpdTlr(globalInfo.getTlrno());
		ds.setLstUpdTm(new Date());
		ds.setCrtTm(new Date());
		//workdate
		ds.setWorkDate(DateUtil.getWorkDate());
		//机构号
		ds.setBrNo(globalInfo.getBrno());
		//保存前后台验证
		ReportDataVaildUtil.executeVaild(ds.getApptype(), ds.getCurrentfile(), ds);
		rootDao.save(ds);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_JSH, TopReportConstants.REPORT_FILE_TYPE_JSH_F, uuid,
				ds.getRptno(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "管理信息新增");
	}
	/*
	 * 管理信息修改
	 */
	public void collManageMod(MtsJshDefgDs ds) throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//根据是否上报成功填写系统信息
		String isSubSuccess = ds.getSubSuccess();
		String actiontype = null;
		String recStatus = null;
		String approveStatus = null;
		String repStatus = null;
		if(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES.equalsIgnoreCase(isSubSuccess)) {
			actiontype = TopReportConstants.REPORT_ACTIONTYPE_C;
			recStatus = TopReportConstants.REPORT_RECSTATUS_02;
			approveStatus = TopReportConstants.REPORT_APPROVESTATUS_00;
			repStatus = TopReportConstants.REPORT_REPSTATUS_00;
		} else if(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO.equalsIgnoreCase(isSubSuccess)) {
			actiontype = TopReportConstants.REPORT_ACTIONTYPE_A;
			recStatus = TopReportConstants.REPORT_RECSTATUS_02;
			approveStatus = TopReportConstants.REPORT_APPROVESTATUS_00;
			repStatus = TopReportConstants.REPORT_REPSTATUS_00;
		}
		ds.setActiontype(actiontype);
		ds.setRecStatus(recStatus);
		ds.setApproveStatus(approveStatus);
		ds.setRepStatus(repStatus);
		//其他字段
		ds.setLstUpdTlr(globalInfo.getTlrno());
		ds.setLstUpdTm(new Date());
		ds.setBrNo(globalInfo.getBrno());
		//workdate
		ds.setWorkDate(DateUtil.getWorkDate());
		//保存前后台验证
		ReportDataVaildUtil.executeVaild(ds.getApptype(), ds.getCurrentfile(), ds);
		dao.update(ds);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_JSH, TopReportConstants.REPORT_FILE_TYPE_JSH_F, ds.getId(),
				ds.getRptno(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "管理信息修改");
	}
	/*
	 * 管理信息删除
	 */
	public void collManageDel(MtsJshDefgDs ds) throws CommonException {
		// TODO Auto-generated method stub
		//删除逻辑
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//记录系统信息
		ds.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		ds.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		ds.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		//上报状态未变化 忽略
		//其他字段
		ds.setLstUpdTlr(globalInfo.getTlrno());
		ds.setLstUpdTm(new Date());
		ds.setBrNo(globalInfo.getBrno());
		//workdate
		ds.setWorkDate(DateUtil.getWorkDate());
		dao.update(ds);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_JSH, TopReportConstants.REPORT_FILE_TYPE_JSH_F, ds.getId(),
				ds.getRptno(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", "管理信息删除");
	}
}
