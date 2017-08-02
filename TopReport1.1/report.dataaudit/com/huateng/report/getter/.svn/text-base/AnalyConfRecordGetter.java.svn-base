package com.huateng.report.getter;


import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.BiAnalyConfService;

public class AnalyConfRecordGetter extends BaseGetter {


	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	private PageQueryResult getData() throws AppException {
		/*
		 * 获得查询参数，得到数据集
		 */
		this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "数据分析配置信息查询");
		Map paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String qbusiType = (String) paramsMap.get("qbusiType");
		String qappType = (String) paramsMap.get("qappType");
		String qconfType = (String) paramsMap.get("qconfType");
		String qconfVaild = (String) paramsMap.get("qconfVaild");
		StringBuffer hql = new StringBuffer();
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		//拼装hql(qbusiType数据库按DATA_DIC.35的DATA_NO字段,qconfDate按格式“yyyyMMdd”查，qconfVaild是0,1)
		hql.append("from BiAnalyConf biAnalyConf where 1 = 1 ");
		if(StringUtils.isNotBlank(qbusiType)) {
			hql.append(" and biAnalyConf.busiType = '"+qbusiType.trim()+"' ");
		}
		if(StringUtils.isNotBlank(qappType)) {
			hql.append(" and biAnalyConf.appType = '"+qappType.trim()+"' ");
		}
		if(StringUtils.isNotBlank(qconfType)) {
			hql.append(" and biAnalyConf.confType = '"+qconfType.trim()+"' ");
		}
		if(StringUtils.isNotBlank(qconfVaild)) {
			hql.append(" and biAnalyConf.confVaild = '"+qconfVaild.trim()+"' ");
		}

		return BiAnalyConfService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
	}


}
