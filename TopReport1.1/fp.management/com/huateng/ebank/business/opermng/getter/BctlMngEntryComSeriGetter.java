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
import resource.bean.report.SysTaskInfo;
import resource.bean.report.SysTaskLog;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
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
public class BctlMngEntryComSeriGetter extends BaseGetter {

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
		PageQueryResult pageQueryResult = new PageQueryResult();
		String st = (String) getCommQueryServletRequest().getParameterMap().get("st");
		String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
		String tskId = (String) getCommQueryServletRequest().getParameterMap().get("tskId");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<String> brcodes = new ArrayList<String>();
		if(flag.equals("0")){
			if(st.equals("2")){
				ReportTaskUtil rt = new ReportTaskUtil();
				List<SysTaskInfo> taskList = rootdao.queryByQL2List("from SysTaskInfo where intInsId='100399' and adtRcdPk='" + tlrno + "'");
				if (taskList.size() > 0) {
					TlrInfoAuditBean auditBean = (TlrInfoAuditBean) rt.getObjctBySysTaskInfo(taskList.get(0));
					for(TlrBctlRel temp : auditBean.getBctlRellist()){
						brcodes.add(temp.getBrcode());
					}
					String hql = "select bctl from Bctl bctl where bctl.status='1' and bctl.brcode in" + ReportUtils.toInString(brcodes) + " order by bctl.brno";
					List<Bctl> list = rootdao.queryByQL2List(hql);
					pageQueryResult.setTotalCount(list.size());
					pageQueryResult.setQueryResult(list);
				}
			}
		}
		if (flag.equals("1")) {
			ReportTaskUtil rt=new ReportTaskUtil();
			SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
			TlrInfoAuditBean newValue = null;
			if(systasklog.getNewVal1()!=null){
				newValue=(TlrInfoAuditBean)rt.getNewObjectByTaskLog(systasklog);	  
			}
			if(newValue != null){
				for(TlrBctlRel temp : newValue.getBctlRellist()){
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
