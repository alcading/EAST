<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="银团贷款签约信息">
<table width="90%" align="left">
	<tr>
		<td width="75%" valign="top">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanChange" init="true" submitMode="all" navigate="false">
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td align="center" nowrap class="labeltd" width="25%"> 外债编号 </td>
									<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="exdebtcode"/>
										<input id="loadYinTuan" extra="button" style='width=25px;height=17px;' onclick="loadYinTuan();" type='button' value='...'/></td>
									<td align="center" nowrap class="labeltd" width="25%"> 债务类型 </td>
									<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="debtype"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd"> 债务人代码 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="debtorcode"/></td>
									<td align="center" nowrap class="labeltd"> 签约币种 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="contractcurr"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd"> 签约金额 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="contractamount"/></td>
									<td align="center" nowrap class="labeltd"> 起息日 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="valuedate"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd"> 到期日 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="maturity"/></td>
									<td align="center" nowrap class="labeltd"> 是否浮动利率 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="floatrate"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd"> 年化利率值 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="anninrate"/></td>
									<td align="center" nowrap class="labeltd"> 是否有利息本金化条款 </td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="inprterm"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd"> 是否经外汇局特批不需占用指标 </td>
									<td class="datatd" colspan="3"><@CommonQueryMacro.SingleField fId="spapfeboindex"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd"> 备注 </td>
									<td colspan="3" class="datatd"><@CommonQueryMacro.SingleField fId="debtyperema"/></td>
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
								<td align="center" nowrap class="labeltd" width="25%"> 银行业务参号 </td>
								<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="buscode"/></td>
								<td align="center" nowrap class="labeltd" width="25%"> 变动编号 </td>
								<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="changeno"/></td>
							</tr>
							<tr>
								<td  align="center" nowrap class="labeltd"> 变动类型 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="changtype"/></td>
								<td align="center" nowrap class="labeltd"> 变动日期 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="chdate"/></td>
							</tr>
							<tr>
								<td  align="center" nowrap class="labeltd"> 变动币种 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="chcurrency"/></td>
								<td align="center" nowrap class="labeltd"> 变动金额 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="chamount"/></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd"> 公允价值 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="fairvalue"/></td>
								<td align="center" nowrap class="labeltd"> 业务流水号 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd"> 备注 </td>
								<td class="datatd" colspan="3" width="75%"><@CommonQueryMacro.SingleField fId="remark"/></td>
							</tr>
						</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
		  		<tr>
		  			<td>
		  				<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
		  			</td>
		  		</tr>
		  	</table>
	  	</td>
	  	<td width="8px"></td>
	  	<td width="25%" valign="top" id="sysMsgGroup">
				<@CommonQueryMacro.GroupBox id="guoup3" label="系统信息" expand="true">
		            <table frame=void class="grouptable" width="100%">
						<tr>
							<td align="center" nowrap class="labeltd" width="25%">操作类型</td>
							<td nowrap class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="actiontype" /></td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd" width="25%">记录状态</td>
							<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="recStatus" /></td>
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
							<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a></td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd">创建时间</td>
							<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="crtTm" /></td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd">最后更新时间</td>
							<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm" /></td>
						</tr>
					</table>
				</@CommonQueryMacro.GroupBox>
				<@CommonQueryMacro.GroupBox id="guoup4" label="删除原因" expand="true">
					<table frame=void class="grouptable" width="100%">
						<tr>
							<td align="center" nowrap class="labeltd" width="25%">删除原因</td>
							<td class="datatd" width="75%"><@CommonQueryMacro.SingleField fId="actiondesc" /></td>
						</tr>
					</table>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>

