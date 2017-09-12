<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基础信息">
	<@CommonQueryMacro.CommonQuery id="BopUDsCollection" init="false" submitMode="current" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" hasFrame="true" fieldStr="opr[100],recStatus[80],approveStatus[80],repStatus[80],custcode,custname,industrycode,attrcode,countrycode,istaxfree,taxfreecode,rptmethod" readonly="true" hasFrame="true" width="900" height="260"/>
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">

		function initCallGetter_post(){
			var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
			BopUDsCollection_interface_dataset.setValue("qworkDateStart", currentDate);
			BopUDsCollection_interface_dataset.setValue("qworkDateEnd", currentDate);
		}

		//当系统刷新单元格的内容时被触发
		function datatable1_opr_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var recStatus = record.getValue("recStatus");
				var subSuccess = record.getValue("subSuccess");
				var innerStr = "<center>";
				if (recStatus == "01" || recStatus == "02") {
					innerStr = innerStr + "<a href=\"JavaScript:doCollection('" + id + "', '" + subSuccess + "')\">修改</a>&nbsp;&nbsp;";
					if ("0" == subSuccess) {
						innerStr += "<a href=\"JavaScript:doDelete('" + id + "')\">删除</a>"
					}
				} else {
					innerStr = innerStr + "<a title='该记录状态不可修改' style='color:#999999'>修改</a>&nbsp;&nbsp;";
					if ("0" == subSuccess) {
						innerStr += "<a title='该记录状态不可删除' style='color:#999999'>删除</a>";
					}
				}
				innerStr = innerStr + "</center>";

				cell.innerHTML =innerStr;
			} else {//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}

		function datatable1_custcode_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('" + id + "')\">" + value + "</a>"
			} else {
				cell.innerHTML="&nbsp;";
			}
		}
		
		function btAdd_onClick(button) {
			btNewClick();
		}
		//新增
		function btNewClick(){
			showWin("新增","${contextPath}/fpages/bop/collandaudit/u/ftl/BopUDsCollectionInfo.ftl?op=new","window","flushPage()",window);
		}

		//刷新数据
		function flushPage(){
			BopUDsCollection_dataset.flushData();
		}

		//修改
		function doCollection(id, subSuccess){
			showWin("修改","${contextPath}/fpages/bop/collandaudit/u/ftl/BopUDsCollectionInfo.ftl?id=" + id + "&op=modify&subSuccess="+subSuccess,"window","flushPage()",window);
		}

		//删除
		function doDelete(id){
			showWin("删除","${contextPath}/fpages/bop/collandaudit/u/ftl/BopUDsCollectionInfo.ftl?id=" + id + "&op=delete","window","flushPage()",window);
		}

		//详细信息
		function doDetail(id){
			showWin("明细","${contextPath}/fpages/bop/collandaudit/u/ftl/BopUDsCollectionInfo.ftl?id=" + id + "&op=detail","window","",window);
		}
	</script>
</@CommonQueryMacro.page>