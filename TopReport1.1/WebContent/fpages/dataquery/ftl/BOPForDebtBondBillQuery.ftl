<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BOPForDebtBondBillQueryTabs" navigate="false" currentTab="BOPForDebtBondBillQuery">
		<@CommonQueryMacro.CommonQuery id="BOPForDebtBondBillQuery" init="false" submitMode="current" navigate="false">
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface"  label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
					</td>

				</tr>

				<tr>
					<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[100],brNo[140],brNoName[180],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],debtorcode[120],debtype[180],valuedate[100],contractcurr[150],contractamount[120],maturity[100],anninrate[100],spapfeboindex" readonly="true" hasFrame="true" width="900" height="260"/>
					</td>
				</tr>

			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>


	<script language="JavaScript">
	
		function initCallGetter_post(){
			<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
			BOPForDebtBondBillQuery_interface_dataset.setValue("qWorkDate", "${workdate}");
			BOPForDebtBondBillQuery_interface_dataset.setValue("eWorkDate", "${workdate}");
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

		//详细
		function doDetail(id) {
			showWin("债券和票据签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtBondBillCol.ftl?op=detaile&id="+id,"report","flushPage()");
		}

		//刷新数据
		function flushPage(){
			BOPForDebtBondBillQuery_dataset.flushData();
		}
	</script>
</@CommonQueryMacro.page>