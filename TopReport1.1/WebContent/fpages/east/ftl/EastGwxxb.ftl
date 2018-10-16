<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="��λ��Ϣ��">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastGwxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="��λ��Ϣ��" />
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

//����ѯ�����е�Ĭ��ֵΪ��ǰ�µ���һ���µ����һ��
window.onload=function(){
	var date = new Date();
    var day = new Date(date.getFullYear(), date.getMonth(), 0).getDate();
	var enddate = new Date(new Date().getFullYear(), new Date().getMonth()-1, day);
    EastGwxxb_interface_dataset.setValue("cjrq", enddate);
}

	//��λһ�м�¼
	function locate(id) {
		var record = EastGwxxb_dataset.find(["id"],[id]);
		if(record) {
			EastGwxxb_dataset.setRecord(record);
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
		EastGwxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
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
			alert('��ѡ���¼');
			return false;
		}
		return confirm("ȷ��ɾ����¼��");
	}
	
	function btDel_postSubmit(button) {
		alert("ɾ����¼�ɹ�");
		button.url="#";
		//ˢ�µ�ǰҳ
		flushCurrentPage();
	}
	function btModOrAdd_onClickCheck(button) {
		var id = EastGwxxb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}
		var gwbh = EastGwxxb_dataset.getValue("gwbh");
		if (gwbh == null || "" == gwbh) {
			alert("�ֶ�[��λ���]����Ϊ��");
			return false;
		}

		var yxjgdm = EastGwxxb_dataset.getValue("yxjgdm");
		if (yxjgdm == null || "" == yxjgdm) {
			alert("�ֶ�[���л�������]����Ϊ��");
			return false;
		}

		var nbjgh = EastGwxxb_dataset.getValue("nbjgh");
		if (nbjgh == null || "" == nbjgh) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}

		var jrxkzh = EastGwxxb_dataset.getValue("jrxkzh");
		if (jrxkzh == null || "" == jrxkzh) {
			alert("�ֶ�[�������֤��]����Ϊ��");
			return false;
		}

		var gwzl = EastGwxxb_dataset.getValue("gwzl");
		if (gwzl == null || "" == gwzl) {
			alert("�ֶ�[��λ����]����Ϊ��");
			return false;
		}

		var gwmc = EastGwxxb_dataset.getValue("gwmc");
		if (gwmc == null || "" == gwmc) {
			alert("�ֶ�[��λ����]����Ϊ��");
			return false;
		}

		var gwsm = EastGwxxb_dataset.getValue("gwsm");
		if (gwsm == null || "" == gwsm) {
			alert("�ֶ�[��λ˵��]����Ϊ��");
			return false;
		}

		var gwzt = EastGwxxb_dataset.getValue("gwzt");
		if (gwzt == null || "" == gwzt) {
			alert("�ֶ�[��λ״̬]����Ϊ��");
			return false;
		}

		var cjrq = EastGwxxb_dataset.getValue("cjrq");
		if (cjrq == null || "" == cjrq) {
			alert("�ֶ�[�ɼ�����]����Ϊ��");
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
		EastGwxxb_dataset.flushData(EastGwxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>