<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="" >
<table  width="90%" align="left">
	<tr >
		<td align="left" colspan="2">
			文件报送 &gt; 生成文件报送
		</td>
	</tr>

	<tr>
		<td align="left" colspan="2">
			<hr />
		</td >
	</tr>

	<tr>
		<td width="100%"  valign="top" colspan="2">
			<@CommonQueryMacro.CommonQuery id="reportSubFile" init="false" submitMode="current" navigate="false">
				<table width="100%">
  					<tr>
						<td>
							<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm="4"/>
						</td>
					</tr>
				</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>

	<tr>
		<td width="60%" valign="top">
			<@CommonQueryMacro.CommonQuery id="reportSubFile" mode="1" navigate="false">
				<table width="100%">
					<tr>
  						<td><@CommonQueryMacro.PagePilot id="pagePilot" maxpagelink="10"/></td>
  					</tr>

  					<tr>
    					<td>
    						<@CommonQueryMacro.DataTable paginationbar="btSend,-,btExpSubFile" id="receiptFile" fieldStr="appType[100],packName[180],crtDate[150],fileCount[60]"  width="100%" readonly="true"  hasFrame="true" height="300"/>
    					</td>
  					</tr>

				</table>
			</@CommonQueryMacro.CommonQuery>
		</td>

		<td  width="40%" valign="top">
			<@CommonQueryMacro.CommonQuery id="reportSubFileDetail" init="false" submitMode="all" navigate="false">
				<table width="100%">
  					<tr>
  						<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="10"/></td>
  					</tr>

  					<tr>
    					<td>
    						<@CommonQueryMacro.DataTable id="receiptFile" fieldStr="currentFileName1[180],id[180],totalrecords"  width="100%" height="300" hasFrame="true" readonly="true"/>
    					</td>
  					</tr>

  					<tr>
  						<td colspan="2">
							<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
								<div align="center">
									<@CommonQueryMacro.Group id="group1" label="上报数据包查询详细" fieldStr="id,apptype,currentFileName1,brNo,workdate,crtTm,repFileName,repTm,filePack,repErrType,totalrecords,sucrecords,falrecords,isImpRep" colNm=4/>
			 						</br>
								</div>
	 						</@CommonQueryMacro.FloatWindow>
  						</td>
  					</tr>
				</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<iframe id="filedownloadfrm"  style="display: none;"></iframe>
<script type="text/javascript">

	function initCallGetter_post(){
		btExpSubFile.disable(true);
		btSend.disable(true);
		//interface里查询的设置工作日期默认当天
		reportSubFile_interface_dataset.setValue("qworkdateStart",_today_date);
		reportSubFile_interface_dataset.setValue("qworkdateEnd",_today_date);
		reportSubFile_interface_dataset.setValue("qbusiType",defaultType);
	}
	

     	//定位一条记录
	function locate(id) {
		var record = reportSubFileDetail_dataset.find(["id"],[id]);
		if (record) {
			reportSubFileDetail_dataset.setRecord(record);
		}
	}

	function reportSubFile_dataset_flushDataPost(dataset){
		if(reportSubFile_dataset.length>0){
			btExpSubFile.disable(false);
			btSend.disable(false);
		}else{
			btExpSubFile.disable(true);
			btSend.disable(true);
		}
	}

	function qappType_DropDown_beforeOpen(dropDown){
	     var type=reportSubFile_interface_dataset.getValue("qbusiType");
	     if(type.length>0){
	     	AppTypeSelect_DropDownDataset.setParameter("type",type);
	     }
	     qappType_DropDown.cached=false;
	}
	function qbusiType_DropDown_onSelect(dropDown,record,editor){
	    var selId=record.getValue("data");
	    var oldId = reportSubFile_interface_dataset.getValue("qbusiType");
	    if(selId!=oldId){
	    	reportSubFile_interface_dataset.setValue2("qappType","");
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
    	var tid = reportSubFileDetail_dataset.getValue("id");
    	var errType= reportSubFileDetail_dataset.getValue("repErrType");
    	var isImpRep = reportSubFileDetail_dataset.getValue("isImpRep");
    	showNWindow();

    }

	function showNWindow(){
	  	reportSubFileDetail_dataset.setFieldReadOnly("id",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("apptype",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("currentFileName1",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("brNo",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("workdate",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("crtTm",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("repFileName",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("repTm",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("filePack",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("repErrType",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("totalrecords",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("sucrecords",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("falrecords",true);
	   	reportSubFileDetail_dataset.setFieldReadOnly("isImpRep",true);
	   	subwindow_signWindow.show();
	}
    		//关浮动窗口,释放dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		reportSubFileDetail_dataset.cancelRecord();
		return true;
    }
    
    function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
    }


	function reportSubFile_dataset_afterScroll(dataset){
		var pname = dataset.getValue("packName");
	    if(pname!=null&&pname.length>0){
	    	reportSubFileDetail_dataset.setParameter("packname",pname);
	    }else{
	    	reportSubFileDetail_dataset.setParameter("packname","");
	    }
	    reportSubFileDetail_dataset.flushData(reportSubFileDetail_dataset.pageIndex);
	}

	function downloadFile(type){
		 var apptype=reportSubFile_dataset.getValue("appType");
		 var pack = reportSubFile_dataset.getValue("packName");
		 document.getElementById("filedownloadfrm").src ="${contextPath}/download?type="+type+"&apptype="+apptype+"&pack="+pack;
	}

	function btSend_postSubmit(button){
		var pack = reportSubFile_dataset.getValue("packName");
		alert(pack+"报送执行成功！");
		reportSubFile_dataset.flushData(reportSubFile_dataset.pageIndex);
  	}

	function btExpSubFile_onClickCheck(button){
		var bl = window.confirm("采用‘导出报送’后系统将记录该文件包已报送，\n将不能采用‘上传报送’，确定吗?");
		if(bl){
			downloadFile("send");
		}
		return bl;
	}

	function btExpSubFile_postSubmit(button){
		reportSubFile_dataset.flushData(reportSubFile_dataset.pageIndex);
  	}


</script>
</@CommonQueryMacro.page>