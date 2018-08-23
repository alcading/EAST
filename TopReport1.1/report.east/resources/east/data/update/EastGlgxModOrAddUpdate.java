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

import resources.east.data.operation.EastGlgxOperation;
import resources.east.data.pub.EastGlgx;
import resources.east.data.pub.EastGlgxPK;

public class EastGlgxModOrAddUpdate extends BaseUpdate {

	private static final Logger logger = Logger.getLogger(EastGlgxModOrAddUpdate.class);
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastGlgx";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastGlgx eastGlgx = new EastGlgx();
			EastGlgxPK Glgxpk = new EastGlgxPK();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String khtybh = (String) map.get("khtybh");
				String glrkhtybh = (String) map.get("glrkhtybh");
				String cjrq = (String) map.get("cjrq");
				Glgxpk.setKhtybh(khtybh);
				Glgxpk.setGlrkhtybh(glrkhtybh);
				Glgxpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastGlgx, map);
				eastGlgx.setId(Glgxpk);
					context.setAttribute(EastGlgxOperation.CMD, EastGlgxOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastGlgx);
				// call方式开启operation事务
				OPCaller.call(EastGlgxOperation.ID, context);
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
