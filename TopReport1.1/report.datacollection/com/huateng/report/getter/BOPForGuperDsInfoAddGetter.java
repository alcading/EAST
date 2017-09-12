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
public class BOPForGuperDsInfoAddGetter extends BaseGetter {

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
//		   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//		   GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
//
//
//		   PageQueryCondition queryCondition = new PageQueryCondition();
//
//		   StringBuffer hql = new StringBuffer("");

		List<BopCFAExguTorInfo> list = new ArrayList<BopCFAExguTorInfo>();
		String id = getCommQueryServletRequest().getParameter("id");
		String op = getCommQueryServletRequest().getParameter("op");
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		//担保申请人
		String hqlTorGu= " FROM BopExguTorDs bet WHERE bet.recId = '"+id+"' AND bet.torType = '03' ";
		String hqlTorBen= " FROM BopExguTorDs bet WHERE bet.recId = '"+id+"' AND bet.torType = '01' ";
		//担保申请人
		String hqlExgu= " FROM BopCfaExguDs bce WHERE bce.id = '"+id+"' ";
		BopCFAExguTorInfo  bopCFAExguTorInfo = new BopCFAExguTorInfo();
		List<BopCfaExguDs> listExgu = new ArrayList<BopCfaExguDs>();
		List<BopExguTorDs> listTorGu = new ArrayList<BopExguTorDs>();
		List<BopExguTorDs> listTorBen = new ArrayList<BopExguTorDs>();


		if(NEW_CMD.equals(op)){

			bopCFAExguTorInfo.setComplianceno(ReportUtils.getTempStr(null, 4));
			list.add(bopCFAExguTorInfo);
			return list;

		}else if(DETAILE_CMD.equalsIgnoreCase(op) || DELETE_CMD.equalsIgnoreCase(op) || MOD_CMD.equalsIgnoreCase(op)){
			listExgu = dao.queryByQL2List(hqlExgu);
			listTorGu = dao.queryByQL2List(hqlTorGu);
			listTorBen= dao.queryByQL2List(hqlTorBen);
			BopCfaExguDs bopCfaExguDs = (BopCfaExguDs) listExgu.get(0);
			BopExguTorDs bopExguTorDsGu = (BopExguTorDs) listTorGu.get(0);
			BopExguTorDs bopExguTorDsBen = (BopExguTorDs) listTorBen.get(0);
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
		
			//履约信息
			bopCFAExguTorInfo.setActiondesc(bopCfaExguDs.getActiondesc());
			bopCFAExguTorInfo.setActiontype(bopCfaExguDs.getActiontype());
			bopCFAExguTorInfo.setAppdocuno(bopCfaExguDs.getAppdocuno());
			bopCFAExguTorInfo.setApproveResult(bopCfaExguDs.getApproveResult());
			bopCFAExguTorInfo.setApproveStatus(bopCfaExguDs.getApproveStatus());
			bopCFAExguTorInfo.setApptype(bopCfaExguDs.getApptype());
			bopCFAExguTorInfo.setBasere(bopCfaExguDs.getBasere());
			bopCFAExguTorInfo.setBrNo(bopCfaExguDs.getBrNo());
			bopCFAExguTorInfo.setBuscode(bopCfaExguDs.getBuscode());
			bopCFAExguTorInfo.setComplianceno(bopCfaExguDs.getComplianceno());
			bopCFAExguTorInfo.setContractdate(bopCfaExguDs.getContractdate());
			bopCFAExguTorInfo.setCrtTm(bopCfaExguDs.getCrtTm());
			bopCFAExguTorInfo.setCurrentfile(bopCfaExguDs.getCurrentfile());
			bopCFAExguTorInfo.setExguarancode(bopCfaExguDs.getExguarancode());
			bopCFAExguTorInfo.setFiller1(bopCfaExguDs.getFiller1());
			bopCFAExguTorInfo.setGuaranamount(bopCfaExguDs.getGuaranamount());
			bopCFAExguTorInfo.setGuarancurr(bopCfaExguDs.getGuarancurr());
			bopCFAExguTorInfo.setGuarantorcode(bopCfaExguDs.getGuarantorcode());
			bopCFAExguTorInfo.setGuarantype(bopCfaExguDs.getGuarantype());
			bopCFAExguTorInfo.setLstUpdTlr(bopCfaExguDs.getLstUpdTlr());
			bopCFAExguTorInfo.setLstUpdTm(bopCfaExguDs.getLstUpdTm());
			bopCFAExguTorInfo.setMaindebtamount(bopCfaExguDs.getMaindebtamount());
			bopCFAExguTorInfo.setContractdate(bopCfaExguDs.getContractdate());
			bopCFAExguTorInfo.setWabachandate(bopCfaExguDs.getWabachandate());
			bopCFAExguTorInfo.setMaturity(bopCfaExguDs.getMaturity());
			bopCFAExguTorInfo.setMaindebtcurr(bopCfaExguDs.getMaindebtcurr());
			bopCFAExguTorInfo.setFiller2(bopCfaExguDs.getFiller2());
			bopCFAExguTorInfo.setRecStatus(bopCfaExguDs.getRecStatus());
			bopCFAExguTorInfo.setRemark(bopCfaExguDs.getRemark());
			bopCFAExguTorInfo.setRepStatus(bopCfaExguDs.getRepStatus());
			bopCFAExguTorInfo.setSubSuccess(bopCfaExguDs.getSubSuccess());
			bopCFAExguTorInfo.setRecId(bopCfaExguDs.getId());
			
			bopCFAExguTorInfo.setGuperdate(bopCfaExguDs.getGuperdate());
			bopCFAExguTorInfo.setGupercurr(bopCfaExguDs.getGupercurr());
			bopCFAExguTorInfo.setGuperamount(bopCfaExguDs.getGuperamount());
			bopCFAExguTorInfo.setPguperamount(bopCfaExguDs.getPguperamount());

			//担保申请人信息
			bopCFAExguTorInfo.setTorCodeGu(bopExguTorDsGu.getTorCode());
			bopCFAExguTorInfo.setTorEnnameGu(bopExguTorDsGu.getTorEnname());
			bopCFAExguTorInfo.setTorNameGu(bopExguTorDsGu.getTorName());
			bopCFAExguTorInfo.setTorTypeCode(bopExguTorDsGu.getTorTypeCode());
			bopCFAExguTorInfo.setIdGu(bopExguTorDsGu.getId());

			//受益人信息
			bopCFAExguTorInfo.setTorCodeBen(bopExguTorDsBen.getTorCode());
			bopCFAExguTorInfo.setTorEnnameBen(bopExguTorDsBen.getTorEnname());
			bopCFAExguTorInfo.setTorNameBen(bopExguTorDsBen.getTorName());
			bopCFAExguTorInfo.setTorTypeCode(bopExguTorDsBen.getTorTypeCode());
			bopCFAExguTorInfo.setIdBen(bopExguTorDsBen.getId());

			list.add(bopCFAExguTorInfo);
			return list;
		}
		return list;
	}
}