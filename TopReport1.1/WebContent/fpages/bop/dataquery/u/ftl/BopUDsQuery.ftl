<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基础信息">
	<@CommonQueryMacro.CommonQuery id="BopUDsQuery" init="false" submitMode="current" navigate="false">
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
					<@CommonQueryMacro.DataTable id ="datatable1" hasFrame="true" fieldStr="recStatus[80],approveStatus[80],repStatus[80],custcode,custname,industrycode,attrcode,countrycode,istaxfree,taxfreecode,rptmethod" readonly="true" hasFrame="true" width="900" height="260"/>
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">

		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			BopUDsQuery_interface_dataset.setValue("qworkDateStart", currentDate);
			BopUDsQuery_interface_dataset.setValue("qworkDateEnd", currentDate);
		}

		function datatable1_custcode_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + value + "</a>"
			} else {
				cell.innerHTML="&nbsp;";
			}
		}

		//详细信息
		function doDetail(id){
			showWin("明细","${contextPath}/fpages/bop/collandaudit/u/ftl/BopUDsCollectionInfo.ftl?id=" + id + "&op=detail","window","",window);
		}
	</script>
</@CommonQueryMacro.page>