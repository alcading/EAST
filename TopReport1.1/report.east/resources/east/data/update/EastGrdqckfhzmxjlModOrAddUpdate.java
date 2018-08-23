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

import resources.east.data.operation.EastGrdqckfhzmxjlOperation;
import resources.east.data.pub.EastGrdqckfhzmxjl;
import resources.east.data.pub.EastGrdqckfhzmxjlId;

public class EastGrdqckfhzmxjlModOrAddUpdate extends BaseUpdate {
	
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastGrdqckfhzmxjl";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastGrdqckfhzmxjl eastGrdqckfhzmxjl = new EastGrdqckfhzmxjl();
			EastGrdqckfhzmxjlId Grdqckfhzmxjlpk = new EastGrdqckfhzmxjlId();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String hxjylsh = (String) map.get("hxjylsh");
				String zjylsh = (String) map.get("zjylsh");
				String bcxh = (String) map.get("bcxh");
				String dqckzh = (String) map.get("dqckzh");
				String hxjyrq = (String) map.get("hxjyrq");
				String cjrq = (String) map.get("cjrq");
				Grdqckfhzmxjlpk.setDqckzh(dqckzh);
				Grdqckfhzmxjlpk.setBcxh(Integer.valueOf(bcxh));
				Grdqckfhzmxjlpk.setCjrq(cjrq);
				Grdqckfhzmxjlpk.setHxjylsh(hxjylsh);
				Grdqckfhzmxjlpk.setHxjyrq(hxjyrq);
				Grdqckfhzmxjlpk.setZjylsh(zjylsh);
				BaseUpdate.mapToObject(eastGrdqckfhzmxjl, map);
				eastGrdqckfhzmxjl.setId(Grdqckfhzmxjlpk);
					context.setAttribute(EastGrdqckfhzmxjlOperation.CMD, EastGrdqckfhzmxjlOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastGrdqckfhzmxjl);
				// call方式开启operation事务
				OPCaller.call(EastGrdqckfhzmxjlOperation.ID, context);
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
