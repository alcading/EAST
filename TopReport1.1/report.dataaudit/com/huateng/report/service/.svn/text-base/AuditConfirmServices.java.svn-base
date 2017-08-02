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

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bean.AuditConfirmBean;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.ExecuteGenBopBusiNo;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class AuditConfirmServices {
	private static final String HQL_TABLENAME = "TABLENAME";
	private static final String HQL_PARAM_APPTYPE = "HQL_PARAM_APPTYPE";
	private static final String HQL_PARAM_CURRENTFILE = "HQL_PARAM_CURRENTFILE";

	/*
	 * 获得自身的实例
	 *
	 */
	public static synchronized AuditConfirmServices getInstance() {
		return (AuditConfirmServices) ApplicationContextUtils.getBean("AuditConfirmServices");
	}

	/**
	 * 查询审核完成确认数量
	 *
	 * @param workdate
	 * @param busiType
	 * @param brNo
	 * @param isShowZero2
	 * @return
	 * @throws CommonException
	 */
	public List getAuditConfirmList(String workdateStart, String workDateEnd, String busiType, String qappType, String brNo,String isShowZero) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer countHql = new StringBuffer();
		countHql.append("select model.recStatus as recsta,model.approveStatus as appsta,count(model) as stacount from ")
				.append(HQL_TABLENAME).append(" model ");
		countHql.append(" where model.recStatus in ('" + TopReportConstants.REPORT_RECSTATUS_03 + "','"
				+ TopReportConstants.REPORT_RECSTATUS_04 + "')");
		if (StringUtils.isNotEmpty(workdateStart)) {
			countHql.append(" and model.workDate >= '" + workdateStart + "'");
		}
		if (StringUtils.isNotEmpty(workDateEnd)) {
			countHql.append(" and model.workDate <= '" + workDateEnd + "'");
		}
		//是否按操作人员进行确认
		String flag = ReportUtils.getSysParamsValue("CFM", "0001");
		if(ReportEnum.REPORT_IS_STR.YES.value.equals(flag)){
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			countHql.append(" and model.lstUpdTlr='"+ gi.getTlrno() +"'");
		}
		countHql.append(" and model.brNo='" + brNo + "'");
		countHql.append(" and model.apptype='" + qappType + "'");
		countHql.append(" and model.currentfile='" + HQL_PARAM_CURRENTFILE + "'");
		countHql.append(" group by model.recStatus,model.approveStatus");

		Map<String, List<DataDic>> map = ReportCommonService.getInstance().getAppAndFileTypeByDataDic(busiType, qappType,
				null);
		List<AuditConfirmBean> list = new ArrayList<AuditConfirmBean>();
//		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
//			String appType = iterator.next().trim();
		if(map.size() > 0){
			List<DataDic> ddList = map.get(qappType);
			for (int i = 0; i < ddList.size(); i++) {
				DataDic dd = ddList.get(i);
				String fileType = dd.getDataNo().trim();
				String tableBean = dd.getHighLimit();
				if (tableBean != null) {
					String hql = countHql.toString().replaceAll(HQL_TABLENAME, tableBean.trim())
							.replaceAll(HQL_PARAM_CURRENTFILE, fileType);
					List groupList = rootdao.queryByQL2List(hql);
					if (isShowZero.equals(ReportEnum.REPORT_IS_STR.NO.value)) {
						if (groupList.size() == 0) {
							continue;
						}
					}
					AuditConfirmBean bean = new AuditConfirmBean();
					bean.setApptype(qappType);
					bean.setCurrentfile(fileType);
					bean.setWorkDate("workdateStart=" + workdateStart + ",workdateEnd=" + workDateEnd);
					bean.setBusiType(busiType);
					bean.setNoApprove(0);
					bean.setApprovePass(0);
					bean.setApproveUnPass(0);
					for (int j = 0; j < groupList.size(); j++) {
						Object[] obj = (Object[]) groupList.get(j);
						if (obj[0] == null || obj[1] == null || obj[2] == null) {
							ExceptionUtil.throwCommonException("存在未知状态记录！");
						}
						String recsta = obj[0].toString();
						String appsta = obj[1].toString();
						int count = Integer.parseInt(obj[2].toString());

						if (recsta.equals(TopReportConstants.REPORT_RECSTATUS_03)
								&& !appsta.equals(TopReportConstants.REPORT_APPROVESTATUS_00)) {
							ExceptionUtil.throwCommonException(qappType+"-"+fileType,"存在未知记录状态为'确认待审核'，而审批状态不为'未审核'记录！");
						}

						if (recsta.equals(TopReportConstants.REPORT_RECSTATUS_04)
								&& appsta.equals(TopReportConstants.REPORT_APPROVESTATUS_00)) {
							ExceptionUtil.throwCommonException(qappType+"-"+fileType,"存在未知记录状态为'已审核待确认'，而审批状态为'未审核'记录！");
						}

						if (recsta.equals(TopReportConstants.REPORT_RECSTATUS_03)
								&& appsta.equals(TopReportConstants.REPORT_APPROVESTATUS_00)) {
							bean.setNoApprove(count);
						}
						if (recsta.equals(TopReportConstants.REPORT_RECSTATUS_04)
								&& appsta.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
							bean.setApprovePass(count);
						}
						if (recsta.equals(TopReportConstants.REPORT_RECSTATUS_04)
								&& appsta.equals(TopReportConstants.REPORT_APPROVESTATUS_02)) {
							bean.setApproveUnPass(count);
						}
					}
					list.add(bean);
				}
			}
		}
		return list;
	}



	/**
	 * 执行审核完成确认
	 *
	 * @param busiType
	 * @param appType
	 * @param tlrNo
	 * @param brNo
	 * @param workDate
	 * @throws CommonException
	 */
	public void excue(String busiType, String appType, String tlrNo, String brNo, String workDate) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer querySql = new StringBuffer();
		querySql.append(" from ").append(HQL_TABLENAME);
		querySql.append(" where recStatus='" + TopReportConstants.REPORT_RECSTATUS_04 + "'");// 审核待确认
		querySql.append(" and approveStatus<>'" + TopReportConstants.REPORT_APPROVESTATUS_00 + "'");// 不等于未审核
		String workDateStart = null;
		String workDateEnd = null;
		String[] workDateStrs = workDate.split(",");
		if(workDate.split(",").length == 2) {
			if (workDateStrs[0].split("=").length == 2 && workDateStrs[0].split("=")[1].length() == 8) {
				workDateStart = workDateStrs[0].split("=")[1];
				querySql.append(" and workDate >='" + workDateStart + "'");
			}
			if (workDateStrs[1].split("=").length == 2 && workDateStrs[1].split("=")[1].length() == 8) {
				workDateEnd = workDateStrs[1].split("=")[1];
				querySql.append(" and workDate <='" + workDateEnd + "'");
			}
		}
		querySql.append(" and brNo='" + brNo + "'");
		String flag = ReportUtils.getSysParamsValue("CFM", "0001");
		if(ReportEnum.REPORT_IS_STR.YES.value.equals(flag)){
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			querySql.append(" and lstUpdTlr='"+ gi.getTlrno() +"'");
		}

		Map<String, List<DataDic>> map = ReportCommonService.getInstance().getAppAndFileTypeByDataDic(busiType, appType,
				null);
		Set<String> tableNmSet = new HashSet<String>();
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

		// 1.根据审核结果进行处理
		for (Iterator<String> it = tableNmSet.iterator(); it.hasNext();) {
			String tnm = it.next();
			String hql = querySql.toString().replaceAll(HQL_TABLENAME, tnm);
			List list = rootdao.queryByQL2List(hql);
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				boolean isDel = false;
				try {
					String approveStatus = PropertyUtils.getNestedProperty(obj, "approveStatus").toString();
					if (approveStatus.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {// 通过
						// 1.1 根据操作类型进行处理
						String actionType = PropertyUtils.getNestedProperty(obj, "actiontype").toString();
						if (actionType.equalsIgnoreCase(TopReportConstants.REPORT_ACTIONTYPE_A)
								|| actionType.equalsIgnoreCase(TopReportConstants.REPORT_ACTIONTYPE_C)) {// 创建或修改
							PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_05);// 已审核确认
						} else if (actionType.equalsIgnoreCase(TopReportConstants.REPORT_ACTIONTYPE_D)) {// 删除
							// 1.2 根据是否成功上报过进行标记为删除状态数据进行处理
							Object tmp = PropertyUtils.getNestedProperty(obj, "subSuccess");
							String isSubSuccess = null;
							if (tmp!=null) {
								isSubSuccess = tmp.toString();
							}else{
								ExceptionUtil.throwCommonException(HQL_TABLENAME+"数据上报状态丢失！");
							}
							if (isSubSuccess.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)) {// 上报过
								PropertyUtils.setNestedProperty(obj, "recStatus",
										TopReportConstants.REPORT_RECSTATUS_05);// 已审核确认
							} else if (isSubSuccess.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {// 为成功上报过执行删除
								isDel = true;
							}
						}
					} else if (approveStatus.equals(TopReportConstants.REPORT_APPROVESTATUS_02)) {// 不通过
						PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_01);// 可编辑
					}
					if (isDel) {
						//删除相关表
						String recId = (String) PropertyUtils.getNestedProperty(obj, "id");
						//删除关联表
						String[] tabs = new String[]{"BOP_CFA_CREDITOR_DS","BOP_CFA_EXPLBALAINFO","BOP_CFA_FOGUCODEINFO","BOP_EXGU_TOR_DS","BOP_PROJECT_INFO","MTS_BOP_INVCOUNTRYCODE","MTS_BOP_OPENACCOUNT"};
						for (int j = 0; j < tabs.length; j++) {
//							String sql = "delete from "+tabs[i]+" where REC_ID='"+recId+"'";
							String sql = "delete from "+tabs[j]+" where REC_ID='"+recId+"'";
							rootdao.executeSql(sql);
						}
						rootdao.delete(obj);
					} else {
						PropertyUtils.setNestedProperty(obj, "lstUpdTlr", tlrNo);
						PropertyUtils.setNestedProperty(obj, "lstUpdTm", new Date());
						rootdao.saveOrUpdate(obj);
					}
				} catch (Exception e) {
					ExceptionUtil.throwCommonException(e.getMessage());
				}
			}
		}
		// 2.开始处理未生成的编号
		genBussinessNo(tableNmSet, busiType, appType, workDateStart, workDateEnd , brNo);
	}

	public void genBussinessNo(Set<String> tableNmSet, String busiType, String appType, String workDateStart, String workDateEnd, String brNo)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer updateQuerySql = new StringBuffer();
		updateQuerySql.append(" from ").append(HQL_TABLENAME);
		updateQuerySql.append(" where recStatus='" + TopReportConstants.REPORT_RECSTATUS_05 + "'");// 已审核确认
		updateQuerySql.append(" and approveStatus = '" + TopReportConstants.REPORT_APPROVESTATUS_01 + "'");// 审核通过
		if(StringUtils.isNotEmpty(workDateStart)){
				updateQuerySql.append(" and workDate >='" + workDateStart + "'");
		}
		if (StringUtils.isNotEmpty(workDateEnd)) {
			updateQuerySql.append(" and workDate <='" + workDateEnd + "'");
		}
		updateQuerySql.append(" and brNo='" + brNo + "'");
		String flag = ReportUtils.getSysParamsValue("CFM", "0001");
		if(ReportEnum.REPORT_IS_STR.YES.value.equals(flag)){
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			updateQuerySql.append(" and lstUpdTlr='"+ gi.getTlrno() +"'");
		}
		String paramValue =ReportConstant.BUSI_NO_CODE;
		for (Iterator<String> it = tableNmSet.iterator(); it.hasNext();) {
			String tnm = it.next();
			String hql = updateQuerySql.toString().replaceAll(HQL_TABLENAME, tnm);
			List list = rootdao.queryByQL2List(hql);
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				try {
//					String appType = PropertyUtils.getNestedProperty(obj,  "apptype").toString();
					String fileType = PropertyUtils.getNestedProperty(obj, "currentfile").toString();
					String objWorkDate = PropertyUtils.getNestedProperty(obj, "workDate").toString();
					ExecuteGenBopBusiNo.execute(objWorkDate, busiType, appType, fileType, paramValue,obj);
				} catch (Exception e) {
					ExceptionUtil.throwCommonException(e.getMessage());
				}
			}
		}
	}

}
