package com.huateng.report.update;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExplbalainfo;
import resource.bean.report.BopCfaExplrmbloDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BopCfaExplrmbloDsChangeInfoOperation;

public class BopCfaExplrmbloDsChangeInfoUpdate extends BaseUpdate{

	private static final String DATASET_ID = "BopCfaExplrmbloDsChangeInfoAdd";

	private static final String EXPLCURRINFO_ID = "BopCfaExplcurrinfo";


	public static final String OPERATION_INSERT = "new";
	public static final String OPERATION_MODIFY = "mod";
	public static final String OPERATION_DELETE = "del";
	public static final String OPERATION_DETAIL = "detail";


	@SuppressWarnings("unchecked")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			//更新对象
			BopCfaExplrmbloDs bean = null;
			while (updateResultBean.hasNext()) {
				bean = new BopCfaExplrmbloDs();
				Map map = updateResultBean.next();
				//属性拷贝
				mapToObject(bean, map);

				if (null != map.get("crtTm") && StringUtils.isNotEmpty(String.valueOf(map.get("crtTm")))) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
					bean.setCrtTm(sdf.parse(String.valueOf(map.get("crtTm"))));
				}
			}

			UpdateResultBean explcurrinfoResult = multiUpdateResultBean.getUpdateResultBeanByID(EXPLCURRINFO_ID);
			List<BopCfaExplbalainfo>saveList = new ArrayList<BopCfaExplbalainfo>();
			List<BopCfaExplbalainfo>updateList = new ArrayList<BopCfaExplbalainfo>();
			List<BopCfaExplbalainfo>deleteList = new ArrayList<BopCfaExplbalainfo>();
			BopCfaExplbalainfo explbalainfo = null;
			while (explcurrinfoResult.hasNext()) {
				explbalainfo = new BopCfaExplbalainfo();
				//属性拷贝
				mapToObject(explbalainfo, explcurrinfoResult.next());
				switch (explcurrinfoResult.getRecodeState()) {
				case UpdateResultBean.INSERT:
					saveList.add(explbalainfo);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(explbalainfo);
					break;
				case UpdateResultBean.DELETE:
					deleteList.add(explbalainfo);
					break;
				default:
					break;
				}
			}

			//Operation参数
			OperationContext context = new OperationContext();
			String op = updateResultBean.getParameter("op");
			if(StringUtils.equals(op, OPERATION_INSERT)){
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.CMD, BopCfaExplrmbloDsChangeInfoOperation.CMD_INSERT);
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM, bean);

				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM_NEW_LIST, saveList);
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM_MOD_LIST, updateList);
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM_DEL_LIST, deleteList);
				OPCaller.call(BopCfaExplrmbloDsChangeInfoOperation.ID, context);
			} else if (StringUtils.equals(op, OPERATION_MODIFY)) {
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.CMD, BopCfaExplrmbloDsChangeInfoOperation.CMD_UPDATE);
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM, bean);

				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM_NEW_LIST, saveList);
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM_MOD_LIST, updateList);
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM_DEL_LIST, deleteList);

				OPCaller.call(BopCfaExplrmbloDsChangeInfoOperation.ID, context);
			} else if (StringUtils.equals(op, OPERATION_DELETE)) {
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.CMD, BopCfaExplrmbloDsChangeInfoOperation.CMD_DELETE);
				context.setAttribute(BopCfaExplrmbloDsChangeInfoOperation.IN_PARAM, bean);
				OPCaller.call(BopCfaExplrmbloDsChangeInfoOperation.ID, context);
			}

			return updateReturnBean;

		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}
	}
}