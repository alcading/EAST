package com.huateng.report.vaild.impl;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaLounexguDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaDAVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		BopCfaLounexguDs da = (BopCfaLounexguDs) obj;
		StringBuffer result = new StringBuffer();
		// 操作类型 必填项
		result.append(this.isEmpty(da.getActiontype(), "操作类型"));

		// 删除原因
		result.append(this.isDelRemarkVaild(da.getActiontype(),
				da.getActiondesc()));

		// 必填项，境外担保项下境内贷款唯一性编码
		result.append(this.valLenByNotNull(da.getLounexgucode(), 28, "外保内贷编号"));

		// 必填项，金融机构标识码
		result.append(this.isEmpty(da.getCreditorcode(), "金融机构标识码"));

		// 必填项，债务人代码（组织机构代码）
		result.append(this.isEmpty(da.getDebtorcode(), "债务人代码"));

		// 必填项，债务人中文姓名
		result.append(this.isEmpty(da.getDebtorname(), "债务人中文姓名"));

		// 必填项，债务人类型
		result.append(this.isEmpty(da.getDebtortype(), "债务人类型"));

		// 中资企业境外担保项下贷款业务批准文件号 非必填项，债务人类型为“中资企业”时，为必填项。
		if (da.getDebtortype().equals("1011")) {

			result.append(this.isEmpty(da.getCfeogudad(),
					"债务人类型为“中资企业”时,中资企业境外担保项下贷款业务批准文件号"));

		}
		// 中资企业境外担保项下境内贷款额度币种 ,非必填项，债务人类型为“中资企业”时，为必填项
		if (da.getDebtortype().equals("1011")) {
			result.append(this.isEmpty(da.getCfeogudcurr(),
					"债务人类型为“中资企业”时,中资企业境外担保项下境内贷款额度币种"));
		}
		// 中资企业境外担保项下境内贷款额度金额 非必填项，大于等于0。债务人类型为“中资企业”时，为必填项。
		if (da.getDebtortype().equals("1011")) {
			result.append(this.isEmpty(da.getCfeogudamount(),
					"债务人类型为“中资企业”时,中资企业境外担保项下境内贷款额度金额"));
			result.append(this.isAmountAndZero22_2(da.getCfeogudamount(),
					"中资企业境外担保项下境内贷款额度金额"));

		}
		// 贷款币种 必填项
		result.append(this.isEmpty(da.getCredcurrcode(), "贷款币种"));

		// 贷款签约金额 必填项，大于等于0
		result.append(this.isAmountAndZero22_2(da.getCredconamount(), "贷款签约金额"));

		// 起息日 必填项 VALUEDATE
		result.append(this.checkDateFormat(da.getValuedate(), "yyyyMMdd", "起息日"));

		// 到期日 必填项，格式YYYYMMDD，大于等于起息日
		result.append(this.dateLessCheckDateOrEqual(da.getValuedate(),
				da.getMaturity(), "起息日", "到期日"));

		// 国内外汇贷款编号 非必填项，贷款币种不是“CNY”时，必填。

		if (da.getCredcurrcode().equals("CNY")) {
			if (StringUtils.isNotBlank(da.getDofoexlocode())) {
				result.append("贷款币种是CNY时,国内外汇贷款编号为空!");
			}

		} else {
			result.append(this.isEmpty(da.getDofoexlocode(), "国内外汇贷款编号"));

		}
		result.append(this.exbuiSeNumVaild(da.getApptype(),
				da.getCurrentfile(), da.getFiller2(), da.getBrNo()));

		if (da.getFogucodeinfos() != null) {
			for (int i = 0; i < da.getFogucodeinfos().size(); i++) {
				result.append(this.TypeConfirmCode(da.getFogucodeinfos().get(i)
						.getFogucode(), "境外担保人代码"));
				result.append(this.optionOne(da.getFogucodeinfos().get(i)
						.getFoguname(), da.getFogucodeinfos().get(i)
						.getFogunamen(), "境外担保人中英文名称"));
				result.append(this.isEmpty(da.getFogucodeinfos().get(i)
						.getFogurecode(), "境外担保人注册地国家/地区代码"));
				result.append(this.isEmpty(da.getFogucodeinfos().get(i)
						.getGuaranteetype(), "担保方式"));

			}
		}

		return result.toString();
	}

}
