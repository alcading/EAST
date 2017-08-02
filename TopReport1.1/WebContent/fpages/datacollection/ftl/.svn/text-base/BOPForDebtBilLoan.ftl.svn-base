<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BOPForDebtTabs" navigate="false" currentTab="BOPForDebtBilLoan">
		<@CommonQueryMacro.CommonQuery id="BOPForDebtBilLoan" init="false" submitMode="all" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[100],filler2[100]],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[190],debtorcode[140],debtype[90],contractdate[120],valuedate[120],contractcurr[140],contractamount[120],maturity[120],anninrate[100],inprterm,spapfeboindex" readonly="true" hasFrame="true" width="900" height="260"/>
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
			<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
			BOPForDebtBilLoan_interface_dataset.setValue("qStartDate", "${workdate}");
			BOPForDebtBilLoan_interface_dataset.setValue("qEndDate", "${workdate}");
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

			var record = BOPForDebtBilLoan_dataset.find(["id"],[id]);
			if (record) {
				BOPForDebtBilLoan_dataset.setRecord(record);
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

			showWin("双边贷款签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtBilLoanCol.ftl?op=new","report","flushPage()");

		}
		//详细
		function doDetail(id) {
			locate(id);
			showWin("双边贷款签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtBilLoanCol.ftl?id="+id+"&op=detaile","report","flushPage()");
		}

	    //刷新数据
		function flushPage(){

			BOPForDebtBilLoan_dataset.flushData(1);
		}

		//修改
		function doModify(id) {
		    locate(id);
			showWin("双边贷款签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtBilLoanCol.ftl?id="+id+"&op=mod","report","flushPage()");
		}

		//删除
		function doDelete(id) {
		    locate(id);
			showWin("双边贷款签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtBilLoanCol.ftl?id="+id+"&op=del","report","flushPage()");
		}

		//BOPForDebtBilLoan_interface_dataset.setValue("qWorkDate",new Date());

	</script>
</@CommonQueryMacro.page>