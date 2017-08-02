package com.huateng.ebank.framework.web.commQuery;

import java.io.IOException;

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
import com.huateng.commquery.dao.ICommQueryDAO;
import com.huateng.commquery.process.base.IViewProcess;
import com.huateng.ebank.framework.web.struts.BaseAction;
import com.huateng.exception.DomainException;
import com.huateng.mvc.struts.utils.BaseErrorUtils;

public class CommonQueryResultAction extends BaseAction {
	private ICommQueryDAO commQueryDAO;

	@Override
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws DomainException, IOException {
		// TODO Auto-generated method stub
		try {
			super.init(request);
			String id = request.getParameter(CommonQueryConstants.COMMON_QUERY_ID);
			ICommonQueryBean commonQueryBean = CommonQueryUtil.getCommonQueryBean(id);

			Class resultProcessClass = Class.forName(commonQueryBean.getResultProcess());
			//New Element resultProcess Class
			IViewProcess process = (IViewProcess)resultProcessClass.newInstance();
			process.process(id, request, response);
			return null;
		} catch (DomainException dEx) {
			BaseErrorUtils.handleError(request, this, dEx,
					BaseErrorUtils.RT_HISTORY);
			throw dEx;
		} catch (Exception ex) {
			DomainException dex = new DomainException(
					Module.DEFAULT_MODULE, Rescode.DEFAULT_RESCODE, ex
							.getMessage(), Constants.COMMON_PAGE, ex);
			BaseErrorUtils.handleError(request, this, dex,
					BaseErrorUtils.RT_HISTORY);
			throw dex;
		}
	}

	public boolean safePrivi(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	public ICommQueryDAO getCommQueryDAO() {
		return commQueryDAO;
	}

	public void setCommQueryDAO(ICommQueryDAO commQueryDAO) {
		this.commQueryDAO = commQueryDAO;
	}

}
