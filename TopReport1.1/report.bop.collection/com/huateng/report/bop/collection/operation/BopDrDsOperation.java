package com.huateng.report.bop.collection.operation;

import resource.bean.report.MtsBopDrDs;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bop.collection.service.BopDrDsService;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;

public class BopDrDsOperation extends BaseOperation {
	public static final String ID = "BopDrDsOperation";
	public static final String CMD = "CMD";
	//传入操作类型
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM_DR = "IN_PARAM_DR";
	//传入文件类型
	public static final String BOP = "BOP";
	public static final String BOP_D = "BOP_D";
	public static final String BOP_R = "BOP_R";
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);	
		MtsBopDrDs mtsBopDrDs = (MtsBopDrDs) context.getAttribute(IN_PARAM_DR);
		// 调用服务
		BopDrDsService bopDrDsService = BopDrDsService.getInstance();
		// 数据处理记录服务
		ReportCommonService reportCommonService = ReportCommonService.getInstance();
		//判断是基础信息还是管理信息
		String currentfileMessage = null;
		String bop  =  (String) context.getAttribute(BOP);
		if(BOP_D.equalsIgnoreCase(bop)){
			currentfileMessage = "基础信息";
		}
		if(BOP_R.equalsIgnoreCase(bop)){
			currentfileMessage = "管理信息";
		}
		// 境内收入申报单 update insert delete
		if (CMD_INSERT.equalsIgnoreCase(cmd)) {		
			
			bopDrDsService.save(mtsBopDrDs,currentfileMessage);	
		//记录操作日志	
			reportCommonService.saveBiDataProcessLog(mtsBopDrDs.getApptype(),
					mtsBopDrDs.getCurrentfile(), mtsBopDrDs.getId(),
					mtsBopDrDs.getRptno(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"A-创建", "境内收入申报单-"+currentfileMessage+"  "+currentfileMessage+"ID ：" + mtsBopDrDs.getId());
		}

		else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
			//状态非01 02的不能修改 
			if (!(TopReportConstants.REPORT_RECSTATUS_02
					.equalsIgnoreCase(mtsBopDrDs.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01
					.equalsIgnoreCase(mtsBopDrDs.getRecStatus()))) {
				ExceptionUtil.throwCommonException("不能修改当前管理信息记录,当前记录状态为    "
						+ mtsBopDrDs.getRecStatus() + "");
			}
			
			bopDrDsService.update(mtsBopDrDs,currentfileMessage);
			//记录操作日志
			reportCommonService.saveBiDataProcessLog(mtsBopDrDs.getApptype(),
					mtsBopDrDs.getCurrentfile(), mtsBopDrDs.getId(),
					mtsBopDrDs.getRptno(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"C-修改",
					"更新境内收入申报单-"+currentfileMessage+"  "+currentfileMessage+"ID ：" + mtsBopDrDs.getId());

		} else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
			//状态非01 02的不能删除
			if (!(TopReportConstants.REPORT_RECSTATUS_02
					.equalsIgnoreCase(mtsBopDrDs.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01
					.equalsIgnoreCase(mtsBopDrDs.getRecStatus()))) {
				ExceptionUtil.throwCommonException("不能删除当前"+currentfileMessage+"记录,当前记录状态为    "
						+ mtsBopDrDs.getRecStatus() + "");
			}
           //状态改为删除状态
			bopDrDsService.delete(mtsBopDrDs, currentfileMessage);
			//记录日志
			reportCommonService.saveBiDataProcessLog(mtsBopDrDs.getApptype(),
					mtsBopDrDs.getCurrentfile(), mtsBopDrDs.getId(),
					mtsBopDrDs.getRptno(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "D-删除",
					"删除境内收入申报单"+currentfileMessage+"  "+currentfileMessage+"ID ：" + mtsBopDrDs.getId());	
		}
	}
	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
