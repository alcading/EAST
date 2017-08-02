<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<@CommonQueryMacro.page title="澳新银行当月开户信息统计图">
 <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="ChartForOpenMonth" init="false" submitMode="all">
      		<table width="1000px">


			<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="澳新银行当月开户信息查询" colNm=4 showButton="true" />
        	</td>
       		 </tr>
		<tr>
		 <td align="center" style="border: 0px solid ">
		 <div id="view1">
		 </div>
		 </td>
	</tr>
   
				
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">
function ChartForOpenMonth_dataset_flushDataPost(){
var v_param1=ChartForOpenMonth_dataset.getValue("param1");
//alert(v_param1);
document.getElementById("view1").innerHTML=v_param1;
}
</script>
</@CommonQueryMacro.page>