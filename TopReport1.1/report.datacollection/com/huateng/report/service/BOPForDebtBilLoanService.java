package com.huateng.report.service;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bean.BopForDebtFeiOrgSave;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

/**
 * BOP_CFA_EXDEBT_DS :外债信息表   增加、删除、查询、更新
 * @author cwenao
 * @version 1.0
 * 2012-8-28
 * */
public class BOPForDebtBilLoanService  {

	private static final String DATASET_ID="com.huateng.report.service.BOPForDebtBilLoanService";

	public synchronized static BOPForDebtBilLoanService getInstance() {
		return (BOPForDebtBilLoanService) ApplicationContextUtils.getBean(DATASET_ID);
	}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	public BopCfaExdebtDs load(String id) throws CommonException {

		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		return (BopCfaExdebtDs)rootDao.query(BopCfaExdebtDs.class, id);
	}

	public void delete(BopCfaExdebtDs bpExdebt) throws CommonException {

		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		BopCfaExdebtDs bpExdebtTemp = (BopCfaExdebtDs) rootDao.query(BopCfaExdebtDs.class, bpExdebt.getId());

		if (null == bpExdebtTemp) {
			ExceptionUtil.throwCommonException("当前记录不存在！");
		} else {
		    rootDao.saveOrUpdate(bpExdebt);
		}
	}

	public void save(BopCfaExdebtDs bpExdebt) throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		ReportDataVaildUtil.executeVaild(bpExdebt.getApptype(), bpExdebt.getCurrentfile(), bpExdebt);
		rootDao.save(bpExdebt);
	}

	public void update(BopCfaExdebtDs bpExdebt) throws CommonException  {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		ReportDataVaildUtil.executeVaild(bpExdebt.getApptype(), bpExdebt.getCurrentfile(), bpExdebt);
		rootDao.saveOrUpdate(bpExdebt);
	}
	/**
	 *
	 * 查询上报文件生成界面
	 *
	 * */
	public PageQueryResult queryGenRecordAD(int pageIndex, int pageSize, String qactiontype,
			String brNo,String qFiller2,String apptype,String currentfile,String changFileType) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");
		hql.append(" model.apptype=? and model.currentfile=? and model.recStatus=? and model.workDate=? ");

		objs.add(apptype);
		objs.add(currentfile);
		objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		objs.add(gi.getFileDate());

		if (!DataFormat.isEmpty(changFileType)) {
			hql.append(" and model.changeFileType=?  ");
			objs.add(changFileType);
		}

		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" and model.actiontype=?");
			objs.add(qactiontype);
		}

		if (!DataFormat.isEmpty(brNo)) {
			hql.append(" and model.brNo=?");
			objs.add(brNo);
		}
		if (!DataFormat.isEmpty(qFiller2)) {
			hql.append(" and model.filler2=?");
			objs.add(qFiller2);
		}

		hql.append(" order by model.lstUpdTm desc");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);

	}
	/**
	 * 9-20
	 * 带有起止日期的补录查询界面
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 *
	 * */
	@SuppressWarnings("rawtypes")
	public PageQueryResult queryRecordADMod(int pageIndex, int pageSize, String qworkDateBegin, String qworkDateOver,String qactiontype,
			String brNo,String qFiller2,String qapproveStatus, String qrecStatus,String qrepStatus,String apptype,String currentfile,String changFileType) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? ");
		objs.add(apptype);
		objs.add(currentfile);
//		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		if (!DataFormat.isEmpty(changFileType)) {
			hql.append(" AND model.changeFileType = ? ");
			objs.add(changFileType);
		}

		if(!DataFormat.isEmpty(qworkDateBegin)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qworkDateBegin);
		}
		if(!DataFormat.isEmpty(qworkDateOver)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qworkDateOver);
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
		if (!DataFormat.isEmpty(brNo)) {
			hql.append(" AND model.brNo = ? ");
			objs.add(brNo);
		}
		if (!DataFormat.isEmpty(qFiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qFiller2 + "%");
		}
		hql.append(" ORDER BY model.lstUpdTm DESC");

		PageQueryCondition queryCondition = new PageQueryCondition();

		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);
		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
				debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
				debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
				debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
				debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
				debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
				debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
				debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
				debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}
	/**
	 *
	 * 补录查询界面
	 *
	 * */
	@SuppressWarnings("rawtypes")
	public PageQueryResult queryRecordAD(int pageIndex, int pageSize, String qWorkDateStart,String qWorkDateEnd, String qactiontype,
			String brNo,String qFiller2,String qapproveStatus, String qrecStatus,String qrepStatus,String apptype,String currentfile,String changFileType) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? ");
		objs.add(apptype);
		objs.add(currentfile);
