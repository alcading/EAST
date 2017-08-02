<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="终止信息">
<@CommonQueryMacro.CommonQueryTab id="bopCfaStrdeDsEntryTabs" navigate="false" currentTab="bopCfaStrdeDsEntryTerminate">
	<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsEntryTerminate" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="operation[100],filler2[80],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],strdecode[250],branchcode[120],tertype[80],terpaycode,contract[280],terdate[100],terpayamtormb,terrmbpayam,terpaycurr[150],terpaycurram,remark[300]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
</td></tr></table>
<script language="JavaScript">
	function initCallGetter_post() {
		//工作日期
		<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
		bopCfaStrdeDsEntryTerminate_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		bopCfaStrdeDsEntryTerminate_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
	}
	//刷新操作内容
	function datatable1_operation_onRefresh(cell,value,record) {
		if(record) {
			cell.innerHTML="<center><a href=\"JavaScript:doMod('"+value+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDel('"+value+"')\">删除</a></center>";
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	function datatable1_filler2_onRefresh(cell,value,record) {
		if(record && record != null) {
			var id = record.getValue("id");
			cell.innerHTML = "<center><a href=\"JavaScript:doDetail('"+id+"')\">"+value+"</a></center>";
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	
	function btAdd_onClick(button) {
			btNewClick();
	}
	//详细
	function doDetail(id) {
		showWin("终止信息详细","${contextPath}/fpages/datacollection/ftl/BopCfaStrdeDsEntryTerminateInfo.ftl?id="+id+"&op="+"detail");
	}
	//新增
	function btNewClick() {
		showWin("终止信息新增","${contextPath}/fpages/datacollection/ftl/BopCfaStrdeDsEntryTerminateAdd.ftl?op=add","report","flushPage()");
	}
	//修改
	function doMod(id) {
		showWin("终止信息修改","${contextPath}/fpages/datacollection/ftl/BopCfaStrdeDsEntryTerminateInfo.ftl?op=mod&id="+id,"report","flushPage()");
	}
	//删除
	function doDel(id) {
		showWin("终止信息删除","${contextPath}/fpages/datacollection/ftl/BopCfaStrdeDsEntryTerminateInfo.ftl?op=del&id="+id,"report","flushPage()");
	}
	//刷新页面
	function flushPage() {
		bopCfaStrdeDsEntryTerminate_dataset.flushData(1);
	}
</script>
</@CommonQueryMacro.page>