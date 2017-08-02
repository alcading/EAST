package com.huateng.report.bean;

import java.io.Serializable;

public class DataProcess implements Serializable{
	private String RecType;//记录类型

	private String RecId;//记录主键
	private String BrNo; //机构号
	private String WorkDate;//工作日期
	private String ActionType;
	private String ActionDesc;
	private String AnalyStatu; //数据分析状态
	
	private String AnalyTlr; //分析人
	private String AnalyTm;//分析时间
	private String isAdd; //是否补录

	public String getRecType() {
		return RecType;
	}
	public void setRecType(String recType) {
		RecType = recType;
	}
	public String getRecId() {
		return RecId;
	}
	public void setRecId(String recId) {
		RecId = recId;
	}
	
	public String getAnalyStatu() {
		return AnalyStatu;
	}
	public void setAnalyStatu(String analyStatu) {
		AnalyStatu = analyStatu;
	}
	public String getBrNo() {
		return BrNo;
	}
	public void setBrNo(String brNo) {
		BrNo = brNo;
	}
	public String getWorkDate() {
		return WorkDate;
	}
	public void setWorkDate(String workDate) {
		WorkDate = workDate;
	}
	public String getActionType() {
		return ActionType;
	}
	public void setActionType(String actionType) {
		ActionType = actionType;
	}
	public String getActionDesc() {
		return ActionDesc;
	}
	public void setActionDesc(String actionDesc) {
		ActionDesc = actionDesc;
	}
	public String getAnalyTlr() {
		return AnalyTlr;
	}
	public void setAnalyTlr(String analyTlr) {
		AnalyTlr = analyTlr;
	}
	public String getAnalyTm() {
		return AnalyTm;
	}
	public void setAnalyTm(String analyTm) {
		AnalyTm = analyTm;
	}
	public String getIsAdd() {
		return isAdd;
	}
	public void setIsAdd(String isAdd) {
		this.isAdd = isAdd;
	}
}
