package com.huateng.ebank.business.workflow.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import resource.bean.pub.TlrInfo;
import resource.dao.base.HQLDAO;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.business.management.service.TlrInfoExService;
import com.huateng.ebank.business.workflow.bean.GetTaskRequestBean;
import com.huateng.ebank.business.workflow.bean.TaskBean;
import com.huateng.ebank.business.workflow.bean.WorkFlowForwardTaskBean;
import com.huateng.ebank.entity.dao.workflow.WorkFlowDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowTaskInfoDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowParam;
import com.huateng.ebank.entity.data.workflow.WorkflowTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.topbpm.commonface.base.WIPageQueryResult;
import com.huateng.topbpm.commonface.base.WITask;
import com.huateng.topbpm.commonface.topbpm.TOPBPMWITask;

/**
 * Title: com.huateng.ebank.business.workflow.serviceWorkFlowService.java
 * Description: 工作流服务 Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version v1.0,2008-7-17
 */
public class WorkFlowService {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(WorkFlowService.class);

	public WorkFlowService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get instance of log seq service
	 *
	 * @return
	 */
	public synchronized static WorkFlowService getInstance() {
		return (WorkFlowService) ApplicationContextUtils
				.getBean(WorkFlowService.class.getName());
	}



	/**modified by jornezhang 20100806 工作流分页查询 begin
	 *
	 * //GetTaskRequestBean 需要扩充 传入 pageIndex、pageSize 和过滤出条件
			Integer pageIndex = 1;
			Integer pageSize = 1;
			Map transMap = new HashMap();

			//过滤条件例子 根据传入的协议号 like 查询
			/*String inTransno = request.getTransno();
			if(!StringUtils.isEmpty(inTransno)){
				transMap.put("LK{TRANSNO}", inTransno);
			}
			//过滤条件例子 根据客户号 = 查询
			String incustcd= request.getCstcd();
			if(!StringUtils.isEmpty(custcd)){
				transMap.put("EQ{CUSTCD}", incustcd);
			}
	 *
	 * */
	/**
	 * Description: 获取任务列表
	 *
	 * @param GetTaskRequestBean
	 * @return List
	 * @exception
	 * @author shen_antonio
	 * @version v1.0,2008-7-16
	 */
	public PageQueryResult getTaskList(GetTaskRequestBean request, String taskState)
			throws CommonException {
		List taskList = new ArrayList();
		PageQueryResult returnPageQueryResult = new PageQueryResult();
		try {
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = DAOUtils.getWorkFlowDAO();

			// 获取工作流参数，userName
			String userName = request.getTlrno();
			String password = null;
			String version = null;
			String flowName = request.getFlowName();
			TlrInfoExService tlrInfoExService = TlrInfoExService.getInstance();
			TlrInfo tlrInfo = tlrInfoExService.getTlrInfoByTlrno(userName);
			String contractno = request.getContractno();
			String brcode = request.getBrcode();

			//GetTaskRequestBean 需要扩充 传入 pageIndex、pageSize 和过滤出条件
			Integer pageIndex = request.getPageIndex();
			Integer pageSize = request.getPageSize();
			Map transMap = new HashMap();

			//过滤条件例子 根据传入的协议号 like 查询
			/*String inTransno = request.getTransno();
			if(!StringUtils.isEmpty(inTransno)){
				transMap.put("LK{TRANSNO}", inTransno);
			}
			//过滤条件例子 根据客户号 = 查询
			String incustcd= request.getCstcd();
			if(!StringUtils.isEmpty(custcd)){
				transMap.put("EQ{CUSTCD}", incustcd);
			} */
			if(!DataFormat.isEmpty(contractno)){
				transMap.put("LK{CONTRACTNO}", contractno);
			}

			if(!DataFormat.isEmpty(brcode)){
				transMap.put("LK{STARTBRCODE}", brcode);
			}
			// 返回taskList
			WIPageQueryResult result = workFlowDAO.getTaskList(userName, password, flowName,version, taskState,pageIndex,pageSize,transMap);
			List list = result.getQueryResult();
			for (int i = 0; i < list.size(); i++) {
				TOPBPMWITask wITask = (TOPBPMWITask) list.get(i);
				Map map = wITask.getValueMap();
				WorkflowTaskInfo info = WorkflowTaskInfoService.getInstance()
						.findTaskInfo((String) map.get("APPNO"),
								(String) map.get("APPTYPE"),
								wITask.getTaskName(), wITask.getProcName(),
								wITask.getProcInsId());
//				if (info !=null && info.getWorkflowRole() != null
//						&& !info.getWorkflowRole().equals("ROLE" + curRole))//当前角色不等于工作流角色
//					continue;
//				else {
				TaskBean taskBean = new TaskBean();
				taskBean.setAppno((String) map.get("APPNO"));
				taskBean.setAppType((String) map.get("APPTYPE"));
				taskBean.setBrcode((String) map.get("BRCODE"));
				taskBean.setBrclass((String) map.get("BRCLASS"));
				taskBean.setComment((String) map.get("COMMENT"));
				taskBean.setContractno((String) map.get("CONTRACTNO"));
				taskBean.setCustno((String) map.get("CUSTCD"));
				taskBean.setStatus((String) map.get("STATUS"));
				taskBean.setStatusList((String) map.get("STATUS_LIST"));
//				taskBean.setProcName((String)map.get("FLOWNAME"));
				taskBean.setBrcode((String)map.get("STARTBRCODE"));//需要确认
				taskBean.setTxnamt((String) map.get("TXNAMT"));
				taskBean.setSystype((String)map.get("SYSTYPE"));//判断是个贷还是企贷，1 是企贷 2 是个贷
				taskBean.setOwner(wITask.getOwner());//工作流拥有者
				taskBean.setPiid(wITask.getProcInsId());
				taskBean.setProcName(wITask.getProcName());
/* add by haizhou.li 2010-11-20 经办任务中列表的时间显示统计到时间层 begin */
				taskBean.setTaskStartTime(DateUtil.Time14ToString2(info.getTaskStartTime()));
				taskBean.setTaskEndTime(DateUtil.Time14ToString2(wITask.getTaskEndTime()));
/* add by haizhou.li 2010-11-20 经办任务中列表的时间显示统计到时间层 begin */
				taskBean.setTaskId(wITask.getTaskId());
				taskBean.setTaskName(wITask.getTaskName());
				taskBean.setTaskState(wITask.getTaskState());
				taskBean.setUserName(wITask.getUserName());
				taskBean.setOwner(info.getTlrnoList());

				//add by kangbyron 2011-03-15 增加审批时效
				try{
					WorkflowParam workflowParam = (WorkflowParam)DAOUtils.getWorkflowParamDAO().queryByCondition("po.processTemplate='"
							+wITask.getProcName()+"' and po.taskName='"+wITask.getTaskName()+"'").get(0);
					Integer limitation = workflowParam.getLimitation();
					long currTime = System.currentTimeMillis();
					long endTime = info.getTaskStartTime().getTime()+limitation*3600*1000;
					long leftTime = endTime-currTime;
					String leftTimeString = DateUtil.getProcTime(leftTime);
					String endTimeString = DateUtil.Time14ToString2(new Time(endTime));
					taskBean.setLimitEndTime(endTimeString);
					taskBean.setLimitLeftTime(leftTimeString);

				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					logger.info("审批时效显示失败!不影响业务");
				}

				taskList.add(taskBean);


				//WorkFlowParamService.getInstance().getAllTaskAssignOprList("170479");
			}
//			}
			returnPageQueryResult.setQueryResult(taskList);
			returnPageQueryResult.setTotalCount(result.getTotalCount());

		} catch (Exception ex)
		{
			System.out.println("@@@@@@@@@@@@@:");
			ex.printStackTrace();
//			ExceptionUtil.throwCommonException(ex.getMessage(),
//					ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR, ex);
		}
		return returnPageQueryResult;

	}

