package com.huateng.report.system.operation;

import java.io.IOException;
import java.util.Iterator;

import resource.bean.report.SysTaskInfo;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.system.service.SysParamsService;
import com.huateng.report.system.service.TaskListService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

/**
 * @Description:
 * @Package: com.huateng.ebank.business.custadmin.operation
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class SecParameterOperation extends BaseOperation {

	public static final String ID = "Parameter.SecParameterOperation";
	public static final String IN_UPDATE = "IN_UPDATE";


	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
	 	 PfSysParam param =  (PfSysParam) context.getAttribute(IN_UPDATE);
		 SysParamsService secService = SysParamsService.getInstance();
			//调用服务类更新
			//将对象序列化写入SYS_TASK_INFO表中；
		    String pk = param.getId().getParamId()+"#"+param.getId().getMagicId();
		  
		    Iterator it= secService.selectID(param.getId().getMagicId(),param.getId().getParamId());
		    TaskListService tls= TaskListService.getInstance();
			//不审核
			if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100899.value)){
				GlobalInfo  gi=GlobalInfo.getCurrentInstance();
				param.setSt(ReportEnum.REPORT__FH_ST.YES.value);
				secService.savePfParam(param);
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"系统安全参数修改"});
				
			}
			else{
		    while(it.hasNext()){
		    GlobalInfo  gi=GlobalInfo.getCurrentInstance();
		    PfSysParam sys1=(PfSysParam) it.next();
		    sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
		    sys1.setLock(true);
		    secService.savePfParam(sys1);
		    gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"系统安全参数修改"});
		    }
			//sysParamsService.mergeSysParamsEntity(sysParams);
			try {   
				SysTaskInfo taskInfo =  ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_100899.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, param, pk, param.getSt());			
				secService.addTosystaskinfo(taskInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
}
