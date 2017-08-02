package com.huateng.report.operation;

import java.util.List;

import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bean.BopCFAExguTorAll;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopCFAExguDsService;
import com.huateng.report.service.BopExguTorDsService;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopExguDsOperation extends BaseOperation {
	public static final String ID = "BopExguDsOperation";
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

	//被担保人
	public static final String IN_PARAM_MOD_GUA = "IN_PARAM_MOD_GUA";
	public static final String IN_PARAM_DEL_GUA = "IN_PARAM_DEL_GUA";
	public static final String IN_PARAM_INSERT_GUA = "IN_PARAM_INSERT_GUA";

	//被担保人
	public static final String IN_PARAM_MOD_BEN = "IN_PARAM_MOD_BEN";
	public static final String IN_PARAM_DEL_BEN = "IN_PARAM_DEL_BEN";
	public static final String IN_PARAM_INSERT_BEN = "IN_PARAM_INSERT_BEN";

	public static final String IN_PARAM_CHECK_GUARANTOR = "IN_PARAM_CHECK_GUARANTOR";
	public static final String IN_PARAM_CHECK_BENEFICIARY = "IN_PARAM_CHECK_BENEFICIARY";


	public static final String IN_TOR = "IN_TOR";
	public static final String CMD_Tor_ADD = "CMD_Tor_ADD";
	public static final String CMD_Tor_MOD = "CMD_Tor_MOD";
	public static final String CMD_Tor_DEL = "CMD_Tor_DEL";

	public static final String IN_PARAM_EXGU = "IN_PARAM_EXGU";
	public static final String IN_PARAM_TOR = "IN_PARAM_TOR";




	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		String torAddCmd = (String) context.getAttribute(CMD_Tor_ADD);
		String torModCmd = (String) context.getAttribute(CMD_Tor_MOD);
		String torDelCmd = (String) context.getAttribute(CMD_Tor_DEL);

		// 对外担保信息表
		BopCfaExguDs bopCfaExguDs = (BopCfaExguDs) context.getAttribute(IN_PARAM_EXGU);
		// 担保人申请人
		BopExguTorDs bopExguTorDs = (BopExguTorDs) context.getAttribute(IN_PARAM_TOR);

		// 调用服务类
		BopCFAExguDsService serviceCFA = BopCFAExguDsService.getInstance();
		BopExguTorDsService serviceTor = BopExguTorDsService.getInstance();

		// 数据处理记录表
		ReportCommonService reportCommonService = ReportCommonService.getInstance();
		// 一个担保号 对应多个被担保人
		List<BopExguTorDs> insertTorGuaList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_INSERT_GUA);
		List<BopExguTorDs> modTorGuaList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_MOD_GUA);
		List<BopExguTorDs> delTorGuaList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_DEL_GUA);

		// 一个担保号 对应多个受益人
		List<BopExguTorDs> insertTorBenList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_INSERT_BEN);
		List<BopExguTorDs> modTorBenList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_MOD_BEN);
		List<BopExguTorDs> delTorBenList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_DEL_BEN);
		//添加页面验证
		if(!CMD_DELETE.equalsIgnoreCase(cmd)){
			BopCFAExguTorAll bop = new BopCFAExguTorAll();
			bop.setBopCfaExguDs(bopCfaExguDs);
			bop.setBopExguTorDs(bopExguTorDs);
			if(CMD_INSERT.equalsIgnoreCase(cmd)){

				List<BopExguTorDs> guarantorList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_CHECK_GUARANTOR);
				List<BopExguTorDs> beneficiaryList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_CHECK_BENEFICIARY);

				bop.setListBen(beneficiaryList);
				bop.setListGua(guarantorList);

//				bop.setListBen(insertTorBenList);
//				bop.setListGua(insertTorGuaList);
			}else if(CMD_UPDATE.equalsIgnoreCase(cmd)){

				List<BopExguTorDs> guarantorList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_CHECK_GUARANTOR);
				List<BopExguTorDs> beneficiaryList = (List<BopExguTorDs>) context.getAttribute(IN_PARAM_CHECK_BENEFICIARY);

				bop.setListBen(beneficiaryList);
				bop.setListGua(guarantorList);

