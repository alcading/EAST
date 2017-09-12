<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="账户开关信息">

<@CommonQueryMacro.CommonQueryTab id="BOPForDebtNobleMetalGenTabs" navigate="false" currentTab="BOPForDebtNobleMetalGenChange">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtNobleMetalGenChange" init="false" submitMode="selected" navigate="false" >
		<table align="left">
			<tr>
				<td>
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
				</td>
		    </tr>
		    <tr>
		    	<td>
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],brNo,brNoName,workDate[100],exdebtcode[190],buscode[120],changeno[80],changtype[120],chdate[120],chcurrency[140],chamount[120],fairvalue[120]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		   
		  
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">
	
	//当系统刷新单元格的内容时被触发
	function datatable1_filler2_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + value + "</a>";
		} else {//当不存在记录时
		 	cell.innerHTML="&nbsp;";
		}
	}

	function doDetail(id){
		showWin("贵金属拆借签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtNobleMetalLendingChangeInfoCol.ftl?id=" + id + "&op=detaile");
	}
</script>
</@CommonQueryMacro.page>