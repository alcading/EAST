<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BOPForDebtOverseaLendingQueryTabs" navigate="false" currentTab="BOPForDebtOverseaLendingQuery">
		<@CommonQueryMacro.CommonQuery id="BOPForDebtOverseaLendingQuery" init="false" submitMode="all" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[100],brNo[140],brNoName[180],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],debtorcode[120],debtype[80],valuedate[100],contractcurr[120],contractamount[120],maturity[100],anninrate[100],inprterm,spapfeboindex" readonly="true" hasFrame="true" width="900" height="230"/>
		      		</td>
		      	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
		//工作日期
		function initCallGetter_post() {
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BOPForDebtOverseaLendingQuery_interface_dataset.setValue("qWorkDateStart","${v_txdate}");
			BOPForDebtOverseaLendingQuery_interface_dataset.setValue("qWorkDateEnd","${v_txdate}");
		}
		function locate(id) {

			var record = BOPForDebtOverseaLendingQuery_dataset.find(["id"],[id]);
			if (record) {
				BOPForDebtOverseaLendingQuery_dataset.setRecord(record);
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

		//详细
		function doDetail(id) {
			locate(id);
			showWin("境外同业拆借签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOverseaLendingCol.ftl?id="+id+"&op=detaile&model=Query","report","flushPage()");
		}

	    //刷新数据
		function flushPage(){
			BOPForDebtOverseaLendingQuery_dataset.flushData();
		}
	</script>
</@CommonQueryMacro.page>