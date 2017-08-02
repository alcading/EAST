<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="基础信息">
<@CommonQueryMacro.CommonQuery id="BopUDsCollectionInfo" init="true" insertOnEmpty="true" submitMode="current" navigate="false">
<table width="90%" cellpadding="2">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox1" label="基础信息" expand="true">
							<table frame="void" class="grouptable" width="100%">
								<tr>
									<td align="center" nowrap class="labeltd">组织机构代码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="custcode"/></td>
									<td align="center" nowrap class="labeltd">组织机构名称</td>
									<td><@CommonQueryMacro.SingleField fId="custname"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">住所/营业场所 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="areacode" /></td>
									<td align="center" nowrap class="labeltd">单位地址 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="custaddr" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">邮政编码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="postcode"/></td>
									<td align="center" nowrap class="labeltd">常驻国家代码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="countrycode" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">行业属性代码 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="industrycode" /></td>
									<td align="center" nowrap class="labeltd">经济类型代码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="attrcode" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">是否特殊经济区内企业</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="istaxfree" /></td>
									<td align="center" nowrap class="labeltd">特殊经济区内企业类型</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="taxfreecode" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">外汇局联系用eMail</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="email" /></td>
									<td align="center" nowrap class="labeltd">交易用eMail</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="ecexaddr" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">申报方式 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="rptmethod" /></td>
									<td align="center" nowrap class="labeltd">备注</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="remarks" /></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>

		<#assign op=RequestParameters["op"]?default("")>
		<#if op != "new">
		<td width="8px"></td>

		<td valign="top">
			<table id="systemMessageTable" width="100%" cellpadding="0" cellspacing="0" style="">
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox2" label="系统信息" expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td align="center" nowrap class="labeltd" >记录状态</td>
									<td class="datatd" ><@CommonQueryMacro.SingleField fId="recStatus" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">审批状态</td>
									<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="approveStatus" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">审批结果</td>
									<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="approveResult" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">回执状态</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="repStatus"/>
										<a id="repResult" href="JavaScript:doRepDet()">回执说明<a/>
									</td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">创建时间</td>
									<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="crtTm" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">最后更新时间</td>
									<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm" /></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>
		</#if>
	</tr>

	<tr>
		<td align="left" colspan="3">
			<@CommonQueryMacro.CommonQuery id="BopInvcountrycode" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
				<@CommonQueryMacro.GroupBox id="guoup2" label="外方投资者国别" expand="true">
					<table frame=void width="100%">
						<#assign op = RequestParameters["op"]?default("")>
						<#assign subSuccess = RequestParameters["subSuccess"]?default("0")>
						<#if (op == "new" || op == "modify") && subSuccess == "0">
							<tr>
								<td align="right">
									<@CommonQueryMacro.Button id= "btAddRecord"/>&nbsp;&nbsp;
									<@CommonQueryMacro.Button id= "btDelRecord"/>&nbsp;&nbsp;
								</td>
							</tr>
						</#if>
						<tr>
							<td>
								<@CommonQueryMacro.DataTable id="invcountrycodedatatable" fieldStr="invcountrycode" readonly="false" width="100%" hasFrame="true" height="200px" />
							</td>
						</tr>
					</table>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>

	<tr>
		<td align="left" colspan="3">
			<@CommonQueryMacro.CommonQuery id="BopOpenDsCollection" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
				<@CommonQueryMacro.GroupBox id="guoup2" label="开户信息" expand="true">
					<table frame=void width="100%">
						<#assign op=RequestParameters["op"]?default("")>
						<#if op == "new" || op == "modify">
							<tr>
								<td align="right">
									<@CommonQueryMacro.Button id= "btAddAccount"/>&nbsp;&nbsp;
									<@CommonQueryMacro.Button id= "btDelAccount"/>&nbsp;&nbsp;
								</td>
							</tr>
						</#if>
						<tr>
							<td>
								<@CommonQueryMacro.DataTable id="openaccounttable" fieldStr="branchcode[180],contact,tel,fax" readonly="false" width="100%" hasFrame="true" height="200px" />
							</td>
						</tr>
					</table>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>

	<tr>
		<td align="left" colspan="3">
			<@CommonQueryMacro.CommonQuery mode = "1" id = "BopUDsCollectionInfo">
				<#assign op=RequestParameters["op"]?default("")>
				<#if op != "detail">
					<@CommonQueryMacro.Button id="btSave"/>&nbsp; &nbsp;
				</#if>
				<@CommonQueryMacro.Button id="btBack"/>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

	var op = "${RequestParameters["op"]?default('')}";

	function initCallGetter_post() {

		//回执说明链接样式
		var repStatus = BopUDsCollectionInfo_dataset.getValue("repStatus");
		if(repStatus == "00" || repStatus == "01") {
			document.getElementById("repResult").href = "javascript:void(0)";
			document.getElementById("repResult").style.color = "#999999";
		}

		if ("modify" == op) {
			var subSuccess = BopUDsCollectionInfo_dataset.getValue("subSuccess");
			if (subSuccess == "1") {
				BopUDsCollectionInfo_dataset.setFieldReadOnly("custcode",true);
				BopUDsCollectionInfo_dataset.setFieldReadOnly("custname",true);
				BopUDsCollectionInfo_dataset.setFieldReadOnly("industrycode",true);
				BopUDsCollectionInfo_dataset.setFieldReadOnly("attrcode",true);
				BopUDsCollectionInfo_dataset.setFieldReadOnly("countrycode",true);
				BopUDsCollectionInfo_dataset.setFieldReadOnly("istaxfree",true);
				BopUDsCollectionInfo_dataset.setFieldReadOnly("areacode",true);
				BopInvcountrycode_dataset.setFieldReadOnly("invcountrycode",true);
			}
		} else if ("delete" == op || "detail" == op) {
			BopUDsCollectionInfo_dataset.setFieldReadOnly("custcode",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("custname",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("areacode",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("custaddr",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("postcode",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("countrycode",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("industrycode",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("attrcode",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("istaxfree",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("taxfreecode",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("email",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("ecexaddr",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("rptmethod",true);
			BopUDsCollectionInfo_dataset.setFieldReadOnly("remarks",true);


			BopInvcountrycode_dataset.setFieldReadOnly("invcountrycode",true);

			BopOpenDsCollection_dataset.setFieldReadOnly("branchcode",true);
			BopOpenDsCollection_dataset.setFieldReadOnly("contact",true);
			BopOpenDsCollection_dataset.setFieldReadOnly("tel",true);
			BopOpenDsCollection_dataset.setFieldReadOnly("fax",true);

		}
	}

	function getNumberFromUnitCode(code) {
		var SerialNumber = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return SerialNumber.indexOf(code);
	}

	function checkUnitCode(UnitCode) {
		if (UnitCode == null || "" == UnitCode || UnitCode.length != 9 || "000000000" == UnitCode) {
			alert("组织机构代码不符合规范");
			return false;
		}
		var one = getNumberFromUnitCode(UnitCode.substring(0, 1));
		var two = getNumberFromUnitCode(UnitCode.substring(1, 2));
		var three = getNumberFromUnitCode(UnitCode.substring(2, 3));
		var four = getNumberFromUnitCode(UnitCode.substring(3, 4));
		var five = getNumberFromUnitCode(UnitCode.substring(4, 5));
		var six = getNumberFromUnitCode(UnitCode.substring(5, 6));
		var seven = getNumberFromUnitCode(UnitCode.substring(6, 7));
		var eight = getNumberFromUnitCode(UnitCode.substring(7, 8));
		var tag = 11 - (one * 3 + two * 7 + three * 9 + four * 10 + five * 5 + six * 8 + seven * 4 + eight * 2) % 11;
		if ("X" != UnitCode.substring(8, 9) && tag == 10) {
			alert("组织机构代码不符合规范,最后一位必须为X");
			return false;
		} else if ("0" != UnitCode.substring(8, 9) && tag == 11) {
			alert("组织机构代码不符合规范,最后一位必须为0");
			return false;
		} else if (tag != 10 && tag != 11) {
			var nine = getNumberFromUnitCode(UnitCode.substring(8, 9));
			if (nine != tag) {
				alert("组织机构代码不符合规范,最后一位必须为" + tag);
				return false;
			}
		}
		return true;
	}

	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {

		if (op == "new" || op == "modify") {
			var custcode = BopUDsCollectionInfo_dataset.getValue("custcode");
			var countrycode = BopUDsCollectionInfo_dataset.getValue("countrycode");
			var areacode = BopUDsCollectionInfo_dataset.getValue("areacode");
			var attrcode = BopUDsCollectionInfo_dataset.getValue("attrcode");
			var istaxfree = BopUDsCollectionInfo_dataset.getValue("istaxfree");
			var taxfreecode = BopUDsCollectionInfo_dataset.getValue("taxfreecode");
			var custname = BopUDsCollectionInfo_dataset.getValue("custname");

			if (!checkUnitCode(custcode)) {
				return false;
			}
			if (countrycode == "CHN") {
				if (!isChinese(custname)) {
					alert("[常驻国家代码]为中国时[组织机构名称]必须为中文");
					return false;
				}
			}
			if (areacode == "100000") {
				alert("[住所/营业场所]不能选[100000]");
				return false;
			}
			if (attrcode == "100" || attrcode == "140" || attrcode == "150" || attrcode == "170" || attrcode == "200" || attrcode == "300") {
				alert("[内资]、[联营]、[有限责任（公司）]、[私有]、[港澳台投资]、[国外投资]由于不是最细分类，因此为不可选项");
				return false;
			}
			if (attrcode == "110" || attrcode == "120" || attrcode == "130" || attrcode == "210"
				|| attrcode == "220" || attrcode == "230" || attrcode == "240" || attrcode == "290"
				|| attrcode == "310" || attrcode == "320" || attrcode == "330" || attrcode == "340"
				|| attrcode == "390") {
				if (countrycode != "CHN") {
					alert("[经济类型代码]为[内资],[港澳台投资],[国外投资]项下[常驻国家代码]应为[中国]");
					return false;
				}
			}
			if (attrcode == "400") {
				if (countrycode == "CHN") {
					alert("[经济类型代码]为[境外机构],[常驻国家代码]应为[外国或港澳台]");
				}
			}
			if (null != istaxfree && istaxfree == "Y") {
				if (taxfreecode == "") {
					alert("[是否特殊经济区内企业]为[特殊经济区内企业],[特殊经济区内企业类型]不能为空");
					return false;
				}
			} else if (null != istaxfree && istaxfree == "N") {
				if (taxfreecode != "") {
					alert("[是否特殊经济区内企业]为[非特殊经济区内企业],[特殊经济区内企业类型]无需填写");
					return false;
				}
			}
			//校验外方投资者国别
			if (attrcode == "400") {
				var record = BopInvcountrycode_dataset.getFirstRecord();
				if (null != record) {
					alert("[经济类型]为[境外机构],[外方投资者国别]必须为空");
					return false;
				}
			}
			if (attrcode == "210" || attrcode == "220" || attrcode == "230" || attrcode == "240" || attrcode == "290") {
				var flag = false;
				var record = BopInvcountrycode_dataset.getFirstRecord();
				if (null == record) {
					alert("[经济类型]为[港澳台投资]项下,[外方投资者国别]不能为空");
					return false;
				}
				while (record) {
					var invcountrycode = record.getValue("invcountrycode");
					if (invcountrycode == "HKG" || invcountrycode == "MAC" || invcountrycode == "TWN") {
						flag = true;
					}
					record = record.getNextRecord();
				}
				if (!flag) {
					alert("[经济类型]为[港澳台投资]项下,[外方投资者国别]中至少有[港澳台]之一");
					return false;
				}
			}
			if (attrcode == "310" || attrcode == "320" || attrcode == "330" || attrcode == "340" || attrcode == "390") {
				var record = BopInvcountrycode_dataset.getFirstRecord();
				var flag = false;
				if (null == record) {
					alert("[经济类型]为[国外投资]项下,[外方投资者国别]不能为空");
					return false;
				}
				while (record) {
					var invcountrycode = record.getValue("invcountrycode");
					if (invcountrycode != "HKG" && invcountrycode != "MAC" && invcountrycode != "TWN" && invcountrycode != "CHN") {
						flag = true;
					}
					record = record.getNextRecord();
				}
				if (!flag) {
					alert("[经济类型]为[港澳台投资]项下,[外方投资者国别]至少一项为外国（中国大陆及港澳台除外）");
					return false;
				}
			}
			var record = BopInvcountrycode_dataset.getFirstRecord();
			if (null != record) {
				while (record) {
					var invcountrycode = record.getValue("invcountrycode");
					if ("CHN" == invcountrycode) {
						alert("外方投资者国别不能选择中国");
						return false;
					}
					var count = 0;
					var countryrRcord = BopInvcountrycode_dataset.getFirstRecord();
					while (countryrRcord) {
						country = countryrRcord.getValue("invcountrycode");
						if (country == invcountrycode) {
							count ++;
						}
						countryrRcord = countryrRcord.getNextRecord();
					}
					if (1 < count){
						alert("同一笔[单位基本情况表]下[投资国别代码]不能重复");
						return false;
					}
					record = record.getNextRecord();
				}
			}
			var record = BopInvcountrycode_dataset.getFirstRecord();
			var count = 0;
			while (record) {
				count ++;
				if (count > 5) {
					alert("同一笔[单位基本情况表]下[投资国别代码]个数必须小于等于[5]");
					return false;
				}
				record = record.getNextRecord();
			}


			//开户信息
			var record = BopOpenDsCollection_dataset.getFirstRecord();
			if (null == record) {
				alert("同一笔[单位基本情况表],[开户信息]记录数必须大于等于[1]");
				return false;
			}
			while (record) {
				var branchcode = record.getValue("branchcode");
				var bankRcord = BopOpenDsCollection_dataset.getFirstRecord();
				var count = 0;
				while (bankRcord) {
					if (branchcode == bankRcord.getValue("branchcode")) {
						count ++;
					}
					bankRcord = bankRcord.getNextRecord();
				}
				if (1 < count) {
					alert("同一笔[单位基本情况表]下[开户信息]的[金融机构标识码]不能重复");
					return false;
				}
				record = record.getNextRecord();
			}
		}
		return true;
	}


	function isChinese(str){
		//半角
		var badChar ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		badChar += "abcdefghijklmnopqrstuvwxyz";
		badChar += "0123456789";
		badChar += "`~!@#$%^&()-_=+[]\\|:;\"\\'<,>?/";//不包含*或.的英文符号
		badChar += " ";

		//全角
		badChar += "ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ";
		badChar += "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
		badChar += "０１２３４５６７８９";
		badChar += "　";
		badChar += "｀～！＠＃＄％＾＆（）－＿＝＋［］＼｜：；＂＇＜，＞？／";//不包含*或.的英文符号
		if ("" == str) {
			return true;
		}
		for (var i= 0;i < str.length; i++) {
			var c = str.charAt(i);//字符串str中的字符
			if (badChar.indexOf(c) > -1) {
				return false;
			}
		}
		return true;
	}

	function btSave_postSubmit(button) {
		alert("保存成功！");
		closeWin(true);
	}

	function doRepDet() {
		var id = BopUDsCollectionInfo_dataset.getValue("id");
		var appType = BopUDsCollectionInfo_dataset.getValue("appType");
		var currentfile = BopUDsCollectionInfo_dataset.getValue("currentfile");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile, 600, 500);
	}

	function btBack_onClick() {
		closeWin();
	}


</script>
</@CommonQueryMacro.page>