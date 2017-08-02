package com.huateng.ebank.business.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;

import resource.bean.pub.Bctl;
import resource.bean.pub.DataDic;
import resource.bean.pub.TlrInfo;
import resource.bean.report.BiAreaOfChina;
import resource.bean.report.BiDayexchangerate;
import resource.bean.report.BiMonthexchangerate;
import resource.bean.report.BiNationregion;
import resource.bean.report.MtsInOutCode;
import resource.bean.report.SubFileInfo;
import resource.bean.report.SysCurrency;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.commquery.config.bean.base.ICommonQueryBaseBean;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.entity.dao.mng.BizFuncInfoDAO;
import com.huateng.ebank.entity.data.mng.BizFuncInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.HuatengException;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.service.pub.RoleMgrService;

public class CQMethod {

	/**
	 * get data_dic_name by translated
	 *
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getDataDicName(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {
		String translated = element.getAnyValue("translated");
		if (StringUtils.isEmpty(value) || StringUtils.isEmpty(translated)
				|| !translated.startsWith("DATA_DIC.")) {
			return value;
		}
		String dicType = translated.substring(translated.indexOf(".") + 1);
		String dicName = DataDicUtils.getDicName(dicType, value);
		return dicName;
	}

	/**
	 * @author Hanziyang
	 * @desc getRoleName
	 * @date 20100421
	 * @return String roleName
	 * @throws HuatengException
	 */
	public static String getRoleName(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		RoleMgrService roleMgrService = RoleMgrService.getInstance();

		if (StringUtils.isEmpty(value)) {
			return "";
		}
		String rolename = null;
		try {
			rolename = roleMgrService.getRoleById(Integer.parseInt(value)).getRoleName();
		} catch (Exception e) {

		}
		if (StringUtils.isEmpty(rolename)) {
			return value;
		}
		return rolename;
	}

	/**
	*
	* get getUbankName by no
	*
	* @param element
	* @param value
	* @param request
	* @return
	* @throws HuatengException
	*/
	public static String getUbankNamebyNo(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		if (StringUtils.isEmpty(value)) {
			return "";
		}
		String ubankName = null;
		try {
//			ubankName = DAOUtils.getTblEbUnionBankDAO().getUnionBankByNo(value).getUbankName();
		} catch (Exception e) {
		}
		if (StringUtils.isEmpty(ubankName)) {
			return value;
		}
		return ubankName;
	}

	/**
	 * 获取日牌价折合人民币
	 * currency ：需要转换的金额
	 * currenyType：金额的对应币种
	 * workDate ： 对应的工作日期 如20121017
	 */

