package com.huateng.report.send.parse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

import com.huateng.service.message.base.IStrutBuffer;
import com.huateng.util.ContextUtil;

public class XmlBeanParser implements BeanParser {
	private IStrutBuffer buf;

	public void setBuffBeanId(String buffBeanId) throws Exception {
		this.buf = (IStrutBuffer) ContextUtil.getBean(buffBeanId);
	}

	public String convert2String(Object bean) throws Exception {
		buf.clear();
		buf.loadObject(bean);
		return buf.outputString();
	}

	public Object convert2Bean(String text) throws Exception {
		buf.clear();
		Document doc = DocumentHelper.parseText(text);
		buf.init(doc.getRootElement());
		return buf.printObject();
	}

	public Object convert2BeanByFile(String xmlFile) throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(xmlFile);
		buf.clear();
		buf.init(doc.getRootElement());
		return buf.printObject();
	}
}
