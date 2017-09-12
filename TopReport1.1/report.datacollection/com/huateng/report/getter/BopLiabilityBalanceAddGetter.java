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
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopCFAExguTorInfo;

/**
 *
 * 对外担保 update insert delete Getter
 * @author huang cheng
 * @version 1.0
 * 2012-8-30
 *
 * */
@SuppressWarnings("unchecked")
public class BopLiabilityBalanceAddGetter extends BaseGetter {

	private static final String DELETE_CMD="del";
	private static final String NEW_CMD="new";
	private static final String MOD_CMD="mod";
	private static final String DETAILE_CMD="detail";

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

//		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
//
//
//		PageQueryCondition queryCondition = new PageQueryCondition();
//
//		StringBuffer hql = new StringBuffer("");

		List<BopCFAExguTorInfo> list = new ArrayList<BopCFAExguTorInfo>();
		String id = getCommQueryServletRequest().getParameter("id");
		String op = getCommQueryServletRequest().getParameter("op");


		BopCFAExguTorInfo  bopCFAExguTorInfo = new BopCFAExguTorInfo();
//		List<BopCfaExguDs> listExgu = new ArrayList();
//		List<BopExguTorDs> listTor = new ArrayList();

		if(NEW_CMD.equals(op)){
			list.add(bopCFAExguTorInfo);
			return list;

		}else if(DETAILE_CMD.equalsIgnoreCase(op) || DELETE_CMD.equalsIgnoreCase(op) || MOD_CMD.equalsIgnoreCase(op)){

			String hqlTor= " FROM BopExguTorDs bet WHERE bet.recId = '"+id+"' AND bet.torType = '03'";
			String hqlExgu= " FROM BopCfaExguDs bce WHERE bce.id = '"+id+"'";
			ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
			List<BopCfaExguDs> listExgu = dao.queryByQL2List(hqlExgu);
			List<BopExguTorDs> listTor = dao.queryByQL2List(hqlTor);
			BopCfaExguDs bopCfaExguDs = (BopCfaExguDs) listExgu.get(0);
			BopExguTorDs bopExguTorDs = (BopExguTorDs) listTor.get(0);
			
			
		   //查询最新的基础信息
			BopCfaExguDs  bopCfaExguDsQuery = dao.query(BopCfaExguDs.class,bopCfaExguDs.getFiller1());
			
			bopCFAExguTorInfo.setExguarancode(bopCfaExguDsQuery.getExguarancode());
			bopCFAExguTorInfo.setGuarantorcode(bopCfaExguDsQuery.getGuarantorcode());
			bopCFAExguTorInfo.setGuarantype(bopCfaExguDsQuery.getGuarantype());	
			bopCFAExguTorInfo.setContractdate(bopCfaExguDsQuery.getContractdate());
			bopCFAExguTorInfo.setGuaranamount(bopCfaExguDsQuery.getGuaranamount());
			bopCFAExguTorInfo.setGuarancurr(bopCfaExguDsQuery.getGuarancurr());	
			bopCFAExguTorInfo.setMaturity(bopCfaExguDsQuery.getMaturity());
			bopCFAExguTorInfo.setMaindebtamount(bopCfaExguDsQuery.getMaindebtamount());
			bopCFAExguTorInfo.setMaindebtcurr(bopCfaExguDsQuery.getMaindebtcurr());
			bopCFAExguTorInfo.setAppdocuno(bopCfaExguDsQuery.getAppdocuno());
			bopCFAExguTorInfo.setRemark(bopCfaExguDsQuery.getRemark());

			

			// 责任余额信息
			bopCFAExguTorInfo.setBasere(bopCfaExguDs.getBasere());
			bopCFAExguTorInfo.setWabachandate(bopCfaExguDs.getWabachandate());
			bopCFAExguTorInfo.setFiller2(bopCfaExguDs.getFiller2());		
			bopCFAExguTorInfo.setActiondesc(bopCfaExguDs.getActiondesc());
			bopCFAExguTorInfo.setActiontype(bopCfaExguDs.getActiontype());
			bopCFAExguTorInfo.setApproveResult(bopCfaExguDs.getApproveResult());
			bopCFAExguTorInfo.setApproveStatus(bopCfaExguDs.getApproveStatus());
			bopCFAExguTorInfo.setApptype(bopCfaExguDs.getApptype());
			bopCFAExguTorInfo.setRecStatus(bopCfaExguDs.getRecStatus());
			bopCFAExguTorInfo.setRepStatus(bopCfaExguDs.getRepStatus());
			bopCFAExguTorInfo.setSubSuccess(bopCfaExguDs.getSubSuccess());
			bopCFAExguTorInfo.setRecId(bopCfaExguDs.getId());
			bopCFAExguTorInfo.setCrtTm(bopCfaExguDs.getCrtTm());
			bopCFAExguTorInfo.setBrNo(bopCfaExguDs.getBrNo());
			bopCFAExguTorInfo.setCurrentfile(bopCfaExguDs.getCurrentfile());
			bopCFAExguTorInfo.setFiller1(bopCfaExguDs.getFiller1());
			bopCFAExguTorInfo.setLstUpdTlr(bopCfaExguDs.getLstUpdTlr());
			bopCFAExguTorInfo.setLstUpdTm(bopCfaExguDs.getLstUpdTm());
			bopCFAExguTorInfo.setBuscode(bopCfaExguDs.getBuscode());
			bopCFAExguTorInfo.setComplianceno(bopCfaExguDs.getComplianceno());	
			bopCFAExguTorInfo.setContractdate(bopCfaExguDs.getContractdate());

			//担保申请人信息
			bopCFAExguTorInfo.setTorCodeGu(bopExguTorDs.getTorCode());
			bopCFAExguTorInfo.setTorEnnameGu(bopExguTorDs.getTorEnname());
			bopCFAExguTorInfo.setTorNameGu(bopExguTorDs.getTorName());
			bopCFAExguTorInfo.setTorTypeCode(bopExguTorDs.getTorTypeCode());
			bopCFAExguTorInfo.setIdGu(bopExguTorDs.getId());

			list.add(bopCFAExguTorInfo);
			return list;
		}
		return list;
	}
}