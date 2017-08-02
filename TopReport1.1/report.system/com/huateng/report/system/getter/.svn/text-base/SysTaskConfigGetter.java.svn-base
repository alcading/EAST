package com.huateng.report.system.getter;

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
import com.huateng.report.system.service.SysTaskConfigService;

public class SysTaskConfigGetter extends BaseGetter {
	/**
	 * @author jianxue.zhang 
	 */
	@Override
	public Result call() throws AppException {
		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "系统维护-复核模块维护");
			//List codeslist = GlobalInfo.getCurrentInstance().getConfrimCodeList();
			
				PageQueryResult pageResult = getData();
				ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult
						.getQueryResult(), getResult());
				result.setContent(pageResult.getQueryResult());
				result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws AppException {
		// 获取参数集合
		Map paramMap = this.getCommQueryServletRequest().getParameterMap();
		// 也可以这样 getCommQueryServletRequest().getParameter("qDataTypeNo");
		// 获取参数id,insCd,intInsId,updTransCd
		String id = (String) paramMap.get("id");
		//String insCd = (String) paramMap.get("insCd");
		//String intInsId = (String) paramMap.get("intInsId");
		//String updTransCd = (String) paramMap.get("updTransCd");
		// 获取页面的pageSize
		int pageSize = this.getResult().getPage().getEveryPage();
		// 获取页面的当前页
		int pageIndex = this.getResult().getPage().getCurrentPage();
		// 组装hql语句
		StringBuffer hql = new StringBuffer("from SysTaskConfig dd where 1=1");
		if (StringUtils.isNotBlank(id)) {
			hql.append(" and dd.id like '%").append(id).append("%'");
		}
		hql.append(" and dd.id <> '100399'");
		hql.append(" order by dd.id  desc");
		return SysTaskConfigService.getInstance().list(pageIndex, pageSize, hql.toString());
	}
}
