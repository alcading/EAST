<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="用户登录日志查询">

<@CommonQueryMacro.CommonQueryTab id="tlrLoginLogQueryTabs" navigate="false" currentTab="TlrLoginLogQuery">
<@CommonQueryMacro.CommonQuery id="TlrLoginLogQuery" init="true" submitMode="selected" navigate="false">



<table align="left" width="80%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
    <tr>
		<td>
			<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="tlrNo,brNo,loginAddr,loginSucTm[160],loginOutTm,loginFailTm,loginRemark" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">


</script>
</@CommonQueryMacro.page>
