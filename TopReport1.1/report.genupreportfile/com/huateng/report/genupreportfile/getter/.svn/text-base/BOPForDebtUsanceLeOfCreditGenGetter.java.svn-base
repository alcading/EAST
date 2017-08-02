package com.huateng.report.genupreportfile.getter;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;


/**
 * @author zhuhongyong
 * for(外债 远期信用证)
 *
 */
public class BOPForDebtUsanceLeOfCreditGenGetter extends BaseGetter {
	
	public static final String SIGNED = "sign";//判断是签约信息页面的请求
	public static final String CHANGE = "change";//判断是变动信息页面请求
	
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "远期信用证签约信息查询");
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
		   GlobalInfo glbalInfo = GlobalInfo.getCurrentInstance(); 
		   int pageSize = getResult().getPage().getEveryPage();
		   int pageIndex = getResult().getPage().getCurrentPage();

		   PageQueryCondition queryCondition = new PageQueryCondition();
		   Map paramsMap = this.getCommQueryServletRequest().getParameterMap();
		   
		   String qbrNo = (String) paramsMap.get("qbrNo");
		   String qactiontype = (String) paramsMap.get("qactiontype");
		   String qfiller2 = (String) paramsMap.get("qfiller2");
		   //区分是签约签约信息还是变动信息
		   String getType = (String) paramsMap.get("getType");
		   List<Object> objs = new ArrayList<Object>();
		   StringBuffer hql = new StringBuffer();
		   
		   hql.append(" from BopCfaExdebtDs ds where ds.apptype = ? and ds.workDate = ?");
		   objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		   objs.add(glbalInfo.getFileDate());
		   if(SIGNED.equalsIgnoreCase(getType)) {
			   hql.append(" and ds.currentfile = ?");
			   objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AF);
		   } else if(CHANGE.equalsIgnoreCase(getType)) {
			   hql.append(" and ds.currentfile = ?");
			   objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);
			   hql.append(" and ds.changeFileType = ?");
			   objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AF);
		   }
		   if(!DataFormat.isEmpty(qbrNo)) {
			   hql.append(" and ds.brNo = ?");
			   objs.add(qbrNo);
		   }
		   if(!DataFormat.isEmpty(qactiontype)) {
			   hql.append(" and ds.actiontype = ?");
			   objs.add(qactiontype);
		   }
		   if(!DataFormat.isEmpty(qfiller2)) {
			   hql.append(" and ds.filler2 like ?");
			   objs.add("%"+qfiller2+"%");
		   }
		   hql.append(" order by ds.workDate,ds.approveStatus,ds.actiontype desc");

		   queryCondition.setPageIndex(pageIndex);
		   queryCondition.setPageSize(pageSize);
		   queryCondition.setQueryString(hql.toString());
		   queryCondition.setObjArray(objs.toArray());
		   return  rootdao.pageQueryByQL(queryCondition);
		}

}
