<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="变动信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCfaDofoexloDsAuditTabs" navigate="false" currentTab="BopCfaDofoexloDsChangeInfoAudit">
		<@CommonQueryMacro.CommonQuery id="BopCfaDofoexloDsChangeInfoAudit" init="false" submitMode="selected" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
					</td>
	    		</tr>

	    		<tr>
	    			<td colspan="2">
						<@CommonQueryMacro.DataTable id ="BopCfaDofoexloDsChangeInfoAuditTable" hasFrame="true" paginationbar="btApproved"
							fieldStr="select[60],filler2,workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],dofoexlocode[130],buscode[130],changeno,loanopenbalan[100],changedate[100],withcurrence[150],withamount[100],settamount[100]" readonly="true" hasFrame="true" width="900" height="260"/>
	      			</td>
	    		</tr>

	    		<tr>
					<td>
						<@CommonQueryMacro.FloatWindow id="aditADSubWindow" label="审核信息" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
							<div align="center">
								<@CommonQueryMacro.Group id="group1" label="审核信息" fieldStr="approveStatusChoose,approveResultChoose" colNm=2/>
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

		function initCallGetter_post(){
			<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
			BopCfaDofoexloDsChangeInfoAudit_interface_dataset.setValue("qstartDate", "${workdate}");
			BopCfaDofoexloDsChangeInfoAudit_interface_dataset.setValue("qendDate", "${workdate}");	
		}
		
		//当系统刷新单元格的内容时被触发
		function BopCfaDofoexloDsChangeInfoAuditTable_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var recStatus = record.getValue("recStatus");
				cell.innerHTML = "<center><a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">"+value+"</a></center>";
			} else {
				//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}

		//查询
		function doDetail(id){
			showWin("变动信息查询","${contextPath}/fpages/datacollection/ftl/BopCfaDofoexloDsChangeInfoAdd.ftl?op=detail&id="+id,"report","flushPage()");
		}

		//刷新数据
		function flushPage(){
			BopCfaDofoexloDsChangeInfoAudit_dataset.flushData(1);
		}

		function btSave_postSubmit(buttno) {
			subwindow_aditADSubWindow.close();
			flushCurrentPage();
			alert("保存成功");
		}

		function btApproved_onClickCheck(button) {

			var hasSelected = false;
			var hasAudit = false;
			var record = BopCfaDofoexloDsChangeInfoAudit_dataset.getFirstRecord();
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

			var status = BopCfaDofoexloDsChangeInfoAudit_dataset.getValue("approveStatusChoose");
			var result = BopCfaDofoexloDsChangeInfoAudit_dataset.getValue("approveResultChoose");
			if (!status.length > 0) {
	   			alert("请选择审核结果！");
	   			return false;
	   		}
	   		if (status == "02" && result.length < 1) {
	   			alert("审核结果不通过，审核说明必须填写！");
	   			return false;
			}

			BopCfaDofoexloDsChangeInfoAudit_dataset.setParameter("approveStatusChoose",status);
			BopCfaDofoexloDsChangeInfoAudit_dataset.setParameter("approveResultChoose",result);
			return true;
		}

		//刷新当前页
		function flushCurrentPage() {
			BopCfaDofoexloDsChangeInfoAudit_dataset.flushData(BopCfaDofoexloDsChangeInfoAudit_dataset.pageIndex);
		}

		function btApproved_onClick() {
			subwindow_aditADSubWindow.show();
		}

		function btClose_onClick() {
			subwindow_aditADSubWindow.hide();
		}
	</script>
</@CommonQueryMacro.page>