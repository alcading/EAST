package com.huateng.report.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import resource.bean.report.BopCfaExguDs;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;


public class BopCFAExguDsService {
	
	private static HtLog htLog = HtLogFactory.getLog(BopCfaCreditorDsService.class);
	private ROOTDAO rootDao ;
	

	/*
	 * 获取一个实例
	 * @param paramgroupId 参数段编号
	 */

	public static BopCFAExguDsService getInstance() {
		// TODO Auto-generated method stub
		return (BopCFAExguDsService)ApplicationContextUtils.getBean("BopCFAExguDsService");
	}
	
	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}
	
	
	
	public void delete(String id) throws CommonException {
		htLog.info("开始删除对外担保签约信息记录 ,表记录ID："+id);
		rootDao= ROOTDAOUtils.getROOTDAO();
		BopCfaExguDs bpInfo = (BopCfaExguDs) rootDao.query(BopCfaExguDs.class, id);

		if(null == bpInfo)
		{
			ExceptionUtil.throwCommonException("当前记录不存在！");
		}else
		    rootDao.delete(bpInfo.getClass(), id);
		
	}

	public void save(BopCfaExguDs bpInfo) throws CommonException {
		htLog.info("开始插入对外担保签约信息记录 ,表记录ID："+bpInfo.getId());
		rootDao= ROOTDAOUtils.getROOTDAO();
		BopCfaExguDs bpInfoTemp = (BopCfaExguDs) rootDao.query(BopCfaExguDs.class, (String)bpInfo.getId());

		if(null != bpInfoTemp)
		{
			ExceptionUtil.throwCommonException("当前记录已存在！");
		}else
			rootDao.save(bpInfo);

	}

	public void update(BopCfaExguDs bpInfo) throws CommonException {
		
		htLog.info("开始更新对外担保签约信息记录 ,表记录ID："+bpInfo.getId());
		rootDao= ROOTDAOUtils.getROOTDAO();

		rootDao.saveOrUpdate(bpInfo);

	}

	public BopCfaExguDs load(String RecId)  throws CommonException{
		// TODO Auto-generated method stub
		rootDao= ROOTDAOUtils.getROOTDAO();
		return (BopCfaExguDs)rootDao.query(BopCfaExguDs.class, RecId);
	}
	
	public  void  AuditBopCFAExguDs(String approveStatusChoose, String approveResultChoose, List<BopCfaExguDs> bopCfaExguDsList) throws CommonException{
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List<String> bopCfaExguDsIds = new ArrayList<String>();
		for(int i=0; i<bopCfaExguDsList.size(); i++){
			String id = bopCfaExguDsList.get(i).getId();
			bopCfaExguDsIds.add(id);
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from BopCfaExguDs model where model.id in" + ReportUtils.toInString(bopCfaExguDsIds);
		List<BopCfaExguDs> qbopCfaExguDsList = rootdao.queryByQL2List(hql);
		
		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}
		
		for (BopCfaExguDs bopCfaExguDs : qbopCfaExguDsList) {
			bopCfaExguDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExguDs.setLstUpdTm(new Date());
			bopCfaExguDs.setApproveResult(approveResultChoose);
			bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopCfaExguDs.setApproveStatus(approveStatusChoose);
			rootdao.saveOrUpdate(bopCfaExguDs);
			
			if(bopCfaExguDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopCfaExguDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCfaExguDs.getApptype(), bopCfaExguDs.getCurrentfile(), bopCfaExguDs.getId(), bopCfaExguDs.getExguarancode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, bopCfaExguDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCfaExguDs.getApptype(), bopCfaExguDs.getCurrentfile(), bopCfaExguDs.getId(), bopCfaExguDs.getExguarancode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}
		
		
		
		
	}
	}



}
	

	

