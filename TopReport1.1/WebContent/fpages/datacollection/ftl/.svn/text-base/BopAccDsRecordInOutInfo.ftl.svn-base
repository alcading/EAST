<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean("bopAccDsRecordInOutInfo")>
<#assign op=RequestParameters["op"]?default("")>
<#if op=="detail">
	${CommonQueryConfig.setAnyValue("navigate","外汇账户补录 &gt; 开关账户信息&gt; 详细")}
</#if>
<#if op=="modify">
	${CommonQueryConfig.setAnyValue("navigate","外汇账户补录 &gt; 开关账户信息&gt; 修改")}
</#if>
<#if op=="delete">
	${CommonQueryConfig.setAnyValue("navigate","外汇账户补录 &gt; 开关账户信息&gt; 删除")}
</#if>
<@CommonQueryMacro.page title="账户开关信息">
	<@CommonQueryMacro.CommonQuery id="bopAccDsRecordInOutInfo" init="true" submitMode="all" navigate="false">
		<table width="90%" cellpadding="2">
			<tr>
				<td width="75%" valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd"> 帐号 </td>
											<td class="datatd" > <@CommonQueryMacro.SingleField fId="accountno"/><input id="loadAccountButton" extra="button" style='width=25px;height=17px;' onclick="loadAccount();" type='button' value='...'/></td>
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
								<@CommonQueryMacro.GroupBox id="guoup2" label="变动信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td  align="center" nowrap class="labeltd"  width="25%"> 业务发生日期  </td>
											<td class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="dealDate" /></td>
											<td align="center" nowrap class="labeltd"  width="25%"> 账户余额 </td>
											<td nowrap class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="balance" /></td>
										</tr>
										<tr>
											<td  align="center" nowrap class="labeltd"> 当日贷方发生额  </td>
											<td class="datatd"> <@CommonQueryMacro.SingleField fId="credit" /></td>
											<td align="center" nowrap class="labeltd"> 当日借方发生额 </td>
											<td nowrap class="datatd"> <@CommonQueryMacro.SingleField fId="debit" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" width="25%"> 备注 </td>
											<td class="datatd" colspan="3"> <@CommonQueryMacro.SingleField fId="remark2" /></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
					</table>
				</td>
				<td width="8px"></td>
				<td width="25%"  valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup3" label="系统信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd"  width="25%"> 操作类型 </td>
											<td nowrap class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="actiontype" /></td>
										</tr>
										<tr>
											<td  align="center" nowrap class="labeltd"  width="25%"> 记录状态 </td>
											<td class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="recStatus" /></td>
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
											<td align="center" nowrap class="labeltd" > 创建时间 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="crtTm" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" > 最后更新时间 </td>
											<td class="datatd" > <@CommonQueryMacro.SingleField fId="lstUpdTm" /></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup4" label="删除原因" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd" width="25%"> 删除原因 </td>
											<td class="datatd" width="75%"> <@CommonQueryMacro.SingleField fId="actiondesc" /></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="left" colspan="3">
					<@CommonQueryMacro.Button id="btSave"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id="btBack"/>
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">
		var op = "${op}";

		function initCallGetter_post(){
			if (op == "delete") {
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("amtype",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("enCode",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountType",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("enName",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountCata",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("fileNumber",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("limitType",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountLimit",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("balance",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("credit",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("debit",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("remark2",true);
			}
			if (op == "modify") {
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("amtype",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("enCode",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountType",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("enName",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountCata",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("fileNumber",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("limitType",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountLimit",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("actiondesc",true);
			}
			if (op == "detail"){
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("amtype",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("enCode",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountType",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("enName",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountCata",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("fileNumber",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("limitType",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountLimit",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("balance",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("credit",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("debit",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("remark2",true);
				bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("actiondesc",true);
				//保存按钮隐藏
				document.getElementById("btSave").style.display="none";
			}
			//隐藏选择账号的按钮
			document.getElementById("loadAccountButton").style.display="none";

			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("accountno",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("currencyCode",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("dealDate",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("actiontype",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("recStatus",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("approveStatus",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("repStatus",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("crtTm",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("lstUpdTm",true);
			bopAccDsRecordInOutInfo_dataset.setFieldReadOnly("approveResult",true);
			//TODO 判断审核详细和回执详细
			var repStatus = bopAccDsRecordInOutInfo_dataset.getValue("repStatus");
			if (repStatus != "02") {
				document.getElementById("repHerf").href="#";
				document.getElementById("repHerf").style.color="#999999";
			}
		}

		function btSave_onClickCheck(){
			if (op == "modify") {
			var repStatus = bopAccDsRecordInOutInfo_dataset.getValue("repStatus");
				if (!bopAccDsRecordInOutInfo_dataset.modified && '01' != repStatus) {
					alert("请先修改后再保存！");
					return false;
				}
				bopAccDsRecordInOutInfo_dataset.setParameter("op",op);
			}
			if (op == "delete") {
				var actiondesc = bopAccDsRecordInOutInfo_dataset.getValue("actiondesc");
				if (actiondesc.length == 0) {
					alert("请填写删除原因！");
					return false;
				}
				bopAccDsRecordInOutInfo_dataset.setParameter("op", op);
			}
		}

		function doRepDet(){
			var id = bopAccDsRecordInOutInfo_dataset.getValue("id");
			var appType = bopAccDsRecordInOutInfo_dataset.getValue("appType");
			var currentfile = bopAccDsRecordInOutInfo_dataset.getValue("currentfile");
			var busiCode = bopAccDsRecordInOutInfo_dataset.getValue("fileNumber");
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