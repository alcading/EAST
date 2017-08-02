/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.opermng.getter;

import java.util.ArrayList;
import java.util.List;

import resource.bean.pub.Bctl;
import resource.bean.pub.TlrBctlRel;
import resource.bean.report.SysTaskLog;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.system.bean.TlrInfoAuditBean;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportUtils;

/**
 * @author zhiguo.zhao
 *
 */
public class BctlMngEntryComGetter extends BaseGetter {

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

	protected PageQueryResult getData() throws Exception {
		String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
		String tskId = (String) getCommQueryServletRequest().getParameter("tskId");
		String st = (String) getCommQueryServletRequest().getParameter("st");
		
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = new PageQueryResult();
		List<String> brcodes = new ArrayList<String>();
		if(flag.equals("0")){
			if (!DataFormat.isEmpty(tlrno) && !tlrno.equals("0")){
				String tempHql = "select tlrBctl from TlrBctlRel tlrBctl where tlrBctl.tlrNo = '" + tlrno + "'";
				List<TlrBctlRel> tempList = rootdao.queryByQL2List(tempHql);
				for(TlrBctlRel temp : tempList){
					brcodes.add(temp.getBrcode());
				}
			}
			String hql = "select bctl from Bctl bctl where bctl.status='1' and bctl.brcode in" + ReportUtils.toInString(brcodes) + " order by bctl.brno";
			List<Bctl> list = rootdao.queryByQL2List(hql);
			
			pageQueryResult.setTotalCount(list.size());
			pageQueryResult.setQueryResult(list);
		} 
		if (flag.equals("1")) {
			ReportTaskUtil rt=new ReportTaskUtil();
			SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
			TlrInfoAuditBean OldValue = null;
			if(systasklog.getOldVal1()!=null){
				OldValue=(TlrInfoAuditBean)rt.getOldObjectByTaskLog(systasklog);	  
			}
			if(OldValue != null){
				for(TlrBctlRel temp : OldValue.getBctlRellist()){
					brcodes.add(temp.getBrcode());
				}
				String hql = "select bctl from Bctl bctl where bctl.brcode in" + ReportUtils.toInString(brcodes) + " order by bctl.brcode";
				List<Bctl> list = rootdao.queryByQL2List(hql);
				
				pageQueryResult.setTotalCount(list.size());
				pageQueryResult.setQueryResult(list);
			}
		}

		return pageQueryResult;
	}
}
