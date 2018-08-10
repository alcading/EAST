package resources.finstandard.data.service;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.finstandard.data.pub.LoanBalance;

public class LoanBalanceService {
	public static synchronized LoanBalanceService getInstance() {
		return (LoanBalanceService) ApplicationContextUtils.getBean("LoanBalanceService");
	}

//	public void LoanBalanceDel(LoanBalance loaf) throws CommonException {
//		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
//	}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		return rootDao.pageQueryByQL(queryCondition);
	}

}
