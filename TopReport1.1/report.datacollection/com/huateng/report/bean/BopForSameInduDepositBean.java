package com.huateng.report.bean;

public class BopForSameInduDepositBean {

	// fields
	private java.lang.String apptype;// 应用类型
	private java.lang.String currentfile;// 文件类型
	private java.lang.String exdebtcode; // 外债编号
	private java.lang.String limitType;// 账户类型
	private java.lang.String debtorcode; // 债务人代码
	private java.lang.String debtype; // 债务类型
	private java.lang.String valuedate; // 起息日
	private java.lang.String contractcurr; // 签约币种
	private java.lang.String floatrate; // 是否浮动利率
	private java.math.BigDecimal anninrate; // 年化利率值
	private java.lang.String spapfeboindex; // 是否经外汇局特批不需占用指标
	private java.lang.String remark; // 备注
	private java.lang.String brNo; //机构号
	

	// 系统信息
	private java.lang.String workDate;// 工作日期

	private java.lang.String inprterm; // 是否有利息本金化条款
	private java.util.Date lstUpdTm;// 最后更新时间
	private java.util.Date crtTm;// 创建时间
	private java.lang.String lstUpdTlr;// 最后更新人
	private java.lang.String subSuccess;// 是否成功上报
	private java.lang.String recStatus;// 记录状态
	private java.lang.String repStatus;// 回执状态
	private java.lang.String approveStatus;// 审核状态
	private java.lang.String approveResult;// 审核说明
	private java.lang.String actiondesc;// 删除原因
	private java.lang.String actiontype;// 操作类型

	// 余额信息
	private java.lang.String filler1;
	
	//业务流水号
	private java.lang.String  filler2;
	//签约信息业务流水号
	private java.lang.String filler2Oth;
	


	private java.lang.String buscode; // 银行账号
	private java.lang.String changeno;// 变动编号
	private java.math.BigDecimal accoamount;// 外债余额

	private java.lang.String chdate;// 变动日期

	// 债权信息
	private java.lang.String creditorid;

	private java.lang.String creditorcode; // 债权人代码
	private java.lang.String creditorname;// 债权人中文名称
	private java.lang.String creditornamen;// 债权人英文名称
	private java.math.BigDecimal creditorca;// 债权人签约金额
	private java.lang.String creditortype;// 债权人类型代码
	private java.lang.String crehqcode;// 债权人总部所在国家（地区）代码
	private java.lang.String opercode;// 债权人经营地所在国家（地区）代码
	private java.lang.String recId;

	// private java.lang.String isincode;//

	// private java.lang.String contractdate;//签约日期
	// private java.math.BigDecimal contractamount; //签约金额
	// private java.lang.String maturity; //到期日

	// private java.lang.String filler1;

	// private java.lang.String brNo;

	// private java.lang.String buscode;

	// private java.lang.String inltcabuscode;
	// private java.lang.String appcode;
	// private java.lang.String appname;
	//
	// private java.lang.String creditorid;

	// fields

	// private java.lang.String changeno;
	// private java.lang.String changtype;
	// private java.lang.String chdate;
	// private java.lang.String chcurrency;
	// private java.math.BigDecimal chamount;
	// private java.math.BigDecimal fairvalue;

	// private java.lang.String projectname;//项目名称
	// private java.lang.String projid;//项目外键ID

	/**
	 * @return the recId
	 */
	public java.lang.String getRecId() {
		return recId;
	}

	/**
	 * @param recId
	 *            the recId to set
	 */
	public void setRecId(java.lang.String recId) {
		this.recId = recId;
	}

	public java.lang.String getFiller2Oth() {
		return filler2Oth;
	}

	public void setFiller2Oth(java.lang.String filler2Oth) {
		this.filler2Oth = filler2Oth;
	}
	
	/**
	 * @return the creditorid
	 */
	public java.lang.String getCreditorid() {
		return creditorid;
	}

	/**
	 * @param creditorid
	 *            the creditorid to set
	 */
	public void setCreditorid(java.lang.String creditorid) {
		this.creditorid = creditorid;
	}

	private java.lang.String id;

	/**
	 * @return the id
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * @return the apptype
	 */
	public java.lang.String getApptype() {
		return apptype;
	}

	/**
	 * @param apptype
	 *            the apptype to set
	 */
	public void setApptype(java.lang.String apptype) {
		this.apptype = apptype;
	}

	/**
	 * @return the currentfile
	 */
	public java.lang.String getCurrentfile() {
		return currentfile;
	}

	/**
	 * @param currentfile
	 *            the currentfile to set
	 */
	public void setCurrentfile(java.lang.String currentfile) {
		this.currentfile = currentfile;
	}

	/**
	 * @return the exdebtcode
	 */
	public java.lang.String getExdebtcode() {
		return exdebtcode;
	}

