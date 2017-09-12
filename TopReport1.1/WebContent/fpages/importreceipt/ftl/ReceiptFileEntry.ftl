<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="" >
<table width="1200px" align="left">
	<tr>
		<td align="left" colspan="2">
			回执导入 &gt; 回执信息导入
		</td>
	</tr>
	<tr>
		<td align="left" colspan="2">
			<hr />
		</td>
	</tr>
	<tr>
		<td width="600"  valign="top">
			<@CommonQueryMacro.CommonQuery id="receiptPackImport" init="false" submitMode="all" navigate="false">
				<table width="100%">
  					<tr>
						<td>
							<@CommonQueryMacro.Interface id="interface" label="回执信息查询" />
						</td>
					</tr>
				</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
		<td width="600" style="padding-left: 8px;padding-top: 20px;" valign="top">
			<div  id="importMsg" style="font-size: 12px;width: 99%;height:70px;overflow: auto;border: 1px solid #ededed;display: none;"></div>
		</td>
	</tr>
	<tr>
		<td width="600" valign="top">
			<@CommonQueryMacro.CommonQuery id="receiptPackImport" mode="1" navigate="false">
				<table width="100%">
					<tr>
  						<td><@CommonQueryMacro.PagePilot id="pagePilot" maxpagelink="10"/></td>
  					</tr>
  					<tr>
    					<td>
    						<@CommonQueryMacro.DataTable id="receiptFile" paginationbar="executeImport" fieldStr="appType[100],packName[180],crtDate[150],fileCount[60],subType[80],feedBackDate[150],isHashFeedBack"   hasFrame="true" height="300"  width="600" readonly="true"/>
    					</td>
  					</tr>
  					
				</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
		<td  width="600" valign="top">
			<@CommonQueryMacro.CommonQuery id="receiptFileImportEntry" init="false" submitMode="all" navigate="false">
				<table width="100%">
  					<tr>
  						<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="10"/></td>
  					</tr>
  					<tr>
    					<td>
    						<@CommonQueryMacro.DataTable id="receiptFile" fieldStr="currentFileName1,id[100],totalrecords,sucrecords,falrecords"  hasFrame="true" height="300"  width="600" readonly="true"/>
    					</td>
  					</tr>
  					<tr>
  						<td colspan="2">
							<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
								<div align="center">
									<@CommonQueryMacro.Group id="group1" label="回执文件导入详细" fieldStr="id,apptype,currentFileName1,brNo,workdate,crtTm,repFileName,repTm,filePack,repErrType,totalrecords,sucrecords,falrecords,isImpRep" colNm=4/>
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
<script type="text/javascript">

	function initCallGetter_post(){
		executeImport.disable(true);
		//interface里查询的设置工作日期默认当天
		receiptPackImport_interface_dataset.setValue("qworkdateStart",_today_date);
		receiptPackImport_interface_dataset.setValue("qworkdateEnd",_today_date);
		receiptPackImport_interface_dataset.setValue("qbusiType",defaultType);
	}

     	//定位一条记录
	function locate(id) {
		var record = receiptFileImportEntry_dataset.find(["id"],[id]);
		if (record) {
			receiptFileImportEntry_dataset.setRecord(record);
		}
	}



	function receiptPackImport_dataset_flushDataPost(dataset) {
		var record = receiptPackImport_dataset.firstUnit;
		var bl = false;
		while(record){
			var isHashFeedBack = record.getValue("isHashFeedBack");
			if(isHashFeedBack=='N'){
				bl = true;
				break;
			}
			record=record.nextUnit;
		}
	    if(bl){
	    	executeImport.disable(false);
	    }else{
	        executeImport.disable(true);
	    }
	}

	function receiptPackImport_dataset_afterScroll(dataset){
	    var pname = dataset.getValue("packName");
	    if(pname!=null&&pname.length>0){
	    	receiptFileImportEntry_dataset.setParameter("packname",pname);
	    }else{
	    	receiptFileImportEntry_dataset.setParameter("packname","");
	    }
	    receiptFileImportEntry_dataset.flushData(1);
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

     function executeImport_onClickCheck(button){
     	document.getElementById("importMsg").style.display = "";
     	document.getElementById("importMsg").innerHTML = "<font color='green'><br/>&nbsp;&nbsp;回执导入开始执行...</font>";
     	return true;
     }

    function showDetail(id){
    	locate(id);
    	var tid = receiptFileImportEntry_dataset.getValue("id");
    	var errType= receiptFileImportEntry_dataset.getValue("repErrType");
    	var isImpRep = receiptFileImportEntry_dataset.getValue("isImpRep");
    	showNWindow();

    }

	function showNWindow(){
	  	receiptFileImportEntry_dataset.setFieldReadOnly("id",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("apptype",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("currentFileName1",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("brNo",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("workdate",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("crtTm",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("repFileName",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("repTm",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("filePack",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("repErrType",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("totalrecords",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("sucrecords",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("falrecords",true);
	   	receiptFileImportEntry_dataset.setFieldReadOnly("isImpRep",true);
	   	subwindow_signWindow.show();
	}
    		//关浮动窗口,释放dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		receiptFileImportEntry_dataset.cancelRecord();
		return true;
    }
    
    function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
    }

	function executeImport_postSubmit(button){
	    var retParam = button.returnParam;
	    var msg=document.getElementById('importMsg');

	    var ret = retParam.ERRMSG;
	    var str = "<table style='line-height:20px;'>";
	    var rets = ret.split("@@");
	    for(var i=0;i<rets.length;i++){
	    	if(rets[i]!=null && rets[i].length>0){
    			str+="<tr><td><li>"+rets[i]+"</li></td></tr>";
    		}
	    }
	    str+="</table>"
        msg.innerHTML = str;

        receiptPackImport_dataset.flushData(receiptPackImport_dataset.pageIndex);
	}

</script>
</@CommonQueryMacro.page>