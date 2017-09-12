package com.huateng.report.update;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
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

public class BopForSameInduDepositUpdate extends BaseUpdate{

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("BopForSameInduDepositInfoCol");

			BopCfaExdebtDs bopCfaExdebtDs = new BopCfaExdebtDs();
			BopCfaCreditorDs bopCfaCreditorDs = new BopCfaCreditorDs();

			OperationContext oc = new OperationContext();

			while(updateResultBean.hasNext()){
				//签约信息新增
				String op  = updateResultBean.getParameter("op");
				Map map = updateResultBean.next();
				String Uuid = ReportUtils.getUUID();
				if("new".equalsIgnoreCase(op)){
					bopCfaExdebtDs.setId(Uuid);//记录主键
					//基本信息
					bopCfaExdebtDs.setExdebtcode(map.get("exdebtcode").toString());//外债编号
					//bopCfaExdebtDs.setLimitType(map.get("limitType").toString()); //账户类型
					bopCfaExdebtDs.setDebtorcode(map.get("debtorcode").toString());//债务人代码
					bopCfaExdebtDs.setDebtype(map.get("debtype").toString());//债务类型
					bopCfaExdebtDs.setValuedate(map.get("valuedate").toString());//起息日
					bopCfaExdebtDs.setContractcurr(map.get("contractcurr").toString());//签约币种
					bopCfaExdebtDs.setFloatrate(map.get("floatrate").toString());//是否浮动利率
					if(map.get("anninrate").toString()!=null && !"".equals(map.get("anninrate").toString())){
						BigDecimal anninrate=new BigDecimal(map.get("anninrate").toString());

						bopCfaExdebtDs.setAnninrate(anninrate);
					}//年化利率值
					bopCfaExdebtDs.setSpapfeboindex(map.get("spapfeboindex").toString());//是否经外汇局特批不需占用指标
					bopCfaExdebtDs.setRemark(map.get("remark").toString());//备注
					bopCfaExdebtDs.setFiller2(map.get("filler2").toString());//业务流水号

					//系统信息
					GlobalInfo gi = GlobalInfo.getCurrentInstance();
					bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));//工作日期
					bopCfaExdebtDs.setCrtTm(new Date());
					bopCfaExdebtDs.setLstUpdTm(new Date());
					bopCfaExdebtDs.setLstUpdTlr(gi.getTlrno());
					bopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);	//应用类型
					bopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);//文件类型
					bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);//操作类型创建
					bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);//记录状态待确认
					bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);//审核状态 未审核
					bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);//回执状态 00 未返回
					bopCfaExdebtDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);//未成功上报
					bopCfaExdebtDs.setBrNo(gi.getBrno()); //机构号



					//债权人
					bopCfaCreditorDs.setId(ReportUtils.getUUID());
					bopCfaCreditorDs.setCreditorcode(map.get("creditorcode").toString());//债权人代码
					bopCfaCreditorDs.setCreditorname(map.get("creditorname").toString());//债权人中文名称
					bopCfaCreditorDs.setCreditornamen(map.get("creditornamen").toString());//债权人英文名称
					bopCfaCreditorDs.setCreditortype(map.get("creditortype").toString());//债权人类型代码
					bopCfaCreditorDs.setCrehqcode(map.get("crehqcode").toString());//债权人总部所在国家（地区）代码
					bopCfaCreditorDs.setOpercode(map.get("opercode").toString());//债权人经营地所在国家（地区）代码
					bopCfaCreditorDs.setCrtTm(new Date());//创建时间
					bopCfaCreditorDs.setRecId(Uuid);
					oc.setAttribute(BopForSameInduDepositOperation.CMD, BopForSameInduDepositOperation.CMD_SIGN_INSERT);
				}else if("mod".equalsIgnoreCase(op)){

					bopCfaExdebtDs.setId(map.get("id").toString());//记录主键
					//基本信息
					bopCfaExdebtDs.setExdebtcode(map.get("exdebtcode").toString());//外债编号
					//bopCfaExdebtDs.setLimitType(map.get("limitType").toString()); //外债编号
					bopCfaExdebtDs.setDebtorcode(map.get("debtorcode").toString());//债务人代码
					bopCfaExdebtDs.setDebtype(map.get("debtype").toString());//债务类型
					bopCfaExdebtDs.setValuedate(map.get("valuedate").toString());//起息日
					bopCfaExdebtDs.setContractcurr(map.get("contractcurr").toString());//签约币种
					bopCfaExdebtDs.setFloatrate(map.get("floatrate").toString());//是否浮动利率
					if(map.get("anninrate").toString()!=null && !"".equals(map.get("anninrate").toString())){
						BigDecimal anninrate=new BigDecimal(map.get("anninrate").toString());
						bopCfaExdebtDs.setAnninrate(anninrate);
					}//年化利率值
					bopCfaExdebtDs.setSpapfeboindex(map.get("spapfeboindex").toString());//是否经外汇局特批不需占用指标
					bopCfaExdebtDs.setRemark(map.get("remark").toString());//备注
					bopCfaExdebtDs.setFiller2(map.get("filler2").toString());//业务流水
					if (null != map.get("crtTm") && StringUtils.isNotEmpty(String.valueOf(map.get("crtTm")))) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
						bopCfaExdebtDs.setCrtTm(sdf.parse(String.valueOf(map.get("crtTm"))));
					}
					bopCfaExdebtDs.setSubSuccess(map.get("subSuccess").toString());

					//系统信息
					GlobalInfo gi = GlobalInfo.getCurrentInstance();
					bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));//工作日期
					bopCfaExdebtDs.setBrNo(gi.getBrno()); //机构号
					bopCfaExdebtDs.setLstUpdTm(new Date());
					bopCfaExdebtDs.setLstUpdTlr(map.get("lstUpdTlr").toString());
					bopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);	//应用类型
					bopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);//文件类型
					if(bopCfaExdebtDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)){
						bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);//操作类型创建
					}else{
						bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);//操作类型创建
					}
					bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);//记录状态待确认
					bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);//审核状态 未审核
					bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);//回执状态 00 未返回

					//债权人
					bopCfaCreditorDs.setId(map.get("creditorid").toString());
					bopCfaCreditorDs.setCreditorcode(map.get("creditorcode").toString());//债权人代码
					bopCfaCreditorDs.setCreditorname(map.get("creditorname").toString());//债权人中文名称
					bopCfaCreditorDs.setCreditornamen(map.get("creditornamen").toString());//债权人英文名称
					bopCfaCreditorDs.setCreditortype(map.get("creditortype").toString());//债权人类型代码
					bopCfaCreditorDs.setCrehqcode(map.get("crehqcode").toString());//债权人总部所在国家（地区）代码
					bopCfaCreditorDs.setOpercode(map.get("opercode").toString());//债权人经营地所在国家（地区）代码
					bopCfaCreditorDs.setRecId(map.get("id").toString());
					oc.setAttribute(BopForSameInduDepositOperation.CMD, BopForSameInduDepositOperation.CMD_SIGN_UPDATE);

				} else if("del".equalsIgnoreCase(op)) {
					bopCfaExdebtDs.setId(map.get("id").toString());//记录主键
					//基本信息
					bopCfaExdebtDs.setExdebtcode(map.get("exdebtcode").toString());//外债编号
					//bopCfaExdebtDs.setLimitType(map.get("limitType").toString()); //外债编号
					bopCfaExdebtDs.setDebtorcode(map.get("debtorcode").toString());//债务人代码
					bopCfaExdebtDs.setDebtype(map.get("debtype").toString());//债务类型
					bopCfaExdebtDs.setValuedate(map.get("valuedate").toString());//起息日
					bopCfaExdebtDs.setContractcurr(map.get("contractcurr").toString());//签约币种
					bopCfaExdebtDs.setFloatrate(map.get("floatrate").toString());//是否浮动利率
					if(map.get("anninrate").toString()!=null && !"".equals(map.get("anninrate").toString())){
						BigDecimal anninrate=new BigDecimal(map.get("anninrate").toString());
						bopCfaExdebtDs.setAnninrate(anninrate);
					}//年化利率值
					bopCfaExdebtDs.setSpapfeboindex(map.get("spapfeboindex").toString());//是否经外汇局特批不需占用指标
					bopCfaExdebtDs.setRemark(map.get("remark").toString());//备注
					bopCfaExdebtDs.setFiller2(map.get("filler2").toString());//业务流水
					if (null != map.get("crtTm") && StringUtils.isNotEmpty(String.valueOf(map.get("crtTm")))) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
						bopCfaExdebtDs.setCrtTm(sdf.parse(String.valueOf(map.get("crtTm"))));
					}
					bopCfaExdebtDs.setSubSuccess(map.get("subSuccess").toString());//是否成功上报过
					bopCfaExdebtDs.setActiondesc(map.get("actiondesc").toString());//删除原因
					//系统信息
					GlobalInfo gi = GlobalInfo.getCurrentInstance();
					bopCfaExdebtDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));//工作日期
					bopCfaExdebtDs.setBrNo(gi.getBrno()); //机构号
					bopCfaExdebtDs.setLstUpdTm(new Date());
					bopCfaExdebtDs.setLstUpdTlr(map.get("lstUpdTlr").toString());
					bopCfaExdebtDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);	//应用类型
					bopCfaExdebtDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);//文件类型
					bopCfaExdebtDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);//操作类型创建
					bopCfaExdebtDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);//记录状态待确认
					bopCfaExdebtDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);//审核状态 未审核
					bopCfaExdebtDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);//回执状态 00 未返回
					oc.setAttribute(BopForSameInduDepositOperation.CMD, BopForSameInduDepositOperation.CMD_SIGN_DELETE);

				}
			}
			oc.setAttribute(BopForSameInduDepositOperation.PARAM_EXDEBTDS,bopCfaExdebtDs);
			oc.setAttribute(BopForSameInduDepositOperation.PARAM_CREDITORSDS, bopCfaCreditorDs);
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