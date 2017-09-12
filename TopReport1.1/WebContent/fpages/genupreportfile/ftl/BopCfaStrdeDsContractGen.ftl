<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQueryTab id="bopCfaStrdeDsGenTabs" navigate="false" currentTab="bopCfaStrdeDsContractGen">
<table width=""><tr><td>
	<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsContractGen" init="false" submitMode="selected" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],brNo[150],brNoName[150],workDate[100],actiontype[80],strdecode[250],branchcode[120],clientcode[100],clientname[100],contractdate[100],contract[280],contractamount[100],maturity[100],lincame[200],lincamethod[200],aginraup[120],aginralo[120],aginraloinpay[200],remark[300]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</table></tr></td>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">
	var ds = bopCfaStrdeDsContractGen_dataset;
	function initCallGetter_post() {
		//向getter类发送参数
		ds.setParameter("getType","contract");
	}
	
	function datatable1_filler2_onRefresh(cell,value,record) {
		if(record) {
			var id = record.getValue("id");
			cell.innerHTML = "<center><a href=\"JavaScript:doDetail('"+id+"')\">"+value+"</a></center>";
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	//详细
	function doDetail(id) {
		showWin("签约信息详细","${contextPath}/fpages/datacollection/ftl/BopCfaStrdeDsEntryADInfo.ftl?id="+id+"&op="+"detail");
	}
</script>
</@CommonQueryMacro.page>