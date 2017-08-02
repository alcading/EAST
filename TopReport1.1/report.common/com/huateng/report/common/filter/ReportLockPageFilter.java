package com.huateng.report.common.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.utils.ReportUtils;

public class ReportLockPageFilter implements Filter {
	private static final Logger logger = Logger.getLogger(ReportLockPageFilter.class);
	private static final String LOCK_PAGE = "LOCK_PAGE";
	private static final String LOCK_PAGE_CONFIG = "LOCK_PAGE_CONFIG";

	private FilterConfig filterConfig;
	private boolean islockpage = false;
	private Properties properties = null;

	public void destroy() {
		this.filterConfig = null;
		this.properties = null;
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException,
			ServletException {
		if (islockpage) {
			HttpServletRequest request = (HttpServletRequest) req;
			boolean lock = false;
			String reqUrl = request.getServletPath();
			if (properties.containsKey(reqUrl)) {
				String appType = properties.getProperty(reqUrl);
				if(appType != null && appType.length() > 0){
					try {
						HttpSession httpSession = request.getSession(false);
						if (null != httpSession) {
							Object o = httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
							if (null != o && o instanceof GlobalInfo) {
								GlobalInfo globalInfo = (GlobalInfo) o;
								lock = ReportUtils.isLockByExecByBop(globalInfo, appType);
							}
						}
					} catch (CommonException e) {
						logger.error(e);
						e.printStackTrace();
					}
				} else {
					lock = true;
				}
				if (lock) {
					logger.info(reqUrl + " send to lockpage");
					((HttpServletResponse) resp)
							.sendRedirect(request.getContextPath() + "/login/homepage/lockpage.jsp");
				}
			}
		}
		filterChain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		this.islockpage = Boolean.parseBoolean(this.filterConfig.getInitParameter(LOCK_PAGE));
		if(islockpage){
			String confPath = this.filterConfig.getInitParameter(LOCK_PAGE_CONFIG);
			if (confPath != null && confPath.trim().length() > 0) {
				loadProperties(confPath.trim());
			}
		}
	}

	private void loadProperties(String resourcePath) {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
		if (null == is) {
			throw new RuntimeException("找不到资源文件:" + resourcePath);
		}
		try {
			properties = new Properties();
			properties.load(is);
//			Set<String> set = new HashSet<String>();
//			for (Iterator iterator = properties.keySet().iterator(); iterator.hasNext();) {
//				String name = (String) iterator.next();
//				int ls = name.lastIndexOf("/")+1;
//				String t = name.substring(0,ls)+"*";
//				set.add(t);
//			}
//			for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
//				String name = iterator.next();
//				System.out.println("<filter-mapping>\n<filter-name>lockPageFilter</filter-name>\n<url-pattern>"+name+"</url-pattern>\n</filter-mapping>\n");
//			}
//
//
			logger.info("load properties " + resourcePath);

		} catch (IOException ioe) {
			throw new RuntimeException("不能加载资源文件:" + resourcePath, ioe);
		} finally {
			try {
				is.close();
			} catch (Exception e) {
			}
		}
	}
}
