<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="柜员表">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastGyb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="柜员表" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="-,btDel" fieldStr="select,gyh[60],gh[60],yxjgdm[100],nbjgh[100],jrxkzh[110],yxjgmc[300],gylx[100],gyyhjb[100],gyqxjb[100],sgrq[60],gwzt[60],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="gyh,gh,yxjgdm,nbjgh,zxjgdm,jrxkzh,yxjgmc,gylx,sfstgy,khjlbz,jbzwbz,qxglbz,xdybz,kgybz,zhgybz,sqbz,sqfw,gwbh,gyyhjb,gyqxjb,sgrq,gwzt,cjrq" colNm=4/>
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
    EastGyb_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastGyb_dataset.find(["id"],[id]);
		if(record) {
			EastGyb_dataset.setRecord(record);
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
		EastGyb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		$("#btModOrAdd").get(0).style.display="";
		EastGyb_dataset.insertRecord("end");
		subwindow_signWindow.show();
	}
	

	//修改功能
	function openModifyWindow(id,flag) {
		locate(id);
		if(flag==1){
			EastGyb_dataset.setFieldReadOnly("gyh",true);
			EastGyb_dataset.setFieldReadOnly("gh",false);
			EastGyb_dataset.setFieldReadOnly("yxjgdm",false);
			EastGyb_dataset.setFieldReadOnly("nbjgh",true);
			EastGyb_dataset.setFieldReadOnly("zxjgdm",false);
			EastGyb_dataset.setFieldReadOnly("jrxkzh",false);
			EastGyb_dataset.setFieldReadOnly("yxjgmc",false);
			EastGyb_dataset.setFieldReadOnly("gylx",false);
			EastGyb_dataset.setFieldReadOnly("sfstgy",false);
			EastGyb_dataset.setFieldReadOnly("khjlbz",false);
			EastGyb_dataset.setFieldReadOnly("jbzwbz",false);
			EastGyb_dataset.setFieldReadOnly("qxglbz",false);
			EastGyb_dataset.setFieldReadOnly("ybglbz",false);
			EastGyb_dataset.setFieldReadOnly("xdybz",false);
			EastGyb_dataset.setFieldReadOnly("kgybz",false);
			EastGyb_dataset.setFieldReadOnly("zhgybz",false);
			EastGyb_dataset.setFieldReadOnly("sqbz",false);
			EastGyb_dataset.setFieldReadOnly("sqfw",false);
			EastGyb_dataset.setFieldReadOnly("gwbh",false);
			EastGyb_dataset.setFieldReadOnly("gyyhjb",false);
			EastGyb_dataset.setFieldReadOnly("gyqxjb",false);
			EastGyb_dataset.setFieldReadOnly("sgrq",false);
			EastGyb_dataset.setFieldReadOnly("gwzt",false);
			EastGyb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastGyb_dataset.setFieldReadOnly("gyh",true);
			EastGyb_dataset.setFieldReadOnly("gh",true);
			EastGyb_dataset.setFieldReadOnly("yxjgdm",true);
			EastGyb_dataset.setFieldReadOnly("nbjgh",true);
			EastGyb_dataset.setFieldReadOnly("zxjgdm",true);
			EastGyb_dataset.setFieldReadOnly("jrxkzh",true);
			EastGyb_dataset.setFieldReadOnly("yxjgmc",true);
			EastGyb_dataset.setFieldReadOnly("gylx",true);
			EastGyb_dataset.setFieldReadOnly("sfstgy",true);
			EastGyb_dataset.setFieldReadOnly("khjlbz",true);
			EastGyb_dataset.setFieldReadOnly("jbzwbz",true);
			EastGyb_dataset.setFieldReadOnly("qxglbz",true);
			EastGyb_dataset.setFieldReadOnly("ybglbz",true);
			EastGyb_dataset.setFieldReadOnly("xdybz",true);
			EastGyb_dataset.setFieldReadOnly("kgybz",true);
			EastGyb_dataset.setFieldReadOnly("zhgybz",true);
			EastGyb_dataset.setFieldReadOnly("sqbz",true);
			EastGyb_dataset.setFieldReadOnly("sqfw",true);
			EastGyb_dataset.setFieldReadOnly("gwbh",true);
			EastGyb_dataset.setFieldReadOnly("gyyhjb",true);
			EastGyb_dataset.setFieldReadOnly("gyqxjb",true);
			EastGyb_dataset.setFieldReadOnly("sgrq",true);
			EastGyb_dataset.setFieldReadOnly("gwzt",true);
			EastGyb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="none";
			}
		subwindow_signWindow.show();	
	}
	
	function btDel_onClickCheck(button) {
		var rec = EastGyb_dataset.firstUnit;
		var f = false;
		while(rec) {
			if (rec.getValue('select')) {
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
		var id = EastGyb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("字段[内部机构号]不能为空");
			return false;
		}
		var gyh = EastGyb_dataset.getValue("gyh");
		if (gyh == null || "" == gyh) {
			alert("字段[柜员号]不能为空");
			return false;
		}

		var gh = EastGyb_dataset.getValue("gh");
		if (gh == null || "" == gh) {
			alert("字段[工号]不能为空");
			return false;
		}

		var yxjgdm = EastGyb_dataset.getValue("yxjgdm");
		if (yxjgdm == null || "" == yxjgdm) {
			alert("字段[银行机构代码]不能为空");
			return false;
		}

		var nbjgh = EastGyb_dataset.getValue("nbjgh");
		if (nbjgh == null || "" == nbjgh) {
			alert("字段[内部机构号]不能为空");
			return false;
		}

		var zxjgdm = EastGyb_dataset.getValue("zxjgdm");
		if (zxjgdm == null || "" == zxjgdm) {
			alert("字段[总行机构代码]不能为空");
			return false;
		}

		var jrxkzh = EastGyb_dataset.getValue("jrxkzh");
		if (jrxkzh == null || "" == jrxkzh) {
			alert("字段[金融许可证号]不能为空");
			return false;
		}

		var yxjgmc = EastGyb_dataset.getValue("yxjgmc");
		if (yxjgmc == null || "" == yxjgmc) {
			alert("字段[银行机构名称]不能为空");
			return false;
		}

		var gylx = EastGyb_dataset.getValue("gylx");
		if (gylx == null || "" == gylx) {
			alert("字段[柜员类型]不能为空");
			return false;
		}

		var sfstgy = EastGyb_dataset.getValue("sfstgy");
		if (sfstgy == null || "" == sfstgy) {
			alert("字段[是否实体柜员]不能为空");
			return false;
		}

		var khjlbz = EastGyb_dataset.getValue("khjlbz");
		if (khjlbz == null || "" == khjlbz) {
			alert("字段[客户经理标志]不能为空");
			return false;
		}

		var jbzwbz = EastGyb_dataset.getValue("jbzwbz");
		if (jbzwbz == null || "" == jbzwbz) {
			alert("字段[经办账务标志]不能为空");
			return false;
		}

		var qxglbz = EastGyb_dataset.getValue("qxglbz");
		if (qxglbz == null || "" == qxglbz) {
			alert("字段[权限管理标志]不能为空");
			return false;
		}

		var ybglbz = EastGyb_dataset.getValue("ybglbz");
		if (ybglbz == null || "" == ybglbz) {
			alert("字段[一般管理标志]不能为空");
			return false;
		}

		var xdybz = EastGyb_dataset.getValue("xdybz");
		if (xdybz == null || "" == xdybz) {
			alert("字段[信贷员标志]不能为空");
			return false;
		}

		var kgybz = EastGyb_dataset.getValue("kgybz");
		if (kgybz == null || "" == kgybz) {
			alert("字段[库管员标志]不能为空");
			return false;
		}

		var zhgybz = EastGyb_dataset.getValue("zhgybz");
		if (zhgybz == null || "" == zhgybz) {
			alert("字段[综合柜员标志]不能为空");
			return false;
		}

		var sqbz = EastGyb_dataset.getValue("sqbz");
		if (sqbz == null || "" == sqbz) {
			alert("字段[授权标志]不能为空");
			return false;
		}

		var sqfw = EastGyb_dataset.getValue("sqfw");
		if (sqfw == null || "" == sqfw) {
			alert("字段[授权范围]不能为空");
			return false;
		}

		var gwbh = EastGyb_dataset.getValue("gwbh");
		if (gwbh == null || "" == gwbh) {
			alert("字段[岗位编号]不能为空");
			return false;
		}

		var gyyhjb = EastGyb_dataset.getValue("gyyhjb");
		if (gyyhjb == null || "" == gyyhjb) {
			alert("字段[柜员用户级别]不能为空");
			return false;
		}

		var gyqxjb = EastGyb_dataset.getValue("gyqxjb");
		if (gyqxjb == null || "" == gyqxjb) {
			alert("字段[柜员权限级别]不能为空");
			return false;
		}

		var sgrq = EastGyb_dataset.getValue("sgrq");
		if (sgrq == null || "" == sgrq) {
			alert("字段[上岗日期]不能为空");
			return false;
		}

		var gwzt = EastGyb_dataset.getValue("gwzt");
		if (gwzt == null || "" == gwzt) {
			alert("字段[柜员状态]不能为空");
			return false;
		}

		var cjrq = EastGyb_dataset.getValue("cjrq");
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
		EastGyb_dataset.flushData(EastGyb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>