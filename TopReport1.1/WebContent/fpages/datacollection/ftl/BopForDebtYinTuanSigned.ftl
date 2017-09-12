<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BopForDebtYinTuanTabs" navigate="false" currentTab="BopForDebtYinTuanSigned">
		<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanSigned" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" hasFrame="true" fieldStr="opr[80],filler2[80],workDate[85],actiontype,recStatus[70],approveStatus,repStatus,exdebtcode,debtorcode,debtype,valuedate[85],contractcurr[100],contractamount,maturity[85],floatrate,anninrate,inprterm,spapfeboindex" readonly="true" hasFrame="true" width="900" height="260"/>
					</td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	
	<script language="JavaScript">

		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			bopForDebtYinTuanSigned_interface_dataset.setValue("qworkDateStart", currentDate);
			bopForDebtYinTuanSigned_interface_dataset.setValue("qworkDateEnd", currentDate);
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

		function datatable1_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + value + "</a>"
			} else {
				cell.innerHTML="&nbsp;";
			}
		}
		
		function btAdd_onClick(button) {
			btNewClick();
		}
		//新增
		function btNewClick(){
			showWin("银团贷款签约新增","${contextPath}/fpages/datacollection/ftl/BopForDebtYinTuanSignedAdd.ftl?op=new","report","flushPage()");
		}

		//刷新数据
		function flushPage(){
			bopForDebtYinTuanSigned_dataset.flushData(1);
		}

		//修改
		function doCollection(id){
			showWin("银团贷款签约信息修改","${contextPath}/fpages/datacollection/ftl/BopForDebtYinTuanSignedInfo.ftl?id=" + id + "&op=modify","report","flushPage()");
		}

		//删除
		function doDelete(id){
			showWin("银团贷款签约信息删除","${contextPath}/fpages/datacollection/ftl/BopForDebtYinTuanSignedInfo.ftl?id=" + id + "&op=delete","report","flushPage()");
		}

		//详细信息
		function doDetail(id){
			showWin("银团贷款签约信息明细","${contextPath}/fpages/datacollection/ftl/BopForDebtYinTuanSignedInfo.ftl?id=" + id + "&op=detail");
		}
	</script>
</@CommonQueryMacro.page>