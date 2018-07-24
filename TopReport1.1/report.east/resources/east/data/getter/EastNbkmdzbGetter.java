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

import resources.east.data.service.EastNbkmdzbService;

@SuppressWarnings("unchecked")
public class EastNbkmdzbGetter extends BaseGetter {
	/*
	 * 获取员工列表
	 * @author luqh
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "内部科目对照表信息查询");
			
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(),
			pageResult.getQueryResult(),getResult());
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

	  /**
	   * 查询
	   * @return
	   */
		private PageQueryResult getData() throws CommonException {
		    Map para = this.getCommQueryServletRequest().getParameterMap();
		   	
		   	String cjrq = (String)para.get("cjrq");
		   	
		   	String kmbh = (String)para.get("kmbh");
		   	
			int pageSize = this.getResult().getPage().getEveryPage();
			int pageIndex = this.getResult().getPage().getCurrentPage();
			
			StringBuffer hql = new StringBuffer();
			
			hql.append("from EastNbkmdzb A where 1 = 1 ");
			
			if(StringUtils.isNotBlank(kmbh)){
				hql.append(" and A.kmbh = '"+kmbh.trim()+"' ");
			}
			if(StringUtils.isNotBlank(cjrq)){
				hql.append(" and A.id.cjrq = '"+cjrq.trim().toUpperCase()+"' ");
			}else {
				hql.append(" and 1 = 0 ");
			}
			PageQueryResult pqr= EastNbkmdzbService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
			return pqr;
		}
}
