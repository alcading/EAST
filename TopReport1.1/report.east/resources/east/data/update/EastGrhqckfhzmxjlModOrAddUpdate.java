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

import resources.east.data.operation.EastGrhqckfhzmxjlOperation;
import resources.east.data.pub.EastGrhqckfhzmxjl;
import resources.east.data.pub.EastGrhqckfhzmxjlId;

public class EastGrhqckfhzmxjlModOrAddUpdate extends BaseUpdate {
	
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastGrhqckfhzmxjl";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastGrhqckfhzmxjl eastGrhqckfhzmxjl = new EastGrhqckfhzmxjl();
			EastGrhqckfhzmxjlId Grhqckfhzmxjlpk = new EastGrhqckfhzmxjlId();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String hxjylsh = (String) map.get("hxjylsh");
				String zjylsh = (String) map.get("zjylsh");
				String bcxh = (String) map.get("bcxh");
				String hqckzh = (String) map.get("hqckzh");
				String hxjyrq = (String) map.get("hxjyrq");
				String cjrq = (String) map.get("cjrq");
				Grhqckfhzmxjlpk.setHqckzh(hqckzh);
				Grhqckfhzmxjlpk.setBcxh(Integer.valueOf(bcxh));
				Grhqckfhzmxjlpk.setCjrq(cjrq);
				Grhqckfhzmxjlpk.setHxjylsh(hxjylsh);
				Grhqckfhzmxjlpk.setHxjyrq(hxjyrq);
				Grhqckfhzmxjlpk.setZjylsh(zjylsh);
				BaseUpdate.mapToObject(eastGrhqckfhzmxjl, map);
				eastGrhqckfhzmxjl.setId(Grhqckfhzmxjlpk);
					context.setAttribute(EastGrhqckfhzmxjlOperation.CMD, EastGrhqckfhzmxjlOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastGrhqckfhzmxjl);
				// call方式开启operation事务
				OPCaller.call(EastGrhqckfhzmxjlOperation.ID, context);
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
