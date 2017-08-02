<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="数据分析">
<script type='text/javascript' src='${contextPath}/dwr/interface/ReportFile.js'> </script>
<table width="95%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="analyseDataEntry" init="false" submitMode="current">
	<table width="100%">
		<tr>
			<td valign="top">
				<@CommonQueryMacro.Interface id="interface" label="数据分析查询" colNm=4 showButton="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.PagePilot id="pagePilot"  maxpagelink="9" showArrow="true" pageCache="false"/>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.DataTable id="dataTable1" paginationbar="btToAnalysis" fieldStr="workDate,busiType,appType,operTm,processStatus,processResult,operTlr,detailRemark,opr"  width="100%" hasFrame="true" height="100%"  />
			</td>
		</tr>

	</table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>
<script language="javascript">

   function initCallGetter_post(){
	 //interface里查询的设置工作日期默认当天
		analyseDataEntry_interface_dataset.setValue("qworkDate",_today_date);
		analyseDataEntry_interface_dataset.setValue("qbusiType",defaultType);
	   
   }
	
	//当系统刷新单元格的内容时被触发
	function dataTable1_opr_onRefresh(cell,value,record) {
		if(record&&record!=null){//当存在记录时
			var id = record.getValue("id");
			if(id==null || id.trim().length==0){
				cell.innerHTML="<center><a href='#' title='数据分析尚未执行' style='color:#666666'>详细</a></center>";
			}else{
				cell.innerHTML="<center><a href=\"javascript:doDetail('"+id+"')\">详细</a></center>";
			}
		} else {//当不存在记录时
		 	cell.innerHTML="&nbsp;";
		}
	}
	//定位一条记录
	function locate(id) {
		var record = analyseDataEntry_dataset.find(["analyNo"],[id]);
		if (record) {
			analyseDataEntry_dataset.setRecord(record);
		}
	}

	function doDetail(id){
		var paramsMap = new Map();
		paramsMap.put("analyNo",id);
		loadPageWindows("detailWindow","详细","/fpages/dataaudit/ftl/ExecuteResult.ftl",paramsMap,"winZone");
	}



	function analyseDataEntry_dataset_afterScroll(dataset){
		var sta = dataset.getValue("processStatus");
		var ret = dataset.getValue("processResult");
		btToAnalysis.disable(true);
		if(sta=="00" || ret=="02"){
			btToAnalysis.disable(false);
		}
	}

	function btToAnalysis_onClickCheck(button){
		dwr.engine.setAsync(false);
		var sta = null;
		ReportFile.isAnalyExecute(analyseDataEntry_dataset.getValue("workDate"),function(data){
			sta = data;
		});
		dwr.engine.setAsync(true);
		if(sta=="02"){
			var t =window.confirm("未执行数据导入，确定要执行分析吗？");
			return t;
		}else if(sta=="03"){
			var t =window.confirm("导入数据存在错误未修正，确定要执行分析吗？");
			return t;
		}else{
			return true;
		}
	}

	function btToAnalysis_postSubmit(button) {
		analyseDataEntry_dataset.flushData(analyseDataEntry_dataset.pageIndex);
		var retParam = button.returnParam;
		var analyNo = retParam.analyNo;
		doDetail(analyNo);
		return;
	}

	function qappType_DropDown_beforeOpen(dropDown){
	     var type=analyseDataEntry_interface_dataset.getValue("qbusiType");
	     if(type.length>0){
	     	AppTypeSelect_DropDownDataset.setParameter("type",type);
	     }
	     qappType_DropDown.cached=false;
	}
	function qbusiType_DropDown_onSelect(dropDown,record,editor){
	    var selId=record.getValue("data");
	    var oldId = analyseDataEntry_interface_dataset.getValue("qbusiType");
	    if(selId!=oldId){
	    	analyseDataEntry_interface_dataset.setValue2("qappType","");
	   	}
	    return true;
	}
</script>
</@CommonQueryMacro.page>
