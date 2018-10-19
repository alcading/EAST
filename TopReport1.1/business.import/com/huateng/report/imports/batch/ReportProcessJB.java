package com.huateng.report.imports.batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.utils.PackZipUtil;
import com.huateng.report.utils.ReportUtils;

import east.dao.BaseDao;
import east.dao.JBDao;
import east.utils.tools.ToolUtils;
import east.utils.tools.XmlUtil;

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
		String jbFilePath = "";
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
		try{
			//生成金标文件路径加年月日路径(个人证件号码md5加密)
			jbFilePath = ReportUtils.getSysParamsValue(Constants.PARAM_DIR,
					Constants.PARAM_DIR_0104, "");
			//jbFilePath = "C:\\Users\\yueya\\Desktop\\jb1"; //本地测试
			generateJBReportFile(jbFilePath,true);
			
			//生成金标文件路径加年月日路径(个人证件号码不加密)
			jbFilePath = ReportUtils.getSysParamsValue(Constants.PARAM_DIR,
					Constants.PARAM_DIR_0105, "");
			//jbFilePath = "C:\\Users\\yueya\\Desktop\\jb2"; //本地测试
			generateJBReportFile(jbFilePath,false);
			
		}catch(Exception e){
			e.printStackTrace();
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
	
	private void generateJBReportFile(String jbFilePath,boolean md) throws Exception{

		//取任务日期
		String[] args = ToolUtils.queryDate();
		System.out.println("Start generate JB report files:"+args[0]);
		XmlUtil x = new XmlUtil();
		Map<String, List<String>> tableInfoMap = BaseDao.queryFieldInfo();
		//读取sql.xml中sql
		Map<String, String> sqlMap = x.getSqlMap();
		double start;
		double end ;
		//金标-金融机构编码
		String jbBankCode = BaseDao.getJBBankCode();
		
//		String jbFilePath = "C:\\Project\\EAST"; //本地测试
		jbFilePath = jbFilePath + File.separator + args[0].substring(0, 6) + File.separator;
		File jbPath = new File(jbFilePath);
		if(!jbPath.exists()){
			jbPath.mkdir();
		}
		
		Map retMap;
		Boolean retFlag = false;
		String retType = "";
		Set<String> jbSet = new HashSet<String>();
		for (String tableName : tableInfoMap.keySet()) {

			//判断某报表在当前日期是否执行数据分析生成文件
			retMap = BaseDao.ifCreateFile(tableName, args[0]);
			retFlag = (Boolean)retMap.get("retFlag");
			retType = (String)retMap.get("retType");
			if(!retFlag){
				continue;
			}
			if("J".equals(retType)){
				jbSet.add(tableName);
			}	
		}
		//跑金标报送的数据
		for(String tableName : jbSet){
			try{
				start=System.currentTimeMillis();
				System.out.println("star===tableName:"+tableName);
				
				writeJBFile(tableName, args[0], sqlMap, tableInfoMap, jbFilePath, jbBankCode, md);
				
				end=System.currentTimeMillis();
				System.out.println("end===time(s):["+(end-start)/1000+"]!");
			}catch(Exception e) {
				System.err.println(e.getMessage());
				continue;
			}			
		}
		
	
	} 
	/*
	 * 生成金标报送文件 
	 */
	private static void writeJBFile(String tableName, String workdate, Map sqlMap, Map tableInfoMap
			, String filePath, String bankCode, boolean md )throws Exception{
		String fileName=null;	
		fileName = filePath + tableName + bankCode.trim() +  ToolUtils.formatDate(workdate);
		File datFile = new File(fileName + ".dat");
		BufferedWriter bw = new BufferedWriter(new FileWriter(datFile));
		
		int count = BaseDao.queryAndWriteJBFile(tableName, workdate, sqlMap, tableInfoMap, bw, md);
	
		bw.close();
		
		PackZipUtil zipUtil = new PackZipUtil();
		String zipFileName = fileName + ReportConstant.DOWN_LOAD_PACK_ZIP_EXT;
		zipUtil.zip(zipFileName, datFile);
		System.out.println(tableName + "file***over,sum:"+ count +"！");
	}
}
