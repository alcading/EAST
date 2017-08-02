package com.huateng.ebank.business.opermng.getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import resource.bean.pub.RoleInfo;
import resource.bean.pub.TlrRoleRel;
import resource.bean.report.SysTaskInfo;
import resource.bean.report.SysTaskLog;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.system.bean.TlrInfoAuditBean;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportUtils;
import com.huateng.view.pub.TlrRoleRelationView;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngRoleInfoComSeriGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

	private PageQueryResult getData() throws CommonException, IOException, ClassNotFoundException {
		PageQueryResult pageQueryResult = new PageQueryResult();
		String st = (String) getCommQueryServletRequest().getParameterMap().get("st");
		String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
		String tskId = (String) getCommQueryServletRequest().getParameter("tskId");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		
		List tlrRoleViewList = new ArrayList();
		List<Integer> roleIds = new ArrayList<Integer>();
		if(flag.equals("0")){
			if(st.equals("2")){
				ReportTaskUtil rt = new ReportTaskUtil();
				List<SysTaskInfo> taskList = rootdao.queryByQL2List("from SysTaskInfo where intInsId='100399' and adtRcdPk='" + tlrno + "'");
				if (taskList.size() > 0) {
					TlrInfoAuditBean auditBean = (TlrInfoAuditBean) rt.getObjctBySysTaskInfo(taskList.get(0));
					for (TlrRoleRel rr : auditBean.getRoleRellist()) {
						roleIds.add(rr.getRoleId());
					}
					List roleList = DAOUtils.getRoleInfoDAO().queryByCondition(" po.id in" + ReportUtils.toInString(roleIds));
					// 对以有的操作员岗位在岗位列表中显示
					for (int i = 0; i < roleList.size(); i++) {
						RoleInfo roleInfo = (RoleInfo) roleList.get(i);
						TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
						tlrRoleView.setRoleId(String.valueOf(roleInfo.getId().intValue()));
						tlrRoleView.setRoleName(roleInfo.getRoleName());
						tlrRoleViewList.add(tlrRoleView);
					}
					pageQueryResult.setQueryResult(tlrRoleViewList);
					pageQueryResult.setTotalCount(tlrRoleViewList.size());
				}
			}
		}
		if(flag.equals("1")) {
			ReportTaskUtil rt=new ReportTaskUtil();
			SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
			TlrInfoAuditBean newValue = null;
			if(systasklog.getNewVal1()!=null){
				newValue=(TlrInfoAuditBean)rt.getNewObjectByTaskLog(systasklog);	  
			}
			if(newValue != null){
				for (TlrRoleRel rr : newValue.getRoleRellist()) {
					roleIds.add(rr.getRoleId());
				}
				List roleList = DAOUtils.getRoleInfoDAO().queryByCondition(" po.id in" + ReportUtils.toInString(roleIds));
				// 对以有的操作员岗位在岗位列表中显示
				for (int i = 0; i < roleList.size(); i++) {
					RoleInfo roleInfo = (RoleInfo) roleList.get(i);
					TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
					tlrRoleView.setRoleId(String.valueOf(roleInfo.getId().intValue()));
					tlrRoleView.setRoleName(roleInfo.getRoleName());
					tlrRoleViewList.add(tlrRoleView);
				}
				pageQueryResult.setQueryResult(tlrRoleViewList);
				pageQueryResult.setTotalCount(tlrRoleViewList.size());
			}
		}
		return pageQueryResult;
	}
}
