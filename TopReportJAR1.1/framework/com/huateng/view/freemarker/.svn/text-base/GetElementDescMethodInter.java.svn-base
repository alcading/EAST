package com.huateng.view.freemarker;

import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.MessageResourceUtil;

import freemarker.template.TemplateModelException;

public class GetElementDescMethodInter extends GetElementDescMethod {

	protected static Logger logger = Logger
			.getLogger(GetElementDescMethodInter.class);
	
	@Override
	public Object exec(List args) throws TemplateModelException {
		Object desc = super.exec(args);
		return MessageResourceUtil.getBasicMessage((String) desc);
	}
}
