<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="账户开关信息">

<@CommonQueryMacro.CommonQueryTab id="BOPForDebtAndSubSidGenTabs" navigate="false" currentTab="BOPForDebtAndSubSidGen">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtAndSubSidGen" init="false" submitMode="selected" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[180],brNo,brNoName,actiontype[80],exdebtcode[180],limitType[100],debtorcode[120],debtype[80],valuedate[100],contractcurr[80],floatrate[80],anninrate[80],creditorcode[80],creditorname[80],creditornamen[80],creditortype[80],spapfeboindex[80],crehqcode,opercode" hasFrame="true" width="900" height="260" readonly="true"/>
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
			var filler2 = record.getValue("filler2");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a>";
		} else {//当不存在记录时
		 	cell.innerHTML="&nbsp;";
		}
	}
	
	function doDetail(id){
		showWin("境外联行及附属机构往来签约信息","${contextPath}/fpages/datacollection/ftl/BopForCorAndAffOrgContactInfo.ftl?id=" + id + "&op=detail");
	}
</script>
</@CommonQueryMacro.page>