/*
 * Created on 2005-7-14
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.view.pub;

import java.util.Date;

/**
 * 已经废弃
 *
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class TlrInfoView {
	private String brcode;
	private String innerbrcode;
	private String tlrno;
	private String tlrnoName;
	private String status;
	private Date creatDate;
	private Date latelyLoginTime;
	private Date latelyLogoutTime;
	private Date effectDate;
	private Date expireDate;
	private String passwd;
	private String ip;
	// 虚拟字段，该字段用于区页面的分该记录是从数据库读出来的，还是用户在页面新增的，如果该字段不为空则是页面上用户新增的字段
	// 在查询的getter方法中给该字段赋值
	// *************** yjw add beging **********************
	private String v_id;

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getTlrno() {
		return tlrno;
	}

	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

	public String getTlrnoName() {
		return tlrnoName;
	}

	public void setTlrnoName(String tlrnoName) {
		this.tlrnoName = tlrnoName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public Date getLatelyLoginTime() {
		return latelyLoginTime;
	}

	public void setLatelyLoginTime(Date latelyLoginTime) {
		this.latelyLoginTime = latelyLoginTime;
	}

	public Date getLatelyLogoutTime() {
		return latelyLogoutTime;
	}

	public void setLatelyLogoutTime(Date latelyLogoutTime) {
		this.latelyLogoutTime = latelyLogoutTime;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getV_id() {
		return v_id;
	}

	public void setV_id(String v_id) {
		this.v_id = v_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getInnerbrcode() {
		return innerbrcode;
	}

	public void setInnerbrcode(String innerbrcode) {
		this.innerbrcode = innerbrcode;
	}

}
