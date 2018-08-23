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

import resources.east.data.operation.EastXdywzhdywOperation;
import resources.east.data.pub.EastXdywzhdyw;
import resources.east.data.pub.EastXdywzhdywPK;

public class EastXdywzhdywModOrAddUpdate extends BaseUpdate {

	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastXdywzhdyw";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastXdywzhdyw eastXdywzhdyw = new EastXdywzhdyw();
			EastXdywzhdywPK xdywzhdywpk = new EastXdywzhdywPK();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String zhdywbh = (String) map.get("zhdywbh");
				String cjrq = (String) map.get("cjrq");
				xdywzhdywpk.setZhdywbh(zhdywbh);
				xdywzhdywpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastXdywzhdyw, map);
				eastXdywzhdyw.setId(xdywzhdywpk);
				context.setAttribute(EastXdywzhdywOperation.CMD, EastXdywzhdywOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastXdywzhdyw);
				// call方式开启operation事务
				OPCaller.call(EastXdywzhdywOperation.ID, context);
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
