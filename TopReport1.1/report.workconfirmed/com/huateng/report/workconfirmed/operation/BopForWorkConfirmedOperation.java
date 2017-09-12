package com.huateng.report.workconfirmed.operation;

import java.util.Date;
import java.util.List;

import resource.bean.report.BiExecConfirm;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.workconfirmed.service.BopForWorkConfirmedService;

public class BopForWorkConfirmedOperation extends BaseOperation {

	private static final HtLog htlog = HtLogFactory.getLogger(BopForWorkConfirmedOperation.class);
	 
	public static final String ID = "BopForWorkConfirmedOperation";
	public static final String CMD = "CMD";
	public static final String OP_LOCK="OP_LOCK";
	public static final String OP_UNLOCK = "OP_UNLOCK";
	public static final String IN_REMARK = "IN_REMARK";

	public static final String IN_BUSITYPE = "IN_BUSITYPE";
	public static final String IN_APPTYPE = "IN_APPTYPE";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		String confirmRemark = (String) context.getAttribute(IN_REMARK);
		String busiType = (String) context.getAttribute(IN_BUSITYPE);
		String appType = (String) context.getAttribute(IN_APPTYPE);
		
		BopForWorkConfirmedService bopService= BopForWorkConfirmedService.getInstance();
		
		if (cmd.equals(OP_LOCK)){
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			
			String hql = " from BiExecConfirm model where model.id.busiType='" + busiType + "' and model.id.apptype='" + appType + "' and model.id.workDate='" + 
					DateUtil.dateToNumber(gi.getTxdate()) + "' and model.id.brNo ='" + gi.getBrno()+"'";
		
			List<BiExecConfirm> biExecConfrimList = rootdao.queryByQL2List(hql);
			for(BiExecConfirm biExec : biExecConfrimList){
			
				biExec.setConfirmStatus(TopReportConstants.REPORT_CONFRIM_STATUS_01);
				biExec.setConfirmTlrNo(gi.getTlrno());
				biExec.setConfirmRemark(confirmRemark);
				biExec.setConfirmTm(new Date());
				bopService.doConfirmed(biExec);
			}
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行工作完成确认"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行工作完成确认"});
		} else {
			
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			
			String hql = " from BiExecConfirm model where model.id.busiType='" + busiType + "' and model.id.apptype='" + appType + "' and model.id.workDate='" + 
					DateUtil.dateToNumber(gi.getTxdate()) + "' and model.id.brNo ='" + gi.getBrno()+"'";
		
			List<BiExecConfirm> biExecConfrimList = rootdao.queryByQL2List(hql);
		
			for(BiExecConfirm biExec : biExecConfrimList){
				
				biExec.setConfirmStatus(TopReportConstants.REPORT_CONFRIM_STATUS_03);
				biExec.setConfirmTlrNo(gi.getTlrno());
				biExec.setConfirmRemark(confirmRemark);
				biExec.setConfirmTm(new Date());
				bopService.doConfirmed(biExec);
			}
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行工作完成取消确认，业务类型【" + busiType + "】应用类型【" + appType + "】"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行工作完成取消确认，业务类型【" + busiType + "】应用类型【" + appType + "】"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
