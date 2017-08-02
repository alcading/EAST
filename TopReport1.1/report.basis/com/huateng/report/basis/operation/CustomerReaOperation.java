package com.huateng.report.basis.operation;


import resource.bean.report.BiCustomer;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.basis.service.CustomerReaService;

public class CustomerReaOperation  extends BaseOperation{

	public static final String ID = "CustomerReaOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		BiCustomer biCustomer = (BiCustomer) context.getAttribute(IN_PARAM);
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		CustomerReaService customerReaService = CustomerReaService.getInstance();
		if (CMD_QUERY.equals(cmd)) {
			
		} else if (CMD_INSERT.equals(cmd)) {
			customerReaService.savaBiCustomer(biCustomer);
		} else if (CMD_UPDATE.equals(cmd)) {
			customerReaService.UpdateBiCustomer(biCustomer);
		} else if (CMD_DELETE.equals(cmd)) {
			customerReaService.delete(biCustomer);
		}
	}

	@Override	
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}
	
		
}
