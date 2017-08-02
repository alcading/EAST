/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import resource.bean.pub.TlrRoleRel;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GetTlrIntNoGenerator;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.generator.GeneratorFactory;
import com.huateng.ebank.business.common.generator.GetAccumFundActno2Generator;
import com.huateng.ebank.business.common.generator.GetAcontnoGenerator;
import com.huateng.ebank.business.common.generator.GetAppno2Generator;
import com.huateng.ebank.business.common.generator.GetAppnoGenerator;
import com.huateng.ebank.business.common.generator.GetBrcodeIDGenerator;
import com.huateng.ebank.business.common.generator.GetBreedCreditNoGenerator;
import com.huateng.ebank.business.common.generator.GetCinoGenerator;
import com.huateng.ebank.business.common.generator.GetContnoGenerator;
import com.huateng.ebank.business.common.generator.GetContractnoGenerator;
import com.huateng.ebank.business.common.generator.GetCoreReqSeqGenerator;
import com.huateng.ebank.business.common.generator.GetCorpCreditIdGenerator;
import com.huateng.ebank.business.common.generator.GetCredencenoGenerator;
import com.huateng.ebank.business.common.generator.GetCreditCinoGenerator;
import com.huateng.ebank.business.common.generator.GetCreditFrzSeqGenerator;
import com.huateng.ebank.business.common.generator.GetCreditNoGenerator;
import com.huateng.ebank.business.common.generator.GetCustCreditNoGenerator;
import com.huateng.ebank.business.common.generator.GetCustcdGenerator;
import com.huateng.ebank.business.common.generator.GetCustomerInfractIdGenerator;
import com.huateng.ebank.business.common.generator.GetHousenoGenerator;
import com.huateng.ebank.business.common.generator.GetInsurerNoticeNoGenerator;
import com.huateng.ebank.business.common.generator.GetLnidGenerator;
import com.huateng.ebank.business.common.generator.GetMortImpawnIDGenerator;
import com.huateng.ebank.business.common.generator.GetProductCreditNoGenerator;
import com.huateng.ebank.business.common.generator.GetProjectnoGenerator;
import com.huateng.ebank.business.common.generator.GetWarningIDGenerator;
import com.huateng.ebank.business.common.operator.GetSeqnoOperation;
import com.huateng.ebank.entity.dao.mng.PfSysParamDAO;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.operation.SingleOPCaller;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * @author valley
 * @date 2004-11-16
 * @desc 通用service
 */
public class CommonService
{

	protected CommonService()
	{
	}

	/**
	 * Get instance of common service
	 *
	 * @return
	 */
	public synchronized static CommonService getInstance()
	{
		return (CommonService) ApplicationContextUtils
				.getBean(CommonService.class.getName());
	}

	/**
	 * 生成申请编号
	 *
	 * @param apptype 申请类型
	 * @param brcode 申请机构
	 * @return
	 * @throws CommonException
	 */
	public String getAppno(String custNo) throws CommonException
	{
		GetAppnoGenerator getAppnoGenertor = (GetAppnoGenerator) GeneratorFactory
				.getGenerator("GetAppnoGenerator");
		Map paramMap = new HashMap();
		paramMap.put("custNo", custNo);
		String appno = getAppnoGenertor.gen(paramMap);
		return appno;
	}

	/**
	 * 生成申请编号
	 *
	 * @param apptype
	 *            申请类型
	 * @param brcode
	 *            申请机构
	 * @return
	 * @throws CommonException
	 */
	public String getAppno(String apptype, String brcode)
			throws CommonException {
		GetAppnoGenerator getAppnoGenertor = (GetAppnoGenerator)GeneratorFactory.getGenerator("GetAppnoGenerator");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("apptype", apptype);
		paramMap.put("brcode", brcode);
		String appno = getAppnoGenertor.genBuyApptypeBrcode(paramMap);
		return appno;
	}

