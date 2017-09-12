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
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BOPForDebtBilLoanCreditor;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

/**
 *
 * 外债信息表 update insert delete Getter
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 *
 * */
@SuppressWarnings("unchecked")
public class BOPForDebtOverseaLendingColGetter extends BaseGetter {

	private static final String DELETE_CMD="del";
	private static final String NEW_CMD="new";
	private static final String MOD_CMD="mod";
	private static final String DETAILE_CMD="detaile";

	@SuppressWarnings("rawtypes")
	public Result call() throws AppException {
		try {
			List queryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(), queryResult,getResult());

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
	private List getData() throws CommonException
	{
		List<BOPForDebtBilLoanCreditor> list = new ArrayList<BOPForDebtBilLoanCreditor>();
		String id = getCommQueryServletRequest().getParameter("id");
		String op = getCommQueryServletRequest().getParameter("op");

		BOPForDebtBilLoanCreditor bop = new BOPForDebtBilLoanCreditor();

		if(NEW_CMD.equals(op)){

			bop.setExdebtcode(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_CFA_AC));
			ReportUtils.setObjectPro(bop, TopReportConstants.REPORT_FILE_TYPE_CFA_AC);
			GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
			bop.setDebtorcode(gInfo.getBrno());
			list.add(bop);

			return list;

		}else if(DETAILE_CMD.equalsIgnoreCase(op) || DELETE_CMD.equalsIgnoreCase(op) || MOD_CMD.equalsIgnoreCase(op)){

			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			BopCfaExdebtDs exdebtds = rootdao.query(BopCfaExdebtDs.class, id);

			StringBuilder query = new StringBuilder(" FROM BopCfaCreditorDs WHERE recId = ? ");
			List<BopCfaCreditorDs>creditorList = rootdao.queryByQL2List(query.toString(), new Object[]{id}, null);

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
				if (!StringUtils.equalsIgnoreCase(MOD_CMD, op)) {
					bop.setActiondesc(exdebtds.getActiondesc());
				}
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
			list.add(bop);
		}
		return list;
	}
}