<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="变动信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCfaExplrmbloDsTabs" navigate="false" currentTab="BopCfaExplrmbloDsChangeInfo">
		<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsChangeInfo" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="BopCfaExplrmbloDsChangeInfoTable" paginationbar="btAdd" hasFrame="true"
							fieldStr="opr[100],filler2,workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],explrmblono[130],buocmonth[130],changeno,monbeloadbal[100],monenloadbal[100]" readonly="true" hasFrame="true" width="900" height="260"/>
	      			</td>
	    		</tr>

			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">

		function initCallGetter_post() {
			<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
			BopCfaExplrmbloDsChangeInfo_interface_dataset.setValue("qworkDateStart", "${workdate}");
			BopCfaExplrmbloDsChangeInfo_interface_dataset.setValue("qworkDateEnd", "${workdate}");
		}

		//当系统刷新单元格的内容时被触发
		function BopCfaExplrmbloDsChangeInfoTable_opr_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");

				var recStatus = record.getValue("recStatus");
				var actiontype = record.getValue("actiontype");
				var repStatus = record.getValue("repStatus");
				if (("01" == recStatus || "02" == recStatus) && ("D" != actiontype || ("D" == actiontype && "01" != repStatus))) {
					cell.innerHTML = "<center><a href=\"JavaScript:doModify('"+id+"')\">修改</a>&nbsp;<a href=\"JavaScript:doDelete('"+id+"')\">删除</a></center>";
				} else {
					cell.innerHTML ="<center><a title='该记录状态不可修改' style='color:#999999'>修改</a>&nbsp;<a title='该记录状态不可删除' style='color:#999999'>删除</a></center>";
				}
			} else {
				//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}

		//当系统刷新单元格的内容时被触发
		function BopCfaExplrmbloDsChangeInfoTable_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var filler2 = record.getValue("filler2");
				cell.innerHTML = "<center><a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">"+filler2+"</a></center>";
			} else {
				//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}
		function btAdd_onClick(button) {
			btNewClick();
		}
		//删除
		function doDelete(id){
			showWin("变动信息删除","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsChangeInfoAdd.ftl?op=del&id=" + id,"report","flushPage()");
		}

		//新增
		function btNewClick(){
			showWin("变动信息新增","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsChangeInfoAdd.ftl?op=new","report","flushPage()");
		}

		//查询
		function doDetail(id){
			showWin("变动信息查询","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsChangeInfoAdd.ftl?op=detail&id="+id,"report","flushPage()");
		}

		//修改
		function doModify(id){
			showWin("变动信息修改","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsChangeInfoAdd.ftl?id=" + id + "&op=mod","report","flushPage()");
		}

		//刷新数据
		function flushPage(){
			BopCfaExplrmbloDsChangeInfo_dataset.flushData(1);
		}

	</script>
</@CommonQueryMacro.page>