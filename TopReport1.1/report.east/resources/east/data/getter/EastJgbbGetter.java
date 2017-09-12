package resources.east.data.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resources.east.data.service.EastJgbbService;

public class EastJgbbGetter extends BaseGetter {

	public EastJgbbGetter() {
		// TODO 自动生成的构造函数存根
	}

	/*
	 * 获取员工列表
	 * @author luqh
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "报送表信息查询");
			
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
	   private PageQueryResult getData() {
			String eastTable = (String) getCommQueryServletRequest().getParameterMap().get("eastTable");
			String eastTableName = (String) getCommQueryServletRequest().getParameterMap().get("eastTableName");
			int pageSize = this.getResult().getPage().getEveryPage();
			int pageIndex = this.getResult().getPage().getCurrentPage();
			//String qst=getCommQueryServletRequest().getParameter("st");
			//PageQueryResult pqr= BiMonthExchangeRateService.getInstance().pageQueryByHql(pageIndex, pageSize, ratecut,yearMonth,qst);
			PageQueryResult pqr= EastJgbbService.getInstance().pageQueryByHql(pageIndex, pageSize,eastTable,eastTableName);
			return pqr;
		}

}
