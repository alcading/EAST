<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="CurrencyManEntry.title">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="CurrencyManEntry" init="false" submitMode="current">
      		<table width="800px">

      			<tr>
      			  <td colspan="2" valign="top">
      			    <@CommonQueryMacro.Interface id="interface" label="CurrencyManEntry.interface.interface.label" />
      			  </td>
      			</tr>

      			<tr>

      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>
					
      			</tr>

      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" paginationbar="btNew" fieldStr="id,currencyName,dotNum,st,opr[120]" width="100%" hasFrame="true" readonly="true" />
      			  </td>
      			 </tr>
      			 <tr>
		      		<td colspan="2">
		      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
		      			<div align="center">
		      				<@CommonQueryMacro.Group id="group1" label="CurrencyManEntry.group.group1.label"
		        			  fieldStr="id,currencyName,dotNum" colNm=4/>
		        			 </br>
		      				<@CommonQueryMacro.Button id= "btSave"/>
		      			</div>
		     		 </@CommonQueryMacro.FloatWindow>

		  			</td>
  				</tr>
      			 <tr style="display:none">
					<td colspan="2">
						<@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btMod"/>&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						<span id="size"> </span>&nbsp;&nbsp;<span id="show"> </span>
					</td>
				</tr>
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">



	function btSave_postSubmit(button){
		alert("保存成功！");
	}

	//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var lock = record.getValue("lock");
			if(isTrue(lock)){
				cell.innerHTML = "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\"><@bean.message key="CurrencyManEntry.button.btMod" /></a> &nbsp; <a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\"><@bean.message key="CurrencyManEntry.button.btDel" /></a></center>";
			}else{
				cell.innerHTML="<center><a href=\"JavaScript:doModify('"+value+"')\"><@bean.message key="CurrencyManEntry.button.btMod" /></a> &nbsp; <a href=\"JavaScript:doDelete('"+value+"')\"><@bean.message key="CurrencyManEntry.button.btDel" /></a></center>";
			}
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}
	}

	//定位一条记录
	function locate(id) {

		var record = CurrencyManEntry_dataset.find(["id"],[id]);
		if (record) {
			CurrencyManEntry_dataset.setRecord(record);
		}
	}

	//修改
	function doModify(id) {
		locate(id);

		 CurrencyManEntry_dataset.setFieldReadOnly("id",true);
		 CurrencyManEntry_dataset.setFieldReadOnly("currencyName",false);
		 CurrencyManEntry_dataset.setFieldReadOnly("dotNum",false);

		subwindow_signWindow.show();
	}

	//删除
	function doDelete(id) {
		locate(id);

		if(confirm('是否删除当前记录'))
		{
			btDel.click();
		}
	}
//展示对比功能的js
	function datatable1_id_onRefresh(cell, value, record){
	if(record!=null){
		var sta = record.getValue("st");
		var id=record.getValue("id");


		cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"','"+sta+"')\">"+id+"</a>";

	} else {
		cell.innerHTML = ""
	}
}


function showDetail(id,sta){

	var paramMap = new Map();
	paramMap.put("id",id);
	paramMap.put("st",sta);
	paramMap.put("action","detail");
	paramMap.put("flag","0");
	loadPageWindows("partWin", "币种信息维护","/fpages/basis/ftl/CurrencyManEntryDetail.ftl", paramMap, "winZone");
}

	function btNew_onClick(button){

		  subwindow_signWindow.show();
		  var  v_currencyCode = CurrencyManEntry_dataset.getValue("id");
		  //数据库中的记录。

		  if (v_currencyCode!=""  ){
		    CurrencyManEntry_dataset.setFieldReadOnly("id",true);
		    CurrencyManEntry_dataset.setFieldReadOnly("currencyName",true);
		    CurrencyManEntry_dataset.setFieldReadOnly("dotNum",true);
		  }else{
		    CurrencyManEntry_dataset.setFieldReadOnly("id",false);
		    CurrencyManEntry_dataset.setFieldReadOnly("currencyName",false);
		    CurrencyManEntry_dataset.setFieldReadOnly("dotNum",false);
		  }
	}

	function signWindow_floatWindow_beforeClose(subwindow){
		 CurrencyManEntry_dataset.cancelRecord();
		 return true;
	}
	
	function signWindow_floatWindow_beforeHide(subwindow){
		return signWindow_floatWindow_beforeClose(subwindow);
	}

</script>
</@CommonQueryMacro.page>