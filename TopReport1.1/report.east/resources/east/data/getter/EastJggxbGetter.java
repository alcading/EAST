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
import resources.east.data.service.EastJggxbService;

public class EastJggxbGetter extends BaseGetter {
	/*
	 * 获取员工列表
	 * @author luqh
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "机构表信息查询");
			
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
	   * 根据内部机构号或银行机构名称查找机构信息
	   * @return
	   */
	 private PageQueryResult getData() throws CommonException {

		   Map para = this.getCommQueryServletRequest().getParameterMap();
		   	
		   	String cjrq = (String)para.get("cjrq");
		   	
		   	String yxjgdm = (String)para.get("yxjgdm");
		   	
		   	String nbjgh = (String)para.get("id");
		   	
		   	String yxjgmc = (String)para.get("yxjgmc");
		   	
			int pageSize = this.getResult().getPage().getEveryPage();
			int pageIndex = this.getResult().getPage().getCurrentPage();
			
			StringBuffer hql = new StringBuffer();
			
			hql.append("from EastJggxb A where rownum<="+DBUtil.ROWNUM);
			
			if(StringUtils.isNotBlank(yxjgdm)){
				hql.append(" and A.yxjgdm = '"+yxjgdm.trim()+"' ");
			}
			if(StringUtils.isNotBlank(nbjgh)){
				hql.append(" and A.nbjgh = '"+nbjgh.trim()+"' ");
			}
			if(StringUtils.isNotBlank(yxjgmc)){
				hql.append(" and A.yxjgmc like '%").append(yxjgmc.trim()).append("%'");
			}
			if(StringUtils.isNotBlank(cjrq)){
				hql.append(" and A.cjrq = '"+cjrq.trim().toUpperCase()+"' ");
			}else {
				hql.append(" and 1 = 0 ");
			}
			
			PageQueryResult pqr= EastJggxbService.getInstance().pageQueryByHql(pageIndex, pageSize, hql.toString());
			return pqr;
		}
}
