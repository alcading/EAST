package com.huateng.report.system.bopbusinno.cfa.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaStrdeDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportUtils;

/**
 * 更新商业银行人民币结构性存款编号
 *
 * @author NING-PENG
 *
 */
public class BopBusiNoGenCFAStrdeCode implements IGenBopBusinessNo {

	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException {
		String appType = paramMap.get(IGenBopBusinessNo.APP_TYPE).toString();
		String busiType = paramMap.get(IGenBopBusinessNo.BUSI_TYPE).toString();
		String paramValue = paramMap.get(IGenBopBusinessNo.PARAM_VALUE).toString();
		String workDate = paramMap.get(IGenBopBusinessNo.WORK_DATE).toString();
		String fileType = paramMap.get(IGenBopBusinessNo.FILE_TYPE).toString();
		Object obj = paramMap.get(IGenBopBusinessNo.OBJECT_BEAN);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		BopCfaStrdeDs strde = (BopCfaStrdeDs) obj;
		String code = strde.getStrdecode();

		if (code.indexOf(paramValue)>=0) {
			// 更新商业银行人民币结构性存款编号
			String newcode = ReportUtils.getCfaCode(paramValue, busiType, appType,fileType, workDate, code);
			strde.setStrdecode(newcode);
			strde = (BopCfaStrdeDs) rootdao.saveOrUpdate(strde);
		}
		// 更新终止、利息给付相关商业银行人民币结构性存款编号
		String recId = strde.getId();
		List list = rootdao.queryByQL2List(" from BopCfaStrdeDs where filler1='" + recId + "' and strdecode<>'"+strde.getStrdecode()+"'");
		for (int i = 0; i < list.size(); i++) {
			BopCfaStrdeDs str = (BopCfaStrdeDs) list.get(i);
			if (str.getStrdecode().indexOf(paramValue)<0) {
				continue;
			}
			str.setStrdecode(strde.getStrdecode());
			rootdao.saveOrUpdate(str);
		}
		// 查询终止变动序号
		int terpay = 1;
		String seqTemp = ReportUtils.getTempStr(null, 4);
		Object maxObjter = rootdao.queryByHqlMax("select max(terpaycode) from BopCfaStrdeDs where  filler1='" + recId + "' and  terpaycode<>'" + seqTemp + "'");
		if (maxObjter != null) {
			terpay = Integer.parseInt(maxObjter.toString()) + 1;
		}
		List terpaySeqList = rootdao.queryByQL2List(" from BopCfaStrdeDs where filler1='" + recId + "' and terpaycode='" + seqTemp + "' order by crtTm");
		for (int i = 0; i < terpaySeqList.size(); i++) {
			BopCfaStrdeDs terpayds = (BopCfaStrdeDs) terpaySeqList.get(i);
			if (terpayds.getTerpaycode().indexOf(paramValue) < 0) {
				continue;
			}
			String changeNo = StringUtils.leftPad(String.valueOf(terpay), 4, "0");
			terpayds.setTerpaycode(changeNo);
			rootdao.saveOrUpdate(terpayds);
			terpay++;
		}

		//查询付息序号
		int inpay =1;
		Object maxObj = rootdao.queryByHqlMax("select max(inpaycode) from BopCfaStrdeDs where  filler1='" + recId + "' and  inpaycode<>'" + seqTemp + "'");
		if (maxObj != null) {
			inpay = Integer.parseInt(maxObj.toString()) + 1;
		}
		List inpayList = rootdao.queryByQL2List(" from BopCfaStrdeDs where filler1='" + recId + "' and inpaycode='" + seqTemp + "' order by crtTm");
		for (int i = 0; i < inpayList.size(); i++) {
			BopCfaStrdeDs inpayds = (BopCfaStrdeDs) inpayList.get(i);
			if (inpayds.getInpaycode().indexOf(paramValue) < 0) {
				continue;
			}
			String inpayCode = StringUtils.leftPad(String.valueOf(inpay), 4, "0");
			inpayds.setInpaycode(inpayCode);
			rootdao.saveOrUpdate(inpayds);
			inpay++;
		}
	}

}
