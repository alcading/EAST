<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="涉农统计表">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastSntjb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="涉农统计表" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="jrjgdm[100],nbjgh[80],tjkmbh[80],tjkmmc[100],tjkmje[70],qxlx[50],tjrq[70],bz[40],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="jrjgdm,jrxkzh,nbjgh,tjkmbh,tjkmmc,tjkmje,qxlx,tjrq,bz,dqmc,xzqhdm,cjrq" colNm=4/>
        			<br/>
        			<@CommonQueryMacro.Button id="btModOrAdd" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<@CommonQueryMacro.Button id="btCancel" />
      			</div>
     		</@CommonQueryMacro.FloatWindow>	
  		</td>
  	</tr>
	<tr style="display:none">
		<td><@CommonQueryMacro.Button id="btDel" /></td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr>
</table>
<script language="JavaScript">

//给查询条件中的默认值为当前月的上一个月的最后一天
window.onload=function(){
	var date = new Date();
    var day = new Date(date.getFullYear(), date.getMonth(), 0).getDate();
	var enddate = new Date(new Date().getFullYear(), new Date().getMonth()-1, day);
    EastSntjb_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastSntjb_dataset.find(["id"],[id]);
		if(record) {
			EastSntjb_dataset.setRecord(record);
		}
	}
	//系统刷新单元格
	function datatable1_operation_onRefresh(cell,value,record) {
		if(record) {
			var id = record.getValue("id");
			
			if( !(''==id || null == id))
			{
				cell.innerHTML="<center><a href=\"JavaScript:openModifyWindow('"+id+"',1)\"><@bean.message key='修改'/></a> &nbsp; </center>";
			}
			
		}else {
			cell.innerHTML="&nbsp;";
		}
	}
	function btAdd_onClick(button) {
			btNewClick();
	}
	//取消功能
	function btCancel_onClickCheck(button) {
		//关闭浮动窗口
		subwindow_signWindow.close();
	}
	//关浮动窗口,释放dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		EastSntjb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		EastSntjb_dataset.setFieldReadOnly("jrjgdm",false);
		EastSntjb_dataset.setFieldReadOnly("jrxkzh",false);
		EastSntjb_dataset.setFieldReadOnly("nbjgh",false);
		EastSntjb_dataset.setFieldReadOnly("tjkmbh",false);
		EastSntjb_dataset.setFieldReadOnly("tjkmmc",false);
		EastSntjb_dataset.setFieldReadOnly("tjkmje",false);
		EastSntjb_dataset.setFieldReadOnly("qxlx",false);
		EastSntjb_dataset.setFieldReadOnly("tjrq",false);
		EastSntjb_dataset.setFieldReadOnly("bz",false);
		EastSntjb_dataset.setFieldReadOnly("dqmc",false);
		EastSntjb_dataset.setFieldReadOnly("xzqhdm",false);
		EastSntjb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastSntjb_dataset.insertRecord("end");
		subwindow_signWindow.show();
	}
	
	/**
	//展示对比功能的js
	function datatable1_id_onRefresh(cell, value, record){
		if(record!=null){
			var id=record.getValue("id");
			cell.innerHTML = "<a href=\"Javascript:openModifyWindow('"+id+"',2)\">"+id+"</a>";
		} else {
			cell.innerHTML = ""
		}
	}
    **/

	//修改功能
	function openModifyWindow(id,flag) {
		locate(id);
		if(flag==1){
			EastSntjb_dataset.setFieldReadOnly("jrjgdm",false);
			EastSntjb_dataset.setFieldReadOnly("jrxkzh",false);
			EastSntjb_dataset.setFieldReadOnly("nbjgh",true);
			EastSntjb_dataset.setFieldReadOnly("tjkmbh",true);
			EastSntjb_dataset.setFieldReadOnly("tjkmmc",false);
			EastSntjb_dataset.setFieldReadOnly("tjkmje",false);
			EastSntjb_dataset.setFieldReadOnly("qxlx",true);
			EastSntjb_dataset.setFieldReadOnly("tjrq",true);
			EastSntjb_dataset.setFieldReadOnly("bz",true);
			EastSntjb_dataset.setFieldReadOnly("dqmc",false);
			EastSntjb_dataset.setFieldReadOnly("xzqhdm",false);
			EastSntjb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastSntjb_dataset.setFieldReadOnly("jrjgdm",true);
			EastSntjb_dataset.setFieldReadOnly("jrxkzh",true);
			EastSntjb_dataset.setFieldReadOnly("nbjgh",true);
			EastSntjb_dataset.setFieldReadOnly("tjkmbh",true);
			EastSntjb_dataset.setFieldReadOnly("tjkmmc",true);
			EastSntjb_dataset.setFieldReadOnly("tjkmje",true);
			EastSntjb_dataset.setFieldReadOnly("qxlx",true);
			EastSntjb_dataset.setFieldReadOnly("tjrq",true);
			EastSntjb_dataset.setFieldReadOnly("bz",true);
			EastSntjb_dataset.setFieldReadOnly("dqmc",true);
			EastSntjb_dataset.setFieldReadOnly("xzqhdm",true);
			EastSntjb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="none";
		}
		subwindow_signWindow.show();	
	}
	
	function doDel(id) {
		locate(id);
		btDel.click();
	}
	
	function btDel_onClickCheck(button) {
		return confirm("确认删除该条记录？");
	}
	function btDel_postSubmit(button) {
		
		button.url="#";
		//刷新当前页
		flushCurrentPage();
	}
	function btModOrAdd_onClickCheck(button) {
		var id = EastSntjb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("字段[内部机构号]不能为空");
			return false;
		}
		return true;
	}
	//保存后刷新当前页
	function btModOrAdd_postSubmit(button) {
		button.url="#";
		subwindow_signWindow.close();
		flushCurrentPage();
	}
	//刷新当前页
	function flushCurrentPage() {
		EastSntjb_dataset.flushData(EastSntjb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>