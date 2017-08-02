package com.huateng.report.bop.collection.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import resource.bean.report.MtsBopAgDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bop.collection.operation.BopAgDsOperation;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopAgDsUpdateService {
	
	protected static final Logger logger = Logger.getLogger(BopAgDsUpdateService.class);

	protected BopAgDsUpdateService() {
	}

	public synchronized static BopAgDsUpdateService getInstance() {
		return (BopAgDsUpdateService) ApplicationContextUtils.getBean(BopAgDsUpdateService.class.getName());
	}
	
	/**
	 * 保存或更新BOP国际收支涉外收入相关信息
	 * @param bopDs
	 * @param type
	 * @throws CommonException
	 */
	public void saveBopAgDs(MtsBopAgDs bopAgDs, String type) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if (BopAgDsOperation.OP_A_NEW.equals(type)){
			saveBopANew(bopAgDs, gi, rootdao, commonService);
		} else if (BopAgDsOperation.OP_A_MOD.equals(type)) {
			saveBopAMod(bopAgDs, gi, rootdao, commonService);
		} else if (BopAgDsOperation.OP_A_DEL.equals(type)) {
			saveBopADel(bopAgDs, gi, rootdao, commonService);
		} else if (BopAgDsOperation.OP_G_NEW.equals(type)) {
			saveBopGNew(bopAgDs, gi, rootdao, commonService);
		} else if (BopAgDsOperation.OP_G_MOD.equals(type)) {
			saveBopGMod(bopAgDs, gi, rootdao, commonService);
		} else if (BopAgDsOperation.OP_G_DEL.equals(type)) {
			saveBopGDel(bopAgDs, gi, rootdao, commonService);
		} 
	}
	
	private void saveBopANew(MtsBopAgDs bopAgDs, GlobalInfo gi, ROOTDAO rootdao,
			ReportCommonService commonService) throws CommonException {
		bopAgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		bopAgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopAgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopAgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		bopAgDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		// 生成申报号码
		String rptno = ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_BOP_A);
		bopAgDs.setRptno(rptno);
		bopAgDs.setCrtTm(new Date());
		bopAgDs.setLstUpdTm(new Date());
		bopAgDs.setLstUpdTlr(gi.getTlrno());
		bopAgDs.setBrNo(gi.getBrno());
		bopAgDs.setId(ReportUtils.getUUID());
		bopAgDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
		bopAgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_A);
		bopAgDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

		// 验证类并且配置
		ReportDataVaildUtil.executeVaild(bopAgDs.getApptype(), bopAgDs.getCurrentfile(), bopAgDs);

		//数据处理记录表保存
		commonService.saveBiDataProcessLog(bopAgDs.getApptype(), bopAgDs.getCurrentfile(), bopAgDs.getId(), bopAgDs.getRptno(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

		rootdao.save(bopAgDs);
	}
	
	private void saveBopAMod(MtsBopAgDs bopAgDs, GlobalInfo gi, ROOTDAO rootdao,
			ReportCommonService commonService) throws CommonException {
		MtsBopAgDs dbBopAgDs = rootdao.query(MtsBopAgDs.class, bopAgDs.getId());

		if(!StringUtils.equals(bopAgDs.getRecStatus(), dbBopAgDs.getRecStatus())){
			ExceptionUtil.throwCommonException("BOP交易["+dbBopAgDs.getBuscode()+"]已经被其他用户修改");
		}

		dbBopAgDs.setRptno(bopAgDs.getRptno());
		dbBopAgDs.setCustype(bopAgDs.getCustype());
		dbBopAgDs.setIdcode(bopAgDs.getIdcode());
		dbBopAgDs.setCustcod(bopAgDs.getCustcod());
		dbBopAgDs.setCustnm(bopAgDs.getCustnm());
		dbBopAgDs.setOppuser(bopAgDs.getOppuser());
		dbBopAgDs.setTxccy(bopAgDs.getTxccy());
		dbBopAgDs.setTxamt(bopAgDs.getTxamt());
		dbBopAgDs.setExrate(bopAgDs.getExrate());
		dbBopAgDs.setLcyamt(bopAgDs.getLcyamt());
		dbBopAgDs.setLcyacc(bopAgDs.getLcyacc());
		dbBopAgDs.setFcyamt(bopAgDs.getFcyamt());
		dbBopAgDs.setFcyacc(bopAgDs.getFcyacc());
		dbBopAgDs.setOthamt(bopAgDs.getOthamt());
		dbBopAgDs.setOthacc(bopAgDs.getOthacc());
		dbBopAgDs.setMethod(bopAgDs.getMethod());
		dbBopAgDs.setBuscode(bopAgDs.getBuscode());
		dbBopAgDs.setInchargeccy(bopAgDs.getInchargeccy());
		dbBopAgDs.setInchargeamt(bopAgDs.getInchargeamt());
		dbBopAgDs.setOutchargeccy(bopAgDs.getOutchargeccy());
		dbBopAgDs.setOutchargeamt(bopAgDs.getOutchargeamt());
		dbBopAgDs.setFiller2(bopAgDs.getFiller2());
		dbBopAgDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
		dbBopAgDs.setActiondesc(bopAgDs.getActiondesc());
		dbBopAgDs.setLstUpdTlr(gi.getTlrno());
		dbBopAgDs.setLstUpdTm(new Date());
		if (dbBopAgDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
			dbBopAgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		} else {
			dbBopAgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
		}
		dbBopAgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbBopAgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbBopAgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

		ReportDataVaildUtil.executeVaild(dbBopAgDs.getApptype(), dbBopAgDs.getCurrentfile(), dbBopAgDs);
		
		//数据处理记录表保存
		commonService.saveBiDataProcessLog(dbBopAgDs.getApptype(), dbBopAgDs.getCurrentfile(), dbBopAgDs.getId(), dbBopAgDs.getRptno(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

		rootdao.saveOrUpdate(dbBopAgDs);
	}

	private void saveBopADel(MtsBopAgDs bopAgDs, GlobalInfo gi, ROOTDAO rootdao,
			ReportCommonService commonService) throws CommonException {
		MtsBopAgDs dbBopAgDs = rootdao.query(MtsBopAgDs.class, bopAgDs.getId());
		/**
		 * 校验当前数据是否已经被其他用户更新
		 */
		if(!StringUtils.equals(bopAgDs.getRecStatus(), dbBopAgDs.getRecStatus())){
			ExceptionUtil.throwCommonException("BOP交易["+bopAgDs.getBuscode()+"]已经被其他用户修改");
		}
		
		/**
		 * 根据账户信息的ID 查询相应申报信息
		 */
		Integer count = rootdao.queryByHqlToCount(" SELECT count(model) FROM MtsBopAgDs model WHERE model.filler1 = '" + bopAgDs.getId() + "' ");
		if (count > 0){
			ExceptionUtil.throwCommonException("已存在相关的申报信息不能删除！");
		}
		
		dbBopAgDs.setLstUpdTlr(gi.getTlrno());
		dbBopAgDs.setLstUpdTm(new Date());
		dbBopAgDs.setActiondesc(bopAgDs.getActiondesc());
		dbBopAgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		dbBopAgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbBopAgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbBopAgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		dbBopAgDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
		//数据处理记录表保存
		commonService.saveBiDataProcessLog(dbBopAgDs.getApptype(), dbBopAgDs.getCurrentfile(), dbBopAgDs.getId(), dbBopAgDs.getRptno(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopAgDs.getActiondesc());

		rootdao.saveOrUpdate(dbBopAgDs);
	}
	
	private void saveBopGNew(MtsBopAgDs bopAgDs, GlobalInfo gi, ROOTDAO rootdao,
			ReportCommonService commonService) throws CommonException {
		MtsBopAgDs newBopAgDs = new MtsBopAgDs();
		//新增基本信息
		newBopAgDs.setId(ReportUtils.getUUID());
		newBopAgDs.setCrtTm(new Date());
		newBopAgDs.setLstUpdTm(new Date());
		newBopAgDs.setLstUpdTlr(gi.getTlrno());
		newBopAgDs.setBrNo(gi.getBrno());
		newBopAgDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
		newBopAgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_G);
		newBopAgDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
		newBopAgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		newBopAgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		newBopAgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		newBopAgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		newBopAgDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//新增页面信息 
		newBopAgDs.setRptno(bopAgDs.getRptno());
		newBopAgDs.setCountry(bopAgDs.getCountry());
		newBopAgDs.setPaytype(bopAgDs.getPaytype());
		newBopAgDs.setTxcode(bopAgDs.getTxcode());
		newBopAgDs.setTc1amt(bopAgDs.getTc1amt());
		newBopAgDs.setTxrem(bopAgDs.getTxrem());
		newBopAgDs.setTxcode2(bopAgDs.getTxcode2());
		newBopAgDs.setTc2amt(bopAgDs.getTc2amt());
		newBopAgDs.setTx2rem(bopAgDs.getTx2rem());
		newBopAgDs.setIsref(bopAgDs.getIsref());
		newBopAgDs.setPayattr(bopAgDs.getPayattr());
		newBopAgDs.setCrtuser(bopAgDs.getCrtuser());
		newBopAgDs.setInptelc(bopAgDs.getInptelc());
		newBopAgDs.setRptdate(bopAgDs.getRptdate());
		if(StringUtils.isEmpty(bopAgDs.getBillno())){
			newBopAgDs.setBillno("N/A");
		} else {
			newBopAgDs.setBillno(bopAgDs.getBillno());
		}
		newBopAgDs.setFiller1(bopAgDs.getFiller1());
		newBopAgDs.setFiller2(bopAgDs.getFiller2());
		//其中有一步验证需要用到基础信息的收入款金额
		newBopAgDs.setTxamt(bopAgDs.getTxamt());
		ReportDataVaildUtil.executeVaild(newBopAgDs.getApptype(), newBopAgDs.getCurrentfile(), newBopAgDs);
		newBopAgDs.setTxamt(null);
		//数据处理记录表保存
		commonService.saveBiDataProcessLog(newBopAgDs.getApptype(), newBopAgDs.getCurrentfile(), newBopAgDs.getId(), newBopAgDs.getRptno(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

		rootdao.save(newBopAgDs);
		
	}

	private void saveBopGMod(MtsBopAgDs bopAgDs, GlobalInfo gi, ROOTDAO rootdao,
			ReportCommonService commonService) throws CommonException {
		MtsBopAgDs dbBopAgDs = rootdao.query(MtsBopAgDs.class, bopAgDs.getId());
		/**
		 * 校验当前数据是否已经被其他用户更新
		 */
		if(!StringUtils.equals(dbBopAgDs.getRecStatus(), bopAgDs.getRecStatus())){
			ExceptionUtil.throwCommonException("该记录["+bopAgDs.getRptno()+"]已经被其他用户修改");
		}
		dbBopAgDs.setRptno(bopAgDs.getRptno());
		dbBopAgDs.setCountry(bopAgDs.getCountry());
		dbBopAgDs.setPaytype(bopAgDs.getPaytype());
		dbBopAgDs.setTxcode(bopAgDs.getTxcode());
		dbBopAgDs.setTc1amt(bopAgDs.getTc1amt());
		dbBopAgDs.setTxrem(bopAgDs.getTxrem());
		dbBopAgDs.setTxcode2(bopAgDs.getTxcode2());
		dbBopAgDs.setTc2amt(bopAgDs.getTc2amt());
		dbBopAgDs.setTx2rem(bopAgDs.getTx2rem());
		dbBopAgDs.setIsref(bopAgDs.getIsref());
		dbBopAgDs.setPayattr(bopAgDs.getPayattr());
		dbBopAgDs.setCrtuser(bopAgDs.getCrtuser());
		dbBopAgDs.setInptelc(bopAgDs.getInptelc());
		dbBopAgDs.setRptdate(bopAgDs.getRptdate());
		if(StringUtils.isEmpty(bopAgDs.getBillno())){
			dbBopAgDs.setBillno("N/A");
		} else {
			dbBopAgDs.setBillno(bopAgDs.getBillno());
		}
		dbBopAgDs.setLstUpdTlr(gi.getTlrno());
		dbBopAgDs.setFiller2(bopAgDs.getFiller2());
		dbBopAgDs.setLstUpdTm(new Date());
		if (dbBopAgDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
			dbBopAgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		} else {
			dbBopAgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
		}
		dbBopAgDs.setActiondesc(bopAgDs.getActiondesc());
		dbBopAgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbBopAgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbBopAgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		dbBopAgDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
		//其中有一步验证需要用到基础信息的收入款金额
		dbBopAgDs.setTxamt(bopAgDs.getTxamt());
		ReportDataVaildUtil.executeVaild(dbBopAgDs.getApptype(), dbBopAgDs.getCurrentfile(), dbBopAgDs);
		dbBopAgDs.setTxamt(null);
		//数据处理记录表保存
		commonService.saveBiDataProcessLog(dbBopAgDs.getApptype(), dbBopAgDs.getCurrentfile(), dbBopAgDs.getId(), dbBopAgDs.getRptno(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

		rootdao.save(dbBopAgDs);
	}

	private void saveBopGDel(MtsBopAgDs bopAgDs, GlobalInfo gi, ROOTDAO rootdao,
			ReportCommonService commonService) throws CommonException {
		MtsBopAgDs dbBopAgDs = rootdao.query(MtsBopAgDs.class, bopAgDs.getId());
		/**
		 * 校验当前数据是否已经被其他用户更新
		 */
		if(!StringUtils.equals(bopAgDs.getRecStatus(), dbBopAgDs.getRecStatus())){
			ExceptionUtil.throwCommonException("BOP交易["+bopAgDs.getBuscode()+"]已经被其他用户修改");
		}
		dbBopAgDs.setLstUpdTlr(gi.getTlrno());
		dbBopAgDs.setLstUpdTm(new Date());
		dbBopAgDs.setActiondesc(bopAgDs.getActiondesc());
		dbBopAgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		dbBopAgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbBopAgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbBopAgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		dbBopAgDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
		//数据处理记录表保存
		commonService.saveBiDataProcessLog(dbBopAgDs.getApptype(), dbBopAgDs.getCurrentfile(), dbBopAgDs.getId(), dbBopAgDs.getRptno(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopAgDs.getActiondesc());
	}
	
	public void isCanDelete(MtsBopAgDs bopAgDs) throws CommonException {
		String hql = "from MtsBopAgDs model where model.filler1 = '" + bopAgDs.getId() + "'";
		hql += "and model.actiontype <> '"+TopReportConstants.REPORT_ACTIONTYPE_D+"'";
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List list = dao.queryByQL2List(hql);
		if (list != null && list.size() > 0) {
			ExceptionUtil.throwCommonException("该记录已经绑定了基础信息不能删除");
		}
	}
}
