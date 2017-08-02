/*
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2003-2004 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.framework.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.huateng.ebank.framework.operation.OperContext;

/**
 * 电子银行Validation BaseForm基类；
 * 所有Struts ActionForm都应该从这个基类中继承。
 *
 * @author Huang Liang
 */
public class HTBaseForm extends ValidatorForm {

	private OperContext fmContext = new OperContext();
	private String jsessionid;
	private String JSESSIONID;
	private boolean success;
		
	public HTBaseForm() {
		super();
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		super.reset(mapping, request);
		success = false;
		jsessionid = null;
		JSESSIONID = null;
	}

	public void reset() {
		success = false;
		jsessionid = null;
		JSESSIONID = null;
	}
	
	/**
	 * @return
	 */
	public OperContext getFmContext() {
		return fmContext;
	}

	/**
	 * @param context
	 */
	public void setFmContext(OperContext context) {
		fmContext = context;
	}

	/**
	 * @return
	 */
	public String getJsessionid() {
		return jsessionid;
	}

	/**
	 * @param string
	 */
	public void setJsessionid(String string) {
		jsessionid = string;
	}

	/**
	 * @return
	 */
	public String getJSESSIONID() {
		return JSESSIONID;
	}

	/**
	 * @param string
	 */
	public void setJSESSIONID(String string) {
		JSESSIONID = string;
	}

	/**
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param b
	 */
	public void setSuccess(boolean b) {
		success = b;
	}

}