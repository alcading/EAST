package com.huateng.report.scheduler.job;

import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.report.ReportJobConfig;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;


/**
 * 数据分析定时任务
 */
public class DataAnalyzeJob implements Job {
	private Logger log = Logger.getLogger(this.getClass());

	public static final String ANZ_ANALY_ISFIN = "ANZ_ANALY_ISFIN";

	public void execute(JobExecutionContext context) throws JobExecutionException {
		String onOff = ReportUtils.getSysParamsValue("ANZ", "0001", "OFF");//是不是要双重控制定时任务的执行
		if ("ON".equalsIgnoreCase(onOff)) {
			ServletContext serContext = null;
			String result = null;
			Date startTm = null;
			Date endTm = null;
			String jobName = null;
			String jobId = null;
			String remark = "";
			try {
				serContext = (ServletContext) context.getScheduler().getContext().get("serContext");
				jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, jobId);
				jobName = jobConfig.getJobName();
				boolean isdo = ReportJobUtil.isDoTaskJob(serContext, ANZ_ANALY_ISFIN, jobConfig);
				//先判断是不是在执行定时任务,如果是,不执行
				remark = jobConfig.getJobRemark();
				if (isdo) {
					startTm = new Date();
					serContext.setAttribute(ANZ_ANALY_ISFIN, false);//先将他设置为未执行完
					log.info("==澳新数据分析定时任务begin==");
//					AnalyDate analyDateJob = new AnalyDate();
					//analyDateJob.doProcess();
					log.info("==澳新数据分析定时任务end==");
					endTm = new Date();
					result = ReportEnum.REPORT_RESULT.SUCCESS.value;
					serContext.setAttribute(ANZ_ANALY_ISFIN, true);//设置为执行完
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("澳新数据分析定时任务异常" + e.getMessage());
				serContext.setAttribute(ANZ_ANALY_ISFIN, true);
				result = ReportEnum.REPORT_RESULT.FAILD.value;
				remark+= ":澳新数据分析定时任务异常,"+e.getMessage();
			}
			ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId, result, jobName, remark);
		}
	}
}
