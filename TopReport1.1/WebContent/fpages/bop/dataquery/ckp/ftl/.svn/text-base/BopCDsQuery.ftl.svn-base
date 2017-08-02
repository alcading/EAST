<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基础信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCKPDsQueryTabs" navigate="false" currentTab="BopCDsQuery">
		<@CommonQueryMacro.CommonQuery id="BopCDsQuery" init="false" submitMode="current" navigate="false" >
			<table align="left">
				<tr>
					<td>
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>
				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
					</td>
			    </tr>
	  			<tr>
			    	<td>
						<@CommonQueryMacro.DataTable id ="datatable1" hasFrame="true" fieldStr="filler2,buscode,brNo,brNoName[150],workDate[85],recStatus[70],approveStatus,repStatus,actiontype,actiondesc,rptno,custnm,custype[120],idcode,custcod,oppuser,txccy,txamt,exrate,lcyamt,lcyacc[100],fcyamt,fcyacc,othamt,othacc,method,actuccy[100],actuamt,outchargeccy[100],outchargeamt,lcbgno,issdate[100],tenor" readonly="true" hasFrame="true" width="900" height="260"/>
					</td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">

		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			BopCDsQuery_interface_dataset.setValue("qworkDateStart", currentDate);
			BopCDsQuery_interface_dataset.setValue("qworkDateEnd", currentDate);
		}

		function datatable1_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + value + "</a>"
			} else {
				cell.innerHTML="&nbsp;";
			}
		}

		//详细信息
		function doDetail(id){
			showWin("基础信息明细","${contextPath}/fpages/bop/collandaudit/ckp/ftl/BopCDsCollectionInfo.ftl?id=" + id + "&op=detail","window","",window);
		}
	</script>
</@CommonQueryMacro.page>