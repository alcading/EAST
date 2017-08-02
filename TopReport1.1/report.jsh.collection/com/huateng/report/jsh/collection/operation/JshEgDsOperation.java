package com.huateng.report.jsh.collection.operation;

import resource.bean.report.MtsJshDefgDs;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.jsh.collection.service.JshEgDsService;
public class JshEgDsOperation extends BaseOperation {
	public static final String ID = "JshEgDsOperation";
	public static final String CMD = "CMD";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM_EG = "IN_PARAM_EG";
	//传入的文件类型
	public static final String CURRENT_TYPE = "CURRENT_TYPE";
	public static final String JSH_E = "JSH_E";
	public static final String JSH_G = "JSH_G";
	
	String message = null;

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
	}
	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		
		MtsJshDefgDs mtsJshDefgDs = (MtsJshDefgDs) context.getAttribute(IN_PARAM_EG);
		String currentype = (String) context.getAttribute(CURRENT_TYPE);
		// 调用服务类
		JshEgDsService jshDEgDsService = JshEgDsService.getInstance();
		// 数据处理记录服务
		ReportCommonService reportCommonService = ReportCommonService.getInstance();
			
		if(JSH_E.equalsIgnoreCase(currentype)){
			message ="基础信息";			
		}
		if(JSH_G.equalsIgnoreCase(currentype)){
			message ="管理信息";			
		}
		// 境内收入申报单 update insert delete
		if (CMD_INSERT.equalsIgnoreCase(cmd)) {
			
			jshDEgDsService.save(mtsJshDefgDs, message);
			
			reportCommonService.saveBiDataProcessLog(mtsJshDefgDs.getApptype(),
					mtsJshDefgDs.getCurrentfile(), mtsJshDefgDs.getId(),
					mtsJshDefgDs.getRptno(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"A-创建", "外汇账户内购汇-"+message+"  "+message+"ID ：" + mtsJshDefgDs.getId());		
		}

		else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
			if (!(TopReportConstants.REPORT_RECSTATUS_02
					.equalsIgnoreCase(mtsJshDefgDs.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01
					.equalsIgnoreCase(mtsJshDefgDs.getRecStatus()))) {
				ExceptionUtil.throwCommonException("不能修改当前基础信息记录,当前记录状态为    "
						+ mtsJshDefgDs.getRecStatus() + "");
			}
			
			jshDEgDsService.update(mtsJshDefgDs,message);
			
			reportCommonService.saveBiDataProcessLog(mtsJshDefgDs.getApptype(),
					mtsJshDefgDs.getCurrentfile(), mtsJshDefgDs.getId(),
					mtsJshDefgDs.getRptno(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"C-修改",
					"更新外汇账户内购汇-"+message+"  "+message+"ID ：" + mtsJshDefgDs.getId());
		} else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
			//状态非01 02的不能删除
			if (!(TopReportConstants.REPORT_RECSTATUS_02
					.equalsIgnoreCase(mtsJshDefgDs.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01
					.equalsIgnoreCase(mtsJshDefgDs.getRecStatus()))) {
				ExceptionUtil.throwCommonException("不能删除当前基础信息记录,当前记录状态为    "
						+ mtsJshDefgDs.getRecStatus() + "");
			}
			jshDEgDsService.delete(mtsJshDefgDs,message);
			
			reportCommonService.saveBiDataProcessLog(mtsJshDefgDs.getApptype(),
					mtsJshDefgDs.getCurrentfile(), mtsJshDefgDs.getId(),
					mtsJshDefgDs.getRptno(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"D-删除",
					"删除外汇账户内购汇-"+message+"  "+message+"ID ：" + mtsJshDefgDs.getId());
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
	}
}
