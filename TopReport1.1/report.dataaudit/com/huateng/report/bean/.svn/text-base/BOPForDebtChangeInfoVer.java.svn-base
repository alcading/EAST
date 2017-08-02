package com.huateng.report.bean;

import java.math.BigDecimal;

public class BOPForDebtChangeInfoVer {

	private String id;

	private String actionType; // ACTIONTYPE	操作类型	字符型，1	必填项，
	//A－新建
	//C－修改
	//D－删除
	private String actionDesc;// ACTIONDESC	删除原因	字符型，128	如果ACTIONTYPE字段值为D，则此字段为必填字段。
	private String exdebtCode;//EXDEBTCODE	外债编号	字符型，28	必填项，外债唯一性编码。
	private String busCode;// BUSCODE	银行业务参号	字符型，32	必填项，指该笔变动业务在银行的业务参号。
	private String changeNo;// CHANGENO	变动编号	字符型，4	必填项。
	private String changType;// CHANGTYPE	变动类型	字符型，4	必填项，见外债变动类型代码表。
	private String ChDate;//CHDATE	变动日期	日期型，8	必填项，格式YYYYMMDD。
	private String chCurrency ;//CHCURRENCY	变动币种	字符型，3	必填项，见币种代码表。
	private BigDecimal ChAmount;//CHAMOUNT	变动金额	数值型，22.2	必填项，大于等于0。
	private BigDecimal fairValue;// FAIRVALUE 价值	数值型，22.2	选填项。对于银行发行的货币市场工具，应每月末报送该笔债券和票据、货币市场工具的最后一个交易日公允价值市值，月末报送。
	private String remark;//REMARK	备注	字符型，256	非必填项。



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionDesc() {
		return actionDesc;
	}
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	public String getExdebtCode() {
		return exdebtCode;
	}
	public void setExdebtCode(String exdebtCode) {
		this.exdebtCode = exdebtCode;
	}
	public String getBusCode() {
		return busCode;
	}
	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}
	public String getChangeNo() {
		return changeNo;
	}
	public void setChangeNo(String changeNo) {
		this.changeNo = changeNo;
	}
	public String getChangType() {
		return changType;
	}
	public void setChangType(String changType) {
		this.changType = changType;
	}
	public String getChDate() {
		return ChDate;
	}
	public void setChDate(String chDate) {
		ChDate = chDate;
	}
	public String getChCurrency() {
		return chCurrency;
	}
	public void setChCurrency(String chCurrency) {
		this.chCurrency = chCurrency;
	}
	public BigDecimal getChAmount() {
		return ChAmount;
	}
	public void setChAmount(BigDecimal chAmount) {
		ChAmount = chAmount;
	}
	public BigDecimal getFairValue() {
		return fairValue;
	}
	public void setFairValue(BigDecimal fairValue) {
		this.fairValue = fairValue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
