<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="基础信息">
<@CommonQueryMacro.CommonQuery id="BopEQDsCollectionLoadPage" init="false" submitMode="all" navigate="false" >
	<table align="left">
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
			</td>
		</tr>
		<tr>
			<td valign="top">
				<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="9" showArrow="true" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[80],custcod[80],custnm[80],oppuser[80],oppacc[80],txccy[80],txamt[80],exrate[80],lcyamt[80],lcyacc[80],fcyamt[80],fcyacc[80],othamt[80],method[80],buscode[80],actiondesc[120]" hasFrame="true" width="900" height="260" readonly="true"/>
			</td>
    	</tr>
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
				<@CommonQueryMacro.Button id= "btConfirmBack"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	function initCallGetter_post(){
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		BopEQDsCollectionLoadPage_interface_dataset.setValue("qworkDateStart", currentDate);
		BopEQDsCollectionLoadPage_interface_dataset.setValue("qworkDateEnd", currentDate);
	}
	
	var localDs = BopEQDsCollectionLoadPage_dataset;
	function datatable1_onDbClick(table,record) {	   
		btSelect(record);
	}
		
	function btConfirm_onClick(button) {
		btSelect(localDs);
	}
	
	function btSelect(localDs) {
	
		var ds = window.parent.BopQDsCollectionInfo_dataset;
		if (ds.length==0){
			ds.insertRecord("end");
		}
		
		ds.setValue("rptno", localDs.getValue("rptno"));
		ds.setValue2("custype", localDs.getValue("custype"));
		ds.setValue("idcode", localDs.getValue("idcode"));
		ds.setValue("custcod", localDs.getValue("custcod"));
		ds.setValue("custnm", localDs.getValue("custnm"));
		ds.setValue("oppuser", localDs.getValue("oppuser"));
		ds.setValue("oppacc", localDs.getValue("oppacc"));
		ds.setValue2("txccy", localDs.getValue("txccy"));
		ds.setValue2("txccyName", localDs.getValue("txccyName"));
		ds.setValue("txamt", localDs.getValue("txamt"));
		ds.setValue("exrate", localDs.getValue("exrate"));
		ds.setValue("lcyamt", localDs.getValue("lcyamt"));
		ds.setValue("lcyacc", localDs.getValue("lcyacc"));
		ds.setValue("fcyamt", localDs.getValue("fcyamt"));
		ds.setValue("fcyacc", localDs.getValue("fcyacc"));
		ds.setValue("othamt", localDs.getValue("othamt"));
		ds.setValue("othacc", localDs.getValue("othacc"));
		ds.setValue2("method", localDs.getValue("method"));
		ds.setValue("buscode", localDs.getValue("buscode"));
		ds.setValue("currentfile", localDs.getValue("currentfile"));
		ds.setValue("filler1", localDs.getValue("id"));
		closeWin();
	}

	function btConfirmBack_onClick(button){
		closeWin();
	}
</script>
</@CommonQueryMacro.page>