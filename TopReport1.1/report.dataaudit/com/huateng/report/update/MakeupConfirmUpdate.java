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
import com.huateng.report.operation.MakeupConfirmOperation;
import com.huateng.report.utils.ReportUtils;

public class MakeupConfirmUpdate extends BaseUpdate {

	private static final String DATASET_ID = "MakeupConfirm";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest arg1,
			HttpServletResponse arg2) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			int noNumTotal = 0;
			int hashNumTotal = 0;
			String busiType = null;
			String workDate = null;
			String apptype = null;
			OperationContext context = new OperationContext();
			while (updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				int hashNum = Integer.parseInt(map.get("hashNum").toString());
				int noNum = Integer.parseInt(map.get("noNum").toString());
				noNumTotal+=noNum;
				hashNumTotal+=hashNum;

				busiType = (String) map.get("busiType");
				workDate = (String) map.get("workDate");
				apptype = (String) map.get("apptype");
			}
			if (hashNumTotal==0) {
				ExceptionUtil.throwCommonException("没有需要确认的数据！");
			}

			String parValue = ReportUtils.getSysParamsValue("100", "0002");
			if (parValue.equals("0") && noNumTotal>0) {
				ExceptionUtil.throwCommonException("补录尚未完成，不能进行完成确认操作！");
			}
			context.setAttribute(MakeupConfirmOperation.BUSI_TYPE, busiType);
			context.setAttribute(MakeupConfirmOperation.WORK_DATE, workDate);
			context.setAttribute(MakeupConfirmOperation.APP_TYPE, apptype);
			OPCaller.call(MakeupConfirmOperation.ID, context);
			return updateReturnBean;
		} catch (CommonException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
