/*
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2003-2004 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

/*
*peijizong 20090310 添加行号
*/
package com.huateng.ebank.business.common;

import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import com.huateng.ebank.framework.operation.BaseVoObject;

/**
 * 用户的Session信息类；
 *
 * @author James Wu, Henry Huang
 * @version 1.0.0
 */

public class UserSessionInfo extends BaseVoObject {

	private Date txDate;
	private String tlrNo = "" ; //柜员号
	private String tlrName = "" ; //柜员名称
	private String brCode = "" ; //机构号
	private String brNo="";//外部机构号
	private String organCode = "" ; //企业组织机构号
	private String custNo = "" ; //企业客户号
	private int custId = 0; //企业信息id
	private int branchId = 0 ; //机构号
	private String roleName= ""; //用户角色信息
	private int roleid = 0; //用户角色信息
	private Hashtable userFunctions=null;//用户权限
	private Hashtable allFunctions=null;//用户权限
	private Vector userRoles=null;
	private String lastLoginTime = "" ;//最近登陆时间
	private String lastLogoutTime = "" ;//最近退出时间
	private String ip = "" ;//IP
	private String brName = ""; //机构名称
	private String acctBrhName = "";//入账机构名
	private int acctBranchId = 0 ; //入账机构ID
	private String bankNo = "";
	private String custName = "";
	private String custAdress = "";
	private int userid;
	    String userName="";

    private String upBrCode = ""; //上级机构号
    private Vector workflowRoles; //工作流角色信息

    private String lastLoginFailTime = "";

    public String getLastLoginFailTime() {
		return lastLoginFailTime;
	}
	public void setLastLoginFailTime(String lastLoginFailTime) {
		this.lastLoginFailTime = lastLoginFailTime;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public UserSessionInfo() {
		userRoles = new Vector();
		workflowRoles = new Vector();
		userFunctions = new Hashtable();
	}
	public Vector getWorkflowRoles() {
		return workflowRoles;
	}

	public void setWorkflowRoles(Vector workflowRoles) {
		this.workflowRoles = workflowRoles;
	}
	public void addWorkflowRolesItem(Object obj) {
		workflowRoles.add(obj);
	}

	public void removeWorkflowRolesItem(Object obj) {
		workflowRoles.remove(obj);
	}

	public void clearWorkflowRolesItems() {
		workflowRoles.clear();
	}

	public boolean isExistWorkflowRolesItems(Object obj) {
		return workflowRoles.contains(obj);
	}
	public String getUpBrCode() {
			return upBrCode;
		}

		public void setUpBrCode(String upBrCode) {
			this.upBrCode = upBrCode;
		}

	public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}


	public Hashtable getUserFunctions() {
		return userFunctions;
	}

	public void setUserFunctions(Hashtable hashtable) {
		userFunctions = hashtable;
	}

	public void addUserFunctionsItem(Object obj) {
		userFunctions.put(obj,obj);
	}

	public void removeUserFunctionsItem(Object obj) {
		userFunctions.remove(obj);
	}

	public void clearFunctionsItems() {
		userFunctions.clear() ;
	}

	public boolean isExistUserFunctionsItems(Object obj) {
		Object lobj = userFunctions.get(obj);
		return null!=lobj ;
	}

	public Vector getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Vector vector) {
		userRoles = vector;
	}

	public void addUserRolesItem(Object obj) {
		userRoles.add(obj);
	}

	public void removeUserRolesItem(Object obj) {
		userRoles.remove(obj);
	}

	public void clearUserRolesItems() {
		userRoles.clear();
	}

	public boolean isExistUserRolesItems(Object obj) {
		return userRoles.contains(obj);
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}



	public String getBrCode() {
		return brCode;
	}

	public String getTlrName() {
		return tlrName;
	}

	public String getTlrNo() {
		return tlrNo;
	}

	public void setBrCode(String string) {
		brCode = string;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public void setTlrName(String string) {
		tlrName = string;
	}

	public void setTlrNo(String string) {
		tlrNo = string;
	}


	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("UserSessionInfo[tlrNo=");
		sb.append(this.tlrNo);
		sb.append(", tlrName=");
		sb.append(this.tlrName);
		sb.append(", brCode=");
		sb.append(this.brCode);
		sb.append(", organCode=");
		sb.append(this.organCode);
		sb.append(", custId=");
		sb.append(this.custId);
		sb.append(", roleName=");
		sb.append(this.roleName);
		sb.append(", roleid=");
		sb.append(this.roleid);
		sb.append(", userid=");
		sb.append(this.userid);
		sb.append(", ip=");
		sb.append(this.ip);
		sb.append(", userName=");
		sb.append(this.userName);
		sb.append(", brName=");
		sb.append(this.brName);
		sb.append(", lastLoginTime=");
		sb.append(this.lastLoginTime);
		sb.append(", lastLogoutTime=");
		sb.append(this.lastLogoutTime);
		sb.append("]");
		return sb.toString();
	}


	/**
	 * @return
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @return
	 */
	public String getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @return
	 */
	public String getLastLogoutTime() {
		return lastLogoutTime;
	}

	/**
	 * @param string
	 */
	public void setIp(String string) {
		ip = string;
	}

	/**
	 * @param string
	 */
	public void setLastLoginTime(String string) {
		lastLoginTime = string;
	}

	/**
	 * @param string
	 */
	public void setLastLogoutTime(String string) {
		lastLogoutTime = string;
	}

	/**
	 * @return
	 */
	public String getBrName() {
		return brName;
	}



	public void setBrName(String brName) {
		this.brName = brName;
	}

	public Hashtable getAllFunctions() {
		return allFunctions;
	}

	public void setAllFunctions(Hashtable allFunctions) {
		this.allFunctions = allFunctions;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getAcctBrhName() {
		return acctBrhName;
	}

	public void setAcctBrhName(String acctBrhName) {
		this.acctBrhName = acctBrhName;
	}

	public int getAcctBranchId() {
		return acctBranchId;
	}

	public void setAcctBranchId(int acctBranchId) {
		this.acctBranchId = acctBranchId;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the custAdress
	 */
	public String getCustAdress() {
		return custAdress;
	}

	/**
	 * @param custAdress the custAdress to set
	 */
	public void setCustAdress(String custAdress) {
		this.custAdress = custAdress;
	}



	/**
	 * @param string
	 */


}
