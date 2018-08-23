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
import resources.east.data.service.EastLccpxsmxjlService;

@SuppressWarnings("unchecked")
public class EastLccpxsmxjlGetter extends BaseGetter {
	/*
	 * 获取员工列表
	 * @author luqh
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "理财产品销售明细记录");
			
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
	 * 根据销售合同号或采集日期查找理财产品销售明细记录
	 * @return
	 * @throws CommonException 
	 */
	private PageQueryResult getData() throws CommonException {
		Map para = this.getCommQueryServletRequest().getParameterMap();
		
		String cjrq = (String)para.get("cjrq");
		
		String jyh = (String)para.get("jyh");
		
		String hxjylsh = (String)para.get("hxjylsh");
		
		String khxm = (String)para.get("khxm");
		
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("from EastLccpxsmxjl A where rownum<="+DBUtil.ROWNUM);
		
		if(StringUtils.isNotBlank(hxjylsh)){
			hql.append(" and A.id.hxjylsh = '"+hxjylsh.trim()+"' ");
		}
		if(StringUtils.isNotBlank(khxm)){
			hql.append(" and A.khxm = '"+khxm.trim()+"' ");
		}
		if(StringUtils.isNotBlank(jyh)){
			hql.append(" and A.jyh = '"+jyh.trim()+"' ");
		}
		if(StringUtils.isNotBlank(cjrq)){
			hql.append(" and A.cjrq = '"+cjrq.trim().toUpperCase()+"' ");
		}else {
			hql.append(" and 1 = 0 ");
		}
		
		PageQueryResult pqr= EastLccpxsmxjlService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
		return pqr;
	}
}
