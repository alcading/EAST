package com.huateng.report.vaild.bop.impl;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopUDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportBopUValid extends AbsReportDataVaild {

	public String executeDataVaild(Object obj) {

		MtsBopUDs ds = (MtsBopUDs) obj;
		StringBuilder result = new StringBuilder();

		//custcode必输， 技监局代码，代码必须符合技监局的机构代码编制规则，但去掉特殊代码000000000
		result.append(checkUnitCode(ds.getCustcode()));
		//必输，当常驻国为中国时必须输中文。
		result.append(lessLen(ds.getCustname(), 128, "组织机构名称"));
		result.append(isChinese(ds.getCustname(), ds.getCountrycode()));

		//必输，必须是行政区划表中存在的记录，但不能选100000。
		result.append(valLenByNotNull(ds.getAreacode(), 6, "住所/营业场所"));
		if (StringUtils.equals("100000", ds.getAreacode())) {
			result.append("行政区不能选100000");
		}
		//单位地址	字符型，256	选输。
		result.append(lessLenNull(ds.getCustaddr(), 256, "单位地址"));
		//邮政编码	字符型，6	选输。
		result.append(lessLenNull(ds.getPostcode(), 6, "邮政编码"));
		//必输，必须是行业属性代码表中存在的最细分类的记录
		result.append(valLenByNotNull(ds.getIndustrycode(), 4, "行业属性代码"));
		//必输，必须是经济类型代码表中存在的最细分类的记录。100、140、150、170、200、300由于不是最细分类，因此为不可选项；
		result.append(valLenByNotNull(ds.getAttrcode(), 3, "经济类型代码"));
		result.append(checkAttrcode(ds.getAttrcode()));
		//必输，字母代码，必须是国别/地区代码表中存在的记录。如果100、200、300项下的任何一项，则常驻国家地区应为中国CHN。如果经济类型选择400，则常驻国家地区为外国或者港澳台。
		result.append(valLenByNotNull(ds.getCountrycode(), 3, "常驻国家代码"));
		result.append(checkCountrycode(ds.getAttrcode(), ds.getCountrycode()));
		//必输，N-非特殊经济区内企业 ,Y-特殊经济区内企业
		result.append(isYorNAndNotNull(ds.getIstaxfree(), "是否特殊经济区内企业"));
		if (StringUtils.equals("Y", ds.getIstaxfree())) {
			result.append(valLenByNotNull(ds.getTaxfreecode(), 2, "特殊经济区内企业类型"));
		} else {
			if (StringUtils.isNotEmpty(ds.getTaxfreecode())) {
				result.append("[是否特殊经济区内企业]为[否],[特殊经济区内企业类型]必须为空");
			}
		}

		//必须是国别/地区代码表中存在的记录；
		//外方投资者国别不能选择中国。
		//如果经济类型为200项下，则外方投资者国别中至少有港澳台之一，不能为空；
		//如果经济类型选择300项下，则外方投资者国别中不能为空，至少一项为外国（中国大陆及港澳台除外）；
		//如果经济类型选择400，外方投资者国别必须为空。
		//投资国别代码个数<=5，同一笔单位基本情况表下投资国别代码不能重复
		result.append(checkInvcountrycode(ds.getAttrcode(), ds.getInvcountry()));
		//选输，用于与外汇局之间的日常办公联系用的eMail地址
		result.append(lessLenNull(ds.getEmail(), 128, "外汇局联系用eMail"));
		//选输，1、纸质申报,2、网上申报
		result.append(checkRptmethod(ds.getRptmethod()));
		//交易用eMail
		result.append(lessLenNull(ds.getEcexaddr(), 128, "交易用eMail"));
		//备注
		result.append(lessLenNull(ds.getRemarks(), 128, "备注"));
		//开户信息记录数>=1。同一笔单位基本情况表下开户信息中金融机构标识码不能重复
		result.append(checkBankinfo(ds.getBankinfos()));
		return result.toString();
	}
}
