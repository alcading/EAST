package com.huateng.report.getter;


import java.util.Map;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


@SuppressWarnings("unchecked")
public class BopExguTorDsInfoBenGetter extends BaseGetter {
	/*
	 * 对外担保信息
	 * @author huangcheng
	 */
	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(),
			pageResult.getQueryResult(),getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
			}catch(AppException appEx){
			throw appEx;
			}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
			Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
			}
			}

			private PageQueryResult getData() {
		
				int pageSize = this.getResult().getPage().getEveryPage();
				int pageIndex = this.getResult().getPage().getCurrentPage();
				Map paramMap = this.getCommQueryServletRequest().getParameterMap();
				ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
				String hql;
		        PageQueryResult pageQueryResult = null;
				PageQueryCondition queryCondition = new PageQueryCondition();
				String recId = (String) paramMap.get("id");
                hql = "from BopExguTorDs  where 1=1 and torType = '01' and recId ='"+recId+"'  ";
                
				      try {
					      queryCondition.setQueryString(hql);
					      queryCondition.setPageIndex(pageIndex);
					      queryCondition.setPageSize(pageSize);
					      pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
				         } catch (CommonException e) {
					     // TODO Auto-generated catch block
				             e.printStackTrace();
				         }
				    
				
				 return pageQueryResult;
			}
			}



