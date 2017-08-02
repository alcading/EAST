package com.huateng.ebank.business.parammng.cqGetter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.parammng.bean.LimitParamInfoView;
import com.huateng.ebank.business.parammng.operation.LimitParamOperation;
import com.huateng.ebank.entity.data.workflow.LimitParam;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class AurhoritySetCallGetter extends BaseGetter {


	public Result call() throws AppException{
		try
		{
		PageQueryResult pageResult = getData();
		ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
		result.setContent(pageResult.getQueryResult());
		result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
		result.init();
		return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}

	}

	protected PageQueryResult getData() throws Exception {

		PageQueryResult pageQueryResult = new PageQueryResult();
		String brcode =(String)getCommQueryServletRequest().getParameterMap().get("brcode");
		String tlrno =(String)getCommQueryServletRequest().getParameterMap().get("tlrno");
		/**mod by abudula at 20101118 start */
		String bizclass =(String)getCommQueryServletRequest().getParameterMap().get("bussType");
		String bizSubClass =(String)getCommQueryServletRequest().getParameterMap().get("bizType");
//		String loantype =(String)getCommQueryServletRequest().getParameterMap().get("loantype");
//		String projecttype =(String)getCommQueryServletRequest().getParameterMap().get("projecttype");

		OperationContext context = new OperationContext();
        context.setAttribute(LimitParamOperation.CMD,"SELECT");
        context.setAttribute(LimitParamOperation.IN_PARAM_BRCODE,brcode);
        context.setAttribute(LimitParamOperation.IN_PARAM_TLRNO,tlrno);
        context.setAttribute(LimitParamOperation.IN_PARAM_BIZCLASS,bizclass);
        context.setAttribute(LimitParamOperation.IN_PARAM_BIZ_SUBCLASS,bizSubClass);
        /**mod by abudula at 20101118 start */
//        context.setAttribute(LimitParamOperation.IN_PARAM_LOANTYPE,loantype);
//        context.setAttribute(LimitParamOperation.IN_PARAM_PROJECTTYPE,projecttype);

        OPCaller.call("parammng.LimitParamOP", context);
        Iterator outParam = (Iterator)context.getAttribute(LimitParamOperation.OUT_PARAM);
		List list1 = new ArrayList();

		while (outParam.hasNext()) {
			LimitParam limitParam = (LimitParam) outParam.next();
			LimitParamInfoView infoview = new LimitParamInfoView();
			//			id
			infoview.setId(String.valueOf(limitParam.getId()));
			//			操作员号
			infoview.setTlrno(limitParam.getTlrno());
			//流程
			infoview.setBussType(limitParam.getBizClass());
			//业务品种
			infoview.setBizType(limitParam.getBizSubclass());
			//业务品种
			infoview.setBizTypeName(limitParam.getBizSubclass());

//			String bizclassname =DataDicService.getInstance().getNameByTypeNo(
//          SystemConstant.DATADIC_TYPE_LIMIT_TYPE,
//          limitParam.getBizClass());
//	        infoview.setBizclassname(bizclassname);
			//以下逻辑 yjw 修改
			//			审批类型
//			if(limitParam.getBizClass().equals(SystemConstant.LIMIT_PARAM_BIZ_CLASS_LOAN))
//			{//1-贷款业务  数据库中 bizSubclass 放的是贷款大类
// 				infoview.setBizsubclass(limitParam.getBizSubclass());
// 				//为了编译通过而注释
//// 				infoview.setBizsubclassname(ParamMngService.getInstance()
//// 						.getLntypeName(limitParam.getBizSubclass()));
//
//				infoview.setProjecttype("");
//			}else if(limitParam.getBizClass().equals(SystemConstant.LIMIT_PARAM_BIZ_CLASS_PROJ))
//			{//2-合作项目  数据库中 bizSubclass 放的是合作项目
//				infoview.setBizsubclass("");
//				infoview.setProjecttype(limitParam.getBizSubclass());
//			}	else
//			{
//			    infoview.setProjecttype("");
//			    infoview.setBizsubclass("");
//			}
			infoview.setApprovemode(limitParam.getLimitMode());
			infoview.setLimitMaxamount(limitParam.getLimitMaxamount().doubleValue());
			infoview.setLimitMinamount(limitParam.getLimitMinamount().doubleValue());
			infoview.setPrecondition(limitParam.getPrecondition());
			infoview.setStatus(limitParam.getStatus());
			infoview.setEffectdate(limitParam.getEffectDate());
			infoview.setExpiredate(limitParam.getExpireDate());
			list1.add(infoview);
		}
		pageQueryResult.setTotalCount(list1.size());
		pageQueryResult.setQueryResult(list1);
		return pageQueryResult;


	}

}


