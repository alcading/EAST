<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="" >
    <link rel="stylesheet" type="text/css" href="${contextPath}/templets/updata/uploadify.css">  
   	<script language="javascript" src="${contextPath}/templets/easyui/jquery-1.7.2.min.js"></script>    
    <script type="text/javascript" src="${contextPath}/templets/updata/jquery.uploadify-3.1.min.js"></script>   
    <script type="text/javascript" src="${contextPath}/templets/updata/initUploadify.js"></script>  
<@CommonQueryMacro.CommonQueryTab id="UpImportData" navigate="false" currentTab="updata">  
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="UpData" init="true" submitMode="current" navigate="false">
<table width="800px">
  <tr>
		<td colspan="2">
			<@CommonQueryMacro.Interface id="interface" label="请选择日期" />
		</td>
	</tr>
  <tr>
    <td colspan="2">
		<input type="file" name="uploadify" id="uploadify" /><div style="float:right"><input type="checkbox" name="is" id="isUp"/>是否允许重复上传</div>
	</td>
  </tr>
  <tr>
    <td>
    <@CommonQueryMacro.DataTable id="uptable" fieldStr="fileName[100],isHave[70],progress[310]"  width="100%" hasFrame="true" height="300" readonly="true"/>
    </td>
  </tr>
</table>	
</@CommonQueryMacro.CommonQuery>
</td></tr></table>
</@CommonQueryMacro.CommonQueryTab>
<script type="text/javascript">
	$(document).ready(function() {	
	       var swf='${contextPath}/templets/updata/uploadify.swf';
	       var uploader='${contextPath}/scripts/uploadify?someKey="a"';	  
		   initUpLoadify(getDatasetByID('UpData_dataset'),swf,uploader);
     });
     
    function uptable_answer_onRefresh(cell,value,record){
              if(record){
                   var id=record[1].split('.')[0]+record[1].split('.')[1]+'answer';
                   cell.innerHTML='<span id="'+id+'" ></span>';
              }
             }
	function UpData_dataset_flushDataPre(dataset) {
		var chbox = $(":checkbox");
		//reset [重复导入] checkbox
		for(var i=0;i<chbox.length;i++)
		{
			chbox[i].checked=false;
		}
	}
    function uptable_ishave_onRefresh(cell,value,record){
              if(record){
                   var id=record[1].split('.')[0]+record[1].split('.')[1]+'ishave';   
                   if(value=='true'){
                 //   cell.innerHTML='<input id="'+id+'"  type="checkbox" checked></input>';
                      cell.innerHTML='<span id="'+id+'">已存在</span><input id="'+id+'have"  type="hidden" value="'+value+'"/>';
                   }else{
                //    cell.innerHTML='<input id="'+id+'"  type="checkbox" ></input>';
                      cell.innerHTML='<span id="'+id+'">不存在</span><input id="'+id+'have"  type="hidden" value="'+value+'"/>';
                   }                     
              }
             }
             
    function uptable_upstatus_onRefresh(cell,value,record){
              if(record){
                   var id=record[1].split('.')[0]+record[1].split('.')[1]+'upstatus';
                   cell.innerHTML='<span id="'+id+'" >'+"未上传"+'</span>';
              }
             }
     
    function uptable_progress_onRefresh(cell,value,record){
              if(record){
                   var id=record[1].split('.')[0]+record[1].split('.')[1]+'progress';   
                   cell.innerHTML='<div id="'+ id+ '" class="uploadify-queue-item" style="display:none;"><div style="float:left" class="uploadify-progress">'+
                     '<div class="uploadify-progress-bar"></div></div><div style="float:right"><span id="'+id+'span"></span></div></div>';   
                       
                  
              }
             }
             
   
</script>
</@CommonQueryMacro.page>