	/**
	 * Description: 获取任务列表
	 *
	 * @param GetTaskRequestBean
	 * @return List
	 * @exception
	 * @author shen_antonio
	 * @version v1.0,2008-7-16
	 */
	public PageQueryResult getTaskListByTlrno(GetTaskRequestBean request)
			throws CommonException {
		List taskList = new ArrayList();
		PageQueryResult returnPageQueryResult = new PageQueryResult();
		try {
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = DAOUtils.getWorkFlowDAO();

			// 获取工作流参数，userName
			String tlrno = request.getTlrno();
			String password = null;
			String version = null;
			String flowName = request.getFlowName();
			TlrInfoExService tlrInfoExService = TlrInfoExService.getInstance();
//			String tlrno = tlrInfoExService.getTlrno(userName);
			TlrInfo tlrInfo = tlrInfoExService.getTlrInfoByTlrno(tlrno);
			String curRole = String.valueOf(tlrInfo.getRoleid().intValue());

			//GetTaskRequestBean 需要扩充 传入 pageIndex、pageSize 和过滤出条件
			Integer pageIndex = 1;
			Integer pageSize = 1;
			Map transMap = new HashMap();

			//过滤条件例子 根据传入的协议号 like 查询
			/*String inTransno = request.getTransno();
			if(!StringUtils.isEmpty(inTransno)){
				transMap.put("LK{TRANSNO}", inTransno);
			}
			//过滤条件例子 根据客户号 = 查询
			String incustcd= request.getCstcd();
			if(!StringUtils.isEmpty(custcd)){
				transMap.put("EQ{CUSTCD}", incustcd);
			} */

			String taskState=null;
			// 返回taskList
			WIPageQueryResult result = workFlowDAO.getTaskList(tlrno, password,
			 taskState,pageIndex,pageSize,transMap);
			//List list = workFlowDAO.getTaskList(userName, password, flowName,
			//		version, taskState);
			List list = result.getQueryResult();
			for (int i = 0; i < list.size(); i++) {
				TOPBPMWITask wITask = (TOPBPMWITask) list.get(i);
				Map map = wITask.getValueMap();
				WorkflowTaskInfo info = WorkflowTaskInfoService.getInstance()
						.findTaskInfo((String) map.get("APPNO"),
								(String) map.get("APPTYPE"),
								wITask.getTaskName(), (String)map.get("FLOWNAME"),
								wITask.getProcInsId());
				if (info.getWorkflowRole() != null
						&& !info.getWorkflowRole().equals("ROLE" + curRole))
					continue;
				else {
					TaskBean taskBean = new TaskBean();
					taskBean.setAppno((String) map.get("APPNO"));
					taskBean.setAppType((String) map.get("APPTYPE"));
					taskBean.setBrcode((String) map.get("BRCODE"));
					taskBean.setBrclass((String) map.get("BRCLASS"));
					taskBean.setComment((String) map.get("COMMENT"));
					taskBean.setContractno((String) map.get("CONTRACTNO"));
					taskBean.setCustno((String) map.get("CUSTNO"));
					taskBean.setPiid(wITask.getProcInsId());
					taskBean.setProcName(wITask.getProcName());
					taskBean.setStatus((String) map.get("STATUS"));
					taskBean.setStatusList((String) map.get("STATUS_LIST"));
					taskBean.setTaskEndTime(DateUtil.dateToString(wITask
							.getTaskEndTime()));
					taskBean.setTaskId(wITask.getTaskId());
					taskBean.setTaskName(wITask.getTaskName());
					taskBean.setTaskStartTime(DateUtil.dateToString(wITask
							.getTaskStartTime()));
					taskBean.setTaskState(wITask.getTaskState());
					taskBean.setTxnamt((String) map.get("TXNAMT"));
					taskBean.setUserName(wITask.getUserName());
					taskList.add(taskBean);
				}
			}
			returnPageQueryResult.setQueryResult(taskList);
			returnPageQueryResult.setTotalCount(result.getTotalCount());

		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR, ex);
		}
		return returnPageQueryResult;

	}

