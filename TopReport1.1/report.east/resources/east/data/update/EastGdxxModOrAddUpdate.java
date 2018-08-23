package resources.east.data.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.system.operation.SysParamsOperation;

import resources.east.data.operation.EastGdxxOperation;
import resources.east.data.pub.EastGdxx;
import resources.east.data.pub.EastGdxxPK;

public class EastGdxxModOrAddUpdate extends BaseUpdate {

	private static final Logger logger = Logger.getLogger(EastGdxxModOrAddUpdate.class);
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastGdxx";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastGdxx eastGdxx = new EastGdxx();
			EastGdxxPK Gdxxpk = new EastGdxxPK();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String khtybh = (String) map.get("khtybh");
				String gdzjhm = (String) map.get("gdzjhm");
				String cjrq = (String) map.get("cjrq");
				Gdxxpk.setKhtybh(khtybh);
				Gdxxpk.setGdzjhm(gdzjhm);
				Gdxxpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastGdxx, map);
				eastGdxx.setId(Gdxxpk);
					context.setAttribute(EastGdxxOperation.CMD, EastGdxxOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastGdxx);
				// call方式开启operation事务
				OPCaller.call(EastGdxxOperation.ID, context);
				return updateReturnBean;
			}
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage(), e);
		}
		return null;
	}

}
