<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQueryTab id="bopForDebtYinTuanGenTabs" navigate="false" currentTab="BopForDebtYinTuanSignedGen">
	<@CommonQueryMacro.CommonQuery id="bopForDebtYinTuanSignedGen" init="false" submitMode="current" navigate="false" >
		<table align="left">
			<tr>
				<td >
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
				</td>
		    </tr>
  			 <tr>
		      	<td >
					<@CommonQueryMacro.DataTable id ="datatable1" hasFrame="true" fieldStr="brNo,brNoName,workDate[85],actiontype,exdebtcode,debtorcode,debtype,valuedate[85],contractcurr[100],contractamount,maturity[85],floatrate,anninrate,inprterm,spapfeboindex" readonly="true" hasFrame="true" width="900" height="260"/>
		      	</td>
		      </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">

	function datatable1_exdebtcode_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			var exdebtcode = record.getValue("exdebtcode");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + exdebtcode + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}
	
	//详细信息
	function doDetail(id){
		showWin("银团贷款签约信息明细","${contextPath}/fpages/datacollection/ftl/BopForDebtYinTuanSignedInfo.ftl?id=" + id + "&op=detail");
	}
</script>
</@CommonQueryMacro.page>