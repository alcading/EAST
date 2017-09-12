/*
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.session.SessionManager;

public class SessionAuthorizationFilter implements Filter {
	private FilterConfig filterConfig;
	private String loginPageName = null ;
	private String expiredPageName = null ;

	public void init(FilterConfig config) {
		this.filterConfig = config;
		loginPageName = filterConfig.getInitParameter("LOGIN_PAGE");
		expiredPageName = filterConfig.getInitParameter("EXPIRED_PAGE");
	}

	public void destroy() {
		this.filterConfig = null;
		this.loginPageName = null;
		this.expiredPageName = null;
	}

	public void doFilter(ServletRequest request,ServletResponse response,FilterChain filterChain)throws IOException, ServletException {

		String STRING_LOGIN = "login" ;
		//String STRING_INDEX = "index" ;
		String STRING_LOGOUT = "logout" ;
		String STRING_CHGPWD = "changePwd" ;
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//获取请求URL
		String path = req.getRequestURI();
		String actionString = "" ;
		try{
			actionString = path.substring(path.lastIndexOf("/") + 1,path.lastIndexOf("."));
		}
		catch(Exception e){
			actionString = STRING_LOGIN ;
		}
		
		//System.out.println("The URL path=<"+path+">");
		
		//如果是登陆页
		if( (STRING_LOGIN.equalsIgnoreCase(actionString)) || 
			//(STRING_INDEX.equalsIgnoreCase(actionString)) || 
			(STRING_LOGOUT.equalsIgnoreCase(actionString)) || 
			(STRING_CHGPWD.equalsIgnoreCase(actionString))){
			filterChain.doFilter(request,response);
			return;
		}
		
		HttpSession session = null ;
		try{
			session = SessionManager.getInstance().getSession(req);
		}
		catch(Exception e){
			session = null ;
		}
		//跳转到登陆页
		if( null == session ){
			filterConfig.getServletContext().getRequestDispatcher(loginPageName).forward(request,response);
			return ;
		}

		//SessionID为空，跳转到登陆页
		String strSessionID = null; 
		try{ 
			strSessionID = session.getAttribute(SystemConstant.WEB_SESSION_ID).toString();
		}
		catch(Exception e){
			strSessionID = null ;
		}
		if( null == strSessionID ){
			filterConfig.getServletContext().getRequestDispatcher(loginPageName).forward(request,response);
			return ;			
		}

		//Session过期了，跳转到Session过期页
		boolean bExpired = true ;
		try{
			bExpired = SessionManager.getInstance().isExpired(req);
		}
		catch(Exception e){
			bExpired = true ;	
		}
		if( true == bExpired ){
			filterConfig.getServletContext().getRequestDispatcher(expiredPageName).forward(request,response);
			return ;
		}
	
		/*
		//比较JSP中SESSIONID值是否有效
		String jspSessionID = null ;
		try{
			jspSessionID = req.getParameter(SystemConstant.WEB_SESSION_ID);
		}
		catch(Exception e){
			jspSessionID = null ;
		}
		//Jsp SESSION ID 为空或不匹配
		if( (null==jspSessionID) || (!strSessionID.equals(jspSessionID)) ){
			filterConfig.getServletContext().getRequestDispatcher(loginPageName).forward(request,response);
			return ;			
		}
		*/
		
		//传递Filter链	
		filterChain.doFilter(request,response);
		
		return ;
	}
}
