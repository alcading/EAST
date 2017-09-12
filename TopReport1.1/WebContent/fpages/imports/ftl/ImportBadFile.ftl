<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="定时任务重新导入">
<@CommonQueryMacro.CommonQuery id="ImportBadFile" init="false" submitMode="all" navigate="false">
<table width="800px">
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" label="定时任务错误文件重新导入" btnNm="确定" colNm=8/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="datatable1" fieldStr="select[40],fileNameFull,fileName"  width="100%" hasFrame="true" height="300" readonly="true"/>
		</td>
	</tr>
	<tr>
		<td>
			<span id="message" >注意：如果传票文件出错，切勿重新手工导入!请联系科技人员。</span>
		</td>
	</tr>
</table>
<span id="button-tools" style="padding-center:10px"><@CommonQueryMacro.Button id= "btImport"/>&nbsp;<span id="message" >先点击[确定],检查文件列表</span></span>
</@CommonQueryMacro.CommonQuery>

<script language="javascript"> 
var op = "${RequestParameters["op"]?default('')}"; 
$('#ImportBadFile_interface_dataset_btnSubmit').after($('#button-tools'));
$(function(){
});

function initCallGetter_post() {
	btImport.disable(true);
}

function ImportBadFile_dataset_flushDataPost(dataset) {
	btImport.disable(dataset.length == 0);
	
	var record = dataset.firstUnit;
	while(record) {
		record = record.nextUnit;
	}
	
}

var int;
function btImport_onClickCheck(button) {
	var rec = ImportBadFile_dataset.firstUnit;
	var f = false;
	while(rec) {
		if (rec.getValue('select')) {
			f = true;
			//break;
		}
		rec = rec.nextUnit;
	}
	if(!f) {
		alert('请选择要导入的文件');
		return false;
	}
	//ImportBadFile_dataset.setValue('reImport', reImport.checked);
	btImport.disable(true);
	//funPreHook(_theme_root + "/loading.gif");
	
	//preProgress();
	//int = setInterval(progress, 100);
}
</script>
</@CommonQueryMacro.page>
