<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="境内汇款申请书-基础信息">
	<@CommonQueryMacro.CommonQueryTab id="BopEQDsQueryTabs" navigate="false" currentTab="BopEDsQuery">
		<@CommonQueryMacro.CommonQuery id="BopEDsQuery" init="false" submitMode="current" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td colspan="2" valign="top">
						<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
					</td>
	    		</tr>

	    		<tr>
	    			<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[120],rptno[80],custype[80],idcode[100],custcod[80],custnm[80],oppuser[80],oppacc[80],txccy[80],txamt[80],exrate[80],lcyamt[80],lcyacc[80],fcyamt[80],fcyacc[80],othamt[80],method[80]" hasFrame="true" width="900" height="260" readonly="true"/>
	      			</td>
	    		</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
		//工作日期
		function initCallGetter_post() {
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			BopEDsQuery_interface_dataset.setValue("qWorkDateStart",currentDate);
			BopEDsQuery_interface_dataset.setValue("qWorkDateEnd",currentDate);
		}

	//当系统刷新单元格的内容时被触发
	function datatable1_filler2_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			var recStatus = record.getValue("recStatus");
			cell.innerHTML = "<center><a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">"+value+"</a></center>";
		} else {
			//当不存在记录时
		 	cell.innerHTML="&nbsp;";
		}
	}

	//详细信息
	function doDetail(id){
		showWin("境内汇款申请书-基础信息明细","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopEDsCollectionInfo.ftl?id=" + id + "&op=det","window","flushPage()",window);
	}

	//刷新数据
	function flushPage(){
		BopEDsQuery_dataset.flushData();
	}

</script>
</@CommonQueryMacro.page>