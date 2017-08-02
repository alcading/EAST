/*
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2003-2004 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */
 
package com.huateng.ebank.framework.struts;

import org.apache.struts.validator.DynaValidatorForm;

import com.huateng.ebank.framework.operation.OperContext;


/**
 * 电子银行Validation DynamicForm基类；
 * 所有Struts DynamicForm都应该从这个基类中继承。
 *
 * @author Huang Liang
 * @version 1.0
 */
public class HTDynaForm extends DynaValidatorForm {

	//操作上下文，存储来自后台服务调用返回的值对象集合，
	//从而可以在展现层加以显示。该对象里面维护一个HashTable对象类型。
	OperContext opContext = null;
	
	public HTDynaForm() {
		super();
	}
	
	/**
	 * @return
	 */
	public OperContext getOpContext() {
		return opContext;
	}

	/**
	 * @param context
	 */
	public void setOpContext(OperContext context) {
		opContext = context;
	}
}
