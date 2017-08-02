package com.huateng.report.operation;

import resource.bean.report.BiAnalyConf;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.service.BiAnalyConfService;

public class BiAnalyConfOperation extends BaseOperation {
	
	public final static String ID = "biAnalyConfOperation";
	public final static String CMD = "CMD";
	public final static String CMD_CHANGE_STATUS = "CMD_CHANGE_STATUS";
	public final static String IN_PARAM = "IN_PARAM";
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		BiAnalyConf biAnalyConf = (BiAnalyConf) context.getAttribute(IN_PARAM);
		BiAnalyConfService service = BiAnalyConfService.getInstance();
		//更改有效无效设置
		if(CMD_CHANGE_STATUS.equals(cmd)) {
			service.updateBiAnalyConfByConfVaild(biAnalyConf);
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
