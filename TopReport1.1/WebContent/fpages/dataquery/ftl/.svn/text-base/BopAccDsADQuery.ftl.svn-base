<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="账户开关信息">
<@CommonQueryMacro.CommonQueryTab id="bopAccDsQueryTabs" navigate="false" currentTab="BopAccDsADQuery">
	<@CommonQueryMacro.CommonQuery id="bopAccDsADQuery" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="brNo,brNoName[150],workDate[85],actiontype,recStatus[70],approveStatus,repStatus,accountno[200],currencyCode[100],accountstat,businessDate[85],amtype,enCode,enName,accountType[200],accountCata,fileNumber,limitType,accountLimit" hasFrame="true" width="900" height="260" readonly="true"/>

		      	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
</td></tr></table>
<script language="JavaScript">

	function initCallGetter_post(){
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		bopAccDsADQuery_interface_dataset.setValue("qstartDate", currentDate);
		bopAccDsADQuery_interface_dataset.setValue("qendDate", currentDate);
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
		showWin("开关账户明细","${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=detail");
	}
</script>
</@CommonQueryMacro.page>