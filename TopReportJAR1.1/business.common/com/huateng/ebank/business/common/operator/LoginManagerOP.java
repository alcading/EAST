/*
 * $Header: /home/plis/batch/cvs/cvsdvp/BocomplJAR/JavaSource/com/huateng/bocompl/common/LoginManagerOP.java,v 1.32 2005/06/22 06:44:37 wu_zhiqiang Exp $
 * $Revision: 1.32 $
 * $Date: 2005/06/22 06:44:37 $
 *
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.business.common.operator;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import resource.bean.pub.Bctl;
import resource.bean.pub.FunctionInfo;
import resource.bean.pub.Globalinfo;
import resource.bean.pub.RoleInfo;
import resource.dao.pub.GlobalinfoDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.service.pub.UserMgrService;

/**
 * 用户登陆操作
 *
 * @author James wu
 * @version 1.0.0
 */

public class LoginManagerOP extends BaseOperation {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginManagerOP.class);

	// KEY值定义，包括输入IN 和输出OUT

	public static final String ID = "Management.LoginManagerOP";
	public static final String IN_TLR_NO = "TLR_NO";
	public static final String IN_TLR_PWD = "TLR_PWD";
	public static final String IN_GLOBALINFO = "IN_GLOBALINFO";
	public static final String OUT_USER_SESSION_INFO = "USER_SESSION_INFO";
	public static final String OUT_GLOBALINFO_INFO = "GLOBALINFO";

	public static final String CONTEXT_PATH = "CONTEXT_PATH";
	public static final String OUT_TREE = "TREE_FUNCTION";
	public static final String OUT_MENU = "MENU_FUNCTION";

	public static final String IN_TLR_BRNO = "IN_TLR_BRNO";
	public static final String IN_TLR_BRCODE = "IN_TLR_BRCODE";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// 判断系统状态
		GlobalinfoDAO globalinfoDAO = BaseDAOUtils.getGlobalinfoDAO();
		Globalinfo gi = globalinfoDAO.query(SystemConstant.TABLE_GLOBAL_INFO_ID);
		String batchStatus = DataFormat.trim(gi.getStatus());
		if (!batchStatus.equals(SystemConstant.GLOBAL_INFO_STATE_ONLINE)) { // 批量状态
			ExceptionUtil.throwCommonException("系统处于批量状态, 请等待批量结束后再试.",
					ErrorCode.ERROR_CODE_GLOBALINFO_BATCH);
		}
		Date currentdate = DateUtil.getTbsDay();
		Date lastDate = DateUtil.getBhDate();
		// 判断用户登录信息是否符合
		GlobalInfo globalInfo = (GlobalInfo) context.getAttribute(LoginManagerOP.IN_GLOBALINFO);
		globalInfo.setTxdate(DataFormat.trsUtilDateToSqlDate(currentdate));
		globalInfo.setFileDate(DateUtil.dateToNumber(currentdate));

		globalInfo.setLastDate(lastDate);
		GlobalInfo.setCurrentInstance(globalInfo);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.BaseOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {

		GlobalInfo globalInfo=GlobalInfo.getCurrentInstance();

		String userID = (String) context.getAttribute(LoginManagerOP.IN_TLR_NO);

		String userPwd = (String) context.getAttribute(LoginManagerOP.IN_TLR_PWD);

		String userBrcode = (String) context.getAttribute(IN_TLR_BRCODE);


		if (DataFormat.isEmpty(userBrcode) || userBrcode.equals("-1")) {
			globalInfo.setBrno(null);
			ExceptionUtil.throwCommonException("请选择登录机构");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("logicProc() - String userID=" + userID); //$NON-NLS-1$
		}
		if (logger.isDebugEnabled()) {
			logger.debug("logicProc() - String userPwd=" + userPwd); //$NON-NLS-1$
		}
		UserMgrService userMgrService = new UserMgrService();
		// 用户校验\保存用户会话信息
		UserSessionInfo sessionInfo = userMgrService.loginUserSessionInfo(userID, userPwd, userBrcode);
		// 保存会计日期
		sessionInfo.setTxDate( globalInfo.getTxdate());
		// 设定用户信息
		userMgrService.setLoginInInfo(userID);

		// 设定全局信息
		globalInfo.setBrcode(sessionInfo.getBrCode());
		// 设置工作流岗位号
		if( !sessionInfo.getWorkflowRoles().isEmpty() ){
			globalInfo.setWorkflowRoleId(((RoleInfo)sessionInfo.getWorkflowRoles().toArray()[0]).getId().toString());
		}

//		Iterator roleIt = sessionInfo.getUserRoles().iterator();
//		List roleList = new ArrayList();
//		while (roleIt.hasNext()) {
//			roleList.add(new Integer(Integer.parseInt(roleIt.next().toString())));
//		}
//		globalInfo.setUserRoles(roleList);
		/* . */

		// 获得用户的分行号, 如果是总行, 设置为本身
		BctlService bctlService = BctlService.getInstance();
		Bctl bctl = bctlService.getBctlByBrcode(globalInfo.getBrcode());

		/**modify by xiaojian.yu STL-80  bug修复 20101125 start**/
//		if(bctl.getBrclass().equals(SystemConstant.BRCODE_CLASS_HEAD)){
//			globalInfo.setBranchBrcode(bctl.getBrclass());
//		}else{
//			globalInfo.setBranchBrcode(bctl.getBlnBranchBrcode());
//		}
		globalInfo.setBranchBrcode(bctl.getBlnBranchBrcode());
		/**modify by xiaojian.yu STL-80  bug修复 20101125 end**/

		//设置分行级别
//		globalInfo.setBrClass(bctl.getBlnBranchClass());
		//设置机构级别
		globalInfo.setBrClass(bctl.getBrclass());
		//设置外部机构号
		globalInfo.setBrno(bctl.getBrno());
		//设置机构名称
		globalInfo.setBrName(bctl.getBrname());
		//设置操作员 add by shao_mying
		globalInfo.setTlrno(userID);
		//设置地区码
//		globalInfo.setArea(bctl.getRegionalism());
		//设置ContextPath
		globalInfo.setSContextPath((String)context.getAttribute(CONTEXT_PATH));

		//记录查询日志参数
		String saveQeuryLog = CommonService.getInstance().getSysParamDef("PSWD", "SAVE_QUERY_LOG", "0");
		globalInfo.setSaveQueryLog(saveQeuryLog);

		// 获取用户的管理分行,如果是总行，设置为本身
		/*
		String manageBrcode = bctlService.getBranchManageBrcode(globalInfo.getBrcode());
		globalInfo.setBranchMngBrcode(manageBrcode);
		*/
		// 设置当前机构是否为总行
		//globalInfo.setHeadBrcode(bctlService.isHeadBrcode(globalInfo.getBrcode()));

		List<FunctionInfo> userRoleFunclist = userMgrService.getUserFunctions(userID);
//		List<FunctionInfo> resultFuncList = new ArrayList();


		// 设置返回值
		context.setAttribute(LoginManagerOP.OUT_USER_SESSION_INFO, sessionInfo);
		context.setAttribute(LoginManagerOP.OUT_GLOBALINFO_INFO, globalInfo);
		if (logger.isDebugEnabled()) {
			logger.debug("logicProc() - end"); //$NON-NLS-1$
		}
		//组装菜单
		StringBuffer tree = new StringBuffer();
		StringBuffer menu = new StringBuffer();

		//1:查找机构的功能列表

		//2:比对用户的功能列表和机构的功能列表 遍历方式
		//modi by ningpeng 20120823 去除机构权限

//		List branchFunctions = userMgrService.getBranchFuctions(bctl.getBrcode());
//		if(CollectionUtils.isEmpty(branchFunctions)){
//			throw new CommonException("没有该机构可以操作的业务");
//		}
		if(CollectionUtils.isEmpty(userRoleFunclist)){
			ExceptionUtil.throwCommonException("没有该用户可以操作的业务！");
		}
//		for (int i=0; i<userRoleFunclist.size();i++) {
//			FunctionInfo userFunction  = userRoleFunclist.get(i);
//			 for (Iterator iterator = branchFunctions.iterator(); iterator
//					.hasNext();) {
//				 FunctionInfo branchFunction = (FunctionInfo) iterator.next();
//				if(userFunction.getId().equals(branchFunction.getId())){
//					resultFuncList.add(userFunction);
//					break;
//				}
//			}
//
//		}
		//是否可进行主管确认操作
		List<FunctionInfo> confrimList = userMgrService.getApproveUserFunc(userRoleFunclist);
		globalInfo.setConfrimCodeList(confrimList);


		globalInfo.setAllFunctions(CommonFunctions.transToHashtableByFunc(userRoleFunclist));
		GlobalInfo.setCurrentInstance(globalInfo);

		tree.append(CommonFunctions.getRoleFunction(SystemConstant.TREE_ROOT, userRoleFunclist, SystemConstant.TREE_TREE_FLAG));
		if(tree.length() != 0)
			tree.deleteCharAt(tree.length()-1);
		menu.append(CommonFunctions.getRoleFunction(SystemConstant.TREE_ROOT, userRoleFunclist, SystemConstant.TREE_MENU_FLAG));
		if(menu.length() != 0)
			menu.deleteCharAt(menu.length()-1);


		context.setAttribute(LoginManagerOP.OUT_TREE, tree);
		context.setAttribute(LoginManagerOP.OUT_MENU, menu);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.BaseOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
	}

}
