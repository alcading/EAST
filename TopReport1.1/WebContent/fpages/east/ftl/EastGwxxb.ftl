<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="岗位信息表">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastGwxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="岗位信息表" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="-,btDel" fieldStr="select,gwbh[60],yxjgdm[100],nbjgh[80],jrxkzh[110],gwzl[100],gwmc[100],gwsm[100],gwzt[100],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="gwbh,yxjgdm,nbjgh,jrxkzh,gwzl,gwmc,gwsm,gwzt,cjrq" colNm=4/>
        			<br/>
        			<@CommonQueryMacro.Button id="btModOrAdd" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<@CommonQueryMacro.Button id="btCancel" />
      			</div>
     		</@CommonQueryMacro.FloatWindow>	
  		</td>
  	</tr>
	<tr style="display:none">
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
    EastGwxxb_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastGwxxb_dataset.find(["id"],[id]);
		if(record) {
			EastGwxxb_dataset.setRecord(record);
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
		EastGwxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
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
		EastGwxxb_dataset.setFieldReadOnly("gwbh",true);
		EastGwxxb_dataset.setFieldReadOnly("nbjgh",true);
		$("#btModOrAdd").get(0).style.display="";
		}
		
		subwindow_signWindow.show();	
	}
	
	function btDel_onClickCheck(button) {
		var rec = EastGwxxb_dataset.firstUnit;
		var id;
		var f = false;
		while(rec) {
			if (rec.getValue('select')) {
				id=rec.getValue('id');
				locate(id);
				f = true;
			}
			rec = rec.nextUnit;
		}
		if(!f) {
			alert('请选择记录');
			return false;
		}
		return confirm("确认删除记录？");
	}
	
	function btDel_postSubmit(button) {
		alert("删除记录成功");
		button.url="#";
		//刷新当前页
		flushCurrentPage();
	}
	function btModOrAdd_onClickCheck(button) {
		var id = EastGwxxb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("字段[内部机构号]不能为空");
			return false;
		}
		var gwbh = EastGwxxb_dataset.getValue("gwbh");
		if (gwbh == null || "" == gwbh) {
			alert("字段[岗位编号]不能为空");
			return false;
		}

		var yxjgdm = EastGwxxb_dataset.getValue("yxjgdm");
		if (yxjgdm == null || "" == yxjgdm) {
			alert("字段[银行机构代码]不能为空");
			return false;
		}

		var nbjgh = EastGwxxb_dataset.getValue("nbjgh");
		if (nbjgh == null || "" == nbjgh) {
			alert("字段[内部机构号]不能为空");
			return false;
		}

		var jrxkzh = EastGwxxb_dataset.getValue("jrxkzh");
		if (jrxkzh == null || "" == jrxkzh) {
			alert("字段[金融许可证号]不能为空");
			return false;
		}

		var gwzl = EastGwxxb_dataset.getValue("gwzl");
		if (gwzl == null || "" == gwzl) {
			alert("字段[岗位种类]不能为空");
			return false;
		}

		var gwmc = EastGwxxb_dataset.getValue("gwmc");
		if (gwmc == null || "" == gwmc) {
			alert("字段[岗位名称]不能为空");
			return false;
		}

		var gwsm = EastGwxxb_dataset.getValue("gwsm");
		if (gwsm == null || "" == gwsm) {
			alert("字段[岗位说明]不能为空");
			return false;
		}

		var gwzt = EastGwxxb_dataset.getValue("gwzt");
		if (gwzt == null || "" == gwzt) {
			alert("字段[岗位状态]不能为空");
			return false;
		}

		var cjrq = EastGwxxb_dataset.getValue("cjrq");
		if (cjrq == null || "" == cjrq) {
			alert("字段[采集日期]不能为空");
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
		EastGwxxb_dataset.flushData(EastGwxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>