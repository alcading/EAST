package com.huateng.report.system.bopbusinno.cfa.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExplrmbloDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 外汇质押人民币贷款
 *
 * @author NING-PENG
 *
 */
public class BopBusiNoGenCFAExplrmbloCode implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		BopCfaExplrmbloDs explRmbLo = (BopCfaExplrmbloDs) obj;
		String code = explRmbLo.getExplrmblono();

		if (code.indexOf(paramValue)>=0) {
			// 更新外汇质押人民币贷款编号
			String newcode = ReportUtils.getCfaCode(paramValue, busiType, appType,fileType, workDate, code);
			explRmbLo.setExplrmblono(newcode);
			explRmbLo = (BopCfaExplrmbloDs) rootdao.saveOrUpdate(explRmbLo);
		}
		// 更新变动编号
		String recId = explRmbLo.getId();
		List list = rootdao.queryByQL2List(" from BopCfaExplrmbloDs where filler1='" + recId + "' and explrmblono<>'"+explRmbLo.getExplrmblono()+"'");
		for (int i = 0; i < list.size(); i++) {
			BopCfaExplrmbloDs exp = (BopCfaExplrmbloDs) list.get(i);
			if (exp.getExplrmblono().indexOf(paramValue)<0) {
				continue;
			}
			exp.setExplrmblono(explRmbLo.getExplrmblono());
			rootdao.saveOrUpdate(exp);
		}
		// 产生变动序号
		int seq = 1;
		String seqTemp = ReportUtils.getTempStr(null, 4);
		Object maxObj = rootdao.queryByHqlMax("select max(changeno) from BopCfaExplrmbloDs where  filler1='" + recId + "' and  changeno<>'" + seqTemp + "'");
		if (maxObj != null) {
			seq = Integer.parseInt(maxObj.toString()) + 1;
		}
		List seqList = rootdao.queryByQL2List(" from BopCfaExplrmbloDs where filler1='" + recId + "' and changeno='" + seqTemp + "' order by crtTm");
		for (int i = 0; i < seqList.size(); i++) {
			BopCfaExplrmbloDs ds = (BopCfaExplrmbloDs) seqList.get(i);
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
