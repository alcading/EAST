<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="选择">
	<@CommonQueryMacro.CommonQuery id="BopBhnDsLoadPage" init="false" submitMode="selected" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[80],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[100],custype[80],idcode[150],custcod[80],custnm[100],oppuser[100],txccy[150],txamt[100],exrate[100],txamt[100],lcyacc[150],fcyamt[100],fcyacc[150],othamt[100],othacc[150],method[100],buscode[100]" hasFrame="true" width="900" height="260" readonly="true"/>
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
		BopBhnDsLoadPage_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		BopBhnDsLoadPage_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
	
	}
	
	var type = "${RequestParameters["type"]?default('')}";
	
	var localDs = BopBhnDsLoadPage_dataset;
	
	function datatable1_onDbClick(table,record) {
		btSelect(record);
	}
	
	function btConfirm_onClick(button) {
		btSelect(localDs);
	}
	
	function btSelect(localDs) {
		var ds = null;
		if(type == "report") {
			ds = window.parent.BopBhnDsReportCollInfo_dataset;
			if(ds.length == 0 ) {
				ds.insertRecord("end");
			}
			setBasicValueToParent(localDs,ds);
		} else if(type == "manage") {
			ds = window.parent.BopBhnDsManageCollInfo_dataset;
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
		//汇款人下拉框
		parentDs.setValue2("custype",localDs.getValue("custype"));
		parentDs.setValue("idcode",localDs.getValue("idcode"));
		parentDs.setValue("custcod",localDs.getValue("custcod"));
		parentDs.setValue("custnm",localDs.getValue("custnm"));
		parentDs.setValue("oppuser",localDs.getValue("oppuser"));
		//下拉框的值
		parentDs.setValue2("txccy",localDs.getValue("txccy"));
		parentDs.setValue2("txccyName",localDs.getValue("txccyName"));
		parentDs.setValue("txamt",localDs.getValue("txamt"));
		parentDs.setValue("exrate",localDs.getValue("exrate"));
		parentDs.setValue("lcyamt",localDs.getValue("lcyamt"));
		parentDs.setValue("lcyacc",localDs.getValue("lcyacc"));
		parentDs.setValue("fcyamt",localDs.getValue("fcyamt"));
		parentDs.setValue("fcyacc",localDs.getValue("fcyacc"));
		parentDs.setValue("othamt",localDs.getValue("othamt"));
		parentDs.setValue("othacc",localDs.getValue("othacc"));
		//下拉框值
		parentDs.setValue2("method",localDs.getValue("method"));
		parentDs.setValue("buscode",localDs.getValue("buscode"));
		closeWin();
	}
	function btConfirmBack_onClick(button) {
		closeWin();
	}

</script>
</@CommonQueryMacro.page>