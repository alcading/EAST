package com.huateng.report.system.bopbusinno.bop.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopDrDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新境内收入申报单申报号码（基础、申报、管理信息);
 * 
 * @author Zhusujian
 * 
 */
public class MtsBusiNoGenBOPDRRptNo implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap)
			throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		MtsBopDrDs mtsBopDrds = (MtsBopDrDs) obj;
		String rptNo = mtsBopDrds.getRptno();
		String cusType = mtsBopDrds.getCustype();
		if (rptNo.indexOf(paramValue) >= 0) {
			// 更新境内收入申报单申报号码
			String newRptNo = ReportUtils.getBopRptNoByCusType(paramValue, busiType, appType, fileType, workDate, cusType, rptNo);
			mtsBopDrds.setRptno(newRptNo);
			mtsBopDrds = (MtsBopDrDs) rootdao.saveOrUpdate(mtsBopDrds);
		}

		// 更新申报、管理信息
		String recId = mtsBopDrds.getId();
		List list = rootdao.queryByQL2List(" from MtsBopDrDs where filler1='" + recId + "' and rptno<>'" + mtsBopDrds.getRptno() + "'");
		for (int i = 0; i < list.size(); i++) {
			MtsBopDrDs bopDr = (MtsBopDrDs) list.get(i);
			if (bopDr.getRptno().indexOf(paramValue) < 0) {
				continue;
			}
			bopDr.setRptno(mtsBopDrds.getRptno());
			rootdao.saveOrUpdate(bopDr);
		}
	}

}
