<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="DataCheckResult.title">
<table width="1000px" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="DataCheckResult" init="true" submitMode="current">
	<table width="100%">
		<tr>
   			<td valign="top" colspan="2">
   				<@CommonQueryMacro.Interface id="intface" label="校验结果查询" colNm=4 showButton="true" />
        	</td>
        </tr>
		<tr>
   			<td>
   				<@CommonQueryMacro.PagePilot id="PagePilot"/>
   			</td>
  			
  		</tr>
  		<tr>
      		<td colspan="2">
          		<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id,tableName,tableDesc,columnName,columnDesc,errormsg,dataDate,opr" width="100%"  readonly="true"/></br>
        	</td>
        </tr>
 
   </table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>
<script language="javascript">
	//定位一条记录
	function locate(tableName) {
		var record = DataCheckResult_dataset.find(["id"],[id]);
		if (record) {
			DataCheckResult_dataset.setRecord(record); 
		}
	}

	function datatable1_opr_onRefresh(cell, value, record)
	{
	
		if (record) {
		    var tableName = record.getValue("tableName");
		   cell.innerHTML="<center><a href=\"JavaScript:openData('"+tableName+"')\">详细</a></center>";
		   //  cell.innerHTML="<center><a href=\"${contextPath}\/fpages\/datamodify\/ftl\/DataManageJgxxb.ftl\">详细</a></center>";
			//cell.innerHTML="<center>详细</center>";
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}	
	}
	
	function openData(tableName){
		if( tableName != null){
		   if (tableName == "EAST_YGB"){
		      window.location.href = "${contextPath}/fpages/datamodify/ftl/DataManageYgb.ftl";
		   } else if (id == "EAST_JGXXB"){
		      window.location.href = "${contextPath}/fpages/datamodify/ftl/DataManageJgxxb.ftl";
		   } else{
		   }
		} else{
		}
		
	}
</script>
</@CommonQueryMacro.page>