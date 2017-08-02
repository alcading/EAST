package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileBean;

import east.dao.BaseDao;

@SuppressWarnings("unchecked")
public class AnalyseDataManualGetter extends BaseGetter{
	@Override
	public Result call() throws AppException {
		try {
			//获取需要手工分析的表名
			Map para=this.getCommQueryServletRequest().getParameterMap();
			String tableName = (String)para.get("tblName");
			if(tableName!=null && !"".equals(tableName)){
				tableName = tableName.toUpperCase();
			}
			
			List dataList = BaseDao.queryFieldInfoTable(tableName);
			List list = new ArrayList();
			for(int i=0; i<dataList.size(); i++){
				String tblName = (String)dataList.get(i);
				ImportFileBean bean = new ImportFileBean();
				bean.setTableName(tblName);
				list.add(bean);
			}

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list, getResult());
			result.setContent(list);
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
