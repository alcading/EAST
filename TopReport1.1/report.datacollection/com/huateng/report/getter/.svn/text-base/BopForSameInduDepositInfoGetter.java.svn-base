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
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForSameInduDepositBean;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BopForSameInduDepositInfoGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws AppException
	{
		setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外同业存放补录信息签约信息查询");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();

		List<BopForSameInduDepositBean> list = new ArrayList<BopForSameInduDepositBean>();
		StringBuffer hql = new StringBuffer("");

		// 获取外债信息表、债权人信息表记录 以外债id left join on
		hql.append(" SELECT bds.REC_ID, bds.exdebtcode,bds.limit_Type,bds.debtorcode,bds.debtype,bds.valuedate,");
		hql.append("        bds.contractcurr,bds.floatrate,bds.anninrate,bds.spapfeboindex,bds.remark, bds.work_Date,");
		hql.append("        bds.crt_Tm,bds.lst_Upd_Tm,bds.lst_Upd_Tlr,bds.apptype,bds.currentfile,bds.actiontype,");
		hql.append("        bds.rec_Status,bds.approve_Status,bds.rep_Status,bds.is_sub_Success,");
		hql.append("        bcd.creditor_id,bcd.creditorcode, bcd.creditorname, bcd.creditornamen,bcd.creditortype,");
		hql.append("        bcd.crehqcode,bcd.opercode,bcd.REC_ID,bds.filler2,bds.actiondesc");
		hql.append("   FROM BOP_CFA_EXDEBT_DS bds LEFT JOIN BOP_CFA_CREDITOR_DS bcd ON bds.REC_ID = bcd.REC_ID WHERE 1 = 1 " );

		String qworkDateStart = getCommQueryServletRequest().getParameter("qworkDateStart");
		String qworkDateEnd = getCommQueryServletRequest().getParameter("qworkDateEnd");
		String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");

		String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
		String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");

		String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

		List<Object>paramentList = new ArrayList<Object>();
		if(StringUtils.isNotBlank(qworkDateStart) ){
			hql.append(" and bds.work_Date >= ? ");
			paramentList.add(qworkDateStart);
		}
		if(StringUtils.isNotBlank(qworkDateEnd)){
			hql.append("and  bds.work_Date <= ? ");
			paramentList.add(qworkDateEnd);
		}
		if(StringUtils.isNotBlank(qactiontype))
		{
			hql.append(" AND bds.actiontype = ? ");
			paramentList.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qrecStatus))
		{
			hql.append(" AND bds.rec_Status = ? ");
			paramentList.add(qrecStatus);
		}
		if(StringUtils.isNotBlank(qapproveStatus))
		{
			hql.append(" AND bds.approve_Status = ? ");
			paramentList.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus))
		{
			hql.append(" AND bds.rep_Status = ? ");
			paramentList.add(qrepStatus);
		}
		if(StringUtils.isNotBlank(qfiller2))
		{
			hql.append(" AND bds.filler2 LIKE ? ");
			paramentList.add("%"+qfiller2+"%");
		}

		hql.append(" AND (bds.rec_Status = ? OR  bds.rec_Status = ? )");
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_01);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_02);

		hql.append(" AND bds.currentfile = ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);

		hql.append(" AND bds.br_No = ? ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		paramentList.add(gi.getBrno());

		hql.append(" ORDER BY bds.lst_Upd_Tm DESC,bds.work_Date, bds.actiontype, bds.approve_Status DESC ");

		PageQueryCondition pc = new PageQueryCondition();
		pc.setPageIndex(pageIndex);
		pc.setPageSize(pageSize);
		pc.setQueryString(hql.toString());
		pc.setObjArray(paramentList.toArray());
		PageQueryResult pageResult = rootdao.pageQueryBySQL(pc);

		BopForSameInduDepositBean bop = null;
		for(Iterator it = pageResult.getQueryResult().iterator(); it.hasNext();)
		{
			bop = new BopForSameInduDepositBean();
			Object[] queryArray = (Object[]) it.next();
			bop.setId((String)queryArray[0]);
			bop.setExdebtcode((String)queryArray[1]);
			bop.setLimitType((String)queryArray[2]);
			bop.setDebtorcode((String)queryArray[3]);
			bop.setDebtype((String)queryArray[4]);
			bop.setValuedate((String)queryArray[5]);
			bop.setContractcurr((String)queryArray[6]);
			bop.setFloatrate((String)queryArray[7]);
			bop.setAnninrate((BigDecimal) queryArray[8]);
			bop.setSpapfeboindex((String)queryArray[9]);
			bop.setRemark((String)queryArray[10]);
			bop.setWorkDate((String)queryArray[11]);
			bop.setCrtTm((Date)queryArray[12]);
			bop.setLstUpdTm((Date)queryArray[13]);
			bop.setLstUpdTlr((String)queryArray[14]);
			bop.setApptype((String)queryArray[15]);
			bop.setCurrentfile((String)queryArray[16]);
			bop.setActiontype((String)queryArray[17]);
			bop.setRecStatus((String)queryArray[18]);
			bop.setApproveStatus((String)queryArray[19]);
			bop.setRepStatus((String)queryArray[20]);
			bop.setSubSuccess((String)queryArray[21]);
			bop.setCreditorid((String)queryArray[22]);
			bop.setCreditorcode((String)queryArray[23]);
			bop.setCreditorname((String)queryArray[24]);
			bop.setCreditornamen((String)queryArray[25]);
			bop.setCreditortype((String)queryArray[26]);
			bop.setCrehqcode((String)queryArray[27]);
			bop.setOpercode((String)queryArray[28]);
			bop.setRecId((String)queryArray[29]);
			bop.setFiller2((String)queryArray[30]);
			bop.setActiondesc((String)queryArray[31]);
			list.add(bop);
		}
		pageResult.setQueryResult(list);
		return  pageResult;
	}
}