package com.huateng.report.bop.collection.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import resource.bean.report.MtsBopEqDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bop.collection.operation.BopEqDsOperation;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopEqDsUpdateService {
	
	protected static final Logger logger = Logger.getLogger(BopEqDsUpdateService.class);

	protected BopEqDsUpdateService() {
		
	}

	public synchronized static BopEqDsUpdateService getInstance() {
		return (BopEqDsUpdateService) ApplicationContextUtils.getBean(BopEqDsUpdateService.class.getName());
	}

	public void saveBopEqDs(MtsBopEqDs bopEqDs, String type) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if (BopEqDsOperation.OP_E_NEW.equals(type)){
			saveBOPENew(bopEqDs, gi, rootdao, commonService);
		} else if (BopEqDsOperation.OP_E_MOD.equals(type)) {
			saveBOPEMod(bopEqDs, gi, rootdao, commonService);
		} else if (BopEqDsOperation.OP_E_DEL.equals(type)) {
			saveBOPEDel(bopEqDs, gi, rootdao, commonService);
		} else if (BopEqDsOperation.OP_Q_NEW.equals(type)){
			saveBOPQNew(bopEqDs, gi, rootdao, commonService);
		} else if (BopEqDsOperation.OP_Q_MOD.equals(type)) {
			saveBOPQMod(bopEqDs, gi, rootdao, commonService);
		} else if (BopEqDsOperation.OP_Q_DEL.equals(type)) {
			saveBOPQDel(bopEqDs, gi, rootdao, commonService);
		}
	}
	
	private void saveBOPENew(MtsBopEqDs bopEqDs, GlobalInfo gi,
			ROOTDAO rootdao, ReportCommonService commonService) throws CommonException {
		bopEqDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		bopEqDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopEqDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopEqDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		bopEqDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		// 生成申报号码
		String rptno = ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_BOP_E);
		bopEqDs.setRptno(rptno);
		bopEqDs.setCrtTm(new Date());
		bopEqDs.setLstUpdTm(new Date());
		bopEqDs.setLstUpdTlr(gi.getTlrno());
		bopEqDs.setBrNo(gi.getBrno());
		bopEqDs.setId(ReportUtils.getUUID());
		bopEqDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
		bopEqDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_E);
		bopEqDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

		ReportDataVaildUtil.executeVaild(bopEqDs.getApptype(), bopEqDs.getCurrentfile(), bopEqDs);

		//数据处理记录表保存
		commonService.saveBiDataProcessLog(bopEqDs.getApptype(), bopEqDs.getCurrentfile(), bopEqDs.getId(), bopEqDs.getBuscode(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

		rootdao.save(bopEqDs);
	}
	
	private void saveBOPEMod(MtsBopEqDs bopEqDs, GlobalInfo gi,
			ROOTDAO rootdao, ReportCommonService commonService) throws CommonException {
		MtsBopEqDs dbBopEqDs = rootdao.query(MtsBopEqDs.class, bopEqDs.getId());

		if(!StringUtils.equals(bopEqDs.getRecStatus(), dbBopEqDs.getRecStatus())){
			ExceptionUtil.throwCommonException("BOP交易["+dbBopEqDs.getBuscode()+"]已经被其他用户修改");
		}

		dbBopEqDs.setRptno(bopEqDs.getRptno());
		dbBopEqDs.setCustype(bopEqDs.getCustype());
		dbBopEqDs.setIdcode(bopEqDs.getIdcode());
		dbBopEqDs.setCustcod(bopEqDs.getCustcod());
		dbBopEqDs.setCustnm(bopEqDs.getCustnm());
		dbBopEqDs.setOppuser(bopEqDs.getOppuser());
		dbBopEqDs.setOppacc(bopEqDs.getOppacc());
		dbBopEqDs.setTxccy(bopEqDs.getTxccy());
		dbBopEqDs.setTxamt(bopEqDs.getTxamt());
		dbBopEqDs.setExrate(bopEqDs.getExrate());
		dbBopEqDs.setLcyamt(bopEqDs.getLcyamt());
		dbBopEqDs.setLcyacc(bopEqDs.getLcyacc());
		dbBopEqDs.setFcyamt(bopEqDs.getFcyamt());
		dbBopEqDs.setFcyacc(bopEqDs.getFcyacc());
		dbBopEqDs.setOthamt(bopEqDs.getOthamt());
		dbBopEqDs.setOthacc(bopEqDs.getOthacc());
		dbBopEqDs.setMethod(bopEqDs.getMethod());
		dbBopEqDs.setBuscode(bopEqDs.getBuscode());
		dbBopEqDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
		dbBopEqDs.setLstUpdTlr(gi.getTlrno());
		dbBopEqDs.setLstUpdTm(new Date());
		if (dbBopEqDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
			dbBopEqDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		} else {
			dbBopEqDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
		}
		dbBopEqDs.setActiondesc(bopEqDs.getActiondesc());
		dbBopEqDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbBopEqDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbBopEqDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

		ReportDataVaildUtil.executeVaild(dbBopEqDs.getApptype(), dbBopEqDs.getCurrentfile(), dbBopEqDs);
		
		//数据处理记录表保存
		commonService.saveBiDataProcessLog(dbBopEqDs.getApptype(), dbBopEqDs.getCurrentfile(), dbBopEqDs.getId(), dbBopEqDs.getRptno(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

		rootdao.saveOrUpdate(dbBopEqDs);
	}
	
	private void saveBOPEDel(MtsBopEqDs bopEqDs, GlobalInfo gi,
			ROOTDAO rootdao, ReportCommonService commonService) throws CommonException {
		MtsBopEqDs dbBopEqDs = rootdao.query(MtsBopEqDs.class, bopEqDs.getId());
		
		if(!StringUtils.equals(bopEqDs.getRecStatus(), dbBopEqDs.getRecStatus())){
			ExceptionUtil.throwCommonException("该记录["+bopEqDs.getRptno()+"]已经被其他用户修改");
		}
		
		/**
		 * 根据账户信息的ID 查询相应管理信息
		 */
		Integer count = rootdao.queryByHqlToCount(" SELECT count(model) FROM MtsBopEqDs model WHERE model.filler1 = '" + bopEqDs.getId() + "' ");
		if (count > 0){
			ExceptionUtil.throwCommonException("已存在相关的管理信息不能删除！");
		}
		dbBopEqDs.setLstUpdTlr(gi.getTlrno());
		dbBopEqDs.setLstUpdTm(new Date());
		dbBopEqDs.setActiondesc(bopEqDs.getActiondesc());
		dbBopEqDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		dbBopEqDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbBopEqDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbBopEqDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		dbBopEqDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

		//数据处理记录表保存
		commonService.saveBiDataProcessLog(dbBopEqDs.getApptype(), dbBopEqDs.getCurrentfile(), dbBopEqDs.getId(), dbBopEqDs.getBuscode(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopEqDs.getActiondesc());

		rootdao.saveOrUpdate(dbBopEqDs);
	}
	
	private void saveBOPQNew(MtsBopEqDs bopEqDs, GlobalInfo gi,
			ROOTDAO rootdao, ReportCommonService commonService) throws CommonException {
		MtsBopEqDs newBopEqDs = new MtsBopEqDs();
		//新增基本信息
		newBopEqDs.setId(ReportUtils.getUUID());
		newBopEqDs.setCrtTm(new Date());
		newBopEqDs.setLstUpdTm(new Date());
		newBopEqDs.setLstUpdTlr(gi.getTlrno());
		newBopEqDs.setBrNo(gi.getBrno());
		newBopEqDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
		newBopEqDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_Q);
		newBopEqDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
		newBopEqDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		newBopEqDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		newBopEqDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		newBopEqDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		newBopEqDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		//新增页面管理信息
		newBopEqDs.setRptno(bopEqDs.getRptno());
		newBopEqDs.setCountry(bopEqDs.getCountry());
		newBopEqDs.setIsref(bopEqDs.getIsref());
		newBopEqDs.setPaytype(bopEqDs.getPaytype());
		newBopEqDs.setPayattr(bopEqDs.getPayattr());
		newBopEqDs.setTxcode(bopEqDs.getTxcode());
		newBopEqDs.setTc1amt(bopEqDs.getTc1amt());
		newBopEqDs.setTxcode2(bopEqDs.getTxcode2());
		newBopEqDs.setTc2amt(bopEqDs.getTc2amt());
		newBopEqDs.setContrno(bopEqDs.getContrno());
		newBopEqDs.setInvoino(bopEqDs.getInvoino());
		newBopEqDs.setRegno(bopEqDs.getRegno());
		newBopEqDs.setCrtuser(bopEqDs.getCrtuser());
		newBopEqDs.setInptelc(bopEqDs.getInptelc());
		newBopEqDs.setRptdate(bopEqDs.getRptdate());
		newBopEqDs.setFiller1(bopEqDs.getFiller1());
		newBopEqDs.setFiller2(bopEqDs.getFiller2());
		// 设置基础信息的值
		newBopEqDs.setRptno(bopEqDs.getRptno());
		newBopEqDs.setCustype(bopEqDs.getCustype());
		newBopEqDs.setIdcode(bopEqDs.getIdcode());
		newBopEqDs.setCustcod(bopEqDs.getCustcod());
		newBopEqDs.setCustnm(bopEqDs.getCustnm());
		newBopEqDs.setOppuser(bopEqDs.getOppuser());
		newBopEqDs.setOppacc(bopEqDs.getOppacc());
		newBopEqDs.setTxccy(bopEqDs.getTxccy());
		newBopEqDs.setTxamt(bopEqDs.getTxamt());
		newBopEqDs.setExrate(bopEqDs.getExrate());
		newBopEqDs.setLcyamt(bopEqDs.getLcyamt());
		newBopEqDs.setLcyacc(bopEqDs.getLcyacc());
		newBopEqDs.setFcyamt(bopEqDs.getFcyamt());
		newBopEqDs.setFcyacc(bopEqDs.getFcyacc());
		newBopEqDs.setOthamt(bopEqDs.getOthamt());
		newBopEqDs.setOthacc(bopEqDs.getOthacc());
		newBopEqDs.setMethod(bopEqDs.getMethod());
		newBopEqDs.setBuscode(bopEqDs.getBuscode());
		ReportDataVaildUtil.executeVaild(newBopEqDs.getApptype(), newBopEqDs.getCurrentfile(), newBopEqDs);
		//数据处理记录表保存
		commonService.saveBiDataProcessLog(newBopEqDs.getApptype(), newBopEqDs.getCurrentfile(), newBopEqDs.getId(),
				newBopEqDs.getBuscode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

		rootdao.save(newBopEqDs);
	}
	
	private void saveBOPQMod(MtsBopEqDs bopEqDs, GlobalInfo gi,
			ROOTDAO rootdao, ReportCommonService commonService) throws CommonException {
		MtsBopEqDs dbBopEqDs = rootdao.query(MtsBopEqDs.class, bopEqDs.getId());
		/**
		 * 校验当前数据是否已经被其他用户更新
		 */
		if(!StringUtils.equals(dbBopEqDs.getRecStatus(), bopEqDs.getRecStatus())){
			ExceptionUtil.throwCommonException("该记录["+bopEqDs.getRptno()+"]已经被其他用户修改");
		}

		dbBopEqDs.setRptno(bopEqDs.getRptno());
		dbBopEqDs.setCountry(bopEqDs.getCountry());
		dbBopEqDs.setIsref(bopEqDs.getIsref());
		dbBopEqDs.setPaytype(bopEqDs.getPaytype());
		dbBopEqDs.setPayattr(bopEqDs.getPayattr());
		dbBopEqDs.setTxcode(bopEqDs.getTxcode());
		dbBopEqDs.setTc1amt(bopEqDs.getTc1amt());
		dbBopEqDs.setTxcode2(bopEqDs.getTxcode2());
		dbBopEqDs.setTc2amt(bopEqDs.getTc2amt());
		dbBopEqDs.setContrno(bopEqDs.getContrno());
		dbBopEqDs.setInvoino(bopEqDs.getInvoino());
		dbBopEqDs.setRegno(bopEqDs.getRegno());
		dbBopEqDs.setCrtuser(bopEqDs.getCrtuser());
		dbBopEqDs.setInptelc(bopEqDs.getInptelc());
		dbBopEqDs.setRptdate(bopEqDs.getRptdate());
		dbBopEqDs.setFiller1(bopEqDs.getFiller1());
		dbBopEqDs.setFiller2(bopEqDs.getFiller2());
		// 设置基础信息的值
		dbBopEqDs.setRptno(bopEqDs.getRptno());
		dbBopEqDs.setCustype(bopEqDs.getCustype());
		dbBopEqDs.setIdcode(bopEqDs.getIdcode());
		dbBopEqDs.setCustcod(bopEqDs.getCustcod());
		dbBopEqDs.setCustnm(bopEqDs.getCustnm());
		dbBopEqDs.setOppuser(bopEqDs.getOppuser());
		dbBopEqDs.setOppacc(bopEqDs.getOppacc());
		dbBopEqDs.setTxccy(bopEqDs.getTxccy());
		dbBopEqDs.setTxamt(bopEqDs.getTxamt());
		dbBopEqDs.setExrate(bopEqDs.getExrate());
		dbBopEqDs.setLcyamt(bopEqDs.getLcyamt());
		dbBopEqDs.setLcyacc(bopEqDs.getLcyacc());
		dbBopEqDs.setFcyamt(bopEqDs.getFcyamt());
		dbBopEqDs.setFcyacc(bopEqDs.getFcyacc());
		dbBopEqDs.setOthamt(bopEqDs.getOthamt());
		dbBopEqDs.setOthacc(bopEqDs.getOthacc());
		dbBopEqDs.setMethod(bopEqDs.getMethod());
		dbBopEqDs.setBuscode(bopEqDs.getBuscode());

		dbBopEqDs.setLstUpdTlr(gi.getTlrno());
		dbBopEqDs.setLstUpdTm(new Date());
		if (dbBopEqDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
			dbBopEqDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		} else {
			dbBopEqDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
		}
		dbBopEqDs.setActiondesc(bopEqDs.getActiondesc());
		dbBopEqDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbBopEqDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbBopEqDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		dbBopEqDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

		ReportDataVaildUtil.executeVaild(dbBopEqDs.getApptype(), dbBopEqDs.getCurrentfile(), dbBopEqDs);
		
		//数据处理记录表保存
		commonService.saveBiDataProcessLog(dbBopEqDs.getApptype(), dbBopEqDs.getCurrentfile(), dbBopEqDs.getId(), null,
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

		rootdao.saveOrUpdate(dbBopEqDs);
	}
	
	private void saveBOPQDel(MtsBopEqDs bopEqDs, GlobalInfo gi,
			ROOTDAO rootdao, ReportCommonService commonService) throws CommonException {
		MtsBopEqDs dbBopEqDs = rootdao.query(MtsBopEqDs.class, bopEqDs.getId());

		/**
		 * 校验当前数据是否已经被其他用户更新
		 */
		if(!StringUtils.equals(bopEqDs.getRecStatus(), dbBopEqDs.getRecStatus())){
			ExceptionUtil.throwCommonException("该记录["+bopEqDs.getRptno()+"]已经被其他用户修改");
		}

		dbBopEqDs.setLstUpdTlr(gi.getTlrno());
		dbBopEqDs.setLstUpdTm(new Date());
		dbBopEqDs.setActiondesc(bopEqDs.getActiondesc());
		dbBopEqDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		dbBopEqDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbBopEqDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbBopEqDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		dbBopEqDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

		//数据处理记录表保存
		commonService.saveBiDataProcessLog(dbBopEqDs.getApptype(), dbBopEqDs.getCurrentfile(), dbBopEqDs.getId(), null,
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopEqDs.getActiondesc());

		rootdao.saveOrUpdate(dbBopEqDs);
	}
}
