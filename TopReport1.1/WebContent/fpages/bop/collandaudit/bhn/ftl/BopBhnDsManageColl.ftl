<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="申报信息">
<@CommonQueryMacro.CommonQueryTab id="BopBhnDsCollTabs" navigate="false" currentTab="BopBhnDsManageColl">
	<@CommonQueryMacro.CommonQuery id="BopBhnDsManageColl" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="operation[100],filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[100],contrno[100],invoino[100],crtuser[80],inptelc[100],rptdate[80]" hasFrame="true" width="900" height="260" readonly="true"/>
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
		BopBhnDsManageColl_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		BopBhnDsManageColl_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
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
		showWin("管理信息详细","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsManageCollInfo.ftl?id="+id+"&op="+"detail","window","flushPage()",window);
	}
	//新增
	function btNewClick() {
		showWin("管理信息新增","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsManageCollInfo.ftl?op=add","window","flushPage()",window);
	}
	//修改
	function doMod(id) {
		showWin("管理信息修改","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsManageCollInfo.ftl?op=mod&id="+id,"window","flushPage()",window);
	}
	//删除
	function doDel(id) {
		showWin("管理信息删除","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsManageCollInfo.ftl?op=del&id="+id,"window","flushPage()",window);
	}
	//刷新页面
	function flushPage() {
		BopBhnDsManageColl_dataset.flushData(1);
	}
</script>
</@CommonQueryMacro.page>