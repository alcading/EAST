package com.huateng.report.update;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopCFAExguTorInfo;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BopGuperOperation;
import com.huateng.report.service.BopCFAExguDsService;
import com.huateng.report.service.BopExguTorDsService;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;

/**
* @author huangcheng
*
*/
public class BopGuperUpdate extends BaseUpdate {

	private static final String DATASET2_ID="BOPForGuperDsInfoAdd";
	private static final String RECORD_DELETE="del";
	private static final String RECORD_ADD="new";
	private static final String RECORD_MOD="mod";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//返回结果对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET2_ID);
		//履约明细
		//对外担保信息
		BopCfaExguDs  bopCfaExguDs = new BopCfaExguDs();
		//自定义bean ： 对外担保信息+受益人/担保人/被担保人信息
		BopCFAExguTorInfo bpETorTemp = new BopCFAExguTorInfo();
		//担保申请人信息
		BopExguTorDs bopExguTorDsGu = new BopExguTorDs();
		//受益人信息
		BopExguTorDs bopExguTorDsBen = new BopExguTorDs();
		//对外担保服务
		BopCFAExguDsService  serviceCFA = new BopCFAExguDsService();
		//担保人 申请人 被担保人服务
		BopExguTorDsService  serviceTor = new BopExguTorDsService();
		OperationContext oc = new OperationContext();
		//返回对象
		if(updateResultBean.hasNext())
		{
			String op = updateResultBean.getParameter("op");
			Map map =updateResultBean.next();
			mapToObject(bpETorTemp,map);
			if(!StringUtils.isEmpty(op))
			{
				if(RECORD_ADD.equalsIgnoreCase(op))
				{
					/*操作状态=A-创建
					记录状态=02-编辑待确认
					审核状态=00-未审核
					回执状态=00-未返回
					是否已成功上报=0-否*/
					GlobalInfo  gInfo =GlobalInfo.getCurrentInstance();
					String guid = ReportUtils.getUUID();
					//签约信息
					bopCfaExguDs.setExguarancode(bpETorTemp.getExguarancode());
					bopCfaExguDs.setGuarantorcode(bpETorTemp.getGuarantorcode());
					bopCfaExguDs.setGuarantype(bpETorTemp.getGuarantype());
					bopCfaExguDs.setActiontype(bpETorTemp.getActiontype());
					bopCfaExguDs.setAppdocuno(bpETorTemp.getAppdocuno());
					bopCfaExguDs.setContractdate(bpETorTemp.getContractdate());
					bopCfaExguDs.setMaturity(bpETorTemp.getMaturity());
					bopCfaExguDs.setMaindebtcurr(bpETorTemp.getMaindebtcurr());
					bopCfaExguDs.setGuarancurr(bpETorTemp.getGuarancurr());
					bopCfaExguDs.setGuaranamount(bpETorTemp.getGuaranamount());
					bopCfaExguDs.setMaindebtamount(bpETorTemp.getMaindebtamount());
					bopCfaExguDs.setRemark(bpETorTemp.getRemark());
					bopCfaExguDs.setWorkDate(gInfo.getTxdate().toString().replaceAll("-", ""));
					bopCfaExguDs.setFiller1(bpETorTemp.getFiller1());
					//履约信息
					bopCfaExguDs.setBuscode(bpETorTemp.getBuscode());
					bopCfaExguDs.setComplianceno(bpETorTemp.getComplianceno());
					bopCfaExguDs.setFiller2(bpETorTemp.getFiller2());
					bopCfaExguDs.setGuperdate(bpETorTemp.getGuperdate());
					bopCfaExguDs.setGupercurr(bpETorTemp.getGupercurr());
					bopCfaExguDs.setGuperamount(bpETorTemp.getGuperamount());
					bopCfaExguDs.setPguperamount(bpETorTemp.getPguperamount());
					//受益人信息
					bopCfaExguDs.setBename(bpETorTemp.getTorNameBen());
					bopCfaExguDs.setBenamen(bpETorTemp.getTorEnnameBen());
					bopCfaExguDs.setBencode(bpETorTemp.getTorCodeBen());

					bopCfaExguDs.setId(guid);
					bopCfaExguDs.setCrtTm(new Date());
					bopCfaExguDs.setLstUpdTm(new Date());
					bopCfaExguDs.setLstUpdTlr(gInfo.getTlrno());
					bopCfaExguDs.setBrNo(gInfo.getBrno());

					bopCfaExguDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaExguDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_BC);
					bopCfaExguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaExguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
				    bopCfaExguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopCfaExguDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

					ReportDataVaildUtil.executeVaild(bopCfaExguDs.getApptype(), bopCfaExguDs.getCurrentfile(), bopCfaExguDs);
					//新增对外担保基础信息中的担保申请人信息
					bopExguTorDsGu.setTorCode(bpETorTemp.getTorCodeGu());
					bopExguTorDsGu.setTorName(bpETorTemp.getTorNameGu());
					bopExguTorDsGu.setTorEnname(bpETorTemp.getTorEnnameGu());
					bopExguTorDsGu.setRecId(guid);
					bopExguTorDsGu.setCrtTm(new Date());
					bopExguTorDsGu.setId(ReportUtils.getUUID());
					bopExguTorDsGu.setTorType("03");
					//新增受益人信息
					bopExguTorDsBen.setTorCode(bpETorTemp.getTorCodeBen());
					bopExguTorDsBen.setTorName(bpETorTemp.getTorNameBen());
					bopExguTorDsBen.setTorEnname(bpETorTemp.getTorEnnameBen());
					bopExguTorDsBen.setRecId(guid);
					bopExguTorDsBen.setCrtTm(new Date());
					bopExguTorDsBen.setId(ReportUtils.getUUID());
					bopExguTorDsBen.setTorType("01");

					oc.setAttribute(BopGuperOperation.CMD, BopGuperOperation.CMD_INSERT);
					oc.setAttribute(BopGuperOperation.IN_PARAM_TORGU, bopExguTorDsGu);
					oc.setAttribute(BopGuperOperation.IN_PARAM_TORBEN, bopExguTorDsBen);

				}
				else if(RECORD_MOD.equalsIgnoreCase(op))
				{
					bopCfaExguDs = serviceCFA.load(bpETorTemp.getRecId());//加载要修改的bopCfaExguDs
					GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
					//签约信息
					bopCfaExguDs.setExguarancode(bpETorTemp.getExguarancode());
					bopCfaExguDs.setGuarantorcode(bpETorTemp.getGuarantorcode());
					bopCfaExguDs.setGuarantype(bpETorTemp.getGuarantype());
					bopCfaExguDs.setActiontype(bpETorTemp.getActiontype());

					bopCfaExguDs.setActiondesc(bpETorTemp.getActiondesc());

					bopCfaExguDs.setAppdocuno(bpETorTemp.getAppdocuno());
					bopCfaExguDs.setContractdate(bpETorTemp.getContractdate());
					bopCfaExguDs.setMaturity(bpETorTemp.getMaturity());
					bopCfaExguDs.setMaindebtcurr(bpETorTemp.getMaindebtcurr());
					bopCfaExguDs.setGuarancurr(bpETorTemp.getGuarancurr());
					bopCfaExguDs.setGuaranamount(bpETorTemp.getGuaranamount());
					bopCfaExguDs.setMaindebtamount(bpETorTemp.getMaindebtamount());
					bopCfaExguDs.setRemark(bpETorTemp.getRemark());
					bopCfaExguDs.setWorkDate(gInfo.getTxdate().toString().replaceAll("-", ""));
					bopCfaExguDs.setFiller1(bpETorTemp.getFiller1());
					//履约信息
					bopCfaExguDs.setBuscode(bpETorTemp.getBuscode());
					bopCfaExguDs.setComplianceno(bpETorTemp.getComplianceno());
					bopCfaExguDs.setFiller2(bpETorTemp.getFiller2());
					bopCfaExguDs.setGuperdate(bpETorTemp.getGuperdate());
					bopCfaExguDs.setGupercurr(bpETorTemp.getGupercurr());
					bopCfaExguDs.setGuperamount(bpETorTemp.getGuperamount());
					bopCfaExguDs.setPguperamount(bpETorTemp.getPguperamount());
					//受益人信息
					bopCfaExguDs.setBename(bpETorTemp.getTorNameBen());
					bopCfaExguDs.setBenamen(bpETorTemp.getTorEnnameBen());
					bopCfaExguDs.setBencode(bpETorTemp.getTorCodeBen());
					//受益人修改
					bopExguTorDsBen = serviceTor.load(bpETorTemp.getIdBen());
					bopExguTorDsBen.setTorCode(bpETorTemp.getTorCodeBen());
					bopExguTorDsBen.setTorName(bpETorTemp.getTorNameBen());
					bopExguTorDsBen.setTorEnname(bpETorTemp.getTorEnnameBen());

					if(StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES, bpETorTemp.getSubSuccess()))
					{
						/*
						 * 上报已成功
						 *
						 操作状态=C-修改
						记录状态=02-编辑待确认
						审核状态=00-未审核
						回执状态=00-未返回
						是否已成功上报=不变化*/
						bopCfaExguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
						bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bopCfaExguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bopCfaExguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					}
					else if(StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO, bpETorTemp.getSubSuccess()))
					{
						/*
						 * 上报未成功
						 *
						 操作状态=A-创建
						记录状态=02-编辑待确认
						审核状态=00-未审核
						回执状态=00-未返回
						是否已成功上报=不变化*/
						bopCfaExguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
						bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bopCfaExguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bopCfaExguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					}

