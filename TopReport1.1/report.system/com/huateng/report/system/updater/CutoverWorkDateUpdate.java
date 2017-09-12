package com.huateng.report.system.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.databak.service.ReportDataBakService;
import com.huateng.report.system.bean.CutoverWorkDateBean;
import com.huateng.report.system.operation.BiWorkDateOperation;

public class CutoverWorkDateUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {

		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("cutoverWorkDate");
			CutoverWorkDateBean cutoverWorkDateBean = null ;
			while (updateResultBean.hasNext())
			 {
				cutoverWorkDateBean = new CutoverWorkDateBean();
				Map map = updateResultBean.next();
				mapToObject(cutoverWorkDateBean,map);
			  }

			OperationContext oc = new OperationContext();
			oc.setAttribute(BiWorkDateOperation.CMD, BiWorkDateOperation.OP_UPDATE_CUTOVERWORKDATE);
			oc.setAttribute(BiWorkDateOperation.IN_CUTOVERWORKDATEBEAN, cutoverWorkDateBean);
			OPCaller.call(BiWorkDateOperation.ID, oc);

			try {
				String zipFilepath = ReportDataBakService.getInstance().createDataBakFile();
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("备份业务数据异常:"+e.getMessage());
			}


			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
