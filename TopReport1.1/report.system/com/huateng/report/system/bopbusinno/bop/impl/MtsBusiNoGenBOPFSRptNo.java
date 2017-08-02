package com.huateng.report.system.bopbusinno.bop.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopFsDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新境内付款/承兑通知书申报号码（基础、申报、管理信息);
 * 
 * @author Zhusujian
 * 
 */
public class MtsBusiNoGenBOPFSRptNo implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap)
			throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		MtsBopFsDs mtsBopFsds = (MtsBopFsDs) obj;
		String rptNo = mtsBopFsds.getRptno();
		String cusType = mtsBopFsds.getCustype();
		if (rptNo.indexOf(paramValue) >= 0) {
			// 更新境内付款/承兑通知书申报号码
			String newRptNo = ReportUtils.getBopRptNoByCusType(paramValue, busiType, appType, fileType, workDate, cusType, rptNo);
			mtsBopFsds.setRptno(newRptNo);
			mtsBopFsds = (MtsBopFsDs) rootdao.saveOrUpdate(mtsBopFsds);
		}

		// 更新申报、管理信息
		String recId = mtsBopFsds.getId();
		List list = rootdao.queryByQL2List(" from MtsBopFsDs where filler1='" + recId + "' and rptno<>'" + mtsBopFsds.getRptno() + "'");
		for (int i = 0; i < list.size(); i++) {
			MtsBopFsDs bopFs = (MtsBopFsDs) list.get(i);
			if (bopFs.getRptno().indexOf(paramValue) < 0) {
				continue;
			}
			bopFs.setRptno(mtsBopFsds.getRptno());
			rootdao.saveOrUpdate(bopFs);
		}
	}

}
