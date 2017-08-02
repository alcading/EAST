package com.huateng.report.system.bopbusinno.cfa.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExguDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新对外担保编号、履约编号
 *
 * @author NING-PENG
 *
 */
public class BopBusiNoGenCFAExguaranCode implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		BopCfaExguDs exgu = (BopCfaExguDs) obj;
		String code = exgu.getExguarancode();

		if (code.indexOf(paramValue)>=0) {
			// 更新对外担保编号
			String newcode = ReportUtils.getCfaCode(paramValue, busiType, appType,fileType, workDate, code);
			exgu.setExguarancode(newcode);
			exgu = (BopCfaExguDs) rootdao.saveOrUpdate(exgu);
		}
		// 更新相关责任余额、履约对外担保编号
		String recId = exgu.getId();
		List list = rootdao.queryByQL2List(" from BopCfaExguDs where filler1='" + recId + "' and exguarancode<>'"+exgu.getExguarancode()+"'");
		for (int i = 0; i < list.size(); i++) {
			BopCfaExguDs compExGu = (BopCfaExguDs) list.get(i);
			if (compExGu.getExguarancode().indexOf(paramValue)<0) {
				continue;
			}
			compExGu.setExguarancode(exgu.getExguarancode());
			rootdao.saveOrUpdate(compExGu);
		}
		// 产生履约序号
		int seq = 1;
		String seqTemp = ReportUtils.getTempStr(null, 4);
		Object maxObj = rootdao.queryByHqlMax("select max(complianceno) from BopCfaExguDs where  filler1='" + recId + "' and  complianceno<>'" + seqTemp + "'");
		if (maxObj != null) {
			seq = Integer.parseInt(maxObj.toString()) + 1;
		}
		List seqList = rootdao.queryByQL2List(" from BopCfaExguDs where filler1='" + recId + "' and complianceno='" + seqTemp + "' order by crtTm");
		for (int i = 0; i < seqList.size(); i++) {
			BopCfaExguDs ds = (BopCfaExguDs) seqList.get(i);
			if (ds.getComplianceno().indexOf(paramValue) < 0) {
				continue;
			}
			String changeNo = StringUtils.leftPad(String.valueOf(seq), 4, "0");
			ds.setComplianceno(changeNo);
			rootdao.saveOrUpdate(ds);
			seq++;
		}
	}

}
