package com.huateng.report.update;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaLounexguDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.DateUtil;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BOPCfaLounexguRecordOperation;
import com.huateng.report.utils.ReportUtils;

public class BOPCfaLounexguRecordChangeUpdate  extends BaseUpdate {
	private static final String DATASET_ID = "BOPCfaLounexguRecordChangeInfo";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AppException {
		// TODO Auto-generated method stub

		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean  =multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			String id = httpServletRequest.getParameter("id");
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			OperationContext oc = new OperationContext();
			BopCfaLounexguDs bopCfaLounexguDs = new BopCfaLounexguDs();
			ROOTDAO rootDao= ROOTDAOUtils.getROOTDAO();
			if(updateResultBean.hasNext()){
				Map map= updateResultBean.next();
				
				String op = updateResultBean.getParameter("op");
				if("new".equalsIgnoreCase(op)){
					
					bopCfaLounexguDs.setLounexgucode(map.get("lounexgucode").toString());
					bopCfaLounexguDs.setFiller1(map.get("filler1").toString());
					if(map.get("credwithamount").toString()!=null && !"".equals(map.get("credwithamount").toString())){
						BigDecimal bd=new BigDecimal(map.get("credwithamount").toString()); 
						
						bopCfaLounexguDs.setCredwithamount(bd);
					}
					bopCfaLounexguDs.setBuscode(map.get("buscode").toString());
					if(map.get("credrepayamount").toString()!=null && !"".equals(map.get("credrepayamount").toString())){
						BigDecimal bd=new BigDecimal(map.get("credrepayamount").toString()); 
						bopCfaLounexguDs.setCredrepayamount(bd);
					}
					bopCfaLounexguDs.setChangeno(map.get("changeno").toString());
					
					if(map.get("picamount").toString()!=null && !"".equals(map.get("picamount").toString())){
						BigDecimal bd=new BigDecimal(map.get("picamount").toString()); 
						bopCfaLounexguDs.setPicamount(bd);
					}
					
					bopCfaLounexguDs.setChangedate(map.get("changedate").toString());
					
					if(map.get("credprinbala").toString()!=null && !"".equals(map.get("credprinbala").toString())){
						BigDecimal bd=new BigDecimal(map.get("credprinbala").toString()); 
						bopCfaLounexguDs.setCredprinbala(bd);
					}
					bopCfaLounexguDs.setCredcurrcode(map.get("credcurrcode").toString());
					if(map.get("guarantlibala").toString()!=null && !"".equals(map.get("guarantlibala").toString())){
						BigDecimal bd=new BigDecimal(map.get("guarantlibala").toString()); 
						bopCfaLounexguDs.setGuarantlibala(bd);
					}
					bopCfaLounexguDs.setRemark(map.get("remark").toString());
					if(map.get("guperamount").toString()!=null && !"".equals(map.get("guperamount").toString())){
						BigDecimal bd=new BigDecimal(map.get("guperamount").toString()); 
						bopCfaLounexguDs.setGuperamount(bd);
					}
					bopCfaLounexguDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaLounexguDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_DB);
					
					String uuid = ReportUtils.getUUID();
					bopCfaLounexguDs.setId(uuid);
					bopCfaLounexguDs.setCrtTm(new Date()); 
					
					bopCfaLounexguDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
					bopCfaLounexguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					bopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaLounexguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaLounexguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopCfaLounexguDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
				    bopCfaLounexguDs.setCrtTm(new Date());
				    bopCfaLounexguDs.setLstUpdTm(new Date());
				    bopCfaLounexguDs.setLstUpdTlr(gi.getTlrno());
				    bopCfaLounexguDs.setBrNo(gi.getBrno());
				    bopCfaLounexguDs.setFiller2(map.get("filler2").toString());
					oc.setAttribute(BOPCfaLounexguRecordOperation.CMD, BOPCfaLounexguRecordOperation.CMD_INSERT_CH);
				}else if("mod".equalsIgnoreCase(op)){
					mapToObject(bopCfaLounexguDs, map);
					//String id = map.get("id").toString();
					//bopCfaLounexguDs.setId(map.get("id").toString());
					bopCfaLounexguDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaLounexguDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_DB);
					bopCfaLounexguDs.setBrNo(gi.getBrno());
					if(map.get("subSuccess").toString().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)){
						bopCfaLounexguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
						bopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bopCfaLounexguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bopCfaLounexguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
						 bopCfaLounexguDs.setLstUpdTm(new Date());
						 bopCfaLounexguDs.setLstUpdTlr(gi.getTlrno());
					}else{
						bopCfaLounexguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
						bopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bopCfaLounexguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bopCfaLounexguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
						 bopCfaLounexguDs.setLstUpdTm(new Date());
						 bopCfaLounexguDs.setLstUpdTlr(gi.getTlrno());
						 bopCfaLounexguDs.setLstUpdTlr(gi.getTlrno());
					}
					oc.setAttribute(BOPCfaLounexguRecordOperation.CMD, BOPCfaLounexguRecordOperation.CMD_UPDATE_CH);
				}else if("del".equalsIgnoreCase(op)){
		
					mapToObject(bopCfaLounexguDs, map);
					bopCfaLounexguDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaLounexguDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_DB);
					bopCfaLounexguDs.setBrNo(gi.getBrno());
					bopCfaLounexguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaLounexguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaLounexguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					 bopCfaLounexguDs.setLstUpdTm(new Date());
					 bopCfaLounexguDs.setLstUpdTlr(gi.getTlrno());
					oc.setAttribute(BOPCfaLounexguRecordOperation.CMD, BOPCfaLounexguRecordOperation.CMD_DELETE_CH);
				}
			}
			oc.setAttribute(BOPCfaLounexguRecordOperation.IN_PARAM, bopCfaLounexguDs);
			OPCaller.call(BOPCfaLounexguRecordOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException Ae) {
			// TODO: handle exception
			throw Ae;
		}catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
