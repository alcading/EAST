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
import resources.finstandard.data.pub.DepositBalance;

public class DepositBalanceUpdateMod extends BaseUpdate {

	private static final String DATASET_ID = "DepositBalanceEdit";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
	
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//返回结果对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		//返回存款余额对象
		DepositBalance DepositBalance  = new DepositBalance();
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		
		if (updateResultBean.hasNext()) {
			// 属性拷贝
			Map map = updateResultBean.next();
			BaseUpdate.mapToObject(DepositBalance, map);
           try{
				dao.getHibernateTemplate().update(DepositBalance);
			}catch(Exception e){
				ExceptionUtil.throwCommonException("更新存款余额信息失败");
			}
		}
		return updateReturnBean;
	}

}
