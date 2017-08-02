<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基础信息">
	<@CommonQueryMacro.CommonQueryTab id="BopFSDsQueryTabs" navigate="false" currentTab="BopSDsQuery">
		<@CommonQueryMacro.CommonQuery id="BopSDsQuery" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" hasFrame="true" fieldStr="filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[80],rptno[80],isref,country,paytype[120],payattr[120],txcode[200],tc1amt,txcode2[200],tc2amt,contrno[120],invoino[120],billno[120],contamt,regno,crtuser,inptelc,rptdate[85]" readonly="true" hasFrame="true" width="900" height="260"/>
					</td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">

		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			BopSDsQuery_interface_dataset.setValue("qworkDateStart", currentDate);
			BopSDsQuery_interface_dataset.setValue("qworkDateEnd", currentDate);
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
			showWin("基础信息明细","${contextPath}/fpages/bop/collandaudit/fs/ftl/BopSDsCollectionInfo.ftl?id=" + id + "&op=detail","window","",window);
		}
	</script>
</@CommonQueryMacro.page>