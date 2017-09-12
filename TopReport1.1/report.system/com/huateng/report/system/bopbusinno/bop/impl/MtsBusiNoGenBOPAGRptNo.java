package com.huateng.report.system.bopbusinno.bop.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopAgDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新涉外收入申报单申报号码（基础、申报、管理信息);
 * @author NING-PENG
 *
 */
public class MtsBusiNoGenBOPAGRptNo implements IGenBopBusinessNo{

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		MtsBopAgDs mtsBopAgds = (MtsBopAgDs) obj;
		String rptNo = mtsBopAgds.getRptno();
		String cusType = mtsBopAgds.getCustype();
		if (rptNo.indexOf(paramValue)>=0) {
			// 更新涉外收入申报单申报号码
			String newRptNo = ReportUtils.getBopRptNoByCusType(paramValue, busiType, appType, fileType, workDate, cusType, rptNo);
			mtsBopAgds.setRptno(newRptNo);
			mtsBopAgds = (MtsBopAgDs) rootdao.saveOrUpdate(mtsBopAgds);
		}

		//更新申报、管理信息
		String recId = mtsBopAgds.getId();
		List list = rootdao.queryByQL2List(" from MtsBopAgDs where filler1='" + recId + "' and rptno<>'"+mtsBopAgds.getRptno()+"'");
		for (int i = 0; i < list.size(); i++) {
			MtsBopAgDs bopag = (MtsBopAgDs) list.get(i);
			if (bopag.getRptno().indexOf(paramValue)<0) {
				continue;
			}
			bopag.setRptno(mtsBopAgds.getRptno());
			rootdao.saveOrUpdate(bopag);
		}
	}

}
