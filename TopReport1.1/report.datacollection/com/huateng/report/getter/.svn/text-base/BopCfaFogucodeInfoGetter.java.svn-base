package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaFogucodeinfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class BopCfaFogucodeInfoGetter extends BaseGetter{

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();
			
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	
	public PageQueryResult getData() throws CommonException{
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		List<BopCfaFogucodeinfo> list = new ArrayList<BopCfaFogucodeinfo>();
		PageQueryResult queryResult = new PageQueryResult();
		String id = (String) map.get("id");
		String op = (String) map.get("op");
		if(DataFormat.isEmpty(id)) {
//			TODO
		} else {
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String hql = "from BopCfaFogucodeinfo model where model.recId = '" + id + "'";
			list = rootdao.queryByQL2List(hql);
		}
		queryResult.setQueryResult(list);
		//页面接收判断
		getCommQueryServletRequest().setParameter("op", op);
		return queryResult;
	}

}
