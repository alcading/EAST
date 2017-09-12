package com.huateng.report.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.pub.Bctl;
import resource.bean.report.BiAnalyConf;
import resource.bean.report.BiAnalyDetail;
import resource.bean.report.BiAnalyDetailPars;
import resource.bean.report.BiAnalyProcess;
import resource.bean.report.BiProcessLog;
import resource.dao.pub.BctlDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.dataAnaly.util.ExecuteDataAnalysis;
import com.huateng.report.dataAnaly.util.ReportDataAnalyUtil;
import com.huateng.report.operation.AnalyseDataOperation;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

/*
 * 数据分析服务
 *
 */
public class AnalyProService {
	private static final HtLog htlog = HtLogFactory.getLogger(AnalyProService.class);
	/*
	 * 获取自身实例
	 */
	public synchronized static AnalyProService getInstance() {
		return (AnalyProService) ApplicationContextUtils.getBean(AnalyProService.class.getName());
	}

	/*
	 * 结果集查询 @param qworkDate,qbusiType
	 */
	public List queryByqworkDateAndqBusiType(String qworkDate, String qbusiType, String qappType)
			throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		StringBuffer hqlBuff = new StringBuffer();
		hqlBuff.append("from BiAnalyProcess biAnalyProcess where 1 = 1 ");
		if (qworkDate == null || qworkDate.trim().length() == 0) {
			qworkDate = DateUtil.dateToNumber(GlobalInfo.getCurrentInstance().getTxdate());
		}
		hqlBuff.append(" and biAnalyProcess.workDate= '" + qworkDate.trim() + "' ");
		if (StringUtils.isNotBlank(qbusiType)) {
			hqlBuff.append(" and biAnalyProcess.busiType ='" + qbusiType.trim() + "' ");
		}
		if (StringUtils.isNotBlank(qbusiType)) {
			hqlBuff.append(" and biAnalyProcess.appType ='" + qappType.trim() + "' ");
		}
		List<BiAnalyProcess> biAnalyProcessList = rootDAO.queryByQL2List(hqlBuff.toString());
		if (biAnalyProcessList == null) {
			biAnalyProcessList = new ArrayList<BiAnalyProcess>();
		}
		for (int i = 0; i < biAnalyProcessList.size(); i++) {
			BiAnalyProcess bi = biAnalyProcessList.get(i);
			// 根据分析明细计算分析状态
			String status = getDataAnalyProcessStatus(bi.getId());
			bi.setProcessStatus(status);
			// 根据分析明细计算分析结果
			bi.setProcessResult(getDataAnalyProcessResult(status, bi.getId()));

			bi.setDetailRemark(getDataAnalyProcessStatusByProg(bi.getId()));
		}


