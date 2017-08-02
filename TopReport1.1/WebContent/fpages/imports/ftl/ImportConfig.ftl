<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="DataDicEntry.title">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="ImportConfig" init="true" submitMode="allchange">
<table width="900px">
    <tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td><span>请选择相应的文件进行配置：</span></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btNew,-,btMod,-,btDel,-,btSave,-,Cancel,-,btRow,-,iXml" fieldStr="fileName[100],tableName[100],fileType[100],splitType[90]"  width="100%" hasFrame="true" height="100%" readonly="true"/>
		</td>
	</tr>
	
	 <tr>
		 <td colspan="2">
		      <@CommonQueryMacro.Group id="group1" label="文件属性"
		        	 fieldStr="fileName,tableName,fileType,splitType,seperator,importTime,updateType,startRow,endrowFlag,startColumn,endColumn,sheetNum,mainFlag,fuid,status,remark" colNm=4/> 			
		 </td>
  	 </tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr>
</table>
<script language="JavaScript">
  
  function btNew_onClick(button){
     fieldReadOnlyStatus(false);
  }
  
  function btMod_onClick(button){
     fieldReadOnlyStatus(false);
  }
 
 function Cancel_onClick(){
     ImportConfig_dataset.flushData(ImportConfig_dataset.pageIndex);
  }
 
  function ImportConfig_dataset_afterScroll(dataset){
     fieldReadOnlyStatus(true);
     var record=dataset.record;
     if(record){
       var fileType=record.getValue("fileType");
         if(fileType=='XML'){
          // document.getElementById("btRow").disabled=true;
           document.getElementById("iXml").disable(false);
         }else{
           //document.getElementById("btRow").disabled=false;
           document.getElementById("iXml").disable(true);
         }
     }
    setRequired("splitType", (dataset.getValue('fileType').toLowerCase() == 'txt'));
	setRequired("seperator",(dataset.getValue('splitType') == '1'));
	setRequired("sheetNum", (ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xls' ||ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xlx'));
	setRequired("startColumn", (ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xls' ||ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xlx'));
	setRequired("endColumn", (ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xls' ||ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xlx'));

  }

  function btRow_onClickCheck(button){
     var id=ImportConfig_dataset.record.getValue("id");
     var filename=ImportConfig_dataset.record.getValue("fileName");
     var tablename=ImportConfig_dataset.record.getValue("tableName");
     if(filename){
       button.url="fpages/imports/ftl/ImportFieldConfig.ftl?importFileId="+id+"&fileName="+filename+"&tableName="+tablename;
     }else{
       alert("当前所选行为空，请插入值！");
       return false;
     }    
  }
 
  function iXml_onClickCheck(button){
     var id=ImportConfig_dataset.record.getValue("id");
     var filename=ImportConfig_dataset.record.getValue("fileName");
     var tablename=ImportConfig_dataset.record.getValue("tableName");
     if(id){
       button.url="fpages/imports/ftl/ImportXmlConfig.ftl?guid="+id+"&fileName="+filename+"&tableName="+tablename;
     }else{
       alert("当前所选行为空，请插入值！");
       return false;
     }
      
  }
 
  function btSave_postSubmit(button){
     fieldReadOnlyStatus(true);      
     ImportConfig_dataset.flushData(ImportConfig_dataset.pageIndex);
  }
  function btSave_onClickCheck(button) {
  	if (ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xls' ||ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xlx') {
  		if (ImportConfig_dataset.getValue('sheetNum')<1) {
  			alert("[" + ImportConfig_dataset.getField('sheetNum').label + "] 必须大于0");
  			return false;
  		}
  		if (ImportConfig_dataset.getValue('startColumn')<1) {
  			alert("[" + ImportConfig_dataset.getField('startColumn').label + "] 必须大于0");
  			return false;
  		}
  		if (ImportConfig_dataset.getValue('endColumn')<1) {
  			alert("[" + ImportConfig_dataset.getField('endColumn').label + "] 必须大于0");
  			return false;
  		}
  		if (ImportConfig_dataset.getValue('endColumn') < ImportConfig_dataset.getValue('startColumn')) {
  			alert("[" + ImportConfig_dataset.getField('endColumn').label + "] 必须大于 [" + ImportConfig_dataset.getField('startColumn').label + "]");
  			return false;
  		}
  	}
  	return true;
  }
  
 function fieldReadOnlyStatus(flag){
   ImportConfig_dataset.setReadOnly(flag);
 }
function ImportConfig_dataset_afterChange(dataset,field) {
	if(field.fieldName =="fileType"){
		setRequired("splitType", (dataset.getValue('fileType').toLowerCase() == 'txt'));
		
		setRequired("sheetNum", (ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xls' ||ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xlx'));
		setRequired("startColumn", (ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xls' ||ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xlx'));
		setRequired("endColumn", (ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xls' ||ImportConfig_dataset.getValue('fileType').toLowerCase() == 'xlx'));
	}
	if(field.fieldName =="splitType"){
		setRequired("seperator",(dataset.getValue('splitType') == '1'));
	}
}
function setRequired(field, flag) {
	var f = ImportConfig_dataset.getField(field);
	f.required = flag;
	if(flag) {
		$('#fldlabel_'+field).empty().prepend("<font color=red>*</font>").append(f.label);
	} else {
		$('#fldlabel_'+field).html("&nbsp;&nbsp;"+f.label);
	}
}
</script>
</@CommonQueryMacro.page>