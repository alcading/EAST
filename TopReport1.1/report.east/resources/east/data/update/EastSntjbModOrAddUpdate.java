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

import resources.east.data.operation.EastSntjbOperation;
import resources.east.data.pub.EastSntjb;
import resources.east.data.pub.EastSntjbPK;

public class EastSntjbModOrAddUpdate extends BaseUpdate {
	
	private static final Logger logger = Logger.getLogger(EastSntjbModOrAddUpdate.class);
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastSntjb";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastSntjb eastSntjb = new EastSntjb();
			EastSntjbPK Sntjbpk = new EastSntjbPK();
			// Operation参数
			OperationContext context = new OperationContext();
			if (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				map.remove("id");
				String nbjgh = (String) map.get("nbjgh");
				String tjkmbh = (String) map.get("tjkmbh");
				String qxlx = (String) map.get("qxlx");
				String tjrq = (String) map.get("tjrq");
				String bz = (String) map.get("bz");
				String cjrq = (String) map.get("cjrq");
				Sntjbpk.setNbjgh(nbjgh);
				Sntjbpk.setTjkmbh(tjkmbh);
				Sntjbpk.setQxlx(qxlx);
				Sntjbpk.setTjrq(tjrq);
				Sntjbpk.setBz(bz);
				Sntjbpk.setCjrq(cjrq);
				Sntjbpk.setNbjgh(nbjgh);
				BaseUpdate.mapToObject(eastSntjb, map);
				eastSntjb.setId(Sntjbpk);
				if (UpdateResultBean.MODIFY == updateResultBean.getRecodeState()) {
					context.setAttribute(EastSntjbOperation.CMD, EastSntjbOperation.CMD_UPDATE);
				}
				if (UpdateResultBean.INSERT == updateResultBean.getRecodeState()) {
					context.setAttribute(EastSntjbOperation.CMD, EastSntjbOperation.CMD_INSERT);
				}
				if (UpdateResultBean.NONE == updateResultBean.getRecodeState()) {
					context.setAttribute(EastSntjbOperation.CMD, EastSntjbOperation.CMD_DELETE);
				}
				context.setAttribute(SysParamsOperation.IN_PARAM, eastSntjb);
				// call方式开启operation事务
				OPCaller.call(EastSntjbOperation.ID, context);
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
