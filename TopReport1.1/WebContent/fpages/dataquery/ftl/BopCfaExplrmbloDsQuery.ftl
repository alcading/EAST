<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="信息补录查询">
	<@CommonQueryMacro.CommonQueryTab id="BopCfaExplrmbloDsQueryTabs" navigate="false" currentTab="BopCfaExplrmbloDsQuery">
		<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsQuery" init="false" submitMode="current" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
					</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
						<@CommonQueryMacro.DataTable id ="BopCfaExplrmbloDsQueryTable" hasFrame="true"
							fieldStr="filler2,workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],explrmblono[130],creditorcode,debtorcode[80],debtorname,valuedate[100],maturity[100],credconcurr[150],credconamount[100]" readonly="true" hasFrame="true" width="900" height="260"/>
	      			</td>
	    		</tr>

			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>
	<script language="JavaScript">
		function initCallGetter_post() {
			//起始工作日期默认当前日期
			<#assign v_date = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BopCfaExplrmbloDsQuery_interface_dataset.setValue("workDateStart","${v_date}");
			BopCfaExplrmbloDsQuery_interface_dataset.setValue("workDateEnd","${v_date}");
		}
		//当系统刷新单元格的内容时被触发
		function BopCfaExplrmbloDsQueryTable_filler2_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				var id = record.getValue("id");
				var filler2 = record.getValue("filler2");
				cell.innerHTML = "<center><a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">"+filler2+"</a></center>";
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
			BopCfaExplrmbloDsQuery_dataset.flushData();
		}

	</script>
</@CommonQueryMacro.page>