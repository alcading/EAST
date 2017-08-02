package com.huateng.report.update;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaExdebtDs;

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
import com.huateng.report.operation.BopForSameInduDepositOperation;
import com.huateng.report.utils.ReportUtils;

public class BopForSameInduDepositBalanceUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AppException {
		// TODO Auto-generated method stub
		
		
		try {
			
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean  updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("BopForSameInduDepositBalanceInfoCol");
			
			BopCfaExdebtDs bopCfaExdebtDs = new BopCfaExdebtDs();
			OperationContext oc = new OperationContext();
			while(updateResultBean.hasNext()){
				GlobalInfo gi = GlobalInfo.getCurrentInstance();
				String op  = updateResultBean.getParameter("op");
				Map map = updateResultBean.next();
				String Uuid = ReportUtils.getUUID();
				if("newBalance".equalsIgnoreCase(op)){

					bopCfaExdebtDs.setId(Uuid);//记录主键
					bopCfaExdebtDs.setFiller1(map.get("filler1").toString());
					//基本信息
					
					
					//余额信息
					bopCfaExdebtDs.setExdebtcode(map.get("exdebtcode").toString());//外债编号
					bopCfaExdebtDs.setBuscode(map.get("buscode").toString()); // 银行账号
					bopCfaExdebtDs.setChangeno(map.get("changeno").toString());// 变动编号
					
					if(map.get("accoamount").toString()!=null && !"".equals(map.get("accoamount").toString())){
						BigDecimal accoamount=new BigDecimal(map.get("accoamount").toString()); 
						
						bopCfaExdebtDs.setAccoamount(accoamount);
					}// 外债余额
					
					
					bopCfaExdebtDs.setChdate(map.get("chdate").toString());//变动日期
					bopCfaExdebtDs.setRemark(map.get("remark").toString());//备注
					bopCfaExdebtDs.setBalanceFileType(map.get("currentfile").toString());
					//系统信息
					
					bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));//工作日期
					bopCfaExdebtDs.setCrtTm(new Date());
					bopCfaExdebtDs.setLstUpdTm(new Date());
					bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
					bopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);	//应用类型 
					bopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
					bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);//操作类型创建
					bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);//记录状态待确认
					bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);//审核状态 未审核
					bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);//回执状态 00 未返回
					bopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);//未成功上报
					bopCfaExdebtDs.setBrNo(gi.getBrno()); //机构号
					bopCfaExdebtDs.setFiller2(map.get("filler2").toString());
					bopCfaExdebtDs.setBalanceFileType(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);
					oc.setAttribute(BopForSameInduDepositOperation.CMD, BopForSameInduDepositOperation.CMD_BALANCE_INSERT);
				}else if("modBalance".equalsIgnoreCase(op)){
					mapToObject(bopCfaExdebtDs, map);
					if(bopCfaExdebtDs.getSubSuccess().equalsIgnoreCase(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)){
						bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);//操作类型创建
						bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);//记录状态待确认
						bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);//审核状态 未审核
						bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);//回执状态 00 未返回
						bopCfaExdebtDs.setLstUpdTm(new Date());// 最新更新时间
						bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());//最新更新人
						bopCfaExdebtDs.setBalanceFileType(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);
					}else{
						bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);//操作类型修改
						bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);//记录状态待确认
						bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);//审核状态 未审核
						bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);//回执状态 00 未返回
						bopCfaExdebtDs.setLstUpdTm(new Date());// 最新更新时间
						bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());//最新更新人
						bopCfaExdebtDs.setBalanceFileType(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);
					}
				
					oc.setAttribute(BopForSameInduDepositOperation.CMD, BopForSameInduDepositOperation.CMD_BALANCE_UPDATE);
				}else if("delBalance".equalsIgnoreCase(op)){
					mapToObject(bopCfaExdebtDs, map);
					bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);//操作类型删除
					bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);//记录状态待确认
					bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);//审核状态 未审核
					bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);//回执状态 00 未返回
					bopCfaExdebtDs.setLstUpdTm(new Date());// 最新更新时间
					bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());//最新更新人\
					oc.setAttribute(BopForSameInduDepositOperation.CMD, BopForSameInduDepositOperation.CMD_BALANCE_DELETE);
					bopCfaExdebtDs.setBalanceFileType(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);
				}
				
			}

			oc.setAttribute(BopForSameInduDepositOperation.PARAM_EXDEBTDS,bopCfaExdebtDs);
			OPCaller.call("BopForSameInduDepositOperation", oc);
			return updateReturnBean;
			
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
		
	
	}
	
}
