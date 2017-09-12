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
import resources.east.data.pub.EastGrhqckfhz;
import resources.east.data.pub.EastGrhqckfhzId;
import resources.east.data.pub.EastGrhqckfhzTmp;


public class EastGrhqckfhzTmpUpdate extends BaseUpdate {
	private static final HtLog htlog=HtLogFactory.getLogger(EastGrhqckfhzTmpUpdate.class);
	private static final String DATASET_ID="EAST_GRHQCKFHZ_TMP";


	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		EastGrhqckfhzTmp grhqckfhzTmp = new EastGrhqckfhzTmp();
		EastGrhqckfhz grhqckfhz = new EastGrhqckfhz();
		EastGrhqckfhzId grhqckfhzId = new EastGrhqckfhzId();
		if(updateResultBean.hasNext()){
			Map map = updateResultBean.next();
			map.remove("id");
			//hqckzh, bz, jyjzh, chlb, cjrq
			String hqckzh = (String) map.get("hqckzh");
			String bz = (String) map.get("bz");
			String jyjzh = (String) map.get("jyjzh");
			String chlb = (String) map.get("chlb");
			String cjrq = (String) map.get("cjrq");
	
			grhqckfhzId.setHqckzh(hqckzh);
			grhqckfhzId.setBz(bz);
			grhqckfhzId.setJyjzh(jyjzh);
			grhqckfhzId.setChlb(chlb);
			grhqckfhzId.setCjrq(cjrq);
			mapToObject(grhqckfhzTmp,map);
			mapToObject(grhqckfhz,map);
			grhqckfhzTmp.setId(grhqckfhzId);
			grhqckfhz.setId(grhqckfhzId);
			try{
				htlog.info("开始修改EAST_GRHQCKFHZ数据");
				dao.getHibernateTemplate().update(grhqckfhz);
				htlog.info("开始删除EAST_GRHQCKFHZ_TMP数据");
				dao.getHibernateTemplate().delete(grhqckfhzTmp);
				
			}catch(Exception e){
				ExceptionUtil.throwCommonException("更新员工信息失败");
			}
			
	
		}
		return updateReturnBean;
	}

}
