package com.huateng.report.operation;

import java.util.ArrayList;
import java.util.List;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.service.BopForSameInduDepositService;

public class BopForSameInduDepositOperation  extends  BaseOperation{
	private static final HtLog htLog = HtLogFactory.getLogger(BopAccDsOperation.class);
	
	public  static final String ID = "BopForSameInduDepositOperation";
	public static  final String CMD = "CMD";
	//签约信息新增
	public static final String CMD_SIGN_INSERT= "CMD_SIGN_INSERT";
	//签约信息修改
	public static final String CMD_SIGN_UPDATE = "CMD_SIGN_UPDATE";
	//签约信息删除
	public static final String CMD_SIGN_DELETE = "CMD_SIGN_DELETE";
	//签约信息审核
	public static final String CMD_SIGN_AUDIT= "CMD_SIGN_AUDIT";
	//签约信息数据
	public static final String  SIGN_IN_LIST = "SIGN_IN_LIST";
	//审核状态
	public static final String  IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	//审核说明
	public static final String  IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	
	//余额信息新增
	public static final String CMD_BALANCE_INSERT = "CMD_BALANCE_INSERT";
	//余额信息修改
	public static final String CMD_BALANCE_UPDATE= "CMD_BALANCE_UPDATE";
	//余额信息删除
	public static final String CMD_BALANCE_DELETE= "CMD_BALANCE_DELETE";
	//余额信息审核
	public static final String CMD_BALANCE_AUDIT= "CMD_BALANCE_AUDIT";
	//余额信息数据
	public static final String  BALANCE_IN_LIST = "BALANCE_IN_LIST";
	//外债信息
	public static final String  PARAM_EXDEBTDS = "PARAM_EXDEBTDS";
	//债权信息
	public static final String PARAM_CREDITORSDS = "PARAM_CREDITORSDS";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String)context.getAttribute(CMD);
		BopForSameInduDepositService bopForSameInduDepositService = BopForSameInduDepositService.getInstance();
		
		BopCfaExdebtDs bopCfaExdebtDs = (BopCfaExdebtDs)context.getAttribute(PARAM_EXDEBTDS);
		BopCfaCreditorDs bopCfaCreditorDs = (BopCfaCreditorDs)context.getAttribute(PARAM_CREDITORSDS);
		
		// 把债权人信息表设置到外债信息表里，做验证
		if(null != bopCfaCreditorDs) {
			List<BopCfaCreditorDs> creditors = new ArrayList<BopCfaCreditorDs>();
			creditors.add(bopCfaCreditorDs);
			bopCfaExdebtDs.setCreditors(creditors);
		}
		
		if(CMD_SIGN_INSERT.equalsIgnoreCase(cmd)){
			bopForSameInduDepositService.saveInduDeposit(bopCfaExdebtDs,bopCfaCreditorDs);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"同业存放签约信息新增"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"同业存放签约信息新增"});
		}else if(CMD_SIGN_UPDATE.equalsIgnoreCase(cmd)){
			bopForSameInduDepositService.updateInduDeposit(bopCfaExdebtDs, bopCfaCreditorDs);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"同业存放签约信息修改"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"同业存放签约信息修改"});
		}else if(CMD_SIGN_DELETE.equalsIgnoreCase(cmd)){
			bopForSameInduDepositService.deleteInduDeposit(bopCfaExdebtDs);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"同业存放签约信息删除"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"同业存放签约信息删除"});
		}else if(CMD_BALANCE_INSERT.equalsIgnoreCase(cmd)){
			bopForSameInduDepositService.saveInduDepositBalance(bopCfaExdebtDs);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"同业存放余额信息新增"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"同业存放余额信息新增"});
		}else if(CMD_BALANCE_UPDATE.equalsIgnoreCase(cmd)){
			bopForSameInduDepositService.updateInduDepositBalance(bopCfaExdebtDs);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"同业存放余额信息修改"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"同业存放余额信息修改"});
		}else if(CMD_BALANCE_DELETE.equalsIgnoreCase(cmd)){
			bopForSameInduDepositService.updateInduDepositBalance(bopCfaExdebtDs);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"同业存放余额信息删除"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"同业存放余额信息删除"});
		}else if(CMD_SIGN_AUDIT.equalsIgnoreCase(cmd)){
			List<BopCfaExdebtDs> bopCfaExDsList = (List<BopCfaExdebtDs>)context.getAttribute(SIGN_IN_LIST);
			String approveStatusChoose  = (String)context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose  = (String)context.getAttribute(IN_AUDIT_RESULT);
			bopForSameInduDepositService.auditInduDeposit(approveStatusChoose, approveResultChoose, bopCfaExDsList);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"同业存放签约信息审核"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"同业存放签约信息审核"});
		}else if(CMD_BALANCE_AUDIT.equalsIgnoreCase(cmd)){
			List<BopCfaExdebtDs> bopCfaExDsList = (List<BopCfaExdebtDs>)context.getAttribute(BALANCE_IN_LIST);
			String approveStatusChoose  = (String)context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose  = (String)context.getAttribute(IN_AUDIT_RESULT);
			bopForSameInduDepositService.auditInduBalanceDeposit(approveStatusChoose, approveResultChoose, bopCfaExDsList);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"同业存放余额信息审核"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"同业存放余额信息审核"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
