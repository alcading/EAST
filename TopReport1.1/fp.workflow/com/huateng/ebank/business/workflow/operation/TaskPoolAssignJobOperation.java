package com.huateng.ebank.business.workflow.operation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import resource.dao.pub.TlrWorkloadDAO;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.taskassign.TaskAssignService;
import com.huateng.ebank.business.workflow.bean.WorkFlowForwardTaskBean;
import com.huateng.ebank.business.workflow.service.WorkFlowService;
import com.huateng.ebank.entity.dao.workflow.WorkflowTaskPoolDAO;
import com.huateng.ebank.entity.data.TlrWorkload;
import com.huateng.ebank.entity.data.workflow.WorkflowTaskPool;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * Title: com.huateng.ebank.business.workflow.operationGetTaskListOperation.java
 * Description: 获取工作列表OP Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd.
 * @author kangbyron
 * @version v1.0,2011-2-25
 */
public class TaskPoolAssignJobOperation extends BaseOperation {
	public static final String ID = "WorkFlow.TaskPoolAssignJobOperation";

	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		WorkFlowService workFlowService = WorkFlowService.getInstance();
		WorkflowTaskPoolDAO taskPoolDAO = DAOUtils.getWorkflowTaskPoolDAO();
		TlrWorkloadDAO tlrWorkloadDAO = DAOUtils.getTlrWorkloadDAO();
		//查询未分配的任务
		List taskList = taskPoolDAO.queryByCondition("po.assignFlag ='"+SystemConstant.TASKPOOL_UNASSIGN+"'");
		for (int i = 0; i < taskList.size(); i++) {
			WorkflowTaskPool pool = (WorkflowTaskPool)taskList.get(i);
			//查询待分配操作员的任务
			String hsql = "po.tlrno in ('" + pool.getTlrnoList().replaceAll(",", "','") + "')";
			hsql +=" and po.restWl < po.maxWl ";//剩余工作量必须小于阀值 add by kangbyron
			hsql += " order by restWl";
			List<TlrWorkload> tlrWorkloadList = tlrWorkloadDAO
					.queryByCondition(hsql);
			long min_rest_wl = 0;
			List<String> disTlrnoList = new ArrayList<String>();
			if(tlrWorkloadList.size()==0){//没有可分配的操作员都达到了审批阀值,暂时报错,后续加入待审批池
				continue;
			}else{
				// 最小剩余工作量
				List<String> minTlrnoList = new ArrayList<String>();
				min_rest_wl = tlrWorkloadList.get(0).getRestWl();
				for (TlrWorkload tlrWorkload : tlrWorkloadList) {
					if (tlrWorkload.getRestWl() == min_rest_wl) {
						minTlrnoList.add(tlrWorkload.getTlrno().trim());
					} else {
						break;
					}
				}
				disTlrnoList = minTlrnoList;
			}
			// 随机分配
			Random random = new Random(System.currentTimeMillis());
			int rand = random.nextInt(disTlrnoList.size());
			String disTlrno = disTlrnoList.get(rand).trim();
			//分给该操作员
			pool.setTlrno(disTlrno);
			pool.setAssignFlag(SystemConstant.TASKPOOL_ASSIGNED);
			pool.setAssignTime(new Timestamp(System.currentTimeMillis()));//时间戳
			pool.setTimestamps(new Timestamp(System.currentTimeMillis()));//时间戳
			taskPoolDAO.update(pool);
			//工作流任务分配
			WorkFlowForwardTaskBean workFlowForwardTaskBean =
				new WorkFlowForwardTaskBean(disTlrno, disTlrno, disTlrno);
			workFlowForwardTaskBean.setProcInsId(pool.getProcInsId());
			workFlowForwardTaskBean.setTaskName(pool.getTaskName());
			workFlowForwardTaskBean.setTaskId(pool.getTaskId());
			workFlowService.forwardTask(workFlowForwardTaskBean);
			//记录TLR_WORKLOAD表该操作员工作量统计表
			TaskAssignService taskAssignService = TaskAssignService.getInstance();
			taskAssignService.insertOrUpdateTlrWorkload(disTlrno,
					null,
					null,
					SystemConstant.TASK_ASSIGN_MODE_1,
					false,false);
		}
	}
}
