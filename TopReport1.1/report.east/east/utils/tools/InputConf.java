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

public class InputConf {
	
	public static Connection getConnection(){
		Connection conn = null;
		InputConf dbUtil=new InputConf();
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
		List colList = new ArrayList();
		StringBuffer sb = new StringBuffer();

		ResultSet fileSet = null;
		try{
			Statement sts=conn.createStatement();
			Statement sts1=conn.createStatement();
			Statement sts2=conn.createStatement();
			//第一步：取得所有需要导入的表名
			sb.append("select TABLE_NAME,COLUMN_NAME,COLUMN_ID from cols where table_name   in('SNTJB',");
			sb.append("'B_JGB','EX_DATA','GWXXB','MYRZYWXXB','XDZCZR','XMDKXXB','XYKXX','XYKZHJYMXB','YGB','ZCZRGXB','ZYGDJZYGLQY','BCTL','TLR_INFO') ");
			sb.append("  order by table_name,column_id");
			tableList = sts.executeQuery(sb.toString());
			System.out.println(sb.toString());
			int id = 1;
			File file = new File("D:\\inputConf.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			//第二步：循环根据表名取得列名、第几列
			while (tableList.next()) {
				String tableName=tableList.getString("TABLE_NAME");				
				String columnName=tableList.getString("COLUMN_NAME");				
				String columnId=tableList.getString("COLUMN_ID");
				if("CHANGE_FLAG".equals(columnName)){
					continue;
				}
				//取关联文件id
				String fileId = "1";
				sb = new StringBuffer();
				sb.append("select ID from BI_IMPORT_FILE_CONFIG where TABLE_NAME='"+tableName+"'");
				fileSet =sts1.executeQuery(sb.toString());
				if(fileSet.next()){
					fileId = fileSet.getString("ID");
				}
				
				
				//第三步：拼装sql
				sb = new StringBuffer();
				sb.append("insert into BI_IMPORT_FIELD_CONFIG (ID, IMPORT_FILE_ID, FIELD_NAME, FIELD_DESC, UNIQUE_FLAG, BATCH_NO, FIELD_TYPE, COLUMN_NUM, DEFAULT_VAL, FIELD_UPDATE_FLAG, FIELD_UPDATE_TYPE, MAP_FUNCTION, MAP_PARAMS, FILTER_FLAG, FILTER_FUNCTION, FILTER_PARAMS, NODE_SEQ, NODE_PATH, NODE_TYPE) values (");
				sb.append("'"+id+"',");
				sb.append("'"+fileId+"',");
				sb.append("'"+columnName+"',");
				sb.append(" null, '0', 0, '2', null, null, '1', '1', 'getPrimaryColumn(${value},");
				sb.append(columnId);
				sb.append(")', null, '0', null, null, null, null, null);");

				id = id+1;
				//第四步：执行sql（去外部执行）
//				sts2.addBatch(sb.toString());
				fw.write(sb.toString());
				fw.write("\n");
			}
			fw.flush();
			fw.close();
//			sts2.executeBatch();
			//第三步：拼装sql
			//第四步：执行sql（去外部执行）
		}catch(Exception e){
			e.printStackTrace();
		}
			
		
		
		
		close(conn, null, null);
	}
	
}
