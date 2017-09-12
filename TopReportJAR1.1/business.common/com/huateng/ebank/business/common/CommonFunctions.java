package com.huateng.ebank.business.common;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import resource.bean.pub.FunctionInfo;
import resource.dao.pub.FunctionInfoDAO;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.service.pub.UserMgrService;

public class CommonFunctions {

	public static CommonFunctions getInstance() {
		return new CommonFunctions();
	}

	// BMS-2472 南京银行版本合并 jiang@2010-02-09 begin
	/**
	 * 根据起始日和相隔天数计算终止日
	 *
	 * @param startDate
	 * @param days
	 * @return
	 */
	public static Date getEndDateByDays(Date startDate, int days) {
		Calendar calendarStartDate = Calendar.getInstance();
		calendarStartDate.setTime(startDate);
		calendarStartDate.add(Calendar.DAY_OF_YEAR, days);

		return calendarStartDate.getTime();
	}

	// BMS-2472 南京银行版本合并 jiang@2010-02-09 end
	/*
	 * 生成功能树字符串.
	 */
	public static StringBuffer getFunction(List<FunctionInfo> lst) throws CommonException {
		StringBuffer sb = new StringBuffer();
		Iterator it = lst.iterator();
		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			sb.append("\"");
			sb.append(f.getId());
			sb.append("|");
			sb.append(f.getLastdirectory());
			sb.append("|");
			if (f.getIsdirectory() == 1)
				sb.append(f.getFuncname());
			else {
				String fullpath = getFullPath(f.getId());
				sb.append("<input type='checkbox' id='id" + f.getId() + "' name='id' height='14pt' value='" + fullpath + "'>" + f.getFuncname() + "</input>");
			}
			sb.append("\"");
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb;
	}

