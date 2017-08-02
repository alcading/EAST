<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="基础信息">
<@CommonQueryMacro.CommonQueryTab id="JshDfDsQueryTabs" navigate="false" currentTab="JshDfDsQueryEntry">
<table width=""><tr><td>
	<@CommonQueryMacro.CommonQuery id="JshDfDsQueryEntry" init="false" submitMode="all" navigate="false" >
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
				<td align="right">
	    		<a href="JavaScript:btNewClick()">新增</a>
	        	</td>
		    </tr>
		    <tr>
		    	<td colspan="2">
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[80],rptno[80],custype[80],custcod[80],idcode[100],custnm[80],fcyacc[80],lcyacc[80],oppuser[80],oppbank[250],fcyamt[80],fcyccy[150],exrate[80]" hasFrame="true" width="900" height="260" readonly="true"/>
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
		JshDfDsQueryEntry_interface_dataset.setValue("qworkDateStart","${v_txdate}");
		JshDfDsQueryEntry_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
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
		showWin("基础信息详细","${contextPath}/fpages/jsh/collandaudit/df/ftl/JshDfDsCollInfo.ftl?id="+id+"&op="+"detail","window","",window);
	}
</script>
</@CommonQueryMacro.page>