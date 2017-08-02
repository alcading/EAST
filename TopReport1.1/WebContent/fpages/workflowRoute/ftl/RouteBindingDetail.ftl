<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="审批路线绑定">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="routeBindingDetail1" init="true" navigate="true" submitMode="all">
	<table align="left">
			<tr>
       		<td valign="top"  valign="top">
      <@CommonQueryMacro.Group id ="group2" label="详细信息" fieldStr="bussType,startBrhid,brhClass,maxAmt,isBand"colNm=4/>
       		</td>
      		</tr>

   </table>
</@CommonQueryMacro.CommonQuery>

</td>
<td>&nbsp</td></tr><tr>
<td valign="top" rowspan="1"  valign="top">
<br/>
<br/>
<br/>
<@CommonQueryMacro.CommonQuery id="routeBindingDetail2" init="true" navigate="false" >
	<table align="left">
			<tr>
       			<td rowspan="1"  valign="top" >
       			<#-- modify by shen_antonio 20091214 jira: BMS-2334 begin -->
        		<@CommonQueryMacro.DataTable id ="datatable2" fieldStr="select,routeId,routeName"  width="520" />
        		<#-- modify by shen_antonio 20091214 jira: BMS-2334 end -->
        		</td>
      		</tr>
      		<tr align="left">
       			<td align="left">
         		<@CommonQueryMacro.Button id= "btSave2"/>
        		</td>
      	  	</tr>
   </table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>

<script language="javaScript">

<#-- modify by shen_antonio 20091214 jira: BMS-2334 begin -->
function routeBindingDetail2_dataset_afterChange(dataset, field)
{
	routeBindingDetail2_dataset.disableEvents();
	var record = routeBindingDetail2_dataset.firstUnit;
	var temp = routeBindingDetail2_dataset.getValue("select");
	if(temp==true)
	{

		while(record)
		{
			record.setValue("select",false);
			record=record.nextUnit;
		}
		routeBindingDetail2_dataset.setValue("select",temp);
	}

	routeBindingDetail2_dataset.enableEvents();
}
<#-- modify by shen_antonio 20091214 jira: BMS-2334 end -->
function btSave2_onClickCheck(button){
	var id = routeBindingDetail2_dataset.getParameter("id");
	var record = routeBindingDetail2_dataset.firstUnit;
	if(record){
		var routeId = record.getValue("routeId");
		if(routeId == null ||routeId ==""){
		alert("无记录不能保存");
		return false;
		}
	}else{
		alert("无记录不能保存");
		return false;
	}

//	var  _nextUrl = "/fpages/workflowRoute/ftl/RouteBindingEntry.ftl?id="+ id;
	var  _nextUrl = "/fpages/workflowRoute/ftl/RouteBindingEntry.ftl";
	button.url = _nextUrl;
}

function datatable2_routeid_onRefresh(cell, value, record)
{
	if(value =="")
    {	cell.innerHTML = "";
    	return false;
    }
	var routeId = record.getValue("routeId");
	cell.innerHTML = "<a href=\"Javascript:openRouteDetail('" + routeId + "')\">" + value + "</a>";
}
function openRouteDetail(value){
	path = _application_root + "/fpages/workflowRoute/ftl/RouteDetailSetQuery.ftl?routeId=" + value  ;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
</script>
</@CommonQueryMacro.page>
