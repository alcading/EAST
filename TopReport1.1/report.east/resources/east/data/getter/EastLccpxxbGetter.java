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
import resources.east.data.service.EastLccpxxbService;

public class EastLccpxxbGetter extends BaseGetter {
	/*
	 * 获取员工列表
	 * @author luqh
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "理财产品信息表查询");
			
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
	   * 查询理财产品信息表
	   * 通过采集日期和行内标识码来查询
	   * @return
	 * @throws CommonException 
	   */
	   private PageQueryResult getData() throws CommonException {
		   Map para = this.getCommQueryServletRequest().getParameterMap();
		   	
		   String cjrq = (String)para.get("cjrq");
		   
		   String hnbsm = (String)para.get("id");
		   
		   String cpmc = (String)para.get("cpmc");
		   
		   String cpdjbm = (String)para.get("cpdjbm");
		   
		   int pageSize = this.getResult().getPage().getEveryPage();
		   int pageIndex = this.getResult().getPage().getCurrentPage();
		   
		   StringBuffer hql = new StringBuffer();
		   
		   hql.append("from EastLccpxxb A where rownum<="+DBUtil.ROWNUM);
		   
		   if(StringUtils.isNotBlank(cpdjbm)){
			   hql.append(" and A.cpdjbm = '"+cpdjbm.trim()+"' ");
		   }
		   if(StringUtils.isNotBlank(cpmc)){
			   hql.append(" and A.cpmc like '%"+cpmc.trim()+"%' ");
		   }
		   if(StringUtils.isNotBlank(hnbsm)){
			   hql.append(" and A.id = '"+hnbsm.trim()+"' ");
		   }
		   if(StringUtils.isNotBlank(cjrq)){
			   hql.append(" and A.cjrq = '"+cjrq.trim().toUpperCase()+"' ");
		   }else {
			   hql.append(" and 1 = 0 ");
		   }
		   
		   PageQueryResult pqr= EastLccpxxbService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
		   return pqr;
	   }
}
