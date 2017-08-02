<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="涉外收入申报单-申报信息">
<@CommonQueryMacro.CommonQueryTab id="bopAGDsRecordTabs" navigate="false" currentTab="bopGDsRecord">
	<@CommonQueryMacro.CommonQuery id="bopGDsRecord" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[100],filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno,country,paytype,txcode,tc1amt,txrem,txcode2,tc2amt,tx2rem,isref,billno,payattr,crtuser,inptelc,rptdate" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
</td></tr></table>
<script language="JavaScript">
	
	function initCallGetter_post(){
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		bopGDsRecord_interface_dataset.setValue("qworkDateStart", currentDate);
		bopGDsRecord_interface_dataset.setValue("qworkDateEnd", currentDate);
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
		if(record && record != null) {
			var id = record.getValue("id");
			cell.innerHTML = "<center><a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">"+value+"</a></center>";
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	
	function btAdd_onClick(button) {
		btNewClick();
	}
	
	//刷新数据
	function flushPage(){
		bopGDsRecord_dataset.flushData(1);
	}
	
	//新增
	function btNewClick(){
		showWin("涉外收入申报单-申报信息新增","${contextPath}/fpages/bop/collandaudit/ag/ftl/BopGDsRecordInfo.ftl?op=add","window","flushPage()",window);
	}
	
	//修改
	function doCollection(id){
		showWin("涉外收入申报单-申报信息修改","${contextPath}/fpages/bop/collandaudit/ag/ftl/BopGDsRecordInfo.ftl?id=" + id + "&op=mod","window","flushPage()",window);
	}
	
	//删除
	function doDelete(id){
		showWin("涉外收入申报单-申报信息删除","${contextPath}/fpages/bop/collandaudit/ag/ftl/BopGDsRecordInfo.ftl?id=" + id + "&op=del","window","flushPage()",window);
	}
	
	//详细信息
	function doDetail(id){
		showWin("涉外收入申报单-申报信息明细","${contextPath}/fpages/bop/collandaudit/ag/ftl/BopGDsRecordInfo.ftl?id=" + id + "&op=det","window","flushPage()",window);
	}
</script>
</@CommonQueryMacro.page>