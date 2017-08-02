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
import com.huateng.report.operation.BOPForDebtBalanceInfoOperation;
import com.huateng.report.service.BOPForDebtBilLoanService;
import com.huateng.report.utils.ReportUtils;

public class BOPForDebtBalanceInfoUpdate extends BaseUpdate {


	private static final String DATASET_ID="BOPForDebtBalanceInfoCol";
	private static final String RECORD_DELETE="del";
	private static final String RECORD_ADD="new";
	private static final String RECORD_MOD="mod";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
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
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();

		if(updateResultBean.hasNext())
		{
			//自定义bean ： 外债信息+单债权人信息
			BopCfaExdebtDs bpExdebtTemp = new BopCfaExdebtDs();
			String op = updateResultBean.getParameter("op");
			String balanceFileType = updateResultBean.getParameter("balanceFileType");
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
					bpExdebt.setChdate(bpExdebtTemp.getChdate());
					bpExdebt.setRemark(bpExdebtTemp.getRemark());
					bpExdebt.setWorkDate(gInfo.getTxdate().toString().replaceAll("-", ""));

					bpExdebt.setFiller2(bpExdebtTemp.getFiller2());
					bpExdebt.setAccoamount(bpExdebtTemp.getAccoamount());

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

					bpExdebt.setBalanceFileType(balanceFileType);
					bpExdebt.setFiller1(bpExdebtTemp.getFiller1());

					bpExdebt.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bpExdebt.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);

					bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);

					bpExdebt.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bpExdebt.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bpExdebt.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bpExdebt.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

					oc.setAttribute(BOPForDebtBalanceInfoOperation.CMD, BOPForDebtBalanceInfoOperation.CMD_INSERT);

				}
				else if(RECORD_MOD.equalsIgnoreCase(op))
				{

					debtServ = BOPForDebtBilLoanService.getInstance();

					bpExdebt = debtServ.load(bpExdebtTemp.getId());

					bpExdebt.setActiondesc(null);
					bpExdebt.setExdebtcode(bpExdebtTemp.getExdebtcode());
					bpExdebt.setBuscode(bpExdebtTemp.getBuscode());

					bpExdebt.setChangeno(bpExdebtTemp.getChangeno());
					bpExdebt.setChdate(bpExdebtTemp.getChdate());
					bpExdebt.setRemark(bpExdebtTemp.getRemark());
					bpExdebt.setWorkDate(gInfo.getTxdate().toString().replaceAll("-", ""));
					bpExdebt.setFiller2(bpExdebtTemp.getFiller2());
					bpExdebt.setAccoamount(bpExdebtTemp.getAccoamount());

					if(!StringUtils.isEmpty(bpExdebtTemp.getSubSuccess()) && TopReportConstants.REPORT_IS_SUB_SUCCESS_YES.equalsIgnoreCase(bpExdebtTemp.getSubSuccess()))
					{
						bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
					}
					else if(!StringUtils.isEmpty(bpExdebtTemp.getSubSuccess()) && TopReportConstants.REPORT_IS_SUB_SUCCESS_NO.equalsIgnoreCase(bpExdebtTemp.getSubSuccess()))
					{
						bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					}

					bpExdebt.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bpExdebt.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bpExdebt.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

					bpExdebt.setId(bpExdebtTemp.getId());
					bpExdebt.setLstUpdTlr(gInfo.getTlrno());
					bpExdebt.setLstUpdTm(new Date());

					bpExdebt.setBalanceFileType(balanceFileType);
					oc.setAttribute(BOPForDebtBalanceInfoOperation.CMD, BOPForDebtBalanceInfoOperation.CMD_UPDATE);
				}
				else if(RECORD_DELETE.equalsIgnoreCase(op))
				{
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

					bpExdebt.setBalanceFileType(balanceFileType);
					oc.setAttribute(BOPForDebtBalanceInfoOperation.CMD, BOPForDebtBalanceInfoOperation.CMD_DELETE);
				}
			}
		}
		oc.setAttribute(BOPForDebtBalanceInfoOperation.PARAM_BALANCE, bpExdebt);
		OPCaller.call(BOPForDebtBalanceInfoOperation.ID, oc);
		return updateReturnBean;
	}
}
