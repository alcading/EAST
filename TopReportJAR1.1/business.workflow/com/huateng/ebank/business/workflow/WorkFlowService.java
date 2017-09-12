package com.huateng.ebank.business.workflow;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import resource.bean.pub.TlrInfo;
import resource.dao.base.HQLDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.taskassign.TaskAssignService;
import com.huateng.ebank.business.workflow.bean.DoTaskRequestBean;
import com.huateng.ebank.business.workflow.bean.GetTaskRequestBean;
import com.huateng.ebank.business.workflow.bean.TaskBean;
import com.huateng.ebank.business.workflow.bean.WorkFlowDoTaskBean;
import com.huateng.ebank.business.workflow.bean.WorkFlowForwardTaskBean;
import com.huateng.ebank.business.workflow.bean.WorkFlowHelper;
import com.huateng.ebank.business.workflow.bean.WorkFlowStartBean;
import com.huateng.ebank.entity.dao.workflow.WorkFlowDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowInsRouteDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowTaskInfoDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowInsRoute;
import com.huateng.ebank.entity.data.workflow.WorkflowTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.service.pub.TlrInfoService;
import com.huateng.topbpm.commonface.base.WIFlowInstance;
import com.huateng.topbpm.commonface.base.WIPageQueryResult;
import com.huateng.topbpm.commonface.base.WITask;
import com.huateng.topbpm.commonface.exception.WIException;
import com.huateng.topbpm.commonface.topbpm.TOPBPMWITask;

/**
 * Title: WorkFlowService
 * Description: 工作流服务:负责吊起工作流和任务分配
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-3-31
 */
public class WorkFlowService {
	private static final String DEFAULT_ASSIGN = "SYSTEM";

	/** memeber variable: Log　log. */
	private static Log log = LogFactory.getLog(WorkFlowService.class);


	/** memeber variable: WorkFlowService　single. */
	private static WorkFlowService single;

	/**
	 * Default constructor
	 */
	protected WorkFlowService() {
	}

	/**
	 * get instance.
	 * @return
	 */
	public synchronized static WorkFlowService getInstance() {
		/*
		if (null == single) {
			single = new WorkFlowService();
		}
		return single;
		*/
		return (WorkFlowService)ApplicationContextUtils.getBean("WorkFlowService");
	}


