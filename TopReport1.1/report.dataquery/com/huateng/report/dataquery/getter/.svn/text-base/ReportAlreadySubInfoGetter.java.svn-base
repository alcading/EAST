package com.huateng.report.dataquery.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.report.AlreadySubInfo;
import resource.bean.report.SubFileInfo;
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
import com.huateng.report.common.bean.ReportBackErrBean;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.dataquery.bean.ReportAlreadySubInfoErrBean;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class ReportAlreadySubInfoGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub

		try {

			PageQueryResult queryResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
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
	private PageQueryResult getData() throws CommonException
	{
		String recId = getCommQueryServletRequest().getParameter("recId");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//上报文件信息
		SubFileInfo subFileInfo = rootdao.query(SubFileInfo.class, recId);
		String appType = subFileInfo.getApptype();
		String currentfile = subFileInfo.getCurrentfile();
		//上报文件配置信息
		ReportCommonService reportCommonService = ReportCommonService.getInstance();
		//已上报文件信息
		List<AlreadySubInfo> list = rootdao.queryByQL2List(" from AlreadySubInfo model where model.fileName='"+subFileInfo.getId()+"' and model.apptype='"+appType+"' and model.currentfile='"+currentfile+"'");
		List<ReportAlreadySubInfoErrBean> infoErrBeans = new ArrayList<ReportAlreadySubInfoErrBean>();
		for(AlreadySubInfo alreadySubInfo : list){
			//返回错误消息实体
			ReportBackErrBean backErrBean = ReportUtils.getReportBankMsg(alreadySubInfo.getRecId(), subFileInfo.getApptype(), subFileInfo.getCurrentfile());
			if (backErrBean != null) {
				if (backErrBean.getErrType().equals(ReportEnum.REPORT_ERR_TYPE.FORMAT_ERR.value)) {
					List<String> errMsgs = backErrBean.getErrMsg();
					for(String errMsg : errMsgs){
						ReportAlreadySubInfoErrBean infoErrBean = new ReportAlreadySubInfoErrBean();
						infoErrBean.setErrType(backErrBean.getErrType());
						infoErrBean.setErrMsg(errMsg);
						infoErrBeans.add(infoErrBean);
					}
				} else if (backErrBean.getErrType().equals(ReportEnum.REPORT_ERR_TYPE.REC_ERR.value)){
					Map<String, String> errFiledMap = backErrBean.getErrFiledMap();
					Iterator it = errFiledMap.keySet().iterator();
					Map<String, String> errFiledContentMap = backErrBean.getErrFiledContentMap();
					while(it.hasNext()){
						ReportAlreadySubInfoErrBean infoErrBean = new ReportAlreadySubInfoErrBean();
						infoErrBean.setErrType(backErrBean.getErrType());
						String errfield = (String) it.next();
						String errfieldcn = errFiledMap.get(errfield);
						String errfieldMsg = errFiledContentMap.get(errfield);
						infoErrBean.setErrfield(errfield);
						infoErrBean.setErrfieldcn(errfieldcn);
						infoErrBean.setErrMsg(errfieldMsg);
						infoErrBeans.add(infoErrBean);
					}
				}
			}
		}
		PageQueryResult queryResult = new PageQueryResult();
		queryResult.setQueryResult(infoErrBeans);
		queryResult.setTotalCount(infoErrBeans.size());
	   return queryResult;
	}
}