	public static BigDecimal getDayCNY(BigDecimal currency,String currenyType,String workDate) throws CommonException
	{
		if("CNY".equalsIgnoreCase(currenyType))
		{
			return currency;
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<BiDayexchangerate> dayList = new ArrayList<BiDayexchangerate>();
		BiDayexchangerate biDay =null;
		BigDecimal toExCNY = new BigDecimal(0).setScale(2);
		StringBuffer hql = new StringBuffer("");
		hql.append(" from BiDayexchangerate biday where id='"+currenyType+"' and rateDate='"+workDate+"'");
		dayList = rootdao.queryByQL2List(hql.toString());

		if(null ==dayList || dayList.size()==0)
		{
			ExceptionUtil.throwCommonException("外汇日牌价不存在相应的记录！");
		}

		for(Object dayObj : dayList)
		{
			biDay = (BiDayexchangerate)dayObj;
			if(null ==biDay)
			{
				ExceptionUtil.throwCommonException("外汇日牌价不存在相应的记录！");
			}
			if(null !=biDay && "4".equalsIgnoreCase(biDay.getSt()))
			{
				toExCNY = currency.divide(biDay.getRateUnit()).multiply(biDay.getRateMidprice());
			}else if(null !=biDay && !"4".equalsIgnoreCase(biDay.getSt()))
			{
				ExceptionUtil.throwCommonException("请检查 外汇日牌价的[主管确认]是否已经完成！");
			}
		}
		return toExCNY;
	}


	/**
	 * 获取月牌价折合人民币
	 * currency ：需要转换的金额
	 * currenyType：金额的对应币种
	 * yearMoth ： 对应的年月 如201210
	 */

	public static BigDecimal getMothCNY(BigDecimal currency,String currenyType,String yearMoth) throws CommonException
	{
		if("CNY".equalsIgnoreCase(currenyType))
		{
			return currency;
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<BiMonthexchangerate> dayList = new ArrayList<BiMonthexchangerate>();
		BiMonthexchangerate biMoth =null;
		BigDecimal toExCNY = new BigDecimal(0).setScale(2);
		StringBuffer hql = new StringBuffer("");
		hql.append(" from BiMonthexchangerate bimoth where id='"+currenyType+"' and yearMonth='"+yearMoth+"'");
		dayList = rootdao.queryByQL2List(hql.toString());

		if(null ==dayList || dayList.size()==0)
		{
			ExceptionUtil.throwCommonException("外汇月牌价不存在相应的记录！");
		}

		for(Object dayObj : dayList)
		{
			biMoth = (BiMonthexchangerate)dayObj;
			if(null ==biMoth)
			{
				ExceptionUtil.throwCommonException("外汇月牌价不存在相应的记录！");
			}
			if(null !=biMoth && "4".equalsIgnoreCase(biMoth.getSt()))
			{
				toExCNY = currency.divide(biMoth.getRateUnit()).multiply(biMoth.getRateMidprice());
			}else if(null !=biMoth && !"4".equalsIgnoreCase(biMoth.getSt()))
			{
				ExceptionUtil.throwCommonException("请检查 外汇月牌价的[主管确认]是否已经完成！");
			}
		}
		return toExCNY;
	}

	/**
	*
	* get getUbankName by no
	*
	* @param element
	* @param value
	* @param request
	* @return
	* @throws HuatengException
	*/
	public static String getRMBCapitalMoney(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		if (StringUtils.isEmpty(value)) {
			return "";
		}
		return DataFormat.getRMBCapitalMoney(Double.parseDouble(value));
	}

	/** add by junyun.lin 2010-05-20 HTEBANK-10 begin */
	/**
	*
	* 将用string表示的以分为单位的金额字符串转换成以元为单位
	* 如：以分为单位的String a = 2000，转换成 BigDecimal 20.00
	*
	* @param element
	* @param value
	* @param request
	* @return
	* @throws HuatengException
	*/
	public final static String formatFenToBigDecimal(ICommonQueryBaseBean element,
			String value, ServletRequest request)throws HuatengException{
		if(value==null||"".equals(value)){
			return "";
		}
		BigDecimal bigDec = new BigDecimal(value);
		bigDec = bigDec.movePointLeft(2);
		return String.valueOf(bigDec.setScale(2));
	}

   /**
	*
	* get getUbankName by no
	*
	* @param element
	* @param value
	* @param request
	* @return
	* @throws HuatengException
	*/
	public static String getRMBCapitalformatFenMoney(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		if (StringUtils.isEmpty(value)) {
			return "";
		}
		BigDecimal bigDec = new BigDecimal(value);
		bigDec = bigDec.movePointLeft(2);
		value = String.valueOf(bigDec.setScale(2));
		return DataFormat.getRMBCapitalMoney(Double.parseDouble(value));
	}
	/** add by junyun.lin 2010-05-20 HTEBANK-10 end */

	/**
	*
	* 将用string表示的以分为单位的金额字符串转换成以元为单位,带分隔符的
	* 如：以分为单位的String a = 123456，转换成 String 1,234.56
	*
	* @param element
	* @param value
	* @param request
	* @return
	* @throws HuatengException
	*/
	public final static String formatFenToCurrency(ICommonQueryBaseBean element,
			String value, ServletRequest request)throws HuatengException{
		if(value==null||"".equals(value)){
			return "";
		}
		BigDecimal bigDec = new BigDecimal(value);
		bigDec = bigDec.movePointLeft(2);
		bigDec.setScale(2);
		return DataFormat.doubleToCurrencyRA(bigDec.doubleValue());
	}

	/**
	 * 根据应用类型取得文件类型 	返回格式: 文件类型名称
	 *
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */

	public static String getCurrentFile(ICommonQueryBaseBean element,String value, ServletRequest request) throws CommonException{
		String currentFileName = "";
		if (value!=null && value.trim().length()>0) {
			ReportCommonService service = ReportCommonService.getInstance();
			String typeFile[] = value.split("_");
			String appType = typeFile[0];
			String currentFileType =  typeFile[1];
			DataDic dic = service.getDataDic(ReportConstant.DATA_DIC_BUSI_TYPE_NO, TopReportConstants.REPORT_BUSITYPE_BOP);
			if (dic!=null && dic.getMiscflgs()!=null && dic.getMiscflgs().trim().length()>0) {
				String dataTypeNo = dic.getMiscflgs().trim();
				DataDic appDic = service.getDataDic(Integer.parseInt(dataTypeNo), appType.trim());
				if (appDic!=null && appDic.getMiscflgs()!=null && appDic.getMiscflgs().trim().length()>0) {
					DataDic fileDic = service.getDataDic(Integer.parseInt(appDic.getMiscflgs().trim()), currentFileType.trim());
					if (fileDic!=null) {
						currentFileName = fileDic.getDataName();
					}
				}
			}
		}
		return currentFileName;
	}


	/**
	 *
	 * get getBrhName by id
	 *
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getBrhName(ICommonQueryBaseBean element, String value,
			ServletRequest request) throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return value;
		}
		BctlService bctlService = BctlService.getInstance();

		if (StringUtils.isEmpty(value)) {
			return "";
		} else {
			String brhName = null;
			try {
				brhName = bctlService.getBctlByBrcode(value).getBrname();
			} catch (Exception e) {

			}
			if (StringUtils.isEmpty(value)) {
				return value;
			}
			if(DataFormat.isEmpty(brhName)){
				brhName = "";
			}
			return brhName;
		}

	}
//del by zhaozhiguo
//	/**
//	 *
//	 * 获取保险公司名称
//	 */
//	public static String getInsurer(ICommonQueryBaseBean element, String value,
//			ServletRequest request) throws HuatengException {
//		if (StringUtils.isEmpty(value)) {
//			return "";
//		} else {
//			try {
//				StringBuffer hql = new StringBuffer();
//				hql.append("select po.cname from CustomerInfo po where po.custType = '")
//						.append(SystemConstant.CUST_TYPE_FINANCIAL);
//				hql.append("'");
//				hql.append(" and (po.cname like '").append(value).append("'");
//				hql.append(" or po.custno like '").append(value).append("')");
//
//				CustomerInfoDAO dao = BaseDAOUtils.getCustomerInfoDAO();
//				CustomerInfo customerInfo = dao.query(value);
//				if(customerInfo != null) {
//					return customerInfo.getCname();
//				} else {
//					return "";
//				}
//
//			} catch (Exception e) {
//				return "";
//			}
//		}
//
//	}

	/**
	 * 根据外部机构号获取机构名称 机构名称格式为: brname
	 *
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getBrnoName(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		/* mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 begin
		BctlService bctlService = BctlService.getInstance();
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		String brname = bctlService.getBranchName(value);
		if (StringUtils.isEmpty(brname)) {
			return value;
		}*/
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		List l = DAOUtils.getBctlDAO().queryByCondition("po.brno = '" + value + "'");
		if (l == null || l.isEmpty()) {
			return "";
		} else {
			Bctl bctl = (Bctl) l.get(0);
			return bctl.getBrname();
		}
		/* mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整  end*/
	}


	/**
	 * 根据区域代码获取对应的中文名称 机构名称格式为: areaname
	 *
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	@SuppressWarnings("rawtypes")
	public static String getAreacodName(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return StringUtils.EMPTY;
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List areacodeList = rootdao.queryByQL2List(" FROM BiAreaOfChina WHERE areacode = '" + value + "' ");
		if (areacodeList == null || areacodeList.isEmpty()) {
			return "";
		} else {
			BiAreaOfChina areacode = (BiAreaOfChina) areacodeList.get(0);
			return areacode.getAreaname();
		}
	}


	/**
	 * 根据外部机构号获取机构名称 机构名称格式为: brno-brname
	 *
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getBrhNameByBrno(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		/* mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 begin
		BctlService bctlService = BctlService.getInstance();
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		String brname = bctlService.getBranchName(value);
		if (StringUtils.isEmpty(brname)) {
			return value;
		}*/
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		List l = DAOUtils.getBctlDAO().queryByCondition("po.brno = '" + value + "'");
		if (l == null || l.isEmpty()) {
			return "";
		} else {
			Bctl bctl = (Bctl) l.get(0);
			return value + "-" + bctl.getBrname();
		}
		/* mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整  end*/
	}




