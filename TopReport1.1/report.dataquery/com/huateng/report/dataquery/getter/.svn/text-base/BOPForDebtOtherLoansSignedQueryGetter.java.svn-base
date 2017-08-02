package com.huateng.report.dataquery.getter;



import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.bean.report.BopProjectInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForDebtFeiOrgSave;
import com.huateng.report.constants.TopReportConstants;

/**
 * 
 * 外债信息表Getter
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 * 
 * */

public class BOPForDebtOtherLoansSignedQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub

		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债信息其他贷款签约信息查询");
			PageQueryResult queryResult = getData();
		
		//	HtLog logger = HtLogFactory.getLog(BOPForDebtBilLoanGetter.class);
			
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
	private PageQueryResult getData() throws CommonException, IllegalAccessException, InvocationTargetException
		{

		   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		   //
		   int pageSize = getResult().getPage().getEveryPage();
		   //页码
		   int pageIndex = getResult().getPage().getCurrentPage();

		   PageQueryCondition queryCondition = new PageQueryCondition();

		   StringBuffer hql = new StringBuffer("select bds from BopCfaExdebtDs bds where 1=1 ");
		   
		   Map map = getCommQueryServletRequest().getParameterMap();
		   String qbrNo = (String) map.get("qbrNo");
		   String qWorkDateBegin = (String)map.get("qWorkDateBegin");
		   String qWorkDateOver = (String)map.get("qWorkDateOver");
		   String qactiontype = (String) map.get("qactiontype");
		   String qrecStatus = (String) map.get("qrecStatus");
		   String qapproveStatus = (String) map.get("qapproveStatus");
		   String qrepStatus = (String) map.get("qrepStatus");
		   String qfiller2 = (String) map.get("qfiller2");
		   if(StringUtils.isNotBlank(qbrNo))
		   {
			   hql.append(" and bds.brNo ='").append(qbrNo).append("'");
		   }
		   if(StringUtils.isNotBlank(qWorkDateBegin))
		   {
			   hql.append(" and bds.workDate >='" + qWorkDateBegin + "'");
		   }
		   if(StringUtils.isNotBlank(qWorkDateOver))
		   {
			   hql.append(" and bds.workDate <='" + qWorkDateOver + "'");
		   }
		   if(StringUtils.isNotBlank(qactiontype))
		   {
			   hql.append(" and bds.actiontype ='").append(qactiontype).append("'");
		   }
		   if(StringUtils.isNotBlank(qrecStatus))
		   {
			   hql.append(" and bds.recStatus ='").append(qrecStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qapproveStatus))
		   {
			   hql.append(" and bds.approveStatus ='").append(qapproveStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qrepStatus))
		   {
			   hql.append(" and bds.repStatus ='").append(qrepStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qfiller2))
		   {
			   hql.append(" and bds.filler2 like '%").append(qfiller2).append("%'");
		   }
		   hql.append(" and bds.apptype='"+TopReportConstants.REPORT_APP_TYPE_CFA+"'");
		   hql.append(" and bds.currentfile='"+TopReportConstants.REPORT_FILE_TYPE_CFA_AI+"'");
		   hql.append(" order by bds.lstUpdTm desc");

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
						String cpjHql = "from BopProjectInfo model where model.recId ='" + cfaExdebtDs.getId() + "'";
						BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
						BopProjectInfo bopProjectInfo = (BopProjectInfo)rootdao.queryByQL2List(cpjHql).get(0);
//						BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
						debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
						debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
						debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
						debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
						debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
						debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
						debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
						debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
						debtFeiOrgSave.setProjectname(bopProjectInfo.getProjectname());
					debtFeiOrgSaves.add(debtFeiOrgSave);
				}
			}
			queryResult.setQueryResult(debtFeiOrgSaves);
			return queryResult;
		   
		}

}
