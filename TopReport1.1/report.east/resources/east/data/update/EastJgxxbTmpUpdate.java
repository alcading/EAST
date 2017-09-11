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
import resources.east.data.operation.EastJgxxbOperation;
import resources.east.data.pub.EastCzxx;
import resources.east.data.pub.EastCzxxTmp;
import resources.east.data.pub.EastCzxxTmpId;
import resources.east.data.pub.EastJgxxb;
import resources.east.data.pub.EastJgxxbTmp;

public class EastJgxxbTmpUpdate extends BaseUpdate {

	private static final String DATASET_ID="EAST_JGXXB_TMP";


	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		EastJgxxbTmp jgxxbTmp = new EastJgxxbTmp();
		EastJgxxb jgxxb = new EastJgxxb();
		//EastCzxxTmpId czxxId = new EastCzxxTmpId();
		if(updateResultBean.hasNext())
		{
			Map map = updateResultBean.next();
			mapToObject(jgxxbTmp,map);
			mapToObject(jgxxb,map);
           String id = jgxxb.getId();
			try{
				dao.getHibernateTemplate().update(jgxxb);
				dao.getHibernateTemplate().delete(jgxxbTmp);
				
			}catch(Exception e){
				ExceptionUtil.throwCommonException("更新机构信息失败");
			}
			
	
		}
		return updateReturnBean;
	}
	
}

