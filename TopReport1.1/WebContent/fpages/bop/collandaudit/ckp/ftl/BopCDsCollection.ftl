<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基础信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCKPDsCollectionTabs" navigate="false" currentTab="BopCDsCollection">
		<@CommonQueryMacro.CommonQuery id="BopCDsCollection" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" hasFrame="true" fieldStr="opr[100],filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno,custnm,custype[120],idcode,custcod,oppuser,txccy[100],txamt,exrate,lcyamt,lcyacc,fcyamt,fcyacc,othamt,othacc,method,actuccy[100],actuamt,outchargeccy[100],outchargeamt,lcbgno,issdate[85],tenor" readonly="true" hasFrame="true" width="900" height="260"/>
					</td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">

		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			BopCDsCollection_interface_dataset.setValue("qworkDateStart", currentDate);
			BopCDsCollection_interface_dataset.setValue("qworkDateEnd", currentDate);
		}

		//当系统刷新单元格的内容时被触发
		function datatable1_opr_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var recStatus = record.getValue("recStatus");
				var innerStr = "<center>";
				if (recStatus == "01" || recStatus == "02") {
					innerStr = innerStr + "<a href=\"JavaScript:doCollection('"+id+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDelete('"+id+"')\">删除</a>"
				} else {
					innerStr = innerStr + "<a title='该记录状态不可修改' style='color:#999999'>修改</a>&nbsp;&nbsp;<a title='该记录状态不可删除' style='color:#999999'>删除</a>";
				}
				innerStr = innerStr + "</center>";

				cell.innerHTML =innerStr;
			} else {//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}

		function datatable1_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + value + "</a>"
			} else {
				cell.innerHTML="&nbsp;";
			}
		}
		
		function btAdd_onClick(button) {
			btNewClick();
		}
		//新增
		function btNewClick(){
			showWin("基础信息新增","${contextPath}/fpages/bop/collandaudit/ckp/ftl/BopCDsCollectionInfo.ftl?op=new","window","flushPage()",window);
		}

		//刷新数据
		function flushPage(){
			BopCDsCollection_dataset.flushData(1);
		}

		//修改
		function doCollection(id){
			showWin("基础信息修改","${contextPath}/fpages/bop/collandaudit/ckp/ftl/BopCDsCollectionInfo.ftl?id=" + id + "&op=modify","window","flushPage()",window);
		}

		//删除
		function doDelete(id){
			showWin("基础信息删除","${contextPath}/fpages/bop/collandaudit/ckp/ftl/BopCDsCollectionInfo.ftl?id=" + id + "&op=delete","window","flushPage()",window);
		}

		//详细信息
		function doDetail(id){
			showWin("基础信息明细","${contextPath}/fpages/bop/collandaudit/ckp/ftl/BopCDsCollectionInfo.ftl?id=" + id + "&op=detail","window","",window);
		}
	</script>
</@CommonQueryMacro.page>