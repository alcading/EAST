package com.huateng.report.scheduler.job;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.report.ReportJobConfig;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.operation.SingleOPCaller;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.dataClean.bean.ReportDataCleanBean;
import com.huateng.report.dataClean.operation.ReportDataCleanOperation;
import com.huateng.report.dataClean.utils.ReportDataCleanResource;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class DataCleanJob implements Job{
	private Logger log = Logger.getLogger(this.getClass());

	public static final String BOP_DATACLEAN_ISFIN = "BOP_DATACLEAN_ISFIN";

	public void execute(JobExecutionContext context) throws JobExecutionException {
		String onOff = ReportUtils.getSysParamsValue("CLN", "0001", "OFF");
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
				boolean isdo = ReportJobUtil.isDoTaskJob(serContext, BOP_DATACLEAN_ISFIN, jobConfig);
				remark = jobConfig.getJobRemark();
				if (isdo) {
					startTm = new Date();
					serContext.setAttribute(BOP_DATACLEAN_ISFIN, false);
					log.info("==定时数据清理异常begin==");
					String str = doDataClean();
					if (str.length()>0) {
						throw new Exception("错误信息："+str);
					}
					log.info("==定时数据清理异常end==");
					endTm = new Date();
					result = ReportEnum.REPORT_RESULT.SUCCESS.value;
					serContext.setAttribute(BOP_DATACLEAN_ISFIN, true);
				}
			} catch (Exception e) {
				log.error("定时数据清理异常" + e.getMessage());
				result = ReportEnum.REPORT_RESULT.FAILD.value;
				remark+= ":定时数据清理异常,"+e.getMessage();
				serContext.setAttribute(BOP_DATACLEAN_ISFIN, true);
			}
			ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId, result, jobName, remark);
		}
	}

	private String doDataClean(){
		StringBuffer result = new StringBuffer();
		List<ReportDataCleanBean> cleanList = ReportDataCleanResource.getInstance().getTableList();
		for (int i = 0; i < cleanList.size(); i++) {
			ReportDataCleanBean cleanbean = cleanList.get(i);
			log.info("clean table "+cleanbean.getTableName()+"=======start======");
			OperationContext opcontext = new OperationContext();
			try {
				opcontext.setAttribute(ReportDataCleanOperation.IN_OBJ, cleanbean);
				SingleOPCaller.call(ReportDataCleanOperation.ID, opcontext);
			} catch (CommonException e) {
				result.append(" ["+cleanbean.getTableName()+":"+e.getMessage()+"]");
				log.error(cleanbean.getTableName()+"执行数据清理异常："+e.getMessage());
			}
			log.info("clean table "+cleanbean.getTableName()+"=======end======");
		}
		return result.toString();
	}


}
