package com.huateng.ebank.business.common.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


public class BankNameGetter extends BaseGetter {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		String value = DataFormat.trim(getCommQueryServletRequest()
				.getParameter("value"));
		/** add by jornezhang 20091229 BMS-2385 大数据量下拉框功能优化 注释 begin */
		// 第一次打开输入框时会回调该Getter，value会传入""，而点击查询按钮会传入"%字符串%"
		// 因此可以根据字符串是否为""，来区分第一次回调和空字符串查询
		/*if (value!=null && !value.equals("") && value.trim().getBytes().length<(6+2)){
			ExceptionUtil.throwCommonException("查询条件必须输入6个以上字符","") ;
		}*/
		/** add by jornezhang 20091229 BMS-2385 大数据量下拉框功能优化 注释 end */
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();

		PageQueryCondition condition = new PageQueryCondition();
		/** add by jornezhang 20091229 BMS-2385 大数据量下拉框功能优化 begin */
		condition.setPageIndex(pageIndex);
		/** add by jornezhang 20091229 BMS-2385 大数据量下拉框功能优化 end */
		/**add by jornezhang 20091019 BMS-2101 查询速度优化 begin*/
		condition.setPageSize(pageSize);
		/**add by jornezhang 20091019 BMS-2101 查询速度优化 end*/

		StringBuffer hql = new StringBuffer();

		hql.append("select po from TblEbUnionBank po where (po.ubankNo like '"+value+"' or po.ubankName like '"+value+"')");

		condition.setQueryString(hql.toString());

		/** add by jornezhang 20091229 BMS-2385 大数据量下拉框功能优化 begin */
		PageQueryResult result = BaseDAOUtils.getHQLDAO().pageQueryByQL(condition);
		/** add by jornezhang 20091229 BMS-2385 大数据量下拉框功能优化 end */
//		int pageCount = result.getPageCount(pageSize);

		Iterator it = result.getQueryResult().iterator();

		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			list.add(obj[0]);
			/**add by jornezhang 20091019 BMS-2101 查询速度优化 begin*/
			/*if(list.size()>=1000)
				break;*/
			/**add by jornezhang 20091019 BMS-2101 查询速度优化 end*/
		}

		ResultMng.fillResultByList(getCommonQueryBean(),
				getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		/** add by jornezhang 20091229 BMS-2385 大数据量下拉框功能优化 begin */
		getResult().getPage().setTotalPage(result.getPageCount(getResult().getPage().getEveryPage()));
		/** add by jornezhang 20091229 BMS-2385 大数据量下拉框功能优化 end */
		getResult().init();
		return getResult();
	}

}
