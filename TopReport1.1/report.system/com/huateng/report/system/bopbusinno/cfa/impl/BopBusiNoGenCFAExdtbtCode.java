package com.huateng.report.system.bopbusinno.cfa.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新外债编号/变更/余额序号
 *
 * @author NING-PENG
 *
 */
public class BopBusiNoGenCFAExdtbtCode implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		BopCfaExdebtDs exdebt = (BopCfaExdebtDs) obj;
		String code = exdebt.getExdebtcode();

		if (code.indexOf(paramValue)>=0) {
			// 更新外债编号
			String newcode = ReportUtils.getCfaCode(paramValue, busiType, appType,fileType, workDate, code);
			exdebt.setExdebtcode(newcode);
			exdebt = (BopCfaExdebtDs) rootdao.saveOrUpdate(exdebt);
		}
		// 更新相关变动中外债编号
		String recId = exdebt.getId();
		List list = rootdao.queryByQL2List(" from BopCfaExdebtDs where filler1='" + recId + "' and exdebtcode<>'"+exdebt.getExdebtcode()+"'");
		for (int i = 0; i < list.size(); i++) {
			BopCfaExdebtDs changeExdebt = (BopCfaExdebtDs) list.get(i);
			if (changeExdebt.getExdebtcode().indexOf(paramValue)<0) {
				continue;
			}
			changeExdebt.setExdebtcode(exdebt.getExdebtcode());
			rootdao.saveOrUpdate(changeExdebt);
		}
		// 产生变动序号
		int seq = 1;
		String seqTemp = ReportUtils.getTempStr(null, 4);
		Object maxObj = rootdao.queryByHqlMax("select max(changeno) from BopCfaExdebtDs where  filler1='" + recId + "' and  changeno<>'" + seqTemp + "'");
		if (maxObj != null) {
			seq = Integer.parseInt(maxObj.toString()) + 1;
		}
		// 外债变动或余额信息
		List seqList = rootdao.queryByQL2List(" from BopCfaExdebtDs where filler1='" + recId + "' and changeno='" + seqTemp + "' order by crtTm");
		for (int i = 0; i < seqList.size(); i++) {
			BopCfaExdebtDs ds = (BopCfaExdebtDs) seqList.get(i);
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
