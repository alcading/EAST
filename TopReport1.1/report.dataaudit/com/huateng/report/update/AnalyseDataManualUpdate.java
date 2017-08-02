package com.huateng.report.update;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileBean;
import com.huateng.report.imports.updater.ImportFileUpdate;

import east.creatfile.CreatFile;
import east.dao.BaseDao;

public class AnalyseDataManualUpdate extends BaseUpdate {

	private static Logger logger = Logger.getLogger(ImportFileUpdate.class
			.getName());

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("analyseDataManual");
			String whereString = " table_name in(";
			while (updateResultBean.hasNext()) {
				Map<String, String> map = updateResultBean.next();
				ImportFileBean bean = new ImportFileBean();
				mapToObject(bean, map);
				if(bean.isSelect()) {
					whereString += "'" + bean.getTableName() + "',";
				}
			}
			whereString = whereString.substring(0, whereString.length()-1) + ")";
			Map<String, List<String>> tableInfoMap;
			try {
				tableInfoMap = BaseDao.queryFieldInfo2(whereString);
				CreatFile.creatManualJgbsFile(tableInfoMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return updateReturnBean;
	}
	
}
