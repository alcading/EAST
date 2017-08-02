package com.huateng.report.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaStrdeDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopCfaStrdeDsService {

	/*
	 * 获得自身实例
	 */
	public synchronized static BopCfaStrdeDsService getInstance() {
		return (BopCfaStrdeDsService) ApplicationContextUtils.getBean(BopCfaStrdeDsService.class.getName());
	}

	/*
	 * 分页查询服务
	 */
	public PageQueryResult pageQueryByHql(int pageIndex,int maxRows,String hql) throws CommonException {
		if(StringUtils.isBlank(hql)) {
			throw new NullPointerException("查询语句为空");
		}
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		PageQueryCondition condition = new PageQueryCondition();
		condition.setPageIndex(pageIndex);
		condition.setPageSize(maxRows);
		condition.setQueryString(hql);
		try {
			return dao.pageQueryByQL(condition);
		} catch (CommonException e) {
			e.printStackTrace();
			ExceptionUtil.throwCommonException("查询异常");
		}
		return null;
	}
	/*
	 * 签约信息add
	 */
	public void bopCfaStrdeAd_add(BopCfaStrdeDs bopCfaStrdeDs) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		//开始插入逻辑
		//数据写入业务表
		String rec_id = ReportUtils.getUUID();
		BopCfaStrdeDs saveBopCfaStrdeDs = new BopCfaStrdeDs();
		//状态变化等信息
		/*
		 * 操作状态=A-创建
		 * 记录状态=02-编辑待确认
		 * 审核状态=00-未审核
		 * 回执状态=00-未返回
		 * 是否已成功上报=0-否
		 */
		saveBopCfaStrdeDs.setId(rec_id);
		saveBopCfaStrdeDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		saveBopCfaStrdeDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		saveBopCfaStrdeDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		saveBopCfaStrdeDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		saveBopCfaStrdeDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//业务字段
		saveBopCfaStrdeDs.setStrdecode(bopCfaStrdeDs.getStrdecode());
		saveBopCfaStrdeDs.setBranchcode(bopCfaStrdeDs.getBranchcode());
		saveBopCfaStrdeDs.setClientcode(bopCfaStrdeDs.getClientcode());
		saveBopCfaStrdeDs.setClientname(bopCfaStrdeDs.getClientname());
		saveBopCfaStrdeDs.setContractdate(bopCfaStrdeDs.getContractdate());
		saveBopCfaStrdeDs.setContract(bopCfaStrdeDs.getContract());
		saveBopCfaStrdeDs.setContractamount(bopCfaStrdeDs.getContractamount());
		saveBopCfaStrdeDs.setMaturity(bopCfaStrdeDs.getMaturity());
		saveBopCfaStrdeDs.setLincame(bopCfaStrdeDs.getLincame());
		saveBopCfaStrdeDs.setLincamethod(bopCfaStrdeDs.getLincamethod());
		saveBopCfaStrdeDs.setAginraup(bopCfaStrdeDs.getAginraup());
		saveBopCfaStrdeDs.setAginralo(bopCfaStrdeDs.getAginralo());
		saveBopCfaStrdeDs.setAginraloinpay(bopCfaStrdeDs.getAginraloinpay());
		//业务流水号
		saveBopCfaStrdeDs.setFiller2(bopCfaStrdeDs.getFiller2());
		saveBopCfaStrdeDs.setRemark(bopCfaStrdeDs.getRemark());
		//必输项
		saveBopCfaStrdeDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
		saveBopCfaStrdeDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_FA);
		//其他字段
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		saveBopCfaStrdeDs.setLstUpdTlr(globalInfo.getTlrno());
		saveBopCfaStrdeDs.setLstUpdTm(globalInfo.getTxtime());
		saveBopCfaStrdeDs.setCrtTm(globalInfo.getTxtime());
		//机构号
		saveBopCfaStrdeDs.setBrNo(globalInfo.getBrno());
		saveBopCfaStrdeDs.setBranchcode(globalInfo.getBrno());
		//默认工作日期当天
		saveBopCfaStrdeDs.setWorkDate(DateUtil.dateToNumber(GlobalInfo.getCurrentInstanceWithoutException().getTxdate()));
		//默认未上报
		saveBopCfaStrdeDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

		/*
		 * 保存前后台验证 add
		 */
		ReportDataVaildUtil.executeVaild(saveBopCfaStrdeDs.getApptype(), saveBopCfaStrdeDs.getCurrentfile(), saveBopCfaStrdeDs);

		rootDAO.save(saveBopCfaStrdeDs);
		//数据处理记录表(业务编号存的是strdecode,人民币结构性存款编号)
		String appType = TopReportConstants.REPORT_APP_TYPE_CFA;
		String currentFile = TopReportConstants.REPORT_FILE_TYPE_CFA_FA;
		String recId = rec_id;
		String busiNo = bopCfaStrdeDs.getStrdecode();
		String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT;
		String execResult = "新增";
		String execRemark = "签约信息新增";

		ReportCommonService.getInstance().saveBiDataProcessLog(appType, currentFile, recId, busiNo, execType, execResult, execRemark);

		//完成插入逻辑
	}
	/*
	 * 签约信息mod
	 */
	public void bopCfaStrdeAd_mod(BopCfaStrdeDs bopCfaStrdeDs) throws CommonException {
		BopCfaStrdeDs modBopCfaStrdeDs = ROOTDAOUtils.getROOTDAO().query(BopCfaStrdeDs.class, bopCfaStrdeDs.getId());
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//修改逻辑开始
		//第一步判断记录状态是否为01-可编辑或者02编辑待确认
		String recStatus = getRecStatuById(bopCfaStrdeDs.getId());
		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStatus) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStatus)) {
			//不是01或者02不能删除
			ExceptionUtil.throwCommonException("该数据记录状态不是可编辑或者编辑待确认，无法修改");
		}
		//第二步根据是否已成功上报判断操作状态,记录相应的状态
		String subSuccess = modBopCfaStrdeDs.getSubSuccess();
		//记录系统信息
		String rActiontype = null;
		String rRecStatus = null;
		String rApproveStatus = null;
		String rRepStatus = null;
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
		modBopCfaStrdeDs.setActiontype(rActiontype);
		modBopCfaStrdeDs.setRecStatus(rRecStatus);
		modBopCfaStrdeDs.setApproveStatus(rApproveStatus);
		modBopCfaStrdeDs.setRepStatus(rRepStatus);
		//记录其他信息
		modBopCfaStrdeDs.setStrdecode(bopCfaStrdeDs.getStrdecode());
		modBopCfaStrdeDs.setBranchcode(bopCfaStrdeDs.getBranchcode());
		modBopCfaStrdeDs.setClientcode(bopCfaStrdeDs.getClientcode());
		modBopCfaStrdeDs.setClientname(bopCfaStrdeDs.getClientname());
		modBopCfaStrdeDs.setContractdate(bopCfaStrdeDs.getContractdate());
		modBopCfaStrdeDs.setContract(bopCfaStrdeDs.getContract());
		modBopCfaStrdeDs.setContractamount(bopCfaStrdeDs.getContractamount());
		modBopCfaStrdeDs.setMaturity(bopCfaStrdeDs.getMaturity());
		modBopCfaStrdeDs.setLincame(bopCfaStrdeDs.getLincame());
		modBopCfaStrdeDs.setLincamethod(bopCfaStrdeDs.getLincamethod());
		modBopCfaStrdeDs.setAginraup(bopCfaStrdeDs.getAginraup());
		modBopCfaStrdeDs.setAginralo(bopCfaStrdeDs.getAginralo());
		modBopCfaStrdeDs.setAginraloinpay(bopCfaStrdeDs.getAginraloinpay());
		modBopCfaStrdeDs.setActiondesc(bopCfaStrdeDs.getActiondesc());
		//业务流水号
		modBopCfaStrdeDs.setFiller2(bopCfaStrdeDs.getFiller2());
		modBopCfaStrdeDs.setRemark(bopCfaStrdeDs.getRemark());
		modBopCfaStrdeDs.setLstUpdTlr(globalInfo.getTlrno());
		modBopCfaStrdeDs.setLstUpdTm(new Date());
		//workdate一起更新
		modBopCfaStrdeDs.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		/*
		 * 保存前后台验证 mod
		 */
		ReportDataVaildUtil.executeVaild(modBopCfaStrdeDs.getApptype(), modBopCfaStrdeDs.getCurrentfile(), modBopCfaStrdeDs);

		//记录到业务表
		ROOTDAOUtils.getROOTDAO().update(modBopCfaStrdeDs);
		//记录数据到数据处理记录表
		String appType = TopReportConstants.REPORT_APP_TYPE_CFA;
		String currentFile = TopReportConstants.REPORT_FILE_TYPE_CFA_FA;
		String recId = bopCfaStrdeDs.getId();
		String busiNo = bopCfaStrdeDs.getStrdecode();
		String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT;
		String execResult = "修改";
		String execRemark = "签约信息修改";
		ReportCommonService.getInstance().saveBiDataProcessLog(appType, currentFile, recId, busiNo, execType, execResult, execRemark);
	}
	/*
	 * 签约信息del
	 */
	public void bopCfaStrdeAd_del(BopCfaStrdeDs bopCfaStrdeDs) throws CommonException {
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//删除逻辑开始
		//第一步判断记录状态是否为01-可编辑或者02编辑待确认
		String recStatus = getRecStatuById(bopCfaStrdeDs.getId());
		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStatus) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStatus)) {
			//不是01或者02不能删除
			ExceptionUtil.throwCommonException("该数据记录状态不是可编辑或者编辑待确认，无法删除");
		}
		//第二步判断业务是否能删除
		boolean flag1 = delBopCfaStrdeAdAvailable(bopCfaStrdeDs.getId());
		if(flag1 == false) {
			//提示不能删除
			ExceptionUtil.throwCommonException("该数据存在终止信息或利息给付信息或资金流出入和结购汇信息，不能删除");
		}
		//第三步可以删除了，以下是删除操作的业务逻辑（删除原因也要记录）
		BopCfaStrdeDs delBopCfaStrdeDs = ROOTDAOUtils.getROOTDAO().query(BopCfaStrdeDs.class, bopCfaStrdeDs.getId());
		//记录系统信息
		/*
		 * 操作状态=D-删除
		 * 记录状态=02-编辑待确认
		 * 审核状态=00-未审核
		 * 回执状态=00-未返回
		 * 是否已成功上报=不变化
		 */
		delBopCfaStrdeDs.setId(bopCfaStrdeDs.getId());
		delBopCfaStrdeDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		delBopCfaStrdeDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		delBopCfaStrdeDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		delBopCfaStrdeDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		//其他字段
		delBopCfaStrdeDs.setLstUpdTlr(globalInfo.getTlrno());
		delBopCfaStrdeDs.setLstUpdTm(new Date());
		//更新workdate
		delBopCfaStrdeDs.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		//删除原因
		delBopCfaStrdeDs.setActiondesc(bopCfaStrdeDs.getActiondesc());

		ROOTDAOUtils.getROOTDAO().update(delBopCfaStrdeDs);
		//记录数据到数据处理记录表
		String appType = TopReportConstants.REPORT_APP_TYPE_CFA;
		String currentFile = TopReportConstants.REPORT_FILE_TYPE_CFA_FA;
		String recId = bopCfaStrdeDs.getId();
		String busiNo = bopCfaStrdeDs.getStrdecode();
		String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL;
		String execResult = "删除";
		String execRemark = "签约信息删除";
		ReportCommonService.getInstance().saveBiDataProcessLog(appType, currentFile, recId, busiNo, execType, execResult, execRemark);
		//删除逻辑完成

	}

	//判断签约信息是否能删除，业务逻辑为：对应rec_id的数据如果有终止信息，利息给付信息，	资金流出入和结构汇信息，则不能删除
	public boolean delBopCfaStrdeAdAvailable(String id) throws CommonException {
		if(StringUtils.isBlank(id)) {
			throw new NullPointerException();
		}
		//查看应用类型是cfa，文件类型不是FA-商业银行人民币结构性存款—签约信息的所有信息，如果他们的filler1有和id相等的数据，则不能删除
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hqlBuff = new StringBuffer();
		hqlBuff.append(" SELECT count(*) FROM BopCfaStrdeDs ds WHERE 1 = 1 ");
		hqlBuff.append(" AND ds.apptype = '"+TopReportConstants.REPORT_APP_TYPE_CFA+"' ");
		hqlBuff.append(" AND ds.currentfile != '"+TopReportConstants.REPORT_FILE_TYPE_CFA_FA+"' ");
		hqlBuff.append(" AND ds.recStatus !='"+TopReportConstants.REPORT_RECSTATUS_07+"' ");
		hqlBuff.append(" AND ds.filler1 = '"+id+"' ");
		try {
			int count = dao.queryByHqlToCount(hqlBuff.toString());
			return count == 0 ? true : false;
		} catch (CommonException e) {
			e.printStackTrace();
			ExceptionUtil.throwCommonException("未知错误");
		}
		return false;
	}

	/*
	 * 获得记录状态
	 */
	public String getRecStatuById(String id) throws CommonException {
		BopCfaStrdeDs bopCfaStrdeDs = queryByIdReturnBean(id);
		if(bopCfaStrdeDs == null) {
			return null;
		} else {
			return bopCfaStrdeDs.getRecStatus();
		}
	}

	/*
	 * id查记录
	 */
	public BopCfaStrdeDs queryByIdReturnBean(String id) throws CommonException {
		if(StringUtils.isBlank(id)) {
			return null;
		}
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		return dao.query(BopCfaStrdeDs.class, id);
	}
	/*
	 * 终止信息add
	 */
	public void bopCfaStrdeTerminate_add(BopCfaStrdeDs bopCfaStrdeDs) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//		String filler1 = bopCfaStrdeDs.getFiller1();
		//终止支付金额合计折人民币值，等于终止人民币支付金额+终止外币支付金额折人民币。
