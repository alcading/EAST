<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="数据分析详细">
<table width="95%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="executeResult" init="true" submitMode="current"  navigate="false">
	<table width="100%">
		<tr>
			<td valign="top" colspan="2">
				<@CommonQueryMacro.Group id ="group1" label="数据分析明细信息" fieldStr="workDate,operTm,busiType,appType,detailRemark" colNm=4/>
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<td>
</tr>
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="executeResultDetail" init="true" submitMode="current" navigate="false">
<FIELDSET name='interface2' style="padding:6px;"><LEGEND>&nbsp;分析记录详细&nbsp;</LEGEND>
<table width="100%">
	<tr>
    	<td><@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="10"/></td>
    </tr>
    <tr>
    	<td><@CommonQueryMacro.DataTable id ="datatable1" fieldStr="confSeq[30],confDesc,startTm[150],endTm[150],execSta[120],executeResult[120],execRemark" readonly="true" width="100%" /></td>
    </tr>
</table>
</FIELDSET>
</@CommonQueryMacro.CommonQuery>
<td>
</tr>
<tr valign="top">
<td  style='padding:5px;'>
	<@CommonQueryMacro.Button id= "btClose"/>
</td>
</tr>
</table>

<script language="javascript">
function btClose_onClickCheck(button){
  unloadPageWindows("detailWindow");
  return false;
}
</script>
</@CommonQueryMacro.page>
