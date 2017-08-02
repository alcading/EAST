<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean("bopAccDsRecordADInfo")>
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
	<@CommonQueryMacro.CommonQuery id="bopAccDsRecordADInfo" init="true" submitMode="all" navigate="false">
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
											<td class="datatd" colspan="3" width="75%"> <@CommonQueryMacro.SingleField fId="remark1" /></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
						<tr>
							<td align="left">
								<br>
								<@CommonQueryMacro.Button id="btSave"/>&nbsp;&nbsp;
								<@CommonQueryMacro.Button id="btBack"/>
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
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">
		var op = "${op}";

		function initCallGetter_post(){
			if (op == "delete") {
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("amtype",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("enCode",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountType",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("enName",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountCata",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("fileNumber",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("limitType",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountLimit",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountstat",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("businessDate",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("remark1",true);
			}
			if (op == "modify") {
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("actiondesc",true);
			}
			if (op == "detail"){
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("amtype",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("enCode",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountType",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("enName",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountCata",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("fileNumber",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("limitType",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountLimit",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountstat",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("businessDate",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("remark1",true);
				bopAccDsRecordADInfo_dataset.setFieldReadOnly("actiondesc",true);
				//保存按钮隐藏
				document.getElementById("btSave").style.display="none";
			}
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("accountno",true);
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("currencyCode",true);
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("actiontype",true);
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("recStatus",true);
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("approveStatus",true);
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("repStatus",true);
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("crtTm",true);
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("lstUpdTm",true);
			bopAccDsRecordADInfo_dataset.setFieldReadOnly("approveResult",true);

			//TODO 判断审核详细和回执详细
			var repStatus = bopAccDsRecordADInfo_dataset.getValue("repStatus");
			if (repStatus != "02") {
				document.getElementById("repHerf").href="#";
				document.getElementById("repHerf").style.color="#999999";
			}
		}

		function btSave_onClickCheck(){
			if (op == "modify") {
				var repStatus = bopAccDsRecordADInfo_dataset.getValue("repStatus");
				if (!bopAccDsRecordADInfo_dataset.modified && '01' != repStatus) {
					alert("请先修改后再保存！");
					return false;
				}
				bopAccDsRecordADInfo_dataset.setParameter("op",op);
			}
			if (op == "delete") {
				var actiondesc = bopAccDsRecordADInfo_dataset.getValue("actiondesc");
				if (actiondesc.length == 0) {
					alert("请填写删除原因！");
					return false;
				}
				bopAccDsRecordADInfo_dataset.setParameter("op", op);
			}
		}

		function doRepDet(){
			var id = bopAccDsRecordADInfo_dataset.getValue("id");
			var appType = bopAccDsRecordADInfo_dataset.getValue("appType");
			var currentfile = bopAccDsRecordADInfo_dataset.getValue("currentfile");
			var busiCode = bopAccDsRecordADInfo_dataset.getValue("fileNumber");
			showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
		}

		function btBack_onClick(){
			closeWin();
		}

		function btSave_onClickCheck(button) {
			//RBS要求账号为15位
			if ("delete" != op) {
				var accountno = bopAccDsRecordADInfo_dataset.getValue("accountno");
				if(null != accountno && "" != accountno && accountno.length != 15){
					alert("帐号必须是15位数字");
					return false;
				}
			}
			return true;
		}

		function btSave_postSubmit(button){
			alert("保存成功！");
			closeWin(true);
		}
	</script>
</@CommonQueryMacro.page>