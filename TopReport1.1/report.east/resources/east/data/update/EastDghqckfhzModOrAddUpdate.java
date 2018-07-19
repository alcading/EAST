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

import resources.east.data.operation.EastDghqckfhzOperation;
import resources.east.data.pub.EastDghqckfhz;
import resources.east.data.pub.EastDghqckfhzId;

public class EastDghqckfhzModOrAddUpdate extends BaseUpdate {
	
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastDghqckfhz";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastDghqckfhz eastDghqckfhz = new EastDghqckfhz();
			EastDghqckfhzId Dghqckfhzpk = new EastDghqckfhzId();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String hqckzh = (String) map.get("hqckzh");
				String bz = (String) map.get("bz");
				String chlb = (String) map.get("chlb");
				String cjrq = (String) map.get("cjrq");
				Dghqckfhzpk.setHqckzh(hqckzh);
				Dghqckfhzpk.setBz(bz);
				Dghqckfhzpk.setChlb(chlb);
				Dghqckfhzpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastDghqckfhz, map);
				eastDghqckfhz.setId(Dghqckfhzpk);
				if (UpdateResultBean.MODIFY == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDghqckfhzOperation.CMD, EastDghqckfhzOperation.CMD_UPDATE);
				}
				if (UpdateResultBean.INSERT == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDghqckfhzOperation.CMD, EastDghqckfhzOperation.CMD_INSERT);
				}
				if (UpdateResultBean.NONE == updateResultBean.getRecodeState()) {
					context.setAttribute(EastDghqckfhzOperation.CMD, EastDghqckfhzOperation.CMD_DELETE);
				}
				context.setAttribute(SysParamsOperation.IN_PARAM, eastDghqckfhz);
				// call方式开启operation事务
				OPCaller.call(EastDghqckfhzOperation.ID, context);
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
