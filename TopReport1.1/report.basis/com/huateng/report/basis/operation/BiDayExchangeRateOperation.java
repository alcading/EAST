package com.huateng.report.basis.operation;

import java.io.IOException;
import java.util.Iterator;

import resource.bean.report.BiDayexchangerate;
import resource.bean.report.SysTaskInfo;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.basis.service.BiDayExchangeRateService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

public class BiDayExchangeRateOperation extends BaseOperation{
	public static final String ID = "BiDayExchangeRateOperation";
	public static final String CMD = "CMD";	
	public static final String IN_PARAM = "IN_PARAM";
	public final static String CMD_ADD = "CMD_ADD";
	public final static String CMD_MOD = "CMD_MOD";
	public final static String CMD_DEL = "CMD_DEL";
	private static final HtLog htlog=HtLogFactory.getLogger(BiDayExchangeRateOperation.class);

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override 
	//author  by  计翔 2012.9.5
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		BiDayexchangerate biDayexchangerate = (BiDayexchangerate) context.getAttribute(IN_PARAM);
		//调用服务类
		
		
		
		 
		BiDayExchangeRateService service = BiDayExchangeRateService.getInstance();
		if(CMD_DEL.equals(cmd)) {
			//删除
			//service.removeEntity(biDayexchangerate);
			
			Iterator  it=service.selectByid(biDayexchangerate.getId());
			
			 while(it.hasNext()){
				 BiDayexchangerate sys1=(BiDayexchangerate)it.next();
				  sys1.setSt(ReportEnum.REPORT_ST1.DE.value);
				   sys1.setCrtDt(DateUtil.get8Date());
				   sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
				   sys1.setLastUpdTms(DateUtil.get14Date());
				  sys1.setLock(true);
				  
				  service.modEntity(sys1);
				  
			 }
			 SysTaskInfo taskInfo;
				try {
					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110699.value, ReportEnum.REPORT_TASK_TRANS_CD.DEL.value, biDayexchangerate, biDayexchangerate.getId(), biDayexchangerate.getSt());
					service.addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				GlobalInfo  gi=GlobalInfo.getCurrentInstance();
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇日牌的删除"});
				htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇日牌的删除"});
		} else if(CMD_ADD.equals(cmd)) {
			//插入或者更新
			//service.addEntity(biDayexchangerate);
			//biDayexchangerate.setSt("1");
			biDayexchangerate.setSt(ReportEnum.REPORT_ST1.CR.value);
			biDayexchangerate.setLock(true);		
			biDayexchangerate.setCrtDt(DateUtil.get8Date());
			biDayexchangerate.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
			biDayexchangerate.setLastUpdTms(DateUtil.get14Date());
			service.addEntity(biDayexchangerate);
			 
			
			SysTaskInfo taskInfo;
			try {
				taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110699.value, ReportEnum.REPORT_TASK_TRANS_CD.NEW.value, biDayexchangerate, biDayexchangerate.getId(), biDayexchangerate.getSt());
				service.addTosystaskinfo(taskInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			GlobalInfo  gi=GlobalInfo.getCurrentInstance();
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇日牌的增加"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇日牌的增加"});
		} else if(CMD_MOD.equals(cmd)) {
			//service.modEntity(biDayexchangerate);
			 Iterator  it=service.selectByid(biDayexchangerate.getId());
				//sysCurService.update(sysCurrency);
			 while(it.hasNext()){
				 BiDayexchangerate sys1=(BiDayexchangerate)it.next();
				  //sys1.setSt("2");
				  sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
				  sys1.setCrtDt(DateUtil.get8Date());
				   sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
				   sys1.setLastUpdTms(DateUtil.get14Date());
				  sys1.setLock(true);
				  service.modEntity(sys1);
				  
			 }
			 SysTaskInfo taskInfo;
				try {
					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_110699.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, biDayexchangerate, biDayexchangerate.getId(), biDayexchangerate.getSt());
					service.addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
		}
		GlobalInfo  gi=GlobalInfo.getCurrentInstance();
		gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇日牌的编辑"});
		htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇日牌的编辑"});
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
