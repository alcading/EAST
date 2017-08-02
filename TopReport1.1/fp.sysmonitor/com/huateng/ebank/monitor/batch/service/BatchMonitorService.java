package com.huateng.ebank.monitor.batch.service;

import java.util.ArrayList;
import java.util.List;

import resource.bean.pub.BhProcStatus;
import resource.bean.pub.BhProcStep;
import resource.dao.pub.BhProcStepDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.monitor.batch.bean.BatchConstant;
import com.huateng.ebank.monitor.batch.bean.BatchInfo;
import com.huateng.ebank.monitor.batch.bean.BatchStepInfo;
import com.huateng.ebank.monitor.batch.bean.Holiday;

/**
 * 批量监控service
 */
public class BatchMonitorService {
	protected BatchMonitorService() {
	}

	/* get instance */
	public static synchronized BatchMonitorService getInstance() {
		return (BatchMonitorService) ApplicationContextUtils
				.getBean(BatchMonitorService.class.getName());
	}

	/** 获得批量步骤列表 */
	public List getBatchStepList(String bhDate, String statusCode)
			throws Exception {
		List<BatchStepInfo> result=new ArrayList<BatchStepInfo>();
		List<BhProcStep> stepInfoList;
		BhProcStatus stepStatus;
		BhProcStepDAO dao=BaseDAOUtils.getBatchProcessStepDAO();

		Holiday holiday = new Holiday(bhDate);
		List<String> runtimes = new ArrayList<String>();

		runtimes.add(BatchConstant.SUB_STEP_RUN_TIME_DAILY);// 添加日运行
		runtimes.add(holiday.getDay_of_month()+"");
		runtimes.add(holiday.getDay_of_week()+"");
		if (holiday.isaPeriodOfTenDays()) {// 每旬
			runtimes.add(BatchConstant.SUB_STEP_RUN_TIME_EVERY_TEN_DAYS);
		} else if (holiday.isHalfYearEnd()) {// 半年
			runtimes.add(BatchConstant.SUB_STEP_RUN_TIME_EVERY_HALF_YEAR);
		}else if(holiday.isMonthEnd()){//月末
			runtimes.add(BatchConstant.SUB_STEP_RUN_TIME_MONTHLY);
		}else if(holiday.isSeasonEnd()){//季末
			runtimes.add(BatchConstant.SUB_STEP_RUN_TIME_EVERY_SEASON);
		}else if(holiday.isYearEnd()){//年末
			runtimes.add(BatchConstant.SUB_STEP_RUN_TIME_YEARLY);
		}

	    stepInfoList=dao.findStepsByRuntimes(runtimes);

		BatchInfo batchInfo=new BatchInfo();//总批量信息
		batchInfo.setBhDate(bhDate);
		batchInfo.setStepList(result);

		for(BhProcStep step:stepInfoList){
			//step.setBhDate(bhDate);
			stepStatus= dao.findStatusByStep(step,bhDate);
			BatchStepInfo stepBean=new BatchStepInfo();
			stepBean.setJobNo(step.getJobno());
			stepBean.setStepNo(step.getStep());
			stepBean.setSubStepNo(step.getSubStep());
			stepBean.setSuspendCode(step.getSuspend());
			stepBean.setSubStepName(step.getDesc0());
			if(stepStatus!=null){
			stepBean.setStatusCode(stepStatus.getStatus());
			/*modified by Chengyu.LI 20091224 BMS-2340 begin*/
			stepBean.setStartTime(DateUtil.Time14ToString(stepStatus.getStartTime()));
			stepBean.setEndTime(DateUtil.Time14ToString(stepStatus.getEndTime()));
			/*modified by Chengyu.LI 20091224 BMS-2340 end*/
			}

			stepBean.setBatchInfo(batchInfo);

			if(statusCode==null || statusCode.equals(stepBean.getStatusCode())){
			result.add(stepBean);
			}
		}

		return result;
	}

	public List getBatchStepList(String bhDate) throws Exception {
		return getBatchStepList(bhDate, null);
	}
}
