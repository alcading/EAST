<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="������Ϣ��">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastHlxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="������Ϣ��" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="yxjgdm[100],nbjgh[90],wb[50],bb[50],zjj[70],jzj[70],hlrq[100],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="yxjgdm,jrxkzh,nbjgh,yxjgmc,wb,bb,zjj,jzj,hlrq,cjrq" colNm=4/>
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

//����ѯ�����е�Ĭ��ֵΪ��ǰ�µ���һ���µ����һ��
window.onload=function(){
	var date = new Date();
    var day = new Date(date.getFullYear(), date.getMonth(), 0).getDate();
	var enddate = new Date(new Date().getFullYear(), new Date().getMonth()-1, day);
    EastHlxxb_interface_dataset.setValue("cjrq", enddate);
}

	//��λһ�м�¼
	function locate(id) {
		var record = EastHlxxb_dataset.find(["id"],[id]);
		if(record) {
			EastHlxxb_dataset.setRecord(record);
		}
	}
	//ϵͳˢ�µ�Ԫ��
	function datatable1_operation_onRefresh(cell,value,record) {
		if(record) {
			var id = record.getValue("id");
			
			if( !(''==id || null == id))
			{
				cell.innerHTML="<center><a href=\"JavaScript:openModifyWindow('"+id+"',1)\"><@bean.message key='�޸�'/></a> &nbsp; </center>";
			}
			
		}else {
			cell.innerHTML="&nbsp;";
		}
	}
	function btAdd_onClick(button) {
			btNewClick();
	}
	//ȡ������
	function btCancel_onClickCheck(button) {
		//�رո�������
		subwindow_signWindow.close();
	}
	//�ظ�������,�ͷ�dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		EastHlxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//��������
	function btNewClick() {
		EastHlxxb_dataset.setFieldReadOnly("yxjgdm",false);
		EastHlxxb_dataset.setFieldReadOnly("jrxkzh",false);
		EastHlxxb_dataset.setFieldReadOnly("nbjgh",false);
		EastHlxxb_dataset.setFieldReadOnly("yxjgmc",false);
		EastHlxxb_dataset.setFieldReadOnly("wb",false);
		EastHlxxb_dataset.setFieldReadOnly("bb",false);
		EastHlxxb_dataset.setFieldReadOnly("zjj",false);
		EastHlxxb_dataset.setFieldReadOnly("jzj",false);
		EastHlxxb_dataset.setFieldReadOnly("hlrq",false);
		EastHlxxb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastHlxxb_dataset.insertRecord("end");
		subwindow_signWindow.show();
	}
	
	/**
	//չʾ�Աȹ��ܵ�js
	function datatable1_id_onRefresh(cell, value, record){
		if(record!=null){
			var id=record.getValue("id");
			cell.innerHTML = "<a href=\"Javascript:openModifyWindow('"+id+"',2)\">"+id+"</a>";
		} else {
			cell.innerHTML = ""
		}
	}
    **/

	//�޸Ĺ���
	function openModifyWindow(id,flag) {
		locate(id);
		if(flag==1){
			EastHlxxb_dataset.setFieldReadOnly("yxjgdm",false);
			EastHlxxb_dataset.setFieldReadOnly("jrxkzh",false);
			EastHlxxb_dataset.setFieldReadOnly("nbjgh",false);
			EastHlxxb_dataset.setFieldReadOnly("yxjgmc",false);
			EastHlxxb_dataset.setFieldReadOnly("wb",true);
			EastHlxxb_dataset.setFieldReadOnly("bb",true);
			EastHlxxb_dataset.setFieldReadOnly("zjj",false);
			EastHlxxb_dataset.setFieldReadOnly("jzj",false);
			EastHlxxb_dataset.setFieldReadOnly("hlrq",true);
			EastHlxxb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastHlxxb_dataset.setFieldReadOnly("yxjgdm",true);
			EastHlxxb_dataset.setFieldReadOnly("jrxkzh",true);
			EastHlxxb_dataset.setFieldReadOnly("nbjgh",true);
			EastHlxxb_dataset.setFieldReadOnly("yxjgmc",true);
			EastHlxxb_dataset.setFieldReadOnly("wb",true);
			EastHlxxb_dataset.setFieldReadOnly("bb",true);
			EastHlxxb_dataset.setFieldReadOnly("zjj",true);
			EastHlxxb_dataset.setFieldReadOnly("jzj",true);
			EastHlxxb_dataset.setFieldReadOnly("hlrq",true);
			EastHlxxb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="none";
		}
		subwindow_signWindow.show();	
	}
	
	function doDel(id) {
		locate(id);
		btDel.click();
	}
	
	function btDel_onClickCheck(button) {
		return confirm("ȷ��ɾ��������¼��");
	}
	function btDel_postSubmit(button) {
		
		button.url="#";
		//ˢ�µ�ǰҳ
		flushCurrentPage();
	}
	function btModOrAdd_onClickCheck(button) {
		var id = EastHlxxb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}
		return true;
	}
	//�����ˢ�µ�ǰҳ
	function btModOrAdd_postSubmit(button) {
		button.url="#";
		subwindow_signWindow.close();
		flushCurrentPage();
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		EastHlxxb_dataset.flushData(EastHlxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>