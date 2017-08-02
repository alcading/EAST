<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<script type='text/javascript' src='${contextPath}/dwr/interface/ReportFile.js'> </script>
<@CommonQueryMacro.page title="工作日期切换">
<table align="left" width="100%">
	<tr>
		<td width="100%">
			主页 &gt; 系统维护 &gt; 工作日期切换
		</td>
	</tr>
	<tr>
		<td width="100%">
			<hr />
		</td >
	</tr>
	<tr>
		<td valign="top" align="left" width="100%">
			<table>
				<tr>
					<td width="400">
						<@CommonQueryMacro.CommonQuery id="cutoverWorkDate" init="true" navigate="false" submitMode="current">
							<FIELDSET><LEGEND>&nbsp;切换工作日期&nbsp;</LEGEND>
							<table class="grouptable" width="100%">
								<tr>
									<td class="labeltd">
									&nbsp;&nbsp;上一工作日&nbsp;&nbsp;
									</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="lastDate"/>
									</td>
									<td>&nbsp;&nbsp</td>
									<td class="labeltd" id="lastDateDay"></td>
								</tr>
								<tr><td colspan="4"><br></td></tr>
								<tr>
									<td class="labeltd">
									&nbsp;&nbsp;当前工作日&nbsp;&nbsp;
									</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="currentDate"/>
									</td>
									<td>&nbsp;&nbsp</td>
									<td class="labeltd" id="currentDateDay"></td>
								</tr>
								<tr><td colspan="4"><br></td></tr>
								<tr>
									<td class="labeltd">
									&nbsp;&nbsp;下一工作日&nbsp;&nbsp;
									</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="nextDate"/>
									</td>
									<td>&nbsp;&nbsp</td>
									<td class="labeltd" id="nextDateDay"></td>
								</tr>
							</table>
							</FIELDSET>
							<br>
							<table class="grouptable" width="100%">
								<tr>
									<td align="left">
										<@CommonQueryMacro.Button id= "btSave" />
									</td>
								</tr>
							</table>
						</@CommonQueryMacro.CommonQuery>
					</td>
					<td width="10"></td>
					<td valign="top" align="left" width="340">
					<FIELDSET><LEGEND>&nbsp;工作完成情况&nbsp;</LEGEND>
						<@CommonQueryMacro.CommonQuery id="biExecConfirmed" init="true" submitMode="current" navigate="false">
							<@CommonQueryMacro.DataTable id="datatable1" fieldStr="brNo,brName,finishStatus" width="100%" hasFrame="true"/>
						</@CommonQueryMacro.CommonQuery>
						</FIELDSET>
					</td>
					<td width="10"></td>
					<td valign="top" align="left" width="500">
						<FIELDSET><LEGEND>&nbsp;工作完成详情&nbsp;</LEGEND>
						<@CommonQueryMacro.CommonQuery id="biExecConfirmedDetail" init="true" submitMode="current" navigate="false">
							<@CommonQueryMacro.DataTable id="datatable1" fieldStr="busiType,apptype,confirmStatus,subfileStatus" width="100%" hasFrame="true"/>
						</@CommonQueryMacro.CommonQuery>
						</FIELDSET>
					</td>
				<tr>
			</table>
		</td>
	</tr>
</table>
<script language="javascript">
	function initCallGetter_post(){
		var lastDate = cutoverWorkDate_dataset.getValue("lastDate");
		document.getElementById("lastDateDay").innerHTML=dayStr(lastDate.getDay());
		var currentDate = cutoverWorkDate_dataset.getValue("currentDate");
		document.getElementById("currentDateDay").innerHTML=dayStr(currentDate.getDay());
    	var nextDate= cutoverWorkDate_dataset.getValue("nextDate");
		document.getElementById("nextDateDay").innerHTML=dayStr(nextDate.getDay());
	}

	function dayStr(day){
		if (day == 0) {
			return "&nbsp;星期天&nbsp;&nbsp;&nbsp;"
		} else if (day == 1) {
			return "&nbsp;星期一&nbsp;&nbsp;&nbsp;"
		}else if (day == 2) {
			return "&nbsp;星期二&nbsp;&nbsp;&nbsp;"
		}else if (day == 3) {
			return "&nbsp;星期三&nbsp;&nbsp;&nbsp;"
		}else if (day == 4) {
			return "&nbsp;星期四&nbsp;&nbsp;&nbsp;"
		}else if (day == 5) {
			return "&nbsp;星期五&nbsp;&nbsp;&nbsp;"
		}else if (day == 6) {
			return "&nbsp;星期六&nbsp;&nbsp;&nbsp;"
		}
	}

	function date_afterClick(date){
	 	document.getElementById("nextDateDay").innerHTML=dayStr(date.getDay());
	}

	function btSave_onClickCheck(){
		var flag = false;
		dwr.engine.setAsync(false);
		ReportFile.getIsAllOrgFinished(function(data){
			flag = data;
		});
		dwr.engine.setAsync(true);
		if(!flag){
			if(confirm('不是所有的机构工作完成锁定，是否确认要切换工作日期？')){
				return true;
			} else {
				return false;
			}
		}
		
		//var flag = false;
		//var record = biExecConfirmed_dataset.getFirstRecord();
		//while(record){
		//	var v_finishStatus = record.getValue("finishStatus");
		//	//判断是否数据处理完成
		//	if(v_finishStatus == "02"){
		//		flag = true;
		//		break;
		//	}
		//	record=record.getNextRecord();
	   	//}
	   	//if(flag){
	   	//	alert("当前工作日期的数据处理未完成不能切换工作日期！");
	   	//	return false;
	   	//}
	   	//return true;
	}
	
	function biExecConfirmed_dataset_afterScroll(dataset){
		var brNo = dataset.getValue("brNo"); 
		if(brNo != null && brNo.length>0){
			biExecConfirmedDetail_dataset.setParameter("brNo",brNo);
	    	biExecConfirmedDetail_dataset.flushData(1);
		}
	}

</script>
</@CommonQueryMacro.page>
