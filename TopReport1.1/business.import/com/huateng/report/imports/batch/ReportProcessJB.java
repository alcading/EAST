package com.huateng.report.imports.batch;

import java.util.Date;

import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;

import east.dao.JBDao;

/**
 * 生成金标数据主类
 * @author Alca Ding
 */
public class ReportProcessJB {
	
	private JBDao jbDao = null;
	/*
	 * 生成金标数据主方法
	 */
	public void generateData() throws Exception {
		
		Date tbsDay = DateUtil.getTbsDay();
		//判断业务日期是否是每月月末,若是,开始金标批量
		Date monLastDate = DateUtil.getLastDate(tbsDay);
		String monLastDate1 = DataFormat.dateToNumber(monLastDate);
		String monthEndDate = DataFormat.dateToNumber(tbsDay);
		if(monLastDate1.equals(monthEndDate)){
			String monthStartDate = DataFormat.dateToNumber(DateUtil.getFirstDate(tbsDay));
			jbDao = new JBDao();
			cleanData(monthEndDate);
			
			generateDepositBalance(monthEndDate);
			generatePLoanBalance(monthEndDate);
			generatePLoanAccrual(monthStartDate, monthEndDate);
			generateCLoanBalance(monthEndDate);
			generateCLoanAccrual(monthStartDate, monthEndDate);
		}
	}
	
	/*
	 * 清除已跑批数据，以免重跑批并数据重复
	 */
	private void cleanData(String monthEndDate) throws Exception{
		jbDao.deleteJBBatchData(monthEndDate);
	}
	
	/*
	 * 生成存款余额数据方法
	 */
	private void generateDepositBalance(String monthEndDate)throws Exception{
		jbDao.insertDepositBalance(monthEndDate);
	}
	
	/*
	 * 生成个人贷款余额数据方法
	 */
	private void generatePLoanBalance(String monthEndDate) throws Exception{
		jbDao.insertPLoanBalance(monthEndDate);
	}
	
	/*
	 * 生成个人贷款发生额数据方法
	 */
	private void generatePLoanAccrual(String monthStartDate, String monthEndDate) throws Exception{
		jbDao.insertPLoanAccrual(monthStartDate, monthEndDate);
	}
	
	/*
	 * 生成对公贷款余额数据方法
	 */
	private void generateCLoanBalance(String monthEndDate) throws Exception{
		jbDao.insertCLoanBalance(monthEndDate);
	}
	
	/*
	 * 生成对公贷款发生额数据方法
	 */
	private void generateCLoanAccrual(String monthStartDate, String monthEndDate) throws Exception{
		jbDao.insertCLoanAccrual(monthStartDate, monthEndDate);
	}

}