	/**
	 * 生成定制贷款查询申请号
	 *
	 * @param apptype
	 *            申请类型
	 * @param brcode
	 *            申请机构
	 * @return
	 * @throws CommonException
	 */
	public String getAppno2(String apptype, String brcode)
			throws CommonException {
		GetAppno2Generator getAppnoGenertor = (GetAppno2Generator)GeneratorFactory.getGenerator("GetAppno2Generator");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("apptype", apptype);
		paramMap.put("brcode", brcode);
		String appno = getAppnoGenertor.gen(paramMap);
		return appno;
	}

	/**
	 * 得到序号
	 *
	 * @param valueNo
	 * @param valueIndex
	 * @return
	 * @throws CommonException
	 */
	/** modify by shen_antonio 20091009 jira:BMS-2059 begin . */
	public synchronized int getSeqno(int valueNo, String valueIndex)
			throws CommonException
	{
		/** modify by shen_antonio 20091009 jira:BMS-2059 end . */
		/*
		 * modify by shen_antonio 20090227 以SingleOPCaller的方式调用
		 * GetSeqnoGenerator getSeqnoGenerator =
		 * (GetSeqnoGenerator)GeneratorFactory.getGenerator("GetSeqnoGenerator");
		 * Map paramMap = new HashMap(); paramMap.put("valueNo", new
		 * Integer(valueNo)); paramMap.put("valueIndex", valueIndex); Integer
		 * seqno = new
		 * Integer(Integer.parseInt(getSeqnoGenerator.gen(paramMap)));
		 */
		OperationContext context = new OperationContext();
		context.setAttribute(GetSeqnoOperation.VALUE_NO, new Integer(valueNo));
		context.setAttribute(GetSeqnoOperation.VALUE_INDEX, valueIndex);
		SingleOPCaller.call(GetSeqnoOperation.ID, context);
		Integer seqno = (Integer) context.getAttribute(GetSeqnoOperation.SEQNO);
		return seqno.intValue();
	}

	/**
	 *
	 * Description: 校验组织机构代码证是否正确，例：23893788-0
	 *
	 * Modified by Robin Suo For Jira BMS-2329 支持组织机构代码中前8位有字母的情况
	 *
	 * @param no 组织机构代码证
	 * @return 是否正确的boolean值
	 * @author mengyf
	 * @version v1.0,2008-11-19
	 */
	public boolean checkOrgCode(String no)
	{
		// 如果组织机构代码证是空
		if (StringUtils.isBlank(no))
		{
			return false;
		}

		// 去掉空字符串
		String orgCode = StringUtils.trimToEmpty(no);

		// 组织机构代码基本格式10位的有效组织机构代码， 前8位为有效数字，第9位为“－”，第10位为校验位
		if (!Pattern.matches("^[A-Z0-9]{8}\\-[\\d{1}|X]$", orgCode))
		{
			return false;
		}

		int[] tempInt = new int[8];
		int[] factor = { 3, 7, 9, 10, 5, 8, 4, 2 };

		int sum = 0;
		if (orgCode.charAt(8) != 45)
		{
			return false;
		}
		for (int i = 0; i < 10; i++)
		{
			int c = orgCode.charAt(i);
			if (c <= 122 && c >= 97)
			{
				return false;
			}
		}

		/*
		 * Blocked by Robin Suo For Jira BMS-2329 int fir_value =
		 * orgCode.charAt(0); int sec_value = orgCode.charAt(1);
		 *
		 * if (fir_value >= 65 && fir_value <= 90) { tempInt[0] = (fir_value +
		 * 32) - 87; } else if (fir_value >= 48 && fir_value <= 57) { tempInt[0] =
		 * fir_value - 48; } else { return false; } sum += factor[0] *
		 * tempInt[0];
		 *
		 * if (sec_value >= 65 && sec_value <= 90) { tempInt[1] = (sec_value -
		 * 65) + 10; } else if (sec_value >= 48 && sec_value <= 57) { tempInt[1] =
		 * sec_value - 48; } else { return false; } sum += factor[1] *
		 * tempInt[1];
		 *
		 */

		for (int j = 0; j < 8; j++)
		{
			if (orgCode.charAt(j) >= 65 && orgCode.charAt(j) <= 90)
			{
				tempInt[j] = orgCode.charAt(j) - 65 + 10;
			} else if (orgCode.charAt(j) >= 48 && orgCode.charAt(j) <= 57)
			{
				tempInt[j] = orgCode.charAt(j) - 48;
			} else
			{
				return false;
			}
			sum += factor[j] * tempInt[j];
		}

		// 计算获得最后真正的校验码
		int balance = 11 - sum % 11;

		// 最后一位校验码
		int last_value = orgCode.charAt(9);

		// 判断校验位
		if (!((last_value == 88 && balance == 10) // 条件1：如果校验码是'X'的话，计算而得的值为10
				|| (balance == 11 && last_value == 48) // 条件2：如果计算而得的值为11，校验码是'0'的
		|| balance == last_value - 48 // 条件3：其他情况都应该是：balance == last_value -
		// 48
		))
		{
			return false;
		}

		return true;
	}

