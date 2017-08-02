package com.huateng.report.service;

import java.util.Date;
import java.util.List;

import resource.bean.report.BopCfaFogucodeinfo;
import resource.bean.report.BopCfaLounexguDs;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BOPCfaLounexguRecordOperation;
import com.huateng.report.operation.BOPCfaLounexguRecordVerOperation;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BOPCfaLounexguRecordService {
	private static final String DATASET_ID = "BOPCfaLounexguRecordService";
	private static final HtLog htlog = HtLogFactory.getLogger(BOPCfaLounexguRecordService.class);

	public synchronized static BOPCfaLounexguRecordService getInstance(){
		return (BOPCfaLounexguRecordService)ApplicationContextUtils.getBean(DATASET_ID);
	}

	public PageQueryResult getPageList(int pageIndex,int pageSize,String hqlString) throws CommonException{
		htlog.info("-- begin  BOPCfaLounexguRecordService getPageList--");
		PageQueryCondition pc = new PageQueryCondition();
		pc.setPageIndex(pageIndex);
		pc.setPageSize(pageSize);
		pc.setQueryString(hqlString);
		HQLDAO hqlDao = DAOUtils.getHQLDAO();

		return hqlDao.pageQueryByQL(pc);
	}

	//保存
	public void updateOrSaveBean(BopCfaLounexguDs  bopCfaLounexguDs,List<BopCfaFogucodeinfo> insertList,List<BopCfaFogucodeinfo> updateList,List<BopCfaFogucodeinfo> delList,String type) throws CommonException{
		htlog.info("-- begin  BOPCfaLounexguRecordService saveBean--");
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if(BOPCfaLounexguRecordOperation.CMD_INSERT_CH.equals(type)){
			rootDao = ROOTDAOUtils.getROOTDAO();
			//保存前数据验证  add by 黄成
			ReportDataVaildUtil.executeVaild(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs);

			rootDao.save(bopCfaLounexguDs);
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs.getId(),
					bopCfaLounexguDs.getLounexgucode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "境外担保下境内贷款变动信息新增");
		}else if(BOPCfaLounexguRecordOperation.CMD_UPDATE_CH .equals(type)){
			htlog.info("-- begin  BOPCfaLounexguRecordService updateBean--");
			rootDao = ROOTDAOUtils.getROOTDAO();
			   //修改前数据验证  add by 黄成
			ReportDataVaildUtil.executeVaild(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs);

			rootDao.update(bopCfaLounexguDs);
			commonService.saveBiDataProcessLog(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs.getId(),
					bopCfaLounexguDs.getLounexgucode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "境外担保下境内贷款变动信息修改");
		}else if(BOPCfaLounexguRecordOperation.CMD_DELETE_CH .equals(type) ){
			htlog.info("-- begin  BOPCfaLounexguRecordService updateBean--");
			rootDao = ROOTDAOUtils.getROOTDAO();


			rootDao.update(bopCfaLounexguDs);
			commonService.saveBiDataProcessLog(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs.getId(),
					bopCfaLounexguDs.getLounexgucode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", "境外担保下境内贷款变动信息删除");
		}else {
			if(BOPCfaLounexguRecordOperation.CMD_INSERT.equals(type)){
				//保存前数据验证  add by 黄成
				ReportDataVaildUtil.executeVaild(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs);
				rootDao.save(bopCfaLounexguDs);
				commonService.saveBiDataProcessLog(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs.getId(),
						bopCfaLounexguDs.getLounexgucode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "境外担保下境内贷款签约信息新增");
			}else if(BOPCfaLounexguRecordOperation.CMD_UPDATE.equals(type)){
				//修改前数据验证  add by 黄成
				ReportDataVaildUtil.executeVaild(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs);

				rootDao.update(bopCfaLounexguDs);
				commonService.saveBiDataProcessLog(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs.getId(),
						bopCfaLounexguDs.getLounexgucode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "境外担保下境内贷款签约信息修改");
			}else if(BOPCfaLounexguRecordOperation.CMD_DELETE.equals(type)){
				rootDao.update(bopCfaLounexguDs);
				commonService.saveBiDataProcessLog(bopCfaLounexguDs.getApptype(), bopCfaLounexguDs.getCurrentfile(), bopCfaLounexguDs.getId(),
						bopCfaLounexguDs.getLounexgucode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", "境外担保下境内贷款签约信息删除");
			}

			for(BopCfaFogucodeinfo bopInsert : insertList){
				bopInsert.setCrtTm(new Date());
				bopInsert.setFogucodeinfoId(ReportUtils.getUUID());
				bopInsert.setRecId(bopCfaLounexguDs.getId());
				rootDao.save(bopInsert);
			}
			for(BopCfaFogucodeinfo bopUpdate : updateList){
				rootDao.update(bopUpdate);
			}
			for(BopCfaFogucodeinfo bopDel : delList){
				rootDao.delete(BopCfaFogucodeinfo.class, bopDel.getFogucodeinfoId());
			}
		}
	}

	/**
	 * 境外担保境内贷款签约信息审核
	 * @param list
	 * @param approveStatusChoose 回执状态
	 * @param approveResultChoose 回执结果
	 * @throws CommonException
	 */
	public void auditBean(List<BopCfaLounexguDs> list,String approveStatusChoose, String approveResultChoose,String type) throws CommonException{
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if(BOPCfaLounexguRecordVerOperation.CMD_AUDIT.equals(type)){
			for(BopCfaLounexguDs bopCfaLounexguDs : list){
				BopCfaLounexguDs dbBopCfaLounexguDs = rootDao.query(BopCfaLounexguDs.class, bopCfaLounexguDs.getId());
				dbBopCfaLounexguDs.setApproveStatus(approveStatusChoose);
				dbBopCfaLounexguDs.setApproveResult(approveResultChoose);
				dbBopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);

				dbBopCfaLounexguDs.setLstUpdTm(new Date());
				dbBopCfaLounexguDs.setLstUpdTlr(gi.getTlrno());
				rootDao.update(dbBopCfaLounexguDs);
				if(TopReportConstants.REPORT_APPROVESTATUS_01.equals(approveStatusChoose)){
					commonService.saveBiDataProcessLog(dbBopCfaLounexguDs.getApptype(), dbBopCfaLounexguDs.getCurrentfile(), dbBopCfaLounexguDs.getId(),
							TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "通过", "审核境外担保下境内贷款—签约信息     外债信息ID ："+bopCfaLounexguDs.getId());
				}else{
					commonService.saveBiDataProcessLog(dbBopCfaLounexguDs.getApptype(), dbBopCfaLounexguDs.getCurrentfile(), dbBopCfaLounexguDs.getId(),
							TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "不通过", "审核境外担保下境内贷款—签约信息     外债信息ID ："+bopCfaLounexguDs.getId());
				}

			}
		}else{
			for(BopCfaLounexguDs bopCfaLounexguDs : list){
				BopCfaLounexguDs dbBopCfaLounexguDs = rootDao.query(BopCfaLounexguDs.class, bopCfaLounexguDs.getId());
				dbBopCfaLounexguDs.setApproveStatus(approveStatusChoose);
				dbBopCfaLounexguDs.setApproveResult(approveResultChoose);
				dbBopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);

				dbBopCfaLounexguDs.setLstUpdTm(new Date());
				dbBopCfaLounexguDs.setLstUpdTlr(gi.getTlrno());
				rootDao.update(dbBopCfaLounexguDs);
				if(TopReportConstants.REPORT_APPROVESTATUS_01.equals(approveStatusChoose)){
					commonService.saveBiDataProcessLog(dbBopCfaLounexguDs.getApptype(), dbBopCfaLounexguDs.getCurrentfile(), dbBopCfaLounexguDs.getId(),
							TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "通过", "审核境外担保下境内贷款—变动信息     外债信息ID ："+bopCfaLounexguDs.getId());
				}else{
					commonService.saveBiDataProcessLog(dbBopCfaLounexguDs.getApptype(), dbBopCfaLounexguDs.getCurrentfile(), dbBopCfaLounexguDs.getId(),
							TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "不通过", "审核境外担保下境内贷款—变动信息    外债信息ID ："+bopCfaLounexguDs.getId());
				}

			}
		}
	}

	//更新
	public void updateBean(BopCfaLounexguDs bopCfaLounexguDs) throws CommonException{
		htlog.info("-- begin  BOPCfaLounexguRecordService updateBean--");
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		rootDao.update(bopCfaLounexguDs);
	}
}