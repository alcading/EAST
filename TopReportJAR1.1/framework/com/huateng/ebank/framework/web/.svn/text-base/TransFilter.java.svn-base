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
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.service.pub.UserMgrService;

/**
 * 处理GlobalInfo ,把GlobalInfo放到threadLocal
 *
 * @author yjw
 *
 */
public class TransFilter implements Filter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TransFilter.class);
	/** memeber variable: String　LOGIN_PAGE. */
	private static final String LOGIN_REF = "LOGIN_REF";
	/** memeber variable: String　EXPIRED_PAGE. */
	private static final String EXPIRED_PAGE = "EXPIRED_PAGE";

	private FilterConfig filterConfig;
	private String expiredPageName = null;
	private String loginRef = null;


	public String getExpiredPageName() {
		return expiredPageName;
	}

	public void setExpiredPageName(String expiredPageName) {
		this.expiredPageName = expiredPageName;
	}

	public String getLoginRef() {
		return loginRef;
	}

	public void setLoginRef(String loginRef) {
		this.loginRef = loginRef;
	}
	private UserMgrService userService = UserMgrService.getInstance();
	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		this.loginRef = this.filterConfig.getInitParameter(LOGIN_REF);
		this.expiredPageName = this.filterConfig.getInitParameter(EXPIRED_PAGE);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession httpSession = request.getSession(false);
		if (null != httpSession) {
			Object o = httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);

			if (null != o&& o instanceof GlobalInfo) {
				GlobalInfo globalInfo = (GlobalInfo) o;
				/**
				 * 判断用户是否登录
				 */
				GlobalInfo.setCurrentInstance(globalInfo);
				String sessionId = httpSession.getId();
				globalInfo.setSessionId(sessionId);

				//set funcid
				globalInfo.setFuncId(request.getParameter("__FuncId"));

				/** add by zhaozhiguo 2011-6-20 BMS-3153 begin */
				String path = request.getServletPath();
				if (!path.endsWith("ChangePwd.ftl") && !path.endsWith("logout.do")
						&& !path.endsWith("login.do")) {
					if (globalInfo.getLastpwdchgtm() == null) {
						globalInfo.setPswdForcedToChange(true);//未修改过密码
					} else {
						long between = DateUtil.getDaysBetween(new Date(), globalInfo.getLastpwdchgtm());
						if (between > globalInfo.getEffectiveDay() && globalInfo.getEffectiveDay() >= 0) {
							globalInfo.setPswdForcedToChange(true);//超过N久没修改密码,要强制修改
						}
					}
					if (globalInfo.isPswdForcedToChange()) {
						((HttpServletResponse)resp).getWriter().print("<script>top.location='" + request.getContextPath() + "/fpages/management/ftl/ChangePwd.ftl';</script>");
						return;
					}
					/***add by ningpeng 2012-11-7 增加签退过滤 begin*/
					String tlrNo = globalInfo.getTlrno();
					String sta = userService.getUserLoginStatus(tlrNo);
					if (sta==null || SystemConstant.TLR_NO_STATE_LOGOUT.equals(sta)) {
						((HttpServletResponse) resp).sendRedirect(request.getContextPath() + "/common/success.jsp?type=signout");
						return;
					}
					/***add by ningpeng 2012-11-7 增加签退过滤 end*/
				}
				/** add by zhaozhiguo 2011-6-20 BMS-3153 end */
			}else{
				if(expiredSystem((HttpServletRequest) req,
						(HttpServletResponse) resp)){
					return;
				}
			}
		}else{
			if(expiredSystem((HttpServletRequest) req,
					(HttpServletResponse) resp)){
				return;
			}
		}
		filterChain.doFilter(req, resp);
	}

	private boolean expiredSystem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uriStr = StringUtils.substringAfterLast(req.getServletPath(), "/");
		if (StringUtils.indexOf(loginRef, uriStr)==-1) {
			resp.setHeader("Pragma", "No-cache");
			resp.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
			resp.setDateHeader("Expires", 1);
			RequestDispatcher rd = (req)
					.getRequestDispatcher(expiredPageName);
			rd.forward(req, resp);
			return true;
		}
		return false;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;
	}

}