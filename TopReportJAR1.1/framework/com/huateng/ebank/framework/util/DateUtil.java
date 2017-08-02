/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.ebank.framework.util;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import resource.bean.pub.Globalinfo;
import resource.dao.pub.GlobalinfoDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * @author valley
 * @date Nov 29, 2004
 * @description
 */
public class DateUtil {

    public static Date defaultDate = null;

    public static Date date19700101 = null;

    private static Log log = LogFactory.getLog(DateUtil.class);

    static {
        try {
            defaultDate = DataFormat.numberToDate("19000101");
            date19700101 = DataFormat.numberToDate("19700101");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SimpleDateFormat formatter;

    public DateUtil() {
        super();
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static java.sql.Date getCurrentDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Time getCurrentTime() {
        return new Time(System.currentTimeMillis());
    }
    /**
	 * 得到上月最后一天的日期
	 * 
	 * @param today
	 * @return
	 */
	public static Date getLastDateL(Date today) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.set(Calendar.DATE, 1);// 设为当前月的1号
		cal.add(Calendar.DATE, -1);// 获取上月最后一天
		return cal.getTime();
	}
    /**
	 * 根据计一段时间内的周日有哪些
	 * 
	 */
	public static List getEndWeekDate(Date startDate, Date endDate,
			SimpleDateFormat sdf) {

		Calendar cal = Calendar.getInstance();
		int days = getDaysBetween(startDate, endDate);
		List list = new ArrayList<String>();
		for (int i = 1; i < days; i++) {
			startDate = getNextDay(startDate);
			cal.setTime(startDate);
			// 判定要计算的日期是否是周日，假如是则减一天计算周六的，否则会出题目，计算到下一周往了
			int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
			if (1 == dayWeek) {
				cal.add(Calendar.DAY_OF_MONTH, -1);
			}
			cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
			int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
			cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减往星期几与一个星期第一天的差值
			String imptimeBegin = sdf.format(cal.getTime());
			cal.add(Calendar.DATE, 6);
			String imptimeEnd = sdf.format(cal.getTime());
			list.add(imptimeEnd);
		}
		// 去掉重复
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();

			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);

		return newList;
	}

	/**
	 * 根据计一段时间内每个月末日期
	 * 
	 */
	public static List getEndMonthDate(Date startDate, Date endDate,
			SimpleDateFormat sdf) {

		Calendar cal = Calendar.getInstance();
		int months = getMonthsBetween(startDate, endDate);
		List list = new ArrayList<String>();
		
		for (int i = 0; i < months; i++) {
			startDate=getLastDate(startDate);			
			cal.setTime(startDate);		
			String imptimeEnd = sdf.format(startDate);
			list.add(imptimeEnd);
			startDate = getNextDay(startDate);
		}
		/*// 去掉重复
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();

			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);*/

		return list;
	}
    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getWorkDate(){
    	GlobalinfoDAO dao = BaseDAOUtils.getGlobalinfoDAO();
    	Globalinfo gi = dao.findById(SystemConstant.TABLE_GLOBAL_INFO_ID);
    	String wd = dateToNumber(gi.getTbsdy());
    	return wd;
    }
    //根据当前的工作日,获取这个月1号到今天的日期列表
    public static List getSomeDays(Date endDate, SimpleDateFormat sdf) {
    	Date startDate=getFirstDate(endDate);
    	Calendar cal = Calendar.getInstance();
    	int days = getDaysBetween(startDate, endDate);
    	List list = new ArrayList<String>();
    	for (int i = 0; i <= days; i++) {
    	cal.setTime(startDate);
    	String imptimeEnd = sdf.format(startDate);
    	startDate = getNextDay(startDate);
    	list.add(imptimeEnd);
    	}
    	return list;
    	}

    /**
     * 得到当前会计日期
     *
     * @return
     */
    public static Date getTbsDay() throws CommonException {
//    	SimpleDateFormat sdp =new SimpleDateFormat("yyyyMMdd");
    	GlobalinfoDAO dao = BaseDAOUtils.getGlobalinfoDAO();
    	Globalinfo gi = dao.findById(SystemConstant.TABLE_GLOBAL_INFO_ID);
//        try {
			return gi.getTbsdy();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			ExceptionUtil.throwCommonException(e.getMessage());
//		}
//		return null;
    }
	/**
	 * 得到下个一会计日
	 * 
	 * @param 当前日期
	 * @return
	 */
	public static Date getNextDay(Date nowDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
    /**
     * 得到上一个工作日
     *
     * @return
     */
    public static Date getBhDate() throws CommonException {
    	GlobalinfoDAO dao = BaseDAOUtils.getGlobalinfoDAO();
    	Globalinfo gi = dao.findById(SystemConstant.TABLE_GLOBAL_INFO_ID);
		return gi.getBhdate();
    }

    /**
     * 返回yyyy-MM-dd格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                SystemConstant.DATE_PATTERN);
        return simpleDateFormat.format(date);
    }

    /**
	 * 由日期返回yyyyMMdd格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateToNumber(Date date) {
		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat =
			new SimpleDateFormat(SystemConstant.DATE_PATTERN_2);
		return simpleDateFormat.format(date);
	}


    /**
     * 返回yyyy-MM-dd hh : mm : ss 格式的字符串
     *
     * @param date
     * @return
     */
    public static String Time14ToString(java.sql.Timestamp time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME14_PATTERN);
        return simpleDateFormat.format(time);
    }
/*  add by haizhou.li 2010-11-19 begin */
    /**
     * 返回yyyy-MM-dd hh : mm : ss 格式的字符串
     *
     * @param date
     * @return
     * @author haizhou.li
     */
    public static String Time14ToString2(java.util.Date time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME14_PATTERN);
        return simpleDateFormat.format(time);
    }
    /*  add by haizhou.li 2010-11-19 begin */
    /*  add by haizhou.li 2010-11-19 begin */
    /**
     * 返回yyyy-MM-dd hh : mm : ss 格式的字符串
     *
     * @param date
     * @return
     * @author haizhou.li
     */
    public static String Time14ToString2(java.sql.Timestamp time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME14_PATTERN2);
        return simpleDateFormat.format(time);
    }
    /*  add by haizhou.li 2010-11-19 begin */

    /**
     * 返回 hh : mm : ss 格式的字符串
     *
     * @param date
     * @return
     */
    public static String Time6ToString(java.sql.Timestamp time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME6_PATTERN);
        return simpleDateFormat.format(time);
    }

    /**
     * 由yyyy-MM-dd格式的字符串返回日期
     *
     * @param date
     * @return
     */
    public static Date stringToDate(String string) throws CommonException {
        if (string == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                SystemConstant.DATE_PATTERN);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            ExceptionUtil
                    .throwCommonException(ErrorCode.ERROR_CODE_DATE_FORMAT_ERR);
        }
        return null;
    }

    /**
     * 由yyyymmdd格式的字符串返回日期
     *
     * @param date
     * @return
     */
    public static Date stringToDate2(String string) throws CommonException {
        if (DataFormat.isEmpty(string))
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                SystemConstant.DATE_PATTERN_2);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            ExceptionUtil
                    .throwCommonException(ErrorCode.ERROR_CODE_DATE_FORMAT_ERR);
        }
        return null;
    }

    /**
     * 计算两个日期相隔的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDaysBetween(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        if (startDate.after(endDate)) {
            Calendar swap = calendarStartDate;
            calendarStartDate = calendarEndDate;
            calendarEndDate = swap;
        }

        int days = calendarEndDate.get(Calendar.DAY_OF_YEAR)
                - calendarStartDate.get(Calendar.DAY_OF_YEAR);
        int y2 = calendarEndDate.get(Calendar.YEAR);
        while (calendarStartDate.get(Calendar.YEAR) < y2) {
            days += calendarStartDate.getActualMaximum(Calendar.DAY_OF_YEAR);
            calendarStartDate.add(Calendar.YEAR, 1);
        }

        return days;
    }
    /**

	 * 计算两个日期相隔天数，其中满月按30天算，不满月按实际天数

	 * @param

	 * @return 天数

	 */
    public static int getDaysBetween30(Date startDate, Date endDate) {



		Calendar calendarStartDate = Calendar.getInstance();

		Calendar calendarEndDate = Calendar.getInstance();



		// 设日历为相应日期

		calendarStartDate.setTime(startDate);

		calendarEndDate.setTime(endDate);

		if (startDate.after(endDate)) {

			Calendar swap = calendarStartDate;

			calendarStartDate = calendarEndDate;

			calendarEndDate = swap;

		}



		int months =

			calendarEndDate.get(Calendar.MONTH)

				- calendarStartDate.get(Calendar.MONTH)

				+ (calendarEndDate.get(Calendar.YEAR)

					- calendarStartDate.get(Calendar.YEAR))

					* 12;



		Date newEndDate = getEndDateByMonths(startDate, months);



		if (newEndDate.compareTo(endDate) <= 0

			|| isSameDate(newEndDate, endDate) == true)

			months += 1;



		int days =  ( months - 1 )* 30;



		Date newStartDate = getEndDateByMonths(startDate, months - 1);



		days += getDaysBetween(newStartDate, endDate);



		return days;

	}


    /**
     * 计算两个日期相隔年数(不比较月、日)
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getYearsBetween(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        //设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        return calendarEndDate.get(Calendar.YEAR)
                - calendarStartDate.get(Calendar.YEAR);
    }

    /**
     * 计算两个日期相隔的月数(不足整月的算一个月)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getMonthsBetween(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        if (startDate.after(endDate)) {
            Calendar swap = calendarStartDate;
            calendarStartDate = calendarEndDate;
            calendarEndDate = swap;
        }

        int months = calendarEndDate.get(Calendar.MONTH)
                - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate
                        .get(Calendar.YEAR)) * 12;

        if (getEndDateByMonths(startDate, months).compareTo(endDate) < 0)
            months += 1;

        return months;
    }

    /**
     * 计算两个日期相隔的月数(不比较日)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getActualMonths(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        if (startDate.after(endDate)) {
            Calendar swap = calendarStartDate;
            calendarStartDate = calendarEndDate;
            calendarEndDate = swap;
        }

        int months = calendarEndDate.get(Calendar.MONTH)
                - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate
                        .get(Calendar.YEAR)) * 12;


        return months;
    }

    /**
     * 计算两个日期相隔的月数 比较日(不足月的不算1个月)
     */
    public static int getActualMonths2(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        if (startDate.after(endDate)) {
            Calendar swap = calendarStartDate;
            calendarStartDate = calendarEndDate;
            calendarEndDate = swap;
        }

        int months = calendarEndDate.get(Calendar.MONTH)
                - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate
                        .get(Calendar.YEAR)) * 12;

        if (getEndDateByMonths(startDate, months).after(endDate))
            months = months-1;

        return months;
    }

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

    /**
     * 根据起始日和相隔月数计算终止日
     *
     * @param startDate
     * @param months
     * @return
     */
    public static Date getEndDateByMonths(Date startDate, int months) {
        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(startDate);
        calendarStartDate.add(Calendar.MONTH, months);

        return calendarStartDate.getTime();
    }

    /**
     * 根据起始日和期限计算终止日
     * @param startDate
     * @param term YYMMDD格式的贷款期限
     * @return
     */
    public static Date getEndDateByTerm(Date startDate, String term) {
        int years = Integer.parseInt(term.substring(0, 2));
        int months = Integer.parseInt(term.substring(2, 4));
        int days = Integer.parseInt(term.substring(4, 6));
        return getEndDateByDays(getEndDateByMonths(startDate, years * 12
                + months), days);
    }

    /**
     * 根据起始日期和终止日期计算期限
     * @param startDate
     * @param endDate
     * @return YYMMDD格式的贷款期限
     */
    public static String getTermBetween(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        if (startDate.after(endDate)) {
            Calendar swap = calendarStartDate;
            calendarStartDate = calendarEndDate;
            calendarEndDate = swap;
        }

        int months = calendarEndDate.get(Calendar.MONTH)
                - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate
                        .get(Calendar.YEAR)) * 12;
        int days = 0;
        Date tempEndDate = getEndDateByMonths(startDate, months);

        if (tempEndDate.compareTo(endDate) < 0) {
            days = getDaysBetween(tempEndDate, endDate);
        } else if (tempEndDate.compareTo(endDate) > 0) {
            months -= 1;
            tempEndDate = getEndDateByMonths(startDate, months);
            days = getDaysBetween(tempEndDate, endDate);
        }

        int years = months / 12;
        months = months % 12;

        return DataFormat.termToString(years, months, days);
    }

    /**
     * 根据起始日和期限计算终止日
     * @param startDate
     * @param years
     * @param months
     * @param days
     * @return
     */
    public static Date getEndDateByTerm(Date startDate, int years, int months,
            int days) {
        return getEndDateByDays(getEndDateByMonths(startDate, years * 12
                + months), days);
    }

    /**
     * 根据终止日和相隔天数计算起始日
     *
     * @param endDate
     * @param days
     * @return
     */
    public static Date getStartDateByDays(Date endDate, int days) {
        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(endDate);
        calendarEndDate.add(Calendar.DAY_OF_YEAR, 0 - days);

        return calendarEndDate.getTime();
    }

    /**
     * 根据终止日和相隔月数计算起始日
     *
     * @param endDate
     * @param months
     * @return
     */
    public static Date getStartDateByMonths(Date endDate, int months) {
        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(endDate);
        calendarEndDate.add(Calendar.MONTH, 0 - months);

        return calendarEndDate.getTime();
    }

    public static Date getStartDateByYears(Date endDate, int years) {
        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(endDate);
        calendarEndDate.add(Calendar.YEAR, 0 - years);

        return calendarEndDate.getTime();
    }
    /**
     * 判断两个日期是否对日
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isSameDate(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        if (startDate.after(endDate)) {
            Calendar swap = calendarStartDate;
            calendarStartDate = calendarEndDate;
            calendarEndDate = swap;
        }

        if (calendarStartDate.get(Calendar.DATE) == calendarEndDate
                .get(Calendar.DATE))
            return true;

        if (calendarStartDate.get(Calendar.DATE) > calendarEndDate
                .get(Calendar.DATE)) {
            if (calendarEndDate.get(Calendar.DATE) == calendarEndDate
                    .getActualMaximum(Calendar.DATE))
                return true;
        }

        return false;
    }

    /**
     * 判断日期是否与指定的日期对日
     *
     * @param date
     * @param dd
     * @return
     */
    public static boolean isSameDate(Date date, String dd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = Integer.parseInt(dd);

        if (calendar.get(Calendar.DATE) == day)
            return true;

        if (calendar.get(Calendar.DATE) < day) {
            if (calendar.get(Calendar.DATE) == calendar
                    .getActualMaximum(Calendar.DATE))
                return true;
        }

        return false;
    }

    /**
     * 判断两个日期是否同一个月
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isSameMonth(Date startDate, Date endDate) {
        if (startDate == null || endDate == null)
            return false;

        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);

        if (calendarStartDate.get(Calendar.YEAR) == calendarEndDate
                .get(Calendar.YEAR)
                && calendarStartDate.get(Calendar.MONTH) == calendarEndDate
                        .get(Calendar.MONTH))
            return true;

        return false;
    }

    /**
     * 得到本月第一天的日期
     *
     * @param today
     * @return
     */
    public static Date getFirstDate(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, 1);

        return calendar.getTime();
    }

    /**
     * 得到本月最后一天的日期
     *
     * @param today
     * @return
     */
    public static Date getLastDate(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        return calendar.getTime();
    }
    
    /**
     * 得到下个月最后一天的日期
     *
     * @param today
     * @return
     */
    public static Date getNextLastDate(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getNextDay(getLastDate(today)));
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        return calendar.getTime();
    }
    
    

    /**
     * 缺省的日期. 为1900年1月1号0点0分0秒.
     *
     * @return
     */
    public static Date getDefaultDate() {
        return defaultDate;
    }

    /**
     * double 转换为 bigdecimal
     * @param input
     * @return
     */
    public static BigDecimal convertDouble2BigDecimal(double input){
    	return new BigDecimal(Double.toString(input));
    }

    public static String iSODateTimeTo8Date(String iSODateTime){
    	if (DataFormat.trim(iSODateTime).length()>=10){
    		return iSODateTime.substring(0, 4)+iSODateTime.substring(5, 7)+iSODateTime.substring(8,10);
    	}else
    		return iSODateTime;
    }
    public static String formatDate8(String date) {
		if (date.length() == 8) {
			return date;
		}
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		String day = date.substring(8);

		StringBuffer rtnDate = new StringBuffer(year).append(month).append(day);
		return rtnDate.toString().trim();
	}
  //add by shouhao 20091125 BMS-2244 begin
	/**
	 * 获取当前日期
	 */
	public static String getCurrentDate(String formatString) {
		SimpleDateFormat   sDateFormat   =   new   SimpleDateFormat(formatString);
		String   date   =   sDateFormat.format(new   java.util.Date());
		return date;
	}
	//add by shouhao 20091125 BMS-2244 end


	//add by shouhao 20091125 BMS-2336 begin
	/**
	 *@param dateString 该字符串须是date类型的字符串 例如：20091221等
	 */
	public static String convertStringToTimeString(String dateString ) {
		Date date1 = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			date1 = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String day = format1.format(date1);
		return day;


	}
	/**
	 * @param dateString 该字符串须是date类型的字符串 例如：20091221等
	 * @param adateStrteStr
	 * @return
	 */
	public static String convertString2TimeString(String adateStrteStr ) {
		Date date1 = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
		try {
			date1 = simpleDateFormat.parse(adateStrteStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

		String day = format1.format(date1);
		return day;


	}
	//add by shouhao 20091125 BMS-2336 end


	/**
	 * 取得TXN操作日期
	 * @return TXN操作日期
	 */
	public static String getTXNDate()
	{
		//TODO:取得操作日期
		return get8Date();
	}
	/**
	 * 取得YYYYmmdd形式表示的8位当前日期
	 * @return
	 */
	public static String get8Date()
	{
		Calendar calendar = Calendar.getInstance();
		return String.format("%1$4tY%1$2tm%1$td", calendar);
	}
	/**
	 * 取得YYYYmmddHHMMSS形式表示的14位当前日期
	 * @return
	 */
	public static String get14Date()
	{
		Calendar calendar = Calendar.getInstance();
		return String.format("%1$4tY%1$2tm%1$td%1$2TH%1$2TM%1$2TS", calendar);
	}
	/**
	 * 取得YYYYmmdd形式表示的8位日期
	 * @param date 日期
	 * @return YYYYmmdd形式表示的日期
	 */
	public static String get8Date(Calendar date)
	{
		return String.format("%1$4tY%1$2tm%1$td", date);
	}
	/**
	 * 取得YYYYmmddHHMMSS形式表示的14位当前日期
	 * @param date 日期
	 * @return YYYYmmddHHMMSS形式表示的日期
	 */
	public static String get14Date(Calendar date)
	{
		return String.format("%1$4tY%1$2tm%1$td%1$2TH%1$2TM%1$2TS", date);
	}

	/**
	 * 取得日期转换成的Calendar对象
	 * @param date 8位或14位的日期
	 * @return Calendar对象
	 * @throws CommonException 当转换出错时产生错误
	 */
	public static Calendar getCalFromDate(String date) throws CommonException
	{
		Calendar calendar = Calendar.getInstance();
		int year = 0;
		int month = 0;
		int date_of_month = 0;
		int hourOfDay = 0;
		int minute = 0;
		int second = 0;
		try {
			if(date.length()>=8)
			{
				year = Integer.valueOf(date.substring(0,4));
				month = Integer.valueOf(date.substring(4,6))-1;
				date_of_month = Integer.valueOf(date.substring(6,8));
			}
			if(date.length()>=14)
			{
				hourOfDay = Integer.valueOf(date.substring(8,10));
				minute = Integer.valueOf(date.substring(10,12));
				second = Integer.valueOf(date.substring(12,14));
			}
		}
		catch (NumberFormatException e) {
			ExceptionUtil.throwCommonException(e.getLocalizedMessage(),
                    ErrorCode.ERROR_CODE_NORMAL,e);
		}
		calendar.set(year, month, date_of_month, hourOfDay, minute, second);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	/**
	 * 通过传入格式为yyyyMMddhhmmss的字符串参数，将其转换成YYYY-mm-dd HH:MM:SS 格式的时间字符串 *
	 * @return
	 * @author lizh
	 */
	public static String get19Date(String dtime)	{
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
		Calendar calendar = Calendar.getInstance();
		try {
			Date dateTime=simpleDateFormat.parse(dtime);
			calendar.setTime(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.format("%1$4tY-%1$2tm-%1$td %1$2TH:%1$2TM:%1$2TS", calendar);
	}
	public static String getTermCh(String term){
		String year = term.substring(0, 2);
		if (year.substring(0, 1).equals("0"))
			year = year.substring(1, 2);
		String month = term.substring(2, 4);
		if (month.substring(0, 1).equals("0"))
			month = month.substring(1, 2);
		String day = term.substring(4, 6);
		if (day.substring(0, 1).equals("0"))
			day = day.substring(1, 2);
		term = year + "年" + month + "月" + day + "天";
		return term;
	}

	public static Date get20Date(String source) throws CommonException{
		if(source==null || source.equals("")){
			ExceptionUtil.throwCommonException(ErrorCode.DATE_IS_NULL);
		}
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try
		{
			date = format.parse(source);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 通过传入yyyyMMdd格式的日期字符串，将其转换成yyyy-MM-dd格式的日期字符串
	 *
	 * @param  source
	 * @return yyyy-MM-dd
	 */
	public static String get21Date(String source){
		if(source==null||source.equals(""))return null;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try
		{
			date = format1.parse(source);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return format2.format(date);
	}


	public static int getWeek(Date startDate){
		Calendar calendarStartDate = Calendar.getInstance();
		calendarStartDate.setTime(startDate);
		int weekday = calendarStartDate.get(Calendar.DAY_OF_WEEK);
		return weekday;
	}

	/**
	 * 通过传入long格式的时间间隔(ms)，将其转换成 hh : mm : ss 格式的字符串
	 * @param procTime
	 * @return
	 */
	public static String getProcTime(long procTime){
		String flg = "";
		if(procTime<0){
			flg = "-";
			procTime *= -1;
		}
		procTime = procTime/1000; //得到秒级别的
		long hh = procTime/3600;
		long mm = (procTime-hh*3600)/60;
		long ss = procTime-mm*60-hh*3600;
		return flg + hh+":"+mm+":"+ss;
	}

	/**
	 * 由日期返回yyyyMMddHHmmss格式的字符串
	 * @param time
	 * @return
	 */
	public static String timeToNumber(Date time) {
		if (time == null)
			return null;

		SimpleDateFormat simpleDateFormat =
			new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(time);
	}

	public static String convterDateFmt(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date dt = sdf.parse(date);
			return new SimpleDateFormat("yyMMdd").format(dt);
		} catch (ParseException e) {
			return date;
		}
	}


}