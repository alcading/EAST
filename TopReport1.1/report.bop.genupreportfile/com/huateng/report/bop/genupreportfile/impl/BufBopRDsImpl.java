package com.huateng.report.bop.genupreportfile.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopDrDs;
import resource.bean.report.MtsBopRefnos;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;
public class BufBopRDsImpl implements IGetSubFileList  {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hqlBuff = new StringBuffer();
		String id = null;

		String fileDate = (String) paramMap.get(IGetSubFileList.IN_FILE_DATE);
		String appType = (String) paramMap.get(IGetSubFileList.IN_APP_TYPE);
		String fileType = (String) paramMap.get(IGetSubFileList.IN_FILE_TYPE);

		hqlBuff.append(" from MtsBopDrDs model ").append(" where model.apptype = '"+appType).append("'")
		.append(" and model.currentfile = '"+fileType+"'");
		if (fileDate!=null && fileDate.trim().length()>0) {
			hqlBuff.append(" and model.workDate = '"+fileDate+"'");
		}
		hqlBuff.append(" and model.recStatus = '"+TopReportConstants.REPORT_RECSTATUS_05+"'");
		
		//出口收汇核销单号码 list添加到MtsBopDrDs	
		List<MtsBopDrDs> mtsBopRDs = dao.queryByQL2List(hqlBuff.toString());
		if(mtsBopRDs!=null&&mtsBopRDs.size()>0){
		    id = mtsBopRDs.get(0).getId();
			StringBuffer refnosHql = new StringBuffer();
			refnosHql.append(" from MtsBopRefnos model where model.recId = '"+id+"'");
			List<MtsBopRefnos> mtsBopRefnos = dao.queryByQL2List(refnosHql.toString());
			List<String> refnos = new ArrayList<String>();
			for(int i=0; i<mtsBopRefnos.size(); i++){
				refnos.add(mtsBopRefnos.get(i).getRefno());
			}
		   
			mtsBopRDs.get(0).setRefnos(refnos);
			
		}
	
				

		return mtsBopRDs;
	}

}
