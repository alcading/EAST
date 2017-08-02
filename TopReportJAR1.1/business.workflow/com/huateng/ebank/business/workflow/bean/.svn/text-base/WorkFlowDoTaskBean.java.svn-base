/**
 *
 */
package com.huateng.ebank.business.workflow.bean;

import java.util.List;
import java.util.Map;

/**
 * Title: WorkFlowDoTaskBean
 * Description: 执行任务Bean
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-3-31
 */
public class WorkFlowDoTaskBean extends BaseWorkFlowTaskAssignBean{

	/** memeber variable: String　tlrno. */
	private String tlrno;
	/** memeber variable: String　procInsId. */
	private String procInsId;
	/** memeber variable: String　taskId. */
	private String taskId;
	/** memeber variable: Map　attribute. */
	private Map attribute;
	/** memeber variable: String　status. */
	private String status;
	/** memeber variable: String　comment. */
	private String comment;


	/**
	 * 执行任务Bean构造
	 * @param tlrnoList 下步任务待选操作员列表
	 * @param brcode 机构号
	 * @param workType 工作类型(01-贷前 02-贷后)
	 * @param assignMode 工作分配模式(0-分配到岗位，1-分配到人(按工作两分配),2-完全随机分配)
	 * @param isWorkType 是否根据工作类型统分析
	 * @param isLv 是否有请假制度
	 * @param tlrno 完成工作操作员号
	 * @param procInsId 任务所属实例号
	 * @param taskId 执行任务号
	 * @param attribute 传入工作流参数
	 * @param status 执行操作
	 * @param comment 执行任务留言(允许为NULL)
	 * 2008-3-31
	 */
	public WorkFlowDoTaskBean(List tlrnoList, String brcode,
			String workType, String assignMode, boolean isWorkType,
			boolean isLv, String tlrno,String procInsId,String taskId, Map attribute,String status,String comment) {
		super(tlrnoList, brcode, workType, assignMode, isWorkType, isLv);
		this.tlrno = tlrno;
		this.procInsId = procInsId;
		this.taskId = taskId;
		this.attribute = attribute;
		this.status = status;
		this.comment = comment;
	}

	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public Map getAttribute() {
		return attribute;
	}
	public void setAttribute(Map attribute) {
		this.attribute = attribute;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getProcInsId() {
		return procInsId;
	}

	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}

	public String getTlrno() {
		return tlrno;
	}

	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

}
