package com.huateng.report.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.bean.report.BopProjectInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bean.BopForDebtFeiOrgSave;
import com.huateng.report.bean.BopForDebtFeiPerSave;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BopForDebtFeiOrgSaveOperation;
import com.huateng.report.operation.BopForDebtFeiPerSaveOperation;
import com.huateng.report.operation.BopForDebtYinTuanOperation;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public class BopForDebtYinTuanService {

	protected static final Logger logger = Logger.getLogger(BopForDebtYinTuanService.class);

	protected BopForDebtYinTuanService() {
	}

	public synchronized static BopForDebtYinTuanService getInstance() {
		return (BopForDebtYinTuanService) ApplicationContextUtils.getBean(BopForDebtYinTuanService.class.getName());
	}

	/**
	 * 银团贷款签约信息补录查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param qactiontype
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryRecordYinTuan(String queryType, int pageIndex, int pageSize, String qworkDateStart,String qworkDateEnd, String qfiller2, String qactiontype,
			String qapproveStatus, String qrepStatus, String qRecStatus) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN(?,?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);
			objs.add(TopReportConstants.REPORT_RECSTATUS_01);
			objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		}
		if (queryType.equals("change")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.changeFileType = ? AND model.recStatus IN(?,?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_01);
			objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		}
		if(!DataFormat.isEmpty(qworkDateStart)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qworkDateStart);
		}
		if(!DataFormat.isEmpty(qworkDateEnd)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qworkDateEnd);
		}
		if(!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%"+qfiller2+"%");
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qRecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qRecStatus);
		}

		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC,model.workDate, model.actiontype, model.approveStatus DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}

	/**
	 * 查询审核信息
	 * @param queryType
	 * @param pageIndex
	 * @param pageSize
	 * @param qworkDate
	 * @param qactiontype
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qexdebtcode
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryAuditYinTuan(String queryType, int pageIndex,
			int pageSize, String qStartDate, String qEndDate, String qactiontype,String qRecStatus,
			String qapproveStatus, String qrepStatus, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN(?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);
			objs.add(TopReportConstants.REPORT_RECSTATUS_03);
			objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		}
		if (queryType.equals("change")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.changeFileType = ? AND model.recStatus IN(?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_03);
			objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		}
		if(!DataFormat.isEmpty(qStartDate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qStartDate);
		}
		if(!DataFormat.isEmpty(qEndDate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qEndDate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qRecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qRecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC,model.workDate, model.actiontype, model.approveStatus DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}

	public PageQueryResult queryRecordYinTuanLoadPage(int pageIndex,
			int pageSize, String qcontractdate, String qdebtorcode, String qworkDate) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.actiontype <> ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);
		objs.add(TopReportConstants.REPORT_ACTIONTYPE_D);
		if(!DataFormat.isEmpty(qcontractdate)){
			hql.append(" AND model.contractdate = ? ");
			objs.add(qcontractdate);
		}
		if (!DataFormat.isEmpty(qdebtorcode)) {
			hql.append(" AND model.debtorcode = ? ");
			objs.add(qdebtorcode);
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" AND model.workDate = ? ");
			objs.add(qworkDate);
		}
		hql.append(" AND model.brNo = ? ORDER BY model.workDate, model.actiontype, model.approveStatus DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}

	/**
	 * 保存银团贷款信息
	 * @param opType
	 * @param bopCfaExdebtDs
	 * @param proNewList
	 * @param proModList
	 * @param proDelList
	 * @param creNewList
	 * @param creModList
	 * @param creDelList
	 * @throws CommonException
	 */
	public void saveDebtYinTuan(String opType,
			BopCfaExdebtDs bopCfaExdebtDs, List<BopProjectInfo> proNewList,
			List<BopProjectInfo> proModList, List<BopProjectInfo> proDelList,
			List<BopCfaCreditorDs> creNewList,
			List<BopCfaCreditorDs> creModList, List<BopCfaCreditorDs> creDelList) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if(BopForDebtYinTuanOperation.OP_SIGNED_NEW.equals(opType)){
			bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			bopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			bopCfaExdebtDs.setCrtTm(new Date());
			bopCfaExdebtDs.setLstUpdTm(new Date());
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setBrNo(gi.getBrno());
			bopCfaExdebtDs.setId(ReportUtils.getUUID());
			bopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			bopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);
			bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			//后台信息验证
			ReportDataVaildUtil.executeVaild(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");

			rootdao.save(bopCfaExdebtDs);
		} else if (BopForDebtYinTuanOperation.OP_SIGNED_MOD.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, bopCfaExdebtDs.getId());

			dbBopCfaExdebtDs.setDebtype(bopCfaExdebtDs.getDebtype());
			dbBopCfaExdebtDs.setDebtorcode(bopCfaExdebtDs.getDebtorcode());
			dbBopCfaExdebtDs.setContractamount(bopCfaExdebtDs.getContractamount());
			dbBopCfaExdebtDs.setValuedate(bopCfaExdebtDs.getValuedate());
			dbBopCfaExdebtDs.setMaturity(bopCfaExdebtDs.getMaturity());
			dbBopCfaExdebtDs.setFloatrate(bopCfaExdebtDs.getFloatrate());
			dbBopCfaExdebtDs.setAnninrate(bopCfaExdebtDs.getAnninrate());
			dbBopCfaExdebtDs.setInprterm(bopCfaExdebtDs.getInprterm());
			dbBopCfaExdebtDs.setSpapfeboindex(bopCfaExdebtDs.getSpapfeboindex());
			dbBopCfaExdebtDs.setFiller2(bopCfaExdebtDs.getFiller2());//add 业务流水号
			dbBopCfaExdebtDs.setRemark(bopCfaExdebtDs.getRemark());
			dbBopCfaExdebtDs.setActiondesc(null);//在报送新增和修改时不需要填删除原因

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			if (dbBopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");
			//后台信息验证
			dbBopCfaExdebtDs.setCreditors(bopCfaExdebtDs.getCreditors());
			dbBopCfaExdebtDs.setProjects(bopCfaExdebtDs.getProjects());

			ReportDataVaildUtil.executeVaild(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs);

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtYinTuanOperation.OP_SIGNED_DEL.equals(opType)) {

			StringBuilder hql = new StringBuilder(" SELECT COUNT(*) FROM BopCfaExdebtDs WHERE filler1 = '")
				.append(bopCfaExdebtDs.getId()).append("' AND currentfile = '")
				.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AR + "' AND changeFileType='")
				.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AG).append("' AND recStatus <> '" + TopReportConstants.REPORT_RECSTATUS_07 + "' ");

			int count = rootdao.queryByHqlToCount(hql.toString());
			if (0 < count) {
				ExceptionUtil.throwCommonException("该签约信息存在变动信息不可删除");
			}

			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, bopCfaExdebtDs.getId());

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			dbBopCfaExdebtDs.setActiondesc(bopCfaExdebtDs.getActiondesc());
			dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCfaExdebtDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtYinTuanOperation.OP_CHANGE_NEW.equals(opType)) {
			BopCfaExdebtDs newBopCfaExdebtDs = new BopCfaExdebtDs();

			newBopCfaExdebtDs.setId(ReportUtils.getUUID());
			newBopCfaExdebtDs.setCrtTm(new Date());
			newBopCfaExdebtDs.setLstUpdTm(new Date());
			newBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			newBopCfaExdebtDs.setBrNo(gi.getBrno());
			newBopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			newBopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);
			newBopCfaExdebtDs.setChangeFileType(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);
			newBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			newBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			newBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			newBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			newBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			newBopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

			newBopCfaExdebtDs.setExdebtcode(bopCfaExdebtDs.getExdebtcode());
			newBopCfaExdebtDs.setBuscode(bopCfaExdebtDs.getBuscode());
			newBopCfaExdebtDs.setChangeno(bopCfaExdebtDs.getChangeno());
			newBopCfaExdebtDs.setChangtype(bopCfaExdebtDs.getChangtype());
			newBopCfaExdebtDs.setChdate(bopCfaExdebtDs.getChdate());
			newBopCfaExdebtDs.setChcurrency(bopCfaExdebtDs.getChcurrency());
			newBopCfaExdebtDs.setChamount(bopCfaExdebtDs.getChamount());
			newBopCfaExdebtDs.setFairvalue(bopCfaExdebtDs.getFairvalue());
			newBopCfaExdebtDs.setRemark(bopCfaExdebtDs.getRemark());
			newBopCfaExdebtDs.setFiller1(bopCfaExdebtDs.getFiller1());
			newBopCfaExdebtDs.setFiller2(bopCfaExdebtDs.getFiller2());

			dataVaild(newBopCfaExdebtDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(newBopCfaExdebtDs.getApptype(), newBopCfaExdebtDs.getCurrentfile(), newBopCfaExdebtDs.getId(),
					newBopCfaExdebtDs.getExdebtcode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");
			rootdao.save(newBopCfaExdebtDs);
		} else if (BopForDebtYinTuanOperation.OP_CHANGE_MOD.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, bopCfaExdebtDs.getId());

			dbBopCfaExdebtDs.setChangtype(bopCfaExdebtDs.getChangtype());
			dbBopCfaExdebtDs.setChdate(bopCfaExdebtDs.getChdate());
			dbBopCfaExdebtDs.setChcurrency(bopCfaExdebtDs.getChcurrency());
			dbBopCfaExdebtDs.setChamount(bopCfaExdebtDs.getChamount());
			dbBopCfaExdebtDs.setFairvalue(bopCfaExdebtDs.getFairvalue());
			dbBopCfaExdebtDs.setFiller2(bopCfaExdebtDs.getFiller2());
			dbBopCfaExdebtDs.setRemark(bopCfaExdebtDs.getRemark());

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			if (dbBopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));


			dataVaild(dbBopCfaExdebtDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtYinTuanOperation.OP_CHANGE_DEL.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, bopCfaExdebtDs.getId());
			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			dbBopCfaExdebtDs.setActiondesc(bopCfaExdebtDs.getActiondesc());
			dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCfaExdebtDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		}

		if (BopForDebtYinTuanOperation.OP_SIGNED_NEW.equals(opType) ||
				BopForDebtYinTuanOperation.OP_SIGNED_MOD.equals(opType) ||
				BopForDebtYinTuanOperation.OP_SIGNED_DEL.equals(opType)) {
			for(BopProjectInfo proNew : proNewList){
				proNew.setId(ReportUtils.getUUID());
				proNew.setCrtTm(new Date());
				proNew.setRecId(bopCfaExdebtDs.getId());

				rootdao.saveOrUpdate(proNew);
			}
			for (BopProjectInfo proMod : proModList) {
				rootdao.saveOrUpdate(proMod);
			}
			for(BopProjectInfo proDel : proDelList){
				rootdao.delete(BopProjectInfo.class, proDel.getId());
			}
			for(BopCfaCreditorDs creNew : creNewList){
				creNew.setId(ReportUtils.getUUID());
				creNew.setCrtTm(new Date());
				creNew.setRecId(bopCfaExdebtDs.getId());
				rootdao.saveOrUpdate(creNew);
			}
			for (BopCfaCreditorDs creMod : creModList) {
				rootdao.saveOrUpdate(creMod);
			}
			for(BopCfaCreditorDs creDel : creDelList){
				rootdao.delete(BopCfaCreditorDs.class, creDel.getId());
			}
		}
	}

	/**
	 * 银团贷款审核
	 * @param approveStatusChoose
	 * @param approveResultChoose
	 * @param list
	 * @param opType
	 * @throws CommonException
	 */
	public void auditYinTuan(String approveStatusChoose,
			String approveResultChoose, List<BopCfaExdebtDs> list,
			String opType) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List<String> ids = new ArrayList<String>();
		for(BopCfaExdebtDs bopAccDs : list){
			ids.add(bopAccDs.getId());
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from BopCfaExdebtDs model where model.id in" + ReportUtils.toInString(ids);
		List<BopCfaExdebtDs> bopCfaExdebtDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}

		for (BopCfaExdebtDs bopCfaExdebtDs : bopCfaExdebtDsList) {
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setLstUpdTm(new Date());
			bopCfaExdebtDs.setApproveResult(approveResultChoose);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopCfaExdebtDs.setApproveStatus(approveStatusChoose);
			bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			rootdao.saveOrUpdate(bopCfaExdebtDs);

			if(bopCfaExdebtDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, bopCfaExdebtDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult queryRecordFeiOrgSave(String queryType, int pageIndex,
			int pageSize, String qworkDate,String eworkDate ,String qactiontype,
			String qapproveStatus, String qrepStatus,String qFiller2, String qRecStatus) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (? , ? ) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);
			objs.add(TopReportConstants.REPORT_RECSTATUS_01);
			objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		}
		if (queryType.equals("over")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.balanceFileType = ? AND model.recStatus IN (? , ? ) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_01);
			objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" AND model.workDate >= ? ");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(eworkDate)) {
			hql.append(" AND model.workDate <= ? ");
			objs.add(eworkDate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if(!DataFormat.isEmpty(qFiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%"+qFiller2+"%");
		}
		if(!DataFormat.isEmpty(qRecStatus)){
			hql.append(" AND model.recStatus = ? ");
			objs.add(qRecStatus);
		}

		hql.append(" AND model.brNo=? ORDER BY model.lstUpdTm DESC,model.workDate, model.actiontype, model.approveStatus DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				if (queryType.equals("signed")) {
					String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}

	public PageQueryResult queryRecordFeiPerSave(String queryType, int pageIndex,
			int pageSize, String startdate, String enddate, String qactiontype,
			String qapproveStatus, String qrepStatus, String qRecStatus, String filler2) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN(?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_01);
			objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		}
		if (queryType.equals("over")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.balanceFileType = ? AND model.recStatus IN(?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_01);
			objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		}
		if(!DataFormat.isEmpty(startdate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(startdate);
		}
		if(!DataFormat.isEmpty(enddate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(enddate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qRecStatus)){
			hql.append(" AND model.recStatus = ? ");
			objs.add(qRecStatus);
		}
		if (!DataFormat.isEmpty(filler2)){
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + filler2 + "%");
		}

		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC,model.workDate, model.actiontype, model.approveStatus DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiPerSave> debtFeiPerSaves = new ArrayList<BopForDebtFeiPerSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiPerSave debtFeiPerSave = new BopForDebtFeiPerSave();
				BeanUtils.copyProperties(debtFeiPerSave, cfaExdebtDs);
				if (queryType.equals("signed")) {
					String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiPerSave, cfaCreditorDs);
					debtFeiPerSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiPerSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiPerSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiPerSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiPerSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiPerSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiPerSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiPerSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiPerSaves.add(debtFeiPerSave);
			}
		}
		queryResult.setQueryResult(debtFeiPerSaves);
		return queryResult;
	}

	public PageQueryResult queryRecordCorOrgContact(String queryType, int pageIndex,
			int pageSize, String qworkDate,String eworkDate, String qactiontype,
			String qapproveStatus, String qrepStatus,String qfiller2, String qRecStatus) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.recStatus in(?,?)");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_01);
			objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		}
		if (queryType.equals("over")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.balanceFileType=? and model.recStatus in(?,?)");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_01);
			objs.add(TopReportConstants.REPORT_RECSTATUS_02);
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" and model.workDate>=?");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(eworkDate)) {
			hql.append(" and model.workDate<=?");
			objs.add(eworkDate);
		}
		if(!DataFormat.isEmpty(qfiller2)){
			hql.append(" and model.filler2=?");
			objs.add(qfiller2);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" and model.actiontype=?");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" and model.approveStatus=?");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" and model.repStatus=?");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qRecStatus)) {
			hql.append(" and model.recStatus = ? ");
			objs.add(qRecStatus);
		}

		hql.append(" and model.brNo=? order by model.lstUpdTm desc");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object o = it.next();
			Object[] os = (Object[]) o;
			BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
			BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
			BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
			if (queryType.equals("signed")) {
				String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//				BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
				debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
				debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
				debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
				debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
				debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
				debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
				debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
				debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
			}
			debtFeiOrgSaves.add(debtFeiOrgSave);
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}

	public void saveCorOrgContact(String opType,
			BopForDebtFeiOrgSave debtFeiOrgSave) throws CommonException, IllegalAccessException, InvocationTargetException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if(BopForDebtFeiOrgSaveOperation.OP_SIGNED_NEW.equals(opType)){
			BopCfaExdebtDs bopCfaExdebtDs = new BopCfaExdebtDs();
			BeanUtils.copyProperties(bopCfaExdebtDs, debtFeiOrgSave);

			BopCfaCreditorDs bopCfaCreditorDs = new BopCfaCreditorDs();
			BeanUtils.copyProperties(bopCfaCreditorDs, debtFeiOrgSave);

			bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			bopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			bopCfaExdebtDs.setCrtTm(new Date());
			bopCfaExdebtDs.setLstUpdTm(new Date());
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setBrNo(gi.getBrno());
			bopCfaExdebtDs.setId(ReportUtils.getUUID());
			bopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			bopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);
			bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			bopCfaCreditorDs.setId(ReportUtils.getUUID());
			bopCfaCreditorDs.setCrtTm(new Date());
			bopCfaCreditorDs.setRecId(bopCfaExdebtDs.getId());
			// 把债权人信息表设置到外债信息表里，做验证
			if(null != bopCfaCreditorDs) {
				List<BopCfaCreditorDs> creditors = new ArrayList<BopCfaCreditorDs>();
				creditors.add(bopCfaCreditorDs);
				bopCfaExdebtDs.setCreditors(creditors);
			}
			/** 外债 校验开始  **/
			ReportDataVaildUtil.executeVaild(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs);
			/** 外债 校验结束  **/
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");
			rootdao.save(bopCfaCreditorDs);
			rootdao.save(bopCfaExdebtDs);
		} else if(BopForDebtFeiOrgSaveOperation.OP_SIGNED_MOD.equals(opType)){
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiOrgSave.getId());

			dbBopCfaExdebtDs.setDebtype(debtFeiOrgSave.getDebtype());
			dbBopCfaExdebtDs.setDebtorcode(debtFeiOrgSave.getDebtorcode());
			dbBopCfaExdebtDs.setLimitType(debtFeiOrgSave.getLimitType());
			dbBopCfaExdebtDs.setValuedate(debtFeiOrgSave.getValuedate());
			dbBopCfaExdebtDs.setContractcurr(debtFeiOrgSave.getContractcurr());
			dbBopCfaExdebtDs.setFloatrate(debtFeiOrgSave.getFloatrate());
			dbBopCfaExdebtDs.setAnninrate(debtFeiOrgSave.getAnninrate());
			dbBopCfaExdebtDs.setSpapfeboindex(debtFeiOrgSave.getSpapfeboindex());
			dbBopCfaExdebtDs.setRemark(debtFeiOrgSave.getRemark());
			//流水号
			dbBopCfaExdebtDs.setFiller2(debtFeiOrgSave.getFiller2());
			dbBopCfaExdebtDs.setActiondesc(debtFeiOrgSave.getActiondesc());

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			if (dbBopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));



			//债券人信息
			String creHql = "from BopCfaCreditorDs model where model.recId ='" + dbBopCfaExdebtDs.getId() + "'";
			BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
			cfaCreditorDs.setCreditorcode(debtFeiOrgSave.getCreditorcode());
			cfaCreditorDs.setCreditorname(debtFeiOrgSave.getCreditorname());
			cfaCreditorDs.setCreditornamen(debtFeiOrgSave.getCreditornamen());
			cfaCreditorDs.setCreditortype(debtFeiOrgSave.getCreditortype());
			cfaCreditorDs.setCrehqcode(debtFeiOrgSave.getCrehqcode());
			cfaCreditorDs.setOpercode(debtFeiOrgSave.getOpercode());
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");
			// 把债权人信息表设置到外债信息表里，做验证
			if(null != cfaCreditorDs) {
				List<BopCfaCreditorDs> creditors = new ArrayList<BopCfaCreditorDs>();
				creditors.add(cfaCreditorDs);
				dbBopCfaExdebtDs.setCreditors(creditors);
			}
			/** 外债 校验开始  **/
			ReportDataVaildUtil.executeVaild(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs);
			/** 外债 校验结束  **/
			rootdao.saveOrUpdate(cfaCreditorDs);
			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiOrgSaveOperation.OP_SIGNED_DEL.equals(opType)) {

			StringBuilder hql = new StringBuilder(" SELECT COUNT(*) FROM BopCfaExdebtDs WHERE filler1 = '")
				.append(debtFeiOrgSave.getId()).append("' AND currentfile = '")
				.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AS + "' AND balanceFileType='")
				.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AM).append("' AND recStatus <> '" + TopReportConstants.REPORT_RECSTATUS_07 + "' ");

			int count = rootdao.queryByHqlToCount(hql.toString());
			if (0 < count) {
				ExceptionUtil.throwCommonException("该签约信息存在余额信息不可删除");
			}

			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiOrgSave.getId());
			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			dbBopCfaExdebtDs.setActiondesc(debtFeiOrgSave.getActiondesc());
			dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCfaExdebtDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiOrgSaveOperation.OP_OVER_NEW.equals(opType)) {
			BopCfaExdebtDs newBopCfaExdebtDs = new BopCfaExdebtDs();

			newBopCfaExdebtDs.setId(ReportUtils.getUUID());
			newBopCfaExdebtDs.setCrtTm(new Date());
			newBopCfaExdebtDs.setLstUpdTm(new Date());
			newBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			newBopCfaExdebtDs.setBrNo(gi.getBrno());
			newBopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			newBopCfaExdebtDs.setCurrentfile("AS");
			newBopCfaExdebtDs.setBalanceFileType("AM");
			newBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			newBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			newBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			newBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			newBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			newBopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

			newBopCfaExdebtDs.setExdebtcode(debtFeiOrgSave.getExdebtcode());
			newBopCfaExdebtDs.setBuscode(debtFeiOrgSave.getBuscode());
			newBopCfaExdebtDs.setChangeno(debtFeiOrgSave.getChangeno());
			newBopCfaExdebtDs.setChdate(debtFeiOrgSave.getChdate());
			newBopCfaExdebtDs.setAccoamount(debtFeiOrgSave.getAccoamount());
			newBopCfaExdebtDs.setFiller1(debtFeiOrgSave.getFiller1());
			newBopCfaExdebtDs.setRemark(debtFeiOrgSave.getRemark());
			newBopCfaExdebtDs.setFiller2(debtFeiOrgSave.getFiller2());
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(newBopCfaExdebtDs.getApptype(), newBopCfaExdebtDs.getCurrentfile(), newBopCfaExdebtDs.getId(),
					newBopCfaExdebtDs.getExdebtcode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");
			rootdao.save(newBopCfaExdebtDs);
		} else if (BopForDebtFeiOrgSaveOperation.OP_OVER_MOD.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiOrgSave.getId());

			dbBopCfaExdebtDs.setChangeno(debtFeiOrgSave.getChangeno());
			dbBopCfaExdebtDs.setChdate(debtFeiOrgSave.getChdate());
			dbBopCfaExdebtDs.setAccoamount(debtFeiOrgSave.getAccoamount());
			dbBopCfaExdebtDs.setBuscode(debtFeiOrgSave.getBuscode());
			dbBopCfaExdebtDs.setRemark(debtFeiOrgSave.getRemark());

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			if (dbBopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiOrgSaveOperation.OP_OVER_DEL.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiOrgSave.getId());
			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			dbBopCfaExdebtDs.setActiondesc(debtFeiOrgSave.getActiondesc());
			dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCfaExdebtDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		}
	}

	public PageQueryResult queryCorOrgContactLoadPage(int pageIndex, int pageSize,
			String qexdebtcode, String qdebtorcode) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");
		hql.append(" model.apptype=? and model.currentfile=? and model.subSuccess =? and model.actiontype<>?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);
		objs.add(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES);
		objs.add(TopReportConstants.REPORT_ACTIONTYPE_D);
		if(!DataFormat.isEmpty(qexdebtcode)){
			hql.append(" and model.exdebtcode like ?");
			objs.add("%" + qexdebtcode + "%");
		}
		if (!DataFormat.isEmpty(qdebtorcode)) {
			hql.append(" and model.debtorcode like ?");
			objs.add("%" + qdebtorcode + "%");
		}
		hql.append(" and model.brNo=? order by model.lstUpdTm desc");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
//				BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
				debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
				debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
				debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
				debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
				debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
				debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
				debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}

	public void saveDebtFeiOrgSave(String opType,
			BopForDebtFeiOrgSave debtFeiOrgSave) throws CommonException, IllegalAccessException, InvocationTargetException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if(BopForDebtFeiOrgSaveOperation.OP_SIGNED_NEW.equals(opType)){
			BopCfaExdebtDs bopCfaExdebtDs = new BopCfaExdebtDs();
			BeanUtils.copyProperties(bopCfaExdebtDs, debtFeiOrgSave);

			BopCfaCreditorDs bopCfaCreditorDs = new BopCfaCreditorDs();
			BeanUtils.copyProperties(bopCfaCreditorDs, debtFeiOrgSave);

			bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			bopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			bopCfaExdebtDs.setCrtTm(new Date());
			bopCfaExdebtDs.setLstUpdTm(new Date());
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setBrNo(gi.getBrno());
			bopCfaExdebtDs.setId(ReportUtils.getUUID());
			bopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			bopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);
			bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			bopCfaCreditorDs.setId(ReportUtils.getUUID());
			bopCfaCreditorDs.setCrtTm(new Date());
			bopCfaCreditorDs.setRecId(bopCfaExdebtDs.getId());

			//数据校验
			dataVaild(bopCfaExdebtDs, bopCfaCreditorDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");
			rootdao.save(bopCfaCreditorDs);
			rootdao.save(bopCfaExdebtDs);
		} else if(BopForDebtFeiOrgSaveOperation.OP_SIGNED_MOD.equals(opType)){
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiOrgSave.getId());

			dbBopCfaExdebtDs.setDebtype(debtFeiOrgSave.getDebtype());
			dbBopCfaExdebtDs.setDebtorcode(debtFeiOrgSave.getDebtorcode());
			dbBopCfaExdebtDs.setLimitType(debtFeiOrgSave.getLimitType());
			dbBopCfaExdebtDs.setValuedate(debtFeiOrgSave.getValuedate());
			dbBopCfaExdebtDs.setContractcurr(debtFeiOrgSave.getContractcurr());
			dbBopCfaExdebtDs.setFloatrate(debtFeiOrgSave.getFloatrate());
			dbBopCfaExdebtDs.setAnninrate(debtFeiOrgSave.getAnninrate());
			dbBopCfaExdebtDs.setSpapfeboindex(debtFeiOrgSave.getSpapfeboindex());
			dbBopCfaExdebtDs.setRemark(debtFeiOrgSave.getRemark());
			dbBopCfaExdebtDs.setFiller2(debtFeiOrgSave.getFiller2());

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			if (dbBopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCfaExdebtDs.setActiondesc(debtFeiOrgSave.getActiondesc());
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//债券人信息
			String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + dbBopCfaExdebtDs.getId() + "' ";
			BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
			cfaCreditorDs.setCreditorcode(debtFeiOrgSave.getCreditorcode());
			cfaCreditorDs.setCreditorname(debtFeiOrgSave.getCreditorname());
			cfaCreditorDs.setCreditornamen(debtFeiOrgSave.getCreditornamen());
			cfaCreditorDs.setCreditortype(debtFeiOrgSave.getCreditortype());
			cfaCreditorDs.setCrehqcode(debtFeiOrgSave.getCrehqcode());
			cfaCreditorDs.setOpercode(debtFeiOrgSave.getOpercode());

			//数据校验
			dataVaild(dbBopCfaExdebtDs, cfaCreditorDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");
			rootdao.saveOrUpdate(cfaCreditorDs);
			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiOrgSaveOperation.OP_SIGNED_DEL.equals(opType)) {

			StringBuilder hql = new StringBuilder(" SELECT COUNT(*) FROM BopCfaExdebtDs WHERE filler1 = '")
				.append(debtFeiOrgSave.getId()).append("' AND currentfile = '")
				.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AS).append("' AND balanceFileType = '")
				.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AN).append("' AND recStatus <> '")
				.append(TopReportConstants.REPORT_RECSTATUS_07).append("' ");

			int count = rootdao.queryByHqlToCount(hql.toString());
			if (0 < count) {
				ExceptionUtil.throwCommonException("该签约信息存在变动信息不可删除");
			}

			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiOrgSave.getId());
			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			dbBopCfaExdebtDs.setActiondesc(debtFeiOrgSave.getActiondesc());
			dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCfaExdebtDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiOrgSaveOperation.OP_OVER_NEW.equals(opType)) {
			BopCfaExdebtDs newBopCfaExdebtDs = new BopCfaExdebtDs();

			newBopCfaExdebtDs.setId(ReportUtils.getUUID());
			newBopCfaExdebtDs.setCrtTm(new Date());
			newBopCfaExdebtDs.setLstUpdTm(new Date());
			newBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			newBopCfaExdebtDs.setBrNo(gi.getBrno());
			newBopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			newBopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);
			newBopCfaExdebtDs.setBalanceFileType(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);
			newBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			newBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			newBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			newBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			newBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			newBopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

			newBopCfaExdebtDs.setExdebtcode(debtFeiOrgSave.getExdebtcode());
			newBopCfaExdebtDs.setBuscode(debtFeiOrgSave.getBuscode());
			newBopCfaExdebtDs.setChangeno(debtFeiOrgSave.getChangeno());
			newBopCfaExdebtDs.setChdate(debtFeiOrgSave.getChdate());
			newBopCfaExdebtDs.setAccoamount(debtFeiOrgSave.getAccoamount());
			newBopCfaExdebtDs.setFiller1(debtFeiOrgSave.getFiller1());
			newBopCfaExdebtDs.setFiller2(debtFeiOrgSave.getFiller2());
			newBopCfaExdebtDs.setRemark(debtFeiOrgSave.getRemark());

			dataVaild(newBopCfaExdebtDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(newBopCfaExdebtDs.getApptype(), newBopCfaExdebtDs.getCurrentfile(), newBopCfaExdebtDs.getId(),
					newBopCfaExdebtDs.getExdebtcode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");
			rootdao.save(newBopCfaExdebtDs);
		} else if (BopForDebtFeiOrgSaveOperation.OP_OVER_MOD.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiOrgSave.getId());

			dbBopCfaExdebtDs.setChangeno(debtFeiOrgSave.getChangeno());
			dbBopCfaExdebtDs.setChdate(debtFeiOrgSave.getChdate());
			dbBopCfaExdebtDs.setAccoamount(debtFeiOrgSave.getAccoamount());
			dbBopCfaExdebtDs.setBuscode(debtFeiOrgSave.getBuscode());
			dbBopCfaExdebtDs.setFiller2(debtFeiOrgSave.getFiller2());
			dbBopCfaExdebtDs.setRemark(debtFeiOrgSave.getRemark());

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			if (dbBopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			dataVaild(dbBopCfaExdebtDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiOrgSaveOperation.OP_OVER_DEL.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiOrgSave.getId());
			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			dbBopCfaExdebtDs.setActiondesc(debtFeiOrgSave.getActiondesc());
			dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//dataVaild(dbBopCfaExdebtDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCfaExdebtDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		}
	}

	private void dataVaild(BopCfaExdebtDs bopCfaExdebtDs,
			BopCfaCreditorDs bopCfaCreditorDs) throws CommonException {

		bopCfaExdebtDs.setCreditorcode(bopCfaCreditorDs.getCreditorcode());
		bopCfaExdebtDs.setCreditorname(bopCfaCreditorDs.getCreditorname());
		bopCfaExdebtDs.setCreditornamen(bopCfaCreditorDs.getCreditornamen());
		bopCfaExdebtDs.setCreditortype(bopCfaCreditorDs.getCreditortype());
		bopCfaExdebtDs.setCrehqcode(bopCfaCreditorDs.getCrehqcode());
		bopCfaExdebtDs.setOpercode(bopCfaCreditorDs.getOpercode());

		ReportDataVaildUtil.executeVaild(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs);
	}

	private void dataVaild(BopCfaExdebtDs bopCfaExdebtDs) throws CommonException {
		ReportDataVaildUtil.executeVaild(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs);
	}

	public void saveDebtFeiPerSave(String opType,
			BopForDebtFeiPerSave debtFeiPerSave) throws CommonException, IllegalAccessException, InvocationTargetException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		if(BopForDebtFeiPerSaveOperation.OP_SIGNED_NEW.equals(opType)){
			BopCfaExdebtDs bopCfaExdebtDs = new BopCfaExdebtDs();
			BeanUtils.copyProperties(bopCfaExdebtDs, debtFeiPerSave);

			BopCfaCreditorDs bopCfaCreditorDs = new BopCfaCreditorDs();
			BeanUtils.copyProperties(bopCfaCreditorDs, debtFeiPerSave);

			bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			bopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			bopCfaExdebtDs.setCrtTm(new Date());
			bopCfaExdebtDs.setLstUpdTm(new Date());
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setBrNo(gi.getBrno());
			bopCfaExdebtDs.setId(ReportUtils.getUUID());
			bopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			bopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);
			bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			bopCfaCreditorDs.setId(ReportUtils.getUUID());
			bopCfaCreditorDs.setCrtTm(new Date());
			bopCfaCreditorDs.setRecId(bopCfaExdebtDs.getId());

			//数据校验
			dataVaild(bopCfaExdebtDs, bopCfaCreditorDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");
			rootdao.save(bopCfaCreditorDs);
			rootdao.save(bopCfaExdebtDs);
		} else if(BopForDebtFeiPerSaveOperation.OP_SIGNED_MOD.equals(opType)){
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiPerSave.getId());

			dbBopCfaExdebtDs.setDebtype(debtFeiPerSave.getDebtype());
			dbBopCfaExdebtDs.setDebtorcode(debtFeiPerSave.getDebtorcode());
			dbBopCfaExdebtDs.setLimitType(debtFeiPerSave.getLimitType());
			dbBopCfaExdebtDs.setValuedate(debtFeiPerSave.getValuedate());
			dbBopCfaExdebtDs.setContractcurr(debtFeiPerSave.getContractcurr());
			dbBopCfaExdebtDs.setFloatrate(debtFeiPerSave.getFloatrate());
			dbBopCfaExdebtDs.setAnninrate(debtFeiPerSave.getAnninrate());
			dbBopCfaExdebtDs.setSpapfeboindex(debtFeiPerSave.getSpapfeboindex());
			dbBopCfaExdebtDs.setFiller2(debtFeiPerSave.getFiller2());
			dbBopCfaExdebtDs.setRemark(debtFeiPerSave.getRemark());

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			if (dbBopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCfaExdebtDs.setActiondesc(debtFeiPerSave.getActiondesc());
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//债券人信息
			String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + dbBopCfaExdebtDs.getId() + "' ";
			BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
			cfaCreditorDs.setCreditorcode(debtFeiPerSave.getCreditorcode());
			cfaCreditorDs.setCreditorname(debtFeiPerSave.getCreditorname());
			cfaCreditorDs.setCreditornamen(debtFeiPerSave.getCreditornamen());
			cfaCreditorDs.setCreditortype(debtFeiPerSave.getCreditortype());
			cfaCreditorDs.setCrehqcode(debtFeiPerSave.getCrehqcode());
			cfaCreditorDs.setOpercode(debtFeiPerSave.getOpercode());

			//数据校验
			dataVaild(dbBopCfaExdebtDs, cfaCreditorDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");
			rootdao.saveOrUpdate(cfaCreditorDs);
			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiPerSaveOperation.OP_SIGNED_DEL.equals(opType)) {

			StringBuilder hql = new StringBuilder(" SELECT COUNT(*) FROM BopCfaExdebtDs WHERE filler1 = '")
				.append(debtFeiPerSave.getId()).append("' AND currentfile = '")
					.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AS).append("' AND balanceFileType='")
					.append(TopReportConstants.REPORT_FILE_TYPE_CFA_AP).append("' AND recStatus <> '")
					.append(TopReportConstants.REPORT_RECSTATUS_07).append("' ");

			int count = rootdao.queryByHqlToCount(hql.toString());
			if (0 < count) {
				ExceptionUtil.throwCommonException("该签约信息存在变动信息不可删除");
			}

			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiPerSave.getId());
			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			dbBopCfaExdebtDs.setActiondesc(debtFeiPerSave.getActiondesc());
			dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据校验
			BopCfaCreditorDs cfaCreditorDs = new BopCfaCreditorDs();
			BeanUtils.copyProperties(cfaCreditorDs, debtFeiPerSave);
			//dataVaild(dbBopCfaExdebtDs, cfaCreditorDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCfaExdebtDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiPerSaveOperation.OP_OVER_NEW.equals(opType)) {
			BopCfaExdebtDs newBopCfaExdebtDs = new BopCfaExdebtDs();

			newBopCfaExdebtDs.setId(ReportUtils.getUUID());
			newBopCfaExdebtDs.setCrtTm(new Date());
			newBopCfaExdebtDs.setLstUpdTm(new Date());
			newBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			newBopCfaExdebtDs.setBrNo(gi.getBrno());
			newBopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			newBopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);
			newBopCfaExdebtDs.setBalanceFileType(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);
			newBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			newBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			newBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			newBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			newBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			newBopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

			newBopCfaExdebtDs.setExdebtcode(debtFeiPerSave.getExdebtcode());
			newBopCfaExdebtDs.setBuscode(debtFeiPerSave.getBuscode());
			newBopCfaExdebtDs.setChangeno(debtFeiPerSave.getChangeno());
			newBopCfaExdebtDs.setChdate(debtFeiPerSave.getChdate());
			newBopCfaExdebtDs.setAccoamount(debtFeiPerSave.getAccoamount());
			newBopCfaExdebtDs.setFiller1(debtFeiPerSave.getFiller1());
			newBopCfaExdebtDs.setFiller2(debtFeiPerSave.getFiller2());
			newBopCfaExdebtDs.setRemark(debtFeiPerSave.getRemark());

			//数据校验
			dataVaild(newBopCfaExdebtDs);
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(newBopCfaExdebtDs.getApptype(), newBopCfaExdebtDs.getCurrentfile(), newBopCfaExdebtDs.getId(),
					newBopCfaExdebtDs.getExdebtcode(), TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增");
			rootdao.save(newBopCfaExdebtDs);
		} else if (BopForDebtFeiPerSaveOperation.OP_OVER_MOD.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiPerSave.getId());

			dbBopCfaExdebtDs.setChangeno(debtFeiPerSave.getChangeno());
			dbBopCfaExdebtDs.setChdate(debtFeiPerSave.getChdate());
			dbBopCfaExdebtDs.setAccoamount(debtFeiPerSave.getAccoamount());
			dbBopCfaExdebtDs.setBuscode(debtFeiPerSave.getBuscode());
			dbBopCfaExdebtDs.setFiller2(debtFeiPerSave.getFiller2());
			dbBopCfaExdebtDs.setRemark(debtFeiPerSave.getRemark());

			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			if (dbBopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			} else {
				dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
			}
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据校验
			dataVaild(dbBopCfaExdebtDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改");

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		} else if (BopForDebtFeiPerSaveOperation.OP_OVER_DEL.equals(opType)) {
			BopCfaExdebtDs dbBopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, debtFeiPerSave.getId());
			dbBopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			dbBopCfaExdebtDs.setLstUpdTm(new Date());
			dbBopCfaExdebtDs.setActiondesc(debtFeiPerSave.getActiondesc());
			dbBopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
			dbBopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			dbBopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			dbBopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
			dbBopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));

			//数据校验
			dataVaild(dbBopCfaExdebtDs);

			//数据处理记录表保存
			commonService.saveBiDataProcessLog(dbBopCfaExdebtDs.getApptype(), dbBopCfaExdebtDs.getCurrentfile(), dbBopCfaExdebtDs.getId(), dbBopCfaExdebtDs.getExdebtcode(),
					TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", dbBopCfaExdebtDs.getActiondesc());

			rootdao.saveOrUpdate(dbBopCfaExdebtDs);
		}
	}

	public PageQueryResult queryFeiOrgSaveLoadPage(int pageIndex, int pageSize,
			String qexdebtcode, String qdebtorcode, String qworkDate) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");
		hql.append(" model.apptype=? and model.currentfile=? and model.subSuccess =? and model.actiontype<>?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);
		objs.add(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
		objs.add(TopReportConstants.REPORT_ACTIONTYPE_D);
		if(!DataFormat.isEmpty(qexdebtcode)){
			hql.append(" and model.exdebtcode like ?");
			objs.add("%" + qexdebtcode + "%");
		}
		if (!DataFormat.isEmpty(qdebtorcode)) {
			hql.append(" and model.debtorcode like ?");
			objs.add("%" + qdebtorcode + "%");
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" and model.workDate=?");
			objs.add(qworkDate);
		}
		hql.append(" and model.brNo=? order by model.lstUpdTm desc");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
//				BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
				debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
				debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
				debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
				debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
				debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
				debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
				debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}

	public PageQueryResult queryFeiPerSaveLoadPage(int pageIndex, int pageSize,String workdate,String qactiontype,String qrecStatus,String qapproveStatus,String qrepStatus,
			String qFiller2, String qdebtorcode) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE model.apptype = ? AND model.currentfile = ? AND model.actiontype <> ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);
		objs.add(TopReportConstants.REPORT_ACTIONTYPE_D);
		if(!DataFormat.isEmpty(qFiller2)){
			hql.append(" AND model.filler2 LIKE ?");
			objs.add("%" + qFiller2 + "%");
		}
		if (!DataFormat.isEmpty(qdebtorcode)) {
			hql.append(" AND model.debtorcode LIKE ?");
			objs.add("%" + qdebtorcode + "%");
		}
		if(!DataFormat.isEmpty(workdate)){
			hql.append(" AND model.workDate = ?");
			objs.add(workdate);
		}
		if(!DataFormat.isEmpty(qactiontype)){
			hql.append(" AND model.actiontype = ?");
			objs.add(qactiontype);
		}
		if(!DataFormat.isEmpty(qrecStatus)){
			hql.append(" AND model.recStatus = ?");
			objs.add(qrecStatus);
		}
		if(!DataFormat.isEmpty(qapproveStatus)){
			hql.append(" AND model.approveStatus = ?");
			objs.add(qapproveStatus);
		}
		if(!DataFormat.isEmpty(qrepStatus)){
			hql.append(" AND model.repStatus = ?");
			objs.add(qrepStatus);
		}

		hql.append(" AND model.brNo=? ORDER BY model.lstUpdTm DESC");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiPerSave> debtFeiPerSaves = new ArrayList<BopForDebtFeiPerSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				String creHql = " FROM BopCfaCreditorDs model WHERE model.recId ='" + cfaExdebtDs.getId() + "'";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
				BopForDebtFeiPerSave debtFeiPerSave = new BopForDebtFeiPerSave();
