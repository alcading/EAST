package com.huateng.report.system.dataanaly.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import resource.bean.report.BopAccDs;
import resource.bean.report.RbsDsBiBalance;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.dataAnaly.bean.DataAnalysisTool;
import com.huateng.report.dataAnaly.util.ReportDataAnalyUtil;
import com.huateng.report.utils.ReportUtils;

public class BalanceDataAnalysis extends DataAnalysisTool {
	/**
	 * 查询从上个工作日期后当当天的所有余额数据, 得到这段时间内的 累积 收入和支出的总额。
	 * 按 branchcode, partynumber, currencycode 分组 后 将 totaldtbal，  totalcrbal 两列分别 进行 加总
	 */
	private static final String SEARCH_TODAY_DR_CR = " SELECT branchcode, partynumber, currencycode, SUM(totaldtbal), SUM(ABS(totalcrbal)) FROM Rbs_Ds_Bi_Balance WHERE currencycode <> ? AND dealdate > ? AND dealdate <= ? GROUP BY branchcode, partynumber, currencycode ";
	/**
	 * 查询 当前 工作日余额数据
	 */
	private static final String SEARCH_TODAY_BALANCE = " FROM RbsDsBiBalance WHERE currencycode <> ? AND dealdate = ? AND (branchcode || partynumber || currencycode) IN ";
	/**
	 * 获取和余额相关联的开户信息
	 */
	private static final String SEARCH_ACCOUNT_BY_BALANCE = " FROM BopAccDs WHERE currentfile = ? AND accountno || currencyCode IN ";
	/**
	 * 查询 从上个工作日期后当当天的所有余额记录的总条数
	 * 如果 branchcode, partynumber, currencycode 相同则为同一条
	 */
	private static final String SEARCH_COUNT_TODAY_DR_CR = " SELECT COUNT(*) FROM ( " + SEARCH_TODAY_DR_CR + " ) ";
	/**
	 * 币种，人民币
	 */
	private static final String CNY_CURRENCY = "CNY";
	/**
	 * 将上一工作日期格式化成字符串
	 */
	private static final String DATE_FORMAT = "yyyyMMdd";
	/**
	 * 每次用IN 查询的最大记录数
	 */
	private static final int PAGE_SIZE = 100;

	@SuppressWarnings("unchecked")
	public Map<String, Object> executeAnalysis(Map<String, Object> paramMap)
			throws CommonException {

		String workdate = String.valueOf(paramMap.get(ReportDataAnalyUtil.PARAM_WORK_DATE));

		AccountDataAnalysis analysis = new AccountDataAnalysis();
		Map<String, String> branchCodeMap = analysis.findAllBankCode();
		Map<String, String>branchnameMap = analysis.getAllBankName();

		Map<String, BopAccDs>balanceMap = new HashMap<String, BopAccDs>();
		Map<String, String>accountMap = new HashMap<String,String>();

		/** 将上一工作日期格式化成字符串  */
		String lastworkingdate = DateFormatUtils.format(com.huateng.ebank.framework.util.DateUtil.getBhDate(), DATE_FORMAT);
		/** 设置查询条件  */
		Object[] paraments = new Object[]{CNY_CURRENCY, lastworkingdate, workdate};
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		/** 获取当前记录可以分成几页 */
		int pagenumber = getPageNumber(rootdao, paraments);

		PageQueryCondition queryCondition = getQueryCondition(paraments);
		for(int i = 1; i <= pagenumber ; i++){

			queryCondition.setPageIndex(i);

			PageQueryResult qresult = rootdao.pageQueryBySQL(queryCondition);
			List<Object[]>list = qresult.getQueryResult();

			String key = null;
			BopAccDs balance = null;
			for (Object[] values : list) {
				/** 生产收支余额数据 */
				balance = getBalanceData(workdate, analysis, branchCodeMap, branchnameMap, values);

				/** 获取当前余额的主键，主键 Accountno + CurrencyCode */
				key = getBalanceDataPK(balance);
				balanceMap.put(key, balance);
			}
			if(!balanceMap.isEmpty()){
				/** 获取余额对应的帐户信息  */
				accountMap.putAll(getAccountDataByAccountno(rootdao,balanceMap.keySet()));
			}

			String condition = ReportUtils.toInString(balanceMap.keySet());

			/** 获取当前工作日期的余额  */
			Iterator<RbsDsBiBalance>balanceiter = rootdao.queryByQL(SEARCH_TODAY_BALANCE + condition, new Object[]{CNY_CURRENCY, workdate}, null);
			String pk = null;

			RbsDsBiBalance rbsbalance = null;
			while(balanceiter.hasNext()){
				rbsbalance = balanceiter.next();
				pk = getBalanceDataPK(rbsbalance);
				if(balanceMap.containsKey(pk)){
					BopAccDs drcr = balanceMap.get(pk);
					drcr.setBalance(rbsbalance.getValuebal());
					String accountid = accountMap.get(getBalanceDataPK(drcr));
					if(null != accountid){
						drcr.setFiller1(accountid);
						rootdao.save(drcr);
					}
				}
			}
			accountMap.clear();
			balanceMap.clear();
		}
		return null;
	}

