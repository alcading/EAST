package com.huateng.report.update;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopCFAExguTorInfo;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BopExguDsOperation;
import com.huateng.report.service.BopCFAExguDsService;
import com.huateng.report.service.BopExguTorDsService;
import com.huateng.report.utils.ReportUtils;


/**
* @author huangcheng
*
*/
public class BopExguBiLoanUpdate extends BaseUpdate  {

	private static final String DATASET1_ID_Ben="BOPForExguTorDsInfoBen";
	private static final String DATASET1_ID_Gua="BOPForExguTorDsInfoGua";
	private static final String DATASET2_ID="BOPForCFAExguDsInfoAdd";
	private static final String RECORD_DELETE="del";
	private static final String RECORD_ADD="new";
	private static final String RECORD_MOD="mod";
//	private static final String BopExguTorDs="BopExguTorDs";
//	private static final String BopCfaExguDs="BopCfaExguDs";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {

		// 返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		// 返回结果对象
		UpdateResultBean updateResultBeanExgu = multiUpdateResultBean.getUpdateResultBeanByID(DATASET2_ID);
		UpdateResultBean updateResultBeanTorBen = multiUpdateResultBean.getUpdateResultBeanByID(DATASET1_ID_Ben);
		UpdateResultBean updateResultBeanTorGua = multiUpdateResultBean.getUpdateResultBeanByID(DATASET1_ID_Gua);

		// 受益人/担保人/申请人信息
		BopExguTorDs bopExguTorDs = new BopExguTorDs();
		// 对外担保信息
		BopCfaExguDs bopCfaExguDs = new BopCfaExguDs();
		// 自定义bean ： 对外担保信息+受益人/担保人/被担保人信息
		BopCFAExguTorInfo bpETorTemp = new BopCFAExguTorInfo();
		// 对外担保服务
		BopCFAExguDsService serviceCFA = new BopCFAExguDsService();
		// 受益人/担保人/申请人服务
		BopExguTorDsService serviceTor = new BopExguTorDsService();
		OperationContext oc = new OperationContext();
		//担保受益人
		List<BopExguTorDs> delTorBenList = new ArrayList<BopExguTorDs>();
		List<BopExguTorDs> insertTorBenList = new ArrayList<BopExguTorDs>();
		List<BopExguTorDs> updateTorBenList = new ArrayList<BopExguTorDs>();
		//被担保人
		List<BopExguTorDs> delTorGuaList = new ArrayList<BopExguTorDs>();
		List<BopExguTorDs> insertTorGuaList = new ArrayList<BopExguTorDs>();
		List<BopExguTorDs> updateTorGuaList = new ArrayList<BopExguTorDs>();
		// 返回对象
		if (updateResultBeanExgu.hasNext()) {
			String op = updateResultBeanExgu.getParameter("op");
			String id = updateResultBeanExgu.getParameter("id");
			Map map = updateResultBeanExgu.next();
			mapToObject(bpETorTemp, map);
			if (!StringUtils.isEmpty(op)) {

				if (RECORD_ADD.equalsIgnoreCase(op)) {
					/*
					 * 操作状态=A-创建 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
					 * 是否已成功上报=0-否
					 */
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
					bopCfaExguDs.setBasere(bpETorTemp.getBasere());
					bopCfaExguDs.setFiller2(bpETorTemp.getFiller2());

					bopCfaExguDs.setId(guid);
					bopCfaExguDs.setCrtTm(new Date());
					bopCfaExguDs.setLstUpdTm(new Date());
					bopCfaExguDs.setLstUpdTlr(gInfo.getTlrno());
					bopCfaExguDs.setBrNo(gInfo.getBrno());

					bopCfaExguDs.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
					bopCfaExguDs.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_BA);
					bopCfaExguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaExguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaExguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopCfaExguDs.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
                    //担保申请人
					bopExguTorDs.setTorCode(bpETorTemp.getTorCodeGu());
					bopExguTorDs.setTorName(bpETorTemp.getTorNameGu());
					bopExguTorDs.setTorEnname(bpETorTemp.getTorEnnameGu());
					bopExguTorDs.setCountryCode(bpETorTemp.getCountryCodeGu());

					String guid1 = ReportUtils.getUUID();
					bopExguTorDs.setRecId(guid);
					bopExguTorDs.setCrtTm(new Date());
					bopExguTorDs.setId(guid1);
					bopExguTorDs.setTorType("03");

					oc.setAttribute(BopExguDsOperation.CMD,BopExguDsOperation.CMD_INSERT);
					oc.setAttribute(BopExguDsOperation.IN_PARAM_TOR,bopExguTorDs);
				} else if (RECORD_MOD.equalsIgnoreCase(op)) {
					GlobalInfo gInfo = GlobalInfo.getCurrentInstance();

					bopCfaExguDs = serviceCFA.load(id);
					bopExguTorDs = serviceTor.load(bpETorTemp.getIdGu());
//					//验证记录是否已经补录确认
//					String recStatus = bopExguTorDs.getRecStatus();
//					//记录状态不为01或02的不能进行修改
//					if(!recStatus.equals(TopReportConstants.REPORT_RECSTATUS_01)&&!recStatus.equals(TopReportConstants.REPORT_RECSTATUS_02)){
//						ExceptionUtil.throwCommonException("记录状态不为01或02的不能进行修改");
//					}

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
					bopCfaExguDs.setBasere(bpETorTemp.getBasere());
					bopCfaExguDs.setFiller2(bpETorTemp.getFiller2());

					if (StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES, bpETorTemp.getSubSuccess())) {
						/*
						 * 上报已成功
						 *
						 * 操作状态=C-修改 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
						 * 是否已成功上报=不变化
						 */
						bopCfaExguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
						bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bopCfaExguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bopCfaExguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					}
					else if (StringUtils.equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO, bpETorTemp.getSubSuccess())) {
						/*
						 * 上报未成功
						 *
						 * 操作状态=A-创建 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
						 * 是否已成功上报=不变化
						 */
						bopCfaExguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
						bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
						bopCfaExguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
						bopCfaExguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					}


