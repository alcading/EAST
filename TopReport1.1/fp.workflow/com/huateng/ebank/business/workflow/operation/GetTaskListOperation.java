package com.huateng.ebank.business.workflow.operation;

import com.huateng.commquery.result.Page;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.workflow.bean.GetTaskRequestBean;
import com.huateng.ebank.business.workflow.service.WorkFlowService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * Title: com.huateng.ebank.business.workflow.operationGetTaskListOperation.java
 * Description: 获取工作列表OP Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version v1.0,2008-7-17
 */
public class GetTaskListOperation extends BaseOperation {
	public static final String ID = "WorkFlow.GetTaskListOperation";
	public static final String REQ_TASK_NM = "REQ_TASK_NM";
	public static final String REQ_FLOW_NM = "REQ_FLOW_NM";
	public static final String REQ_FLOW_VERSION = "REQ_FLOW_VERSION";
	public static final String REQ_TLRNO = "REQ_TLRNO";

	public static final String REQ_CONTRACTNO = "REQ_CONTRACTNO";

	public static final String RSP_TASK_LIST = "RSP_TASK_LIST";

	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String taskNm = (String) context.getAttribute(REQ_TASK_NM);
		String flowNm = (String) context.getAttribute(REQ_FLOW_NM);
		String flowVersion = (String) context.getAttribute(REQ_FLOW_VERSION);
		String tlrno = (String) context.getAttribute(REQ_TLRNO);
		String contractno = (String) context.getAttribute(REQ_CONTRACTNO);
		Page page = (Page)context.getAttribute("Page");
		GetTaskRequestBean getTaskRequestBean = new GetTaskRequestBean(tlrno);
		getTaskRequestBean.setFlowName(flowNm);
		getTaskRequestBean.setVersion(flowVersion);
		getTaskRequestBean.setTaskName(taskNm);
		getTaskRequestBean.setPageIndex(page.getCurrentPage());
		getTaskRequestBean.setPageSize(page.getEveryPage());
		getTaskRequestBean.setContractno(contractno);

		WorkFlowService workflowService = WorkFlowService.getInstance();
		PageQueryResult taskList = workflowService
				.getUnFinishedTaskList(getTaskRequestBean);
//		List returnList = new ArrayList();
//		LoancenterService service = LoancenterService.getInstance();
//		for (int i = 0; i < taskList.getQueryResult().size(); i++) {
//			TaskBean taskBean = (TaskBean) taskList.getQueryResult().get(i);
//			TaskBeanQry bean = new TaskBeanQry();
//			bean.setTaskBean(taskBean);
//			List list = service.getContractBusiListById(taskBean.getAppno());
//			bean.getLoanContInfoBean().setContBaseInfo(new ContBaseInfo());
//			boolean delFlag = true;
//			if (list != null && list.size() > 0) {
//				BusinessRela rela = (BusinessRela) list.get(0);
//				if (!StringUtils.isEmpty(rela.getCode())) {
//					ContBaseInfo contBaseInfo = service
//							.getContBaseInfoById(rela.getCode());
//					if (contBaseInfo != null) {
//						delFlag = false;
//						bean.getLoanContInfoBean()
//								.setContBaseInfo(contBaseInfo);
//					}
//				}
//			}
			/**
			 * 为什么在这里 doTask?为了编译通过而删除.
			 */
//			if (delFlag) {
//
//				String taskId = taskBean.getTaskId();
//				String taskState = taskBean.getTaskState();
//				if (taskState.equals(WorkFlowHelper.STATE_READY)) { // CANCELTASK
//					workflowService.claimTask(tlrno, taskId);
//				}
//				DoTaskRequestBean doTaskRequestBean = new DoTaskRequestBean(
//						tlrno, WorkFlowHelper.STATUS_CancelProcess, "0",
//						GlobalInfo.getCurrentInstance().getBrcode(), taskId);
//				try {
//					lservice.delApplyInfoByAppno(taskBean.getAppno());
//					workflowService.doTask(doTaskRequestBean);
//				} catch (Exception e) {
//				}
//				continue;
//			}
//			returnList.add(bean);

//		}
		context.setAttribute(RSP_TASK_LIST, taskList);
	}
}
