package com.huateng.report.system.bopbusinno.jsh.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.MtsJshDefgDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新JSH申报号码（基础、管理信息);
 * @author Zhusujian
 *
 */
public class MtsBusiNoGenJSHDEFGRptNo implements IGenBopBusinessNo{

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		MtsJshDefgDs mtsJshDefgds = (MtsJshDefgDs) obj;
		String rptNo = mtsJshDefgds.getRptno();
		String cusType = mtsJshDefgds.getCustype();
		if (rptNo.indexOf(paramValue)>=0) {
			// 更新JSH申报号码
			String newRptNo = ReportUtils.getBopRptNoByCusType(paramValue, busiType, appType, fileType, workDate, cusType, rptNo);
			mtsJshDefgds.setRptno(newRptNo);
			mtsJshDefgds = (MtsJshDefgDs) rootdao.saveOrUpdate(mtsJshDefgds);
		}

		//更新管理信息
		String recId = mtsJshDefgds.getId();
		List list = rootdao.queryByQL2List(" from MtsJshDefgDs where filler1='" + recId + "' and rptno<>'"+ mtsJshDefgds.getRptno()+"'");
		for (int i = 0; i < list.size(); i++) {
			MtsJshDefgDs jshDefgds = (MtsJshDefgDs) list.get(i);
			if (jshDefgds.getRptno().indexOf(paramValue)<0) {
				continue;
			}
			jshDefgds.setRptno(mtsJshDefgds.getRptno());
			rootdao.saveOrUpdate(jshDefgds);
		}
	}

}
