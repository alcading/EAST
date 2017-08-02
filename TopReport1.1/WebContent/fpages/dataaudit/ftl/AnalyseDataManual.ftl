<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="数据分析手工执行">
<@CommonQueryMacro.CommonQuery id="analyseDataManual" init="true" submitMode="all" navigate="false">
<table width="800px">
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" label="数据分析手工执行" btnNm="查询" colNm=8/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="datatable1" fieldStr="select[40],tableName"  width="100%" hasFrame="true" height="300" readonly="true"/>
		</td>
	</tr>
	<tr>
		<td>
		</td>
	</tr>
</table>
<span id="button-tools" style="padding-center:10px"><@CommonQueryMacro.Button id= "btAnalyse"/>&nbsp;<span id="message" ></span></span>
</@CommonQueryMacro.CommonQuery>

<script language="javascript"> 
var op = "${RequestParameters["op"]?default('')}"; 
$('#analyseDataManual_interface_dataset_btnSubmit').after($('#button-tools'));
$(function(){
});

//function initCallGetter_post() {
//	btAnalyse.disable(true);
//}

function analyseDataManual_dataset_flushDataPost(dataset) {
	btAnalyse.disable(dataset.length == 0);
	
	var record = dataset.firstUnit;
	while(record) {
		record = record.nextUnit;
	}
	
}

var int;
function btAnalyse_onClickCheck(button) {
	var rec = analyseDataManual_dataset.firstUnit;
	var f = false;
	while(rec) {
		if (rec.getValue('select')) {
			f = true;
			//break;
		}
		rec = rec.nextUnit;
	}
	if(!f) {
		alert('请选择要分析的表名');
		return false;
	}
	//analyseDataManual_dataset.setValue('reImport', reImport.checked);
	btAnalyse.disable(true);
	//funPreHook(_theme_root + "/loading.gif");
	
	//preProgress();
	//int = setInterval(progress, 100);
}
</script>
</@CommonQueryMacro.page>
