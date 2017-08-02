package com.huateng.report.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * Get the dropdown's data from DB with HQL and full the dataset to dropdown
 * @author cwenao
 * 2012-8-13
 */


public class NativeCodeSelectGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryCondition queryCondition = new PageQueryCondition();
			Page page = result.getPage();
			String value=getCommQueryServletRequest().getParameter("value1");
			if(value!=null&&!value.equals("")){
				queryCondition.setQueryString(" from BiNationregion  bn where bn.id like '"+value+"' order by bn.id");
			}else{
				queryCondition.setQueryString(" from BiNationregion bn where  1=1  order by bn.id");
			}
			queryCondition.setPageSize(page.getEveryPage());
			queryCondition.setPageIndex(page.getCurrentPage());
			PageQueryResult pageResult = DAOUtils.getHQLDAO().pageQueryByQL(queryCondition);
			
			/*BiNationregion biNa = new BiNationregion();
			biNa.setId("ABW");
			biNa.setNationregionNumber("533");
			biNa.setNationregionName("阿鲁巴");
			
			BiNationregion biNa1 = new BiNationregion();
			biNa.setId("ARE");
			biNa.setNationregionNumber("784");
			biNa.setNationregionName("阿拉伯联合酋长国");
			
			BiNationregion biNa2 = new BiNationregion();
			biNa.setId("HKG");
			biNa.setNationregionNumber("344");
			biNa.setNationregionName("中国香港特别行政区");
			
			
			List<BiNationregion> list = new ArrayList<BiNationregion>();
			
			list.add(biNa);
			list.add(biNa1);
			list.add(biNa2);
			*/
			
			
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
			result.setContent(pageResult.getQueryResult());
			
			if (pageResult.getQueryResult().size() == 0) {
				result.getPage().setTotalPage(0);
			} else {
				result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			}
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
