package com.huateng.report.system.bopbusinno.cfa.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaLounexguDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新外保内贷编号及变动编号
 *
 * @author NING-PENG
 *
 */
public class BopBusiNoGenCFALounexguCode implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		BopCfaLounexguDs lounexgu = (BopCfaLounexguDs) obj;
		String code = lounexgu.getLounexgucode();

		if (code.indexOf(paramValue)>=0) {
			// 更新外保内贷编号
			String newcode = ReportUtils.getCfaCode(paramValue, busiType, appType,fileType, workDate, code);
			lounexgu.setLounexgucode(newcode);
			lounexgu = (BopCfaLounexguDs) rootdao.saveOrUpdate(lounexgu);
		}
		// 更新变动及履约编号
		String recId = lounexgu.getId();
		List list = rootdao.queryByQL2List(" from BopCfaLounexguDs where filler1='" + recId + "' and lounexgucode<>'"+lounexgu.getLounexgucode()+"'");
		for (int i = 0; i < list.size(); i++) {
			BopCfaLounexguDs loun = (BopCfaLounexguDs) list.get(i);
			if (loun.getLounexgucode().indexOf(paramValue)<0) {
				continue;
			}
			loun.setLounexgucode(lounexgu.getLounexgucode());
			rootdao.saveOrUpdate(loun);
		}
		// 产生变动序号
		int seq = 1;
		String seqTemp = ReportUtils.getTempStr(null, 4);
		Object maxObj = rootdao.queryByHqlMax("select max(changeno) from BopCfaLounexguDs where  filler1='" + recId + "' and  changeno<>'" + seqTemp + "'");
		if (maxObj != null) {
			seq = Integer.parseInt(maxObj.toString()) + 1;
		}
		List seqList = rootdao.queryByQL2List(" from BopCfaLounexguDs where filler1='" + recId + "' and changeno='" + seqTemp + "' order by crtTm");
		for (int i = 0; i < seqList.size(); i++) {
			BopCfaLounexguDs ds = (BopCfaLounexguDs) seqList.get(i);
			if (ds.getChangeno().indexOf(paramValue) < 0) {
				continue;
			}
			String changeNo = StringUtils.leftPad(String.valueOf(seq), 4, "0");
			ds.setChangeno(changeNo);
			rootdao.saveOrUpdate(ds);
			seq++;
		}
	}

}
