package com.huateng.report.update;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaDofoexloDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BopCfaDofoexloDsChangeInfoOperation;

public class BopCfaDofoexloDsChangeInfoUpdate extends BaseUpdate {

	private static final String DATASET_ID = "BopCfaDofoexloDsChangeInfoAdd";

	public static final String OPERATION_INSERT = "new";
	public static final String OPERATION_MODIFY = "mod";
	public static final String OPERATION_DELETE = "del";
	public static final String OPERATION_DETAIL = "detail";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			//更新对象
			BopCfaDofoexloDs bean = null;
			//Operation参数
			OperationContext context = new OperationContext();

			while (updateResultBean.hasNext()) {
				bean = new BopCfaDofoexloDs();
				Map map = updateResultBean.next();
				//属性拷贝
				mapToObject(bean, map);

				if (null != map.get("crtTm") && StringUtils.isNotEmpty(String.valueOf(map.get("crtTm")))) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
					bean.setCrtTm(sdf.parse(String.valueOf(map.get("crtTm"))));
				}

				String op = updateResultBean.getParameter("op");
				if(StringUtils.equals(op, OPERATION_INSERT)){
					context.setAttribute(BopCfaDofoexloDsChangeInfoOperation.CMD, BopCfaDofoexloDsChangeInfoOperation.CMD_INSERT);
					context.setAttribute(BopCfaDofoexloDsChangeInfoOperation.IN_PARAM, bean);
					OPCaller.call(BopCfaDofoexloDsChangeInfoOperation.ID, context);
				} else if (StringUtils.equals(op, OPERATION_MODIFY)) {
					context.setAttribute(BopCfaDofoexloDsChangeInfoOperation.CMD, BopCfaDofoexloDsChangeInfoOperation.CMD_UPDATE);
					context.setAttribute(BopCfaDofoexloDsChangeInfoOperation.IN_PARAM, bean);
					OPCaller.call(BopCfaDofoexloDsChangeInfoOperation.ID, context);
				} else if (StringUtils.equals(op, OPERATION_DELETE)) {
					context.setAttribute(BopCfaDofoexloDsChangeInfoOperation.CMD, BopCfaDofoexloDsChangeInfoOperation.CMD_DELETE);
					context.setAttribute(BopCfaDofoexloDsChangeInfoOperation.IN_PARAM, bean);
					OPCaller.call(BopCfaDofoexloDsChangeInfoOperation.ID, context);
				}
				return updateReturnBean;
			}
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}

		return null;
	}

}
