package com.huateng.report.update;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BOPForDebtBilLoanCreditor;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BOPForDebtOtherDebtsOperation;
import com.huateng.report.service.BOPForDebtBilLoanService;
import com.huateng.report.service.BopCfaCreditorDsService;
import com.huateng.report.utils.ReportUtils;

public class BOPForDebtOtherDebtsUpdate extends BaseUpdate{

	private static final String DATASET_ID="BOPForDebtOtherDebtsCol";

	private static final String RECORD_DELETE="del";
	private static final String RECORD_ADD="new";
	private static final String RECORD_MOD="mod";


	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//取得外债信息结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		//外债信息表
		BopCfaExdebtDs bpExdebt =null;
		//债权人信息表
		BopCfaCreditorDs bcc = new BopCfaCreditorDs();
		BopCfaCreditorDsService creditorServ = null;
		BOPForDebtBilLoanService debtServ = null;

		OperationContext oc = new OperationContext();
		if (updateResultBean.hasNext()) {

			String op = updateResultBean.getParameter("op");

			// 自定义bean ： 外债信息+单债权人信息
			BOPForDebtBilLoanCreditor bpExdebtTemp = new BOPForDebtBilLoanCreditor();
			mapToObject(bpExdebtTemp, updateResultBean.next());
			if (!StringUtils.isEmpty(op)) {

				if (StringUtils.equals(RECORD_ADD, op)) {
					bpExdebt = new BopCfaExdebtDs();
					String guid = ReportUtils.getUUID();

					bpExdebt.setId(guid);
					bpExdebt.setCrtTm(new Date());

					// 项目信息表
					bcc = new BopCfaCreditorDs();
					bcc.setRecId(guid);
					bcc.setCrtTm(new Date());
					bcc.setId(ReportUtils.getUUID());

					setValuePageParement(bpExdebt, bcc, bpExdebtTemp);

					oc.setAttribute(BOPForDebtOtherDebtsOperation.CMD, BOPForDebtOtherDebtsOperation.CMD_INSERT);

				} else if (StringUtils.equals(RECORD_MOD, op)) {
					creditorServ = BopCfaCreditorDsService.getInstance();
					debtServ = BOPForDebtBilLoanService.getInstance();

					bpExdebt = debtServ.load(bpExdebtTemp.getId());
					bcc = creditorServ.load(bpExdebtTemp.getCreditorid());

					setValuePageParement(bpExdebt, bcc, bpExdebtTemp);

					oc.setAttribute(BOPForDebtOtherDebtsOperation.CMD, BOPForDebtOtherDebtsOperation.CMD_UPDATE);
				} else if (StringUtils.equals(RECORD_DELETE, op)) {
					/*
					 * 操作状态=D-删除 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
					 * 是否已成功上报=不变化
					 */
					debtServ = BOPForDebtBilLoanService.getInstance();

					bpExdebt = debtServ.load(bpExdebtTemp.getId());

					bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bpExdebt.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bpExdebt.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bpExdebt.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bpExdebt.setActiondesc(bpExdebtTemp.getActiondesc());

					GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
					bpExdebt.setLstUpdTlr(ginfo.getTlrno());
					bpExdebt.setLstUpdTm(new Date());
					bpExdebt.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));
					bpExdebt.setBrNo(ginfo.getBrno());

					oc.setAttribute(BOPForDebtOtherDebtsOperation.CMD,BOPForDebtOtherDebtsOperation.CMD_DELETE);

				}
			}
		}

		oc.setAttribute(BOPForDebtOtherDebtsOperation.IN_PARAM_EXDEBT, bpExdebt);
		oc.setAttribute(BOPForDebtOtherDebtsOperation.IN_PARAM_BCC, bcc);

		OPCaller.call(BOPForDebtOtherDebtsOperation.ID, oc);


		return updateReturnBean;
	}


	private void setValuePageParement(BopCfaExdebtDs bpExdebt,
			BopCfaCreditorDs bcc, BOPForDebtBilLoanCreditor bpExdebtTemp) throws CommonException {

		bcc.setCreditorcode(bpExdebtTemp.getCreditorcode());
		bcc.setCreditorname(bpExdebtTemp.getCreditorname());
		bcc.setCreditornamen(bpExdebtTemp.getCreditornamen());
		bcc.setCreditortype(bpExdebtTemp.getCreditortype());
		bcc.setOpercode(bpExdebtTemp.getOpercode());
		bcc.setCrehqcode(bpExdebtTemp.getCrehqcode());



		bpExdebt.setExdebtcode(bpExdebtTemp.getExdebtcode());
		bpExdebt.setDebtorcode(bpExdebtTemp.getDebtorcode());
		bpExdebt.setDebtype(bpExdebtTemp.getDebtype());
		bpExdebt.setContractamount(bpExdebtTemp.getContractamount());
		bpExdebt.setContractcurr(bpExdebtTemp.getContractcurr());
		bpExdebt.setValuedate(bpExdebtTemp.getValuedate());
		bpExdebt.setMaturity(bpExdebtTemp.getMaturity());
		bpExdebt.setFloatrate(bpExdebtTemp.getFloatrate());
		bpExdebt.setAnninrate(bpExdebtTemp.getAnninrate());
		bpExdebt.setInprterm(bpExdebtTemp.getInprterm());
		bpExdebt.setSpapfeboindex(bpExdebtTemp.getSpapfeboindex());
		bpExdebt.setDebtyperema(bpExdebtTemp.getDebtyperema());
		bpExdebt.setRemark(bpExdebtTemp.getRemark());
		bpExdebt.setFiller2(bpExdebtTemp.getFiller2());
		bpExdebt.setActiondesc(bpExdebtTemp.getActiondesc());

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bpExdebt.setLstUpdTlr(ginfo.getTlrno());
		bpExdebt.setLstUpdTm(new Date());
		bpExdebt.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));
		bpExdebt.setBrNo(ginfo.getBrno());


		bpExdebt.setApptype(bpExdebtTemp.getApptype());
		bpExdebt.setCurrentfile(bpExdebtTemp.getCurrentfile());
		bpExdebt.setActiontype(bpExdebtTemp.getActiontype());
		bpExdebt.setRecStatus(bpExdebtTemp.getRecStatus());
		bpExdebt.setApproveStatus(bpExdebtTemp.getApproveStatus());
		bpExdebt.setRepStatus(bpExdebtTemp.getRepStatus());
		bpExdebt.setSubSuccess(bpExdebtTemp.getSubSuccess());

	}

}