//	/**
//	 * Description: 获取已经完成的任务列表
//	 *
//	 * @param GetTaskRequestBean
//	 * @return List
//	 * @exception CommonException
//	 * @author shen_antonio
//	 * @version v1.0,2008-7-17
//	 */
//	public List getFinishedTaskList(GetTaskRequestBean request)
//			throws CommonException {
//		return getTaskList(request, WorkFlowHelper.getFinishedState());
//	}

	/**
	 * Description: 获取未完成的任务列表
	 *
	 * @param GetTaskRequestBean
	 * @return List
	 * @exception CommonException
	 * @author shen_antonio
	 * @version v1.0,2008-7-17
	 * inuse
	 */
	public PageQueryResult getUnFinishedTaskList(GetTaskRequestBean request)
			throws CommonException {
		return getTaskList(request, null);
	}

	/**modified by jornezhang 20100806 工作流分页查询 end*/



	/**
	 *
	 * Description: 获得任务
	 *
	 * @param taskId
	 *            任务编号
	 * @return TaskBean 任务
	 * @exception
	 * @author mengyf
	 * @version v1.0,2008-8-16
	 */
	public TaskBean getTaskBean(String taskId) throws CommonException {
		TaskBean taskBean = new TaskBean();
		try {
			// 调用工作流层接口获取任务信息
			WorkFlowDAO workFlowDAO = DAOUtils.getWorkFlowDAO();
			Map map = workFlowDAO.getValue(taskId);
			WITask task = workFlowDAO.getTask(taskId);
			// 将map中的任务信息赋给TaskBean
			String brcode = (String) map.get("BRCODE");
			String brclass = (String) map.get("BRCLASS");
			String appno = (String) map.get("APPNO");
			String appType = (String) map.get("APPTYPE");
			String contractno = (String) map.get("CONTRACTNO");
			String txnamt = (String) map.get("TXNAMT");
			String statusList = (String) map.get("STATUS_LIST");
			String comment = (String) map.get("COMMENT");
			String status = (String) map.get("STATUS");
			String piid = task.getProcInsId();
			String procName = task.getProcName();
			String taskName = task.getTaskName();
			/*
			 * author:yangyong
			 * @start data:20100722
			 * 取消时获取当前用户
			 */
			String userName = task.getUserName();
			String taskStartTime = (String) map.get("TASKSTARTTIME");
			String taskEndTime = (String) map.get("TASKENDTIME");
			String taskState = task.getTaskState();
			String custno = (String) map.get("CUSTNO");
			taskBean.setAppno(appno);
			taskBean.setAppType(appType);
			taskBean.setBrclass(brclass);
			taskBean.setBrcode(brcode);
			taskBean.setComment(comment);
			taskBean.setContractno(contractno);
			taskBean.setCustno(custno);
			taskBean.setPiid(piid);
			taskBean.setProcName(procName);
			taskBean.setStatus(status);
			taskBean.setStatusList(statusList);
			taskBean.setTaskId(taskId);
			taskBean.setTaskName(taskName);
			taskBean.setTaskStartTime(taskStartTime);
			taskBean.setTaskState(taskState);
			taskBean.setTxnamt(txnamt);
			taskBean.setUserName(userName);
			taskBean.setTaskEndTime(taskEndTime);
			// 返回TaskBean

		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR, ex);
		}
		return taskBean;
	}


	/**
	 * 根据岗位编号和机构编号获取操作员列表
	 *
	 * @param roleId
	 * @param brcodeList
	 * @return
	 * @throws CommonException
	 */
	public String getTlrnoList(String roleId, String[] brcodeList)
			throws CommonException {
		String tlrnoList = "";
		String brcode = "";
		HQLDAO dao = DAOUtils.getHQLDAO();
		try {
			for (int i = 0; i < brcodeList.length; i++) {
				brcode = brcodeList[i];
				String hql = "select tlr.tlrno,tlr.brcode from TlrInfo as tlr,TlrRoleRelation as rela where tlr.tlrno=rela.tlrno and rela.roleId="
						+ roleId + " and tlr.brcode='" + brcode + "'";
				Iterator it = dao.queryByQL(hql);
				while (it.hasNext()) {
					Object[] result = (Object[]) it.next();
					if (tlrnoList.equals("")) {
						tlrnoList = ((String) result[0]).trim();
					} else
						tlrnoList = tlrnoList + ","
								+ ((String) result[0]).trim();
				}
			}
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return tlrnoList;
	}

//	public String getTOPBPMStatus(String status, String isApprove) {
//		String statusName = "";
//		if (status.equals(WorkFlowHelper.STATUS_Agree)) {
//			if (isApprove != null && isApprove.equals("1"))
//				statusName = "ToEnd";
//			else
//				statusName = "AgreeToNext";
//		}
//		else if (status.equals(WorkFlowHelper.STATUS_Rollback))
//			statusName = "GoBack";
//		else if (status.equals(WorkFlowHelper.STATUS_Refuse)||status.equals(WorkFlowHelper.STATUS_StopProcess))
//			statusName = "ToEnd";
//		else if(status.equals(WorkFlowHelper.STATUS_AgreeUpload))
//			statusName="AgreeToNext";
//		return statusName;
//	}

	/**
	 * 任务移交
	 * @param workFlowForwardTaskBean
	 * @throws CommonException
	 */
	public  void forwardTask(WorkFlowForwardTaskBean workFlowForwardTaskBean)throws CommonException{
		WorkflowTaskInfoDAO workflowTaskInfoDAO = DAOUtils.getWorkflowTaskInfoDAO();
		WorkflowTaskInfo workflowTaskInfo = null;
		WorkFlowDAO workFlowDAO = DAOUtils.getWorkFlowDAO();
		try{
			workflowTaskInfo =workflowTaskInfoDAO.queryByTask(workFlowForwardTaskBean.getTaskName(),workFlowForwardTaskBean.getProcInsId());

			if( workflowTaskInfo.getTaskEndFlag().equals(SystemConstant.FLAG_ON)){
				ExceptionUtil.throwCommonException("该[proc_ins_id = " + workFlowForwardTaskBean.getProcInsId() +
						" , task_id = " + workFlowForwardTaskBean.getTaskId() + "]任务已在" +
						workflowTaskInfo.getTaskEndTime() + "完成",
						ErrorCode.ERROR_CODE_TASK_FORWARD_ERROR);
			}
			//更新分配操作员
			workflowTaskInfo.setTlrno(workFlowForwardTaskBean.getTlrno());
			workflowTaskInfoDAO.update(workflowTaskInfo);
			workFlowDAO.forwardTask(workFlowForwardTaskBean.getTaskId(), workFlowForwardTaskBean.getTlrno());

		}catch(CommonException cex){
			throw cex;
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_FORWARD_ERROR);
		}
	}

}
