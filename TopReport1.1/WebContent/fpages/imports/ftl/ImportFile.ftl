<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="数据导入">
<@CommonQueryMacro.CommonQueryTab id="UpImportData" navigate="false" currentTab="import">   
<@CommonQueryMacro.CommonQuery id="ImportFile" init="false" submitMode="all" navigate="false">
<table width="800px">
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" label="导入功能实现" btnNm="确定" colNm=8/>
		</td>
	</tr>
	<tr>
		<td align="right">
			<input type="checkbox" id="reImport"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="datatable1" fieldStr="select[40],fileNameFull,tableName,exist,impStatus,progress[300]"  width="100%" hasFrame="true" height="300" readonly="true"/>
		</td>
	</tr>
	<tr>
		<td>
		</td>
	</tr>
</table>
<span id="button-tools" style="padding-left:10px"><@CommonQueryMacro.Button id= "btImport"/>&nbsp;<span id="message" >先点击[确定],检查文件列表</span></span>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="javascript"> 
var op = "${RequestParameters["op"]?default('')}"; 
$('#ImportFile_interface_dataset_btnSubmit').after($('#button-tools'));
$('#editor_qReImport').hide().parent().append($('#reImport'));
$(function(){
});

function onData(event) { 
	var id = event.get("id");
	var progress = event.get("progress");
	var errorMessage = event.get("errorMessage");
	$('#P'+id).css("width", progress);
	$('#S'+id).html(progress);
	if (errorMessage) {
		$('#S'+id).html(errorMessage);
	}
}
function initCallGetter_post() {
	btImport.disable(true);
}
function datatable1_progress_onRefresh(cell,value,record){
  if(record){
       cell.innerHTML="<div style='width:300px;' nowrap><div id='P"+ value+ "' style='float:left;background-color:#0099FF;width:0%;text-align:right;color:red;overflow:hidden'></div><span id='S"+ value+ "'></span></div>";   
  } else {
  	   cell.innerHTML="&nbsp;";
  }	
}
function ImportFile_dataset_flushDataPre(dataset) {
	var chbox = $(":checkbox");
	//reset [重复导入] checkbox
	for(var i=0;i<chbox.length;i++)
	{
		chbox[i].checked=false;
	}
}
function ImportFile_dataset_flushDataPost(dataset) {
	btImport.disable(dataset.length == 0);
	
	if(ImportFile_dataset.getValue('importing')) {
		btImport.disable(true);
		$('#message').html('正在导入中...');
	} 
	var record = dataset.firstUnit;
	while(record) {
		record = record.nextUnit;
	}
	
}

var int;
function btImport_onClickCheck(button) {
	var rec = ImportFile_dataset.firstUnit;
	var f = false;
	while(rec) {
		if (rec.getValue('select')) {
			f = true;
			//break;
		}
		rec.setValue('reImport', reImport.checked);
		rec = rec.nextUnit;
	}
	if(!f) {
		alert('请选择要导入的文件');
		return false;
	}
	//ImportFile_dataset.setValue('reImport', reImport.checked);
	btImport.disable(true);
	funPreHook(_theme_root + "/loading.gif");
	
	preProgress();
	int = setInterval(progress, 100);
}

var prehook;
var posthook;
var errhook;
function getRecordById(id) {
	record = ImportFile_dataset.find(["id"],[id]);
	if (record) {
		ImportFile_dataset.setRecord(record); 
	}
	return ImportFile_dataset;
}
function preProgress() {
	prehook = dwr.engine._preHook;
	posthook = dwr.engine._postHook;
	errhook = dwr.engine._errorHandler;
	DWREngine.setPreHook(function(){});
	DWREngine.setPostHook(function(){});
	DWREngine.setErrorHandler(function(){
		postProgress();
	});
}
function postProgress() {
	clearInterval(int);
	funPostHook();
	DWREngine.setPreHook(prehook);
	DWREngine.setPostHook(posthook);
	DWREngine.setErrorHandler(errhook);
}
function progress() {
	PrivAction.getProgress(
		function(arr){
			for(var i=0;i<arr.length;i++) {
				data = arr[i];
				var p = $('#P' + data.id);
				var s = $('#S' + data.id);
				p.css('width',parseInt(data.progress)*2.5);
				s.html(data.progress);
				if (data.errorMessage) {
					p.css('width','0px');
					s.html("<font color=red>"+data.errorMessage+"</font>");
				}
				if (data.errorMessage) {
					getRecordById(data.id).setValue2('impStatus',0);
				} else {
					getRecordById(data.id).setValue2('impStatus',1);
				}
			}
			for(var i=arr.length-1;i>=0;i--) {
				data = arr[i];
				if (data.stopFlag) {
					postProgress();
					break;
				}
			}
		}
	);
}

</script>
</@CommonQueryMacro.page>
