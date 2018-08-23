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
import resources.east.data.service.EastZzhjqkmbService;

@SuppressWarnings("unchecked")
public class EastZzhjqkmbGetter extends BaseGetter {
	/*
	 * 获取员工列表
	 * @author luqh
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "总账会计全科目表查询");
			
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
	   * 查询总账会计全科目表
	   * @return
	   */
		private PageQueryResult getData() throws CommonException {
	
		    Map para = this.getCommQueryServletRequest().getParameterMap();
		   	
		   	String kjrq = (String)para.get("kjrq");
		   	
		   	String yhjgdm = (String)para.get("yhjgdm");
		   	
		   	String kmbh = (String)para.get("kmbh");
		   	
		   	String kmlx = (String)para.get("kmlx");
		   	
			int pageSize = this.getResult().getPage().getEveryPage();
			int pageIndex = this.getResult().getPage().getCurrentPage();
			
			StringBuffer hql = new StringBuffer();
			
			hql.append("from EastZzhjqkmb A where rownum<="+DBUtil.ROWNUM);
			
			if(StringUtils.isNotBlank(yhjgdm)){
				hql.append(" and A.yhjgdm = '"+yhjgdm.trim()+"' ");
			}
			if(StringUtils.isNotBlank(kmbh)){
				hql.append(" and A.id.kmbh = '"+kmbh.trim()+"' ");
			}
			if(StringUtils.isNotBlank(kmlx)){
				hql.append(" and A.kmlx = '"+kmlx.trim()+"' ");
			}
			if(StringUtils.isNotBlank(kjrq)){
				hql.append(" and A.id.kjrq = '"+kjrq.trim().toUpperCase()+"' ");
			}else {
				hql.append(" and 1 = 0 ");
			}
		
			PageQueryResult pqr= EastZzhjqkmbService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
			return pqr;
		}
}
