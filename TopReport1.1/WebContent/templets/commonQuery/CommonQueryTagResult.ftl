<#--Result 模板　适用了Tag方式-->
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="">
<@CommonQueryMacro.CommonQueryForRequest>
	<table align="left">
			<tr>
       			<td valign="top" rowspan="1"  valign="top">
       				<@CommonQueryMacro.PagePilot id="PagePilot"/>
       				<@CommonQueryMacro.DataTable id ="dataTable" readonly="true"/>
        		</td>
      	  	</tr>
      	  	<tr>
       			<td align="center">
         			<@CommonQueryMacro.ButtonGroup/>
        		</td>
      	  	</tr>
   </table>
</@CommonQueryMacro.CommonQueryForRequest>
</@CommonQueryMacro.page>