package com.huateng.report.system.updater;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.SysTaskConfig;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.system.operation.SysTaskConfigOperation;
//jianxue.zhang
public class SysTaskConfigUpdater extends BaseUpdate {

	
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("ApproveConfig");
			
			List updateList = new ArrayList();
			List insertList = new ArrayList();
			//List delList = new ArrayList();
			
			SysTaskConfig bean = new SysTaskConfig();
			while (updateResultBean.hasNext()) {
				mapToObject(bean, updateResultBean.next());
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(bean);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(bean);
					break;
				default:
					break;
				}
			}
			OperationContext context = new OperationContext();
			context.setAttribute(SysTaskConfigOperation.INSERT_LIST, insertList);
			context.setAttribute(SysTaskConfigOperation.UPDATE_LIST, updateList);
			//context.setAttribute(BranchManageUpdateOperation.DEL_LIST, delList);
			OPCaller.call("SysTaskConfigOperation", context);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
