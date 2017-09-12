<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<@CommonQueryMacro.page title="各行日销售业绩产品明细查询">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="BranchDailyQueryDetail" init="true" submitMode="current">
      		<table width="600px">
      			<tr>

      			  <td>
      			   <br/>
      			  </td>
				

      			</tr>

      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" fieldStr="id,pname,amt" width="100%" hasFrame="true" readonly="true" />
      			  </td>
      			 </tr>
      			 <tr>
					<td colspan="2">
					<br/>
					<br/>
						<@CommonQueryMacro.Button id= "btSee"/>&nbsp;&nbsp;
						
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