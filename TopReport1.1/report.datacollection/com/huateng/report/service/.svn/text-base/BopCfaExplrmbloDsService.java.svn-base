package com.huateng.report.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExplrmbloDs;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

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

public class BopCfaExplrmbloDsService {

	/*
	 * 获得自身实例
	 */
	public synchronized static BopCfaExplrmbloDsService getInstance() {
		return (BopCfaExplrmbloDsService) ApplicationContextUtils
				.getBean(BopCfaExplrmbloDsService.class.getName());
	}

	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize,
			String currentfile, String workDate, String actiontype,
			String recStatus, String approveStatus, String repStatus,
			String filler2, String brno) throws CommonException {

		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaExplrmbloDs WHERE currentfile = ? ");
		List<Object> paralist = new ArrayList<Object>();
		paralist.add(currentfile);
		return pageQueryByHql(pageIndex, pageSize, workDate, actiontype,
				recStatus, approveStatus, repStatus, filler2, brno, queryhql,
				paralist);
	}

	public PageQueryResult pageQueryByAlreadyAudit(int pageIndex, int pageSize,
			String currentfile, String workDate, String actiontype,
			String recStatus, String approveStatus, String repStatus,
			String filler2, String brno) throws CommonException {

		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaExplrmbloDs WHERE currentfile = ? AND recStatus = ? ");

		List<Object> paraList = new ArrayList<Object>();
		paraList.add(currentfile);
		paraList.add(TopReportConstants.REPORT_RECSTATUS_05);

		PageQueryResult result = pageQueryByHql(pageIndex, pageSize, workDate,
				actiontype, recStatus, approveStatus, repStatus, filler2, brno,
				queryhql, paraList);
		return result;
	}

	public PageQueryResult pageQueryByAudit(int pageIndex, int pageSize,
			String currentfile, String qworkDate, String eworkDate,
			String actiontype, String recStatus, String approveStatus,
			String repStatus, String filler2, String brno)
			throws CommonException {

		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaExplrmbloDs WHERE currentfile = ? AND recStatus IN (? , ?) ");
		List<Object> paralist = new ArrayList<Object>();
		paralist.add(currentfile);
		paralist.add(TopReportConstants.REPORT_RECSTATUS_03);
		paralist.add(TopReportConstants.REPORT_RECSTATUS_04);
		return pageQueryByHql(pageIndex, pageSize, qworkDate, eworkDate,
				actiontype, recStatus, approveStatus, repStatus, filler2, brno,
				queryhql, paralist);
	}

	public PageQueryResult pageQueryByEdit(int pageIndex, int pageSize,
			String currentfile, String workDateStart, String workDateEnd,
			String actiontype, String recStatus, String approveStatus,
			String repStatus, String filler2, String brno)
			throws CommonException {

		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaExplrmbloDs WHERE currentfile = ? AND recStatus IN (? , ?)  ");
		List<Object> paralist = new ArrayList<Object>();
		paralist.add(currentfile);
		paralist.add(TopReportConstants.REPORT_RECSTATUS_01);
		paralist.add(TopReportConstants.REPORT_RECSTATUS_02);
		return pageQueryByHql(pageIndex, pageSize, workDateStart, workDateEnd,
				actiontype, recStatus, approveStatus, repStatus, filler2, brno,
				queryhql, paralist);
	}

	/*
	 * add by zhuhongyong 外汇质押补录信息查询,加入两个时间之间的模糊查询
	 */
	@SuppressWarnings("rawtypes")
	public PageQueryResult pageQueryByHqlForExplrmblo(String type,
			int pageIndex, int pageSize, String workDateStart,
			String workDateEnd, String qbrNo, String actiontype,
			String recStatus, String approveStatus, String repStatus,
			String filler2) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuilder queryHql = new StringBuilder();
		List<Object> objs = new ArrayList<Object>();
		queryHql.append(" FROM BopCfaExplrmbloDs WHERE apptype = ?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		/* 签约信息还是变动信息 */
		if (StringUtils.isNotBlank(type)) {
			if (type.equalsIgnoreCase(TopReportConstants.REPORT_FILE_TYPE_CFA_EA)) {
				queryHql.append(" AND currentfile = ?");
				objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_EA);
			} else if (type
					.equalsIgnoreCase(TopReportConstants.REPORT_FILE_TYPE_CFA_EB)) {
				queryHql.append(" AND currentfile = ?");
				objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_EB);
			}
		}
		if (StringUtils.isNotBlank(workDateStart)) {
			queryHql.append(" AND workDate >= ?");
			objs.add(workDateStart);
		}
		if (StringUtils.isNotBlank(workDateEnd)) {
			queryHql.append(" AND workDate <= ?");
			objs.add(workDateEnd);
		}
		if (StringUtils.isNotBlank(qbrNo)) {
			queryHql.append(" AND brNo = ?");
			objs.add(qbrNo);
		}
		if (StringUtils.isNotBlank(actiontype)) {
			queryHql.append(" AND actiontype = ?");
			objs.add(actiontype);
		}
		if (StringUtils.isNotBlank(recStatus)) {
			queryHql.append(" AND recStatus = ?");
			objs.add(recStatus);
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			queryHql.append(" AND approveStatus = ?");
			objs.add(approveStatus);
		}
		if (StringUtils.isNotBlank(repStatus)) {
			queryHql.append(" AND repStatus >= ?");
			objs.add(repStatus);
		}
		if (StringUtils.isNotBlank(filler2)) {
			queryHql.append(" AND filler2 like ?");
			objs.add("%" + filler2 + "%");
		}
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(queryHql.toString());
		queryCondition.setObjArray(objs.toArray());

		// 处理excel导出的数据
		PageQueryResult pageQueryResult = dao.pageQueryByQL(queryCondition);
		List list = pageQueryResult.getQueryResult();
		for (Object o : list) {
			BopCfaExplrmbloDs bopCfaExplrmbloDs = (BopCfaExplrmbloDs) (((Object[]) o)[0]);
			if (StringUtils.isNotBlank(type)) {
				if (type.equalsIgnoreCase(TopReportConstants.REPORT_FILE_TYPE_CFA_EA)) {
					// 签约信息
					bopCfaExplrmbloDs.setExplcurrinfo(ReportCommonService
							.getInstance().getConExplbalainfoToStr(
									bopCfaExplrmbloDs.getId()));
				} else if (type
						.equalsIgnoreCase(TopReportConstants.REPORT_FILE_TYPE_CFA_EB)) {
					bopCfaExplrmbloDs.setExplbalainfo(ReportCommonService
							.getInstance().getChangExplbalainfoToStr(
									bopCfaExplrmbloDs.getId()));
				}
			}
		}
		return pageQueryResult;
	}

	private PageQueryResult pageQueryByHql(int pageIndex, int pageSize,
			String workDate, String actiontype, String recStatus,
			String approveStatus, String repStatus, String filler2,
			String brno, StringBuilder queryhql, List<Object> paralist)
			throws CommonException {
		if (StringUtils.isNotBlank(workDate)) {
			queryhql.append(" AND workDate = ? ");
			paralist.add(workDate);
		}
		if (StringUtils.isNotBlank(actiontype)) {
			queryhql.append(" AND actiontype = ? ");
			paralist.add(actiontype);
		}
		if (StringUtils.isNotBlank(recStatus)) {
			queryhql.append(" AND recStatus = ? ");
			paralist.add(recStatus);
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			queryhql.append(" AND approveStatus = ? ");
			paralist.add(approveStatus);
		}
		if (StringUtils.isNotBlank(repStatus)) {
			queryhql.append(" AND repStatus = ? ");
			paralist.add(repStatus);
		}
		if (StringUtils.isNotBlank(filler2)) {
			queryhql.append(" AND filler2 LIKE ? ");
			paralist.add("%" + filler2 + "%");
		}
		// 只查询当前分行数据
		if (StringUtils.isNotBlank(brno)) {
			queryhql.append(" AND brNo = ? ");
			paralist.add(brno);
		}

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(queryhql.toString());
		queryCondition.setObjArray(paralist.toArray(new Object[0]));
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult result = hqlDAO.pageQueryByQL(queryCondition);
		return result;
	}

	// add by huangcheng 补录查询中workDate 变成时间段查询
	private PageQueryResult pageQueryByHql(int pageIndex, int pageSize,
			String workDateStart, String workDateEnd, String actiontype,
			String recStatus, String approveStatus, String repStatus,
			String filler2, String brno, StringBuilder queryhql,
			List<Object> paralist) throws CommonException {
		if (StringUtils.isNotBlank(workDateStart)) {
			queryhql.append(" AND workDate >= ? ");
			paralist.add(workDateStart);
		}
		if (StringUtils.isNotBlank(workDateEnd)) {
			queryhql.append(" AND workDate <= ? ");
			paralist.add(workDateEnd);
		}
		if (StringUtils.isNotBlank(actiontype)) {
			queryhql.append(" AND actiontype = ? ");
			paralist.add(actiontype);
		}
		if (StringUtils.isNotBlank(recStatus)) {
			queryhql.append(" AND recStatus = ? ");
			paralist.add(recStatus);
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			queryhql.append(" AND approveStatus = ? ");
			paralist.add(approveStatus);
		}
		if (StringUtils.isNotBlank(repStatus)) {
			queryhql.append(" AND repStatus = ? ");
			paralist.add(repStatus);
		}
		if (StringUtils.isNotBlank(filler2)) {
			queryhql.append(" AND filler2 LIKE ? ");
			paralist.add("%" + filler2 + "%");
		}

		if (StringUtils.isNotBlank(brno)) {
			queryhql.append(" AND brNo = ? ");
			paralist.add(brno);
		}
		queryhql.append(" order by lstUpdTm desc ");
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(queryhql.toString());
		queryCondition.setObjArray(paralist.toArray(new Object[0]));
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult result = hqlDAO.pageQueryByQL(queryCondition);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public BopCfaExplrmbloDs load(String uuid) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(
				" FROM BopCfaExplrmbloDs WHERE id = ? ", new Object[] { uuid },
				null);
		if (!list.isEmpty()) {
			return (BopCfaExplrmbloDs) list.get(0);
		}
		return null;
	}

	public BopCfaExplrmbloDs loadChangeInfo(String uuid) throws CommonException {
		BopCfaExplrmbloDs changeinfo = load(uuid);
		if (null != changeinfo) {
			BopCfaExplrmbloDs parent = load(changeinfo.getFiller1());
			if (null != parent) {
				setChildByParent(changeinfo, parent);
			}
		}
		return changeinfo;
	}

	public void setChildByParent(BopCfaExplrmbloDs child,
			BopCfaExplrmbloDs parent) {
		child.setDebtorcode(parent.getDebtorcode());
		child.setCreditorcode(parent.getCreditorcode());
		child.setDebtorname(parent.getDebtorname());
		child.setValuedate(parent.getValuedate());
		child.setMaturity(parent.getMaturity());
		child.setCredconcurr(parent.getCredconcurr());
		child.setExplcurr(parent.getExplcurr());
		child.setCredconamount(parent.getCredconamount());
		child.setExplamount(parent.getExplamount());
	}

	public void setFiledNull(BopCfaExplrmbloDs bopcfa) {
		bopcfa.setDebtorcode(null);
		bopcfa.setCreditorcode(null);
		bopcfa.setDebtorname(null);
		bopcfa.setValuedate(null);
		bopcfa.setMaturity(null);
		bopcfa.setCredconcurr(null);
		bopcfa.setExplcurr(null);
		bopcfa.setCredconamount(null);
		bopcfa.setExplamount(null);
	}

	public void update(BopCfaExplrmbloDs bopcfa) throws CommonException {
		bopcfa.setActiondesc(null);
		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(),
				bopcfa.getCurrentfile(), bopcfa);

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		rootdao.update(bopcfa);
	}

	public void deleteChangeInfo(BopCfaExplrmbloDs bopcfa)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));
		// add by huangcheng 2012-10-26 数据验证
		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(),
				bopcfa.getCurrentfile(), bopcfa);

		rootdao.update(bopcfa);
	}

	public void delete(BopCfaExplrmbloDs bopcfa) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		// 查询 BopCfaExplrmbloDs 文件类型为 外汇质押人民币贷款—变动信息 并且没有被删除的 变动信息
		StringBuilder hql = new StringBuilder(
				" SELECT COUNT(*) FROM BopCfaExplrmbloDs WHERE filler1 = '").append(bopcfa.getId())
				.append("' AND currentfile = '").append(TopReportConstants.REPORT_FILE_TYPE_CFA_EB)
				.append("' AND recStatus <> '").append(TopReportConstants.REPORT_RECSTATUS_07).append("' ");

		int count = rootdao.queryByHqlToCount(hql.toString());
		if (0 < count) {
			ExceptionUtil.throwCommonException("该签约信息存在变动信息不可删除");
		}

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		rootdao.update(bopcfa);
	}

	public void save(BopCfaExplrmbloDs bopcfa) throws CommonException {
		bopcfa.setId(ReportUtils.getUUID());
		bopcfa.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));
		bopcfa.setCrtTm(new Date());
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		// add by huangcheng 2012-10-26 数据验证
		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(),
				bopcfa.getCurrentfile(), bopcfa);

		rootdao.save(bopcfa);
	}

	public void saveChangeInfo(BopCfaExplrmbloDs bopcfa) throws CommonException {

		bopcfa.setId(ReportUtils.getUUID());
		bopcfa.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));

		bopcfa.setCrtTm(new Date());

		StringBuilder hql = new StringBuilder(
				" SELECT COUNT(*) FROM BopCfaExplrmbloDs WHERE currentfile = '")
				.append(bopcfa.getCurrentfile()).append("' AND buscode = '")
				.append(bopcfa.getBuscode()).append("' AND actiontype <> '")
				.append(TopReportConstants.REPORT_ACTIONTYPE_D).append("' ");

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int count = rootdao.queryByHqlToCount(hql.toString());
		if (0 < count) {
			ExceptionUtil.throwCommonException("已有相同银行业务参号的记录");
		}
		setFiledNull(bopcfa);
		// add by huangcheng 2012-10-26 数据验证
		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(),
				bopcfa.getCurrentfile(), bopcfa);

		rootdao.save(bopcfa);
	}

	public void updateChangeInfo(BopCfaExplrmbloDs bopcfa)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		StringBuilder hql = new StringBuilder(
				" SELECT COUNT(*) FROM BopCfaExplrmbloDs WHERE currentfile = '")
				.append(bopcfa.getCurrentfile()).append("' AND buscode = '")
				.append(bopcfa.getBuscode()).append("' AND actiontype <> '")
				.append(TopReportConstants.REPORT_ACTIONTYPE_D)
				.append("' AND id <> '").append(bopcfa.getId()).append("' ");
		int count = rootdao.queryByHqlToCount(hql.toString());
		if (0 < count) {
			ExceptionUtil.throwCommonException("已有相同银行业务参号的记录");
		}

		bopcfa.setActiondesc(null);
		setFiledNull(bopcfa);

		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		bopcfa.setLstUpdTlr(ginfo.getTlrno());
		bopcfa.setLstUpdTm(new Date());
		bopcfa.setBrNo(ginfo.getBrno());
		bopcfa.setWorkDate(DateUtil.dateToNumber(ginfo.getTxdate()));
		// add by huangcheng 2012-10-26 数据验证
		ReportDataVaildUtil.executeVaild(bopcfa.getApptype(),
				bopcfa.getCurrentfile(), bopcfa);

		rootdao.update(bopcfa);
	}

	public void approved(List<BopCfaExplrmbloDs> bopcfaList)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for (BopCfaExplrmbloDs bopcfa : bopcfaList) {
			bopcfa.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			rootdao.update(bopcfa);
		}
	}
}