	/* added by yang jenny 2009-11-03 BMS-2156 begin */
	/**
	 * 生成额度产品编号
	 *
	 * @param bankNo 联行号
	 * @param busiType 业务类型
	 * @return
	 * @throws CommonException
	 * @author yang jenny
	 */
	public String getCreditNo(String preIndex, String busiType)
			throws CommonException
	{
		GetCreditNoGenerator getCreditNoGenertor = (GetCreditNoGenerator) GeneratorFactory
				.getGenerator("GetCreditNoGenerator");
		Map paramMap = new HashMap();
		paramMap.put("preIndex", preIndex);
		paramMap.put("busiType", busiType);
		String appno = getCreditNoGenertor.gen(paramMap);
		return appno;
	}

	/**
	 * 生成额度关联ID编号
	 *
	 * @return
	 * @throws CommonException
	 * @author yang jenny
	 */
	public int getCreditRealId() throws CommonException
	{
		int creditRealId = CommonService.getInstance().getSeqno(
				SystemConstant.VALUE_NO_CREDITREALID,
				SystemConstant.VALUE_INDEX);
		return creditRealId;
	}


	/**
	 * 生成机构编号
	 *
	 * @author yjw
	 * @return
	 * @throws CommonException
	 */
	public String getBrcodeID() throws CommonException
	{
		GetBrcodeIDGenerator GetBrcodeIDGenerator = (GetBrcodeIDGenerator) GeneratorFactory
				.getGenerator("GetBrcodeIDGenerator");
		String brcodeId = GetBrcodeIDGenerator.gen(null);
		return brcodeId;
	}

	/**
	 * Description: 生成客户内部编码
	 *
	 * @param custType 客户内部编码类型
	 * @return String
	 * @exception CommonException
	 * @author maidi
	 * @version v1.0,2008-7-1
	 */
	public String getCustcd(String custType, String corpCodeType)
			throws CommonException
	{
		GetCustcdGenerator getCustcdGenerator = (GetCustcdGenerator) GeneratorFactory
				.getGenerator("GetCustcdGenerator");
		Map paramMap = new HashMap();
		paramMap.put("custType", custType);
		paramMap.put("corpCodeType", corpCodeType);
		String corpCustcd = getCustcdGenerator.gen(paramMap);
		return corpCustcd;
	}

