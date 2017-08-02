<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="变动信息">

<@CommonQueryMacro.CommonQueryTab id="BOPForDebtOverseaLendingQueryTabs" navigate="false" currentTab="BOPForDebtOverseaLendingChangeInfoQuery">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtChangeInfoQuery" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2,brNo[140],brNoName[180],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],buscode[120],changeno[100],changtype[120],chdate[100],chcurrency[160],chamount[120],fairvalue[120]" readonly="true" hasFrame="true" width="900" height="260"/>
		      	</td>

		      </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">

	

	function initCallGetter_post()
	{
		BOPForDebtChangeInfoQuery_dataset.setParameter("changFileType","AC");
		<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
		BOPForDebtChangeInfoQuery_interface_dataset.setValue("qstartdate","${v_txdate}");
		BOPForDebtChangeInfoQuery_interface_dataset.setValue("qenddate","${v_txdate}");
	}

//	function locate(id) {
//		var record = BOPForDebtChangeInfoQuery_dataset.find(["id"],[id]);
//		if (record) {
//			BOPForDebtChangeInfoQuery_dataset.setRecord(record);
//		}
//	}

    function datatable1_filler2_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + value + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}

	//详细
	//function doDetail(id) {
	//	locate(id);
	//	showWin("境外同业拆借变动信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOverseaLendingChangeInfoCol.ftl?id="+id+"&op=detaile&model=Query","report","flushPage()");
	//}

	//详细
	function doDetail(id) {
		var changFileType = "AC";
		showWin("境外同业拆借变动信息","${contextPath}/fpages/datacollection/ftl/BOPForDebtOverseaLendingChangeInfoCol.ftl?id="+id+"&op=detaile&changFileType="+changFileType,"report","flushPage()");
	}

    //刷新数据
	function flushPage(){
		BOPForDebtChangeInfoQuery_dataset.flushData();
	}

</script>
</@CommonQueryMacro.page>