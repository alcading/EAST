package com.huateng.view.freemarker;

import java.util.List;

import com.huateng.ebank.business.common.MessageResourceUtil;

import freemarker.template.TemplateModelException;

public class GetFieldDescMethodInter extends GetFieldDescMethod {

	@Override
	public Object exec(List args) throws TemplateModelException {
		Object desc = super.exec(args);
		return MessageResourceUtil.getBasicMessage((String) desc);
	}
}