	/**
	 * 生成余额数据
	 * @param workdate
	 * @param analysis
	 * @param branchCodeMap
	 * @param branchnameMap
	 * @param values
	 * @return
	 */
	private BopAccDs getBalanceData(String workdate,
			AccountDataAnalysis analysis, Map<String, String> branchCodeMap,
			Map<String, String> branchnameMap, Object[] values) {

		BopAccDs balance = new BopAccDs();
		balance.setId(ReportUtils.getUUID());
		setSystemInfo(balance);
		String branchcode = branchCodeMap.get(values[0]);
		if (StringUtils.isNotEmpty(branchcode)) {
			balance.setBranchCode(branchcode);
			balance.setBrNo(branchcode);
			balance.setBranchName(branchnameMap.get(branchcode));
		}
		balance.setWorkDate(workdate);//设置工作日期
		balance.setDealDate(workdate);//设置交易日期
		if (null != values[0] && null != values[1]) {
			balance.setAccountno(analysis.getAccountNumber(String.valueOf(values[0]), String.valueOf(values[1])));
		}
		if (null != values[2]) {
			balance.setCurrencyCode(String.valueOf(values[2]));
		}
		if (null != values[3]) {
			balance.setDebit(new BigDecimal(String.valueOf(values[3])));
		}
		if (null != values[4]) {
			balance.setCredit(new BigDecimal(String.valueOf(values[4])));
		}
		return balance;
	}

	/**
	 * 获取查询条件
	 * @param paraments
	 * @return
	 */
	private PageQueryCondition getQueryCondition(Object[] paraments) {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageSize(PAGE_SIZE);//分页数
		queryCondition.setQueryString(SEARCH_TODAY_DR_CR);//查询语句
		queryCondition.setObjArray(paraments);//查询条件
		return queryCondition;
	}

	/**
	 * 获取当前页数
	 * @param rootdao
	 * @param paraments
	 * @return
	 * @throws CommonException
	 */
	private int getPageNumber(ROOTDAO rootdao, Object[] paraments)
			throws CommonException {
		/** 查询当天账户余额记录的总记录数  */
		int totalrecords = Integer.parseInt(String.valueOf(rootdao.queryBySQL(SEARCH_COUNT_TODAY_DR_CR, paraments, null).next()));

		PageQueryResult result = new PageQueryResult();
		result.setTotalCount(totalrecords);
		int pagenumber = result.getPageCount(PAGE_SIZE);//分页查询的记录数
		return pagenumber;
	}

	/**
	 * 获取RBS源数据中的余额信息的主键，主键 Branchcode + Partynumber + Currencycode
	 * @param balance
	 * @return
	 */
	private String getBalanceDataPK(RbsDsBiBalance balance) {
		String pk = balance.getBranchcode() + balance.getPartynumber() + balance.getCurrencycode();
		return pk;
	}

	/**
	 * 获取当前余额的主键，主键 Accountno + CurrencyCode
	 * @param balance
	 * @return
	 */
	private String getBalanceDataPK(BopAccDs balance) {
		String pk = balance.getAccountno() + balance.getCurrencyCode();
		return pk;
	}

	/**
	 * @param rootdao
	 * @param rbsaccountList
	 * @param branchCodeMap
	 * @param workdate
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> getAccountDataByAccountno(ROOTDAO rootdao, Collection<String> accountList) throws CommonException {

		String condition = ReportUtils.toInString(accountList);
		Iterator<BopAccDs>iter = rootdao.queryByQL(SEARCH_ACCOUNT_BY_BALANCE + condition, new Object[]{TopReportConstants.REPORT_FILE_TYPE_CFA_CA}, null);
		Map<String, String>accountMap = new HashMap<String, String>();
		BopAccDs account = null;
		while(iter.hasNext()) {
			account = iter.next();
			accountMap.put(getBalanceDataPK(account), account.getId());
		}
		return accountMap;
	}

	/**
	 * 设置系统信息的默认值
	 * @param balence
	 */
	private void setSystemInfo(BopAccDs balance) {
		balance.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		balance.setRecStatus(TopReportConstants.REPORT_RECSTATUS_01);

		balance.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		balance.setRepStatus(TopReportConstants.REPORT_APPROVESTATUS_00);

		balance.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);//没有成功上报
		balance.setApptype(TopReportConstants.REPORT_APP_TYPE_ACC);
		balance.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_ACC_CB);

		balance.setCrtTm(new Date());
	}
}