<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="管理信息">
<@CommonQueryMacro.CommonQueryTab id="BopBhnDsAuditTabs" navigate="false" currentTab="BopBhnDsManageAudit">
<table width=""><tr><td>
	<@CommonQueryMacro.CommonQuery id="BopBhnDsManageAudit" init="false" submitMode="selected" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAudit" fieldStr="select[40],filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[80],country[80],paytype[80],txcode[80],tc1amt[100],txrem[80],txcode2[80],tc2amt[100],tx2rem[80],isref[80],crtuser[80],inptelc[100],rptdate[80],regno[80]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		   
		    <tr>
		    	<td>
		    		<@CommonQueryMacro.FloatWindow id="contractAuditSubWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
		      			<div align="center">
		      				<@CommonQueryMacro.Group id="group1" label="审核信息"
		        			  fieldStr="approveStatusChoose,approveResultChoose" colNm=2/>
		        			 </br>
		      				<center><@CommonQueryMacro.Button id="btAuditSave"/>&nbsp;&nbsp;
		      				<@CommonQueryMacro.Button id= "btBack"/></center>
		      			</div>
		     		</@CommonQueryMacro.FloatWindow>
		    	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</table></tr></td>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">
	var ds = BopBhnDsManageAudit_dataset;
	function initCallGetter_post() {
		//工作日期
		<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
		BopBhnDsManageAudit_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		BopBhnDsManageAudit_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
	}
	
	function datatable1_filler2_onRefresh(cell,value,record) {
		if(record && record != null) {
			var id = record.getValue("id");
			cell.innerHTML = "<center><a href=\"JavaScript:doDetail('"+id+"')\">"+value+"</a></center>";
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	//详细
	function doDetail(id) {
		showWin("管理信息详细","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsManageCollInfo.ftl?id="+id+"&op="+"detail","window","",window);
	}
	//刷新页面
	function flushPage() {
		ds.flushData(1);
	}
	
	function btAudit_onClick() {
		var hasSelect = false;
		var hasAudit = false;
		var record = ds.getFirstRecord();
		while(record) {
			var v_select = record.getValue("select");
			var v_approveStatus = record.getValue("approveStatus");
			if(v_select == true) {
				hasSelect = true;
				if(v_approveStatus != "00") {
					hasAudit = true;
				}
			}
			record = record.getNextRecord();
		}
		if(!hasSelect) {
			alert("请选择相应的记录！");
			return false;
		}
		if(hasAudit) {
			if(!confirm("所选记录包含已审核记录，确定要重新审核吗?")) {
				return false;
			}
		}
		subwindow_contractAuditSubWindow.show();
	}
	
	function btAuditSave_onClickCheck(button) {
		var approveStatusChoose = ds.getValue("approveStatusChoose");
		var approveResultChoose = ds.getValue("approveResultChoose");
		if(!approveStatusChoose.length > 0) {
			alert("请选择审核结果！");
	   		return false;
		}
		if (approveStatusChoose == "02" && approveResultChoose.length < 1)
		   	{
		   		alert("审核结果不通过，审核说明必须填写！");
		   		return false;
		   	}
		ds.setParameter("approveStatusChoose",approveStatusChoose);
		ds.setParameter("approveResultChoose",approveResultChoose);
		subwindow_contractAuditSubWindow.hide();
		return true;
	}
	//返回
	function btBack_onClick() {
		subwindow_contractAuditSubWindow.hide();
	}

	function btAuditSave_postSubmit(button){
		alert("保存成功");
		flushPage();
	}
</script>
</@CommonQueryMacro.page>