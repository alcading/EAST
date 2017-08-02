package east.dao;

import java.io.BufferedWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.Auth;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import east.utils.tools.DBUtil;
import east.utils.tools.ToolUtils;
import east.vo.DefautValueVO;



public class BaseDao {
	
	/**
	 * 
	 * @param tableName
	 * @param cjrq format:yyyyMMdd
	 * @return Map<fieldName, fieldValue>
	 */
	public static List<Map<String, String>> query(String tableName, String cjrq, Map<String, String> sqlMap) throws Exception{
		
		Connection conn = DBUtil.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		try {
			if(sqlMap.get(tableName)==null || "".equals(sqlMap.get(tableName).trim())) {
				throw new Exception("tableName:["+tableName + "] not exist!");
			}
			pstmt = conn.prepareStatement(sqlMap.get(tableName));
			int paramNum = pstmt.getParameterMetaData().getParameterCount();
			for (int i = 1; i < paramNum+1; i++) {
				pstmt.setString(i, cjrq);
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			if(rs!=null){
				
				while(rs.next()){
					map = new HashMap<String, String>();
					for (int i = 1; i <= count; i++) {
							map.put(rsmd.getColumnName(i), rs.getString(i));
					}
					list.add(map);
				}
			}
		} catch (SQLException e) {
			throw new Exception("tableName:["+tableName + "] query! error!" + e.getMessage(), e);
		} finally{
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
		
	}
	
    public static int queryAndWriteFile(String tableName, String cjrq, Map<String, String> sqlMap, Map<String, List<String>> tableInfoMap, 
    		BufferedWriter bw, DefautValueVO defautValue) throws Exception{
    	int ret = 0;
    	int count = 0;
		Connection conn = DBUtil.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder line = null;
		String fieldName = null;
		String fieldType = null;
		String fieldLength = null;
		String specflag = null;
		String fieldLength2 = null;
		String fieldSetFlag= null;
		String fieldValue = null;
		String[] temAry = null;
		//	value	byte[] 定长,value  String非定长
		String value = null;
		try {
			if(sqlMap.get(tableName)==null || "".equals(sqlMap.get(tableName).trim())) {
				throw new Exception("tableName:["+tableName + "] not exist!");
			}
			pstmt = conn.prepareStatement(sqlMap.get(tableName));
			int paramNum = pstmt.getParameterMetaData().getParameterCount();
			for (int i = 1; i < paramNum+1; i++) {
				pstmt.setString(i, cjrq);
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			count = rsmd.getColumnCount();
			List<String> fieldInfoList = tableInfoMap.get(tableName);
			if(rs!=null){
				while(rs.next()){
					ret ++;
					line = new StringBuilder();
					if(count == fieldInfoList.size())
					{
						for (int i = 0; i < count; i++) 
						{
							String fieldInfo = fieldInfoList.get(i);
							temAry = fieldInfo.split("\\|");
							//获取字段名称
							fieldName = temAry[0];
							//字段类型
							fieldType= temAry[1];
							//获取字段长度
							fieldLength = temAry[2];
							//是否特殊标志
							specflag= temAry[3];
							//特殊处理位数
							fieldLength2= temAry[4];
							//变形字段标记  '不变形-0,名称变形-1,身份证变形-2,名称暂时不取-3,身份证暂时不取-4,其他暂不取-5,其他暂时不变形-6'
							fieldSetFlag= temAry[5];
							//sql中查出对应字段值
							fieldValue = rs.getString(fieldName);
							if(fieldType.startsWith("TIMESTAMP")) {
								fieldValue = ToolUtils.formatTimestamp(fieldValue);
							}else if(fieldType.startsWith("DATE")){
								fieldValue = ToolUtils.formatDate(fieldValue);
							}
							try {
								if ((fieldName.equals("YXJGDM")||fieldName.equals("YWBLX"))&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue =defautValue.getYXJGDM();
								} else if (fieldName.equals("NBJGH")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getNBJGH();
								} else if (fieldName.equals("JRXKZH")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue =defautValue.getJRXKZH();
								} else if (fieldName.equals("JBJGMC")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getYXJGMC();
								}else if (fieldName.equals("YXJGMC")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getYXJGMC();
								} else if (fieldName.equals("ZXJGDM")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getNBJGH();
								}
								else if(fieldName.equals("FKXDM")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getYXJGDM();
								}
								else if(fieldName.equals("FKXMC")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getYXJGMC();
								}
								else if(fieldName.equals("JYJGMC")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getYXJGMC();
								}
								else if(fieldName.equals("DJJG")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getYXJGDM();
								}
								else if(fieldName.equals("CZJG")&& (null == fieldValue || "".equals(fieldValue.trim()))) {
									fieldValue = defautValue.getYXJGDM();
								}
								if(null!=fieldValue&&!"".equals(fieldValue)){
									fieldValue=fieldValue.replaceAll(",", "-");
								}
							//非定长用逗号分割
								value=ToolUtils.formatString(fieldType, fieldValue, Integer.parseInt(fieldLength),specflag,Integer.parseInt(fieldLength2),Integer.parseInt(fieldSetFlag));
							} catch (Exception e) {
								break;
							}
							//定长 line.append(new String(value,"GBK"));
							//非定长
							line.append(value);
						}
						//非定长需要长度减1
						line.deleteCharAt(line.length()-1);
						bw.write(line + "\n");
						bw.flush();
					}
					else
					{
						System.err.println("tableName:["+tableName + "]FIELD_INFO is wrong!");
					}
				}
			}
		} catch (SQLException e) {
			throw new Exception("tableName:["+tableName + "] query! error!" + e.getMessage(), e);
		} finally{
			DBUtil.close(conn, pstmt, rs);
		}
		return ret;
	}
	
	/**
	 * insert field info
	 * @param fieldList
	 * @throws Exception
	 */
	public static void insertFieldInfo(Map<String, List<Map<String, String>>> fieldMap) throws Exception{
		
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		try {
			for (String tableName : fieldMap.keySet()) {
				for (Map<String, String> fieldInfoMap : fieldMap.get(tableName)) {
					stmt.addBatch("insert into field_info values ('"+ fieldInfoMap.get("TABLE_NAME") +"', " + fieldInfoMap.get("SEQ") + ", '"+ fieldInfoMap.get("COLUMN_NAME") +"', '"+ fieldInfoMap.get("COLUMN_TYPE") +"')");
				}
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			throw new Exception("insert Column error!===" + e.getMessage(), e);
		} finally{
			DBUtil.close(conn, stmt, rs);
		}
		
	}

	public static Map<String, List<String>> queryFieldInfo() throws Exception{
		
		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> fieldList = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from field_info order by table_name, seq");
			if(rs!=null){
				while(rs.next()){
					if (map.containsKey(rs.getString("TABLE_NAME"))) {
						fieldList = map.get(rs.getString("TABLE_NAME"));
					} else {
						fieldList = new ArrayList<String>();
					}
					fieldList.add(rs.getString("COLUMN_NAME") + "|" + rs.getString("COLUMN_TYPE")+ "|" + rs.getString("TOTAL")+ "|" 
							+rs.getString("SPECFLAG")+ "|" +rs.getString("LENGTH2")+ "|" +rs.getString("SETFLAG"));
					map.put(rs.getString("TABLE_NAME"), fieldList);
				}
			}
		} catch (SQLException e) {
			throw new Exception("query Column error！===" + e.getMessage(), e);
		} finally{
			DBUtil.close(conn, stmt, rs);
		}
		return map;
		
	}
	
	/**
	 * 根据tableName获取field_info表名
	 * @return
	 * @throws Exception
	 */
	public static List queryFieldInfoTable(String tableName) throws Exception {

		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> tableList = new ArrayList<String>();
		String sql = "select distinct TABLE_NAME from field_info where 1=1";
		if(tableName!=null && !"".equals(tableName)){
			sql += " and TABLE_NAME like '%"+tableName+"%'";
		}
		sql += " order by TABLE_NAME";
		tableList = rootDAO.queryBySQLList(sql);
		return tableList;

	}
	
	public static Map<String, List<String>> queryFieldInfo2(String whereString) throws Exception {

		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> fieldList = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from field_info where 1=1 ";
			if(whereString!=null && !"".equals(whereString)){
				sql += " and " + whereString; 
			}
			sql += "order by table_name, seq";
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					if (map.containsKey(rs.getString("TABLE_NAME"))) {
						fieldList = map.get(rs.getString("TABLE_NAME"));
					} else {
						fieldList = new ArrayList<String>();
					}
					fieldList.add(rs.getString("COLUMN_NAME") + "|"
							+ rs.getString("COLUMN_TYPE") + "|"
							+ rs.getString("TOTAL") + "|"
							+ rs.getString("SPECFLAG") + "|"
							+ rs.getString("LENGTH2") + "|"
							+ rs.getString("SETFLAG"));
					map.put(rs.getString("TABLE_NAME"), fieldList);
				}
			}
		} catch (SQLException e) {
			throw new Exception("query Column error！===" + e.getMessage(), e);
		} finally {
			DBUtil.close(conn, stmt, rs);
		}
		return map;

	}
	
