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

import east.dao.BaseDao;
import east.utils.tools.DBUtil;
import resources.east.data.service.EastJylsService;

@SuppressWarnings("unchecked")
public class EastJylsGetter extends BaseGetter {
	/*
	 * 获取员工列表
	 * @author luqh
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "交易流水信息查询");
			
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
	 * 根据核心交易流水号或采集日期查找机构信息
	 * @return
	 * @throws CommonException 
	 */
	private PageQueryResult getData() throws CommonException {
		Map para = this.getCommQueryServletRequest().getParameterMap();
		
		String cjrq = (String)para.get("cjrq");
		
		String hxjylsh = (String)para.get("hxjylsh");
		
		String jyzh = (String)para.get("jyzh");
		
		String jyhm = (String)para.get("jyhm");
		
		String zjylsh = (String)para.get("zjylsh");
		
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();

		
		StringBuffer hql = new StringBuffer();
		
		hql.append("from EastJyls A where rownum<="+DBUtil.ROWNUM);
		
		if(StringUtils.isNotBlank(jyzh)){
			hql.append(" and A.id.jyzh = '"+jyzh.trim()+"' ");
		}
		if(StringUtils.isNotBlank(zjylsh)){
			hql.append(" and A.id.zjylsh = '"+zjylsh.trim()+"' ");
		}
		if(StringUtils.isNotBlank(jyhm)){
			hql.append(" and A.jyhm like '%"+jyhm.trim()+"%' ");
		}
		if(StringUtils.isNotBlank(hxjylsh)){
			hql.append(" and A.id.hxjylsh = '"+hxjylsh.trim()+"' ");
		}
		if(StringUtils.isNotBlank(cjrq)){
			hql.append(" and A.id.cjrq = '"+cjrq.trim().toUpperCase()+"' ");
		}else {
			hql.append(" and 1 = 0 ");
		}
		
		PageQueryResult pqr= EastJylsService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
		return pqr;
	}
}
