<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="选择">
	<@CommonQueryMacro.CommonQuery id="JshDfDsLoadPage" init="false" submitMode="selected" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[80],custype[120],custcod[80],idcode[100],custnm[80],fcyacc[80],lcyacc[80],oppuser[80],oppbank[250],fcyamt[80],fcyccy[150],exrate[80]" hasFrame="true" width="900" height="260" readonly="true"/>
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
		JshDfDsLoadPage_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		JshDfDsLoadPage_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
	}
	
	var type = "${RequestParameters["type"]?default('')}";
	
	var localDs = JshDfDsLoadPage_dataset;
	
	function datatable1_onDbClick(table,record) {
		btSelect(record);
	}
	
	function btConfirm_onClick(button) {
		btSelect(localDs);
	}
	
	function btSelect(localDs) {
		var ds = null;
		if(type == "manage") {
			ds = window.parent.JshDfDsManageCollInfo_dataset;
			if(ds.length == 0 ) {
				ds.insertRecord("end");
			}
			setBasicValueToParent(localDs,ds);
		}

	}
	/*设置基础信息*/
	function setBasicValueToParent(localDs,parentDs) {
		//设置filler1为记录编号以及其他签约信息字段
		parentDs.setValue("filler1",localDs.getValue("id"));
		parentDs.setValue("rptno",localDs.getValue("rptno"));
		parentDs.setValue("buscode",localDs.getValue("buscode"));
		//下拉框
		parentDs.setValue2("custype",localDs.getValue("custype"));
		parentDs.setValue("custcod",localDs.getValue("custcod"));
		parentDs.setValue("idcode",localDs.getValue("idcode"));
		parentDs.setValue("custnm",localDs.getValue("custnm"));
		parentDs.setValue("fcyacc",localDs.getValue("fcyacc"));
		parentDs.setValue("lcyacc",localDs.getValue("lcyacc"));
		parentDs.setValue("oppuser",localDs.getValue("oppuser"));
		parentDs.setValue("oppbank",localDs.getValue("oppbank"));
		parentDs.setValue("fcyamt",localDs.getValue("fcyamt"));
		//下拉框
		parentDs.setValue2("fcyccy",localDs.getValue("fcyccy"));
		parentDs.setValue("fcyccyName",localDs.getValue("fcyccyName"));
		
		parentDs.setValue("exrate",localDs.getValue("exrate"));
		closeWin();
	}
	function btConfirmBack_onClick(button) {
		closeWin();
	}

</script>
</@CommonQueryMacro.page>