package com.huateng.report.system.bopbusinno.cfa.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaDofoexloDs;
import resource.bean.report.BopCfaLounexguDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新国内外汇贷款编号及变动编号、更新境外担保项下境内贷款
 *
 * @author NING-PENG
 *
 */
public class BopBusiNoGenCFADofoexloCode implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		BopCfaDofoexloDs dofoexlo = (BopCfaDofoexloDs) obj;
		String code = dofoexlo.getDofoexlocode();

		if (code.indexOf(paramValue)>=0) {
			// 更新国内外汇贷款编号
			String newcode = ReportUtils.getCfaCode(paramValue, busiType, appType,fileType, workDate, code);
			dofoexlo.setDofoexlocode(newcode);
			dofoexlo = (BopCfaDofoexloDs) rootdao.saveOrUpdate(dofoexlo);
		}
		// 更新变动国内外汇贷款编号
		String recId = dofoexlo.getId();
		List list = rootdao.queryByQL2List(" from BopCfaDofoexloDs where filler1='" + recId + "' and dofoexlocode<>'"+dofoexlo.getDofoexlocode()+"'");
		for (int i = 0; i < list.size(); i++) {
			BopCfaDofoexloDs dofo = (BopCfaDofoexloDs) list.get(i);
			if (dofo.getDofoexlocode().indexOf(paramValue)<0) {
				continue;
			}
			dofo.setDofoexlocode(dofoexlo.getDofoexlocode());
			rootdao.saveOrUpdate(dofo);
		}
		// 产生变动序号
		int seq = 1;
		String seqTemp = ReportUtils.getTempStr(null, 4);
		Object maxObj = rootdao.queryByHqlMax("select max(changeno) from BopCfaDofoexloDs where  filler1='" + recId + "' and  changeno<>'" + seqTemp + "'");
		if (maxObj != null) {
			seq = Integer.parseInt(maxObj.toString()) + 1;
		}
		List seqList = rootdao.queryByQL2List(" from BopCfaDofoexloDs where filler1='" + recId + "' and changeno='" + seqTemp + "' order by crtTm");
		for (int i = 0; i < seqList.size(); i++) {
			BopCfaDofoexloDs ds = (BopCfaDofoexloDs) seqList.get(i);
			if (ds.getChangeno().indexOf(paramValue) < 0) {
				continue;
			}
			String changeNo = StringUtils.leftPad(String.valueOf(seq), 4, "0");
			ds.setChangeno(changeNo);
			rootdao.saveOrUpdate(ds);
			seq++;
		}

		//FIXME 更新境外担保项下境内贷款-签约信息中使用到的国内外汇贷款编号
		List lounexguDsList = rootdao.queryByQL2List(" from BopCfaLounexguDs where filler1='" + recId + "' and dofoexlocode<>'"+dofoexlo.getDofoexlocode()+"'");
		for (int i = 0; i < lounexguDsList.size(); i++) {
			BopCfaLounexguDs guds = (BopCfaLounexguDs) lounexguDsList.get(i);
			if (guds.getDofoexlocode().indexOf(paramValue)<0) {
				continue;
			}
			guds.setDofoexlocode(dofoexlo.getDofoexlocode());
			rootdao.saveOrUpdate(guds);
		}
	}

}
