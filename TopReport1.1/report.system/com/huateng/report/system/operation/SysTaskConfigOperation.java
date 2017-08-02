package com.huateng.report.system.operation;

import java.util.List;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.system.service.SysTaskConfigService;
//jianxue.zhang
public class SysTaskConfigOperation extends BaseOperation{
public static final String INSERT_LIST="insert";
public static final String UPDATE_LIST="update";
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List insertList = (List) context.getAttribute(INSERT_LIST);
        List updateList = (List) context.getAttribute(UPDATE_LIST);
        //List delList = (List) context.getAttribute(DEL_LIST);
       // BctlService bctlService = BctlService.getInstance();
        //bctlService.bctlInfo(insertList, updateList, delList);
       SysTaskConfigService.getInstance().saveOrUpdate(insertList,updateList);

		
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
