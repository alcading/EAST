package com.huateng.report.update;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.AuditConfirmOperation;
import com.huateng.report.utils.ReportUtils;
public class AuditConfirmUpdate extends BaseUpdate {

	private static final String DATASET_ID = "AuditConfirm";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest arg1, HttpServletResponse arg2)
	        throws AppException {
		try {

			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			int noApproveTotal = 0;
			int hashApproveTotal = 0;
			String busiType = null;
			String workDate = null;
			String appType = null;
			OperationContext context = new OperationContext();
			while (updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				int noApprove = Integer.parseInt(map.get("noApprove").toString());
				int approvePass = Integer.parseInt(map.get("approvePass").toString());
				int approveUnPass = Integer.parseInt(map.get("approveUnPass").toString());
				noApproveTotal+=noApprove;
				hashApproveTotal+=approvePass;
				hashApproveTotal+=approveUnPass;
				busiType = (String) map.get("busiType");
				workDate = (String) map.get("workDate");
				appType = (String) map.get("apptype");
			}
			if (hashApproveTotal==0) {
				ExceptionUtil.throwCommonException("没有需要审核确认的数据！");
			}

			String parValue = ReportUtils.getSysParamsValue("100", "0003");
			if (parValue.equals("0") && noApproveTotal>0) {
				ExceptionUtil.throwCommonException("审核尚未完成，不能进行审核完成确认操作！");
			}
			context.setAttribute(AuditConfirmOperation.BUSI_TYPE, busiType);
			context.setAttribute(AuditConfirmOperation.WORK_DATE, workDate);
			context.setAttribute(AuditConfirmOperation.APP_TYPE, appType);
			OPCaller.call(AuditConfirmOperation.ID, context);
			return updateReturnBean;
		} catch (CommonException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}




}
