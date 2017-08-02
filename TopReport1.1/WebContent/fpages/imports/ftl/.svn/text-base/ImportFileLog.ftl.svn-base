<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="数据导入日志">
<table align="left" width="100%">
<tr><td>
<@CommonQueryMacro.CommonQuery id="ImportFileLog" init="false" submitMode="current" navigate="false">
<table width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" label="日志查询"  colNm=4/>
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btDetail,-,btMod,-,btImport" fieldStr="fileName,tableName,workDate,importStatus,totalRows,correctRows,errorRows,filterRows,beginTime,endTime,ip,errorMessage,modFlg"  width="100%" hasFrame="true" height="300" readonly="true"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr>
<tr><td>
<#include "/fpages/imports/ftl/ImportFileLogDtl.ftl">
<#include "/fpages/imports/ftl/ImportFileMod.ftl">
</td></tr></table>
<script language="javascript"> 
function initCallGetter_post() {
	btDetail.disable(true);
	btMod.disable(true);
	btImport.disable(true);
}
function ImportFileLog_dataset_flushDataPost(dataset) {
	btDetail.disable(dataset.length != 0);
	btMod.disable(dataset.length != 0);
	btImport.disable(dataset.length != 0);
}
function ImportFileLog_dataset_afterScroll(dataset) {
	btDetail.disable(dataset.length == 0 ||dataset.getValue('modFlg')!= '' || dataset.getValue('errFilePath') == '');
	btMod.disable(dataset.length == 0||dataset.getValue('modFlg')!= '' || dataset.getValue('errFilePath') == '');
	btImport.disable(dataset.length == 0||dataset.getValue('modFlg')!='1' || dataset.getValue('errFilePath') == '');
}
function btDetail_onClick(button){
	ImportFileLogDtl_dataset.setParameter('logid',ImportFileLog_dataset.getValue("id"));
	subwindow_detailFW.show();
	ImportFileLogDtl_dataset.flushData(1);
}
function btMod_onClick(button){
	ImportFileMod_dataset.setParameter('logid',ImportFileLog_dataset.getValue("id"));
	ImportFileMod_dataset.flushData(0);
	subwindow_detailFW2.show();
}

function btSave_postSubmit(button) {
	subwindow_detailFW2.hide();
	ImportFileLog_dataset.flushData(ImportFileLog_dataset.pageIndex);
}
function btImport_postSubmit(button) {
	alert('导入成功');
	ImportFileLog_dataset.flushData(ImportFileLog_dataset.pageIndex);
}
</script>
</@CommonQueryMacro.page>
