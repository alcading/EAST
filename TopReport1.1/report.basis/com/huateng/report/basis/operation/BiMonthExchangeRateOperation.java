package com.huateng.report.basis.operation;

import java.io.IOException;

import resource.bean.report.BiMonthexchangerate;
import resource.bean.report.SysTaskInfo;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.basis.service.BiMonthExchangeRateService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

public class BiMonthExchangeRateOperation extends BaseOperation{
	public static final String ID = "BiMonthExchangeRateOperation";
	public static final String CMD = "CMD";	
	public static final String IN_PARAM = "IN_PARAM";
	public final static String CMD_ADD = "CMD_ADD";
	public final static String CMD_MOD = "CMD_MOD";
	public final static String CMD_DEL = "CMD_DEL";
	private static final HtLog htlog=HtLogFactory.getLogger(BiMonthExchangeRateOperation.class);
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	 //author  by  计翔 2012.9.5
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		BiMonthexchangerate biMonthexchangerate = (BiMonthexchangerate) context.getAttribute(IN_PARAM);
		//调用服务类
		BiMonthExchangeRateService service = BiMonthExchangeRateService.getInstance();
		if(CMD_DEL.equals(cmd)) {
			//删除
			//service.removeEntity(biMonthexchangerate);
			 BiMonthexchangerate sys1=service.selectById(biMonthexchangerate.getId());
				//sysCurService.update(sysCurrency);
			 sys1.setSt(ReportEnum.REPORT_ST1.DE.value);
			   sys1.setCrtDt(DateUtil.get8Date());
			   sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
			   sys1.setLastUpdTms(DateUtil.get14Date());
			 sys1.setLock(true);
			 service.modEntity(sys1);
			 SysTaskInfo taskInfo;
				try {
					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110599.value, ReportEnum.REPORT_TASK_TRANS_CD.DEL.value, biMonthexchangerate, biMonthexchangerate.getId(), biMonthexchangerate.getSt());
					service.addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				GlobalInfo  gi=GlobalInfo.getCurrentInstance();
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇月牌的删除"});
				htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇月牌的删除"});
		} else if(CMD_ADD.equals(cmd)) {
			//插入或者更新
			//service.addEntity(biMonthexchangerate);
			biMonthexchangerate.setSt(ReportEnum.REPORT_ST1.CR.value);
			biMonthexchangerate.setCrtDt(DateUtil.get8Date());
			biMonthexchangerate.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
			biMonthexchangerate.setLastUpdTms(DateUtil.get14Date());
			biMonthexchangerate.setLock(true);		
			
			service.addEntity(biMonthexchangerate);
			 
			
			SysTaskInfo taskInfo;
			try {
				taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110599.value, ReportEnum.REPORT_TASK_TRANS_CD.NEW.value, biMonthexchangerate, biMonthexchangerate.getId(), biMonthexchangerate.getSt());
				service.addTosystaskinfo(taskInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			GlobalInfo  gi=GlobalInfo.getCurrentInstance();
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇月牌的增加"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇月牌的增加"});
		} else if(CMD_MOD.equals(cmd)) {
			//service.modEntity(biMonthexchangerate);
			 //Iterator  it=service.selectByid(biMonthexchangerate.getId());
			 BiMonthexchangerate sys1=service.selectById(biMonthexchangerate.getId());
				//sysCurService.update(sysCurrency);
			 sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
			 sys1.setCrtDt(DateUtil.get8Date());
			  sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
			   sys1.setLastUpdTms(DateUtil.get14Date());
			 sys1.setLock(true);
			 service.modEntity(sys1);
			
			 SysTaskInfo taskInfo;
				try {
					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110599.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, biMonthexchangerate, biMonthexchangerate.getId(), biMonthexchangerate.getSt());
					service.addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
		}
		GlobalInfo  gi=GlobalInfo.getCurrentInstance();
		gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇月牌的编辑"});
		htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇月牌的编辑"});
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
