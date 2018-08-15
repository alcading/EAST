<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="交易流水">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastJyls" init="true" submitMode="交易流水">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="交易流水" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="hxjylsh[90],zjylsh[80],bcxh[40],jyhm[100],dfhm[100],jyje[60],bz[40],xzbz[40],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="hxjylsh,zjylsh,bcxh,jyrq,yxjgdm,nbjgh,jrxkzh,mxkmbh,jysj,jzrq,jzsj,jyjgmc,jyzh,jyhm,jyxtmc,dfxh,dfjgmc,dfzh,dfhm,jyje,zhye,jyjdbz,xzbz,bz,ywlx,jylx,jyqd,jyjzmc,jyjzh,czgyh,gylsh,fhgyh,zy,zpzzl,zpzh,fpzzl,fpzh,cbmbz,sjc,zhbz,kxhbz,cjrq" colNm=4/>
        			<br/><br></br><br></br><br></br><br></br><br></br><br></br>
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
    EastJyls_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastJyls_dataset.find(["id"],[id]);
		if(record) {
			EastJyls_dataset.setRecord(record);
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
		EastJyls_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		EastJyls_dataset.setFieldReadOnly("hxjylsh",false);
		EastJyls_dataset.setFieldReadOnly("zjylsh",false);
		EastJyls_dataset.setFieldReadOnly("bcxh",false);
		EastJyls_dataset.setFieldReadOnly("jyrq",false);
		EastJyls_dataset.setFieldReadOnly("yxjgdm",false);
		EastJyls_dataset.setFieldReadOnly("nbjgh",false);
		EastJyls_dataset.setFieldReadOnly("jrxkzh",false);
		EastJyls_dataset.setFieldReadOnly("mxkmbh",false);
		EastJyls_dataset.setFieldReadOnly("jysj",false);
		EastJyls_dataset.setFieldReadOnly("jzrq",false);
		EastJyls_dataset.setFieldReadOnly("jzsj",false);
		EastJyls_dataset.setFieldReadOnly("jyjgmc",false);
		EastJyls_dataset.setFieldReadOnly("jyzh",false);
		EastJyls_dataset.setFieldReadOnly("jyhm",false);
		EastJyls_dataset.setFieldReadOnly("jyxtmc",false);
		EastJyls_dataset.setFieldReadOnly("dfxh",false);
		EastJyls_dataset.setFieldReadOnly("dfjgmc",false);
		EastJyls_dataset.setFieldReadOnly("dfzh",false);
		EastJyls_dataset.setFieldReadOnly("dfhm",false);
		EastJyls_dataset.setFieldReadOnly("jyje",false);
		EastJyls_dataset.setFieldReadOnly("zhye",false);
		EastJyls_dataset.setFieldReadOnly("jyjdbz",false);
		EastJyls_dataset.setFieldReadOnly("xzbz",false);
		EastJyls_dataset.setFieldReadOnly("bz",false);
		EastJyls_dataset.setFieldReadOnly("ywlx",false);
		EastJyls_dataset.setFieldReadOnly("jylx",false);
		EastJyls_dataset.setFieldReadOnly("jyqd",false);
		EastJyls_dataset.setFieldReadOnly("jyjzmc",false);
		EastJyls_dataset.setFieldReadOnly("jyjzh",false);
		EastJyls_dataset.setFieldReadOnly("czgyh",false);
		EastJyls_dataset.setFieldReadOnly("gylsh",false);
		EastJyls_dataset.setFieldReadOnly("fhgyh",false);
		EastJyls_dataset.setFieldReadOnly("zy",false);
		EastJyls_dataset.setFieldReadOnly("zpzzl",false);
		EastJyls_dataset.setFieldReadOnly("zpzh",false);
		EastJyls_dataset.setFieldReadOnly("fpzzl",false);
		EastJyls_dataset.setFieldReadOnly("fpzh",false);
		EastJyls_dataset.setFieldReadOnly("cbmbz",false);
		EastJyls_dataset.setFieldReadOnly("sjc",false);
		EastJyls_dataset.setFieldReadOnly("zhbz",false);
		EastJyls_dataset.setFieldReadOnly("kxhbz",false);
		EastJyls_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastJyls_dataset.insertRecord("end");
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
			EastJyls_dataset.setFieldReadOnly("hxjylsh",true);
			EastJyls_dataset.setFieldReadOnly("zjylsh",true);
			EastJyls_dataset.setFieldReadOnly("bcxh",true);
			EastJyls_dataset.setFieldReadOnly("jyrq",true);
			EastJyls_dataset.setFieldReadOnly("yxjgdm",false);
			EastJyls_dataset.setFieldReadOnly("nbjgh",false);
			EastJyls_dataset.setFieldReadOnly("jrxkzh",false);
			EastJyls_dataset.setFieldReadOnly("mxkmbh",false);
			EastJyls_dataset.setFieldReadOnly("jysj",false);
			EastJyls_dataset.setFieldReadOnly("jzrq",false);
			EastJyls_dataset.setFieldReadOnly("jzsj",false);
			EastJyls_dataset.setFieldReadOnly("jyjgmc",false);
			EastJyls_dataset.setFieldReadOnly("jyzh",true);
			EastJyls_dataset.setFieldReadOnly("jyhm",false);
			EastJyls_dataset.setFieldReadOnly("jyxtmc",false);
			EastJyls_dataset.setFieldReadOnly("dfxh",false);
			EastJyls_dataset.setFieldReadOnly("dfjgmc",false);
			EastJyls_dataset.setFieldReadOnly("dfzh",false);
			EastJyls_dataset.setFieldReadOnly("dfhm",false);
			EastJyls_dataset.setFieldReadOnly("jyje",false);
			EastJyls_dataset.setFieldReadOnly("zhye",false);
			EastJyls_dataset.setFieldReadOnly("jyjdbz",false);
			EastJyls_dataset.setFieldReadOnly("xzbz",false);
			EastJyls_dataset.setFieldReadOnly("bz",false);
			EastJyls_dataset.setFieldReadOnly("ywlx",false);
			EastJyls_dataset.setFieldReadOnly("jylx",false);
			EastJyls_dataset.setFieldReadOnly("jyqd",false);
			EastJyls_dataset.setFieldReadOnly("jyjzmc",false);
			EastJyls_dataset.setFieldReadOnly("jyjzh",false);
			EastJyls_dataset.setFieldReadOnly("czgyh",false);
			EastJyls_dataset.setFieldReadOnly("gylsh",false);
			EastJyls_dataset.setFieldReadOnly("fhgyh",false);
			EastJyls_dataset.setFieldReadOnly("zy",false);
			EastJyls_dataset.setFieldReadOnly("zpzzl",false);
			EastJyls_dataset.setFieldReadOnly("zpzh",false);
			EastJyls_dataset.setFieldReadOnly("fpzzl",false);
			EastJyls_dataset.setFieldReadOnly("fpzh",false);
			EastJyls_dataset.setFieldReadOnly("cbmbz",false);
			EastJyls_dataset.setFieldReadOnly("sjc",false);
			EastJyls_dataset.setFieldReadOnly("zhbz",false);
			EastJyls_dataset.setFieldReadOnly("kxhbz",false);
			EastJyls_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastJyls_dataset.setFieldReadOnly("hxjylsh",true);
			EastJyls_dataset.setFieldReadOnly("zjylsh",true);
			EastJyls_dataset.setFieldReadOnly("bcxh",true);
			EastJyls_dataset.setFieldReadOnly("jyrq",true);
			EastJyls_dataset.setFieldReadOnly("yxjgdm",true);
			EastJyls_dataset.setFieldReadOnly("nbjgh",true);
			EastJyls_dataset.setFieldReadOnly("jrxkzh",true);
			EastJyls_dataset.setFieldReadOnly("mxkmbh",true);
			EastJyls_dataset.setFieldReadOnly("jysj",true);
			EastJyls_dataset.setFieldReadOnly("jzrq",true);
			EastJyls_dataset.setFieldReadOnly("jzsj",true);
			EastJyls_dataset.setFieldReadOnly("jyjgmc",true);
			EastJyls_dataset.setFieldReadOnly("jyzh",true);
			EastJyls_dataset.setFieldReadOnly("jyhm",true);
			EastJyls_dataset.setFieldReadOnly("jyxtmc",true);
			EastJyls_dataset.setFieldReadOnly("dfxh",true);
			EastJyls_dataset.setFieldReadOnly("dfjgmc",true);
			EastJyls_dataset.setFieldReadOnly("dfzh",true);
			EastJyls_dataset.setFieldReadOnly("dfhm",true);
			EastJyls_dataset.setFieldReadOnly("jyje",true);
			EastJyls_dataset.setFieldReadOnly("zhye",true);
			EastJyls_dataset.setFieldReadOnly("jyjdbz",true);
			EastJyls_dataset.setFieldReadOnly("xzbz",true);
			EastJyls_dataset.setFieldReadOnly("bz",true);
			EastJyls_dataset.setFieldReadOnly("ywlx",true);
			EastJyls_dataset.setFieldReadOnly("jylx",true);
			EastJyls_dataset.setFieldReadOnly("jyqd",true);
			EastJyls_dataset.setFieldReadOnly("jyjzmc",true);
			EastJyls_dataset.setFieldReadOnly("jyjzh",true);
			EastJyls_dataset.setFieldReadOnly("czgyh",true);
			EastJyls_dataset.setFieldReadOnly("gylsh",true);
			EastJyls_dataset.setFieldReadOnly("fhgyh",true);
			EastJyls_dataset.setFieldReadOnly("zy",true);
			EastJyls_dataset.setFieldReadOnly("zpzzl",true);
			EastJyls_dataset.setFieldReadOnly("zpzh",true);
			EastJyls_dataset.setFieldReadOnly("fpzzl",true);
			EastJyls_dataset.setFieldReadOnly("fpzh",true);
			EastJyls_dataset.setFieldReadOnly("cbmbz",true);
			EastJyls_dataset.setFieldReadOnly("sjc",true);
			EastJyls_dataset.setFieldReadOnly("zhbz",true);
			EastJyls_dataset.setFieldReadOnly("kxhbz",true);
			EastJyls_dataset.setFieldReadOnly("cjrq",true);
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
		var id = EastJyls_dataset.getValue("id");
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
		EastJyls_dataset.flushData(EastJyls_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>