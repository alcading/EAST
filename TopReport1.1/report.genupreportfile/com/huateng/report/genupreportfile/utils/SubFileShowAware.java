package com.huateng.report.genupreportfile.utils;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.huateng.ebank.framework.util.DateUtil;

public class SubFileShowAware implements ApplicationContextAware {

	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		context = ctx;
	}



	public static void putEvent(String msg) {
		String tmp = DateUtil.Time14ToString2(new Date())+" "+msg;
		SubFileEventBean evt = new SubFileEventBean(tmp);
		context.publishEvent(evt);
	}
}
