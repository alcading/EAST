<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="申报信息">
<@CommonQueryMacro.CommonQueryTab id="BopBhnDsQueryTabs" navigate="false" currentTab="BopBhnDsReportQuery">
	<@CommonQueryMacro.CommonQuery id="BopBhnDsReportQuery" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[120],rptno[100],country[150],paytype[80],txcode[250],tc1amt[100],txrem[150],txcode2[250],tc2amt[100],tx2rem[150],isref[80],crtuser[80],inptelc[100],rptdate[80],regno[80]" hasFrame="true" width="900" height="260" readonly="true"/>
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
		BopBhnDsReportQuery_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		BopBhnDsReportQuery_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
	}

	//刷新操作内容
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
		showWin("申报信息详细","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsReportCollInfo.ftl?id="+id+"&op="+"detail","window","flushPage()",window);
	}
</script>
</@CommonQueryMacro.page>