<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="个人活期存款分户账">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastGrhqckfhzmxjl" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="个人活期存款分户账明细记录" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="hqckzh[80],zhmc[100],khtybh[80],mxkmmc[60],jylx[80],jyje[40],zhye[40],hxjyrq[60],hxjysj[50],cjrq[50],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="hxjylsh,zjylsh,bcxh,hqckzh,khtybh,yxjgdm,jrxkzh,nbjgh,mxkmbh,yxjgmc,mxkmmc,hxjyrq,hxjysj,bz,zhmc,jylx,jyje,khhjgh,ywbljgh,zhye,dfzh,dfhm,dfxh,dfxm,jyqd,xzbz,dbrxm,dbrzjlb,dbrzjhm,jygyh,gylsh,sqgyh,zy,cbmbz,jyjdbz,cjrq" colNm=4/>
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
	//定位一行记录
	function locate(id) {
		var record = EastGrhqckfhzmxjl_dataset.find(["id"],[id]);
		if(record) {
			EastGrhqckfhzmxjl_dataset.setRecord(record);
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
		EastGrhqckfhzmxjl_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	


	//修改功能
	function openModifyWindow(id,flag) {
		locate(id);
		if(flag==1){
		EastGrhqckfhzmxjl_dataset.setFieldReadOnly("hxjylsh",true);
		EastGrhqckfhzmxjl_dataset.setFieldReadOnly("zjylsh",true);
		EastGrhqckfhzmxjl_dataset.setFieldReadOnly("bcxh",true);
		EastGrhqckfhzmxjl_dataset.setFieldReadOnly("hqckzh",true);
		EastGrhqckfhzmxjl_dataset.setFieldReadOnly("hxjyrq",true);
		EastGrhqckfhzmxjl_dataset.setFieldReadOnly("cjrq",true);
		$("#btModOrAdd").get(0).style.display="";
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
		var id = EastGrhqckfhzmxjl_dataset.getValue("id");
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
		EastGrhqckfhzmxjl_dataset.flushData(EastGrhqckfhzmxjl_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>