//		BigDecimal terpayamtormb = bopCfaStrdeDs.getTerpayamtormb();
//		BigDecimal terrmbpayam = bopCfaStrdeDs.getTerrmbpayam();
//		String terpaycurr = bopCfaStrdeDs.getTerpaycurr();
//		BigDecimal terpaycurram = bopCfaStrdeDs.getTerpaycurram();
		//终止信息是否只有一个等待确认
		String uuid = ReportUtils.getUUID();
		bopCfaStrdeDs.setId(uuid);
		bopCfaStrdeDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
		bopCfaStrdeDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_FB);
		//系统信息记录
		bopCfaStrdeDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		bopCfaStrdeDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopCfaStrdeDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopCfaStrdeDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		bopCfaStrdeDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//其他字段
		bopCfaStrdeDs.setLstUpdTlr(globalInfo.getTlrno());
		bopCfaStrdeDs.setLstUpdTm(new Date());
		bopCfaStrdeDs.setCrtTm(new Date());
		//workdate
		bopCfaStrdeDs.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		//机构号
		bopCfaStrdeDs.setBrNo(globalInfo.getBrno());
		bopCfaStrdeDs.setBranchcode(globalInfo.getBrno());
		/*
		 * 保存前后台验证 add
		 */
		ReportDataVaildUtil.executeVaild(bopCfaStrdeDs.getApptype(), bopCfaStrdeDs.getCurrentfile(), bopCfaStrdeDs);

		rootDAO.save(bopCfaStrdeDs);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FB, uuid,
				bopCfaStrdeDs.getStrdecode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "终止信息新增");

	}
	/*
	 * 终止信息修改mod
	 */
	public void bopCfaStrdeTerminate_mod(BopCfaStrdeDs bopCfaStrdeDsTerminate) throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//记录系统信息
