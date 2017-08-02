<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BOPForDebtOtherDebtsAuditTabs" navigate="false" currentTab="BOPForDebtOtherDebtsAudit">
		<@CommonQueryMacro.CommonQuery id="BOPForDebtOtherDebtsAudit" init="false" submitMode="selected" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td>
	  			    	<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btApproved" fieldStr="select[40],filler2,workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],debtorcode[120],debtype[80],valuedate[100],contractcurr[150],contractamount[100],maturity[100],anninrate[100],inprterm,spapfeboindex" readonly="true" hasFrame="true" width="900" height="260"/>
					</td>
				</tr>

				<tr>
					<td width="500">
						<@CommonQueryMacro.FloatWindow id="aditADSubWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
							<div align="center">
								<@CommonQueryMacro.Group id="group1" label="审核信息"  fieldStr="approveStatusChoose,approveResultChoose" colNm=2/>
								</br>
								<center>
									<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
				      				<@CommonQueryMacro.Button id= "btClose"/>
				      			</center>
				      		</div>
				     	</@CommonQueryMacro.FloatWindow>
				    </td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">

		//工作日期
		function initCallGetter_post(){
			<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BOPForDebtOtherDebtsAudit_interface_dataset.setValue("startdate","${workdate}");
			BOPForDebtOtherDebtsAudit_interface_dataset.setValue("enddate","${workdate}");		
		}
		//当系统刷新单元格的内容时被触发
		function datatable1_opr_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var recStatus = record.getValue("recStatus");
				var innerStr = "<center>";
				if (recStatus == "01" || recStatus == "02") {
					innerStr = innerStr + "<a href=\"JavaScript:doModify('"+id+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDelete('"+id+"')\">删除</a>"
				} else {
					innerStr = innerStr + "<a title='该记录状态不可修改' style='color:#999999'>修改</a>&nbsp;&nbsp;<a title='该记录状态不可删除' style='color:#999999'>删除</a>";
				}
				innerStr = innerStr + "</center>";

				cell.innerHTML =innerStr;
			} else {//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}

		function locate(id) {

			var record = BOPForDebtOtherDebtsAudit_dataset.find(["id"],[id]);
			if (record) {
				BOPForDebtOtherDebtsAudit_dataset.setRecord(record);
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

		//详细
		function doDetail(id) {
			locate(id);
			showWin("其他外债签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOtherDebtsCol.ftl?id="+id+"&op=detaile","report","flushCurrentPage()");
		}

		function btSave_postSubmit(buttno) {
			subwindow_aditADSubWindow.close();
			flushCurrentPage();
			alert("保存成功");
		}

		function btApproved_onClickCheck(button) {
			var hasSelected = false;
			var hasAudit = false;
			var record = BOPForDebtOtherDebtsAudit_dataset.getFirstRecord();
			while(record){
				var v_selected = record.getValue("select");
				var v_approveStatus = record.getValue("approveStatus");
				if( v_selected == true ){
					hasSelected=true;
					if (v_approveStatus != "00") {
						hasAudit = true;
					}
				}
				record=record.getNextRecord();
	   		}
	   		if (!hasSelected) {
	   			alert("请选择相应的记录！");
	   			return false;
	  	 	}
	  	 	if (hasAudit) {
	   			if(!confirm("所选记录包含已审核记录，确定需重新审核吗？")) {
					return false;
				}
	   		}
		}

		function btSave_onClickCheck(button) {

			var status = BOPForDebtOtherDebtsAudit_dataset.getValue("approveStatusChoose");
			var result = BOPForDebtOtherDebtsAudit_dataset.getValue("approveResultChoose");
			if (!status.length > 0) {
	   			alert("请选择审核结果！");
	   			return false;
	   		}
	   		if (status == "02" && result.length < 1) {
	   			alert("审核结果不通过，审核说明必须填写！");
	   			return false;
			}
			BOPForDebtOtherDebtsAudit_dataset.setParameter("approveStatusChoose",status);
			BOPForDebtOtherDebtsAudit_dataset.setParameter("approveResultChoose",result);
			return true;
		}

		//刷新当前页
		function flushCurrentPage() {
			BOPForDebtOtherDebtsAudit_dataset.flushData(1);
		}

		function btApproved_onClick() {
			subwindow_aditADSubWindow.show();
		}

		function btClose_onClick() {
			subwindow_aditADSubWindow.hide();
		}

	</script>
</@CommonQueryMacro.page>