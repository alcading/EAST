package com.huateng.ebank.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ===============================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2009 Huateng Software System Co., Ltd. All rights
 * reserved.
 *
 * @Company: 上海华腾软件系统有限公司
 * @Project: 银行个人贷款管理系统
 *
 * @Auther: yjw
 *          ===============================================================================
 *          <p>
 * @Title: CharUtils.java类
 *         </p>
 *         <p>
 * @Version: 1.0 Created time: 2009-9-18-下午03:00:43
 *           </p>
 *           <p>
 * @Description:关于字符串处理的常用类
 *           </p>
 */
public class CharUtils {

	/**
	 * @description:半角转全角,保留空格,全角空格为12288，半角空格为32 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
	 * @date: 2009-9-8 下午03:58:12
	 * @author: yjw
	 * @param :@param
	 * @return: String
	 */

	public static String ToSBC(String input) {
		if (input == null || input.trim().equals(""))
			return "";
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 32) {
				c[i] = (char) 12288;
				continue;
			}
			if (c[i] < 127)
				c[i] = (char) (c[i] + 65248);
		}
		return new String(c);
	}

	/**
	 * @description:半角转全角,去掉头尾和中间的空格,全角空格为12288，半角空格为32 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
	 * @date: 2009-9-18 下午03:06:39
	 * @author: yjw
	 * @param :@param
	 *            input
	 * @return: String
	 */
	public static String ToSBCTrim(String input) {
		if (input == null || input.trim().equals(""))
			return "";
		char[] c = input.toCharArray();
		char[] r = new char[c.length];
		int j = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 32) {
				c[i] = (char) 12288;
				j++;
				continue;
			}
			if (c[i] < 127)
				c[i] = (char) (c[i] + 65248);
			r[i - j] = c[i];// 将字符串前移空格的位数
		}
		String str = new String(r);
		return str.trim();
	}

	/**
	 * @description:全角转半角,保留空格,全角空格为12288，半角空格为32 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
	 * @date: 2009-9-8 下午03:58:36
	 * @author: yjw
	 * @param :@param
	 *            input
	 * @return: String
	 */
	public static String ToDBC(String input) {
		if (input == null || input.trim().equals(""))
			return "";
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	/**
	 * @description:全角转半角,去掉中间和头尾的空格,全角空格为12288，半角空格为32 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
	 * @date: 2009-9-8 下午03:59:29
	 * @author: yjw
	 * @param :@param
	 *            input
	 * @return: String
	 */
	public static String ToDBCTrim(String input) {
		if (input == null || input.trim().equals(""))
			return "";
		char[] c = input.toCharArray();
		char[] r = new char[c.length];
		int j = 0;// 记录空格的个数
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288 || c[i] == 32) {
				j++;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
			r[i - j] = c[i];// 将字符串前移空格的位数
		}
		String str = new String(r);
		return str.trim();
	}

	/**
	 * @description:检查指定的字符串是否包含特殊的字符,如果包含返回true,否则返回false;
	 * @date: 2009-9-22 上午11:44:36
	 * @author: yjw
	 * @param :@param
	 *            srcStr
	 * @param :@param
	 *            spStr
	 * @return: boolean
	 */
	public static boolean includeSpChar(String srcStr, String[] spStr) {
		if (srcStr == null || srcStr.trim().equals(""))
			return false;
		if (spStr == null || spStr.length == 0) {
			return false;
		}
		for (int i = 0; i < spStr.length; i++) {
			if (srcStr.indexOf(spStr[i]) != -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @description:判断字符串中是否包含中文
	 * @date: 2009-9-23 上午09:44:48
	 * @author: yjw
	 * @param :@param
	 *            str
	 * @param :@return
	 * @return: boolean
	 */
	public static boolean isIncludeCN(String str) {
		str = DataFormat.trim(str);
		if (str.equals(""))
			return false;
		// String regEx = "[\\u4e00-\\u9fb0]";// U+4e00 ~ U+9FB0 原来 GB2312 和 GBK
		// 中的汉字
		String regEx = "[\\u3400-\\u9fb0]";// U+3400 ~ U+4DB6 包括 GB18030.2000
		// 中那些增加的汉字
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		if (m.find())
			return true;
		return false;
	}

	/**
	 * @description:判断首字母是否大写
	 * @date: 2009-9-23 上午10:39:01
	 * @author: yjw
	 * @param :@param
	 *            str
	 * @param :@return
	 * @return: boolean
	 */
	public static boolean isFirstCharUp(String str) {
		str = DataFormat.trim(str);
		if (str.equals(""))
			return false;
		return Character.isUpperCase(str.charAt(0));
	}

	/**
	 * @description:将字符串的首字母改为大写
	 * @date: 2009-9-24 下午03:03:52
	 * @author: yjw
	 * @param :@param
	 *            str
	 * @param :@return
	 * @return: String
	 */
	public static String toFirstCharUp(String str) {
		str = DataFormat.trim(str);
		if (str.equals(""))
			return "";
		char[] c = str.toCharArray();
		c[0] = Character.toUpperCase(c[0]);
		return new String(c);
	}

	/**
	 * @description:判断给出的字符串是否符合正则表达式的要求
	 * @date: 2009-9-23 下午02:05:07
	 * @author: yjw
	 * @param :@param
	 *            srcStr
	 * @param :@param
	 *            regExStr
	 * @param :@return
	 * @return: boolean
	 */
	public static boolean matchReg(String srcStr, String regExStr) {
		srcStr = DataFormat.trim(srcStr);
		Pattern p = Pattern.compile(regExStr);
		Matcher m = p.matcher(srcStr);
		if (m.matches())
			return true;
		return false;
	}

	/**
	 * @description:判断给出的字符串中是否只包含字母,数字,和括号
	 * @date: 2009-9-23 下午02:08:07
	 * @author: yjw
	 * @param :@param
	 *            string
	 * @param :@return
	 * @return: boolean
	 */
	public static boolean isNumOrWord2(String string) {
		String regEx = "^[A-Za-z0-9\\)\\(]+$";
		return matchReg(string, regEx);
	}

	/**
	 * @description:判断是否只包含大写字母和数字
	 * @date: 2009-9-23 下午03:08:29
	 * @author: yjw
	 * @param :@param
	 *            string
	 * @param :@return
	 * @return: boolean
	 */
	public static boolean isNumOrUpWord(String string) {
		String regEx = "^[A-Z0-9]+$";
		return matchReg(string, regEx);
	}

	/**
	 * @description:判断字符串是否为半角
	 * @date: 2009-10-15 下午03:45:14
	 * @author: yjw
	 * @param :@param
	 *            str
	 * @param :@return
	 * @return: boolean
	 */
	public static boolean isDBC(String str) {
		int length = str.length();
		int byteLength = str.getBytes().length;
		if (byteLength == length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @description:根据一户通规则计算字符的长度,按照一户通(AS400)每遇到一个全角就需要额外占用两个字节的规则, 如"中国人abcd",遇到一次连续的全角字符,那么需要额外占用2个字节,则一共占用(3*2+4+2)=12个字节;
	 *                                                                如"中国abcd人",遇到两次连续的全角字符,分别为"中国"和"人",那么需要额外占用4个字节(2+2),一共需要占用(3*2+4+4)=14个字节;
	 * @date: 2009-10-21 上午10:16:05
	 * @author: yjw
	 * @param :@param
	 *            input
	 * @param :@return
	 * @return: int
	 */
	public static int getBitByYIHUTONG(String input) {
		input = input.trim();
		if (input.equals(""))
			return 0;
		int count = 0;
		boolean isPreCharSBC = false;// 前一个字符是否为全角
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (Character.toString(c[i]).getBytes().length!=Character.toString(c[i]).length()) {//当前字符为全角字符或者中文字符
				if(isPreCharSBC==false){//前一个字符不是全角字符，那么是新遇到连续的全角字符
					isPreCharSBC=true;
					count++;
				}else{//前一个字符就是全角字符，说明当前全角字符和前一个全角字符是连续在一起的
					continue;//do nothing
				}
			}else{//当前字符不为全角字符
				isPreCharSBC = false ;//将isPreCharSBC变量置为false,以便下一次判断使用
			}
		}
		return input.getBytes().length+count*2;
	}
}
