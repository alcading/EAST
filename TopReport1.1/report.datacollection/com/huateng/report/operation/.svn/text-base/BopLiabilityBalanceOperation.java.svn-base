package com.huateng.report.operation;

import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopCFAExguDsService;
import com.huateng.report.service.BopExguTorDsService;


public class BopLiabilityBalanceOperation extends BaseOperation {
	public static final String ID = "BopLiabilityBalanceOperation";
	public static final String CMD = "CMD";
	public static final String OP_MOD = "OP_MOD";

	public static final String CMD_MOD = "CMD_MOD";
	public static final String CMD_DEL = "CMD_DEL";
	public static final String CMD_INSERT = "CMD_INSERT";
	// 对外担保信息
	public static final String IN_CFA = "IN_CFA";
	public static final String CMD_CFA_ADD = "CMD_CFA_ADD";
	public static final String CMD_CFA_MOD = "CMD_CFA_MOD";

	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";

	// 收益人/担保人/被担保人信息
	public static final String IN_PARAM_MOD = "IN_PARAM_MOD";
	public static final String IN_PARAM_DEL = "IN_PARAM_DEL";

	public static final String IN_TOR = "IN_TOR";
	public static final String CMD_Tor_ADD = "CMD_Tor_ADD";
	public static final String CMD_Tor_MOD = "CMD_Tor_MOD";
	public static final String CMD_Tor_DEL = "CMD_Tor_DEL";

	public static final String IN_PARAM_EXGU = "IN_PARAM_EXGU";
	public static final String IN_PARAM_TOR = "IN_PARAM_TOR";
	public static final String IN_PARAM_TOR_INSERT = "IN_PARAM_TOR_INSERT";
	public static final String IN_PARAM_INSERT = "IN_PARAM_INSERT";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);

		// 对外担保信息表
		BopCfaExguDs bopCfaExguDs = (BopCfaExguDs) context
				.getAttribute(IN_PARAM_EXGU);
		// 担保人申请人
		BopExguTorDs bopExguTorDs = (BopExguTorDs) context
				.getAttribute(IN_PARAM_TOR);
		BopExguTorDsService serviceTor = BopExguTorDsService.getInstance();
		// 调用服务类
		BopCFAExguDsService serviceCFA = BopCFAExguDsService.getInstance();
		// 数据处理记录表
		ReportCommonService reportCommonService = ReportCommonService
				.getInstance();

		// 对外担保 update insert delete
		if (CMD_INSERT.equalsIgnoreCase(cmd)) {
			serviceCFA.save(bopCfaExguDs);
			serviceTor.save(bopExguTorDs);
			reportCommonService.saveBiDataProcessLog(bopCfaExguDs.getApptype(),
					bopCfaExguDs.getCurrentfile(), bopCfaExguDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"A-创建", "对外担保-签约信息        签约信息ID ：" + bopCfaExguDs.getId());
			reportCommonService.saveBiDataProcessLog(bopCfaExguDs.getApptype(),
					bopCfaExguDs.getCurrentfile(), bopCfaExguDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"A-创建",
					"对外担保-签约信息-担保申请人信息       签约信息ID ：" + bopCfaExguDs.getId()
							+ "    受益人或被担保人名称：" + bopExguTorDs.getTorName());
		}

		else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
			if (!(TopReportConstants.REPORT_RECSTATUS_02
					.equalsIgnoreCase(bopCfaExguDs.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01
					.equalsIgnoreCase(bopCfaExguDs.getRecStatus()))) {
				ExceptionUtil.throwCommonException("不能修改当前签约信息记录,当前记录状态为    "
						+ bopCfaExguDs.getRecStatus() + "");
			}

			serviceCFA.update(bopCfaExguDs);
			serviceTor.update(bopExguTorDs);

			reportCommonService.saveBiDataProcessLog(bopCfaExguDs.getApptype(),
					bopCfaExguDs.getCurrentfile(), bopCfaExguDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"C-修改",
					"更新对外担保-签约信息          签约信息ID ：" + bopCfaExguDs.getId());
			reportCommonService.saveBiDataProcessLog(bopCfaExguDs.getApptype(),
					bopCfaExguDs.getCurrentfile(), bopCfaExguDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"C-修改",
					"对外担保-签约信息-担保申请人信息       签约信息ID ：" + bopCfaExguDs.getId()
							+ "    受益人或被担保人名称：" + bopExguTorDs.getTorName());

		} else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
			if (!(TopReportConstants.REPORT_RECSTATUS_02
					.equalsIgnoreCase(bopCfaExguDs.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01
					.equalsIgnoreCase(bopCfaExguDs.getRecStatus()))) {
				ExceptionUtil.throwCommonException("不能删除当前签约信息记录,当前记录状态为    "
						+ bopCfaExguDs.getRecStatus() + "");
			}

			serviceCFA.update(bopCfaExguDs);
			reportCommonService.saveBiDataProcessLog(bopCfaExguDs.getApptype(),
					bopCfaExguDs.getCurrentfile(), bopCfaExguDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "D-删除",
					"删除对外担保-签约信息        签约信息ID ：" + bopCfaExguDs.getId());
			
		}

	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
