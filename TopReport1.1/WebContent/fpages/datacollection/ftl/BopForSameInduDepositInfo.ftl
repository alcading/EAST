<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BopForSameInduDepositTabs" navigate="false" currentTab="BopForSameInduDepositInfo">
		<@CommonQueryMacro.CommonQuery id="BopForSameInduDepositInfo" init="false" submitMode="all" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface"  label="请输入查询条件" />
					</td>
				</tr>

				<tr>
  			  		<td>
  			    		<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"   pageCache="false" showArrow="true"/>
  			  		</td>
  			 	</tr>

  			 	<tr>
		      		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[100],filler2[80],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],debtorcode[120],debtype[180],valuedate[100],contractcurr[80],floatrate[80],anninrate[80],creditorcode,creditorname,creditornamen,creditortype[230],crehqcode,opercode" readonly="true" hasFrame="true" width="1000" height="260"/>
		      		</td>
		      	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
		
		function initCallGetter_post() {
			//工作日期
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BopForSameInduDepositInfo_interface_dataset.setValue("qworkDateStart","${v_txdate}");
			BopForSameInduDepositInfo_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
		}
		
		//当系统刷新单元格的内容时被触发
		function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
				var id = record.getValue("id");
				var innerStr = "";
				var recStatus = record.getValue("recStatus");
				if (recStatus == "01" || recStatus == "02"   ) {
					innerStr = innerStr + "<a href=\"JavaScript:doModify('"+id+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDel('"+id+"')\">删除</a>"
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
				var filler2 = record.getValue("filler2");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a>"
			} else {
				cell.innerHTML="&nbsp;";
			}
		}
		
		function btAdd_onClick(button) {
			btNewClick();
		}
		
		function doModify(id){
				//window.location.href = "${contextPath}/fpages/datacollection/ftl/BOPCfaLounexguRecordEdit.ftl?id=" + id+"&op=mod";
				showWin("签约信息修改","${contextPath}/fpages/datacollection/ftl/BopForSameInduDepositInfoCol.ftl?id=" + id+"&op=mod","report","flushPage()");
		}
		function btNewClick(){
			showWin("签约信息新增","${contextPath}/fpages/datacollection/ftl/BopForSameInduDepositInfoCol.ftl?op=new","report","flushPage()");
		}
		function doDel(id){
			showWin("签约信息删除","${contextPath}/fpages/datacollection/ftl/BopForSameInduDepositInfoCol.ftl?id=" + id+"&op=del","flushPage()");
		}
		//详细信息
		function doDetail(id){
			showWin("签约信息明细","${contextPath}/fpages/datacollection/ftl/BopForSameInduDepositInfoCol.ftl?id=" + id + "&op=detail");
		}
		function flushPage(){
			BopForSameInduDepositInfo_dataset.flushData(1);
		}
	</script>
</@CommonQueryMacro.page>