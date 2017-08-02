package com.huateng.ebank.business.workflow.bean;


public class BankTaskInfo {
	/** memeber variable: String　contractno.  合同号*/
	public String contractno;
	/** memeber variable: String　appno. 申请号*/
	public String appno; 
	/** memeber variable: double　amount. 金额*/
	public double amount = 0;
	/** memeber variable: String　customer. 客户号*/
	public String customer; 
	/** memeber variable: String　starter. 启动任务者*/
	public String starter;

	public BankTaskInfo(String sContractno, String sAppno,
					double sAmount, String sCustomer ,String sStarter)
	{
		this.contractno = sContractno;
		this.appno = sAppno;
		this.amount = sAmount;
		this.customer = sCustomer;
		this.starter = sStarter;
	}

	public String getContractno() {
		return contractno;
	}

	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getStarter() {
		return starter;
	}

	public void setStarter(String starter) {
		this.starter = starter;
	}
  
}
