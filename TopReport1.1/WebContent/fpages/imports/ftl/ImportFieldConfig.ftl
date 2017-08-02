<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="DataDicEntry.title">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="ImportFieldConfig" init="true" submitMode="allchange">
<table width="800px">
    <tr>
        <td>
 <span>文件名为：【${RequestParameters["fileName"]}】,表名为:【${RequestParameters["tableName"]}】,其被配置的字段如下: </span>
        </td>  
    </tr>
    <tr>
		<td>		
	<@CommonQueryMacro.DataTable id ="group1" fieldStr="fieldName[150],fieldDesc[70],fieldType[30],fieldUpdateFlag[30]],fieldUpdateType[30],filterFlag[30]" width="100%" hasFrame="true" height="100%" readonly="true"/>
		</td>
	</tr>
	<tr >
		<td>
			<@CommonQueryMacro.Button id= "btNew"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btMod"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btCancel"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btRow"/>&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td>		
	<@CommonQueryMacro.Group id ="group2" label="具体字段配置" fieldStr="fieldName,fieldDesc,uniqueFlag,fieldType,fieldUpdateFlag,fieldUpdateType,mapFunction,filterFlag,filterFunction" colNm=4/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr>
</table>
<script language="JavaScript">
    var importFileId="${RequestParameters["importFileId"]}";
  
  function ImportFieldConfig_dataset_flushDataPost(dataset){
      if(!ImportFieldConfig_dataset.getFirstRecord()){
          fieldReadOnlyStatus(true);
      }
  }


  function ImportFieldConfig_dataset_afterScroll(dataset){
     fieldReadOnlyStatus(true);
  }

 function fieldReadOnlyStatus(flag){
 	ImportFieldConfig_dataset.setReadOnly(flag);
 }

 function btNew_onClick(button){
     fieldReadOnlyStatus(false);
     var record=ImportFieldConfig_dataset.record;
     record.setValue("importFileId",importFileId);
  }
  
  function btMod_onClick(button){
     fieldReadOnlyStatus(false);
  }
 
 function btCancel_onClick(button){
     ImportFieldConfig_dataset.cancelRecord();
     ImportFieldConfig_dataset.flushData( ImportFieldConfig_dataset.pageIndex);
  }
  
  function btSave_postSubmit(button){
     fieldReadOnlyStatus(true);      
  }
  
</script>
</@CommonQueryMacro.page>