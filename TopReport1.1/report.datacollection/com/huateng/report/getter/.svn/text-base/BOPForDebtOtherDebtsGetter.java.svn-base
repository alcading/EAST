package com.huateng.report.getter;

import java.util.ArrayList;
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
public class BOPForDebtOtherDebtsGetter extends BaseGetter{

	private static final String DELETE_CMD="del";
	private static final String NEW_CMD="new";
	private static final String MOD_CMD="mod";
	private static final String DETAILE_CMD="detaile";

	public Result call() throws AppException {
		try {
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

	private PageQueryResult getData() throws AppException {

		String op = getCommQueryServletRequest().getParameter("op");

		if (StringUtils.equals(NEW_CMD, op)) {

			BOPForDebtBilLoanCreditor bop = new BOPForDebtBilLoanCreditor();

			bop.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bop.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bop.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bop.setRepStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bop.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);//没有成功上报
			bop.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			bop.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AQ);

			//生成外债编号，后6位用******代替
			bop.setExdebtcode(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_CFA_AQ));
			ReportUtils.setObjectPro(bop, TopReportConstants.REPORT_FILE_TYPE_CFA_AQ);
			GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
			bop.setDebtorcode(gInfo.getBrno());
			List<BOPForDebtBilLoanCreditor> list = new ArrayList<BOPForDebtBilLoanCreditor>();
			list.add(bop);

			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(list);
			queryResult.setTotalCount(list.size());
			return queryResult;
		} else if (StringUtils.equals(DETAILE_CMD, op) || StringUtils.equals(DELETE_CMD, op) || StringUtils.equals(MOD_CMD, op)) {
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

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债-其他外债补录-签约信息查询");

			StringBuffer hql = new StringBuffer(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");
			String qstartdate = getCommQueryServletRequest().getParameter("startdate");
			String qenddate = getCommQueryServletRequest().getParameter("enddate");
			String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");
			String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");
			String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");
			String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");
			String filler2 = getCommQueryServletRequest().getParameter("filler2");

			List<Object>paramentList = new ArrayList<Object>();
			if (StringUtils.isNotBlank(qstartdate)) {
				hql.append(" AND bds.workDate >= ? ");
				paramentList.add(qstartdate);
			}
			if (StringUtils.isNotBlank(qenddate)) {
				hql.append(" AND bds.workDate <= ? ");
				paramentList.add(qenddate);
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
				paramentList.add("%"+ filler2 +"%");
			}
			//只查询应用类型 为 资本项目
			hql.append(" AND bds.apptype = ? ");
			paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			//只查询文件类型 为 其他外债
			hql.append(" AND bds.currentfile = ? ");
			paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AQ);

			//只查询记录状态为可编辑何编辑待确认的记录
			hql.append(" AND  (bds.recStatus = ? OR  bds.recStatus = ? ) ");
			paramentList.add(TopReportConstants.REPORT_RECSTATUS_01);
			paramentList.add(TopReportConstants.REPORT_RECSTATUS_02);

			//只查询当前分行数据
			GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
			String brno = ginfo.getBrno();
			if (StringUtils.isNotBlank(brno)) {
				hql.append(" AND brNo = ? ");
				paramentList.add(brno);
			}

			hql.append(" ORDER BY bds.lstUpdTm DESC ");

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

	private BOPForDebtBilLoanCreditor getDebtCreditor(String id) throws CommonException {

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


//		StringBuffer hql = new StringBuffer("");
//		// 获取外债信息表、债权人信息表记录 以外债id left join on
//		hql.append(" SELECT bds.REC_ID,bds.apptype, bds.currentfile,bds.exdebtcode, bds.debtorcode,bds.debtype,");
//		hql.append("        bds.debtyperema, bds.contractdate, bds.valuedate,bds.contractcurr,bds.contractamount,");
//		hql.append("        bds.maturity,bds.floatrate, bds.anninrate, bds.inprterm, bds.spapfeboindex,bds.remark,");
//		hql.append("        bds.lst_Upd_Tlr,bds.lst_Upd_Tm,bds.crt_Tm, bds.filler1, bds.br_No,bds.actiontype,");
//		hql.append("        bds.actiondesc,bds.rec_Status,bds.rep_Status, bds.approve_Status,");
//		hql.append("        bds.approve_Result, bds.work_Date,bds.is_sub_Success,bcd.creditor_id,");
//		hql.append("        bcd.creditorcode, bcd.creditorname, bcd.creditornamen,");
//		hql.append("        bcd.creditorca,bcd.creditortype, bcd.crehqcode,");
//		hql.append("        bcd.opercode, bcd.rec_Id,bds.BUSCODE,bds.debtyperema,bpi.projectname,bpi.proj_id, bds.filler2 ");
//		hql.append("   FROM BOP_CFA_EXDEBT_DS bds LEFT JOIN BOP_CFA_CREDITOR_DS bcd ON bds.REC_ID = bcd.REC_ID ");
//		hql.append(" 		LEFT JOIN BOP_PROJECT_INFO bpi ON bds.REC_ID = bpi.REC_ID    WHERE 1 = 1 ");
//		hql.append(" 		AND bds.REC_ID = '").append(id).append("' ");
//
//		BOPForDebtBilLoanCreditor bop = new BOPForDebtBilLoanCreditor();
//		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//		// 将取得的数据放入到 BOPForDebtBilLoanCreditor bean中
//		for (Iterator it = rootdao.queryBySQL(hql.toString()); it.hasNext();) {
//			Object[] queryArray = (Object[]) it.next();
//			setValue(bop, queryArray);
//		}
//		return bop;
	}
}