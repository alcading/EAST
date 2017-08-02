<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCfaExplrmbloDsGenTabs" navigate="false" currentTab="BopCfaExplrmbloDsGen">
		<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsGen" init="false" submitMode="current" navigate="false" >
			<table align="left">
				<tr>
					<td>
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
					</td>
	    		</tr>
	    		<tr>
	    			<td>
						<@CommonQueryMacro.DataTable id ="datatable" hasFrame="true"
							fieldStr="filler2,workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],explrmblono[130],creditorcode,debtorcode[80],debtorname,valuedate[100],maturity[100],credconcurr[150],credconamount[100]" readonly="true" hasFrame="true" width="900" height="260"/>
	      			</td>
	    		</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">

		//当系统刷新单元格的内容时被触发
		function datatable_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				cell.innerHTML = "<center><a style='text-decoration:none' href=\"JavaScript:doDetail('" + id + "')\">" + value + "</a></center>";
			} else {
				//当不存在记录时
			 	cell.innerHTML="&nbsp;";
			}
		}

		//查询
		function doDetail(id){
			showWin("签约信息查询","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsAdd.ftl?op=detail&id="+id,"report1","flushPage()");
		}

		//刷新数据
		function flushPage(){
			BopCfaExplrmbloDsGen_dataset.flushData();
		}
	</script>
</@CommonQueryMacro.page>