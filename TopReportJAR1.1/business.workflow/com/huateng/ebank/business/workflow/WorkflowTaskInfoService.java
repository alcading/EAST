package com.huateng.ebank.business.workflow;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import resource.bean.pub.Globalinfo;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.workflow.bean.DoTaskRequestBean;
import com.huateng.ebank.business.workflow.bean.TaskBean;
import com.huateng.ebank.business.workflow.bean.WorkFlowHelper;
import com.huateng.ebank.entity.dao.workflow.WorkflowAppInfoDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowTaskInfoDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowAppInfo;
import com.huateng.ebank.entity.data.workflow.WorkflowTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class WorkflowTaskInfoService {

	public static final String START_TASK_NAME = "StartFlow";

	public static final String TASK_STATE_ASSIGNED = "0";
	public static final String TASK_STATE_CLAIMED = "2";
	public static final String TASK_STATE_FINISHED = "1";

	public static WorkflowTaskInfoService getInstance() {
		return (WorkflowTaskInfoService) ApplicationContextUtils
				.getBean("WorkflowTaskInfoService");
	}
//del by zhaozhiguo
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
//		taskInfo.setCustcd(req.getCustcd());
//		taskInfo.setContractno(req.getContractno());
//		taskInfo.setProcEndFlag(WorkFlowConstants.FLAG_OFF);
//		taskInfo.setProcessTemplate(req.getFlowName());
//		taskInfo.setProcInsId(rsp.getPiid());
//		taskInfo.setProcStartTime(now);
//		taskInfo.setTaskName(START_TASK_NAME);
//		taskInfo.setTaskStartTime(now);
//		taskInfo.setTaskEndFlag(WorkFlowConstants.FLAG_ON);
//		taskInfo.setTlrno(req.getStarter());
//		taskInfo.setTaskEndTime(now);
//		taskInfo.setMisc(req.getStarter());
//
//		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();
//		dao.insert(taskInfo);
//
//		WorkflowAppInfoDAO wDao = BaseDAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(req.getAppno());
//		if (appInfo == null) {
//			appInfo = new WorkflowAppInfo(req.getAppno(), req.getAppType(), rsp
//					.getPiid(), req.getFlowName(), now,
//					"0");
//			appInfo.setCurrRole(String.valueOf(WorkFlowConstants.ROLE_ID_LOAN_INPUT));
//			appInfo.setBrcode(req.getBrcode());
//			appInfo.setTlrno(req.getStarter());
//
//			String custcd = req.getCustcd();
//			/* mod by kangbyron 20101015  避免custcd为空时报错 begin  */
//			if(!DataFormat.isEmpty(custcd)){
//				CustomerInfo ci = BaseDAOUtils.getCustomerInfoDAO().queryById(custcd);
//				appInfo.setCustno(ci.getCustno());
//				appInfo.setCustName(ci.getCname());
//			}
//			/* mod by kangbyron 20101015  避免custcd为空时报错 end  */
//			wDao.insert(appInfo);
//		} else {
//			appInfo.setPiid(rsp.getPiid());
//			appInfo.setStatus("0");
//			appInfo.setCurrRole(String.valueOf(WorkFlowConstants.ROLE_ID_LOAN_INPUT));
//			appInfo.setTimestamps(null);
//			wDao.update(appInfo);
//		}
//
//	}

	public void markTaskClaimed(String tlrno, TaskBean rsp)
			throws CommonException {
		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();
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

	public void markTaskUnclaimed(String tlrno, TaskBean rsp)
			throws CommonException {
		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();
		String appno = rsp.getAppno();
		String appType = rsp.getAppType();
		//String taskName = rsp.getTaskName().replaceAll("[0-9]", "");
		String taskName = rsp.getTaskName();
		String flowName = rsp.getProcName();
		String piid = rsp.getPiid();

		WorkflowTaskInfo taskInfo = findTaskInfo(appno, appType, taskName,
				flowName, piid);
		taskInfo.setTaskEndFlag(TASK_STATE_ASSIGNED);
		taskInfo.setTlrno(null);

		dao.update(taskInfo);
	}

	/**
	 * Description: 在业务数据库中记录任务分配记录
	 *
	 * @param
	 * @exception
	 * @author richmond_liu
	 * @version v1.0,2008-8-18
	 */
	public void markTaskAssigned(String appno, String appType, String taskName,
			String workflowRole) throws CommonException {
		WorkflowTaskInfo taskInfo = new WorkflowTaskInfo();
		Date now = getCurrentDate();
		WorkflowTaskInfo flowInfo = findProcessInfo(appno, appType);
		try {
			BeanUtils.copyProperties(taskInfo, flowInfo);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("任务分配bean复制出错！",
					ErrorCode.ERROR_CODE_TASK_ASSIGN_ERROR, e);
		}

		taskInfo.setId(0);
		taskInfo.setTaskName(taskName);
		taskInfo.setTaskStartTime(now);
		taskInfo.setWorkflowRole(workflowRole);
		taskInfo.setTaskEndFlag(TASK_STATE_ASSIGNED);
		taskInfo.setTaskEndTime(null);
		taskInfo.setTlrno(null);


		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();
		//退回不用在向数据库插数据了(合同和授信流程)。在工作流的GetTaskAssign类中已经插入了数据了。
		if(!taskName.equalsIgnoreCase(WorkFlowHelper.TASK_NM_CAP_CustMngModify))
		{
			if(!taskName.equalsIgnoreCase(WorkFlowHelper.TASK_NM_LAP_LoanCustMngModify))
			{
				dao.insert(taskInfo);
			}
		}

		WorkflowAppInfoDAO wDao = BaseDAOUtils.getWorkflowAppInfoDAO();
		WorkflowAppInfo appInfo = wDao.queryById(appno);
		if (appInfo == null) {
			ExceptionUtil.throwCommonException("没有找到流程信息！",
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}
		appInfo.setCurrRole(workflowRole);
		wDao.update(appInfo);
	}

	public boolean isAfterFlowSelect(String appType, String taskName) {
		if (appType.equals(WorkFlowHelper.APP_TYPE_CreditApplyProcess)
				&& !taskName.equals(WorkFlowHelper.TASK_NM_CAP_CustMngInput)
				&& !taskName.equals(WorkFlowHelper.TASK_NM_CAP_CustMngModify)
				&& !taskName.equals(WorkFlowHelper.TASK_NM_CAP_SubLeaderAudit)
				&& !taskName.equals(WorkFlowHelper.TASK_NM_CAP_ExceptionAudit)) {
			return true;
		}

		return false;
	}

	/**
	 * Description: 在业务数据库中记录任务完成记录
	 *
	 * @param
	 * @exception
	 * @author richmond_liu
	 * @version v1.0,2008-8-18
	 */
	public void markTaskDone(DoTaskRequestBean req, TaskBean rsp)
			throws CommonException {
		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();
		String appno = rsp.getAppno();
		String appType = rsp.getAppType();
		String taskName = rsp.getTaskName();

		String flowName = rsp.getProcName();
		String piid = rsp.getPiid();

		WorkflowTaskInfo taskInfo = findTaskInfo(appno, appType, taskName,
				flowName, piid);
		taskInfo.setTaskEndFlag(TASK_STATE_FINISHED);
		taskInfo.setTaskEndTime(getCurrentDate());
		taskInfo.setTlrno(req.getTlrno());
		taskInfo.setMisc(req.getStatus());
		dao.update(taskInfo);

		WorkflowAppInfoDAO wDao = BaseDAOUtils.getWorkflowAppInfoDAO();
		WorkflowAppInfo appInfo = wDao.queryById(rsp.getAppno());
		if (appInfo == null) {
			ExceptionUtil.throwCommonException("没有找到流程信息！",
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}

		if (taskInfo.getWorkflowRole() != null
				&& !taskInfo.getWorkflowRole().equals(WorkFlowConstants.WF_ROLE_TYPE_ROLE101)
				&& !taskInfo.getWorkflowRole().equals(WorkFlowConstants.WF_ROLE_TYPE_ROLE116)) {
			appInfo.setTimestamps(null);
			wDao.update(appInfo);
		}else{
			appInfo.setStatus(WorkFlowConstants.FLOW_STATUS_INPROCESS);
			appInfo.setTimestamps(null);
			wDao.update(appInfo);
		}
	}

	/**
	 * Description: 流程结束时，更新所有相关的任务记录
	 *
	 * @param
	 * @exception
	 * @author richmond_liu
	 * @version v1.0,2008-8-18
	 */
	public void markFlowEnded(String appno, String appType)
			throws CommonException {
		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();
		Date now = getCurrentDate();
		List list = dao.queryByCondition(
				"po.appno = ? and po.apptype = ? and po.procEndFlag = ?",
				new Object[] { appno, appType, WorkFlowConstants.FLAG_OFF });
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			WorkflowTaskInfo info = (WorkflowTaskInfo) iter.next();
			info.setProcEndFlag(WorkFlowConstants.FLAG_ON);
			info.setProcEndTime(now);

			dao.update(info);
		}

	}

	/**
	 * Description: 在业务数据库中，通过申请书号和申请类型查找流程信息
	 *
	 * @param
	 * @return WorkflowTaskInfo
	 * @exception
	 * @author richmond_liu
	 * @version v1.0,2008-8-18
	 */
	public WorkflowTaskInfo findProcessInfo(String appno, String appType)
			throws CommonException {
		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();
		List list = dao
				.queryByCondition(
						"po.appno = ? and po.apptype = ? and po.taskName = ? and po.procEndFlag = ?",
						new Object[] { appno, appType, START_TASK_NAME,
								WorkFlowConstants.FLAG_OFF });
		if (list.size() == 0) {
			ExceptionUtil.throwCommonException("没有找到流程信息！",
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}

		return (WorkflowTaskInfo) list.get(0);
	}

	public WorkflowTaskInfo findTaskInfo(String appno, String appType,
			String taskName, String flowName, String piid)
			throws CommonException {
		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();

//		String whereString = "where po.appno = '"+appno+"' and po.apptype = '"+appType+"' and po.processTemplate = '"+flowName+
//			"' and po.procInsId = '"+piid+"' and po.taskName = '"+taskName+"' and po.taskEndFlag <> '"+WorkFlowConstants.FLAG_ON+"' order by id desc";
		List list = dao
				.queryByCondition(
						"po.appno = ? and po.apptype = ? and po.processTemplate = ? and po.procInsId = ? and po.taskName = ? and po.taskEndFlag <> ? order by id desc",
						new Object[] { appno, appType, flowName, piid, taskName, "1" });//WorkFlowConstants.FLAG_ON
//		List list = dao.queryByCondition(whereString);
		if (list.size() == 0) {
//			ExceptionUtil.throwCommonException("没有找到任务信息！",
//					ErrorCode.ERROR_CODE_WORKFLOW_GETTASKVALUE_ERROR);
			return null;
		} else {
			return (WorkflowTaskInfo) list.get(0);
		}

	}

	public void markRollBack(String appType, String appno)
			throws CommonException {
		if (appType.equals(WorkFlowHelper.APP_TYPE_CreditApplyProcess)) {
			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
					appType, WorkFlowHelper.TASK_NM_CAP_CustMngModify,
					WorkFlowConstants.WF_ROLE_TYPE_ROLE100);
		} else if (appType.equals(WorkFlowHelper.APP_TYPE_LoanApplyProcess)) {
			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
					appType, WorkFlowHelper.TASK_NM_LAP_LoanCustMngModify,
					WorkFlowConstants.WF_ROLE_TYPE_ROLE100);
		} else if (appType.equals(WorkFlowHelper.APP_TYPE_FiveClassProcess)) {
			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
					appType, WorkFlowHelper.TASK_NM_FCP_FiveClassMngModify,
					WorkFlowConstants.WF_ROLE_TYPE_ROLE116);
		} else if (appType.equals(WorkFlowHelper.APP_TYPE_Monitor_Memo)) {
			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
					appType, WorkFlowHelper.TASK_NM_ML_CustMngModify,
					WorkFlowConstants.WF_ROLE_TYPE_ROLE101);
		} else {
			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
					appType, WorkFlowHelper.TASK_NM_MS_CustMngModify,
					WorkFlowConstants.WF_ROLE_TYPE_ROLE101);
		}
	}

	public void markSuccess(String appno, String appType)
			throws CommonException {
		WorkflowAppInfoDAO wDao = BaseDAOUtils.getWorkflowAppInfoDAO();
		WorkflowAppInfo appInfo = wDao.queryById(appno);
		if (appInfo == null) {
			ExceptionUtil.throwCommonException("没有找到流程信息！",
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}

		appInfo.setStatus(WorkFlowConstants.FLOW_STATUS_APPROVED);
		wDao.update(appInfo);
	}

	public void markReject(String appno, String appType) throws CommonException {
		WorkflowAppInfoDAO wDao = BaseDAOUtils.getWorkflowAppInfoDAO();
		WorkflowAppInfo appInfo = wDao.queryById(appno);
		if (appInfo == null) {
			ExceptionUtil.throwCommonException("没有找到流程信息！",
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}

		appInfo.setStatus(WorkFlowConstants.FLOW_STATUS_REJECTED);
		wDao.update(appInfo);
	}

	public void markException(String appno, String appType)
			throws CommonException {
		WorkflowAppInfoDAO wDao = BaseDAOUtils.getWorkflowAppInfoDAO();
		WorkflowAppInfo appInfo = wDao.queryById(appno);
		if (appInfo == null) {
			ExceptionUtil.throwCommonException("没有找到流程信息！",
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR);
		}

		appInfo.setStatus(WorkFlowConstants.FLOW_STATUS_EXCEPTION);
		wDao.update(appInfo);
	}

	private Date getCurrentDate() throws CommonException{
		Date now = null;
		Date time = null;
		try{
			now = GlobalInfo.getCurrentInstance().getTxdate();
		} catch (Exception e){
			List list = BaseDAOUtils.getGlobalinfoDAO().queryByCondition("1=1");
			now = ((Globalinfo)list.get(0)).getTbsdy();
		}

		time = new Date();
		time.setDate(now.getDate());
		time.setMonth(now.getMonth());
		time.setYear(now.getYear());

		return time;
	}
//del by zhaozhiguo
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
//		flowInfo.setProcEndFlag(WorkFlowConstants.FLAG_OFF);
//		flowInfo.setProcessTemplate(req.getFlowName());
//		flowInfo.setProcInsId(rsp.getPiid());
//		flowInfo.setProcStartTime(now);
//		flowInfo.setTaskName(START_TASK_NAME);
//		flowInfo.setTaskStartTime(now);
//		flowInfo.setTaskEndFlag(WorkFlowConstants.FLAG_ON);
//		flowInfo.setTlrno(req.getStarter());
//		flowInfo.setTaskEndTime(now);
//
//		WorkflowTaskInfoDAO dao = BaseDAOUtils.getWorkflowTaskInfoDAO();
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
//			HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
//			Iterator iter = hqlDAO
//					.queryByQL(
//							"from ToprulesInvokeLog po where po.dataPk = ? and po.nodeName = ? and timestamps > ? order by po.timestamps desc",
//							new Object[] { req.getAppno(),
//									WorkFlowConstants.INVOKE_KEY_FLOWSEL,
//									flowInfo.getTimestamps() }, null);
//
//			if (iter.hasNext()) {
////				ToprulesInvokeLog log = (ToprulesInvokeLog) iter.next();
////				taskInfo.setMiscflgs(log.getResult());
//			}
//		}
//		dao.insert(flowInfo);
//		dao.insert(taskInfo);
//
//		WorkflowAppInfoDAO wDao = BaseDAOUtils.getWorkflowAppInfoDAO();
//		WorkflowAppInfo appInfo = wDao.queryById(req.getAppno());
//		if (appInfo == null) {
//			appInfo = new WorkflowAppInfo(req.getAppno(), req.getAppType(), rsp
//					.getPiid(), req.getFlowName(), now,
//					WorkFlowConstants.FLOW_STATUS_NOTUPLOAD);
//			appInfo.setCurrRole(WorkFlowConstants.WF_ROLE_TYPE_ROLE101);
//			appInfo.setBrcode(req.getBrcode());
//			appInfo.setTlrno(req.getStarter());
//
//			String custcd = req.getCustno();
//			CustomerInfoDAO cid = BaseDAOUtils.getCustomerInfoDAO();
//			CustomerInfo ci = cid.queryById(custcd);
//
//			appInfo.setCustno(ci.getCustno());
//			appInfo.setCustName(ci.getCname());
//			appInfo.setCurrRole(workflowRole);
//			wDao.insert(appInfo);
//		} else {
//			appInfo.setCurrRole(workflowRole);
//			appInfo.setPiid(rsp.getPiid());
//			appInfo.setStatus(WorkFlowConstants.FLOW_STATUS_NOTUPLOAD);
//			appInfo.setCurrRole(WorkFlowConstants.WF_ROLE_TYPE_ROLE101);
//			appInfo.setTimestamps(null);
//			wDao.update(appInfo);
//		}
//	}
}