//				BeanUtils.copyProperties(debtFeiPerSave, cfaCreditorDs);
				BeanUtils.copyProperties(debtFeiPerSave, cfaExdebtDs);
				debtFeiPerSave.setRecId(cfaCreditorDs.getRecId());
				debtFeiPerSave.setCreditorca(cfaCreditorDs.getCreditorca());
				debtFeiPerSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
				debtFeiPerSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
				debtFeiPerSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
				debtFeiPerSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
				debtFeiPerSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
				debtFeiPerSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				debtFeiPerSaves.add(debtFeiPerSave);
			}
		}
		queryResult.setQueryResult(debtFeiPerSaves);
		return queryResult;
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult queryAuditFeiOrgSave(String queryType, int pageIndex,
			int pageSize, String qworkDate, String eworkDate,String qactiontype,
			String qrecStatus,String qapproveStatus, String qrepStatus, String qfiller2) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);
			objs.add(TopReportConstants.REPORT_RECSTATUS_03);
			objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		}
		if (queryType.equals("signeds")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?)");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);
			objs.add(TopReportConstants.REPORT_RECSTATUS_03);
			objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		}
		if (queryType.equals("over")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.balanceFileType = ? AND model.recStatus IN (?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_03);
			objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		}
		if (queryType.equals("overs")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.balanceFileType = ? AND model.recStatus IN (?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_03);
			objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" AND model.workDate >= ? ");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(eworkDate)) {
			hql.append(" AND model.workDate <= ? ");
			objs.add(eworkDate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC,model.workDate, model.actiontype, model.approveStatus DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		PageQueryResult queryResult = new PageQueryResult();

		queryResult = rootdao.pageQueryByQL(queryCondition);
		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				if (queryType.equals("signed")) {
					String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				if (queryType.equals("signeds")) {
					String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}


	@SuppressWarnings("rawtypes")
	public PageQueryResult queryFeiPerSaveQuery(String queryType, int pageIndex,
			int pageSize, String qstartdate,String qenddate, String qactiontype,
			String qapproveStatus, String qrepStatus, String filler2, String qbrNo, String recStatus) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (StringUtils.equals(queryType, "signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);
		} else if (StringUtils.equals(queryType, "over")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.balanceFileType = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);//变动对于的签约的文件类型
		}
		if(!DataFormat.isEmpty(qstartdate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qstartdate);
		}
		if(!DataFormat.isEmpty(qenddate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qenddate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(filler2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + filler2 + "%");
		}
		if (!DataFormat.isEmpty(qbrNo)) {
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(recStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(recStatus);
		}
		hql.append(" ORDER BY model.lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		PageQueryResult queryResult = new PageQueryResult();

		queryResult = rootdao.pageQueryByQL(queryCondition);
		List<BopForDebtFeiPerSave> debtFeiPerSaves = new ArrayList<BopForDebtFeiPerSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiPerSave debtFeiPerSave = new BopForDebtFeiPerSave();
				BeanUtils.copyProperties(debtFeiPerSave, cfaExdebtDs);
				if (queryType.equals("signed")) {
					String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiPerSave, cfaCreditorDs);
					debtFeiPerSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiPerSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiPerSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiPerSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiPerSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiPerSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiPerSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiPerSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiPerSaves.add(debtFeiPerSave);
			}
		}
		queryResult.setQueryResult(debtFeiPerSaves);
		return queryResult;
	}


	@SuppressWarnings("rawtypes")
	public PageQueryResult queryFeiPerGen(String queryType, int pageIndex,
			int pageSize, String qworkDate, String qactiontype, String filler2, String qbrNo) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		if (queryType.equals("over")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.balanceFileType = ? AND model.recStatus = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		if(!DataFormat.isEmpty(qworkDate)){
			hql.append(" AND model.workDate = ? ");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
//		if (!DataFormat.isEmpty(qapproveStatus)) {
//			hql.append(" AND model.approveStatus = ? ");
//			objs.add(qapproveStatus);
//		}
//		if (!DataFormat.isEmpty(qrepStatus)) {
//			hql.append(" AND model.repStatus = ? ");
//			objs.add(qrepStatus);
//		}
//		if (!DataFormat.isEmpty(recStatus)) {
//			hql.append(" AND model.recStatus = ? ");
//			objs.add(recStatus);
//		}
		if (!DataFormat.isEmpty(filler2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + filler2 + "%");
		}
		if (!DataFormat.isEmpty(qbrNo)) {
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}

		hql.append(" ORDER BY model.lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		PageQueryResult queryResult = new PageQueryResult();

		queryResult = rootdao.pageQueryByQL(queryCondition);
		List<BopForDebtFeiPerSave> debtFeiPerSaves = new ArrayList<BopForDebtFeiPerSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiPerSave debtFeiPerSave = new BopForDebtFeiPerSave();
				BeanUtils.copyProperties(debtFeiPerSave, cfaExdebtDs);
				if (queryType.equals("signed")) {
					String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
					debtFeiPerSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiPerSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiPerSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiPerSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiPerSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiPerSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiPerSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiPerSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiPerSaves.add(debtFeiPerSave);
			}
		}
		queryResult.setQueryResult(debtFeiPerSaves);
		return queryResult;
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult queryAuditFeiPerSave(String queryType, int pageIndex,
			int pageSize, String startdate,String enddate, String qactiontype, String qrecStatus,
			String qapproveStatus, String qrepStatus, String filler2) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN(?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);
			objs.add(TopReportConstants.REPORT_RECSTATUS_03);
			objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		}
		if (queryType.equals("over")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.balanceFileType = ? AND model.recStatus IN(?, ?) ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AP);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_03);
			objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		}
		if(!DataFormat.isEmpty(startdate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(startdate);
		}
		if(!DataFormat.isEmpty(enddate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(enddate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(filler2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + filler2 + "%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC,model.workDate, model.actiontype, model.approveStatus DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		PageQueryResult queryResult = new PageQueryResult();

		queryResult = rootdao.pageQueryByQL(queryCondition);
		List<BopForDebtFeiPerSave> debtFeiPerSaves = new ArrayList<BopForDebtFeiPerSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiPerSave debtFeiPerSave = new BopForDebtFeiPerSave();
				BeanUtils.copyProperties(debtFeiPerSave, cfaExdebtDs);
				if (queryType.equals("signed")) {
					String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiPerSave, cfaCreditorDs);
					debtFeiPerSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiPerSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiPerSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiPerSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiPerSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiPerSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiPerSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiPerSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiPerSaves.add(debtFeiPerSave);
			}
		}
		queryResult.setQueryResult(debtFeiPerSaves);
		return queryResult;
	}

	public void auditFeiOrgSave(String approveStatusChoose,
			String approveResultChoose, List<String> ids, String opSignedAudit) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from BopCfaExdebtDs model where model.id in" + ReportUtils.toInString(ids);
		List<BopCfaExdebtDs> bopCfaExdebtDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if (approveStatusChoose.equals(TopReportConstants.REPORT_APPROVESTATUS_01)) {
			approveStatusChooseName = "通过";
		} else {
			approveStatusChooseName = "不通过";
		}

		for (BopCfaExdebtDs bopCfaExdebtDs : bopCfaExdebtDsList) {
			bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
			bopCfaExdebtDs.setLstUpdTm(new Date());
			bopCfaExdebtDs.setApproveResult(approveResultChoose);
			bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopCfaExdebtDs.setApproveStatus(approveStatusChoose);
			bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			rootdao.saveOrUpdate(bopCfaExdebtDs);

			if(bopCfaExdebtDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, bopCfaExdebtDs.getActiondesc());
			} else {
				//数据处理记录表保存
				commonService.saveBiDataProcessLog(bopCfaExdebtDs.getApptype(), bopCfaExdebtDs.getCurrentfile(), bopCfaExdebtDs.getId(), bopCfaExdebtDs.getExdebtcode(),
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, approveStatusChooseName, approveResultChoose);
			}
		}
	}

	public PageQueryResult queryYinTuanGen(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qactiontype, String qexdebtcode) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.recStatus=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		if (queryType.equals("change")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.changeFileType=? and model.recStatus=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		hql.append("and model.workDate=?");
		objs.add(GlobalInfo.getCurrentInstance().getFileDate());
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" and model.brNo = ?");
			objs.add(qbrNo);
		}
		if(!DataFormat.isEmpty(qactiontype)){
			hql.append(" and model.actiontype = ?");
			objs.add(qactiontype);
		}
		if(!DataFormat.isEmpty(qexdebtcode)){
			hql.append(" and model.exdebtcode like ?");
			objs.add("%" + qexdebtcode + "%");
		}
		hql.append(" order by model.lstUpdTm desc");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult queryYinTuanQueryBetweenDate(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qactiontype, String qrecStatus,
			String qapproveStatus, String qrepStatus, String qfiller2, String qWorkDateBegin, String qWorkDateOver) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);
		}
		if (queryType.equals("change")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.changeFileType = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);//变动对于的签约的文件类型
		}
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if(!DataFormat.isEmpty(qactiontype)){
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if(!DataFormat.isEmpty(qrecStatus)){
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if(!DataFormat.isEmpty(qapproveStatus)){
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if(!DataFormat.isEmpty(qrepStatus)){
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if(!DataFormat.isEmpty(qfiller2)){
			hql.append(" AND model.filler2 like ? ");
			objs.add("%" + qfiller2 + "%");
		}
		if(!DataFormat.isEmpty(qWorkDateBegin)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qWorkDateBegin);
		}
		if(!DataFormat.isEmpty(qWorkDateOver)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qWorkDateOver);
		}
		hql.append(" ORDER BY model.lstUpdTm desc");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());


		List<BopCfaExdebtDs> bopCfaExdebtDses = new ArrayList<BopCfaExdebtDs>();
		PageQueryResult result =  rootdao.pageQueryByQL(queryCondition);

		List resultList = result.getQueryResult();

		for (int i = 0; i < resultList.size(); i++) {
			Object[] obj = (Object[]) resultList.get(i);

			BopCfaExdebtDs exdebtds = (BopCfaExdebtDs) obj[0];

			ReportCommonService commservice = ReportCommonService.getInstance();

			exdebtds.setProjectname(commservice.getProjectNamesToStr(exdebtds.getId()));
			exdebtds.setCreditorsStr(commservice.getBopCreditorsToStr(exdebtds.getId()));
			bopCfaExdebtDses.add(exdebtds);
		}
		result.setQueryResult(bopCfaExdebtDses);
		return result;

	}

	public PageQueryResult queryYinTuanQuery(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qactiontype, String qrecStatus,
			String qapproveStatus, String qrepStatus, String qfiller2, String qstartdate,String qenddate) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);
		}
		if (queryType.equals("change")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? AND model.changeFileType = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AG);//变动对于的签约的文件类型
		}
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if(!DataFormat.isEmpty(qactiontype)){
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if(!DataFormat.isEmpty(qrecStatus)){
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if(!DataFormat.isEmpty(qapproveStatus)){
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if(!DataFormat.isEmpty(qrepStatus)){
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if(!DataFormat.isEmpty(qfiller2)){
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		if(!DataFormat.isEmpty(qstartdate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qstartdate);
		}
		if(!DataFormat.isEmpty(qenddate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qenddate);
		}
		hql.append(" ORDER BY model.lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult queryFeiOrgSaveGen(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qactiontype, String qfiller2) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.recStatus=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		if (queryType.equals("signedsQuery")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.recStatus=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AH);
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		if (queryType.equals("signeds")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.recStatus=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		if (queryType.equals("over")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.balanceFileType=? and model.recStatus=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		if (queryType.equals("oversQuery")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.balanceFileType=? and model.recStatus=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AH);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		if (queryType.equals("overs")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.balanceFileType=? and model.recStatus=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);//变动对于的签约的文件类型
			objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		}
		hql.append(" and model.workDate=?");
		objs.add(GlobalInfo.getCurrentInstance().getFileDate());
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" and model.brNo=?");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" and model.actiontype=?");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" and model.filler2 like ?");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" order by model.lstUpdTm desc");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				if (queryType.equals("signed")) {
					String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				if (queryType.equals("signedsQuery")) {
					String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				if (queryType.equals("signeds")) {
					String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult queryFeiOrgSaveQueryBetweenDate(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qrecStatus, String qactiontype,
			String qapproveStatus, String qrepStatus, String qfiller2, String qWorkDateBegin, String qWorkDateOver) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM BopCfaExdebtDs model WHERE ");
		if (queryType.equals("signedQuery")) {
			hql.append(" model.apptype = ? AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AH);
		}
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qWorkDateBegin)) {
			hql.append(" AND model.workDate >= ? ");
			objs.add(qWorkDateBegin);
		}
		if (!DataFormat.isEmpty(qWorkDateOver)) {
			hql.append(" AND model.workDate <= ? ");
			objs.add(qWorkDateOver);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" ORDER BY model.lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				if (queryType.equals("signedQuery")) {
					String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					String cpjHql = " FROM BopProjectInfo model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
					BopProjectInfo bopProjectInfo;
					if (!rootdao.queryByQL2List(cpjHql).isEmpty()) {
						bopProjectInfo = (BopProjectInfo)rootdao.queryByQL2List(cpjHql).get(0);
						debtFeiOrgSave.setProjectname(bopProjectInfo.getProjectname());
					}
//					BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult queryFeiOrgSaveQuery(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qrecStatus, String qactiontype,
			String qapproveStatus, String qrepStatus, String qfiller2, String qworkDate,String eworkDate) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");
		if (queryType.equals("signed")) {
			hql.append(" model.apptype=? and model.currentfile=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);
		}
		if (queryType.equals("signedQuery")) {
			hql.append(" model.apptype=? and model.currentfile=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AH);
		}
		if (queryType.equals("signeds")) {
			hql.append(" model.apptype=? and model.currentfile=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);
		}
		if (queryType.equals("over")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.balanceFileType=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AN);//变动对于的签约的文件类型
		}
		if (queryType.equals("overs")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.balanceFileType=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);//变动对于的签约的文件类型
		}
		if (queryType.equals("oversQuery")) {
			hql.append(" model.apptype=? and model.currentfile=? and model.balanceFileType=?");
			objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AH);//变动对于的签约的文件类型
		}
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" and model.brNo=?");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" and model.workDate>=?");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(eworkDate)) {
			hql.append(" and model.workDate<=?");
			objs.add(eworkDate);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" and model.recStatus=?");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" and model.actiontype=?");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" and model.approveStatus=?");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" and model.repStatus=?");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" and model.filler2 like ?");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" order by model.lstUpdTm desc");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);

		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if(list != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				if (queryType.equals("signed")) {
					String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				if (queryType.equals("signedQuery")) {
					String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				if (queryType.equals("signeds")) {
					String creHql = "from BopCfaCreditorDs model where model.recId ='" + cfaExdebtDs.getId() + "'";
					BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
//					BeanUtils.copyProperties(debtFeiOrgSave, cfaCreditorDs);
					debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
					debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
					debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
					debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
					debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
					debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
					debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
					debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				}
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}

	public PageQueryResult queryAuditFeiOrgSaveGen(int pageIndex,
			int pageSize, String qworkDate, String qactiontype,
			String qapproveStatus, String qrepStatus,String qrecStatus) throws CommonException, IllegalAccessException, InvocationTargetException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("select model from BopCfaExdebtDs model where ");

		hql.append(" model.apptype=? and model.currentfile=? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);

		if(!DataFormat.isEmpty(qworkDate)){
			hql.append(" and model.workDate=?");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" and model.actiontype=?");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" and model.approveStatus=?");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" and model.repStatus=?");
			objs.add(qrepStatus);
		}

		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" and model.recStatus= ?");
			objs.add(qrecStatus);
		}
		hql.append(" and model.brNo=? order by model.lstUpdTm desc");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}
}
