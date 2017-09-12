package com.huateng.report.system.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import resource.bean.pub.Bctl;
import resource.bean.pub.DataDic;
import resource.bean.pub.Globalinfo;
import resource.bean.report.BiExecConfirm;
import resource.bean.report.BiExecConfirmPK;
import resource.bean.report.BiWorkdate;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.execconfirm.service.BiExecConfirmService;
import com.huateng.report.system.bean.CutoverWorkDateBean;
import com.huateng.report.utils.ReportUtils;

public class BiWorkDateService {

	protected static final Logger logger = Logger.getLogger(BiWorkDateService.class);

	protected BiWorkDateService() {
	}

	public synchronized static BiWorkDateService getInstance() {
		return (BiWorkDateService) ApplicationContextUtils.getBean(BiWorkDateService.class.getName());
	}

	/**
	 * 修改保存工作日期维护
	 * @param year
	 * @param workDateStrs
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public void updateWorkDate(String year, List<String> workDateStrs) throws CommonException{
		//先删除数据库中的数据
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select workDate from BiWorkdate workDate where workDate.id like '" + year + "%'";
		List<BiWorkdate> dbWorkDates = rootdao.queryByQL2List(hql);
		for(BiWorkdate delObj : dbWorkDates){
			rootdao.delete(delObj);
		}

		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		for(String wdStr : workDateStrs){
			BiWorkdate biWorkdate = new BiWorkdate();
			biWorkdate.setId(wdStr);
			biWorkdate.setOperatorId(gi.getTlrno());
			biWorkdate.setWorkFlag(TopReportConstants.REPORT_BIWORKDATE_WORKFLAG_WORK);
			rootdao.save(biWorkdate);
		}

	}

	/**
	 * 根据年份查询日期标识为工作日的列表
	 * @param year
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public List<BiWorkdate> getWorkDateByYear(String year) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select workDate from BiWorkdate workDate where workDate.id like '" + year + "%' and workDate.workFlag=" +
				TopReportConstants.REPORT_BIWORKDATE_WORKFLAG_WORK;
		return rootdao.queryByQL2List(hql);
	}

	/**
	 * 根据当前日期获取下一个工作日期
	 * @param curDate
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public Date getNextWorkDateByCurDate(Date curDate) throws CommonException{
		String curDateStr = DateUtil.dateToNumber(curDate);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select workDate from BiWorkdate workDate where workDate.id > '" + curDateStr + "' and workDate.workFlag=" +
				TopReportConstants.REPORT_BIWORKDATE_WORKFLAG_WORK + " order by workDate.id";
		List<BiWorkdate> list = rootdao.pageQueryByHql(hql, 1, 1);
		if (list.size() <= 0) {
			ExceptionUtil.throwCommonException("topreport.biworkdate.not.init");
		}
		BiWorkdate workdate = list.get(0);
		return DateUtil.stringToDate2(workdate.getId());
	}

	/**
	 * 切换工作日期
	 * @param cutoverWorkDateBean
	 * @throws CommonException
	 */
	public void updateCutoverWorkDate(CutoverWorkDateBean cutoverWorkDateBean) throws CommonException{
		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		// 检查当日业务处理是否执行完成，未完成不能切换。
		String preTxDate = DateUtil.dateToNumber(gi.getTxdate());
		BiExecConfirmService.getInstance().checkExecConfirm(preTxDate);

		//切换日期
		Date nextDate = cutoverWorkDateBean.getNextDate();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String nextDateStr = DateUtil.dateToNumber(nextDate);
		String hql = "select workDate from BiWorkdate workDate where workDate.id = '" + nextDateStr + "' and workDate.workFlag=" +
				TopReportConstants.REPORT_BIWORKDATE_WORKFLAG_WORK;
		List<BiWorkdate> list = rootdao.queryByQL2List(hql);
		if (list.size() == 0) {
			ExceptionUtil.throwCommonException("topreport.cutoverworkdate.not.workdate", new Object[]{DateUtil.dateToString(nextDate)});
		}
		Globalinfo giBean = (Globalinfo) rootdao.query(Globalinfo.class, SystemConstant.TABLE_GLOBAL_INFO_ID);
		giBean.setLbhdate(giBean.getBhdate());
		giBean.setBhdate(giBean.getTbsdy());
		giBean.setTbsdy(nextDate);
		
		giBean = (Globalinfo) rootdao.saveOrUpdate(giBean);

		gi.setTxdate(giBean.getTbsdy());
		gi.setLastDate(giBean.getBhdate());
		
		
		List<Bctl> bctls = BctlService.getInstance().getAllEnableBctl();
		List<String> brNoList = new ArrayList<String>();
		for(Bctl bc : bctls){
			brNoList.add(bc.getBrno());
		}
		List<DataDic> busiTypes = ReportUtils.getBusinessList();

		//生成新的工作完成确认数据
		for(DataDic dd : busiTypes){
			if(dd.getMiscflgs() != null && dd.getMiscflgs().length() > 0){
				List<DataDic> appTypes = ReportCommonService.getInstance().getDataDic(Integer.valueOf(dd.getMiscflgs()));
				for(DataDic ddd : appTypes){
					for(String brNo : brNoList){
						BiExecConfirm biExecConfirm = new BiExecConfirm();
						BiExecConfirmPK id = new BiExecConfirmPK();
						id.setBrNo(brNo);
						id.setApptype(ddd.getDataNo());
						id.setBusiType(dd.getDataNo());
						id.setWorkDate(nextDateStr);
						biExecConfirm.setId(id);
						biExecConfirm.setLstUpdTm(new Date());
						biExecConfirm.setLstUpdTlr(gi.getTlrno());
						biExecConfirm.setConfirmStatus(TopReportConstants.REPORT_CONFRIM_STATUS_02);
						biExecConfirm.setSubfileStatus(TopReportConstants.REPORT_SUBFILE_STATUS_02);
						rootdao.save(biExecConfirm);
					}
				}
			}
		}
	}
}