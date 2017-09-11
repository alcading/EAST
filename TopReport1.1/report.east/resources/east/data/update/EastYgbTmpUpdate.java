package resources.east.data.update;

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

import resources.east.data.pub.EastYgb;
import resources.east.data.pub.EastYgbPK;
import resources.east.data.pub.EastYgbTmp;

public class EastYgbTmpUpdate extends BaseUpdate {

	private static final String DATASET_ID="EAST_YGB_TMP";


	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		EastYgbTmp ygbTmp = new EastYgbTmp();
		EastYgb ygb = new EastYgb();
		EastYgbPK ygbpk = new EastYgbPK();
		if(updateResultBean.hasNext())
		{
			Map map = updateResultBean.next();
			map.remove("id");
			String gh = (String) map.get("gh");
			String nbjgh = (String) map.get("nbjgh");
		
			ygbpk.setGh(gh);
			ygbpk.setNbjgh(nbjgh);
			mapToObject(ygbTmp,map);
			mapToObject(ygb,map);
			ygbTmp.setId(ygbpk);
			ygb.setId(ygbpk);
			try{
				
				dao.getHibernateTemplate().delete(ygbTmp);
				dao.getHibernateTemplate().update(ygb);
			}catch(Exception e){
				ExceptionUtil.throwCommonException("更新员工信息失败");
			}
			
	
		}
		return updateReturnBean;
	}

}