	/**
	 * 101 客户经理 Description: 判断角色是否是客户经理
	 *
	 * @param roleId
	 *            角色ID
	 * @return boolean
	 * @exception
	 * @author mengyf
	 * @version v1.0,2008-10-7
	 */
	public boolean isCustomerManager() throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		int roleId = 0;
		String role = DataFormat.trim(gi.getWorkflowRoleId());
		if (role.length() > 0)
			try {
				roleId = Integer.parseInt(role);
				if (roleId == SystemConstant.ROLE_CUST_MANAGER) {// 客户经理
					return true;
				}
			}
			// 不能转说明是不是数字。
			catch (Exception e) {
				int subroleId = Integer.parseInt(role.substring(4, 7));
				if (subroleId == SystemConstant.ROLE_CUST_MANAGER) {
					return true;
				}
			}
		return false;

	}

	/**
	 * 102 支行行长 Description: 判断是否支行级别的角色brclass=2
	 *
	 * @param roleId
	 * @return
	 * @author mengyf
	 * @version v1.0,2008-10-8
	 */
	public boolean isSubBranchRole() throws CommonException
	{
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String brclass = gi.getBrClass();
		if (SystemConstant.BRCODE_CLASS_SUBBRANCH.equals(brclass))
		{// 支行行长
			return true;
		}
		return false;
	}

	// 判断当前岗位是否省分行branchClass=1
	public boolean isProBranchRole() throws CommonException
	{
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		// String brclass = gi.getBranchClass();
		// if (SystemConstant.RPT_BRCODE_CLASS_1.equals(brclass)) {//省分行行长
		// return true;
		// }
		return false;
	}

	/**
	 *
	 * 103 分行审查岗 104 分行高级经理 105 分行分管行长
	 *
	 * 115 贷审会秘书
	 *
	 * 106 放款中心档案岗 108 放款中心法律岗 107 放款中心审查岗 109 放款中心主管岗 110 放款中心放款岗
	 *
	 * 114 资产保全 116 贷后管理岗
	 *
	 * Description: 是否分行级别的角色brclass=1
	 *
	 * @param roleId
	 * @return
	 * @author mengyf
	 * @version v1.0,2008-10-8
	 */
	public boolean isBranchRole() throws CommonException
	{
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String brclass = gi.getBrClass();
		if (SystemConstant.BRCODE_CLASS_BRANCH.equals(brclass))
		{// 分行行长
			return true;
		}
		return false;
		/*
		 * if (roleId == 103//分行审查岗 || roleId == 104//分行高级经理 || roleId ==
		 * 105//分行分管行长 || roleId == 115//贷审会秘书 || roleId == 106//放款中心档案岗 ||
		 * roleId == 108//放款中心法律岗 || roleId == 107//放款中心审查岗 || roleId ==
		 * 109//放款中心主管岗 || roleId == 110//放款中心放款岗 || roleId == 114//资产保全 ||
		 * roleId == 116//贷后管理岗 ) {
		 */
	}

	/**
	 * 111 系统管理 112 授权管理 113 业务管理 201 征信岗 Description: TODO
	 *
	 * @param roleId
	 * @return
	 * @author mengyf
	 * @version v1.0,2008-10-8
	 */
	public boolean isChiefBranchRole() throws CommonException
	{
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String brclass = gi.getBrClass();
		if (SystemConstant.BRCODE_CLASS_HEAD.equals(brclass))
		{// 总行行长
			return true;
		}
		return false;
		/*
		 * if (roleId == 111//系统管理 || roleId == 112 //授权管理 || roleId == 113
		 * //业务管理 || roleId == 201 //征信岗 ) { return true; }
		 */
	}

	/**
	 * 生成抵押、质押序号
	 *
	 * @return
	 * @throws CommonException
	 */
	public int getMortImpawnID(String contractno) throws CommonException {
		GetMortImpawnIDGenerator getMortImpawnIDGenerator = (GetMortImpawnIDGenerator) GeneratorFactory
				.getGenerator("GetMortImpawnIDGenerator");
		String mortImpawnID = getMortImpawnIDGenerator.gen(null);
		return Integer.parseInt(mortImpawnID);
	}

	/**
	 * 生成审批通知书号
	 *
	 * @return
	 * @throws CommonException
	 */
	public int getInsurerNoticeNoID() throws CommonException {
		GetInsurerNoticeNoGenerator getInsurerNoticeNoGenerator = (GetInsurerNoticeNoGenerator) GeneratorFactory
				.getGenerator("GetInsurerNoticeNoGenerator");
		String mortImpawnID = getInsurerNoticeNoGenerator.gen(null);
		return Integer.parseInt(mortImpawnID);
	}


	/**
	 * 生成客户额度编号
	 *
	 * @param brcode
	 *            申请机构
	 * @return custCreditno
	 * @throws CommonException
	 */
	public String getCustCreditno(String brcode, String custno) throws CommonException {
		GetCustCreditNoGenerator getCreditnoGenerator = (GetCustCreditNoGenerator) GeneratorFactory
				.getGenerator("GetCustCreditNoGenerator");
		Map paramMap = new HashMap();
		paramMap.put("brcode", brcode);
		paramMap.put("custno", custno);
		String custCreditno = getCreditnoGenerator.gen(paramMap);
		return custCreditno;
	}


	/**
	 * 生成产品额度编号
	 *
	 * @param custCreditNo
	 * @param curcd
	 *            结算币种
	 * @param creditType
	 *            产品类型
	 * @return productCreditno
	 * @throws CommonException
	 */
	public String getProductCreditno(String custCreditNo, String curcd,
			String productType) throws CommonException {
		GetProductCreditNoGenerator getCreditnoGenerator = (GetProductCreditNoGenerator) GeneratorFactory
				.getGenerator("GetProductCreditNoGenerator");
		Map paramMap = new HashMap();
		paramMap.put("custCreditNo", custCreditNo);
		paramMap.put("curcd", curcd);
		paramMap.put("productType", productType);
		String productCreditno = getCreditnoGenerator.gen(paramMap);
		return productCreditno;
	}


	/**
	 * 生成品种额度编号
	 *
	 * @param productCreditNo
	 * @param breedType
	 *            品种类型
	 * @param useType
	 *            使用方式
	 * @return productCreditno
	 * @throws CommonException
	 */
	public String getBreedCreditno(String productCreditNo, String breedType,
			String useType) throws CommonException {
		GetBreedCreditNoGenerator getCreditnoGenerator = (GetBreedCreditNoGenerator) GeneratorFactory
				.getGenerator("GetBreedCreditNoGenerator");
		Map paramMap = new HashMap();
		paramMap.put("productCreditNo", productCreditNo);
		paramMap.put("breedType", breedType);
		paramMap.put("useType", useType);
		String breedCreditno = getCreditnoGenerator.gen(paramMap);
		return breedCreditno;
	}

	/**
	 * 生成额度冻结解冻顺序号
	 *
	 * @return
	 * @throws CommonException
	 */
	public int GetCreditFrzSeqno() throws CommonException {
		GetCreditFrzSeqGenerator getCreditFrzSeqGenerator = (GetCreditFrzSeqGenerator) GeneratorFactory
				.getGenerator("GetCreditFrzSeqGenerator");
		String frzSeqno = getCreditFrzSeqGenerator.gen(null);
		return Integer.parseInt(frzSeqno);
	}


	/**
	 * 生成合同编号
	 *
	 * @param productCreditNo
	 * @param breedType
	 *            品种类型
	 * @param useType
	 *            使用方式
	 * @return productCreditno
	 * @throws CommonException
	 */
	public String getContractno(String contType) throws CommonException {
		GetContnoGenerator getContnoGenerator = (GetContnoGenerator) GeneratorFactory
				.getGenerator("GetContnoGenerator");
		Map paramMap = new HashMap();
		paramMap.put("brno", BctlService.getInstance().getBrnoByBrcode(
				GlobalInfo.getCurrentInstance().getBrcode()));
		paramMap.put("contType", contType);
		String contractno = getContnoGenerator.gen(paramMap);
		return contractno;
	}

	/**
	 * 生成合同编号(新规则) add 20100813 angelo.tian
	 *
	 * @param contTypeSmall
	 * @return
	 * @throws CommonException
	 */
	public String getContractnoNew(String contTypeSmall) throws CommonException {
		GetContnoGenerator getContnoGenerator = (GetContnoGenerator) GeneratorFactory
				.getGenerator("GetContnoGenerator");
		Map paramMap = new HashMap();
//		paramMap.put("brno", BctlService.getInstance().getBrnoByBrcode(
//				GlobalInfo.getCurrentInstance().getBrcode()));
		paramMap.put("contTypeSmall", contTypeSmall);
		String contractno = getContnoGenerator.genNew(paramMap);
		return contractno;
	}

	/**
	 * 生成从合同编号
	 *
	 * @param productCreditNo
	 * @param breedType
	 *            品种类型
	 * @param useType
	 *            使用方式
	 * @return productCreditno
	 * @throws CommonException
	 */
	public String getAContno(String contTypeSmal) throws CommonException {
		GetAcontnoGenerator getContnoGenerator = (GetAcontnoGenerator) GeneratorFactory
				.getGenerator("GetAcontnoGenerator");
		Map paramMap = new HashMap();
//		paramMap.put("brno", BctlService.getInstance().getBrnoByBrcode(
//				GlobalInfo.getCurrentInstance().getBrcode()));
//		paramMap.put("acontType", acontType);
		paramMap.put("contTypeSmall", contTypeSmal);
		String contractno = getContnoGenerator.gen(paramMap);
		return contractno;
	}


	/**
	 * 生成凭证编号
	 *
	 * @param productCreditNo
	 * @param breedType
	 *            品种类型
	 * @param useType
	 *            使用方式
	 * @return productCreditno
	 * @throws CommonException
	 */
	public String getCredenceno() throws CommonException {
		GetCredencenoGenerator getContnoGenerator = (GetCredencenoGenerator) GeneratorFactory
				.getGenerator("GetCredencenoGenerator");
		Map paramMap = new HashMap();
		paramMap.put("brno", BctlService.getInstance().getBrnoByBrcode(
				GlobalInfo.getCurrentInstance().getBrcode()));
		String contractno = getContnoGenerator.gen(paramMap);
		return contractno;
	}

	public String getCustInfractId() throws CommonException {
		GetCustomerInfractIdGenerator getCustomerInfractIdGenerator = (GetCustomerInfractIdGenerator) GeneratorFactory
				.getGenerator("GetCustomerInfractIdGenerator");
		String infractId = getCustomerInfractIdGenerator.gen(null);
		return infractId;
	}

	/**
	 * Description: 生成征信信息编号
	 *
	 * @param
	 * @return String
	 * @exception
	 * @author maidi
	 * @version v1.0,2008-9-2
	 */
	public String getCorpCreditId() throws CommonException {
		GetCorpCreditIdGenerator getCorpCreditIdGenerator = (GetCorpCreditIdGenerator) GeneratorFactory
				.getGenerator("GetCorpCreditIdGenerator");
		String creditId = getCorpCreditIdGenerator.gen(null);
		return creditId;
	}

	/**
	 * 生成贷款合同号
	 *
	 * @param brcode 申请机构
	 * @param lnid   贷款种类
	 * @return
	 * @throws CommonException
	 */
	public String getContractno(String brcode, String lnid)
			throws CommonException {
		GetContractnoGenerator getContractnoGenerator = (GetContractnoGenerator)GeneratorFactory.getGenerator("GetContractnoGenerator");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("brcode", brcode);
		paramMap.put("lnid", lnid);
		String contractno = getContractnoGenerator.gen(paramMap);
		return contractno;
	}


	/**
	 * 生成借据号
	 *
	 * @param contractno
	 * @param seqno
	 * @return
	 * @throws CommonException
	 */
	public String getCino(String contractno, short seqno)throws CommonException {
		GetCinoGenerator getCinoGenerator = (GetCinoGenerator)GeneratorFactory.getGenerator("GetCinoGenerator");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("contractno", contractno);
		paramMap.put("seqno", new Integer(seqno));
		String cino = getCinoGenerator.gen(paramMap);
		return cino;
	}

	/**
	 * 生成合作项目编号（4位机构号+2位年份+4位顺序号）
	 *
	 * @param brcode
	 *            申请机构
	 * @return
	 * @throws CommonException
	 */
	public String getProjectno(String brcode) throws CommonException {
		GetProjectnoGenerator getProjectnoGenerator = (GetProjectnoGenerator)GeneratorFactory.getGenerator("GetProjectnoGenerator");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("brcode", brcode);
		String projectno = getProjectnoGenerator.gen(paramMap);
		return projectno;
	}

	/**
	 * 生成预警编号
	 *
	 * @param brcode
	 *            预警机构
	 * @return
	 * @throws CommonException
	 */
	public String getWarningID(String brcode) throws CommonException {
		GetWarningIDGenerator getWarningIDGenerator = (GetWarningIDGenerator)GeneratorFactory.getGenerator("GetWarningIDGenerator");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("brcode", brcode);
		String warningID = getWarningIDGenerator.gen(paramMap);
		return warningID;
	}

	/**
	 * 生成楼盘编号
	 *
	 * @param brcode 申请机构
	 * @return
	 * @throws CommonException
	 */
	public String getHouseno(String brcode) throws CommonException {
		GetHousenoGenerator getHousenoGenerator = (GetHousenoGenerator)GeneratorFactory.getGenerator("GetHousenoGenerator");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("brcode", brcode);
		String houseno = getHousenoGenerator.gen(paramMap);
		return houseno;
	}


	/**
	 * 生成公积金帐号(特殊处理140101,140102)
	 *
	 * @param brcode  申请机构
	 * @param term    贷款期限
	 * @param lnid    贷款小类
	 * @return
	 * @throws CommonException
	 */

	public String getAccumFundActno(String brcode, String term, String lnid)
			throws CommonException {
		GetAccumFundActno2Generator GetAccumFundActno2Generator = (GetAccumFundActno2Generator)GeneratorFactory.getGenerator("GetAccumFundActno2Generator");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("brcode", brcode);
		paramMap.put("term", term);
		paramMap.put("lnid", lnid);
		String accumFundActno = GetAccumFundActno2Generator.gen(paramMap);
		return accumFundActno;
	}

	/**
	 * 生成核心交易请求流水
	 *
	 * @return
	 * @throws CommonException
	 */
	public int getCoreReqSeq() throws CommonException {
		GetCoreReqSeqGenerator getCoreReqSeqGenerator = (GetCoreReqSeqGenerator)GeneratorFactory.getGenerator("GetCoreReqSeqGenerator");
		String coreReqSeq = getCoreReqSeqGenerator.gen(null);
		return Integer.parseInt(coreReqSeq);


	}

	/**
	 * 101 客户经理 Description: 判断角色是否是客户经理
	 *
	 * @param roleId
	 *            角色ID
	 * @return boolean
	 * @exception
	 * @author HUJF
	 * @version v1.0,2010-11-8
	 */
	public boolean isCustomerManagerNew() throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List roleList = DAOUtils.getTlrRoleRelDAO().queryByCondition("po.tlrno='"+gi.getTlrno()+"'");
		for (int i = 0; i < roleList.size(); i++) {
			TlrRoleRel rel = (TlrRoleRel)roleList.get(i);
			if(SystemConstant.ROLE_CUST_MANAGER == rel.getRoleId() ){
				return true;
			}
		}
		return false;

	}
	/**
	 * 121 资产保全管户岗 Description: 判断角色是否是资产保全管户岗
	 *
	 * @param roleId
	 *            角色ID
	 * @return boolean
	 * @exception
	 * @author HUJF
	 * @version v1.0,2010-11-8
	 */
	public boolean isNpaManagerNew() throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List roleList = DAOUtils.getTlrRoleRelDAO().queryByCondition("po.tlrno='"+gi.getTlrno()+"'");
		for (int i = 0; i < roleList.size(); i++) {
			TlrRoleRel rel = (TlrRoleRel)roleList.get(i);
			if(SystemConstant.ROLE_NPA_MANAGER == rel.getRoleId() ){
				return true;
			}
		}
		return false;

	}

	/**
	 * 把贷款期限转化成实际的天数
	 *
	 * @param term
	 *            期限为10位
	 * @return
	 */
	public int getDaysNmByTerm(String term) {
		int theDaysOfYear = SystemConstant.DAYS_NUM_OF_YEAR;
		int theDaysOfMonth = SystemConstant.DAYS_NUM_OF_MONTH;
		// 贷款期限
		int totalDays = 0;
		int temYears = 0;
		int temMonths = 0;
		int temDays = 0;
		if (term.length() > 3 && term.substring(0, 3).compareTo("000") > 0) {
			temYears = new Integer(term.substring(0, 3)).intValue();
		}
		if (term.length() > 6 && term.substring(3, 6).compareTo("000") > 0) {
			temMonths = new Integer(term.substring(3, 6)).intValue();
		}
		if (term.length() > 6 && term.substring(6).compareTo("0000") > 0) {
			temDays = new Integer(term.substring(6)).intValue();
		}
		totalDays = temYears * theDaysOfYear + temMonths * theDaysOfMonth
				+ temDays;
		return totalDays;
	}

