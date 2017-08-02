package com.huateng.report.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import resource.bean.pub.DataDic;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bean.MakeupConfirmBean;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class MakeupConfirmServices {
	private static final HtLog htlog = HtLogFactory.getLogger(MakeupConfirmServices.class);
	private static final String HQL_TABLENAME = "TABLENAME";
	private static final String HQL_PARAM_APPTYPE = "HQL_PARAM_APPTYPE";
	private static final String HQL_PARAM_CURRENTFILE = "HQL_PARAM_CURRENTFILE";
	private static final String HQL_PARAM_WORKDATE_START = "HQL_PARAM_WORKDATE_START";
	private static final String HQL_PARAM_WORKDATE_END = "HQL_PARAM_WORKDATE_END";
	private static final String HQL_PARAM_BRNO = "HQL_PARAM_BRNO";
	private static final String HQL_PARAM_RECSTATUS = "HQL_PARAM_RECSTATUS";

	/*
	 * 获得自身的实例
	 *
	 */
	public static synchronized MakeupConfirmServices getInstance() {
		return (MakeupConfirmServices) ApplicationContextUtils.getBean("MakeupConfirmServices");
	}

	// 执行补录 补录成功更改记录状态为03
	public void excue(String busiType, String appType, String tlrNo, String brNo, String workDate) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Map<String, List<DataDic>> map = ReportCommonService.getInstance().getAppAndFileTypeByDataDic(busiType, appType,
				null);
		StringBuffer querySql = new StringBuffer();
		querySql.append(" from ").append(HQL_TABLENAME);
		querySql.append(" where recStatus='" + TopReportConstants.REPORT_RECSTATUS_02 + "'");
		String[] workDateStrs = workDate.split(",");
		if(workDate.split(",").length == 2) {
			if (workDateStrs[0].split("=").length == 2 && workDateStrs[0].split("=")[1].length() == 8) {
				querySql.append(" and workDate >='" + workDateStrs[0].split("=")[1] + "'");
			}
			if (workDateStrs[1].split("=").length == 2 && workDateStrs[1].split("=")[1].length() == 8) {
				querySql.append(" and workDate <='" + workDateStrs[1].split("=")[1] + "'");
			}
		}
		querySql.append(" and brNo='" + brNo + "'");
		String flag = ReportUtils.getSysParamsValue("CFM", "0001");
		if(ReportEnum.REPORT_IS_STR.YES.value.equals(flag)){
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			querySql.append(" and lstUpdTlr='"+ gi.getTlrno() +"'");
		}
		
		Set<String> tableNmSet = new HashSet<String>();
//		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
//			String appType = iterator.next().trim();
		if(map.size() > 0){
			List<DataDic> ddList = map.get(appType);
			for (int i = 0; i < ddList.size(); i++) {
				DataDic dd = ddList.get(i);
				String tableNm = dd.getHighLimit();
				if (tableNm != null) {
					tableNmSet.add(tableNm.trim());
				}
			}
		}
		for (Iterator<String> it = tableNmSet.iterator(); it.hasNext();) {
			String tnm = it.next();
			String hql = querySql.toString().replaceAll(HQL_TABLENAME, tnm);
			List list = rootdao.queryByQL2List(hql);
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				try {
					PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_03);
					PropertyUtils.setNestedProperty(obj, "lstUpdTlr", tlrNo);
					PropertyUtils.setNestedProperty(obj, "lstUpdTm", new Date());
					rootdao.saveOrUpdate(obj);
				} catch (Exception e) {
					ExceptionUtil.throwCommonException(e.getMessage());
				}
			}
		}
	}

	public List getMakeUpConfirmList(String busiType, String qappType, String workDateStart, String workDateEnd, String brNo,String isShwoZero) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer countHql = new StringBuffer();
		countHql.append("select count(model) from ").append(HQL_TABLENAME).append(" model where");
		if(StringUtils.isNotEmpty(workDateStart) && StringUtils.isNotEmpty(workDateEnd)){
			countHql.append(" model.workDate >='" + HQL_PARAM_WORKDATE_START + "'");
			countHql.append(" and model.workDate <='" + HQL_PARAM_WORKDATE_END + "'");
		} else if (StringUtils.isNotEmpty(workDateStart) && StringUtils.isEmpty(workDateEnd)) {
			countHql.append(" model.workDate >='" + HQL_PARAM_WORKDATE_START + "'");
		} else if (StringUtils.isEmpty(workDateStart) && StringUtils.isNotEmpty(workDateEnd)){
			countHql.append(" model.workDate <='" + HQL_PARAM_WORKDATE_END + "'");
		}
		countHql.append(" and model.recStatus='" + HQL_PARAM_RECSTATUS + "'");
		countHql.append(" and model.brNo='" + HQL_PARAM_BRNO + "'");
//		countHql.append(" and model.apptype='" + HQL_PARAM_APPTYPE + "'");
		countHql.append(" and model.apptype='" + qappType + "'");
		countHql.append(" and model.currentfile='" + HQL_PARAM_CURRENTFILE + "'");
		//是否按操作人员进行确认
		String flag = ReportUtils.getSysParamsValue("CFM", "0001");
		if(ReportEnum.REPORT_IS_STR.YES.value.equals(flag)){
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			countHql.append(" and model.lstUpdTlr='"+ gi.getTlrno() +"'");
		}
		
//		Map<String, List<DataDic>> map = ReportCommonService.getInstance().getAppAndFileTypeByDataDic(busiType, null, null);
		Map<String, List<DataDic>> map = ReportCommonService.getInstance().getAppAndFileTypeByDataDic(busiType, qappType, null);
		List<MakeupConfirmBean> list = new ArrayList<MakeupConfirmBean>();
//		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
//			String appType = iterator.next().trim();
		if(map.size() > 0){
			List<DataDic> ddList = map.get(qappType);
			for (int i = 0; i < ddList.size(); i++) {
				DataDic dd = ddList.get(i);
				String fileType = dd.getDataNo().trim();
				String tableBean = dd.getHighLimit();
				if (tableBean != null) {
					String hql = countHql.toString().replaceAll(HQL_TABLENAME, tableBean.trim()).replaceAll(
							HQL_PARAM_BRNO, brNo).replaceAll(HQL_PARAM_WORKDATE_START, workDateStart).replaceAll(
							HQL_PARAM_WORKDATE_END, workDateEnd).replaceAll(
							HQL_PARAM_CURRENTFILE, fileType);
					int hashNum = rootdao.queryByHqlToCount(hql.replaceAll(HQL_PARAM_RECSTATUS,
							TopReportConstants.REPORT_RECSTATUS_02));
					int noNum = rootdao.queryByHqlToCount(hql.replaceAll(HQL_PARAM_RECSTATUS,
							TopReportConstants.REPORT_RECSTATUS_01));
					if (isShwoZero.equals(ReportEnum.REPORT_IS_STR.NO.value)) {
						if (hashNum == 0 && noNum == 0) {
							continue;
						}
					}
					MakeupConfirmBean bean = new MakeupConfirmBean();
					bean.setApptype(qappType);
					bean.setCurrentfile(fileType);
					bean.setWorkDate("workDateStart=" + workDateStart + ",workDateEnd=" + workDateEnd);
					bean.setHashNum(hashNum);
					bean.setNoNum(noNum);
					bean.setBusiType(busiType);
					list.add(bean);
				}
			}
		}
		return list;
	}

}