//		//add 判断是否补录确认了，如果补录确认了，不给修改
//		BopCfaStrdeDs ds = dao.query(BopCfaStrdeDs.class, bopCfaStrdeDsTerminate.getId());
//		String recStat = ds.getRecStatus();
//		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStat) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStat)) {
//			//不是01或者02不能修改
//			ExceptionUtil.throwCommonException("该数据记录状态不是可编辑或者编辑待确认，无法修改");
//		}
		//根据是否上报成功填写系统信息
		String isSubSuccess = bopCfaStrdeDsTerminate.getSubSuccess();
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
		bopCfaStrdeDsTerminate.setActiontype(actiontype);
		bopCfaStrdeDsTerminate.setRecStatus(recStatus);
		bopCfaStrdeDsTerminate.setApproveStatus(approveStatus);
		bopCfaStrdeDsTerminate.setRepStatus(repStatus);
		//其他字段
		bopCfaStrdeDsTerminate.setLstUpdTlr(globalInfo.getTlrno());
		bopCfaStrdeDsTerminate.setLstUpdTm(new Date());
		//workdate
		bopCfaStrdeDsTerminate.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		/*
		 * 保存前后台验证 mod
		 */
		ReportDataVaildUtil.executeVaild(bopCfaStrdeDsTerminate.getApptype(), bopCfaStrdeDsTerminate.getCurrentfile(), bopCfaStrdeDsTerminate);

		dao.update(bopCfaStrdeDsTerminate);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FB, bopCfaStrdeDsTerminate.getId(),
				bopCfaStrdeDsTerminate.getStrdecode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "终止信息修改");
	}
	/*
	 * 终止信息删除del
	 */
	public void bopCfaStrdeTerminate_del(BopCfaStrdeDs bopCfaStrdeDsTerminate) throws CommonException {
		//删除逻辑
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//		//add 判断是否补录确认了，如果补录确认了，不给修改
//		BopCfaStrdeDs ds = dao.query(BopCfaStrdeDs.class, bopCfaStrdeDsTerminate.getId());
//		String recStat = ds.getRecStatus();
//		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStat) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStat)) {
//			//不是01或者02不能删除
//			ExceptionUtil.throwCommonException("该数据记录状态不是可编辑或者编辑待确认，无法删除");
//		}
		//记录系统信息
		bopCfaStrdeDsTerminate.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		bopCfaStrdeDsTerminate.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopCfaStrdeDsTerminate.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopCfaStrdeDsTerminate.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		//上报状态未变化 忽略
		//其他字段
		bopCfaStrdeDsTerminate.setLstUpdTlr(globalInfo.getTlrno());
		bopCfaStrdeDsTerminate.setLstUpdTm(new Date());
		//workdate
		bopCfaStrdeDsTerminate.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		dao.update(bopCfaStrdeDsTerminate);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FB, bopCfaStrdeDsTerminate.getId(),
				bopCfaStrdeDsTerminate.getStrdecode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", "终止信息删除");
	}
	/*
	 * 利息给付信息add
	 */
	public void bopCfaStrdeInpay_add(BopCfaStrdeDs bopCfaStrdeDs) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String uuid = ReportUtils.getUUID();
		bopCfaStrdeDs.setId(uuid);
		bopCfaStrdeDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
		bopCfaStrdeDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_FC);
		//其他字段
		bopCfaStrdeDs.setCrtTm(new Date());
		bopCfaStrdeDs.setLstUpdTlr(globalInfo.getTlrno());
		bopCfaStrdeDs.setLstUpdTm(new Date());
		bopCfaStrdeDs.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		//系统信息记录
		bopCfaStrdeDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		bopCfaStrdeDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopCfaStrdeDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopCfaStrdeDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		bopCfaStrdeDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//机构号
		bopCfaStrdeDs.setBrNo(globalInfo.getBrno());
		bopCfaStrdeDs.setBranchcode(globalInfo.getBrno());
		/*
		 * 保存前后台验证 add
		 */
		ReportDataVaildUtil.executeVaild(bopCfaStrdeDs.getApptype(), bopCfaStrdeDs.getCurrentfile(), bopCfaStrdeDs);

		dao.save(bopCfaStrdeDs);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FC, uuid,
				bopCfaStrdeDs.getStrdecode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "利息给付信息新增");
	}
	/*
	 * 利息给付信息mod
	 */
	public void bopCfaStrdeInpay_mod(BopCfaStrdeDs bopCfaStrdeDsInpay) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//		//add 判断是否补录确认了，如果补录确认了，不给修改
