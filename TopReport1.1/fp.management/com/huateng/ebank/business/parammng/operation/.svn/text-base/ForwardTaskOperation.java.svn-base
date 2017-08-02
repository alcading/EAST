/**
 *
 */
package com.huateng.ebank.business.parammng.operation;

import java.util.List;

import resource.bean.pub.TlrInfo;
import resource.dao.pub.TlrInfoDAO;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.business.workflow.bean.TaskBean;
import com.huateng.ebank.business.workflow.bean.WorkFlowForwardTaskBean;
import com.huateng.ebank.business.workflow.service.WorkFlowService;
import com.huateng.ebank.entity.dao.flowManagement.ApplydtlDAO;
import com.huateng.ebank.entity.data.flowManagement.Applydtl;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class ForwardTaskOperation extends BaseOperation {

	public static final String ID = "parammng.ForwardTaskOperation";
	public static final String TASK_LIST = "TASK_LIST";
	public static final String FORWARDTLRNO = "FORWARDTLRNO";

	public void afterProc(OperationContext context) throws CommonException {}

	public void beforeProc(OperationContext context) throws CommonException {}


	public void execute(OperationContext context) throws CommonException {
		
		String forwardTlrno = (String)context.getAttribute(FORWARDTLRNO);
		List taskList = (List) context.getAttribute(TASK_LIST);
		
		WorkFlowService workFlowService = WorkFlowService.getInstance();
		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		
		for(int i = 0; i < taskList.size(); i++){
			TaskBean taskBean = (TaskBean)taskList.get(i);
			String procInsId = taskBean.getPiid();
			String taskId = taskBean.getTaskId();
//			String tlrno = taskBean.getOwner();

			TlrInfo tlrInfo = tlrInfoDAO.query(forwardTlrno);
			String obrcode = tlrInfo.getBrcode();

//			if(!tlrno.equals(SystemConstant.ROLE_DEFINFE_TLRNO)){
//				//检查被移交操作员与原操作员是否同一机构
//				if(!obrcode.equals(tlrInfoDAO.query(tlrno).getBrcode())){
//					ExceptionUtil.throwCommonException("被移交操作员与原操作员不在同一机构",
//							ErrorCode.ERROR_CODE_TASK_FORWARD_ERROR);
//				}
//			}

			//指定任务移交
			WorkFlowForwardTaskBean workFlowForwardTaskBean = new WorkFlowForwardTaskBean(procInsId,taskId,forwardTlrno,obrcode);
			workFlowForwardTaskBean.setTaskName(taskBean.getTaskName());
			workFlowService.forwardTask(workFlowForwardTaskBean);
			
//			WorkflowTaskInfo WorkflowTaskInfo = DAOUtils.getWorkflowTaskInfoDAO().queryByTaskId(workFlowForwardTaskBean.getTaskId());
//			String roleTypeO = WorkflowTaskInfo.getRoleType();
//
//			if(!tlrno.equals(SystemConstant.ROLE_DEFINFE_TLRNO)){
//				//检查被移交操作员岗位类型
//				List roleInfoList = TellerService.getInstance().getTellerRoleInfoList(forwardTlrno);
//				List roleTypeList = new ArrayList();
//				for(int n = 0; n < roleInfoList.size(); n++){
//					String roleTypeN = ((RoleInfo)roleInfoList.get(n)).getRoleType();
//					roleTypeList.add(roleTypeN);
//				}
//				if(!roleTypeList.contains(roleTypeO)){
//					ExceptionUtil.throwCommonException("被移交的操作员并不具有执行该任务的权限",
//							ErrorCode.ERROR_CODE_TASK_FORWARD_ERROR);
//				}
//			}

			//移交任务同时插入历史审批意见表
			ApplydtlDAO applyDtlDAO = DAOUtils.getApplydtlDAO();
			Applydtl applydtl = new Applydtl();
			applydtl.setAppno(taskBean.getAppno());
			applydtl.setTxnDate(globalInfo.getTxdate());
//			applydtl.setTxtime(globalInfo.getTxtime().toString());
			applydtl.setAttitude(SystemConstant.APP_ATTITUDE_AGREE);
			applydtl.setContractno(taskBean.getContractno());
			applydtl.setReason("任务移交");
			applydtl.setBrcode(obrcode);
//			applydtl.setTlrno(globalInfo.getTlrno());
			applydtl.setTlsrno(globalInfo.getTlrno());
			applydtl.setFuncCode(globalInfo.getFuncCode());
//			applydtl.setUntread(SystemConstant.APPLYDTL_UNTREAD_NO);
//			Applydtl applydtltmp = (Applydtl) DAOUtils.getApplydtlDAO().queryByAppno(appno).get(0);
//			applydtl.setApptype(applydtltmp.getApptype());
			applydtl.setApptype(taskBean.getAppType());
			applydtl.setRoleId(tlrInfo.getRoleid());
			applyDtlDAO.insert(applydtl);

		}
	}
}
