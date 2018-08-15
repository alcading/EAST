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

import resources.east.data.operation.EastDkwjxtbdOperation;
import resources.east.data.pub.EastDkwjxtbd;
import resources.east.data.pub.EastDkwjxtbdPK;

public class EastDkwjxtbdModOrAddUpdate extends BaseUpdate {

	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastDkwjxtbd";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastDkwjxtbd eastDkwjxtbd = new EastDkwjxtbd();
			EastDkwjxtbdPK dkwjxtbdpk = new EastDkwjxtbdPK();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String tzrq = (String) map.get("tzrq");
				String xdjjh = (String) map.get("xdjjh");
				String cjrq = (String) map.get("cjrq");
				dkwjxtbdpk.setTzrq(tzrq);
				dkwjxtbdpk.setXdjjh(xdjjh);
				dkwjxtbdpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastDkwjxtbd, map);
				eastDkwjxtbd.setId(dkwjxtbdpk);
				//if (UpdateResultBean.MODIFY == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDkwjxtbdOperation.CMD, EastDkwjxtbdOperation.CMD_UPDATE);
				//}
				/*if (UpdateResultBean.INSERT == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDkwjxtbdOperation.CMD, EastDkwjxtbdOperation.CMD_INSERT);
				}
				if (UpdateResultBean.NONE == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDkwjxtbdOperation.CMD, EastDkwjxtbdOperation.CMD_DELETE);
				}*/
				context.setAttribute(SysParamsOperation.IN_PARAM, eastDkwjxtbd);
				// call方式开启operation事务
				OPCaller.call(EastDkwjxtbdOperation.ID, context);
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