	/*
	 * 生成功能树数组.
	 */
	public static List<String> getFunctionList(List<FunctionInfo> lst) throws CommonException {

		Iterator it = lst.iterator();
		List<String> result = new ArrayList<String>();
		Map ht = transToHashtableByFunc(lst);

		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			StringBuffer sb = new StringBuffer();
			// sb.append("\"");
			sb.append(f.getId().trim());
			sb.append("|");
			sb.append(f.getLastdirectory());
			sb.append("|");
			if (f.getIsdirectory() == 1)
				sb.append(f.getFuncname().trim());
			else {
				String fullpath = getFullPathByAllFuncList(f.getId().trim(), ht);
				sb.append("<input type='checkbox' id='id" + f.getId().trim() + "' name='id' height='14pt' value='" + fullpath + "'>" + f.getFuncname().trim() + "</input>");
			}
			// sb.append("\"");
			result.add(sb.toString());
		}
		return result;
	}

	public static List<String> getFunctionListCompar(List<FunctionInfo> lst) throws CommonException {

		Iterator it = lst.iterator();
		List<String> result = new ArrayList<String>();
		Map ht = transToHashtableByFunc(lst);

		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			StringBuffer sb = new StringBuffer();
			// sb.append("\"");
			sb.append(f.getId().trim());
			sb.append("|");
			sb.append(f.getLastdirectory());
			sb.append("|");
			if (f.getIsdirectory() == 1)
				sb.append(f.getFuncname().trim());
			else {
				String fullpath = getFullPathByAllFuncList(f.getId().trim(), ht);
				sb.append("<input type='checkbox' id='id" + f.getId().trim() + "' name='id' height='14pt' value='" + fullpath + "'>" + f.getFuncname().trim() + "</input>");
			}
			// sb.append("\"");
			result.add(sb.toString());
		}
		return result;
	}

	/**
	 * 将YYYYMMDD -> YYYY-MM-DD
	 *
	 * @param date8
	 * @return
	 */
	public static String converDate8TO101(String date8) {
		if (date8 != null && date8.length() == 8) {
			String sYear = date8.substring(0, 4);
			String sMonth = date8.substring(4, 6);
			String sDay = date8.substring(6);
			return sYear + "-" + sMonth + "-" + sDay;
		} else {
			return date8;
		}
	}

	/**
	 * 将YYYY-MM-DD-> YYYYMMDD
	 *
	 * @param date8
	 * @return
	 */
	public static String converDate12TO8(String data12) {
		if (data12 != null && data12.length() == 12) {
			String sYear = data12.substring(0, 4);
			String sMonth = data12.substring(5, 7);
			String sDay = data12.substring(8);
			return sYear + sMonth + sDay;
		} else {
			return data12;
		}
	}

	/**
	 * 将24hhmiss -> hh:mi:ss
	 *
	 * @param date8
	 * @return
	 */
	public static String converStringTOTime(String time) {
		if (time != null && time.length() == 6) {
			String hh = time.substring(0, 2);
			String mi = time.substring(2, 4);
			String ss = time.substring(4);
			return hh + ":" + mi + ":" + ss;
		} else {
			return time;
		}
	}

	/**
	 * 将用BigDecimal 表示的金额转换成以(18,2)形式表示的金额. 符合ECDS金额类型
	 */
	public final static String formatLoaclAmt6ReqAmt(BigDecimal bigDec) {
		if (bigDec == null)
			return null;
		DecimalFormat formatter = new DecimalFormat("###############0.000000");
		return formatter.format(bigDec);
	}

	/** 取得系统当前日期 YYYYMMDD */
	public static String getCurrDate() {
		String currentDate = null;
		/* 使用webserver机器时间 */
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		currentDate = formater.format(new Date());
		return currentDate;
	}

	/**
	 * <P>
	 * getRoleFunction:(生成tree,menu string字符串)
	 * <P>
	 * 适用条件: (这里描述这个方法适用条件 – 可选)
	 * <P>
	 * 执行流程: (这里描述这个方法的执行流程 – 可选)
	 * <P>
	 * 使用方法: (这里描述这个方法的使用方法 – 可选)
	 * <P>
	 * 注意事项: (这里描述这个方法的注意事项 – 可选)
	 *
	 * @param iRoot
	 * @param lst
	 * @param iloc
	 * @return
	 * @throws CommonException
	 * @throws
	 * @since CommonFunctions Ver1.1
	 */
	public static StringBuffer getRoleFunction(int iRoot, List lst, int iloc) throws CommonException {
		GlobalInfo global = GlobalInfo.getCurrentInstance();
		String sPath = global.getSContextPath();
		StringBuffer sb = new StringBuffer();
		Iterator it = lst.iterator();
		/* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 begin . */
		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			if ((f.getLastdirectory().equals(String.valueOf(iRoot))) && (f.getLocation() == iloc)) {
				String functionName = MessageResourceUtil.getBasicMessage("FUN." + f.getId().trim(), true, null);
				if (functionName == null || !MessageResourceUtil.isIl8n()) {
					functionName = f.getFuncname();
				}
				if (f.getIsdirectory() == 1) {
					sb.append("0,'");
					sb.append(functionName + "','" + f.getId().trim() + "','" + functionName + "','','',4,'','','',-1,");
					sb.append(getRoleFunction(Integer.parseInt(f.getId().trim()), lst, iloc));
					sb.append("1,");
					if (iRoot == 0)
						sb.append("5,");
				} else {
					sb.append("2,'" + functionName + "','" + f.getId().trim() + "','" + functionName + "','',3,'','" + sPath + f.getPagepath() + "','',");
				}
			}
			/* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 end. */
		}
		return sb;
	}

	/*
	 * 生成tree,menu string字符串.
	 */
	/** modify by chenjinghui 2010-5-20 HTEBANK-18 begin */
	public static StringBuffer getAdminRoleFunction(int iRoot, List lst, int iloc) throws CommonException {
		// GlobalInfo global = GlobalInfo.getCurrentInstance();
		String sPath = "";// global.getSContextPath();
		StringBuffer sb = new StringBuffer();
		Iterator it = lst.iterator();
		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			if ((f.getLastdirectory().equals(String.valueOf(iRoot))) && (f.getLocation() == iloc)) {
				if (f.getIsdirectory() == 1) {
					sb.append("0,'");
					sb.append(f.getFuncname() + "','" + f.getFuncname() + "','" + f.getFuncname() + "','','',4,'','','',-1,");
					sb.append(getAdminRoleFunction(Integer.parseInt(f.getId()), lst, iloc));
					sb.append("1,");
					if (iRoot == 0)
						sb.append("5,");
				} else {
					sb.append("2,'" + f.getFuncname() + "','" + f.getFuncname() + "','" + f.getFuncname() + "','',3,'','" + sPath + f.getPagepath() + "','',");
				}
			}
		}
		return sb;
	}

	/** modify by chenjinghui 2010-5-20 HTEBANK-18 end */
	/*
	 * 生成收藏夹字符串.
	 */
	public static StringBuffer getSvaeFolder(List lst) throws CommonException {

		// GlobalInfo global = GlobalInfo.getCurrentInstance();
		// String spath = "";//global.getSContextPath();
		StringBuffer sb = new StringBuffer();
		sb.append("0,'收藏夹','收藏夹','收藏夹','','',4,'','','',-1,");
		Iterator it = lst.iterator();
		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			sb.append("2,'" + f.getFuncname() + "','" + f.getId() + "','" + f.getFuncname() + "','',3,'','" + f.getPagepath() + "','',");
		}
		sb.append("1,5,");
		return sb;
	}

	public static Map transToHashtableByFunc(List lst) {
		Map mp = Collections.synchronizedMap(new LinkedHashMap());
		Iterator it = lst.iterator();
		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			mp.put(f.getId().trim(), f);
		}
		return mp;
	}

	public static List getAllFuncList() {
		String str = "from FunctionInfo func";
		List list;
		try {
			list = CommonFunctions.getFunctionList(BaseDAOUtils.getHQLDAO().queryByQL2List(str));
		} catch (CommonException e) {
			return new ArrayList();
		}

		return list;
	}

	public static Hashtable transToHashtableByFuncAdmin(List lst) {
		Hashtable ht = new Hashtable();
		Iterator it = lst.iterator();
		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			ht.put(f.getId(), f);
		}
		return ht;
	}

	public static String getFullPathByAllFuncList(String fid, Map ht) {
		if (ht == null) {
			ht = transToHashtableByFunc(getAllFuncList());
		}

		FunctionInfo f = (FunctionInfo) ht.get(fid);
		if (f != null) {
			// System.out.println(fid+"-Lastdirectory="+f.getLastdirectory());
			if (f.getLastdirectory().equals("0"))
				return f.getId().trim();
			else
				return getFullPathByAllFuncList(f.getLastdirectory().toString().trim(), ht).trim() + "," + f.getId().trim();
		} else {
			// System.out.println(fid + "is null");
			return "";
		}
	}

	public static String getFullPathByAllFuncListCompar(String fid, Map ht) {
		if (ht == null) {
			ht = transToHashtableByFunc(getAllFuncList());
		}

		FunctionInfo f = (FunctionInfo) ht.get(fid);
		if (f != null) {
			// System.out.println(fid+"-Lastdirectory="+f.getLastdirectory());
			if (f.getLastdirectory().equals("0"))
				return f.getId().trim();
			else
				return getFullPathByAllFuncListCompar(f.getLastdirectory().toString().trim(), ht).trim() + "," + f.getId().trim();
		} else {
			// System.out.println(fid + "is null");
			return "";
		}
	}

	public static String getFullPath(String fid) throws CommonException {
		GlobalInfo global = GlobalInfo.getCurrentInstance();
		Map<String, FunctionInfo> ht = global.getAllFunctions();

		FunctionInfo f = ht.get(fid);
		if (f != null) {
			System.out.println(fid + "-Lastdirectory=" + f.getLastdirectory());
			if (f.getLastdirectory().equals("0"))
				return f.getId().trim();
			else
				return getFullPath(f.getLastdirectory().toString().trim()) + "," + f.getId().trim();
		} else {
			System.out.println(fid + "is null");
			return "";
		}
	}

	public static int[] getAmountEveryNum(String sValue) {
		double amount = Double.parseDouble(sValue);
		if (amount > 99999999999999.99 || amount < -99999999999999.99)
			throw new IllegalArgumentException("参数值超出允许范围 (-99999999999999.99 ～ 99999999999999.99)！");
		long longvalue = Math.round(amount * 100);
		int[] iResult = new int[10];
		for (int i = 0; i < 10; i++) {
			iResult[i] = (int) longvalue % 10;
			longvalue = longvalue / 10;
		}
		return iResult;
	}

	public static String commonFillDefault(String sValue, int iType) throws CommonException {
		if (iType == SystemConstant.TYPE_STRING) {
			if (sValue == null || sValue.equals("")) {
				return " ";
			} else {
				return sValue;
			}
		}
		if (iType == SystemConstant.TYPE_DATE) {
			if (sValue == null || sValue.equals("")) {
				return " ";
			} else {
				sValue = sValue.replace("-", "");
				sValue = sValue.replace("/", "");
				return sValue;
			}
		}
		if (iType == SystemConstant.TYPE_AMOUNT) {
			if (sValue == null || sValue.equals("")) {
				return "0";
			} else {
				sValue = sValue.replace(",", "");
				if (sValue.indexOf("%") != -1) {
					sValue = sValue.replace("%", "");
					double amount = Double.parseDouble(sValue);
					sValue = String.valueOf(amount);
				}
				return sValue;
			}
		}
		return " ";
	}

	/**
	 * 将用string表示的以分为单位的金额字符串转换成以元为单位,保留两位小数的BigDecimal数值. 如：以分为单位的String a =
	 * 2000，转换成 BigDecimal 为20.00
	 */
	public final static BigDecimal formatFenToBigDecimal(String a) {
		BigDecimal bigDec = new BigDecimal(a);
		bigDec = bigDec.movePointLeft(2);
		return bigDec.setScale(2);
	}

	/**
	 * 将用BigDecimal表示的金额转换成以分为单位的String. 如：BigDecimal 为20.00，转换成 以分为单位的String a =
	 * 2000.
	 */
	public final static String formatBigDecimalToFen(BigDecimal bigDec) {
		if (bigDec.compareTo(new BigDecimal(0)) == 0) {
			return "00";
		} else {
			bigDec = bigDec.movePointRight(2);
			String str = bigDec.toString();
			return str;
		}
	}

	/**
	 * 将用BigDecimal 表示的利率转换成以(7,6)形式表示的利率. 符合ECDS利率类型
	 */
	public final static String formatLoalRate2ReqRate(BigDecimal bigDec) throws CommonException {
		if (bigDec == null)
			return null;
		DecimalFormat formatter = new DecimalFormat("0.000000");
		return formatter.format(bigDec);
	}

	/**
	 * 将用BigDecimal 表示的金额转换成以(18,2)形式表示的金额. 符合ECDS金额类型
	 */
	public final static String formatLoaclAmt2ReqAmt(BigDecimal bigDec) throws CommonException {
		if (bigDec == null)
			return null;
		DecimalFormat formatter = new DecimalFormat("###############0.##");
		return formatter.format(bigDec);
	}

	// BMS-2472 南京银行版本合并 jiang@2010-02-09 begin
	/**
	 * 将用BigDecimal 表示的金额转换成以(18,2)形式表示的金额. 符合ECDS金额类型
	 */
	public final static String formatAmt2ReqAmt(BigDecimal bigDec) throws CommonException {
		if (bigDec == null)
			return null;
		DecimalFormat formatter = new DecimalFormat("###,###,###,###,###,###,##0.00");
		return formatter.format(bigDec);
	}

	// BMS-2472 南京银行版本合并 jiang@2010-02-09 end

	/**
	 * @Title: 将用BigDecimal 表示的金额*100后转换成以(18,2)形式表示的金额. 符合SWT格式
	 * @Description: TODO
	 * @param
	 * @param bigDec
	 * @param
	 * @return
	 * @return String
	 * @author shen_antonio
	 * @date 2010-5-10 上午10:32:55
	 * @throws
	 */
	public final static String formatLoaclAmt2ReqAmt100(BigDecimal bigDec) throws CommonException {
		return formatLoaclAmt2ReqAmt(bigDec.multiply(new BigDecimal(100)));
	}

	/**
	 * 将用BigDecimal 表示的金额/100后转换成以(18,2)形式获取SWT的金额.
	 *
	 * @param bigDec
	 * @return
	 * @throws CommonException
	 */
	public final static BigDecimal formatReqAmt2LoaclAmt100(BigDecimal bigDec) throws CommonException {
		return bigDec.divide(new BigDecimal(100));
	}

	/*
	 * 生成功能树数组.
	 */
	public static List<String> getFunctionListAdmin(List<FunctionInfo> lst) throws CommonException {

		Iterator it = lst.iterator();
		List<String> result = new ArrayList<String>();
		while (it.hasNext()) {
			FunctionInfo f = (FunctionInfo) it.next();
			StringBuffer sb = new StringBuffer();
			// sb.append("\"");
			sb.append(f.getId());
			sb.append("|");
			sb.append(f.getLastdirectory());
			sb.append("|");
			if (f.getIsdirectory() == 1)
				sb.append(f.getFuncname());
			else {
				String fullpath = getFullPathAdmin(f.getId());
				sb.append("<input type='checkbox' id='id" + f.getId() + "' name='id' height='14pt' value='" + fullpath + "'>" + f.getFuncname() + "</input>");
			}
			// sb.append("\"");
			result.add(sb.toString());
		}
		return result;
	}

	public static String getFullPathAdmin(String fid) throws CommonException {
		Map ht = CommonFunctions.transToHashtableByFunc(getAllFunctions(0));
		FunctionInfo f = (FunctionInfo) ht.get(fid);
		if (f.getLastdirectory().equals("0"))
			return f.getId().toString();
		else
			return getFullPathAdmin(f.getLastdirectory()) + "," + f.getId().toString();
	}

	public static List getAllFunctions(int uid) throws CommonException {
		FunctionInfoDAO fdao = BaseDAOUtils.getFunctionInfoDAO();
		return fdao.findAll();
	}

	/***************************************************************************
	 * 校验考核期数格式 是否正确
	 *
	 * @param termType
	 *            期数类型: GRADE_TERM_TYPE_MONTH="1"; //1-月
	 *            GRADE_TERM_TYPE_SEASON="2"; //2-季 GRADE_TERM_TYPE_HALF="3";
	 *            //3-半年 GRADE_TERM_TYPE_YEAR="4"; //4-年
	 * @param term
	 *            期数值
	 * @throws CommonException
	 * @date 2010-11-22
	 * @author lizh
	 */

	public void checkTermIsCorrect(String termType, String term) throws CommonException {
		String currentDate = DateUtil.dateToString(DateUtil.getCurrentDate());
		String currentYear = currentDate.substring(0, 4);
		String currentMonth = currentDate.substring(5, 7);

		String currentYearAndMonth = currentYear + currentMonth;// 当前年月

		if (SystemConstant.GRADE_TERM_TYPE_MONTH.equals(termType)) {// 期数类型 为月
			if (term.length() != 6) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "月报必须是6位");
			}
			String rpyMonth = term.substring(4, 6);
			if (Integer.valueOf(rpyMonth).intValue() > 12 || Integer.valueOf(rpyMonth).intValue() < 1) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数中月份必须是01-12的数字");
			}
			if (Integer.valueOf(term).intValue() >= Integer.valueOf(currentYearAndMonth).intValue()) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数必须在本月之前");

			}

		} else if (SystemConstant.GRADE_TERM_TYPE_SEASON.equals(termType)) {// 期数类型
			// 为季

			if (term.length() != 6) {

				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为季的月份必须是6位");
			}
			String rpyMonth = term.substring(4, 6);
			if (Integer.valueOf(rpyMonth).intValue() > 12 || Integer.valueOf(rpyMonth).intValue() < 1) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为季的月份必须是01-12的数字");
			}
			if ((Integer.valueOf(rpyMonth).intValue()) % 3 != 0) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为季的月份必须是3,6,9,12月");
			}
			if (Integer.valueOf(term).intValue() >= Integer.valueOf(currentYearAndMonth).intValue()) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为季考核期必须在本季之前");

			}
		} else if (SystemConstant.GRADE_TERM_TYPE_HALF.equals(termType)) { // 期数类型
			// 为半年
			if (term.length() != 6) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为半年对应的期数值必须是6位");
			}
			String rpyMonth = term.substring(4, 6);
			if (Integer.valueOf(rpyMonth).intValue() > 12 || Integer.valueOf(rpyMonth).intValue() < 1) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为半年对应的期数值中月份必须是01-12的数字");
			}
			if (!rpyMonth.equals("06") && !rpyMonth.equals("12")) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为半年对应的期数值中月份必须是六月份或者十二月份");
			}
			String rptYear = term.substring(0, 4);
			if (Integer.valueOf(rptYear).intValue() > Integer.valueOf(currentYear).intValue()) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为半年对应的期数值次必须在半年之前");

			} else if (Integer.valueOf(rptYear).intValue() == Integer.valueOf(currentYear).intValue()) {
				if ((Integer.valueOf(rpyMonth).intValue() - 1) / 6 >= (Integer.valueOf(currentMonth).intValue() - 1) / 6) {
					throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为半年对应的期数值必须在半年之前");
				}
			}
		} else if (SystemConstant.GRADE_TERM_TYPE_YEAR.equals(termType)) { // 期数类型
			// 为年
			if (term.length() != 4) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为年对应的期数值必须是4位");
			}
			String rptYear = term.substring(0, 4);
			if (Integer.valueOf(rptYear).intValue() >= Integer.valueOf(currentYear).intValue()) {
				throw new CommonException(ErrorCode.ERROR_CODE_CANNOT_SUBMIT, "期数类型为年对应的期数值次必须在本年之前");

			}
		} else {
			// 预留
		}
	}

	/**
	 * 创建文件夹
	 *
	 * @param path
	 */
	public static void mkDir(String path) {
		File dirFile = new File(path);
		if (!dirFile.isDirectory() || !dirFile.exists())
			try {
				FileUtils.forceMkdir(dirFile);
			} catch (IOException ioex) {
				throw new RuntimeException((new StringBuilder("create unmatch info diractory : [")).append(path).append("] error").toString(), ioex);
			}
	}

	public static List<MenuFunction> getMenuFunctionList(Map funcMap) {
		List<MenuFunction> list = new ArrayList<MenuFunction>();
		Iterator it = funcMap.values().iterator();
		while (it.hasNext()) {
			FunctionInfo fi = (FunctionInfo) it.next();
			if (fi.getLastdirectory() == null || fi.getLastdirectory().equals("0")) {// 一级菜单
//				System.out.println(fi.getFuncname());
				MenuFunction mf = new MenuFunction();
				mf.setMenuLevel(1);
				mf.setFunction(fi);
				// 获取下级菜单
				getSubMenuFunctionList(funcMap, mf);
				list.add(mf);
			}
		}
		return list;
	}

	private static void getSubMenuFunctionList(Map funcMap, MenuFunction mf) {
		Iterator it = funcMap.values().iterator();
		while (it.hasNext()) {
			FunctionInfo subfun = (FunctionInfo) it.next();
			//TODO modi by peng.ning 主管确认调整
			if (!mf.getFunction().getId().trim().equals(ReportConstant.APPROVE_FUNC_ID) && mf.getFunction().getId().trim().equals(subfun.getLastdirectory().toString())) {
				MenuFunction subMf = new MenuFunction();
				subMf.setMenuLevel(mf.getMenuLevel() + 1);
				subMf.setFunction(subfun);
				mf.getSubMenuList().add(subMf);
				getSubMenuFunctionList(funcMap, subMf);
			}
		}
	}

	public static String createMenu(HttpSession session) throws CommonException {
		GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
	    GlobalInfo.setCurrentInstance(globalInfo);

	   String reqtype = globalInfo.getMenuCode();
	    //String reqtype= "0101";
	    List funcList = new ArrayList();
	    UserMgrService.getInstance().getUserFunctionsByMenuType(globalInfo.getTlrno(),reqtype,funcList);
	    StringBuffer menuBar = new StringBuffer();
	    for (int i=0;i<funcList.size();i++) {
	    	FunctionInfo fi = (FunctionInfo)funcList.get(i);
	        if (fi.getLastdirectory().equals(reqtype)) {//一级菜单
	            menuBar.append("<a id='mb" + fi.getId() + "' href='javascript:void(0)' menu='#mm" + fi.getId()
	                    + "' class='easyui-menubutton' iconCls='" + fi.getIconCls() + "' duration='0'>" + fi.getFuncname() + "</a>");
	            if (fi.getIsdirectory() == 1) {//目录菜单
	                try{
	                    menuBar.append(getSubDiv(fi,reqtype));
	                } catch(Exception e) {
	                    e.printStackTrace();
	                }
	            } else {
	                //ignore
	            }
	        } else {
	            //ignore
	        }
	    }
	    return menuBar.toString();
	}

	private static StringBuffer getSubDiv(FunctionInfo fi,String reqtype) throws CommonException {
    	int width = 150;
        StringBuffer menuDiv = new StringBuffer();
        if (fi.getLastdirectory().equals(reqtype)) {
            menuDiv.append("<div id='mm" + fi.getId() + "' MENU_ITEM style='width:"+width+"px;' iconCls='" + fi.getIconCls() + "'>");
            List<FunctionInfo> list = DAOUtils.getHQLDAO().queryByQL2List("from FunctionInfo po where po.lastdirectory=" + fi.getId()+" order by po.showseq");
            for (FunctionInfo fi2 : list) {
                menuDiv.append(getSubDiv(fi2,reqtype));
            }
            menuDiv.append("</div>");
            return menuDiv;
        }
        String clickEvent = "";
        if(fi.getPagepath() != null) {
            clickEvent = "onclick=\"doWork('"+ fi.getId() +"','" + fi.getFuncname() + "','" + fi.getPagepath() + "');\"";
        }
        menuDiv.append("<div iconCls='" + fi.getIconCls() + "' title='" + fi.getFuncname() + "' " + clickEvent + ">");
        List<FunctionInfo> list = DAOUtils.getHQLDAO().queryByQL2List("from FunctionInfo po where po.lastdirectory=" + fi.getId()+" order by po.showseq");
        if (fi.getIsdirectory() == 1 && !list.isEmpty()) {
            StringBuffer subDiv = new StringBuffer();
            for (FunctionInfo fi2 : list) {
                subDiv.append(getSubDiv(fi2,reqtype));
            }
            if (subDiv.length() == 0 || ReportConstant.APPROVE_FUNC_ID.equals(fi.getId())) {//过滤数据项权限
                menuDiv.append(fi.getFuncname());
            } else {
                menuDiv.append("<span>" + fi.getFuncname() + "</span>");
                menuDiv.append("<div style='width:"+width+"px;'>");
                menuDiv.append(subDiv);
                menuDiv.append("</div>");
            }
        } else {
            menuDiv.append(fi.getFuncname());
        }
        menuDiv.append("</div>");
        return menuDiv;
    }

}
