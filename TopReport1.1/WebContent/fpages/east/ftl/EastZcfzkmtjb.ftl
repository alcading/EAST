<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="�ʲ���ծ��Ŀͳ�Ʊ�">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastZcfzkmtjb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="�ʲ���ծ��Ŀͳ�Ʊ�" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="jrjgdm[100],nbjgh[80],tjkmbh[80],tjkmmc[100],tjkmje[70],qxlx[50],tjrq[70],bz[40],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="jrjgdm,jrxkzh,nbjgh,tjkmbh,tjkmmc,tjkmje,qxlx,tjrq,bz,dqmc,xzqhdm,cjrq" colNm=4/>
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
    EastZcfzkmtjb_interface_dataset.setValue("cjrq", enddate);
}

	//��λһ�м�¼
	function locate(id) {
		var record = EastZcfzkmtjb_dataset.find(["id"],[id]);
		if(record) {
			EastZcfzkmtjb_dataset.setRecord(record);
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
		EastZcfzkmtjb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//��������
	function btNewClick() {
		EastZcfzkmtjb_dataset.setFieldReadOnly("jrjgdm",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("jrxkzh",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("nbjgh",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmbh",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmmc",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmje",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("qxlx",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("tjrq",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("bz",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("dqmc",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("xzqhdm",false);
		EastZcfzkmtjb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastZcfzkmtjb_dataset.insertRecord("end");
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
			EastZcfzkmtjb_dataset.setFieldReadOnly("jrjgdm",false);
			EastZcfzkmtjb_dataset.setFieldReadOnly("jrxkzh",false);
			EastZcfzkmtjb_dataset.setFieldReadOnly("nbjgh",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmbh",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmmc",false);
			EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmje",false);
			EastZcfzkmtjb_dataset.setFieldReadOnly("qxlx",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("tjrq",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("bz",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("dqmc",false);
			EastZcfzkmtjb_dataset.setFieldReadOnly("xzqhdm",false);
			EastZcfzkmtjb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastZcfzkmtjb_dataset.setFieldReadOnly("jrjgdm",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("jrxkzh",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("nbjgh",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmbh",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmmc",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("tjkmje",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("qxlx",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("tjrq",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("bz",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("dqmc",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("xzqhdm",true);
			EastZcfzkmtjb_dataset.setFieldReadOnly("cjrq",true);
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
		var id = EastZcfzkmtjb_dataset.getValue("id");
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
		EastZcfzkmtjb_dataset.flushData(EastZcfzkmtjb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>