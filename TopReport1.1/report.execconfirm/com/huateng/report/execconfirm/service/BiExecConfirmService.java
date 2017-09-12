package com.huateng.report.execconfirm.service;
import java.util.ArrayList;
import java.util.List;

import resource.bean.pub.Bctl;
import resource.bean.pub.DataDic;
import resource.bean.report.BiExecConfirm;
import resource.bean.report.BiExecConfirmPK;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

public class BiExecConfirmService {
	private static final HtLog htlog = HtLogFactory.getLogger(BiExecConfirmService.class);

	protected BiExecConfirmService() {
	}

	public synchronized static BiExecConfirmService getInstance() {
		return (BiExecConfirmService) ApplicationContextUtils.getBean(BiExecConfirmService.class.getName());
	}


	public BiExecConfirm getBiExecConfirmByPk(String busiType, String appType, String brNo,String workDate) throws CommonException{
		return ROOTDAOUtils.getROOTDAO().query(BiExecConfirm.class, new BiExecConfirmPK(busiType, appType, brNo,workDate));
	}




	/**
	 * 判断是否工作完成
	 * @param preTxDate
	 * @throws CommonException
	 */
	public void checkExecConfirm(String preTxDate) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Bctl> bctls = BctlService.getInstance().getAllEnableBctl();
		List<String> brNoList = new ArrayList<String>();
		for(Bctl bc : bctls){
			brNoList.add(bc.getBrno());
		}
		List<DataDic> busiTypes = ReportUtils.getBusinessList();
		for(DataDic dd : busiTypes){
			String hql = " from BiExecConfirm model where model.id.busiType='" + dd.getDataNo() + "' and model.id.workDate='" + preTxDate 
					+ "' and model.id.brNo in" + ReportUtils.toInString(brNoList) + " and (model.confirmStatus <> '" + TopReportConstants.REPORT_CONFRIM_STATUS_01
					+ "' or model.subfileStatus <> '" + TopReportConstants.REPORT_SUBFILE_STATUS_01 + "')";
			List<BiExecConfirm> biExecConfrimList = rootdao.queryByQL2List(hql);
			if(biExecConfrimList.size() > 0) {
				ExceptionUtil.throwCommonException(preTxDate+"的工作未全部确认完成或锁定不能工作日期切换");
			}
		}
	}
}