<script language="JavaScript">

	function changtype_DropDown_beforeOpen(dropDown){
		DataDicTreeSelectCor_DropDownDataset.setParameter("headDataTypeNo","31");
	}

	var op = "${op}";

	function initCallGetter_post(){
		if (op == "new"){
			if (bopForDebtYinTuanChange_dataset.length==0) {
				bopForDebtYinTuanChange_dataset.insertRecord("end");
			}
			<#assign v_changeno = statics["com.huateng.report.utils.ReportUtils"].getTempStr(null,4)>
			bopForDebtYinTuanChange_dataset.setValue("changeno", "${v_changeno}");
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("changeno",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("exdebtcode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtype",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtorcode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("contractcurr",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("contractamount",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("valuedate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("maturity",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("floatrate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("anninrate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("inprterm",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("spapfeboindex",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtyperema",true);
			document.getElementById("sysMsgGroup").style.display="none";
		}
		if (op == "delete") {
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("exdebtcode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtype",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtorcode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("contractcurr",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("contractamount",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("valuedate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("maturity",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("floatrate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("anninrate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("inprterm",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("spapfeboindex",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("remark",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtyperema",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("buscode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("changeno",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("changtype",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("chdate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("chcurrency",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("chamount",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("fairvalue",true);
			document.getElementById("loadYinTuan").style.display="none";
		}
		if (op == "modify") {
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("changeno",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("exdebtcode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtype",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtorcode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("contractcurr",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("contractamount",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("valuedate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("maturity",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("floatrate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("anninrate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("inprterm",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("spapfeboindex",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtyperema",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("actiondesc",true);

			bopForDebtYinTuanChange_dataset.setFieldReadOnly("buscode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("changeno",true);
			document.getElementById("loadYinTuan").style.display="none";
		}
		if (op == "detail"){
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("exdebtcode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtype",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtorcode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("contractcurr",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("contractamount",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("valuedate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("maturity",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("floatrate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("anninrate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("inprterm",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("spapfeboindex",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("remark",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("actiondesc",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("debtyperema",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("buscode",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("changeno",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("changtype",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("chdate",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("chcurrency",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("chamount",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("fairvalue",true);
			bopForDebtYinTuanChange_dataset.setFieldReadOnly("filler2",true);
			//保存按钮隐藏
			document.getElementById("btSave").style.display="none";
			document.getElementById("loadYinTuan").style.display="none";
		}
		bopForDebtYinTuanChange_dataset.setFieldReadOnly("actiontype",true);
		bopForDebtYinTuanChange_dataset.setFieldReadOnly("recStatus",true);
		bopForDebtYinTuanChange_dataset.setFieldReadOnly("approveStatus",true);
		bopForDebtYinTuanChange_dataset.setFieldReadOnly("repStatus",true);
		bopForDebtYinTuanChange_dataset.setFieldReadOnly("crtTm",true);
		bopForDebtYinTuanChange_dataset.setFieldReadOnly("lstUpdTm",true);
		bopForDebtYinTuanChange_dataset.setFieldReadOnly("approveResult",true);

		//TODO 判断审核详细和回执详细
		var repStatus = bopForDebtYinTuanChange_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
	}

	function btSave_onClickCheck(){
		if (op == "new") {
			var exdebtcode = bopForDebtYinTuanChange_dataset.getValue("exdebtcode");
			if (exdebtcode.length == 0) {
				alert("请选择外债编号！");
				return false;
			}
			bopForDebtYinTuanChange_dataset.setParameter("op",op);
		}
		if (op == "modify") {
			if (!bopForDebtYinTuanChange_dataset.modified) {
				alert("请先修改后再保存！");
				return false;
			}
			bopForDebtYinTuanChange_dataset.setParameter("op",op);
		}
		if (op == "delete") {
			var actiondesc = bopForDebtYinTuanChange_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("请填写删除原因！");
				return false;
			}
			bopForDebtYinTuanChange_dataset.setParameter("op", op);
		}
	}

	function doRepDet(){
		var id = bopForDebtYinTuanChange_dataset.getValue("id");
		var appType = bopForDebtYinTuanChange_dataset.getValue("appType");
		var currentfile = bopForDebtYinTuanChange_dataset.getValue("currentfile");
		var busiCode = bopForDebtYinTuanChange_dataset.getValue("exdebtcode");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
	}

	function loadYinTuan(){
		showPickup("银团贷款签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopForDebtYinTuanLoadPage.ftl");
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