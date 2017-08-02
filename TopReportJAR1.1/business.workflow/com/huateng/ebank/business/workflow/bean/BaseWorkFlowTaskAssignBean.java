/**
 *
 */
package com.huateng.ebank.business.workflow.bean;

import java.util.List;

/**
 * Title: BaseWorkFlowTaskAssignBean
 * Description: 工作流任务分配相关Bean
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-3-31
 */
public abstract class BaseWorkFlowTaskAssignBean {

	/** memeber variable: List<String>　tlrnoList. */
	private List tlrnoList;
	/** memeber variable: String　brcode. */
	private String brcode;
	/** memeber variable: String　workType. */
	private String workType;
	/** memeber variable: String　assignMode. */
	private String assignMode;
	/** memeber variable: boolean　isWorkType. */
	private boolean isWorkType;
	/** memeber variable: boolean　isLv. */
	private boolean isLv;


	public BaseWorkFlowTaskAssignBean(List tlrnoList, String brcode,
			String workType, String assignMode, boolean isWorkType, boolean isLv) {
		super();
		this.tlrnoList = tlrnoList;
		this.brcode = brcode;
		this.workType = workType;
		this.assignMode = assignMode;
		this.isWorkType = isWorkType;
		this.isLv = isLv;
	}

	public BaseWorkFlowTaskAssignBean() {
		super();
	}

	public List getTlrnoList() {
		return tlrnoList;
	}
	public void setTlrnoList(List tlrnoList) {
		this.tlrnoList = tlrnoList;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getAssignMode() {
		return assignMode;
	}
	public void setAssignMode(String assignMode) {
		this.assignMode = assignMode;
	}
	public boolean isWorkType() {
		return isWorkType;
	}
	public void setWorkType(boolean isWorkType) {
		this.isWorkType = isWorkType;
	}
	public boolean isLv() {
		return isLv;
	}
	public void setLv(boolean isLv) {
		this.isLv = isLv;
	}

}
