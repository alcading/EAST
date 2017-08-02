package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;

import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopCFAExguTorInfo;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

/**
 *
 * 对外担保 update insert delete Getter
 * @author huang cheng
 * @version 1.0
 * 2012-8-30
 *
 * */
@SuppressWarnings("unchecked")
public class BopForCFAExguDsInfoAddGetter extends BaseGetter {

	private static final String DELETE_CMD="del";
	private static final String NEW_CMD="new";
	private static final String MOD_CMD="mod";
	private static final String DETAILE_CMD="detail";

	private static final String HQL_TOR= " FROM BopExguTorDs bet WHERE bet.recId = ? AND bet.torType = '03'";

	private static final String HQL_EXGU= " FROM BopCfaExguDs bce WHERE bce.id = ? ";

	@SuppressWarnings("rawtypes")
	public Result call() throws AppException {
		try {
			List queryResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(), queryResult,getResult());
			result.setContent(queryResult);
			result.getPage().setTotalPage(0);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	private List getData() throws CommonException
	{
		List<BopCFAExguTorInfo> list = new ArrayList<BopCFAExguTorInfo>();
		String id = getCommQueryServletRequest().getParameter("id");
		String op = getCommQueryServletRequest().getParameter("op");
		BopCFAExguTorInfo exguTorInfo = new BopCFAExguTorInfo();
//		List<BopCfaExguDs> listExgu = new ArrayList<BopCfaExguDs>();
//		List<BopExguTorDs> listTor = new ArrayList<BopExguTorDs>();//担保申请人List
		if(NEW_CMD.equals(op)){
//			BopCFAExguTorInfo.setExguarancode(ReportUtils.getBussinessNo(TopReportConstants.REPORT_BUSITYPE_BOP));
			exguTorInfo.setExguarancode(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_CFA_BA));
			GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
			exguTorInfo.setGuarantorcode(gInfo.getBrno());
			list.add(exguTorInfo);
			return list;
		}else if(DETAILE_CMD.equalsIgnoreCase(op) || DELETE_CMD.equalsIgnoreCase(op) || MOD_CMD.equalsIgnoreCase(op)){
//			String hqlTor= " FROM BopExguTorDs bet WHERE bet.recId = '"+id+"' AND bet.torType = '03'";
//			String hqlExgu= " FROM BopCfaExguDs bce WHERE bce.id = '"+id+"'";

			ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
//			listExgu = dao.queryByQL2List(hqlExgu);
			List<BopCfaExguDs> listExgu = dao.queryByQL2List(HQL_EXGU, new Object[]{id}, null);

//			listTor = dao.queryByQL2List(hqlTor);
			List<BopExguTorDs> listTor = dao.queryByQL2List(HQL_TOR, new Object[]{id}, null);

			BopCfaExguDs bopCfaExguDs = (BopCfaExguDs) listExgu.get(0);
			exguTorInfo.setActiondesc(bopCfaExguDs.getActiondesc());
			exguTorInfo.setActiontype(bopCfaExguDs.getActiontype());
			exguTorInfo.setAppdocuno(bopCfaExguDs.getAppdocuno());
			exguTorInfo.setApproveResult(bopCfaExguDs.getApproveResult());
			exguTorInfo.setApproveStatus(bopCfaExguDs.getApproveStatus());
			exguTorInfo.setApptype(bopCfaExguDs.getApptype());
			exguTorInfo.setBasere(bopCfaExguDs.getBasere());
			exguTorInfo.setBrNo(bopCfaExguDs.getBrNo());
			exguTorInfo.setBuscode(bopCfaExguDs.getBuscode());
			exguTorInfo.setComplianceno(bopCfaExguDs.getComplianceno());
			exguTorInfo.setContractdate(bopCfaExguDs.getContractdate());
			exguTorInfo.setCrtTm(bopCfaExguDs.getCrtTm());
			exguTorInfo.setCurrentfile(bopCfaExguDs.getCurrentfile());
			exguTorInfo.setExguarancode(bopCfaExguDs.getExguarancode());
			exguTorInfo.setGuaranamount(bopCfaExguDs.getGuaranamount());
			exguTorInfo.setGuarancurr(bopCfaExguDs.getGuarancurr());
			exguTorInfo.setGuarantorcode(bopCfaExguDs.getGuarantorcode());
			exguTorInfo.setGuarantype(bopCfaExguDs.getGuarantype());
			exguTorInfo.setLstUpdTlr(bopCfaExguDs.getLstUpdTlr());
			exguTorInfo.setLstUpdTm(bopCfaExguDs.getLstUpdTm());
			exguTorInfo.setRecId(bopCfaExguDs.getId());
			exguTorInfo.setFiller1(bopCfaExguDs.getFiller1());
			exguTorInfo.setFiller2(bopCfaExguDs.getFiller2());

			exguTorInfo.setMaturity(bopCfaExguDs.getMaturity());
			exguTorInfo.setMaindebtcurr(bopCfaExguDs.getMaindebtcurr());
			exguTorInfo.setMaindebtamount(bopCfaExguDs.getMaindebtamount());

			exguTorInfo.setRecStatus(bopCfaExguDs.getRecStatus());
			exguTorInfo.setRemark(bopCfaExguDs.getRemark());
			exguTorInfo.setRepStatus(bopCfaExguDs.getRepStatus());
			exguTorInfo.setSubSuccess(bopCfaExguDs.getSubSuccess());
			//担保申请人信息
			if (listTor.size() > 0) {
				BopExguTorDs bopExguTorDs = (BopExguTorDs) listTor.get(0);
				exguTorInfo.setTorCodeGu(bopExguTorDs.getTorCode());
				exguTorInfo.setTorEnnameGu(bopExguTorDs.getTorEnname());
				exguTorInfo.setTorNameGu(bopExguTorDs.getTorName());
				exguTorInfo.setIdGu(bopExguTorDs.getId());
			}
			list.add(exguTorInfo);
			return list;
		}
		return list;
	}
}