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

import resources.east.data.operation.EastKhlczhxxbOperation;
import resources.east.data.pub.EastKhlczhxxb;
import resources.east.data.pub.EastKhlczhxxbPK;

public class EastKhlczhxxbModOrAddUpdate extends BaseUpdate {
	
	private static final Logger logger = Logger.getLogger(EastKhlczhxxbModOrAddUpdate.class);
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastKhlczhxxb";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastKhlczhxxb eastKhlczhxxb = new EastKhlczhxxb();
			EastKhlczhxxbPK Khlczhxxbpk = new EastKhlczhxxbPK();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String lczh = (String) map.get("lczh");
				String glhqckzh = (String) map.get("glhqckzh");
				String hnbsm = (String) map.get("hnbsm");
				Khlczhxxbpk.setLczh(lczh);
				Khlczhxxbpk.setGlhqckzh(glhqckzh);
				Khlczhxxbpk.setHnbsm(hnbsm);
				BaseUpdate.mapToObject(eastKhlczhxxb, map);
				eastKhlczhxxb.setId(Khlczhxxbpk);
					context.setAttribute(EastKhlczhxxbOperation.CMD, EastKhlczhxxbOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastKhlczhxxb);
				// call方式开启operation事务
				OPCaller.call(EastKhlczhxxbOperation.ID, context);
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
