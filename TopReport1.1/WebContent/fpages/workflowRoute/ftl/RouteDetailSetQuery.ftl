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
					<@CommonQueryMacro.DataTable id ="datatableRoute" fieldStr="stopId,brhClass1,roleName,need,pass"  readonly="true" width="100%"/>
			</td>
<td>&nbsp</td></tr><tr>
      		<td valign="top">
					<@CommonQueryMacro.Group id ="groupRoute" label="详细信息" fieldStr="stopId,brhClass1,need,roleName,pass,approveAmt,amtType"colNm=4/>

	  			<table>
        		<tr align="center">
					<td >
					<!--
      					<@CommonQueryMacro.Button id= "btBack2"/>
      					&nbsp;&nbsp;&nbsp;&nbsp;
      				-->
      				</td>

      			</tr>
      			</table>
      		</td>
		 </tr>
 		</table>
	 </table>
</@CommonQueryMacro.CommonQuery>
<script language="Javascript">
var routeId = routeDetailSet_dataset.getParameter("routeId");
var v_stopId = 1;
var temp = 0 ;
//默认不可输入，新增后可输入
function routeDetailSet_dataset_flushDataPost(dataset){
		routeDetailSet_dataset.setFieldReadOnly("stopId",true);
		routeDetailSet_dataset.setFieldReadOnly("brhClass1",true);
		routeDetailSet_dataset.setFieldReadOnly("roleId",true);
		routeDetailSet_dataset.setFieldReadOnly("need",true);
		routeDetailSet_dataset.setFieldReadOnly("pass",true);
		routeDetailSet_dataset.setFieldReadOnly("amtType",true);
		routeDetailSet_dataset.setFieldReadOnly("approveAmt",true);
}

function btBack2_onClickCheck(button){
<#--modify by lizh 20091201 BMS-2276 begin-->
 //   window.close();
  unloadPageWindows("userWin");
  return false;
<#--modify by lizh 20091201 BMS-2276 end-->
}
</script>
</@CommonQueryMacro.page>
