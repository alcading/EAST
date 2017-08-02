<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="申报信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCKPDsQueryTabs" navigate="false" currentTab="BopPDsQuery">
		<@CommonQueryMacro.CommonQuery id="BopPDsQuery" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" hasFrame="true" fieldStr="filler2,buscode,brNo,brNoName[150],workDate[85],recStatus[70],approveStatus,repStatus,actiontype,actiondesc,rptno,contrno[150],invoino[150],billno[150],contamt,crtuser[60],inptelc,rptdate[100]" readonly="true" hasFrame="true" width="900" height="260"/>
					</td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">

		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			BopPDsQuery_interface_dataset.setValue("qworkDateStart", currentDate);
			BopPDsQuery_interface_dataset.setValue("qworkDateEnd", currentDate);
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
			showWin("申报信息明细","${contextPath}/fpages/bop/collandaudit/ckp/ftl/BopPDsCollectionInfo.ftl?id=" + id + "&op=detail","window","",window);
		}
	</script>
</@CommonQueryMacro.page>