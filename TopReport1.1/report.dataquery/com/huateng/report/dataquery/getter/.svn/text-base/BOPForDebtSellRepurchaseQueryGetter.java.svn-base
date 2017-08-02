package com.huateng.report.dataquery.getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForDebtFeiOrgSave;
import com.huateng.report.constants.TopReportConstants;

public class BOPForDebtSellRepurchaseQueryGetter extends BaseGetter {
	
	public static final String CONTRACT = "sign";
	public static final String CHANGE = "change";
	
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "卖出回购签约信息查询");
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

	private PageQueryResult getData() throws CommonException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		   GlobalInfo gInfo = GlobalInfo.getCurrentInstance(); 
		   
		   int pageSize = getResult().getPage().getEveryPage();
		   int pageIndex = getResult().getPage().getCurrentPage();
		   PageQueryCondition queryCondition = new PageQueryCondition();

		   StringBuffer hql = new StringBuffer("select ds from BopCfaExdebtDs ds where 1=1 ");
		   
		   String qbrNo = this.getCommQueryServletRequest().getParameter("qbrNo");
		   String qworkDateBegin = getCommQueryServletRequest().getParameter("qWorkDateBegin");
		   String qworkDateOver = getCommQueryServletRequest().getParameter("qWorkDateOver");
		   String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");
		   String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
		   String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");
		   String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
		   String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");
		   //获得查询类型 是签约信息还是变动信息
		   String getType = this.getCommQueryServletRequest().getParameter("getType");
		   if(CONTRACT.equalsIgnoreCase(getType)) {
			   hql.append(" and ds.apptype = '").append(TopReportConstants.REPORT_APP_TYPE_CFA).append("'").append(" and" +
			   		" ds.currentfile = '").append(TopReportConstants.REPORT_FILE_TYPE_CFA_AE).append("'");
		   } else if(CHANGE.equalsIgnoreCase(getType)) {
			   hql.append(" and ds.apptype = '").append(TopReportConstants.REPORT_APP_TYPE_CFA).append("'").append(" and" +
				   		" ds.currentfile = '").append(TopReportConstants.REPORT_FILE_TYPE_CFA_AR).append("'");
			   hql.append(" and ds.changeFileType = '").append(TopReportConstants.REPORT_FILE_TYPE_CFA_AE).append("'");
		   }
		   if(StringUtils.isNotBlank(qbrNo))
		   {
			   hql.append(" and ds.brNo ='").append(qbrNo).append("'");
		   }
		   if(StringUtils.isNotBlank(qworkDateBegin))
		   {
			   hql.append(" and ds.workDate >='").append(qworkDateBegin).append("'");
		   }
		   if(StringUtils.isNotBlank(qworkDateOver))
		   {
			   hql.append(" and ds.workDate <='").append(qworkDateOver).append("'");
		   }
		   if(StringUtils.isNotBlank(qactiontype))
		   {
			   hql.append(" and ds.actiontype ='").append(qactiontype).append("'");
		   }
		   if(StringUtils.isNotBlank(qrecStatus))
		   {
			   hql.append(" and ds.recStatus ='").append(qrecStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qapproveStatus))
		   {
			   hql.append(" and ds.approveStatus ='").append(qapproveStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qrepStatus)) {
			   hql.append(" and ds.repStatus like '").append(qrepStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qfiller2))
		   {
			   hql.append(" and ds.filler2 like '%").append(qfiller2).append("%'");
		   }
		   
		   hql.append(" order by ds.workDate,ds.approveStatus,ds.actiontype desc");
		   queryCondition.setPageIndex(pageIndex);
		   queryCondition.setPageSize(pageSize);
		   queryCondition.setQueryString(hql.toString());
		   
		   PageQueryResult queryResult = new PageQueryResult();
			queryResult = rootdao.pageQueryByQL(queryCondition);
			List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
			List list = queryResult.getQueryResult();
			if(list != null){
				Iterator it = list.iterator();
				while(it.hasNext()){
					Object o = it.next();
					Object[] os = (Object[]) o;
					BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
					BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
					BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
					String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
					debtFeiOrgSaves.add(debtFeiOrgSave);
				}
				
			}
			queryResult.setQueryResult(debtFeiOrgSaves);
			return queryResult;
	}

}
