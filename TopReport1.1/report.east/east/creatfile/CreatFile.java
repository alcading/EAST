package east.creatfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.utils.ReportUtils;

import resource.bean.pub.Bctl;

import resource.report.dao.ROOTDAOUtils;

import east.dao.BaseDao;
import east.special.product.UpdateAndQuery;
import east.utils.tools.ToolUtils;
import east.utils.tools.XmlUtil;
import east.vo.DefautValueVO;


/**
 * 
 * @author Administrator
 *shaomying
 */

public class CreatFile {

	public static void creatJgbsFile(String[] args) throws Exception {

		//取任务日期
		args = ToolUtils.queryDate();
		//调用sh
		System.out.println("getFile start!"+args[0]);
		//BhRunShell.runShell(args[0]);
		DefautValueVO defautValue = ToolUtils.defautValue();
		UpdateAndQuery updateandquery = new UpdateAndQuery();
		//对方账户处理
		updateandquery.updateDfzh();
		//工号处理
		updateandquery.updateGh();
		//隐藏不报数据处理
		updateandquery.shieldData();
		// 274利率代号处理
		updateandquery.updateDqzwjLldh();
		XmlUtil x = new XmlUtil();
		Map<String, List<String>> tableInfoMap = BaseDao.queryFieldInfo();
		//读取sql.xml中sql
		Map<String, String> sqlMap = x.getSqlMap();
		String fileName=null;	
		double start;
		double end ;
		//金融机构代号
		Bctl bctl=ROOTDAOUtils.getBctlDAO().query("9999");
		
		//生成文件路径加年月路径
		String filePath = ReportUtils.getSysParamsValue(Constants.PARAM_DIR,
				Constants.PARAM_DIR_0103, "");
		filePath = filePath + File.separator + args[0].substring(0, 6) + File.separator;
		File path = new File(filePath);
		if(!path.exists()){
			path.mkdir();
		}
		
		Map retMap;
		Boolean retFlag = false;
		String retType = "";
		Boolean weekFlag = true;
		Boolean monthFlag = true;
		Boolean quarterFlag = true;
		Boolean yearFlag = true;
		Calendar cal;
		String beginDate = "";
		Set<String> daySet = new HashSet<String>();
		Set<String> weekSet = new HashSet<String>();
		Set<String> monthSet = new HashSet<String>();
		Set<String> quarterSet = new HashSet<String>();
		Set<String> yearSet = new HashSet<String>();
		Set<String> cSet = new HashSet<String>();
		for (String tableName : tableInfoMap.keySet()) {
			//start=System.currentTimeMillis();
			/*if(!tableName.equals("JGB")){
				continue;
			}*/
			//System.out.println("star===tableName:"+tableName);
			
			fileName = filePath + bctl.getFinanceCode().trim()+"-" + tableName + "-" + ToolUtils.formatDate(args[0]);

			//判断某报表在当前日期是否执行数据分析生成文件
			retMap = BaseDao.ifCreateFile(tableName, args[0]);
			retFlag = (Boolean)retMap.get("retFlag");
			retType = (String)retMap.get("retType");
			if(!retFlag){
				continue;
			}
			if("D".equals(retType)){
				daySet.add(tableName);
			}
			if("W".equals(retType)){
				weekSet.add(tableName);
			}
			if("M".equals(retType)){
				monthSet.add(tableName);
			}
			if("Q".equals(retType)){
				quarterSet.add(tableName);
			}
			if("Y".equals(retType)){
				yearSet.add(tableName);
			}
				
		}
		
		//备份cpwj到cpwj_bak
		//BaseDao.delCpwjOrBak("cpwj_bak");
		//BaseDao.backupCpwj();
		
		//跑按日报送的数据
		for(String tableName : daySet){
			try{
				start=System.currentTimeMillis();
				System.out.println("star===tableName:"+tableName);
				
				writeFile(tableName, args[0], sqlMap, tableInfoMap, defautValue, filePath, bctl);
				
				end=System.currentTimeMillis();
				System.out.println("end===time(s):["+(end-start)/1000+"]!");
			}catch(Exception e) {
				System.err.println(e.getMessage());
				continue;
			}		
		}
		
		//跑按周报送的数据
		for(String tableName : weekSet){
			//清空cpwj，导入一周的cpwj数据
			if(weekFlag){
				cal = Calendar.getInstance();
				Date date = DateUtil.stringToDate2(args[0]);
				cal.setTime(date);
				cal.add(Calendar.DATE, -6);
				beginDate = DateUtil.dateToNumber(cal.getTime());
				//BaseDao.delCpwjOrBak("cpwj");
				//BaseDao.insertCpwj(beginDate, args[0]);
				weekFlag = false;
			}
			
			try{
				start=System.currentTimeMillis();
				System.out.println("star===tableName:"+tableName);
				
				writeFile(tableName, args[0], sqlMap, tableInfoMap, defautValue, filePath, bctl);
			
				end=System.currentTimeMillis();
				System.out.println("end===time(s):["+(end-start)/1000+"]!");
			}catch(Exception e) {
				System.err.println(e.getMessage());
				continue;
			}	
		}
		
		//跑按月报送的数据
		for(String tableName : monthSet){
			//清空cpwj，导入一月的cpwj数据
			if(monthFlag){
				beginDate = args[0].substring(0, 6)+"01";
				//BaseDao.delCpwjOrBak("cpwj");
				//BaseDao.insertCpwj(beginDate, args[0]);
				monthFlag = false;
			}
			
			try{
				start=System.currentTimeMillis();
				System.out.println("star===tableName:"+tableName);
				
				writeFile(tableName, args[0], sqlMap, tableInfoMap, defautValue, filePath, bctl);
			
				end=System.currentTimeMillis();
				System.out.println("end===time(s):["+(end-start)/1000+"]!");
			}catch(Exception e) {
				System.err.println(e.getMessage());
				continue;
			}	
		}
		//跑按季报送的数据
		for(String tableName : quarterSet){
			try{
				start=System.currentTimeMillis();
				System.out.println("star===tableName:"+tableName);
				
				writeFile(tableName, args[0], sqlMap, tableInfoMap, defautValue, filePath, bctl);
				
				end=System.currentTimeMillis();
				System.out.println("end===time(s):["+(end-start)/1000+"]!");
			}catch(Exception e) {
				System.err.println(e.getMessage());
				continue;
			}		
		}
		//跑按年报送的数据
		for(String tableName : yearSet){
			try{
				start=System.currentTimeMillis();
				System.out.println("star===tableName:"+tableName);
				
				writeFile(tableName, args[0], sqlMap, tableInfoMap, defautValue, filePath, bctl);
				
				end=System.currentTimeMillis();
				System.out.println("end===time(s):["+(end-start)/1000+"]!");
			}catch(Exception e) {
				System.err.println(e.getMessage());
				continue;
			}		
		}
		
		//还原cpwj_bak到cpwj
		//BaseDao.delCpwjOrBak("cpwj");
		//BaseDao.revertCpwj();
		//BaseDao.delCpwjOrBak("cpwj_bak");
		
		System.out.println("******************  数据分析正常完成!  ******************");
	}
	
