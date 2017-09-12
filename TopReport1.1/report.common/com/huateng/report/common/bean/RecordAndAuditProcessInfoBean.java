package com.huateng.report.common.bean;

import java.io.Serializable;

public class RecordAndAuditProcessInfoBean implements Serializable {

	private String brNo;
	
	private String brNoName;
	
	private String appType;
	
	private Integer notRecord;
	
	private Integer notAudit;
	
	private Integer hasReport;

	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public String getBrNoName() {
		return brNoName;
	}

	public void setBrNoName(String brNoName) {
		this.brNoName = brNoName;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Integer getNotRecord() {
		return notRecord;
	}

	public void setNotRecord(Integer notRecord) {
		this.notRecord = notRecord;
	}

	public Integer getNotAudit() {
		return notAudit;
	}

	public void setNotAudit(Integer notAudit) {
		this.notAudit = notAudit;
	}

	public Integer getHasReport() {
		return hasReport;
	}

	public void setHasReport(Integer hasReport) {
		this.hasReport = hasReport;
	}

}
