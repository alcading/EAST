package com.huateng.report.utils;

import sun.misc.BASE64Decoder;

public class ReportBase64 {
	/**
	 * Base64将字符串进行编码
	 */
	public static String getBase64FromString(String s) {
		if (s == null) {
			return null;
		}
		String tmp = (new Base64Encode()).encode(s.getBytes());
		return tmp;
	}

	/**
	 * Base64对字符串进行解码
	 * @param s
	 * @return
	 */
	public static String getStringFromBase64(String s) {
		if (s == null) {
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			String tmp = new String(b);
			return tmp;
		} catch (Exception e) {
			return null;
		}
	}
}
