package com.huateng.report.bop.collection.operation;

import java.util.List;

import resource.bean.report.MtsBopInvcountrycode;
import resource.bean.report.MtsBopOpenAccount;
import resource.bean.report.MtsBopUDs;
import cn.cncc.cjdp.common.utils.StringUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.collection.service.BopUDsService;

public class BopUDsOperation extends BaseOperation {

	private static final HtLog htlog = HtLogFactory.getLogger(BopFsDsOperation.class);
	public static final String ID = "BopUDsOperation";
	public static final String CMD = "CMD";
	public static final String CMD_NEW = "new";
	public static final String CMD_MOD = "modify";
	public static final String CMD_DEL = "delete";
	public static final String CMD_DETAIL = "detail";
	public static final String CMD_AUDIT = "audit";

	public static final String PARAM_U = "PARAM_U";
	public static final String PARAM_COUNTRY_ADD = "PARAM_COUNTRY_ADD";
	public static final String PARAM_COUNTRY_MOD = "PARAM_COUNTRY_MOD";
	public static final String PARAM_COUNTRY_DEL = "PARAM_COUNTRY_DEL";

	public static final String PARAM_OPENACCOUNT_ADD = "PARAM_OPENACCOUNT_ADD";
	public static final String PARAM_OPENACCOUNT_MOD = "PARAM_OPENACCOUNT_MOD";
	public static final String PARAM_OPENACCOUNT_DEL = "PARAM_OPENACCOUNT_DEL";

	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";

	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);

		BopUDsService service = BopUDsService.getInstance();
		if (StringUtils.equals(CMD_NEW, cmd)) {
			MtsBopUDs bopu = (MtsBopUDs)context.getAttribute(PARAM_U);
			List<MtsBopInvcountrycode> countryList = (List<MtsBopInvcountrycode>)context.getAttribute(PARAM_COUNTRY_ADD);
			List<MtsBopOpenAccount> openaccountList = (List<MtsBopOpenAccount>)context.getAttribute(PARAM_OPENACCOUNT_ADD);
			service.saveBopU(bopu, countryList, openaccountList);

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"单位基本情况表新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"单位基本情况表新增"});
		} else if (StringUtils.equals(CMD_MOD, cmd)){

			MtsBopUDs bopu = (MtsBopUDs)context.getAttribute(PARAM_U);
			List<MtsBopInvcountrycode> countryList = (List<MtsBopInvcountrycode>)context.getAttribute(PARAM_COUNTRY_ADD);
			List<MtsBopOpenAccount> openaccountList = (List<MtsBopOpenAccount>)context.getAttribute(PARAM_OPENACCOUNT_ADD);

			List<MtsBopInvcountrycode> modcountryList = (List<MtsBopInvcountrycode>)context.getAttribute(PARAM_COUNTRY_MOD);
			List<MtsBopOpenAccount> modopenaccountList = (List<MtsBopOpenAccount>)context.getAttribute(PARAM_OPENACCOUNT_MOD);

			List<MtsBopInvcountrycode>delcountryList = (List<MtsBopInvcountrycode>)context.getAttribute(PARAM_COUNTRY_DEL);
			List<MtsBopOpenAccount> delopenaccountList = (List<MtsBopOpenAccount>)context.getAttribute(PARAM_OPENACCOUNT_DEL);

			service.updateBopU(bopu, countryList, openaccountList, modcountryList, modopenaccountList, delcountryList, delopenaccountList);

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"单位基本情况表修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"单位基本情况表修改"});
		} else if (StringUtils.equals(CMD_DEL, cmd)) {

			MtsBopUDs bopu = (MtsBopUDs)context.getAttribute(PARAM_U);
			service.deleteBopU(bopu);

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"单位基本情况表删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"单位基本情况表删除"});
		} else if (StringUtils.equals(CMD_AUDIT, cmd)) {
			List<MtsBopUDs> bopuList = (List<MtsBopUDs>)context.getAttribute(PARAM_U);
			String approveStatusChoose = (String)context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String)context.getAttribute(IN_AUDIT_RESULT);
			service.audit(bopuList, approveStatusChoose, approveResultChoose);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"单位基本情况表审核"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"单位基本情况表审核"});
		}
	}

	public void afterProc(OperationContext context) throws CommonException {
	}

}
