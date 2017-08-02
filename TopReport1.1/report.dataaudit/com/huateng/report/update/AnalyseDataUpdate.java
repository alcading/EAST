package com.huateng.report.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.AnalyProService;

/*
 * 数据分析的逻辑处理
 */
public class AnalyseDataUpdate extends BaseUpdate{

	private static final String DATASET_ID = "analyseDataEntry";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse arg2)
			throws AppException {
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

		//获得业务参数
		Object analyNo = null;
		String workDate = null;
		String busiType = null;
		String appType = null;
		if (updateResultBean.hasNext()) {
			Map busMap = updateResultBean.next();
			analyNo = busMap.get("id");
			workDate = (String) busMap.get("workDate");
			busiType = (String) busMap.get("busiType");
			appType = (String) busMap.get("appType");
		}
		AnalyProService service = AnalyProService.getInstance();

		String newAnalyNo = service.executeAnalyDetail(workDate,busiType,appType,TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU,analyNo);

		updateReturnBean.setParameter("analyNo",newAnalyNo);

		return updateReturnBean;
	}

}
