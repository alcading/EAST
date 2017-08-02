package com.huateng.report.bop.collection.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import resource.bean.report.MtsBopCkpDs;
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
import com.huateng.report.bop.collection.operation.BopCkpDsOperation;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopCkpDsService {

	protected static final Logger logger = Logger.getLogger(BopCkpDsService.class);

	protected BopCkpDsService() {
		
	}

	public synchronized static BopCkpDsService getInstance() {
		return (BopCkpDsService) ApplicationContextUtils.getBean(BopCkpDsService.class.getName());
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
	public PageQueryResult queryBopCkpCollection(String queryType, int pageIndex, int pageSize, String qstartDate, String qendDate, String qactiontype,
			String qapproveStatus, String qrepStatus, String qrecStatus, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopCkpDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("C")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_C);
		} else if(queryType.equals("K")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_K);
		} else if (queryType.equals("P")){
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_P);
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
		if (!DataFormat.isEmpty(qfiller2)){
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
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qfiller2 
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryBopCkpAudit(String queryType, int pageIndex,
			int pageSize, String qworkDate, String eworkDate,String qactiontype, String qrecStatus,
			String qapproveStatus, String qrepStatus, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopCkpDs model WHERE model.apptype = ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("C")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_C);
		}
		if (queryType.equals("K")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_K);
		}
		if (queryType.equals("P")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_P);
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
		if(!DataFormat.isEmpty(qfiller2)){
			hql.append(" AND model.filler2 like '%" + qfiller2 + "%'");
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
	public PageQueryResult queryCKPDs(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qrecStatus, String qactiontype,
			String qapproveStatus, String qrepStatus, String qworkDate,
			String eworkDate, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopCkpDs model WHERE model.apptype = ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("C")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_C);
		}
		if (queryType.equals("K")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_K);
		}
		if (queryType.equals("P")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_P);
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
		if(!DataFormat.isEmpty(qfiller2)){
			hql.append(" AND model.filler2 like '%" + qfiller2 + "%'");
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
	 * @param bopCkpDs
	 * @param type
	 * @throws CommonException 
	 */
	public void saveCkpDs(MtsBopCkpDs bopCkpDs, String type) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if (BopCkpDsOperation.OP_C_NEW.equals(type)){
			bopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			bopCkpDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			bopCkpDs.setCrtTm(new Date());
			bopCkpDs.setLstUpdTm(new Date());
			bopCkpDs.setLstUpdTlr(gi.getTlrno());
			bopCkpDs.setBrNo(gi.getBrno());
			bopCkpDs.setId(ReportUtils.getUUID());
			bopCkpDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
			bopCkpDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_C);
			bopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//TODO 写验证类并且配置
			ReportDataVaildUtil.executeVaild(bopCkpDs.getApptype(), bopCkpDs.getCurrentfile(), bopCkpDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(bopCkpDs.getApptype(), bopCkpDs.getCurrentfile(), bopCkpDs.getId(), bopCkpDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

			rootdao.save(bopCkpDs);
		} else if (BopCkpDsOperation.OP_C_MOD.equals(type)){
			MtsBopCkpDs dbBopCkpDs = rootdao.query(MtsBopCkpDs.class, bopCkpDs.getId());
			
			if(!StringUtils.equals(bopCkpDs.getRecStatus(), dbBopCkpDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopCkpDs.getRptno()+"]已经被其他用户修改");
			}
			//修改的数据进行设置值 TODO
			dbBopCkpDs.setOppuser(bopCkpDs.getOppuser());
			dbBopCkpDs.setCustype(bopCkpDs.getCustype());
			dbBopCkpDs.setIdcode(bopCkpDs.getIdcode());
			dbBopCkpDs.setCustcod(bopCkpDs.getCustcod());
			dbBopCkpDs.setCustnm(bopCkpDs.getCustnm());
			dbBopCkpDs.setTxccy(bopCkpDs.getTxccy());
			dbBopCkpDs.setTxamt(bopCkpDs.getTxamt());
			dbBopCkpDs.setExrate(bopCkpDs.getExrate());
			dbBopCkpDs.setLcyamt(bopCkpDs.getLcyamt());
			dbBopCkpDs.setLcyacc(bopCkpDs.getLcyacc());
			dbBopCkpDs.setFcyamt(bopCkpDs.getFcyamt());
			dbBopCkpDs.setFcyacc(bopCkpDs.getFcyacc());
			dbBopCkpDs.setOthamt(bopCkpDs.getOthamt());
			dbBopCkpDs.setOthacc(bopCkpDs.getOthacc());
			dbBopCkpDs.setMethod(bopCkpDs.getMethod());
			dbBopCkpDs.setBuscode(bopCkpDs.getBuscode());
			dbBopCkpDs.setActuamt(bopCkpDs.getActuamt());
			dbBopCkpDs.setActuccy(bopCkpDs.getActuccy());
			dbBopCkpDs.setOutchargeamt(bopCkpDs.getOutchargeamt());
			dbBopCkpDs.setOutchargeccy(bopCkpDs.getOutchargeccy());
			dbBopCkpDs.setLcbgno(bopCkpDs.getLcbgno());
			dbBopCkpDs.setIssdate(bopCkpDs.getIssdate());
			dbBopCkpDs.setTenor(bopCkpDs.getTenor());
			dbBopCkpDs.setActiondesc(bopCkpDs.getActiondesc());
			
			dbBopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			dbBopCkpDs.setLstUpdTlr(gi.getTlrno());
			dbBopCkpDs.setLstUpdTm(new Date());
			if (dbBopCkpDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

			ReportDataVaildUtil.executeVaild(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs.getId(), dbBopCkpDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopCkpDs);
		} else if(BopCkpDsOperation.OP_C_DEL.equals(type)){
			MtsBopCkpDs dbBopCkpDs = rootdao.query(MtsBopCkpDs.class, bopCkpDs.getId());
			
			if(!StringUtils.equals(bopCkpDs.getRecStatus(), dbBopCkpDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopCkpDs.getRptno()+"]已经被其他用户修改");
			}
			
			/**
			 * 根据账户信息的ID 查询相应申报和管理信息
			 */
			Integer count = rootdao.queryByHqlToCount(" SELECT count(model) FROM MtsBopCkpDs model WHERE model.filler1 = '" + bopCkpDs.getId() + "' ");
			if (count > 0){
				ExceptionUtil.throwCommonException("已存在相关的申报信息或者管理信息不能删除！");
			}
			dbBopCkpDs.setLstUpdTlr(gi.getTlrno());
			dbBopCkpDs.setLstUpdTm(new Date());
			dbBopCkpDs.setActiondesc(bopCkpDs.getActiondesc());
			dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs.getId(), dbBopCkpDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCkpDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCkpDs);
		} else if (BopCkpDsOperation.OP_K_NEW.equals(type)) {
			MtsBopCkpDs newBopCkpDs = new MtsBopCkpDs();
			//新增基础信息
			newBopCkpDs.setId(ReportUtils.getUUID());
			newBopCkpDs.setCrtTm(new Date());
			newBopCkpDs.setLstUpdTm(new Date());
			newBopCkpDs.setLstUpdTlr(gi.getTlrno());
			newBopCkpDs.setBrNo(gi.getBrno());
			newBopCkpDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
			newBopCkpDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_K);
			newBopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			newBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			newBopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			newBopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			newBopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			newBopCkpDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			//新增页面信息 
			newBopCkpDs.setRptno(bopCkpDs.getRptno());
			newBopCkpDs.setCountry(bopCkpDs.getCountry());
			newBopCkpDs.setPaytype(bopCkpDs.getPaytype());
			newBopCkpDs.setTxcode(bopCkpDs.getTxcode());
			newBopCkpDs.setTc1amt(bopCkpDs.getTc1amt());
			newBopCkpDs.setTxrem(bopCkpDs.getTxrem());
			newBopCkpDs.setTxcode2(bopCkpDs.getTxcode2());
			newBopCkpDs.setTc2amt(bopCkpDs.getTc2amt());
			newBopCkpDs.setTx2rem(bopCkpDs.getTx2rem());
			newBopCkpDs.setIsref(bopCkpDs.getIsref());
			newBopCkpDs.setCrtuser(bopCkpDs.getCrtuser());
			newBopCkpDs.setInptelc(bopCkpDs.getInptelc());
			newBopCkpDs.setRptdate(bopCkpDs.getRptdate());
			newBopCkpDs.setRegno(bopCkpDs.getRegno());
			if(StringUtils.isEmpty(newBopCkpDs.getRegno())){
				newBopCkpDs.setRegno("N/A");
			}
			newBopCkpDs.setFiller1(bopCkpDs.getFiller1());
			newBopCkpDs.setFiller2(bopCkpDs.getFiller2());
			newBopCkpDs.setBuscode(bopCkpDs.getBuscode());

			//其中有一步验证需要用到基础的付款金额
			newBopCkpDs.setTxamt(bopCkpDs.getTxamt());
			ReportDataVaildUtil.executeVaild(newBopCkpDs.getApptype(), newBopCkpDs.getCurrentfile(), newBopCkpDs);
			newBopCkpDs.setTxamt(null);
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(newBopCkpDs.getApptype(), newBopCkpDs.getCurrentfile(), newBopCkpDs.getId(),
					newBopCkpDs.getBuscode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

			rootdao.save(newBopCkpDs);
		} else if (BopCkpDsOperation.OP_K_MOD.equals(type)) {

			MtsBopCkpDs dbBopCkpDs = rootdao.query(MtsBopCkpDs.class, bopCkpDs.getId());
			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(dbBopCkpDs.getRecStatus(), bopCkpDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopCkpDs.getRptno()+"]已经被其他用户修改");
			}

			dbBopCkpDs.setRptno(bopCkpDs.getRptno());
			dbBopCkpDs.setCountry(bopCkpDs.getCountry());
			dbBopCkpDs.setPaytype(bopCkpDs.getPaytype());
			dbBopCkpDs.setTxcode(bopCkpDs.getTxcode());
			dbBopCkpDs.setTc1amt(bopCkpDs.getTc1amt());
			dbBopCkpDs.setTxrem(bopCkpDs.getTxrem());
			dbBopCkpDs.setTxcode2(bopCkpDs.getTxcode2());
			dbBopCkpDs.setTc2amt(bopCkpDs.getTc2amt());
			dbBopCkpDs.setTx2rem(bopCkpDs.getTx2rem());
			dbBopCkpDs.setIsref(bopCkpDs.getIsref());
			dbBopCkpDs.setCrtuser(bopCkpDs.getCrtuser());
			dbBopCkpDs.setInptelc(bopCkpDs.getInptelc());
			dbBopCkpDs.setRptdate(bopCkpDs.getRptdate());
			dbBopCkpDs.setRegno(bopCkpDs.getRegno());
			dbBopCkpDs.setActiondesc(bopCkpDs.getActiondesc());
			if(StringUtils.isEmpty(dbBopCkpDs.getRegno())){
				dbBopCkpDs.setRegno("N/A");
			}
			dbBopCkpDs.setLstUpdTlr(gi.getTlrno());
			dbBopCkpDs.setLstUpdTm(new Date());
			if (dbBopCkpDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//其中有一步验证需要用到基础的付款金额
			dbBopCkpDs.setTxamt(bopCkpDs.getTxamt());
			ReportDataVaildUtil.executeVaild(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs);
			dbBopCkpDs.setTxamt(null);
			
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs.getId(), dbBopCkpDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopCkpDs);
		} else if (BopCkpDsOperation.OP_K_DEL.equals(type)) {
			MtsBopCkpDs dbBopCkpDs = rootdao.query(MtsBopCkpDs.class, bopCkpDs.getId());

			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(bopCkpDs.getRecStatus(), dbBopCkpDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopCkpDs.getRptno()+"]已经被其他用户修改");
			}

			dbBopCkpDs.setLstUpdTlr(gi.getTlrno());
			dbBopCkpDs.setLstUpdTm(new Date());
			dbBopCkpDs.setActiondesc(bopCkpDs.getActiondesc());
			dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs.getId(), dbBopCkpDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCkpDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCkpDs);
		} else if (BopCkpDsOperation.OP_P_NEW.equals(type)) {
			MtsBopCkpDs newBopCkpDs = new MtsBopCkpDs();
			//新增基础信息
			newBopCkpDs.setId(ReportUtils.getUUID());
			newBopCkpDs.setCrtTm(new Date());
			newBopCkpDs.setLstUpdTm(new Date());
			newBopCkpDs.setLstUpdTlr(gi.getTlrno());
			newBopCkpDs.setBrNo(gi.getBrno());
			newBopCkpDs.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
			newBopCkpDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_P);
			newBopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			newBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			newBopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			newBopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			newBopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			newBopCkpDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			//新增页面信息 
			newBopCkpDs.setRptno(bopCkpDs.getRptno());
			newBopCkpDs.setContrno(bopCkpDs.getContrno());
			newBopCkpDs.setInvoino(bopCkpDs.getInvoino());
			newBopCkpDs.setBillno(bopCkpDs.getBillno());
			newBopCkpDs.setContamt(bopCkpDs.getContamt());
			newBopCkpDs.setCrtuser(bopCkpDs.getCrtuser());
			newBopCkpDs.setInptelc(bopCkpDs.getInptelc());
			newBopCkpDs.setRptdate(bopCkpDs.getRptdate());
			newBopCkpDs.setFiller1(bopCkpDs.getFiller1());
			newBopCkpDs.setFiller2(bopCkpDs.getFiller2());
			newBopCkpDs.setBuscode(bopCkpDs.getBuscode());

			//其中有一步验证需要用到基础的付款金额
			ReportDataVaildUtil.executeVaild(newBopCkpDs.getApptype(), newBopCkpDs.getCurrentfile(), newBopCkpDs);
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(newBopCkpDs.getApptype(), newBopCkpDs.getCurrentfile(), newBopCkpDs.getId(),
					newBopCkpDs.getBuscode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

			rootdao.save(newBopCkpDs);
		} else if (BopCkpDsOperation.OP_P_MOD.equals(type)) {

			MtsBopCkpDs dbBopCkpDs = rootdao.query(MtsBopCkpDs.class, bopCkpDs.getId());
			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(dbBopCkpDs.getRecStatus(), bopCkpDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopCkpDs.getRptno()+"]已经被其他用户修改");
			}

			dbBopCkpDs.setRptno(bopCkpDs.getRptno());
			dbBopCkpDs.setContrno(bopCkpDs.getContrno());
			dbBopCkpDs.setInvoino(bopCkpDs.getInvoino());
			dbBopCkpDs.setBillno(bopCkpDs.getBillno());
			dbBopCkpDs.setContamt(bopCkpDs.getContamt());
			dbBopCkpDs.setCrtuser(bopCkpDs.getCrtuser());
			dbBopCkpDs.setInptelc(bopCkpDs.getInptelc());
			dbBopCkpDs.setRptdate(bopCkpDs.getRptdate());
			dbBopCkpDs.setFiller1(bopCkpDs.getFiller1());
			dbBopCkpDs.setActiondesc(bopCkpDs.getActiondesc());

			dbBopCkpDs.setLstUpdTlr(gi.getTlrno());
			dbBopCkpDs.setLstUpdTm(new Date());
			if (dbBopCkpDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//其中有一步验证需要用到基础的付款金额
			ReportDataVaildUtil.executeVaild(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs);
			
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs.getId(), dbBopCkpDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopCkpDs);
		} else if (BopCkpDsOperation.OP_P_DEL.equals(type)) {
			MtsBopCkpDs dbBopCkpDs = rootdao.query(MtsBopCkpDs.class, bopCkpDs.getId());

			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(bopCkpDs.getRecStatus(), dbBopCkpDs.getRecStatus())){
				ExceptionUtil.throwCommonException("该记录["+bopCkpDs.getRptno()+"]已经被其他用户修改");
			}

			dbBopCkpDs.setLstUpdTlr(gi.getTlrno());
			dbBopCkpDs.setLstUpdTm(new Date());
			dbBopCkpDs.setActiondesc(bopCkpDs.getActiondesc());
			dbBopCkpDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCkpDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCkpDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCkpDs.getApptype(), dbBopCkpDs.getCurrentfile(), dbBopCkpDs.getId(), dbBopCkpDs.getBuscode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCkpDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCkpDs);
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
	public void auditBopCkpDs(String approveStatusChoose,
			String approveResultChoose, List<String> ids, String opSignedAudit) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from MtsBopCkpDs model where model.id in" + ReportUtils.toInString(ids);
		List<MtsBopCkpDs> bopCkpDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}

		for (MtsBopCkpDs bopCkpDs : bopCkpDsList) {
			bopCkpDs.setLstUpdTlr(gi.getTlrno());
			bopCkpDs.setLstUpdTm(new Date());
			bopCkpDs.setApproveResult(approveResultChoose);
			bopCkpDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopCkpDs.setApproveStatus(approveStatusChoose);
			bopCkpDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			rootdao.saveOrUpdate(bopCkpDs);

			if(bopCkpDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopCkpDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCkpDs.getApptype(), bopCkpDs.getCurrentfile(), bopCkpDs.getId(), bopCkpDs.getBuscode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, bopCkpDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCkpDs.getApptype(), bopCkpDs.getCurrentfile(), bopCkpDs.getId(), bopCkpDs.getBuscode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}
		}
	}

}