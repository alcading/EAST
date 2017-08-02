<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="履约明细信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCFAExguQryTabs" navigate="false" currentTab="BOPLiabilityBalanceQry">
		<@CommonQueryMacro.CommonQuery id="BOPLiabilityBalanceQry" init="false" submitMode="selected" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="9" showArrow="true" />
					</td>
		    	</tr>

		    	<tr>
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],brNo[80],brNoName[80],workDate[80],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exguarancode[80],wabachandate[80],basere[80]" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">

	//工作日期
	function initCallGetter_post() {
		<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
		BOPLiabilityBalanceQry_interface_dataset.setValue("qWorkDateStart","${v_txdate}");
		BOPLiabilityBalanceQry_interface_dataset.setValue("qWorkDateEnd","${v_txdate}");
	}

	function datatable1_filler2_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			var filler2 = record.getValue("filler2");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}


	//详细信息
	function doDetail(id){

		showWin("责任余额明细","${contextPath}/fpages/datacollection/ftl/BopLiabilityBalanceAdd.ftl?id=" + id + "&op=detail");
	}
	</script>
</@CommonQueryMacro.page>