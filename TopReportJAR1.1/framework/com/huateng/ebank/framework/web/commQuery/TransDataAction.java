/**
 *
 */
package com.huateng.ebank.framework.web.commQuery;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.common.Constants;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.common.CommonQueryConstants;
import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.config.bean.base.ICommonQueryField;
import com.huateng.commquery.result.databus.CommonQueryDataBusMng;
import com.huateng.ebank.framework.web.struts.BaseAction;
import com.huateng.exception.DomainException;
import com.huateng.mvc.struts.utils.BaseErrorUtils;

/**
 * Title: TransDataAction
 * Description:
 * Copyright: Copyright (c) 2007
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2007-11-13
 */
public class TransDataAction extends BaseAction {

	 @Override
	public ActionForward execute(ActionMapping actionMapping,
	            ActionForm actionForm, HttpServletRequest request,
	            HttpServletResponse response) throws Exception
	    {
	        //super.init(request);
	        try{
				String id = request.getParameter(CommonQueryConstants.COMMON_QUERY_ID);
				ICommonQueryBean commonQueryBean = CommonQueryUtil.getCommonQueryBean(id);
				String buttonId = request.getParameter("_button_id");
				String page = commonQueryBean.getOperationsElement(buttonId).getAnyValue("url");

				String dataSetId = commonQueryBean.getAnyValue("databusid");
				/** use DataBus .*/
				if(dataSetId != null){
					Iterator fieldIt = commonQueryBean.getFields().keySet().iterator();
					String fId,fVal;
					ICommonQueryField field;
					Map dataSetMap = new HashMap();
					while(fieldIt.hasNext()){
						fId = (String)fieldIt.next();
						field = commonQueryBean.getField(fId);
						if(field.getAnyValue("primary")!=null && field.getAnyValue("primary").equalsIgnoreCase("true")){
							fVal  = request.getParameter(fId);
							dataSetMap.put(fId, fVal==null?"":fVal);
						}
					}
					//mng databus
					CommonQueryDataBusMng.setDataBus(request.getSession().getId(),dataSetId,dataSetMap,request.getSession());
				}
				return new ActionForward(page,false);
			}catch(DomainException dEx){
				BaseErrorUtils.handleError(request, this, dEx, BaseErrorUtils.RT_HISTORY);
				throw dEx;
			}catch (Exception ex) {
				DomainException dex = new DomainException(Module.DEFAULT_MODULE,
						Rescode.DEFAULT_RESCODE, ex.getMessage(),
						Constants.COMMON_PAGE, ex);
				BaseErrorUtils.handleError(request, this, dex, BaseErrorUtils.RT_HISTORY);
				throw dex;
			}
	    }
}
