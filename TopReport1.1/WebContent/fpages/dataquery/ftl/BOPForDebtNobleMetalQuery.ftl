<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQueryTab id="BOPForDebtNobleMetalQueryTabs" navigate="false" currentTab="BOPForDebtNobleMetalQuery">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtNobleMetalQuery" init="false" submitMode="current" navigate="false" >
		<table align="left">
			<tr>
				<td >
					<@CommonQueryMacro.Interface id="interface"  label="请输入查询条件" />
				</td>
			</tr>
			<tr>
  			  	<td>
  			    	<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"   pageCache="false" showArrow="true"/>
  			  	</td>
  			</tr>
  			<tr>
		      	<td >
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[100],brNo[140],brNoName[180],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],debtorcode[120],debtype[180],valuedate[100],contractcurr[80],floatrate[80],anninrate[80],creditorcode[80],creditorname[80],creditornamen[80],creditortype[80],crehqcode,opercode,spapfeboindex[80]" readonly="true" hasFrame="true" width="1000" height="260"/>
		      	</td>
      		</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">

	function initCallGetter_post(){
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		BOPForDebtNobleMetalQuery_interface_dataset.setValue("qWorkDateBegin",currentDate);
		BOPForDebtNobleMetalQuery_interface_dataset.setValue("qWorkDateOver",currentDate);
	}
	
	function datatable1_filler2_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + value + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}
	
	//详细信息
	function doDetail(id){
		showWin("贵金属拆借签约信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtNobleMetalLendingCol.ftl?id=" + id + "&op=detaile");
	}
</script>
</@CommonQueryMacro.page>