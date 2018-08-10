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

import resources.east.data.operation.EastXykzhjymxbOperation;
import resources.east.data.pub.EastXykzhjymxb;
import resources.east.data.pub.EastXykzhjymxbPK;

public class EastXykzhjymxbModOrAddUpdate extends BaseUpdate {

	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastXykzhjymxb";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastXykzhjymxb eastXykzhjymxb = new EastXykzhjymxb();
			EastXykzhjymxbPK xykzhjymxbpk = new EastXykzhjymxbPK();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String zjylsh = (String) map.get("zjylsh");
				String jyjzrq = (String) map.get("jyjzrq");
				String hxjylsh = (String) map.get("hxjylsh");
				Integer bcxh = (Integer) map.get("bcxh");
				String cjrq = (String) map.get("cjrq");
				
				xykzhjymxbpk.setZjylsh(zjylsh);
				xykzhjymxbpk.setJyjzrq(jyjzrq);
				xykzhjymxbpk.setHxjylsh(hxjylsh);
				xykzhjymxbpk.setBcxh(bcxh);
				xykzhjymxbpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastXykzhjymxb, map);
				eastXykzhjymxb.setId(xykzhjymxbpk);
				if (UpdateResultBean.MODIFY == updateResultBean.getRecodeState()) {
					context.setAttribute(EastXykzhjymxbOperation.CMD, EastXykzhjymxbOperation.CMD_UPDATE);
				}
				if (UpdateResultBean.INSERT == updateResultBean.getRecodeState()) {
					context.setAttribute(EastXykzhjymxbOperation.CMD, EastXykzhjymxbOperation.CMD_INSERT);
				}
				if (UpdateResultBean.NONE == updateResultBean.getRecodeState()) {
					context.setAttribute(EastXykzhjymxbOperation.CMD, EastXykzhjymxbOperation.CMD_DELETE);
				}
				context.setAttribute(SysParamsOperation.IN_PARAM, eastXykzhjymxb);
				// call方式开启operation事务
				OPCaller.call(EastXykzhjymxbOperation.ID, context);
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