//		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		if (!DataFormat.isEmpty(changFileType))
		{
			hql.append(" AND model.changeFileType = ? ");
			objs.add(changFileType);
		}

		if(StringUtils.isNotBlank(qWorkDateStart))
		{
			hql.append(" AND model.workDate >= '"+qWorkDateStart+"' ");
		}
		if(StringUtils.isNotBlank(qWorkDateEnd))
		{
			hql.append(" AND model.workDate <= '"+qWorkDateEnd+"' ");
		}
		if (!DataFormat.isEmpty(qactiontype))
		{
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus))
		{
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus))
		{
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus))
		{
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(brNo))
		{
			hql.append(" AND model.brNo = ? ");
			objs.add(brNo);
		}
		if (!DataFormat.isEmpty(qFiller2))
		{
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%"+qFiller2+"%");
		}
		hql.append(" ORDER BY model.lstUpdTm DESC");

		PageQueryCondition queryCondition = new PageQueryCondition();

		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult pageQueryResult = rootdao.pageQueryByQL(queryCondition);

		//把excel的项目信息放到projectname字段里
		List list = pageQueryResult.getQueryResult();
		for(Object o : list) {
			Object[] objss = (Object[])o;
			BopCfaExdebtDs ds = (BopCfaExdebtDs) objss[0];
			ds.setProjectname(ReportCommonService.getInstance().getProjectNamesToStr(ds.getId()));
		}
		//excel债权人信息
		for(Object o : list) {
			Object[] objss = (Object[])o;
			BopCfaExdebtDs ds = (BopCfaExdebtDs) objss[0];
			//creditorcode 债权人代码  creditorname 债权人中文名称 creditornamen 债权人英文名称
			//creditortype 债权人类型代码 crehqcode 债权人总部所在国家（地区）代码  opercode  债权人经营地所在国家（地区）代码
			String hqlCreditor = " FROM BopCfaCreditorDs ds WHERE ds.recId = '"+ds.getId()+"' ";
			List creditors = rootdao.queryByQL2List(hqlCreditor);
			for(Object o2 : creditors) {
				BopCfaCreditorDs creditor = (BopCfaCreditorDs)o2;
				ds.setCreditorcode(creditor.getCreditorcode());
				ds.setCreditorname(creditor.getCreditorname());
				ds.setCreditornamen(creditor.getCreditornamen());
				ds.setCreditortype(creditor.getCreditortype());
				ds.setCrehqcode(creditor.getCrehqcode());
				ds.setOpercode(creditor.getOpercode());
			}
		}
		return pageQueryResult;
	}

	/**
	 *
	 * 补录查询界面
	 *
	 * */
	public PageQueryResult queryRecordAD(int pageIndex, int pageSize, String qWorkDate, String qactiontype,
			String brNo,String qFiller2,String qapproveStatus, String qrecStatus,String qrepStatus,String apptype,String currentfile,String changFileType) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");
		hql.append(" model.apptype=? and model.currentfile=? ");
		objs.add(apptype);
		objs.add(currentfile);

		if (!DataFormat.isEmpty(changFileType)) {
			hql.append(" and model.changeFileType=?  ");
			objs.add(changFileType);
		}

		if(StringUtils.isNotBlank(qWorkDate))
		  {
			 hql.append(" and model.workDate ='"+qWorkDate+"'");

		  }
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" and model.actiontype=?");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" and model.recStatus=?");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" and model.approveStatus=?");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" and model.repStatus=?");
			objs.add(qrepStatus);
		}

		if (!DataFormat.isEmpty(brNo)) {
			hql.append(" and model.brNo=?");
			objs.add(brNo);
		}
		if (!DataFormat.isEmpty(qFiller2)) {
			hql.append(" and model.filler2=?");
			objs.add(qFiller2);
		}
		hql.append(" order by model.lstUpdTm desc");


		PageQueryCondition queryCondition = new PageQueryCondition();

		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		return rootdao.pageQueryByQL(queryCondition);

	}
	/**
	 * 审批双边贷款签约信息相关信息
	 * @param approveStatusChoose
	 * @param approveResultChoose
	 * @param bopAccDsList
	 * @param opAdAudit
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public void auditBopCfaExdebtDs(String approveStatusChoose, String approveResultChoose, List<BopCfaExdebtDs> bopCfaExdebtDsList, String opDebtAudit) throws CommonException {
		// opAdAudit 业务逻辑没有不同 此参数待用
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List<String> bopCfaExdebtDsIds = new ArrayList<String>();
		for(BopCfaExdebtDs bopCfaExdebtDs : bopCfaExdebtDsList){
			bopCfaExdebtDsIds.add(bopCfaExdebtDs.getId());
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = " FROM BopCfaExdebtDs model WHERE model.id IN " + ReportUtils.toInString(bopCfaExdebtDsIds);
		List<BopCfaExdebtDs> dbbopCfaExdebtDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}

		for (BopCfaExdebtDs bopCfaExdebtDs : dbbopCfaExdebtDsList) {
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setLstUpdTm(new Date());
			bopCfaExdebtDs.setApproveResult(approveResultChoose);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopCfaExdebtDs.setApproveStatus(approveStatusChoose);
			rootdao.saveOrUpdate(bopCfaExdebtDs);

			if(bopCfaExdebtDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, bopCfaExdebtDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}
		}
	}
}