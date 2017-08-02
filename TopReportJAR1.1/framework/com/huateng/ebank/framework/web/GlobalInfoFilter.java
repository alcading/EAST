/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.web;

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

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.9 $
 * @date 2005-7-14
 *
 * 用来捕获Extra没有捕获的异常. 
 */
public class GlobalInfoFilter implements Filter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GlobalInfoFilter.class);

	private FilterConfig filterConfig;
	private String loginPageName = null ;
	private String expiredPageName = null ;

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		loginPageName = filterConfig.getInitParameter("LOGIN_PAGE");
		expiredPageName = filterConfig.getInitParameter("EXPIRED_PAGE");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException,
			ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - start"); //$NON-NLS-1$
		}
		//需要从配置文件中获得
		String STRING_LOGIN = "login" ;
		String STRING_LOGOUT = "logout" ;
		String STRING_CHGPWD = "changePwd" ;

		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession httpSession = request.getSession();
		if (logger.isDebugEnabled()) {
			logger.debug("session id = " + httpSession.getId());
		}

		GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		if (null != globalInfo) {
			GlobalInfo.setCurrentInstance(globalInfo);
			String sessionId = httpSession.getId();
			globalInfo.setSessionId(sessionId);
		}

		//获取请求URL
		String uri = request.getRequestURI();
		if (logger.isDebugEnabled()) {
			logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - String uri=" + uri); //$NON-NLS-1$
		}

		//add by NT
		System.setProperty("app.web.path",request.getContextPath()+"/");//LoginBkgroundTag.java中要引用这个变量，参考交行个贷

		String actionString = "" ;
		try{
			actionString = uri.substring(uri.lastIndexOf("/") + 1,uri.lastIndexOf("."));
			logger.debug("right - String actionString=" + actionString); //$NON-NLS-1$
		}
		catch(Exception e){
			actionString = STRING_LOGIN ;
			logger.debug("Exception - String actionString=" + actionString); //$NON-NLS-1$
		}

		//如果是登陆页（或非extra页面）
		if( (STRING_LOGIN.equalsIgnoreCase(actionString)) ||
			//(STRING_INDEX.equalsIgnoreCase(actionString)) ||
			(STRING_LOGOUT.equalsIgnoreCase(actionString)) ||
			(STRING_CHGPWD.equalsIgnoreCase(actionString))){
			filterChain.doFilter(req,resp);
			if (logger.isDebugEnabled()) {
				logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end return"); //$NON-NLS-1$
			}
			return;
		}

		//extra页面
		filterChain.doFilter(req, resp);

		try {
			if (uri.endsWith(".do") || uri.endsWith(".jsp")) {
				HttpServletResponse response = (HttpServletResponse) resp;
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
				response.setDateHeader("Expires", 1);
			}
		} catch (Exception e) {
			logger.error("doFilter(ServletRequest, ServletResponse, FilterChain)", e); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;
		this.loginPageName = null;
		this.expiredPageName = null;
	}

}