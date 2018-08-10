<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="理财产品销售明细记录">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastLccpxsmxjl" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="理财产品销售明细记录" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="jyh[100],hxjylsh[80],zjylsh[80],bcxh[30],mxkmmc[60],khxm[50],lccpmc[80],sgshbz[60],bz[20],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="jyh,hxjylsh,zjylsh,bcxh,yxjgdm,jrxkzh,nbjgh,mxkmbh,yxjgmc,mxkmmc,lczh,khtybh,khxm,glhqckzh,lccpmc,hnbsm,sgshbz,bz,hxjyrq,jyje,jyfe,jyfy,jyqd,khjlgh,khjlxm,jygyh,cjrq" colNm=4/>
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
    EastLccpxsmxjl_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastLccpxsmxjl_dataset.find(["id"],[id]);
		if(record) {
			EastLccpxsmxjl_dataset.setRecord(record);
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
		EastLccpxsmxjl_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		EastLccpxsmxjl_dataset.setFieldReadOnly("jyh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("hxjylsh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("zjylsh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("bcxh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("yxjgdm",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("jrxkzh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("nbjgh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("mxkmbh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("yxjgmc",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("mxkmmc",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("lczh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("khtybh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("khxm",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("glhqckzh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("lccpmc",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("hnbsm",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("sgshbz",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("bz",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("hxjyrq",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("jyje",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("jyfe",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("jyfy",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("jyqd",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("khjlgh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("khjlxm",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("jygyh",false);
		EastLccpxsmxjl_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastLccpxsmxjl_dataset.insertRecord("end");
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
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("hxjylsh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("zjylsh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("bcxh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("yxjgdm",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jrxkzh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("nbjgh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("mxkmbh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("yxjgmc",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("mxkmmc",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("lczh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("khtybh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("khxm",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("glhqckzh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("lccpmc",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("hnbsm",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("sgshbz",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("bz",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("hxjyrq",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyje",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyfe",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyfy",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyqd",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("khjlgh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("khjlxm",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jygyh",false);
			EastLccpxsmxjl_dataset.setFieldReadOnly("cjrq",false);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("hxjylsh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("zjylsh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("bcxh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("yxjgdm",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jrxkzh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("nbjgh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("mxkmbh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("yxjgmc",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("mxkmmc",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("lczh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("khtybh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("khxm",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("glhqckzh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("lccpmc",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("hnbsm",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("sgshbz",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("bz",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("hxjyrq",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyje",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyfe",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyfy",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jyqd",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("khjlgh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("khjlxm",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("jygyh",true);
			EastLccpxsmxjl_dataset.setFieldReadOnly("cjrq",true);
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
		var id = EastLccpxsmxjl_dataset.getValue("id");
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
		EastLccpxsmxjl_dataset.flushData(EastLccpxsmxjl_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>