package com.huateng.report.vaild.absbean;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopOpenAccount;

import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

public abstract class AbsReportDataVaild {
	public static final String VAILD_RESULT_SUCCESS = "00";// 全部正确

	private static final String serialNumber = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final String[] attrcodes = new String[]{"100","140","150","170","200","300"};

	private static Set<String> getAccountType() {
		String[] accounttypes = new String[] { "2101", "2102", "2103", "2104", "2106", "2107", "2108", "2109", "2110",
				"2111", "2112", "2201", "2202", "2301", "2302", "2303", "2304", "2305", "2306", "2401", "2402", "2403",
				"2404", "2405", "2406", "2407", "2408", "2409", "2410", "2411", "2412", "2413", "2414", "2415", "2416",
				"2417" };

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < accounttypes.length; i++) {
			set.add(accounttypes[i]);
		}
		return set;
	}

	/**
	 * 境内主体类型集合
	 *
	 * @return
	 */
	private static Set<String> getTreeSet() {
		Set<String> set = new HashSet<String>();
		String[] codes = new String[] { "10110100", "10110200", "10110301", "10110302", "10110303", "10110399",
				"10110401", "10110402", "10110403", "10110404", "10110405", "10110406", "10110407", "10110499",
				"10110501", "10110502", "10110599", "10119900", "10120101", "10120102", "10120103", "10120201",
				"10120202", "10120203", "10120204", "10120205", "10120206", "10120207", "10120299", "10120301",
				"10120302", "10120303", "10129900", "10130000" };
		for (int i = 0; i < codes.length; i++) {
			set.add(codes[i]);
		}
		return set;
	}

	/**
	 * 境外主体类型集合
	 *
	 * @return
	 */
	private static Set<String> getOverSet() {
		Set<String> set = new HashSet<String>();
		String[] codes = new String[] { "20001100", "20001200", "20001300", "20001401", "20001402", "20001501",
				"20001502", "20001601", "20001602", "20001603", "20001699", "20001700", "20001800", "20009900" };
		for (int i = 0; i < codes.length; i++) {
			set.add(codes[i]);
		}
		return set;
	}

	/**
	 * 部分债权人代码标识
	 *
	 * @return
	 */
	private static Set<String> getCredCodes() {
		Set<String> set = new HashSet<String>();
		String[] codes = new String[] { "GOV", "CEB", "CAP", "IDV" };
		for (int i = 0; i < codes.length; i++) {
			set.add(codes[i]);
		}
		return set;
	}

	private static int getNumberFromUnitCode(String code) {
		return serialNumber.indexOf(code);
	}

	public static String checkAttrcode(String attrcode){
		if (StringUtils.isNotEmpty(attrcode)) {
			for (String code : attrcodes) {
				if (StringUtils.equals(code, attrcode)) {
					return "[内资]、[联营]、[有限责任（公司）]、[私有]、[港澳台投资]、[国外投资]由于不是最细分类，因此为不可选项";
				}
			}
		}
		return StringUtils.EMPTY;
	}

	public static String checkCountrycode(String attrcode, String countrycode) {
		if (StringUtils.isNotEmpty(attrcode) && StringUtils.isNotEmpty(countrycode)) {
			if (StringUtils.equals(attrcode, "110") || StringUtils.equals(attrcode, "120") || StringUtils.equals(attrcode, "130")
					|| StringUtils.equals(attrcode, "210") || StringUtils.equals(attrcode, "220") || StringUtils.equals(attrcode, "230")
					|| StringUtils.equals(attrcode, "240") || StringUtils.equals(attrcode, "290") || StringUtils.equals(attrcode, "310")
					|| StringUtils.equals(attrcode, "320") || StringUtils.equals(attrcode, "330") || StringUtils.equals(attrcode, "340")
					|| StringUtils.equals(attrcode, "390")) {
				if (!StringUtils.equals(countrycode, "CHN")) {
					return "[经济类型代码]为[内资],[港澳台投资],[国外投资]项下[常驻国家代码]应为[中国]";
				}
			}
		}
		return StringUtils.EMPTY;
	}

	public String checkBankinfo(List<MtsBopOpenAccount>bankinfoList){
		if (null == bankinfoList || bankinfoList.isEmpty()) {
			return "同一笔单位基本情况表下开户信息，必须有一条";
		}
		StringBuilder result = new StringBuilder();
		for (MtsBopOpenAccount bankinfo : bankinfoList) {
			result.append(valLenByNotNull(bankinfo.getBranchcode(), 12, "金融机构标识码"));
			result.append(lessLenNull(bankinfo.getContact(), 40, "单位联系人"));
			result.append(lessLenNull(bankinfo.getTel(), 20, "单位联系电话"));
			result.append(lessLenNull(bankinfo.getFax(), 20, "单位传真"));
			int count = 0;
			for (MtsBopOpenAccount openaccount : bankinfoList) {
				if (StringUtils.equals(bankinfo.getBranchcode(), openaccount.getBranchcode())) {
					count ++;
				}
			}
			if (1 < count) {
				result.append("同一笔单位基本情况表下开户信息中金融机构标识码不能重复");
			}
		}
		return result.toString();
	}

	public static String checkInvcountrycode(String attrcode, List<String>invcountrycodeList){

		//校验外方投资者国别
		if (StringUtils.equals(attrcode, "210") || StringUtils.equals(attrcode, "220") || StringUtils.equals(attrcode, "230")
				|| StringUtils.equals(attrcode, "240") || StringUtils.equals(attrcode, "290")) {
			if (null == invcountrycodeList || invcountrycodeList.isEmpty()) {
				return "[经济类型]为[港澳台投资]项下,[外方投资者国别]不能为空";
			}
			boolean flag = false;
			for (String countrycode : invcountrycodeList) {
				if (StringUtils.equals(countrycode, "HKG") || StringUtils.equals(countrycode,"MAC") || StringUtils.equals(countrycode,"TWN")) {
					flag = true;
				}
			}
			if (!flag) {
				return "[经济类型]为[港澳台投资]项下,[外方投资者国别]中至少有[港澳台]之一";
			}
		}
		if (StringUtils.equals(attrcode, "310") || StringUtils.equals(attrcode, "320")
				|| StringUtils.equals(attrcode, "330") || StringUtils.equals(attrcode, "340")
				|| StringUtils.equals(attrcode, "390")) {
			if (null == invcountrycodeList || invcountrycodeList.isEmpty()) {
				return "[经济类型]为[国外投资]项下,[外方投资者国别]不能为空";
			}
			boolean flag = false;
			for (String countrycode : invcountrycodeList) {
				if (!StringUtils.equals(countrycode, "HKG") && !StringUtils.equals(countrycode, "MAC")
						&& !StringUtils.equals(countrycode, "TWN")
						&& !StringUtils.equals(countrycode, "CHN")) {
					flag = true;
				}
			}
			if (!flag) {
				return "[经济类型]为[港澳台投资]项下,[外方投资者国别]至少一项为外国（中国大陆及港澳台除外）";
			}
		}
		if (StringUtils.equals(attrcode, "400")) {
			if (null == invcountrycodeList || !invcountrycodeList.isEmpty()) {
				return "[经济类型]为[境外机构],[外方投资者国别]必须为空";
			}
		}
		if (null != invcountrycodeList) {
			for (String countrycode : invcountrycodeList) {
				if (StringUtils.equals("CHN", countrycode)) {
					return "外方投资者国别不能选择中国";
				}
				int count = 0;
				for (String invcountry : invcountrycodeList) {
					if (StringUtils.equals(countrycode, invcountry)) {
						count ++;
					}
				}
				if (1 < count){
					return "同一笔[单位基本情况表]下[投资国别代码]不能重复";
				}
			}
		}
		if (null != invcountrycodeList && invcountrycodeList.size() > 5) {
			return "[投资国别代码]必须[小于等于5个]";
		}
		return StringUtils.EMPTY;
	}

	public static String checkRptmethod(String rptmethod) {
		if (StringUtils.isNotEmpty(rptmethod)) {
			if (!StringUtils.equals("1", rptmethod) && !StringUtils.equals("2", rptmethod)) {
				return "只能选择：纸质申报，网上申报";
			}
		}
		return StringUtils.EMPTY;
	}

	public static String checkUnitCode(String UnitCode)
	{
		if (UnitCode == null || "".equals(UnitCode) || UnitCode.length() != 9 || "000000000".equals(UnitCode)) {
			return "组织机构代码不符合规范";
		}
		int one = getNumberFromUnitCode(UnitCode.substring(0, 1));
		int two = getNumberFromUnitCode(UnitCode.substring(1, 2));
		int three = getNumberFromUnitCode(UnitCode.substring(2, 3));
		int four = getNumberFromUnitCode(UnitCode.substring(3, 4));
		int five = getNumberFromUnitCode(UnitCode.substring(4, 5));
		int six = getNumberFromUnitCode(UnitCode.substring(5, 6));
		int seven = getNumberFromUnitCode(UnitCode.substring(6, 7));
		int eight = getNumberFromUnitCode(UnitCode.substring(7, 8));
		int tag = 11 - (one * 3 + two * 7 + three * 9 + four * 10 + five * 5 + six * 8 + seven * 4 + eight * 2) % 11;
		if (!StringUtils.equals("X", UnitCode.substring(8, 9)) && tag == 10) {
			return "组织机构代码不符合规范,最后一位必须为X";
		} else if (!StringUtils.equals("0", UnitCode.substring(8, 9)) && tag == 11) {
			return "组织机构代码不符合规范,最后一位必须为0";
		} else if (tag != 10 && tag != 11) {
			int nine = getNumberFromUnitCode(UnitCode.substring(8, 9));
			if (nine != tag) {
				return "组织机构代码不符合规范,最后一位必须为" + tag;
			}
		}
		return StringUtils.EMPTY;
	}

	public static String isChinese(String custname, String country){

		if (StringUtils.isNotEmpty(custname) && StringUtils.equals(country, "CHN")) {
			//半角
			String badChar ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			badChar += "abcdefghijklmnopqrstuvwxyz";
			badChar += "0123456789";
			badChar += "`~!@#$%^&()-_=+[]\\|:;\"\\'<,>?/";//不包含*或.的英文符号
			badChar += " ";

			//全角
			badChar += "ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ";
			badChar += "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
			badChar += "０１２３４５６７８９";
			badChar += "　";
			badChar += "｀～！＠＃＄％＾＆（）－＿＝＋［］＼｜：；＂＇＜，＞？／";//不包含*或.的英文符号

			for (int i = 0; i < custname.length(); i++) {
				char c = custname.charAt(i);//字符串str中的字符
				if (badChar.indexOf(c) > -1) {
					return "[常驻国家代码]为[中国]时[组织机构名称]必须输中文";
				}
			}
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 根据境外担保人类型确定境外担保人代码
	 *
	 * @return
	 */
	public String TypeConfirmCode(Object objstr, String errField) {
		StringBuffer result = new StringBuffer();

		return result.toString();
	}

	private static Set<String> getTreeSetOrg() {
		Set<String> set = new HashSet<String>();
		String[] codes = new String[] { "20001501", "20001502" };
		for (int i = 0; i < codes.length; i++) {
			set.add(codes[i]);
		}
		return set;
	}

	/**
	 * 资本项下-文件类型
	 *
	 * @return
	 */
	private static Set<String> getCFAFileTy() {

		Set<String> set = new HashSet<String>();
		String[] files = new String[] { "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM",
				"AN", "AP", "AQ", "AR", "AS", "BA", "BB", "BC", "CA", "CB", "DA", "DB", "EA", "EB", "FA", "EB", "FA",
				"FB", "FC", "FD" };
		for (int i = 0; i < files.length; i++) {
			set.add(files[i]);
		}
		return set;
	}



	/**
	 * 为空NULL验证
	 *
	 * @param objstr
	 * @param errField
	 * @return
	 */
	public String isNull(Object objstr, String errField) {
		StringBuffer result = new StringBuffer();
		if (objstr == null) {
			result.append(errField + "不能为空！");
		}
		return result.toString();
	}

	/**
	 * 为空或字符串长度为0验证
	 *
	 * @param objstr
	 * @param errField
	 * @return
	 */
	public String isEmpty(Object objstr, String errField) {
		StringBuffer result = new StringBuffer();
		if (objstr == null) {
			result.append(errField + "不能为空！");
		} else {
			String val = String.valueOf(objstr);
			if (val.trim().length() == 0) {
				result.append(errField + "不能为空！");
			}
		}
		return result.toString();
	}

	/**
	 * 长度验证，不能为空
	 *
	 * @param objstr
	 * @param len
	 * @param errField
	 * @return
	 */
	public String lessLen(String objstr, int len, String errField) {
		StringBuffer result = new StringBuffer();
		if (objstr == null || objstr.trim().length() == 0) {
			result.append(errField + "不能为空！");
		} else {
			if (objstr.trim().length() > len) {
				result.append(errField + "长度不能超过" + len + "位！");
			}
		}
		return result.toString();
	}

	/**
	 * 长度验证，可以为空（null或者长度0）
	 *
	 * @param objstr
	 * @param len
	 * @param errField
	 * @return
	 */
	public String lessLenNull(String objstr, int len, String errField) {
		StringBuffer result = new StringBuffer();
		if (objstr != null && objstr.trim().length() != 0) {
			if (objstr.trim().length() > len) {
				result.append(errField + "长度不能超过" + len + "位！");
			}
		}
		return result.toString();
	}

	/**
	 * 金额验证，可以为空（22位长度2位小数)
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isAmount22_2(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();
		if (val != null) {
			String regEx = "\\d{0,20}(\\.\\d{0,2}){0,1}$";
			boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
			if (!bl) {
				result.append(errField + "输入错误！");
			}
		}
		return result.toString();
	}

	/**
	 * 金额验证，可以为空（22位）
	 *
	 * @param val
	 * @param errField
	 */
	public String isAmount22_0(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();
		if (val != null) {
			String regEx = "\\d{0,22}$";
			boolean flag = ReportDataVaildUtil.regVaild(regEx, val.toString());
			if (!flag) {
				result.append(errField + "输入错误！");
			}
		}
		return result.toString();
	}

	/**
	 * 金额验证，不可以为空（22位）
	 */
	public String isAmount22_0NotNull(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();
		if (val == null) {
			result.append(errField + "不能为空！");
		} else {
			String regEx = "\\d{0,22}$";
			boolean flag = ReportDataVaildUtil.regVaild(regEx, val.toString());
			if (!flag) {
				result.append(errField + "输入错误！");
			}
		}
		return result.toString();
	}

	/**
	 * 银团所有债权人签约金额之和等于签约金额
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isAmountEqual(BigDecimal val, BigDecimal checkval, String errField1, String errField2) {
		StringBuffer result = new StringBuffer();
		if (val.longValue() >= 0 && checkval.longValue() >= 0) {
			boolean b1 = val.compareTo(checkval) == 0;
			if (!b1) {
				result.append(errField1 + "必须等于" + errField2 + "！");
			}
		}
		return result.toString();
	}

	/**
	 * 大于等于0且符合要求
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isAmountAndZero22_2(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();
		if (val != null) {
			if (val.doubleValue() < 0) {
				result.append(errField + "输入错误,须大于等于0！");
			} else {
				String regEx = "\\d{0,20}(\\.\\d{0,2}){0,1}$";
				boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
				if (!bl) {
					result.append(errField + "输入错误！");
				}
			}
		}
		return result.toString();
	}

	/**
	 * 大于0则必填
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String notZeroNotNull(BigDecimal val, String errField, String fieldn, String fieldm) {
		StringBuffer result = new StringBuffer();
		if ((errField == null || errField.length() == 0) && null != val) {
			if (val.doubleValue() > 0) {
				result.append("如果" + fieldm + "不为空,则" + fieldn + "必填");
			}
		} else if ((null != errField && 0 != errField.length()) && null == val) {
			result.append("如果" + errField + "不为空,则" + fieldn + "必填");
		}
		return result.toString();
	}

	/**
	 * 大于0则必填
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String notZeroNotNull2(BigDecimal val1, BigDecimal val2, String errField, String fieldn, String fieldm,
			String fields) {
		StringBuffer result = new StringBuffer();
		if (errField == null || errField.length() == 0) {
			if ((null != val1 && val1.doubleValue() > 0) || (null != val2 && val2.doubleValue() > 0)) {
				result.append("如果" + fieldm + "或" + fields + "大于0,则" + fieldn + "必填");
			}

		}

		return result.toString();
	}

	/**
	 * 比较BigDecimal大小
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isAmountAndPare22_2(BigDecimal val, BigDecimal checkval, String errField1, String errField2) {
		StringBuffer result = new StringBuffer();

		if (null != val && null != checkval) {
			if (val.longValue() > 0 && checkval.longValue() > 0) {
				if (val.compareTo(checkval) == 1) {
					result.append(errField2 + "需小于等于" + errField1 + "！");
				}
			}
		}
		return result.toString();
	}

	/**
	 * 大于等于0且符合要求
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isAmountAndZero22_2NotNull(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();

		if (null == val) {
			result.append(errField + "输入错误,不可以为空！");
		}

		if (val != null) {
			if (val.doubleValue() < 0) {
				result.append(errField + "输入错误,须大于等于0！");
			} else {
				String regEx = "\\d{0,20}(\\.\\d{0,2}){0,1}$";
				boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
				if (!bl) {
					result.append(errField + "输入错误！");
				}
			}
		}
		return result.toString();
	}

	/**
	 * 利率验证，可以为空（13位长度8位小数)
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isRatesAndZero13_8(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();
		if (val != null) {
			if (val.doubleValue() < 0) {
				result.append(errField + "输入错误,须大于0！");
			} else {
				String regEx = "\\d{0,5}(\\.\\d{0,8}){0,1}$";
				boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
				if (!bl) {
					result.append(errField + "输入错误！");
				}
			}
		}
		return result.toString();
	}

	/**
	 * 利率验证，不可以为空（13位长度8位小数)
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isRatesAndZero13_8NotNull(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();

		if (null == val) {
			result.append(errField + "输入错误,不可以为空！");
		}
		if (val != null) {
			if (val.doubleValue() < 0) {
				result.append(errField + "输入错误,须大于0！");
			} else {
				String regEx = "\\d{0,5}(\\.\\d{0,8}){0,1}$";
				boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
				if (!bl) {
					result.append(errField + "输入错误！");
				}
			}
		}
		return result.toString();
	}

	/**
	 * 利率验证，可以为空（13位长度8位小数)
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isRates13_8(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();
		if (val != null) {
			String regEx = "\\d{0,5}(\\.\\d{0,8}){0,1}$";
			boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
			if (!bl) {
				result.append(errField + "输入错误！");
			}
		}
		return result.toString();
	}

	/**
	 * 自定义正则表达式验证
	 *
	 * @param val
	 * @param errField
	 * @param regEx
	 * @return
	 */
	public String regVaild(String val, String errField, String regEx) {
		StringBuffer result = new StringBuffer();
		boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
		if (!bl) {
			result.append(errField + "输入错误！");
		}
		return result.toString();
	}

	/**
	 * 选填1项验证
	 *
	 * @param val1
	 * @param val2
	 * @param errField
	 * @return
	 */
	public String optionOne(Object val1, Object val2, String errField) {
		StringBuffer result = new StringBuffer();
		if (val1 == null && val2 == null) {
			result.append(errField + "请选填一项！");
		} else {
			String val1str = String.valueOf(val1);
			String val2str = String.valueOf(val2);
			if (val1str.trim().length() == 0 && val2str.trim().length() == 0) {
				result.append(errField + "请选填一项！");
			}
		}
		return result.toString();
	}

	/**
	 * 四个选填1项验证
	 *
	 * @param val1
	 * @param val2
	 * @param val3
	 * @param val4
	 * @param errField
	 * @return
	 */
	public String fourOptionOne(Object val1, Object val2, Object val3, Object val4, String errField) {
		StringBuffer result = new StringBuffer();
		boolean val11 = (val1 == null) || (String.valueOf(val1).equals(""));
		boolean val22 = (val2 == null) || (String.valueOf(val2).equals(""));
		boolean val33 = (val3 == null) || (String.valueOf(val3).equals(""));
		boolean val44 = (val4 == null) || (String.valueOf(val4).equals(""));

		if (val11 && val22 && val33 && val44) {
			result.append(errField + "请选填一项！");
		}

		return result.toString();
	}

	/**
	 * 三个选填1项验证
	 *
	 * @param val1
	 * @param val2
	 * @param val3
	 * @param errField
	 * @return
	 */
	public String threeOptionOne(Object val1, Object val2, Object val3, String errField) {
		StringBuffer result = new StringBuffer();
		boolean val11 = (val1 == null) || (String.valueOf(val1).equals(""));
		boolean val22 = (val2 == null) || (String.valueOf(val2).equals(""));
		boolean val33 = (val3 == null) || (String.valueOf(val3).equals(""));

		if (val11 && val22 && val33) {
			result.append(errField + "请选填一项！");
		}

		return result.toString();
	}

	/**
	 * 字符串长度验证，允许为空
	 *
	 * @param val
	 * @param len
	 * @param errField
	 * @return
	 */
	public String valLenByNull(String val, int len, String errField) {
		StringBuffer result = new StringBuffer();
		if (val != null && val.length() != 0) {
			if (val.trim().length() != len) {
				result.append(errField + "长度必须为" + len + "位！");
			}
		}
		return result.toString();
	}

	/**
	 * 字符串长度验证，不允许为空
	 *
	 * @param val
	 * @param len
	 * @param errField
	 * @return
	 */
	public String valLenByNotNull(String val, int len, String errField) {
		StringBuffer result = new StringBuffer();
		if (val == null) {
			result.append(errField + "不能为空！");
		} else {
			if (val.trim().length() != len) {
				result.append(errField + "长度必须为" + len + "位！");
			}
		}
		return result.toString();
	}

	/**
	 * val的值大于0的值，可为空
	 *
	 * @param bigDecimal
	 * @param errField
	 * @return
	 */
	public String valLtZeroNull(BigDecimal bigDecimal, String errField) {
		StringBuffer result = new StringBuffer();

		if (null != bigDecimal) {
			if (bigDecimal.compareTo(new BigDecimal(0)) >= 0) {
				result.append(errField + "必须大于等于零");
			}

		}
		return result.toString();
	}

	/**
	 * 判断字符串是否相等
	 *
	 * @param val1
	 * @param val2
	 * @param errField1
	 * @param errField2
	 * @return
	 */
	public String isEqual(String val1, String val2, String errField1, String errField2) {
		StringBuffer result = new StringBuffer();
		if (!val1.equals(val2)) {
			result.append(errField2 + "需等于" + errField1 + "！");
		}
		return result.toString();
	}

	/**
	 * 日期比对验证 yyyyMMdd
	 *
	 * @param startDate
	 * @param endDate
	 * @param errField
	 * @return
	 * @throws ParseException
	 */
	public String dateLessCheckDate(String date, String checkDate, String errField1, String errField2) {
		StringBuffer result = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			boolean bl = sdf.parse(date).before(sdf.parse(checkDate));
			if (!bl) {
				result.append(errField2 + "需大于" + errField1 + "！");
			}
		} catch (ParseException e) {
			result.append(errField1 + "或" + errField2 + "不符合格式要求！");
		}
		return result.toString();
	}

	/**
	 * 日期比对验证 yyyyMMdd
	 *
	 * @param startDate
	 * @param endDate
	 * @param errField
	 * @return
	 * @throws ParseException
	 */
	public String dateLessCheckDateOrEqual(String date, String checkDate, String errField1, String errField2) {
		StringBuffer result = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			boolean bl = sdf.parse(date).before(sdf.parse(checkDate));
			if (!bl && !date.equals(checkDate)) {
				result.append(errField2 + "需大于等于" + errField1 + "！");
			}
		} catch (ParseException e) {
			result.append(errField1 + "或" + errField2 + "不符合格式要求！");
		}
		return result.toString();
	}

	/**
	 * 日期比对验证 yyyyMMdd
	 *
	 * @param startDate
	 * @param endDate
	 * @param errField
	 * @return
	 * @throws ParseException
	 */
	public String dateltCheckDateOrEqual(String date, String errField1) {
		StringBuffer result = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			String checkDate = DateUtil.getWorkDate();
			boolean bl = sdf.parse(date).before(sdf.parse(checkDate));
			if (!bl && !date.equals(checkDate)) {
				result.append(errField1 + "需小于等于工作日期！");
			}
		} catch (Exception e) {
			result.append(errField1 + "不符合格式要求！");
		}
		return result.toString();
	}

	/**
	 * 日期比对验证 yyyyMMdd
	 *
	 * @param startDate
	 * @param endDate
	 * @param errField
	 * @return
	 * @throws ParseException
	 */
	public String dateltCheckDate(String date, String errField1) {
		StringBuffer result = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			String checkDate = DateUtil.getWorkDate();
			boolean bl = sdf.parse(date).before(sdf.parse(checkDate));
			if (!bl) {
				result.append(errField1 + "需小于工作日期！");
			}
		} catch (Exception e) {
			result.append(errField1 + "不符合格式要求！");
		}
		return result.toString();
	}

	/**
	 * 日期比对验证
	 *
	 * @param startDate
	 * @param endDate
	 * @param errField
	 * @return
	 * @throws ParseException
	 */
	public String dateLessCheckDate(Date date, Date checkDate, String errField1, String errField2) {
		StringBuffer result = new StringBuffer();
		boolean bl = date.before(checkDate);
		if (!bl) {
			result.append(errField2 + "需大于" + errField1 + "！");
		}
		return result.toString();
	}

	/**
	 * 日期比对验证 自定义格式
	 *
	 * @param startDate
	 * @param endDate
	 * @param errField
	 * @return
	 * @throws ParseException
	 */
	public String dateLessCheckDate(String date, String checkDate, String errField1, String errField2, String formatStr) {
		StringBuffer result = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			boolean bl = sdf.parse(date).before(sdf.parse(checkDate));
			if (!bl) {
				result.append(errField2 + "需大于" + errField1 + "！");
			}
		} catch (ParseException e) {
			result.append(errField1 + "或" + errField2 + "不符合格式要求！");
		}
		return result.toString();
	}

	// ==========================================================业务性判断============================================

	/**
	 * 根据输入国家地区代码判断主体类型代码
	 *
	 * @param county
	 * @param code
	 * @param errField
	 * @return
	 */
	public String countySubTypeCode(String county, String code, String errField) {
		StringBuffer result = new StringBuffer();
		Set<String> set = null;
		if (county.equalsIgnoreCase(ReportConstant.CURRENT_COUNTY_CODE)) {
			set = getOverSet();
		} else {
			set = getTreeSet();
		}
		if (!set.contains(code)) {
			result.append(errField + "输入错误！");
		}
		return result.toString();
	}

	/**
	 * 根据账户类型判断是否需要输入 外汇局批件号/备案表号/业务编号
	 *
	 * @param county
	 * @param code
	 * @param errField
	 * @return
	 */
	public String checkFileNumberByAccounttype(String accounttype, String fileNumber) {
		StringBuffer result = new StringBuffer();
		if (StringUtils.isNotEmpty(accounttype)) {
			Set<String> set = getAccountType();
			if (set.contains(accounttype) && StringUtils.isEmpty(fileNumber)) {
				result.append("外汇局批件号/备案表号/业务编号不能为空！");
			}
		}
		return result.toString();
	}

	/**
	 * ISIN CODE验证
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String isInCodeVaild(String val) {
		StringBuffer result = new StringBuffer();
		if (val != null) {
			String regEx = "[A-Z]{2}[0-9A-Za-z]{9}[0-9]{1}$";
			boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
			if (!bl) {
				result.append("ISIN CODE输入错误！");
			}
		}
		return result.toString();
	}

	/**
	 * 当为删除时则验证 删除原因不能为空
	 *
	 * @param actionTy
	 * @param delRemark
	 * @return
	 */
	public String isDelRemarkVaild(String actionTy, String delRemark) {
		StringBuffer result = new StringBuffer();
		if (actionTy != null && TopReportConstants.REPORT_ACTIONTYPE_D.equals(actionTy)) {
			if (null == delRemark || "".equals(delRemark.trim())) {
				result.append("删除原因不能为空！");
			}
		} else if (actionTy != null && !TopReportConstants.REPORT_ACTIONTYPE_D.equals(actionTy)) {
			if (null != delRemark && !"".equals(delRemark.trim())) {
				result.append("非删除操作,删除原因必须为空！");
			}
		}

		return result.toString();
	}

	/**
	 * 公允价值进行验证
	 *
	 * @param val
	 * @return
	 */
	public String isFariValue(BigDecimal val) {
		StringBuffer result = new StringBuffer();
		if (val != null) {
			String regEx = "[+-]?([0-9]{1}[\\d]{0,19}|[0-9]{1}[\\d]{0,19}[\\.][\\d]{1,2}|0)$";
			boolean bl = ReportDataVaildUtil.regVaild(regEx, val.toString());
			if (!bl) {
				result.append("公允价值输入错误！");
			}
		}
		return result.toString();
	}

	/**
	 * 外债债权人代码
	 *
	 * @param val
	 * @param creditorType
	 * @param debType
	 * @param errField
	 * @return
	 */
	public String exdetbCreditorCodeVaild(String val, String creditorType, String debType, String errField) {
		StringBuffer result = new StringBuffer();
		if (val != null && val.trim().length() > 0) {
			if (val.trim().length() > 11) {
				result.append(errField + "输入错误,不能超过11位!");
			}
			if (creditorType != null) {
				if (creditorType.equals("20001100") || creditorType.equals("20001300")) {
					if (val.trim().length() != 6) {
						result.append(errField + "输入错误!");
					}
				}
			} else if (debType != null) {
				if (debType.equals("1201") || debType.equals("1202") || debType.equals("1304")) {
					if (val.trim().length() != 6) {
						result.append(errField + "输入错误!");
					}
				}
			}
		}
		return result.toString();
	}

	/**
	 * 受益人等验证
	 *
	 * @param val
	 * @param appTlrType
	 * @param errField
	 * @return
	 */
	public String exguTlrCodeVaild(String val, String appTlrType, String errField) {
		StringBuffer result = new StringBuffer();
		Set<String> treeOrgset = getTreeSetOrg();
		if (val != null && appTlrType != null && val.trim().length() > 0) {
			if (val.trim().length() > 32) {
				result.append(errField + "输入错误,不能超过32位!");
			}
			//
			// if (treeOrgset.contains(appTlrType)) {//境外金融机构
			// if(val.trim().length()!=8 ||val.trim().length()!=11){
			// result.append(errField+"输入错误,应为8-11位SWIFT CODE");
			// }
			// }else if(appTlrType.equals("10130000")){
			// String regEx ="\\d{15}$)|(\\d{17}([0-9]|X)$";
			// boolean bl = ReportDataVaildUtil.regVaild(regEx,val);
			// if (!bl) {
			// result.append(errField+"输入错误,应为个人身份证号！");
			// }
			// }
		}

		return result.toString();
	}

	/**
	 * 字符串日期格式验证
	 *
	 * @param date
	 *            日期字符串
	 * @param format
	 *            格式字符串
	 * @param errField
	 *            错误描述
	 * @return
	 */
	public static String checkDateFormat(String date, String format, String errField) {
		StringBuilder result = new StringBuilder();
		if (StringUtils.isNotEmpty(date)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				sdf.parse(date);
			} catch (ParseException e) {
				result.append(errField).append("格式不正确！");
			}
		}
		return result.toString();
	}

	public static String isYorNAndNotNull(String value, String errField) {
		StringBuilder result = new StringBuilder();
		if (StringUtils.isEmpty(value)) {
			result.append(errField).append("不能为空！");
		}
		if (!StringUtils.equals("Y", value) && !StringUtils.equals("N", value)) {
			result.append(errField).append("必须为Y或N");
		}
		return result.toString();
	}

	public static String checkActiontype(String value) {
		StringBuilder result = new StringBuilder();
		if (StringUtils.isEmpty(value)) {
			result.append("操作类型不能为空！");
		}
		if (!StringUtils.equals(TopReportConstants.REPORT_ACTIONTYPE_A, value)
				&& !StringUtils.equals(TopReportConstants.REPORT_ACTIONTYPE_C, value)
				&& !StringUtils.equals(TopReportConstants.REPORT_ACTIONTYPE_D, value)) {
			result.append("操作类型必须为A,C或D！");
		}
		return result.toString();
	}

	/**
	 * 业务流水号
	 *
	 * @param appTy
	 * @param fileTy
	 * @param filler2
	 * @param brNo
	 * @return
	 */
	public String exbuiSeNumVaild(String appTy, String fileTy, String filler2, String brNo) {
		StringBuffer result = new StringBuffer();

		if (TopReportConstants.REPORT_APP_TYPE_ACC.equals(appTy)) {

		} else if (TopReportConstants.REPORT_APP_TYPE_CFA.equals(appTy)) {

		}

		return result.toString();
	}

	// 如果债权人为银行，应填写8位或11位的SWIFT CODE；如果债权人类型为“政府”、或“中央银行”时，
	// 或者当债务类型为“货币市场工具”或“债券和票据”或“非居民个人存款”时，应在外汇局编制的部分债权人代码表中选择债权人代码；否则为空。
	// 如果债权人为“非银行金融机构”或“国际金融组织”，应优先填写SWIFT CODE。
	public String validateCreditorCodeNull(String creditorType, String creditorCode, String debtType, String countrycode) {
		if (StringUtils.isNotEmpty(creditorCode)) {
			if (StringUtils.equals("20001100", creditorType)) {
				if (!StringUtils.equals(creditorCode, "GOV" + countrycode)) {
					return "债权人类型为[政府],债券人代码必须是GOV+国家地区代码";
				}
			}
			if (StringUtils.equals("20001300", creditorType)) {
				if (!StringUtils.equals(creditorCode, "CEB" + countrycode)) {
					return "债权人类型为[中央银行],债券人代码必须是CEB+国家地区代码";
				}
			}
			if (StringUtils.equals("20001800", creditorType)) {
				if (!StringUtils.equals(creditorCode, "CAP" + countrycode)) {
					return "债权人类型为[资本市场],债券人代码必须是CAP+国家地区代码";
				}
			}
			if (StringUtils.equals(debtType, TopReportConstants.REPORT_FILE_TYPE_CFA_AP)) {
				if (!StringUtils.equals(creditorCode, "IDV" + countrycode)) {
					return "债务类型为[非居民个人存款],债券人代码必须是IDV+国家地区代码";
				}
			}
			if (StringUtils.equals("20001401", creditorType) || StringUtils.equals("20001402", creditorType)) {
				if (StringUtils.isNotEmpty(creditorCode)) {
					if (8 != creditorCode.length() && 11 != creditorCode.length()) {
						return "债权人为[银行]，应填写8位或11位的SWIFT CODE";
					}
				}
			}
		}
		return StringUtils.EMPTY;
	}

	// ==========================================================BOP校验规则==========================================================//
	/**
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String amtNotNull(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();

		if (null == val) {
			result.append(errField + "不可为空");
		}
		return result.toString();
	}

	/**
	 * val的值大于0的值，可为空
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String valGtZeroNull(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();

		if (null != val) {
			if (val.compareTo(new BigDecimal(0)) < 1) {
				result.append(errField + "必须大于零");
			}
		}
		return result.toString();
	}

	/**
	 * val的值大于等于0的值，可为空
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String valGEZeroNull(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();

		if (null != val) {
			if (val.compareTo(new BigDecimal(0)) < 0) {
				result.append(errField + "必须大于等于零");
			}
		}
		return result.toString();
	}

	/**
	 * val的值大于0的值， 不可为空
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String valGtZeroNotNull(BigDecimal val, String errField) {
		StringBuffer result = new StringBuffer();

		if (null == val) {
			result.append(errField + "不可空");
		}

		if (null != val) {
			if (val.compareTo(new BigDecimal(0)) < 1) {
				result.append(errField + "必须大于零");
			}
		}
		return result.toString();
	}

	/**
	 * 检查OPPUSER不为空且是否以(JW)或(JN)开头
	 *
	 * @param oppuser
	 * @param fileType
	 * @param errField
	 * @return
	 */
	public String valOppuser(String oppuser, String fileType, String errField) {
		StringBuffer result = new StringBuffer();
		if (StringUtils.isEmpty(oppuser)) {
			result.append(errField + "不可空");
		} else if (StringUtils.isNotEmpty(oppuser)) {
			if (oppuser.length() > 128) {
				result.append(errField + "长度不能大于128位！");
			}
			if (fileType.equals("A") || fileType.equals("B") || fileType.equals("C")) {
				if (!oppuser.startsWith("(JW)") && !oppuser.startsWith("(JN)")) {
					result.append(errField + "必需以(JN)或(JW)开头！");
				}
			} else if (fileType.equals("D") || fileType.equals("E") || fileType.equals("F")) {
				if (oppuser.startsWith("(JW)") || oppuser.startsWith("(JN)")) {
					result.append(errField + "不需以(JN)或(JW)开头！");
				}
			}
		}
		return result.toString();
	}

	/**
	 * 根据客户类型判断组织机构代码和个人身份证号码
	 *
	 * @param custtype 客户类型
	 * @param custcod  组织机构代码
	 * @param idcode	个人身份证号码
	 * @param errField	客户类型字段说明
	 *
	 * @return
	 */
	public String valCusttype(String custtype, String custcod, String idcode, String errField) {
		StringBuffer result = new StringBuffer();
		if (StringUtils.isEmpty(custtype)) {
			result.append(errField + "不可空！");
		} else if (StringUtils.isNotEmpty(custtype)) {
			if (custtype.length() != 1) {
				result.append(errField + "长度不符合规范！");
			}
			// 客户类型为C-对公
			if (custtype.equals("C")) {
				if (StringUtils.isEmpty(custcod)) {
					result.append("客户类型为对公时， 组织机构代码不能为空！");
				} else if (custcod.length() != 9) {
					result.append("客户类型为对公时， 组织机构代码长度必须为9位！");
				}else if(custcod.length()==9){
					try {
						String sc = isValidEntpCode(custcod);
						if(!sc.equals(String.valueOf(custcod.charAt(8)))){
							result.append("组织机构代码错误，最后一位应为'"+sc+"'！");
						}
					} catch (Exception e) {
						result.append(e.getMessage());
					}
				}
				if (StringUtils.isNotEmpty(idcode)) {
					result.append("客户类型为对公时， 个人身份证号码必须为空！");
				}
				// 客户类型为对私
			} else {
				if (StringUtils.isEmpty(idcode)) {
					result.append("客户类型为对私时， 个人身份证号码不能为空！");
				} else if (idcode.length() < 1 || idcode.length() > 32) {
					result.append("客户类型为对私时，个人身份证号码长度不能超过32位！");
				}
				if (StringUtils.isNotEmpty(custcod)) {
					result.append("客户类型为对私时，  组织机构代码必须为空！");
				}
			}
		}
		return result.toString();
	}

	/**
	 * 组织机构代码校验
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static String isValidEntpCode(String code) throws Exception {
		int[] ws = { 3, 7, 9, 10, 5, 8, 4, 2 };
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String regex = "^([0-9A-Z]){8}[0-9|X]$";

		if (!code.matches(regex)) {
			throw new Exception("组织机构代码格式错误！");
		}
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			sum += str.indexOf(String.valueOf(code.charAt(i))) * ws[i];
		}

		int c9 = 11 - (sum % 11);

		String sc9 = String.valueOf(c9);
		if (11 == c9) {
			sc9 = "0";
		} else if (10 == c9) {
			sc9 = "X";
		}
		return sc9;
	}

	/**
	 * BOP/JSH 验证修改和删除原因
	 *
	 * @param subsuccess
	 * @param actionDesc
	 * @return
	 */
	public String isModDelRemarkVaild(String subsuccess, String actionDesc) {
		StringBuffer result = new StringBuffer();
		if(StringUtils.isNotEmpty(subsuccess)) {
			// 如果成功上报，原因必填
			if("1".equals(subsuccess)) {
				if (null == actionDesc || "".equals(actionDesc.trim())) {
					result.append("修改/删除原因不能为空！");
				} else if (actionDesc.length() > 128) {
					result.append("修改/删除原因长度不能超过128位！");
				}
			}
		}
		return result.toString();
	}

	public abstract String executeDataVaild(Object obj);
}
