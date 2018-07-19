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

import resources.east.data.operation.EastDgdqckfhzOperation;
import resources.east.data.pub.EastDgdqckfhz;
import resources.east.data.pub.EastDgdqckfhzId;

public class EastDgdqckfhzModOrAddUpdate extends BaseUpdate {
	
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastDgdqckfhz";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastDgdqckfhz eastDgdqckfhz = new EastDgdqckfhz();
			EastDgdqckfhzId Dgdqckfhzpk = new EastDgdqckfhzId();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String dqckzh = (String) map.get("dqckzh");
				String bz = (String) map.get("bz");
				String chlb = (String) map.get("chlb");
				String cjrq = (String) map.get("cjrq");
				Dgdqckfhzpk.setDqckzh(dqckzh);
				Dgdqckfhzpk.setBz(bz);
				Dgdqckfhzpk.setChlb(chlb);
				Dgdqckfhzpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastDgdqckfhz, map);
				eastDgdqckfhz.setId(Dgdqckfhzpk);
				if (UpdateResultBean.MODIFY == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDgdqckfhzOperation.CMD, EastDgdqckfhzOperation.CMD_UPDATE);
				}
				if (UpdateResultBean.INSERT == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDgdqckfhzOperation.CMD, EastDgdqckfhzOperation.CMD_INSERT);
				}
				if (UpdateResultBean.NONE == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDgdqckfhzOperation.CMD, EastDgdqckfhzOperation.CMD_DELETE);
				}
				context.setAttribute(SysParamsOperation.IN_PARAM, eastDgdqckfhz);
				// call方式开启operation事务
				OPCaller.call(EastDgdqckfhzOperation.ID, context);
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
