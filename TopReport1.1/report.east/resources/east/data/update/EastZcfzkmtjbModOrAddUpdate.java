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

import resources.east.data.operation.EastZcfzkmtjbOperation;
import resources.east.data.pub.EastZcfzkmtjb;
import resources.east.data.pub.EastZcfzkmtjbPK;

public class EastZcfzkmtjbModOrAddUpdate extends BaseUpdate {
	
	private static final Logger logger = Logger.getLogger(EastZcfzkmtjbModOrAddUpdate.class);
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static String DATASET_ID = "EastZcfzkmtjb";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			// 更新对象
			EastZcfzkmtjb eastZcfzkmtjb = new EastZcfzkmtjb();
			EastZcfzkmtjbPK Zcfzkmtjbpk = new EastZcfzkmtjbPK();
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
				Zcfzkmtjbpk.setNbjgh(nbjgh);
				Zcfzkmtjbpk.setTjkmbh(tjkmbh);
				Zcfzkmtjbpk.setQxlx(qxlx);
				Zcfzkmtjbpk.setTjrq(tjrq);
				Zcfzkmtjbpk.setBz(bz);
				Zcfzkmtjbpk.setCjrq(cjrq);
				BaseUpdate.mapToObject(eastZcfzkmtjb, map);
				eastZcfzkmtjb.setId(Zcfzkmtjbpk);
				context.setAttribute(EastZcfzkmtjbOperation.CMD, EastZcfzkmtjbOperation.CMD_UPDATE);
				context.setAttribute(SysParamsOperation.IN_PARAM, eastZcfzkmtjb);
				// call方式开启operation事务
				OPCaller.call(EastZcfzkmtjbOperation.ID, context);
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