//		BopCfaStrdeDs ds = dao.query(BopCfaStrdeDs.class, bopCfaStrdeDsInpay.getId());
//		String recStat = ds.getRecStatus();
//		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStat) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStat)) {
//			//不是01或者02不能修改
//			ExceptionUtil.throwCommonException("该数据记录状态不是可编辑或者编辑待确认，无法修改");
//		}
		//记录系统信息
		//根据是否上报成功填写系统信息
		String isSubSuccess = bopCfaStrdeDsInpay.getSubSuccess();
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
		bopCfaStrdeDsInpay.setActiontype(actiontype);
		bopCfaStrdeDsInpay.setRecStatus(recStatus);
		bopCfaStrdeDsInpay.setApproveStatus(approveStatus);
		bopCfaStrdeDsInpay.setRepStatus(repStatus);
		//一些其他信息lstUpdTm
		bopCfaStrdeDsInpay.setLstUpdTm(new Date());
		bopCfaStrdeDsInpay.setLstUpdTlr(globalInfo.getTlrno());
		//workdate
		bopCfaStrdeDsInpay.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		/*
		 * 保存前后台验证 add
		 */
		ReportDataVaildUtil.executeVaild(bopCfaStrdeDsInpay.getApptype(), bopCfaStrdeDsInpay.getCurrentfile(), bopCfaStrdeDsInpay);

		dao.update(bopCfaStrdeDsInpay);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FC, bopCfaStrdeDsInpay.getId(),
				bopCfaStrdeDsInpay.getStrdecode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "利息给付信息修改");

	}
	/*
	 * 利息给付信息del
	 */
	public void bopCfaStrdeInpay_del(BopCfaStrdeDs bopCfaStrdeDsInpay) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//		//add 判断是否补录确认了，如果补录确认了，不给删除
