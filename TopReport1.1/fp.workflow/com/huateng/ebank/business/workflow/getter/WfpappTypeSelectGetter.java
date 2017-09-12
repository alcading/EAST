/**
 *
 */
package com.huateng.ebank.business.workflow.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.workflow.bean.WorkFlowConfig;
import com.huateng.ebank.business.workflow.bean.WorkFlowParamSelectBean;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 */
public class WfpappTypeSelectGetter extends BaseGetter {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub

		try {

			List resultlist = new ArrayList();

			String selectappTypeValue = this.getCommQueryServletRequest()
					.getParameter("selectTemplate");


			if (!StringUtils.isEmpty(selectappTypeValue)) {
				String selectappTypeValueAT = selectappTypeValue+"_APP_TYPE";
//				将工作流模板名 与 申请类型进行匹配

				List appTypeValueAT = new ArrayList();
				appTypeValueAT = DataFormat.stringToList(WorkFlowConfig.getValue(selectappTypeValueAT));
				Object obj[]=appTypeValueAT.toArray();
				for (int i = 0; i < obj.length; i++) {
						WorkFlowParamSelectBean wfpSelectBean = new WorkFlowParamSelectBean();
                        String value[]=obj[i].toString().split("-");
						wfpSelectBean.setAppType(value[0]);
						wfpSelectBean.setAppTypeName(obj[i].toString());
						resultlist.add(wfpSelectBean);
				}
			}

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultlist, getResult());
			result.setContent(resultlist);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}


}
