package com.huateng.ebank.entity.data.mng;

import java.util.Date;

public class PasswordHis implements java.io.Serializable {
	
	private String id;
	private String userid;
	private String password;
	private String encMode;
	private Date modifiedTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncMode() {
		return encMode;
	}

	public void setEncMode(String encMode) {
		this.encMode = encMode;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
