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
import com.huateng.report.operation.BOPForDebtBondBillOperation;
import com.huateng.report.service.BOPForDebtBilLoanService;
import com.huateng.report.service.BopCfaCreditorDsService;
import com.huateng.report.utils.ReportUtils;

public class BOPForDebtBondBillUpdate extends BaseUpdate{

	private static final String DATASET_ID="BOPForDebtBondBillCol";

	private static final String RECORD_DELETE="del";
	private static final String RECORD_ADD="new";
	private static final String RECORD_MOD="mod";

	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {


		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		//取得外债信息结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

		OperationContext oc = new OperationContext();
		//债权人信息表
		BopCfaCreditorDs bcc = null;
		//外债信息表
		BopCfaExdebtDs bpExdebt = null;
		if(updateResultBean.hasNext()) {

			String op = updateResultBean.getParameter("op");
			//自定义bean ： 外债信息+单债权人信息
			BOPForDebtBilLoanCreditor bpExdebtTemp = new BOPForDebtBilLoanCreditor();
			mapToObject(bpExdebtTemp, updateResultBean.next());
			if(StringUtils.isNotEmpty(op)) {
				if(StringUtils.equals(RECORD_ADD, op)) {
					bcc = new BopCfaCreditorDs();

					bcc.setCrtTm(new Date());
					bcc.setId(ReportUtils.getUUID());
					String guid = ReportUtils.getUUID();
					bcc.setRecId(guid);

					bpExdebt = new BopCfaExdebtDs();
					bpExdebt.setId(guid);

					setValueByExdebtTemp(bcc, bpExdebt, bpExdebtTemp);

					bpExdebt.setCrtTm(new Date());

					oc.setAttribute(BOPForDebtBondBillOperation.CMD, BOPForDebtBondBillOperation.CMD_INSERT);
				} else if (StringUtils.equals(RECORD_MOD, op)){
					BopCfaCreditorDsService creditorServ = BopCfaCreditorDsService.getInstance();
					BOPForDebtBilLoanService debtServ = BOPForDebtBilLoanService.getInstance();

					bpExdebt = debtServ.load(bpExdebtTemp.getId());
					bcc =  creditorServ.load(bpExdebtTemp.getCreditorid());

					setValueByExdebtTemp(bcc, bpExdebt, bpExdebtTemp);

					bpExdebt.setId(bpExdebtTemp.getId());
					bcc.setId(bpExdebtTemp.getCreditorid());

					oc.setAttribute(BOPForDebtBondBillOperation.CMD, BOPForDebtBondBillOperation.CMD_UPDATE);

				} else if (StringUtils.equals(RECORD_DELETE, op)){
					BopCfaCreditorDsService creditorServ = BopCfaCreditorDsService.getInstance();
					BOPForDebtBilLoanService debtServ = BOPForDebtBilLoanService.getInstance();

					bpExdebt = debtServ.load(bpExdebtTemp.getId());
					bcc = creditorServ.load(bpExdebtTemp.getCreditorid());

					setValueByExdebtTemp(bcc, bpExdebt, bpExdebtTemp);

					bpExdebt.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bpExdebt.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bpExdebt.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bpExdebt.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bpExdebt.setActiondesc(bpExdebtTemp.getActiondesc());

					oc.setAttribute(BOPForDebtBondBillOperation.CMD, BOPForDebtBondBillOperation.CMD_DELETE);
				}
			}
		}

		oc.setAttribute(BOPForDebtBondBillOperation.IN_PARAM_EXDEBT, bpExdebt);
		oc.setAttribute(BOPForDebtBondBillOperation.IN_PARAM_BCC, bcc);

		OPCaller.call(BOPForDebtBondBillOperation.ID, oc);


		return updateReturnBean;
	}

	private void setValueByExdebtTemp(BopCfaCreditorDs bcc,
			BopCfaExdebtDs bpExdebt, BOPForDebtBilLoanCreditor bpExdebtTemp) throws CommonException {
		bpExdebt.setExdebtcode(bpExdebtTemp.getExdebtcode());
		bpExdebt.setDebtorcode(bpExdebtTemp.getDebtorcode());
		bpExdebt.setDebtype(bpExdebtTemp.getDebtype());
		bpExdebt.setContractamount(bpExdebtTemp.getContractamount());
		bpExdebt.setContractcurr(bpExdebtTemp.getContractcurr());
		bpExdebt.setValuedate(bpExdebtTemp.getValuedate());
		bpExdebt.setMaturity(bpExdebtTemp.getMaturity());
		bpExdebt.setFloatrate(bpExdebtTemp.getFloatrate());
		bpExdebt.setAnninrate(bpExdebtTemp.getAnninrate());
		bpExdebt.setIsincode(bpExdebtTemp.getIsincode());
		bpExdebt.setSpapfeboindex(bpExdebtTemp.getSpapfeboindex());
		bpExdebt.setRemark(bpExdebtTemp.getRemark());
		bpExdebt.setBuscode(bpExdebtTemp.getBuscode());
		bpExdebt.setFiller2(bpExdebtTemp.getFiller2());

		bcc.setCreditorcode(bpExdebtTemp.getCreditorcode());
		bcc.setCreditorname(bpExdebtTemp.getCreditorname());
		bcc.setCreditornamen(bpExdebtTemp.getCreditornamen());
		bcc.setCreditortype(bpExdebtTemp.getCreditortype());
		bcc.setOpercode(bpExdebtTemp.getOpercode());
		bcc.setCrehqcode(bpExdebtTemp.getCrehqcode());

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bpExdebt.setLstUpdTlr(ginfo.getTlrno());
		bpExdebt.setLstUpdTm(new Date());
		bpExdebt.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));
		bpExdebt.setBrNo(ginfo.getBrno());
		bpExdebt.setActiondesc(null);//新增或修改时不需要填写删除原因

		bpExdebt.setApptype(bpExdebtTemp.getApptype());
		bpExdebt.setCurrentfile(bpExdebtTemp.getCurrentfile());
		bpExdebt.setActiontype(bpExdebtTemp.getActiontype());
		bpExdebt.setRecStatus(bpExdebtTemp.getRecStatus());
		bpExdebt.setApproveStatus(bpExdebtTemp.getApproveStatus());
		bpExdebt.setRepStatus(bpExdebtTemp.getRepStatus());
		bpExdebt.setSubSuccess(bpExdebtTemp.getSubSuccess());
	}

}
