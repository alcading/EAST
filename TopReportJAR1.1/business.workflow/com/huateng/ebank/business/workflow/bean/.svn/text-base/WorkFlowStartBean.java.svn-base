/**
 *
 */
package com.huateng.ebank.business.workflow.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: WorkFlowStartBean
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-3-31
 */
public class WorkFlowStartBean extends BaseWorkFlowTaskAssignBean{


	/** memeber variable: String　flowName. */
	private String flowName;
	/** memeber variable: String　version. */
	private String version;
	/** memeber variable: Map　attribute. */
	private Map attribute;
	/** memeber variable: String　key. */
	private String key;
	/** memeber variable: String　status. */
	private String status;

	/**
	 * 启动工作流对象构造方法
	 * @param tlrnoList 待选操作员列表
	 * @param brcode 机构号
	 * @param flowName 启动流程名
	 * @param version 启动流程版本号(允许为空,默认是最近的流程)
	 * @param attribute 启动流程参数集合
	 * @param key 流程主键(允许为空)
	 * @param status 启动流程操作(允许为NULL,为默认操作)
	 * @param workType 工作类型(01-贷前 02-贷后)
	 * @param assignMode 工作分配模式(0-分配到岗位，1-分配到人(按工作两分配),2-完全随机分配)
	 * @param isWorkTyp 是否根据工作类型统分析
	 * @param isLv 是否有请假制度
	 * 2008-3-31
	 */
	public WorkFlowStartBean(List tlrnoList, String brcode,String flowName,
			String version, Map attribute, String key,String status,
			String workType, String assignMode, boolean isWorkType, boolean isLv) {
		super(tlrnoList,brcode,workType,assignMode,isWorkType,isLv);
		this.flowName = flowName;
		this.version = version;
		this.attribute = attribute;
		this.key = key;
		this.status = status;
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
	public Map getAttribute() {
		return attribute;
	}
	public void setAttribute(Map attribute) {
		this.attribute = attribute;
	}
	public void setAttribute(String contractno,String appno,double amount, String custcd ,String starter,
			String bizSubclass, String bizClass, String startBrcode, String mgrno, String lastTlrno, String appType) {
		Map attribute = new HashMap();
		attribute.put("CONTRACTNO", contractno==null?"":contractno);
		attribute.put("APPNO", appno==null?"":appno);
		attribute.put("AMOUNT", new Double(amount));
		attribute.put("CUSTCD", custcd==null?"":custcd);
		attribute.put("STARTER", starter==null?"":starter);
		attribute.put("BIZSUBCLASS", bizSubclass==null?"":bizSubclass);
		attribute.put("BIZCLASS", bizClass==null?"":bizClass);
		attribute.put("STARTBRCODE", startBrcode==null?"":startBrcode);
		attribute.put("MGRNO", mgrno==null?"":mgrno);
		attribute.put("LASTTLRNO", lastTlrno==null?"":lastTlrno);
		attribute.put("APPTYPE", appType==null?"":appType);
		this.attribute = attribute;
	}

	public void setAttribute(String contractno,String appno,double amount, String custcd ,String starter,
			String bizSubclass, String bizClass, String startBrcode, String mgrno, String lastTlrno, String appType, String systype) {
		Map attribute = new HashMap();
		attribute.put("CONTRACTNO", contractno==null?"":contractno);
		attribute.put("APPNO", appno==null?"":appno);
		attribute.put("AMOUNT", new Double(amount));
		attribute.put("CUSTCD", custcd==null?"":custcd);
		attribute.put("STARTER", starter==null?"":starter);
		attribute.put("BIZSUBCLASS", bizSubclass==null?"":bizSubclass);
		attribute.put("BIZCLASS", bizClass==null?"":bizClass);
		attribute.put("STARTBRCODE", startBrcode==null?"":startBrcode);
		attribute.put("MGRNO", mgrno==null?"":mgrno);
		attribute.put("LASTTLRNO", lastTlrno==null?"":lastTlrno);
		attribute.put("APPTYPE", appType==null?"":appType);
		attribute.put("SYSTYPE", systype==null?"":systype);
		this.attribute = attribute;
	}

	/**
	 * @param contractno 合同号
	 * @param appno 申请书号
	 * @param amount 贷款金额
	 * @param custcd 客户id
	 * @param starter 客户号
	 * @param bizSubclass 贷款细类
	 * @param bizClass 大类
	 * @param startBrcode 发起机构号
	 * @param mgrno 客户经理号
	 * @param lastTlrno
	 * @param appType 贷款类型
	 * @param lastTask 最后任务id？
	 * @param sysType 模块类型
	 */
	public void setAttribute(String contractno,String appno,double amount, String custcd ,String starter,
			String bizSubclass, String bizClass, String startBrcode, String mgrno, String lastTlrno, String appType, String lastTask, String sysType) {
		Map attribute = new HashMap();
		attribute.put("CONTRACTNO", contractno==null?"":contractno);
		attribute.put("APPNO", appno==null?"":appno);
		attribute.put("AMOUNT", new Double(amount));
		attribute.put("CUSTCD", custcd==null?"":custcd);
		attribute.put("STARTER", starter==null?"":starter);
		attribute.put("BIZSUBCLASS", bizSubclass==null?"":bizSubclass);
		attribute.put("BIZCLASS", bizClass==null?"":bizClass);
		attribute.put("STARTBRCODE", startBrcode==null?"":startBrcode);
		attribute.put("MGRNO", mgrno==null?"":mgrno);
		attribute.put("LASTTLRNO", lastTlrno==null?"":lastTlrno);
		attribute.put("APPTYPE", appType==null?"":appType);
		attribute.put("LASTTASK", lastTask==null?"":lastTask);
		//模块类型:个贷申请、企业贷款申请、合作项目申请等
		attribute.put("SYSTYPE", sysType==null?"":sysType);
		this.attribute = attribute;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
