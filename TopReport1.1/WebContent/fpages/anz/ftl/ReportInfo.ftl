<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<@CommonQueryMacro.page title="澳新分析报表下载">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="ReportInfo" init="false" submitMode="current">
      		<table width="1000px">


			<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="报表查询下载" colNm=4 showButton="true" />
        	</td>
       		 </tr>
      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" fieldStr="reportName,fileName,fileTotal,fileCreateTime,opr" width="100%" hasFrame="true" readonly="true" />
      			  </td>
      			 </tr>
	 				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Button id= "btTest"/>&nbsp;&nbsp;
					</td>
				</tr>
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">

//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			
				cell.innerHTML="<center><a href=\"JavaScript:doDownload('"+value+"')\">下载</a></center>";
			
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}
	}
	//下载文件

	function doDownload(id){
		var path=_application_root + "/fileDownload.do?flag=0&filePath="+id;
		location.href=path;
		return false;
	}
function btTest_onClickCheck(button){
var path=_application_root + "/fileDownload.do?flag=2";
		location.href=path;
		return false;
}
</script>
</@CommonQueryMacro.page>