package com.huateng.report.imports.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BiImportFileConfig;
import resource.dao.base.HQLDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileStatus;
import com.huateng.report.imports.common.FileImportUtil;

public class ImportFileGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		try {
			String importTime = getCommQueryServletRequest().getParameter("qimportTime");
			importTime = FileImportUtil.getWorkDate(importTime);
			PageQueryResult pageResult = getData();
			List queryResult=pageResult.getQueryResult();
			Iterator it=queryResult.iterator();
			List returnResult=new ArrayList();
			while(it.hasNext()){
				ImportFileStatus fileStatus=new ImportFileStatus();
				BiImportFileConfig fileConfig=new BiImportFileConfig();
				Object[] object = (Object[])it.next();
				fileConfig=(BiImportFileConfig)object[0];
				String name=fileConfig.getFileName();
				fileStatus.setFileName(FileImportUtil.getFileNameFull(importTime, name));
				fileStatus.setId(fileConfig.getId());
			    if(!FileImportUtil.isExist(importTime, fileStatus.getFileName())){
			    	fileStatus.setIsHave("false");
			    }else{
			    	fileStatus.setIsHave("true");
			    }
				returnResult.add(fileStatus);
				
			}
			
			
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), returnResult,
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}
	
	private PageQueryResult getData() throws CommonException {
		
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
		StringBuffer hql = new StringBuffer("select dd from BiImportFileConfig dd where 1=1");		

		//add by zhaozhiguo 回执导入 begin
		String receipt = getCommQueryServletRequest().getParameter("receipt");
		if (StringUtils.isNotBlank(receipt)) {
			hql.append(" and impType='1'");
		}
		//add by zhaozhiguo 回执导入 end
		
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		
		return hqlDAO.pageQueryByQL(queryCondition);
	
	}
}