	/**
	 * 启动工作流：
	 * 处理流程：
	 * 			请求TaskAssignService服务，获取分配操作员号
	 * 			启动工作流程
	 *  		请求TaskAssignService服务，记录操作员工作量统计表信息
	 * @param wokrFlowStartBean 启动工作流Bean
	 * @return
	 * @throws CommonException
	 */
	public  WIFlowInstance startFlow(WorkFlowStartBean workFlowStartBean)throws CommonException{
		try {
			// 请求任务分配服务，获取对应操作员号或岗位号
			//modify by shen_antonio 20080814 现在任务分配由统一模块处理
			/*
			TaskAssignService taskAssignService = TaskAssignService.getInstance();
			String tlrno = taskAssignService.getAssignToTlrno(workFlowStartBean
					.getTlrnoList(), workFlowStartBean.getWorkType(),
					workFlowStartBean.getAssignMode(), workFlowStartBean
							.isWorkType(), workFlowStartBean.isLv());
			*/
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			// 启动工作流
			List actors = new ArrayList();
//			actors.add(globalInfo.getTlrno());
			WIFlowInstance wiFlowInstance = workFlowDAO.startFlow(globalInfo
					.getTlrno(), "", actors, workFlowStartBean.getFlowName(),
					workFlowStartBean.getVersion(), workFlowStartBean
							.getStatus(), workFlowStartBean.getAttribute(),
					workFlowStartBean.getKey());
			// 请求任务分配服务，记录操作员工作量统计表
			/*modify by shen_antonio 20080814 现在任务分配由统一模块处理
			TaskAssignInfoBean taskAssignInfoBean = new TaskAssignInfoBean(
					wiFlowInstance.getFID(), wiFlowInstance.getNextTaskId(),
					wiFlowInstance.getCurrentUserName(), wiFlowInstance
							.getNextTaskId(),
					workFlowStartBean.getAssignMode(), DEFAULT_ASSIGN,
					workFlowStartBean.getWorkType(), workFlowStartBean
							.getBrcode());
			taskAssignService.assignTask(taskAssignInfoBean);
			*/
			return wiFlowInstance;
		} catch (CommonException cex) {
			throw cex;
		} catch (WIException wex) {
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR);
		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getLocalizedMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR);
		}
		return null;
	}


	/**
	 * 执行任务
	 * 处理流程：
	 * 		 请求TaskAssignService服务，获取分配操作员号
	 *       请求TaskAssignService服务，完成上部任务
	 * 		 调用工作流处理任务，执行该任务
	 *       请求TaskAssignService服务，记录操作员工作量统计表信息
	 * @param workFlowDoTaskBean
	 * @return
	 * @throws CommonException
	 */
	public  WITask doTask1(WorkFlowDoTaskBean workFlowDoTaskBean)throws CommonException{
		try {
//			TaskAssignService taskAssignService = TaskAssignService
//					.getInstance();

			/** add by jornezhang 20100519 BMS-2755 所有审批岗不填写审批结果，直接点击提交，系统报错 begin */
			if(StringUtils.isEmpty(workFlowDoTaskBean.getStatus())){
				throw new WIException("审批结果不能为空!","审批结果不能为空!");
			}
			/** add by jornezhang 20100519 BMS-2755 所有审批岗不填写审批结果，直接点击提交，系统报错 end */

			// 下部任务分配者
			String tlrno = "";
			/** 最后的节点使用.*/
			/*modify by shen_antonio 20080814 现在任务分配由统一模块处理
			if( workFlowDoTaskBean.getTlrnoList() == null || workFlowDoTaskBean.getTlrnoList().size() == 0){
				tlrno = "";
			}else{
				tlrno = taskAssignService.getAssignToTlrno(
					workFlowDoTaskBean.getTlrnoList(), workFlowDoTaskBean
							.getWorkType(), workFlowDoTaskBean.getAssignMode(),
					workFlowDoTaskBean.isWorkType(), workFlowDoTaskBean.isLv());
			}
			*/
			List actors = new ArrayList();
//			actors.add(tlrno);
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			GlobalInfo globalData = GlobalInfo.getCurrentInstance();

			//得到当前时间(系统时间的date+系统时间的time)
			Calendar rightNow = Calendar.getInstance();
			rightNow.set(globalData.getTxdate().getYear(), globalData.getTxdate()
					.getMonth(), globalData.getTxdate().getDate(), globalData
					.getTxtime().getHours(), globalData.getTxtime().getMinutes(),
					globalData.getTxtime().getSeconds());
			//完成任务，记录操作员工作量统计表
//			TaskFinishBean taskFinishBean =
//				new TaskFinishBean(workFlowDoTaskBean.getProcInsId(),
//						workFlowDoTaskBean.getTaskId(),workFlowDoTaskBean.getAssignMode(),
//						workFlowDoTaskBean.getTlrno(),workFlowDoTaskBean.getWorkType(),workFlowDoTaskBean.getBrcode());
//			taskAssignService.doFinishTask(taskFinishBean);
			//更新流程参数中的上个任务
			String taskId = workFlowDoTaskBean.getTaskId();
			String lastTask = this.getTask(taskId).getTaskName();
			Map  map = getTaskValue(taskId);
			/* 处理不同的退回类型 */
			if(WorkFlowServiceHelper.WORKFLOW_TRANS_GOBACK_RETURN.equals(workFlowDoTaskBean.getStatus())){
				workFlowDoTaskBean.setStatus(WorkFlowServiceHelper.WORKFLOW_TRANS_GOBACK);//流程流转和退回一致
				map.put("GOBACK_TYPE", WorkFlowHelper.GOBACK_TYPE_1); //直接后提交给退回者
				map.put("GOBACK_TASKNAME", lastTask); //退回任务名
				map.put("GOBACK_TLRNO", workFlowDoTaskBean.getTlrno()); //退回者
			}else if(WorkFlowServiceHelper.WORKFLOW_TRANS_GOBACK.equals(workFlowDoTaskBean.getStatus())){
				map.put("GOBACK_TYPE", WorkFlowHelper.GOBACK_TYPE_0); //直接退回
			}else if(WorkFlowServiceHelper.WORKFLOW_TRANS_GOBACK_LAST.equals(workFlowDoTaskBean.getStatus())){
				map.put("GOBACK_TYPE", WorkFlowHelper.GOBACK_TYPE_2); //退回给上一节点
				map.put("GOBACK_TLRNO", workFlowDoTaskBean.getTlrno()); //退回者
			}else{//同意

			}

			map.put("STATUS", workFlowDoTaskBean.getStatus());
			map.put("REASON", workFlowDoTaskBean.getComment());
			this.setTaskValue(taskId, map);
			//GlobalInfo.getCurrentInstance().setTaskId(Long.parseLong(taskId));
			//记录当前流程操作岗位信息到GlobalData中	BMS-1457	UU_Wu 2009-10-12	Start
//			if(map.get(WorkFlowConstants.WORKFLOW_ATTRIBUTE_ROLEID)!=null &&
//					(!map.get(WorkFlowConstants.WORKFLOW_ATTRIBUTE_ROLEID).equals(""))){
//				//GlobalInfo.getCurrentInstance().set.setRoleId(Integer.parseInt((String)map.get(WorkFlowConstants.WORKFLOW_ATTRIBUTE_ROLEID)));
//			}else{
//				GlobalInfo.getCurrentInstance().setRoleId(0);
//			}
			//记录当前流程操作岗位信息到GlobalData中	BMS-1457	UU_Wu 2009-10-12	End
			/* modify by shen_antonio 20100714 jira:BMS-2809 begin .*/
			WITask nextTask = workFlowDAO.doTask(String.valueOf(globalData.getTlrno()),
					"password", workFlowDoTaskBean.getTaskId(), actors,
					workFlowDoTaskBean.getStatus(), workFlowDoTaskBean
							.getAttribute(), workFlowDoTaskBean.getComment());
			/* modify by shen_antonio 20100714 jira:BMS-2809 end.*/
			//记录TLR_WORKLOAD表该操作员工作量统计表
			TaskAssignService taskAssignService = TaskAssignService.getInstance();
			taskAssignService.insertOrUpdateTlrWorkload(workFlowDoTaskBean.getTlrno(),
					null,
					null,
					SystemConstant.TASK_ASSIGN_MODE_1,
					true,false);
			//记录工作流任务信息表，更新当前任务信息 Added by UU_Wu 2008-6-24
			WorkflowTaskInfoDAO workflowTaskInfoDAO = BaseDAOUtils.getWorkflowTaskInfoDAO();
			List undoWorkflowTaskInfoList = workflowTaskInfoDAO.queryByCondition("po.procInsId = '" + workFlowDoTaskBean.getProcInsId() + "' and po.taskEndFlag ='"+SystemConstant.FLAG_OFF+"' order by id");
			WorkflowTaskInfo workflowTaskInfo = (WorkflowTaskInfo)undoWorkflowTaskInfoList.get(0);//BaseDAOUtils.getWorkflowTaskInfoDAO().queryByTaskId(workFlowDoTaskBean.getTaskId());
			if(workflowTaskInfo != null){
			//把当前做该任务的操作员更新到当前记录
			workflowTaskInfo.setTlrno(GlobalInfo.getCurrentInstance().getTlrno());
			workflowTaskInfo.setTaskEndFlag(SystemConstant.VALID_FLAG_VALID);
			workflowTaskInfo.setTaskEndTime(new Timestamp(System.currentTimeMillis()));
			workflowTaskInfoDAO.update(workflowTaskInfo);
			}

			//更新WorkFlowAppInfo
//			WorkFlowAppInfoDAO workflowAppInfoDAO = DAOUtils.getWorkFlowAppInfoDAO();
//			WorkflowAppInfo workflowAppInfo = workflowAppInfoDAO.queryByProcInsId(workFlowDoTaskBean.getProcInsId());
//			if(workflowAppInfo !=null){
//				//把当前做该任务的操作员更新到当前记录
//				workflowAppInfo.setCurrOprno(globalData.getTlrno());
//				workflowAppInfoDAO.update(workflowAppInfo);
//			}

			//有下一步任务，分配任务
			if( nextTask != null){
				/*modify by shen_antonio 20080814 现在任务分配由统一模块处理
				TaskAssignInfoBean taskAssignInfoBean = new TaskAssignInfoBean(
						nextTask.getProcInsId(), nextTask.getTaskId(),
						tlrno, nextTask.getTaskId(),
						workFlowDoTaskBean.getAssignMode(), DEFAULT_ASSIGN,
						workFlowDoTaskBean.getWorkType(), workFlowDoTaskBean.getBrcode());
				taskAssignService.assignTask(taskAssignInfoBean);
				*/
				return nextTask;
			}else{

				//更新该流程实例所有记录 Added by UU_Wu 2008-6-24
				if(workflowTaskInfo != null){
					workflowTaskInfo.setTaskEndTime(new Timestamp(System.currentTimeMillis()));
					workflowTaskInfoDAO.update(workflowTaskInfo);
					List list = workflowTaskInfoDAO.queryByProcInsId(workflowTaskInfo.getProcInsId());
					for(int i = 0 ; i < list.size(); i++){
						WorkflowTaskInfo wfti = (WorkflowTaskInfo)list.get(i);
						wfti.setProcEndTime(new Timestamp(System.currentTimeMillis()));
						wfti.setProcEndFlag(SystemConstant.VALID_FLAG_VALID);
						wfti.setTaskEndFlag(SystemConstant.VALID_FLAG_VALID);
						workflowTaskInfoDAO.update(wfti);
					}
				}

				//把当前审批路线实例记录删除 Added by UU_Wu 2009-5-15
				WorkflowInsRouteDAO workflowInsRouteDAO = BaseDAOUtils.getWorkflowInsRouteDAO();
				List workflowInsRouteList = workflowInsRouteDAO.queryByCondition(" po.piid = ?",
										new Object[] {workFlowDoTaskBean.getProcInsId()},
										new Type[] {Hibernate.STRING});
				WorkflowInsRoute workflowInsRoute =null;
				for(int i =0;i<workflowInsRouteList.size();i++){
					workflowInsRoute = (WorkflowInsRoute) workflowInsRouteList.get(i);
					workflowInsRouteDAO.delete(workflowInsRoute);
				}

				//更新WorkFlowAppInfo
//				workflowAppInfo.setStatus("1");//已完成
//				workflowAppInfo.setCurrOprno(GlobalData.getCurrentInstance().getTlrno());
//				workflowAppInfoDAO.update(workflowAppInfo);

				if( log.isDebugEnabled() ){
					log.debug("process instance id = " + workFlowDoTaskBean.getProcInsId() + " is ended");
				}
				return null;
			}
		} catch (CommonException cex) {
			throw cex;
		} catch (WIException wex) {
			/**add by jornezhang 20091023 BMS-2123 电子票据交易检查 begin*/
			ExceptionUtil.throwCommonException(wex.getDetailMessage(),
			/**add by jornezhang 20091023 BMS-2123 电子票据交易检查 end*/
					ErrorCode.ERROR_CODE_WORKFLOW_DOFINISH_ERROR,wex);
		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_DOFINISH_ERROR,ex);
		}
		return null;
	}

	/**
	 * 执行任务
	 * 处理流程：
	 * 		 请求TaskAssignService服务，获取分配操作员号
	 *       请求TaskAssignService服务，完成上部任务
	 * 		 调用工作流处理任务，执行该任务
	 *       请求TaskAssignService服务，记录操作员工作量统计表信息
	 * @param workFlowDoTaskBean
	 * @return
	 * @throws CommonException
	 */
	public  WITask doTask(WorkFlowDoTaskBean workFlowDoTaskBean)throws CommonException{
		try {
			TaskAssignService taskAssignService = TaskAssignService
					.getInstance();
			// 下部任务分配者
			String tlrno = "";
			/** 最后的节点使用.*/
			/*modify by shen_antonio 20080814 现在任务分配由统一模块处理
			if( workFlowDoTaskBean.getTlrnoList() == null || workFlowDoTaskBean.getTlrnoList().size() == 0){
				tlrno = "";
			}else{
				tlrno = taskAssignService.getAssignToTlrno(
					workFlowDoTaskBean.getTlrnoList(), workFlowDoTaskBean
							.getWorkType(), workFlowDoTaskBean.getAssignMode(),
					workFlowDoTaskBean.isWorkType(), workFlowDoTaskBean.isLv());
			}
			*/
			List actors = new ArrayList();
//			actors.add(tlrno);
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			//完成任务，记录操作员工作量统计表
			/*TaskFinishBean taskFinishBean =
				new TaskFinishBean(workFlowDoTaskBean.getProcInsId(),
						workFlowDoTaskBean.getTaskId(),workFlowDoTaskBean.getAssignMode(),
						workFlowDoTaskBean.getTlrno(),workFlowDoTaskBean.getWorkType(),workFlowDoTaskBean.getBrcode());
			taskAssignService.doFinishTask(taskFinishBean);*/
			//更新流程参数中的上个任务
			String taskId = workFlowDoTaskBean.getTaskId();
			String lastTask = this.getTask(taskId).getTaskName();
			Map  map = getTaskValue(taskId);
			map.put("LASTTASK", lastTask);
			this.setTaskValue(taskId, map);
//			GlobalInfo.getCurrentInstance().setTaskId(Long.parseLong(taskId));
			WITask nextTask = workFlowDAO.doTask(globalInfo.getTlrno(),
					"password", workFlowDoTaskBean.getTaskId(), actors,
					workFlowDoTaskBean.getStatus(), workFlowDoTaskBean
							.getAttribute(), workFlowDoTaskBean.getComment());

			//记录工作流任务信息表，更新当前任务信息 Added by UU_Wu 2008-6-24
			WorkflowTaskInfoDAO workflowTaskInfoDAO = BaseDAOUtils.getWorkflowTaskInfoDAO();
			//WorkflowTaskInfo workflowTaskInfo = BaseDAOUtils.getWorkflowTaskInfoDAO().queryById(Long.valueOf(workFlowDoTaskBean.getTaskId()));
			WorkflowTaskInfo workflowTaskInfo = null;
			List undoWorkflowTaskInfoList = workflowTaskInfoDAO.queryByCondition("po.procInsId = '" + workFlowDoTaskBean.getProcInsId() + "' and po.taskEndFlag ='"+SystemConstant.FLAG_OFF+"' ");
			if(undoWorkflowTaskInfoList!=null&&undoWorkflowTaskInfoList.size()>0){
				workflowTaskInfo = (WorkflowTaskInfo)undoWorkflowTaskInfoList.get(0);
			}
//			if(workflowTaskInfo != null){
//			//把当前做该任务的操作员更新到当前记录
//			workflowTaskInfo.setTlrno(globalInfo.getTlrno());
//			workflowTaskInfo.setTaskEndFlag(SystemConstant.VALID_FLAG_VALID);
//			workflowTaskInfo.setTaskEndTime(new Timestamp(System.currentTimeMillis()));
//			workflowTaskInfoDAO.update(workflowTaskInfo);
//			}

			//有下一步任务，分配任务
			if( nextTask != null){
				/*modify by shen_antonio 20080814 现在任务分配由统一模块处理
				TaskAssignInfoBean taskAssignInfoBean = new TaskAssignInfoBean(
						nextTask.getProcInsId(), nextTask.getTaskId(),
						tlrno, nextTask.getTaskId(),
						workFlowDoTaskBean.getAssignMode(), DEFAULT_ASSIGN,
						workFlowDoTaskBean.getWorkType(), workFlowDoTaskBean.getBrcode());
				taskAssignService.assignTask(taskAssignInfoBean);
				*/
				return nextTask;
			}else{

				//更新该流程实例所有记录 Added by UU_Wu 2008-6-24
				if(workflowTaskInfo != null){
					workflowTaskInfo.setTaskEndTime(new Timestamp(System.currentTimeMillis()));
					workflowTaskInfoDAO.update(workflowTaskInfo);
					List list = workflowTaskInfoDAO.queryByProcInsId(workflowTaskInfo.getProcInsId());
					for(int i = 0 ; i < list.size(); i++){
						WorkflowTaskInfo wfti = (WorkflowTaskInfo)list.get(i);
						wfti.setTaskEndTime(new Timestamp(System.currentTimeMillis()));
						wfti.setTaskEndFlag(SystemConstant.VALID_FLAG_VALID);
						wfti.setTaskEndFlag(SystemConstant.VALID_FLAG_VALID);
						workflowTaskInfoDAO.update(wfti);
					}
				}

				if( log.isDebugEnabled() ){
					log.debug("process instance id = " + workFlowDoTaskBean.getProcInsId() + " is ended");
				}
				return null;
			}
		} catch (CommonException cex) {
			throw cex;
		} catch (WIException wex) {
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_DOFINISH_ERROR);
		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_DOFINISH_ERROR);
		}
		return null;
	}

	/**
	 * 任务移交(支持移交指定工作和全部工作)
	 * 处理过程：
	 * 		 请求TaskAssignService服务，移交工作
	 *       调用工作流处理任务，执行该任务移交
	 * @param workFlowForwardTaskBean
	 * @param allFlag 全部移交标志(是否移交该操作员所有工作)
	 * @throws CommonException
	 */
	public  void forwardTask(WorkFlowForwardTaskBean workFlowForwardTaskBean,boolean allFlag)throws CommonException{
		try{
			TaskAssignService taskAssignService = TaskAssignService.getInstance();
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			//移交指定工作
			if( !allFlag ){
				taskAssignService.forwardTask(workFlowForwardTaskBean.getProcInsId(),workFlowForwardTaskBean.getTaskId(),workFlowForwardTaskBean.getTlrno(),workFlowForwardTaskBean.getBrcode());
				workFlowDAO.forwardTask(workFlowForwardTaskBean.getTaskId(), workFlowForwardTaskBean.getTlrno());
			//移交全部工作
			}else{
				List forwoadTaskList =
					taskAssignService.forwardTask(workFlowForwardTaskBean.getOTlrno(), workFlowForwardTaskBean.getTlrno(), workFlowForwardTaskBean.getBrcode());
				workFlowDAO.forwardAllTask(workFlowForwardTaskBean.getOTlrno(), "password",  workFlowForwardTaskBean.getTlrno());
			}
		}catch(CommonException cex){
			throw cex;
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_FORWARD_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_FORWARD_ERROR);
		}
	}

	/**
	 * 任务移交
	 * @param workFlowForwardTaskBean
	 * @throws CommonException
	 */
	public  void forwardTask(WorkFlowForwardTaskBean workFlowForwardTaskBean)throws CommonException{
		WorkflowTaskInfoDAO workflowTaskInfoDAO = BaseDAOUtils.getWorkflowTaskInfoDAO();
		WorkflowTaskInfo workflowTaskInfo = null;
		WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
		try{
			workflowTaskInfo = workflowTaskInfoDAO.queryById(Long.valueOf(workFlowForwardTaskBean.getTaskId()));
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
	/** modified by jornezhang 20100805 begin */
	/**
	 * 修改代办任务查询，改成分页查询，可以通过Map传参数，进行分页查询
	 * */
	/**
	 * 获取指定操作员的工作列表
	 * @param tlrno 操作员号或者岗位号
	 * @param taskState 任务状态 允许为空，默认为所有潜在任务和私有任务
	 * 				WorkFlowServiceHelper.TASK_STATUS_CLAIMED 已经声明的任务
	 * 				WorkFlowServiceHelper.TASK_STATUS_READY 未声明的潜在任务
	 * @return
	 * @throws CommonException
	 */
	public  WIPageQueryResult getTaskList(String tlrno,String taskState,Integer pageIndex,Integer pageSize,Map transMap)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			return workFlowDAO.getTaskList(tlrno, "password",taskState, pageIndex, pageSize, transMap);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR);
		}
		return null;
	}

	/**
	 * 列出指定操作员和流程类型的任务类表
	 * @param tlrno 操作员号(允许为空，默认是所有用户）
	 * @param flowName 流程名
	 * @param version 流程版本号（允许为空，默认获取所有的）,或者FLOW_ALL_VERSION，FLOW_LAST_VERSION
	 * @param taskState 任务状态 允许为空，默认为所有潜在任务和私有任务
	 * 				WorkFlowServiceHelper.TASK_STATUS_CLAIMED 已经声明的任务
	 * 				WorkFlowServiceHelper.TASK_STATUS_READY 未声明的潜在任务
	 * @return List<WITask>工作列表
	 * @throws CommonException
	 */
	public  WIPageQueryResult getTaskList(String tlrno,String flowName,String version,String taskState,Integer pageIndex,Integer pageSize,Map transMap)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			return workFlowDAO.getTaskList(tlrno, "password", flowName, version,taskState, pageIndex, pageSize, transMap);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR);
		}
		return null;
	}

	/**
	 * 列出指定操作员、流程和任务的任务类表
	 * @param tlrno 操作员(允许为空，默认是所有用户）
	 * @param flowName 流程名
	 * @param version 流程版本号（允许为空，默认获取所有的）,或者FLOW_ALL_VERSION，FLOW_LAST_VERSION
	 * @param taskName 任务名
	 * @param taskState 任务状态 允许为空，默认为所有潜在任务和私有任务
	 * 				WorkFlowServiceHelper.TASK_STATUS_CLAIMED 已经声明的任务
	 * 				WorkFlowServiceHelper.TASK_STATUS_READY 未声明的潜在任务
	 * @return List<WITask> 任务列表
	 * @throws CommonException
	 */
	public  WIPageQueryResult getTaskList(String tlrno,String flowName,String version,String taskName,String taskState,Integer pageIndex,Integer pageSize,Map transMap)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			return workFlowDAO.getTaskList(tlrno, "password", flowName, version, taskName,taskState, pageIndex, pageSize, transMap);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR);
		}
		return null;
	}
	/** modified by jornezhang 20100805 end */

	/**
	 * Description: 获取任务信息
	 * @param
	 * @return WITask
	 * @exception
	 * @author shen_antonio
	 * @version v1.0,2009-2-24
	 */
	public WITask getTask(String taskId)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			return workFlowDAO.getTask(taskId);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR);
		}
		return null;
	}

	/**
	 * 列出系统中某个工作流流程的所有实例
	 * @param tlrno 操作员号(允许为空，默认是所有用户）
	 * @param flowName 流程名(允许为空,默认所有流程)
	 * @param version  启动流程版本(允许为空,默认为最新流程版本）,或者FLOW_ALL_VERSION，FLOW_LAST_VERSION
	 * @param key 流程实例快速查询Key(允许为空）
	 * @return List<WIFlowInstance>
	 * @throws CommonException
	 */
	public  List getFlowInstanceList(String tlrno, String flowName,String version,String key)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			return workFlowDAO.getFlowInstanceList(tlrno, "password", flowName, version, key);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}
		return null;
	}

	/**
	 * 获取指定流程号的流程信息
	 * @param flowInsId 流程号
	 * @return WIFlowInstance
	 * @throws WIException
	 */
	public  WIFlowInstance getFlowInstance(String flowInsId)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			WIFlowInstance wiFlowInstance = workFlowDAO.getFlowInstance(flowInsId);
			return wiFlowInstance;
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}
		return null;
	}

	/**
	 * 结束指定流程实例
	 * 处理流程如下：
	 * 			结束任务分配
	 * 			结束工作流任务
	 * @param flowInsId 流程实例号
	 * @throws CommonException
	 */
	public void endFlowInstance(String flowInsId)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			TaskAssignService taskAssignService = TaskAssignService.getInstance();
			// 结束任务分配
			taskAssignService.endProcTask(flowInsId);
			// 结束工作流任务
			workFlowDAO.closeFlowInstance(flowInsId);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}
	}

	/**
	 * 获取指定任务中的参数
	 * @param taskId 任务号
	 * @return Map<String,Object> 参数集合
	 * @throws CommonException
	 */
	public  Map getTaskValue(String taskId)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			return workFlowDAO.getValue(taskId);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKVALUE_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKVALUE_ERROR);
		}
		return null;
	}

	/**
	 * 设置指定任务的参数
	 * @param taskId 任务号
	 * @param valueMap 参数集合
	 * @throws CommonException
	 */
	public  void setTaskValue(String taskId,Map valueMap)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			workFlowDAO.setValue(taskId, valueMap);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_SETTASKVALUE_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_SETTASKVALUE_ERROR);
		}
	}

	/**
	 * 锁工作流任务
	 * @param taskId 任务号
	 * @throws CommonException
	 */
	public  void lockTask(String taskId)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			workFlowDAO.lockTask(GlobalInfo.getCurrentInstance().getTlrno(),taskId);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_LOCKTASK_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_LOCKTASK_ERROR);
		}
	}

	/**
	 * 释放工作流任务
	 * @param taskId 任务号
	 * @throws CommonException
	 */
	public  void releaseTask(String taskId)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			workFlowDAO.releaseTask(taskId);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_RELEASETASK_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_RELEASETASK_ERROR);
		}
	}

	/**
	 * 保留工作流任务
	 * @param taskId 任务号
	 * @throws CommonException
	 */
	public  void keepTask(String taskId)throws CommonException{
		try{
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			workFlowDAO.keepTask(taskId);
		}catch(WIException wex){
			ExceptionUtil.throwCommonException(wex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_KEEPTASK_ERROR);
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_KEEPTASK_ERROR);
		}
	}

	/**
	 * 得到流程状态
	 * @param wiTask 工作流下个任务实例
	 * @param attitude 审批意见
	 * @throws CommonException
	 */
	public  String getFlowType( String attitude )throws CommonException{
		String flowtype = WorkFlowConstants.FLOW_STATUS_APPROVING;
		try{
			//审批同意结束
			if(attitude.equals(WorkFlowConstants.APP_ATTITUDE_AGREE_TO_NEXT)){
				flowtype = WorkFlowConstants.FLOW_STATUS_FINISH;
			}
			//审批拒绝结束
			else if(attitude.equals(WorkFlowConstants.APP_ATTITUDE_AGREE_TO_SUBMIT)){
				flowtype = WorkFlowConstants.FLOW_STATUS_REJECT;
			}
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_KEEPTASK_ERROR);
		}
		return flowtype;
	}


	/**
	 * 得到流程状态
	 * @param wiTask 工作流下个任务实例
	 * @param attitude 审批意见
	 * @throws CommonException
	 */
	public  String getFlowTypeNew( String attitude )throws CommonException{
		String flowtype = WorkFlowConstants.FLOW_STATUS_APPROVING;
		try{
			//审批同意结束
			if(attitude.equals("0")){
				flowtype = WorkFlowConstants.FLOW_STATUS_FINISH;
			}
			//审批拒绝结束
			else if(attitude.equals("1")){
				flowtype = WorkFlowConstants.FLOW_STATUS_REJECT;
			}
		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_KEEPTASK_ERROR);
		}
		return flowtype;
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
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();

			// 获取工作流参数，userName
			String userName = request.getTlrno();
			String password = null;
			String version = null;
			String flowName = request.getFlowName();
			TlrInfoService tlrInfoService = TlrInfoService.getInstance();
			String tlrno = tlrInfoService.getTlrno(userName);
			TlrInfo tlrInfo = tlrInfoService.getTlrInfoByTlrno(tlrno);
			String curRole = "";//String.valueOf(tlrInfo.getCurRoleid().intValue());

			//GetTaskRequestBean 需要扩充 传入 pageIndex、pageSize 和过滤出条件
			Integer pageIndex = request.getPageIndex();
			if(pageIndex == null){
				pageIndex = new Integer(1);
			}
			Integer pageSize = request.getPageSize();
			if(pageSize == null){
				pageSize = new Integer(500);
			}
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
			}*/

			String taskState=null;
			// 返回taskList
			WIPageQueryResult result = workFlowDAO.getTaskList(userName, password,
			 taskState , pageIndex, pageSize, transMap);
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
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		try {
			for (int i = 0; i < brcodeList.length; i++) {
				brcode = brcodeList[i];
				String hql = "select tlr.tlrno,tlr.brcode from TlrInfo as tlr,TlrRoleRel as rela where tlr.tlrno=rela.tlrno and rela.roleId="
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
//del by zhaozhiguo
//	/**
//	 * Description: 启动指定流程
//	 *
//	 * @param StartFlowRequestBean
//	 * @return StartFlowResponseBean
//	 * @exception CommonException
//	 * @author shen_antonio
//	 * @version v1.0,2008-7-16
//	 */
//	public StartFlowResponseBean startFlow(StartFlowRequestBean startFlowRequest)
//			throws CommonException {
//		StartFlowResponseBean startFlowResponseBean = null;
//		try {
//			// 请求工作流DAO
//			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
//			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//			// 获取工作流参数, startFlowRequest中的属性
//			List actors = new ArrayList();
//			Map attributeMap = new HashMap();
//			attributeMap.put("APPNO", startFlowRequest.getAppno());
//			attributeMap.put("APPTYPE", startFlowRequest.getAppType());
//			attributeMap.put("STARTBRCODE", startFlowRequest.getBrcode());
//			attributeMap.put("FLOWNAME", startFlowRequest.getFlowName());
//			attributeMap.put("STARTER", startFlowRequest.getStarter());
//			//attributeMap.put("TLRNO_LIST", startFlowRequest.getStarter());
//			attributeMap.put("CONTRACTNO", startFlowRequest.getContractno());
//			attributeMap.put("CUSTCD", startFlowRequest.getCustcd());
//			attributeMap.put("AMOUNT", startFlowRequest.getTxnamt());
//			attributeMap.put("SYSTYPE",SystemConstant.SYSTYPE_LONSYSWEB);
//			GlobalInfo info = GlobalInfo.getCurrentInstance();
//			info.setTransData(startFlowRequest.getContractno(), startFlowRequest.getCustcd(), startFlowRequest.getAppno(), startFlowRequest.getTxnamt());
//			// 调用工作流启动流程接口
//			WIFlowInstance wiFlowInstance = workFlowDAO.startFlow(globalInfo
//					.getTlrno(), "", actors, startFlowRequest.getFlowName(),
//					null, null, attributeMap, null);
//
//			startFlowResponseBean = new StartFlowResponseBean();
//			startFlowResponseBean.setPiid(wiFlowInstance.getFlow().getFlowId());
//			startFlowResponseBean.setFlowName(startFlowRequest.getFlowName());
//			startFlowResponseBean.setVersion(wiFlowInstance.getFlow()
//					.getFlowVersion());
//			startFlowResponseBean.setStartTime(wiFlowInstance.getStartTime());
//			startFlowResponseBean.setStarter(startFlowRequest.getStarter());
//
//		} catch (Exception ex) {
//			ExceptionUtil.throwCommonException(ex.getMessage(),
//					ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR, ex);
//		}
//
//		return startFlowResponseBean;
//	}

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
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
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
	 * Description: 获取未完成的任务列表
	 *
	 * @param GetTaskRequestBean
	 * @return List
	 * @exception CommonException
	 * @author shen_antonio
	 * @version v1.0,2008-7-17
	 */
	public PageQueryResult getUnFinishedTaskList(GetTaskRequestBean request)
			throws CommonException {
		return getTaskList(request, null);
	}

	/**
	 * Description: 执行任务
	 *
	 * @param DoTaskRequestBean
	 * @return TaskBean
	 * @exception CommonException
	 * @author shen_antonio
	 * @version v1.0,2008-7-16
	 */
	public TaskBean doTask(DoTaskRequestBean doTaskRequestBean)
			throws CommonException {
		TaskBean taskBean = new TaskBean();

		try {
			// 获取流程信息
			String taskId = doTaskRequestBean.getTaskId();
			String status = doTaskRequestBean.getStatus(); // 任务结果状态
			String approveStatus = ""; // 审批结果状态
			String comment = doTaskRequestBean.getComment();
			String userName = doTaskRequestBean.getTlrno();
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();

			Map map = workFlowDAO.getValue(taskId);
			String password = (String) map.get("PASSWORD");
			String flowName = (String) map.get("FLOWNAME");
			String appno = (String) map.get("APPNO");
			String appType = (String) map.get("APPTYPE");
			String isApprove = (String) map.get("ISAPPROVE");

			String contractno = (String) map.get("CONTRACTNO");
			String txnamt = map.get("AMOUNT").toString();
			String custcd = (String) map.get("CUSTCD");

			String statusName = getTOPBPMStatus(status,isApprove);
			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			globalInfo.setTransData(contractno, custcd, appno, txnamt);
			//globalInfo.getUserRoles();

			// 获取审批状态
			if (status.equals("0")) {
				if (isApprove != null && isApprove.equals("1")) {
					approveStatus = WorkFlowHelper.BP_TYPE_ApproveSuccess;
				}
			} else
				approveStatus = status;
			map.put("TYPE", approveStatus);

			WITask curWITask = workFlowDAO.getTask(taskId);
			String taskName = curWITask.getTaskName();

			List actors = new ArrayList();

			if (doTaskRequestBean.getStatus().equals(
					WorkFlowHelper.BP_TYPE_ApproveCancelProcess) || doTaskRequestBean.getStatus().equals(
							WorkFlowHelper.BP_TYPE_ApproveRefuse)) {// 取消任务
				String flowInsId = curWITask.getProcInsId();
				workFlowDAO.closeFlowInstance(flowInsId);

			} else {
				// 调用工作流执行任务接口
				WITask wiTask = workFlowDAO.doTask(userName, password, taskId,
						actors, statusName, map, comment);

				// 在操作员每日工作量统计表中[TLR_WL_HS]插入记录，用于夜间批量统计操作员的工作量,其中操作员工作量衡量标准以[完成工作量]为准。
//				TlrWlHs tlrWlHs = new TlrWlHs();
//				tlrWlHs.setTlrno(userName);
//				tlrWlHs.setBrcode(doTaskRequestBean.getBrcode());
//				tlrWlHs
//						.setWorkDate(GlobalInfo.getCurrentInstance()
//								.getTxdate());
//				TlrWlHsDAO tlrWlHsDAO = DAOUtils.getTlrWlHsDAO();
//				tlrWlHsDAO.insert(tlrWlHs);
			}


			// 根据返回的wiTask实例为TaskBean赋值
			taskBean.setTaskName(taskName);
			taskBean.setAppType(appType);
			taskBean.setTaskId(taskId);
			taskBean.setAppno(appno);
			taskBean.setUserName(userName);
			taskBean.setPiid(curWITask.getProcInsId());
			taskBean.setProcName(flowName);
			taskBean.setTaskStartTime(DateUtil.dateToString(curWITask
					.getTaskStartTime()));
			taskBean.setTaskEndTime(DateUtil.dateToString(curWITask
					.getTaskEndTime()));

			// edit by richmond_liu 在业务数据库中记录任务已完成
//			WorkflowTaskInfoService.getInstance().markTaskDone(
//					doTaskRequestBean, taskBean);
			// 调用BusinessProcess
//			ILoanSysWebInterfaceService interfaceService = (ILoanSysWebInterfaceService)ApplicationContextUtils.getBean("Interface.LoanSysWebInterfaceService");
//			interfaceService.businessProcess(map);

		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_DOFINISH_ERROR, ex);
		}

		return taskBean;
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
	public PageQueryResult getTaskList(GetTaskRequestBean request, String taskState)
			throws CommonException {
		List taskList = new ArrayList();
		PageQueryResult returnPageQueryResult = new PageQueryResult();
		try {
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();

			// 获取工作流参数，userName
			String userName = request.getTlrno();
			String password = null;
			String version = null;
			String flowName = request.getFlowName();
			TlrInfoService tlrInfoService = TlrInfoService.getInstance();
			String tlrno = tlrInfoService.getTlrno(userName);
			TlrInfo tlrInfo = tlrInfoService.getTlrInfoByTlrno(tlrno);
			String curRole = String.valueOf(tlrInfo.getRoleid().intValue());

			//GetTaskRequestBean 需要扩充 传入 pageIndex、pageSize 和过滤出条件
			Integer pageIndex = request.getPageIndex();
			if(pageIndex == null){
				pageIndex = new Integer(1);
			}
			Integer pageSize = request.getPageSize();
			if(pageSize == null){
				pageSize = new Integer(500);
			}
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
			}*/



			// 返回taskList
			// List list = workFlowDAO.getTaskList(userName, password,
			// taskState);
			WIPageQueryResult result = workFlowDAO.getTaskList(userName, password, flowName,
					version, taskState, pageIndex, pageSize, transMap);
			List list = result.getQueryResult();
			for (int i = 0; i < list.size(); i++) {
				TOPBPMWITask wITask = (TOPBPMWITask) list.get(i);
				Map map = wITask.getValueMap();
				System.out.println(map.get("APPNO"));
				WorkflowTaskInfo info = WorkflowTaskInfoService.getInstance()
						.findTaskInfo((String) map.get("APPNO"),
								(String) map.get("APPTYPE"),
								(String)wITask.getTaskName(), (String)flowName,
								(String)wITask.getProcInsId());
				if(info != null) {
//				if (info.getWorkflowRole() != null
//						&& !info.getWorkflowRole().equals("ROLE" + curRole))
//					continue;
				//else {
					TaskBean taskBean = new TaskBean();
					taskBean.setAppno((String) map.get("APPNO"));
					taskBean.setAppType((String) map.get("APPTYPE"));
					taskBean.setBrcode((String) map.get("BRCODE"));
					taskBean.setBrclass((String) map.get("BRCLASS"));
					taskBean.setComment((String) map.get("COMMENT"));
					taskBean.setContractno((String) map.get("CONTRACTNO"));
					taskBean.setCustno((String) map.get("CUSTNO"));
					taskBean.setCustcd((String) map.get("CUSTCD"));
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
					/*
					 * author:yangyong
					 * start data:20100722
					 * 工作流拥有者
					 */
					taskBean.setOwner(wITask.getOwner());
					/*
					 * author:yangyong
					 * end data:20100722
					 * 工作流拥有者
					 */
					taskList.add(taskBean);
				}
			}
			//}
			returnPageQueryResult.setQueryResult(taskList);
			returnPageQueryResult.setTotalCount(result.getTotalCount());
		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR, ex);
		}
		return returnPageQueryResult;

	}

	public PageQueryResult getUploadTaskList(GetTaskRequestBean request,String taskName)
			throws CommonException {
		List taskList = new ArrayList();
		PageQueryResult returnPageQueryResult = new PageQueryResult();
		try {
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();

			// 获取工作流参数，userName
			String userName = request.getTlrno();
			String password = null;
			String version = null;
			String flowName = request.getFlowName();
			TlrInfoService tlrInfoService = TlrInfoService.getInstance();
			String tlrno = tlrInfoService.getTlrno(userName);
			TlrInfo tlrInfo = tlrInfoService.getTlrInfoByTlrno(tlrno);
			String curRole = String.valueOf(tlrInfo.getRoleid().intValue());

			//GetTaskRequestBean 需要扩充 传入 pageIndex、pageSize 和过滤出条件
			Integer pageIndex = request.getPageIndex();
			if(pageIndex == null){
				pageIndex = new Integer(1);
			}
			Integer pageSize = request.getPageSize();
			if(pageSize == null){
				pageSize = new Integer(500);
			}
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
			}*/



			// 返回taskList
			// List list = workFlowDAO.getTaskList(userName, password,
			// taskState);
			WIPageQueryResult result = workFlowDAO.getTaskList(userName, password, flowName,
					version, null, pageIndex, pageSize, transMap);
			List list = result.getQueryResult();
			for (int i = 0; i < list.size(); i++) {
				TOPBPMWITask wITask = (TOPBPMWITask) list.get(i);
				Map map = wITask.getValueMap();
				System.out.println(map.get("APPNO"));
				WorkflowTaskInfo info = WorkflowTaskInfoService.getInstance()
						.findTaskInfo((String) map.get("APPNO"),
								(String) map.get("APPTYPE"),
								(String)wITask.getTaskName(), (String)flowName,
								(String)wITask.getProcInsId());
				if(info != null) {
		//		if (info.getWorkflowRole() != null
		//				&& !info.getWorkflowRole().equals("ROLE" + curRole))
		//			continue;
				//else {
					TaskBean taskBean = new TaskBean();
					taskBean.setAppno((String) map.get("APPNO"));
					taskBean.setAppType((String) map.get("APPTYPE"));
					taskBean.setBrcode((String) map.get("BRCODE"));
					taskBean.setBrclass((String) map.get("BRCLASS"));
					taskBean.setComment((String) map.get("COMMENT"));
					taskBean.setContractno((String) map.get("CONTRACTNO"));
					taskBean.setCustno((String) map.get("CUSTNO"));
					taskBean.setCustcd((String) map.get("CUSTCD"));
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
					/*
					 * author:yangyong
					 * start data:20100722
					 * 工作流拥有者
					 */
					taskBean.setOwner(wITask.getOwner());
					/*
					 * author:yangyong
					 * end data:20100722
					 * 工作流拥有者
					 */
					if(taskName.equals(taskBean.getTaskName()))
						taskList.add(taskBean);
				}
			}
			//}
			returnPageQueryResult.setQueryResult(taskList);
			returnPageQueryResult.setTotalCount(result.getTotalCount());
		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR, ex);
		}
		return returnPageQueryResult;

	}

	public String getTOPBPMStatus(String status, String isApprove) {
		String statusName = "";
		/*if (status.equals(WorkFlowHelper.STATUS_Agree)) {
			if (isApprove != null && isApprove.equals("1"))
				statusName = "ToEnd";
			else
				//statusName = "AgreeToNext";
				statusName = "Agree";
		}
		else if (status.equals(WorkFlowHelper.STATUS_Rollback))
			statusName = "GoBack";
		else if (status.equals(WorkFlowHelper.STATUS_Refuse)||status.equals(WorkFlowHelper.STATUS_StopProcess))
			statusName = "RefuseToEnd";
		else if(status.equals(WorkFlowHelper.STATUS_AgreeUpload))
			statusName="AgreeToNext";
		else if(status.equals(WorkFlowHelper.STATUS_RefuseUpload))
			statusName = "AgreeToNext";*/
		if(WorkFlowHelper.STATUS_1.equals(status)){
			statusName=WorkFlowServiceHelper.WORKFLOW_TRANS_AGREE;
		}else if(WorkFlowHelper.STATUS_2.equals(status)){
			statusName=WorkFlowServiceHelper.WORKFLOW_TRANS_REFUSE;
		}else if(WorkFlowHelper.STATUS_3.equals(status)){
			statusName=WorkFlowServiceHelper.WORKFLOW_TRANS_GOBACK_LAST;
		}else if(WorkFlowHelper.STATUS_4.equals(status)){
			statusName=WorkFlowServiceHelper.WORKFLOW_TRANS_GOBACK;
		}else if(WorkFlowHelper.STATUS_5.equals(status)){
			statusName=WorkFlowServiceHelper.WORKFLOW_TRANS_GOBACK_RETURN;
		}
		return statusName;
	}

	/**
	 * Description: 声明任务
	 *
	 * @param tlrno
	 *            操作员号
	 * @param taskId
	 *            任务号
	 * @return TaskBean
	 * @exception
	 * @author shen_antonio
	 * @version v1.0,2008-7-16
	 */
	public TaskBean claimTask(String tlrno, String taskId)
			throws CommonException {
		TaskBean taskBean = new TaskBean();
		try {
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			WorkflowTaskInfoDAO workflowTaskInfoDAO = BaseDAOUtils
					.getWorkflowTaskInfoDAO();
			// 调用工作流声名任务
			workFlowDAO.lockTask(tlrno, taskId);
			// 更新WORKFLOW_TASK_INFO表中[操作员]字段，应保存任务声明人的操作员号
			WorkflowTaskInfoService workflowTaskInfoService = WorkflowTaskInfoService
					.getInstance();
			Map map = workFlowDAO.getValue(taskId);
			WITask wiTask = workFlowDAO.getTask(taskId);
			String piid = wiTask.getProcInsId();
			String appno = (String) map.get("APPNO");
			String taskName = wiTask.getTaskName();
			String appType = (String) map.get("APPTYPE");
			String flowName = (String) map.get("FLOWNAME");
//			workflowTaskInfo = workflowTaskInfoService.findTaskInfo(appno,
//					appType, taskName, flowName, piid);
//			workflowTaskInfo.setTlrno(tlrno);
//			workflowTaskInfoDAO.update(workflowTaskInfo);
			// 查询工作流任务信息表中的任务信息，并给taskBean赋值
			// 根据taskInfo给taskBean赋值
			taskBean.setAppno(appno);
			taskBean.setAppType(appType);
			taskBean.setPiid(piid);
			taskBean.setProcName(flowName);
			taskBean.setTaskId(taskId);
			taskBean.setTaskName(taskName);

//			WorkflowTaskInfoService.getInstance().markTaskClaimed(tlrno,
//					taskBean);
			GlobalInfo info = GlobalInfo.getCurrentInstance();
			info.setTransData(null, null, appno, null);
		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_LOCKTASK_ERROR, ex);
		}

		return taskBean;
	}

	/**
	 * Description: 释放任务
	 *
	 * @param tlrno
	 *            操作员号
	 * @param taskId
	 *            任务号
	 * @return TaskBean
	 * @exception
	 * @author shen_antonio
	 * @version v1.0,2008-7-16
	 */
	public TaskBean cancelClaimTask(String tlrno, String taskId)
			throws CommonException {
		TaskBean taskBean = new TaskBean();
		try {
			// 请求工作流DAO
			WorkFlowDAO workFlowDAO = BaseDAOUtils.getWorkFlowDAO();
			WorkflowTaskInfoDAO workflowTaskInfoDAO = BaseDAOUtils
					.getWorkflowTaskInfoDAO();
			// 调用工作流取消声明任务
			workFlowDAO.releaseTask(taskId);
			// 更新WORKFLOW_TASK_INFO表中[操作员]字段，置空
			WorkflowTaskInfo workflowTaskInfo = new WorkflowTaskInfo();
			WorkflowTaskInfoService workflowTaskInfoService = WorkflowTaskInfoService
					.getInstance();
			Map map = workFlowDAO.getValue(taskId);
			WITask wiTask = workFlowDAO.getTask(taskId);
			String piid = wiTask.getProcInsId();
			String appno = (String) map.get("APPNO");
			String taskName = wiTask.getTaskName();
			String appType = (String) map.get("APPTYPE");
			String flowName = (String) map.get("FLOWNAME");
			workflowTaskInfo = workflowTaskInfoService.findTaskInfo(appno,
					appType, taskName, flowName, piid);
			workflowTaskInfo.setTlrno("");
			workflowTaskInfoDAO.update(workflowTaskInfo);
			// 查询工作流任务信息表中的任务信息，并给taskBean赋值
			// 根据taskInfo给taskBean赋值
			taskBean.setAppno(workflowTaskInfo.getAppno());
			taskBean.setAppType(workflowTaskInfo.getApptype());
			taskBean.setBrclass((String) map.get("BRCLASS"));
			taskBean.setBrcode((String) map.get("BRCODE"));
			taskBean.setContractno(workflowTaskInfo.getContractno());
			taskBean.setCustno(workflowTaskInfo.getCustcd());
			taskBean.setPiid(workflowTaskInfo.getProcInsId());
			taskBean.setProcName(workflowTaskInfo.getProcessTemplate());
			taskBean.setTaskId(taskId);
			taskBean.setTaskName(workflowTaskInfo.getTaskName());
			taskBean.setTaskStartTime(workflowTaskInfo.getTaskStartTime()
					.toString());
			taskBean.setUserName("");

			WorkflowTaskInfoService.getInstance().markTaskUnclaimed(tlrno,
					taskBean);
			GlobalInfo info = GlobalInfo.getCurrentInstance();
	        info.setTransData(null, null, appno, null);
		} catch (Exception ex) {
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_RELEASETASK_ERROR, ex);
		}

		return taskBean;
	}

	/**
	 * Description: 获取已经完成的任务列表
	 *
	 * @param GetTaskRequestBean
	 * @return List
	 * @exception CommonException
	 * @author shen_antonio
	 * @version v1.0,2008-7-17
	 */
	public PageQueryResult getFinishedTaskList(GetTaskRequestBean request)
			throws CommonException {
		return getTaskList(request, WorkFlowHelper.getFinishedState());
	}


}
