package com.huateng.report.common.bean;

import java.io.Serializable;

public class UndoConfirmTaskBean implements Serializable {

	private String intInsId;
	
	private String intInsIdName;
	
	private Long count;

	public String getIntInsId() {
		return intInsId;
	}

	public void setIntInsId(String intInsId) {
		this.intInsId = intInsId;
	}

	public String getIntInsIdName() {
		return intInsIdName;
	}

	public void setIntInsIdName(String intInsIdName) {
		this.intInsIdName = intInsIdName;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public UndoConfirmTaskBean(String intInsId, String intInsIdName,
			Long count) {
		super();
		this.intInsId = intInsId;
		this.intInsIdName = intInsIdName;
		this.count = count;
	}

	public UndoConfirmTaskBean() {
		super();
	}

	public UndoConfirmTaskBean(String intInsId, Long count) {
		this.intInsId = intInsId;
		this.count = count;
	}
	
	
}
