package com.huateng.report.bop.collection.updater;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import resource.bean.report.MtsBopDrDs;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopDrDsOperation;

/**
* @author huangcheng
*/
public class BopRDsUpdate extends BaseUpdate  {

	private static final String DATASET_ID="BopRDsAdd";
	private static final String RECORD_DELETE="del";
	private static final String RECORD_ADD="new";
	private static final String RECORD_MOD="mod";
	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		// 返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		// 返回结果对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		MtsBopDrDs mtsBopDrDs = new MtsBopDrDs();	
		OperationContext oc = new OperationContext();
		// 返回对象
		if (updateResultBean.hasNext()) {
			String op = updateResultBean.getParameter("op");
			Map map = updateResultBean.next();
			mapToObject(mtsBopDrDs, map);
			if (!StringUtils.isEmpty(op)) {

				if (RECORD_ADD.equalsIgnoreCase(op)) {
					oc.setAttribute(BopDrDsOperation.CMD,BopDrDsOperation.CMD_INSERT);
				} else if (RECORD_MOD.equalsIgnoreCase(op)) {
				
					oc.setAttribute(BopDrDsOperation.CMD,BopDrDsOperation.CMD_UPDATE);
				} else if (RECORD_DELETE.equalsIgnoreCase(op)) {
								
					oc.setAttribute(BopDrDsOperation.CMD,BopDrDsOperation.CMD_DELETE);
				}
			}
		}
		
		oc.setAttribute(BopDrDsOperation.IN_PARAM_DR, mtsBopDrDs);
		oc.setAttribute(BopDrDsOperation.BOP, BopDrDsOperation.BOP_R);
		OPCaller.call(BopDrDsOperation.ID, oc);

		return updateReturnBean;
	}
}