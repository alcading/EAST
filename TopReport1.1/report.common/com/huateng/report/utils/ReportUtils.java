package com.huateng.report.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import resource.bean.pub.DataDic;
import resource.bean.pub.FunctionInfo;
import resource.bean.report.AlreadySubInfo;
import resource.bean.report.BiAnalyProcess;
import resource.bean.report.BiExecConfirm;
import resource.bean.report.BopCfaBusiMapping;
import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExplbalainfo;
import resource.bean.report.BopCfaFogucodeinfo;
import resource.bean.report.BopExguTorDs;
import resource.bean.report.BopProjectInfo;
import resource.bean.report.RepFileErrDet;
import resource.bean.report.SubFileConf;
import resource.bean.report.SubFileInfo;
import resource.bean.report.SysParams;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.generator.GeneratorFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;
import com.huateng.report.common.bean.ReportBackErrBean;
import com.huateng.report.common.generator.GetBOPJSHRptNoGentator;
import com.huateng.report.common.generator.GetCFABusinessNoGentator;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.dataquery.service.ReportDataPackageQueryService;
import com.huateng.report.execconfirm.service.BiExecConfirmService;
import com.huateng.report.service.AnalyProService;
import com.huateng.report.system.common.IGenBopBusinessNo;

public class ReportUtils {

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

	public static String getStrCodes(List codeslist){
		StringBuffer result = new StringBuffer();
		result.append("(");
		for (int i = 0; i < codeslist.size(); i++) {
			String str =  (String) codeslist.get(i);
			result.append("'").append(str).append("'");
			if (i<codeslist.size()-1) {
				result.append(",");
			}
		}
		result.append(")");
		return result.toString();
	}
	public static String getConfrimCodes(List codeslist){
		StringBuffer result = new StringBuffer();
		result.append("(");
		for (int i = 0; i < codeslist.size(); i++) {
			FunctionInfo info = (FunctionInfo) codeslist.get(i);
			result.append("'").append(info.getId().trim()).append("'");
			if (i<codeslist.size()-1) {
				result.append(",");
			}
		}
		result.append(")");
		return result.toString();
	}

	/**
	 *
	 * 导出projectname list
	 * 格式为  \n 换行
	 *
	 * */

