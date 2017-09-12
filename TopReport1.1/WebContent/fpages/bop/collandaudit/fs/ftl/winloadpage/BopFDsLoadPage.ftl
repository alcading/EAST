<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="选择">
	<@CommonQueryMacro.CommonQuery id="BopFDsLoadPage" init="false" submitMode="selected" navigate="false" >
		<table align="left">
			<tr>
				<td>
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
				</td>
		    </tr>
		    <tr>
		    	<td>
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[80],custcod,oppuser,txccy,txamt,exrate,lcyamt,lcyacc,fcyamt,fcyacc,othamt,othacc,method,buscode,actuccy,actuamt,outchargeccy,outchargeamt,lcbgno,issdate,tenor" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		    <tr>
				<td align="left">
					<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id= "btConfirmBack"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	
	function initCallGetter_post() {
		<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
		BopFDsLoadPage_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		BopFDsLoadPage_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
	}
	
	var type = "${RequestParameters["type"]?default('')}";
	
	var localDs = BopFDsLoadPage_dataset;
	
	function datatable1_onDbClick(table,record) {
		btSelect(record);
	}
	
	function btConfirm_onClick(button) {
		btSelect(localDs);
	}
	
	function btSelect(localDs) {
		var ds = null;
		
		ds = window.parent.BopSDsCollection_dataset;
		if(ds.length == 0 ) {
			ds.insertRecord("end");
		}
		setBasicValueToParent(localDs,ds);

	}
	/*设置基础信息*/
	function setBasicValueToParent(localDs,ds) {
		ds.setValue("filler1",localDs.getValue("id"));
		ds.setValue("rptno",localDs.getValue("rptno"));
		ds.setValue("oppuser",localDs.getValue("oppuser"));
		ds.setValue2("custype",localDs.getValue("custype"));
		ds.setValue("lcyacc",localDs.getValue("lcyacc"));
		ds.setValue("idcode",localDs.getValue("idcode"));
		ds.setValue("lcyamt",localDs.getValue("lcyamt"));
		ds.setValue("custcod",localDs.getValue("custcod"));
		ds.setValue("exrate",localDs.getValue("exrate"));
		ds.setValue("custnm",localDs.getValue("custnm"));
		ds.setValue("fcyacc",localDs.getValue("fcyacc"));
		ds.setValue2("txccy",localDs.getValue("txccy"));
		ds.setValue2("txccyName",localDs.getValue("txccyName"));
		ds.setValue("fcyamt",localDs.getValue("fcyamt"));
		ds.setValue("txamt",localDs.getValue("txamt"));
		ds.setValue("othacc",localDs.getValue("othacc"));
		ds.setValue("buscode",localDs.getValue("buscode"));
		ds.setValue("othamt",localDs.getValue("othamt"));
		ds.setValue2("actuccy",localDs.getValue("actuccy"));
		ds.setValue2("actuccyName",localDs.getValue("actuccyName"));
		ds.setValue("actuamt",localDs.getValue("actuamt"));
		ds.setValue2("outchargeccy",localDs.getValue("outchargeccy"));
		ds.setValue2("outchargeccyName",localDs.getValue("outchargeccyName"));
		ds.setValue("outchargeamt",localDs.getValue("outchargeamt"));
		ds.setValue("method",localDs.getValue("method"));
		ds.setValue("lcbgno",localDs.getValue("lcbgno"));
		ds.setValue("tenor",localDs.getValue("tenor"));
		ds.setValue("issdate",localDs.getValue("issdate"));
		closeWin();
	}
	function btConfirmBack_onClick(button) {
		closeWin();
	}

</script>
</@CommonQueryMacro.page>