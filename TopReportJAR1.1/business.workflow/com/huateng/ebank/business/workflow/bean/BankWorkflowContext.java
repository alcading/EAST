/**
 *
 */
package com.huateng.ebank.business.workflow.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.huateng.business.workflow.rule.WorkflowContext;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: BankWorkflowContext
 * Description: 个贷业务工作流内容
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-4
 */
public class BankWorkflowContext extends WorkflowContext {

	/** memeber variable: long　serialVersionUID. */
	private static final long serialVersionUID = -4429068147811460914L;

	public void setBankTaskInfo(BankTaskInfo bankTaskInfo)throws CommonException{
		try{
			if( super.getParamMap() == null ){
				Map paramMap = new HashMap();
				paramMap = BeanUtils.describe(bankTaskInfo);
				super.setParamMap(paramMap);
			}else{
				Map paramMap = super.getParamMap();
				Map map = BeanUtils.describe(bankTaskInfo);
				paramMap.putAll(map);
			}
		}catch(Exception ex){
			ExceptionUtil.throwCommonException("setBankTaskInfo失败",ErrorCode.ERROR_CODE_WORKFLOWRULE_DYN_FLOWNAME_EMPTY);
		}
	}

	public void setBankTaskInfo(String contractno,String appno,double amount, String customer ,String starter){
		if( super.getParamMap() == null ){
			Map paramMap = new HashMap();
			paramMap.put("contractno", contractno==null?"":contractno);
			paramMap.put("appno", appno==null?"":appno);
			paramMap.put("amount", new Double(amount));
			paramMap.put("customer", customer==null?"":appno);
			paramMap.put("starter", starter==null?"":starter);
			super.setParamMap(paramMap);
		}else{
			Map paramMap = super.getParamMap();
			paramMap.put("contractno", contractno==null?"":contractno);
			paramMap.put("appno", appno==null?"":appno);
			paramMap.put("amount", new Double(amount));
			paramMap.put("customer", customer==null?"":appno);
			paramMap.put("starter", starter==null?"":starter);
		}
	}
	//Added by UU_Wu	2008-4-23	加入了贷款种类，bizClass(0-全部，1-贷款，2-合作项目)上传人机构，客户经理，上个操作员以及申请类型
	public void setBankTaskInfo(String contractno,String appno,double amount, String customer ,String starter,
			String bizSubclass, String bizClass, String startBrcode, String mgrno, String lastTlrno, String appType){
		if( super.getParamMap() == null ){
			Map paramMap = new HashMap();
			paramMap.put("contractno", contractno==null?"":contractno);
			paramMap.put("appno", appno==null?"":appno);
			paramMap.put("amount", new Double(amount));
			paramMap.put("customer", customer==null?"":customer);
			paramMap.put("starter", starter==null?"":starter);
			paramMap.put("bizSubclass", bizSubclass==null?"":bizSubclass);
			paramMap.put("bizClass", bizClass==null?"":bizClass);
			paramMap.put("startBrcode", startBrcode==null?"":startBrcode);
			paramMap.put("mgrno", mgrno==null?"":mgrno);
			paramMap.put("lastTlrno", lastTlrno==null?"":lastTlrno);
			paramMap.put("appType", appType==null?"":appType);
			super.setParamMap(paramMap);
		}else{
			Map paramMap = super.getParamMap();
			paramMap.put("contractno", contractno==null?"":contractno);
			paramMap.put("appno", appno==null?"":appno);
			paramMap.put("amount", new Double(amount));
			paramMap.put("customer", customer==null?"":customer);
			paramMap.put("starter", starter==null?"":starter);
			paramMap.put("bizSubclass", bizSubclass==null?"":bizSubclass);
			paramMap.put("bizClass", bizClass==null?"":bizClass);
			paramMap.put("startBrcode", startBrcode==null?"":startBrcode);
			paramMap.put("mgrno", mgrno==null?"":mgrno);
			paramMap.put("lastTlrno", lastTlrno==null?"":lastTlrno);
			paramMap.put("appType", appType==null?"":appType);
		}
	}
	public BankWorkflowContext() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 个贷业务工作流参数内容构造方法
	 * @param bankTaskInfo
	 * @throws CommonException
	 * 2008-4-4
	 */
	public BankWorkflowContext(BankTaskInfo bankTaskInfo)throws CommonException{
		super();
		this.setBankTaskInfo(bankTaskInfo);
	}

}
