package com.huateng.report.operation;

import java.util.List;

import resource.bean.report.BopCfaStrdeDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.service.BopCfaStrdeDsAuditService;
/*
 * 商业银行人民币结构性存款审核
 */
public class BopCfaStrdeDsAuditOperation extends BaseOperation {
	
	private static final HtLog htlog = HtLogFactory.getLogger(BopCfaStrdeDsAuditOperation.class);
	
	public static final String ID = "bopCfaStrdeDsAuditOperation";
	public static final String CMD = "CMD";
	public static final String CONTRACT_AUDIT_CMD = "contract_audit";
	public static final String TERMINATE_AUDIT_CMD = "terminate_audit";
	public static final String INPAY_AUDIT_CMD = "inpay_audit";
	public static final String INOUTMO_AUDIT_CMD = "inoutmo_audit";
	
	public static final String CONTRACT_AUDIT_LIST_IN_PARAM = "CONTRACT_AUDIT_LIST_IN_PARAM";
	public static final String TERMINATE_AUDIT_LIST_IN_PARAM = "TERMINATE_AUDIT_LIST_IN_PARAM";
	public static final String INPAY_AUDIT_LIST_IN_PARAM = "INPAY_AUDIT_LIST_IN_PARAM";
	public static final String INOUTMO_AUDIT_LIST_IN_PARAM = "INOUTMO_AUDIT_LIST_IN_PARAM";
	public static final String AUDIT_STATUS = "AUDIT_STATUS";
	public static final String AUDIT_RESULT = "AUDIT_RESULT";
	
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		String approveStatusChoose = (String) context.getAttribute(AUDIT_STATUS);
		String approveResultChoose = (String) context.getAttribute(AUDIT_RESULT);
		BopCfaStrdeDsAuditService service = BopCfaStrdeDsAuditService.getInstance();
		if(CONTRACT_AUDIT_CMD.equalsIgnoreCase(cmd)) {
			//签约信息审核
			List<BopCfaStrdeDs> bopCfaStrdeDsList = (List<BopCfaStrdeDs>) context.getAttribute(CONTRACT_AUDIT_LIST_IN_PARAM);
			service.contract_audit(bopCfaStrdeDsList,approveStatusChoose,approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款签约信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款签约信息审核"});
		} else if(TERMINATE_AUDIT_CMD.equals(cmd)) {
			//终止信息审核
			List<BopCfaStrdeDs> bopCfaStrdeDsList = (List<BopCfaStrdeDs>) context.getAttribute(TERMINATE_AUDIT_LIST_IN_PARAM);
			service.terminate_audit(bopCfaStrdeDsList, approveStatusChoose, approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款终止信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款终止信息审核"});
		} else if(INPAY_AUDIT_CMD.equals(cmd)) {
			//利息给付信息审核
			List<BopCfaStrdeDs> bopCfaStrdeDsList = (List<BopCfaStrdeDs>) context.getAttribute(INPAY_AUDIT_LIST_IN_PARAM);
			service.inpay_audit(bopCfaStrdeDsList, approveStatusChoose, approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款利息给付信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款利息给付信息审核"});
		} else if(INOUTMO_AUDIT_CMD.equals(cmd)) {
			//资金流出入和结购汇信息
			List<BopCfaStrdeDs> bopCfaStrdeDsList = (List<BopCfaStrdeDs>) context.getAttribute(INOUTMO_AUDIT_LIST_IN_PARAM);
			service.inoutMo_audit(bopCfaStrdeDsList, approveStatusChoose, approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款资金流出入和结购汇信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款资金流出入和结购汇信息审核"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
