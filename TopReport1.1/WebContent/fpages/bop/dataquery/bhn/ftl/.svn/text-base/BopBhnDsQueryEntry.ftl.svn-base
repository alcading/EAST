<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BopBhnDsQueryTabs" navigate="false" currentTab="BopBhnDsQueryEntry">
		<@CommonQueryMacro.CommonQuery id="BopBhnDsQueryEntry" init="false" submitMode="all" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[120],rptno[80],custype[80],idcode[150],custcod[80],custnm[100],oppuser[150],txccy[150],txamt[100],exrate[100],txamt[100],lcyacc[150],fcyamt[100],fcyacc[150],othamt[100],othacc[150],method[100]" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
		var ds = BopBhnDsQueryEntry_dataset;
		function initCallGetter_post() {
			//起始工作日期默认当前日期
			<#assign v_date = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BopBhnDsQueryEntry_interface_dataset.setValue("qworkDateStart","${v_date}");
			BopBhnDsQueryEntry_interface_dataset.setValue("qworkDateEnd","${v_date}");
			//向后台getter类发送参数
			ds.setParameter("getType","contract");
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
			showWin("基础信息详细","${contextPath}/fpages/bop/collandaudit/bhn/ftl/BopBhnDsCollInfo.ftl?id="+id+"&op="+"detail","window","",window);
		}
	</script>
</@CommonQueryMacro.page>