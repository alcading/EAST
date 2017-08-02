package com.huateng.ebank.business.management.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.bean.WelcomeBean;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.business.workflow.bean.GetTaskRequestBean;
import com.huateng.ebank.business.workflow.service.WorkFlowService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.struts.BaseAction;

/**
 * 用于统计首页工作台记录的action
 * @author kangbyron
 *
 */

public class WelcomeAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WelcomeAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		ActionForward actionForward = null;
		//登陆检查
		super.init(request);

		WelcomeBean welcomeBean = new WelcomeBean();
		/* ---------------获取我的待办任务------------- */
		welcomeBean.setCnt1(getCnt1());
		/* ---------------获取我的业务------------- */
		welcomeBean.setCnt2(0);
		/* ---------------获取贷款放款提示------------- */
		welcomeBean.setCnt3(0);
		/* ---------------获取贷款收回提示------------- */
		welcomeBean.setCnt4(0);
		/* ---------------获取我的客户------------- */
		welcomeBean.setCnt5(0);
		/* ---------------获取我的重点客户------------- */
		welcomeBean.setCnt6(0);
		/* ---------------获取我的记事本------------- */
		welcomeBean.setCnt7(0);

		List cntList = new ArrayList();
		cntList.add(welcomeBean);
	    request.setAttribute("cntList", cntList) ;
		actionForward = mapping.findForward("success");
	return actionForward;
	}


	/**
	 * 获取待办任务条数
	 * @param welcomeBean
	 * @return
	 * @throws CommonException
	 */
	private Integer getCnt1() throws CommonException{
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		GetTaskRequestBean getTaskRequestBean = new GetTaskRequestBean(globalInfo.getTlrno());
		getTaskRequestBean.setPageIndex(1);
		getTaskRequestBean.setPageSize(10);
		WorkFlowService workflowService = WorkFlowService.getInstance();
		PageQueryResult taskList = workflowService
				.getUnFinishedTaskList(getTaskRequestBean);
		return taskList.getTotalCount();
	}

	/**
	 * 获取我的业务
	 * @param welcomeBean
	 * @return
	 * @throws CommonException
	 */
	private Integer getCnt2() throws CommonException{
		StringBuffer hqlstr = new StringBuffer(512);
		hqlstr
				.append(
						"select li.brcode, li.contractno, li.lnid, li.totamt, li.lnbal, li.applyDate, li.appstat, li.trmClass, li.clrClass, ")
				.append(
						"ci.custno, ci.cname, ci.id, li.exceptionLoan , ci.blacklist ")
				.append("from Loaninfo as li, CustomerInfo as ci ").append(
						"where li.custcd = ci.id ")
				.append(" and li.trmClass <> '").append(
						SystemConstant.TRM_CLASS_CLOSE).append("'")
				.append("and li.mgrno = '"
								+ GlobalInfo.getCurrentInstance().getTlrno()
								+ "'");
		hqlstr.append(BctlService.getInstance().getQueryBranchCondition(
				"li.brcode", "1", GlobalInfo.getCurrentInstance().getBrcode()));
		hqlstr.append("order by li.contractno desc");

		List resultList = DAOUtils.getHQLDAO().queryByQL2List(hqlstr.toString());

		return resultList.size();
	}

	/**
	 * 获取贷款放款提示
	 * @param welcomeBean
	 * @return
	 * @throws CommonException
	 */
	private Integer getCnt3() throws CommonException{
//		List list = DAOUtils.getLoaninfoDAO().queryByCondition(" po.isdate = ? ",
//				new Object[]{GlobalInfo.getCurrentInstance().getTxdate()},
//				new Type[]{Hibernate.DATE} );
//		return list.size();
		return 0;
	}

	/**
	 * 获取贷款收回提示
	 * @param welcomeBean
	 * @return
	 * @throws CommonException
	 */
	private Integer getCnt4() throws CommonException{
		return 3;
	}

	/**
	 * 获取我的客户
	 * @param welcomeBean
	 * @return
	 * @throws CommonException
	 */
	private Integer getCnt5() throws CommonException{
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		StringBuffer hqlstr = new StringBuffer(512);
		hqlstr
		.append("select distinct ci.custno, ci.cname, ci.idno , ci.idtype, ci.branchBrcode, ci.custType")
		.append(" from  CustomerInfo as ci ")
		.append(" where  ci.directorManagerNo='")
		.append(globalInfo.getTlrno()).append("'");;
		List resultList = DAOUtils.getHQLDAO().queryByQL2List(hqlstr.toString());
		return resultList.size();
	}

	/**
	 * 获取我的重点客户
	 * @param welcomeBean
	 * @return
	 * @throws CommonException
	 */
	private Integer getCnt6() throws CommonException{
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		StringBuffer hqlstr = new StringBuffer(512);
		hqlstr
			.append("select fci.custno, fci.name, fci.idno, fci.idtype, fci.custcd, fci.remarks")
			.append(" from FocusCustInfo as fci where fci.tlrno = '")
			.append(globalInfo.getTlrno()).append("'");
		List resultList = DAOUtils.getHQLDAO().queryByQL2List(hqlstr.toString());
		return resultList.size();
	}

	/**
	 * 获取我的记事本
	 * @param welcomeBean
	 * @return
	 * @throws CommonException
	 */
	private Integer getCnt7() throws CommonException{
		List resultList = DAOUtils.getHQLDAO().queryByQL2List("select po from InformationMsg po");
		return resultList.size();
	}

}
