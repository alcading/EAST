<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="BopForCorAndAffOrgContact" init="true" submitMode="current" navigate="false" >
	<table  width="95%" cellpadding="2">
		<tr>
			<td  width="75%" valign="top"   >
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息"  expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td align="center" nowrap class="labeltd">外债编号</td>
									<td class="datatd" ><@CommonQueryMacro.SingleField fId="exdebtcode"/></td>
									<td rowspan="6" align="center" nowrap class="labeltd">债权人信息</td>
									<td align="center" nowrap class="labeltd">代码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField  fId="creditorcode"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd" width="25%">债务人代码</td>
									<td class="datatd" width="25%"><@CommonQueryMacro.SingleField  fId="debtorcode"/></td>
									<td align="center" nowrap class="labeltd" width="25%">中文名称</td>
									<td class="datatd" width="25%"><@CommonQueryMacro.SingleField  fId="creditorname"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">债务类型</td>
									<td class="datatd" ><@CommonQueryMacro.SingleField  fId="debtype"/></td>
									<td align="center" nowrap class="labeltd">英文名称</td>
									<td class="datatd"><@CommonQueryMacro.SingleField  fId="creditornamen"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">起息日</td>
									<td class="datatd"><@CommonQueryMacro.SingleField  fId="valuedate"/></td>
									<td align="center" nowrap class="labeltd">类型代码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="creditortype"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">签约币种</td>
									<td class="datatd"><@CommonQueryMacro.SingleField	fId="contractcurr"/></td>
									<td align="center" nowrap class="labeltd">总部所在国家（地区）代码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField	fId="crehqcode"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">是否浮动利率</td>
									<td class="datatd"><@CommonQueryMacro.SingleField  fId="floatrate"/></td>
									<td align="center" nowrap class="labeltd">经营地所在国家（地区）代码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField	fId="opercode"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">是否经外汇局特批不需占用指标</td>
									<td class="datatd" ><@CommonQueryMacro.SingleField	fId="spapfeboindex"/></td>
									<td align="center" colspan="2" nowrap class="labeltd">年化利率值</td>
									<td class="datatd" ><@CommonQueryMacro.SingleField  fId="anninrate"/></td>
								</tr>
								<tr>

								    <td align="center" nowrap class="labeltd">业务流水号</td>
									<td class="datatd" ><@CommonQueryMacro.SingleField  fId="filler2"/></td>

									<td  align="center"  colspan="2" nowrap class="labeltd">备注</td>
									<td class="datatd" ><@CommonQueryMacro.SingleField fId="remark"/></td>

								</tr>
							</table>
							</@CommonQueryMacro.GroupBox>
						</td>
					</tr>
				</table>
			</td>

			<td width="8px"></td>
			<td width="25%"  valign="top" id="sysMsgGroup">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						  <@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD1" label="系统信息"  expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td  align="center" nowrap class="labeltd">操作类型</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="actiontype"/></td>
								</tr>
								<tr>

									<td  align="center" nowrap class="labeltd" width="25%">记录状态</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="recStatus"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd" > 审批状态 </td>
									<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveStatus" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd" > 审批结果 </td>
									<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveResult" /></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd" > 回执状态 </td>
									<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a></td>
								</tr>

								<tr>
									<td  align="center" nowrap class="labeltd">创建时间</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="crtTm"/></td>
								</tr>
								<tr>
									<td  align="center" nowrap class="labeltd">最后更新时间</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm"/></td>
								</tr>

								</table>
							  </@CommonQueryMacro.GroupBox>
							</td>
						</tr>

						<tr>
							<td>
							  <@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD2" label="删除信息"   expand="true">
								<table frame=void class="grouptable" width="100%" >
									<tr>
										<td  align="center" nowrap class="labeltd">删除原因</td>
										<td class="datatd" ><@CommonQueryMacro.SingleField fId="actiondesc"/></td>
									</tr>
								</table>
							  </@CommonQueryMacro.GroupBox>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr >
				<td align="left" colspan="3">
					<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
				</td>
			</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

	function debtype_DropDown_beforeOpen(dropDown){
		DataDicTreeSelect_DropDownDataset.setParameter("headDataTypeNo","24");
	}

	function creditortype_DropDown_beforeOpen(dropDown){
		DataDicTreeSelectCor_DropDownDataset.setParameter("headDataTypeNo","23");
	}

	var op = "${op}";

	function initCallGetter_post(){
		if (op == "new") {
			//BopForCorAndAffOrgContact_dataset.setValue2("creditortype","20001602");
			//BopForCorAndAffOrgContact_dataset.setValue("creditortypeName","境内企业境外分支及附属机构");
			BopForCorAndAffOrgContact_dataset.setValue2("floatrate","N");
			BopForCorAndAffOrgContact_dataset.setValue2("spapfeboindex","N");
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("exdebtcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("debtorcode",true);
			//BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditortype",false);
			document.getElementById("sysMsgGroup").style.display="none";
		}
		if (op == "delete") {
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("exdebtcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("debtype",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("debtorcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("contractcurr",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("contractamount",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("valuedate",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("maturity",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("floatrate",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("anninrate",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("inprterm",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("spapfeboindex",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("remark",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("limitType",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditorcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditorname",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditornamen",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditortype",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("crehqcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("opercode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("filler2",true);
		}
		if (op == "modify") {
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("exdebtcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("actiondesc",true);
		}
		if (op == "detail"){
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("exdebtcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("debtype",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("debtorcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("contractcurr",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("contractamount",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("valuedate",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("maturity",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("floatrate",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("anninrate",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("inprterm",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("spapfeboindex",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("remark",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("actiondesc",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("limitType",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditorcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditorname",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditornamen",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("creditortype",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("crehqcode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("opercode",true);
			BopForCorAndAffOrgContact_dataset.setFieldReadOnly("filler2",true);
			//保存按钮隐藏
			document.getElementById("btSave").style.display="none";
		}
		BopForCorAndAffOrgContact_dataset.setFieldReadOnly("actiontype",true);
		BopForCorAndAffOrgContact_dataset.setFieldReadOnly("recStatus",true);
		BopForCorAndAffOrgContact_dataset.setFieldReadOnly("approveStatus",true);
		BopForCorAndAffOrgContact_dataset.setFieldReadOnly("repStatus",true);
		BopForCorAndAffOrgContact_dataset.setFieldReadOnly("crtTm",true);
		BopForCorAndAffOrgContact_dataset.setFieldReadOnly("lstUpdTm",true);
		BopForCorAndAffOrgContact_dataset.setFieldReadOnly("approveResult",true);

		//TODO 判断审核详细和回执详细
		var repStatus = BopForCorAndAffOrgContact_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
	}

	function btSave_onClickCheck(){
		if (op == "new") {
			BopForCorAndAffOrgContact_dataset.setParameter("op",op);
			var v_creditorname = BopForCorAndAffOrgContact_dataset.getValue("creditorname");
			var v_creditornamen = BopForCorAndAffOrgContact_dataset.getValue("creditornamen");
			if( v_creditorname == "" && v_creditornamen == "" ){
				alert("每个债权人的中文名称和英文名称必须填一个！");
				return false;
			}
		}
		if (op == "modify") {
			if (!BopForCorAndAffOrgContact_dataset.modified) {
				alert("请先修改后再保存！");
				return false;
			}
			var v_creditorname = BopForCorAndAffOrgContact_dataset.getValue("creditorname");
			var v_creditornamen = BopForCorAndAffOrgContact_dataset.getValue("creditornamen");
			if( v_creditorname == "" && v_creditornamen == "" ){
				alert("每个债权人的中文名称和英文名称必须填一个！");
				return false;
			}
			BopForCorAndAffOrgContact_dataset.setParameter("op",op);
		}
		if (op == "delete") {
			var actiondesc = BopForCorAndAffOrgContact_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("请填写删除原因！");
				return false;
			}
			BopForCorAndAffOrgContact_dataset.setParameter("op", op);
		}
	}

	function doRepDet(){
		var id = BopForCorAndAffOrgContact_dataset.getValue("id");
		var appType = BopForCorAndAffOrgContact_dataset.getValue("appType");
		var currentfile = BopForCorAndAffOrgContact_dataset.getValue("currentfile");
		var busiCode = BopForCorAndAffOrgContact_dataset.getValue("exdebtcode");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
	}

	function btBack_onClick(){
		closeWin();
	}

	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}
</script>
</@CommonQueryMacro.page>