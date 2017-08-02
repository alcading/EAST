package com.huateng.report.workconfirmed.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import resource.bean.pub.DataDic;
import resource.bean.report.BiExecConfirm;
import resource.bean.report.BiExecConfirmPK;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.dataquery.bean.SupplyEnterVerifyStateQueryBean;
import com.huateng.report.utils.ReportUtils;

/**
 * operation for save query delete add
 * @author cwenao
 * @date 2012-09-20
 * */

public class BopForWorkConfirmedService {
	private static final String DATASET_ID="com.huateng.report.workconfirmed.service.BopForWorkConfirmedService";
	private static final String HQL_TABLENAME = "TABLENAME";
	private static final String SEARCH_ALL_BCTL = " SELECT brno FROM Bctl ORDER BY brno ";

	private ROOTDAO rootDao ;
	private HtLog htLog = HtLogFactory.getLogger(BopForWorkConfirmedService.class);

	public synchronized static BopForWorkConfirmedService getInstance() {
		return (BopForWorkConfirmedService) ApplicationContextUtils.getBean(DATASET_ID);
		}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	public BiExecConfirm load(BiExecConfirmPK id) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();

		return (BiExecConfirm)rootDao.query(BiExecConfirm.class, id);
	}

	public void doConfirmed(BiExecConfirm biExecCon) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();

		BiExecConfirm biExecConTemp = (BiExecConfirm) rootDao.query(BiExecConfirm.class, biExecCon.getId());

		if(TopReportConstants.REPORT_SUBFILE_STATUS_01.equalsIgnoreCase(biExecConTemp.getSubfileStatus()))
		{
			ExceptionUtil.throwCommonException("工作完成上报状态为【已锁定】,工作完成确认状态为不能更改为【已确认】");
		}

		rootDao.saveOrUpdate(biExecCon);

	}

	public void doCancel(BiExecConfirm biExecCon) throws CommonException {


		rootDao= ROOTDAOUtils.getROOTDAO();
		BiExecConfirm biExecConTemp = (BiExecConfirm) rootDao.query(BiExecConfirm.class, biExecCon.getId());

		if(TopReportConstants.REPORT_SUBFILE_STATUS_01.equalsIgnoreCase(biExecConTemp.getSubfileStatus()))
		{
			ExceptionUtil.throwCommonException("工作完成上报状态为【已锁定】,工作完成确认状态不能更改为【已确认】");
		}

		rootDao.saveOrUpdate(biExecCon);

	}

	@SuppressWarnings("unchecked")
	public List<SupplyEnterVerifyStateQueryBean> pageQueryByHql(String workdate, String brno,String busiType, String apptype,String currentfile, String isShowZero) throws CommonException {

		/**
		 * 并接SQL语句，按照BRNO, APPTYPE, CURRENTFILE, RECSTATUS进行分组，然后取每组的记录数
		 */
		StringBuilder countHql = new StringBuilder();
		countHql.append(" SELECT brNo, apptype, currentfile, recStatus, count(*) AS stacount FROM ").append(HQL_TABLENAME).append(" WHERE workDate = ? AND repStatus <> ? ");
		List<Object>paralist = new ArrayList<Object>();
		paralist.add(workdate);
		paralist.add(TopReportConstants.REPORT_REPSTATUS_01);
		if (StringUtils.isNotEmpty(brno)){
			countHql.append(" AND brNo = ? ");
			paralist.add(brno);
		}
		if (StringUtils.isNotEmpty(currentfile)){
			countHql.append(" AND currentfile = ? ");
			paralist.add(currentfile);
		}
		countHql.append(" GROUP BY brNo, apptype, currentfile, recStatus ORDER BY brNo");

		ReportCommonService reportCommonService = ReportCommonService.getInstance();
		Map<String, List<DataDic>> map = reportCommonService.getAppAndFileTypeByDataDic(busiType, apptype, currentfile);

		Set<String> tablenameSet = ReportUtils.getTableName(map);//获取表名

		List<SupplyEnterVerifyStateQueryBean> list = new ArrayList<SupplyEnterVerifyStateQueryBean>();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for (String tablename : tablenameSet) {
			String hql = countHql.toString().replaceAll(HQL_TABLENAME, StringUtils.trim(tablename));
			List<Object[]>groupList = rootdao.queryByQL2List(hql, paralist.toArray(), null);
			for (Object[] obj : groupList) {
				list.add(createQueryBean(workdate, groupList, obj));
			}
		}

		Map<String, SupplyEnterVerifyStateQueryBean> querymap = assembleQueryBean(list);


		querymap = generateEmptyRecord(workdate, brno, isShowZero, map, querymap);
		list = new ArrayList(querymap.size());
		list.addAll(querymap.values());

		/**
		 * 按照BRNO,APPTYPE, CURRENTFILE依次对集合进行排序
		 */
		Collections.sort(list, new Comparator<SupplyEnterVerifyStateQueryBean>(){
			public int compare(SupplyEnterVerifyStateQueryBean o1,
					SupplyEnterVerifyStateQueryBean o2) {
				int result = o1.getBrNo().compareTo(o2.getBrNo());
				if(0 == result){
					result = o1.getApptype().compareTo(o2.getApptype());
					if(0 == result){
						return o1.getCurrentfile().compareTo(o2.getCurrentfile());
					}
					return result;
				}
				return result;
			}
		});

		return list;

	}


	@SuppressWarnings("unchecked")
	private SupplyEnterVerifyStateQueryBean createQueryBean(String workdate, List groupList, Object[] obj) {

		SupplyEnterVerifyStateQueryBean bean = new SupplyEnterVerifyStateQueryBean();
		bean.setWorkDate(workdate);
		bean.setBrNo(String.valueOf(obj[0]));
		bean.setApptype(String.valueOf(obj[1]));
		bean.setCurrentfile(String.valueOf(obj[2]));
		String recstatus = String.valueOf(obj[3]);
		int count = Integer.parseInt(obj[4].toString());
		if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_01)) {
			bean.setNoedit(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_02)) {
			bean.setEditWaitConfirm(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_03)) {
			bean.setConfirmWaitAudit(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_04)) {
			bean.setAuditWaitConfirm(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_05)) {
			bean.setConfirmPass(count);
		} else if (StringUtils.equals(recstatus, TopReportConstants.REPORT_RECSTATUS_06)) {
			bean.setSendreport(count);
		}
		return bean;
	}

	/**
	 * 将查询出的数据进行统计，将同一brno,apptype,currentfile的记录组合成一条记录
	 * @param list
	 * @return
	 */
	private Map<String, SupplyEnterVerifyStateQueryBean> assembleQueryBean(
			List<SupplyEnterVerifyStateQueryBean> list) {
		Map<String, SupplyEnterVerifyStateQueryBean> querymap = new HashMap<String, SupplyEnterVerifyStateQueryBean>();
		SupplyEnterVerifyStateQueryBean beanInMap = null;
		for (SupplyEnterVerifyStateQueryBean bean : list) {
			String key = bean.getBrNo() + "*" + bean.getApptype() + "*" + bean.getCurrentfile();
			if (null != (beanInMap = querymap.get(key))) {
				beanInMap.setNoedit(beanInMap.getNoedit() + bean.getNoedit());
				beanInMap.setEditWaitConfirm(beanInMap.getEditWaitConfirm() + bean.getEditWaitConfirm());
				beanInMap.setConfirmWaitAudit(beanInMap.getConfirmWaitAudit() + bean.getConfirmWaitAudit());
				beanInMap.setAuditWaitConfirm(beanInMap.getAuditWaitConfirm() + bean.getAuditWaitConfirm());
				beanInMap.setConfirmPass(beanInMap.getConfirmPass() + bean.getConfirmPass());
				beanInMap.setSendreport(beanInMap.getSendreport() + bean.getSendreport());
			} else {
				querymap.put(key, bean);
			}
		}
		return querymap;
	}
	/**
	 * 如果 是否显示审核为0的数据 选择了是 ，则按照BCTL的机构号码对没有查询出的机构组成新的记录数位0的记录
	 * @param workdate
	 * @param brno
	 * @param isShowZero
	 * @param map
	 * @param querymap
	 * @return
	 * @throws CommonException
	 */
	private Map<String, SupplyEnterVerifyStateQueryBean> generateEmptyRecord(String workdate,
			String brno, String isShowZero, Map<String, List<DataDic>> map,
			Map<String, SupplyEnterVerifyStateQueryBean> querymap) throws CommonException {
		if (StringUtils.equals(isShowZero, "1")) {
			List<String> branchList = getBranchcodeList(brno);
			for (Iterator<Entry<String, List<DataDic>>> iter = map.entrySet().iterator(); iter.hasNext();) {
				Entry<String, List<DataDic>> entry = iter.next();
				List<DataDic> ddList = entry.getValue();
				for (DataDic dd : ddList) {
					for (String branchcode : branchList) {
						String key = branchcode + "*" + entry.getKey() + "*" + dd.getDataNo();
						if (!querymap.containsKey(key)) {
							SupplyEnterVerifyStateQueryBean bean = new SupplyEnterVerifyStateQueryBean();
							bean.setApptype(entry.getKey());
							bean.setCurrentfile(dd.getDataNo());
							bean.setBrNo(branchcode);
							bean.setWorkDate(workdate);
							querymap.put(key, bean);
						}
					}
				}
			}
		}
		return querymap;
	}
	/**
	 * 如果 已经选择了 所属机构 ，则按照 用户在页面上选的机构号查询，否则，查询所有机构
	 * @param brno
	 * @param rootdao
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	private List<String> getBranchcodeList(String brno) throws CommonException {
		List<String> branchList = null;
		if (StringUtils.isNotEmpty(brno)) {
			branchList = new ArrayList<String>();
			branchList.add(brno);
		} else {
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			branchList = rootdao.queryByQL2List(SEARCH_ALL_BCTL);
		}
		return branchList;
	}
}