//		BopCfaStrdeDs ds = dao.query(BopCfaStrdeDs.class, bopCfaStrdeDsInpay.getId());
//		String recStat = ds.getRecStatus();
//		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStat) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStat)) {
//			//不是01或者02不能删除
//			ExceptionUtil.throwCommonException("该数据记录状态不是可编辑或者编辑待确认，无法删除");
//		}
		//记录系统信息
		bopCfaStrdeDsInpay.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		bopCfaStrdeDsInpay.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopCfaStrdeDsInpay.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopCfaStrdeDsInpay.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		//其他字段
		bopCfaStrdeDsInpay.setLstUpdTlr(globalInfo.getTlrno());
		bopCfaStrdeDsInpay.setLstUpdTm(new Date());
		//workdate
		bopCfaStrdeDsInpay.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		dao.update(bopCfaStrdeDsInpay);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FC, bopCfaStrdeDsInpay.getId(),
				bopCfaStrdeDsInpay.getStrdecode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除" , "利息给付信息删除");
	}
	/*
	 * 资金流出入和结购汇信息新增add
	 */
	public void bopCfaStrdeInoutMo_add(BopCfaStrdeDs bopCfaStrdeDs) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		String uuid = ReportUtils.getUUID();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//主键等
		bopCfaStrdeDs.setId(uuid);
		bopCfaStrdeDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
		bopCfaStrdeDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_FD);
		//记录系统信息
		bopCfaStrdeDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		bopCfaStrdeDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopCfaStrdeDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopCfaStrdeDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		bopCfaStrdeDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//其他字段
		bopCfaStrdeDs.setCrtTm(new Date());
		bopCfaStrdeDs.setLstUpdTlr(globalInfo.getTlrno());
		bopCfaStrdeDs.setLstUpdTm(new Date());
		bopCfaStrdeDs.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		//机构号
		bopCfaStrdeDs.setBrNo(globalInfo.getBrno());
		bopCfaStrdeDs.setBranchcode(globalInfo.getBrno());
		/*
		 * 保存前后台验证 add
		 */
		ReportDataVaildUtil.executeVaild(bopCfaStrdeDs.getApptype(), bopCfaStrdeDs.getCurrentfile(), bopCfaStrdeDs);

		dao.save(bopCfaStrdeDs);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FD, uuid,
				null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "资金流出入和结购汇信息新增");
	}
	/*
	 * 资金流出入和结购汇信息修改mod
	 */
	public void bopCfaStrdeInoutMo_mod(BopCfaStrdeDs bopCfaStrdeDs) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//		//add 判断是否补录确认了，如果补录确认了，不给修改
