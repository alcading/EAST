package com.huateng.report.system.operation;

import resource.bean.report.RbsBranchCodeMapp;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.system.service.RbsBranchCodeMappService;

public class RbsBranchCodeMappOperation extends BaseOperation {
	
	public static final String ID = "RbsBranchCodeMappOperation";
	public static final String IN_PARAMS = "IN_PARAMS";
	public static final String CMD = "CMD";
	public static final String CMD_ADD = "CMD_ADD";
	public static final String CMD_MOD = "CMD_MOD";
	public static final String CMD_VALID = "CMD_VALID";//有效性设置
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		RbsBranchCodeMappService service = RbsBranchCodeMappService.getInstance();
		RbsBranchCodeMapp bean = (RbsBranchCodeMapp) context.getAttribute(IN_PARAMS);
		String cmd = (String) context.getAttribute(CMD);
		//是否插入到log表等未知 ，等待确认
		if(CMD_ADD.equalsIgnoreCase(cmd)) {
			//新增
			service.rbs_add(bean);
		} else if(CMD_MOD.equalsIgnoreCase(cmd)) {
			service.rbs_mod(bean);
		} else if(CMD_VALID.equalsIgnoreCase(cmd)) {
			service.rbs_valid(bean);
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
