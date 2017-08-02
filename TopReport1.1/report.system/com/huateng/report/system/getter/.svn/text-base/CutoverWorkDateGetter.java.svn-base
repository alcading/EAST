package com.huateng.report.system.getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.system.bean.CutoverWorkDateBean;
import com.huateng.report.system.service.BiWorkDateService;

/**
 * 
 * @author shishu.zhang
 *	
 * 2012-8-15上午10:54:59
 */
public class CutoverWorkDateGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "工作日期切换查询");
			
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			List<CutoverWorkDateBean> list = new ArrayList<CutoverWorkDateBean>(); 
			CutoverWorkDateBean cutoverWorkDateBean = new CutoverWorkDateBean();
			
			Date currentdate = DateUtil.getTbsDay();
			Date lastDate = DateUtil.getBhDate();
			cutoverWorkDateBean.setLastDate(lastDate);
			cutoverWorkDateBean.setCurrentDate(currentdate);
			Date nextDate = BiWorkDateService.getInstance().getNextWorkDateByCurDate(currentdate);
			cutoverWorkDateBean.setNextDate(nextDate);
			
			list.add(cutoverWorkDateBean);
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list,
					getResult());
			result.setContent(list);
			result.getPage().setTotalPage(1);
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
}
