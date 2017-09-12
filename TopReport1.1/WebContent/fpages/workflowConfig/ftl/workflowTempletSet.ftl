<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="业务流程配置">
<@CommonQueryMacro.CommonQueryTab id="WORKFLOWCONFIG_TAB" navigate="false" width="1000" height="900" currentTab="tabTempletSet">

<table align="left">
<tr>
<td valign="top">
<@CommonQueryMacro.CommonQuery id="workflowProcSet" init="false" submitMode="current" navigate="false">
	<table align="left">
		<tr>
      		<td valign="top">
					<@CommonQueryMacro.Group id ="group1" label="业务流程" fieldStr="bussProc" colNm=4/>
      		</td>
		 </tr>

	 </table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
<tr>
<td colspan="2">
	<hr/>
</td>
</tr>
<tr>
<td valign="top">
<@CommonQueryMacro.CommonQuery id="workflowTempletSet" init="true" submitMode="all" navigate="false">
	<FIELDSET name="fifsfasd" style="padding: 6px;"><LEGEND>&nbsp;流程模板&nbsp;</LEGEND>
	<table align="left">
      		<tr>
      		<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="20"/>
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="select,description"  readonly="true"/>
			</td>
			</tr>
			<tr>
      		<td valign="top">
        		<tr align="center">
      				<td >
      					<@CommonQueryMacro.Button id= "btSave"/>
      				</td>
      			</tr>
      		</td>
		 	</tr>
	 </table>
	 </FIELDSET>
</@CommonQueryMacro.CommonQuery>
</td>

<td valign="top" rowspan="1"  valign="top" width="100%" height="700px">
 <table align="left" width="100%">
       <tr>
			<td align="left">流程设计图</td>
	   </tr>


      	<tr align="center">
       		<td  align="center" valign="top" width="100%">
       		<IFRAME FRAMEBORDER=2 ALIGN=LEFT width="100%" HEIGHT="400px" SCROLLING=AUTO SRC=''  ID="processDiv" NAME="processDiv">
			</IFRAME>
            </td>
       </tr>
</table>
</td>

</tr>

</table>
</@CommonQueryMacro.CommonQueryTab>

<script language="javascript">
var loadflag = false;
var v_templetName = "";

function WORKFLOWCONFIG_TAB_tabset_beforeTabChange(tabset,oldName,newName){
 	if ( "tabTempletSet" == oldName){
 		var v_bussProc = workflowProcSet_dataset.getValue("bussProc");
		if(!v_bussProc){
			return "您还没有选择业务流程！";
		}
		
		v_templetName = getTempletName(workflowTempletSet_dataset);

		if(!v_templetName){
			return "您还没有选择流程模板！";
		}
 		addParams2TabsUrl(WORKFLOWCONFIG_TAB_tabset, 
 						  "bussProc,templetName", 
 						  v_bussProc + "," + v_templetName);
    }
}

function getTempletName(dataset){
	var v_rec = dataset.firstUnit;
	while(v_rec){
		if(v_rec.getValue("select")){
			return v_rec.getValue("name");
		}
		v_rec = v_rec.nextUnit;
	}
	return "";
}

function initCallGetter_post(){
	loadWorkflowPage();
	loadflag = true;
}


function workflowTempletSet_dataset_afterScroll(dataset){
	if(loadflag){
		loadWorkflowPage();
	}
}

function loadWorkflowPage(){
	v_name = workflowTempletSet_dataset.getValue("name");
	document.getElementById("processDiv").src = "${contextPath}/processimagebyprocname?procName=" + v_name;
}


function bussProc_DropDown_onSelect(dropDown,record,editor){
	v_bussProc = record.getValue("bussProc");
	workflowTempletSet_dataset.setParameter("bussProc",v_bussProc);
	workflowTempletSet_dataset.flushData();
	
	var v_rec = workflowTempletSet_dataset.firstUnit;
	while(v_rec){
		if(v_rec.getValue("select")){
			break;
		}
		v_rec = v_rec.nextUnit;
		workflowTempletSet_dataset.moveNext();
	}
		
	return true;
}

function btSave_onClickCheck(button){
	var v_bussProc = workflowProcSet_dataset.getValue("bussProc");
	if(!v_bussProc){
		alert("您还没有选择业务流程！");
		return false;
	}
	v_templetName = getTempletName(workflowTempletSet_dataset);

	if(!v_templetName){
		return "您还没有选择流程模板！";
	}
	return true;
}

function btSave_postSubmit(button){
	button.url = "/fpages/workflowConfig/ftl/WorkflowNodeSet.ftl?bussProc=" + v_bussProc + "&templetName=" + v_templetName;
}

</script>
</@CommonQueryMacro.page>
