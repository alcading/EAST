package com.huateng.report.operation;

import resource.bean.report.BopCfaStrdeDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.service.BopCfaStrdeDsService;

public class BopCfaStrdeDsOperation extends BaseOperation {
	
	private static final HtLog htlog = HtLogFactory.getLogger(BopCfaStrdeDsOperation.class);
	
	public static final String ID = "bopCfaStrdeDsOperation";
	public static final String AD_IN_PARAM = "AD_IN_PARAM";
	public static final String CMD = "CMD";
	public static final String AD_CMD_DEL = "AD_del";
	public static final String AD_CMD_MOD = "AD_mod";
	public static final String AD_CMD_ADD = "AD_add";
	public static final String TERMINATE_IN_PARAM = "TERMINATE_IN_PARAM";
	public static final String TERMINATE_CMD_DEL = "TERMINATE_del";
	public static final String TERMINATE_CMD_MOD = "TERMINATE_mod";
	public static final String TERMINATE_CMD_ADD = "TERMINATE_add";
	public static final String INPAY_IN_PARAM = "INPAY_IN_PARAM";
	public static final String INPAY_CMD_ADD = "INPAY_ADD";
	public static final String INPAY_CMD_MOD = "INPAY_MOD";
	public static final String INPAY_CMD_DEL = "INPAY_DEL";
	public static final String INOUTMO_IN_PARAM = "INOUTMO_IN_PARAM";
	public static final String INOUTMO_CMD_ADD = "INOUTMo_ADD";
	public static final String INOUTMO_CMD_MOD = "INOUTMo_MOD";
	public static final String INOUTMO_CMD_DEL = "INOUTMo_DEL";
	
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		BopCfaStrdeDs bopCfaStrdeDsAD = (BopCfaStrdeDs) context.getAttribute(BopCfaStrdeDsOperation.AD_IN_PARAM);
		BopCfaStrdeDs bopCfaStrdeDsTerminate = (BopCfaStrdeDs) context.getAttribute(BopCfaStrdeDsOperation.TERMINATE_IN_PARAM);
		BopCfaStrdeDs bopCfaStrdeDsInpay = (BopCfaStrdeDs) context.getAttribute(BopCfaStrdeDsOperation.INPAY_IN_PARAM);
		BopCfaStrdeDs bopCfaStrdeDsInoutMo = (BopCfaStrdeDs) context.getAttribute(BopCfaStrdeDsOperation.INOUTMO_IN_PARAM);
		BopCfaStrdeDsService service = BopCfaStrdeDsService.getInstance();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//签约信息变更(增加，删除，修改)
		if(AD_CMD_ADD.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeAd_add(bopCfaStrdeDsAD);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款签约信息新增"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款签约信息新增"});
		} else if(AD_CMD_MOD.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeAd_mod(bopCfaStrdeDsAD);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款签约信息修改"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款签约信息修改"});
		} else if(AD_CMD_DEL.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeAd_del(bopCfaStrdeDsAD);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款签约信息删除"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款签约信息删除"});
		} 
		//终止信息变更(增加，删除，修改)
		if(TERMINATE_CMD_ADD.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeTerminate_add(bopCfaStrdeDsTerminate);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款终止信息新增"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款终止信息新增"});
		} else if(TERMINATE_CMD_MOD.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeTerminate_mod(bopCfaStrdeDsTerminate);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款终止信息修改"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款终止信息修改"});
		} else if(TERMINATE_CMD_DEL.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeTerminate_del(bopCfaStrdeDsTerminate);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款终止信息删除"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款终止信息删除"});
		}
		//利息给付信息变更
		if(INPAY_CMD_ADD.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeInpay_add(bopCfaStrdeDsInpay);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款利息给付信息增加"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款利息给付信息增加"});			
		} else if(INPAY_CMD_MOD.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeInpay_mod(bopCfaStrdeDsInpay);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款利息给付信息修改"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款利息给付信息修改"});	
		} else if(INPAY_CMD_DEL.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeInpay_del(bopCfaStrdeDsInpay);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款利息给付信息删除"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款利息给付信息删除"});	
		}
		//资金流出入和结购汇信息新增变更(增加，修改，删除)
		if(INOUTMO_CMD_ADD.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeInoutMo_add(bopCfaStrdeDsInoutMo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款 资金流出入和结购汇信息新增"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款 资金流出入和结购汇信息新增"});
		} else if(INOUTMO_CMD_MOD.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeInoutMo_mod(bopCfaStrdeDsInoutMo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款 资金流出入和结购汇信息修改"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款 资金流出入和结购汇信息修改"});
		} else if(INOUTMO_CMD_DEL.equalsIgnoreCase(cmd)) {
			service.bopCfaStrdeInoutMo_del(bopCfaStrdeDsInoutMo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"商业银行人名币结构性存款 资金流出入和结购汇信息删除"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"商业银行人名币结构性存款 资金流出入和结购汇信息删除"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
