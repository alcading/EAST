package com.huateng.report.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.web.struts.BaseAction;

public class NavigationAction extends BaseAction {
	private static final Log logger = LogFactory.getLog(NavigationAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward actionForward = null;

		String type = request.getParameter("type");

		logger.info("forward funcid="+type);

		GlobalInfo globalInfo = (GlobalInfo) request.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		globalInfo.setMenuCode(type);
		GlobalInfo.setCurrentInstance(globalInfo);

		actionForward = mapping.findForward("Report"+type);

		return actionForward;

	}
}
