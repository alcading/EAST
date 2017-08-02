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
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForSameInduDepositBean;
import com.huateng.report.constants.TopReportConstants;

public class BOPForDebtBalanceInfoGetter extends BaseGetter{

	private static final String ADD_RECORD="new";
	private static final String MOD_RECORD="mod";
	private static final String DEL_RECORD="del";
	private static final String DETAIL_RECORD = "detail";

	public Result call() throws AppException {

		try {
			PageQueryResult queryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债-变动信息补录-变动信息查询");

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债买方信贷补录变动信息页面查询");

			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	@SuppressWarnings("unchecked")
	private PageQueryResult getData() throws AppException
	{
		String op = getCommQueryServletRequest().getParameter("op");
		String id = getCommQueryServletRequest().getParameter("id");
		if(id == "") {
			ExceptionUtil.throwCommonException("没有符合条件的记录", new Object[]{ getCommQueryServletRequest().getParameter("qCurrencyCode"),getCommQueryServletRequest().getParameter("qCurrencyName")});
		}

		BopForSameInduDepositBean bop = new BopForSameInduDepositBean();
		List<BopForSameInduDepositBean> list = new ArrayList<BopForSameInduDepositBean>();

		if(StringUtils.equals(ADD_RECORD, op)){
			list.add(bop);
			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(list);
			queryResult.setTotalCount(list.size());
			return queryResult;
		}else if(StringUtils.equals(MOD_RECORD, op)  || StringUtils.equals(DEL_RECORD, op) || StringUtils.equals(DETAIL_RECORD, op)){

//			StringBuffer hql = new StringBuffer();
//			hql.append(" SELECT bds.REC_ID, bds.exdebtcode,bds.limit_Type,bds.debtorcode,bds.debtype,bds.valuedate,");
//			hql.append("        bds.contractcurr,bds.floatrate,bds.anninrate,bds.spapfeboindex,bds.remark, bds.work_Date,");
//			hql.append("        bds.crt_Tm,bds.lst_Upd_Tm,bds.lst_Upd_Tlr,bds.apptype,bds.currentfile,bds.actiontype,");
//			hql.append("        bds.rec_Status,bds.approve_Status,bds.rep_Status,bds.is_sub_Success,");
//			hql.append("        bcd.creditor_id,bcd.creditorcode, bcd.creditorname, bcd.creditornamen,bcd.creditortype,");
//			hql.append("        bcd.crehqcode,bcd.opercode,bcd.REC_ID,");
//			hql.append("        bds.filler1,bds.buscode,bds.changeno,bds.accoamount,bds.chdate,bds.filler2");
//			hql.append("   FROM BOP_CFA_EXDEBT_DS bds LEFT JOIN BOP_CFA_CREDITOR_DS bcd ON bds.REC_ID = bcd.REC_ID WHERE 1 = 1 " );


			//加载变动信息并获取filler1
			//取得filler1
//			String filler1Id = "";

			ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
			BopCfaExdebtDs bopBalanceDs = rootDao.query(BopCfaExdebtDs.class, id);

//			if(null != bopBalanceDs)
//			{
//				filler1Id = bopBalanceDs.getFiller1();
//			}

//			hql.append(" AND bds.REC_ID ='").append(filler1Id).append("'");

			//将变动信息set benan BOPForDebtBilLoanCreditor
			bop.setId(bopBalanceDs.getId());
			bop.setApptype(bopBalanceDs.getApptype());
			bop.setCurrentfile(bopBalanceDs.getCurrentfile());

			bop.setBuscode(bopBalanceDs.getBuscode());
			bop.setChangeno(bopBalanceDs.getChangeno());
			bop.setAccoamount(bopBalanceDs.getAccoamount());
			bop.setChdate(bopBalanceDs.getChdate());


			bop.setFiller1(bopBalanceDs.getFiller1());
			bop.setRemark(bopBalanceDs.getRemark());
			bop.setLstUpdTlr(bopBalanceDs.getLstUpdTlr());
			bop.setLstUpdTm(bopBalanceDs.getLstUpdTm());
			bop.setCrtTm(bopBalanceDs.getCrtTm());
			bop.setActiontype(bopBalanceDs.getActiontype());
			bop.setActiondesc(bopBalanceDs.getActiondesc());
			bop.setRecStatus(bopBalanceDs.getRecStatus());
			bop.setRepStatus(bopBalanceDs.getRepStatus());
			bop.setApproveStatus(bopBalanceDs.getApproveStatus());
			bop.setApproveResult(bopBalanceDs.getApproveResult());
			bop.setWorkDate(bopBalanceDs.getWorkDate());
			bop.setSubSuccess(bopBalanceDs.getSubSuccess());
			bop.setFiller2(bopBalanceDs.getFiller2());


			BopCfaExdebtDs exdebtds = rootDao.query(BopCfaExdebtDs.class, bopBalanceDs.getFiller1());

			if (null != exdebtds) {
				bop.setExdebtcode(exdebtds.getExdebtcode());
				bop.setDebtorcode(exdebtds.getDebtorcode());
				bop.setDebtype(exdebtds.getDebtype());
				bop.setValuedate(exdebtds.getValuedate());
				bop.setContractcurr(exdebtds.getContractcurr());
				bop.setFloatrate(exdebtds.getFloatrate());
				bop.setAnninrate(exdebtds.getAnninrate());
				bop.setSpapfeboindex(exdebtds.getSpapfeboindex());
				bop.setFiller2Oth(exdebtds.getFiller2());

				List<BopCfaCreditorDs>creditorList = rootDao.queryByQL2List(" FROM BopCfaCreditorDs WHERE recId = ? ", new Object[]{bopBalanceDs.getFiller1()}, null);

				if(!creditorList.isEmpty()){
					BopCfaCreditorDs creditor = creditorList.get(0);
					bop.setCreditorid(creditor.getId());
					bop.setCreditorcode(creditor.getCreditorcode());
					bop.setCreditorname(creditor.getCreditorname());
					bop.setCreditornamen(creditor.getCreditornamen());
					bop.setCreditortype(creditor.getCreditortype());
					bop.setCrehqcode(creditor.getCrehqcode());
					bop.setOpercode(creditor.getOpercode());
					bop.setRecId(creditor.getRecId());
				}

			}


//			for(Iterator it = rootDao.queryBySQL(hql.toString()) ;  it.hasNext(); )
//			{
//				Object[] queryArray = (Object[]) it.next();
//				bop.setExdebtcode((String)queryArray[1]);
//				bop.setDebtorcode((String)queryArray[3]);
//				bop.setDebtype((String)queryArray[4]);
//				bop.setValuedate((String)queryArray[5]);
//				bop.setContractcurr((String)queryArray[6]);
//				bop.setFloatrate((String)queryArray[7]);
//				bop.setAnninrate((BigDecimal) queryArray[8]);
//				bop.setSpapfeboindex((String)queryArray[9]);
//
//				bop.setSubSuccess((String)queryArray[21]);
//				bop.setCreditorid((String)queryArray[22]);
//				bop.setCreditorcode((String)queryArray[23]);
//				bop.setCreditorname((String)queryArray[24]);
//				bop.setCreditornamen((String)queryArray[25]);
//				bop.setCreditortype((String)queryArray[26]);
//				bop.setCrehqcode((String)queryArray[27]);
//				bop.setOpercode((String)queryArray[28]);
//				bop.setRecId((String)queryArray[29]);
//				bop.setFiller2Oth((String)queryArray[35]);
//
//				list.add(bop);
//			}
			list.add(bop);
		 	PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(list);
			queryResult.setTotalCount(list.size());
			return queryResult;
		} else {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "余额信息查询");
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
			//
			int pageSize = getResult().getPage().getEveryPage();
			//页码
			int pageIndex = getResult().getPage().getCurrentPage();

			PageQueryCondition queryCondition = new PageQueryCondition();

			StringBuffer hql = new StringBuffer(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");

			String balanceFileType=  getCommQueryServletRequest().getParameter("balanceFileType");

			String qWorkDateStart = getCommQueryServletRequest().getParameter("qWorkDateStart");
			String qWorkDateEnd = getCommQueryServletRequest().getParameter("qWorkDateEnd");
			String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");

			String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");
			String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");

			String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");
			String qFiller2 = getCommQueryServletRequest().getParameter("qFiller2");


			List<Object>paramentList = new ArrayList<Object>();
			if (StringUtils.isNotBlank(qWorkDateStart)) {
				hql.append(" AND bds.workDate >= ? ");
				paramentList.add(qWorkDateStart);
			}
			if (StringUtils.isNotBlank(qWorkDateEnd)) {
				hql.append(" AND bds.workDate <= ? ");
				paramentList.add(qWorkDateEnd);
			}
			if(StringUtils.isNotBlank(qActiontype))
			{
				hql.append(" AND bds.actiontype = ? ");
				paramentList.add(qActiontype);
			}
			if(StringUtils.isNotBlank(qRecStatus))
			{
				hql.append(" AND bds.recStatus = ? ");
				paramentList.add(qRecStatus);
			}
			if(StringUtils.isNotBlank(qApproveStatus))
			{
				hql.append(" AND bds.approveStatus = ? ");
				paramentList.add(qApproveStatus);
			}
			if(StringUtils.isNotBlank(qRepStatus))
			{
				hql.append(" AND bds.repStatus = ? ");
				paramentList.add(qRepStatus);
			}
			if(StringUtils.isNotBlank(qFiller2))
			{
				hql.append(" AND bds.filler2 LIKE ? ");
				paramentList.add("%"+qFiller2+"%");
			}
			hql.append(" AND bds.apptype = ? ");
			paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);

			hql.append(" AND bds.currentfile = ? ");
			paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);

			hql.append(" AND bds.balanceFileType = ? ");
			paramentList.add(balanceFileType);

			hql.append(" AND bds.brNo = ? ");
			paramentList.add(gInfo.getBrno());

			hql.append(" AND  (bds.recStatus = ? OR bds.recStatus = ? ) ");
			paramentList.add(TopReportConstants.REPORT_RECSTATUS_01);
			paramentList.add(TopReportConstants.REPORT_RECSTATUS_02);

			hql.append(" ORDER BY bds.lstUpdTm DESC,bds.workDate, bds.actiontype, bds.approveStatus DESC");

			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);
			queryCondition.setQueryString(hql.toString());
			queryCondition.setObjArray(paramentList.toArray());
			return  rootdao.pageQueryByQL(queryCondition);
		}
	}
}