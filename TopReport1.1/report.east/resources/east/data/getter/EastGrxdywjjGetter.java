package resources.east.data.getter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import east.utils.tools.DBUtil;
import resources.east.data.service.EastGrxdywjjService;

@SuppressWarnings("unchecked")
public class EastGrxdywjjGetter extends BaseGetter {
	/*
	 * 获取列表
	 * 
	 * @author 
	 */
	@Override
	public Result call() throws AppException {
		try {

			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "个人信贷业务借据");

			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	private PageQueryResult getData() throws CommonException {
		
	    Map para = this.getCommQueryServletRequest().getParameterMap();
	   	
	    String cjrq = (String)para.get("cjrq");
	   	
	    String xdhth = (String)para.get("xdhth");
	   	
	    String xdjjh = (String)para.get("xdjjh");
	    
	    String khmc = (String)para.get("khmc");
	    
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("from EastGrxdywjj A where rownum<="+DBUtil.ROWNUM);
		
		if(StringUtils.isNotBlank(xdjjh)){
			hql.append(" and A.id.xdjjh = '"+xdjjh.trim()+"' ");
		}
		if(StringUtils.isNotBlank(xdhth)){
			hql.append(" and A.xdhth = '"+xdhth.trim()+"' ");
		}
		if(StringUtils.isNotBlank(khmc)){
			hql.append(" and A.khmc like '%"+khmc.trim()+"%' ");
		}
		if(StringUtils.isNotBlank(cjrq)){
			hql.append(" and A.id.cjrq = '"+cjrq.trim().toUpperCase()+"' ");
		}else {
			hql.append(" and 1 = 0 ");
		}
		PageQueryResult pqr = EastGrxdywjjService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
		return pqr;
	}
}
