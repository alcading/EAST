package com.huateng.report.operation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BOPForDebtBilLoanService;
import com.huateng.report.service.BOPForDebtChangeInfoService;
import com.huateng.report.service.BopCfaCreditorDsService;

public class BOPForDebtBondBillOperation extends BaseOperation {

	public static final String ID = "BOPForDebtBondBillOperation";
	public static final HtLog htLog = HtLogFactory.getLogger(BOPForDebtBondBillOperation.class);
	//外债信息表cmd
	public static final String CMD = "CMD";


	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String CMD_APPROVE = "CMD_APPROVE";
	//外债信息表、债权人 param
	public static final String IN_PARAM_EXDEBT = "IN_PARAM_EXDEBT";
	public static final String IN_PARAM_BCC = "IN_PARAM_BCC";

	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";

	@Override
	@SuppressWarnings("unchecked")
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		// 外债信息表
		BopCfaExdebtDs bpExdebt = (BopCfaExdebtDs) context.getAttribute(IN_PARAM_EXDEBT);
		// 债权人信息表
		BopCfaCreditorDs bcc = (BopCfaCreditorDs)context.getAttribute(IN_PARAM_BCC);
		// 把债权人信息表设置到外债信息表里，做验证
		if(null != bcc) {
			List<BopCfaCreditorDs> creditors = new ArrayList<BopCfaCreditorDs>();
			creditors.add(bcc);
			bpExdebt.setCreditors(creditors);
		}
		// 数据处理记录表
		ReportCommonService reportCommonService = ReportCommonService.getInstance();
		if (StringUtils.equals(CMD_INSERT, cmd)) {
			BopCfaCreditorDsService bccService = BopCfaCreditorDsService.getInstance();
			BOPForDebtBilLoanService bpDebtService = BOPForDebtBilLoanService.getInstance();

			bpDebtService.save(bpExdebt);
			bccService.save(bcc);

			reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(),
					bpExdebt.getCurrentfile(), bpExdebt.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"A-创建", "插入外债签约信息        签约信息ID ：" + bpExdebt.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"创建外债信息 债券和票据签约信息"});
			htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"创建外债信息 债券和票据签约信息"});


		} else if (StringUtils.equals(CMD_UPDATE, cmd)) {
			BopCfaCreditorDsService bccService = BopCfaCreditorDsService.getInstance();
			BOPForDebtBilLoanService bpDebtService = BOPForDebtBilLoanService.getInstance();

			bpDebtService.update(bpExdebt);
			bccService.update(bcc);

			reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(),
					bpExdebt.getCurrentfile(), bpExdebt.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"C-修改", "更新外债签约信息签约信息       签约信息ID ：" + bpExdebt.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"修改外债信息 债券和票据签约信息"});
			htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"修改外债信息 债券和票据签约信息"});


		} else if (StringUtils.equals(CMD_DELETE, cmd)) {
			BOPForDebtChangeInfoService bopDebtChInfo = BOPForDebtChangeInfoService.getInstance();
			List<BopCfaExdebtDs> list = bopDebtChInfo.queryChangeInfo(bpExdebt.getId());
			BOPForDebtBilLoanService bpDebtService = BOPForDebtBilLoanService.getInstance();
			if (!list.isEmpty()) {
				ExceptionUtil.throwCommonException("无法删除,当前签约信息记录下存在变动信息记录！");
			}
			bpDebtService.delete(bpExdebt);
			reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(),
					bpExdebt.getCurrentfile(), bpExdebt.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "D-删除",
					"删除签约信息      签约信息ID ：" + bpExdebt.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"删除外债信息 债券和票据签约信息"});
			htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"删除外债信息 债券和票据签约信息"});

		} else if (StringUtils.equals(CMD_APPROVE, cmd)) {

			List<BopCfaExdebtDs> bopCfaExdebtDsList = (List<BopCfaExdebtDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);

			BOPForDebtBilLoanService bpDebtService = BOPForDebtBilLoanService.getInstance();
			bpDebtService.auditBopCfaExdebtDs(approveStatusChoose, approveResultChoose, bopCfaExdebtDsList, null);

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外债信息货币市场工具签约信息审核"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外债信息货币市场工具签约信息审核"});

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"审核外债信息 债券和票据签约信息"});
			htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"审核外债信息 债券和票据签约信息"});

		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}
}