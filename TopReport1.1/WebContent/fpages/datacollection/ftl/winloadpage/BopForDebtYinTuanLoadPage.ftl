<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanLoadPage" init="false" submitMode="all" navigate="false" >
	<table align="left">
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
			</td>
		</tr>

		<tr>
			<td colspan="2">
				<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
			</td>
		</tr>

		<tr>
			<td colspan="2">
				<@CommonQueryMacro.DataTable id ="bopForDebtYinTuanLoadPage1" hasFrame="true" fieldStr="exdebtcode,debtorcode,debtype,valuedate[85],contractcurr[100],contractamount,maturity[85],floatrate,anninrate,inprterm,spapfeboindex" readonly="true" hasFrame="true" width="900" height="260"/>
			</td>
    	</tr>

		<tr colspan="2">
			<td>
				<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
				<@CommonQueryMacro.Button id= "btConfirmBack"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

	function initCallGetter_post(){
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		bopForDebtYinTuanLoadPage_interface_dataset.setValue("qworkDate", currentDate);
	}
	
	function datatable1_onDbClick(table,record) {
		copy2Value();
	}

	function btConfirm_onClick(button){
		copy2Value();
	}
	function bopForDebtYinTuanLoadPage1_onDbClick(table,record) {
		copy2Value();
	}
	function copy2Value(){
		var ds = window.parent.bopForDebtYinTuanChange_dataset;
		if (ds.length==0){
			ds.insertRecord("end");
		}
		ds.setValue("exdebtcode", bopForDebtYinTuanLoadPage_dataset.getValue("exdebtcode"));
		ds.setValue2("debtype", bopForDebtYinTuanLoadPage_dataset.getValue("debtype"));
		ds.setValue2("debtypeName", bopForDebtYinTuanLoadPage_dataset.getValue("debtypeName"));
		ds.setValue("debtorcode", bopForDebtYinTuanLoadPage_dataset.getValue("debtorcode"));
		ds.setValue2("contractcurr", bopForDebtYinTuanLoadPage_dataset.getValue("contractcurr"));
		ds.setValue2("contractcurrName", bopForDebtYinTuanLoadPage_dataset.getValue("contractcurrName"));
		ds.setValue("contractamount", bopForDebtYinTuanLoadPage_dataset.getValue("contractamount"));
		ds.setValue("valuedate", bopForDebtYinTuanLoadPage_dataset.getValue("valuedate"));
		ds.setValue("maturity", bopForDebtYinTuanLoadPage_dataset.getValue("maturity"));
		ds.setValue("floatrate", bopForDebtYinTuanLoadPage_dataset.getValue("floatrate"));
		ds.setValue("anninrate", bopForDebtYinTuanLoadPage_dataset.getValue("anninrate"));
		ds.setValue("inprterm", bopForDebtYinTuanLoadPage_dataset.getValue("inprterm"));
		ds.setValue("spapfeboindex", bopForDebtYinTuanLoadPage_dataset.getValue("spapfeboindex"));
		ds.setValue("debtyperema", bopForDebtYinTuanLoadPage_dataset.getValue("remark"));
		ds.setValue("filler1", bopForDebtYinTuanLoadPage_dataset.getValue("id"));
		closeWin();
	}

	function btConfirmBack_onClick(button){
		closeWin();
	}

</script>
</@CommonQueryMacro.page>