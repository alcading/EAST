<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCfaExplrmbloDsTabs" navigate="false" currentTab="BopCfaExplrmbloDs">
		<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDs" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="BopCfaExplrmbloDsTable" paginationbar="btAdd" hasFrame="true"
							fieldStr="opr[100],filler2,workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],explrmblono[130],creditorcode,debtorcode[80],debtorname,valuedate[100],maturity[100],credconcurr[150],credconamount[100]" readonly="true" hasFrame="true" width="900" height="260"/>
	      			</td>
	    		</tr>
	   			<tr style="display:none">
					<td>
						<@CommonQueryMacro.Button id= "btMod"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btDelete"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btDetail"/>&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
		
		function initCallGetter_post() {
			<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
			BopCfaExplrmbloDs_interface_dataset.setValue("workDateStart", "${workdate}");
			BopCfaExplrmbloDs_interface_dataset.setValue("workDateEnd", "${workdate}");
		}

		//当系统刷新单元格的内容时被触发
		function BopCfaExplrmbloDsTable_opr_onRefresh(cell,value,record) {
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
		function BopCfaExplrmbloDsTable_filler2_onRefresh(cell,value,record) {
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
			showWin("签约信息删除","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsAdd.ftl?op=del&id=" + id,"report","flushPage()");
		}

		//新增
		function btNewClick(){
			showWin("签约信息新增","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsAdd.ftl?op=new","report","flushPage()");
		}

		//查询
		function doDetail(id){
			showWin("签约信息查询","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsAdd.ftl?op=detail&id="+id,"report","flushPage()");
		}

		//修改
		function doModify(id){
			showWin("签约信息修改","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsAdd.ftl?id=" + id + "&op=mod","report","flushPage()");
		}

		//刷新数据
		function flushPage(){
			BopCfaExplrmbloDs_dataset.flushData(1);
		}

	</script>
</@CommonQueryMacro.page>