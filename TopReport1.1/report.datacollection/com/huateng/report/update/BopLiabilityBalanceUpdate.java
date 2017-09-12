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
import com.huateng.report.operation.BopExguDsOperation;
import com.huateng.report.operation.BopLiabilityBalanceOperation;
import com.huateng.report.service.BopCFAExguDsService;
import com.huateng.report.service.BopExguTorDsService;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.vaild.util.ReportDataVaildUtil;


/**
* @author huangcheng
*
*/
public class BopLiabilityBalanceUpdate extends BaseUpdate {


	private static final String DATASET2_ID="BopLiabilityBalanceAdd";
	private static final String RECORD_DELETE="del";
	private static final String RECORD_ADD="new";
	private static final String RECORD_MOD="mod";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		// 返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		// 返回结果对象
		UpdateResultBean updateResultBeanExguAdd = multiUpdateResultBean
				.getUpdateResultBeanByID(DATASET2_ID);

		// 对外担保信息
		BopCfaExguDs bopCfaExguDs = new BopCfaExguDs();
		BopExguTorDsService serviceTor = new BopExguTorDsService();
		// 受益人/担保人/申请人信息
		BopExguTorDs bopExguTorDs = new BopExguTorDs();
		// 自定义bean ： 对外担保信息+受益人/担保人/被担保人信息
		BopCFAExguTorInfo bpETorTemp = new BopCFAExguTorInfo();

		// 对外担保服务
		BopCFAExguDsService serviceCFA = new BopCFAExguDsService();
		// 受益人/担保人/申请人服务

		OperationContext oc = new OperationContext();

		// 返回对象

		if (updateResultBeanExguAdd.hasNext()) {
			String op = updateResultBeanExguAdd.getParameter("op");

			Map map = updateResultBeanExguAdd.next();
			mapToObject(bpETorTemp, map);
			if (!StringUtils.isEmpty(op)) {

				if (RECORD_ADD.equalsIgnoreCase(op)) {
					/*
					 * 操作状态=A-创建 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
					 * 是否已成功上报=0-否
					 */
					//新增对外担保基础信息
					GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
					String guid = ReportUtils.getUUID();
					//签约信息
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
					bopCfaExguDs.setExguarancode(bpETorTemp.getExguarancode());
					//责任余额信息
					bopCfaExguDs.setWabachandate(bpETorTemp.getWabachandate());
					bopCfaExguDs.setBasere(bpETorTemp.getBasere());
					bopCfaExguDs.setFiller1(bpETorTemp.getFiller1());
					bopCfaExguDs.setFiller2(bpETorTemp.getFiller2());

					bopCfaExguDs.setId(guid);
					bopCfaExguDs.setCrtTm(new Date());
					bopCfaExguDs.setLstUpdTm(new Date());
					bopCfaExguDs.setLstUpdTlr(gInfo.getTlrno());
					bopCfaExguDs.setBrNo(gInfo.getBrno());

					bopCfaExguDs
							.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaExguDs
							.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_BB);
					bopCfaExguDs
							.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					bopCfaExguDs
							.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaExguDs
							.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaExguDs
							.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopCfaExguDs
							.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);

					ReportDataVaildUtil.executeVaild(bopCfaExguDs.getApptype(), bopCfaExguDs.getCurrentfile(), bopCfaExguDs);
					//新增对外担保基础信息中的担保申请人信息
					bopExguTorDs.setTorCode(bpETorTemp.getTorCodeGu());
					bopExguTorDs.setTorName(bpETorTemp.getTorNameGu());
					bopExguTorDs.setTorEnname(bpETorTemp.getTorEnnameGu());


					String guid1 = ReportUtils.getUUID();
					bopExguTorDs.setRecId(guid);
					bopExguTorDs.setCrtTm(new Date());
					bopExguTorDs.setId(guid1);
					bopExguTorDs.setTorType("03");
					oc.setAttribute(BopLiabilityBalanceOperation.CMD,
							BopLiabilityBalanceOperation.CMD_INSERT);
					oc.setAttribute(BopExguDsOperation.IN_PARAM_TOR,
							bopExguTorDs);

				} else if (RECORD_MOD.equalsIgnoreCase(op)) {
					bopCfaExguDs = serviceCFA.load(bpETorTemp.getRecId());
					bopExguTorDs = serviceTor.load(bpETorTemp.getIdGu());
//					//验证记录是否已经补录确认
//					String recStatus = bopCfaExguDs.getRecStatus();
//					//记录状态不为01或02的进行修改
//					if(!recStatus.equals(TopReportConstants.REPORT_RECSTATUS_01)&&!recStatus.equals(TopReportConstants.REPORT_RECSTATUS_02)){
//						ExceptionUtil.throwCommonException("该记录已经补录确认不能进行修改操作");
//					}

					GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
					//签约信息
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
					bopCfaExguDs.setExguarancode(bpETorTemp.getExguarancode());
					//责任余额信息
					if (StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES, bpETorTemp.getSubSuccess())) {
						/*
						 * 上报已成功
						 *
						 * 操作状态=C-修改 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
						 * 是否已成功上报=不变化
						 */
						bopCfaExguDs
								.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
						bopCfaExguDs
								.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bopCfaExguDs
								.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bopCfaExguDs
								.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

					}

