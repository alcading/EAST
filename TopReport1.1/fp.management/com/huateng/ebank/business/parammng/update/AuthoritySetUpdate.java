package com.huateng.ebank.business.parammng.update;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.parammng.bean.LimitParamInfoView;
import com.huateng.ebank.business.parammng.operation.LimitParamOperation;
import com.huateng.ebank.entity.data.workflow.LimitParam;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author yjw
 *
 */
public class AuthoritySetUpdate extends BaseUpdate {


	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("parammng_AuthoritySet3"); // parammng_AuthoritySet改为parammng_AuthoritySet3
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();
			List noneList = new ArrayList();

			LimitParamInfoView bean1 = null;
			while (updateResultBean.hasNext()) {
				bean1 = new LimitParamInfoView();
				LimitParam bean = new LimitParam();
				mapToObject(bean1, updateResultBean.next());
//				if (!DataFormat.isEmpty(bean1.getId()))
//					bean.setId(Long.parseLong(bean1.getId()));
//				bean.setTlrno(bean1.getTlrno());
//				bean.setBizClass(bean1.getBizclass());
				// yjw modify begin
				// 如果审批类型选择的是贷款类型，bizsubclass字段放的是贷款大类，如果审批类型是合作项目，bizsubclass字段放的是项目类型
				// bean.setBizSubclass(bean1.getBizsubclass());
//				if (bean1.getBizsubclass().equals("")
//						&& bean1.getProjecttype().equals("")) {
//					ExceptionUtil.throwCommonException("贷款种类和合作项目种类必输一项",
//							ErrorCode.ERROR_CODE_LOAN_PARAM);
//				}
//				if (bean1.getBizsubclass() != null
//						&& !bean1.getBizsubclass().equals("")) {
//
////					bean.setBizSubclass(bean1.getBizsubclass());
//				} else if (bean1.getProjecttype() != null
//						&& !bean1.getProjecttype().equals("")) {
//					// //add by chenjz 20080925
//					// ：当审批类型选择为2-合作项目时，且合作项目类型选为0-不限，将其翻译成'000‘保存数据库中
//					// if
//					// (SystemConstant.LIMIT_PARAM_BIZ_CLASS_PROJ.equals(bean1.getBizclass())
//					// && SystemConstant.PROJECT_TYPE_ALL.equals(bean1
//					// .getProjecttype().trim())) {// 合作项目
//					//
//					// bean.setBizSubclass("000");
//					// }else
////					bean.setBizSubclass(bean1.getProjecttype());
//				}
				// yjw modify end

				bean.setLimitMode("1");
				bean.setTlrno(bean1.getTlrno());
				bean.setBizClass(bean1.getBussType());
				bean.setBizSubclass(bean1.getBizType().trim().equals("") ? "0000" : bean1.getBizType().trim());
				//没有projecttype
//				bean.set
				bean.setLimitMaxamount(BigDecimal.valueOf(bean1.getLimitMaxamount()));
				bean.setLimitMinamount(BigDecimal.valueOf(1));
				bean.setPrecondition(bean1.getPrecondition());
				bean.setEffectDate(bean1.getEffectdate());
				bean.setExpireDate(bean1.getExpiredate());
				bean.setStatus(bean1.getStatus());

				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(bean);
					break;
				case UpdateResultBean.DELETE:
					bean.setId(Long.parseLong(bean1.getId()));
					delList.add(bean);
					break;
				case UpdateResultBean.MODIFY:
					bean.setId(Long.parseLong(bean1.getId()));
					updateList.add(bean);
					break;
				default:
					break;
				}
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(LimitParamOperation.DELETE_LIST, delList);
			oc.setAttribute(LimitParamOperation.INSERT_LIST, insertList);
			oc.setAttribute(LimitParamOperation.NONE_LIST, noneList);
			oc.setAttribute(LimitParamOperation.UPDATE_LIST, updateList);
			// 修改操作
			oc.setAttribute(LimitParamOperation.CMD, "DB");
			OPCaller.call("parammng.LimitParamOP", oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
