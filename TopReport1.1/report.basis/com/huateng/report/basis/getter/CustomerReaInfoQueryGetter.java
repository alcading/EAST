package com.huateng.report.basis.getter;

import java.util.ArrayList;
import java.util.List;

import resource.bean.report.BiCustomer;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class CustomerReaInfoQueryGetter extends BaseGetter{

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			List list  = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), 
					getCommQueryServletRequest(), 
					list,getResult());
			result.setContent(list);
			result.getPage().setTotalPage(list.size());
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	
	private List getData() throws CommonException{
		List list = new ArrayList();
		String id = getCommQueryServletRequest().getParameter("id");
		String op = getCommQueryServletRequest().getParameter("op");
		if("new".equals(op)){
			
		}else if("mod".equalsIgnoreCase(op)){
			ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
			list.add(rootDao.query(BiCustomer.class, id));
		}
		return list;
	}
}