	/**
	 * @author xuhong 20160331
	 * @Description 用于判断某报表在当前日期是否执行数据分析生成文件
	 * @param tableName
	 * @param tbsdy
	 * @return
	 * @throws CommonException 
	 */
	public static Map ifCreateFile(String tableName, String tbsdy) throws CommonException{
		Map retMap = new HashMap();
		Boolean retFlag = false;
		String retType = "";
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		List<String> tableList = new ArrayList<String>();
		String sql = "select TYPE from field_table where 1=1 and TABLE_NAME='"+tableName+"' ";
		tableList = rootDAO.queryBySQLList(sql);
		//系统日期--shaomy
		Date dt=DateUtil.stringToDate2(tbsdy);
		if(tableList==null || tableList.size()==0){
			System.out.println("field_table配置错误：表["+tableName+"]未配置");
			throw new CommonException("field_table配置错误：表["+tableName+"]未配置");
		}else{
			/*type类型
			 * Y：按年
			 * Q: 按季
			 * M：按月
			 * W：按周
			 * D: 按日
			 */
			retType = (String)tableList.get(0);
			System.out.println("retType:"+retType);
			Calendar c = Calendar.getInstance();

			if("Y".equals(retType)){
				if("1231".equals(tbsdy.substring(4))){
					retFlag = true;
				}
				
			}else if("Q".equals(retType)){
				if("0331".equals(tbsdy.substring(4)) || "0630".equals(tbsdy.substring(4))
						||"0930".equals(tbsdy.substring(4)) || "1231".equals(tbsdy.substring(4))){
					retFlag = true;
				}	
			}else if("M".equals(retType)){
				//shaomy
				c.setTime(dt); 
				c.set(Calendar.DATE, (c.get(Calendar.DATE) + 1));
				if (c.get(Calendar.DAY_OF_MONTH) == 1) {
					retFlag = true;
				}	
			}else if("W".equals(retType)){	
				//shaomy
				c.setTime(dt); 
				c.set(Calendar.DATE, (c.get(Calendar.DATE)));
				if(c.get(Calendar.DAY_OF_WEEK) == 1){
					retFlag = true;
				}	
			}else if("D".equals(retType)){
				retFlag = true;
				
			}else{
				System.out.println("field_table配置错误：表["+tableName+"]对应的类型["+retType+"]配置错误！只能为：Y、Q、M、W、D三者之一。");
				throw new CommonException("field_table配置错误：表["+tableName+"]对应的类型["+retType+"]配置错误！只能为：Y、Q、M、W、D三者之一。");
			}
		}
		retMap.put("retType", retType);
		retMap.put("retFlag",retFlag);
		return retMap;
	}
	
