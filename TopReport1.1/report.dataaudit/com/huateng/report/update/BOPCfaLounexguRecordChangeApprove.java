package com.huateng.report.update;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaLounexguDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BOPCfaLounexguRecordVerOperation;

public class BOPCfaLounexguRecordChangeApprove  extends BaseUpdate{
	private static final String DATASET_ID = "BOPCfaLounexguRecordChangeVer";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AppException {
		// TODO Auto-generated method stub
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean  =multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext oc = new OperationContext();
			
			
			List<BopCfaLounexguDs>  list =  new ArrayList<BopCfaLounexguDs>();
			ROOTDAO rootDao= ROOTDAOUtils.getROOTDAO();
			while(updateResultBean.hasNext()){
				BopCfaLounexguDs bopCfaLounexguDs = new BopCfaLounexguDs();
				Map map= updateResultBean.next();

				mapToObject(bopCfaLounexguDs, map);
				list.add(bopCfaLounexguDs);
				
			}
			
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			
			oc.setAttribute(BOPCfaLounexguRecordVerOperation.CMD, BOPCfaLounexguRecordVerOperation.CMD_CHANGE_AUDIT);
			oc.setAttribute(BOPCfaLounexguRecordVerOperation.IN_AUDIT_CHANGE_LIST, list);
			oc.setAttribute(BOPCfaLounexguRecordVerOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BOPCfaLounexguRecordVerOperation.IN_AUDIT_RESULT, approveResultChoose);
			OPCaller.call(BOPCfaLounexguRecordVerOperation.ID, oc);
			return updateReturnBean;
		}  catch (AppException Ae) {
			// TODO: handle exception
			throw Ae;
		}catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}