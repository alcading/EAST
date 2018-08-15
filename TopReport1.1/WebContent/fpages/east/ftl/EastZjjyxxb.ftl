<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="资金交易信息表">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastZjjyxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="资金交信息表" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="yxjgdm[100],nbjgh[80],mxkmbh[100],mxkmmc[100],jybh[80],jylx[80],jyzl[80],jrgjbh[100],jyzhlx[80],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="yxjgdm,jrxkzh,nbjgh,mxkmbh,yxjgmc,mxkmmc,jybh,lccpdjbm,jylx,jyzl,jrgjbh,jyzhlx,hth,htje,bz,jczckhmc,jczcsshy,jczcsfwbhkh,jczczxfs,jczczxr,jygy,spr,jydsdm,jydsmc,jyrq,qsrq,dqrq,mmbz,jyqbz,mrbz,mrje,mcbz,mcje,cjjg,ywzt,fhrq,qxrq,sjjgrq,qsbz,jfzh,dfzh,jfje,dfje,jfbz,dfbz,jfll,dfll,bzjjybz,glbzjzh,glywbh,wbglxtmc,cjrq" colNm=4/>
        			<br/><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
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
    EastZjjyxxb_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastZjjyxxb_dataset.find(["id"],[id]);
		if(record) {
			EastZjjyxxb_dataset.setRecord(record);
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
		EastZjjyxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		EastZjjyxxb_dataset.setFieldReadOnly("yxjgdm",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jrxkzh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("nbjgh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("mxkmbh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("yxjgmc",false);
		EastZjjyxxb_dataset.setFieldReadOnly("mxkmmc",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jybh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("lccpdjbm",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jylx",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jyzl",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jrgjbh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jyzhlx",false);
		EastZjjyxxb_dataset.setFieldReadOnly("hth",false);
		EastZjjyxxb_dataset.setFieldReadOnly("htje",false);
		EastZjjyxxb_dataset.setFieldReadOnly("bz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jczckhmc",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jczcsshy",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jczcsfwbhkh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jczczxfs",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jczczxr",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jygy",false);
		EastZjjyxxb_dataset.setFieldReadOnly("spr",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jydsdm",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jydsmc",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jyrq",false);
		EastZjjyxxb_dataset.setFieldReadOnly("qsrq",false);
		EastZjjyxxb_dataset.setFieldReadOnly("dqrq",false);
		EastZjjyxxb_dataset.setFieldReadOnly("mmbz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jyqbz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("mrbz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("mrje",false);
		EastZjjyxxb_dataset.setFieldReadOnly("mcbz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("mcje",false);
		EastZjjyxxb_dataset.setFieldReadOnly("cjjg",false);
		EastZjjyxxb_dataset.setFieldReadOnly("ywzt",false);
		EastZjjyxxb_dataset.setFieldReadOnly("fhrq",false);
		EastZjjyxxb_dataset.setFieldReadOnly("qxrq",false);
		EastZjjyxxb_dataset.setFieldReadOnly("sjjgrq",false);
		EastZjjyxxb_dataset.setFieldReadOnly("qsbz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jfzh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("dfzh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jfje",false);
		EastZjjyxxb_dataset.setFieldReadOnly("dfje",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jfbz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("dfbz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("jfll",false);
		EastZjjyxxb_dataset.setFieldReadOnly("dfll",false);
		EastZjjyxxb_dataset.setFieldReadOnly("bzjjybz",false);
		EastZjjyxxb_dataset.setFieldReadOnly("glbzjzh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("glywbh",false);
		EastZjjyxxb_dataset.setFieldReadOnly("wbglxtmc",false);
		EastZjjyxxb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastZjjyxxb_dataset.insertRecord("end");
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
			EastZjjyxxb_dataset.setFieldReadOnly("yxjgdm",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jrxkzh",false);
			EastZjjyxxb_dataset.setFieldReadOnly("nbjgh",false);
			EastZjjyxxb_dataset.setFieldReadOnly("mxkmbh",false);
			EastZjjyxxb_dataset.setFieldReadOnly("yxjgmc",false);
			EastZjjyxxb_dataset.setFieldReadOnly("mxkmmc",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jybh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("lccpdjbm",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jylx",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jyzl",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jrgjbh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jyzhlx",false);
			EastZjjyxxb_dataset.setFieldReadOnly("hth",false);
			EastZjjyxxb_dataset.setFieldReadOnly("htje",false);
			EastZjjyxxb_dataset.setFieldReadOnly("bz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jczckhmc",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jczcsshy",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jczcsfwbhkh",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jczczxfs",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jczczxr",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jygy",false);
			EastZjjyxxb_dataset.setFieldReadOnly("spr",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jydsdm",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jydsmc",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jyrq",false);
			EastZjjyxxb_dataset.setFieldReadOnly("qsrq",false);
			EastZjjyxxb_dataset.setFieldReadOnly("dqrq",false);
			EastZjjyxxb_dataset.setFieldReadOnly("mmbz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jyqbz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("mrbz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("mrje",false);
			EastZjjyxxb_dataset.setFieldReadOnly("mcbz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("mcje",false);
			EastZjjyxxb_dataset.setFieldReadOnly("cjjg",false);
			EastZjjyxxb_dataset.setFieldReadOnly("ywzt",false);
			EastZjjyxxb_dataset.setFieldReadOnly("fhrq",false);
			EastZjjyxxb_dataset.setFieldReadOnly("qxrq",false);
			EastZjjyxxb_dataset.setFieldReadOnly("sjjgrq",false);
			EastZjjyxxb_dataset.setFieldReadOnly("qsbz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jfzh",false);
			EastZjjyxxb_dataset.setFieldReadOnly("dfzh",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jfje",false);
			EastZjjyxxb_dataset.setFieldReadOnly("dfje",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jfbz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("dfbz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("jfll",false);
			EastZjjyxxb_dataset.setFieldReadOnly("dfll",false);
			EastZjjyxxb_dataset.setFieldReadOnly("bzjjybz",false);
			EastZjjyxxb_dataset.setFieldReadOnly("glbzjzh",false);
			EastZjjyxxb_dataset.setFieldReadOnly("glywbh",false);
			EastZjjyxxb_dataset.setFieldReadOnly("wbglxtmc",false);
			EastZjjyxxb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastZjjyxxb_dataset.setFieldReadOnly("yxjgdm",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jrxkzh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("nbjgh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("mxkmbh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("yxjgmc",true);
			EastZjjyxxb_dataset.setFieldReadOnly("mxkmmc",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jybh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("lccpdjbm",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jylx",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jyzl",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jrgjbh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jyzhlx",true);
			EastZjjyxxb_dataset.setFieldReadOnly("hth",true);
			EastZjjyxxb_dataset.setFieldReadOnly("htje",true);
			EastZjjyxxb_dataset.setFieldReadOnly("bz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jczckhmc",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jczcsshy",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jczcsfwbhkh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jczczxfs",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jczczxr",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jygy",true);
			EastZjjyxxb_dataset.setFieldReadOnly("spr",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jydsdm",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jydsmc",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jyrq",true);
			EastZjjyxxb_dataset.setFieldReadOnly("qsrq",true);
			EastZjjyxxb_dataset.setFieldReadOnly("dqrq",true);
			EastZjjyxxb_dataset.setFieldReadOnly("mmbz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jyqbz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("mrbz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("mrje",true);
			EastZjjyxxb_dataset.setFieldReadOnly("mcbz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("mcje",true);
			EastZjjyxxb_dataset.setFieldReadOnly("cjjg",true);
			EastZjjyxxb_dataset.setFieldReadOnly("ywzt",true);
			EastZjjyxxb_dataset.setFieldReadOnly("fhrq",true);
			EastZjjyxxb_dataset.setFieldReadOnly("qxrq",true);
			EastZjjyxxb_dataset.setFieldReadOnly("sjjgrq",true);
			EastZjjyxxb_dataset.setFieldReadOnly("qsbz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jfzh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("dfzh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jfje",true);
			EastZjjyxxb_dataset.setFieldReadOnly("dfje",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jfbz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("dfbz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("jfll",true);
			EastZjjyxxb_dataset.setFieldReadOnly("dfll",true);
			EastZjjyxxb_dataset.setFieldReadOnly("bzjjybz",true);
			EastZjjyxxb_dataset.setFieldReadOnly("glbzjzh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("glywbh",true);
			EastZjjyxxb_dataset.setFieldReadOnly("wbglxtmc",true);
			EastZjjyxxb_dataset.setFieldReadOnly("cjrq",true);
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
		var id = EastZjjyxxb_dataset.getValue("id");
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
		EastZjjyxxb_dataset.flushData(EastZjjyxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>