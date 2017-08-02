<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="余额信息">
	<@CommonQueryMacro.CommonQuery id="bopForDebtFeiPerSaveOver" init="true" submitMode="current" navigate="false" >
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
											<td class="datatd" >
												<@CommonQueryMacro.SingleField fId="exdebtcode"/>
												<input id="loadFeiPerSave" extra="button" style='width=25px;height=17px;' onclick="loadFeiPerSave();" type='button' value='...'/></td>
											</td>
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


										<tr style="display:none">
											<td>
												<@CommonQueryMacro.SingleField fId="opercode"/>
											</td>
										</tr>

									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>

						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup1" label="余额信息"  expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd">变动编号</td>
											<td class="datatd" ><@CommonQueryMacro.SingleField fId="changeno"/></td>
											<td align="center" nowrap class="labeltd">变动日期</td>
											<td class="datatd"><@CommonQueryMacro.SingleField  fId="chdate"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">银行帐号</td>
											<td class="datatd" width="25%"><@CommonQueryMacro.SingleField  fId="buscode"/></td>
											<td align="center" nowrap class="labeltd">外债余额</td>
											<td class="datatd" width="25%"><@CommonQueryMacro.SingleField  fId="accoamount"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">业务流水号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
											<td align="center" nowrap class="labeltd">备注</td>
											<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="remark"/></td>
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
				if (bopForDebtFeiPerSaveOver_dataset.length==0) {
					bopForDebtFeiPerSaveOver_dataset.insertRecord("end");
				}
				<#assign v_changeno = statics["com.huateng.report.utils.ReportUtils"].getTempStr(null,4)>
				bopForDebtFeiPerSaveOver_dataset.setValue("changeno", "${v_changeno}");
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("changeno",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("exdebtcode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtype", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtorcode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditorcode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditorname", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditornamen", true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("limitType", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditortype", true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("valuedate", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("crehqcode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("contractcurr", true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("opercode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("floatrate", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("anninrate", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("spapfeboindex", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtyperema", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("filler1", true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("filler2", true);
				document.getElementById("sysMsgGroup").style.display="none";
			}
			if (op == "delete") {
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("exdebtcode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtype",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtorcode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("contractcurr",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("contractamount",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("valuedate",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("maturity",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("floatrate",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("anninrate",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("inprterm",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("spapfeboindex",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("remark",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("limitType",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditorcode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditorname",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditornamen",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditortype",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("crehqcode",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("opercode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtyperema", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("changeno", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("chdate", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("buscode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("accoamount", true);
				document.getElementById("loadFeiPerSave").style.display="none";
			}
			if (op == "modify") {
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("changeno",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("exdebtcode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("exdebtcode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtype", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtorcode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditorcode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditorname", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditornamen", true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("limitType", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditortype", true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("valuedate", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("crehqcode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("contractcurr", true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("opercode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("floatrate", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("anninrate", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("spapfeboindex", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtyperema", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("filler1", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("actiondesc",true);
				document.getElementById("loadFeiPerSave").style.display="none";
			}
			if (op == "detail"){
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("exdebtcode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtype",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtorcode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("contractcurr",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("contractamount",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("valuedate",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("maturity",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("floatrate",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("anninrate",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("inprterm",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("spapfeboindex",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("remark",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("actiondesc",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("limitType",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditorcode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditorname",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditornamen",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("creditortype",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("crehqcode",true);
//				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("opercode",true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("debtyperema", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("changeno", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("chdate", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("buscode", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("accoamount", true);
				bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("filler2", true);
				//保存按钮隐藏
				document.getElementById("btSave").style.display="none";
				document.getElementById("loadFeiPerSave").style.display="none";
			}
			bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("actiontype",true);
			bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("recStatus",true);
			bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("approveStatus",true);
			bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("repStatus",true);
			bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("crtTm",true);
			bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("lstUpdTm",true);
			bopForDebtFeiPerSaveOver_dataset.setFieldReadOnly("approveResult",true);

			//TODO 判断审核详细和回执详细
			var repStatus = bopForDebtFeiPerSaveOver_dataset.getValue("repStatus");
			if (repStatus != "02") {
				document.getElementById("repHerf").href="#";
				document.getElementById("repHerf").style.color="#999999";
			}
		}

		function btSave_onClickCheck(){
			if (op == "new") {
				var exdebtcode = bopForDebtFeiPerSaveOver_dataset.getValue("exdebtcode");
				if (exdebtcode.length == 0) {
					alert("请选择外债编号！");
					return false;
				}
				bopForDebtFeiPerSaveOver_dataset.setParameter("op",op);
			}
			if (op == "modify") {
				if (!bopForDebtFeiPerSaveOver_dataset.modified) {
					alert("请先修改后再保存！");
					return false;
				}
				bopForDebtFeiPerSaveOver_dataset.setParameter("op",op);
			}
			if (op == "delete") {
				var actiondesc = bopForDebtFeiPerSaveOver_dataset.getValue("actiondesc");
				if (actiondesc.length == 0) {
					alert("请填写删除原因！");
					return false;
				}
				bopForDebtFeiPerSaveOver_dataset.setParameter("op", op);
			}
		}

		function doRepDet(){
			var id = bopForDebtFeiPerSaveOver_dataset.getValue("id");
			var appType = bopForDebtFeiPerSaveOver_dataset.getValue("appType");
			var currentfile = bopForDebtFeiPerSaveOver_dataset.getValue("currentfile");
			var busiCode = bopForDebtFeiPerSaveOver_dataset.getValue("exdebtcode");
			showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
		}

		function loadFeiPerSave(){
			showPickup("非居民个人存款签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopForDebtFeiPerSaveLoadPage.ftl");
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