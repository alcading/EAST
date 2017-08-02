package com.huateng.report.system.bean;

import com.huateng.ebank.entity.data.mng.PfSysParam;

import resource.bean.pub.Bctl;
import resource.bean.pub.RoleInfo;
import resource.bean.report.BiDayexchangerate;
import resource.bean.report.BiMonthexchangerate;
import resource.bean.report.BiNationregion;
import resource.bean.report.BiWorkdateConf;
import resource.bean.report.SysCurrency;
import resource.bean.report.SysParams;
import resource.bean.report.SysTaskInfo;



/**
 *
 * @author zjx
 * 这个是用来存储待审批的中间页面的对象的bean
 * 包含taskinfobean和相应任务类型对应的bean;
 *
 */
public class TaskListBean {


	// primary key
	
	private String id;
	private SysTaskInfo sysTaskInfo;


	//审批时显示使用,目前共有9种
	private SysParams sysParams;
	private Bctl bctl;
	private RoleInfo roleInfo;
	private TlrInfoAuditBean tlrInfo;
	private BiWorkdateConf biWorkdate;
	private SysCurrency currency;
	private BiNationregion biNationregion;
	private BiMonthexchangerate biMonthexchangerate;
	private BiDayexchangerate biDayexchangerate;
	//系统安全参数
	private PfSysParam pfSysparam;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SysTaskInfo getSysTaskInfo() {
		return sysTaskInfo;
	}
	public void setSysTaskInfo(SysTaskInfo sysTaskInfo) {
		this.sysTaskInfo = sysTaskInfo;
	}
	public SysParams getSysParams() {
		return sysParams;
	}
	public void setSysParams(SysParams sysParams) {
		this.sysParams = sysParams;
	}
	public Bctl getBctl() {
		return bctl;
	}
	public void setBctl(Bctl bctl) {
		this.bctl = bctl;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo ob) {
		this.roleInfo = ob;
	}
	public TlrInfoAuditBean getTlrInfo() {
		return tlrInfo;
	}
	public void setTlrInfo(TlrInfoAuditBean tlrInfo) {
		this.tlrInfo = tlrInfo;
	}
	public BiWorkdateConf getBiWorkdate() {
		return biWorkdate;
	}
	public void setBiWorkdate(BiWorkdateConf biWorkdate) {
		this.biWorkdate = biWorkdate;
	}
	public SysCurrency getCurrency() {
		return currency;
	}
	public void setCurrency(SysCurrency currency) {
		this.currency = currency;
	}
	public BiNationregion getBiNationregion() {
		return biNationregion;
	}
	public void setBiNationregion(BiNationregion biNationregion) {
		this.biNationregion = biNationregion;
	}
	public BiMonthexchangerate getBiMonthexchangerate() {
		return biMonthexchangerate;
	}
	public void setBiMonthexchangerate(BiMonthexchangerate biMonthexchangerate) {
		this.biMonthexchangerate = biMonthexchangerate;
	}
	public BiDayexchangerate getBiDayexchangerate() {
		return biDayexchangerate;
	}
	public void setBiDayexchangerate(BiDayexchangerate biDayexchangerate) {
		this.biDayexchangerate = biDayexchangerate;
	}
	public PfSysParam getPfSysparam() {
		return pfSysparam;
	}
	public void setPfSysparam(PfSysParam pfSysparam) {
		this.pfSysparam = pfSysparam;
	}
	
	
	




}
