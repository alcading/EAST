/**
 *
 */
package com.huateng.ebank.business.workflow;

/**
 * Title: IWorkflowRuleEngine
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-3
 */
public interface IWorkflowRuleEngine {

	public final static String HEADAPPROVETASKRULE = "HeadApprove";
	public final static String LOAN_APPLY_WORKFLOW = "LoanApplyWorkflowRule";
	public final static String LOANCTRAUDITTASKRULE = "LoanCtrAudit";
	public final static String LOANCTRAPPROVETASKRULE = "LoanCtrApprove";
	public final static String BRANCHAPPROVETASKRULE = "BranchApprove";
	public final static String SUBBRANCHAPPROVETASKRULE = "SubBranchApprove";
	public final static String BRANCHUPAPPROVETASKRULE = "BranchUpApprove";
	public final static String BACKTOMODIFYTASKRULE = "BackToModify";
	public final static String BRANCHAUDITTASKRULE = "BranchAudit";
	public final static String SUBBRANCHAUDITTASKRULE = "SubBranchAudit";
	public final static String LOANSUPERVISETASKRULE = "LoanSupervise";
	public final static String CREDIT_APPLY_WORKFLOW = "CreditApplyWorkflowRule";
	public final static String PROJECT_APPLY_WORKFLOW = "ProjectApplyWorkflowRule";
	public final static String PROJECT_MODIFY_WORKFLOW = "ProjectModifyWorkflowRule";
	public final static String PROJECT_STOP_WORKFLOW = "ProjectStopWorkflowRule";
	public final static String CREDIT_ALTER_WORKFLOW = "CreditAlterWorkflowRule";
	public final static String CREDIT_ALTER1_WORKFLOW = "CreditAlter1WorkflowRule";
	public final static String CREDIT_ALTER2_WORKFLOW = "CreditAlter2WorkflowRule";
	public final static String LOAN_ALTER_WORKFLOW = "LoanAlterWorkflowRule";
	public final static String LOAN_ALTER1_WORKFLOW = "LoanAlter1WorkflowRule";
	public final static String LOAN_ALTER2_WORKFLOW = "LoanAlter2WorkflowRule";
	public final static String LOAN_ALTER3_WORKFLOW = "LoanAlter3WorkflowRule";
//	public final static String LOAN_ALTER3_APPROVE_TASK_RULE = "LoanAlter3ApproveTaskRule";
	public final static String LOAN_ALTER4_WORKFLOW = "LoanAlter4WorkflowRule";
	public final static String LOAN_ALTER5_WORKFLOW = "LoanAlter5WorkflowRule";
	public final static String LOAN_ALTER6_WORKFLOW = "LoanAlter6WorkflowRule";
	public final static String LOAN_ALTER7_WORKFLOW = "LoanAlter7WorkflowRule";

	public final static String POST_LOAN_MNG1_WORKFLOW = "PostLoanMng1WorkflowRule";


}
