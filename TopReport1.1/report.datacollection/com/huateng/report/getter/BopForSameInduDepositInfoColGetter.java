package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForSameInduDepositBean;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

@SuppressWarnings("unchecked")
public class BopForSameInduDepositInfoColGetter  extends BaseGetter{

	@SuppressWarnings("rawtypes")
	public Result call() throws AppException {
		List queryList = getList();

		ResultMng.fillResultByList(getCommonQueryBean(),
				getCommQueryServletRequest(),
				queryList,
				getResult());
		result.setContent(queryList);
		result.getPage().setTotalPage(0);
		result.init();
		return result;

	}

	@SuppressWarnings("rawtypes")
	private List getList() throws CommonException{
		String op = getCommQueryServletRequest().getParameter("op");
		String id = getCommQueryServletRequest().getParameter("id");

		BopForSameInduDepositBean bop = new BopForSameInduDepositBean();
		List<BopForSameInduDepositBean> list = new ArrayList<BopForSameInduDepositBean>();
		if("new".equalsIgnoreCase(op)){
			//机构号
			GlobalInfo gb = GlobalInfo.getCurrentInstance();
			//外债编号
			bop.setExdebtcode(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_CFA_AL));
			ReportUtils.setObjectPro(bop, TopReportConstants.REPORT_FILE_TYPE_CFA_AL);
			//债务人代码
			bop.setDebtorcode(gb.getBrno());
			list.add(bop);
		}else if("mod".equalsIgnoreCase(op)  || "del".equalsIgnoreCase(op) || "detail".equalsIgnoreCase(op)){

			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			BopCfaExdebtDs exdebtds = rootdao.query(BopCfaExdebtDs.class, id);

			StringBuilder query = new StringBuilder(" FROM BopCfaCreditorDs WHERE recId = ? ");
			List<BopCfaCreditorDs>creditorList = rootdao.queryByQL2List(query.toString(), new Object[]{id}, null);

			if(null != exdebtds){
				bop.setId(exdebtds.getId());
				bop.setApptype(exdebtds.getApptype());
				bop.setCurrentfile(exdebtds.getCurrentfile());
				bop.setExdebtcode(exdebtds.getExdebtcode());
				bop.setLimitType(exdebtds.getLimitType());
				bop.setDebtorcode(exdebtds.getDebtorcode());
				bop.setDebtype(exdebtds.getDebtype());
				bop.setValuedate(exdebtds.getValuedate());
				bop.setContractcurr(exdebtds.getContractcurr());

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
				if (!StringUtils.equalsIgnoreCase("mod", op)) {
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