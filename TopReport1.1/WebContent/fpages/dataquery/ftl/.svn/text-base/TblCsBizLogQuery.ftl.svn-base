<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="日志查询">
<@CommonQueryMacro.CommonQuery id="tblCsBizLogQuery" init="false" submitMode="current" navigate="false">
	<table align="left" width="90%">
     <tr valign="center">
       			<td valign="top" colspan="2">
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=6 />
				</td>
     </tr>
     <tr>
      		<td valign="top">
      			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
      		</td>
	 </tr>
     <tr>
      		<td valign="middle" align="center" colspan="2">
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="tlrName[80],misc[180],txnStartTime[140],txnEndTime[140],ipAdr[60],txnBizLog1" readonly="true" width="100%"/></br>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<span style="display:none">
<@CommonQueryMacro.CommonQuery id="PosiNameCheck" init="false" navigate="false" >
</@CommonQueryMacro.CommonQuery>
</span>

<script language="JavaScript">


</script>
</@CommonQueryMacro.page>
