<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="" >
<table  width="1000px" align="left">
<tr >
	<td align="left" colspan="2">
	数据查询 &gt; 上报数据包查询
	</td>
</tr>
<tr>
	<td align="left" colspan="2">
		<hr />
	</td >
</tr>
<tr>
<td width="100%"  valign="top" colspan="2">
<@CommonQueryMacro.CommonQuery id="ReportDataPackageQueryEntry" init="false" submitMode="current" navigate="false">
<table width="100%">
  <tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" label="上报数据包查询" colNm="4"/>
		</td>
</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
<tr>
<td width="600" valign="top">
<@CommonQueryMacro.CommonQuery id="ReportDataPackageQueryEntry" mode="1" navigate="false">
<table width="100%">
	<tr>
  	<td><@CommonQueryMacro.PagePilot id="pagePilot" maxpagelink="10"/></td>
  </tr>
  <tr>
    <td>
    <@CommonQueryMacro.DataTable id="receiptFile" paginationbar="btExpSubFile,-,btExpRepFile" fieldStr="appType[100],packName[180],workDate,crtDate[150],fileCount[60],isSub,subType[70],feedBackDate[150],isHashFeedBack"  width="600" readonly="true"  hasFrame="true" height="300"/>
    </td>
  </tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td>
<td  width="600" valign="top">
<@CommonQueryMacro.CommonQuery id="ReportDataPackageDetailEntry" init="false" submitMode="all" navigate="false">
<table width="100%">
  <tr>
  	<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="10"/></td>
  </tr>
  <tr>
    <td>
    <@CommonQueryMacro.DataTable id="receiptFile1" paginationbar="btErr" fieldStr="currentFileName1,id[100],totalrecords,sucrecords,falrecords"  width="600" readonly="true"  hasFrame="true" height="300"/>
    </td>
  </tr>
  <tr>
  	<td>
	<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
		<div align="center">
			<@CommonQueryMacro.Group id="group1" label="上报数据包查询详细"
			  fieldStr="id,apptype,currentFileName1,brNo,workdate,crtTm,repFileName,repTm,filePack,repErrType,totalrecords,sucrecords,falrecords,isImpRep" colNm=4/>
			 </br>
		</div>
	 </@CommonQueryMacro.FloatWindow>
  	</td>
  </tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr></table>
<iframe id="filedownloadfrm"  style="display: none;"></iframe>
<script type="text/javascript">
	
	function initCallGetter_post(){
		//interface里查询的设置工作日期默认当天
		btErr.disable(true);
		btExpSubFile.disable(true);
		btExpRepFile.disable(true);
		ReportDataPackageQueryEntry_interface_dataset.setValue("qworkdateStart",_today_date);
		ReportDataPackageQueryEntry_interface_dataset.setValue("qworkdateEnd",_today_date);
		ReportDataPackageQueryEntry_interface_dataset.setValue("qbusiType",defaultType);
	}

     	//定位一条记录
	function locate(id) {
		var record = ReportDataPackageDetailEntry_dataset.find(["id"],[id]);
		if (record) {
			ReportDataPackageDetailEntry_dataset.setRecord(record);
		}
	}

	function qappType_DropDown_beforeOpen(dropDown){
	     var type=ReportDataPackageQueryEntry_interface_dataset.getValue("qbusiType");
	     if(type.length>0){
	     	AppTypeSelect_DropDownDataset.setParameter("type",type);
	     }
	     qappType_DropDown.cached=false;
	}
	function qbusiType_DropDown_onSelect(dropDown,record,editor){
	    var selId=record.getValue("data");
	    var oldId = ReportDataPackageQueryEntry_interface_dataset.getValue("qbusiType");
	    if(selId!=oldId){
	    	ReportDataPackageQueryEntry_interface_dataset.setValue2("qappType","");
	   	}
	    return true;
	}


     //当系统刷新单元格的内容时被触发
	function receiptFile_id_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			cell.innerHTML = "<center><a href=\"JavaScript:showDetail('"+id+"')\">"+value+"</a></center>";
		}else{
			//记录不存在的时候
			cell.innerHTML = "&nbsp;";
		}
	}

    function showDetail(id){
    	locate(id);
    	var tid = ReportDataPackageDetailEntry_dataset.getValue("id");
    	var errType= ReportDataPackageDetailEntry_dataset.getValue("repErrType");
    	var isImpRep = ReportDataPackageDetailEntry_dataset.getValue("isImpRep");
    	showNWindow();
    }

	function showNWindow(){
	  	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("id",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("apptype",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("currentFileName1",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("brNo",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("workdate",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("crtTm",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("repFileName",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("repTm",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("filePack",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("repErrType",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("totalrecords",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("sucrecords",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("falrecords",true);
	   	ReportDataPackageDetailEntry_dataset.setFieldReadOnly("isImpRep",true);
	   	subwindow_signWindow.show();
	}
    		//关浮动窗口,释放dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		ReportDataPackageDetailEntry_dataset.cancelRecord();
		return true;
    }
    
    function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
    }

    function ReportDataPackageDetailEntry_dataset_afterScroll(dataset){
	  	var currentFile = ReportDataPackageDetailEntry_dataset.getValue("currentFile");
		var repErrType = ReportDataPackageDetailEntry_dataset.getValue("repErrType");
	    if (currentFile != "TT" && (repErrType == "01" || repErrType == "02")) {
			btErr.disable(false);
		} else {
			btErr.disable(true);
		}
	}

	function ReportDataPackageQueryEntry_dataset_afterScroll(dataset){
		var pname = dataset.getValue("packName");
	    if(pname!=null&&pname.length>0){
	    	ReportDataPackageDetailEntry_dataset.setParameter("packname",pname);
	    	btExpSubFile.disable(false);
	    }else{
	    	ReportDataPackageDetailEntry_dataset.setParameter("packname","");
	    	btExpSubFile.disable(true);
	    }
	    ReportDataPackageDetailEntry_dataset.flushData(1);
	  	var sub = dataset.getValue("isHashFeedBack");
	    if (sub =='Y') {
			btExpRepFile.disable(false);
		} else {
			btExpRepFile.disable(true);
		}
	}

	function btErr_onClick(){
		var repErrType = ReportDataPackageDetailEntry_dataset.getValue("repErrType");
		var id = ReportDataPackageDetailEntry_dataset.getValue("id");
		if (repErrType == "01") {
			var paramMap = new Map();
		   	paramMap.put("recId", id);
		   	loadPageWindows("userWin", "回执文件信息", "/fpages/dataquery/ftl/ReportAlreadySubInfo.ftl", paramMap, "winZone");
		} else {
			var paramMap = new Map();
		   	paramMap.put("recId", id);
		   	loadPageWindows("userWin", "回执文件信息", "/fpages/dataquery/ftl/ReportAlreadySubInfoRecordErr.ftl", paramMap, "winZone");
		}
	}

	function downloadFile(type){
		 var apptype=ReportDataPackageQueryEntry_dataset.getValue("appType");
		 var pack = ReportDataPackageQueryEntry_dataset.getValue("packName");
		 document.getElementById("filedownloadfrm").src ="${contextPath}/download?type="+type+"&apptype="+apptype+"&pack="+pack;
	}

	function btExpSubFile_onClickCheck(button){
		downloadFile("send");
       	return false;
  	}

	function btExpRepFile_onClickCheck(button){
		downloadFile("feedback");
       	return false;
	}


</script>
</@CommonQueryMacro.page>