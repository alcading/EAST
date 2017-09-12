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
import resources.east.data.pub.EastDbgx;
import resources.east.data.pub.EastDbgxId;
import resources.east.data.pub.EastDbgxTmp;

public class EastDbgxTmpUpdate extends BaseUpdate {

	private static final String DATASET_ID="EAST_DBGX_TMP";


	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		EastDbgxTmp dbgxTmp = new EastDbgxTmp();
		EastDbgx dbgx = new EastDbgx();
		EastDbgxId dbgxId = new EastDbgxId();
		if(updateResultBean.hasNext())
		{
			Map map = updateResultBean.next();
		    map.remove("id");
		    mapToObject(dbgxId,map);
			mapToObject(dbgxTmp,map);
			mapToObject(dbgx,map);
			dbgxTmp.setId(dbgxId);
			dbgx.setId(dbgxId);
			try{

				dao.getHibernateTemplate().update(dbgx);
				dao.getHibernateTemplate().delete(dbgxTmp);
			}catch(Exception e){
				ExceptionUtil.throwCommonException("更新担保关系信息失败");
			}
			
	
		}
		return updateReturnBean;
	}

}
