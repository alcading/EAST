<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="账户开关信息">
	<@CommonQueryMacro.CommonQueryTab id="bopAccDsAuditTabs" navigate="false" currentTab="BopAccDsAuditAD">
		<@CommonQueryMacro.CommonQuery id="bopAccDsAuditAD" init="false" submitMode="selected" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="select[40],workDate[85],actiontype,recStatus[70],approveStatus,repStatus,accountno[200],currencyCode[100],accountstat,businessDate[85],amtype,enCode,enName,accountType[200],accountCata,fileNumber,limitType,accountLimit" hasFrame="true" width="900" height="260" readonly="true"/>
			      	</td>
			    </tr>

			    <tr>
			    	<td>
			    		<@CommonQueryMacro.Button id="btAudit"/>
			    	</td>
			    </tr>

			    <tr>
			    	<td>
			    		<@CommonQueryMacro.FloatWindow id="aditADSubWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
			      			<div align="center">
			      				<@CommonQueryMacro.Group id="group1" label="审核信息"
									fieldStr="approveStatusChoose,approveResultChoose" colNm=2/>
			        			 </br>
			      				<center>
			      					<@CommonQueryMacro.Button id= "btAuditSave"/>&nbsp;&nbsp;
			      					<@CommonQueryMacro.Button id= "btBack"/>
			      				</center>
			      			</div>
			     		</@CommonQueryMacro.FloatWindow>
			    	</td>
			    </tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
	
		function initCallGetter_post() {
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			bopAccDsAuditAD_interface_dataset.setValue("qstartDate", currentDate);
			bopAccDsAuditAD_interface_dataset.setValue("qendDate", currentDate);
		}
	
		//当系统刷新单元格的内容时被触发
		function datatable1_accountno_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var accountno = record.getValue("accountno");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + accountno + "</a>";
			} else {//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}
		
		function btAuditSave_onClickCheck() {
		
		   	var approveStatusChoose = bopAccDsAuditAD_dataset.getValue("approveStatusChoose");
		   	var approveResultChoose = bopAccDsAuditAD_dataset.getValue("approveResultChoose");
		   	if (!approveStatusChoose.length > 0) {
		   		alert("请选择审核结果！");
		   		return false;
		   	}
		   	if (approveStatusChoose == "02" && approveResultChoose.length < 1) {
		   		alert("审核结果不通过，审核说明必须填写！");
		   		return false;
		   	}
		   	bopAccDsAuditAD_dataset.setParameter("approveStatusChoose",approveStatusChoose);
		   	bopAccDsAuditAD_dataset.setParameter("approveResultChoose",approveResultChoose);
			subwindow_aditADSubWindow.hide();
		}
		
		function btAuditSave_postSubmit(button) {
			alert("保存成功");
			bopAccDsAuditAD_dataset.flushData(1);
		}
		
		function btAudit_onClick() {
			var hasSelected = false;
			var hasAudit = false;
			var record = bopAccDsAuditAD_dataset.getFirstRecord();
			while(record) {
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
		   		if(!confirm("所选记录包含已审核记录，确定需重新审核吗？"))
				{
					return false;
				}
		   	}
			subwindow_aditADSubWindow.show();
		}
		
		function btBack_onClick() {
			subwindow_aditADSubWindow.hide();
		}
		
		function doDetail(id) {
			//window.location.href = "${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=detail";
			showWin("开关账户明细","${contextPath}/fpages/datacollection/ftl/BopAccDsRecordADInfo.ftl?id=" + id + "&op=detail");
		}
	</script>
</@CommonQueryMacro.page>