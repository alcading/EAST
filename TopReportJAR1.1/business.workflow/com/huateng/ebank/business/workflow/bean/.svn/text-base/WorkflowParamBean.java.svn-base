/*
 * Created on 2007-9-5
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.workflow.bean;

import java.util.HashSet;
import java.util.Set;

import com.huateng.ebank.entity.data.workflow.WorkflowParam;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class WorkflowParamBean {
	// //流程名 英文
	// private String flowName;

	// //贷款金额
	// private double lnamt;
	private static Set set;
	static {
        set = new HashSet();
        set.add("workflowParam");
    }
	private WorkflowParam workflowParam = new WorkflowParam(); //票据信息


	/** 流程名称 */
	private String procName;
	/**节点名*/
	private String nodeName;
	/**节点类型*/
	private String nodeType1;

	private boolean selected;


	public String getProcName() {
		return procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}


	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}


	public static boolean isBeanProperty(String propertyName) {
        return set.contains(propertyName);
    }

	public static Set getSet() {
		return set;
	}

	public static void setSet(Set set) {
		WorkflowParamBean.set = set;
	}

	public WorkflowParam getWorkflowParam() {
		return workflowParam;
	}

	public void setWorkflowParam(WorkflowParam workflowParam) {
		this.workflowParam = workflowParam;
	}

	public String getNodeType1() {
		return nodeType1;
	}

	public void setNodeType1(String nodeType1) {
		this.nodeType1 = nodeType1;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
