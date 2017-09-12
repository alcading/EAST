package com.huateng.report.scheduler.job;

import javax.servlet.ServletContext;

import resource.bean.report.ReportJobConfig;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.utils.ReportEnum;

public class ReportJobUtil {
	public static boolean isDoTaskJob(ServletContext serContext,String sign,ReportJobConfig jobConfig) throws CommonException{
		//获取上次定时执行是否完成标识
		Object obj= serContext.getAttribute(sign);
		if (obj==null) {
			return true;
		}
		if (obj  instanceof Boolean) {
			boolean isfinish =  (Boolean) obj;
			if (isfinish) {
				if(jobConfig.getJustWorkdateRun().equals(ReportEnum.REPORT_IS.YES.value)){
					//modified by xuhong 2015-03-11 去掉是否是工作日的校验 start
//					boolean isRunDate = ReportCommonService.getInstance().checkWorkDate(new Date());
					boolean isRunDate = true;
					//modified by xuhong 2015-03-11 去掉是否是工作日的校验 end
					if (isRunDate) {
						return true;
					}
				}else{
					return true;
				}
			}
		}
		return false;
	}
}
