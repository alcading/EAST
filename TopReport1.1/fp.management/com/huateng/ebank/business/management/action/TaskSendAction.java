package com.huateng.ebank.business.management.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.TransferConstant;
import com.huateng.ebank.business.workflow.bean.WorkFlowHelper;
import com.huateng.ebank.framework.web.struts.BaseAction;

public class TaskSendAction extends BaseAction{


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {


		String appno = (String) request.getParameter("appno");
		String taskName=request.getParameter("taskName").toString();
		String taskId = request.getParameter("taskId")==null?"":request.getParameter("taskId").toString();
		String systype = request.getParameter("systype");
		String procName = request.getParameter("procName_")==null?"":request.getParameter("procName_").toString();
		String custno = request.getParameter("custno")==null?"":request.getParameter("custno").toString();
		/** add by Chengyu.LI 贷款减值审批流程 页面传递参数contractno为txnlog的流水号 20101025 begin **/
		String contractno = request.getParameter("contractno")==null?"":request.getParameter("contractno").toString();
		/** add by Chengyu.LI 贷款减值审批流程 页面传递参数contractno为txnlog的流水号 20101025 end **/
		String lncino = request.getParameter("lncino")==null?"":request.getParameter("lncino").toString();
//		if(systype == null || !systype.equals("1") || !systype.equals("2"))
//			mapping.findForward("error");
		Map<String,String> map = new HashMap();
		map.put("appno", appno);
		map.put("taskName", taskName);
		map.put("procName",procName);
		map.put("taskId", taskId);
		map.put("custno", custno);
		if(systype.equals("1"))
		{
			map.put("URL", "/semsWorkFlow.do");//必填
		}
		else if(systype.equals("2"))
		{
			map.put("URL", "/loanWorkFlow.do");//必填
		}else{
			/* portal 的流程 不用跳转 直接在这里转发 */
			if(WorkFlowHelper.WF_NM_NpaTransApplyProcess.equals(procName)){//不良资产移交审批流程

				return  new ActionForward("/fpages/npa/ftl/NpaTransApprove.ftl?appno="+appno+"&taskId="+taskId);
			}else if(WorkFlowHelper.WF_NM_NpaLawsuitApplyProcess.equals(procName)){//诉讼申请审批

				return  new ActionForward("/fpages/npa/ftl/NpaLawsuitApprove.ftl?appno="+appno+"&taskId="+taskId);
			}else if(WorkFlowHelper.WF_NM_NpaRecoveryApplyProcess.equals(procName)){//清收方案审批流程

				return  new ActionForward("/fpages/npa/ftl/NpaRecoveryApprove.ftl?appno="+appno+"&taskId="+taskId);
			}
			/** add by Chengyu.LI 贷款减值审批流程 页面传递参数contractno为txnlog的流水号 20101025 begin **/
			else if(WorkFlowHelper.WF_NM_LoanImpairmentApplyProcess.equals(procName)){
				return  new ActionForward("/fpages/loanImpairment/ftl/loanImpairment2.ftl?appno="+appno+"&taskId="+taskId+"&contractno="+contractno);
			}
			/** add by Chengyu.LI 贷款减值审批流程 页面传递参数contractno为txnlog的流水号 20101025 end **/
			/** add by fan.jiang 20110210 贷款销户 begin*/
			else if(WorkFlowHelper.WFP_LOAN_ChG_LnciActApplyProcess.equals(procName)){//贷款销户审批流程
				return new  ActionForward("/fpages/lncoChg/ftl/lnciActApprove.ftl?appno="+appno+"&taskId="+taskId+"&lncino="+contractno);
			}
			/** add by fan.jiang 20110210 贷款销户 end*/
			/** add by fan.jiang 20110210 贷款核销 begin*/
			else if(WorkFlowHelper.WFP_LOAN_ChG_LnciRecApplyProcess.equals(procName)){//贷款核销审批流程
				return new  ActionForward("/fpages/lncoChg/ftl/lnciRecApprove.ftl?appno="+appno+"&taskId="+taskId+"&lncino="+contractno);
			}
			/** add by fan.jiang 20110210 贷款核销 end*/
			/** add by fan.jiang 20110210 贷款还款计划变更 begin*/
			else if(WorkFlowHelper.WFP_LOAN_ChG_LnRtnChgApplyProcess.equals(procName)){//贷款还款计划变更审批流程
				return new  ActionForward("/fpages/postloanalter/rtnplan/ftl/rtnplanChgApprove.ftl?appno="+appno+"&taskId="+taskId+"&lncino="+contractno);
			}
			/** add by fan.jiang 20110210 贷款还款计划变更 end*/
			/** add by jornezhang 2011-1-25 贷款减值计提 begin */
			else if(WorkFlowHelper.WFP_LOAN_ChG_LnPreimpApplyProcess.equals(procName)){//贷款减值计提审批流程
				return new  ActionForward("/fpages/lncoChg/ftl/lnPreimpApprove.ftl?appno="+appno+"&taskId="+taskId);
			}
			/** add by jornezhang 2011-1-25 贷款减值计提 end */

			/** add by qianlong 罚金减免审批流程  start **/
			else if(WorkFlowHelper.WFP_LOAN_CHG_PENALTY_REDUCTION_APPLY_PROCESS.equals(procName)){//罚金减免审批流程
				return new  ActionForward("/fpages/penaltyreduction/ftl/penaltyReductionApprove.ftl?appno="+appno+"&taskId="+taskId+"&lncino="+contractno);
			}
			/** add by qianlong 罚金减免审批流程 end **/
			/**提前还款*/
			else if(WorkFlowHelper.WFP_LOAN_ChG_LnRtnBackApplyProcess.equals(procName)){//提前还款审批流程
				return new  ActionForward("/fpages/postloanalter/rtnplan/ftl/rtnAdvApproveList.ftl?appno="+appno+"&taskId="+taskId+"&lncino="+contractno);
			}
			/**挪用罚息*/
			else if(WorkFlowHelper.WFP_LOAN_ChG_LnDivertIntApplyProcess.equals(procName)){//挪用罚息审批流程
				return new  ActionForward("/fpages/divertInt/ftl/lnDivertIntApprove.ftl?appno="+appno+"&taskId="+taskId+"&lncino="+contractno);
			}

		}
		map.put("SYSTYPE", systype);//必填

		request.setAttribute(TransferConstant.SEND_VALUE_MAP, map);


		return mapping.findForward("ok");
	}
}
