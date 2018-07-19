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

import resources.east.data.operation.EastDgxdfhzmxjlOperation;
import resources.east.data.pub.EastDgxdfhzmxjl;
import resources.east.data.pub.EastDgxdfhzmxjlId;

public class EastDgxdfhzmxjlModOrAddUpdate extends BaseUpdate {

	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastDgxdfhzmxjl";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastDgxdfhzmxjl eastDgxdfhzmxjl = new EastDgxdfhzmxjl();
			EastDgxdfhzmxjlId Dgxdfhzmxjlpk = new EastDgxdfhzmxjlId();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String hxjylsh = (String) map.get("hxjylsh");
				String zjylsh = (String) map.get("zjylsh");
				String bcxh = (String) map.get("bcxh");
				String dkzh = (String) map.get("dkzh");
				String hxjyrq = (String) map.get("hxjyrq");
				String cjrq = (String) map.get("cjrq");
				String xdjjh = (String) map.get("xdjjh");
				Dgxdfhzmxjlpk.setDkzh(dkzh);
				Dgxdfhzmxjlpk.setBcxh(Integer.valueOf(bcxh));
				Dgxdfhzmxjlpk.setCjrq(cjrq);
				Dgxdfhzmxjlpk.setHxjylsh(hxjylsh);
				Dgxdfhzmxjlpk.setHxjyrq(hxjyrq);
				Dgxdfhzmxjlpk.setZjylsh(zjylsh);
				BaseUpdate.mapToObject(eastDgxdfhzmxjl, map);
				eastDgxdfhzmxjl.setId(Dgxdfhzmxjlpk);
				if (UpdateResultBean.MODIFY == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDgxdfhzmxjlOperation.CMD, EastDgxdfhzmxjlOperation.CMD_UPDATE);
				}
				if (UpdateResultBean.INSERT == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDgxdfhzmxjlOperation.CMD, EastDgxdfhzmxjlOperation.CMD_INSERT);
				}
				if (UpdateResultBean.NONE == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDgxdfhzmxjlOperation.CMD, EastDgxdfhzmxjlOperation.CMD_DELETE);
				}
				context.setAttribute(SysParamsOperation.IN_PARAM, eastDgxdfhzmxjl);
				// call方式开启operation事务
				OPCaller.call(EastDgxdfhzmxjlOperation.ID, context);
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
