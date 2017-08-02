<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="审核路线绑定">
<@CommonQueryMacro.CommonQuery id="routeBindingEntry" init="true" mode="2">
	<table align="left" width="700" >
			<tr valign="left">
       			<td valign="top" colspan="2">
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4  />
				</td>
      		</tr>
      	<tr align="right">

    	</tr>
      	<tr>
      		<td valign="top" >
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9999"/>
			</td>
			<td align="right" >
	    	<a href="javascript:window.document.getElementById('btNew').click();">新增</a>
	    	<!--<a href="javascript:window.document.getElementById('btDelete').click();">删除</a>
	       	-->
	       	</td>
			</tr>
			<tr>
				<td colspan="2">
				<#-- modify by shen_antonio jria: BMS-2334 begin -->
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="bussType,startBrhidName,maxAmt,isBand,opr" width="100%" hasFrame="true" height="150"  readonly="true"/>
					<#-- modify by shen_antonio jria: BMS-2334 end -->
				</td>
			</tr>
			<tr>
      		<td valign="top" colspan="2">
					<@CommonQueryMacro.Group id ="group1" label="详细信息" fieldStr="bussType,startBrhid,brhClass,maxAmt,isBand"colNm=4/>


	  		<table>
        		<tr align="left">
      				<td >
      					<@CommonQueryMacro.Button id= "btSave"/>
      					&nbsp;&nbsp;
      					<@CommonQueryMacro.Button id= "btBind"/>
      				</td>
      			</tr>
      		</table>
      		</td>
		 </tr>
		 <div style="display:none">
		    <@CommonQueryMacro.Button id= "btNew" />
      		<@CommonQueryMacro.Button id= "btDelete"/>
      	 </div>
	 </table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
function btDelete_onClickCheck(button){
	var _isBand = routeBindingEntry_dataset.getValue("isBand");
	if(_isBand=="1"){
		alert("路线已绑定不可删除！");
		return false;
	}
	if(!confirm("确定删除")){
		return false;
	}
}

function btBind_onClickCheck(button){
	var id = routeBindingEntry_dataset.getValue("id");
	var paramMap = new Map();
  	 	paramMap.put("id",id);
  	 	loadPageWindows("userWin", "审批路线绑定明细", "/fpages/workflowRoute/ftl/RouteBindingDetail.ftl", paramMap, "winZone");
   	 	return false;

	var  _nextUrl = "/fpages/workflowRoute/ftl/RouteBindingDetail.ftl?id="+ id;
	button.url = _nextUrl;

}
<#-- modify by shen_antonio jria: BMS-2334 begin -->
function btSave_postSubmit(button){
	routeBindingEntry_dataset.flushData(routeBindingEntry_dataset.pageIndex);
	alert("保存成功");
}
<#-- modify by shen_antonio jria: BMS-2334 end -->

<#-- add by henry 20110617 begin-->
function datatable1_opr_onRefresh(cell, value, record)
{
	if(record&&record!=null){
		var id = record.getValue("id");
		cell.innerHTML = "<a href=\"JavaScript:contractDel("+id+")\">删除</a>";
	}else{
		cell.innerHTML = "";
	}
}

function contractDel(Id){
		var record = routeBindingEntry_dataset.find(["id"],[Id]);
		routeBindingEntry_dataset.setRecord(record);
		window.document.getElementById('btDelete').click();
}
<#--add by henry 20110617 end-->
</script>
</@CommonQueryMacro.page>
