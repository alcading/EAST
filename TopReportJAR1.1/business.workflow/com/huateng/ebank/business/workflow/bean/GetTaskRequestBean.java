package com.huateng.ebank.business.workflow.bean;

public class GetTaskRequestBean {
	/**操作员号*/
	private String tlrno;
	/**工作流名*/
	private String flowName;
	/**工作流版本号*/
	private String version;
	/**任务名称*/
	private String taskName;


	/**申请号*/
	private java.lang.String appno;
	/**申请类型*/
    private java.lang.String appType;
    /**机构号*/
    private java.lang.String brcode;
    /**授信号*/
    private java.lang.String contractno;
    /**页码 */
    private java.lang.Integer pageIndex;
    /**每页条数 */
    private java.lang.Integer pageSize;
    
	public java.lang.Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(java.lang.Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public java.lang.Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(java.lang.Integer pageSize) {
		this.pageSize = pageSize;
	}
	public GetTaskRequestBean(String tlrno){
		super();
		this.tlrno = tlrno;
	}
	public String getTlrno() {
		return tlrno;
	}
	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public java.lang.String getAppno() {
		return appno;
	}
	public void setAppno(java.lang.String appno) {
		this.appno = appno;
	}
	public java.lang.String getAppType() {
		return appType;
	}
	public void setAppType(java.lang.String appType) {
		this.appType = appType;
	}
	public java.lang.String getBrcode() {
		return brcode;
	}
	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}
	public java.lang.String getContractno() {
		return contractno;
	}
	public void setContractno(java.lang.String contractno) {
		this.contractno = contractno;
	}



}
