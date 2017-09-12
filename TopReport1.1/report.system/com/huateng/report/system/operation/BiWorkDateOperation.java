package com.huateng.report.system.operation;

import java.io.IOException;
import java.util.List;

import resource.bean.report.BiWorkdateConf;
import resource.bean.report.SysTaskInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.databak.service.ReportDataBakService;
import com.huateng.report.system.bean.CutoverWorkDateBean;
import com.huateng.report.system.service.BiWorkDateService;
import com.huateng.report.system.service.TaskListService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportEnum.REPORT_TASK_FUNCID;

public class BiWorkDateOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BiWorkDateOperation.class);
	public static final String ID = "system.BiWorkDateOperation";
	public static final String CMD = "CMD";
	public static final String OP_SAVE="OP_SAVE";
	public static final String OP_UPDATE_CUTOVERWORKDATE="OP_UPDATE_CUTOVERWORKDATE";
	public static final String OP_FAVT="OP_FAVT";
	public static final String IN_YEAE = "IN_YEAE";
	public static final String IN_FAVT = "IN_FAVT";
	public static final String IN_WORKDATE = "IN_WORKDATE";
	public static final String IN_CUTOVERWORKDATEBEAN = "IN_CUTOVERWORKDATEBEAN";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	//jianxue.zhang
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		if (OP_SAVE.equals(cmd)) {
			
			ROOTDAO rootdao= ROOTDAOUtils.getROOTDAO();
			String year = (String) context.getAttribute(IN_YEAE);
			List<String> workDateStrs = (List<String>) context.getAttribute(IN_WORKDATE);
			BiWorkdateConf biWorkdateConf = new BiWorkdateConf();
			biWorkdateConf.setWorkDateList(workDateStrs);
			biWorkdateConf.setId(year);
			biWorkdateConf.setDel(false);
			 TaskListService tls= TaskListService.getInstance();
				//不审核
				if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100599.value)){
					biWorkdateConf.setSt(ReportEnum.REPORT__FH_ST.YES.value);
					rootdao.saveOrUpdate(biWorkdateConf);
					BiWorkDateService.getInstance().updateWorkDate(year, workDateStrs);
					gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"工作日期维护"});
					
				}
				else{
			biWorkdateConf.setLock(true);
			//修改
			biWorkdateConf.setSt("2");
			String updCd= "02";
			String oldst="2";
			
			if(rootdao.query(BiWorkdateConf.class, year)== null){
				//新增
				biWorkdateConf.setSt("1");
				 updCd= "01";
				oldst="1";
				//新增时还要将数据保存到表中:
				BiWorkDateService.getInstance().updateWorkDate(year, workDateStrs);
			}
			//保存biworkdateconf表
			rootdao.saveOrUpdate(biWorkdateConf);

			try {
				SysTaskInfo syst=ReportTaskUtil.getSysTaskInfoBean(REPORT_TASK_FUNCID.TASK_100599.value, updCd, biWorkdateConf, year, oldst);
				rootdao.saveOrUpdate(syst);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}
			/*BiWorkDateService workDateService = BiWorkDateService.getInstance();
			workDateService.updateWorkDate(year, workDateStrs);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"修改工作日期维护"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"修改工作日期维护"});*/
		} else if (OP_UPDATE_CUTOVERWORKDATE.equals(cmd)) {
			//FIXME 业务数据备份
			try {
				String zipFilepath = ReportDataBakService.getInstance().createDataBakFile();
				htlog.info(zipFilepath);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("备份业务数据异常:"+e.getMessage());
			}

			CutoverWorkDateBean cutoverWorkDateBean = (CutoverWorkDateBean) context.getAttribute(IN_CUTOVERWORKDATEBEAN);
			BiWorkDateService workDateService = BiWorkDateService.getInstance();
			workDateService.updateCutoverWorkDate(cutoverWorkDateBean);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"切换工作日期操作"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"切换工作日期操作"});

		}else if(OP_FAVT.equals(cmd)){
			List<String> funcIds = (List<String>) context.getAttribute(IN_FAVT);
			ReportCommonService.getInstance().saveOrUpdateFavt(gi.getTlrno(),gi.getMenuCode(), funcIds);
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
