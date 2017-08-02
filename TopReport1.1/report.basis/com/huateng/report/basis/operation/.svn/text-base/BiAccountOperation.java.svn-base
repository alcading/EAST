package com.huateng.report.basis.operation;

import resource.bean.report.BiAccount;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.basis.service.BiAccountService;

public class BiAccountOperation extends BaseOperation {

	public static final String ID = "BiAccountOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {

		String cmd = (String)context.getAttribute(CMD);
		BiAccount biAccount  = (BiAccount) context.getAttribute(IN_PARAM);

		BiAccountService biAccService = BiAccountService.getInstance();

		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{
			biAccService.save(biAccount);
		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			biAccService.update(biAccount);
		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			biAccService.delete(biAccount.getId());
		}
	}

}