//del by zhaozhiguo
//	/**
//	 * 生成黑名单客户编号
//	 *
//	 * @author zhushijie add
//	 * @param brcode
//	 *            申请机构
//	 * @return
//	 * @throws AppException
//	 */
//	public String getBlackCustno(String brcode) throws AppException {
//		GetBlackCustnoGenerator getBlackCustnoGenerator = (GetBlackCustnoGenerator) GeneratorFactory
//				.getGenerator("GetBlackCustnoGenerator");
//		String blackcustno = getBlackCustnoGenerator.gen(brcode);
//		return blackcustno;
//	}
	/**
	 * 生成自然人客户内部编码
	 * @author zhushijie 2011-01-22 12:10:45
	 * @return
	 * @throws CommonException
	 */
	public synchronized String getIndvCustcd() throws CommonException {
		GetCustcdGenerator getIndvCustcdGenerator = (GetCustcdGenerator) GeneratorFactory
				.getGenerator("GetCustcdGenerator");
		Map paramMap = new HashMap();
		paramMap.put("custType", SystemConstant.CUST_TYPE_NATURAL);//自然人
		String indvCustcd = getIndvCustcdGenerator.gen(paramMap);
		return indvCustcd;
	}


	/**
	 * @desc: 生成贷款产品代码
	 * @param lntypeid
	 * @return
	 * @return: String
	 * @throws CommonException
	 * @Date: 2008-5-6
	 * @Author: farly.yu
	 */
	public String genLnid(String lntypeid) throws CommonException{
		GetLnidGenerator getLnidGenerator = (GetLnidGenerator) GeneratorFactory
				.getGenerator("GetLnidGenerator");
		if (lntypeid == null || lntypeid.length() <= 0) {
			lntypeid = "000";
		}
		String lnid = getLnidGenerator.gen(lntypeid);
		return lnid;
	}
	/**
	 * @desc: 生成内部操作员号
	 * @return
	 * @return: String
	 * @throws CommonException
	 * @Date: 2011-2-21
	 * @Author: lilinfeng
	 */
	public String genTlrIntNo() throws CommonException {
		GetTlrIntNoGenerator getTlrIntNoGenerator = (GetTlrIntNoGenerator) GeneratorFactory
				.getGenerator("GetTlrIntNoGenerator");
		return DataFormat.intToString(CommonService.getInstance().getSeqno(
				SystemConstant.VALUE_NO_TLRINTNO,SystemConstant.VALUE_INDEX), 8);

	}

	/**
	 * 生成授信贷款借据号
	 *
	 * @param contractno
	 * @param seqno
	 * @return
	 * @throws CommonException
	 */
	public String getCreditCino(String contractno, short seqno)
			throws CommonException {
		GetCreditCinoGenerator getCreditCinoGenerator = (GetCreditCinoGenerator) GeneratorFactory
				.getGenerator("GetCreditCinoGenerator");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("contractno", contractno);
		paramMap.put("seqno", new Integer(seqno));
		String creditCino = getCreditCinoGenerator.gen(paramMap);
		return creditCino;
	}

	public int getSeqno(String valueNoFk, String valueIndexAccount) throws CommonException, NumberFormatException {
		// TODO Auto-generated method stub
		return getSeqno(Integer.parseInt(valueNoFk),valueIndexAccount);
	}
	
	
	/**
	 *
	 * Description: TODO
	 * @param
	 * @return PfSysParam
	 * @exception
	 * @author Administrator
	 * @version v1.0,2008-11-15
	 */
	public String getSysParamDef(String paramId, String magicId, String defaultVal)
			throws CommonException {
		PfSysParamDAO pfSysParamDAO = DAOUtils.getPfSysParamDAO();
		PfSysParam param = pfSysParamDAO.query(magicId, paramId);
		if (param == null) {
			param = new PfSysParam();
		}
		if (StringUtils.isBlank(param.getParamValueTx())) {
			return defaultVal;
		} else {
			return param.getParamValueTx();
		}
	}
}
