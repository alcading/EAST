package com.huateng.report.operation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.bean.report.BiAnalyDetail;
import resource.bean.report.BiAnalyProcess;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.dataAnaly.util.ReportDataAnalyUtil;
import com.huateng.report.service.AnalyProService;

/*
 * 数据分析操作类
 */
public class AnalyseDataOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BaseOperation.class);
	public static final String ID = "analyseDataOperation";
	public static final String CMD = "CMD";
	public static final String CMD_ANALY = "CMD_AMALY";
	public static final String CMD_ANALY_DETAIL = "CMD_ANALY_DETAIL";
	public static final String WORK_DATE = "WORK_DATE";
	public static final String BUSI_TYPE = "BUSI_TYPE";
	public static final String APP_TYPE = "APP_TYPE";
	public static final String EXEC_TYPE = "EXEC_TYPE";

	public static final String ANALY_NO = "ANALY_NO";
	public static final String ANALY_DETAIL = "ANALY_DETAIL";
	public static final String TLR_NO = "TLR_NO";
	public static final String BR_NO = "BR_NO";
	public static final String RET_ANALY_DETAIL = "RET_ANALY_DETAIL";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		AnalyProService service = AnalyProService.getInstance();
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		String tlrno = (String) context.getAttribute(TLR_NO);
		String brNo = (String) context.getAttribute(BR_NO);
		String analyNo = (String) context.getAttribute(ANALY_NO);
		String workDate = (String) context.getAttribute(WORK_DATE);
		String busiType = (String) context.getAttribute(BUSI_TYPE);
		String appType = (String) context.getAttribute(APP_TYPE);
		// 放入参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(ReportDataAnalyUtil.PARAM_ANALY_ID, analyNo);
		paramMap.put(ReportDataAnalyUtil.PARAM_BUSI_TYPE, busiType);
		paramMap.put(ReportDataAnalyUtil.PARAM_APP_TYPE, appType);
		paramMap.put(ReportDataAnalyUtil.PARAM_WORK_DATE, workDate);
		paramMap.put(ReportDataAnalyUtil.PARAM_BR_NO, brNo);
		paramMap.put(ReportDataAnalyUtil.PARAM_TLR_NO, tlrno);

		// 执行写入分析明细
		if (CMD_ANALY_DETAIL.equals(cmd)) {
			// 写入分析记录
			BiAnalyProcess analyProcess = new BiAnalyProcess();
			analyProcess.setId(analyNo);
			analyProcess.setBusiType(busiType);
			analyProcess.setAppType(appType);
			analyProcess.setWorkDate(workDate);
			analyProcess.setBrNo(brNo);
			analyProcess.setOperTm(new Date());
			analyProcess.setOperTlr(tlrno);
			analyProcess.setExecuteTm(new Date());
			dao.save(analyProcess);
			// 根据配置创建分析明细
			List<BiAnalyDetail> detailList = service.createAnalyDetail(analyProcess, paramMap);
			context.setAttribute(RET_ANALY_DETAIL, detailList);

		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
