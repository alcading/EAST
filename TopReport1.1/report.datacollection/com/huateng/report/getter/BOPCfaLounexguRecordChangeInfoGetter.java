package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaLounexguDs;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.DateUtil;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BOPCfaLounexguRecordBean;
import com.huateng.report.constants.TopReportConstants;

public class BOPCfaLounexguRecordChangeInfoGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		
		try {
				PageQueryResult list = getData(); 
				ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list.getQueryResult(), getResult());
				result.setContent(list.getQueryResult());
				result.getPage().setTotalPage(list.getPageCount(getResult().getPage().getEveryPage()));
				result.init();
				return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	

	private PageQueryResult getData() throws AppException{
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();
		
		String hqlString = "select bd from BopCfaLounexguDs bd where bd.currentfile = '"+TopReportConstants.REPORT_FILE_TYPE_CFA_DB+"'" ;
		PageQueryResult pageQueryResult = new PageQueryResult();
		String op = getCommQueryServletRequest().getParameter("op");
		if("new".equalsIgnoreCase(op)){
			//业务类型标识
			BopCfaLounexguDs bopCfaLounexguDs = new BopCfaLounexguDs();
			
			List list = new ArrayList();
			list.add(bopCfaLounexguDs);
			pageQueryResult.setQueryResult(list);
			
		}else if("mod".equalsIgnoreCase(op) || "del".equalsIgnoreCase(op)  || "detail".equalsIgnoreCase(op)){
			BOPCfaLounexguRecordBean bop = new BOPCfaLounexguRecordBean();
			String  id = getCommQueryServletRequest().getParameter("id");
			if(StringUtils.isNotBlank(id)){
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				
				BopCfaLounexguDs  bopCfa =  rootdao.query(BopCfaLounexguDs.class, id);
				bop.setId(bopCfa.getId());
				bop.setBuscode(bopCfa.getBuscode());
				bop.setChangeno(bopCfa.getChangeno());
				bop.setChangedate(bopCfa.getChangedate());
				bop.setCredcurrcode(bopCfa.getCredcurrcode());
				bop.setRemark(bopCfa.getRemark());
				bop.setFiller2(bopCfa.getFiller2());
				bop.setCredwithamount(bopCfa.getCredwithamount());
				bop.setCredrepayamount(bopCfa.getCredrepayamount());
				bop.setPicamount(bopCfa.getPicamount());
				bop.setCredprinbala(bopCfa.getCredprinbala());
				bop.setGuarantlibala(bopCfa.getGuarantlibala());
				bop.setGuperamount(bopCfa.getGuperamount());
				bop.setFiller1(bopCfa.getFiller1());
				bop.setActiontype(bopCfa.getActiontype());
				bop.setRecStatus(bopCfa.getRecStatus());
				bop.setRepStatus(bopCfa.getRepStatus());
				bop.setApproveStatus(bopCfa.getApproveStatus());
				bop.setCrtTm(bopCfa.getCrtTm());
				bop.setLstUpdTm(bopCfa.getLstUpdTm());
				bop.setActiondesc(bopCfa.getActiondesc());
				bop.setSubSuccess(bopCfa.getSubSuccess());
				bop.setWorkDate(bopCfa.getWorkDate());
				
				
				BopCfaLounexguDs bopCfaLounexguDs = rootdao.query(BopCfaLounexguDs.class,bopCfa.getFiller1());
				bop.setDofoexlocode(bopCfaLounexguDs.getDofoexlocode());
				bop.setLounexgucode(bopCfaLounexguDs.getLounexgucode());
				bop.setCreditorcode(bopCfaLounexguDs.getCreditorcode());
				bop.setDebtorcode(bopCfaLounexguDs.getDebtorcode());
				bop.setDebtorname(bopCfaLounexguDs.getDebtorname());
				bop.setDebtortype(bopCfaLounexguDs.getDebtortype());
				bop.setCredcurrcodeOth(bopCfaLounexguDs.getCredcurrcode());
				bop.setCredconamount(bopCfaLounexguDs.getCredconamount());
				bop.setCfeogudad(bopCfaLounexguDs.getCfeogudad());
				bop.setCfeogudcurr(bopCfaLounexguDs.getCfeogudcurr());
				bop.setCfeogudamount(bopCfaLounexguDs.getCfeogudamount());
				bop.setValuedate(bopCfaLounexguDs.getValuedate());
				bop.setMaturity(bopCfaLounexguDs.getMaturity());
				bop.setRemarkOth(bopCfaLounexguDs.getRemark());
				bop.setFiller2Oth(bopCfaLounexguDs.getFiller2());
				
				List<BOPCfaLounexguRecordBean> list = new ArrayList<BOPCfaLounexguRecordBean>();
				list.add(bop);
				pageQueryResult.setQueryResult(list);
				
			}
		}
		else{
			String workDateStart = getCommQueryServletRequest().getParameter("workDateStart");
			String workDateEnd = getCommQueryServletRequest().getParameter("workDateEnd");
			String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");
			String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
			String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");
			String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
			String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外担保项下境内贷款信息补录变动及履约信息查询");
				GlobalInfo gi = GlobalInfo.getCurrentInstance();
				hqlString += "and  bd.workDate ='"+DateUtil.dateToNumber(gi.getTxdate())+"'";
				hqlString +=" and  (bd.recStatus ='"+TopReportConstants.REPORT_RECSTATUS_01+"' or  bd.recStatus='"+TopReportConstants.REPORT_RECSTATUS_02+"')";
		
					if(StringUtils.isNotBlank(workDateStart)){
						hqlString += " and workDate >= '"+workDateStart +"'";
					}
					if(StringUtils.isNotBlank(workDateEnd)){
						hqlString += " and workDate <= '"+workDateEnd +"'";
					}
					if(StringUtils.isNotBlank(qactiontype)){
						hqlString += " and actiontype = '"+qactiontype +"'";
					}
					if(StringUtils.isNotBlank(qrecStatus)){
						hqlString += " and recStatus = '"+qrecStatus +"'";
					}
					if(StringUtils.isNotBlank(qapproveStatus)){
						hqlString += " and approveStatus = '"+qapproveStatus +"'";
					}
					if(StringUtils.isNotBlank(qrepStatus)){
						hqlString += " and repStatus = '"+qrepStatus +"'";
					}
					if(StringUtils.isNotBlank(qfiller2)){
						hqlString += " and filler2 like'%"+qfiller2 +"%'";
					}
					hqlString += " ORDER BY bd.lstUpdTm DESC ";
			
			PageQueryCondition pc = new PageQueryCondition();
			pc.setPageIndex(pageIndex);
			pc.setPageSize(pageSize);
			pc.setQueryString(hqlString);
			
			HQLDAO hqlDao = DAOUtils.getHQLDAO();
			pageQueryResult = hqlDao.pageQueryByQL(pc);
		}
	
		return pageQueryResult;
		
	}

}
