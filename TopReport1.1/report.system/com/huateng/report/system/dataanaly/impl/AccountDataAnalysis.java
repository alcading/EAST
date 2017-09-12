package com.huateng.report.system.dataanaly.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import resource.bean.pub.Bctl;
import resource.bean.report.BopAccDs;
import resource.bean.report.RbsBranchCodeMapp;
import resource.bean.report.RbsDsBiAccount;
import resource.bean.report.RbsDsBiCustomer;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.dataAnaly.bean.DataAnalysisTool;
import com.huateng.report.dataAnaly.util.ReportDataAnalyUtil;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class AccountDataAnalysis extends DataAnalysisTool{

	/**
	 * 根据工作日期查询所有当天开户的账号
	 */
	private static final String SEARCH_ACCOUNT_DATA_BY_OPENDATE = " FROM RbsDsBiAccount WHERE opendate = ? AND currencycode <> ?";
	/**
	 * 根据工作日期查询所有当天关户的账号
	 */
	private static final String SEARCH_ACCOUNT_DATA_BY_CLOSEDATE = " FROM RbsDsBiAccount WHERE closedate = ? AND currencycode <> ?";
	/**
	 * 得到所有银行分行号码
	 */
	private static final String SEARCH_RBS_BRANCE_CODE_MAPPING = " FROM RbsBranchCodeMapp ";
	/**
	 * 每次用IN 查询的最大记录数
	 */
	private static final int PAGE_SIZE = 500;
	/**
	 * 人民币代码
	 */
	private static final String CURRENCY_CNY = "CNY";

	/**
	 * 得到所有分行信息
	 */
	private static final String SEARCH_ALL_BCTL = " FROM Bctl";

	public Map<String, Object> executeAnalysis(Map<String, Object> paramMap)
			throws CommonException {

		String workdate = String.valueOf(paramMap.get(ReportDataAnalyUtil.PARAM_WORK_DATE));

		getBopAccDsByOpendate(workdate);

		getBopAccDsByClosedate(workdate);

		return Collections.emptyMap();
	}

	@SuppressWarnings("unchecked")
	private void getBopAccDsByClosedate(String workdate) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		/** 查询所有关户日期为当前工作日期,币种不为CNY 的开户信息 */
		List<RbsDsBiAccount>rbsaccountList = rootdao.queryByQL2List(SEARCH_ACCOUNT_DATA_BY_CLOSEDATE, new Object[]{workdate, CURRENCY_CNY}, null);

		/** 查找所有RBS内部的分行编号与金融机构编码的对照关系 */
		Map<String, String>branchCodeMap = findAllBankCode();

		batchUpdateData(rootdao, rbsaccountList, branchCodeMap, workdate);
	}

	/**
	 * 批量 修改 账户信息表的 账户状态设为关户，将工作日期和业务发生日期设为当前工作日期
	 * @param rootdao
	 * @param rbsaccountList
	 * @param branchCodeMap
	 * @param workdate
	 */
	private void batchUpdateData(ROOTDAO rootdao, List<RbsDsBiAccount> rbsaccountList,
			Map<String, String> branchCodeMap, String workdate) {

		String hql = " UPDATE BopAccDs SET accountstat = '"+TopReportConstants.CLOSE_ACCOUNT_TYPE_13+"' , businessDate = '"+workdate+"' , workDate = '"+workdate+"' WHERE (branchCode || accountno || currencyCode) IN  " ;

		/** 用于存放需要修改的记录的唯一标示，由 branchCode + accountno + currencyCode 组成 */
		List<String> keyList = new LinkedList<String>();
		for (RbsDsBiAccount rbsaccount : rbsaccountList) {
			String branchcode = branchCodeMap.get(rbsaccount.getBranchcode());
			keyList.add(branchcode + getAccountNumber(rbsaccount.getBranchcode(), rbsaccount.getAccountnumber()) + rbsaccount.getCurrencycode());
			if (PAGE_SIZE == keyList.size()) {
				String condition = ReportUtils.toInString(keyList);
				String updatehql = hql + condition;
				rootdao.getHibernateTemplate().execute(new UpdateBopAccDs(updatehql));
				keyList.clear();
			}
		}

		if (!keyList.isEmpty()) {
			String condition = ReportUtils.toInString(keyList);
			String updatehql = hql + condition;
			rootdao.getHibernateTemplate().execute(new UpdateBopAccDs(updatehql));
			keyList.clear();
		}
	}

	private class UpdateBopAccDs implements HibernateCallback {
		private String hql;

		public UpdateBopAccDs(String hql){
			this.hql = hql;
		}

		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			int count = session.createQuery(hql).executeUpdate();
			if(0 < count) {
				return true;
			}
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	private void getBopAccDsByOpendate(String workdate) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		/** 查询所有开户日期为当前工作日期，币种不为CNY	的开户信息 */
		List<RbsDsBiAccount>rbsaccountList = rootdao.queryByQL2List(SEARCH_ACCOUNT_DATA_BY_OPENDATE, new Object[]{workdate, CURRENCY_CNY}, null);

		/** 查找所有RBS内部的分行编号与金融机构编码的对照关系 */
		Map<String, String>branchCodeMap = findAllBankCode();

		/** 查找所有分行信息 */
		Map<String, String>branchNameMap = getAllBankName();

		/** 获取与当前需要上报的开户信息相关的客户信息，用RbsDsBiAccount的Branchcode+Partynumber和RbsDsBiCustomer的branchcode + partynumber 进行关联 */
		Map<String, RbsDsBiCustomer> customerMap = getCustomerByAccount(rbsaccountList);

		BopAccDs accountopen = null;
		RbsDsBiCustomer customer = null;
		for (RbsDsBiAccount rbsaccount : rbsaccountList) {

			/** 获取与RBS银行代码相对应的金融机构编码 */
			String branchcode = branchCodeMap.get(rbsaccount.getBranchcode());
			/** 获取金融机构编码相对应的分行名称 */
			String branchname = branchNameMap.get(branchcode);
			/** 根据 RBS银行代码+账号查询出相应的客户信息 */
			customer = customerMap.get(rbsaccount.getBranchcode()+ rbsaccount.getPartynumber());


			accountopen = new BopAccDs();
			accountopen.setId(ReportUtils.getUUID());
			/** 设置系统信息的默认值  */
			setSystemInfo(accountopen);

			/** 生成账号 */
			accountopen.setAccountno(getAccountNumber(rbsaccount.getBranchcode(), rbsaccount.getAccountnumber()));

			accountopen.setBranchCode(branchcode);
			accountopen.setBranchName(branchname);
			accountopen.setWorkDate(workdate);
			accountopen.setBrNo(branchcode);

			if (null != customer) {
				accountopen.setEnCode(customer.getIdcardnumber());
				/** 获取客户名称，如果有中文名称则优先使用中文名称，否则使用英文名称 */
				accountopen.setEnName(getEnname(customer));
				/** 获取开户主体类型 */
				accountopen.setAmtype(getAmtype(rbsaccount.getBranchcode(), customer));
			}
			accountopen.setAccountType(rbsaccount.getReferencenumber());

			accountopen.setCurrencyCode(rbsaccount.getCurrencycode());
			accountopen.setBusinessDate(rbsaccount.getOpendate());

			accountopen.setFileNumber(rbsaccount.getCreditcardnumber());
			accountopen.setAccountLimit(rbsaccount.getLocalextention());

			/** 由于RBS源数据不会提供,所以默认将账户类别设为 12-现汇 */
			accountopen.setAccountCata(TopReportConstants.ACCOUNT_CATA_SPOT_EXCHANGE_12);
			/** 由于RBS源数据不会提供,所以默认将限额类型设为 13-贷方流入限额 */
			accountopen.setLimitType(TopReportConstants.CREDIT_INTO_LIMIT_13);
			/** 由于是开户信息所以将账户状态设为 11-开户 */
			accountopen.setAccountstat(TopReportConstants.OPEN_ACCOUNT_TYPE_11);

			rootdao.save(accountopen);
		}
	}

	/**
	 * 获取客户名称，如果有中文名称则优先使用中文名称，否则使用英文名称
	 * @param customer
	 * @return
	 */
	private String getEnname(RbsDsBiCustomer customer) {
		String customername = customer.getPartynameinlocal();
		if (StringUtils.isEmpty(customername)) {
			customername = customer.getPartyname();
		}
		return customername;
	}

	/**
	 * RBS的账户是有3位的分行号码+12位的账号组成
	 * @param branchcode 3位 的分行号码
	 * @param accountnumber 12位的账号组成
	 * @return
	 */
	public String getAccountNumber(String branchcode, String accountnumber) {
		if (StringUtils.isNotEmpty(branchcode) && StringUtils.isNotEmpty(accountnumber)) {
			return branchcode + accountnumber;
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 设置系统信息的默认值
	 * @param accountopen
	 */
	private void setSystemInfo(BopAccDs accountopen) {
		accountopen.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
		accountopen.setRecStatus(TopReportConstants.REPORT_RECSTATUS_01);

		accountopen.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
		accountopen.setRepStatus(TopReportConstants.REPORT_APPROVESTATUS_00);

		accountopen.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);//没有成功上报
		accountopen.setApptype(TopReportConstants.REPORT_APP_TYPE_ACC);
		accountopen.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_ACC_CA);

		accountopen.setCrtTm(new Date());
	}

	/**
	 * 设置开户主体类型
	 *
	 * BranchCode为700,701,702,703,704,705,720,721,722,723 并且customer.residentialCountry截取前3位如果为778   12-对私居民
	 * BranchCode为700,701,702,703,704,705,720,721,722,723 并且customer.residentialCountry截取前3位如果不为778 13-对私非居民
	 * BranchCode不为700,701,702,703,704,705,720,721,722,723 为11-对公
	 * @return
	 */
	private String getAmtype(String branchcode, RbsDsBiCustomer customer){
		ReportEnum.REPORT_RESIDENTS[] residents = ReportEnum.REPORT_RESIDENTS.values();
		for(ReportEnum.REPORT_RESIDENTS resident : residents){
			if(StringUtils.equals(resident.name, branchcode)) {
				if(StringUtils.isNotEmpty(customer.getResidentialcountry())){
					String customertype = StringUtils.substring(customer.getResidentialcountry(), 0, 3);
					if(StringUtils.equals(customertype, "778")){
						return TopReportConstants.CUSTOMER_PRIV_RESIDENT;
					} else {
						return TopReportConstants.CUSTOMER_PRIV_NON_RESIDENT;
					}
				}
			}
		}
		return TopReportConstants.CUSTOMER_COPR;
	}

	/**
	 * 获取所有的RBS的分行号码，以RBSBRANCECODE为KEY,BOPBRANCECODE为VALUE返回HashMap
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String>findAllBankCode() throws CommonException {

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<RbsBranchCodeMapp>mappingList=rootdao.queryByQL2List(SEARCH_RBS_BRANCE_CODE_MAPPING);
		Map<String, String>branchMap = new HashMap<String, String>(mappingList.size());
		for(RbsBranchCodeMapp mapping : mappingList) {
			branchMap.put(mapping.getRbsbranchcode(), mapping.getBranchcode());
		}
		return branchMap;
	}

	/**
	 * 获取RBS所有的金融机构编码
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String>getAllBankName() throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Bctl>bctlList = rootdao.queryByQL2List(SEARCH_ALL_BCTL);
		Map<String, String>bctlMap = new HashMap<String, String>(bctlList.size());
		for (Bctl bctl : bctlList) {
			bctlMap.put(bctl.getBrno(), bctl.getBrname());
		}
		return bctlMap;
	}

	/**
	 * 获取与当前需要上报的开户信息相关的客户信息，用RbsDsBiAccount的Branchcode+Accountnumber和RbsDsBiCustomer的branchcode + partynumber 进行关联
	 */
	@SuppressWarnings("unchecked")
	private Map<String, RbsDsBiCustomer>getCustomerByAccount(List<RbsDsBiAccount>rbsaccountList) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<String>keyList = new ArrayList<String>(PAGE_SIZE);
		Map<String, RbsDsBiCustomer> customerMap = new HashMap<String, RbsDsBiCustomer>();

		for (RbsDsBiAccount rbsaccount : rbsaccountList) {
			String key = rbsaccount.getBranchcode() + rbsaccount.getPartynumber();
			keyList.add(key);
			if (PAGE_SIZE == keyList.size()) {
				String condition = ReportUtils.toInString(keyList);
				List<RbsDsBiCustomer>customerList = rootdao.queryByQL2List(" FROM RbsDsBiCustomer WHERE (branchcode || partynumber) IN " + condition);
				for(RbsDsBiCustomer customer : customerList) {
					String custid = customer.getBranchcode() + customer.getPartynumber();
					customerMap.put(custid, customer);
				}
				keyList.clear();
			}
		}
		if (!keyList.isEmpty()) {
			String condition = ReportUtils.toInString(keyList);
			List<RbsDsBiCustomer>customerList = rootdao.queryByQL2List(" FROM RbsDsBiCustomer WHERE (branchcode || partynumber) IN " + condition);
			for(RbsDsBiCustomer customer : customerList) {
				String custid = customer.getBranchcode() + customer.getPartynumber();
				customerMap.put(custid, customer);
			}
		}
		return customerMap;
	}
}