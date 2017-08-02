package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.commquery.servlet.CommQueryServletRequest;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopCFAExguTorInfo;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BopExguLoadPageGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			CommQueryServletRequest request= commQueryServletRequest;
			String currentFile = request.getParameter("currentFile");
			if(currentFile.equalsIgnoreCase(TopReportConstants.REPORT_FILE_TYPE_CFA_BC)){
				request.setParameter("currentFile", TopReportConstants.REPORT_FILE_TYPE_CFA_BC);
			}else{
				request.setParameter("currentFile", TopReportConstants.REPORT_FILE_TYPE_CFA_BB);
			}

			PageQueryResult queryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(), getResult());

			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List<BopCFAExguTorInfo> list = new ArrayList<BopCFAExguTorInfo>();
		List<BopExguTorDs> listTor = new ArrayList<BopExguTorDs>();

		String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");
		String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");
		String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");
		String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");
		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");
		String qWorkDate =getCommQueryServletRequest().getParameter("qWorkDate");

		StringBuilder hqlexgu = new StringBuilder(" FROM BopCfaExguDs WHERE 1 = 1 ");

		List<Object>paramentList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(qActiontype)) {
			hqlexgu.append(" AND actiontype = ? ");
			paramentList.add(qActiontype);
		}
		if (StringUtils.isNotBlank(qWorkDate)) {
			hqlexgu.append(" AND workDate = ? ");
			paramentList.add(qWorkDate);
		}
		if (StringUtils.isNotBlank(qRecStatus)) {
			hqlexgu.append(" AND recStatus = ? ");
			paramentList.add(qRecStatus);
		}
		if (StringUtils.isNotBlank(qApproveStatus)) {
			hqlexgu.append(" AND approveStatus = ? ");
			paramentList.add(qApproveStatus);
		}
		if (StringUtils.isNotBlank(qRepStatus)) {
			hqlexgu.append(" AND repStatus = ? ");
			paramentList.add(qRepStatus);
		}
		if (StringUtils.isNotBlank(qfiller2)) {
			hqlexgu.append(" AND filler2 LIKE ? ");
			paramentList.add("%" + qfiller2 + "%");
		}

		hqlexgu.append(" AND apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);

		hqlexgu.append(" AND currentfile = ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_BA);
		hqlexgu.append(" ORDER BY workDate DESC ");
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hqlexgu.toString());
		queryCondition.setObjArray(paramentList.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		PageQueryResult presult = dao.pageQueryByQL(queryCondition);
		List<Object[]> listExgu = presult.getQueryResult();
		for (Object[] values: listExgu) {
			BopCFAExguTorInfo bopCFAExguTorInfo = new BopCFAExguTorInfo();
			BopCfaExguDs bopCfaExguDs = (BopCfaExguDs)values[0];
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
			bopCFAExguTorInfo.setMaindebtcurr(bopCfaExguDs.getMaindebtcurr());
			bopCFAExguTorInfo.setMaturity(bopCfaExguDs.getMaturity());
			bopCFAExguTorInfo.setFiller2(bopCfaExguDs.getFiller2());

			bopCFAExguTorInfo.setRecStatus(bopCfaExguDs.getRecStatus());
			bopCFAExguTorInfo.setRemark(bopCfaExguDs.getRemark());
			bopCFAExguTorInfo.setRepStatus(bopCfaExguDs.getRepStatus());
			bopCFAExguTorInfo.setSubSuccess(bopCfaExguDs.getSubSuccess());

			String recId = bopCfaExguDs.getId();
			bopCFAExguTorInfo.setRecId(recId);
			String hqlTor = " FROM BopExguTorDs bet WHERE bet.recId = '" + recId + "' AND bet.torType = '03'";
			listTor = dao.queryByQL2List(hqlTor);
			BopExguTorDs bopExguTorDs = (BopExguTorDs) listTor.get(0);
			// 担保申请人信息
			bopCFAExguTorInfo.setTorCodeGu(bopExguTorDs.getTorCode());
			bopCFAExguTorInfo.setTorEnnameGu(bopExguTorDs.getTorEnname());
			bopCFAExguTorInfo.setTorNameGu(bopExguTorDs.getTorName());

			list.add(bopCFAExguTorInfo);
		}

		presult.setQueryResult(list);
		return presult;
	}
}