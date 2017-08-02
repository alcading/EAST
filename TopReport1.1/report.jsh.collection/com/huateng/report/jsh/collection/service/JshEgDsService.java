package com.huateng.report.jsh.collection.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsJshDefgDs;
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
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class JshEgDsService {
	public static final String JSH_E = "基础信息";
	public static final String JSH_G = "管理信息";
	private static HtLog htLog = HtLogFactory.getLog(JshEgDsService.class);
	private ROOTDAO rootDao ;
	GlobalInfo globalInfo = null;

	/**
	 * 获取一个实例
	 */			
	public static JshEgDsService getInstance() {
		// TODO Auto-generated method stub
		return (JshEgDsService)ApplicationContextUtils.getBean(JshEgDsService.class.getName());
	}
	
	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}
	
	/**
	 * 删除
	 * @param mtsJshDefgDs 待删除的实体
	 * @param message 待删除的文件类型
	 */
	//逻辑删除  把状态改为删除状态
	public void delete(MtsJshDefgDs mtsJshDefgDs , String currentFile) throws CommonException {
		globalInfo  = GlobalInfo.getCurrentInstance();
		rootDao= ROOTDAOUtils.getROOTDAO();
		/**
		 * 操作状态=D-删除 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
		 * 是否已成功上报=不变化
		 */
		
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		mtsJshDefgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_E);
        //删除的时间 机构号 和 人员
		mtsJshDefgDs.setLstUpdTlr(gInfo.getTlrno());
		mtsJshDefgDs.setLstUpdTm(new Date());
		mtsJshDefgDs.setBrNo(gInfo.getBrno());

		mtsJshDefgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		mtsJshDefgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		mtsJshDefgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		mtsJshDefgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		if(StringUtils.equals(currentFile, JSH_E)){
			mtsJshDefgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_E);
		}
		if(StringUtils.equals(currentFile, JSH_G)){
			mtsJshDefgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_G);
		}
		/**判断基础信息是否绑定了管理信息  begin*/
		this.isCanDelete(mtsJshDefgDs);
		/**判断基础信息是否绑定了管理信息  end*/
		rootDao.saveOrUpdate(mtsJshDefgDs);
		htLog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"外汇账户内购汇"+currentFile+"删除"});		
	}
	
	/**
	 * 保存
	 * @param mtsJshDefgDs 待保存的实体
	 * @param message 待保存的文件类型
	 */	
	public void save(MtsJshDefgDs mtsJshDefgDs , String message) throws CommonException {
		globalInfo  = GlobalInfo.getCurrentInstance();
		rootDao= ROOTDAOUtils.getROOTDAO();
		MtsJshDefgDs mdTemp = (MtsJshDefgDs) rootDao.query(MtsJshDefgDs.class, (String)mtsJshDefgDs.getId());
		if(null != mdTemp)
		{
			ExceptionUtil.throwCommonException("当前记录已存在！");
		}else{
			MtsJshDefgDs mts = JshEgInsertSetValues(mtsJshDefgDs,message);
			//数据验证
			ReportDataVaildUtil.executeVaild(mts.getApptype(), mts.getCurrentfile(), mts);
			rootDao.save(mtsJshDefgDs);
			htLog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"外汇账户内购汇"+message+"保存"});	
			}
	}
	/**
	 * 保存前给实体设置值
	 * @param mtsJshDefgDs 待保存的实体
	 * @param message 待保存的文件类型
	 */	
	private MtsJshDefgDs JshEgInsertSetValues(MtsJshDefgDs mtsJshDefgDs , String currentFile) throws CommonException{
		/**
		 * 操作状态=A-创建 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
		 * 是否已成功上报=0-否
		 */
		globalInfo = GlobalInfo.getCurrentInstance();
		String guid = ReportUtils.getUUID();
		//基础信息
		mtsJshDefgDs.setId(guid);
		mtsJshDefgDs.setCrtTm(new Date());
		mtsJshDefgDs.setLstUpdTm(new Date());
		mtsJshDefgDs.setLstUpdTlr(globalInfo.getTlrno());
		mtsJshDefgDs.setBrNo(globalInfo.getBrno());
		mtsJshDefgDs.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));

		mtsJshDefgDs.setApptype(TopReportConstants.REPORT_APP_TYPE_JSH);
		
		mtsJshDefgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		mtsJshDefgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		mtsJshDefgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		mtsJshDefgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		mtsJshDefgDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		if(StringUtils.equals(currentFile, JSH_E)){
			mtsJshDefgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_E);
		}
		if(StringUtils.equals(currentFile, JSH_G)){
			mtsJshDefgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_G);
		}
		return mtsJshDefgDs;
		
	}
	/**
	 * 更新
	 * @param mtsJshDefgDs 待更新的实体
	 * @param message 待更新的文件类型
	 */	
	public void update(MtsJshDefgDs mtsJshDefgDs , String message) throws CommonException {
		globalInfo  = GlobalInfo.getCurrentInstance();
		rootDao= ROOTDAOUtils.getROOTDAO();
		MtsJshDefgDs mts = JshEgUpdateSetValues(mtsJshDefgDs,message);
		//数据验证
		ReportDataVaildUtil.executeVaild(mts.getApptype(), mts.getCurrentfile(), mts);
		rootDao.saveOrUpdate(mts);
		htLog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"外汇账户内购汇"+message+"修改"});	
	}
	
	private MtsJshDefgDs  JshEgUpdateSetValues(MtsJshDefgDs mtsJshDefgDs , String currentFile) throws CommonException{
	    globalInfo = GlobalInfo.getCurrentInstance();
	    rootDao= ROOTDAOUtils.getROOTDAO();
	    MtsJshDefgDs  mtsJshDefgDsQuery = rootDao.query(MtsJshDefgDs.class, mtsJshDefgDs.getId());
	    if(!StringUtils.equals(mtsJshDefgDsQuery.getRecStatus(), mtsJshDefgDs.getRecStatus())){
	    	ExceptionUtil.throwCommonException("JSH交易["+mtsJshDefgDsQuery.getBuscode()+"]已经被其他用户修改");
	    }
	    rootDao.getHibernateTemplate().evict(mtsJshDefgDsQuery);
		if (!StringUtils.isEmpty(mtsJshDefgDs.getSubSuccess())
				&& TopReportConstants.REPORT_IS_SUB_SUCCESS_YES.equalsIgnoreCase(mtsJshDefgDs.getSubSuccess())) {
			/**
			 * 上报已成功
			 * 操作状态=C-修改 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
			 * 是否已成功上报=不变化
			 */
			
			mtsJshDefgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
		}
		else if (!StringUtils.isEmpty(mtsJshDefgDs.getSubSuccess())
				&& TopReportConstants.REPORT_IS_SUB_SUCCESS_NO.equalsIgnoreCase(mtsJshDefgDs.getSubSuccess())) {
			/**
			 * 上报未成功
			 * 操作状态=A-创建 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
			 * 是否已成功上报=不变化
			 */
			mtsJshDefgDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			
		}
		mtsJshDefgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		mtsJshDefgDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		mtsJshDefgDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		//修改的机构号 时间 和人员
		mtsJshDefgDs.setLstUpdTlr(globalInfo.getTlrno());
		mtsJshDefgDs.setLstUpdTm(new Date());
		mtsJshDefgDs.setBrNo(globalInfo.getBrno());
		if(StringUtils.equals(currentFile, JSH_E)){
			mtsJshDefgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_E);
		}
		if(StringUtils.equals(currentFile, JSH_G)){
			mtsJshDefgDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_JSH_G);
		}
		return mtsJshDefgDs;		
	}

	public MtsJshDefgDs load(String RecId)  throws CommonException{
		// TODO Auto-generated method stub
		rootDao= ROOTDAOUtils.getROOTDAO();
		return (MtsJshDefgDs)rootDao.query(MtsJshDefgDs.class, RecId);
	}
	/**
	 * 审核操作
	 * @param approveStatusChoose 审核状态
	 * @param approveResultChoose 审核结果
	 * @param MtsJshDefgDsList 要审核的实体List
	 */
	public  void  AuditMtsJshDefgDs(String approveStatusChoose, String approveResultChoose, List<MtsJshDefgDs> MtsJshDefgDsList) throws CommonException{
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List<String>MtsJshDefgDsIds = new ArrayList<String>();
		for(int i=0; i<MtsJshDefgDsList.size(); i++){
			String id = MtsJshDefgDsList.get(i).getId();
			MtsJshDefgDsIds.add(id);
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from MtsJshDefgDs model where model.id in" + ReportUtils.toInString(MtsJshDefgDsIds);
		List<MtsJshDefgDs> qMtsJshDefgDsList = rootdao.queryByQL2List(hql);
		
		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}
		
		for (MtsJshDefgDs mtsJshDefgDs : qMtsJshDefgDsList) {
			mtsJshDefgDs.setLstUpdTlr(gi.getTlrno());
			mtsJshDefgDs.setLstUpdTm(new Date());
			mtsJshDefgDs.setApproveResult(approveResultChoose);
			mtsJshDefgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			mtsJshDefgDs.setApproveStatus(approveStatusChoose);
			rootdao.saveOrUpdate(mtsJshDefgDs);
			
			if(mtsJshDefgDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && mtsJshDefgDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(mtsJshDefgDs.getApptype(), mtsJshDefgDs.getCurrentfile(), mtsJshDefgDs.getId(), mtsJshDefgDs.getRptno(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, mtsJshDefgDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(mtsJshDefgDs.getApptype(), mtsJshDefgDs.getCurrentfile(), mtsJshDefgDs.getId(), mtsJshDefgDs.getRptno(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}
		
	   }
	}
	/**
	 * 判断基础信息是否能够删除
	 * @param mtdr 待判断的实体
	
	 */
	public void isCanDelete(MtsJshDefgDs mtdr) throws CommonException{
		String hql = "from MtsJshDefgDs model where model.filler1 = '"+mtdr.getId()+"'";
		hql += "and model.actiontype <> '"+TopReportConstants.REPORT_ACTIONTYPE_D+"'";
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List list = dao.queryByQL2List(hql);
		if(list!=null&&list.size()>0){
			ExceptionUtil.throwCommonException("该记录已经绑定了管理信息不能删除");
		}
	}

}
	

	

