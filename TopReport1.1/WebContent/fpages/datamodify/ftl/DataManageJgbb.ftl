<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="报送表信息查询">
<@CommonQueryMacro.CommonQuery id="dataManageJgbb" init="true" submitMode="current" navigate="false">
<table align="left" width="800px">
   <tr>
      	<td colspan="2">
      	   <@CommonQueryMacro.Interface id="interface" label="报送报表查询" />
      	</td>
    </tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
	</tr>
   <tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="id,eastTableName,opr"  width="100%" hasFrame="true"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">

</script>
</@CommonQueryMacro.page>

