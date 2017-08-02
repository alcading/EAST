package east.utils.tools;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huateng.ebank.framework.security.Md5;

import east.vo.DefautValueVO;

/**
 * 
 * @author shaomying
 * 
 */
public class ToolUtils {
	static	Md5 objMd5 = new Md5();
		/**
	 * @return String[]
	 */
	public static String[] queryDate() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String[] str = new String[1];
		try {
			pstmt = conn.prepareStatement("select  TO_CHAR(TBSDY,'YYYYMMDD') as TBSDY from  GLOBALINFO");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				str[0] = rs.getString("TBSDY");
			}
		} catch (SQLException e) {
			System.out.println("param error!");
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return str;
	}

	
	/**
	 * @return String[]
	 */
	public static List<String> queryTables() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list=new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement("select   table_name  from   user_tables ");
			rs = pstmt.executeQuery();
			String tablename=null;
			while (rs.next()) {
				tablename=rs.getString("TABLE_NAME").toString().toLowerCase();
				list.add(tablename);
				if(tablename.equals("b_jgb")||tablename.indexOf("b_g")!=-1||tablename.equals("field_info")){
					list.remove(tablename);	
				}

			}
		} catch (SQLException e) {
			System.out.println("param error!");
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
	}	
	/**
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	public static DefautValueVO defautValue() {
		DefautValueVO defautValueVO=new DefautValueVO();

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list=new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement("select JRXKZH , ZFHHH ,NBJGH ,JGMC from b_jgb where dflag='1' ");
			rs = pstmt.executeQuery();
			String tablename=null;
			while (rs.next()) {
				defautValueVO.setJRXKZH(rs.getString("JRXKZH").toString());
				defautValueVO.setYXJGDM(rs.getString("ZFHHH").toString());
				defautValueVO.setNBJGH(rs.getString("NBJGH").toString());
				defautValueVO.setYXJGMC(rs.getString("JGMC").toString());
			}
		} catch (SQLException e) {
			System.out.println("param error!");
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return defautValueVO;
	}

	
	/**
	 * 
	 * @param fieldType
	 *            字段类型
	 * @param fieldValue
	 *            字段值
	 * @return
	 * @throws Exception
	 */
	public static String formatString(String fieldType, String fieldValue,
			int fieldLength, String specflag, int fieldLength2,int fieldSetFlag)
			throws Exception {
		
		if (fieldValue == null || "".equals(fieldValue.trim())) {
			if (fieldType.startsWith("DECIMAL")) {
				fieldValue = "0";
			}else if(fieldType.startsWith("INTEGER")) {
				fieldValue = "0";
			} else {
				fieldValue = "";
			}
		}
		// 处理金额
		if (fieldType.equals("DECIMAL")) {
			BigDecimal money = new BigDecimal(fieldValue);
			if (specflag.equals("1")) {
				money = money.setScale(fieldLength2, BigDecimal.ROUND_HALF_UP);
			} else {
				money = money.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			fieldValue = money.toString()+",";
			return fieldValue.trim();
		}else {
			if(fieldSetFlag!=0&&!"".equals(fieldValue)){// 非金额处理	
				fieldValue=changData(fieldValue,fieldSetFlag);	
			}
		}
		return fieldValue.trim()+",";
	}	

	//名称变形,身份证变形 '不变形-0,名称变形-1,身份证变形-2,名称暂时不取-3,身份证暂时不取-4,其他暂不取-5,其他暂时不变形-6'
	public static String changData(String fieldValue,int fieldSetFlag) {
		switch (fieldSetFlag) {
		case 0:
			return fieldValue.trim();				
		case 1:
			if(fieldValue.trim().length()==2){
				fieldValue=fieldValue.trim().substring(1, 2);
			}else if(fieldValue.trim().length()==3){
				fieldValue=fieldValue.trim().substring(2, 3);
			}
			return fieldValue.trim();		
		case 2:
			if(fieldValue.trim().length()==18||fieldValue.trim().length()==15){
				fieldValue=objMd5.getMD5ofStr(fieldValue.trim());	
			}
			return fieldValue.trim();				
		case 3:
			
			return fieldValue.trim();	
			
		case 4:
			
			return fieldValue.trim();	
			
		case 5:
			
			return fieldValue.trim();	
			
		default:
			return fieldValue.trim();	
		}	
	}
		
	/**
	 * 
	 * @param fieldType
	 *            字段类型
	 * @param fieldValue
	 *            字段值
	 * @param fieldLength
	 *            字段基准长度
	 * @param specflag
	 *            特殊处理标志
	 * @param fieldLength2
	 *            特殊处理长度
	 * @return
	 * @throws Exception
	 */
	public static byte[] format(String fieldType, String fieldValue,
			int fieldLength, String specflag, int fieldLength2)
			throws Exception {
		
		if (fieldValue == null || "".equals(fieldValue.trim())) {
			if (fieldType.startsWith("DECIMAL")) {
				fieldValue = "0";
			} else {
				fieldValue = "";
			}
		}
		byte[] bytes = new byte[fieldLength];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) 32;
		}
		fieldValue=new String(fieldValue.getBytes(),"GBK");
		// 处理金额
		if (fieldType.equals("DECIMAL")) {
			BigDecimal money = new BigDecimal(fieldValue);
			if (specflag.equals("1")) {
				money = money.setScale(fieldLength2, BigDecimal.ROUND_HALF_UP);
			} else {
				money = money.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			fieldValue = money.toString();

			if (fieldValue.getBytes().length < fieldLength) {
				System.arraycopy(fieldValue.getBytes(), 0, bytes, 0, fieldValue
						.getBytes().length);
			} else {
				System.arraycopy(fieldValue.getBytes(), 0, bytes, 0,
						fieldLength);
			}
			return bytes;
		} else {// 非金额处理
			
			if (fieldValue.getBytes().length < fieldLength) {
				System.arraycopy(fieldValue.getBytes(), 0, bytes, 0, fieldValue
						.getBytes().length);
			} else {
				System.arraycopy(fieldValue.getBytes(), 0, bytes, 0,
						fieldLength);
			}
			return bytes;
		}

	}

	/**
	 * 处理日期
	 * 
	 * @param strDate
	 * @return
	 */
	public static String formatDate(String strDate) {
		if (strDate == null || "".equals(strDate.trim()))
			return "";
		Date date = null;
		boolean isSuccess = false;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			isSuccess = true;
		} catch (ParseException e) {
		}
		if (!isSuccess) {
			try {
				date = new SimpleDateFormat("yyyyMMdd").parse(strDate);
				isSuccess = true;
			} catch (ParseException e) {
			}
		}
		if (!isSuccess) {
			try {
				date = new SimpleDateFormat("yyyy/MM/dd").parse(strDate);
				isSuccess = true;
			} catch (ParseException e) {
			}
		}
		if (isSuccess) {
			return new SimpleDateFormat("yyyyMMdd").format(date);
		} else {
			return "";
		}
	}

	/**
	 * 处理时间戳
	 * 
	 * @param strDate
	 *            日期
	 * @return String yyyyMMddhhmmss
	 */
	public static String formatTimestamp(String strDate) throws Exception {
		if (strDate == null || "".equals(strDate.trim()))
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = sdf.parse(strDate);
		sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(date);
	}
	
	/**
	 * 执行shell
	 * @param command
	 * @throws Exception
	 */
	public static void exeShell(String command)throws Exception{
		Process process = Runtime.getRuntime().exec(command.toString());
		StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR");
		errorGobbler.start();
		StreamGobbler outGobbler = new StreamGobbler(process.getInputStream(), "STDOUT");
		outGobbler.start();
		process.waitFor();
		process.destroy();
	}
}
