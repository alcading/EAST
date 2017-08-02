/* ================================================================== *
 * The Huateng Software License
 *
 *  Copyright (c) 2004-2005 Huateng Software System.  All rights
 *  reserved.
 *  ==================================================================
 */
package com.huateng.ebank.business.parammng.operation;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import resource.bean.pub.TlrInfo;
import resource.dao.pub.TlrInfoDAO;
import resource.dao.pub.TlrRoleRelDAO;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.entity.dao.workflow.LimitParamDAO;
import com.huateng.ebank.entity.data.workflow.LimitParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author wuguangjie 审批权限设置 TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */
public class LimitParamOperation extends BaseOperation {

	public static final String DELETE_LIST = "DELETE_LIST";

	public static final String INSERT_LIST = "INSERT_LIST";

	public static final String UPDATE_LIST = "UPDATE_LIST";

	public static final String NONE_LIST = "NONE_LIST";

	public static final String CMD = "CMD";

	public static final String LIMIT_PARAM = "LIMIT_PARAM";

	public static final String IN_PARAM = "IN_PARAM";

	public static final String OUT_PARAM = "OUT_PARAM";

	public static final String IN_PARAM_BRCODE = "IN_PARAM_BRCODE";

	public static final String IN_PARAM_TLRNO = "IN_PARAM_TLRNO";

	public static final String IN_PARAM_BIZCLASS = "IN_PARAM_BIZCLASS";

	public static final String IN_PARAM_LOANTYPE = "IN_PARAM_LOANTYPE";

	public static final String IN_PARAM_PROJECTTYPE = "IN_PARAM_PROJECTTYPE";

