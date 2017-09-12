package com.huateng.ebank.framework.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huateng.ebank.business.innerinterface.ITimedScheduler;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.service.pub.QryExpThreadPoolExecutor;
import com.huateng.util.ContextUtil;


public class ContextLoaderListener implements ServletContextListener{
	private static Log logger = LogFactory.getLog(ContextLoaderListener.class);

	public ContextLoaderListener() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void contextInitialized(ServletContextEvent event)
	{
		ServletContext context = event.getServletContext();
		try{


//初始化spring的上下文,并将它赋给ApplicationContextUtils util类
			ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
			ApplicationContextUtils.setContext(ctx);
			logger.info("ApplicationContextUtils: 初始化完成...");
			ContextUtil.setContext(ctx);

//启动定时任务类:
			String isStartJob = context.getInitParameter("startJob");
			logger.info("isStartJob: " + isStartJob);
			if(isStartJob.equals("true")){
			ITimedScheduler scheduler=(ITimedScheduler)ContextUtil.getContext().getBean("bopTimedScheduler");
//			ITimedScheduler scheduler=(ITimedScheduler)ctx.getBean("bopTimedScheduler");
			scheduler.run(context);
			}
			/** 扫描批量导出任务表 */
			logger.info("QryExpThreadPoolExecutor: 批量报表线程池启动... ");
			QryExpThreadPoolExecutor.setProducerPool(3,6, 0, 100);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	public void contextDestroyed(ServletContextEvent sce)
	{
		ApplicationContextUtils.close();
	}

}