	public static String getProjectNamesByList(List bopProjectList){
		StringBuffer result = new StringBuffer();
		int len = bopProjectList.size();
		for (int i = 0; i < len; i++) {
			BopProjectInfo info = (BopProjectInfo) bopProjectList.get(i);
			result.append(info.getProjectname());
			if (i<len-1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	/**
	 *
	 * 导出creditors list
	 * 格式为  一条记录的多个字段用','分隔，多行记录\n换行记录
	 *
	 * */
	public static String getBopCreditorsByList(List creditorsList){
		StringBuffer result = new StringBuffer();
		int len = creditorsList.size();
		for (int i = 0; i < len; i++) {
			BopCfaCreditorDs info = (BopCfaCreditorDs) creditorsList.get(i);
			result.append("代码：" + (null == info.getCreditorcode() ? "" : info.getCreditorcode()) + ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("中文名称：" + (null == info.getCreditorname() ? "" : info.getCreditorname()) + ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("英文名称：" + (null == info.getCreditornamen() ? "" : info.getCreditornamen()) + ReportConstant.QUERY_EXP_EXCEl_SPLIT);

			if(null!=info.getCreditorca())
			{
				result.append("签约金额：" + info.getCreditorca().setScale(2).toPlainString() + ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			}
			else
			{
				result.append("签约金额：" + ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			}

			result.append("类型代码："+info.getCreditortype()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("总部所在国家（地区）代码："+info.getCrehqcode()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("经营地所在国家（地区）代码："+info.getOpercode());
			if (i<len-1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	/**
	 *
	 * 导出exguTor list
	 * 格式为  一条记录的多个字段用','分隔，多行记录\n换行记录
	 *
	 * */

	public static String getBopExguTorDsByList(List exguTorList){
		StringBuffer result = new StringBuffer();
		int len = exguTorList.size();
		for (int i = 0; i < len; i++) {
			BopExguTorDs info = (BopExguTorDs) exguTorList.get(i);
			result.append("代码："+info.getTorCode()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("中文名称："+info.getTorName()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("英文名称："+info.getTorEnname()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("类型："+info.getTorTypeCode()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("国别/地区："+info.getCountryCode()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);

			if (i<len-1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	/**
	 *
	 * 导出exguTor list
	 * 格式为  一条记录的多个字段用','分隔，多行记录\n换行记录
	 *
	 * */

	public static String getFogucodeinfoByList(List foguinfoList){
		StringBuffer result = new StringBuffer();
		int len = foguinfoList.size();
		for (int i = 0; i < len; i++) {
			BopCfaFogucodeinfo info = (BopCfaFogucodeinfo) foguinfoList.get(i);
			result.append("代码："+info.getFogucode()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("中文名称："+info.getFoguname()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("英文名称："+info.getFogunamen()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("注册地国家/地区代码："+info.getFogurecode()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			result.append("担保方式："+info.getGuaranteetype()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);

			if (i<len-1) {
				result.append("\n");
			}
		}
		return result.toString();
	}


	/**
	 *
	 * 导出Explbalainfo list:签约信息
	 * 格式为  一条记录的多个字段用','分隔，多行记录\n换行记录
	 *
	 * */

	public static String getConExplbalainfoByList(List explbaList){
		StringBuffer result = new StringBuffer();
		int len = explbaList.size();
		for (int i = 0; i < len; i++) {
			BopCfaExplbalainfo info = (BopCfaExplbalainfo) explbaList.get(i);
			result.append("币种："+info.getExplcurr()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);

			if(null!=info.getExplamount())
			{
				result.append("金额："+info.getExplamount().setScale(2).toPlainString()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			}
			else result.append("金额："+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			if (i<len-1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	/**
	 *
	 * 导出Explbalainfo list：变动信息
	 * 格式为  一条记录的多个字段用','分隔，多行记录\n换行记录
	 *
	 * */

	public static String getChangExplbalainfoByList(List explbaList){
		StringBuffer result = new StringBuffer();
		int len = explbaList.size();
		for (int i = 0; i < len; i++) {
			BopCfaExplbalainfo info = (BopCfaExplbalainfo) explbaList.get(i);

			result.append("币种："+info.getExplcurr()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			if(null!=info.getExplbala())
			{
				result.append("金额："+info.getExplbala().setScale(2).toPlainString()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			}
			else
				result.append("金额："+ReportConstant.QUERY_EXP_EXCEl_SPLIT);

			if(null!=info.getExplperamount())
			{
				result.append("履约金额："+info.getExplperamount().setScale(2).toPlainString()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			}
			else
				result.append("履约金额："+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			if(null!=info.getPlcoseamount())
			{
				result.append("履约结汇金额："+info.getPlcoseamount().setScale(2).toPlainString()+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			}
			else
				result.append("履约结汇金额："+ReportConstant.QUERY_EXP_EXCEl_SPLIT);
			if (i<len-1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	/**
	 * 判断补录及审核功能是否允许操作
	 * @param info
	 * @return
	 * @throws CommonException
	 */
	public static boolean isLockByExecByBop(GlobalInfo info, String apptype) throws CommonException{
		boolean bl = false;
		BiExecConfirm confirm =  BiExecConfirmService.getInstance().getBiExecConfirmByPk(TopReportConstants.REPORT_BUSITYPE_BOP, apptype, info.getBrno(), DateUtil.dateToNumber(info.getTxdate()));
		if (confirm!=null) {
			String confstatus = confirm.getConfirmStatus();
			if (confstatus.equals(TopReportConstants.REPORT_CONFRIM_STATUS_01)) {
				bl = true;
			}
		}
		return bl;
	}

	public static Set<String> getQueryTableSet(String busiType, String qappType) throws CommonException {
		Map<String, List<DataDic>> map = ReportCommonService.getInstance().getAppAndFileTypeByDataDic(busiType, qappType,
				null);
		Set<String> tableNmSet = new HashSet<String>();
		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
			String appType = iterator.next().trim();
			List<DataDic> ddList = map.get(appType);
			for (int i = 0; i < ddList.size(); i++) {
				DataDic dd = ddList.get(i);
				if (dd!=null && dd.getHighLimit() != null) {
					tableNmSet.add(dd.getHighLimit().trim());
				}
			}
		}
		return tableNmSet;
	}

	/**
	 * 获取当前页面上所选的查询条件所要查询的表名
	 * @param map
	 * @return
	 */
	public static Set<String> getTableName(Map<String, List<DataDic>> map) {
		Set<String> tablenameSet = new HashSet<String>();
		for (Iterator<Entry<String, List<DataDic>>> iter = map.entrySet().iterator(); iter.hasNext();) {
			Entry<String, List<DataDic>> entry = iter.next();
			List<DataDic> ddList = entry.getValue();
			for (DataDic dd : ddList) {
				if (dd.getHighLimit()!=null && dd.getHighLimit().trim().length()>0) {
					tablenameSet.add(dd.getHighLimit().trim());
				}
			}
		}
		return tablenameSet;
	}

	public static List<DataDic> getBusinessList() throws CommonException {
		return ReportCommonService.getInstance().getBusinessByTypeNo();
	}

	/**
	 * 生成in语句
	 *
	 * @param coll
	 *            值列表
	 * @return 形如('a','b')或(1,2,3)的语句
	 */
	public static String toInString(Collection<?> coll) {
		if (null == coll || coll.size() == 0) {
			return "('')"; // 避免语法错误
		}
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (Object obj : coll) {
			if (obj == null)
				continue;

			if (obj instanceof Date) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				sb.append("'").append(df.format((Date) obj)).append("'");
			} else if (obj instanceof String) {
				sb.append("'" + obj + "'");
			} else {
				sb.append(obj);
			}

			sb.append(',');
		}
		sb.deleteCharAt(sb.length() - 1); // 删除多加的","
		sb.append(")");
		String s = sb.toString();
		if ("()".equals(s)) { // 避免语法错误
			s = "('')";
		}
		return s;
	}

	/**
	 * 根据业务类型生成外债编号等（2为业务类型+12位机构号+8位当前日期+6位流水号{目前为*代替}）
	 * 申报号码生成规则：6位地区标识码+4位银行代码+2位银行顺序码+收付汇日期（yymmdd）+4位银行业务流水码。
	 * 前12位为业务发生的银行金融机构标识码。
	 * @param bussType：业务类型代码
	 *
	 */

	public static String getBussinessNo(String bussType) throws CommonException {
		String bussinessNo = "";
		GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
		if (null != bussType && bussType.length() == 2) {
			//业务类型转换
			BopCfaBusiMapping busiMapping = ROOTDAOUtils.getROOTDAO().query(BopCfaBusiMapping.class, bussType);
			if (busiMapping != null && busiMapping.getBusiCode() != null && busiMapping.getBusiCode().length() == 2) {
				String tmp = busiMapping.getBusiCode() + ginfo.getBrno() + DateUtil.dateToNumber(ginfo.getTxdate());
				bussinessNo = getTempStr(tmp, 28);
			} else {
				ExceptionUtil.throwCommonException("文件类型和业务标识未映射！");
			}
		} else if(null != bussType && bussType.length() == 1){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
			String tmp = ginfo.getBrno() + simpleDateFormat.format(ginfo.getTxdate());;
			bussinessNo = getTempStr(tmp, 22);
		}else if (null == bussType || bussType.length() > 2) {
			ExceptionUtil.throwCommonException("业务类型长度错误！");
		}

		return bussinessNo;
	}

	/**
	 * 根据传实体和文件类型，查询配置映射去设置默认值。
	 * @param obj
	 * @param bussType
	 * @throws CommonException
	 */
	public static void setObjectPro(Object obj,String bussType) throws CommonException{
		if (null != bussType && bussType.length() == 2) {
			BopCfaBusiMapping busiMapping = ROOTDAOUtils.getROOTDAO().query(BopCfaBusiMapping.class, bussType);
			if (busiMapping != null && busiMapping.getOtherMapping() != null) {
				String[] provals = busiMapping.getOtherMapping().split(",");
				for(String proval : provals){
					String[] strs = proval.split(":");
					if (strs.length == 2) {
						try {
							PropertyUtils.setNestedProperty(obj, strs[0], strs[1]);
						} catch (Exception e) {

						}
					}
				}
			}
		}
	}

	public static String getTempStr(String str, int len) {
		return StringUtils.rightPad(str == null ? "" : str.trim(), len, ReportConstant.BUSI_NO_CODE);
	}


	/**
	 * 根据编码加载左侧导航
	 *
	 * @param code
	 * @return
	 */
	public static List getLeftNavgList(String code) {
		if (code == null || code.trim().length() == 0) {
			return null;
		}
		ReportCommonService commonService = ReportCommonService.getInstance();
		List list = null;
		try {
			list = commonService.getConfList(code);
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean isAnalyByBusiType(String workdate, String busiType) {
		boolean bl = true;
		try {
			// 判断是否导入数据
			int logcount = ReportCommonService.getInstance().getImportLogByWorkDate(workdate);
			if (logcount > 0) {// 已成功导入文件
				BiAnalyProcess process = AnalyProService.getInstance().getBiAnalyProcessByTypeAndWorkDate(workdate,
						busiType);
				if (process == null || process.getExecuteTm() == null) {
					bl = false;
				}
			}
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return bl;
	}

	/**
	 * 加载业务主键
	 *
	 * @param obj
	 * @param confBusiPk
	 * @return
	 * @throws Exception
	 */
	public static String getBopDsBusiNo(Object obj, String confBusiPk, SubFileConf conf) throws Exception {
		if (confBusiPk==null) {
			return "";
		}
		StringBuffer result = new StringBuffer();
		String[] pks = confBusiPk.split(",");
		for (int i = 0; i < pks.length; i++) {
			Object value = PropertyUtils.getNestedProperty(obj, pks[i]);
			if (value == null || value.toString().trim().length() == 0) {
				ExceptionUtil.throwCommonException(pks[i] + "业务主键为空!");
			} else {
				result.append(value.toString().trim());
				if (conf.getPkSplit() != null && conf.getPkSplit().length() > 0 && i < pks.length - 1) {
					result.append(conf.getPkSplit());
				}
			}
		}
		return result.toString();
	}
	/**
	 * 根据应用及文件类型加载表名
	 * @param appType
	 * @param fileType
	 * @return
	 * @throws CommonException
	 */
	public static String getBopDsBeanName(String appType, String fileType) throws CommonException{
		String tableName = null;
		Map<String, List<DataDic>> map = ReportCommonService.getInstance().getAppAndFileTypeByDataDic(
				TopReportConstants.REPORT_BUSITYPE_BOP, appType, fileType);
		if (map != null && map.size() > 0) {
			List<DataDic> dicList = map.get(appType);
			if (dicList.size() == 1) {
				DataDic dataDic = dicList.get(0);
				tableName = dataDic.getHighLimit();
			}
		}
		return tableName;
	}

	/**
	 * 根据应用类型、文件类型、记录主键加载对象
	 *
	 * @param appType
	 * @param fileType
	 * @param recId
	 * @return
	 * @throws CommonException
	 */
	public static Object getObjectByAppTypeAndFileType(String appType, String fileType, String recId)
			throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		Object obj = null;
		String tableName = getBopDsBeanName(appType, fileType);
		if (tableName != null && tableName.trim().length() > 0) {
			List objList = dao.queryByQL2List(" from " + tableName + " model where model.id='" + recId + "'");
			if (objList.size() == 1) {
				obj = objList.get(0);
			}
		}
		return obj;
	}

	/**
	 * 获取上报文件生成配置信息
	 *
	 * @param appType
	 * @param fileType
	 * @return
	 * @throws CommonException
	 */
	public static SubFileConf getSubFileConfByBopPk(String appType, String fileType) throws CommonException {
		return ReportCommonService.getInstance().getSubFileConfByPk(TopReportConstants.REPORT_BUSITYPE_BOP, appType,
				fileType);
	}

	/**
	 * 获取业务主键
	 *
	 * @param appType
	 * @param fileType
	 * @param recId
	 * @return
	 * @throws CommonException
	 */
	public static String getBopBusiNoByAppAndFileType(String appType, String fileType, String recId)
			throws CommonException {
		Object obj = getObjectByAppTypeAndFileType(appType, fileType, recId);
		if (obj == null) {
			ExceptionUtil.throwCommonException(recId + "对象不存在(" + appType + fileType + ")!");
		}
		SubFileConf conf = getSubFileConfByBopPk(appType, fileType);
		String bussNo = null;
		try {
			if (conf != null && conf.getBusiPkStr() != null && conf.getBusiPkStr().trim().length() > 0) {
				bussNo = getBopDsBusiNo(obj, conf.getBusiPkStr(), conf);
			}
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(recId + "对象获取业务主键异常，(" + appType + fileType + ")!");
		}
		return bussNo;
	}

	/**
	 * 加载回执信息
	 *
	 * @param recId
	 * @param appType
	 * @param fileType
	 * @return
	 * @throws CommonException
	 */
	public static ReportBackErrBean getReportBankMsg(String recId, String appType, String fileType)
			throws CommonException {
		ReportBackErrBean bean = null;
		ReportDataPackageQueryService dataPackService = ReportDataPackageQueryService.getInstance();
		AlreadySubInfo subInfo = dataPackService.getAlreadySubInfo(recId, appType, fileType);
		if (subInfo != null) {
			SubFileInfo fileInfo = dataPackService.getSubFileInfo(subInfo.getFileName().trim());
			if (fileInfo != null) {
				if (fileInfo.getIsImpRep().equals(ReportEnum.REPORT_IS.YES.value)) {
					if (fileInfo.getRepErrType().equals(ReportEnum.REPORT_ERR_TYPE.FORMAT_ERR.value)) {
						List errList = dataPackService.getReportErrDetailList(null, fileInfo.getRepFileName(), appType,
								fileType);
						if(errList!=null && errList.size() > 0){
							bean = new ReportBackErrBean();
							bean.setErrType(fileInfo.getRepErrType());
							for (int i = 0; i < errList.size(); i++) {
								RepFileErrDet det = (RepFileErrDet) errList.get(i);
								bean.getErrMsg().add(det.getErrdesc());
							}
						}
					} else if (fileInfo.getRepErrType().equals(ReportEnum.REPORT_ERR_TYPE.REC_ERR.value)) {
						String busiCode = getBopBusiNoByAppAndFileType(appType, fileType, recId);// 业务主键
						List errList = dataPackService.getReportErrDetailList(busiCode, fileInfo.getRepFileName(),
								appType, fileType);
						if(errList!=null && errList.size() > 0){
							bean = new ReportBackErrBean();
							bean.setErrType(fileInfo.getRepErrType());
							for (int i = 0; i < errList.size(); i++) {
								RepFileErrDet det = (RepFileErrDet) errList.get(i);
								bean.getErrFiledMap().put(det.getErrfield(), det.getErrfieldcn());
								bean.getErrFiledContentMap().put(det.getErrfield(), det.getErrdesc());
							}
						}
					}

				}
			}
		}
		return bean;
	}

	public static String getSysParamsValue(String groupId, String paramId) {
		String value = null;
		try {
			SysParams param = ReportCommonService.getInstance().getSysparamsByPk(groupId, paramId);
			value = param.getParamVal().trim();
		} catch (CommonException e) {
			e.printStackTrace();
		}

		return value;
	}

	public static String getSysParamsValue(String groupId, String paramId, String defaultValue) {
		String value = null;
		try {
			SysParams param = ReportCommonService.getInstance().getSysparamsByPk(groupId, paramId);
			if(param==null){
				return defaultValue;
			}
			value = param.getParamVal().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}
	/**
	 * 获取资本项目编号
	 * @param parValue
	 * @param busiType
	 * @param appType
	 * @param workDate
	 * @param busiNo
	 * @return
	 * @throws CommonException
	 */
	public static String getCfaCode(String parValue, String busiType,String appType,String fileType, String workDate, String busiNo)
			throws CommonException {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(IGenBopBusinessNo.PARAM_VALUE, parValue);
		paramMap.put(IGenBopBusinessNo.APP_TYPE, appType);
		paramMap.put(IGenBopBusinessNo.BUSI_TYPE, busiType);
		paramMap.put(IGenBopBusinessNo.WORK_DATE, workDate);
		paramMap.put(IGenBopBusinessNo.BUSINSESS_NO, busiNo);
		paramMap.put(IGenBopBusinessNo.FILE_TYPE, fileType);
		GetCFABusinessNoGentator getCfaBusinessNoGentator = (GetCFABusinessNoGentator) GeneratorFactory.getGenerator("GetCFABusinessNoGentator");
		try {
			String code = getCfaBusinessNoGentator.gen(paramMap);
			return code;
		} catch (AppException e) {
			ExceptionUtil.throwCommonException(e.getMessage());
		}
		return busiNo;
	}

	/**
	 * 获取国际收支申报号码
	 * @param parValue
	 * @param busiType
	 * @param appType
	 * @param fileType
	 * @param workDate
	 * @param cusType
	 * @param busiNo
	 * @return
	 * @throws CommonException
	 */
	public static String getBopRptNoByCusType(String parValue,String busiType,String appType,String fileType,String workDate,String cusType,String busiNo) throws CommonException{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(IGenBopBusinessNo.PARAM_VALUE, parValue);
		paramMap.put(IGenBopBusinessNo.APP_TYPE, appType);
		paramMap.put(IGenBopBusinessNo.BUSI_TYPE, busiType);
		paramMap.put(IGenBopBusinessNo.WORK_DATE, workDate);
		paramMap.put(IGenBopBusinessNo.BUSINSESS_NO, busiNo);
		paramMap.put(IGenBopBusinessNo.FILE_TYPE, fileType);
		paramMap.put(IGenBopBusinessNo.CUS_TYPE, cusType);
		GetBOPJSHRptNoGentator 	getBOPJSHRptNoGentator = (GetBOPJSHRptNoGentator) GeneratorFactory.getGenerator("GetBOPJSHRptNoGentator");

		try {
			String retNo = getBOPJSHRptNoGentator.gen(paramMap);
			return retNo;
		} catch (AppException e) {
			ExceptionUtil.throwCommonException(e.getMessage());
		}
		return busiNo;
	}


	/**
	 * 确认产生文件名称的日期
	 *
	 * @param info
	 * @return
	 */
	public static String getSubFileDate6(GlobalInfo info) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		if (ReportConstant.SUB_FILE_DATE_TYPE.equals("01")) {
			return sdf.format(new Date());
		} else if (ReportConstant.SUB_FILE_DATE_TYPE.equals("02")) {
			return sdf.format(info.getTxdate());
		}
		return sdf.format(new Date());
	}

	public static boolean isFileExist(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			return true;
		}
		return false;
	}

	/**
	 * 获取下载到本地后文件全路径
	 *
	 * @param srcpath
	 * @param repPack
	 * @param fileName
	 * @return
	 */
	public  static String getFeedbackFilePath(String srcpath, String repPack, String fileName) {
		StringBuffer ttFilePath = new StringBuffer();
		String feedbackPath = getSysParamsValue("DIR", "0004", "Feedback/");
		ttFilePath.append(srcpath).append(feedbackPath);
		ttFilePath.append(repPack + "/");
		ttFilePath.append(fileName);
		return ttFilePath.toString();
	}
	
	/**
	 * 如果证件种类是身份证且姓名为2-3个字，返回最后一个字，其他类型不变。
	 * @param zjzl 证件种类
	 * @param name 姓名
	 * @return
	 */
	public static String getFinalName(String zjzl, String name){
		if("0".equals(zjzl) && name.length()>=2 && name.length()<=3){
			return name.substring(name.length()-1);
		}else{
			return name;
		}
	}
	
}
