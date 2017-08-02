package com.huateng.report.system.bopbusinno.bop.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopCkpDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新对外付款/承兑通知书申报号码（基础、申报、管理信息);
 * 
 * @author Zhusujian
 * 
 */
public class MtsBusiNoGenBOPCKPRptNo implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap)
			throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		MtsBopCkpDs mtsBopCkpds = (MtsBopCkpDs) obj;
		String rptNo = mtsBopCkpds.getRptno();
		String cusType = mtsBopCkpds.getCustype();
		if (rptNo.indexOf(paramValue) >= 0) {
			// 更新对外付款/承兑通知书申报号码
			String newRptNo = ReportUtils.getBopRptNoByCusType(paramValue, busiType, appType, fileType, workDate, cusType, rptNo);
			mtsBopCkpds.setRptno(newRptNo);
			mtsBopCkpds = (MtsBopCkpDs) rootdao.saveOrUpdate(mtsBopCkpds);
		}

		// 更新申报、管理信息
		String recId = mtsBopCkpds.getId();
		List list = rootdao.queryByQL2List(" from MtsBopCkpDs where filler1='" + recId + "' and rptno<>'" + mtsBopCkpds.getRptno() + "'");
		for (int i = 0; i < list.size(); i++) {
			MtsBopCkpDs bopCkp = (MtsBopCkpDs) list.get(i);
			if (bopCkp.getRptno().indexOf(paramValue) < 0) {
				continue;
			}
			bopCkp.setRptno(mtsBopCkpds.getRptno());
			rootdao.saveOrUpdate(bopCkp);
		}
	}

}
