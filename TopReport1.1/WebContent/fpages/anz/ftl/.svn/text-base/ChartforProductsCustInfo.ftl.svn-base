<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<@CommonQueryMacro.page title="银行产品明细查询">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="ChartforProductsCustInfo" init="false" submitMode="current">
      		<table width="1000px">


			<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="银行产品明细统计图查询" colNm=4 showButton="true" />
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
function ChartforProductsCustInfo_dataset_flushDataPost(){
var v_param1=ChartforProductsCustInfo_dataset.getValue("param1");
//alert(v_param1);
document.getElementById("view1").innerHTML=v_param1;
}
	

</script>
</@CommonQueryMacro.page>