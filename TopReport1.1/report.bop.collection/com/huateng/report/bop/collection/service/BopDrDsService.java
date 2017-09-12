package com.huateng.report.bop.collection.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopDrDs;
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

public class BopDrDsService {
	
	private static HtLog htLog = HtLogFactory.getLog(BopDrDsService.class);
	public static final String BOP_D = "基础信息";
	public static final String BOP_R = "管理信息";
	GlobalInfo  globalInfo;
	private ROOTDAO rootDao ;
	/**
	 * 获取一个实例
	 * @param paramgroupId 参数段编号
	 */

	public static BopDrDsService getInstance() {
		// TODO Auto-generated method stub
		return (BopDrDsService)ApplicationContextUtils.getBean("BopDrDsService");
	}
	/**
	 * getter分页查询
	 */
	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}
	/**
	 * 删除一个实体
	 * @param  mtsBopDrDs 要删除的实体
	 * @param  currentfileMessage 文件类型
	 */
	//逻辑删除  只是更改状态为删除状态
	public void delete(MtsBopDrDs mtsBopDrDs , String currentfile) throws CommonException {
		globalInfo = GlobalInfo.getCurrentInstance();
		rootDao= ROOTDAOUtils.getROOTDAO();
		/**
		 * 操作状态=D-删除 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
		 * 是否已成功上报=不变化
		 */
		if(StringUtils.equals(currentfile, BOP_D)){
			mtsBopDrDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_D);			
		}
		if(StringUtils.equals(currentfile, BOP_R)){
			mtsBopDrDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_R);			
		}
        //删除的时间 机构号 和 人员
		mtsBopDrDs.setLstUpdTlr(globalInfo.getTlrno());
		mtsBopDrDs.setLstUpdTm(new Date());
		mtsBopDrDs.setBrNo(globalInfo.getBrno());

		mtsBopDrDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
		mtsBopDrDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		mtsBopDrDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		mtsBopDrDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		/**判断基础信息是否绑定了管理信息  begin*/
		isCanDelete(mtsBopDrDs);
		/**判断基础信息是否绑定了管理信息  end*/
		rootDao.saveOrUpdate(mtsBopDrDs);
		htLog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境内收入申报单"+currentfile+"删除"});	
	}

	/**
	 * 保存一个实体
	 * @param  mtsBopDrDs 要保存的实体
	 * @param  currentfileMessage 文件类型
	 */
	public void save(MtsBopDrDs mbDr, String currentfileMessage) throws CommonException {		
		globalInfo = GlobalInfo.getCurrentInstance();
		rootDao= ROOTDAOUtils.getROOTDAO();
		MtsBopDrDs mbDrTemp = (MtsBopDrDs) rootDao.query(MtsBopDrDs.class, (String)mbDr.getId());
		if(null != mbDrTemp)
		{
			ExceptionUtil.throwCommonException("当前记录已存在！");
		}else{		
			MtsBopDrDs mtsBopDrDs = bopDRDsInsertSetValue(mbDr,currentfileMessage);
				//数据验证
				ReportDataVaildUtil.executeVaild(mtsBopDrDs.getApptype(), mtsBopDrDs.getCurrentfile(), mtsBopDrDs);
				rootDao.save(mtsBopDrDs);							
			htLog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境内收入申报单"+currentfileMessage+"新增"});
			
			}
			
	}

	/**
	 * 给实体设置值
	 * @param  mtsBopDrDs 要保存的实体
	 * @param  currentfileMessage 文件类型
	 * @return 
	 * @throws CommonException 
	 */
	private MtsBopDrDs bopDRDsInsertSetValue(MtsBopDrDs mbDr, String currentfile) throws CommonException{
		/**
		 * 操作状态=A-创建 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
		 * 是否已成功上报=0-否
		 */
		String guid = ReportUtils.getUUID();
		globalInfo = GlobalInfo.getCurrentInstance();
		//基础信息
		mbDr.setId(guid);
		mbDr.setCrtTm(new Date());
		mbDr.setLstUpdTm(new Date());
		mbDr.setLstUpdTlr(globalInfo.getTlrno());
		mbDr.setBrNo(globalInfo.getBrno());
		mbDr.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));

		mbDr.setApptype(TopReportConstants.REPORT_APP_TYPE_BOP);		
		mbDr.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		mbDr.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		mbDr.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		mbDr.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		mbDr.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		if(StringUtils.equals(currentfile, BOP_D)){
			mbDr.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_D);			
		}
		if(StringUtils.equals(currentfile, BOP_R)){
			mbDr.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_R);			
		}
		return mbDr;
		
		
	}
	



	/**
	 * 修改一个实体
	 * @param  mtsBopDrDs 要修改的实体
	 * @param  currentfileMessage 文件类型
	 */
	public void update(MtsBopDrDs mbDr , String currentfileMessage) throws CommonException {
		
		MtsBopDrDs mtsBopDrDs = bopDrUpdateSetValue(mbDr,currentfileMessage);
		//数据验证
		ReportDataVaildUtil.executeVaild(mtsBopDrDs.getApptype(), mtsBopDrDs.getCurrentfile(), mtsBopDrDs);
		rootDao.saveOrUpdate(mtsBopDrDs);
		htLog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境内收入申报单"+currentfileMessage+"修改"});
	}
	
	private  MtsBopDrDs  bopDrUpdateSetValue(MtsBopDrDs mbDr , String currentfile) throws CommonException{
		globalInfo = GlobalInfo.getCurrentInstance();
		rootDao= ROOTDAOUtils.getROOTDAO();
		MtsBopDrDs mtsBopDrDsQuery  = rootDao.query(MtsBopDrDs.class,mbDr.getId() );
		if(!StringUtils.equals(mtsBopDrDsQuery.getRecStatus(), mbDr.getRecStatus())){
			ExceptionUtil.throwCommonException("BOP交易["+mtsBopDrDsQuery.getBuscode()+"]已经被其他用户修改");
		}
		rootDao.getHibernateTemplate().evict(mtsBopDrDsQuery);

		mbDr.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
		if (!StringUtils.isEmpty(mbDr.getSubSuccess())
				&& TopReportConstants.REPORT_IS_SUB_SUCCESS_YES.equalsIgnoreCase(mbDr.getSubSuccess())) {
			/**
			 * 上报已成功
			 * 操作状态=C-修改 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
			 * 是否已成功上报=不变化
			 */
			mbDr.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);			
		}
		else if (!StringUtils.isEmpty(mbDr.getSubSuccess())
				&& TopReportConstants.REPORT_IS_SUB_SUCCESS_NO.equalsIgnoreCase(mbDr.getSubSuccess())) {
			/**
			 * 上报未成功
			 * 操作状态=A-创建 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
			 * 是否已成功上报=不变化
			 */
			mbDr.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);		
		}
		mbDr.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
		mbDr.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		mbDr.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
		if(StringUtils.equals(currentfile, BOP_D)){
			mbDr.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_D);			
		}
		if(StringUtils.equals(currentfile, BOP_R)){
			mbDr.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_BOP_R);			
		}

		mbDr.setLstUpdTlr(globalInfo.getTlrno());
		mbDr.setLstUpdTm(new Date());
		mbDr.setBrNo(globalInfo.getBrno());
		return mbDr;
		
		
	}

	/**
	 * 加载一个实体
	 * @param  RecId 要加载的实体的业务主键
	 */
	public MtsBopDrDs load(String RecId)  throws CommonException{
		// TODO Auto-generated method stub
		rootDao= ROOTDAOUtils.getROOTDAO();
		return (MtsBopDrDs)rootDao.query(MtsBopDrDs.class, RecId);
	}
	
	/**
	 * 审核
	 * @param  approveStatusChoose 审核状态
	 * @param  approveResultChoose 审核结果
	 * @param  approveResultChoose 要审核的实体List
	 */
	public  void  AuditMtsBopDrDs(String approveStatusChoose, String approveResultChoose, List<MtsBopDrDs> MtsBopDrDsList) throws CommonException{
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List<String>MtsBopDrDsIds = new ArrayList<String>();
		for(int i=0; i<MtsBopDrDsList.size(); i++){
			String id = MtsBopDrDsList.get(i).getId();
			MtsBopDrDsIds.add(id);
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from MtsBopDrDs model where model.id in" + ReportUtils.toInString(MtsBopDrDsIds);
		@SuppressWarnings("unchecked")
		List<MtsBopDrDs> qMtsBopDrDsList = rootdao.queryByQL2List(hql);
		
		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}
		
		for (MtsBopDrDs mtsBopDrDs : qMtsBopDrDsList) {
			mtsBopDrDs.setLstUpdTlr(gi.getTlrno());
			mtsBopDrDs.setLstUpdTm(new Date());
			mtsBopDrDs.setApproveResult(approveResultChoose);
			mtsBopDrDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			mtsBopDrDs.setApproveStatus(approveStatusChoose);
			rootdao.saveOrUpdate(mtsBopDrDs);
			
			if(mtsBopDrDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && mtsBopDrDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(mtsBopDrDs.getApptype(), mtsBopDrDs.getCurrentfile(), mtsBopDrDs.getId(), mtsBopDrDs.getRptno(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, mtsBopDrDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(mtsBopDrDs.getApptype(), mtsBopDrDs.getCurrentfile(), mtsBopDrDs.getId(), mtsBopDrDs.getRptno(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}	
	   }
	}
	/**
	 * 判断基础信息是否能删除
	 * @param  mtsBopDrDs  待删除的基础信息类
	 */
	public void isCanDelete(MtsBopDrDs mtsBopDrDs) throws CommonException{
		String hql = "from MtsBopDrDs model where model.filler1 = '"+mtsBopDrDs.getId()+"'";
		hql += "and model.actiontype <> '"+TopReportConstants.REPORT_ACTIONTYPE_D+"'";
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		@SuppressWarnings("rawtypes")
		List list = dao.queryByQL2List(hql);
		if(list!=null&&list.size()>0){
			ExceptionUtil.throwCommonException("该记录已经绑定了管理信息不能删除");
		}
	}
}
	

	

