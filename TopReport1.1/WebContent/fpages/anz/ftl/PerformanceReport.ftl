<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<@CommonQueryMacro.page title="客户经理月业绩信息">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="PerformanceReport" init="false" submitMode="current">
      		<table width="1000px">


			<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="客户经理月业绩信息查询" colNm=4 showButton="true" />
        	</td>
       		 </tr>
      			<tr>

      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>

      			</tr>
      				<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" fieldStr="cmrm,newcustNum,redcustNum,allamt,proamt" width="100%" hasFrame="true" readonly="true" />
      			  </td>
      			 </tr>
				
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">
</script>
</@CommonQueryMacro.page>