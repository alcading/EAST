package com.huateng.report.vaild.impl;

import java.util.Iterator;

import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;

import com.huateng.report.bean.BopCFAExguTorAll;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaBAVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild( Object obj) {
		BopCFAExguTorAll ba = (BopCFAExguTorAll) obj;
		BopCfaExguDs ds = ba.getBopCfaExguDs();
		BopExguTorDs da = ba.getBopExguTorDs();
		StringBuffer result = new StringBuffer();
		/*result.append(this.lessLen(ds.getBename(), 128, "受益人名称"));
		result.append(this.lessLen(ds.getBencode(),32,"受益人代码"));
		result.append(this.valLenByNotNull(ds.getActiontype(),2, "操作类型"));*/
		result.append(this.checkActiontype(ds.getActiontype()));
		result.append(this.isDelRemarkVaild(ds.getActiontype(), ds.getActiondesc()));
		result.append(this.lessLen(ds.getExguarancode(), 28, "对外担保编号"));
		result.append(this.lessLen(ds.getGuarantorcode(), 12, "担保人代码"));
		result.append(this.isAmount22_2(ds.getMaindebtamount(), "主债务金额"));
		result.append(this.isAmount22_2(ds.getGuaranamount(), "保函金额"));
		result.append(checkDateFormat(ds.getContractdate(), "yyyyMMdd", "签约日期"));
		result.append(this.dateltCheckDateOrEqual(ds.getContractdate(),"签约日期"));
		result.append(this.optionOne(da.getTorName(), da.getTorEnname(), "中文名称和英文名称"));
		Iterator it = ba.getListBen().iterator();
		if(it.hasNext()){
			BopExguTorDs ben = (BopExguTorDs)it.next();
			result.append(this.exguTlrCodeVaild(ben.getTorCode(), ben.getTorType(), "受益人代码"));
			result.append(this.optionOne(ben.getTorName(), ben.getTorEnname(), "中文名称和英文名称"));
		}
		Iterator its = ba.getListGua().iterator();
		if(its.hasNext()){
			BopExguTorDs ben = (BopExguTorDs)its.next();
			result.append(this.exguTlrCodeVaild(ben.getTorCode(), ben.getTorType(), "被担保人代码"));
			result.append(this.optionOne(ben.getTorName(), ben.getTorEnname(), "中文名称和英文名称"));
		}
		
		result.append(this.exbuiSeNumVaild(ds.getApptype(),ds.getCurrentfile(),ds.getFiller2(),ds.getBrNo()));
		result.append(this.lessLenNull(ds.getRemark(), 256, "备注"));

		return result.toString();
	}

}



