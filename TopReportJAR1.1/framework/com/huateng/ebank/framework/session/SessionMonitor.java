package com.huateng.ebank.framework.session;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.commquery.result.databus.CommonQueryDataBusMng;
import com.huateng.ebank.business.common.GlobalInfo;

/**
 * Title: com.huateng.ebank.framework.session.SessionMonitor.java Description:
 * TODO Copyright (c) 2006 Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version v1.0,2008-10-6
 */

public class SessionMonitor implements HttpSessionListener {

	private static Log log = LogFactory.getLog(SessionMonitor.class);

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionMonitor:sessionCreated()");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionMonitor:sessionDestroyed()");

		// 注销DataBus中的数据信息
		// 清空TLR_INFO表中的Session Id数据
		// 这个方法被调用是因为调用了session.invalidate()
		// 所以在这里不需要清除SESSION数据,
		// 但是可以在这里清除系统中和这个SESSION相关联的系统资源
		// TODO:

		try {
			HttpSession session = se.getSession();
			GlobalInfo globalInfo = (GlobalInfo) session
					.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			/** 如果操作员仍然处于登录状态的情况下，自定进行签退. */
//			if (globalInfo != null
//					&& globalInfo.getTlrStatus().equals(
//							SystemConstant.TLR_NO_STATE_LOGIN)) {
//				GlobalInfo.setCurrentInstance(globalInfo);
//				OperationContext operContext = new OperationContext();
//				OPCaller.call(LogoutManagerOP.ID, operContext);
//			}
			/** . */
			/** destory common query databus. */
			CommonQueryDataBusMng.destory(se.getSession().getId(), se
					.getSession());
			// 使session无效，释放资源
			String strAttrName = null;
			Enumeration names = session.getAttributeNames();
			while (names.hasMoreElements()) {
				strAttrName = (String) names.nextElement();
				session.removeAttribute(strAttrName);
			}
		} catch (Exception ex) {
			log.error("BankHttpSessionListener:sessionDestroyed error", ex);
		}
	}

}