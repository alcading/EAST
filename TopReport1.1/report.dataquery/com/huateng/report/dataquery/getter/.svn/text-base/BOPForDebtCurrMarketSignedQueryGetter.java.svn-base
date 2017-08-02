package com.huateng.report.dataquery.getter;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
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
import com.huateng.report.constants.TopReportConstants;

/**
 * 
 * 外债信息表Getter
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 * 
 * */

@SuppressWarnings("unchecked")
public class BOPForDebtCurrMarketSignedQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {

		try {
			
			PageQueryResult queryResult = getData();
		
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage())); 
			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	private PageQueryResult getData() throws CommonException
		{

		   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		   //
		   int pageSize = getResult().getPage().getEveryPage();
		   //页码
		   int pageIndex = getResult().getPage().getCurrentPage();

		   PageQueryCondition queryCondition = new PageQueryCondition();

		   StringBuffer hql = new StringBuffer(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");
		   Map map = getCommQueryServletRequest().getParameterMap();
		   String qbrNo = (String) map.get("qbrNo");
		   String qworkDate = (String)map.get("qworkDate");
		   String eworkDate = (String)map.get("eworkDate");
		   String qactiontype = (String) map.get("qactiontype");
		   String qrecStatus = (String) map.get("qrecStatus");
		   String qapproveStatus = (String) map.get("qapproveStatus");
		   String qrepStatus = (String) map.get("qrepStatus");
		   String qfiller2 = (String) map.get("qfiller2");
		   
		   List<Object>paramentList = new ArrayList<Object>();
		   if(StringUtils.isNotBlank(qbrNo))
		   {
			   hql.append(" AND bds.brNo = ? ");
			   paramentList.add(qbrNo);
		   }
		   if(StringUtils.isNotBlank(qworkDate))
		   {
			   hql.append(" AND bds.workDate >= ? ");
			   paramentList.add(qworkDate);
		   }
		   if(StringUtils.isNotBlank(eworkDate))
		   {
			   hql.append(" AND bds.workDate <= ? ");
			   paramentList.add(eworkDate);
		   }
		   if(StringUtils.isNotBlank(qactiontype))
		   {
			   hql.append(" AND bds.actiontype = ? ");
			   paramentList.add(qactiontype);
		   }
		   if(StringUtils.isNotBlank(qrecStatus))
		   {
			   hql.append(" AND bds.recStatus = ? ");
			   paramentList.add(qrecStatus);
		   }
		   if(StringUtils.isNotBlank(qapproveStatus))
		   {
			   hql.append(" AND bds.approveStatus = ? ");
			   paramentList.add(qapproveStatus);
		   }
		   if(StringUtils.isNotBlank(qrepStatus))
		   {
			   hql.append(" AND bds.repStatus = ? ");
			   paramentList.add(qrepStatus);
		   }
		   if(StringUtils.isNotBlank(qfiller2))
		   {
			   hql.append(" AND bds.filler2 LIKE ? ");
			   paramentList.add("%" + qfiller2 + "%");
		   }
		   hql.append(" AND bds.apptype = ? ");
		   paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		   
		   hql.append(" AND bds.currentfile = ? ");
		   paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AJ);
		   
		   hql.append(" ORDER BY bds.lstUpdTm DESC");

		   queryCondition.setPageIndex(pageIndex);
		   queryCondition.setPageSize(pageSize);
		   queryCondition.setQueryString(hql.toString());
		   queryCondition.setObjArray(paramentList.toArray());
		   PageQueryResult pageQueryResult = rootdao.pageQueryByQL(queryCondition);
		   List resultList = pageQueryResult.getQueryResult();
		   for(int i=0;i<resultList.size();i++){
			   Object[] obj = (Object[])resultList.get(i);
			   BopCfaExdebtDs bopCfaExdebtDs = (BopCfaExdebtDs)obj[0];
			   List creditorsList = rootdao.queryByQL2List(" FROM BopCfaCreditorDs model WHERE model.recId = '"+bopCfaExdebtDs.getId().trim()+"' ");
			   BopCfaCreditorDs bopCfaCreditorDs =(BopCfaCreditorDs)creditorsList.get(0);
			   bopCfaExdebtDs.setCreditorcode(bopCfaCreditorDs.getCreditorcode());
			   bopCfaExdebtDs.setCreditorname(bopCfaCreditorDs.getCreditorname());
			   bopCfaExdebtDs.setCreditornamen(bopCfaCreditorDs.getCreditornamen());
			   bopCfaExdebtDs.setCreditortype(bopCfaCreditorDs.getCreditortype());
			   bopCfaExdebtDs.setCrehqcode(bopCfaCreditorDs.getCrehqcode());
			   bopCfaExdebtDs.setOpercode(bopCfaCreditorDs.getOpercode());
		   }
		   pageQueryResult.setQueryResult(resultList);
		   return  pageQueryResult;
		}

}