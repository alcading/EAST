<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQueryTab id="BopCfaExplrmbloDsQueryTabs" navigate="false" currentTab="BopCfaExplrmbloDsChangeInfoQuery">
		<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsChangeInfoQuery" init="false" submitMode="current" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>
				<tr>
					<td colspan="2" valign="top">
						<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
					</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
						<@CommonQueryMacro.DataTable id ="BopCfaExplrmbloDsChangeInfoQueryTable" hasFrame="true"
							fieldStr="filler2,workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],explrmblono[130],buocmonth[130],changeno,monbeloadbal[100],monenloadbal[100]" readonly="true" hasFrame="true" width="900" height="260"/>
	      			</td>
	    		</tr>

			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">
		function initCallGetter_post() {
			//起始工作日期默认当前日期
			<#assign v_date = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			BopCfaExplrmbloDsChangeInfoQuery_interface_dataset.setValue("workDateStart","${v_date}");
			BopCfaExplrmbloDsChangeInfoQuery_interface_dataset.setValue("workDateEnd","${v_date}");
		}
		//当系统刷新单元格的内容时被触发
		function BopCfaExplrmbloDsChangeInfoQueryTable_filler2_onRefresh(cell,value,record) {
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
			showWin("变动信息查询","${contextPath}/fpages/datacollection/ftl/BopCfaExplrmbloDsChangeInfoAdd.ftl?op=detail&id="+id,"report1","flushPage()");
		}

				//刷新数据
		function flushPage(){
			BopCfaExplrmbloDsChangeInfoQuery_dataset.flushData();
		}

	</script>
</@CommonQueryMacro.page>