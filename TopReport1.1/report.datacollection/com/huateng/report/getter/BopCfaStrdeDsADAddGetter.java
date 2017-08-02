package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaStrdeDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopCfaStrdeDsService;
import com.huateng.report.update.BopCfaDofoexloDsUpdate;
import com.huateng.report.utils.ReportUtils;

@SuppressWarnings("unchecked")
public class BopCfaStrdeDsADAddGetter extends BaseGetter {
	private static final String ADD = "add";
	private static final String MOD = "mod";
	private static final String DEL = "del";
	private static final String DETAIL = "detail";

	public Result call() throws AppException {
		try {
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

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {
		Map paramsMap = getCommQueryServletRequest().getParameterMap();
		String op = (String) paramsMap.get("op");

		if(ADD.equals(op)) {
			//新增
			//产生人民币结构性存款编号
			String strdecode = ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_CFA_FA);
			BopCfaStrdeDs bopCfaStrdeDs = new BopCfaStrdeDs();
			bopCfaStrdeDs.setStrdecode(strdecode);
			List list = new ArrayList();
			list.add(bopCfaStrdeDs);

			PageQueryResult pageQueryResult = new PageQueryResult();
			pageQueryResult.setQueryResult(list);
			return pageQueryResult;
		}
		if(MOD.equals(op) || DEL.equals(op) || DETAIL.equals(op)) {
			//修改和删除
			String rec_id = (String) paramsMap.get("id");
			if (StringUtils.isNotBlank(rec_id)) {

				BopCfaStrdeDsService service = BopCfaStrdeDsService.getInstance();
				BopCfaStrdeDs bopcfastrdeds = service.queryByIdReturnBean(rec_id);
				if (StringUtils.equals(MOD, op)) {
					bopcfastrdeds.setActiondesc(null);
					if (StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO, bopcfastrdeds.getSubSuccess())) {
						bopcfastrdeds.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					} else {
						bopcfastrdeds.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
					}
				} else if(StringUtils.equals(op, BopCfaDofoexloDsUpdate.OPERATION_DELETE)){
					bopcfastrdeds.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
				}
				if (StringUtils.equals(op, MOD)
						|| StringUtils.equals(op, DEL)){
					bopcfastrdeds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopcfastrdeds.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopcfastrdeds.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
				}

				List<BopCfaStrdeDs>list = new ArrayList<BopCfaStrdeDs>();
				list.add(bopcfastrdeds);
				PageQueryResult queryResult = new PageQueryResult();
				queryResult.setQueryResult(list);
				queryResult.setTotalCount(list.size());
				return queryResult;
			}
		}
		return null;
	}
}