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
import resources.east.data.pub.EastCzxx;
import resources.east.data.pub.EastCzxxTmp;
import resources.east.data.pub.EastCzxxTmpId;

public class EastCzxxTmpUpdate extends BaseUpdate {

	private static final String DATASET_ID="EAST_CZXX_TMP";


	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		EastCzxxTmp czxxTmp = new EastCzxxTmp();
		EastCzxx czxx = new EastCzxx();
		EastCzxxTmpId czxxId = new EastCzxxTmpId();
		if(updateResultBean.hasNext())
		{
			Map map = updateResultBean.next();
		    map.remove("id");
			String czh = (String) map.get("czh");
			String cjrq = (String) map.get("cjrq");
		
			czxxId.setCzh(czh);
			czxxId.setCjrq(cjrq);
			mapToObject(czxxTmp,map);
			mapToObject(czxx,map);
			czxxTmp.setId(czxxId);
			czxx.setId(czxxId);
			try{

				dao.getHibernateTemplate().update(czxx);
				dao.getHibernateTemplate().delete(czxxTmp);
			}catch(Exception e){
				ExceptionUtil.throwCommonException("更新存折信息失败");
			}
			
	
		}
		return updateReturnBean;
	}

}
