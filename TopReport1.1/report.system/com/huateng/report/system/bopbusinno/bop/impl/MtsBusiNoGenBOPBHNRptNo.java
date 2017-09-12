package com.huateng.report.system.bopbusinno.bop.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopBhnDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新境外汇款申请书申报号码（基础、申报、管理信息);
 * @author Zhusujian
 *
 */
public class MtsBusiNoGenBOPBHNRptNo implements IGenBopBusinessNo{

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		MtsBopBhnDs mtsBopBhnds = (MtsBopBhnDs) obj;
		String rptNo = mtsBopBhnds.getRptno();
		String cusType = mtsBopBhnds.getCustype();
		if (rptNo.indexOf(paramValue)>=0) {
			// 更新境外汇款申请书申报号码
			String newRptNo = ReportUtils.getBopRptNoByCusType(paramValue, busiType, appType, fileType, workDate, cusType, rptNo);
			mtsBopBhnds.setRptno(newRptNo);
			mtsBopBhnds = (MtsBopBhnDs) rootdao.saveOrUpdate(mtsBopBhnds);
		}

		//更新申报、管理信息
		String recId = mtsBopBhnds.getId();
		List list = rootdao.queryByQL2List(" from MtsBopBhnDs where filler1='" + recId + "' and rptno<>'"+mtsBopBhnds.getRptno()+"'");
		for (int i = 0; i < list.size(); i++) {
			MtsBopBhnDs bopbhn = (MtsBopBhnDs) list.get(i);
			if (bopbhn.getRptno().indexOf(paramValue)<0) {
				continue;
			}
			bopbhn.setRptno(mtsBopBhnds.getRptno());
			rootdao.saveOrUpdate(bopbhn);
		}
	}

}