	/**
	 * @param exdebtcode
	 *            the exdebtcode to set
	 */
	public void setExdebtcode(java.lang.String exdebtcode) {
		this.exdebtcode = exdebtcode;
	}

	/**
	 * @return the limitType
	 */
	public java.lang.String getLimitType() {
		return limitType;
	}

	/**
	 * @param limitType
	 *            the limitType to set
	 */
	public void setLimitType(java.lang.String limitType) {
		this.limitType = limitType;
	}

	/**
	 * @return the debtorcode
	 */
	public java.lang.String getDebtorcode() {
		return debtorcode;
	}

	public java.lang.String getFiller1() {
		return filler1;
	}

	public void setFiller1(java.lang.String filler1) {
		this.filler1 = filler1;
	}

	public java.lang.String getFiller2() {
		return filler2;
	}

	public void setFiller2(java.lang.String filler2) {
		this.filler2 = filler2;
	}

	/**
	 * @param debtorcode
	 *            the debtorcode to set
	 */
	public void setDebtorcode(java.lang.String debtorcode) {
		this.debtorcode = debtorcode;
	}

	/**
	 * @return the debtype
	 */
	public java.lang.String getDebtype() {
		return debtype;
	}

	/**
	 * @param debtype
	 *            the debtype to set
	 */
	public void setDebtype(java.lang.String debtype) {
		this.debtype = debtype;
	}

	/**
	 * @return the valuedate
	 */
	public java.lang.String getValuedate() {
		return valuedate;
	}

	/**
	 * @param valuedate
	 *            the valuedate to set
	 */
	public void setValuedate(java.lang.String valuedate) {
		this.valuedate = valuedate;
	}

	/**
	 * @return the contractcurr
	 */
	public java.lang.String getContractcurr() {
		return contractcurr;
	}

	/**
	 * @param contractcurr
	 *            the contractcurr to set
	 */
	public void setContractcurr(java.lang.String contractcurr) {
		this.contractcurr = contractcurr;
	}

	/**
	 * @return the floatrate
	 */
	public java.lang.String getFloatrate() {
		return floatrate;
	}

	/**
	 * @param floatrate
	 *            the floatrate to set
	 */
	public void setFloatrate(java.lang.String floatrate) {
		this.floatrate = floatrate;
	}

	/**
	 * @return the anninrate
	 */
	public java.math.BigDecimal getAnninrate() {
		return anninrate;
	}

	/**
	 * @param anninrate
	 *            the anninrate to set
	 */
	public void setAnninrate(java.math.BigDecimal anninrate) {
		this.anninrate = anninrate;
	}

	/**
	 * @return the spapfeboindex
	 */
	public java.lang.String getSpapfeboindex() {
		return spapfeboindex;
	}

	/**
	 * @param spapfeboindex
	 *            the spapfeboindex to set
	 */
	public void setSpapfeboindex(java.lang.String spapfeboindex) {
		this.spapfeboindex = spapfeboindex;
	}

	/**
	 * @return the remark
	 */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * @return the workDate
	 */
	public java.lang.String getWorkDate() {
		return workDate;
	}

	public java.lang.String getBrNo() {
		return brNo;
	}

	public void setBrNo(java.lang.String brNo) {
		this.brNo = brNo;
	}	
	
	/**
	 * @param workDate
	 *            the workDate to set
	 */
	public void setWorkDate(java.lang.String workDate) {
		this.workDate = workDate;
	}

	/**
	 * @return the inprterm
	 */
	public java.lang.String getInprterm() {
		return inprterm;
	}

	/**
	 * @param inprterm
	 *            the inprterm to set
	 */
	public void setInprterm(java.lang.String inprterm) {
		this.inprterm = inprterm;
	}

	/**
	 * @return the lstUpdTm
	 */
	public java.util.Date getLstUpdTm() {
		return lstUpdTm;
	}

	/**
	 * @param lstUpdTm
	 *            the lstUpdTm to set
	 */
	public void setLstUpdTm(java.util.Date lstUpdTm) {
		this.lstUpdTm = lstUpdTm;
	}

	/**
	 * @return the crtTm
	 */
	public java.util.Date getCrtTm() {
		return crtTm;
	}

	/**
	 * @param crtTm
	 *            the crtTm to set
	 */
	public void setCrtTm(java.util.Date crtTm) {
		this.crtTm = crtTm;
	}

	/**
	 * @return the lstUpdTlr
	 */
	public java.lang.String getLstUpdTlr() {
		return lstUpdTlr;
	}

	/**
	 * @param lstUpdTlr
	 *            the lstUpdTlr to set
	 */
	public void setLstUpdTlr(java.lang.String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}

	/**
	 * @return the subSuccess
	 */
	public java.lang.String getSubSuccess() {
		return subSuccess;
	}

