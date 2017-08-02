package com.huateng.report.genupreportfile.utils;

import java.util.Collection;

import javax.servlet.ServletContext;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.context.ServletContextAware;

/**
 * 监听事件
 *
 * @author peng.ning
 */
public class NotifyClient implements ApplicationListener, ServletContextAware {
	private ServletContext context = null;

	public void setServletContext(ServletContext ctx) {
		this.context = ctx;
	}

	@SuppressWarnings("unchecked")
	public void onApplicationEvent(ApplicationEvent event) {
		String eventMsg = event.getSource().toString();
		ServerContext serverCtx = ServerContextFactory.get(context);
		if (serverCtx!=null) {
			Collection<ScriptSession> sessions = serverCtx.getScriptSessionsByPage(context.getContextPath()+ "/fpages/genupreportfile/jsp/createSubFileInfo.jsp");
			for (ScriptSession scs : sessions) {
				if (scs != null && !scs.isInvalidated()) {
					ScriptBuffer script = new ScriptBuffer();
					script.appendScript("showFileMsg(");
					script.appendData(eventMsg);
					script.appendScript(")");
					scs.addScript(script);
				}
			}
		}
	}

}
