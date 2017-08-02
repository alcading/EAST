package com.huateng.report.update;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaFogucodeinfo;
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
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BOPCfaLounexguRecordOperation;
import com.huateng.report.utils.ReportUtils;

public class BOPCfaLounexguRecordUpdate extends BaseUpdate{

	private static final String DATASET_ID = "BOPCfaLounexguRecordAD";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AppException {
		try {

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			OperationContext oc = new OperationContext();
			//外债信息
//			UpdateResultBean updateResultBean  =multiUpdateResultBean.getUpdateResultBeanByID("BOPCfaLounexguRecordAD");
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

			//境外担保人信息
			UpdateResultBean  fogUpdateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("BopCfaFogucodeInfo");
			List<BopCfaFogucodeinfo> insertList = new ArrayList<BopCfaFogucodeinfo>();
			List<BopCfaFogucodeinfo> updateList = new ArrayList<BopCfaFogucodeinfo>();
			List<BopCfaFogucodeinfo> delList = new ArrayList<BopCfaFogucodeinfo>();
			BopCfaFogucodeinfo bopCfaFogucodeinfo = null;

			List<BopCfaFogucodeinfo>checkProjectList = new ArrayList<BopCfaFogucodeinfo>();
			while(fogUpdateResultBean.hasNext()){
				bopCfaFogucodeinfo= new BopCfaFogucodeinfo();
				mapToObject(bopCfaFogucodeinfo, fogUpdateResultBean.next());
				if(UpdateResultBean.DELETE != fogUpdateResultBean.getRecodeState()) {
					checkProjectList.add(bopCfaFogucodeinfo);
				}
				switch (fogUpdateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(bopCfaFogucodeinfo);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(bopCfaFogucodeinfo);
					break;
				case UpdateResultBean.DELETE:
					delList.add(bopCfaFogucodeinfo);
				default:
					break;
				}
			}
			oc.setAttribute(BOPCfaLounexguRecordOperation.INSERT_LIST, insertList);
			oc.setAttribute(BOPCfaLounexguRecordOperation.UPDATE_LIST, updateList);
			oc.setAttribute(BOPCfaLounexguRecordOperation.DEL_LIST, delList);

			oc.setAttribute(BOPCfaLounexguRecordOperation.CHECK_LIST, checkProjectList);

			BopCfaLounexguDs bopCfaLounexguDs = null;
			ROOTDAO rootDao= ROOTDAOUtils.getROOTDAO();
			while(updateResultBean.hasNext()){
				bopCfaLounexguDs = new BopCfaLounexguDs();
				Map map= updateResultBean.next();
				GlobalInfo gi = GlobalInfo.getCurrentInstance();
				String op = updateResultBean.getParameter("op");
				if("new".equalsIgnoreCase(op)){
					bopCfaLounexguDs.setLounexgucode(map.get("lounexgucode").toString());
					bopCfaLounexguDs.setCreditorcode(map.get("creditorcode").toString());
					bopCfaLounexguDs.setDebtorcode(map.get("debtorcode").toString());
					bopCfaLounexguDs.setDebtorname(map.get("debtorname").toString());
					bopCfaLounexguDs.setDebtortype(map.get("debtortype").toString());
					bopCfaLounexguDs.setCfeogudad(map.get("cfeogudad").toString());
					bopCfaLounexguDs.setCfeogudcurr(map.get("cfeogudcurr").toString());
					if(map.get("cfeogudamount").toString()!=null && !"".equals(map.get("cfeogudamount").toString())){
						BigDecimal bd=new BigDecimal(map.get("cfeogudamount").toString());
						bopCfaLounexguDs.setCfeogudamount(bd);
					}
					bopCfaLounexguDs.setCredcurrcode(map.get("credcurrcode").toString());
					if(map.get("credconamount").toString()!=null && !"".equals(map.get("credconamount").toString())){
						BigDecimal bd=new BigDecimal(map.get("credconamount").toString());
						bopCfaLounexguDs.setCredconamount(bd);
					}
					bopCfaLounexguDs.setValuedate(map.get("valuedate").toString());
					bopCfaLounexguDs.setMaturity(map.get("maturity").toString());
					bopCfaLounexguDs.setDofoexlocode(map.get("dofoexlocode").toString());

					bopCfaLounexguDs.setRemark(map.get("remark").toString());

					bopCfaLounexguDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaLounexguDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_DA);

					String uuid = ReportUtils.getUUID();
					bopCfaLounexguDs.setId(uuid);
					bopCfaLounexguDs.setLstUpdTm(new Date());
					bopCfaLounexguDs.setCrtTm(new Date());
					bopCfaLounexguDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
					bopCfaLounexguDs.setLstUpdTlr(gi.getTlrno());
					bopCfaLounexguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					bopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaLounexguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaLounexguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopCfaLounexguDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
					bopCfaLounexguDs.setBrNo(gi.getBrno());
					bopCfaLounexguDs.setFiller2(map.get("filler2").toString());
					bopCfaLounexguDs.setFiller1(map.get("filler1").toString());
					oc.setAttribute(BOPCfaLounexguRecordOperation.CMD, BOPCfaLounexguRecordOperation.CMD_INSERT);
				}else if("mod".equalsIgnoreCase(op)){
					mapToObject(bopCfaLounexguDs, map);
					bopCfaLounexguDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaLounexguDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_DA);
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
					}
					bopCfaLounexguDs.setActiondesc(null);
					oc.setAttribute(BOPCfaLounexguRecordOperation.CMD, BOPCfaLounexguRecordOperation.CMD_UPDATE);
				}else if("del".equalsIgnoreCase(op)){
					mapToObject(bopCfaLounexguDs, map);
					bopCfaLounexguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaLounexguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaLounexguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopCfaLounexguDs.setLstUpdTm(new Date());
					oc.setAttribute(BOPCfaLounexguRecordOperation.CMD, BOPCfaLounexguRecordOperation.CMD_DELETE);
				}else if("delInfo".equalsIgnoreCase(op)){
					String id = map.get("id").toString();

					String hql = " SELECT COUNT(bl) FROM BopCfaLounexguDs bl WHERE bl.filler1 = '"+id +"' AND recStatus <> '" + TopReportConstants.REPORT_RECSTATUS_07 + "' ";
					Integer count = rootDao.queryByHqlToCount(hql);
					if (count > 0) {
						ExceptionUtil.throwCommonException("该签约信息已存在变动，不能删除！");
					}
					mapToObject(bopCfaLounexguDs, map);
					bopCfaLounexguDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaLounexguDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_DA);
					bopCfaLounexguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bopCfaLounexguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaLounexguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaLounexguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopCfaLounexguDs.setLstUpdTm(new Date());
					oc.setAttribute(BOPCfaLounexguRecordOperation.CMD, BOPCfaLounexguRecordOperation.CMD_DELETE);
				}
			}

			oc.setAttribute(BOPCfaLounexguRecordOperation.IN_PARAM, bopCfaLounexguDs);
			OPCaller.call(BOPCfaLounexguRecordOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}