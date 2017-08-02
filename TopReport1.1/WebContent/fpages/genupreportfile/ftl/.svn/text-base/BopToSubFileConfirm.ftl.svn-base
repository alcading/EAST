<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign create = statics["com.huateng.ebank.framework.report.common.ReportConstant"].CREATE_SUB_FILE_IS_WORKDATE>
<@CommonQueryMacro.page title="生成上报文件确认">
<@CommonQueryMacro.CommonQuery id="bopToSubFileConfirm" init="true" submitMode="all">
<table width="800px">
   <#if create == true>
   <tr>
      	<td>
      	   <@CommonQueryMacro.Group id ="group1" label="统计日期" fieldStr="fileDate" colNm=2/>
      	</td>
	</tr>
	</#if>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="datatable1" fieldStr="appType,fileType,recCount,fileCount"  width="100%" hasFrame="true" height="300"/>
		</td>
	</tr>
 	<tr>
	   <td>
		<@CommonQueryMacro.Button id="btConfirm"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id="btCancel"/>
	    </td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	function btCancel_onClick(button){
		closeWin();
	}

	function btConfirm_onClick(button){
		closeWin(true);
	}
</script>
</@CommonQueryMacro.page>