<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="账户收支余信息">
<@CommonQueryMacro.CommonQuery id="bopAccDsRecordInOutCollect" init="true" submitMode="all" navigate="false" >
<table width="800">
	<tr>
		<td>
			<@CommonQueryMacro.Group id="group1" label="账户信息" fieldStr="actiontype,accountno,accountstat,amtype,enCode,enName,accountType,accountCata,businessDate,fileNumber,limitType,accountLimit" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.Group id="group2" label="变动信息" fieldStr="dealDate,currencyCode,credit,debit,balance,remark2" colNm=4 />
		</td>
	</tr>
	<tr>
		<td align="left">
			<@CommonQueryMacro.Button id="btSave"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id="btBack"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

	function initCallGetter_post(){
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("actiontype",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("accountno",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("accountstat",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("amtype",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("enCode",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("enName",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("accountType",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("accountCata",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("fileNumber",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("businessDate",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("accountType",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("limitType",true);
		bopAccDsRecordInOutCollect_dataset.setFieldReadOnly("accountLimit",true);
	}
	
	function btBack_onClick(){
		window.history.go(-1);
	}
</script>
</@CommonQueryMacro.page>