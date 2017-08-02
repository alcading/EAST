package com.huateng.report.genupreportfile.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufCfaAhBopCfaExdebtDsImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hqlBuff = new StringBuffer();
		String fileDate = (String) paramMap.get(IGetSubFileList.IN_FILE_DATE);
		String appType = (String) paramMap.get(IGetSubFileList.IN_APP_TYPE);
		String fileType = (String) paramMap.get(IGetSubFileList.IN_FILE_TYPE);
		//查询外债表
		hqlBuff.append(" from BopCfaExdebtDs model ").append(" where model.apptype = '"+appType).append("'")
		.append(" and model.currentfile = '"+fileType+"'");
		if (fileDate!=null && fileDate.trim().length()>0) {
			hqlBuff.append(" and model.workDate = '"+fileDate+"'");
		}
		hqlBuff.append(" and model.recStatus = '"+TopReportConstants.REPORT_RECSTATUS_05+"'");
		List<BopCfaExdebtDs> queryBopCfaExdebtDsList = (List<BopCfaExdebtDs>) dao.queryByQL2List(hqlBuff.toString());
		for(BopCfaExdebtDs model : queryBopCfaExdebtDsList) {
			//查询债权人信息表并赋值
			String id = model.getId();
			String hql = " from BopCfaCreditorDs model where model.recId = '"+id+"'";
			List<BopCfaCreditorDs> queryBopCfaCreditorDsList = dao.queryByQL2List(hql);
			//赋值债权人代码  债权人中文名称  债权人英文名称  债权人类型代码  债权人总部所在国家（地区）代码   债权人经营地所在国家（地区）代码
			//应该只有一个，避免空指针
			for(BopCfaCreditorDs ds : queryBopCfaCreditorDsList) {
				model.setCreditorcode(ds.getCreditorcode());
				model.setCreditorname(ds.getCreditorname());
				model.setCreditornamen(ds.getCreditornamen());
				model.setCreditortype(ds.getCreditortype());
				model.setCrehqcode(ds.getCrehqcode());
				model.setOpercode(ds.getOpercode());
			}
		}
		return queryBopCfaExdebtDsList;
	}
}
