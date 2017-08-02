<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="境内收入申报单">
	<@CommonQueryMacro.CommonQueryTab id="BopDRDsQryTabs" navigate="false" currentTab="BopRDsQry">
		<@CommonQueryMacro.CommonQuery id="BopRDsQry" init="false" submitMode="all" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[80],rptno[80],isref[80],payattr[80],paytype[80],txcode[80],tc1amt[80],txrem[80],txcode2[80],tc2amt[80],tx2rem[80],crtuser[80],inptelc[80],rptdate[80],regno[80]" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">
		//工作日期
		function initCallGetter_post() {
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BopRDsQry_interface_dataset.setValue("qworkDateStart","${v_txdate}");
			BopRDsQry_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
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
		
		function locate(id) {
			var record = MtsBopQDs_dataset.find(["id"],[id]);
			if (record) {
				BopRDsQry_dataset.setRecord(record);
			}
		}
		
		//详细信息
		function doDetail(id){
			showWin("境内收入申报单管理信息明细","${contextPath}/fpages/bop/collandaudit/dr/ftl/BopRDsAdd.ftl?id=" + id + "&op=detail","window","flushPage()",window);
		}
	</script>
</@CommonQueryMacro.page>