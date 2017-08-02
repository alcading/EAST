package com.huateng.ebank.business.management.operation;

import java.util.List;

import com.huateng.ebank.business.common.service.DepartmentInfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class DepartmentInfoManageUpdateOperation extends BaseOperation {

	public static final String INSERT_LIST = "INSERT_LIST";
	public static final String UPDATE_LIST = "UPDATE_LIST";
	public static final String DEL_LIST = "DEL_LIST";

	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	public void execute(OperationContext context) throws CommonException {
		List insertList = (List) context.getAttribute(INSERT_LIST);
        List updateList = (List) context.getAttribute(UPDATE_LIST);
        List delList = (List) context.getAttribute(DEL_LIST);
        DepartmentInfoService departmentInfoService = DepartmentInfoService.getInstance();
        departmentInfoService.departmentInfo(insertList, updateList, delList);
	}

}
