<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="审批路线设置">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="routeDetailSet" init="true" mode="2">
	<table align="left">

      	<tr>
      		<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresultRoute" maxpagelink="9999"/>
			</td>
				<td align="right">

	    	<a href="javascript:window.document.getElementById('btNew2').click();">新增</a>
	    	<!--
	    	<a href="javascript:window.document.getElementById('btDelete2').click();">删除</a>
	       -->
	       </td>
		</tr>
		<tr>
		<td  colspan="2">
			<@CommonQueryMacro.DataTable id ="datatableRoute" fieldStr="stopId,brhClass1,roleId,need,pass,opr2"  readonly="true" width="100%" hasFrame="true" height="150" />
		</td>
		</tr>

<tr>
      		<td valign="top" colspan="2">
					<@CommonQueryMacro.Group id ="groupRoute" label="详细信息" fieldStr="stopId,brhClass1,need,pass,amtType,approveAmt,roleId"colNm=4/>

	  			<table>
        		<tr align="left">
      				<td >
      					<@CommonQueryMacro.Button id= "btSave2"/>
      					&nbsp;&nbsp;
      					<@CommonQueryMacro.Button id= "btBack"/>
      				</td>

      			</tr>
      			</table>
      		</td>
		 </tr>
		 <div style="display:none">
		 	<@CommonQueryMacro.Button id= "btNew2" />
      		<@CommonQueryMacro.Button id= "btDelete2"/>
		 </div>
 		</table>
	 </table>
</@CommonQueryMacro.CommonQuery>
<script language="Javascript">




var routeId = routeDetailSet_dataset.getParameter("routeId");
var v_stopId = 1;
var temp = 0 ;
//默认不可输入，新增后可输入
function routeDetailSet_dataset_flushDataPost(dataset){
	v_stopId = routeDetailSet_dataset.length;
	if(v_stopId ==0){
		routeDetailSet_dataset.setFieldReadOnly("stopId",true);
		routeDetailSet_dataset.setFieldReadOnly("brhClass1",true);
		routeDetailSet_dataset.setFieldReadOnly("roleId",true);
		routeDetailSet_dataset.setFieldReadOnly("need",true);
		routeDetailSet_dataset.setFieldReadOnly("pass",true);
		routeDetailSet_dataset.setFieldReadOnly("amtType",true);
		routeDetailSet_dataset.setFieldReadOnly("approveAmt",true);
	}
	else{
		routeDetailSet_dataset.setFieldReadOnly("stopId",true);
		routeDetailSet_dataset.setFieldReadOnly("brhClass1",false);
		routeDetailSet_dataset.setFieldReadOnly("roleId",false);
		routeDetailSet_dataset.setFieldReadOnly("need",false);
		routeDetailSet_dataset.setFieldReadOnly("pass",false);
		routeDetailSet_dataset.setFieldReadOnly("amtType",false);
		routeDetailSet_dataset.setFieldReadOnly("approveAmt",false);
	}

}

//新增记录时给每条记录赋审批路线ID(routeId)的值
	function btNew2_onClick(button){
		v_stopId = getstopId();
//		routeDetailSet_dataset.setFieldReadOnly("stopId",false);
		routeDetailSet_dataset.setFieldReadOnly("brhClass1",false);
		routeDetailSet_dataset.setFieldReadOnly("roleId",false);
		routeDetailSet_dataset.setFieldReadOnly("need",false);
		routeDetailSet_dataset.setFieldReadOnly("pass",false);
		routeDetailSet_dataset.setFieldReadOnly("amtType",false);
		routeDetailSet_dataset.setFieldReadOnly("approveAmt",false);
		routeDetailSet_dataset.setValue2("routeId",routeId);
		routeDetailSet_dataset.setValue2("stopId",v_stopId);
	}


//初始化stopId字段,保证每次增加都是按顺序的
var array={};
var tempValue ="" ;
var count = 0 ;
function datatableRoute_stopid_onRefresh(cell, value, record)
{
	if(value.trim()=='')
	{
	   return ;
	}
    array[count++]=value ;
    cell.innerHTML = value ;
}

function getstopId()
{

    for(var i=0;i<= count ;i++)
    {
    	if(array[i]>temp)
    	{
    	    temp = array[i] ;
    	}
    }
    array[count++] =++temp  ;
    return temp ;
}

//是否跳过与是否必经不能同为"是"
function need_DropDown_onSelect(dropDown,record,editor)
{
   if(record.getValue("data").trim()=="1"&&routeDetailSet_dataset.getValue("pass")=="1")
   {
		alert("跳过和必经只能选其一");
   	  	routeDetailSet_dataset.setValue2("pass","0");
   }
   return true;
}
function pass_DropDown_onSelect(dropDown,record,editor)
{
   if(record.getValue("data").trim()=="1"&&routeDetailSet_dataset.getValue("need")=="1")
   {
		alert("跳过和必经只能选其一");
   	  	routeDetailSet_dataset.setValue2("need","0");
   }
   return true;
}

//金额策略不启用则审批金额不能输入
function amtType_DropDown_onSelect(dropDown,record,editor)
{
   if(record.getValue("data").trim()=="0")
   {
   	  	routeDetailSet_dataset.setFieldReadOnly("approveAmt",true);
   	  	routeDetailSet_dataset.setValue2("approveAmt",0);
   }
   else{
  		routeDetailSet_dataset.setFieldReadOnly("approveAmt",false);
   }
   return true;
}


 //提交前的检查
function btSave2_onClickCheck(button){

//	var _nextUrl = "/fpages/workflowRoute/ftl/RouteDetailSet.ftl?routeId="+ routeId;
	var _nextUrl = "/fpages/workflowRoute/ftl/RouteTemplateSet.ftl?routeId="+ routeId;
	button.url = _nextUrl;
}

function btBack_onClickCheck(button){
    unloadPageWindows("userWin");
    return false;
}

<#-- add by henry 20110617 begin-->
function datatableRoute_opr2_onRefresh(cell, value, record)
{
	if(record&&record!=null){
		var id = record.getValue("id");
		cell.innerHTML = "<center><a href=\"JavaScript:contractDel2("+id+")\">删除</a></center>";
	}else{
		cell.innerHTML = "";
	}
}

function contractDel2(Id){
		var record = routeDetailSet_dataset.find(["id"],[Id]);
		routeDetailSet_dataset.setRecord(record);
		window.document.getElementById('btDelete2').click();
}
<#--add by henry 20110617 end-->
</script>
</@CommonQueryMacro.page>
