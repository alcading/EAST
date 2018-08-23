package resources.east.data.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import resources.east.data.operation.EastCzxxOperation;
import resources.east.data.pub.EastCzxx;
import resources.east.data.pub.EastCzxxTmpId;

public class EastCzxxModOrAddUpdate extends BaseUpdate {

	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastCzxx";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastCzxx eastCzxx = new EastCzxx();
			EastCzxxTmpId czxxpk = new EastCzxxTmpId();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String czh = (String) map.get("czh");
				String cjrq = (String) map.get("cjrq");
				czxxpk.setCzh(czh);
				czxxpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastCzxx, map);
				eastCzxx.setId(czxxpk);
				context.setAttribute(EastCzxxOperation.CMD, EastCzxxOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastCzxx);
				// call方式开启operation事务
				OPCaller.call(EastCzxxOperation.ID, context);
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
