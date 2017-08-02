package com.huateng.report.bop.collection.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import resource.bean.report.MtsBopFsDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bop.collection.operation.BopFsDsOperation;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopFsDsService {

	protected static final Logger logger = Logger.getLogger(BopFsDsService.class);

	protected BopFsDsService() {
		
	}

	public synchronized static BopFsDsService getInstance() {
		return (BopFsDsService) ApplicationContextUtils.getBean(BopFsDsService.class.getName());
	}

	/**
	 * BOP记录查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qstartDate
	 * @param qendDate
	 * @param qactiontype
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qfiller2 
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryBopFsCollection(String queryType, int pageIndex, int pageSize, String qstartDate, String qendDate, String qactiontype,
			String qapproveStatus, String qrepStatus, String qrecStatus, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopFsDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("F")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_F);
		} else if(queryType.equals("S")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_S);
		}
 		objs.add(TopReportConstants.REPORT_RECSTATUS_01);
		objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		if(!DataFormat.isEmpty(qstartDate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qstartDate);
		}
		if(!DataFormat.isEmpty(qendDate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qendDate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}
	
	/**
	 * BOP审核查询
	 * @param queryType
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param eworkDate
	 * @param qactiontype
	 * @param 
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qfiller2 
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryBopFsAudit(String queryType, int pageIndex,
			int pageSize, String qworkDate, String eworkDate,String qactiontype, String qrecStatus,
			String qapproveStatus, String qrepStatus, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopFsDs model WHERE model.apptype = ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("F")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_F);
		}
		if (queryType.equals("S")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_S);
		}
		hql.append(" AND model.recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_RECSTATUS_03);
		objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" AND model.workDate >= ? ");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(eworkDate)) {
			hql.append(" AND model.workDate <= ? ");
			objs.add(eworkDate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}
	
	/**
	 * 补录查询
	 * @param queryType
	 * @param pageIndex
	 * @param pageSize
	 * @param qbrNo
	 * @param qrecStatus
	 * @param qactiontype
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qworkDate
	 * @param eworkDate
	 * @param qfiller2 
	 * @return
	 * @throws CommonException 
	 */
	public PageQueryResult queryFsDs(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qrecStatus, String qactiontype,
			String qapproveStatus, String qrepStatus, String qworkDate,
			String eworkDate, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopFsDs model WHERE model.apptype = ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("F")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_F);
		}
		if (queryType.equals("S")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_S);
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" AND model.workDate >= ? ");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(eworkDate)) {
			hql.append(" AND model.workDate <= ? ");
			objs.add(eworkDate);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" ORDER BY model.lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}

	/**
	 * 保存
	 * @param bopFsDs
	 * @param type
	 * @throws CommonException 
	 */
	public void saveFsDs(MtsBopFsDs bopFsDs, String type) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if (BopFsDsOperation.OP_F_NEW.equals(type)){
			bopFsDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bopFsDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bopFsDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopFsDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			bopFsDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			bopFsDs.setCrtTm(new Date());
			bopFsDs.setLstUpdTm(new Date());
			bopFsDs.setLstUpdTlr(gi.getTlrno());
			bopFsDs.setBrNo(gi.getBrno());
			bopFsDs.setId(ReportUtils.getUUID());
			bopFsDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
			bopFsDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_F);
			bopFsDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//TODO 写验证类并且配置
			ReportDataVaildUtil.executeVaild(bopFsDs.getApptype(), bopFsDs.getCurrentfile(), bopFsDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(bopFsDs.getApptype(), bopFsDs.getCurrentfile(), bopFsDs.getId(), bopFsDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

			rootdao.save(bopFsDs);
		} else if (BopFsDsOperation.OP_F_MOD.equals(type)){
			MtsBopFsDs dbBopFsDs = rootdao.query(MtsBopFsDs.class, bopFsDs.getId());
			
			if(!StringUtils.equals(bopFsDs.getRecStatus(), dbBopFsDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopFsDs.getRptno()+"]已经被其他用户修改");
			}
			//修改的数据进行设置值 TODO
			dbBopFsDs.setOppuser(bopFsDs.getOppuser());
			dbBopFsDs.setCustype(bopFsDs.getCustype());
			dbBopFsDs.setIdcode(bopFsDs.getIdcode());
			dbBopFsDs.setCustcod(bopFsDs.getCustcod());
			dbBopFsDs.setCustnm(bopFsDs.getCustnm());
			dbBopFsDs.setTxccy(bopFsDs.getTxccy());
			dbBopFsDs.setTxamt(bopFsDs.getTxamt());
			dbBopFsDs.setExrate(bopFsDs.getExrate());
			dbBopFsDs.setLcyamt(bopFsDs.getLcyamt());
			dbBopFsDs.setLcyacc(bopFsDs.getLcyacc());
			dbBopFsDs.setFcyamt(bopFsDs.getFcyamt());
			dbBopFsDs.setFcyacc(bopFsDs.getFcyacc());
			dbBopFsDs.setOthamt(bopFsDs.getOthamt());
			dbBopFsDs.setOthacc(bopFsDs.getOthacc());
			dbBopFsDs.setMethod(bopFsDs.getMethod());
			dbBopFsDs.setBuscode(bopFsDs.getBuscode());
			dbBopFsDs.setActuamt(bopFsDs.getActuamt());
			dbBopFsDs.setActuccy(bopFsDs.getActuccy());
			dbBopFsDs.setOutchargeamt(bopFsDs.getOutchargeamt());
			dbBopFsDs.setOutchargeccy(bopFsDs.getOutchargeccy());
			dbBopFsDs.setLcbgno(bopFsDs.getLcbgno());
			dbBopFsDs.setIssdate(bopFsDs.getIssdate());
			dbBopFsDs.setTenor(bopFsDs.getTenor());
			dbBopFsDs.setActiondesc(bopFsDs.getActiondesc());
			
			dbBopFsDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			dbBopFsDs.setLstUpdTlr(gi.getTlrno());
			dbBopFsDs.setLstUpdTm(new Date());
			if (dbBopFsDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopFsDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopFsDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopFsDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopFsDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopFsDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

			ReportDataVaildUtil.executeVaild(dbBopFsDs.getApptype(), dbBopFsDs.getCurrentfile(), dbBopFsDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopFsDs.getApptype(), dbBopFsDs.getCurrentfile(), dbBopFsDs.getId(), dbBopFsDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopFsDs);
		} else if(BopFsDsOperation.OP_F_DEL.equals(type)){
			MtsBopFsDs dbBopFsDs = rootdao.query(MtsBopFsDs.class, bopFsDs.getId());
			
			if(!StringUtils.equals(bopFsDs.getRecStatus(), dbBopFsDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopFsDs.getRptno()+"]已经被其他用户修改");
			}
			
			/**
			 * 根据账户信息的ID 查询相应申报和管理信息
			 */
			Integer count = rootdao.queryByHqlToCount(" SELECT count(model) FROM MtsBopFsDs model WHERE model.filler1 = '" + bopFsDs.getId() + "' ");
			if (count > 0){
				ExceptionUtil.throwCommonException("已存在相关的申报信息或者管理信息不能删除！");
			}
			dbBopFsDs.setLstUpdTlr(gi.getTlrno());
			dbBopFsDs.setLstUpdTm(new Date());
			dbBopFsDs.setActiondesc(bopFsDs.getActiondesc());
			dbBopFsDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopFsDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopFsDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopFsDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopFsDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopFsDs.getApptype(), dbBopFsDs.getCurrentfile(), dbBopFsDs.getId(), dbBopFsDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopFsDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopFsDs);
		} else if (BopFsDsOperation.OP_S_NEW.equals(type)) {
			MtsBopFsDs newBopFsDs = new MtsBopFsDs();
			//新增基础信息
			newBopFsDs.setId(ReportUtils.getUUID());
			newBopFsDs.setCrtTm(new Date());
			newBopFsDs.setLstUpdTm(new Date());
			newBopFsDs.setLstUpdTlr(gi.getTlrno());
			newBopFsDs.setBrNo(gi.getBrno());
			newBopFsDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
			newBopFsDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_S);
			newBopFsDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			newBopFsDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			newBopFsDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			newBopFsDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			newBopFsDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			newBopFsDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			//新增页面信息 
			newBopFsDs.setRptno(bopFsDs.getRptno());
			newBopFsDs.setIsref(bopFsDs.getIsref());
			newBopFsDs.setCountry(bopFsDs.getCountry());
			newBopFsDs.setPaytype(bopFsDs.getPaytype());
			newBopFsDs.setPayattr(bopFsDs.getPayattr());
			newBopFsDs.setTxcode(bopFsDs.getTxcode());
			newBopFsDs.setTc1amt(bopFsDs.getTc1amt());
			newBopFsDs.setTxcode2(bopFsDs.getTxcode2());
			newBopFsDs.setTc2amt(bopFsDs.getTc2amt());
			newBopFsDs.setImpdate(bopFsDs.getImpdate());
			newBopFsDs.setContrno(bopFsDs.getContrno());
			newBopFsDs.setInvoino(bopFsDs.getInvoino());
			newBopFsDs.setBillno(bopFsDs.getBillno());
			newBopFsDs.setContamt(bopFsDs.getContamt());
			newBopFsDs.setCrtuser(bopFsDs.getCrtuser());
			newBopFsDs.setInptelc(bopFsDs.getInptelc());
			newBopFsDs.setRptdate(bopFsDs.getRptdate());
			newBopFsDs.setRegno(bopFsDs.getRegno());
			if(StringUtils.isEmpty(newBopFsDs.getRegno())){
				newBopFsDs.setRegno("N/A");
			}
			newBopFsDs.setFiller1(bopFsDs.getFiller1());
			newBopFsDs.setFiller2(bopFsDs.getFiller2());
			newBopFsDs.setBuscode(bopFsDs.getBuscode());

			//其中有一步验证需要用到基础的付款金额
			newBopFsDs.setTxamt(bopFsDs.getTxamt());
			ReportDataVaildUtil.executeVaild(newBopFsDs.getApptype(), newBopFsDs.getCurrentfile(), newBopFsDs);
			newBopFsDs.setTxamt(null);
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(newBopFsDs.getApptype(), newBopFsDs.getCurrentfile(), newBopFsDs.getId(),
					newBopFsDs.getBuscode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

			rootdao.save(newBopFsDs);
		} else if (BopFsDsOperation.OP_S_MOD.equals(type)) {

			MtsBopFsDs dbBopFsDs = rootdao.query(MtsBopFsDs.class, bopFsDs.getId());
			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(dbBopFsDs.getRecStatus(), bopFsDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopFsDs.getRptno()+"]已经被其他用户修改");
			}

			dbBopFsDs.setRptno(bopFsDs.getRptno());
			dbBopFsDs.setIsref(bopFsDs.getIsref());
			dbBopFsDs.setCountry(bopFsDs.getCountry());
			dbBopFsDs.setPaytype(bopFsDs.getPaytype());
			dbBopFsDs.setPayattr(bopFsDs.getPayattr());
			dbBopFsDs.setTxcode(bopFsDs.getTxcode());
			dbBopFsDs.setTc1amt(bopFsDs.getTc1amt());
			dbBopFsDs.setTxcode2(bopFsDs.getTxcode2());
			dbBopFsDs.setTc2amt(bopFsDs.getTc2amt());
			dbBopFsDs.setImpdate(bopFsDs.getImpdate());
			dbBopFsDs.setContrno(bopFsDs.getContrno());
			dbBopFsDs.setInvoino(bopFsDs.getInvoino());
			dbBopFsDs.setBillno(bopFsDs.getBillno());
			dbBopFsDs.setContamt(bopFsDs.getContamt());
			dbBopFsDs.setCrtuser(bopFsDs.getCrtuser());
			dbBopFsDs.setInptelc(bopFsDs.getInptelc());
			dbBopFsDs.setRptdate(bopFsDs.getRptdate());
			dbBopFsDs.setRegno(bopFsDs.getRegno());
			dbBopFsDs.setActiondesc(bopFsDs.getActiondesc());
			if(StringUtils.isEmpty(dbBopFsDs.getRegno())){
				dbBopFsDs.setRegno("N/A");
			}
			dbBopFsDs.setLstUpdTlr(gi.getTlrno());
			dbBopFsDs.setLstUpdTm(new Date());
			if (dbBopFsDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopFsDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopFsDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopFsDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopFsDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopFsDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopFsDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//其中有一步验证需要用到基础的付款金额
			dbBopFsDs.setTxamt(bopFsDs.getTxamt());
			ReportDataVaildUtil.executeVaild(dbBopFsDs.getApptype(), dbBopFsDs.getCurrentfile(), dbBopFsDs);
			dbBopFsDs.setTxamt(null);
			
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopFsDs.getApptype(), dbBopFsDs.getCurrentfile(), dbBopFsDs.getId(), dbBopFsDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopFsDs);
		} else if (BopFsDsOperation.OP_S_DEL.equals(type)) {
			MtsBopFsDs dbBopFsDs = rootdao.query(MtsBopFsDs.class, bopFsDs.getId());

			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(bopFsDs.getRecStatus(), dbBopFsDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopFsDs.getRptno()+"]已经被其他用户修改");
			}

			dbBopFsDs.setLstUpdTlr(gi.getTlrno());
			dbBopFsDs.setLstUpdTm(new Date());
			dbBopFsDs.setActiondesc(bopFsDs.getActiondesc());
			dbBopFsDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopFsDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopFsDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopFsDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopFsDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopFsDs.getApptype(), dbBopFsDs.getCurrentfile(), dbBopFsDs.getId(), dbBopFsDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopFsDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopFsDs);
		}
	}
	
	/**
	 * 审核方法
	 * @param approveStatusChoose
	 * @param approveResultChoose
	 * @param ids
	 * @param opSignedAudit
	 * @throws CommonException
	 */
	public void auditBopFsDs(String approveStatusChoose,
			String approveResultChoose, List<String> ids, String opSignedAudit) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from MtsBopFsDs model where model.id in" + ReportUtils.toInString(ids);
		List<MtsBopFsDs> bopFsDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}

		for (MtsBopFsDs bopFsDs : bopFsDsList) {
			bopFsDs.setLstUpdTlr(gi.getTlrno());
			bopFsDs.setLstUpdTm(new Date());
			bopFsDs.setApproveResult(approveResultChoose);
			bopFsDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopFsDs.setApproveStatus(approveStatusChoose);
			bopFsDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			rootdao.saveOrUpdate(bopFsDs);

			if(bopFsDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopFsDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopFsDs.getApptype(), bopFsDs.getCurrentfile(), bopFsDs.getId(), bopFsDs.getBuscode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, bopFsDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopFsDs.getApptype(), bopFsDs.getCurrentfile(), bopFsDs.getId(), bopFsDs.getBuscode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}
		}
	}

}