					else if (StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO, bpETorTemp.getSubSuccess())) {
						/*
						 * 上报未成功
						 *
						 * 操作状态=A-创建 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
						 * 是否已成功上报=不变化
						 */
						bopCfaExguDs
								.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
						bopCfaExguDs
								.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
						bopCfaExguDs
								.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bopCfaExguDs
								.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bopCfaExguDs
								.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

					}

					bopCfaExguDs.setWabachandate(bpETorTemp.getWabachandate());
					bopCfaExguDs.setBasere(bpETorTemp.getBasere());
					bopCfaExguDs.setFiller1(bpETorTemp.getFiller1());
					bopCfaExguDs.setLstUpdTm(new Date());

					bopCfaExguDs.setLstUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
					bopCfaExguDs.setBrNo(GlobalInfo.getCurrentInstance().getBrno());

					ReportDataVaildUtil.executeVaild(bopCfaExguDs.getApptype(), bopCfaExguDs.getCurrentfile(), bopCfaExguDs);
					//担保申请人的信息更改
					bopExguTorDs.setTorName(bpETorTemp.getTorNameGu());
					bopExguTorDs.setTorEnname(bpETorTemp.getTorEnnameGu());
					bopExguTorDs.setTorCode(bpETorTemp.getTorCodeGu());




					oc.setAttribute(BopLiabilityBalanceOperation.CMD,
							BopLiabilityBalanceOperation.CMD_UPDATE);
					oc.setAttribute(BopExguDsOperation.IN_PARAM_TOR,
							bopExguTorDs);

				} else if (RECORD_DELETE.equalsIgnoreCase(op)) {
					/*
					 * 操作状态=D-删除 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
					 * 是否已成功上报=不变化
					 */
					bopCfaExguDs = serviceCFA.load(bpETorTemp.getRecId());


					GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
					bopCfaExguDs.setActiondesc(bpETorTemp.getActiondesc());

					bopCfaExguDs.setLstUpdTlr(gInfo.getTlrno());
					bopCfaExguDs.setLstUpdTm(new Date());
					bopCfaExguDs.setBrNo(GlobalInfo.getCurrentInstance().getBrno());
					bopCfaExguDs
							.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bopCfaExguDs
							.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaExguDs
							.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaExguDs
							.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);

					oc.setAttribute(BopLiabilityBalanceOperation.CMD,
							BopLiabilityBalanceOperation.CMD_DELETE);

				}

			}

		}
		oc.setAttribute(BopLiabilityBalanceOperation.IN_PARAM_EXGU,
				bopCfaExguDs);


		OPCaller.call(BopLiabilityBalanceOperation.ID, oc);

		return updateReturnBean;
	}

}