	/**
	 * 根据币种编码获取币种名称 	返回格式: currencyNo-currencyName
	 *
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getCurNameByCurNo(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		if (StringUtils.isEmpty(value)) {
			return value;
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List l = rootdao.queryByQL2List("from SysCurrency cur where  cur.id = '" + value + "'");
		if (l == null || l.isEmpty()) {
			return value;
		} else {
			SysCurrency cur = (SysCurrency) l.get(0);
			return value + "-" + cur.getCurrencyName();
		}
	}

	/**
	 * 根据国家地区代码获取名称 	返回格式: nationregionId-Name
	 *
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getNationregionIdName(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		if (StringUtils.isEmpty(value)) {
			return "";
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List l = rootdao.queryByQL2List("from BiNationregion biNag where  biNag.id = '" + value + "'");
		if (l == null || l.isEmpty()) {
			return "";
		} else {
			BiNationregion biNag = (BiNationregion) l.get(0);
			return value + "-" + biNag.getChinaName();
		}
	}



	public static String getTotalSucRecords(ICommonQueryBaseBean element,
			String value, ServletRequest request) throws HuatengException {

		if (StringUtils.isEmpty(value)) {
			return "";
		}

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List sfiList = rootdao.queryByQL2List("from SubFileInfo sfi where  sfi.id = '" + value + "'");
		if (sfiList == null || sfiList.isEmpty()) {
			return "";
		} else {
			SubFileInfo sfi = (SubFileInfo) sfiList.get(0);
			return ""+(null == sfi.getTotalrecords() ? 0: sfi.getTotalrecords())+"/"+ (null == sfi.getSucrecords() ? 0: sfi.getSucrecords());
		}
	}

	/**
	 * Description: 评分功能：显示评分要素状态
	 * @param
	 * @return String
	 * @exception
	 * @author UU_Wu
	 * @version v1.0,2009-3-11
	 */
	public static String getGradeStateNameByNo(ICommonQueryBaseBean element,String value, ServletRequest request) throws HuatengException {
			if( StringUtils.isEmpty(value) ){
				return "";
			}else{
				String statename = DataDicUtils.getDicName(SystemConstant.DATADIC_TYPE_GRADE_STATE, value);
				return statename;
			}
	}
//del by zhaozhiguo
//	/**
//	 *
//	 * 客户号翻译成客户名称方法
//	 */
//	public static String getCustNameById(ICommonQueryBaseBean element, String value,
//			ServletRequest request) throws HuatengException {
//		if (StringUtils.isEmpty(value)) {
//			return "";
//		} else {
//			try {
//				CustomerInfoDAO dao = BaseDAOUtils.getCustomerInfoDAO();
//				CustomerInfo customerInfo = dao.query(value);
//				if(customerInfo != null) {
//					return customerInfo.getCname();
//				} else {
//					return "";
//				}
//
//			} catch (Exception e) {
//				return "";
//			}
//		}
//
//	}
//
//	/**
//	 *
//	 * 贷款品种id翻译成名称方法
//	 */
//	public static String getLoanNameById(ICommonQueryBaseBean element, String value,
//			ServletRequest request) throws HuatengException {
//		if (DataFormat.isEmpty(value)) {
//			return "";
//		}
//		else if ("000000".equals(value)) {
//			return "000000-不限";
//		}
//
//		else {
//			try {
//				LoanParamDAO dao = BaseDAOUtils.getLoanParamDAO();
//				LoanParam loanParam = null;
//				List list = dao.queryByCondition(" po.lnid ='"+value+"' ");
//				if(list!=null&&list.size()>0){
//					loanParam = (LoanParam)list.get(0);
//				}
//				if(loanParam != null) {
//					return value+"-"+loanParam.getLnname();
//				} else {
//					return "";
//				}
//
//			} catch (Exception e) {
//				return "";
//			}
//		}
//
//	}
//
//
//	/**
//	 * Description: 评分模型，根据要素号获得要素名称
//	 * @param
//	 * @return String
//	 * @exception
//	 * @author lu_kangyi
//	 * @version v1.0,2009-3-10
//	 */
//	public static String getGradeNameByNo(ICommonQueryBaseBean element,String value, ServletRequest request) throws HuatengException {
//			if( StringUtils.isEmpty(value) ){
//				return "";
//			}else{
//				GradeModelElementsDAO dao = DAOUtils.getGradeModelElementsDAO();
//				List list = dao.queryByCondition("po.id ='"+Integer.parseInt(value)+"'");
//				GradeModelElements gradeModelElements = (GradeModelElements)list.get(0);
//				return gradeModelElements.getGradeName();
//			}
//	}
//
//
//	/**
//	 * Description: 查询企业行业性质
//	 * @param
//	 * @return String
//	 * @exception
//	 * @author lu_kangyi
//	 * @version v1.0,2009-3-10
//	 */
//	public static String getCustClassName(ICommonQueryBaseBean element,String value, ServletRequest request) throws HuatengException {
//			if( StringUtils.isEmpty(value) ){
//				return "";
//			}else{
//				List list = BaseDAOUtils.getDataDicDAO().queryByCondition("po.dataTypeNo='900' and po.dataNo='" + value + "'");
//				DataDic dic = (DataDic)list.get(0);
//				return dic.getDataName();
//			}
//	}
//
//	/**
//	 * Description: 查询企业行业
//	 * @param
//	 * @return String
//	 * @exception
//	 * @author lu_kangyi
//	 * @version v1.0,2009-3-10
//	 */
//	public static String getBizType(ICommonQueryBaseBean element,String value, ServletRequest request) throws HuatengException {
//			if( StringUtils.isEmpty(value) ){
//				return "";
//			}else{
//				Iterator it = BaseDAOUtils.getHQLDAO().queryByQL("from IndustryTypes po where po.id = '" + value + "'");
//				return ((IndustryTypes)it.next()).getIndustryName();
//			}
//	}
//
//
//
//
//	/**
//	 *
//	 * Description: TODO
//	 *
//	 * @param
//	 * @return String
//	 * @exception
//	 * @author Administrator
//	 * @version v1.0,2008-9-6
//	 */
//	public static String getLoanClassNameByCode(ICommonQueryBaseBean element,
//			String value, ServletRequest request) throws HuatengException {
//
//		HQLDAO hqldao = DAOUtils.getHQLDAO();
//
//		//保证
//		//测试用sql
//		StringBuffer sb = new StringBuffer(
//		"select lp.lnname from LoanParam lp where 1 = 1");
//		if(null != value && !"".equals(value)){
//			sb.append(" and lp.lnid= '" + value + "'");
//		}else{
//			return "";
//		}
//
//		List list = hqldao.queryByQL2List(sb.toString());
//		if(null != list && list.size() == 1){
//			return value + "-" + list.get(0).toString();
//		}else{
//			return "";
//		}
//	}


