package com.huateng.ebank.monitor.globalInfo.getter;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.ebank.monitor.globalInfo.service.GlobalInfoService;
import com.huateng.exception.AppException;

/**
 * 系统状态信息
 * @author wangpeng
 *
 */
public class GlobalInfoGetter extends BaseGetter {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		GlobalInfoService service=(GlobalInfoService)ApplicationContextUtils.getBean(GlobalInfoService.class.getName());
		
		resource.bean.pub.Globalinfo global=service.getCurrentGlobalInfo();
		ResultMng.fillResultByObject(getCommonQueryBean(), getCommQueryServletRequest(), global,getResult());
		
		result.getPage().setTotalPage(1);
		result.init();
		return result;
	}

}
