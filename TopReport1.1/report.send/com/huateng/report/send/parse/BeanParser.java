package com.huateng.report.send.parse;

public interface BeanParser {
	void setBuffBeanId(String buffBeanId) throws Exception;
	String convert2String(Object bean) throws Exception;
	Object convert2Bean(String text) throws Exception;
	Object convert2BeanByFile(String xmlFile) throws Exception;
}
