<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQueryTab id="BOPCfaLounexguRecordTabs" navigate="false" currentTab="BOPCfaLounexguRecordAD">
	<@CommonQueryMacro.CommonQuery id="BOPCfaLounexguRecordAD" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[70],filler2[80],workDate[75],actiontype[75],recStatus[75],approveStatus[75],repStatus[75],lounexgucode[80],creditorcode[80],debtorcode[80],debtorname[80],debtortype[70],valuedate[80],maturity[80],dofoexlocode[80]"   hasFrame="true" width="1000" height="260" readonly="true"/>
		      	</td>
		    </tr>
		    <tr style="display:none">
		    	<td>
		    		<@CommonQueryMacro.Button id="btDel"/>
		    	</td>
		    </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
</td></tr></table>
<script language="JavaScript">
	
	function initCallGetter_post() {
		//interface里查询的设置工作日期默认当天
		BOPCfaLounexguRecordAD_interface_dataset.setValue("workDateStart","${v_txdate}");
		BOPCfaLounexguRecordAD_interface_dataset.setValue("workDateEnd","${v_txdate}");
	}	
	
	//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
			var id = record.getValue("id");
			var innerStr = "";
			var recStatus = record.getValue("recStatus");
			if (recStatus == "01" || recStatus == "02"   ) {
				innerStr = innerStr + "<a href=\"JavaScript:doModify('"+id+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDel('"+id+"')\">删除</a>"
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
			var filler2 = record.getValue("filler2");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}
	
	function btAdd_onClick(button) {
			btNewClick();
	}
	function doModify(id){
		
			//window.location.href = "${contextPath}/fpages/datacollection/ftl/BOPCfaLounexguRecordEdit.ftl?id=" + id+"&op=mod";
			showWin("签约信息修改","${contextPath}/fpages/datacollection/ftl/BOPCfaLounexguRecordEdit.ftl?id=" + id+"&op=mod","report","flushPage()");
	}
	
	
	
	function btNewClick(){
	
		showWin("签约信息新增","${contextPath}/fpages/datacollection/ftl/BOPCfaLounexguRecordEdit.ftl?op=new","report","flushPage()");
		//window.location.href = "${contextPath}/fpages/datacollection/ftl/BOPCfaLounexguRecordEdit.ftl?op=new";
	}
	
		//刷新数据
	function flushPage(){
		BOPCfaLounexguRecordAD_dataset.flushData(1);
	}
	
	function doDel(id){
			showWin("签约信息删除","${contextPath}/fpages/datacollection/ftl/BOPCfaLounexguRecordEdit.ftl?id=" + id+"&op=delInfo","report","flushPage()");
	}
	//详细信息
	function doDetail(id){
		showWin("签约信息明细","${contextPath}/fpages/datacollection/ftl/BOPCfaLounexguRecordEdit.ftl?id=" + id + "&op=detail");
	}	
</script>
</@CommonQueryMacro.page>