	/**
	 * @param subSuccess
	 *            the subSuccess to set
	 */
	public void setSubSuccess(java.lang.String subSuccess) {
		this.subSuccess = subSuccess;
	}

	/**
	 * @return the recStatus
	 */
	public java.lang.String getRecStatus() {
		return recStatus;
	}

	/**
	 * @param recStatus
	 *            the recStatus to set
	 */
	public void setRecStatus(java.lang.String recStatus) {
		this.recStatus = recStatus;
	}

	/**
	 * @return the repStatus
	 */
	public java.lang.String getRepStatus() {
		return repStatus;
	}

	/**
	 * @param repStatus
	 *            the repStatus to set
	 */
	public void setRepStatus(java.lang.String repStatus) {
		this.repStatus = repStatus;
	}

	/**
	 * @return the approveStatus
	 */
	public java.lang.String getApproveStatus() {
		return approveStatus;
	}

	/**
	 * @param approveStatus
	 *            the approveStatus to set
	 */
	public void setApproveStatus(java.lang.String approveStatus) {
		this.approveStatus = approveStatus;
	}

	/**
	 * @return the approveResult
	 */
	public java.lang.String getApproveResult() {
		return approveResult;
	}

	/**
	 * @param approveResult
	 *            the approveResult to set
	 */
	public void setApproveResult(java.lang.String approveResult) {
		this.approveResult = approveResult;
	}

	/**
	 * @return the actiondesc
	 */
	public java.lang.String getActiondesc() {
		return actiondesc;
	}

	/**
	 * @param actiondesc
	 *            the actiondesc to set
	 */
	public void setActiondesc(java.lang.String actiondesc) {
		this.actiondesc = actiondesc;
	}

	/**
	 * @return the actiontype
	 */
	public java.lang.String getActiontype() {
		return actiontype;
	}

	/**
	 * @param actiontype
	 *            the actiontype to set
	 */
	public void setActiontype(java.lang.String actiontype) {
		this.actiontype = actiontype;
	}

	/**
	 * @return the creditorcode
	 */
	public java.lang.String getCreditorcode() {
		return creditorcode;
	}

	/**
	 * @param creditorcode
	 *            the creditorcode to set
	 */
	public void setCreditorcode(java.lang.String creditorcode) {
		this.creditorcode = creditorcode;
	}

	/**
	 * @return the creditorname
	 */
	public java.lang.String getCreditorname() {
		return creditorname;
	}

	/**
	 * @param creditorname
	 *            the creditorname to set
	 */
	public void setCreditorname(java.lang.String creditorname) {
		this.creditorname = creditorname;
	}

	/**
	 * @return the creditornamen
	 */
	public java.lang.String getCreditornamen() {
		return creditornamen;
	}

	/**
	 * @param creditornamen
	 *            the creditornamen to set
	 */
	public void setCreditornamen(java.lang.String creditornamen) {
		this.creditornamen = creditornamen;
	}

	/**
	 * @return the creditorca
	 */
	public java.math.BigDecimal getCreditorca() {
		return creditorca;
	}

	/**
	 * @param creditorca
	 *            the creditorca to set
	 */
	public void setCreditorca(java.math.BigDecimal creditorca) {
		this.creditorca = creditorca;
	}

	/**
	 * @return the creditortype
	 */
	public java.lang.String getCreditortype() {
		return creditortype;
	}

	/**
	 * @param creditortype
	 *            the creditortype to set
	 */
	public void setCreditortype(java.lang.String creditortype) {
		this.creditortype = creditortype;
	}

	/**
	 * @return the crehqcode
	 */
	public java.lang.String getCrehqcode() {
		return crehqcode;
	}

	/**
	 * @param crehqcode
	 *            the crehqcode to set
	 */
	public void setCrehqcode(java.lang.String crehqcode) {
		this.crehqcode = crehqcode;
	}

	/**
	 * @return the opercode
	 */
	public java.lang.String getOpercode() {
		return opercode;
	}

	/**
	 * @param opercode
	 *            the opercode to set
	 */
	public void setOpercode(java.lang.String opercode) {
		this.opercode = opercode;
	}

	public java.lang.String getBuscode() {
		return buscode;
	}

	public void setBuscode(java.lang.String buscode) {
		this.buscode = buscode;
	}

	public java.lang.String getChangeno() {
		return changeno;
	}

	public void setChangeno(java.lang.String changeno) {
		this.changeno = changeno;
	}


	public java.lang.String getChdate() {
		return chdate;
	}

	public void setChdate(java.lang.String chdate) {
		this.chdate = chdate;
	}
	public java.math.BigDecimal getAccoamount() {
		return accoamount;
	}

	public void setAccoamount(java.math.BigDecimal accoamount) {
		this.accoamount = accoamount;
	}

}
