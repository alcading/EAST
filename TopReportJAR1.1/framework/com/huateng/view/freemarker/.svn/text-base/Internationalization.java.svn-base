package com.huateng.view.freemarker;

import com.huateng.ebank.framework.exceptions.CommonException;

public interface Internationalization {
	String ON_OFF = "internationalization";
	String ON = "ON";
	String OFF = "OFF";
	String RESOURCE = "resources.Message";
	/**
	 * <pre>
	 * 不同的语言环境下,将messageKey翻译成相应的文字
	 * 例:
	 * xxx.properteis 
	 * login.user=用户
	 * internationalized("login.user") 将返回 "用户";
	 * </pre>
	 * @param messageKey
	 * @return
	 */
	String internationalized(String messageKey) throws CommonException;
}
