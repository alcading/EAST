<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="外汇账户内购汇管理信息">
	<@CommonQueryMacro.CommonQueryTab id="JshEgDsTabs" navigate="false" currentTab="JshGDs">
		<@CommonQueryMacro.CommonQuery id="JshGDs" init="false" submitMode="all" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[80],filler2[80],buscode[80],brNo[80],brNoName[80],workDate[80],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[80],rptno[80],regno,txcode,crtuser,inptelc,rptdate" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">
	
		//工作日期
		function initCallGetter_post() {
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			JshGDs_interface_dataset.setValue("qworkDateStart","${v_txdate}");
			JshGDs_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
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
		
		function btAdd_onClick(button) {
			btNewClick();
		}
		//刷新数据
		function flushPage(){
			JshGDs_dataset.flushData(1);
		}
		function locate(id) {
			var record = MtsJshGDs_dataset.find(["id"],[id]);
			if (record) {
				MtsJshGDs_dataset.setRecord(record);
			}
		}
		function btNewClick(){
		
			showWin("外汇账户内购汇管理信息","${contextPath}/fpages/jsh/collandaudit/eg/ftl/JshGDsAdd.ftl?op=new","window","flushPage()",window);
		}
		//修改
		function doCollection(id){
			showWin("外汇账户内购汇管理信息修改","${contextPath}/fpages/jsh/collandaudit/eg/ftl/JshGDsAdd.ftl?id=" + id + "&op=mod","window","flushPage()",window);
		}
		//删除
		function doDelete(id){
			showWin("外汇账户内购汇管理信息删除","${contextPath}/fpages/jsh/collandaudit/eg/ftl/JshGDsAdd.ftl?id=" + id + "&op=del","window","flushPage()",window);
		}
		//详细信息
		function doDetail(id){
			showWin("外汇账户内购汇管理信息明细","${contextPath}/fpages/jsh/collandaudit/eg/ftl/JshGDsAdd.ftl?id=" + id + "&op=detail","window","flushPage()",window);
		}
	</script>
</@CommonQueryMacro.page>