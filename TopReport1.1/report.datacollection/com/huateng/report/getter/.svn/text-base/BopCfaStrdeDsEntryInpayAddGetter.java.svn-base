package com.huateng.report.getter;

import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaStrdeDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class BopCfaStrdeDsEntryInpayAddGetter extends BaseGetter {

	private static final String ADD = "add";
	private static final String MOD = "mod";
	private static final String DEL = "del";
	private static final String DETAIL = "detail";

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
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

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {
		Map paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String op = (String) paramsMap.get("op");
		System.out.println("op=" + op);
		if (ADD.equals(op)) {
			// 新增
			PageQueryResult pageQueryResult = new PageQueryResult();
			return pageQueryResult;
		}
		if (MOD.equals(op) || DEL.equals(op) || DETAIL.equals(op)) {
			// 修改和删除
			ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
			String rec_id = (String) paramsMap.get("id");
			String hql = " from BopCfaStrdeDs ds where 1 = 1 ";
			hql += " and ds.id = '" + rec_id + "' order by ds.lstUpdTm desc";
			List<BopCfaStrdeDs> mtsBopCfaStrdeDsInfos = dao.queryByQL2List(hql);
			for (BopCfaStrdeDs ds : mtsBopCfaStrdeDsInfos) {
				String id = ds.getFiller1();
				BopCfaStrdeDs collBopCfaStrdeDs = dao.query(
						BopCfaStrdeDs.class, id);
				if (collBopCfaStrdeDs != null) {
					// strdecode branchcode clientcode clientname contractdate
					// contract
					// contractamount maturity lincame lincamethod aginraup
					// aginralo aginraloinpay remark
					// brno
					ds.setStrdecode(collBopCfaStrdeDs.getStrdecode());
					ds.setBranchcode(collBopCfaStrdeDs.getBranchcode());
					ds.setClientcode(collBopCfaStrdeDs.getClientcode());
					ds.setClientname(collBopCfaStrdeDs.getClientname());
					ds.setContractdate(collBopCfaStrdeDs.getContractdate());
					ds.setContract(collBopCfaStrdeDs.getContract());
					ds.setContractamount(collBopCfaStrdeDs.getContractamount());
					ds.setMaturity(collBopCfaStrdeDs.getMaturity());
					ds.setLincame(collBopCfaStrdeDs.getLincame());
					ds.setLincamethod(collBopCfaStrdeDs.getLincamethod());
					ds.setAginraup(collBopCfaStrdeDs.getAginraup());
					ds.setAginralo(collBopCfaStrdeDs.getAginralo());
					ds.setAginrapay(collBopCfaStrdeDs.getAginraloinpay());
					ds.setRemark(collBopCfaStrdeDs.getRemark());
					ds.setBrNo(collBopCfaStrdeDs.getBrNo());

				}
				PageQueryResult result = new PageQueryResult();
				result.setQueryResult(mtsBopCfaStrdeDsInfos);
				return result;
			}
		}
		return null;
	}
}