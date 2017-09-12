<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="管理信息">
<@CommonQueryMacro.CommonQueryTab id="BopBhnDsQueryTabs" navigate="false" currentTab="BopBhnDsManageQuery">
	<@CommonQueryMacro.CommonQuery id="BopBhnDsManageQuery" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[120],rptno,contrno[100],invoino[100],crtuser[80],inptelc[100],rptdate[80]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
</td></tr></table>
<script language="JavaScript">
	//工作日期
	function initCallGetter_post(){
		<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
		BopBhnDsManageQuery_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		BopBhnDsManageQuery_interface_dataset.setValue("qworkDateEnd","${v_txdate}");	
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
		showWin("管理信息详细","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsManageCollInfo.ftl?id="+id+"&op="+"detail","window","flushPage()",window);
	}
</script>
</@CommonQueryMacro.page>