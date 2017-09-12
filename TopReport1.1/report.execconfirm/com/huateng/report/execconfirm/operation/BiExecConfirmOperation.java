package com.huateng.report.execconfirm.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import resource.bean.pub.Bctl;
import resource.bean.report.BiExecConfirm;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

public class BiExecConfirmOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BiExecConfirmOperation.class);
	public static final String ID = "execConfirm.BiExecConfirmOperation";
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
		String busiType = (String) context.getAttribute(IN_BUSITYPE);
		String appType = (String) context.getAttribute(IN_APPTYPE);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Bctl> bctls = BctlService.getInstance().getAllEnableBctl();
		List<String> brNoList = new ArrayList<String>();
		for(Bctl bc : bctls){
			brNoList.add(bc.getBrno());
		}
		String hql = " from BiExecConfirm model where model.id.busiType='" + busiType + "' and model.id.apptype='" + appType 
				+ "' and model.id.workDate='" + DateUtil.dateToNumber(gi.getTxdate()) 
				+ "' and model.id.brNo in" + ReportUtils.toInString(brNoList);
		List<BiExecConfirm> biExecConfrimList = rootdao.queryByQL2List(hql);
		if (cmd.equals(OP_LOCK)){
			for(BiExecConfirm biExec : biExecConfrimList){
				biExec.setSubfileStatus(TopReportConstants.REPORT_SUBFILE_STATUS_01);
				biExec.setSubfileTlrNo(gi.getTlrno());
				biExec.setSubfileTm(new Date());
				rootdao.saveOrUpdate(biExec);
			}
		} else {
			String subfileRemark = (String) context.getAttribute(IN_REMARK);
			for(BiExecConfirm biExec : biExecConfrimList){
				biExec.setSubfileStatus(TopReportConstants.REPORT_SUBFILE_STATUS_03);
				biExec.setSubfileTlrNo(gi.getTlrno());
				biExec.setSubfileTm(new Date());
				biExec.setSubfileRemark(subfileRemark);
				rootdao.saveOrUpdate(biExec);
			}
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
