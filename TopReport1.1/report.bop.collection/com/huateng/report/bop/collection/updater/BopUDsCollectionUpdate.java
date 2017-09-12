package com.huateng.report.bop.collection.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopInvcountrycode;
import resource.bean.report.MtsBopOpenAccount;
import resource.bean.report.MtsBopUDs;
import cn.cncc.cjdp.common.utils.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopUDsOperation;

public class BopUDsCollectionUpdate extends BaseUpdate {

	private static final String BOPU_ID = "BopUDsCollectionInfo";
	private static final String INVCOUNTRYCODE_ID = "BopInvcountrycode";
	private static final String OPENACCOUNT_ID = "BopOpenDsCollection";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(BOPU_ID);

			MtsBopUDs bopu = null;
			while (updateResultBean.hasNext()) {
				bopu = new MtsBopUDs();
				Map map = updateResultBean.next();
				mapToObject(bopu,map);
			}

			List<MtsBopInvcountrycode>insertcountryList = new ArrayList<MtsBopInvcountrycode>();
			List<MtsBopInvcountrycode>modifycountryList = new ArrayList<MtsBopInvcountrycode>();
			List<MtsBopInvcountrycode>deletecountryList = new ArrayList<MtsBopInvcountrycode>();

			List<String>checkCountryList = new ArrayList<String>();

			updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(INVCOUNTRYCODE_ID);

			MtsBopInvcountrycode countrycode = null;
			while (updateResultBean.hasNext()) {
				countrycode = new MtsBopInvcountrycode();
				Map map = updateResultBean.next();
				mapToObject(countrycode,map);
				if (UpdateResultBean.DELETE != updateResultBean.getRecodeState()) {
					checkCountryList.add(countrycode.getInvcountrycode());
				}
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertcountryList.add(countrycode);
					break;
				case UpdateResultBean.MODIFY:
					modifycountryList.add(countrycode);
					break;
				case UpdateResultBean.DELETE:
					deletecountryList.add(countrycode);
					break;
				default:
					break;
				}
			}



			List<MtsBopOpenAccount>insertopenaccountList = new ArrayList<MtsBopOpenAccount>();
			List<MtsBopOpenAccount>modifyopenaccountList = new ArrayList<MtsBopOpenAccount>();
			List<MtsBopOpenAccount>deleteopenaccountList = new ArrayList<MtsBopOpenAccount>();

			List<MtsBopOpenAccount>checkBankinfoList = new ArrayList<MtsBopOpenAccount>();

			updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(OPENACCOUNT_ID);

			MtsBopOpenAccount openaccount = null;
			while (updateResultBean.hasNext()) {
				openaccount = new MtsBopOpenAccount();
				Map map = updateResultBean.next();
				mapToObject(openaccount,map);
				if (UpdateResultBean.DELETE != updateResultBean.getRecodeState()) {
					checkBankinfoList.add(openaccount);
				}
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertopenaccountList.add(openaccount);
					break;
				case UpdateResultBean.MODIFY:
					modifyopenaccountList.add(openaccount);
					break;
				case UpdateResultBean.DELETE:
					deleteopenaccountList.add(openaccount);
					break;
				default:
					break;
				}
			}

			bopu.setInvcountry(checkCountryList);
			bopu.setBankinfos(checkBankinfoList);

			String op = updateResultBean.getParameter("op");
			if (StringUtils.equals(BopUDsOperation.CMD_NEW, op)) {
				OperationContext oc = new OperationContext();
				oc.setAttribute(BopUDsOperation.CMD, BopUDsOperation.CMD_NEW);

				oc.setAttribute(BopUDsOperation.PARAM_U, bopu);
				oc.setAttribute(BopUDsOperation.PARAM_COUNTRY_ADD, insertcountryList);
				oc.setAttribute(BopUDsOperation.PARAM_OPENACCOUNT_ADD, insertopenaccountList);

				OPCaller.call(BopUDsOperation.ID, oc);
			} else if (StringUtils.equals(BopUDsOperation.CMD_MOD, op)) {
				OperationContext oc = new OperationContext();
				oc.setAttribute(BopUDsOperation.CMD, BopUDsOperation.CMD_MOD);
				oc.setAttribute(BopUDsOperation.PARAM_U, bopu);

				oc.setAttribute(BopUDsOperation.PARAM_COUNTRY_ADD, insertcountryList);
				oc.setAttribute(BopUDsOperation.PARAM_OPENACCOUNT_ADD, insertopenaccountList);

				oc.setAttribute(BopUDsOperation.PARAM_COUNTRY_MOD, modifycountryList);
				oc.setAttribute(BopUDsOperation.PARAM_OPENACCOUNT_MOD, modifyopenaccountList);

				oc.setAttribute(BopUDsOperation.PARAM_COUNTRY_DEL, deletecountryList);
				oc.setAttribute(BopUDsOperation.PARAM_OPENACCOUNT_DEL, deleteopenaccountList);

				OPCaller.call(BopUDsOperation.ID, oc);
			} else if (StringUtils.equals(BopUDsOperation.CMD_DEL, op)) {
				OperationContext oc = new OperationContext();
				oc.setAttribute(BopUDsOperation.CMD, BopUDsOperation.CMD_DEL);
				oc.setAttribute(BopUDsOperation.PARAM_U, bopu);
				OPCaller.call(BopUDsOperation.ID, oc);
			}
			return updateReturnBean;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