	public static void writeFile(String tableName, String workdate, Map sqlMap, Map tableInfoMap ,DefautValueVO defautValue
			, String filePath, Bctl bctl)throws Exception{
		String fileName=null;	
		fileName = filePath + bctl.getFinanceCode().trim()+"-" + tableName + "-" + ToolUtils.formatDate(workdate);
		File txtFile = new File(fileName + ".txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(txtFile));
		
		int count = BaseDao.queryAndWriteFile(tableName, workdate, sqlMap, tableInfoMap, bw, defautValue);
	
		bw.close();
		//log文件
		BufferedWriter flagFileWriter = new BufferedWriter(new FileWriter(fileName + ".log"));
		flagFileWriter.write(txtFile.getName() + "\n" );
		flagFileWriter.write(txtFile.length() + "\n" );
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		flagFileWriter.write(sdf.format(calendar.getTime())+"\n");
		flagFileWriter.write("Y".trim());
		flagFileWriter.close();

		System.out.println(tableName + "file***over,sum:"+ count +"！");
		//end=System.currentTimeMillis();
		//System.out.println("end===time(s):["+(end-start)/1000+"]!");
	}
	
	public static void creatManualJgbsFile(Map<String, List<String>> tableInfoMap) throws Exception {

		//取任务日期
		String[] workDate = ToolUtils.queryDate();
		//调用sh
		System.out.println("getFile start!"+workDate[0]);
		//BhRunShell.runShell(args[0]);
		DefautValueVO defautValue = ToolUtils.defautValue();
		XmlUtil x = new XmlUtil();
		//读取sql.xml中sql
		Map<String, String> sqlMap = x.getSqlMap();
		String fileName=null;	
		double start;
		double end ;
		//金融机构代号
		Bctl bctl=ROOTDAOUtils.getBctlDAO().query("9999");
		for (String tableName : tableInfoMap.keySet()) {
			start=System.currentTimeMillis();
			/*if(!tableName.equals("JGB")){
				continue;
			}*/
			System.out.println("star===tableName:"+tableName);
			String filePath = ReportUtils.getSysParamsValue(Constants.PARAM_DIR,
					Constants.PARAM_DIR_0103, "");
			File path = new File(filePath);
			if(!path.exists()){
				path.mkdir();
			}

			fileName = filePath + bctl.getFinanceCode().trim()+"-" + tableName + "-" + ToolUtils.formatDate(workDate[0]);

			try {
				File txtFile = new File(fileName + ".txt");
				BufferedWriter bw = new BufferedWriter(new FileWriter(txtFile));
				
				//dataList = BaseDao.query(tableName, args[0], sqlMap);
				
				int count = BaseDao.queryAndWriteFile(tableName, workDate[0], sqlMap, tableInfoMap, bw, defautValue);
			
			
				bw.close();
				FileInputStream inputStream = new FileInputStream(txtFile);
				//log文件
				BufferedWriter flagFileWriter = new BufferedWriter(new FileWriter(fileName + ".log"));
				flagFileWriter.write(txtFile.getName() + "\n" );
				flagFileWriter.write(txtFile.length() + "\n" );
				Calendar calendar=Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				flagFileWriter.write(sdf.format(calendar.getTime())+"\n");
				flagFileWriter.write("Y".trim());
				flagFileWriter.close();
	
				System.out.println(tableName + "file***over,sum:"+ count +"！");
				end=System.currentTimeMillis();
				System.out.println("end===time(s):["+(end-start)/1000+"]!");
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}			
		}
		System.out.println("******************  重复数据分析正常完成!  ******************");
	}

}
