<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="涉外收入申报单-申报信息">
	<@CommonQueryMacro.CommonQueryTab id="BopAGDsQueryTabs" navigate="false" currentTab="BopGDsQuery">
		<@CommonQueryMacro.CommonQuery id="BopGDsQuery" init="false" submitMode="all" navigate="false" >
			<table align="left">
				<tr>
					<td>
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="9" showArrow="true" />
					</td>
		    	</tr>

		    	<tr>
		    		<td>
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[120],rptno,country,paytype,txcode,tc1amt,txrem,txcode2,tc2amt,tx2rem,isref,billno,payattr,crtuser,inptelc,rptdate" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">
		//工作日期
		function initCallGetter_post() {
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BopGDsQuery_interface_dataset.setValue("qWorkDateStart","${v_txdate}");
			BopGDsQuery_interface_dataset.setValue("qWorkDateEnd","${v_txdate}");
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
				bopGDsQuery_dataset.setRecord(record);
			}
		}
		
		//详细信息
		function doDetail(id){
			showWin("涉外收入申报单-申报信息明细","${contextPath}/fpages/bop/collandaudit/ag/ftl/BopGDsRecordInfo.ftl?id=" + id + "&op=det","window","flushPage()",window);
		}
	</script>
</@CommonQueryMacro.page>