					bopCfaExguDs.setLstUpdTlr(gInfo.getTlrno());
					bopCfaExguDs.setLstUpdTm(new Date());
					bopCfaExguDs.setBrNo(gInfo.getBrno());
					//担保申请人的信息更改
					bopExguTorDs.setTorName(bpETorTemp.getTorNameGu());
					bopExguTorDs.setTorEnname(bpETorTemp.getTorEnnameGu());
					bopExguTorDs.setTorCode(bpETorTemp.getTorCodeGu());

					oc.setAttribute(BopExguDsOperation.CMD,BopExguDsOperation.CMD_UPDATE);
					oc.setAttribute(BopExguDsOperation.IN_PARAM_TOR,bopExguTorDs);
				} else if (RECORD_DELETE.equalsIgnoreCase(op)) {
					/*
					 * 操作状态=D-删除 记录状态=02-编辑待确认 审核状态=00-未审核 回执状态=00-未返回
					 * 是否已成功上报=不变化
					 */
					GlobalInfo gInfo = GlobalInfo.getCurrentInstance();

					bopCfaExguDs = serviceCFA.load(bpETorTemp.getRecId());
			        //删除的时间 机构号 和 人员
					bopCfaExguDs.setLstUpdTlr(gInfo.getTlrno());
					bopCfaExguDs.setLstUpdTm(new Date());
					bopCfaExguDs.setBrNo(gInfo.getBrno());

					bopCfaExguDs.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
					bopCfaExguDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopCfaExguDs.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					bopCfaExguDs.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					/**判断签约信息是否绑定了责任余额或履约明细  begin*/
					String hql = " FROM BopCfaExguDs bd WHERE bd.filler1 = '"+bpETorTemp.getRecId()+"' ";
					hql += " AND bd.recStatus <> '"+TopReportConstants.REPORT_RECSTATUS_07+"' ";
//					hql += "AND bd.actiontype <> '"+TopReportConstants.REPORT_ACTIONTYPE_D+"'";
					ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
					List list = dao.queryByQL2List(hql);
					if(list.size()>0){
						ExceptionUtil.throwCommonException("该记录已经绑定了责任余额和履约明细 不能删除");
					}
					/**判断签约信息是否绑定了责任余额或履约明细  end*/
					bopCfaExguDs.setActiondesc(bpETorTemp.getActiondesc());
					oc.setAttribute(BopExguDsOperation.CMD,BopExguDsOperation.CMD_DELETE);
				}
			}
		}
		//被担保人 增删改

		List<BopExguTorDs>checkGuarantorList = new ArrayList<BopExguTorDs>();
		while (updateResultBeanTorGua.hasNext()) {
			BopExguTorDs bopExguTorDsSet = new BopExguTorDs();
			Map map = updateResultBeanTorGua.next();
			mapToObject(bopExguTorDsSet, map);

			if(UpdateResultBean.DELETE != updateResultBeanTorGua.getRecodeState()){
				checkGuarantorList.add(bopExguTorDsSet);
			}

			switch (updateResultBeanTorGua.getRecodeState()) {

			case UpdateResultBean.INSERT:
				String guidGua = ReportUtils.getUUID();
				bopExguTorDsSet.setId(guidGua);
				bopExguTorDsSet.setCrtTm(new Date());
				bopExguTorDsSet.setRecId(bopCfaExguDs.getId());
				bopExguTorDsSet.setTorType("02");
				bopExguTorDsSet.setTorTypeCode((String) map.get("torTypeCodeGua"));
				bopExguTorDsSet.setCountryCode((String) map.get("countryCodeGua"));
				insertTorGuaList.add(bopExguTorDsSet);
				oc.setAttribute(BopExguDsOperation.CMD_Tor_ADD,	BopExguDsOperation.CMD_INSERT);
				break;
			case UpdateResultBean.DELETE:
				bopExguTorDsSet = serviceTor.load(bopExguTorDsSet.getId());
				delTorGuaList.add(bopExguTorDsSet);
				oc.setAttribute(BopExguDsOperation.CMD_Tor_DEL,BopExguDsOperation.CMD_DELETE);
				break;
			case UpdateResultBean.MODIFY:
				bopExguTorDsSet = serviceTor.load(bopExguTorDsSet.getId());
				bopExguTorDsSet.setTorTypeCode((String) map.get("torTypeCodeGua"));
				bopExguTorDsSet.setCountryCode((String) map.get("countryCodeGua"));
				bopExguTorDsSet.setTorCode((String) map.get("torCode"));
				bopExguTorDsSet.setTorName((String) map.get("torName"));
				bopExguTorDsSet.setTorEnname((String) map.get("torEnname"));
				updateTorGuaList.add(bopExguTorDsSet);
				oc.setAttribute(BopExguDsOperation.CMD_Tor_MOD,BopExguDsOperation.CMD_UPDATE);
				break;
			default:
				break;
			}
		}
		//受益人 增删改
		List<BopExguTorDs>checkBeneficiaryList = new ArrayList<BopExguTorDs>();
		while (updateResultBeanTorBen.hasNext()) {
			BopExguTorDs bopExguTorDsSet = new BopExguTorDs();
			Map map = updateResultBeanTorBen.next();
			mapToObject(bopExguTorDsSet, map);

			if(UpdateResultBean.DELETE != updateResultBeanTorBen.getRecodeState()) {
				checkBeneficiaryList.add(bopExguTorDsSet);
			}
			switch (updateResultBeanTorBen.getRecodeState()) {

			case UpdateResultBean.INSERT:
				String guidBen = ReportUtils.getUUID();
				bopExguTorDsSet.setId(guidBen);
				bopExguTorDsSet.setCrtTm(new Date());
				bopExguTorDsSet.setRecId(bopCfaExguDs.getId());
				bopExguTorDsSet.setTorType("01");
				bopExguTorDsSet.setTorTypeCode((String) map.get("torTypeCodeBen"));
				bopExguTorDsSet.setCountryCode((String) map.get("countryCodeBen"));
				insertTorBenList.add(bopExguTorDsSet);
				oc.setAttribute(BopExguDsOperation.CMD_Tor_ADD,	BopExguDsOperation.CMD_INSERT);
				break;
			case UpdateResultBean.DELETE:
				bopExguTorDsSet = serviceTor.load(bopExguTorDsSet.getId());
				delTorBenList.add(bopExguTorDsSet);
				oc.setAttribute(BopExguDsOperation.CMD_Tor_DEL,BopExguDsOperation.CMD_DELETE);
				break;
			case UpdateResultBean.MODIFY:
				bopExguTorDsSet.setId(bopExguTorDsSet.getId());
				bopExguTorDsSet.setTorTypeCode((String) map.get("torTypeCodeBen"));
				bopExguTorDsSet.setCountryCode((String) map.get("countryCodeBen"));
				updateTorBenList.add(bopExguTorDsSet);
				oc.setAttribute(BopExguDsOperation.CMD_Tor_MOD,BopExguDsOperation.CMD_UPDATE);
				break;
			default:
				break;
			}
		}

		oc.setAttribute(BopExguDsOperation.IN_PARAM_EXGU, bopCfaExguDs);
		//被担保人list
		oc.setAttribute(BopExguDsOperation.IN_PARAM_INSERT_GUA, insertTorGuaList);
		oc.setAttribute(BopExguDsOperation.IN_PARAM_MOD_GUA, updateTorGuaList);
		oc.setAttribute(BopExguDsOperation.IN_PARAM_DEL_GUA, delTorGuaList);
		//受益人List
		oc.setAttribute(BopExguDsOperation.IN_PARAM_INSERT_BEN, insertTorBenList);
		oc.setAttribute(BopExguDsOperation.IN_PARAM_MOD_BEN, updateTorBenList);
		oc.setAttribute(BopExguDsOperation.IN_PARAM_DEL_BEN, delTorBenList);

		oc.setAttribute(BopExguDsOperation.IN_PARAM_CHECK_BENEFICIARY, checkBeneficiaryList);
		oc.setAttribute(BopExguDsOperation.IN_PARAM_CHECK_GUARANTOR, checkGuarantorList);

		OPCaller.call(BopExguDsOperation.ID, oc);

		return updateReturnBean;
	}
}