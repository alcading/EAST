<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="理财产品信息表">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastLccpxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="理财产品信息表" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="nbjgh[80],mxkmmc[80],cpmc[80],id[100],cpqc[60],cpsprxm[60],cpsjrxm[60],tzjlxm[60],cpqx[80],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="yxjgdm,jrxkzh,nbjgh,mxkmbh,yxjgmc,mxkmmc,cpmc,cpdjbm,id,cppp,cpqc,cpsprsfzh,cpsprxm,cpsjrsfzh,cpsjrxm,tzjlsfzh,tzjlxm,cpsylx,cpqx,tzzlx,zjtxdq,cptzgjhdq,lcywfwms,cpyzms,kjhsfs,cpzcpzfs,cpglms,sjgllmc,cpdjfs,tzlx,hzms,hzjgmc,tzzczljbl,sfyyqsyl,yjkhzgnsyl,yjkhzdnsyl,sfysylcsyj,tzzfxph,cpxsqy,mjbz,dfbjbz,dfsybz,qdxsje,jhmjje,mjqsrq,tzbjdzr,tzsydzr,xssxfl,jntgjgmc,jntgjgdm,jwtgjggb,jwtgjgmc,lccpzjtgzh,lccpzjtgzhmc,tgfl,cpfxdj,fxjgtqzzqbs,khshqbs,cpzxbs,cpzxjglx,cpzxxs,cjrq" colNm=4/>
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
    EastLccpxxb_interface_dataset.setValue("cjrq", enddate);
}

	//定位一行记录
	function locate(id) {
		var record = EastLccpxxb_dataset.find(["id"],[id]);
		if(record) {
			EastLccpxxb_dataset.setRecord(record);
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
		EastLccpxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}

	
	//修改功能
	function openModifyWindow(id,flag) {
		locate(id);
		if(flag==1){
			EastLccpxxb_dataset.setFieldReadOnly("id",true);
			EastLccpxxb_dataset.setFieldReadOnly("cjrq",false);
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
		var id = EastLccpxxb_dataset.getValue("id");
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
		EastLccpxxb_dataset.flushData(EastLccpxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>