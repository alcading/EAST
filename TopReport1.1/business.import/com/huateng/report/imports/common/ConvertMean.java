package com.huateng.report.imports.common;


public class ConvertMean {
	
	public static String conertSql(String words){
		String result="";
		if (words != null) {
			result = words;
		}
		return result.replaceAll("'", "''");
	}
	

	/**
	 * 截取子字符串(按字节，区别单双字节)
	 * 
	 * @param endIndex终止位
	 * @return 返回子串
	 */
	public static String subStringUTF8(String str, int endIndex) {
		if (str == null) {
			return null;
		}
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c > 255) {
				j += 3;
			} else {
				j += 1;
				
			}
			if(j>endIndex){
				return str.substring(0,i-1);
			}
		}
		return str;
	}
	
	public static String replace(String strSource, String strFrom, String strTo) {
		if (strSource == null) {
			return null;
		}
		int i = 0;
		if ((i = strSource.indexOf(strFrom, i)) >= 0) {
			char[] cSrc = strSource.toCharArray();
			char[] cTo = strTo.toCharArray();
			int len = strFrom.length();
			StringBuffer buf = new StringBuffer(cSrc.length);
			buf.append(cSrc, 0, i).append(cTo);
			i += len;
			int j = i;
			while ((i = strSource.indexOf(strFrom, i)) > 0) {
				buf.append(cSrc, j, i - j).append(cTo);
				i += len;
				j = i;
			}
			buf.append(cSrc, j, cSrc.length - j);
			return buf.toString();
		}
		return strSource;
	}

}
