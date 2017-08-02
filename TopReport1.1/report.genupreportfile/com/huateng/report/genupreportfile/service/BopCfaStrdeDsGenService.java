package com.huateng.report.genupreportfile.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.genupreportfile.getter.BopCfaStrdeDsGenGetter;

/**
 * @author zhuhongyong
 *
 */
public class BopCfaStrdeDsGenService {
	
	public static BopCfaStrdeDsGenService getInstance() {
		return (BopCfaStrdeDsGenService) ApplicationContextUtils.getBean(BopCfaStrdeDsGenService.class.getName());
	}

	/**
	 * 分页查询
	 * @param getType
	 * @param qactiontype
	 * @param qbrNo
	 * @param qstrdecode
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult pageQueryByHql(String getType,String qactiontype,String qbrNo,String qfiller2,int pageSize,int pageIndex) throws CommonException {
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		StringBuffer buff = new StringBuffer();
		List<Object> paramList = new ArrayList<Object>();
		buff.append(" from BopCfaStrdeDs model where model.workDate = ? and model.apptype = ? and model.recStatus = ? and model.repStatus = ?");
		paramList.add(globalInfo.getFileDate());
		paramList.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		paramList.add(TopReportConstants.REPORT_RECSTATUS_05);
		paramList.add(TopReportConstants.REPORT_REPSTATUS_00);
		if(StringUtils.isNotBlank(qactiontype)) {
			buff.append(" and model.actiontype = ?");
			paramList.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qbrNo)) {
			buff.append("and model.brNo = ?") ;
			paramList.add(qbrNo);
		}
		if(StringUtils.isNotBlank(qfiller2)) {
			buff.append(" and model.filler2 like ?");
			paramList.add("%"+qfiller2+"%");
		}
		//判断不同的文件类型,取不同的信息数据
		System.out.println("getType = "+getType);
		if(BopCfaStrdeDsGenGetter.GET_TYPE_CONTRACT.equalsIgnoreCase(getType)) {
			buff.append(" and model.currentfile = ?");
			paramList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FA);
		} else if(BopCfaStrdeDsGenGetter.GET_TYPE_TERMINATE.equalsIgnoreCase(getType)) {
			buff.append(" and model.currentfile = ?");
			paramList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FB);
		} else if(BopCfaStrdeDsGenGetter.GET_TYPE_INPAY.equalsIgnoreCase(getType)) {
			buff.append(" and model.currentfile = ?");
			paramList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FC);
		} else if(BopCfaStrdeDsGenGetter.GET_TYPE_INOUTMO.equalsIgnoreCase(getType)) {
			buff.append(" and model.currentfile = ?");
			paramList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FD);
		}
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageSize(pageSize);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setQueryString(buff.toString());
		queryCondition.setObjArray(paramList.toArray());
		System.out.println(buff.toString());
		System.out.println(paramList);
		return ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
	}
	
}
