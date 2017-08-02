<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="对外担保信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCFAExguTabs" navigate="false" currentTab="BOPForCFAExguDsInfo">
		<@CommonQueryMacro.CommonQuery id="BOPForCFAExguDsInfo" init="false" submitMode="all" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[80],filler2[80],brNo[80],brNoName[80],workDate[80],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exguarancode[80],guarantorcode[80],guarantype[80],appdocuno[80],contractdate[80],maturity[80],guarancurr[80],maindebtcurr[80],guaranamount[80],maindebtamount[80],guappcode[80],guappname[80],guappnamen[80],remark[80],actiondesc[80]" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">
		//工作日期
		function initCallGetter_post() {
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BOPForCFAExguDsInfo_interface_dataset.setValue("qstartDate","${v_txdate}");
			BOPForCFAExguDsInfo_interface_dataset.setValue("qendDate","${v_txdate}");
		}
	    function datatable1_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var filler2 = record.getValue("filler2");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a>"
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
		//刷新数据
		function flushPage(){
			BOPForCFAExguDsInfo_dataset.flushData(1);
		}
		function locate(id) {
			var record = BOPForCFAExguDsInfo_dataset.find(["id"],[id]);
			if (record) {
				BOPForCFAExguDsInfo_dataset.setRecord(record);
			}
		}
		
		function btAdd_onClick(button) {
			btNewClick();
		}
		function btNewClick(){
			showWin("对外担保签约信息","${contextPath}/fpages/datacollection/ftl/BopForCFAExguDsAdd.ftl?op=new","report","flushPage()");
		}
		//修改
		function doCollection(id){
			showWin("对外担保签约信息修改","${contextPath}/fpages/datacollection/ftl/BopForCFAExguDsAdd.ftl?id=" + id + "&op=mod","report","flushPage()");
		}
		//删除
		function doDelete(id){
			showWin("对外担保签约信息删除","${contextPath}/fpages/datacollection/ftl/BopForCFAExguDsAdd.ftl?id=" + id + "&op=del","report","flushPage()");
		}
		//详细信息
		function doDetail(id){
			showWin("对外担保签约信息明细","${contextPath}/fpages/datacollection/ftl/BopForCFAExguDsAdd.ftl?id=" + id + "&op=detail");
		}
	</script>
</@CommonQueryMacro.page>