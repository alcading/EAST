package com.huateng.report.dataquery.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.dataquery.getter.BopCfaStrdeDsQueryGetter;

/**
 * @author zhuhongyong
 *
 */
public class BopCfaStrdeDsQueryService {
	
	public static BopCfaStrdeDsQueryService getInstance() {
		return (BopCfaStrdeDsQueryService) ApplicationContextUtils.getBean(BopCfaStrdeDsQueryService.class.getName());
	}
	
	/**
	 * 分页查询
	 * @param getType
	 * @param qbrNo
	 * @param qworkDate
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qstrdecode
	 * @param  
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 * @throws CommonException 
	 */
	public PageQueryResult pageQueryByQL(String getType, String qbrNo,
			String qworkDateStart,String qworkDateEnd, String qactiontype,String qrecStatus, String qapproveStatus,
			String qrepStatus, String qfiller2, int pageSize, int pageIndex) throws CommonException {
		// TODO Auto-generated method stub
		StringBuffer buff = new StringBuffer();
		List<Object> objs = new ArrayList<Object>();
		buff.append(" from BopCfaStrdeDs model where model.apptype = ?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		//判断按个页面来的   按不同的文件类型查
		if(BopCfaStrdeDsQueryGetter.GET_TYPE_CONTRACT.equalsIgnoreCase(getType)) {
			buff.append(" and model.currentfile = ?");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FA);
		} else if(BopCfaStrdeDsQueryGetter.GET_TYPE_TERMINATE.equalsIgnoreCase(getType)) {
			buff.append(" and model.currentfile = ?");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FB);
		} else if(BopCfaStrdeDsQueryGetter.GET_TYPE_INPAY.equalsIgnoreCase(getType)) {
			buff.append(" and model.currentfile = ?");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FC);
		}
		// qbrNo,qworkDate,qrecStatus,qapproveStatus,qrepStatus,qstrdecode
		if(StringUtils.isNotBlank(qbrNo)) {
			buff.append(" and model.brNo = ?");
			objs.add(qbrNo);
		} 
		if(StringUtils.isNotBlank(qworkDateStart)) {
			buff.append(" and model.workDate >= ?");
			objs.add(qworkDateStart);
		}
		if(StringUtils.isNotBlank(qworkDateEnd)) {
			buff.append(" and model.workDate <= ?");
			objs.add(qworkDateEnd);
		}
		if(StringUtils.isNotBlank(qactiontype)) {
			buff.append(" and model.actiontype = ?");
			objs.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qrecStatus)) {
			buff.append(" and model.recStatus = ?");
			objs.add(qrecStatus);
		}
		if(StringUtils.isNotBlank(qapproveStatus)) {
			buff.append(" and model.approveStatus = ?");
			objs.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus)) {
			buff.append(" and model.repStatus = ?");
			objs.add(qrepStatus);
		}
		if(StringUtils.isNotBlank(qfiller2)) {
			buff.append(" and model.filler2 like ?");
			objs.add("%"+qfiller2+"%");
		}
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setObjArray(objs.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(buff.toString());
		System.out.println(buff.toString());
		System.out.println(objs);
		return ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
	}

	/**
	 * 重载分页服务(for 资金流出入和结购汇信息)
	 * @param qbrNo
	 * @param qworkDate
	 * @param qactiontype
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 * @throws CommonException 
	 */
	public PageQueryResult pageQueryByQL(String qfiller2,String qbrNo, String qworkDateStart,String qworkDateEnd,
			String qactiontype, String qrecStatus, String qapproveStatus,
			String qrepStatus, int pageSize, int pageIndex) throws CommonException {
		// TODO Auto-generated method stub
		StringBuffer buff = new StringBuffer();
		List<Object> objs = new ArrayList<Object>();
		buff.append(" from BopCfaStrdeDs model where model.apptype = ? and model.currentfile = ?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FD);
		if(StringUtils.isNotBlank(qfiller2)) {
			buff.append(" and model.filler2 like ?");
			objs.add("%"+qfiller2+"%");
		}
		if(StringUtils.isNotBlank(qbrNo)) {
			buff.append(" and model.brNo = ?");
			objs.add(qbrNo);
		} 
		if(StringUtils.isNotBlank(qworkDateStart)) {
			buff.append(" and model.workDate >= ?");
			objs.add(qworkDateStart);
		}
		if(StringUtils.isNotBlank(qworkDateEnd)) {
			buff.append(" and model.workDate <= ?");
			objs.add(qworkDateEnd);
		}
		if(StringUtils.isNotBlank(qactiontype)) {
			buff.append(" and model.actiontype = ?");
			objs.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qrecStatus)) {
			buff.append(" and model.recStatus = ?");
			objs.add(qrecStatus);
		}
		if(StringUtils.isNotBlank(qapproveStatus)) {
			buff.append(" and model.approveStatus = ?");
			objs.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus)) {
			buff.append(" and model.repStatus = ?");
			objs.add(qrepStatus);
		}
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setObjArray(objs.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(buff.toString());
		System.out.println(buff.toString());
		System.out.println(objs);
		return ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
	}
	
	
}
