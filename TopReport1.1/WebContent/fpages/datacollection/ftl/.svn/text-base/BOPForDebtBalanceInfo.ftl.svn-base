<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<#assign balanceFileType = RequestParameters["balanceFileType"]?default("")>
	<#assign tabId = "BopForSameInduDepositTabs">
	<#if balanceFileType == "AL">
		<#assign tabId = "BopForSameInduDepositTabs">
	</#if>
	<#if balanceFileType == "AM">
		<#assign tabId = "BopForCorAndAffOrgContactTabs">
	</#if>
	<#if balanceFileType == "AN">
		<#assign tabId = "BopForDebtFeiOrgSaveTabs">
	</#if>
	<#if balanceFileType == "AP">
		<#assign tabId = "bopForDebtFeiPerSaveTabs">
	</#if>
	<@CommonQueryMacro.CommonQueryTab id="${tabId}" navigate="false" currentTab="BOPForDebtBalanceInfo">
		<@CommonQueryMacro.CommonQuery id="BOPForDebtBalanceInfo" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[100],filler2[80],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],buscode[120],changeno,accoamount,chdate" readonly="true" hasFrame="true" width="900" height="260"/>
		      		</td>
		      	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">

		var balanceFileType;
		function initCallGetter_post()
		{
			//工作日期
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BOPForDebtBalanceInfo_interface_dataset.setValue("qworkDateStart","${v_txdate}");
			BOPForDebtBalanceInfo_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
			balanceFileType = "${RequestParameters["balanceFileType"]?default('')}";
			BOPForDebtBalanceInfo_dataset.setParameter("balanceFileType",balanceFileType);

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
		function btNewClick(id){
			showWin("余额信息新增","${contextPath}/fpages/datacollection/ftl/BOPForDebtBalanceInfoCol.ftl?op=new&balanceFileType="+balanceFileType,"report","flushPage()");
		}
		//详细
		function doDetail(id) {
			showWin("余额信息详细","${contextPath}/fpages/datacollection/ftl/BOPForDebtBalanceInfoCol.ftl?id="+id+"&op=detail&balanceFileType="+balanceFileType,"report","flushPage()");
		}
		//修改
		function doModify(id) {
			showWin("余额信息修改","${contextPath}/fpages/datacollection/ftl/BOPForDebtBalanceInfoCol.ftl?id="+id+"&op=mod&balanceFileType="+balanceFileType,"report","flushPage()");
		}
		//删除
		function doDelete(id) {
			showWin("余额信息删除","${contextPath}/fpages/datacollection/ftl/BOPForDebtBalanceInfoCol.ftl?id="+id+"&op=del&balanceFileType="+balanceFileType,"report","flushPage()");
		}
		//刷新数据
		function flushPage(){
			BOPForDebtBalanceInfo_dataset.flushData(1);
		}
	</script>
</@CommonQueryMacro.page>