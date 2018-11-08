package east.utils.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public static String formatString(String tableName, String fieldName, String fieldType, String fieldValue,
			int fieldLength, String specflag, int fieldLength2,int fieldSetFlag,String separator)
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
			fieldValue = money.toString();
			return fieldValue.trim()+separator;
		}else {
			if(fieldSetFlag!=0&&!"".equals(fieldValue)){// 非金额处理
				//为股东信息中的股东证件号码特殊处理
				if("GDXX".equals(tableName)){
					Connection conn = DBUtil.getConnection();
					Statement stmt = null;
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select distinct GDZJLB from EAST_GDXX where GDZJHM ='" + fieldValue.trim() + "'");  
				    while (rs.next()) {  
				        Object note[] = new Object[50];  
				        for (int i = 0; i < note.length; i++) {  
				            note[i] = rs.getObject(i + 1);  
				            if("身份证".equals(note[i])){
				            	fieldValue=changData(fieldValue,fieldSetFlag);	
				            	break;
				            }else{
				            	fieldValue=changData(fieldValue,8);	//股东信息中除了身份证，其他的都不加密
				            	break;
				            }
				        }  
				    }  
				    
				}else{
					fieldValue=changData(fieldValue,fieldSetFlag);	
				}
				
			}
		}
		if ("CJRQ".equals(fieldName)){
			return fieldValue.trim();
		}else{
			return fieldValue.trim()+separator;
		}
		
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
	public static String JBformatString(String tableName, String fieldName, String fieldType, String fieldValue,
			int fieldLength, String specflag, int fieldLength2,int fieldSetFlag,String separator, boolean md, String khlx)
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
		
		//利率水平字段保留五位小数
		if("LLSP".equals(fieldName)){
			DecimalFormat df = new DecimalFormat("#.00000");
			fieldValue = df.format(Double.parseDouble(fieldValue)).toString();
		}
		
		//个人身份证件信息进行MD5加密处理
		if(md&&"1".equals(khlx)){
			if("JKRBM".equals(fieldName)){
				fieldValue = ICMD5(fieldValue);
			}
		}
		//将(个人)身份证件号码中的英文字母转换成大写
		if(!md&&"1".equals(khlx)){
			if("JKRBM".equals(fieldName)){
				fieldValue = fieldValue.toUpperCase();
			}
		}
		
		// 处理金额
		if (fieldType.equals("DECIMAL")&&!"LLSP".equals(fieldName)) {
			BigDecimal money = new BigDecimal(fieldValue);
			if (specflag.equals("1")) {
				money = money.setScale(fieldLength2, BigDecimal.ROUND_HALF_UP);
			} else {
				money = money.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			fieldValue = money.toString();
			return fieldValue.trim()+separator;
		}else {
			if(fieldSetFlag!=0&&!"".equals(fieldValue)){// 非金额处理
				//为股东信息中的股东证件号码特殊处理
				if("GDXX".equals(tableName)){
					Connection conn = DBUtil.getConnection();
					Statement stmt = null;
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select distinct GDZJLB from EAST_GDXX where GDZJHM ='" + fieldValue.trim() + "'");  
				    while (rs.next()) {  
				        Object note[] = new Object[50];  
				        for (int i = 0; i < note.length; i++) {  
				            note[i] = rs.getObject(i + 1);  
				            if("身份证".equals(note[i])){
				            	fieldValue=changData(fieldValue,fieldSetFlag);	
				            	break;
				            }else{
				            	fieldValue=changData(fieldValue,8);	//股东信息中除了身份证，其他的都不加密
				            	break;
				            }
				        }  
				    }  
				    
				}else{
					fieldValue=changData(fieldValue,fieldSetFlag);	
				}
				
			}
		}
		
		if ("CJRQ".equals(fieldName)){
			return fieldValue.trim();
		}else{
			return fieldValue.trim()+separator;
		}
		
	}
	
	private static String ICMD5(String fieldValue) throws IOException{
		if(fieldValue.length()>0){
			String da = cutStringByU8(fieldValue,6);
			fieldValue = da+EncoderByMd5(fieldValue.substring(da.length()).trim());
		}
		return fieldValue;
	}
	
	// 使用UTF-8编码表进行截取字符串，一个汉字对应三个负数，一个英文字符对应一个正数
	private static String cutStringByU8(String str, int len) throws IOException {

        byte[] buf = str.getBytes("utf-8");
        int count = 0;
        for (int x = len - 1; x >= 0; x--) {
            if (buf[x] < 0) {
                count++;
            } else {
                break;
            }
        }
        if (count % 3 == 0) {
            return new String(buf, 0, len, "utf-8");
        } else if (count % 3 == 1) {
            return new String(buf, 0, len - 1, "utf-8");
        } else {
            return new String(buf, 0, len - 2, "utf-8");
        }
    }
	
	//名称变形,身份证变形 '不变形-0,名称变形-1,对私表身份证变形-2,含对公对私表身份证变形-3,身份证暂时不取-4,其他暂不取-5,对私客户统一编号变形-6,含对私与对公的客户统一编号变形-7,其他暂时不变形-8'
	public static String changData(String fieldValue,int fieldSetFlag) throws UnsupportedEncodingException {
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
			
			if (fieldValue.trim().length()!=fieldValue.trim().getBytes().length){
				fieldValue=fieldValue.trim().substring(0, 2) + EncoderByMd5(fieldValue.trim());
			}else{
				fieldValue=fieldValue.trim().substring(0, 6) + objMd5.getMD5ofStr(fieldValue.trim());	
			}
	        
			return fieldValue.trim();		
			
		case 3:
			if (fieldValue.trim().length()==15 || fieldValue.trim().length()==18 ){
				if (fieldValue.trim().length()!=fieldValue.trim().getBytes().length){
					fieldValue=fieldValue.trim().substring(0, 2) + EncoderByMd5(fieldValue.trim());;
				}else{
					fieldValue=fieldValue.trim().substring(0, 6) + objMd5.getMD5ofStr(fieldValue.trim());	
				}
			}
			
			return fieldValue.trim();	
			
		case 4:
			
			return fieldValue.trim();	
			
		case 5:
			
			return fieldValue.trim();
			
		case 6:
			int len = fieldValue.trim().length();
			if (len>7){
				fieldValue=fieldValue.trim().substring(0, 1) + fieldValue.trim().substring(1, 7) + objMd5.getMD5ofStr(fieldValue.trim().substring(1, len));
			}
		
		case 7:
			if (fieldValue.trim().length()==19){
				fieldValue=fieldValue.trim().substring(0, 1) + fieldValue.trim().substring(1, 7) + objMd5.getMD5ofStr(fieldValue.trim().substring(1, 19));	
			}else if (fieldValue.trim().length()==16){
				fieldValue=fieldValue.trim().substring(0, 1) + fieldValue.trim().substring(1, 7) + objMd5.getMD5ofStr(fieldValue.trim().substring(1, 16));	
			}
			return fieldValue.trim();
			
		default:
			return fieldValue.trim();	
		}	
	}
	
	
	public static String EncoderByMd5(String str) {  
	    String result = "";  
	    MessageDigest md5 = null;  
	    try {  
	        md5 = MessageDigest.getInstance("MD5");  
	        // 这句是关键  
	        md5.update(str.getBytes("UTF-8"));  
	    } catch (NoSuchAlgorithmException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    } catch (UnsupportedEncodingException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }  
	    byte b[] = md5.digest();  
	    int i;  
	    StringBuffer buf = new StringBuffer("");  
	    for (int offset = 0; offset < b.length; offset++) {  
	        i = b[offset];  
	        if (i < 0)  
	            i += 256;  
	        if (i < 16)  
	            buf.append("0");  
	        buf.append(Integer.toHexString(i));  
	    }  
	    result = buf.toString();  
	    return result;  
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
		fieldValue=new String(fieldValue.getBytes(),"UTF-8");
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
	 * 处理日期
	 * 返回yyyy-MM-dd
	 * @param strDate
	 * @return
	 */
	public static String formatDate1(String strDate) {
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
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
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
