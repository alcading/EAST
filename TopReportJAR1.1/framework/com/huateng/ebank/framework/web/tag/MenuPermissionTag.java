/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.4 $
 * @date 2005-7-5
 *  
 * 菜单权限设置的Tag.
 */
public class MenuPermissionTag extends BodyTagSupport {
	private static Log log = LogFactory.getLog(MenuPermissionTag.class);
	//menu id
	String menuId = "";
	
	/**
	 * Render the beginning of this tag.
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 */
	@Override
	public int doStartTag() throws JspException {
//		PageManager pm = PageManager.getInstance(pageContext);
//		Menu menu = (Menu)pm.getComponent(menuId);
//		
//		GlobalInfo globalInfo = null;
//		try{
//			globalInfo = GlobalInfo.getFromRequest((HttpServletRequest)this.pageContext.getRequest());			
//		}catch(CommonException ce){
//			log.error("异常.",ce);
//			throw new JspException(ce.getMessage(),ce);
//		}
//		
//		if ( null == globalInfo ){
//			log.error("没有全局信息, 请先登录.");
//			throw new JspException("没有全局信息, 请先登录.");
//		}
//		
//		String tlrno = globalInfo.getTlrno();
//		
//		if ( null == menu )return(EVAL_BODY_INCLUDE);
//		
//		OperationContext operationContext = new OperationContext();
//		operationContext.setAttribute(MenuPermissionOperation.IN_PARAM_MENU, menu);
//		operationContext.setAttribute(MenuPermissionOperation.IN_PARAM_TLRNO, tlrno);
//		try{
//			OPCaller.call("tag.MenuPermissionOperation", operationContext);
//		}catch(CommonException ce){
//			log.error("异常",ce);			
//			throw new JspException(ce.getMessage(),ce);
//		}
		return (EVAL_BODY_INCLUDE);
	}
	
	/**
	 * Render the end of this tag.
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 */
	@Override
	public int doEndTag() throws JspException {		
		// Continue processing this page
		return (EVAL_PAGE);
	}
	/**
	 * @return Returns the menuId.
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId The menuId to set.
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	
	
}
