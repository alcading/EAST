package com.huateng.report.bop.collection.getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopUDs;
import cn.cncc.cjdp.common.utils.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopUDsOperation;
import com.huateng.report.bop.collection.service.BopUDsService;

@SuppressWarnings("unchecked")
public class BopUDsCollectionGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "单位基本情况表管理查询");
			PageQueryResult pageQueryResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult getData() throws CommonException {
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String op = (String) map.get("op");
		if (StringUtils.equals(BopUDsOperation.CMD_NEW, op)) {
			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(Collections.emptyList());
			queryResult.setTotalCount(Collections.emptyList().size());
			return queryResult;
		} else if (StringUtils.equals(BopUDsOperation.CMD_MOD, op)
				|| StringUtils.equals(BopUDsOperation.CMD_DEL, op)
				|| StringUtils.equals(BopUDsOperation.CMD_DETAIL, op)) {
			String id = (String) map.get("id");
			BopUDsService service = BopUDsService.getInstance();
			MtsBopUDs bopu = service.loadBopU(id);

			List<MtsBopUDs>bopuList = new ArrayList<MtsBopUDs>(1);
			bopuList.add(bopu);
			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(bopuList);
			queryResult.setTotalCount(bopuList.size());
			return queryResult;
		} else {
			String qworkDateStart = (String) map.get("qworkDateStart");
			String qworkDateEnd = (String) map.get("qworkDateEnd");
			String qapproveStatus = (String) map.get("qapproveStatus");
			String qrepStatus = (String) map.get("qrepStatus");
			String qrecStatus = (String) map.get("qrecStatus");
			String qcustcode = (String) map.get("qcustcode");

			BopUDsService service = BopUDsService.getInstance();
			return service.queryBopUCollection(pageIndex, pageSize, qworkDateStart, qworkDateEnd, qapproveStatus, qrepStatus, qrecStatus, qcustcode);
		}
	}

}
