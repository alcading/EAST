<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="涉外收入申报单基础信息">
<@CommonQueryMacro.CommonQuery id="bopAGDsLoadPage" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2,buscode,workDate,recStatus,approveStatus,repStatus,actiontype,actiondesc,rptno,custype,idcode,custcod,custnm,oppuser,txccy,txamt,inchargeccy,inchargeamt,outchargeccy,outchargeamt,exrate,lcyamt,lcyacc,fcyamt,fcyacc,othamt,othacc,method" hasFrame="true" width="900" height="260" readonly="true"/>
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
			bopAGDsLoadPage_interface_dataset.setValue("qworkDateStart", currentDate);
			bopAGDsLoadPage_interface_dataset.setValue("qworkDateEnd", currentDate);
		}
		
		var localDs = bopAGDsLoadPage_dataset;
		function datatable1_onDbClick(table, record) {	   
			btSelect(record);
		}
		
		function btConfirm_onClick(button) {
			btSelect(localDs);
		}

		function btSelect(localDs) {
			
			var ds = window.parent.bopGDsRecordInfo_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			
			ds.setValue("rptno", localDs.getValue("rptno"));
			ds.setValue2("custype", localDs.getValue("custype"));
			ds.setValue("idcode", localDs.getValue("idcode"));
			ds.setValue("custcod", localDs.getValue("custcod"));
			ds.setValue("custnm", localDs.getValue("custnm"));
			ds.setValue("oppuser", localDs.getValue("oppuser"));
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
			ds.setValue2("outchargeccy", localDs.getValue("outchargeccy"));
			ds.setValue2("outchargeccyName", localDs.getValue("outchargeccyName"));
			ds.setValue("outchargeamt", localDs.getValue("outchargeamt"));
			ds.setValue2("inchargeccy", localDs.getValue("inchargeccy"));
			ds.setValue2("inchargeccyName", localDs.getValue("inchargeccyName"));
			ds.setValue("inchargeamt", localDs.getValue("inchargeamt"));
			ds.setValue("currentfile", localDs.getValue("currentfile"));
			ds.setValue("filler1", localDs.getValue("id"));
			closeWin();
		}

		function btConfirmBack_onClick(button){
			closeWin();
		}
	</script>
</@CommonQueryMacro.page>