package east.utils.tools;


import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class WriteFile {
	
	public static Connection getConnection(){
		Connection conn = null;
		WriteFile dbUtil=new WriteFile();
		StringBuffer filePath=new StringBuffer();
		filePath.append(dbUtil.getClass().getClassLoader().getResource("").getPath());
		filePath.deleteCharAt(0);
		filePath.append("resources/SQLContext.xml");

		Resource rs = new FileSystemResource(filePath.toString());    
		BeanFactory factory = new XmlBeanFactory(rs);    
		ComboPooledDataSource dataSource=(ComboPooledDataSource)factory.getBean("bmsdataSource");
		String username =dataSource.getUser();
		String password = dataSource.getPassword();
		String driver=dataSource.getDriverClass();
		String url=dataSource.getJdbcUrl();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("in");
		Connection conn = getConnection();

		ResultSet tableList = null;
		ResultSet columnList=null;
		List colList = new ArrayList();
		StringBuffer sb = new StringBuffer();
		StringBuffer querytables= new StringBuffer();
		StringBuffer querycolumns=null;
		StringBuffer writefile=null;
		String columnName=null;
		String columnType=null; 
		ResultSet fileSet = null;
		String  putin=null;
		try{
			Statement sts=conn.createStatement();
			Statement sts1=conn.createStatement();
		
			//获取需要的表名
			querytables.append("select TABLE_NAME from user_tables where table_name in('ACCEPTANCEDRAFT','APPLICATIONCONFIG','APPLICATION','ASSET','ASSETTYPE','ASSUREINFO','BGLOANAPPLICATION','BHDJB','BWYWMX','COLOANAPPLICATION','CORELOANINFO','CORPCUSTOMER','CORP_FINANCE_INFO','CORPPROPIETOR','CPWJ','CREDIT_INFO','CUSTOMER','CUSTOMER_INFO','CUSTOMER_RELATION_INFO','CYMD','CYQYGQMX','CYQYZQMX','DBEXTENSION','DBQKTJB','DGKHXXWJ','DKHZWJ','DKMX','DQB','DQZWJ','DSHQZWJ','DSKHB','DSKHXXWJ','DSPZKZWJ','DYFRJBQK','EJZZWJ','FIELD_INFO','FUND_RTNACTNO_PARAM','GGJZYGLRXX','GGJZYGLRZJB','GLJTXX','GRDKWYQKTJB','GRDKWYQTZJ','GTZWR','GUARANTEEACCOUNTINFO','HBB','HLB','HPDJB','HQDGZWJ','IMPAWN','INDV_INCOME_INFO','JGB','JTJBQK','JTKHSXCFQK','JYLB','KHZHGXWJ','KMDHB','LCCPCSB','LCCPYWTJB','LCCPZWJ','LCJZLSB','LINE','LLB','LNHTR','LOANAPPLICATION','LOANCHECK','LOANCINO','LOAN','LOANDUEBILL','LOANINFO','LOANSORT2LIST','MONITORDTL','MORTAGAGE','NBZZWJ','RY','SECURITY','SHDJB','SJKZR','SXQK','SYFPCSB','SYHPDJB','TERM_CHG_APPLY','TJKMKJDZB','TLA_LN_ACCT','TLA_LNCINO_BASE','TSKXXDJB','TYCJDJB','TYKHXXB','TYKHYWMX','YJKMDHB','ZCFZKMTJB','ZD_HH','ZMDZB','ZQJBZLB','ZQMRDJB','ZYB','ZYPZZLB')");
			sb.append("  order by table_name");	
			querytables.append(sb);	
			
			tableList = sts.executeQuery(querytables.toString());
			System.out.println(sb.toString());
			
			
			int id = 1;
			File file =null;
			FileWriter fw =null;

			//第二步：循环根据表名取得列名、第几列
			while (tableList.next()) {
				String tableName=tableList.getString("TABLE_NAME").trim();	
				querycolumns=new StringBuffer();
				//获取对应的表字段名
				querycolumns.append("select COLUMN_NAME,DATA_TYPE,COLUMN_ID from cols where table_name='");
				querycolumns.append(tableName);
				querycolumns.append("'  order by column_id");
				file=new File("D:\\source_ctl\\"+tableName.toLowerCase()+".ctl");
				if(!file.exists()){
					file.createNewFile();
				}
				fw= new FileWriter(file);
				writefile = new StringBuffer();
				writefile.append("--sqlldr source_data/source_data@east control=");
				writefile.append(tableName.toLowerCase());
				writefile.append(".ctl rows=5000 direct=true readsize=10000000");
				writefile.append("\r\n");	
				writefile.append("load data");	
				writefile.append("\r\n");	
				writefile.append("infile *");
				writefile.append("\r\n");	
				writefile.append("into table  ");
				writefile.append(tableName.toLowerCase());
				writefile.append("\r\n");	
				writefile.append("append");
				writefile.append("\r\n");	
				writefile.append("fields terminated by '|'");
				writefile.append("\r\n");	
				writefile.append("trailing nullcols");
				writefile.append("\r\n");
				writefile.append("(");
				columnList=sts1.executeQuery(querycolumns.toString());
				while (columnList.next()) {
					columnName = columnList.getString("COLUMN_NAME").toLowerCase().trim();
					columnType = columnList.getString("DATA_TYPE").toLowerCase().trim();
					if ("CHANGE_FLAG".equals(columnName)) {
						continue;
					}
					writefile.append("\r\n");
					if(columnType.equals("date")){
						writefile.append(columnName);
						writefile.append("  date 'yyyy/mm/dd',");
					}else{
						writefile.append(columnName);
						writefile.append(" ,");
					}
				}
				putin=writefile.substring(0,writefile.length()-1);
				writefile=new StringBuffer();
				writefile.append(putin);
				writefile.append("\r\n");
				writefile.append(")");
				fw.write(writefile.toString());
				fw.flush();
			}
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
					
		close(conn, null, null);
	}
	
}
