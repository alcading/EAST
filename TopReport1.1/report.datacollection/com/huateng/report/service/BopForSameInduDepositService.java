package com.huateng.report.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopForSameInduDepositService  {
	//private static final String DATASET_ID = "com.huateng.report.service.BopForSameInduDepositService";
	//private static final Logger log = Logger.getLogger(BopForSameInduDepositService.class);

	public static synchronized BopForSameInduDepositService getInstance(){
		return (BopForSameInduDepositService)ApplicationContextUtils.getBean(BopForSameInduDepositService.class.getName());
	}

	protected BopForSameInduDepositService() {

	}

	/**
	 * 签约信息查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param qactiontype
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qaccountstat
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryRecordAD(int pageIndex, int pageSize, String qworkDate, String qactiontype,
			String qrecStatus, String qapproveStatus, String qrepStatus,
			String qexdebtcode) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
	   StringBuffer hql = new StringBuffer("select bds from BopCfaExdebtDs bds where 1=1 ");

	   if(StringUtils.isNotBlank(qworkDate))
	   {
		   hql.append(" and bds.workDate ='").append(qworkDate).append("'");
	   }
	   if(StringUtils.isNotBlank(qactiontype))
	   {
		   hql.append(" and bds.actiontype ='").append(qactiontype).append("'");
	   }
	   if(StringUtils.isNotBlank(qrecStatus))
	   {
		   hql.append(" and bds.recStatus ='").append(qrecStatus).append("'");
	   }
	   if(StringUtils.isNotBlank(qapproveStatus))
	   {
		   hql.append(" and bds.approveStatus ='").append(qapproveStatus).append("'");
	   }
	   if(StringUtils.isNotBlank(qrepStatus))
	   {
		   hql.append(" and bds.repStatus ='").append(qrepStatus).append("'");
	   }
	   if(StringUtils.isNotBlank(qexdebtcode))
	   {
		   hql.append(" and bds.exdebtcode like '%").append(qexdebtcode).append("%'");
	   }
	   hql.append(" and  (bds.recStatus ='"+TopReportConstants.REPORT_RECSTATUS_01+"' or  bds.recStatus='"+TopReportConstants.REPORT_RECSTATUS_02+"')");
	   hql.append(" order by bds.workDate,bds.approveStatus,bds.actiontype desc");
	   PageQueryCondition pc = new PageQueryCondition();
	   pc.setPageIndex(pageIndex);
	   pc.setPageSize(pageSize);
	   pc.setQueryString(hql.toString());

	   return rootdao.pageQueryByQL(pc);
	}

	/**
	 * 同业存放签约信息保存
	 * @throws CommonException
	 */
	public void saveInduDeposit(BopCfaExdebtDs  bopCfaExdebtDs , BopCfaCreditorDs bopCfaCreditorDs) throws CommonException{
		ReportCommonService reportCommonService =ReportCommonService.getInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if(bopCfaExdebtDs.getId()!="" && bopCfaCreditorDs.getId()!= ""){
			//保存外债信息
			/** 外债 校验开始  **/
		ReportDataVaildUtil.executeVaild(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs);
			/** 外债 校验结束  **/
			rootdao.save(bopCfaExdebtDs);
			//保存债权信息
			rootdao.save(bopCfaCreditorDs);
			reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增外债信息-签约信息     签约信息ID ："+bopCfaExdebtDs.getId());
		}
	}

	public void updateInduDeposit(BopCfaExdebtDs  bopCfaExdebtDs , BopCfaCreditorDs bopCfaCreditorDs) throws CommonException{
		ReportCommonService reportCommonService =ReportCommonService.getInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if(bopCfaExdebtDs.getId()!="" && bopCfaCreditorDs.getId()!= ""){
			//保存外债信息
			/** 外债 校验开始  **/
			ReportDataVaildUtil.executeVaild(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs);
			/** 外债 校验结束  **/
			rootdao.update(bopCfaExdebtDs);
			//保存债权信息

			rootdao.update(bopCfaCreditorDs);
			reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "更新", "修改外债信息-签约信息     签约信息ID ："+bopCfaExdebtDs.getId());
		}
	}

	public void deleteInduDeposit(BopCfaExdebtDs  bopCfaExdebtDs ) throws CommonException{
		ReportCommonService reportCommonService =ReportCommonService.getInstance();
		/** 外债 校验开始 删除不用验证 **/
		//ReportDataVaildUtil.executeVaild(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs);

		StringBuilder hql = new StringBuilder(" SELECT COUNT(*) FROM BopCfaExdebtDs WHERE filler1 = '")
			.append(bopCfaExdebtDs.getId()).append("' AND currentfile = '")
			.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AS).append("' AND balanceFileType='")
			.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AM)
			.append("' AND recStatus <> '").append(TopReportConstants.REPORT_RECSTATUS_07).append("' ");

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int count = rootdao.queryByHqlToCount(hql.toString());
		if (0 < count) {
			ExceptionUtil.throwCommonException("该签约信息存在余额信息不可删除");
		}

		/** 外债 校验结束  **/

		rootdao.update(bopCfaExdebtDs);
		reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
				TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "删除", "删除外债信息-签约信息     签约信息ID ："+bopCfaExdebtDs.getId());
	}

	public String getRecID(String id) throws CommonException{
		PageQueryCondition  pc= new PageQueryCondition();
		String recid = "";
		String hqlString = "SELECT bs.CREDITOR_ID from BOP_CFA_CREDITOR_DS bs where bs.rec_Id ='"+id+"'";
		pc.setQueryString(hqlString);

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for(Iterator it = rootdao.queryBySQL(hqlString.toString()) ;  it.hasNext(); ){
			Object[] queryArray = (Object[]) it.next();
			recid = (String)queryArray[0];
		}
		return recid;
	}

	/**
	 * 余额信息新增
	 * @param bopCfaExdebtDs 外债实体
	 * @throws CommonException
	 */
	public void saveInduDepositBalance(BopCfaExdebtDs  bopCfaExdebtDs ) throws CommonException{
		ReportCommonService reportCommonService =ReportCommonService.getInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if(bopCfaExdebtDs.getId()!=""){
			//保存外债信息
			rootdao.save(bopCfaExdebtDs);
			//保存债权信息
			reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增外债信息-同业存放—余额信息     余额信息ID ："+bopCfaExdebtDs.getId());
		}
	}

	/**
	 * 更新境外同业存放余额信息
	 * @param bopCfaExdebtDs
	 * @throws CommonException
	 */
	public void updateInduDepositBalance(BopCfaExdebtDs  bopCfaExdebtDs ) throws CommonException{
		ReportCommonService reportCommonService =ReportCommonService.getInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if(bopCfaExdebtDs.getId()!=""){
			//保存外债信息
			rootdao.update(bopCfaExdebtDs);
			//保存债权信息
			reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "更新", "修改外债信息-同业存放—余额信息     余额信息ID ："+bopCfaExdebtDs.getId());
		}
	}
	/**
	 * 审核境外同业存放签约信息
	 * @param approveStatusChoose
	 * @param approveResultChoose
	 * @param bopCfaExdebtDsList
	 * @throws CommonException
	 */
	public void auditInduDeposit(String approveStatusChoose,
			String approveResultChoose, List<BopCfaExdebtDs> bopCfaExdebtDsList ) throws CommonException{
		ReportCommonService reportCommonService =ReportCommonService.getInstance();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for (BopCfaExdebtDs  bopCfaExdebtDs : bopCfaExdebtDsList){
			bopCfaExdebtDs.setApproveStatus(approveStatusChoose);
			bopCfaExdebtDs.setApproveResult(approveResultChoose);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setLstUpdTm(new Date());

			rootdao.update(bopCfaExdebtDs);
			if(TopReportConstants.REPORT_APPROVESTATUS_01.equals(approveStatusChoose)){
				reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
						TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "通过", "审核外债信息-同业存放—签约信息     外债信息ID ："+bopCfaExdebtDs.getId());
			}else{
				reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
						TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "不通过", "审核外债信息-同业存放—签约信息     外债信息ID ："+bopCfaExdebtDs.getId());
			}
		}
	}
	/**
	 * 审核境外同业存放余额信息
	 * @param approveStatusChoose  审核状态
	 * @param approveResultChoose	审核说明
	 * @param bopCfaExdebtDsList
	 * @throws CommonException
	 */
	public void auditInduBalanceDeposit(String approveStatusChoose,
			String approveResultChoose, List<BopCfaExdebtDs> bopCfaExdebtDsList ) throws CommonException{
		ReportCommonService reportCommonService =ReportCommonService.getInstance();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for (BopCfaExdebtDs  bopCfaExdebtDs : bopCfaExdebtDsList){
			bopCfaExdebtDs.setApproveStatus(approveStatusChoose);
			bopCfaExdebtDs.setApproveResult(approveResultChoose);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setLstUpdTm(new Date());
			rootdao.update(bopCfaExdebtDs);
			if(TopReportConstants.REPORT_APPROVESTATUS_01.equals(approveStatusChoose)){
				reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
						TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "通过", "审核外债信息-同业存放—余额信息     外债信息ID ："+bopCfaExdebtDs.getId());
			}else{
				reportCommonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(),
						TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "不通过", "审核外债信息-同业存放—余额信息     外债信息ID ："+bopCfaExdebtDs.getId());
			}
		}
	}
}