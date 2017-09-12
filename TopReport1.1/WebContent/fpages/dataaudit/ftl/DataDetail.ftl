<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="数据分析详细">
<table width="800px" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="dataDetailEntry" init="true" submitMode="current">
	<table width="1000px">
		<tr>
			<td valign="top" colspan="2">
				<@CommonQueryMacro.Interface id="interface" label="数据分析查询" colNm=4 showButton="true"/>
			</td>
		</tr>
		<tr>
			<td valign="top" colspan="2">
				<@CommonQueryMacro.Group id ="group1" label="数据分析详细信息" fieldStr="workDate,busiType,brName,operTlr,operTm" colNm=4/>
			</td>
		</tr>
		<tr>
			<td  colspan="2">
				<@CommonQueryMacro.PagePilot id="pagePilot"  maxpagelink="15" showArrow="true" pageCache="false"/>
			</td>
		</tr>	
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.DataTable id="dataTable1" fieldStr="analyNo,appType,fileType,analyResult"  width="100%" hasFrame="true" height="100%"  />
			</td>
		</tr>
		<tr>
			<td>
				<span id="size"> </span>&nbsp;&nbsp;<span id="show"> </span>
			</td>
		</tr>
	</@CommonQueryMacro.CommonQuery>
<td>
</tr>	 	
</table>
<script language="javascript">
	//当页面初始化完之后可以调用该方法执行需要处理的操作
function initCallGetter_post(dataset) {
	dataDetailEntry_dataset.setFieldReadOnly("workDate",true);
	dataDetailEntry_dataset.setFieldReadOnly("busiType",true);
	dataDetailEntry_dataset.setFieldReadOnly("brName",true);
	dataDetailEntry_dataset.setFieldReadOnly("operTlr",true);
	dataDetailEntry_dataset.setFieldReadOnly("operTm",true);
}
</script>
</@CommonQueryMacro.page>			
