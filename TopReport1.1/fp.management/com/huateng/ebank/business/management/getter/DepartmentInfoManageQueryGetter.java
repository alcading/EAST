package com.huateng.ebank.business.management.getter;

import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.service.DepartmentInfoService;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class DepartmentInfoManageQueryGetter extends BaseGetter {

	public Result call() throws AppException {
		try{
			/** 获取查询条件*/
			Map param = this.getCommQueryServletRequest().getParameterMap();

			/** 获取everyPage：每页包含的记录数 */
			int everypage = Integer.parseInt(param.get("everyPage").toString());

			/** 获取nextPage：表示下一页是第几页 */
			int nextpage = Integer.parseInt(param.get("nextPage").toString());

			/** 获取所有查询结果 */
			List list = DepartmentInfoService.getInstance().getAllEnableDepartment();

			if (list.size()==0) {
				ExceptionUtil.throwCommonException("没有找到符合条件的记录",ErrorCode.ERROR_CODE_RECORD_NOTFOUND);
			}
			int maxIndex = nextpage * everypage;

			/** 对最后一页的处理 */
			if (maxIndex > list.size()) {
				maxIndex = list.size();
			}
			List resultList = list.subList((nextpage - 1) * everypage, maxIndex);
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultList, getResult());

			result.setContent(resultList);

			result.getPage().setTotalPage((list.size() - 1) / everypage + 1);
			result.init();

			return result;

		}catch(AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
