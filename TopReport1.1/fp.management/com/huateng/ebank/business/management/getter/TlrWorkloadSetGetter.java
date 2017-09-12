/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.management.getter;


import java.util.ArrayList;
import java.util.List;

import resource.bean.pub.TlrInfo;
import resource.dao.pub.BctlDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.data.TlrWorkload;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author kangbyron
 * @date 2011-02-10
 * @desc
 */
public class TlrWorkloadSetGetter extends BaseGetter {


	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try{

			String brcode = (String) getCommQueryServletRequest().getParameterMap().get("brcode1");
			String tlrno =  (String) getCommQueryServletRequest().getParameterMap().get("tlrno1");
			PageQueryResult pageQueryResult = new PageQueryResult();
	    	GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
			if(DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno)) {
				ExceptionUtil.throwCommonException("机构号与操作员号必输其一", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			if(!DataFormat.isEmpty(brcode)){
				BctlDAO bctlDao = DAOUtils.getBctlDAO();
				try {
					bctlDao.query(brcode);
				} catch (Exception e) {
					ExceptionUtil.throwCommonException("输入机构号不存在", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
				}
				if (!BctlService.getInstance().isBlnBrcode(brcode, globalinfo.getBrcode())) {
					ExceptionUtil.throwCommonException("输入机构号不为本机构或者下属机构", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
				}
			}

			StringBuffer queryString = new StringBuffer();
			queryString.append("select po,load from TlrInfo po,TlrWorkload load where po.tlrno=load.tlrno and po.status <> '"
						+ SystemConstant.TLR_NO_STATE_QUIT + "' ");
			if (!DataFormat.isEmpty(brcode)) {
				queryString.append(" and po.brcode='"+brcode+"'");
			}
			if (!DataFormat.isEmpty(tlrno)) {
				queryString.append(" and po.tlrno='"+tlrno+"'");
			}

			PageQueryCondition queryCondition = new PageQueryCondition();
			queryCondition.setPageIndex(result.getPage().getCurrentPage());
			queryCondition.setPageSize(result.getPage().getEveryPage());
			queryCondition.setQueryString(queryString.toString());
			pageQueryResult = DAOUtils.getHQLDAO().pageQueryByQL(queryCondition);
			List resultList = new ArrayList();
			for (int i = 0; i < pageQueryResult.getQueryResult().size(); i++) {
				Object[] obj = (Object[])pageQueryResult.getQueryResult().get(i);
				TlrInfo tlrInfo = (TlrInfo)obj[0];
				TlrWorkload tlrWorkload = (TlrWorkload)obj[1];
				tlrInfo.setMaxWl(tlrWorkload.getMaxWl());
				resultList.add(tlrInfo);
			}
			pageQueryResult.setQueryResult(resultList);



			ResultMng.fillResultByList(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageQueryResult.getQueryResult(),
					getResult());

			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(result.getPage().getEveryPage()));
			result.init();
		return result;



	}catch(AppException appEx){
		throw appEx;
	}catch(Exception ex){
		throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
	}


	}
}


