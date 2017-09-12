package com.huateng.report.update;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExdebtDs;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BOPForDebtChangeInfoOperation;
import com.huateng.report.service.BOPForDebtBilLoanService;
import com.huateng.report.utils.ReportUtils;

/**
 * 外债信息-变动信息 update
 * @author cwenao
 * @version 1.0
 * 2012-8-28
 * */

public class BOPForDebtChangeInfoUpdate extends BaseUpdate {

	private static final String DATASET_ID="BOPForDebtChangInfoCol";
	private static final String RECORD_DELETE="del";
	private static final String RECORD_ADD="new";
	private static final String RECORD_MOD="mod";


	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//取得外债信息结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		//开始处理
		//外债信息表
		BopCfaExdebtDs bpExdebt =null;

		BOPForDebtBilLoanService debtServ = null;

		OperationContext oc = new OperationContext();
		GlobalInfo  gInfo =GlobalInfo.getCurrentInstance();

		if(updateResultBean.hasNext())
		{
			//自定义bean ： 外债信息+单债权人信息
			BopCfaExdebtDs bpExdebtTemp = new BopCfaExdebtDs();

			String op = updateResultBean.getParameter("op");
			String changFileType = updateResultBean.getParameter("changFileType");
			Map map = updateResultBean.next();
			mapToObject(bpExdebtTemp,map);

			if(!StringUtils.isEmpty(op))
			{
				if(RECORD_ADD.equalsIgnoreCase(op))
				{
					bpExdebt = new BopCfaExdebtDs();

					bpExdebt.setExdebtcode(bpExdebtTemp.getExdebtcode());
					bpExdebt.setBuscode(bpExdebtTemp.getBuscode());

					bpExdebt.setChangeno(bpExdebtTemp.getChangeno());
					bpExdebt.setChangtype(bpExdebtTemp.getChangtype());
					bpExdebt.setChdate(bpExdebtTemp.getChdate());
					bpExdebt.setChcurrency(bpExdebtTemp.getChcurrency());
					bpExdebt.setChamount(bpExdebtTemp.getChamount());
					bpExdebt.setFairvalue(bpExdebtTemp.getFairvalue());
					bpExdebt.setRemark(bpExdebtTemp.getRemark());
					bpExdebt.setWorkDate(gInfo.getTxdate().toString().replaceAll("-", ""));
					bpExdebt.setChangeFileType(changFileType);
					bpExdebt.setFiller1(bpExdebtTemp.getFiller1());
					bpExdebt.setFiller2(bpExdebtTemp.getFiller2());
					bpExdebt.setInpriamount(bpExdebtTemp.getInpriamount());
					/*操作状态=A-创建
					记录状态=02-编辑待确认
					审核状态=00-未审核
					回执状态=00-未返回
					是否已成功上报=0-否*/
					bpExdebt.setId(ReportUtils.getUUID());
					bpExdebt.setCrtTm(new Date());
					bpExdebt.setLstUpdTm(new Date());
					bpExdebt.setLstUpdTlr(gInfo.getTlrno());
					bpExdebt.setBrNo(gInfo.getBrno());

					bpExdebt.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bpExdebt.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);

					bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					bpExdebt.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bpExdebt.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bpExdebt.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bpExdebt.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

					oc.setAttribute(BOPForDebtChangeInfoOperation.IN_FIELD_TYPE, changFileType);
					oc.setAttribute(BOPForDebtChangeInfoOperation.CMD, BOPForDebtChangeInfoOperation.CMD_INSERT);

				}
				else if(RECORD_MOD.equalsIgnoreCase(op))
				{
					debtServ = BOPForDebtBilLoanService.getInstance();

					bpExdebt = debtServ.load(bpExdebtTemp.getId());

					bpExdebt.setExdebtcode(bpExdebtTemp.getExdebtcode());
					bpExdebt.setBuscode(bpExdebtTemp.getBuscode());

					bpExdebt.setChangeno(bpExdebtTemp.getChangeno());
					bpExdebt.setChangtype(bpExdebtTemp.getChangtype());
					bpExdebt.setChdate(bpExdebtTemp.getChdate());
					bpExdebt.setChcurrency(bpExdebtTemp.getChcurrency());
					bpExdebt.setChamount(bpExdebtTemp.getChamount());
					bpExdebt.setFairvalue(bpExdebtTemp.getFairvalue());
					bpExdebt.setRemark(bpExdebtTemp.getRemark());
					bpExdebt.setWorkDate(gInfo.getTxdate().toString().replaceAll("-", ""));
					bpExdebt.setFiller2(bpExdebtTemp.getFiller2());
					bpExdebt.setInpriamount(bpExdebtTemp.getInpriamount());
					bpExdebt.setActiondesc(null);

					if(!StringUtils.isEmpty(bpExdebtTemp.getSubSuccess()) && TopReportConstants.REPORT_IS_SUB_SUCCESS_YES.equalsIgnoreCase(bpExdebtTemp.getSubSuccess()))
					{
						/*
						 * 上报已成功
						 *
						 操作状态=C-修改
						记录状态=02-编辑待确认
						审核状态=00-未审核
						回执状态=00-未返回
						是否已成功上报=不变化*/
						bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
						bpExdebt.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bpExdebt.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bpExdebt.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

					}
					else if(!StringUtils.isEmpty(bpExdebtTemp.getSubSuccess()) && TopReportConstants.REPORT_IS_SUB_SUCCESS_NO.equalsIgnoreCase(bpExdebtTemp.getSubSuccess()))
					{
						/*
						 * 上报未成功
						 *
						 操作状态=A-创建
						记录状态=02-编辑待确认
						审核状态=00-未审核
						回执状态=00-未返回
						是否已成功上报=不变化*/
						bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
						bpExdebt.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bpExdebt.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bpExdebt.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					}
					bpExdebt.setId(bpExdebtTemp.getId());
					bpExdebt.setLstUpdTlr(gInfo.getTlrno());
					bpExdebt.setLstUpdTm(new Date());

					oc.setAttribute(BOPForDebtChangeInfoOperation.IN_FIELD_TYPE, changFileType);
					oc.setAttribute(BOPForDebtChangeInfoOperation.CMD, BOPForDebtChangeInfoOperation.CMD_UPDATE);
				}
				else if(RECORD_DELETE.equalsIgnoreCase(op))
				{
					/*
					 操作状态=D-删除
					记录状态=02-编辑待确认
					审核状态=00-未审核
					回执状态=00-未返回
					是否已成功上报=不变化
					*/
					debtServ = BOPForDebtBilLoanService.getInstance();
					bpExdebt = debtServ.load(bpExdebtTemp.getId());

					bpExdebt.setWorkDate(gInfo.getTxdate().toString().replaceAll("-", ""));

					bpExdebt.setLstUpdTlr(gInfo.getTlrno());
					bpExdebt.setLstUpdTm(new Date());

					bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bpExdebt.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bpExdebt.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bpExdebt.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bpExdebt.setActiondesc(bpExdebtTemp.getActiondesc());

					oc.setAttribute(BOPForDebtChangeInfoOperation.IN_FIELD_TYPE, changFileType);
					oc.setAttribute(BOPForDebtChangeInfoOperation.CMD, BOPForDebtChangeInfoOperation.CMD_DELETE);
				}
			}
		}

		oc.setAttribute(BOPForDebtChangeInfoOperation.IN_PARAM_EXDEBT, bpExdebt);

		OPCaller.call(BOPForDebtChangeInfoOperation.ID, oc);

		return updateReturnBean;
	}
}