	/**翻译功能码名称
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getBizFuncNameById(ICommonQueryBaseBean element, String value,
			ServletRequest request) throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return "";
		} else {
			try {
				BizFuncInfoDAO dao = BaseDAOUtils.getBizFuncInfoDAO();
				List list = dao.queryByCondition(" po.id = '"+value+"'");
				if(list != null&&list.size()>0) {
					BizFuncInfo info = (BizFuncInfo)list.get(0);
					return info.getBizFuncName();
				} else {
					return value;
				}

			} catch (Exception e) {
				return value;
			}
		}

	}

	/**翻译操作员名称
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getTlrNameById(ICommonQueryBaseBean element, String value,
			ServletRequest request) throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return "";
		} else {
			try {
				String tlrName = "";
				TlrInfo info = DAOUtils.getTlrInfoDAO().queryById(value);
				if(info!=null){
					tlrName = info.getTlrName();
				}
				return tlrName;

			} catch (Exception e) {
				return value;
			}
		}

	}

	public static String getMtsInOutCodeName(ICommonQueryBaseBean element, String value,
			ServletRequest request) throws CommonException{
		String codetype = element.getAnyValue("codetype");
		if (StringUtils.isEmpty(value) || StringUtils.isEmpty(codetype)) {
			return value;
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Map<String, String> map = new HashMap<String, String>();
		List<MtsInOutCode> codes = rootdao.queryByQL2List("from MtsInOutCode where id.codeType='" + codetype + "'");
		for(MtsInOutCode code : codes){
			map.put(code.getId().getId(), code.getCodeName());
		}
		if (!map.containsKey(value)) {
			return value;
		} else {
			return map.get(value);
		}
	}

	public static String getTreeCodeName(ICommonQueryBaseBean element, String value,
			ServletRequest request) throws HuatengException {
		String headNodeNo = element.getAnyValue("headnodeno");
		if (StringUtils.isEmpty(value) || StringUtils.isEmpty(headNodeNo)) {
			return value;
		}
		DataDicService dataDicService = DataDicService.getInstance();
		Map<String, String> map = new HashMap<String, String>();
		dataDicService.getDataTreeNoName(headNodeNo, value, map);
		if (!map.containsKey(value)) {
			return value;
		} else {
			return map.get(value);
		}
	}

	public static String getTreeCodeNameByNavition(ICommonQueryBaseBean element, String value,
			ServletRequest request) throws HuatengException {
		String headNodeNo = "23";
		if (StringUtils.isEmpty(value)) {
			return value;
		}
		String[] strs = value.split(",");
		if (strs.length != 2){
			return value;
		}
		if(strs[0].equals("CHN")){
			headNodeNo = "16";
		}
		DataDicService dataDicService = DataDicService.getInstance();
		Map<String, String> map = new HashMap<String, String>();
		dataDicService.getDataTreeNoName(headNodeNo, strs[1], map);
		if (!map.containsKey(strs[1])) {
			return strs[1];
		} else {
			return map.get(strs[1]);
		}
	}


//del by zhaozhiguo
//    /**
//     * 根据评分模型代码 获模型名称
//     * @param element
//     * @param value
//     * @param request
//     * @return
//     * @throws HuatengException
//     */
//	public static String getModelNameByModelCode(ICommonQueryBaseBean element, String value,
//			ServletRequest request) throws HuatengException {
//		if (StringUtils.isEmpty(value)) {
//			return "";
//		} else {
//			try {
//				GradeModelInfoDAO dao = DAOUtils.getGradeModelInfoDAO();
//				List list = dao.queryByCondition(" po.id = '"+value+"'");
//				if(list != null&&list.size()>0) {
//					GradeModelInfo info = (GradeModelInfo)list.get(0);
//					return value+"-"+info.getModelName();
//				} else {
//					return value;
//				}
//			} catch (Exception e) {
//				return value;
//			}
//		}
//	}
//
//	public static String getProNoById(ICommonQueryBaseBean element, String value,
//			ServletRequest request) throws HuatengException {
//		if (DataFormat.isEmpty(value)) {
//			return "";
//		}else{
//			NpaAssetsProDAO dao = DAOUtils.getNpaAssetsProDAO();
//			return dao.query(Integer.valueOf(value)).getProNo();
//		}
//	}
//
//
//
//	public static String getCustnoByCustcd(ICommonQueryBaseBean element, String value,
//			ServletRequest request) throws HuatengException {
//		if(StringUtils.isBlank(value)){
//			return "";
//		}else{
//			CustomerInfoDAO customerInfoDAO = DAOUtils.getCustomerInfoDAO();
//			CustomerInfo customerInfo = customerInfoDAO.query(value);
//			if(null == customerInfo){
//				return "";
//			}else{
//				return customerInfo.getCustno();
//			}
//		}
//	}

}
