<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="账户开关信息">
	<@CommonQueryMacro.CommonQueryTab id="bopAccDsRecordTabs" navigate="false" currentTab="BopAccDsRecordAD">
		<@CommonQueryMacro.CommonQuery id="bopAccDsRecordAD" init="false" submitMode="all" navigate="false">
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
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[80],workDate[85],actiontype,recStatus[70],approveStatus,repStatus,accountno[200],currencyCode[100],accountstat,businessDate[85],amtype,enCode,enName,accountType[200],accountCata,fileNumber,limitType,accountLimit" hasFrame="true" width="900" height="260" readonly="true"/>
			      	</td>
			    </tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">
		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			bopAccDsRecordAD_interface_dataset.setValue("qstartDate", currentDate);
			bopAccDsRecordAD_interface_dataset.setValue("qendDate", currentDate);
		}

		//当系统刷新单元格的内容时被触发
		function datatable1_opr_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var recStatus = record.getValue("recStatus");
				var innerStr = "<center>";
				if (recStatus == "01" || recStatus == "02") {
					innerStr = innerStr + "<a href=\"JavaScript:doCollection('"+id+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDelete('"+id+"')\">删除</a>"
				} else {
					innerStr = innerStr + "<a title='该记录状态不可修改' style='color:#999999'>修改</a>&nbsp;&nbsp;<a title='该记录状态不可删除' style='color:#999999'>删除</a>";
				}
				innerStr = innerStr + "</center>";

				cell.innerHTML =innerStr;
			} else {//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
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
		
		function btAdd_onClick(button) {
			btNewClick();
		}
		//新增
		function btNewClick(){
			showWin("开关账户新增","${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADAdd.ftl","report","flushPage()");
			//window.location.href = "${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADAdd.ftl";
		}

		//刷新数据
		function flushPage(){
			bopAccDsRecordAD_dataset.flushData(1);
		}

		//修改
		function doCollection(id){
			//window.location.href = "${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=modify";
			showWin("开关账户修改","${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=modify","report","flushPage()");
		}

		//删除
		function doDelete(id){
			//window.location.href = "${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=delete";
			showWin("开关账户删除","${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=delete","report","flushPage()");
		}

		//详细信息
		function doDetail(id){
			//window.location.href = "${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=detail";
			showWin("开关账户明细","${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=detail");
		}
	</script>
</@CommonQueryMacro.page>