/**
 *
 * Copyright (c) 2003 ShangHai Huateng Software System Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ShangHai Huateng Software Limited. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with Huateng.
 */

package com.huateng.ebank.framework.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.huateng.ebank.business.common.ErrorCode;



/**
 * Tag used to judge whether a user is authorized or not with the specified
 * fucntion id.
 * @author James wu
 * @version
 */
public class LoginBkgroundTag extends TagSupport {


	public LoginBkgroundTag() {
	}


	// --------------------------------------------- Public Methods.

	@Override
	public int doStartTag() throws JspException {
		try{
			HttpSession session = pageContext.getSession();
			String retCode = (String)session.getAttribute("RET_CODE");
			//youjinwu  modify
			HttpServletRequest request  = (HttpServletRequest)pageContext.getRequest();
			String webPath = request.getContextPath() + "/";
			//String webPath = System.getProperty("app.web.path");
			//System.out.println("webPath=" + webPath);
			if(retCode == null) {
				pageContext.getOut().print(webPath+"images/denglu.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_OK)) {
				pageContext.getOut().print(webPath+"images/denglu.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_TLR_INFO_SELECT) || retCode.equals(ErrorCode.ERROR_CODE_USER_NOT_EXIST)) {
				pageContext.getOut().print(webPath+"images/denglu_usernull.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_USER_PWD_INVALID)) {
				pageContext.getOut().print(webPath+"images/denglu_pwerr.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_TLRNO_PSWD_ERR_TIMES)) {
				pageContext.getOut().print(webPath+"images/denglu_pwerr_conti.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_TLRNO_PSWD_CHANGE)) {
				pageContext.getOut().print(webPath+"images/denglu_pwerr_day.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_TLRNO_STATUS_INVALID)) {
				pageContext.getOut().print(webPath+"images/denglu_statuserr.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_TLRNO_NO_FUNCTION)) {
				pageContext.getOut().print(webPath+"images/denglu_func.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_TLRNO_ALREADY_LOGIN)) {
				pageContext.getOut().print(webPath+"images/denglu_logined.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_GLOBALINFO_BATCH)){
				pageContext.getOut().print(webPath+"images/denglu_offline.gif");
			}
			else if(retCode.equals(ErrorCode.ERROR_CODE_TLRNO_SESSION_BINDED) || retCode.equals(ErrorCode.ERROR_CODE_TLRNO_SESSION_INVALID)){
				pageContext.getOut().print(webPath+"images/denglu_session_invalidate.gif");
			}
//				else if (retCode.equals(ErrorCode.ERROR_CODE_COMMIT_TRANSACTION)) { //add by Farly.yu 2007-04-24 流水重复
//				pageContext.getOut().print(webPath+"images/denglu_insert_log.gif");
//			}
			else {
				pageContext.getOut().print(webPath+"images/denglu_unknowerr.gif");
			}
			if(retCode != null) {
				session.removeAttribute("RET_CODE");
			}
		}catch (Exception e)
		{
			throw new JspException("[pocompl] Exception in LoginBkgroundTag : condition " +
			e.getMessage());
		}
		return (SKIP_BODY);
	} //--doStartTag

	@Override
	public int doEndTag() throws JspException {
		return (EVAL_PAGE);
	}

	/**
	 * Release all allocated resources.
	 */
	@Override
	public void release() {
		super.release();
	}
}
