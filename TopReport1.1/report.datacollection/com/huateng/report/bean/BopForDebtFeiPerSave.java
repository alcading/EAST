package com.huateng.report.bean;



/**
 * 
 *外债信息表、债权人信息表bean
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 * 
 * */

public class BopForDebtFeiPerSave {
	
	private java.lang.String id;
	// fields
	private java.lang.String apptype;//应用类型
	private java.lang.String currentfile;//文件类型
	private java.lang.String exdebtcode; //外债编号
	private java.lang.String debtorcode; //债务人代码
	private java.lang.String debtype; //债务类型
	private java.lang.String debtyperema;
	private java.lang.String contractdate;//签约日期
	private java.lang.String valuedate; //起息日
	private java.lang.String contractcurr; //签约币种
	private java.math.BigDecimal contractamount; //签约金额
	private java.lang.String maturity;   //到期日
	private java.lang.String floatrate; //是否浮动利率
	private java.math.BigDecimal anninrate; //年化利率值
	private java.lang.String inprterm; //是否有利息本金化条款
	private java.lang.String spapfeboindex; //是否经外汇局特批不需占用指标
	private java.lang.String limitType;
	private java.lang.String remark; //备注
	private java.lang.String isincode;// 
	
	private java.lang.String lstUpdTlr;
	private java.util.Date lstUpdTm;
	private java.util.Date crtTm;
	private java.lang.String filler1;
	
	private java.lang.String brNo;
	private java.lang.String actiontype;
	private java.lang.String actiondesc;
	private java.lang.String recStatus;
	private java.lang.String repStatus;
	private java.lang.String approveStatus;
	private java.lang.String approveResult;
	private java.lang.String workDate;
	private java.lang.String subSuccess;
	private java.lang.String buscode;
	
	private java.lang.String inltcabuscode;
	private java.lang.String appcode;
	private java.lang.String appname;
	
	private java.lang.String creditorid;

	private java.lang.String recId;
	// fields
	private java.lang.String creditorcode; //债权人代码
	private java.lang.String creditorname;//债权人中文名称
	private java.lang.String creditornamen;//债权人英文名称
	private java.math.BigDecimal creditorca;//债权人签约金额
	private java.lang.String creditortype;//债权人类型代码
	private java.lang.String crehqcode;//债权人总部所在国家（地区）代码
	private java.lang.String opercode;//债权人经营地所在国家（地区）代码
	
	private java.lang.String changeno;
	private java.lang.String changtype;
	private java.lang.String chdate;
	private java.lang.String chcurrency;
	private java.math.BigDecimal chamount;
	private java.math.BigDecimal fairvalue;
	private java.math.BigDecimal accoamount;

	private String filler2;
	
	public java.lang.String getLimitType() {
		return limitType;
	}

	public void setLimitType(java.lang.String limitType) {
		this.limitType = limitType;
	}

	public java.lang.String getIsincode() {
		return isincode;
	}

	public void setIsincode(java.lang.String isincode) {
		this.isincode = isincode;
	}

	public java.lang.String getInltcabuscode() {
		return inltcabuscode;
	}

	public void setInltcabuscode(java.lang.String inltcabuscode) {
		this.inltcabuscode = inltcabuscode;
	}

	public java.lang.String getAppcode() {
		return appcode;
	}

	public void setAppcode(java.lang.String appcode) {
		this.appcode = appcode;
	}

	public java.lang.String getAppname() {
		return appname;
	}

	public void setAppname(java.lang.String appname) {
		this.appname = appname;
	}

	public java.lang.String getChangeno() {
		return changeno;
	}

	public void setChangeno(java.lang.String changeno) {
		this.changeno = changeno;
	}

	public java.lang.String getChangtype() {
		return changtype;
	}

	public void setChangtype(java.lang.String changtype) {
		this.changtype = changtype;
	}

	public java.lang.String getChdate() {
		return chdate;
	}

	public void setChdate(java.lang.String chdate) {
		this.chdate = chdate;
	}

	public java.lang.String getChcurrency() {
		return chcurrency;
	}

	public void setChcurrency(java.lang.String chcurrency) {
		this.chcurrency = chcurrency;
	}

	public java.math.BigDecimal getAccoamount() {
		return accoamount;
	}

	public void setAccoamount(java.math.BigDecimal accoamount) {
		this.accoamount = accoamount;
	}

	public java.math.BigDecimal getChamount() {
		return chamount;
	}

	public void setChamount(java.math.BigDecimal chamount) {
		this.chamount = chamount;
	}

	public java.math.BigDecimal getFairvalue() {
		return fairvalue;
	}