//		BopCfaStrdeDs ds = dao.query(BopCfaStrdeDs.class, bopCfaStrdeDs.getId());
//		String recStat = ds.getRecStatus();
//		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStat) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStat)) {
//			//不是01或者02不能修改
//			ExceptionUtil.throwCommonException("该数据记录状态不是可编辑或者编辑待确认，无法修改");
//		}
		//记录系统信息
		bopCfaStrdeDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
		bopCfaStrdeDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		//根据是否上报成功填写系统信息
		String isSubSuccess = bopCfaStrdeDs.getSubSuccess();
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
		bopCfaStrdeDs.setActiontype(actiontype);
		bopCfaStrdeDs.setRecStatus(recStatus);
		bopCfaStrdeDs.setApproveStatus(approveStatus);
		bopCfaStrdeDs.setRepStatus(repStatus);
		//一些其他信息lstUpdTm
		bopCfaStrdeDs.setLstUpdTlr(globalInfo.getTlrno());
		bopCfaStrdeDs.setLstUpdTm(new Date());
		//workDate
		bopCfaStrdeDs.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		/*
		 * 保存前后台验证 add
		 */
		ReportDataVaildUtil.executeVaild(bopCfaStrdeDs.getApptype(), bopCfaStrdeDs.getCurrentfile(), bopCfaStrdeDs);

		dao.update(bopCfaStrdeDs);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FD, bopCfaStrdeDs.getId(),
				null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "资金流出入和结购汇信息修改");
	}
	/*
	 * 资金流出入和结购汇信息删除del
	 */
	public void bopCfaStrdeInoutMo_del(BopCfaStrdeDs bopCfaStrdeDs) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//		//add 判断是否补录确认了，如果补录确认了，不给修改
//		BopCfaStrdeDs ds = dao.query(BopCfaStrdeDs.class, bopCfaStrdeDs.getId());
//		String recStat = ds.getRecStatus();
//		if(!TopReportConstants.REPORT_RECSTATUS_01.equals(recStat) && !TopReportConstants.REPORT_RECSTATUS_02.equals(recStat)) {
//			//不是01或者02不能删除
//			ExceptionUtil.throwCommonException("该数据记录状态不是可编辑或者编辑待确认，无法删除");
//		}
		//系统状态信息
		bopCfaStrdeDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		bopCfaStrdeDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopCfaStrdeDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopCfaStrdeDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		//一些其他信息
		bopCfaStrdeDs.setLstUpdTlr(globalInfo.getTlrno());
		bopCfaStrdeDs.setLstUpdTm(new Date());
		//workDate
		bopCfaStrdeDs.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		dao.update(bopCfaStrdeDs);
		//记录到数据处理记录表
		ReportCommonService.getInstance().saveBiDataProcessLog(TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_FD, bopCfaStrdeDs.getId(),
				null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", "资金流出入和结购汇信息删除");
	}
}