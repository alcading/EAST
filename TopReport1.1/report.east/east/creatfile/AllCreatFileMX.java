package east.creatfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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

public class AllCreatFileMX {

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
		//updateandquery.updateGh();
		//隐藏不报数据处理
		updateandquery.shieldData();
		// 274利率代号处理
		//updateandquery.updateDqzwjLldh();
		XmlUtil x = new XmlUtil();
		Map<String, List<String>> tableInfoMap = BaseDao.queryFieldInfo();
		//读取sql.xml中sql
		Map<String, String> sqlMap = x.getSqlMap();
		String fileName=null;	
		double start;
		double end ;
		//金融机构代号
	//	Bctl bctl=ROOTDAOUtils.getBctlDAO().query("9999");
		for (String tableName : tableInfoMap.keySet()) {
			start=System.currentTimeMillis();
			/*if(!tableName.equals("JGB")){
				continue;
			}*/
			System.out.println("star===tableName:"+tableName);
			String filePath = "D:\\sendFile\\";
			File path = new File(filePath);
			if(!path.exists()){
				path.mkdir();
			}
//每家行的fileName不一样，记得修正
			fileName = filePath +"B1138H236020001"+"-" + tableName + "-" + ToolUtils.formatDate(args[0]);

			try {
				File txtFile = new File(fileName + ".txt");
				BufferedWriter bw = new BufferedWriter(new FileWriter(txtFile));
				
				//dataList = BaseDao.query(tableName, args[0], sqlMap);
				
				int count = BaseDao.queryAndWriteFile(tableName, args[0], sqlMap, tableInfoMap, bw, defautValue);
			
			
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
		System.out.println("******************  数据分析正常完成!  ******************");
	}
	public static void main(String[] args) {
		try {
			creatJgbsFile(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
