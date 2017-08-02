package com.huateng.report.imports.bean;

import java.util.Date;

public class ReportFeedBackBean {
	private String busiType;
	private String appType;
	private String packName;
	private String isHashFeedBack;// 是否已导入回执
	private Date feedBackDate;// 上报时间
	private String feedBackMsg;// 回执信息
	private int fileCount;// 上报文件数
	private String isSub;//是否已上报
	private Date crtDate;//生成时间
	private String subType;//上报方式
	private String workDate;//工作日期

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getIsSub() {
		return isSub;
	}

	public void setIsSub(String isSub) {
		this.isSub = isSub;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getIsHashFeedBack() {
		return isHashFeedBack;
	}

	public void setIsHashFeedBack(String isHashFeedBack) {
		this.isHashFeedBack = isHashFeedBack;
	}

	public Date getFeedBackDate() {
		return feedBackDate;
	}

	public void setFeedBackDate(Date feedBackDate) {
		this.feedBackDate = feedBackDate;
	}

	public String getFeedBackMsg() {
		return feedBackMsg;
	}

	public void setFeedBackMsg(String feedBackMsg) {
		this.feedBackMsg = feedBackMsg;
	}

	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	public ReportFeedBackBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportFeedBackBean(String busiType, String appType, String packName, String isHashFeedBack,
			Date feedBackDate, String feedBackMsg, int fileCount) {
		super();
		this.busiType = busiType;
		this.appType = appType;
		this.packName = packName;
		this.isHashFeedBack = isHashFeedBack;
		this.feedBackDate = feedBackDate;
		this.feedBackMsg = feedBackMsg;
		this.fileCount = fileCount;
	}

}
