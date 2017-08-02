<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BOPForDebtOverseaLendingTabs" navigate="false" currentTab="BOPForDebtOverseaLending">
		<@CommonQueryMacro.CommonQuery id="BOPForDebtOverseaLending" init="false" submitMode="all" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface"  label="请输入查询条件" />
					</td>
				</tr>

				<tr>
  			  		<td>
  			    		<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"   pageCache="false" showArrow="true"/>
  			  		</td>
  			 	</tr>

  			 	<tr>
		      		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[100],filler2[80],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],debtorcode[120],debtype[80],valuedate[100],contractcurr[120],contractamount[120],maturity[100],anninrate[100],inprterm,spapfeboindex" readonly="true" hasFrame="true" width="900" height="260"/>
		      		</td>
		      	</tr>

		      	<tr style="display:none">
					<td colspan="2">
						<@CommonQueryMacro.Button id= "btDataCol"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btDetail"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btNew"/>&nbsp;&nbsp;

					</td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
	
		function initCallGetter_post() {
			//工作日期
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BOPForDebtOverseaLending_interface_dataset.setValue("qStartDate","${v_txdate}");
			BOPForDebtOverseaLending_interface_dataset.setValue("qEndDate","${v_txdate}");
		}

		//当系统刷新单元格的内容时被触发
		function datatable1_opr_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var recStatus = record.getValue("recStatus");
				var innerStr = "<center>";
				if (recStatus == "01" || recStatus == "02") {
					innerStr = innerStr + "<a href=\"JavaScript:doModify('"+id+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDelete('"+id+"')\">删除</a>"
				} else {
					innerStr = innerStr + "<a title='该记录状态不可修改' style='color:#999999'>修改</a>&nbsp;&nbsp;<a title='该记录状态不可删除' style='color:#999999'>删除</a>";
				}
				innerStr = innerStr + "</center>";

				cell.innerHTML =innerStr;
			} else {//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}

		function locate(id) {

			var record = BOPForDebtOverseaLending_dataset.find(["id"],[id]);
			if (record) {
				BOPForDebtOverseaLending_dataset.setRecord(record);
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
		//新增
		function btNewClick(){

			showWin("境外同业拆借签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOverseaLendingCol.ftl?op=new","report","flushPage()");

		}
		//详细
		function doDetail(id) {
			locate(id);
			showWin("境外同业拆借签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOverseaLendingCol.ftl?id="+id+"&op=detaile","report","flushPage()");
		}

	    //刷新数据
		function flushPage(){

			BOPForDebtOverseaLending_dataset.flushData(1);
		}

		//修改
		function doModify(id) {
		    locate(id);
			showWin("境外同业拆借签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOverseaLendingCol.ftl?id="+id+"&op=mod","report","flushPage()");
		}

		//删除
		function doDelete(id) {
		    locate(id);
			showWin("境外同业拆借签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOverseaLendingCol.ftl?id="+id+"&op=del","report","flushPage()");
		}
	</script>
</@CommonQueryMacro.page>