	/**
	 * 备份cpwj到cpwj_bak
	 */
	public static void backupCpwj() throws Exception{
		try{
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String sql = "insert into cpwj_bak select * from cpwj where 1=1";
			rootdao.executeSql(sql);
		}catch(Exception e){
			System.out.println("备份cpwj到cpwj_bak错误！错误信息："+e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 清空cpwj或者cpwj_bak
	 */
	public static void delCpwjOrBak(String tableName)throws Exception{
		try{
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String sql = "truncate table " + tableName + "";
			rootdao.executeSql(sql);
		}catch(Exception e){
			System.out.println("清空表"+tableName+"错误！错误信息："+e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 按起始日期、终止日期从cpwj_bak导指定时间段日期到cpwj
	 * @param beginDate
	 * @param endDate
	 */
	public static void insertCpwj(String beginDate, String endDate)throws Exception{
		try{
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String sql = "insert into cpwj select * from cpwj_bak where jyrq>=to_date('"+beginDate+"','yyyy-mm-dd') and jyrq<=to_date('"+endDate+"','yyyy-mm-dd')";
			rootdao.executeSql(sql);
		}catch(Exception e){
			System.out.println("还原cpwj_bak到cpwj错误！错误信息："+e.getMessage());
			throw e;
		}
	}
	
	/**
	 *还原传票文件 
	 */
	public static void revertCpwj()throws Exception{
		try{
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String sql = "insert into cpwj select * from cpwj_bak where 1=1";
			rootdao.executeSql(sql);
		}catch(Exception e){
			System.out.println("还原cpwj_bak到cpwj错误！错误信息："+e.getMessage());
			throw e;
		}
	}
	
}
