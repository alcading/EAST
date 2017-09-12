package resources.east.data.update;



import resources.east.data.operation.EastProcessLogUpdateOperation;
import resources.east.data.pub.EastProcessLog;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.dataAnaly.util.ExecuteDataAnalysis;



public class EastVerifyDelUpdate extends BaseUpdate{
	private static final HtLog htlog = HtLogFactory.getLogger(ExecuteDataAnalysis.class);

	private static final String DATASET_ID="DataVerify";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

		EastProcessLog wbi = new EastProcessLog();;

		OperationContext oc = new OperationContext();

		if(updateResultBean.hasNext())
		{
			Map map = updateResultBean.next();
			oc.setAttribute(EastProcessLogUpdateOperation.CMD, EastProcessLogUpdateOperation.CMD_DELETE);
			mapToObject(wbi,map);
		}

		oc.setAttribute(EastProcessLogUpdateOperation.IN_PARAM, wbi);
		OPCaller.call(EastProcessLogUpdateOperation.ID, oc);

		return updateReturnBean;
	}	
}


