package com.huateng.report.getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForSameInduDepositBean;

public class BopForSameInduDepositBalancceInfoColGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		List queryList = getList();
		if(queryList.isEmpty()){
			ExceptionUtil.throwCommonException("没有符合条件的记录", new Object[]{ getCommQueryServletRequest().getParameter("qCurrencyCode"),getCommQueryServletRequest().getParameter("qCurrencyName")});
		}
		ResultMng.fillResultByList(getCommonQueryBean(), 
				getCommQueryServletRequest(), 
				queryList,
				getResult());
		result.setContent(queryList);
		result.getPage().setTotalPage(0);
		result.init();
		return result;
	}
	private List getList() throws CommonException{
		String op = getCommQueryServletRequest().getParameter("op");
		String id = getCommQueryServletRequest().getParameter("id");
		if(id =="" ){
			ExceptionUtil.throwCommonException("没有符合条件的记录", new Object[]{ getCommQueryServletRequest().getParameter("qCurrencyCode"),getCommQueryServletRequest().getParameter("qCurrencyName")});
		}
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		BopForSameInduDepositBean bop = new BopForSameInduDepositBean();	
		List<BopForSameInduDepositBean> list = new ArrayList<BopForSameInduDepositBean>();
		
		if("newBalance".equalsIgnoreCase(op)){
			list.add(bop);
		}else if("modBalance".equalsIgnoreCase(op)  || "delBalance".equalsIgnoreCase(op) || "detailBalance".equalsIgnoreCase(op)){
			 PageQueryCondition pc = new PageQueryCondition();
			
			 StringBuffer hql = new StringBuffer();
			 hql.append(" SELECT bds.REC_ID, bds.exdebtcode,bds.limit_Type,bds.debtorcode,bds.debtype,bds.valuedate,");
		     hql.append("        bds.contractcurr,bds.floatrate,bds.anninrate,bds.spapfeboindex,bds.remark, bds.work_Date,");
		     hql.append("        bds.crt_Tm,bds.lst_Upd_Tm,bds.lst_Upd_Tlr,bds.apptype,bds.currentfile,bds.actiontype,");
		     hql.append("       bds.rec_Status,bds.approve_Status,bds.rep_Status,bds.is_sub_Success,");
		     hql.append("       bcd.creditor_id,bcd.creditorcode, bcd.creditorname, bcd.creditornamen,bcd.creditortype,");
		     hql.append("       bcd.crehqcode,bcd.opercode,bcd.REC_ID,");
		     hql.append("        bds.filler1,bds.buscode,bds.changeno,bds.accoamount,bds.chdate,bds.filler2");
		     hql.append("   FROM BOP_CFA_EXDEBT_DS bds LEFT JOIN BOP_CFA_CREDITOR_DS bcd ON bds.REC_ID = bcd.REC_ID WHERE 1 = 1 " );
				

				//加载变动信息并获取filler1
				//取得filler1
				String filler1Id = "";
				BopCfaExdebtDs bopBalanceDs = rootDao.query(BopCfaExdebtDs.class, id);
				
				if(null != bopBalanceDs)
				{
					filler1Id = bopBalanceDs.getFiller1();
				}

				hql.append(" AND bds.REC_ID ='").append(filler1Id).append("'");
				
				 pc.setQueryString(hql.toString());
				
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
		 	 
			
		 	
		 	for(Iterator it = rootDao.queryBySQL(hql.toString()) ;  it.hasNext(); )
			{
				Object[] queryArray = (Object[]) it.next();
				//bop.setId((String)queryArray[0]);
				bop.setExdebtcode((String)queryArray[1]);
				//bop.setLimitType((String)queryArray[2]);
				bop.setDebtorcode((String)queryArray[3]);
				bop.setDebtype((String)queryArray[4]);
				bop.setValuedate((String)queryArray[5]);
				bop.setContractcurr((String)queryArray[6]);
				bop.setFloatrate((String)queryArray[7]);
				bop.setAnninrate((BigDecimal) queryArray[8]);
				bop.setSpapfeboindex((String)queryArray[9]);
				
//				bop.setRemark((String)queryArray[10]);
//				bop.setWorkDate((String)queryArray[11]);
//				bop.setCrtTm((Date)queryArray[12]);
//				bop.setLstUpdTm((Date)queryArray[13]);
//				bop.setLstUpdTlr((String)queryArray[14]);
//				bop.setApptype((String)queryArray[15]);
//				bop.setCurrentfile((String)queryArray[16]);
//				bop.setActiontype((String)queryArray[17]);
//				bop.setRecStatus((String)queryArray[18]);
//				bop.setApproveStatus((String)queryArray[19]);
//				bop.setRepStatus((String)queryArray[20]);
				bop.setSubSuccess((String)queryArray[21]);
				bop.setCreditorid((String)queryArray[22]);
				bop.setCreditorcode((String)queryArray[23]);
				bop.setCreditorname((String)queryArray[24]);
				bop.setCreditornamen((String)queryArray[25]);
				bop.setCreditortype((String)queryArray[26]);
				bop.setCrehqcode((String)queryArray[27]);
				bop.setOpercode((String)queryArray[28]);
				bop.setRecId((String)queryArray[29]);
				bop.setFiller2Oth((String)queryArray[35]);
				//bop.setFiller1((String)queryArray[31]);
//				bop.setBuscode((String)queryArray[32]);
//				bop.setChangeno((String)queryArray[33]);
				//bop.setAccoamount((String)queryArray[34]);
				//bop.setChdate((String)queryArray[35]);
				
				list.add(bop);
			}

			return list;
		}
		return list;
	}
		
}
