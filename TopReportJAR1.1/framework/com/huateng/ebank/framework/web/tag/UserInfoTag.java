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


import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Tag used to judge whether a user is authorized or not with the specified
 * fucntion id.
 * @author James wu
 * @version
 */
public class UserInfoTag extends TagSupport {

	public UserInfoTag() {
	}

	// --------------------------------------------- Public Methods.

	@Override
	public int doStartTag() throws JspException {
		try {
			HttpSession session = pageContext.getSession();
			UserSessionInfo userInfo =
				(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
			if (userInfo != null) {
				String tbsDay = DataFormat.dateToString(userInfo.getTxDate()) ;
				StringBuffer sb = new StringBuffer(256);
				sb
					.append("工作日期：")
					.append(tbsDay.substring(0,4))
					.append("年")
					.append(tbsDay.substring(5,7))
					.append("月")
					.append(tbsDay.substring(8,10))
					.append("日")
					.append("&nbsp;&nbsp;&nbsp;操作员号：")
					.append(userInfo.getTlrNo())
					.append("&nbsp;&nbsp;操作员名：")
					.append(userInfo.getTlrName());

				pageContext.getOut().print(sb.toString());
			}
		} catch (Exception e) {
			throw new JspException(
				"[pocompl] Exception in AuthorizeTag : condition "
					+ e.getMessage());
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
