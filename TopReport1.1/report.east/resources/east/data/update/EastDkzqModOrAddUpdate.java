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

import resources.east.data.operation.EastDkzqOperation;
import resources.east.data.pub.EastDkzq;
import resources.east.data.pub.EastDkzqPK;

public class EastDkzqModOrAddUpdate extends BaseUpdate {

	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastDkzq";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastDkzq eastDkzq = new EastDkzq();
			EastDkzqPK dkzqpk = new EastDkzqPK();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String dkzqbh = (String) map.get("dkzqbh");
				String cjrq = (String) map.get("cjrq");
				dkzqpk.setDkzqbh(dkzqbh);
				dkzqpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastDkzq, map);
				eastDkzq.setId(dkzqpk);
				//if (UpdateResultBean.MODIFY == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDkzqOperation.CMD, EastDkzqOperation.CMD_UPDATE);
				//}
				/*if (UpdateResultBean.INSERT == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDkzqOperation.CMD, EastDkzqOperation.CMD_INSERT);
				}
				if (UpdateResultBean.NONE == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDkzqOperation.CMD, EastDkzqOperation.CMD_DELETE);
				}*/
				context.setAttribute(SysParamsOperation.IN_PARAM, eastDkzq);
				// call方式开启operation事务
				OPCaller.call(EastDkzqOperation.ID, context);
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