					bopCfaExguDs.setLstUpdTlr(gInfo.getTlrno());
					bopCfaExguDs.setLstUpdTm(new Date());

					ReportDataVaildUtil.executeVaild(bopCfaExguDs.getApptype(), bopCfaExguDs.getCurrentfile(), bopCfaExguDs);
					//担保申请人的信息更改
					bopExguTorDsGu = serviceTor.load(bpETorTemp.getIdGu());//加载担保人bean
					bopExguTorDsGu.setTorName(bpETorTemp.getTorNameGu());
					bopExguTorDsGu.setTorEnname(bpETorTemp.getTorEnnameGu());
					bopExguTorDsGu.setTorCode(bpETorTemp.getTorCodeGu());
					oc.setAttribute(BopGuperOperation.CMD, BopGuperOperation.CMD_UPDATE);
					oc.setAttribute(BopGuperOperation.IN_PARAM_TORGU, bopExguTorDsGu);
					oc.setAttribute(BopGuperOperation.IN_PARAM_TORBEN, bopExguTorDsBen);
				}
				else if(RECORD_DELETE.equalsIgnoreCase(op))
				{
					/*
					 操作状态=D-删除
					记录状态=02-编辑待确认
					审核状态=00-未审核
					回执状态=00-未返回
					是否已成功上报=不变化
					*/
					GlobalInfo gInfo = GlobalInfo.getCurrentInstance();

					bopCfaExguDs =  serviceCFA.load(bpETorTemp.getRecId());
					bopCfaExguDs.setLstUpdTlr(gInfo.getTlrno());
					bopCfaExguDs.setLstUpdTm(new Date());

					bopCfaExguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaExguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaExguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopCfaExguDs.setActiondesc(bpETorTemp.getActiondesc());
					oc.setAttribute(BopGuperOperation.CMD, BopGuperOperation.CMD_DELETE);
				}
			}
		}

		oc.setAttribute(BopGuperOperation.IN_PARAM_EXGU, bopCfaExguDs);
	    OPCaller.call(BopGuperOperation.ID, oc);
	   return updateReturnBean;
	}
}