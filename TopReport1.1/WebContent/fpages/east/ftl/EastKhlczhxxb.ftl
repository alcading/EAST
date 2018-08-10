<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="客户理财账户信息表">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastKhlczhxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="客户理财账户信息表" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="yxjgdm[100],nbjgh[80],yxjgmc[150],bz[30],lczh[90],khxm[70],lccpmc[90],hnbsm[80],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="yxjgdm,jrxkzh,nbjgh,mxkmbh,yxjgmc,mxkmmc,bz,lczh,khtybh,khxm,glhqckzh,lccpmc,hnbsm,fezs,djfe,hlztzbz,bqsy,ljsy,mrcb,bqqsrq,bqdqrq,khrq,scdhrq,cjrq" colNm=4/>
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
    EastKhlczhxxb_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastKhlczhxxb_dataset.find(["id"],[id]);
		if(record) {
			EastKhlczhxxb_dataset.setRecord(record);
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
		EastKhlczhxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		EastKhlczhxxb_dataset.setFieldReadOnly("yxjgdm",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("jrxkzh",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("nbjgh",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("mxkmbh",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("yxjgmc",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("mxkmmc",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("bz",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("lczh",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("khtybh",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("khxm",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("glhqckzh",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("lccpmc",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("hnbsm",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("fezs",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("djfe",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("hlztzbz",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("bqsy",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("ljsy",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("mrcb",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("bqqsrq",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("bqdqrq",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("khrq",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("scdhrq",false);
		EastKhlczhxxb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastKhlczhxxb_dataset.insertRecord("end");
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
			EastKhlczhxxb_dataset.setFieldReadOnly("yxjgdm",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("jrxkzh",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("nbjgh",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("mxkmbh",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("yxjgmc",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("mxkmmc",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("bz",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("lczh",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("khtybh",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("khxm",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("glhqckzh",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("lccpmc",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("hnbsm",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("fezs",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("djfe",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("hlztzbz",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("bqsy",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("ljsy",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("mrcb",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("bqqsrq",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("bqdqrq",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("khrq",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("scdhrq",false);
			EastKhlczhxxb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastKhlczhxxb_dataset.setFieldReadOnly("yxjgdm",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("jrxkzh",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("nbjgh",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("mxkmbh",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("yxjgmc",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("mxkmmc",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("bz",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("lczh",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("khtybh",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("khxm",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("glhqckzh",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("lccpmc",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("hnbsm",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("fezs",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("djfe",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("hlztzbz",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("bqsy",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("ljsy",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("mrcb",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("bqqsrq",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("bqdqrq",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("khrq",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("scdhrq",true);
			EastKhlczhxxb_dataset.setFieldReadOnly("cjrq",true);
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
		var id = EastKhlczhxxb_dataset.getValue("id");
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
		EastKhlczhxxb_dataset.flushData(EastKhlczhxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>