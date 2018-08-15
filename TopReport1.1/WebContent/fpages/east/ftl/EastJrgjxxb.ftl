<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="金融工具信息表">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastJrgjxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="金融工具信息表" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="yxjgdm[100],nbjgh[80],zqmc[100],jrgjbh[100],zclx[60],fxjg[100],fxgb[80],cppj[60],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="yxjgdm,jrxkzh,nbjgh,yxjgmc,zqmc,jrgjbh,zclx,bz,fxjg,yxczqydm,fxgb,dbjg,cppj,pjjg,fxztpj,jyzhlx,pmll,fxjge,fxrq,ssrq,qxrq,dqrq,lllx,hqbs,zjpgjg,pgjgsj,ye,cjrq" colNm=4/>
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
    EastJrgjxxb_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastJrgjxxb_dataset.find(["id"],[id]);
		if(record) {
			EastJrgjxxb_dataset.setRecord(record);
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
		EastJrgjxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		EastJrgjxxb_dataset.setFieldReadOnly("yxjgdm",false);
		EastJrgjxxb_dataset.setFieldReadOnly("jrxkzh",false);
		EastJrgjxxb_dataset.setFieldReadOnly("nbjgh",false);
		EastJrgjxxb_dataset.setFieldReadOnly("yxjgmc",false);
		EastJrgjxxb_dataset.setFieldReadOnly("zqmc",false);
		EastJrgjxxb_dataset.setFieldReadOnly("jrgjbh",false);
		EastJrgjxxb_dataset.setFieldReadOnly("zclx",false);
		EastJrgjxxb_dataset.setFieldReadOnly("bz",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxjg",false);
		EastJrgjxxb_dataset.setFieldReadOnly("yxczqydm",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxgb",false);
		EastJrgjxxb_dataset.setFieldReadOnly("dbjg",false);
		EastJrgjxxb_dataset.setFieldReadOnly("cppj",false);
		EastJrgjxxb_dataset.setFieldReadOnly("pjjg",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxztpj",false);
		EastJrgjxxb_dataset.setFieldReadOnly("jyzhlx",false);
		EastJrgjxxb_dataset.setFieldReadOnly("pmll",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxjge",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxrq",false);
		EastJrgjxxb_dataset.setFieldReadOnly("ssrq",false);
		EastJrgjxxb_dataset.setFieldReadOnly("qxrq",false);
		EastJrgjxxb_dataset.setFieldReadOnly("dqrq",false);
		EastJrgjxxb_dataset.setFieldReadOnly("lllx",false);
		EastJrgjxxb_dataset.setFieldReadOnly("hqbs",false);
		EastJrgjxxb_dataset.setFieldReadOnly("zjpgjg",false);
		EastJrgjxxb_dataset.setFieldReadOnly("pgjgsj",false);
		EastJrgjxxb_dataset.setFieldReadOnly("ye",false);
		EastJrgjxxb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastJrgjxxb_dataset.insertRecord("end");
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
			EastJrgjxxb_dataset.setFieldReadOnly("yxjgdm",false);
			EastJrgjxxb_dataset.setFieldReadOnly("jrxkzh",false);
			EastJrgjxxb_dataset.setFieldReadOnly("nbjgh",false);
			EastJrgjxxb_dataset.setFieldReadOnly("yxjgmc",false);
			EastJrgjxxb_dataset.setFieldReadOnly("zqmc",false);
			EastJrgjxxb_dataset.setFieldReadOnly("jrgjbh",true);
			EastJrgjxxb_dataset.setFieldReadOnly("zclx",false);
			EastJrgjxxb_dataset.setFieldReadOnly("bz",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxjg",false);
			EastJrgjxxb_dataset.setFieldReadOnly("yxczqydm",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxgb",false);
			EastJrgjxxb_dataset.setFieldReadOnly("dbjg",false);
			EastJrgjxxb_dataset.setFieldReadOnly("cppj",false);
			EastJrgjxxb_dataset.setFieldReadOnly("pjjg",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxztpj",false);
			EastJrgjxxb_dataset.setFieldReadOnly("jyzhlx",false);
			EastJrgjxxb_dataset.setFieldReadOnly("pmll",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxjge",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxrq",false);
			EastJrgjxxb_dataset.setFieldReadOnly("ssrq",false);
			EastJrgjxxb_dataset.setFieldReadOnly("qxrq",false);
			EastJrgjxxb_dataset.setFieldReadOnly("dqrq",false);
			EastJrgjxxb_dataset.setFieldReadOnly("lllx",false);
			EastJrgjxxb_dataset.setFieldReadOnly("hqbs",false);
			EastJrgjxxb_dataset.setFieldReadOnly("zjpgjg",false);
			EastJrgjxxb_dataset.setFieldReadOnly("pgjgsj",false);
			EastJrgjxxb_dataset.setFieldReadOnly("ye",false);
			EastJrgjxxb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastJrgjxxb_dataset.setFieldReadOnly("yxjgdm",true);
			EastJrgjxxb_dataset.setFieldReadOnly("jrxkzh",true);
			EastJrgjxxb_dataset.setFieldReadOnly("nbjgh",true);
			EastJrgjxxb_dataset.setFieldReadOnly("yxjgmc",true);
			EastJrgjxxb_dataset.setFieldReadOnly("zqmc",true);
			EastJrgjxxb_dataset.setFieldReadOnly("jrgjbh",true);
			EastJrgjxxb_dataset.setFieldReadOnly("zclx",true);
			EastJrgjxxb_dataset.setFieldReadOnly("bz",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxjg",true);
			EastJrgjxxb_dataset.setFieldReadOnly("yxczqydm",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxgb",true);
			EastJrgjxxb_dataset.setFieldReadOnly("dbjg",true);
			EastJrgjxxb_dataset.setFieldReadOnly("cppj",true);
			EastJrgjxxb_dataset.setFieldReadOnly("pjjg",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxztpj",true);
			EastJrgjxxb_dataset.setFieldReadOnly("jyzhlx",true);
			EastJrgjxxb_dataset.setFieldReadOnly("pmll",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxjge",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxrq",true);
			EastJrgjxxb_dataset.setFieldReadOnly("ssrq",true);
			EastJrgjxxb_dataset.setFieldReadOnly("qxrq",true);
			EastJrgjxxb_dataset.setFieldReadOnly("dqrq",true);
			EastJrgjxxb_dataset.setFieldReadOnly("lllx",true);
			EastJrgjxxb_dataset.setFieldReadOnly("hqbs",true);
			EastJrgjxxb_dataset.setFieldReadOnly("zjpgjg",true);
			EastJrgjxxb_dataset.setFieldReadOnly("pgjgsj",true);
			EastJrgjxxb_dataset.setFieldReadOnly("ye",true);
			EastJrgjxxb_dataset.setFieldReadOnly("cjrq",true);
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
		var id = EastJrgjxxb_dataset.getValue("id");
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
		EastJrgjxxb_dataset.flushData(EastJrgjxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>