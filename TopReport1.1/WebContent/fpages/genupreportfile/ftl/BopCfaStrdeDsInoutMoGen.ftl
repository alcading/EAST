<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="资金流出入和结购汇信息">
<@CommonQueryMacro.CommonQueryTab id="bopCfaStrdeDsGenTabs" navigate="false" currentTab="bopCfaStrdeDsInoutMoGen">
<table width=""><tr><td>
	<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsInoutMoGen" init="false" submitMode="selected" navigate="false" >
		<table align="left">
			<tr>
				<td colspan="2">
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
				</td>
		    </tr>
		    <tr>
		    	<td colspan="2">
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],brNo[150],brNoName[150],workDate[100],buocmonth[100],currency[200],moexamusd,moamreusd,mopfexamusd,mosettamusd,remark[300]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</table></tr></td>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">
	var ds = bopCfaStrdeDsInoutMoGen_dataset;
	function initCallGetter_post() {
		//向getter类发送参数
		ds.setParameter("getType","inoutMo");
	}
	
	function datatable1_filler2_onRefresh(cell,value,record) {
		if(record && record != null) {
			var id = record.getValue("id");
			cell.innerHTML = "<center><a href=\"JavaScript:doDetail('"+id+"')\">"+value+"</a></center>";
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	//详细
	function doDetail(id) {
		showWin("资金流出入和结购汇信息详细","${contextPath}/fpages/datacollection/ftl/BopCfaStrdeDsEntryInoutMoInfo.ftl?id="+id+"&op="+"detail");
	}
</script>
</@CommonQueryMacro.page>