<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="账户收支余信息">

<@CommonQueryMacro.CommonQueryTab id="bopAccDsQueryTabs" navigate="false" currentTab="BopAccDsInOutQuery">
	<@CommonQueryMacro.CommonQuery id="bopAccDsInOutQuery" init="false" submitMode="all" navigate="false" >
		<table align="left">
			<tr>
				<td >
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
				</td>
		    </tr>
		    <tr>
		    	<td >
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="brNo,brNoName[150],workDate[85],actiontype,recStatus[70],approveStatus,repStatus,accountno[200],currencyCode[100],dealDate[85],credit,debit,balance" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">

	function initCallGetter_post(){
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		bopAccDsInOutQuery_interface_dataset.setValue("qstartDate", currentDate);
		bopAccDsInOutQuery_interface_dataset.setValue("qendDate", currentDate);
	}

	function datatable1_accountno_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			var accountno = record.getValue("accountno");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + accountno + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}

	//详细信息
	function doDetail(id){
		showWin("账户收支余明细","${contextPath}/fpages/datacollection/ftl/BopAccDsRecordInOutInfo.ftl?id=" + id + "&op=detail","report","flushPage()");
	}
</script>
</@CommonQueryMacro.page>