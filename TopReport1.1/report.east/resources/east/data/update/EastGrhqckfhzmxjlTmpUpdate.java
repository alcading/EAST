package resources.east.data.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import resource.dao.base.HQLDAO;
import resources.east.data.pub.EastDghqckfhzmxjl;
import resources.east.data.pub.EastDghqckfhzmxjlId;
import resources.east.data.pub.EastDghqckfhzmxjlTmp;
import resources.east.data.pub.EastGrhqckfhzmxjl;
import resources.east.data.pub.EastGrhqckfhzmxjlTmp;
import resources.east.data.pub.EastGrhqckfhzmxjlTmpId;


public class EastGrhqckfhzmxjlTmpUpdate extends BaseUpdate {
	private static final HtLog htlog=HtLogFactory.getLogger(EastGrhqckfhzmxjlTmpUpdate.class);
	private static final String DATASET_ID="EAST_GRHQCKFHZMXJL_TMP";


	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		EastGrhqckfhzmxjlTmp dghqckfhzmxjlTmp = new EastGrhqckfhzmxjlTmp();
		EastGrhqckfhzmxjl dghqckfhzmxjl = new EastGrhqckfhzmxjl();
		EastGrhqckfhzmxjlTmpId dghqckfhzmxjlId = new EastGrhqckfhzmxjlTmpId();
		if(updateResultBean.hasNext()){
			Map map = updateResultBean.next();
			map.remove("id");
			//hxjylsh, zjylsh,  bcxh,hqckzh,  hxjyrq,cjrq
			String hxjylsh = (String) map.get("hxjylsh");
			String zjylsh = (String) map.get("zjylsh");
			String sbcxh =(String) map.get("bcxh");
			Integer  bcxh = Integer.parseInt(sbcxh);
		//	Integer bcxh = (Integer) map.get("bcxh");
			String hqckzh = (String) map.get("hqckzh");
			String hxjyrq = (String) map.get("hxjyrq");
			String cjrq = (String) map.get("cjrq");
	
			dghqckfhzmxjlId.setHxjylsh(hxjylsh);
			dghqckfhzmxjlId.setZjylsh(zjylsh);
			dghqckfhzmxjlId.setBcxh(bcxh);
			dghqckfhzmxjlId.setHqckzh(hqckzh);
			dghqckfhzmxjlId.setHxjyrq(hxjyrq);
			dghqckfhzmxjlId.setCjrq(cjrq);
			mapToObject(dghqckfhzmxjlTmp,map);
			mapToObject(dghqckfhzmxjl,map);
			dghqckfhzmxjlTmp.setId(dghqckfhzmxjlId);
//			dghqckfhzmxjl.setId(dghqckfhzmxjlId);
			try{
				htlog.info("开始修改EAST_GRHQCKFHZMXJL数据");
				dao.getHibernateTemplate().update(dghqckfhzmxjl);
				htlog.info("开始删除EAST_GRHQCKFHZMXJL_TMP数据");
				dao.getHibernateTemplate().delete(dghqckfhzmxjlTmp);
				
			}catch(Exception e){
				ExceptionUtil.throwCommonException("更对个人活期存款分户账明细记录信息失败");
			}
			
	
		}
		return updateReturnBean;
	}

}