		if (biAnalyProcessList.size() == 0) {// 产生当前工作日分析任务
			String busiDate = DateUtil.dateToNumber(GlobalInfo.getCurrentInstance().getTxdate());
			if (qworkDate.equals(busiDate)) {
				BiAnalyProcess ap = new BiAnalyProcess();
				ap.setWorkDate(busiDate);
				ap.setBusiType(qbusiType);
				ap.setAppType(qappType);
				ap.setProcessStatus(ReportEnum.REPORT_ANALY_STAUS.NOEXEC.value);
				biAnalyProcessList.add(ap);
			}
		}
		return biAnalyProcessList;
	}

	public String getDataAnalyProcessStatusByProg(String processId) throws CommonException {
		StringBuffer status = new StringBuffer();
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		List list = rootDAO.queryByQL2List("select model.executeResult ,count(model) from BiAnalyDetail model where model.analyNo='" + processId + "' group by model.executeResult");
		if (list != null && list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				String sta = (String) obj[0];
				String count =  String.valueOf(obj[1]);
				status.append(ReportEnum.REPORT_ANALY_RESULT.valueof(sta)+":"+count+" ");
			}
		}
		return status.toString();
	}

	/**
	 * 获取执行结果
	 *
	 * @param status
	 * @param processId
	 * @return
	 * @throws CommonException
	 */
	public String getDataAnalyProcessResult(String status, String processId) throws CommonException {
		String result = null;
		if (!status.equals(ReportEnum.REPORT_ANALY_STAUS.NOEXEC.value)) {
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			List list = rootDAO.queryByQL2List(" from BiAnalyDetail model where model.analyNo='" + processId + "'");
			boolean bl = true;
			for (int i = 0; i < list.size(); i++) {
				BiAnalyDetail det = (BiAnalyDetail) list.get(i);
				if (det.getExecuteResult().equals(ReportEnum.REPORT_ANALY_RESULT.FAILD.value)
						|| det.getExecuteResult().equals(ReportEnum.REPORT_ANALY_RESULT.NOEXEC.value)) {
					result = ReportEnum.REPORT_ANALY_RESULT.FAILD.value;
					break;
				}
				if (det.getExecuteResult().equals(ReportEnum.REPORT_ANALY_RESULT.EXEC.value)) {
					bl = false;
				}
			}
			if (bl && result == null) {
				result = ReportEnum.REPORT_ANALY_RESULT.SUCCESS.value;
			}
		}
		return result;
	}

	/**
	 * 获取分析状态
	 *
	 * @param processId
	 * @return
	 * @throws CommonException
	 */
	public String getDataAnalyProcessStatus(String processId) throws CommonException {
		String status = null;
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		List list = rootDAO.queryByQL2List(" from BiAnalyDetail model where model.analyNo='" + processId + "'");
		if (list == null || list.size() == 0) {
			status = ReportEnum.REPORT_ANALY_STAUS.NOEXEC.value;
		} else {
			status = ReportEnum.REPORT_ANALY_STAUS.COMPLTE.value;
			for (int i = 0; i < list.size(); i++) {
				BiAnalyDetail det = (BiAnalyDetail) list.get(i);
				if (det.getExecSta().equals(ReportEnum.REPORT_ANALY_STAUS.EXEC.value)) {
					status = ReportEnum.REPORT_ANALY_STAUS.EXEC.value;
					break;
				}
			}

		}
		return status;
	}

	/*
	 * 根据机构号brno查询机构名称brname
	 *
	 */
	public String getBrName(String brno) throws CommonException {
		BctlDAO dao = ROOTDAOUtils.getBctlDAO();
		List<Bctl> list = null;
		if (StringUtils.isNotBlank(brno)) {
			list = dao.queryByCondition(" po.brno = " + brno.trim());
		}
		if (list.size() == 0) {
			return null;
		}
		return list.get(0).getBrname();
	}

	/*
	 *
	 * 根据应用类型和文件类型得到应用类型的中文(未完成，暂未启用该方法)
	 */
	public String getFileTypeName(String appType, String fileType) {
		if (StringUtils.isBlank(appType) || StringUtils.isBlank(fileType)) {
			return null;
		}

		return null;
	}

	public List queryByQL2List(String hql) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		return rootDAO.queryByQL2List(hql);
	}

	/**
	 * 判断机构、业务当前工作日期是否已执行分析
	 *
	 * @param qworkDate
	 * @param qbusiType
	 * @return
	 * @throws CommonException
	 */
	public boolean hasAnalysis1(String qworkDate, String qbusiType) throws CommonException {
		if (StringUtils.isBlank(qworkDate) || StringUtils.isBlank(qbusiType))
			throw new NullPointerException();
		String hql = "select count(model) from BiAnalyProcess model where 1 = 1 ";
		hql += " and model.workDate = '" + qworkDate + "' ";
		hql += " and model.busiType = '" + qbusiType + "' ";
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		int count = rootDAO.queryByHqlToCount(hql);
		if (count > 0) {
			return true;
		}
		return false;
	}

	public BiAnalyProcess getBiAnalyProcessByTypeAndWorkDate(String qworkDate, String qbusiType) throws CommonException {
		String hql = "from BiAnalyProcess process where process.workDate = '" + qworkDate
				+ "' and process.busiType = '" + qbusiType + "'";
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		List list = rootDAO.queryByQL2List(hql);
		if (list.size() == 1) {
			return (BiAnalyProcess) list.get(0);
		}
		return null;
	}

	/*
	 * 看数据分析配置中是否已有 有效的配置
	 */
	public boolean hasVaildAnalyDataConf(String busiType) throws CommonException {
		ReportCommonService service = ReportCommonService.getInstance();
		List list = service.getDataAnaly(busiType);
		if (list.size() == 0) {
			return false;
		}
		return true;
	}

	/*
	 * 数据分析写入结果明细表服务
	 *
	 */
	public void analyDataAndInsertResultRecode(BiAnalyDetail detail) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		rootDAO.save(detail);
	}

	public BiAnalyProcess getBiAnalyProcessByPk(String analyNo) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		BiAnalyProcess bi = (BiAnalyProcess) rootDAO.query(BiAnalyProcess.class, analyNo);
		if (bi!=null) {
			bi.setDetailRemark(getDataAnalyProcessStatusByProg(bi.getId()));
		}
		return bi;
	}

	public PageQueryResult getAnalyProcessDetail(PageQueryCondition queryCondition, Map map) throws CommonException {
		String analyNo = (String) map.get("analyNo");
		StringBuffer isWhere = new StringBuffer(" from BiAnalyDetail model where model.analyNo='" + analyNo + "' order by model.confSeq");
		queryCondition.setQueryString(isWhere.toString());
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		PageQueryResult queryresult = rootdao.pageQueryByQL(queryCondition);
		return queryresult;
	}

	public List getAnalyProcessDetailBySta(String analyNo) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuffer isWhere = new StringBuffer(" from BiAnalyDetail model where model.analyNo='" + analyNo + "'");
		isWhere.append(" and model.execSta='" + ReportEnum.REPORT_ANALY_STAUS.NOEXEC.value + "' or model.executeResult='"
				+ ReportEnum.REPORT_ANALY_RESULT.NOEXEC.value + "' or model.executeResult='"+ReportEnum.REPORT_ANALY_RESULT.FAILD.value+"' order by model.confSeq");
		List list = dao.queryByQL2List(isWhere.toString());
		return list;
	}

	public List getAnalyDetailParList(String detId)throws CommonException{
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List parList = dao.queryByQL2List(" from BiAnalyDetailPars model where model.detId='" + detId+ "' order by model.parSeq");
		return parList;
	}

	public List<BiAnalyDetail> createAnalyDetail(BiAnalyProcess analyProcess, Map<String, String> paramMap)
			throws CommonException {
		List<BiAnalyDetail> detailList = new ArrayList<BiAnalyDetail>();
		StringBuffer sql = new StringBuffer();
		sql.append(" from BiAnalyConf model where model.busiType='" + analyProcess.getBusiType() + "'");
		sql.append(" and model.appType='" + analyProcess.getAppType() + "'");
		sql.append(" and model.confVaild='" + ReportEnum.REPORT_VAILD.YES.value + "'");
		sql.append(" order by model.confSeq");
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List list = dao.queryByQL2List(sql.toString());
		for (int i = 0; i < list.size(); i++) {
			BiAnalyConf conf = (BiAnalyConf) list.get(i);
			BiAnalyDetail det = ReportDataAnalyUtil.analyConfToDetail(analyProcess, conf, paramMap);
			detailList.add(det);
			dao.save(det);
			for (int j = 0; j < det.getParsList().size(); j++) {
				BiAnalyDetailPars detPar = det.getParsList().get(j);
				dao.save(detPar);
			}
		}
		return detailList;
	}

	public Object[] getBiAnalyDetailList(Object analyNo,String workDate,String busiType,String appType,String execType,String tlrNo,String brNO) throws CommonException{
		Object[] objs = new Object[2];
		//查询分析并写入明细
		List analyDetList = null;
		if (analyNo!=null && analyNo.toString().trim().length()>0) {//已执行分析，查询分析错误信息重新执行
			String status = getDataAnalyProcessStatus(analyNo.toString());
			if (status==null||status.equals(ReportEnum.REPORT_ANALY_STAUS.EXEC.value)) {//执行中
				ExceptionUtil.throwCommonException("数据分析正在执行，不能进行操作!");
			}
			String result = getDataAnalyProcessResult(status,analyNo.toString());
			if (result==null || result.equals(ReportEnum.REPORT_ANALY_RESULT.SUCCESS.value)) {
				ExceptionUtil.throwCommonException("数据分析正在执行或已正确执行，不能进行操作!");
			}
			analyDetList = getAnalyProcessDetailBySta(analyNo.toString());
		}else{
			//创建分析明细并开始执行
			analyNo = ReportUtils.getUUID();
			OperationContext context = new OperationContext();
			context.setAttribute(AnalyseDataOperation.WORK_DATE, workDate);
			context.setAttribute(AnalyseDataOperation.BUSI_TYPE, busiType);
			context.setAttribute(AnalyseDataOperation.APP_TYPE, appType);
			context.setAttribute(AnalyseDataOperation.EXEC_TYPE, TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU);
			context.setAttribute(AnalyseDataOperation.ANALY_NO, analyNo.toString());
			context.setAttribute(AnalyseDataOperation.TLR_NO, tlrNo);
			context.setAttribute(AnalyseDataOperation.BR_NO, brNO);
			context.setAttribute(AnalyseDataOperation.CMD, AnalyseDataOperation.CMD_ANALY_DETAIL);
			OPCaller.call(AnalyseDataOperation.ID, context);

			analyDetList = (List) context.getAttribute(AnalyseDataOperation.RET_ANALY_DETAIL);
		}
		objs[0] = analyNo;
		objs[1] = analyDetList;
		return objs;
	}

	/**
	 * 执行数据分析
	 * @param execType 执行类型
	 * @param analyNo 分析号
	 * @param detailList 分析明细
	 * @throws CommonException
	 */
	public String executeAnalyDetail(String workDate,String busiType,String appType,String execType,Object analyNo) throws CommonException {
		GlobalInfo globalInfo = null;
		String tlrno = null;
		String brNo = null;
		if (execType.equals(TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU)) {
			// 获得当前操作人
			globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
			tlrno = globalInfo.getTlrno().trim();
			brNo = globalInfo.getBrno().trim();
		}else if(execType.equals(TopReportConstants.REPORT_PROCESS_OPERTYPE_TIME)){
			tlrno = "-1";
			brNo = ReportUtils.getSysParamsValue("SUB", "BOP","-1");
		}
		Object[] objs = getBiAnalyDetailList(analyNo, workDate, busiType, appType, execType,tlrno,brNo);
		String newAnalyNo = objs[0].toString();
		List<BiAnalyDetail> analyDetList = (List<BiAnalyDetail>) objs[1];
		if (analyDetList==null || analyDetList.size()==0) {
			ExceptionUtil.throwCommonException("没有可执行的数据分析配置!");
		}
		Date startdate = new Date();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		BiAnalyProcess process = getBiAnalyProcessByPk(newAnalyNo);
		process.setExecuteTm(new Date());
		rootdao.saveOrUpdate(process);
		for (int i = 0; i < analyDetList.size(); i++) {
			BiAnalyDetail detail = (BiAnalyDetail) analyDetList.get(i);
			String confId = detail.getConfId();
			BiAnalyConf conf = rootdao.query(BiAnalyConf.class, confId);
			String isNext = conf.getErrIsNext();
			String startTm = DateUtil.getCurrentDate("yy-MM-dd hh:mm:ss");
			detail.setStartTm(startTm);
			detail.setExecSta(ReportEnum.REPORT_ANALY_STAUS.EXEC.value);
			detail.setExecuteResult(ReportEnum.REPORT_ANALY_RESULT.EXEC.value);
			detail.setExecRemark("");
			detail=(BiAnalyDetail) rootdao.saveOrUpdate(detail);
			String exRet = null;
			try {
				ExecuteDataAnalysis.execute(detail);
				exRet = ReportEnum.REPORT_ANALY_RESULT.SUCCESS.value;
			} catch (Exception e) {
				exRet = ReportEnum.REPORT_ANALY_RESULT.FAILD.value;
				htlog.error(e.getMessage());
				e.printStackTrace();
				detail.setExecRemark(e.getMessage());
			}finally{
				detail.setEndTm(DateUtil.getCurrentDate("yy-MM-dd hh:mm:ss"));
				detail.setExecSta(ReportEnum.REPORT_ANALY_STAUS.COMPLTE.value);
				detail.setExecuteResult(exRet);
				rootdao.saveOrUpdate(detail);
				if (detail.getExecuteResult().equals(ReportEnum.REPORT_ANALY_RESULT.FAILD.value)) {
					//执行异常是否继续执行
					if (isNext==null || isNext.equalsIgnoreCase(ReportEnum.REPORT_IS_STR.NO.value)) {
						break;
					}else if(isNext!=null && isNext.equalsIgnoreCase(ReportEnum.REPORT_IS_STR.YES.value)){
						continue;
					}
				}
			}
		}
		Date enddate = new Date();
		if (globalInfo!=null) {
			// 记录日志
			ReportCommonService.getInstance().saveBiProcessLog(process.getWorkDate(), process.getBusiType(), brNo, process.getAppType(),
					TopReportConstants.REPORT_PROCESS_EXECTYPE_ANALY, startdate,
					enddate, execType);
			globalInfo.addBizLog("Updater.log", new String[]{tlrno, brNo, "执行数据分析，业务-应用类型【"+process.getBusiType()+"-"+process.getAppType()+"】"});
		}else{
			// 写入操作日志
			BiProcessLog biProcessLog = new BiProcessLog();
			biProcessLog.setBrNo(brNo);
			biProcessLog.setBusiType(TopReportConstants.REPORT_BUSITYPE_BOP);
			biProcessLog.setEndTm(startdate);
			biProcessLog.setExecuteId(tlrno);
			biProcessLog.setExecuteTm(new Date());
			biProcessLog.setExecuteType(TopReportConstants.REPORT_PROCESS_EXECTYPE_ANALY);
			biProcessLog.setId(ReportUtils.getUUID());
			biProcessLog.setOperType(execType);
			biProcessLog.setStartTm(enddate);
			biProcessLog.setWorkDate(DateUtil.dateToNumber(DateUtil.getTbsDay()));
			biProcessLog.setIp("server");
			rootdao.save(biProcessLog);
		}
		htlog.info("Updater.log", new String[]{tlrno, brNo, "执行数据分析，业务-应用类型【"+process.getBusiType()+"-"+process.getAppType()+"】"});
		return newAnalyNo;
	}


}
