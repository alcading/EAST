package com.huateng.view.freemarker;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.common.Code;
import com.huateng.ebank.business.common.MessageResourceUtil;
import com.huateng.util.SystemDictionaryUnit;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class SysDicStrMethodInter implements TemplateMethodModel {
	protected static Logger logger = Logger
			.getLogger(SysDicStrMethodInter.class);
	
	public Object exec(List args) throws TemplateModelException {

		String tblNm = null;
		String fldNm = null;
		if (args.size() == 1) {
			int index = 0;
			String trans = args.get(0).toString();
			if ((index = trans.indexOf(".")) == -1)
				return "";
			tblNm = trans.substring(0, index);
			//国际化后的表名
			tblNm = MessageResourceUtil.getDataDicTblNm(tblNm);
			
			fldNm = trans.substring(index + 1);
		} else if (args.size() == 2) {
			tblNm = args.get(0).toString();
			fldNm = args.get(1).toString();
		} else {
			throw new TemplateModelException("Wrong arguments");
		}
		String str = "";
		LinkedHashMap allMap = SystemDictionaryUnit.getAllFieldDesc(tblNm,
				fldNm);
		if (allMap == null) {
			(new TemplateModelException("tblNm = " + tblNm + " : fldVal = "
					+ fldNm + " not found")).printStackTrace();
			return "";
		}
		Iterator it = allMap.keySet().iterator();
		try {
			while (it.hasNext()) {
				String fldId = (String) it.next();
				String fldVal = (String) allMap.get(fldId);
				str = str + fldId + "," + Code.encode(fldVal) + ";";
			}
		} catch (Exception ex) {
			throw new TemplateModelException(ex.getMessage(), ex);
		}
		return str;
	}
}