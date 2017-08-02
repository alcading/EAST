package com.huateng.report.send.translate;

import com.huateng.exception.AppException;
import com.huateng.util.ContextUtil;

public class TransFactory {

	private ITranslate translate;

	public static ITranslate getInstence() throws AppException {
		ITranslate iTranslate = ((TransFactory) ContextUtil.getBean(TransFactory.class.getName())).getTranslate();
		return iTranslate;
	}

	public ITranslate getTranslate() {
		return translate;
	}

	public void setTranslate(ITranslate translate) {
		this.translate = translate;
	}

}
