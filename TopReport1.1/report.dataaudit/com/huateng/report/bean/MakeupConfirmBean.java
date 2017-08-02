package com.huateng.report.bean;

import java.io.Serializable;

public class MakeupConfirmBean implements Serializable {

	private static final long serialVersionUID = 307693110142485027L;
	private String apptype;
	private String currentfile;
	private Integer hashNum;
	private Integer noNum;
	private String workDate;
	private String busiType;

	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getCurrentfile() {
		return currentfile;
	}

	public void setCurrentfile(String currentfile) {
		this.currentfile = currentfile;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public Integer getHashNum() {
		return hashNum;
	}

	public void setHashNum(Integer hashNum) {
		this.hashNum = hashNum;
	}

	public Integer getNoNum() {
		return noNum;
	}

	public void setNoNum(Integer noNum) {
		this.noNum = noNum;
	}

	public MakeupConfirmBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MakeupConfirmBean(String apptype, String currentfile, Integer hashNum, Integer noNum, String workDate) {
		super();
		this.apptype = apptype;
		this.currentfile = currentfile;
		this.hashNum = hashNum;
		this.noNum = noNum;
		this.workDate = workDate;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

}
