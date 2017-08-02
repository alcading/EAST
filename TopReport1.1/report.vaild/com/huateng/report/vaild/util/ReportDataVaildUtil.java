package com.huateng.report.vaild.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.oro.text.perl.Perl5Util;

import resource.bean.report.SubFileConf;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportDataVaildUtil {

	public static boolean regVaild(String regEx,String val){
		boolean bl = false;
		if (val!=null) {
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(val.toString());
			bl = matcher.matches();
		}
		return bl;
	}

	/**
	 * 执行验证
	 * @param busiType
	 * @param appType
	 * @param fileType
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static void executeVaild(String appType, String fileType, Object obj) throws CommonException{
		String result = null;
		SubFileConf conf =ReportUtils.getSubFileConfByBopPk(appType, fileType);
		try {
			if (conf!=null && conf.getDataValidPath()!=null && conf.getDataValidPath().trim().length()>0) {
				AbsReportDataVaild vaild = (AbsReportDataVaild) Class.forName(conf.getDataValidPath().trim()).newInstance();
				result = vaild.executeDataVaild(obj);
			}
		} catch (Exception e) {
			throw new CommonException(e.getMessage());
		}
		if(result!=null && result.trim().length()>0){
			ExceptionUtil.throwCommonException(result,appType+"_"+fileType+"_ERR");
		}
	}

	public static void main(String[] args) {
		String regEx = "[+-]?([0-9]{1}[\\d]{0,19}|[0-9]{1}[\\d]{0,19}[\\.][\\d]{1,2}|0)$";
		Perl5Util pl = new Perl5Util();
		//boolean bl = pl.match(regEx, "20.1");

		System.out.println(regVaild(regEx, "20.1"));

		//System.out.println(bl);
	}
}
