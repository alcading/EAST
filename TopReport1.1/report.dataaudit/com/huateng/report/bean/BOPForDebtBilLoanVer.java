package com.huateng.report.bean;

import java.math.BigDecimal;

public class BOPForDebtBilLoanVer {

	private String id;


	private String  actionType; // ACTIONTYPE	操作类型	字符型，1	必填项，
	//A－新建
	//C－修改
	//D－删除，一旦银行报送了该外债编号下的变动信息，就不可以删除了。

	private String actionDesc; // ACTIONDESC	删除原因	字符型，128	如果ACTIONTYPE字段值为D，则此字段为必填字段。
	private String exdebtCode;// EXDEBTCODE	外债编号	字符型，28	必填项外债唯一性编码。

	private String debtorCode;//DEBTORCODE	债务人代码	字符型，12	必填项，金融机构标识码。
	private String debType; //DEBTYPE	债务类型	字符型，4	必填项，见债务类型代码表。
	private String contracDate;// CONTRACTDATE	签约日期	日期型，8	必填项，格式YYYYMMDD，小于等于当前日期。
	private String valueDate; //VALUEDATE	起息日	日期型，8	必填项，格式YYYYMMDD，大于等于签约日期。
	private String contrActcurr; //CONTRACTCURR	签约币种	字符型，3	必填项，见币种代码表。
	private String contrActamount;// CONTRACTAMOUNT	签约金额	数值型，22.2	必填项，大于等于0。
	private String maturity;//MATURITY	到期日	日期型，8	必填项，格式YYYYMMDD，大于等于起息日。
	private String floatrate;//FLOATRATE	是否浮动利率	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
	private BigDecimal anninrate; //ANNINRATE	年化利率值	数值型，13.8	必填项，大于等于0，按小数填写，如利率为3.21%，则填写0.0321。
	private String creditorCode;// CREDITORCODE	债权人代码	字符型，11	非必填项。
	private String creditorName;// CREDITORNAME	债权人中文名称	字符型，128	非必填项。债权人中文名称和债权人英文名称至少填写一个。
	private String creditorNamEn;// CREDITORNAMEN	债权人英文名称	字符型，128	非必填项。债权人中文名称和债权人英文名称至少填写一个。
	private String creditorType;// CREDITORTYPE	债权人类型代码	字符型，8	必填项，见境外主体类型代码表。
	private String crehqCode;//CREHQCODE	债权人总部所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
	private String operCode;// OPERCODE	债权人经营地所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
	private String inprterm;//INPRTERM	是否有利息本金化条款	字符型，1	必填项，是-Y，否-N，默认为否，填写N 。
	private String spapfeboIndex;// SPAPFEBOINDEX	是否经外汇局特批不需占用指标	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
	private String projectName;// PROJECTNAME	项目名称	字符型，128	必填项。
	private String Remark;//REMARK	备注	字符型，256	非必填项。
	private String createDate; //工作日期（数据导入日期）
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
	public String getDebtorCode() {
		return debtorCode;
	}
	public void setDebtorCode(String debtorCode) {
		this.debtorCode = debtorCode;
	}
	public String getDebType() {
		return debType;
	}
	public void setDebType(String debType) {
		this.debType = debType;
	}
	public String getContracDate() {
		return contracDate;
	}
	public void setContracDate(String contracDate) {
		this.contracDate = contracDate;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public String getContrActcurr() {
		return contrActcurr;
	}
	public void setContrActcurr(String contrActcurr) {
		this.contrActcurr = contrActcurr;
	}
	public String getContrActamount() {
		return contrActamount;
	}
	public void setContrActamount(String contrActamount) {
		this.contrActamount = contrActamount;
	}
	public String getMaturity() {
		return maturity;
	}
	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}
	public String getFloatrate() {
		return floatrate;
	}
	public void setFloatrate(String floatrate) {
		this.floatrate = floatrate;
	}
	public BigDecimal getAnninrate() {
		return anninrate;
	}
	public void setAnninrate(BigDecimal anninrate) {
		this.anninrate = anninrate;
	}
	public String getCreditorCode() {
		return creditorCode;
	}
	public void setCreditorCode(String creditorCode) {
		this.creditorCode = creditorCode;
	}
	public String getCreditorName() {
		return creditorName;
	}
	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}
	public String getCreditorNamEn() {
		return creditorNamEn;
	}
	public void setCreditorNamEn(String creditorNamEn) {
		this.creditorNamEn = creditorNamEn;
	}
	public String getCreditorType() {
		return creditorType;
	}
	public void setCreditorType(String creditorType) {
		this.creditorType = creditorType;
	}
	public String getCrehqCode() {
		return crehqCode;
	}
	public void setCrehqCode(String crehqCode) {
		this.crehqCode = crehqCode;
	}
	public String getOperCode() {
		return operCode;
	}
	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}
	public String getInprterm() {
		return inprterm;
	}
	public void setInprterm(String inprterm) {
		this.inprterm = inprterm;
	}
	public String getSpapfeboIndex() {
		return spapfeboIndex;
	}
	public void setSpapfeboIndex(String spapfeboIndex) {
		this.spapfeboIndex = spapfeboIndex;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
