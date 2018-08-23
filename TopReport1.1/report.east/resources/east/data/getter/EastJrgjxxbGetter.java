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
import resources.east.data.service.EastJrgjxxbService;

@SuppressWarnings("unchecked")
public class EastJrgjxxbGetter extends BaseGetter {
	/*
	 * 获取员工列表
	 * @author luqh
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "金融工具表信息查询");
			
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
	 * 根据采集日期或金融工具编号查找金融工具信息
	 * @return
	 * @throws CommonException 
	 */
	private PageQueryResult getData() throws CommonException {
		Map para = this.getCommQueryServletRequest().getParameterMap();
		
		String cjrq = (String)para.get("cjrq");
		
		String jrgjbh = (String)para.get("jrgjbh");
		
		String zqmc = (String)para.get("zqmc");
		
		String fxjg = (String)para.get("fxjg");
		
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("from EastJrgjxxb A where rownum<="+DBUtil.ROWNUM);
		
		if(StringUtils.isNotBlank(zqmc)){
			hql.append(" and A.zqmc like '%"+zqmc.trim()+"%' ");
		}
		if(StringUtils.isNotBlank(fxjg)){
			hql.append(" and A.fxjg like '%"+fxjg.trim()+"%' ");
		}
		if(StringUtils.isNotBlank(jrgjbh)){
			hql.append(" and A.id.jrgjbh = '"+jrgjbh.trim()+"' ");
		}
		if(StringUtils.isNotBlank(cjrq)){
			hql.append(" and A.id.cjrq = '"+cjrq.trim().toUpperCase()+"' ");
		}else {
			hql.append(" and 1 = 0 ");
		}
		
		PageQueryResult pqr= EastJrgjxxbService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
		return pqr;
	}
}
