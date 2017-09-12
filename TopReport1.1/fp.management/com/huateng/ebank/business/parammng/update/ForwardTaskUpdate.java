/**
 *
 */
package com.huateng.ebank.business.parammng.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.business.management.operation.RelationCodeOperation;
import com.huateng.ebank.business.parammng.operation.ForwardTaskOperation;
import com.huateng.ebank.business.workflow.bean.TaskBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;


public class ForwardTaskUpdate extends BaseUpdate {
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RelationCodeOperation.class);

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		List taskList = new ArrayList();
		UpdateResultBean updateResultBean1 = multiUpdateResultBean.getUpdateResultBeanByID("ForwardTask");
	    UpdateResultBean updateResultBean2 = multiUpdateResultBean.getUpdateResultBeanByID("ForwardTaskSubmit");
	    String forwardTlrno = (String)((Map)updateResultBean2.getTotalList().get(0)).get("forwardTlrno");

		//检查操作员是否存在
	    List list = DAOUtils.getTlrInfoDAO().queryByCondition("po.tlrno = '" + forwardTlrno + "'");
		if(list == null || list.isEmpty()) {
			ExceptionUtil.throwCommonException("操作员" + forwardTlrno + "不存在",
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT);
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("移交的操作员号 =["+forwardTlrno+"]");
		}
		
		while (updateResultBean1.hasNext()) {
			TaskBean taskBean = new TaskBean();
			Map tmpMap = updateResultBean1.next();
			String select = (String)tmpMap.get("select");
			if( select == null || select.equals("false")){
				continue;
			}
			mapToObject(taskBean, tmpMap);
			taskList.add(taskBean);
		}
	    if(taskList.size()==0){
	       ExceptionUtil.throwCommonException("未选择需要移交的任务",
	                    ErrorCode.ERROR_CODE_TASK_FORWARD_ERROR);
	    }
	    
		OperationContext oc = new OperationContext();
	    oc.setAttribute(ForwardTaskOperation.TASK_LIST,taskList);
	    oc.setAttribute(ForwardTaskOperation.FORWARDTLRNO,forwardTlrno);
	    OPCaller.call(ForwardTaskOperation.ID, oc);
		if(logger.isDebugEnabled()){
			logger.debug("移交成功");
		}
	    UpdateReturnBean updReturnBean = new UpdateReturnBean();
		return updReturnBean;
	}

}