//				bop.setListBen(modTorBenList);
//				bop.setListGua(modTorGuaList);
			}
			ReportDataVaildUtil.executeVaild(bop.getBopCfaExguDs().getApptype(), bop.getBopCfaExguDs().getCurrentfile(), bop);

		}

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
			//状态非01 02的不能删除
			if (!(TopReportConstants.REPORT_RECSTATUS_02
					.equalsIgnoreCase(bopCfaExguDs.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01
					.equalsIgnoreCase(bopCfaExguDs.getRecStatus()))) {
				ExceptionUtil.throwCommonException("不能删除当前签约信息记录,当前记录状态为    "
						+ bopCfaExguDs.getRecStatus() + "");
			}

			serviceCFA.update(bopCfaExguDs);
			//serviceTor.delete(bopExguTorDs.getId());
			reportCommonService.saveBiDataProcessLog(bopCfaExguDs.getApptype(),
					bopCfaExguDs.getCurrentfile(), bopCfaExguDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP,
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "D-删除",
					"删除对外担保-签约信息        签约信息ID ：" + bopCfaExguDs.getId());

		}

		// 被担保人员/受益人的 update insert delete
		if (CMD_INSERT.equalsIgnoreCase(torAddCmd)) {
			for (int i = 0; i < insertTorGuaList.size(); i++) {
				BopExguTorDs bopExguTorDsGua = insertTorGuaList.get(i);
				serviceTor.save(bopExguTorDsGua);
				reportCommonService
						.saveBiDataProcessLog(
								bopCfaExguDs.getApptype(),
								bopCfaExguDs.getCurrentfile(),
								bopCfaExguDs.getId(),
								TopReportConstants.REPORT_BUSITYPE_BOP,
								TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
								"A-创建",
								"对外担保-签约信息        签约信息ID ："
										+ bopCfaExguDs.getId()
										+ "被担保人名称："
										+ bopExguTorDs.getTorName());
			}
			for (int i = 0; i < insertTorBenList.size(); i++) {
				BopExguTorDs bopExguTorDsBen = insertTorBenList.get(i);
				serviceTor.save(bopExguTorDsBen);
				reportCommonService
						.saveBiDataProcessLog(
								bopCfaExguDs.getApptype(),
								bopCfaExguDs.getCurrentfile(),
								bopCfaExguDs.getId(),
								TopReportConstants.REPORT_BUSITYPE_BOP,
								TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
								"A-创建",
								"对外担保-签约信息        签约信息ID ："
										+ bopCfaExguDs.getId()
										+ "受益人名称："
										+ bopExguTorDs.getTorName());
			}
		}
		if (CMD_UPDATE.equalsIgnoreCase(torModCmd)) {
			for (int i = 0; i < modTorGuaList.size(); i++) {
				BopExguTorDs bopExguTorDsGua = modTorGuaList.get(i);
				serviceTor.update(bopExguTorDsGua);
				reportCommonService
						.saveBiDataProcessLog(
								bopCfaExguDs.getApptype(),
								bopCfaExguDs.getCurrentfile(),
								bopCfaExguDs.getId(),
								TopReportConstants.REPORT_BUSITYPE_BOP,
								TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
								"C-修改",
								"对外担保-签约信息        签约信息ID ："
										+ bopCfaExguDs.getId()
										+ "受益人或被担保人名称："
										+ bopExguTorDs.getTorName());
			}
			for (int i = 0; i < modTorBenList.size(); i++) {
				BopExguTorDs bopExguTorDsBen = modTorBenList.get(i);
				serviceTor.update(bopExguTorDsBen);
				reportCommonService
						.saveBiDataProcessLog(
								bopCfaExguDs.getApptype(),
								bopCfaExguDs.getCurrentfile(),
								bopCfaExguDs.getId(),
								TopReportConstants.REPORT_BUSITYPE_BOP,
								TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
								"C-修改",
								"对外担保-签约信息        签约信息ID ："
										+ bopCfaExguDs.getId()
										+ "受益人或被担保人名称："
										+ bopExguTorDs.getTorName());
			}
		}
		if (CMD_DELETE.equalsIgnoreCase(torDelCmd)) {
			for (int i = 0; i < delTorGuaList.size(); i++) {
				BopExguTorDs bopExguTorDsGua = delTorGuaList.get(i);
				serviceTor.delete(bopExguTorDsGua.getId());
				reportCommonService
						.saveBiDataProcessLog(
								bopCfaExguDs.getApptype(),
								bopCfaExguDs.getCurrentfile(),
								bopCfaExguDs.getId(),
								TopReportConstants.REPORT_BUSITYPE_BOP,
								TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
								"D-删除",
								"对外担保-签约信息        签约信息ID ："
										+ bopCfaExguDs.getId()
										+ "被担保人名称："
										+ bopExguTorDs.getTorName());
			}
			for (int i = 0; i < delTorBenList.size(); i++) {
				BopExguTorDs bopExguTorDsBen = delTorBenList.get(i);
				serviceTor.delete(bopExguTorDsBen.getId());
				reportCommonService
						.saveBiDataProcessLog(
								bopCfaExguDs.getApptype(),
								bopCfaExguDs.getCurrentfile(),
								bopCfaExguDs.getId(),
								TopReportConstants.REPORT_BUSITYPE_BOP,
								TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
								"D-删除",
								"对外担保-签约信息        签约信息ID ："
										+ bopCfaExguDs.getId()
										+ "受益人名称："
										+ bopExguTorDs.getTorName());
			}
		}
	}

	public void afterProc(OperationContext context) throws CommonException {
	}
}