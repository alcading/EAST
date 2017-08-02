<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="账户开关信息">
	<@CommonQueryMacro.CommonQuery id="bopAccDsRecordADAdd" init="false" submitMode="current" navigate="false">
		<table width="800px">
			<tr>
				<td>
					<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd"> 帐号 </td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="accountno"/></td>
								<td rowspan="3" align="center" nowrap class="labeltd" >开户主体</td>
								<td align="center" nowrap class="labeltd"> 类型 </td>
								<td  class="datatd"> <@CommonQueryMacro.SingleField fId="amtype" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" > 币种 </td>
								<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="currencyCode" /></td>
								<td align="center" nowrap class="labeltd" > 代码 </td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="enCode" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" > 账户性质代码 </td>
								<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="accountType" /></td>
								<td align="center" nowrap class="labeltd" > 名称 </td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="enName" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" > 账户类别 </td>
								<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="accountCata" /></td>
								<td colspan="2" align="center" nowrap class="labeltd" > 外汇局批件号/备案表号/业务编号  </td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="fileNumber" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" width="25%"> 限额类型  </td>
								<td class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="limitType" /></td>
								<td colspan="2" align="center" nowrap class="labeltd"  width="25%"> 账户限额 </td>
								<td class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="accountLimit" /></td>
							</tr>
						</table>
					</@CommonQueryMacro.GroupBox>
				</td>
			</tr>
			<tr>
				<td>
					<@CommonQueryMacro.GroupBox id="guoup2" label="开关户信息" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd"  width="25%"> 账户状态 </td>
								<td nowrap class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="accountstat" /></td>
								<td  align="center" nowrap class="labeltd"  width="25%"> 业务发生日期  </td>
								<td class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="businessDate" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" width="25%"> 备注 </td>
								<td class="datatd" colspan="3"> <@CommonQueryMacro.SingleField fId="remark1" /></td>
							</tr>
						</table>
					</@CommonQueryMacro.GroupBox>
				</td>
			</tr>
			<tr>
				<td align="left">
					&nbsp;<@CommonQueryMacro.Button id="btSave"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id="btBack"/>
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">

		var op = "${RequestParameters["op"]?default('')}";

		function btBack_onClick(){
			closeWin();
		}
		function bopAccDsRecordADAdd_dataset_afterChange(dataset,field){
			var fieldName = field.fieldName;
			if (fieldName == "accountType") {
				//var accountType = bopAccDsRecordADAdd_dataset.getValue("accountType");
				//对除“境内划入保证金专用账户”以外的各类资本项目外汇账户的开立、变更、关户，为必填项。
				//if (accountType == "2105") {
				//	bopAccDsRecordADAdd_dataset.getField("fileNumber").required=true;
				//} else {
				//	bopAccDsRecordADAdd_dataset.getField("fileNumber").required=false;
				//}
			}
			if (fieldName == "limitType") {
				var limitType =  bopAccDsRecordADAdd_dataset.getValue("limitType");
				if (limitType == "12" || limitType == "13") {
					bopAccDsRecordADAdd_dataset.getField("accountLimit").required=true;
					bopAccDsRecordADAdd_dataset.setFieldReadOnly("accountLimit", false);
				} else {
					bopAccDsRecordADAdd_dataset.getField("accountLimit").required=false;
					bopAccDsRecordADAdd_dataset.setFieldReadOnly("accountLimit", true);
				}
			}
		}

		function btSave_onClickCheck(button) {
			//RBS要求账号为15位
			if ("del" != op) {
				var accountno = bopAccDsRecordADAdd_dataset.getValue("accountno");
				if(null != accountno && "" != accountno && accountno.length != 15){
					alert("帐号必须是15位数字");
					return false;
				}
			}
			bopAccDsRecordADAdd_dataset.setParameter("op",op);
			return true;
		}

		function btSave_postSubmit(button){
			alert("保存成功！");
			closeWin(true);
		}
	</script>
</@CommonQueryMacro.page>