package com.huateng.ebank.business.management.updater;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.pub.DepartmentInfo;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.DepartmentInfoManageUpdateOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class DepartmentInfoManageUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try{
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_departmentInfoManage");

			List updateList = new ArrayList();
			List insertList = new ArrayList();
			List delList = new ArrayList();

			DepartmentInfo departmentInfo = new DepartmentInfo();

			while (updateResultBean.hasNext()){
				departmentInfo = new DepartmentInfo();
				mapToObject(departmentInfo, updateResultBean.next());
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(departmentInfo);
					break;
				case UpdateResultBean.DELETE:
					delList.add(departmentInfo);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(departmentInfo);
					break;
				default:
					break;
				}
			}
			OperationContext context = new OperationContext();
			context.setAttribute(DepartmentInfoManageUpdateOperation.INSERT_LIST, insertList);
			context.setAttribute(DepartmentInfoManageUpdateOperation.UPDATE_LIST, updateList);
			context.setAttribute(DepartmentInfoManageUpdateOperation.DEL_LIST, delList);
			OPCaller.call("Management.DepartmentInfoManageUpdateOperation",context);
			return updateReturnBean;
		}catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
