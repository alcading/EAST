package com.huateng.report.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaDofoexloDs;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopCfaDofoexloDsService {

	/*
	 * 获得自身实例
	 */
	public synchronized static BopCfaDofoexloDsService getInstance() {
		return (BopCfaDofoexloDsService) ApplicationContextUtils
				.getBean(BopCfaDofoexloDsService.class.getName());
	}

	/**
	 * 查询记录状态01-可编辑 和 02-编辑待确认 的记录
	 * @param pageIndex
	 * @param pageSize
	 * @param currentfile
	 * @param workDate
	 * @param actiontype
	 * @param recStatus
	 * @param approveStatus
	 * @param repStatus
	 * @param dofoexlocode
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult pageQueryByEdit(int pageIndex, int pageSize, String currentfile,
			String qstartDate ,String qendDate, String actiontype, String recStatus,
			String approveStatus, String repStatus, String filler2, String brno)
			throws CommonException {

		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaDofoexloDs WHERE currentfile = ? AND recStatus IN (?, ?) ");

		List<Object> paraList = new ArrayList<Object>();
		paraList.add(currentfile);
		paraList.add(TopReportConstants.REPORT_RECSTATUS_01);
		paraList.add(TopReportConstants.REPORT_RECSTATUS_02);

		if (StringUtils.isNotBlank(actiontype)) {
			queryhql.append(" AND actiontype = ? ");
			paraList.add(actiontype);
		}
		if (StringUtils.isNotBlank(recStatus)) {
			queryhql.append(" AND recStatus = ? ");
			paraList.add(recStatus);
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			queryhql.append(" AND approveStatus = ? ");
			paraList.add(approveStatus);
		}
		if (StringUtils.isNotBlank(repStatus)) {
			queryhql.append(" AND repStatus = ? ");
			paraList.add(repStatus);
		}
		if (StringUtils.isNotBlank(filler2)) {
			queryhql.append(" AND filler2 LIKE ? ");
			paraList.add("%" + filler2 + "%");
		}
		if (StringUtils.isNotBlank(brno)) {
			queryhql.append(" AND brNo = ? ");
			paraList.add(brno);
		}
		if(StringUtils.isNotBlank(qstartDate)) {
			queryhql.append(" AND workDate >= ? ");
			paraList.add(qstartDate);
		}
		if(StringUtils.isNotBlank(qendDate)) {
			queryhql.append(" AND workDate <= ? ");
			paraList.add(qendDate);
		}

		queryhql.append(" ORDER BY lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(queryhql.toString());
		queryCondition.setObjArray(paraList.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult result = hqlDAO.pageQueryByQL(queryCondition);
		return result;
	}

	/**
	 * 查询记录状态为03-待审核 和 04-待审核确认 记录
	 * @param pageIndex
	 * @param pageSize
	 * @param currentfile
	 * @param workDate
	 * @param actiontype
	 * @param recStatus
	 * @param approveStatus
	 * @param repStatus
	 * @param dofoexlocode
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult pageQueryByAudit(int pageIndex, int pageSize, String currentfile,
			String qstartDate,String qendDate, String actiontype, String recStatus,
			String approveStatus, String repStatus, String filler2, String brno)
			throws CommonException {

		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaDofoexloDs WHERE currentfile = ? AND recStatus IN (? , ?) ");

		List<Object> paraList = new ArrayList<Object>();
		paraList.add(currentfile);
		paraList.add(TopReportConstants.REPORT_RECSTATUS_03);
		paraList.add(TopReportConstants.REPORT_RECSTATUS_04);

		if (StringUtils.isNotBlank(actiontype)) {
			queryhql.append(" AND actiontype = ? ");
			paraList.add(actiontype);
		}
		if (StringUtils.isNotBlank(recStatus)) {
			queryhql.append(" AND recStatus = ? ");
			paraList.add(recStatus);
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			queryhql.append(" AND approveStatus = ? ");
			paraList.add(approveStatus);
		}
		if (StringUtils.isNotBlank(repStatus)) {
			queryhql.append(" AND repStatus = ? ");
			paraList.add(repStatus);
		}
		if (StringUtils.isNotBlank(filler2)) {
			queryhql.append(" AND filler2 LIKE ? ");
			paraList.add("%" + filler2 + "%");
		}
		if (StringUtils.isNotBlank(brno)) {
			queryhql.append(" AND brNo = ? ");
			paraList.add(brno);
		}
		if(StringUtils.isNotBlank(qstartDate)) {
			queryhql.append(" AND workDate >= ? ");
			paraList.add(qstartDate);
		}
		if(StringUtils.isNotBlank(qendDate)) {
			queryhql.append(" AND workDate <= ? ");
			paraList.add(qendDate);
		}

		queryhql.append(" ORDER BY lstUpdTm DESC,workDate, actiontype, approveStatus DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(queryhql.toString());
		queryCondition.setObjArray(paraList.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult result = hqlDAO.pageQueryByQL(queryCondition);
		return result;
	}

	public PageQueryResult pageQueryByAlreadyAudit(int pageIndex, int pageSize, String currentfile,
			String workDate, String actiontype, String recStatus,
			String approveStatus, String repStatus, String qfiller2, String brno)
			throws CommonException {

		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaDofoexloDs WHERE currentfile = ? AND recStatus = ? ");

		List<Object> paraList = new ArrayList<Object>();
		paraList.add(currentfile);
		paraList.add(TopReportConstants.REPORT_RECSTATUS_05);

		PageQueryResult result = pageQueryByHql(pageIndex, pageSize,
				workDate, actiontype, recStatus, approveStatus,
				repStatus, qfiller2, brno, queryhql, paraList, null, null);
		return result;
	}

//	private PageQueryResult pageQueryByHql11(int pageIndex, int pageSize,
//			String workDate, String actiontype, String recStatus,
//			String approveStatus, String repStatus, String qfiller2,
//			String brno, StringBuilder queryhql, List<Object> paraList)
//			throws CommonException {
//
//		if (StringUtils.isNotBlank(workDate)) {
//			queryhql.append(" AND workDate = ? ");
//			paraList.add(workDate);
//		}
//		if (StringUtils.isNotBlank(actiontype)) {
//			queryhql.append(" AND actiontype = ? ");
//			paraList.add(actiontype);
//		}
//		if (StringUtils.isNotBlank(recStatus)) {
//			queryhql.append(" AND recStatus = ? ");
//			paraList.add(recStatus);
//		}
//		if (StringUtils.isNotBlank(approveStatus)) {
//			queryhql.append(" AND approveStatus = ? ");
//			paraList.add(approveStatus);
//		}
//		if (StringUtils.isNotBlank(repStatus)) {
//			queryhql.append(" AND repStatus = ? ");
//			paraList.add(repStatus);
//		}
//		if (StringUtils.isNotBlank(qfiller2)) {
//			queryhql.append(" AND filler2 LIKE ? ");
//			paraList.add("%" + qfiller2 + "%");
//		}
//
//		if (StringUtils.isNotBlank(brno)) {
//			queryhql.append(" AND brNo = ? ");
//			paraList.add(brno);
//		}
//
//		PageQueryCondition queryCondition = new PageQueryCondition();
//		queryCondition.setQueryString(queryhql.toString());
//		queryCondition.setObjArray(paraList.toArray());
//		queryCondition.setPageIndex(pageIndex);
//		queryCondition.setPageSize(pageSize);
//		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
//		PageQueryResult result = hqlDAO.pageQueryByQL(queryCondition);
//		return result;
//	}

	private PageQueryResult pageQueryByHql(int pageIndex, int pageSize,
			String workDate, String actiontype, String recStatus,
			String approveStatus, String repStatus, String filler2,
			String brno, StringBuilder queryhql, List<Object> paraList, String startDate, String endDate)
			throws CommonException {

		if (StringUtils.isNotBlank(workDate)) {
			queryhql.append(" AND workDate = ? ");
			paraList.add(workDate);
		}
		if (StringUtils.isNotBlank(actiontype)) {
			queryhql.append(" AND actiontype = ? ");
			paraList.add(actiontype);
		}
		if (StringUtils.isNotBlank(recStatus)) {
			queryhql.append(" AND recStatus = ? ");
			paraList.add(recStatus);
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			queryhql.append(" AND approveStatus = ? ");
			paraList.add(approveStatus);
		}
		if (StringUtils.isNotBlank(repStatus)) {
			queryhql.append(" AND repStatus = ? ");
			paraList.add(repStatus);
		}
		if (StringUtils.isNotBlank(filler2)) {
			queryhql.append(" AND filler2 LIKE ? ");
			paraList.add("%" + filler2 + "%");
		}
		if (StringUtils.isNotBlank(brno)) {
			queryhql.append(" AND brNo = ? ");
			paraList.add(brno);
		}
		if(StringUtils.isNotBlank(startDate)) {
			queryhql.append(" AND workDate >= ? ");
			paraList.add(startDate);
		}
		if(StringUtils.isNotBlank(endDate)) {
			queryhql.append(" AND workDate <= ? ");
			paraList.add(endDate);
		}

		queryhql.append(" ORDER BY lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(queryhql.toString());
		queryCondition.setObjArray(paraList.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult result = hqlDAO.pageQueryByQL(queryCondition);
		return result;
	}


	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize, String currentfile,
			String workDate, String actiontype, String recStatus,
			String approveStatus, String repStatus, String filler2, String brno, String startDate, String endDate)
			throws CommonException {

		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaDofoexloDs WHERE currentfile = ? ");

		List<Object> paraList = new ArrayList<Object>();
		paraList.add(currentfile);

		PageQueryResult result = pageQueryByHql(pageIndex, pageSize,
				workDate, actiontype, recStatus, approveStatus,
				repStatus, filler2, brno, queryhql, paraList, startDate, endDate);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public BopCfaDofoexloDs load(String uuid) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(
				" FROM BopCfaDofoexloDs WHERE id = ? ", new Object[] { uuid },
				null);
		if (!list.isEmpty()) {
			return (BopCfaDofoexloDs) list.get(0);
		}
		return null;
	}

	public BopCfaDofoexloDs loadChangeInfo(String uuid) throws CommonException{
		BopCfaDofoexloDs bopcfa = load(uuid);
		if(null != bopcfa){
			BopCfaDofoexloDs parent = load(bopcfa.getFiller1());
			if(null != parent){
				setChildByParent(bopcfa, parent);
			}
		}
		return bopcfa;
	}

	public void update(BopCfaDofoexloDs bopcfa) throws CommonException {
		bopcfa.setActiondesc(null);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(), bopcfa.getCurrentfile(), bopcfa);

		rootdao.update(bopcfa);
	}

	@SuppressWarnings("rawtypes")
	public void updateChangeInfo(BopCfaDofoexloDs bopcfa) throws CommonException {
		bopcfa.setActiondesc(null);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao
				.queryByQL2List(
						" FROM BopCfaDofoexloDs WHERE currentfile = ? AND id <> ? AND filler1 = ? AND actiontype <> ? AND TO_DATE(changedate, 'yyyyMMdd') = (SELECT MAX(TO_DATE(changedate, 'yyyyMMdd')) FROM BopCfaDofoexloDs WHERE filler1 = ? AND actiontype <> ? ) ",
						new Object[] {
								TopReportConstants.REPORT_FILE_TYPE_CFA_CB,
								bopcfa.getId(), bopcfa.getFiller1(),
								TopReportConstants.REPORT_ACTIONTYPE_D,
								bopcfa.getFiller1(),
								TopReportConstants.REPORT_ACTIONTYPE_D }, null);
		if (!list.isEmpty()) {
			BopCfaDofoexloDs lastreportdata = (BopCfaDofoexloDs) list.get(0);
			if (bopcfa.getLoanopenbalan().compareTo(
					lastreportdata.getEndbalan()) != 0) {
				ExceptionUtil.throwCommonException("[期初余额]必须等于[上期末余额]");
			}
		}
		list = rootdao.queryByQL2List(
				" FROM BopCfaDofoexloDs WHERE currentfile = ? AND id = ? ",
				new Object[] { TopReportConstants.REPORT_FILE_TYPE_CFA_CA,
						bopcfa.getFiller1() }, null);
		if (!list.isEmpty()) {
			BopCfaDofoexloDs lastreportdata = (BopCfaDofoexloDs) list.get(0);
			Date valuedate = DateUtil.get20Date(lastreportdata.getValuedate());
			Date changedate = DateUtil.get20Date(bopcfa.getChangedate());
			if (valuedate.compareTo(changedate) > 0) {
				ExceptionUtil.throwCommonException("[变动日期]大于等于[起息日]");
			}
		}

		StringBuilder hql = new StringBuilder(
				" SELECT COUNT(*) FROM BopCfaDofoexloDs WHERE currentfile = '")
				.append(bopcfa.getCurrentfile()).append("' AND buscode = '")
				.append(bopcfa.getBuscode()).append("' ")
				.append(" AND id <> '").append(bopcfa.getId()).append(
						"' AND actiontype <> '").append(
						TopReportConstants.REPORT_ACTIONTYPE_D).append("' ");
		int count = rootdao.queryByHqlToCount(hql.toString());
		if (0 < count) {
			ExceptionUtil.throwCommonException("已有相同银行业务参号的记录");
		}
		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(), bopcfa.getCurrentfile(), bopcfa);

		setFieldNull(bopcfa);

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		rootdao.update(bopcfa);
	}

	public void setChildByParent(BopCfaDofoexloDs chield, BopCfaDofoexloDs parent){
		chield.setDebtorcode(parent.getDebtorcode());
		chield.setCreditorcode(parent.getCreditorcode());
		chield.setDebtorname(parent.getDebtorname());
		chield.setValuedate(parent.getValuedate());
		chield.setDofoexlotype(parent.getDofoexlotype());
		chield.setMaturity(parent.getMaturity());
		chield.setLenproname(parent.getLenproname());
		chield.setCurrence(parent.getCurrence());
		chield.setLenagree(parent.getLenagree());
		chield.setContractamount(parent.getContractamount());
		chield.setAnninrate(parent.getAnninrate());
	}

	public void delete(BopCfaDofoexloDs bopcfa) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int count = rootdao
				.queryByHqlToCount(" SELECT COUNT(*) FROM BopCfaDofoexloDs WHERE filler1 = '"
						+ bopcfa.getId()
						+ "' AND currentfile = '"
						+ TopReportConstants.REPORT_FILE_TYPE_CFA_CB
						+ "' AND recStatus <> '"
						+ TopReportConstants.REPORT_RECSTATUS_07 + "' ");
		if (0 < count) {
			ExceptionUtil.throwCommonException("该签约信息存在变动信息不可删除");
		}

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		rootdao.update(bopcfa);
	}

	public void deleteChangeInfo(BopCfaDofoexloDs bopcfa) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		rootdao.update(bopcfa);
	}

	public void save(BopCfaDofoexloDs bopcfa) throws CommonException {

		bopcfa.setId(ReportUtils.getUUID());
		bopcfa.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		bopcfa.setCrtTm(new Date());

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(), bopcfa.getCurrentfile(), bopcfa);

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		rootdao.save(bopcfa);
	}


	@SuppressWarnings("rawtypes")
	public void saveChangeInfo(BopCfaDofoexloDs bopcfa) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		bopcfa.setId(ReportUtils.getUUID());
		bopcfa.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		bopcfa.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
		bopcfa.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_CB);
		bopcfa.setCrtTm(new Date());

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		List list = rootdao
				.queryByQL2List(
						" FROM BopCfaDofoexloDs WHERE currentfile = ? AND filler1 = ? AND actiontype <> ? AND TO_DATE(changedate, 'yyyyMMdd') = (SELECT MAX(TO_DATE(changedate, 'yyyyMMdd')) FROM BopCfaDofoexloDs WHERE filler1 = ? AND actiontype <> ? ) ",
						new Object[] {TopReportConstants.REPORT_FILE_TYPE_CFA_CB, bopcfa.getFiller1(), TopReportConstants.REPORT_ACTIONTYPE_D, bopcfa.getFiller1() , TopReportConstants.REPORT_ACTIONTYPE_D},
						null);
		if (!list.isEmpty()) {
			BopCfaDofoexloDs lastreportdata = (BopCfaDofoexloDs) list.get(0);
			if (bopcfa.getLoanopenbalan().compareTo(
					lastreportdata.getEndbalan()) != 0) {
				ExceptionUtil.throwCommonException("[期初余额]必须等于[上期末余额]");
			}
		}

		list = rootdao.queryByQL2List(" FROM BopCfaDofoexloDs WHERE currentfile = ? AND id = ? ", new Object[] {TopReportConstants.REPORT_FILE_TYPE_CFA_CA, bopcfa.getFiller1()}, null);
		if(!list.isEmpty()){
			BopCfaDofoexloDs lastreportdata = (BopCfaDofoexloDs) list.get(0);
			Date valuedate = DateUtil.get20Date(lastreportdata.getValuedate());
			Date changedate = DateUtil.get20Date(bopcfa.getChangedate());
			if(valuedate.compareTo(changedate) > 0){
				ExceptionUtil.throwCommonException("[变动日期]大于等于[起息日]");
			}
		}

		StringBuilder hql = new StringBuilder(
				" SELECT COUNT(*) FROM BopCfaDofoexloDs WHERE currentfile = '")
				.append(bopcfa.getCurrentfile()).append("' AND buscode = '")
				.append(bopcfa.getBuscode()).append("' AND actiontype <> '")
				.append(TopReportConstants.REPORT_ACTIONTYPE_D).append("' ");
		int count = rootdao.queryByHqlToCount(hql.toString());
		if (0 < count) {
			ExceptionUtil.throwCommonException("已有相同银行业务参号的记录");
		}

		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(), bopcfa.getCurrentfile(), bopcfa);

		rootdao.save(bopcfa);
		setFieldNull(bopcfa);


	}

	private void setFieldNull(BopCfaDofoexloDs bopcfa){
		bopcfa.setDebtorcode(null);
		bopcfa.setCreditorcode(null);
		bopcfa.setDebtorname(null);
		bopcfa.setValuedate(null);
		bopcfa.setDofoexlotype(null);
		bopcfa.setMaturity(null);
		bopcfa.setLenproname(null);
		bopcfa.setCurrence(null);
		bopcfa.setLenagree(null);
		bopcfa.setContractamount(null);
		bopcfa.setAnninrate(null);
	}

	public void approved(List<BopCfaDofoexloDs> bopcfaList)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		Date currentdate = new Date();
		for (BopCfaDofoexloDs bopcfa : bopcfaList) {
			bopcfa.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopcfa.setLstUpdTlr(ginfo.getTlrno());
			bopcfa.setLstUpdTm(currentdate);
			rootdao.update(bopcfa);
		}
	}
}