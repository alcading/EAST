<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="123">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="BuLuConfirm" init="true" submitMode="current">
<table width="800px">
   <tr>
      	<td cospan="2">
      	   <@CommonQueryMacro.Interface id="interface" label="�������ѯ����" />
      	</td>
      		
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="10" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" fieldStr="jiLuLeiXing,zongJiLuShu,buXuBuLu,xuYaoBuLu,yiBuLu,opr"  width="100%" hasFrame="true"/>
		</td>
	</tr>	
	
	
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr>
    <tr>
	    <td>
	<@CommonQueryMacro.Button id="confirm"/>&nbsp&nbsp
	<@CommonQueryMacro.Button id="cancel"/>
	    </td>
	</tr>
</table>
<script language="JavaScript">
function datatable1_opr_onRefresh(cell,value,record) {
		if(record) {
			cell.innerHTML="<center><a href=\"ShenHeConfirm.ftl\">��ϸ</a></center>";

		}
	}
	
	BuLuConfirm_interface_dataset.setValue("riQi",new Date());
    

</script>
</@CommonQueryMacro.page>