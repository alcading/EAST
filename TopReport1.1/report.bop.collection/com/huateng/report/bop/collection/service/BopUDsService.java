package com.huateng.report.bop.collection.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import resource.bean.report.MtsBopInvcountrycode;
import resource.bean.report.MtsBopOpenAccount;
import resource.bean.report.MtsBopUDs;
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
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopUDsService {

	protected static final Logger logger = Logger.getLogger(BopUDsService.class);

	protected BopUDsService() {

	}

	public synchronized static BopUDsService getInstance() {
		return (BopUDsService) ApplicationContextUtils.getBean(BopUDsService.class.getName());
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
	public PageQueryResult queryBopUCollection(int pageIndex, int pageSize, String qstartDate, String qendDate,
			String qapproveStatus, String qrepStatus, String qrecStatus, String qcustcode) throws CommonException {
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" FROM MtsBopUDs WHERE ");
		hql.append(" apptype = ? AND currentfile = ? AND recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_U);
 		objs.add(TopReportConstants.REPORT_RECSTATUS_01);
		objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		if(!DataFormat.isEmpty(qstartDate)){
			hql.append(" AND workDate >= ? ");
			objs.add(qstartDate);
		}
		if(!DataFormat.isEmpty(qendDate)){
			hql.append(" AND workDate <= ? ");
			objs.add(qendDate);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qcustcode)){
			hql.append(" AND custcode LIKE ? ");
			objs.add("%" + qcustcode + "%");
		}
		hql.append(" ORDER BY lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.pageQueryByQL(queryCondition);
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
	public PageQueryResult queryBopUAudit(int pageIndex, int pageSize, String qstartDate, String qendDate,
			String qapproveStatus, String qrepStatus, String qrecStatus, String qcustcode) throws CommonException {
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" FROM MtsBopUDs WHERE ");
		hql.append(" apptype = ? AND currentfile = ? AND recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_U);
 		objs.add(TopReportConstants.REPORT_RECSTATUS_03);
		objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		if(!DataFormat.isEmpty(qstartDate)){
			hql.append(" AND workDate >= ? ");
			objs.add(qstartDate);
		}
		if(!DataFormat.isEmpty(qendDate)){
			hql.append(" AND workDate <= ? ");
			objs.add(qendDate);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qcustcode)){
			hql.append(" AND custcode LIKE ? ");
			objs.add("%" + qcustcode + "%");
		}
		hql.append(" ORDER BY lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.pageQueryByQL(queryCondition);
	}

	public PageQueryResult queryBopU(int pageIndex, int pageSize, String qstartDate, String qendDate,
			String qapproveStatus, String qrepStatus, String qrecStatus, String qbrno, String qcustcode, String qcustname) throws CommonException {
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" FROM MtsBopUDs WHERE ");
		hql.append(" apptype = ? AND currentfile = ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_U);
		if (!DataFormat.isEmpty(qstartDate)) {
			hql.append(" AND workDate >= ? ");
			objs.add(qstartDate);
		}
		if (!DataFormat.isEmpty(qendDate)) {
			hql.append(" AND workDate <= ? ");
			objs.add(qendDate);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qbrno)){
			hql.append(" AND brNo = ? ");
			objs.add(qbrno);
		}
		if (!DataFormat.isEmpty(qcustcode)) {
			hql.append(" AND custcode LIKE ? ");
			objs.add("%" + qcustcode + "%");
		}
		if (!DataFormat.isEmpty(qcustname)) {
			hql.append(" AND custname LIKE ? ");
			objs.add("%" + qcustname + "%");
		}
		hql.append(" ORDER BY lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.pageQueryByQL(queryCondition);
	}

	@SuppressWarnings("unchecked")
	public List<MtsBopInvcountrycode>loadInvcountrycode(String id) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.queryByQL2List(" FROM MtsBopInvcountrycode WHERE recId = ? ", new Object[]{id}, null);
	}

	@SuppressWarnings("unchecked")
	public List<MtsBopOpenAccount>loadOpenAccount(String id) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.queryByQL2List(" FROM MtsBopOpenAccount WHERE recId = ? ", new Object[]{id}, null);
	}

	public MtsBopUDs loadBopU(String id) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.query(MtsBopUDs.class, id);
	}

	@SuppressWarnings("deprecation")
	public void saveBopU(MtsBopUDs bopu, List<MtsBopInvcountrycode>countryList, List<MtsBopOpenAccount>openaccountList) throws CommonException{

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = " SELECT COUNT(*) FROM MtsBopUDs WHERE custcode = '" + bopu.getCustcode() + "' ";
		int count = rootdao.queryByHqlToCount(hql);
		if (0 < count) {
			ExceptionUtil.throwCommonException("已经存在相同组织机构代码的单位基本情况表",bopu.getApptype() + "_" + bopu.getCurrentfile() + "_ERR");
		}

		bopu.setId(ReportUtils.getUUID());
		/**
		 * 该字段不许上报，只是用于在单位基本情况表未上报至外管局时删除该记录
		 */
		bopu.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);

		bopu.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);
		bopu.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_U);
		bopu.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		bopu.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		bopu.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		bopu.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		bopu.setCrtTm(new Date());
		bopu.setCrtuser(gi.getTlrno());
		bopu.setLstUpdTm(new Date());
		bopu.setLstUpdTlr(gi.getTlrno());
		bopu.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
		bopu.setBrNo(gi.getBrno());

		ReportDataVaildUtil.executeVaild(bopu.getApptype(), bopu.getCurrentfile(), bopu);

		//数据处理记录表保存
		ReportCommonService commonService = ReportCommonService.getInstance();
		commonService.saveBiDataProcessLog(bopu.getApptype(), bopu.getCurrentfile(), bopu.getId(), bopu.getCustcode(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

		rootdao.save(bopu);
		for (MtsBopInvcountrycode country : countryList) {
			country.setId(ReportUtils.getUUID());
			country.setRecId(bopu.getId());
			rootdao.save(country);
		}
		for (MtsBopOpenAccount openaccount: openaccountList) {
			openaccount.setId(ReportUtils.getUUID());
			openaccount.setRecId(bopu.getId());
			rootdao.save(openaccount);
		}
	}

	public void updateBopU(MtsBopUDs bopu, List<MtsBopInvcountrycode>countryList, List<MtsBopOpenAccount>openaccountList,
			List<MtsBopInvcountrycode> modcountryList, List<MtsBopOpenAccount> modopenaccountList,
			List<MtsBopInvcountrycode> delcountryList, List<MtsBopOpenAccount> delopenaccountList) throws CommonException{

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		MtsBopUDs dbbopu = rootdao.query(MtsBopUDs.class, bopu.getId());

		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		dbbopu.setLstUpdTm(new Date());
		dbbopu.setLstUpdTlr(gi.getTlrno());
		dbbopu.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

		if(StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES, dbbopu.getSubSuccess())) {
			dbbopu.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
		} else if(StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO, dbbopu.getSubSuccess())) {
			dbbopu.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		}

		dbbopu.setCustcode(bopu.getCustcode());
		dbbopu.setCustname(bopu.getCustname());
		dbbopu.setAreacode(bopu.getAreacode());
		dbbopu.setCustaddr(bopu.getCustaddr());
		dbbopu.setPostcode(bopu.getPostcode());
		dbbopu.setIndustrycode(bopu.getIndustrycode());
		dbbopu.setAttrcode(bopu.getAttrcode());
		dbbopu.setCountrycode(bopu.getCountrycode());
		dbbopu.setIstaxfree(bopu.getIstaxfree());
		dbbopu.setTaxfreecode(bopu.getTaxfreecode());
		dbbopu.setEmail(bopu.getEmail());
		dbbopu.setRptmethod(bopu.getRptmethod());
		dbbopu.setEcexaddr(bopu.getEcexaddr());
		dbbopu.setRemarks(bopu.getRemarks());

		dbbopu.setInvcountry(bopu.getInvcountry());
		dbbopu.setBankinfos(bopu.getBankinfos());

		dbbopu.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbbopu.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbbopu.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

		ReportDataVaildUtil.executeVaild(dbbopu.getApptype(), dbbopu.getCurrentfile(), dbbopu);

		//数据处理记录表保存
		ReportCommonService commonService = ReportCommonService.getInstance();
		commonService.saveBiDataProcessLog(dbbopu.getApptype(), dbbopu.getCurrentfile(), dbbopu.getId(), dbbopu.getCustcode(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

		rootdao.update(dbbopu);
		for (MtsBopInvcountrycode country : countryList) {
			country.setId(ReportUtils.getUUID());
			country.setRecId(dbbopu.getId());
			rootdao.save(country);
		}
		for (MtsBopOpenAccount openaccount: openaccountList) {
			openaccount.setId(ReportUtils.getUUID());
			openaccount.setRecId(dbbopu.getId());
			rootdao.save(openaccount);
		}

		for (MtsBopInvcountrycode country : modcountryList) {
			if (null != country.getId()) {
				rootdao.update(country);
			}
		}
		for (MtsBopOpenAccount openaccount : modopenaccountList) {
			if (null != openaccount) {
				rootdao.update(openaccount);
			}
		}

		for (MtsBopInvcountrycode country : delcountryList) {
			if (null != country) {
				rootdao.delete(country);
			}
		}
		for (MtsBopOpenAccount openaccount : delopenaccountList) {
			if (null != openaccount) {
				rootdao.delete(openaccount);
			}
		}
	}

	public void deleteBopU(MtsBopUDs bopu) throws CommonException{

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		MtsBopUDs dbbopu = rootdao.query(MtsBopUDs.class, bopu.getId());

		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		dbbopu.setLstUpdTm(new Date());
		dbbopu.setLstUpdTlr(gi.getTlrno());
		dbbopu.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

		dbbopu.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		dbbopu.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		dbbopu.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		dbbopu.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

		//数据处理记录表保存
		ReportCommonService commonService = ReportCommonService.getInstance();
		commonService.saveBiDataProcessLog(dbbopu.getApptype(), dbbopu.getCurrentfile(), dbbopu.getId(), dbbopu.getCustcode(),
				TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "删除", "删除");

		rootdao.update(dbbopu);

	}

	@SuppressWarnings("unchecked")
	public void audit(List<MtsBopUDs>bopuList, String approveStatusChoose, String approveResultChoose) throws CommonException {
		List<String> bopuidList = new ArrayList<String>();
		for (MtsBopUDs bopu : bopuList) {
			bopuidList.add(bopu.getId());
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = " FROM MtsBopUDs model WHERE model.id IN " + ReportUtils.toInString(bopuidList);
		List<MtsBopUDs> dbBopUDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if(StringUtils.equals(TopReportConstants.REPORT_APPROVESTATUS_01, approveStatusChoose)) {
			approveStatusChooseName = "通过";
		} else if(StringUtils.equals(TopReportConstants.REPORT_APPROVESTATUS_02, approveStatusChoose)) {
			approveStatusChooseName = "不通过";
		}
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		for (MtsBopUDs bopUDs : dbBopUDsList) {
			bopUDs.setLstUpdTlr(gi.getTlrno());
			bopUDs.setLstUpdTm(new Date());
			bopUDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			bopUDs.setApproveResult(approveResultChoose);
			bopUDs.setApproveStatus(approveStatusChoose);

			bopUDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);

			rootdao.saveOrUpdate(bopUDs);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_BOP;
			String currentFile = TopReportConstants.REPORT_FILE_TYPE_BOP_U;
			String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT;

			String recId = bopUDs.getId();
			String custcode = bopUDs.getCustcode();
			String execResult = approveStatusChooseName;
			String execRemark = null;
			if(StringUtils.equals(bopUDs.getActiontype(), TopReportConstants.REPORT_ACTIONTYPE_D) && StringUtils.equals(bopUDs.getSubSuccess(), TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				execRemark = "删除成功";
			} else {
				execRemark = approveResultChoose;
			}
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(appType, currentFile, recId, custcode, execType, execResult, execRemark);
		}
	}
}