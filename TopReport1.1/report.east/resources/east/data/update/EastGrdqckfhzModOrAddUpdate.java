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

import resources.east.data.operation.EastGrdqckfhzOperation;
import resources.east.data.pub.EastGrdqckfhz;
import resources.east.data.pub.EastGrdqckfhzId;

public class EastGrdqckfhzModOrAddUpdate extends BaseUpdate {
	
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastGrdqckfhz";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastGrdqckfhz eastGrdqckfhz = new EastGrdqckfhz();
			EastGrdqckfhzId Grdqckfhzpk = new EastGrdqckfhzId();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String dqckzh = (String) map.get("dqckzh");
				String bz = (String) map.get("bz");
				String jyjzh = (String) map.get("jyjzh");
				String chlb = (String) map.get("chlb");
				String cjrq = (String) map.get("cjrq");
				Grdqckfhzpk.setDqckzh(dqckzh);
				Grdqckfhzpk.setBz(bz);
				Grdqckfhzpk.setJyjzh(jyjzh);
				Grdqckfhzpk.setChlb(chlb);
				Grdqckfhzpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastGrdqckfhz, map);
				eastGrdqckfhz.setId(Grdqckfhzpk);
					context.setAttribute(EastGrdqckfhzOperation.CMD, EastGrdqckfhzOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastGrdqckfhz);
				// call方式开启operation事务
				OPCaller.call(EastGrdqckfhzOperation.ID, context);
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
