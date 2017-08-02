<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="终止信息">
	<@CommonQueryMacro.CommonQueryTab id="bopCfaStrdeDsQueryTabs" navigate="false" currentTab="bopCfaStrdeDsTerminateQuery">
		<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsTerminateQuery" init="false" submitMode="all" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],apptype[120],currentfile[230],strdecode[250],branchcode[120],tertype[80],terpaycode,contract[280],terdate[100],terpayamtormb,terrmbpayam,terpaycurr[150],terpaycurram,remark[300]" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
		var ds = bopCfaStrdeDsTerminateQuery_dataset;
		function initCallGetter_post() {
			//起始工作日期默认当前日期
			<#assign v_date = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			bopCfaStrdeDsTerminateQuery_interface_dataset.setValue("qworkDateStart","${v_date}");
			bopCfaStrdeDsTerminateQuery_interface_dataset.setValue("qworkDateEnd","${v_date}");
			ds.setParameter("getType","terminate");
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
			showWin("终止信息详细","${contextPath}/fpages/datacollection/ftl/BopCfaStrdeDsEntryTerminateInfo.ftl?id="+id+"&op="+"detail");
		}
	</script>
</@CommonQueryMacro.page>