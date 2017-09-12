<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="银团贷款签约信息">
<table width="90%" align="left">
	<tr>
		<td width="75%" valign="top">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td>
					<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanSigned" init="true" submitMode="all" navigate="false">
						<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td align="center" nowrap class="labeltd" width="25%"> 外债编号 </td>
									<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="exdebtcode"/></td>
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
									<td class="datatd"><@CommonQueryMacro.SingleField fId="spapfeboindex"/></td>
									<td align="center" nowrap class="labeltd"> 业务流水号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd"> 备注 </td>
									<td colspan="3" class="datatd"><@CommonQueryMacro.SingleField fId="remark"/></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</@CommonQueryMacro.CommonQuery>
					</td>
				</tr>
				<tr>
					<td>
					<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanProject" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
						<@CommonQueryMacro.GroupBox id="guoup2" label="项目信息" expand="true">
							<table frame=void width="100%">
								<tr>
									<td id="proMenu" align="right">
										<@CommonQueryMacro.Button id= "btProNew"/>&nbsp;&nbsp;
										<@CommonQueryMacro.Button id= "btProDel"/>&nbsp;&nbsp;
									</td>
								</tr>
								<tr>
									<td>
										<@CommonQueryMacro.DataTable id="datatable1" fieldStr="projectname" width="100%" hasFrame="true" height="200px" readonly="false"/>
									</td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</@CommonQueryMacro.CommonQuery>
					</td>
				</tr>
				<tr>
					<td>
		  			<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanCreditor" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
						<@CommonQueryMacro.GroupBox id="guoup3" label="债权人信息" expand="true">
							<table frame=void width="100%">
								<tr>
									<td id="creMenu" align="right">
										<@CommonQueryMacro.Button id= "btCreNew"/>&nbsp;&nbsp;
										<@CommonQueryMacro.Button id= "btCreDel"/>&nbsp;&nbsp;
									</td>
								</tr>
								<tr>
									<td>
									<@CommonQueryMacro.DataTable id="datatable2" fieldStr="creditorcode,creditorname,creditornamen,creditorca,creditortype,crehqcode,opercode" width="100%" hasFrame="true" height="200px" readonly="false"/>
									</td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
			  		</@CommonQueryMacro.CommonQuery>
		  			</td>
		  		</tr>
		  		<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanSigned" mode="1" navigate="false">
		  		<tr>
		  			<td>
		  				<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
		  			</td>
		  		</tr>
		  	</table>
	  	</td>
	  	<td width="8px"></td>
	  	<td width="25%" valign="top">
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

	function debtype_DropDown_beforeOpen(dropDown){
		DataDicTreeSelect_DropDownDataset.setParameter("headDataTypeNo","24");
	}

	function creditortype_DropDown_beforeOpen(dropDown){
		DataDicTreeSelectCor_DropDownDataset.setParameter("headDataTypeNo","23");
	}

	var op = "${op}";

	function initCallGetter_post(){
		if (op == "delete") {
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("exdebtcode",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("debtype",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("debtorcode",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("contractcurr",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("contractamount",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("valuedate",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("maturity",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("floatrate",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("anninrate",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("inprterm",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("spapfeboindex",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("remark",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("filler2",true);

			bopForDebtYinTuanProject_dataset.setFieldReadOnly("projectname",true);

			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditorcode",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditorname",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditornamen",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditorca",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditortype",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("crehqcode",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("opercode",true);

			//保存按钮隐藏
			document.getElementById("proMenu").style.display="none";
			document.getElementById("creMenu").style.display="none";
		}
		if (op == "modify") {
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("exdebtcode",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("debtype",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("debtorcode",false);
			//bopForDebtYinTuanSigned_dataset.setFieldReadOnly("contractcurr",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("contractcurr",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("contractamount",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("valuedate",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("maturity",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("floatrate",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("anninrate",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("inprterm",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("spapfeboindex",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("remark",false);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("actiondesc",true);
		}
		if (op == "detail"){
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("exdebtcode",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("debtype",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("debtorcode",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("contractcurr",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("contractamount",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("valuedate",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("maturity",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("floatrate",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("anninrate",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("inprterm",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("spapfeboindex",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("remark",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("filler2",true);
			bopForDebtYinTuanSigned_dataset.setFieldReadOnly("actiondesc",true);

			bopForDebtYinTuanProject_dataset.setFieldReadOnly("projectname",true);

			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditorcode",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditorname",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditornamen",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditorca",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("creditortype",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("crehqcode",true);
			bopForDebtYinTuanCreditor_dataset.setFieldReadOnly("opercode",true);
			//保存按钮隐藏
			document.getElementById("proMenu").style.display="none";
			document.getElementById("creMenu").style.display="none";
			document.getElementById("btSave").style.display="none";
		}
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("actiontype",true);
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("recStatus",true);
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("approveStatus",true);
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("repStatus",true);
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("crtTm",true);
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("lstUpdTm",true);
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("approveResult",true);

		//TODO 判断审核详细和回执详细
		var repStatus = bopForDebtYinTuanSigned_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
	}

	function btSave_onClickCheck(){
		if (op == "modify") {
			if (bopForDebtYinTuanCreditor_dataset.length == 0) {
				alert("请填写债权人！");
				return false;
			}
			var record = bopForDebtYinTuanCreditor_dataset.getFirstRecord();
			var v_contractamount = bopForDebtYinTuanSigned_dataset.getValue("contractamount");
			v_contractamount = v_contractamount - 0;
			var  total_creditorca = 0;
			while(record){
				var v_creditorname = record.getValue("creditorname");
				var v_creditornamen = record.getValue("creditornamen");
				var v_creditorca = record.getValue("creditorca") - 0;
				total_creditorca = total_creditorca + v_creditorca;
				if( v_creditorname == "" && v_creditornamen == "" ){
					alert("每个债权人的中文名称和英文名称必须填一个！");
					return false;
				}
				record=record.getNextRecord();
		   	}
		   	if (total_creditorca != v_contractamount) {
		   		alert("债权人签约金额只和不等于签约金额！");
		   		return false;
		   	}
			if (!bopForDebtYinTuanSigned_dataset.modified && !bopForDebtYinTuanProject_dataset.modified && !bopForDebtYinTuanCreditor_dataset.modified) {
				alert("请先修改后再保存！");
				return false;
			}
			bopForDebtYinTuanSigned_dataset.setParameter("op",op);
		}
		if (op == "delete") {
			var actiondesc = bopForDebtYinTuanSigned_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("请填写删除原因！");
				return false;
			}
			bopForDebtYinTuanSigned_dataset.setParameter("op", op);
		}
	}

	function doRepDet(){
		var id = bopForDebtYinTuanSigned_dataset.getValue("id");
		var appType = bopForDebtYinTuanSigned_dataset.getValue("appType");
		var currentfile = bopForDebtYinTuanSigned_dataset.getValue("currentfile");
		var busiCode = bopForDebtYinTuanSigned_dataset.getValue("exdebtcode");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
	}

	function btAddProject(){
		btProNew.click();
	}

	function btDelProject(){
		btProDel.click();
	}

	function btAddCreditor(){
		btCreNew.click();
	}

	function btDelCreditor(){
		btCreDel.click();
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