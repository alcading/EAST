<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="账户选择">
	<@CommonQueryMacro.CommonQuery id="bopAccDsAccountLoadPage" init="false" submitMode="current" navigate="false">
		<table width="800px">
			<tr>
		  		<td valign="top">
		    		<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
		  		</td>
			</tr>

			<tr>
		  		<td>
		    		<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
		  		</td>
			</tr>

			<tr>
		  		<td>
		     		<@CommonQueryMacro.DataTable id="datatable1" fieldStr="accountno[200],currencyCode[100],accountstat,accountCata,accountType[150],amtype,enCode,enName,fileNumber,limitType,accountLimit" width="100%" hasFrame="true" height="240" readonly="true" />
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
	<script language="javascript">
		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			bopAccDsAccountLoadPage_interface_dataset.setValue("qStartDate", currentDate);
			bopAccDsAccountLoadPage_interface_dataset.setValue("qEndDate", currentDate);
		}
		function datatable1_onDbClick(table,record) {
			copy2Value();
		}
		function btConfirm_onClick(button){
			copy2Value();
		}
		function copy2Value(){
			var ds = window.parent.bopAccDsRecordInOutAdd_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			ds.setValue("accountno", bopAccDsAccountLoadPage_dataset.getValue("accountno"));
			ds.setValue2("amtype", bopAccDsAccountLoadPage_dataset.getValue("amtype"));
			ds.setValue2("currencyCode", bopAccDsAccountLoadPage_dataset.getValue("currencyCode"));
			ds.setValue2("currencyCodeName", bopAccDsAccountLoadPage_dataset.getValue("currencyCodeName"));
			ds.setValue("enCode", bopAccDsAccountLoadPage_dataset.getValue("enCode"));
			ds.setValue2("accountType", bopAccDsAccountLoadPage_dataset.getValue("accountType"));
			ds.setValue("enName", bopAccDsAccountLoadPage_dataset.getValue("enName"));
			ds.setValue2("accountCata", bopAccDsAccountLoadPage_dataset.getValue("accountCata"));
			ds.setValue("fileNumber", bopAccDsAccountLoadPage_dataset.getValue("fileNumber"));
			ds.setValue2("limitType", bopAccDsAccountLoadPage_dataset.getValue("limitType"));
			if(!isNaN(bopAccDsAccountLoadPage_dataset.getValue("accountLimit"))){
				ds.setValue("accountLimit", bopAccDsAccountLoadPage_dataset.getValue("accountLimit"));
			} else {
				ds.setValue("accountLimit", "");
			}
			ds.setValue("filler1", bopAccDsAccountLoadPage_dataset.getValue("id"));
			closeWin();
		}
		function btConfirmBack_onClick(button){
			closeWin();
		}
	</script>
</@CommonQueryMacro.page>