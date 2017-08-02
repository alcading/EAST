package com.huateng.report.operation;

import java.util.List;

import resource.bean.report.BopCfaFogucodeinfo;
import resource.bean.report.BopCfaLounexguDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.service.BOPCfaLounexguRecordService;

public class BOPCfaLounexguRecordOperation extends BaseOperation{

	private static final HtLog htlog = HtLogFactory.getLogger(BopForDebtYinTuanOperation.class);
	public static final String ID="BOPCfaLounexguRecordOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";

	public static final String CMD_INSERT_CH = "CMD_INSERT_CH";
	public static final String CMD_UPDATE_CH = "CMD_UPDATE_CH";
	public static final String CMD_DELETE_CH = "CMD_DELETE_CH";


	public static final String INSERT_LIST= "INSERT_LIST";
	public static final String UPDATE_LIST = "UPDATE_LIST";
	public static final String DEL_LIST = "DEL_LIST";

	public static final String CHECK_LIST = "CHECK_LIST";

	public static final String IN_PARAM = "IN_PARAM";

	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		BopCfaLounexguDs bopCfaLounexguDs = (BopCfaLounexguDs) context.getAttribute(IN_PARAM);
		BOPCfaLounexguRecordService  bopLounexguRecordService = BOPCfaLounexguRecordService.getInstance();
		List<BopCfaFogucodeinfo> insertList = (List<BopCfaFogucodeinfo>) context.getAttribute(INSERT_LIST);
		List<BopCfaFogucodeinfo> updateList =(List<BopCfaFogucodeinfo>) context.getAttribute(UPDATE_LIST);
		List<BopCfaFogucodeinfo> delList = (List<BopCfaFogucodeinfo>) context.getAttribute(DEL_LIST);


		if(CMD_INSERT.equals(cmd)){
			bopCfaLounexguDs.setFogucodeinfos(insertList);
			bopLounexguRecordService.updateOrSaveBean(bopCfaLounexguDs, insertList, updateList, delList, CMD_INSERT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款签约信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款签约信息新增"});
		}else if(CMD_UPDATE.equals(cmd)){

			List<BopCfaFogucodeinfo> checkList = (List<BopCfaFogucodeinfo>) context.getAttribute(CHECK_LIST);
			bopCfaLounexguDs.setFogucodeinfos(checkList);
			bopLounexguRecordService.updateOrSaveBean(bopCfaLounexguDs, insertList, updateList, delList, CMD_UPDATE);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款签约信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款签约信息修改"});
		}else if(CMD_DELETE.equals(cmd)){
			bopLounexguRecordService.updateOrSaveBean(bopCfaLounexguDs, insertList, updateList, delList, CMD_DELETE);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款签约信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款签约信息删除"});
		}else if(CMD_INSERT_CH.equals(cmd)){
			bopLounexguRecordService.updateOrSaveBean(bopCfaLounexguDs, null, null, null, CMD_INSERT_CH);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款变动信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款变动信息新增"});
		}else if(CMD_UPDATE_CH.equals(cmd)){
			bopLounexguRecordService.updateOrSaveBean(bopCfaLounexguDs, null, null, null, CMD_UPDATE_CH);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款变动信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款变动信息修改"});
		}else if(CMD_DELETE_CH.equals(cmd)){
			bopLounexguRecordService.updateOrSaveBean(bopCfaLounexguDs, null, null, null, CMD_DELETE_CH);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款变动信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外担保项下境内贷款变动信息删除"});
		}
	}

	public void afterProc(OperationContext context) throws CommonException {
	}
}