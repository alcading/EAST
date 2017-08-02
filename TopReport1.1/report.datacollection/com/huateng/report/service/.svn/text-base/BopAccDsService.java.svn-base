package com.huateng.report.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import resource.bean.report.BopAccDs;
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
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BopAccDsOperation;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopAccDsService {

	protected static final Logger logger = Logger.getLogger(BopAccDsService.class);

	protected BopAccDsService() {
	}

	public synchronized static BopAccDsService getInstance() {
		return (BopAccDsService) ApplicationContextUtils.getBean(BopAccDsService.class.getName());
	}

	/**
	 * 开关账户查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param qactiontype
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qaccountstat
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryRecordAD(int pageIndex, int pageSize, String qstartDate, String qendDate, String qactiontype,
			String qapproveStatus, String qrepStatus,String qaccountstat, String qrecStatus) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopAccDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_ACC);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_ACC_CA);
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
		if (!DataFormat.isEmpty(qaccountstat)) {
			hql.append(" AND model.accountstat = ? ");
			objs.add(qaccountstat);
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
	 * 开关账户审核查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param qactiontype
	 * @param qaccountno
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qaccountstat
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryAuditAD(int pageIndex, int pageSize,
			String qstartDate, String qendDate, String qactiontype, String qaccountno,
			String qapproveStatus, String qrepStatus, String qaccountstat) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopAccDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?)");
		objs.add(TopReportConstants.REPORT_APP_TYPE_ACC);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_ACC_CA);
		objs.add(TopReportConstants.REPORT_RECSTATUS_03);
		objs.add(TopReportConstants.REPORT_RECSTATUS_04);
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
		if (!DataFormat.isEmpty(qaccountno)) {
			hql.append(" AND model.accountno LIKE ? ");
			objs.add("%" + qaccountno + "%");
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qaccountstat)) {
			hql.append(" AND model.accountstat = ? ");
			objs.add(qaccountstat);
		}
		hql.append(" AND model.brNo = ? ORDER BY model.workDate, model.actiontype, model.approveStatus DESC ");
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
	 * 收支余账户查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param qactiontype
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qaccountno
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryRecordInOut(int pageIndex, int pageSize,
			String qstartDate, String qendDate, String qactiontype,
			String qapproveStatus, String qrepStatus, String qaccountno, String qrecStatus) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopAccDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_ACC);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_ACC_CB);
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
		if (!DataFormat.isEmpty(qaccountno)) {
			hql.append(" AND model.accountno LIKE ? ");
			objs.add("%" + qaccountno + "%");
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
	 * 收支余审核查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param qactiontype
	 * @param qaccountno
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryAuditInOut(int pageIndex, int pageSize,
			String qstartDate, String qendDate, String qactiontype, String qrecStatus, String qaccountno,
			String qapproveStatus, String qrepStatus) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopAccDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_ACC);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_ACC_CB);
		objs.add(TopReportConstants.REPORT_RECSTATUS_03);
		objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		if (!DataFormat.isEmpty(qstartDate)) {
			hql.append(" AND model.workDate >= ? ");
			objs.add(qstartDate);
		}
		if (!DataFormat.isEmpty(qendDate)) {
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
		if (!DataFormat.isEmpty(qaccountno)) {
			hql.append(" AND model.accountno LIKE ? ");
			objs.add("%" + qaccountno + "%");
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
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
	 * 弹出选择账户的查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param qaccountstat
	 * @param qaccountCata
	 * @param qaccountno
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryAccountLoadPage(int pageIndex, int pageSize,
			String qStartDate, String qEndDate, String qaccountstat, String qaccountCata,
			String qaccountno) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT new resource.bean.report.BopAccDs(model.id, model.accountno, model.accountstat, model.amtype, " +
				"model.enCode, model.enName, model.accountType, model.accountCata,model.currencyCode, model.businessDate, model.fileNumber, " +
				"model.limitType, model.accountLimit,model.workDate) FROM BopAccDs model WHERE ");
		hql.append(" model.apptype = ? and model.currentfile = ? AND model.recStatus <> ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_ACC);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_ACC_CA);
		objs.add(TopReportConstants.REPORT_RECSTATUS_07);
		if(!DataFormat.isEmpty(qStartDate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qStartDate);
		}
		if(!DataFormat.isEmpty(qEndDate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qEndDate);
		}
		if (!DataFormat.isEmpty(qaccountstat)) {
			hql.append(" AND model.accountstat = ? ");
			objs.add(qaccountstat);
		}
		if (!DataFormat.isEmpty(qaccountCata)) {
			hql.append(" AND model.accountCata = ? ");
			objs.add(qaccountCata);
		}
		if (!DataFormat.isEmpty(qaccountno)) {
			hql.append(" AND model.accountno LIKE ? ");
			objs.add("%" + qaccountno + "%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.workDate, model.actiontype, model.approveStatus DESC ");
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
	 * 保存或更新外汇账户相关信息
	 * @param bopAccDs
	 * @param type
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public void saveAccDs(BopAccDs bopAccDs, String type) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if (BopAccDsOperation.OP_AD_NEW.equals(type)){
			bopAccDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bopAccDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bopAccDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopAccDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			bopAccDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			bopAccDs.setCrtTm(new Date());
			bopAccDs.setLstUpdTm(new Date());
			bopAccDs.setLstUpdTlr(gi.getTlrno());
			bopAccDs.setBrNo(gi.getBrno());
			bopAccDs.setBranchCode(gi.getBrno());
			bopAccDs.setBranchName(gi.getBrName());
			bopAccDs.setId(ReportUtils.getUUID());
			bopAccDs.setApptype(TopReportConstants.REPORT_APP_TYPE_ACC);
			bopAccDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_ACC_CA);
			bopAccDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			Integer count = rootdao.queryByHqlToCount(" SELECT COUNT(model) FROM BopAccDs model WHERE model.accountno = '" + bopAccDs.getAccountno() +
					"' AND model.currencyCode = '" + bopAccDs.getCurrencyCode() + "' AND model.branchCode = '" + bopAccDs.getBranchCode() +
					"' AND model.brNo = '" + gi.getBrno() + "' ");
			if (count > 0) {
				ExceptionUtil.throwCommonException("topreport.bopaccds.new.recordad.repeat");
			}

			ReportDataVaildUtil.executeVaild(bopAccDs.getApptype(), bopAccDs.getCurrentfile(), bopAccDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(bopAccDs.getApptype(), bopAccDs.getCurrentfile(), bopAccDs.getId(), bopAccDs.getFileNumber(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

			rootdao.save(bopAccDs);
		} else if (BopAccDsOperation.OP_AD_MOD.equals(type)) {
			BopAccDs dbBopAccDs = rootdao.query(BopAccDs.class, bopAccDs.getId());

			if(!StringUtils.equals(bopAccDs.getRecStatus(), dbBopAccDs.getRecStatus())){
				ExceptionUtil.throwCommonException("账号["+bopAccDs.getAccountno()+"]已经被其他用户修改");
			}

			/**
			 * 按照
			 * 《国家外汇管理局关于规范境内银行资本项目数据报送的通知》（汇发[2012]36号文）相关问题解答（第三期）
			 * 第 5 节
			 * 《外汇账户数据采集规范（1.0版）》5.1账户开关户信息中，账户状态“变更”与操作类型“修改”有什么区别
			 * 增加了在报变更信息时需要同时将业务发生日期改为本次变更日期
			 */
			if(StringUtils.equals(bopAccDs.getAccountstat(), "12")){
				Date oldbusinessdate = DateUtil.get20Date(dbBopAccDs.getBusinessDate());
				Date newbusinessdate = DateUtil.get20Date(bopAccDs.getBusinessDate());
				if(oldbusinessdate.compareTo(newbusinessdate) > 0) {
					ExceptionUtil.throwCommonException("[账户状态]为[变更]时[业务发生日期]中填写此次变更的日期");
				}
			}


			dbBopAccDs.setAmtype(bopAccDs.getAmtype());
			dbBopAccDs.setEnCode(bopAccDs.getEnCode());
			dbBopAccDs.setEnName(bopAccDs.getEnName());
			dbBopAccDs.setAccountType(bopAccDs.getAccountType());
			dbBopAccDs.setAccountCata(bopAccDs.getAccountCata());
			dbBopAccDs.setFileNumber(bopAccDs.getFileNumber());
			dbBopAccDs.setLimitType(bopAccDs.getLimitType());
			dbBopAccDs.setAccountLimit(bopAccDs.getAccountLimit());
			dbBopAccDs.setAccountstat(bopAccDs.getAccountstat());
			dbBopAccDs.setBusinessDate(bopAccDs.getBusinessDate());
			dbBopAccDs.setRemark1(bopAccDs.getRemark1());
			dbBopAccDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			dbBopAccDs.setLstUpdTlr(gi.getTlrno());
			dbBopAccDs.setLstUpdTm(new Date());
			if (dbBopAccDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopAccDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopAccDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopAccDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopAccDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopAccDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

			ReportDataVaildUtil.executeVaild(dbBopAccDs.getApptype(), dbBopAccDs.getCurrentfile(), dbBopAccDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopAccDs.getApptype(), dbBopAccDs.getCurrentfile(), dbBopAccDs.getId(), dbBopAccDs.getFileNumber(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopAccDs);
		} else if (BopAccDsOperation.OP_AD_DEL.equals(type)) {
			BopAccDs dbBopAccDs = rootdao.query(BopAccDs.class, bopAccDs.getId());
			//判断是否存在收支余信息
			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(bopAccDs.getRecStatus(), dbBopAccDs.getRecStatus())){
				ExceptionUtil.throwCommonException("账号["+bopAccDs.getAccountno()+"]已经被其他用户修改");
			}

			/**
			 * 根据账户信息的ID 查询相应收支余额信息,查询所有记录状态不为07-已删除的余额信息
			 */
			Integer count = rootdao.queryByHqlToCount(" SELECT COUNT(model) FROM BopAccDs model WHERE model.filler1 = '" + dbBopAccDs.getId() + "' AND model.recStatus <> '" + TopReportConstants.REPORT_RECSTATUS_07 + "' ");
			if (count > 0){
				ExceptionUtil.throwCommonException("topreport.bopaccds.delete.exits.inout");
			}
			dbBopAccDs.setLstUpdTlr(gi.getTlrno());
			dbBopAccDs.setLstUpdTm(new Date());
			dbBopAccDs.setActiondesc(bopAccDs.getActiondesc());
			dbBopAccDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopAccDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopAccDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopAccDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopAccDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopAccDs.getApptype(), dbBopAccDs.getCurrentfile(), dbBopAccDs.getId(), dbBopAccDs.getFileNumber(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopAccDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopAccDs);
		} else if (BopAccDsOperation.OP_INOUT_NEW.equals(type)) {
			BopAccDs newBopAccDs = new BopAccDs();

			newBopAccDs.setId(ReportUtils.getUUID());
			newBopAccDs.setCrtTm(new Date());
			newBopAccDs.setLstUpdTm(new Date());
			newBopAccDs.setLstUpdTlr(gi.getTlrno());
			newBopAccDs.setBrNo(gi.getBrno());
			newBopAccDs.setBranchCode(gi.getBrno());
			newBopAccDs.setBranchName(gi.getBrName());
			newBopAccDs.setApptype(TopReportConstants.REPORT_APP_TYPE_ACC);
			newBopAccDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_ACC_CB);//"CB"
			newBopAccDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			newBopAccDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			newBopAccDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			newBopAccDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			newBopAccDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			newBopAccDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

			newBopAccDs.setAccountno(bopAccDs.getAccountno());
			newBopAccDs.setCurrencyCode(bopAccDs.getCurrencyCode());
			newBopAccDs.setDealDate(bopAccDs.getDealDate());
			newBopAccDs.setBalance(bopAccDs.getBalance());
			newBopAccDs.setCredit(bopAccDs.getCredit());
			newBopAccDs.setDebit(bopAccDs.getDebit());
			newBopAccDs.setRemark2(bopAccDs.getRemark2());
			newBopAccDs.setFiller1(bopAccDs.getFiller1());

			Integer count = rootdao.queryByHqlToCount(" SELECT COUNT(model) FROM BopAccDs model WHERE model.accountno= '" + bopAccDs.getAccountno() +
					"' AND model.currencyCode = '" + bopAccDs.getCurrencyCode() + "' AND model.branchCode = '" + gi.getBrno()
					+ "' AND model.dealDate='" + bopAccDs.getDealDate() + "' AND model.currentfile= '"+TopReportConstants.REPORT_FILE_TYPE_ACC_CB+"' AND model.brNo = '" + gi.getBrno() + "' ");
			if (count > 0) {
				ExceptionUtil.throwCommonException("topreport.bopaccds.new.recordinout.repeat");
			}

			checkBalance(rootdao, newBopAccDs);

			/**
			 * 增加了 发生日期大于等于开户日期的校验
			 */
			List<BopAccDs>list = rootdao.queryByQL2List(" FROM BopAccDs WHERE id = '" + bopAccDs.getFiller1() +"' ");
			if(!CollectionUtils.isEmpty(list)){
				BopAccDs balance = list.get(0);
				Date opendate = DateUtil.get20Date(balance.getBusinessDate());
				Date dealdate = DateUtil.get20Date(newBopAccDs.getDealDate());
				if(opendate.after(dealdate)){
					ExceptionUtil.throwCommonException("[收支余额信息]的[发生日期]必须大于等于[开关户信息]的[业务发生日期]");
				}
			}

			ReportDataVaildUtil.executeVaild(newBopAccDs.getApptype(), newBopAccDs.getCurrentfile(), newBopAccDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(newBopAccDs.getApptype(), newBopAccDs.getCurrentfile(), newBopAccDs.getId(),
					bopAccDs.getFileNumber(), //业务编号的赋值 ？ TODO
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

			rootdao.save(newBopAccDs);
		} else if (BopAccDsOperation.OP_INOUT_MOD.equals(type)) {
			//判断是否已产生大于该发生日期的数据，提示不能操作
			Integer count = rootdao.queryByHqlToCount(" SELECT COUNT(model) FROM BopAccDs model WHERE model.dealDate > '" + DateUtil.dateToNumber(gi.getTxdate()) +
					"' AND model.brNo = '" + gi.getBrno() + "' ");
			if (count > 0){
				ExceptionUtil.throwCommonException("topreport.bopaccds.editordelete.exits.predealdate.data");
			}

			BopAccDs dbBopAccDs = rootdao.query(BopAccDs.class, bopAccDs.getId());
			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(bopAccDs.getRecStatus(), dbBopAccDs.getRecStatus())){
				ExceptionUtil.throwCommonException("账号["+bopAccDs.getAccountno()+"]已经被其他用户修改");
			}

			dbBopAccDs.setBalance(bopAccDs.getBalance());
			dbBopAccDs.setCredit(bopAccDs.getCredit());
			dbBopAccDs.setDebit(bopAccDs.getDebit());
			dbBopAccDs.setRemark2(bopAccDs.getRemark2());

			dbBopAccDs.setLstUpdTlr(gi.getTlrno());
			dbBopAccDs.setLstUpdTm(new Date());
			if (dbBopAccDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopAccDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopAccDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopAccDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopAccDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopAccDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopAccDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			checkBalance(rootdao, dbBopAccDs);

			ReportDataVaildUtil.executeVaild(dbBopAccDs.getApptype(), dbBopAccDs.getCurrentfile(), dbBopAccDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopAccDs.getApptype(), dbBopAccDs.getCurrentfile(), dbBopAccDs.getId(), dbBopAccDs.getFileNumber(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopAccDs);
		} else if (BopAccDsOperation.OP_INOUT_DEL.equals(type)) {
			BopAccDs dbBopAccDs = rootdao.query(BopAccDs.class, bopAccDs.getId());

			/**
			 * 校验当前数据是否已经被其他用户更新
			 */
			if(!StringUtils.equals(bopAccDs.getRecStatus(), dbBopAccDs.getRecStatus())){
				ExceptionUtil.throwCommonException("账号["+bopAccDs.getAccountno()+"]已经被其他用户修改");
			}


			//判断是否已产生大于该发生日期的数据，提示不能操作
			Integer count = rootdao.queryByHqlToCount(" SELECT COUNT(model) FROM BopAccDs model WHERE model.dealDate > '" + DateUtil.dateToNumber(gi.getTxdate()) +
					"' AND model.brNo = '" + gi.getBrno() + "' ");
			if (count > 0){
				ExceptionUtil.throwCommonException("topreport.bopaccds.editordelete.exits.predealdate.data");
			}
			dbBopAccDs.setLstUpdTlr(gi.getTlrno());
			dbBopAccDs.setLstUpdTm(new Date());
			dbBopAccDs.setActiondesc(bopAccDs.getActiondesc());
			dbBopAccDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopAccDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopAccDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopAccDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopAccDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopAccDs.getApptype(), dbBopAccDs.getCurrentfile(), dbBopAccDs.getId(), dbBopAccDs.getFileNumber(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopAccDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopAccDs);
		}
	}

	@SuppressWarnings("unchecked")
	private void checkBalance(ROOTDAO rootdao,
			BopAccDs newBopAccDs) throws CommonException {

		if (null != newBopAccDs.getCredit() || null != newBopAccDs.getDebit()){
			Object[] values = new Object[]{newBopAccDs.getAccountno(),newBopAccDs.getCurrencyCode(),newBopAccDs.getBranchCode(), TopReportConstants.REPORT_RECSTATUS_07, newBopAccDs.getCurrentfile(),newBopAccDs.getAccountno(),newBopAccDs.getCurrencyCode(),newBopAccDs.getBranchCode(), TopReportConstants.REPORT_RECSTATUS_07, newBopAccDs.getCurrentfile(), newBopAccDs.getDealDate()};
			List<BopAccDs>balanceList = rootdao.queryByQL2List(" FROM BopAccDs WHERE accountno = ? AND currencyCode = ? AND branchCode = ? AND recStatus <> ? AND currentfile = ? AND dealDate = ( SELECT MAX(dealDate) FROM BopAccDs WHERE accountno = ? AND currencyCode = ? AND branchCode = ? AND recStatus <> ? AND currentfile = ? AND dealDate < ?  )", values, null);
			if(!balanceList.isEmpty()){
				BopAccDs balance = balanceList.get(0);
				checkBalance(balance, newBopAccDs);
			} else {
				checkBalance(newBopAccDs);
			}
		}
	}

	public static void checkBalance(BopAccDs balance,BopAccDs newBopAccDs) throws CommonException{
		BigDecimal todaybalance = new BigDecimal("0.00");
		if(null != newBopAccDs.getCredit()) {
			todaybalance = balance.getBalance().add(newBopAccDs.getCredit());
		}
		if (null != newBopAccDs.getDebit()) {
			todaybalance = todaybalance.subtract(newBopAccDs.getDebit());
		}
		if(!todaybalance.equals(newBopAccDs.getBalance())) {
			ExceptionUtil.throwCommonException("上日余额加上当日贷方发生额减去当日借方发生额不等于当日余额");
		}
	}

	public static void checkBalance(BopAccDs newBopAccDs) throws CommonException{
		BigDecimal todaybalance = new BigDecimal("0.00");
		if(null != newBopAccDs.getCredit()) {
			todaybalance = newBopAccDs.getCredit();
		}
		if (null != newBopAccDs.getDebit()) {
			todaybalance = todaybalance.subtract(newBopAccDs.getDebit());
		}
		if(!todaybalance.equals(newBopAccDs.getBalance())) {
			ExceptionUtil.throwCommonException("上日余额加上当日贷方发生额减去当日借方发生额不等于当日余额");
		}
	}

	/**
	 * 审批外汇账户相关信息
	 * @param approveStatusChoose
	 * @param approveResultChoose
	 * @param bopAccDsList
	 * @param opAdAudit
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public void auditAccDs(String approveStatusChoose,
			String approveResultChoose, List<BopAccDs> bopAccDsList,
			String opAdAudit) throws CommonException {
		// opAdAudit 业务逻辑没有不同 此参数待用
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List<String> bopAccDsIds = new ArrayList<String>();
		for(BopAccDs bopAccDs : bopAccDsList){
			bopAccDsIds.add(bopAccDs.getId());
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = " FROM BopAccDs model WHERE model.id IN " + ReportUtils.toInString(bopAccDsIds);
		List<BopAccDs> dbBopAccDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}

		for (BopAccDs bopAccDs : dbBopAccDsList) {
			bopAccDs.setLstUpdTlr(gi.getTlrno());
			bopAccDs.setLstUpdTm(new Date());
			bopAccDs.setApproveResult(approveResultChoose);
			bopAccDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopAccDs.setApproveStatus(approveStatusChoose);
			bopAccDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			rootdao.saveOrUpdate(bopAccDs);

			if(bopAccDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopAccDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopAccDs.getApptype(), bopAccDs.getCurrentfile(), bopAccDs.getId(), bopAccDs.getFileNumber(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, bopAccDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopAccDs.getApptype(), bopAccDs.getCurrentfile(), bopAccDs.getId(), bopAccDs.getFileNumber(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}
		}
	}

	public PageQueryResult queryBopAccDsGen(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qactiontype, String qaccountstat, String qaccountno) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopAccDs model where ");
		hql.append(" model.apptype=? and model.currentfile=? and model.recStatus=? and model.workDate=?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_ACC);
		if (queryType.equals("AD")) {
			objs.add("CA");
		} else {
			objs.add("CB");
		}
		objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		objs.add(gi.getFileDate());
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" and model.brNo=?");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" and model.actiontype=?");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qaccountstat)) {
			hql.append(" and model.accountstat=?");
			objs.add(qaccountstat);
		}
		if (!DataFormat.isEmpty(qaccountno)) {
			hql.append(" and model.accountno LIKE ?");
			objs.add("%" + qaccountno + "%");
		}
		hql.append(" order by model.lstUpdTm desc");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}

	public PageQueryResult queryBopAccDsQuery(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qactiontype, String qrecStatus,
			String qapproveStatus, String qrepStatus, String qaccountstat,
			String qaccountno, String qstartDate, String qendDate) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopAccDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_ACC);
		if (queryType.equals("AD")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_ACC_CA);
		} else {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_ACC_CB);
		}
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qaccountno)) {
			hql.append(" AND model.accountno LIKE ? ");
			objs.add("%" + qaccountno + "%");
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qaccountstat)) {
			hql.append(" AND model.accountstat = ? ");
			objs.add(qaccountstat);
		}
		if (!DataFormat.isEmpty(qstartDate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qstartDate);
		}
		if (!DataFormat.isEmpty(qendDate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qendDate);
		}
		hql.append(" ORDER BY model.workDate, model.actiontype, model.approveStatus DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}
}