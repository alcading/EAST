<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="机构信息表">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastJgxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="机构信息表" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="-,btDel" fieldStr="select,yxjgdm[100],id[100],jrxkzh[110],yxjgmc[300],jglb[100],wdh[60],yyzt[80],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="yxjgdm,id,jrxkzh,yxjgmc,jglb,yzbm,wdh,yyzt,clsj,jggzkssj,jggzzzsj,jgdz,fzrxm,fzrzw,fzrlxdh,cjrq" colNm=4/>
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
    EastJgxxb_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastJgxxb_dataset.find(["id"],[id]);
		if(record) {
			EastJgxxb_dataset.setRecord(record);
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
		EastJgxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		EastJgxxb_dataset.setFieldReadOnly("id",false);
		EastJgxxb_dataset.setFieldReadOnly("yxjgdm",false);
		EastJgxxb_dataset.setFieldReadOnly("jrxkzh",false);
		EastJgxxb_dataset.setFieldReadOnly("yxjgmc",false);
		EastJgxxb_dataset.setFieldReadOnly("jglb",false);
		EastJgxxb_dataset.setFieldReadOnly("yzbm",false);
		EastJgxxb_dataset.setFieldReadOnly("wdh",false);
		EastJgxxb_dataset.setFieldReadOnly("yyzt",false);
		EastJgxxb_dataset.setFieldReadOnly("clsj",false);
		EastJgxxb_dataset.setFieldReadOnly("jggzkssj",false);
		EastJgxxb_dataset.setFieldReadOnly("jggzzzsj",false);
		EastJgxxb_dataset.setFieldReadOnly("jgdz",false);
		EastJgxxb_dataset.setFieldReadOnly("fzrxm",false);
		EastJgxxb_dataset.setFieldReadOnly("fzrzw",false);
		EastJgxxb_dataset.setFieldReadOnly("fzrlxdh",false);
		EastJgxxb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastJgxxb_dataset.insertRecord("end");
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
		EastJgxxb_dataset.setFieldReadOnly("id",true);
		EastJgxxb_dataset.setFieldReadOnly("yxjgdm",false);
		EastJgxxb_dataset.setFieldReadOnly("jrxkzh",false);
		EastJgxxb_dataset.setFieldReadOnly("yxjgmc",false);
		EastJgxxb_dataset.setFieldReadOnly("jglb",false);
		EastJgxxb_dataset.setFieldReadOnly("yzbm",false);
		EastJgxxb_dataset.setFieldReadOnly("wdh",false);
		EastJgxxb_dataset.setFieldReadOnly("yyzt",false);
		EastJgxxb_dataset.setFieldReadOnly("clsj",false);
		EastJgxxb_dataset.setFieldReadOnly("jggzkssj",false);
		EastJgxxb_dataset.setFieldReadOnly("jggzzzsj",false);
		EastJgxxb_dataset.setFieldReadOnly("jgdz",false);
		EastJgxxb_dataset.setFieldReadOnly("fzrxm",false);
		EastJgxxb_dataset.setFieldReadOnly("fzrzw",false);
		EastJgxxb_dataset.setFieldReadOnly("fzrlxdh",false);
		EastJgxxb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
		EastJgxxb_dataset.setFieldReadOnly("id",true);
		EastJgxxb_dataset.setFieldReadOnly("yxjgdm",true);
		EastJgxxb_dataset.setFieldReadOnly("jrxkzh",true);
		EastJgxxb_dataset.setFieldReadOnly("yxjgmc",true);
		EastJgxxb_dataset.setFieldReadOnly("jglb",true);
		EastJgxxb_dataset.setFieldReadOnly("yzbm",true);
		EastJgxxb_dataset.setFieldReadOnly("wdh",true);
		EastJgxxb_dataset.setFieldReadOnly("yyzt",true);
		EastJgxxb_dataset.setFieldReadOnly("clsj",true);
		EastJgxxb_dataset.setFieldReadOnly("jggzkssj",true);
		EastJgxxb_dataset.setFieldReadOnly("jggzzzsj",true);
		EastJgxxb_dataset.setFieldReadOnly("jgdz",true);
		EastJgxxb_dataset.setFieldReadOnly("fzrxm",true);
		EastJgxxb_dataset.setFieldReadOnly("fzrzw",true);
		EastJgxxb_dataset.setFieldReadOnly("fzrlxdh",true);
		EastJgxxb_dataset.setFieldReadOnly("cjrq",true);
		$("#btModOrAdd").get(0).style.display="none";
		}
		subwindow_signWindow.show();	
	}
	
	function btDel_onClickCheck(button) {
		var rec = EastJgxxb_dataset.firstUnit;
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
		var id = EastJgxxb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("字段[内部机构号]不能为空");
			return false;
		}
		var yxjgdm = EastYgb_dataset.getValue("yxjgdm");
		if (yxjgdm == null || "" == yxjgdm) {
			alert("字段[银行机构代码]不能为空");
			return false;
		}

		var nbjgh = EastYgb_dataset.getValue("nbjgh");
		if (nbjgh == null || "" == nbjgh) {
			alert("字段[内部机构号]不能为空");
			return false;
		}

		var jrxkzh = EastYgb_dataset.getValue("jrxkzh");
		if (jrxkzh == null || "" == jrxkzh) {
			alert("字段[金融许可证号]不能为空");
			return false;
		}

		var yxjgmc = EastYgb_dataset.getValue("yxjgmc");
		if (yxjgmc == null || "" == yxjgmc) {
			alert("字段[银行机构名称]不能为空");
			return false;
		}

		var jglb = EastYgb_dataset.getValue("jglb");
		if (jglb == null || "" == jglb) {
			alert("字段[机构类别]不能为空");
			return false;
		}

		var yzbm = EastYgb_dataset.getValue("yzbm");
		if (yzbm == null || "" == yzbm) {
			alert("字段[邮政编码]不能为空");
			return false;
		}

		var wdh = EastYgb_dataset.getValue("wdh");
		if (wdh == null || "" == wdh) {
			alert("字段[网点号]不能为空");
			return false;
		}

		var yyzt = EastYgb_dataset.getValue("yyzt");
		if (yyzt == null || "" == yyzt) {
			alert("字段[营业状态]不能为空");
			return false;
		}

		var clsj = EastYgb_dataset.getValue("clsj");
		if (clsj == null || "" == clsj) {
			alert("字段[成立时间]不能为空");
			return false;
		}

		var jggzkssj = EastYgb_dataset.getValue("jggzkssj");
		if (jggzkssj == null || "" == jggzkssj) {
			alert("字段[机构工作开始时间]不能为空");
			return false;
		}

		var jggzzzsj = EastYgb_dataset.getValue("jggzzzsj");
		if (jggzzzsj == null || "" == jggzzzsj) {
			alert("字段[机构工作终止时间]不能为空");
			return false;
		}

		var jgdz = EastYgb_dataset.getValue("jgdz");
		if (jgdz == null || "" == jgdz) {
			alert("字段[机构地址]不能为空");
			return false;
		}

		var fzrxm = EastYgb_dataset.getValue("fzrxm");
		if (fzrxm == null || "" == fzrxm) {
			alert("字段[负责人姓名]不能为空");
			return false;
		}

		var fzrzw = EastYgb_dataset.getValue("fzrzw");
		if (fzrzw == null || "" == fzrzw) {
			alert("字段[负责人职务]不能为空");
			return false;
		}

		var fzrlxdh = EastYgb_dataset.getValue("fzrlxdh");
		if (fzrlxdh == null || "" == fzrlxdh) {
			alert("字段[负责人联系电话]不能为空");
			return false;
		}

		var cjrq = EastYgb_dataset.getValue("cjrq");
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
		EastJgxxb_dataset.flushData(EastJgxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>