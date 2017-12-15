package east.utils.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	
	public static Connection getConnection(){
		Connection conn = null;
		DBUtil dbUtil=new DBUtil();
		StringBuffer filePath=new StringBuffer();
		filePath.append(dbUtil.getClass().getClassLoader().getResource("").getPath());
		//delete by xuhong 2015-4-2 begin
//		filePath.deleteCharAt(0);
		//delete by xuhong 2015-4-2 
		filePath.append("resources/SQLContext.xml");

		Resource rs = new FileSystemResource(filePath.toString());
		System.out.println("SQLContext.xml filePath = ["+filePath.toString()+"]");
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
		Connection conn = getConnection();
		close(conn, null, null);
	}
	
}
