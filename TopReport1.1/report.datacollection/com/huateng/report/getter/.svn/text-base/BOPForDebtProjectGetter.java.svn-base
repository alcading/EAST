package com.huateng.report.getter;


import java.util.List;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 
 * 项目信息表Getter
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 * 
 * */

public class BOPForDebtProjectGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub

		try {

			List list = getData();

			// HtLog logger =
			// HtLogFactory.getLog(BOPForDebtBilLoanGetter.class);

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list,
					getResult());

			result.setContent(list);
			result.getPage().setTotalPage(1);
			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private List getData() throws CommonException {

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		
		StringBuffer hql =  new StringBuffer();

		String id = getCommQueryServletRequest().getParameter("id");
		String op = getCommQueryServletRequest().getParameter("op");

		if ("new".equals(op)) {

		} else if ("mod".equalsIgnoreCase(op) || "del".equalsIgnoreCase(op)|| "detaile".equalsIgnoreCase(op)) {
			
			hql.append( " from BopProjectInfo bpi where 1=1 " );
			hql.append(" and bpi.recId ='").append(id.trim()).append("'");
			 
			return rootdao.queryByQL2List(hql.toString());
			
		}

		return null;
	}

}
