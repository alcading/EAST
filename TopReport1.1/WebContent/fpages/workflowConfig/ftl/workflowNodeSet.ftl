<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="业务流程配置">

<@CommonQueryMacro.CommonQueryTab id="WORKFLOWCONFIG_TAB" navigate="false" width="1000" height="900" currentTab="tabTaskNodeSet">

<table width="100%">
	<tr>
		<td valign="top" width="300">
			<FIELDSET style="width:250">
				<LEGEND>流程信息</LEGEND>
				<table align="left">
					<tr>
						<td valign="top">
							<@CommonQueryMacro.CommonQuery id="workflowProcSet_Node" init="true" submitMode="current" navigate="false" >
								<@CommonQueryMacro.Group id ="group1" label="" fieldStr="description,templetDesc" colNm=2 showGroupLine="false"/>
							</@CommonQueryMacro.CommonQuery>
						</td>
					</tr>
					<tr>
			      		<td valign="top" align="left">
			      			<@CommonQueryMacro.CommonQuery id="workflowNodeDetails" init="true" submitMode="all" navigate="false">
								<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="20"/>
								<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="nodeName,nodeType1"  readonly="true"/>
							</@CommonQueryMacro.CommonQuery>
						</td>
					</tr>
				</table>
			</FIELDSET>
		</td>
		<td>
			<IFRAME FRAMEBORDER=2 ALIGN=LEFT width="100%" HEIGHT="450" SCROLLING=AUTO SRC=''  ID="nodeSetDiv" NAME="nodeSetDiv">
			</IFRAME>
		</td>
	</tr>
</table>

</@CommonQueryMacro.CommonQueryTab>

<script language="javascript">

var loadflag = false;

function initCallGetter_post(){
	loadWorkflowNodeSetPage();
	loadflag = true;
}


function workflowNodeDetails_dataset_afterScroll(dataset){
	if(loadflag){
		loadWorkflowNodeSetPage();
	}
}

function loadWorkflowNodeSetPage(){
	v_nodeType1 = workflowNodeDetails_dataset.getValue("nodeType1");
	if(v_nodeType1 == "2"){
		document.getElementById("nodeSetDiv").src = "${contextPath}/fpages/workflowConfig/ftl/workflowApproveNodeSet.ftl?" +
					                                "bussProc=" + workflowProcSet_Node_dataset.getValue("bussProc") +
					                                "&tempateName=" + workflowProcSet_Node_dataset.getValue("templetName");
	}else if(v_nodeType1 == "1"){
		document.getElementById("nodeSetDiv").src = "${contextPath}/fpages/management/ftl/WorkflowParamBinding.ftl?" +
					                                "bussProc=" + workflowProcSet_Node_dataset.getValue("bussProc") +
					                                "&templetName=" + workflowProcSet_Node_dataset.getValue("templetName") + 
					                                "&nodeName=" + workflowNodeDetails_dataset.getValue("nodeName");
	}
}

function datalabel_templetDesc_onRefresh(datalabel,value){
	if(value && value.length!=0){
		datalabel.innerHTML = "<a href=\"Javascript:showImage('" + workflowProcSet_Node_dataset.getValue("templetName") + "','1')\">" + value + "</a>";
	}
}

function showImage(value){
	var path = "${contextPath}/processimagebyprocname?procName=" + value;
	window.showModalDialog(path,"_SEMS_WINDOW","fullscreen:no;toolbar:no;scrollbars:yes;resizable:yes;location:no;status:no;menubar:no;top:0;left:0;dialogWidth:800px;dialogHeight:600px;");
	
}


	
</script>
</@CommonQueryMacro.page>
