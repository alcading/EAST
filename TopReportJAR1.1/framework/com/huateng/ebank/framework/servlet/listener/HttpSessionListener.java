package com.huateng.ebank.framework.servlet.listener;

import javax.servlet.http.HttpSessionEvent;

public class HttpSessionListener implements
		javax.servlet.http.HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		/*
		UserSessionInfo userSessionInfo = (UserSessionInfo)arg0.getSession().getAttribute(LoginManagerOP.OUT_USER_SESSION_INFO);
		SessionCheck.getInstance().delSession(userSessionInfo.getUserid());
		*/
	}

}
