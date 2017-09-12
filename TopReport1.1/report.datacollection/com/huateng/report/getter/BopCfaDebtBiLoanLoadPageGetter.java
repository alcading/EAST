package com.huateng.report.getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BOPForDebtBilLoanCreditor;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BopCfaDebtBiLoanLoadPageGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();
//			ResultMng.fillResultByList(getCommonQueryBean(),
//					getCommQueryServletRequest(), queryResult, getResult());
//			result.setContent(queryResult);
//			result.getPage().setTotalPage(0);
//			result.init();
//			return result;

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
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

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();

		String currentFile =  getCommQueryServletRequest().getParameter("currentFile");
		String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");

		String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");
		String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");

		String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");
		String qFiller2 = getCommQueryServletRequest().getParameter("qFiller2");

		String qStartDate = getCommQueryServletRequest().getParameter("qStartDate");
		String qEndDate = getCommQueryServletRequest().getParameter("qEndDate");


		StringBuffer hql = new StringBuffer("");
		// 获取外债信息表、债权人信息表记录 以外债id left join on
		hql.append(" SELECT bds.REC_ID,bds.apptype, bds.currentfile,bds.exdebtcode, bds.debtorcode,bds.debtype,");
		hql.append("        bds.debtyperema, bds.contractdate, bds.valuedate,bds.contractcurr,bds.contractamount,");
		hql.append("        bds.maturity,bds.floatrate, bds.anninrate, bds.inprterm, bds.spapfeboindex,bds.remark,");
		hql.append("        bds.lst_Upd_Tlr,bds.lst_Upd_Tm,bds.crt_Tm, bds.filler1, bds.br_No,bds.actiontype,");
		hql.append("        bds.actiondesc,bds.rec_Status,bds.rep_Status, bds.approve_Status,");
		hql.append("        bds.approve_Result, bds.work_Date,bds.is_sub_Success,bcd.creditor_id,");
		hql.append("        bcd.creditorcode, bcd.creditorname, bcd.creditornamen,");
		hql.append("        bcd.creditorca,bcd.creditortype, bcd.crehqcode,");
		hql.append("        bcd.opercode, bcd.rec_Id,bds.BUSCODE,bds.debtyperema,bds.isincode,bpi.projectname,bpi.proj_id,bds.appname,bds.appcode,bds.filler2,bds.inpriamount ");
		hql.append(" FROM   BOP_CFA_EXDEBT_DS bds LEFT JOIN BOP_CFA_CREDITOR_DS bcd ON bds.REC_ID = bcd.REC_ID LEFT JOIN BOP_PROJECT_INFO bpi ON bds.REC_ID = bpi.REC_ID WHERE 1 = 1 ");

		List<Object>paramentList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(qActiontype)) {
			hql.append(" AND bds.actiontype = ? ");
			paramentList.add(qActiontype);
		}
		if (StringUtils.isNotBlank(qRecStatus)) {
			hql.append(" AND bds.rec_Status = ? ");
			paramentList.add(qRecStatus);
		}
		if (StringUtils.isNotBlank(qApproveStatus)) {
			hql.append(" AND bds.approve_Status = ? ");
			paramentList.add(qApproveStatus);
		}
		if (StringUtils.isNotBlank(qRepStatus)) {
			hql.append(" AND bds.rep_Status = ? ");
			paramentList.add(qRepStatus);
		}
		if (StringUtils.isNotBlank(qFiller2)) {
			hql.append(" AND bds.filler2 LIKE ? ");
			paramentList.add("%" + qFiller2 + "%");
		}
		if (StringUtils.isNotBlank(qStartDate)) {
			hql.append(" AND bds.work_Date >= ? ");
			paramentList.add(qStartDate);
		}
		if (StringUtils.isNotBlank(qEndDate)) {
			hql.append(" AND bds.work_Date <= ? ");
			paramentList.add(qEndDate);
		}

		hql.append(" AND bds.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);

		hql.append(" AND bds.currentfile = ? ");
		paramentList.add(currentFile);

		hql.append(" AND bds.actiontype <> ? ");
		paramentList.add(TopReportConstants.REPORT_ACTIONTYPE_D);

		hql.append(" AND bds.br_No = ? ");
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		paramentList.add(gInfo.getBrno());

		hql.append(" ORDER BY bds.REC_ID, bds.work_Date,bds.actiontype, bds.approve_Status DESC");


		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(paramentList.toArray());

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		PageQueryResult result = rootdao.pageQueryBySQL(queryCondition);


		String rec_id="";
		BOPForDebtBilLoanCreditor bop = null;
		List<BOPForDebtBilLoanCreditor> list = new ArrayList<BOPForDebtBilLoanCreditor>();
		// 将取得的数据放入到 BOPForDebtBilLoanCreditor bean中
		for (Iterator<Object[]>it = result.getQueryResult().iterator(); it.hasNext();) {
			bop = new BOPForDebtBilLoanCreditor();
			Object[] queryArray = it.next();
			if(!((String)queryArray[0]).equals(rec_id))
			{
				rec_id = (String) queryArray[0];
				bop.setId((String) queryArray[0]);
				bop.setApptype((String) queryArray[1]);
				bop.setCurrentfile((String) queryArray[2]);
				bop.setExdebtcode((String) queryArray[3]);
				bop.setDebtorcode((String) queryArray[4]);
				bop.setDebtype((String) queryArray[5]);
				bop.setDebtyperema((String) queryArray[6]);
				bop.setContractdate((String) queryArray[7]);
				bop.setValuedate((String) queryArray[8]);
				bop.setContractcurr((String) queryArray[9]);

				bop.setContractamount((BigDecimal) queryArray[10]);

				bop.setMaturity((String) queryArray[11]);
				bop.setFloatrate((String) queryArray[12]);
				bop.setAnninrate((BigDecimal) queryArray[13]);
				bop.setInprterm((String) queryArray[14]);
				bop.setSpapfeboindex((String) queryArray[15]);
				bop.setRemark((String) queryArray[16]);
				bop.setLstUpdTlr((String) queryArray[17]);
				bop.setLstUpdTm((Date) queryArray[18]);
				bop.setCrtTm((Date) queryArray[19]);
				bop.setFiller1((String) queryArray[20]);
				bop.setBrNo((String) queryArray[21]);
				bop.setActiontype((String) queryArray[22]);
				bop.setActiondesc((String) queryArray[23]);
				bop.setRecStatus((String) queryArray[24]);
				bop.setRepStatus((String) queryArray[25]);
				bop.setApproveStatus((String) queryArray[26]);
				bop.setApproveResult((String) queryArray[27]);
				bop.setWorkDate((String) queryArray[28]);
				bop.setSubSuccess((String) queryArray[29]);
				bop.setCreditorid((String) queryArray[30]);
				bop.setCreditorcode((String) queryArray[31]);
				bop.setCreditorname((String) queryArray[32]);
				bop.setCreditornamen((String) queryArray[33]);
				bop.setCreditorca((BigDecimal) queryArray[34]);
				bop.setCreditortype((String) queryArray[35]);
				bop.setCrehqcode((String) queryArray[36]);
				bop.setOpercode((String) queryArray[37]);
				bop.setRecId((String) queryArray[38]);
				bop.setBuscode((String) queryArray[39]);
				bop.setDebtyperema((String) queryArray[40]);
				bop.setIsincode((String) queryArray[41]);
				bop.setProjectname((String) queryArray[42]);
				bop.setProjid((String) queryArray[43]);
				bop.setAppname((String) queryArray[44]);
				bop.setAppcode((String) queryArray[45]);
				bop.setFiller2((String) queryArray[46]);
				bop.setInpriamount((BigDecimal) queryArray[47]);
				list.add(bop);
			}
		}
		result.setQueryResult(list);
		return result;
	}
}