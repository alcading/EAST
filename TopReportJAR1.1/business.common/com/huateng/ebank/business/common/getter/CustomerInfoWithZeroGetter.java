package com.huateng.ebank.business.common.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author fubo
 * @company huateng
 * @date 2010-4-22 下午03:12:15
 * @desc 获取发起方列表（增加0为不限）
 */
public class CustomerInfoWithZeroGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List list = new ArrayList();
		String value = DataFormat.trim(getCommQueryServletRequest()
				.getParameter("value"));
		if (StringUtils.isEmpty(value)) {
			value = "";
		}
		// int pageSize = this.getResult().getPage().getEveryPage();
		// int pageIndex = this.getResult().getPage().getCurrentPage();
		PageQueryCondition condition = new PageQueryCondition();
		condition.setPageIndex(1);
		condition.setPageSize(9999);

		StringBuffer hql = new StringBuffer(
				"select po from TblEbCustomerInfo po where 1=1");
		hql.append(" and ( po.custNo like '" + value
				+ "' or po.custName like '" + value
				+ "' ) and po.validFlag = '" + SystemConstant.VALID_FLAG_VALID + "'");

		condition.setQueryString(hql.toString());

		PageQueryResult result = BaseDAOUtils.getHQLDAO().pageQueryByQL(condition);

		Iterator it = result.getQueryResult().iterator();

		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			list.add(obj[0]);
		}

		ResultMng.fillResultByList(getCommonQueryBean(),
				getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

}
