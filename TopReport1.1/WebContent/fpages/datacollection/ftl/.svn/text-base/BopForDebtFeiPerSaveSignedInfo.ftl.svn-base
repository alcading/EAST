<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQuery id="bopForDebtFeiPerSaveSigned" init="true" submitMode="current" navigate="false">
		<table  width="95%" cellpadding="2">
			<tr>
				<td  width="75%" valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd">外债编号</td>
											<td class="datatd" ><@CommonQueryMacro.SingleField fId="exdebtcode"/></td>
											<td rowspan="5" align="center" nowrap class="labeltd">债权人信息</td>
											<td align="center" nowrap class="labeltd">债权人代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="creditorcode"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" width="25%">债务人代码</td>
											<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="debtorcode"/></td>
											<td align="center" nowrap class="labeltd" width="25%">债权人中文名称</td>
											<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="creditorname"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">债务类型</td>
											<td class="datatd" ><@CommonQueryMacro.SingleField fId="debtype"/></td>
											<td align="center" nowrap class="labeltd">债权人英文名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="creditornamen"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">签约币种</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="contractcurr"/></td>
											<td align="center" nowrap class="labeltd">债权人类型代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="creditortype"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">是否浮动利率</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="floatrate"/></td>
											<td align="center" nowrap class="labeltd">债权人国家（地区）代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="crehqcode"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">是否经外汇局特批不需占用指标</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="spapfeboindex"/></td>
											<td align="center" colspan="2" nowrap class="labeltd">年化利率值</td>
											<td class="datatd" ><@CommonQueryMacro.SingleField fId="anninrate"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">业务流水号</td>
											<td class="datatd" colspan="4"><@CommonQueryMacro.SingleField fId="filler2"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">备注</td>
											<td class="datatd" colspan="4"><@CommonQueryMacro.SingleField fId="remark"/></td>
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

			<tr>
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
				bopForDebtFeiPerSaveSigned_dataset.setValue2("creditortype","20001699");
				bopForDebtFeiPerSaveSigned_dataset.setValue("creditortypeName","其他企业");
				bopForDebtFeiPerSaveSigned_dataset.setValue2("floatrate","N");
				bopForDebtFeiPerSaveSigned_dataset.setValue2("spapfeboindex","N");
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("exdebtcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditortype",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("debtorcode",true);
				document.getElementById("sysMsgGroup").style.display="none";
			}
			if (op == "delete") {
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("exdebtcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("debtype",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("debtorcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("contractcurr",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("contractamount",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("floatrate",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("anninrate",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("spapfeboindex",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("remark",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditorcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditorname",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditornamen",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditortype",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("crehqcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("filler2",true);
			}
			if (op == "modify") {
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("exdebtcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("actiondesc",true);
			}
			if (op == "detail"){
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("exdebtcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("debtype",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("debtorcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("contractcurr",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("contractamount",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("floatrate",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("anninrate",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("spapfeboindex",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("remark",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("actiondesc",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditorcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditorname",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditornamen",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("creditortype",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("crehqcode",true);
				bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("filler2",true);
				//保存按钮隐藏
				document.getElementById("btSave").style.display="none";
			}
			bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("actiontype",true);
			bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("recStatus",true);
			bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("approveStatus",true);
			bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("repStatus",true);
			bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("crtTm",true);
			bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("lstUpdTm",true);
			bopForDebtFeiPerSaveSigned_dataset.setFieldReadOnly("approveResult",true);

			//TODO 判断审核详细和回执详细
			var repStatus = bopForDebtFeiPerSaveSigned_dataset.getValue("repStatus");
			if (repStatus != "02") {
				document.getElementById("repHerf").href="#";
				document.getElementById("repHerf").style.color="#999999";
			}
		}

		function btSave_onClickCheck(){
			if (op == "new") {
				bopForDebtFeiPerSaveSigned_dataset.setParameter("op",op);
				var v_creditorname = bopForDebtFeiPerSaveSigned_dataset.getValue("creditorname");
				var v_creditornamen = bopForDebtFeiPerSaveSigned_dataset.getValue("creditornamen");
				if( v_creditorname == "" && v_creditornamen == "" ){
					alert("每个债权人的中文名称和英文名称必须填一个！");
					return false;
				}
				var anninrate = bopForDebtFeiPerSaveSigned_dataset.getValue("anninrate");
				if (!isNaN(anninrate) && parseFloat(anninrate) >= 1) {
					alert("[年化利率值]必须为小数");
					return false;
				}
			}
			if (op == "modify") {
				if (!bopForDebtFeiPerSaveSigned_dataset.modified) {
					alert("请先修改后再保存！");
					return false;
				}
				var v_creditorname = bopForDebtFeiPerSaveSigned_dataset.getValue("creditorname");
				var v_creditornamen = bopForDebtFeiPerSaveSigned_dataset.getValue("creditornamen");
				if( v_creditorname == "" && v_creditornamen == "" ){
					alert("每个债权人的中文名称和英文名称必须填一个！");
					return false;
				}
				var anninrate = bopForDebtFeiPerSaveSigned_dataset.getValue("anninrate");
				if (!isNaN(anninrate) && parseFloat(anninrate) >= 1) {
					alert("[年化利率值]必须为小数");
					return false;
				}
				bopForDebtFeiPerSaveSigned_dataset.setParameter("op",op);
			}
			if (op == "delete") {
				var actiondesc = bopForDebtFeiPerSaveSigned_dataset.getValue("actiondesc");
				if (actiondesc.length == 0) {
					alert("请填写删除原因！");
					return false;
				}
				bopForDebtFeiPerSaveSigned_dataset.setParameter("op", op);
			}
		}
		function doRepDet(){
			var id = bopForDebtFeiPerSaveSigned_dataset.getValue("id");
			var appType = bopForDebtFeiPerSaveSigned_dataset.getValue("appType");
			var currentfile = bopForDebtFeiPerSaveSigned_dataset.getValue("currentfile");
			var busiCode = bopForDebtFeiPerSaveSigned_dataset.getValue("exdebtcode");
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