	public void setFairvalue(java.math.BigDecimal fairvalue) {
		this.fairvalue = fairvalue;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getApptype() {
		return apptype;
	}

	public void setApptype(java.lang.String apptype) {
		this.apptype = apptype;
	}

	public java.lang.String getCurrentfile() {
		return currentfile;
	}

	public void setCurrentfile(java.lang.String currentfile) {
		this.currentfile = currentfile;
	}

	public java.lang.String getExdebtcode() {
		return exdebtcode;
	}

	public void setExdebtcode(java.lang.String exdebtcode) {
		this.exdebtcode = exdebtcode;
	}

	public java.lang.String getDebtorcode() {
		return debtorcode;
	}

	public void setDebtorcode(java.lang.String debtorcode) {
		this.debtorcode = debtorcode;
	}

	public java.lang.String getDebtype() {
		return debtype;
	}

	public void setDebtype(java.lang.String debtype) {
		this.debtype = debtype;
	}

	public java.lang.String getDebtyperema() {
		return debtyperema;
	}

	public void setDebtyperema(java.lang.String debtyperema) {
		this.debtyperema = debtyperema;
	}

	public java.lang.String getContractdate() {
		return contractdate;
	}

	public void setContractdate(java.lang.String contractdate) {
		this.contractdate = contractdate;
	}

	public java.lang.String getValuedate() {
		return valuedate;
	}

	public void setValuedate(java.lang.String valuedate) {
		this.valuedate = valuedate;
	}

	public java.lang.String getContractcurr() {
		return contractcurr;
	}

	public void setContractcurr(java.lang.String contractcurr) {
		this.contractcurr = contractcurr;
	}

	public java.math.BigDecimal getContractamount() {
		return contractamount;
	}

	public void setContractamount(java.math.BigDecimal contractamount) {
		this.contractamount = contractamount;
	}

	public java.lang.String getMaturity() {
		return maturity;
	}

	public void setMaturity(java.lang.String maturity) {
		this.maturity = maturity;
	}

	public java.lang.String getFloatrate() {
		return floatrate;
	}

	public void setFloatrate(java.lang.String floatrate) {
		this.floatrate = floatrate;
	}

	public java.math.BigDecimal getAnninrate() {
		return anninrate;
	}

	public void setAnninrate(java.math.BigDecimal anninrate) {
		this.anninrate = anninrate;
	}

	public java.lang.String getInprterm() {
		return inprterm;
	}

	public void setInprterm(java.lang.String inprterm) {
		this.inprterm = inprterm;
	}

	public java.lang.String getSpapfeboindex() {
		return spapfeboindex;
	}

	public void setSpapfeboindex(java.lang.String spapfeboindex) {
		this.spapfeboindex = spapfeboindex;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getLstUpdTlr() {
		return lstUpdTlr;
	}

	public void setLstUpdTlr(java.lang.String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}

	public java.util.Date getLstUpdTm() {
		return lstUpdTm;
	}

	public void setLstUpdTm(java.util.Date lstUpdTm) {
		this.lstUpdTm = lstUpdTm;
	}

	public java.util.Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(java.util.Date crtTm) {
		this.crtTm = crtTm;
	}

	public java.lang.String getFiller1() {
		return filler1;
	}

	public void setFiller1(java.lang.String filler1) {
		this.filler1 = filler1;
	}

	public java.lang.String getBrNo() {
		return brNo;
	}

	public void setBrNo(java.lang.String brNo) {
		this.brNo = brNo;
	}

	public java.lang.String getActiontype() {
		return actiontype;
	}

	public void setActiontype(java.lang.String actiontype) {
		this.actiontype = actiontype;
	}

	public java.lang.String getActiondesc() {
		return actiondesc;
	}

	public void setActiondesc(java.lang.String actiondesc) {
		this.actiondesc = actiondesc;
	}

	public java.lang.String getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(java.lang.String recStatus) {
		this.recStatus = recStatus;
	}

	public java.lang.String getRepStatus() {
		return repStatus;
	}

	public void setRepStatus(java.lang.String repStatus) {
		this.repStatus = repStatus;
	}

	public java.lang.String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(java.lang.String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public java.lang.String getApproveResult() {
		return approveResult;
	}

	public void setApproveResult(java.lang.String approveResult) {
		this.approveResult = approveResult;
	}

	public java.lang.String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(java.lang.String workDate) {
		this.workDate = workDate;
	}

	public java.lang.String getSubSuccess() {
		return subSuccess;
	}

	public void setSubSuccess(java.lang.String subSuccess) {
		this.subSuccess = subSuccess;
	}

	public java.lang.String getCreditorid() {
		return creditorid;
	}

	public void setCreditorid(java.lang.String creditorid) {
		this.creditorid = creditorid;
	}

	public java.lang.String getCreditorcode() {
		return creditorcode;
	}

	public void setCreditorcode(java.lang.String creditorcode) {
		this.creditorcode = creditorcode;
	}

	public java.lang.String getCreditorname() {
		return creditorname;
	}

	public void setCreditorname(java.lang.String creditorname) {
		this.creditorname = creditorname;
	}

	public java.lang.String getCreditornamen() {
		return creditornamen;
	}

	public void setCreditornamen(java.lang.String creditornamen) {
		this.creditornamen = creditornamen;
	}

	public java.math.BigDecimal getCreditorca() {
		return creditorca;
	}

	public void setCreditorca(java.math.BigDecimal creditorca) {
		this.creditorca = creditorca;
	}

	public java.lang.String getCreditortype() {
		return creditortype;
	}

	public void setCreditortype(java.lang.String creditortype) {
		this.creditortype = creditortype;
	}

	public java.lang.String getCrehqcode() {
		return crehqcode;
	}

	public void setCrehqcode(java.lang.String crehqcode) {
		this.crehqcode = crehqcode;
	}

	public java.lang.String getOpercode() {
		return opercode;
	}

	public void setOpercode(java.lang.String opercode) {
		this.opercode = opercode;
	}

	public java.lang.String getRecId() {
		return recId;
	}

	public void setRecId(java.lang.String recId) {
		this.recId = recId;
	}

	public java.lang.String getBuscode() {
		return buscode;
	}

	public void setBuscode(java.lang.String buscode) {
		this.buscode = buscode;
	}

	public String getFiller2() {
		return filler2;
	}

	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}

}
