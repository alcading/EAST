package com.huateng.ebank.business.workflow.service;

import java.util.List;

import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.business.workflow.bean.TaskBean;
import com.huateng.ebank.entity.dao.workflow.WorkflowTaskInfoDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class WorkflowTaskInfoService {

	public static final String START_TASK_NAME = "StartFlow";

	public static final String TASK_STATE_ASSIGNED = "0";
	public static final String TASK_STATE_CLAIMED = "2";
	public static final String TASK_STATE_FINISHED = "1";

	public static WorkflowTaskInfoService getInstance() {
		return (WorkflowTaskInfoService) ApplicationContextUtils
				.getBean(WorkflowTaskInfoService.class.getName());
	}

//	/**
//	 * Description: 在业务数据库中记录流程发起信息
//	 *
//	 * @param
//	 * @exception
//	 * @author richmond_liu
//	 * @version v1.0,2008-8-18
//	 */
//	public void markFlowStarted(StartFlowRequestBean req,
//			StartFlowResponseBean rsp) throws CommonException {
//		WorkflowTaskInfo taskInfo = new WorkflowTaskInfo();
//		Date now = getCurrentDate();
//
//		taskInfo.setAppno(req.getAppno());
//		taskInfo.setApptype(req.getAppType());
//		taskInfo.setCustcd(req.getCustno());
//		taskInfo.setContractno(req.getContractno());
//		taskInfo.setProcEndFlag(SystemConstant.FLAG_OFF);
//		taskInfo.setProcessTemplate(req.getFlowName());
//		taskInfo.setProcInsId(rsp.getPiid());
//		taskInfo.setProcStartTime(now);
//		taskInfo.setTaskName(START_TASK_NAME);
//		taskInfo.setTaskStartTime(now);
//		taskInfo.setTaskEndFlag(SystemConstant.FLAG_ON);
//		taskInfo.setTlrno(req.getStarter());
//		taskInfo.setTaskEndTime(now);
//
//		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();
//		dao.insert(taskInfo);
//
//		WorkflowAppInfoDAO wDao = DAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(req.getAppno());
//		if (appInfo == null) {
//			appInfo = new WorkflowAppInfo(req.getAppno(), req.getAppType(), rsp
//					.getPiid(), req.getFlowName(), now,
//					SystemConstant.FLOW_STATUS_NOTUPLOAD);
//			appInfo.setCurrRole(SystemConstant.WF_ROLE_TYPE_ROLE101);
//			appInfo.setBrcode(req.getBrcode());
//			appInfo.setTlrno(req.getStarter());
//
//			String custcd = req.getCustno();
//			CustomerInfo ci = CustomerService.getInstance().queryCustomerById(
//					custcd);
//			appInfo.setCustno(ci.getCustno());
//			appInfo.setCustName(ci.getCname());
//			wDao.insert(appInfo);
//		} else {
//			appInfo.setPiid(rsp.getPiid());
//			appInfo.setStatus(SystemConstant.FLOW_STATUS_NOTUPLOAD);
//			appInfo.setCurrRole(SystemConstant.WF_ROLE_TYPE_ROLE101);
//			appInfo.setTimestamps(null);
//			wDao.update(appInfo);
//		}
//
//	}
//
//
	public void markTaskClaimed(String tlrno, TaskBean rsp)
			throws CommonException {
		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();
		String appno = rsp.getAppno();
		String appType = rsp.getAppType();
		//String taskName = rsp.getTaskName().replaceAll("[0-9]", "");
		String taskName = rsp.getTaskName();

		String flowName = rsp.getProcName();
		String piid = rsp.getPiid();

		WorkflowTaskInfo taskInfo = findTaskInfo(appno, appType, taskName,
				flowName, piid);
		taskInfo.setTaskEndFlag(TASK_STATE_CLAIMED);
		taskInfo.setTlrno(tlrno);

		dao.update(taskInfo);
	}
//
//	public void markTaskUnclaimed(String tlrno, TaskBean rsp)
//			throws CommonException {
//		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();
//		String appno = rsp.getAppno();
//		String appType = rsp.getAppType();
//		//String taskName = rsp.getTaskName().replaceAll("[0-9]", "");
//		String taskName = rsp.getTaskName();
//		String flowName = rsp.getProcName();
//		String piid = rsp.getPiid();
//
//		WorkflowTaskInfo taskInfo = findTaskInfo(appno, appType, taskName,
//				flowName, piid);
//		taskInfo.setTaskEndFlag(TASK_STATE_ASSIGNED);
//		taskInfo.setTlrno(null);
//
//		dao.update(taskInfo);
//	}
//
//	/**
//	 * Description: 在业务数据库中记录任务分配记录
//	 *
//	 * @param
//	 * @exception
//	 * @author richmond_liu
//	 * @version v1.0,2008-8-18
//	 */
//	public void markTaskAssigned(String appno, String appType, String taskName,
//			String workflowRole) throws CommonException {
//		WorkflowTaskInfo taskInfo = new WorkflowTaskInfo();
//		Date now = getCurrentDate();
//		WorkflowTaskInfo flowInfo = findProcessInfo(appno, appType);
//		try {
//			BeanUtils.copyProperties(taskInfo, flowInfo);
//		} catch (Exception e) {
//			ExceptionUtil.throwCommonException("任务分配bean复制出错！",
//					ErrorCode.ERROR_CODE_TASK_ASSIGN_ERROR, e);
//		}
//
//		taskInfo.setId(0);
//		taskInfo.setTaskName(taskName);
//		taskInfo.setTaskStartTime(now);
//		taskInfo.setWorkflowRole(workflowRole);
//		taskInfo.setTaskEndFlag(TASK_STATE_ASSIGNED);
//		taskInfo.setTaskEndTime(null);
//		taskInfo.setTlrno(null);
//
//		// 如果是授信流程，记录流程选择结果到miscflgs
//		if (appType.equals(WorkFlowHelper.APP_TYPE_CreditApplyProcess) && isAfterFlowSelect(appType, taskName)) {
//			HQLDAO dao = DAOUtils.getHQLDAO();
//			Iterator iter = dao
//					.queryByQL(
//							"from ToprulesInvokeLog po where po.dataPk = ? and po.nodeName = ? and timestamps > ? order by po.timestamps desc",
//							new Object[] { appno,
//									SystemConstant.INVOKE_KEY_FLOWSEL,
//									flowInfo.getTimestamps() }, null);
//
//			if (iter.hasNext()) {
//				ToprulesInvokeLog log = (ToprulesInvokeLog) iter.next();
//				taskInfo.setMiscflgs(log.getResult());
//			}
//		}
//
//		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();
//		dao.insert(taskInfo);
//
//		WorkflowAppInfoDAO wDao = DAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(appno);
//		if (appInfo == null) {
//			ExceptionUtil.throwCommonException("没有找到流程信息！",
//					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
//		}
//		appInfo.setCurrRole(workflowRole);
//		wDao.update(appInfo);
//	}
//
//	public boolean isAfterFlowSelect(String appType, String taskName) {
//		if (appType.equals(WorkFlowHelper.APP_TYPE_CreditApplyProcess)
//				&& !taskName.equals(WorkFlowHelper.TASK_NM_CAP_CustMngInput)
//				&& !taskName.equals(WorkFlowHelper.TASK_NM_CAP_CustMngModify)
//				&& !taskName.equals(WorkFlowHelper.TASK_NM_CAP_SubLeaderAudit)
//				&& !taskName.equals(WorkFlowHelper.TASK_NM_CAP_ExceptionAudit)) {
//			return true;
//		}
//
//		return false;
//	}
//
//	/**
//	 * Description: 在业务数据库中记录任务完成记录
//	 *
//	 * @param
//	 * @exception
//	 * @author richmond_liu
//	 * @version v1.0,2008-8-18
//	 */
//	public void markTaskDone(DoTaskRequestBean req, TaskBean rsp)
//			throws CommonException {
//		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();
//		String appno = rsp.getAppno();
//		String appType = rsp.getAppType();
//		String taskName = rsp.getTaskName();
//
//		String flowName = rsp.getProcName();
//		String piid = rsp.getPiid();
//
//		WorkflowTaskInfo taskInfo = findTaskInfo(appno, appType, taskName,
//				flowName, piid);
//		taskInfo.setTaskEndFlag(TASK_STATE_FINISHED);
//		taskInfo.setTaskEndTime(getCurrentDate());
//		taskInfo.setTlrno(req.getTlrno());
//		taskInfo.setMisc(req.getStatus());
//		dao.update(taskInfo);
//
//		WorkflowAppInfoDAO wDao = DAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(rsp.getAppno());
//		if (appInfo == null) {
//			ExceptionUtil.throwCommonException("没有找到流程信息！",
//					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
//		}
//
//		if (taskInfo.getWorkflowRole() != null
//				&& !taskInfo.getWorkflowRole().equals(SystemConstant.WF_ROLE_TYPE_ROLE101)
//				&& !taskInfo.getWorkflowRole().equals(SystemConstant.WF_ROLE_TYPE_ROLE116)) {
//			appInfo.setTimestamps(null);
//			wDao.update(appInfo);
//		}else{
//			appInfo.setStatus(SystemConstant.FLOW_STATUS_INPROCESS);
//			appInfo.setTimestamps(null);
//			wDao.update(appInfo);
//		}
//	}
//
//	/**
//	 * Description: 流程结束时，更新所有相关的任务记录
//	 *
//	 * @param
//	 * @exception
//	 * @author richmond_liu
//	 * @version v1.0,2008-8-18
//	 */
//	public void markFlowEnded(String appno, String appType)
//			throws CommonException {
//		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();
//		Date now = getCurrentDate();
//		List list = dao.queryByCondition(
//				"po.appno = ? and po.apptype = ? and po.procEndFlag = ?",
//				new Object[] { appno, appType, SystemConstant.FLAG_OFF });
//		Iterator iter = list.iterator();
//		while (iter.hasNext()) {
//			WorkflowTaskInfo info = (WorkflowTaskInfo) iter.next();
//			info.setProcEndFlag(SystemConstant.FLAG_ON);
//			info.setProcEndTime(now);
//
//			dao.update(info);
//		}
//
//	}
//
//	/**
//	 * Description: 在业务数据库中，通过申请书号和申请类型查找流程信息
//	 *
//	 * @param
//	 * @return WorkflowTaskInfo
//	 * @exception
//	 * @author richmond_liu
//	 * @version v1.0,2008-8-18
//	 */
//	public WorkflowTaskInfo findProcessInfo(String appno, String appType)
//			throws CommonException {
//		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();
//		List list = dao
//				.queryByCondition(
//						"po.appno = ? and po.apptype = ? and po.taskName = ? and po.procEndFlag = ?",
//						new Object[] { appno, appType, START_TASK_NAME,
//								SystemConstant.FLAG_OFF });
//		if (list.size() == 0) {
//			ExceptionUtil.throwCommonException("没有找到流程信息！",
//					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
//		}
//
//		return (WorkflowTaskInfo) list.get(0);
//	}
//
	public WorkflowTaskInfo findTaskInfo(String appno, String appType,
			String taskName, String flowName, String piid)
			throws CommonException {
		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();

//		String whereString = "where po.appno = '"+appno+"' and po.apptype = '"+appType+"' and po.processTemplate = '"+flowName+
//			"' and po.procInsId = '"+piid+"' and po.taskName = '"+taskName+"' and po.taskEndFlag <> '"+SystemConstant.FLAG_ON+"' order by id desc";
		List list = dao
				.queryByCondition(
						"po.appno = ? and po.apptype = ? and po.processTemplate = ? and po.procInsId = ? and po.taskName = ? and po.taskEndFlag <> ? order by id desc",
						new Object[] { appno, appType, flowName, piid, taskName, "1" });//SystemConstant.FLAG_ON
//		List list = dao.queryByCondition(whereString);
		if (list.size() == 0) {
//			ExceptionUtil.throwCommonException("没有找到任务信息！",
//					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKVALUE_ERROR);
			return null;
		} else {
			return (WorkflowTaskInfo) list.get(0);
		}

	}
//
//	public void markRollBack(String appType, String appno)
//			throws CommonException {
//		if (appType.equals(WorkFlowHelper.APP_TYPE_CreditApplyProcess)) {
//			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
//					appType, WorkFlowHelper.TASK_NM_CAP_CustMngModify,
//					SystemConstant.WF_ROLE_TYPE_ROLE101);
//		} else if (appType.equals(WorkFlowHelper.APP_TYPE_LoanApplyProcess)) {
//			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
//					appType, WorkFlowHelper.TASK_NM_LAP_LoanCustMngModify,
//					SystemConstant.WF_ROLE_TYPE_ROLE101);
//		} else if (appType.equals(WorkFlowHelper.APP_TYPE_FiveClassProcess)) {
//			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
//					appType, WorkFlowHelper.TASK_NM_FCP_FiveClassMngModify,
//					SystemConstant.WF_ROLE_TYPE_ROLE116);
//		} else if (appType.equals(WorkFlowHelper.APP_TYPE_Monitor_Memo)) {
//			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
//					appType, WorkFlowHelper.TASK_NM_ML_CustMngModify,
//					SystemConstant.WF_ROLE_TYPE_ROLE101);
//		} else {
//			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
//					appType, WorkFlowHelper.TASK_NM_MS_CustMngModify,
//					SystemConstant.WF_ROLE_TYPE_ROLE101);
//		}
//	}
//
//	public void markSuccess(String appno, String appType)
//			throws CommonException {
//		WorkflowAppInfoDAO wDao = DAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(appno);
//		if (appInfo == null) {
//			ExceptionUtil.throwCommonException("没有找到流程信息！",
//					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
//		}
//
//		appInfo.setStatus(SystemConstant.FLOW_STATUS_APPROVED);
//		wDao.update(appInfo);
//	}
//
//	public void markReject(String appno, String appType) throws CommonException {
//		WorkflowAppInfoDAO wDao = DAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(appno);
//		if (appInfo == null) {
//			ExceptionUtil.throwCommonException("没有找到流程信息！",
//					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
//		}
//
//		appInfo.setStatus(SystemConstant.FLOW_STATUS_REJECTED);
//		wDao.update(appInfo);
//	}
//
//	public void markException(String appno, String appType)
//			throws CommonException {
//		WorkflowAppInfoDAO wDao = DAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(appno);
//		if (appInfo == null) {
//			ExceptionUtil.throwCommonException("没有找到流程信息！",
//					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
//		}
//
//		appInfo.setStatus(SystemConstant.FLOW_STATUS_EXCEPTION);
//		wDao.update(appInfo);
//	}
//
//	private Date getCurrentDate() throws CommonException{
//		Date now = null;
//		Date time = null;
//		try{
//			now = GlobalInfo.getCurrentInstance().getTxdate();
//		} catch (Exception e){
//			List list = DAOUtils.getGlobalinfoDAO().queryByCondition("1=1");
//			now = ((Globalinfo)list.get(0)).getTbsdy();
//		}
//
//		time = new Date();
//		time.setDate(now.getDate());
//		time.setMonth(now.getMonth());
//		time.setYear(now.getYear());
//
//		return time;
//	}
//
//	/**
//	 * Description: modify by shen_antonio
//	 * for lock table
//	 * @param
//	 * @return void
//	 * @exception
//	 * @author shen_antonio
//	 * @version v1.0,2008-11-6
//	 */
//	public void markFlowStartedAndTaskAssigned(StartFlowRequestBean req,StartFlowResponseBean rsp,String taskName,String workflowRole)throws CommonException {
//		WorkflowTaskInfo flowInfo = new WorkflowTaskInfo();
//		Date now = getCurrentDate();
//
//		flowInfo.setAppno(req.getAppno());
//		flowInfo.setApptype(req.getAppType());
//		flowInfo.setCustcd(req.getCustno());
//		flowInfo.setContractno(req.getContractno());
//		flowInfo.setProcEndFlag(SystemConstant.FLAG_OFF);
//		flowInfo.setProcessTemplate(req.getFlowName());
//		flowInfo.setProcInsId(rsp.getPiid());
//		flowInfo.setProcStartTime(now);
//		flowInfo.setTaskName(START_TASK_NAME);
//		flowInfo.setTaskStartTime(now);
//		flowInfo.setTaskEndFlag(SystemConstant.FLAG_ON);
//		flowInfo.setTlrno(req.getStarter());
//		flowInfo.setTaskEndTime(now);
//
//		WorkflowTaskInfoDAO dao = DAOUtils.getWorkflowTaskInfoDAO();
//		WorkflowTaskInfo taskInfo = new WorkflowTaskInfo();
//		try {
//			BeanUtils.copyProperties(taskInfo, flowInfo);
//		} catch (Exception e) {
//			ExceptionUtil.throwCommonException("任务分配bean复制出错！",
//					ErrorCode.ERROR_CODE_TASK_ASSIGN_ERROR, e);
//		}
//		taskInfo.setId(0);
//		taskInfo.setTaskName(taskName);
//		taskInfo.setTaskStartTime(now);
//		taskInfo.setWorkflowRole(workflowRole);
//		taskInfo.setTaskEndFlag(TASK_STATE_ASSIGNED);
//		taskInfo.setTaskEndTime(null);
//		taskInfo.setTlrno(null);
//		// 如果是授信流程，记录流程选择结果到miscflgs
//		String appType = req.getAppType();
//		if (req.getAppType().equals(WorkFlowHelper.APP_TYPE_CreditApplyProcess) && isAfterFlowSelect(appType, taskName)) {
//			HQLDAO hqlDAO = DAOUtils.getHQLDAO();
//			Iterator iter = hqlDAO
//					.queryByQL(
//							"from ToprulesInvokeLog po where po.dataPk = ? and po.nodeName = ? and timestamps > ? order by po.timestamps desc",
//							new Object[] { req.getAppno(),
//									SystemConstant.INVOKE_KEY_FLOWSEL,
//									flowInfo.getTimestamps() }, null);
//
//			if (iter.hasNext()) {
//				ToprulesInvokeLog log = (ToprulesInvokeLog) iter.next();
//				taskInfo.setMiscflgs(log.getResult());
//			}
//		}
//		dao.insert(flowInfo);
//		dao.insert(taskInfo);
//
//		WorkflowAppInfoDAO wDao = DAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(req.getAppno());
//		if (appInfo == null) {
//			appInfo = new WorkflowAppInfo(req.getAppno(), req.getAppType(), rsp
//					.getPiid(), req.getFlowName(), now,
//					SystemConstant.FLOW_STATUS_NOTUPLOAD);
//			appInfo.setCurrRole(SystemConstant.WF_ROLE_TYPE_ROLE101);
//			appInfo.setBrcode(req.getBrcode());
//			appInfo.setTlrno(req.getStarter());
//
//			String custcd = req.getCustno();
//			CustomerInfo ci = CustomerService.getInstance().queryCustomerById(
//					custcd);
//			appInfo.setCustno(ci.getCustno());
//			appInfo.setCustName(ci.getCname());
//			appInfo.setCurrRole(workflowRole);
//			wDao.insert(appInfo);
//		} else {
//			appInfo.setCurrRole(workflowRole);
//			appInfo.setPiid(rsp.getPiid());
//			appInfo.setStatus(SystemConstant.FLOW_STATUS_NOTUPLOAD);
//			appInfo.setCurrRole(SystemConstant.WF_ROLE_TYPE_ROLE101);
//			appInfo.setTimestamps(null);
//			wDao.update(appInfo);
//		}
//	}
}
