package com.huateng.report.bop.collection.getter;

import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.service.BopAgDsRecordService;

/**
 *
 * 国际收支涉外收入申报单基础信息拾取查询
 * 
 * @author sujian.zhu
 *
 */
@SuppressWarnings("unchecked")
public class BopADsLoadPageGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
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

	public PageQueryResult getData() throws AppException {
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();
		setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "国际收支信息补录-涉外收入申报单-基础信息拾取查询");
		
		String qworkDateStart = map.get("qworkDateStart");
		String qworkDateEnd = map.get("qworkDateEnd");
		String qrptno = map.get("qrptno");
		String qfiller2 = map.get("qfiller2");
		//只能查当前机构号
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String qbrNo = globalInfo.getBrno();
		BopAgDsRecordService bopAgDsService = BopAgDsRecordService.getInstance();
		return bopAgDsService.queryBOPAForG(pageIndex, pageSize, qworkDateStart, qworkDateEnd, qrptno, qfiller2, qbrNo);
	}
}
