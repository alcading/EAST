package com.huateng.report.system.operation;

import java.io.IOException;
import java.util.Iterator;

import resource.bean.report.SysParams;
import resource.bean.report.SysTaskInfo;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.system.service.SysParamsService;
import com.huateng.report.system.service.TaskListService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;
/*
 * 系统参数操作类
 */
public class SysParamsOperation extends BaseOperation {
	private static final HtLog htlog=HtLogFactory.getLogger(SysParamsOperation.class);
	public final static String ID = "sysPramsOperation";
	public final static String CMD = "CMD";
	public final static String CMD_MOD = "CMD_MOD";
	public final static String IN_PARAM = "IN_PARAM";
	
    
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException{
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		SysParams sysParams = (SysParams) context.getAttribute(IN_PARAM);
		//调用服务类
		SysParamsService sysParamsService = SysParamsService.getInstance();
		if(CMD_MOD.equals(cmd)) {
			//调用服务类更新
			//将对象序列化写入SYS_TASK_INFO表中；
		    String pk = sysParams.getId().getParamId()+"#"+sysParams.getId().getParamgroupId();
		  
		  
		    TaskListService tls= TaskListService.getInstance();
			//不审核
			if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100799.value)){
				
				GlobalInfo  gi=GlobalInfo.getCurrentInstance();
				sysParams.setSt(ReportEnum.REPORT__FH_ST.YES.value);
				sysParamsService.mergeSysParamsEntity(sysParams);
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"系统参数修改"});
				
			}
			else{
				  Iterator it=   sysParamsService.selectByid(sysParams.getId().getParamgroupId(),sysParams.getId().getParamId());
		    while(it.hasNext()){
		    SysParams sys1=	(SysParams) it.next();
		    sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
		    sys1.setCrtDt(DateUtil.get8Date());
			   sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
			   sys1.setLastUpdTms(DateUtil.get14Date());
		    sys1.setLock(true);
		    sysParamsService.mergeSysParamsEntity(sys1);
		   
		    }
			//sysParamsService.mergeSysParamsEntity(sysParams);
			try {
			     
				SysTaskInfo taskInfo =  ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_100799.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, sysParams, pk, sysParams.getSt());
				
				sysParamsService.addTosystaskinfo(taskInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		GlobalInfo  gi=GlobalInfo.getCurrentInstance();
		gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行更新系统参数信息"});
		htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行更新系统参数信息"});
		}}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
