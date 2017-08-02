<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
<@CommonQueryMacro.page title="变动信息">
	<@CommonQueryMacro.CommonQueryTab id="BOPCfaLounexguDataQueryTabs" navigate="false" currentTab="BOPCfaLounexguChangeDataQuery">
		<@CommonQueryMacro.CommonQuery id="BOPCfaLounexguChangeDataQuery" init="false" submitMode="all" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
					</td>
		    	</tr>

		    	<tr>
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[75],brNo,brNoName[150],workDate[75],actiontype[75],recStatus[75],approveStatus[75],repStatus[75],lounexgucode[80],buscode[80],changeno[80],credcurrcode[70],credwithamount[75],credrepayamount[70],picamount[70],credprinbala[75],guarantlibala[70],guperamount[70]"   hasFrame="true" width="1000" height="260" readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQueryTab>

	<script language="JavaScript">
	
	        function initCallGetter_post(){
	        	<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
				//interface里查询的设置工作日期默认当天
				BOPCfaLounexguChangeDataQuery_interface_dataset.setValue("qworkDate","${v_txdate}");
				BOPCfaLounexguChangeDataQuery_interface_dataset.setValue("eworkDate","${v_txdate}");        	
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

		//详细信息
		function doDetail(id){
			showWin("变动信息明细","${contextPath}/fpages/datacollection/ftl/BOPCfaLounexguRecordChangeInfoEdit.ftl?id=" + id + "&op=detail");
		}
	</script>
</@CommonQueryMacro.page>