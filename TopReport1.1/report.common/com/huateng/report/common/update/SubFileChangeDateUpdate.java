package com.huateng.report.common.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.common.bean.SubFileChangeDateBean;

public class SubFileChangeDateUpdate extends BaseUpdate {

	private final static String DATASET_ID="subfileworkdate";

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			GlobalInfo info = (GlobalInfo) request.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID(DATASET_ID);
			if (updateResultBean.hasNext()) {
				SubFileChangeDateBean bean = new SubFileChangeDateBean();
				mapToObject(bean, updateResultBean.next());
				info.setFileDate(bean.getNewFileDate());
				GlobalInfo.setCurrentInstance(info);
				updateReturnBean.setParameter("newdt", DateUtil.dateToString(DateUtil.stringToDate2(info.getFileDate())));
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
