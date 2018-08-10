package resources.finstandard.data.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import resource.dao.base.HQLDAO;
import resources.finstandard.data.pub.LoanBalance;

public class LoanBalanceUpdateMod extends BaseUpdate {

	private static final String DATASET_ID = "LoanBalanceEdit";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
	
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//返回结果对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		//返回贷款余额对象
		LoanBalance loanBalance  = new LoanBalance();
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		
		if (updateResultBean.hasNext()) {
			// 属性拷贝
			Map map = updateResultBean.next();
			BaseUpdate.mapToObject(loanBalance, map);
           try{
				dao.getHibernateTemplate().update(loanBalance);
			}catch(Exception e){
				ExceptionUtil.throwCommonException("更新贷款余额信息失败");
			}
		}
		return updateReturnBean;
	}

}
