<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="基础信息">
<@CommonQueryMacro.CommonQueryTab id="BopBhnDsCollTabs" navigate="false" currentTab="BopBhnDsCollEntry">
<table width=""><tr><td>
	<@CommonQueryMacro.CommonQuery id="BopBhnDsCollEntry" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="operation[100],filler2[80],buscode[100],workDate[100],recStatus[70],approveStatus,repStatus,actiontype,actiondesc[100],rptno[80],custype[80],idcode[150],custcod[80],custnm[100],oppuser[100],txccy[150],txamt[100],exrate[100],txamt[100],lcyacc[150],fcyamt[100],fcyacc[150],othamt[100],othacc[150],method[100]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</table></tr></td>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">
	function initCallGetter_post() {
		//工作日期
		<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
		BopBhnDsCollEntry_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		BopBhnDsCollEntry_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
	}
	//刷新操作内容
	function datatable1_operation_onRefresh(cell,value,record) {
		if(record) {
			var actiontype = record.getValue("actiontype");
			if(actiontype == "D") {
				cell.innerHTML="<center><a href=\"#\" style=\"color:#999999\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDel('"+value+"')\">删除</a></center>";
			} else {
				cell.innerHTML="<center><a href=\"JavaScript:doMod('"+value+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDel('"+value+"')\">删除</a></center>";
			}
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	
	function datatable1_filler2_onRefresh(cell,value,record) {
		if(record && record != null) {
			var id = record.getValue("id");
			cell.innerHTML = "<center><a style=\"text-decoration:none\" href=\"JavaScript:doDetail('"+id+"')\">"+value+"</a></center>";
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	
	function btAdd_onClick(button) {
		btNewClick();
	}
	//详细
	function doDetail(id) {
		showWin("基础信息详细","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsCollInfo.ftl?id="+id+"&op="+"detail","window","",window);
	}
	//新增
	function btNewClick() {
		showWin("基础信息新增","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsCollInfo.ftl?op=add","window","flushPage()",window);
	}
	//修改
	function doMod(id) {
		showWin("基础信息修改","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsCollInfo.ftl?op=mod&id="+id,"window","flushPage()",window);
	}
	//删除
	function doDel(id) {
		showWin("基础信息删除","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsCollInfo.ftl?op=del&id="+id,"window","flushPage()",window);
	}
	//刷新页面
	function flushPage() {
		BopBhnDsCollEntry_dataset.flushData(1);
	}
</script>
</@CommonQueryMacro.page>