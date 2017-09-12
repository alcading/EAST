<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="境内汇款申请书-基础信息">
	<@CommonQueryMacro.CommonQueryTab id="BopEQDsCollectionTabs" navigate="false" currentTab="BopEDsCollection">
		<@CommonQueryMacro.CommonQuery id="BopEDsCollection" init="false" submitMode="all" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="9" showArrow="true" />
					</td>
		    	</tr>

		    	<tr>
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[100],filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[80],custype[80],idcode[100],custcod[80],custnm[80],oppuser[80],oppacc[80],txccy[80],txamt[80],exrate[80],lcyamt[80],lcyacc[80],fcyamt[80],fcyacc[80],othamt[80],method[80]" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">
		//工作日期
		function initCallGetter_post() {
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			BopEDsCollection_interface_dataset.setValue("qworkDateStart",currentDate);
			BopEDsCollection_interface_dataset.setValue("qworkDateEnd",currentDate);
		}
	    function datatable1_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var filler2 = record.getValue("filler2");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a></center>"
			} else {
				cell.innerHTML="&nbsp;";
			}
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
		function btAdd_onClick(button) {
			btNewClick();
		}
		
		//刷新数据
		function flushPage(){
			BopEDsCollection_dataset.flushData(1);
		}
		function locate(id) {
			var record = BopEDsCollection_dataset.find(["id"],[id]);
			if (record) {
				BopEDsCollection_dataset.setRecord(record);
			}
		}
		function btNewClick(){
			showWin("境内汇款申请书-基础信息增加","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopEDsCollectionInfo.ftl?op=add","window","flushPage()",window);
		}
		//修改
		function doCollection(id){
			showWin("境内汇款申请书-基础信息修改","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopEDsCollectionInfo.ftl?id=" + id + "&op=mod","window","flushPage()",window);
		}
		//删除
		function doDelete(id){
			showWin("境内汇款申请书-基础信息删除","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopEDsCollectionInfo.ftl?id=" + id + "&op=del","window","flushPage()",window);
		}
		//详细信息
		function doDetail(id){
			showWin("境内汇款申请书-基础信息明细","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopEDsCollectionInfo.ftl?id=" + id + "&op=det","window","flushPage()",window);
		}
	</script>
</@CommonQueryMacro.page>