	public static final String IN_PARAM_BIZ_SUBCLASS="IN_PARAM_BIZ_SUBCLASS";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {

		//LimitParamDAO lninfoDao = DAOUtils.getLimitParamDAO();
		String cmd = (String) context.getAttribute(LimitParamOperation.CMD);
		// 查询所有岗位信息
		if (cmd.equals("SELECT")) {

//			List resultList = new ArrayList();
//			List typeList = new ArrayList();
//			List objList = new ArrayList();
//			String brcode = (String) context
//					.getAttribute(LimitParamOperation.IN_PARAM_BRCODE);
			String tlrno = (String) context
					.getAttribute(LimitParamOperation.IN_PARAM_TLRNO);
			String bizClass = (String) context
					.getAttribute(LimitParamOperation.IN_PARAM_BIZCLASS);
//			String loantype = (String) context
//					.getAttribute(LimitParamOperation.IN_PARAM_LOANTYPE);
//			String projecttype = (String) context
//					.getAttribute(LimitParamOperation.IN_PARAM_PROJECTTYPE);
			String bizSubClass = (String) context
					.getAttribute(LimitParamOperation.IN_PARAM_BIZ_SUBCLASS);

			StringBuffer hqlstr = new StringBuffer(512);
			hqlstr.append("select lp ").append(
					"from LimitParam as lp, TlrInfo as po ").append(
					"where lp.status = '").append(
					SystemConstant.VALID_FLAG_VALID).append(
					"' and lp.tlrno = po.tlrno");

			if (!DataFormat.isEmpty(tlrno)) {
				hqlstr.append(" and lp.tlrno = '").append(
						DataFormat.trim(tlrno)).append("' ");
			}

			if (!DataFormat.isEmpty(bizClass)) {// 如果审批类型的条件选上了
				hqlstr.append(" and lp.bizClass = '").append(
						DataFormat.trim(bizClass)).append("' ");
			}
			if (!DataFormat.isEmpty(bizSubClass)) {// 如果审批类型的条件选上了
				hqlstr.append(" and lp.bizSubClass = '").append(
						DataFormat.trim(bizSubClass)).append("' ");
			}

			hqlstr.append(" order by lp.tlrno, lp.bizClass, lp.bizSubclass ");
			String hql = hqlstr.toString();
			Iterator iter = DAOUtils.getHQLDAO().queryByQL(hql);
//			List list = new ArrayList();
//			while (iter.hasNext()) {
//				LimitParam lp = (LimitParam) iter.next();
//				list.add(lp);
//			}
			context.setAttribute(LimitParamOperation.OUT_PARAM, iter);
		} else {// db 更新
			List deleteList = (List) context
					.getAttribute(LimitParamOperation.DELETE_LIST);
			List updateList = (List) context
					.getAttribute(LimitParamOperation.UPDATE_LIST);
			List insertList = (List) context
					.getAttribute(LimitParamOperation.INSERT_LIST);
			List noneList = (List) context
					.getAttribute(LimitParamOperation.NONE_LIST);

			save(deleteList, updateList, insertList, noneList);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {

	}

	private void save(List deleteList, List updateList, List insertList,
			List noneList) throws CommonException {
		LimitParamDAO lpDao = DAOUtils.getLimitParamDAO();
		LimitParam lp;
		if (deleteList.size() > 0) {
			Iterator delit = deleteList.iterator();
			for (; delit.hasNext();) {
				lp = (LimitParam) delit.next();

				long id = lp.getId();
				LimitParam limitInfo1 = null;
				if (id != 0) {
					limitInfo1 = lpDao.query(id);
				} else {
					return;
				}
//				limitInfo1.setStatus("0");
//				limitInfo1.setExpireDate(GlobalInfo.getCurrentInstance()
//						.getTxdate());
				lpDao.delete(limitInfo1);
			}
		}
		DAOUtils.getHQLDAO().flush();

		if (updateList.size() > 0) {
			Iterator updit = updateList.iterator();
			for (; updit.hasNext();) {
				lp = (LimitParam) updit.next();

				LimitParam limitInfo1 = lpDao.query(lp.getId());
				limitInfo1.setTlrno(lp.getTlrno());
				limitInfo1.setBizClass(lp.getBizClass());
				limitInfo1.setBizSubclass(lp.getBizSubclass());
				limitInfo1.setLimitMaxamount(lp.getLimitMaxamount());
				limitInfo1.setLimitMinamount(lp.getLimitMinamount());
				limitInfo1.setLimitMode("1");
				limitInfo1.setPrecondition(lp.getPrecondition());
				lpDao.update(limitInfo1);
			}
		}
		DAOUtils.getHQLDAO().flush();

		if (insertList.size() > 0) {
			checkTrlRole(insertList);
			Date date = GlobalInfo.getCurrentInstance().getTxdate();
			Date date1 = DataFormat.stringToDate("2099-12-31");

			Iterator insit = insertList.iterator();
			for (; insit.hasNext();) {
				lp = (LimitParam) insit.next();
				LimitParam lpQuery = DAOUtils.getLimitParamDAO().query(
						lp.getTlrno(), Integer.parseInt(lp.getBizClass()), lp.getBizSubclass(),"1");
				if (lpQuery == null) {
					// ?0?1 若该操作员的权限信息不存在，则新增
					lp.setEffectDate(date);
					lp.setExpireDate(date1);
					lp.setStatus(SystemConstant.VALID_FLAG_VALID);
					lpDao.insert(lp);
				} else {
					String message = "该组信息已经存在,请勿重复添加[操作员号,流程,业务品种]=["
						+ lp.getTlrno() + "," + lp.getBizClass() + ","
						+ lp.getBizSubclass() + "]";
					ExceptionUtil.throwCommonException(message,
						ErrorCode.ERROR_CODE_DUP_INSERT);
//					// ?0?1 若该操作员的权限信息存在，
//					if (lpQuery.getStatus().equals(
//							SystemConstant.VALID_FLAG_INVALID)) {// 如果是删除导致status变为
//																	// 0
//																	// ，则用update
//						lpQuery.setLimitMode(lp.getLimitMode());
//						lpQuery.setLimitMaxamount(lp.getLimitMaxamount());
//						lpQuery.setEffectDate(date);
//						lpQuery.setExpireDate(date1);
//						lpQuery.setMisc("");
//						lpQuery.setStatus(lp.getStatus().substring(0, 1));
//						lpDao.update(lpQuery);
					}
				}
			}
		DAOUtils.getHQLDAO().flush();

	}

	private void checkTrlRole(List list) throws CommonException {
		TlrInfoDAO tiDao = DAOUtils.getTlrInfoDAO();
		TlrRoleRelDAO trrDao = DAOUtils.getTlrRoleRelDAO();
		String brcode = GlobalInfo.getCurrentInstance().getBrcode();

		LimitParam lp = null;
		for (int i = 0; i < list.size(); i++) {
			lp = (LimitParam) list.get(i);
			// 检查该柜员是否存在
			String tlrno = lp.getTlrno();
			try {
				TlrInfo t= tiDao.query(tlrno);
				if(t== null){
					ExceptionUtil.throwCommonException("添加新纪录中的[操作员号]=[" + tlrno
							+ "]不存在", ErrorCode.ERROR_CODE_NO_TLRNO_EXIST);
				}
			} catch (Exception e) {

				ExceptionUtil.throwCommonException("添加新纪录中的[操作员号]=[" + tlrno
						+ "]不存在", ErrorCode.ERROR_CODE_NO_TLRNO_EXIST);
			}

			// 检查roleid 和 是否是本行管辖内的
			// List trrList = trrDao.queryByCondition("po.tlrno = '" + tlrno
			// + "' and (po.roleId = 105 or po.roleId = 120)");

//			List roleInfoList = TellerService.getInstance()
//					.getTellerRoleInfoList(tlrno);
//
//			// if (trrList == null || trrList.size() == 0) {
//			// ExceptionUtil.throwCommonException(
//			// "该操作员[" + tlrno + "]不具备审批角色",
//			// ErrorCode.ERROR_CODE_NO_RIGHT_ROLEID);
//			// }
//
//			String bizclass = lp.getBizClass();
//			int roleid = 0;
//			if (bizclass.equals(SystemConstant.LIMIT_PARAM_BIZ_CLASS_LOAN)) {
//				// 贷款业务（贷款审批岗以及贷审会审批岗）
//				boolean isLoanApprove = false;
//				for (int k = 0; k < roleInfoList.size(); k++) {
//					RoleInfo roleInfo = (RoleInfo) roleInfoList.get(k);
//					if (roleInfo.getRoleType().equals(
//							SystemConstant.ROLE_TYPE_APPROVE)
//							|| roleInfo.getRoleType().equals(
//									SystemConstant.ROLE_TYPE_COUNCIL_APPROVE)) {
//						isLoanApprove = true;
//						roleid = roleInfo.getRoleId();
//						break;
//					}
//				}
//				if (!isLoanApprove) {
//					ExceptionUtil.throwCommonException("该操作员[" + tlrno
//							+ "]不具备审批贷款业务角色",
//							ErrorCode.ERROR_CODE_NO_RIGHT_ROLEID);
//				}
//
//				// 检查机构是否是本行管辖内的
//				String tlrBrcode = TellerService.getInstance()
//						.getBrcodeByTlrRole(tlrno, roleid);
//				if (!brcode.equals(tlrBrcode)
//						&& !BctlService.getInstance().isBlnBrcode(tlrBrcode,
//								brcode)) {
//
//					ExceptionUtil.throwCommonException("该操作员[" + tlrno
//							+ "]不在本行管辖内", ErrorCode.ERROR_CODE_NO_RANGE);
//				}
//
//			} else if (bizclass
//					.equals(SystemConstant.LIMIT_PARAM_BIZ_CLASS_PROJ)) {
//				boolean isProjApprove = false;
//				for (int k = 0; k < roleInfoList.size(); k++) {
//					RoleInfo roleInfo = (RoleInfo) roleInfoList.get(k);
//					if (roleInfo.getRoleType().equals(
//							SystemConstant.ROLE_TYPE_PROJ_APPROVE)) {
//						isProjApprove = true;
//						roleid = roleInfo.getRoleId();
//						break;
//					}
//				}
//				if (!isProjApprove) {
//					ExceptionUtil.throwCommonException("该操作员[" + tlrno
//							+ "]不具备审批合作项目角色",
//							ErrorCode.ERROR_CODE_NO_RIGHT_ROLEID);
//				}
//				// 检查机构是否是本行管辖内的
//				String tlrBrcode = TellerService.getInstance()
//						.getBrcodeByTlrRole(tlrno, roleid);
//				if (!brcode.equals(tlrBrcode)
//						&& !BctlService.getInstance().isBlnBrcode(tlrBrcode,
//								brcode)) {
//
//					ExceptionUtil.throwCommonException("该操作员[" + tlrno
//							+ "]不在本行管辖内", ErrorCode.ERROR_CODE_NO_RANGE);
//				}
//
//			}

			// else if (bizclass
			// .equals(SystemConstant.LIMIT_PARAM_BIZ_CLASS_ALL)) {
			// //全部
			// boolean flag105 = false;
			// boolean flag120 = false;
			// for (int k = 0; k < trrList.size(); k++) {
			// TlrRoleRelation trr = (TlrRoleRelation) trrList.get(k);
			// if (trr.getRoleId() == 105) {
			// flag105 = true;
			// }
			// if (trr.getRoleId() == 120) {
			// flag120 = true;
			//
			// }
			// if (flag105 && flag120)
			// break;
			// }
			// if (!flag105 || !flag120 ) {
			//
			// ExceptionUtil.throwCommonException("该操作员["+tlrno+"]不具备审批全部角色",
			// ErrorCode.ERROR_CODE_NO_RIGHT_ROLEID);
			// }
			// //检查机构是否是本行管辖内的
			// String tlrBrcode =
			// TellerService.getInstance().getBrcodeByTlrRole(tlrno,105);
			// if(!brcode.equals(tlrBrcode)&&!BctlService.getInstance().isBlnBrcode(tlrBrcode,brcode))
			// {
			//
			// ExceptionUtil.throwCommonException("该操作员["+tlrno+"]不在本行管辖内",
			// ErrorCode.ERROR_CODE_NO_RANGE);
			// }
			// }

		}
	}
}