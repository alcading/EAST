<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="变动信息">

<@CommonQueryMacro.CommonQueryTab id="bopForDebtOtherLoansGenTabs" navigate="false" currentTab="BOPForDebtOtherLoansChangeGen">
	<@CommonQueryMacro.CommonQuery id="bopForDebtOtherLoansChangeGen" init="false" submitMode="all" navigate="false" >
		<table align="left">
			<tr>
				<td>
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],brNo,brNoName,workDate[100],actiontype[80],exdebtcode[180],buscode[120],changeno[100],changtype[120],chdate[100],chcurrency[160],chamount[120],fairvalue[120]" readonly="true" hasFrame="true" width="900" height="260"/>
		      	</td>

		      </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">
	
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
		var changFileType = "AI";
		showWin("其他贷款变动信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOtherLoansChangeInfoCol.ftl?id="+id+"&op=detaile&changFileType="+changFileType);
	}
</script>
</@CommonQueryMacro.page>