package com.huateng.report.getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BOPForDebtBilLoanCreditor;
import com.huateng.report.utils.ReportUtils;


@SuppressWarnings("unchecked")
public class BOPForDebtChangeInfoColGetter extends BaseGetter {

	private static final String DELETE_CMD = "del";
	private static final String NEW_CMD = "new";
	private static final String MOD_CMD = "mod";
	private static final String DETAILE_CMD = "detaile";

	public Result call() throws AppException {
		try {
			List queryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult, getResult());

			result.setContent(queryResult);
			result.getPage().setTotalPage(0);
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
	private List getData() throws CommonException {

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		PageQueryCondition queryCondition = new PageQueryCondition();

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
		hql.append("        bcd.opercode, bcd.rec_Id,bds.BUSCODE,bds.changeno,bds.changtype,bds.chdate,bds.chcurrency,bds.chamount,bds.fairvalue, ");
		hql.append("   bds.debtyperema,bds.isincode,bds.filler2,bds.inpriamount ");
		hql.append("   FROM BOP_CFA_EXDEBT_DS bds LEFT JOIN BOP_CFA_CREDITOR_DS bcd ON bds.REC_ID = bcd.REC_ID WHERE 1 = 1 ");

		List<BOPForDebtBilLoanCreditor> list = new ArrayList<BOPForDebtBilLoanCreditor>();
		String id = getCommQueryServletRequest().getParameter("id");
		String op = getCommQueryServletRequest().getParameter("op");

		BOPForDebtBilLoanCreditor bop = new BOPForDebtBilLoanCreditor();

		if (NEW_CMD.equals(op)) {

			bop.setChangeno(ReportUtils.getTempStr("", 4));
			list.add(bop);

			return list;

		} else if (DETAILE_CMD.equalsIgnoreCase(op) || DELETE_CMD.equalsIgnoreCase(op) || MOD_CMD.equalsIgnoreCase(op)) {

			//加载变动信息并获取filler1
			//取得filler1
			String filler1Id = "";
			BopCfaExdebtDs bopChangDs = rootdao.query(BopCfaExdebtDs.class, id);

			if(null != bopChangDs)
			{
				filler1Id = bopChangDs.getFiller1();
			}

			hql.append(" AND bds.REC_ID ='").append(filler1Id).append("'");

			queryCondition.setQueryString(hql.toString());

			//将变动信息set benan BOPForDebtBilLoanCreditor
			bop.setId(bopChangDs.getId());
			bop.setApptype(bopChangDs.getApptype());
			bop.setCurrentfile(bopChangDs.getCurrentfile());

			bop.setBuscode(bopChangDs.getBuscode());
			bop.setChangeno(bopChangDs.getChangeno());
			bop.setChangtype(bopChangDs.getChangtype());
			bop.setChdate(bopChangDs.getChdate());
			bop.setChcurrency(bopChangDs.getChcurrency());
			bop.setChamount(bopChangDs.getChamount());
			bop.setFairvalue(bopChangDs.getFairvalue());
			bop.setRemark(bopChangDs.getRemark());
			bop.setLstUpdTlr(bopChangDs.getLstUpdTlr());
			bop.setLstUpdTm(bopChangDs.getLstUpdTm());
			bop.setCrtTm(bopChangDs.getCrtTm());
			bop.setActiontype(bopChangDs.getActiontype());
			if (!MOD_CMD.equalsIgnoreCase(op)) {
				bop.setActiondesc(bopChangDs.getActiondesc());
			}
			bop.setRecStatus(bopChangDs.getRecStatus());
			bop.setRepStatus(bopChangDs.getRepStatus());
			bop.setApproveStatus(bopChangDs.getApproveStatus());
			bop.setApproveResult(bopChangDs.getApproveResult());
			bop.setWorkDate(bopChangDs.getWorkDate());
			bop.setSubSuccess(bopChangDs.getSubSuccess());
			bop.setFiller2(bopChangDs.getFiller2());

			// 将取得的数据放入到 BOPForDebtBilLoanCreditor bean中
			for (Iterator it = rootdao.queryBySQL(hql.toString()); it.hasNext();) {
				Object[] queryArray = (Object[]) it.next();

				// 变动信息由 bopChangDs加载
				//bop.setId((String) queryArray[0]);
				/*bop.setApptype((String) queryArray[1]);
				bop.setCurrentfile((String) queryArray[2]);*/

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

				// 变动信息由 bopChangDs加载
				//bop.setRemark((String) queryArray[16]);
				/*bop.setLstUpdTlr((String) queryArray[17]);
				bop.setLstUpdTm((Date) queryArray[18]);
				bop.setCrtTm((Date) queryArray[19]);
				bop.setFiller1((String) queryArray[20]);*/

				bop.setBrNo((String) queryArray[21]);

				bop.setCreditorid((String) queryArray[30]);
				bop.setCreditorcode((String) queryArray[31]);
				bop.setCreditorname((String) queryArray[32]);
				bop.setCreditornamen((String) queryArray[33]);
				bop.setCreditorca((BigDecimal) queryArray[34]);
				bop.setCreditortype((String) queryArray[35]);
				bop.setCrehqcode((String) queryArray[36]);
				bop.setOpercode((String) queryArray[37]);
				//bop.setRecId((String) queryArray[38]);

				// 变动信息由 bopChangDs加载
				/*bop.setBuscode((String) queryArray[39]);
				bop.setChangeno((String) queryArray[40]);
				bop.setChangtype((String) queryArray[41]);
				bop.setChdate((String) queryArray[42]);
				bop.setChcurrency((String) queryArray[43]);
				bop.setChamount( (BigDecimal)queryArray[44]);
				bop.setFairvalue( (BigDecimal)queryArray[45]);
				*/
				bop.setDebtyperema((String) queryArray[46]);
				bop.setIsincode((String) queryArray[47]);
				bop.setqFiller2((String) queryArray[48]);
				bop.setInpriamount((BigDecimal) queryArray[49]);
				list.add(bop);
			}
			return list;
		}
		return list;
	}
}