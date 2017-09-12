package com.huateng.report.update;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.bean.report.BopProjectInfo;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BopForDebtYinTuanOperation;

public class BopForDebtYinTuanSignedUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {

		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();

			//外债主信息
			UpdateResultBean BcedUpdateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopForDebtYinTuanSigned");
			BopCfaExdebtDs bopCfaExdebtDs = null ;
			while (BcedUpdateResultBean.hasNext()){
				bopCfaExdebtDs = new BopCfaExdebtDs();
				mapToObject(bopCfaExdebtDs,BcedUpdateResultBean.next());
			}

			//项目信息
			List<BopProjectInfo> proNewList = new  ArrayList<BopProjectInfo>();
			List<BopProjectInfo> proModList = new  ArrayList<BopProjectInfo>();
			List<BopProjectInfo> proDelList = new  ArrayList<BopProjectInfo>();

			List<BopProjectInfo> checkProjectList = new ArrayList<BopProjectInfo>();

			UpdateResultBean bopProUpdateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopForDebtYinTuanProject");
			while (bopProUpdateResultBean.hasNext()) {
				BopProjectInfo projectInfo = new BopProjectInfo();
				mapToObject(projectInfo, bopProUpdateResultBean.next());
				if(UpdateResultBean.DELETE != bopProUpdateResultBean.getRecodeState()) {
					checkProjectList.add(projectInfo);
				}
				switch (bopProUpdateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					proNewList.add(projectInfo);
					break;
				case UpdateResultBean.DELETE:
					proDelList.add(projectInfo);
					break;
				case UpdateResultBean.MODIFY:
					proModList.add(projectInfo);
					break;
				default:
					break;
				}
			}

			//债权人信息 TODO
			List<BopCfaCreditorDs> creNewList = new  ArrayList<BopCfaCreditorDs>();
			List<BopCfaCreditorDs> creModList = new  ArrayList<BopCfaCreditorDs>();
			List<BopCfaCreditorDs> creDelList = new  ArrayList<BopCfaCreditorDs>();

			List<BopCfaCreditorDs> checkCreditorList = new ArrayList<BopCfaCreditorDs>();

			UpdateResultBean bopCreUpdateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopForDebtYinTuanCreditor");
			while (bopCreUpdateResultBean.hasNext()) {
				BopCfaCreditorDs bopCfaCreditorDs = new BopCfaCreditorDs();
				mapToObject(bopCfaCreditorDs, bopCreUpdateResultBean.next());
				if(UpdateResultBean.DELETE != bopCreUpdateResultBean.getRecodeState()) {
					checkCreditorList.add(bopCfaCreditorDs);
				}
				switch (bopCreUpdateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					creNewList.add(bopCfaCreditorDs);
					break;
				case UpdateResultBean.DELETE:
					creDelList.add(bopCfaCreditorDs);
					break;
				case UpdateResultBean.MODIFY:
					creModList.add(bopCfaCreditorDs);
					break;
				default:
					break;
				}
			}

			String op = BcedUpdateResultBean.getParameter("op");
			OperationContext oc = new OperationContext();
			if (op.equals("new")) {
				oc.setAttribute(BopForDebtYinTuanOperation.CMD, BopForDebtYinTuanOperation.OP_SIGNED_NEW);
			} else if (op.equals("modify")) {
				oc.setAttribute(BopForDebtYinTuanOperation.CMD, BopForDebtYinTuanOperation.OP_SIGNED_MOD);
			} else if (op.equals("delete")) {
				oc.setAttribute(BopForDebtYinTuanOperation.CMD, BopForDebtYinTuanOperation.OP_SIGNED_DEL);
			}
			oc.setAttribute(BopForDebtYinTuanOperation.IN_SIGNED_DEBTBEAN, bopCfaExdebtDs);
			oc.setAttribute(BopForDebtYinTuanOperation.IN_SIGNED_PRONEW, proNewList);
			oc.setAttribute(BopForDebtYinTuanOperation.IN_SIGNED_PROMOD, proModList);
			oc.setAttribute(BopForDebtYinTuanOperation.IN_SIGNED_PRODEL, proDelList);
			oc.setAttribute(BopForDebtYinTuanOperation.IN_SIGNED_CRENEW, creNewList);
			oc.setAttribute(BopForDebtYinTuanOperation.IN_SIGNED_CREDEL, creDelList);
			oc.setAttribute(BopForDebtYinTuanOperation.IN_SIGNED_CREMOD, creModList);

			oc.setAttribute(BopForDebtYinTuanOperation.IN_CHECK_CREDITOR, checkCreditorList);
			oc.setAttribute(BopForDebtYinTuanOperation.IN_CHECK_PROJECT, checkProjectList);

			OPCaller.call(BopForDebtYinTuanOperation.ID, oc);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}