<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="银团贷款签约信息">
<table width="800px" align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanSigned" init="true" submitMode="current" navigate="false">
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

							<td align="center" nowrap class="labeltd"> 业务流水号 </td>
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
							<td align="right">
								<@CommonQueryMacro.Button id= "btProNew"/>&nbsp;&nbsp;
								<@CommonQueryMacro.Button id= "btProDel"/>&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td>
							<@CommonQueryMacro.DataTable id="datatable1" fieldStr="projectname[400]" width="100%" hasFrame="true" height="200px" readonly="false"/>
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
							<td align="right">
								<@CommonQueryMacro.Button id= "btCreNew"/>&nbsp;&nbsp;
								<@CommonQueryMacro.Button id= "btCreDel"/>&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td>
							<@CommonQueryMacro.DataTable id="datatable1" fieldStr="creditorcode,creditorname,creditornamen,creditorca,creditortype,crehqcode,opercode" width="100%" hasFrame="true" height="200px" readonly="false"/>
							</td>
						</tr>
					</table>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanSigned" mode="1" navigate="false">
				<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
				<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="JavaScript">

	function initCallGetter_post(){
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("exdebtcode",true);
		bopForDebtYinTuanSigned_dataset.setFieldReadOnly("debtorcode",true);
	}

	function debtype_DropDown_beforeOpen(dropDown){
		DataDicTreeSelect_DropDownDataset.setParameter("headDataTypeNo","24");
	}

	function creditortype_DropDown_beforeOpen(dropDown){
		DataDicTreeSelectCor_DropDownDataset.setParameter("headDataTypeNo","23");
	}

	function btSave_onClickCheck(){

		var anninrate = bopForDebtYinTuanSigned_dataset.getValue("anninrate");//年化利率值
		if (!isNaN(anninrate) && parseFloat(anninrate) >= 1) {
			alert("[年化利率值]必须为小数");
			return false;
		}

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
		bopForDebtYinTuanSigned_dataset.setParameter("op", "new");
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