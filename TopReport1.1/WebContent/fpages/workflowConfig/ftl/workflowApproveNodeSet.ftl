<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="审核路线绑定">
<@CommonQueryMacro.CommonQuery id="approveNodeRouteBinding" init="true" mode="2" navigate="false">
	<table align="left">
			<tr valign="center">
       			<td valign="top" colspan="2">
       			<#-- modify by shen_antonio jria: BMS-2334 begin -->
       			<table>
        			<tr align="center">
	  				 	<td align="center">
							<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=6  width="200"/>
						<td>
					</tr>
				</table>
				<#-- modify by shen_antonio jria: BMS-2334 end -->
				</td>
      		</tr>
      	<tr>
      		<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9999"/>
					<#-- modify by shen_antonio jria: BMS-2334 begin -->
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="startBrhidName,maxAmt,isBand"  readonly="true"/>
					<#-- modify by shen_antonio jria: BMS-2334 end -->
			</td>
      		<td valign="top">
				<fieldset>
					<legend>业务发起条件</legend>
					<@CommonQueryMacro.Group id ="group1" label="" showGroupLine="false" fieldStr="bizTypeName"colNm=2/>
					<br/>
					<fieldset>
						<legend>发起行</legend>
						<input type="radio" name="type" id="rd_brclass" checked="true" value="1" onclick="freshData()">指定机构级别&nbsp;&nbsp;
						<input type="radio" name="type" id="rd_brcode" value="2" onclick="freshData()">指定机构
						<span id="span_startBrhid" style="display:none">
						<@CommonQueryMacro.Group id ="group1" label="" showGroupLine="false" fieldStr="startBrhid"colNm=4/>
						</span>
						<span id="span_startBrhClass">
						<@CommonQueryMacro.Group id ="group2" label="" showGroupLine="false" fieldStr="startBrhLevel"colNm=4/>
						</span>
					</fieldset>
				</fieldset>
				<@CommonQueryMacro.Group id ="group1" label="业务生效条件" fieldStr="brhClass,maxAmt"colNm=2/>
				<@CommonQueryMacro.Group id ="group1" label="是否绑定路线" fieldStr="isBand"colNm=2/>
	  		<table>
        		<tr align="center">
	  				 <td>
      					<@CommonQueryMacro.Button id= "btNew" />
      				</td>

      				<td>
      					<@CommonQueryMacro.Button id= "btDelete"/>
      				</td>

      				<td >
      					<@CommonQueryMacro.Button id= "btSave"/>
      				</td>

      				<td >
      					<@CommonQueryMacro.Button id= "btBind"/>
      				</td>


      			</tr>
      		</table>
      		</td>
		 </tr>

	 </table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">

function btNew_onClick(button){
	freshData();
}

function btSave_onClickCheck(button){
	var bussProc = approveNodeRouteBinding_dataset.getParameter("bussProc");
	//alert(bussProc);
	approveNodeRouteBinding_dataset.setValue("bussProc",bussProc);
}

function btBind_onClickCheck(button){
	var id = approveNodeRouteBinding_dataset.getValue("id");
	var biz_type = approveNodeRouteBinding_dataset.getValue("bizType");
	var paramMap = new Map();
  	 	paramMap.put("id",id);
  	 	paramMap.put("bussType",biz_type);
  	 	loadPageWindows("userWin", "审批路线绑定明细", "/fpages/workflowConfig/ftl/ApproveNodeRouteBindDetail.ftl", paramMap, "winZone");
   	 	return false;

	var  _nextUrl = "/fpages/workflowConfig/ftl/ApproveNodeRouteBindDetail.ftl?id="+ id;
	button.url = _nextUrl;

}
<#-- modify by shen_antonio jria: BMS-2334 begin -->
function btSave_postSubmit(button){
	approveNodeRouteBinding_dataset.flushData(approveNodeRouteBinding_dataset.pageIndex);
	alert("保存成功");
}
<#-- modify by shen_antonio jria: BMS-2334 end -->

function approveNodeRouteBinding_dataset_afterScroll(dataset){
	var v_rd_brclass = document.getElementById("rd_brclass");
	var v_rd_brcode = document.getElementById("rd_brcode");
	if(dataset.getValue("startBrhid") < 0){
		v_rd_brcode.checked=false;
		v_rd_brclass.checked=true;
		document.getElementById("span_startBrhClass").style.display="";
		document.getElementById("span_startBrhid").style.display="none";
	}else{
		v_rd_brcode.checked=true;
		v_rd_brclass.checked=false;
		document.getElementById("span_startBrhClass").style.display="none";
		document.getElementById("span_startBrhid").style.display="";
	}
}



function freshData(){
	approveNodeRouteBinding_dataset.setValue("startBrhid","");
	approveNodeRouteBinding_dataset.setValue("startBrhidName","");
	approveNodeRouteBinding_dataset.setValue("startBrhLevel","");
	approveNodeRouteBinding_dataset.setValue("startBrhLevelName","");
	var v_rd_brclass = document.getElementById("rd_brclass");
	var v_rd_brcode = document.getElementById("rd_brcode");
	if(v_rd_brclass.checked){
		approveNodeRouteBinding_dataset.getField("startBrhid").required = false;
		approveNodeRouteBinding_dataset.getField("startBrhLevel").required = true;
		document.getElementById("span_startBrhClass").style.display="";
		document.getElementById("span_startBrhid").style.display="none";
	}
	if(v_rd_brcode.checked){
		approveNodeRouteBinding_dataset.getField("startBrhLevel").required = false;
		approveNodeRouteBinding_dataset.getField("startBrhid").required = true;
		document.getElementById("span_startBrhClass").style.display="none";
		document.getElementById("span_startBrhid").style.display="";


	}
	approveNodeRouteBinding_dataset.loadDetail();
	approveNodeRouteBinding_dataset.refreshControls();
}

function approveNodeRouteBinding_interface_dataset_onSetValue(dataset,field,value){
	if(field.name == "startbrhid"){
		if(approveNodeRouteBinding_interface_dataset.getValue("startBrhClass") != ""){
			approveNodeRouteBinding_interface_dataset.setValue("startBrhClass", "");
			approveNodeRouteBinding_interface_dataset.setValue("startBrhClassName", "");
		}
	}
	if(field.name == "startbrhclass"){
		if(approveNodeRouteBinding_interface_dataset.getValue("startBrhId") != ""){
			approveNodeRouteBinding_interface_dataset.setValue("startBrhId", "");
			approveNodeRouteBinding_interface_dataset.setValue("startBrhIdName", "");
		}
	}
	return value;
}

function bizTypeName_DropDown_beforeOpen(dropdown){
	bizTypeName_DropDown.cached=false;
	SelectTempCreditinfo_DropDownDataset.setParameter("typeNo","3");
	SelectTempCreditinfo_DropDownDataset.flushData(0);
	SelectTempCreditinfo_DropDownDataset.insertRecord("begin");
	SelectTempCreditinfo_DropDownDataset.firstUnit.setValue("code", "000000");
	SelectTempCreditinfo_DropDownDataset.firstUnit.setValue("name", "不限");
}
</script>
</@CommonQueryMacro.page>
