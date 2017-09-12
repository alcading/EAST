package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BOPForDebtBilLoanCreditor;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

@SuppressWarnings("unchecked")
public class BOPForDebtBondBillGetter extends BaseGetter {

	/**
	 * 删除操作
	 */
	private static final String DELETE_CMD = "del";
	/**
	 * 新建操作
	 */
	private static final String NEW_CMD = "new";
	/**
	 * 更新操作
	 */
	private static final String MOD_CMD = "mod";
	/**
	 * 查询明细操作
	 */
	private static final String DETAILE_CMD = "detaile";

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "债券和票据签约信息查询");
			PageQueryResult queryResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(
					queryResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {

		String op = getCommQueryServletRequest().getParameter("op");
		if (StringUtils.equals(NEW_CMD, op)) {

			BOPForDebtBilLoanCreditor bopcfa = new BOPForDebtBilLoanCreditor();

			bopcfa.setCrtTm(new Date());

			//应用类型 CFA-资本项目
			bopcfa.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			//文件类型 AK - 外债债券和票据—签约信息
			bopcfa.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AK);
			//操作状态=A-创建
			bopcfa.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			//记录状态=02-编辑待确认
			bopcfa.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			//审核状态=00-未审核
			bopcfa.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			//回执状态=00-未返回
			bopcfa.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			//是否已成功上报=0-否
			bopcfa.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

			/** 债权人类型代码，见境外主体类型代码表。“债券和票据”类外债的债权人类型代码统一填报为“资本市场”。 */
			bopcfa.setCreditortype("20001800");

			bopcfa.setExdebtcode(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_CFA_AK));
			ReportUtils.setObjectPro(bopcfa, TopReportConstants.REPORT_FILE_TYPE_CFA_AK);

			GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
			bopcfa.setDebtorcode(ginfo.getBrno());// 设置债权人代码
			bopcfa.setLstUpdTlr(ginfo.getTlrno());

			List<BOPForDebtBilLoanCreditor> list = new ArrayList<BOPForDebtBilLoanCreditor>(1);
			list.add(bopcfa);
			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(list);
			queryResult.setTotalCount(list.size());
			return queryResult;
		} else if (StringUtils.equals(MOD_CMD, op) || StringUtils.equals(DELETE_CMD, op) || StringUtils.equals(DETAILE_CMD, op)) {
			String id = getCommQueryServletRequest().getParameter("id");
			BOPForDebtBilLoanCreditor bop = getDebtCreditor(id);
			List<BOPForDebtBilLoanCreditor> list = new ArrayList<BOPForDebtBilLoanCreditor>();
			if (null != bop) {
				if(StringUtils.equals(op, MOD_CMD)){
					if (StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO, bop.getSubSuccess())) {
						bop.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					} else {
						bop.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
					}
				} else if(StringUtils.equals(op, DELETE_CMD)){
					bop.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
				}
				if (StringUtils.equals(op, MOD_CMD)
						|| StringUtils.equals(op, DELETE_CMD)){
					bop.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bop.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bop.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bop.setActiondesc(null);
				}
				list.add(bop);
			}
			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(list);
			queryResult.setTotalCount(list.size());
			return queryResult;
		} else {

			StringBuilder hql = new StringBuilder(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");

			String qWorkDateStart = getCommQueryServletRequest().getParameter("qWorkDateStart");
			String qWorkDateEnd = getCommQueryServletRequest().getParameter("qWorkDateEnd");
			String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");
			String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");
			String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");
			String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");
			String filler2 = getCommQueryServletRequest().getParameter("filler2");

			List<Object>paramentList = new ArrayList<Object>();
			if (StringUtils.isNotBlank(qWorkDateStart)) {
				hql.append(" AND bds.workDate >= ? ");
				paramentList.add(qWorkDateStart);
			}
			if (StringUtils.isNotBlank(qWorkDateEnd)) {
				hql.append(" AND bds.workDate <= ? ");
				paramentList.add(qWorkDateEnd);
			}
			if (StringUtils.isNotBlank(qActiontype)) {
				hql.append(" AND bds.actiontype = ? ");
				paramentList.add(qActiontype);
			}
			if (StringUtils.isNotBlank(qRecStatus)) {
				hql.append(" AND bds.recStatus = ? ");
				paramentList.add(qRecStatus);
			}
			if (StringUtils.isNotBlank(qApproveStatus)) {
				hql.append(" AND bds.approveStatus = ? ");
				paramentList.add(qApproveStatus);
			}
			if (StringUtils.isNotBlank(qRepStatus)) {
				hql.append(" AND bds.repStatus = ? ");
				paramentList.add(qRepStatus);
			}
			if (StringUtils.isNotBlank(filler2)) {
				hql.append(" AND bds.filler2 LIKE ? ");
				paramentList.add("%"+filler2+"%");
			}

			//只查询应用类型 为 资本项目
			hql.append(" AND bds.apptype = ? ");
			paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			//只查询文件类型 为 债券和票据
			hql.append(" AND bds.currentfile = ? ");
			paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AK);
			//只查询记录状态为可编辑何编辑待确认的记录
			hql.append(" AND (bds.recStatus = ? OR  bds.recStatus = ? ) ");
			paramentList.add(TopReportConstants.REPORT_RECSTATUS_01);
			paramentList.add(TopReportConstants.REPORT_RECSTATUS_02);
			//只查询当前分行数据
			GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
			String brno = ginfo.getBrno();
			if (StringUtils.isNotBlank(brno)) {
				hql.append(" AND brNo = ? ");
				paramentList.add(brno);
			}
			hql.append(" ORDER BY bds.lstUpdTm DESC,bds.workDate, bds.actiontype, bds.approveStatus DESC ");

			// 分页大小
			int pageSize = getResult().getPage().getEveryPage();
			// 页码
			int pageIndex = getResult().getPage().getCurrentPage();

			PageQueryCondition queryCondition = new PageQueryCondition();
			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);
			queryCondition.setQueryString(hql.toString());
			queryCondition.setObjArray(paramentList.toArray());
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			return rootdao.pageQueryByQL(queryCondition);
		}
	}

	private BOPForDebtBilLoanCreditor getDebtCreditor(String id)
			throws CommonException {

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		BopCfaExdebtDs exdebtds = rootdao.query(BopCfaExdebtDs.class, id);

		StringBuilder query = new StringBuilder(" FROM BopCfaCreditorDs WHERE recId = ? ");
		List<BopCfaCreditorDs>creditorList = rootdao.queryByQL2List(query.toString(), new Object[]{id}, null);

		BOPForDebtBilLoanCreditor bop = new BOPForDebtBilLoanCreditor();
		if(null != exdebtds){
			bop.setId(exdebtds.getId());
			bop.setApptype(exdebtds.getApptype());
			bop.setCurrentfile(exdebtds.getCurrentfile());
			bop.setExdebtcode(exdebtds.getExdebtcode());
			bop.setDebtorcode(exdebtds.getDebtorcode());
			bop.setDebtype(exdebtds.getDebtype());
			bop.setDebtyperema(exdebtds.getDebtyperema());
			bop.setContractdate(exdebtds.getContractdate());
			bop.setValuedate(exdebtds.getValuedate());
			bop.setContractcurr(exdebtds.getContractcurr());

			bop.setContractamount(exdebtds.getContractamount());

			bop.setMaturity(exdebtds.getMaturity());
			bop.setFloatrate(exdebtds.getFloatrate());
			bop.setAnninrate(exdebtds.getAnninrate());
			bop.setInprterm(exdebtds.getInprterm());
			bop.setSpapfeboindex(exdebtds.getSpapfeboindex());
			bop.setRemark(exdebtds.getRemark());
			bop.setLstUpdTlr(exdebtds.getLstUpdTlr());
			bop.setLstUpdTm(exdebtds.getLstUpdTm());
			bop.setCrtTm(exdebtds.getCrtTm());
			bop.setFiller1(exdebtds.getFiller1());
			bop.setBrNo(exdebtds.getBrNo());
			bop.setActiontype(exdebtds.getActiontype());
			bop.setActiondesc(exdebtds.getActiondesc());
			bop.setRecStatus(exdebtds.getRecStatus());
			bop.setRepStatus(exdebtds.getRepStatus());
			bop.setApproveStatus(exdebtds.getApproveStatus());
			bop.setApproveResult(exdebtds.getApproveResult());
			bop.setWorkDate(exdebtds.getWorkDate());
			bop.setSubSuccess(exdebtds.getSubSuccess());
			bop.setBuscode(exdebtds.getBuscode());
			bop.setFiller2(exdebtds.getFiller2());
			bop.setIsincode(exdebtds.getIsincode());

		}

		if(!creditorList.isEmpty()){
			BopCfaCreditorDs creditor = creditorList.get(0);
			bop.setCreditorid(creditor.getId());
			bop.setCreditorcode(creditor.getCreditorcode());
			bop.setCreditorname(creditor.getCreditorname());
			bop.setCreditornamen(creditor.getCreditornamen());
			bop.setCreditorca(creditor.getCreditorca());
			bop.setCreditortype(creditor.getCreditortype());
			bop.setCrehqcode(creditor.getCrehqcode());
			bop.setOpercode(creditor.getOpercode());
			bop.setRecId(creditor.getRecId());
		}
		return bop;
	}
}