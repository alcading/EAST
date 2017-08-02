<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="履约明细信息">
<@CommonQueryMacro.CommonQueryTab id="BopCFAExguTabs" navigate="false" currentTab="BOPForGuperDsInfo">
	<@CommonQueryMacro.CommonQuery id="BOPGuperInfo" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[80],filler2[80],workDate[80],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exguarancode[80],buscode[80],complianceno[80],guarantorcode[80],pguperamount[80],gupercurr[80],guperdate[80],guperamount[80],bencode[80],bename[80],benamen[80],remark[80],actiondesc[80]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
		    
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
</td></tr></table>
<script language="JavaScript">


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

function initCallGetter_post() {
	<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
	BOPGuperInfo_interface_dataset.setValue("qstartDate","${v_txdate}");
	BOPGuperInfo_interface_dataset.setValue("qendDate","${v_txdate}");
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

//刷新数据
function flushPage(){
	BOPGuperInfo_dataset.flushData(1);
}



function locate(id) {
	
	var record = BOPGuperInfo.find(["id"],[id]);
	if (record) {
		BOPGuperInfo.setRecord(record);
	}
}
function btAdd_onClick(button) {
			btNewClick();
}

function btNewClick(){
	
	showWin("履约明细信息","${contextPath}/fpages/datacollection/ftl/BOPForGuperDsInfoAdd.ftl?op=new","report","flushPage()");

	
}

//修改
function doCollection(id){
	
	showWin("履约明细信息修改","${contextPath}/fpages/datacollection/ftl/BOPForGuperDsInfoAdd.ftl?id=" + id + "&op=mod","report","flushPage()");
}

//删除
function doDelete(id){
	
	showWin("履约明细信息删除","${contextPath}/fpages/datacollection/ftl/BOPForGuperDsInfoAdd.ftl?id=" + id + "&op=del","report","flushPage()");
}

//详细信息
function doDetail(id){
	
	showWin("履约明细信息明细","${contextPath}/fpages/datacollection/ftl/BOPForGuperDsInfoAdd.ftl?id=" + id + "&op=detail");
}
</script>
</@CommonQueryMacro.page>