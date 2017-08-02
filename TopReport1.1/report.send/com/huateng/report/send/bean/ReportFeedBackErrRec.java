package com.huateng.report.send.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportFeedBackErrRec {
	private String bussno;
	/**用于读取BOP的错误反馈*/
	private String rptno;

	private List<ReportFeedBackErrField> errFields = new ArrayList<ReportFeedBackErrField>();

	public String getBussno() {
		return bussno;
	}

	public void setBussno(String bussno) {
		this.bussno = bussno;
	}

	public List<ReportFeedBackErrField> getErrFields() {
		return errFields;
	}

	public void setErrFields(List<ReportFeedBackErrField> errFields) {
		this.errFields = errFields;
	}

	public String getRptno() {
		return rptno;
	}

	public void setRptno(String rptno) {
		this.rptno = rptno;
	}

}
