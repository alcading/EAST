<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="Ա����">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastYgb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="Ա����" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="-,btDel"  fieldStr="select,gh[60],yxjgdm[100],nbjgh[80],jrxkzh[110],yxjgmc[200],xm[60],sfzh[100],ygzt[60],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="gh,yxjgdm,nbjgh,jrxkzh,yxjgmc,xm,sfzh,lxdh,wdh,ssbm,zw,ygzt,gwbh,cjrq" colNm=4/>
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
    EastYgb_interface_dataset.setValue("cjrq", enddate);
}

	//��λһ�м�¼
	function locate(id) {
		var record = EastYgb_dataset.find(["id"],[id]);
		if(record) {
			EastYgb_dataset.setRecord(record);
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
		EastYgb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//��������
	function btNewClick() {
		EastYgb_dataset.setFieldReadOnly("gh",false);
		EastYgb_dataset.setFieldReadOnly("nbjgh",false);
		EastYgb_dataset.setFieldReadOnly("yxjgdm",false);
		EastYgb_dataset.setFieldReadOnly("jrxkzh",false);
		EastYgb_dataset.setFieldReadOnly("yxjgmc",false);
		EastYgb_dataset.setFieldReadOnly("xm",false);
		EastYgb_dataset.setFieldReadOnly("sfzh",false);
		EastYgb_dataset.setFieldReadOnly("wdh",false);
		EastYgb_dataset.setFieldReadOnly("lxdh",false);
		EastYgb_dataset.setFieldReadOnly("ssbm",false);
		EastYgb_dataset.setFieldReadOnly("zw",false);
		EastYgb_dataset.setFieldReadOnly("ygzt",false);
		EastYgb_dataset.setFieldReadOnly("gwbh",false);
		EastYgb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastYgb_dataset.insertRecord("end");
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
		EastYgb_dataset.setFieldReadOnly("gh",true);
		EastYgb_dataset.setFieldReadOnly("nbjgh",true);
		EastYgb_dataset.setFieldReadOnly("yxjgdm",false);
		EastYgb_dataset.setFieldReadOnly("jrxkzh",false);
		EastYgb_dataset.setFieldReadOnly("yxjgmc",false);
		EastYgb_dataset.setFieldReadOnly("xm",false);
		EastYgb_dataset.setFieldReadOnly("sfzh",false);
		EastYgb_dataset.setFieldReadOnly("wdh",false);
		EastYgb_dataset.setFieldReadOnly("lxdh",false);
		EastYgb_dataset.setFieldReadOnly("ssbm",false);
		EastYgb_dataset.setFieldReadOnly("zw",false);
		EastYgb_dataset.setFieldReadOnly("ygzt",false);
		EastYgb_dataset.setFieldReadOnly("gwbh",false);
		EastYgb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
		EastYgb_dataset.setFieldReadOnly("gh",true);
		EastYgb_dataset.setFieldReadOnly("nbjgh",true);
		EastYgb_dataset.setFieldReadOnly("yxjgdm",true);
		EastYgb_dataset.setFieldReadOnly("jrxkzh",true);
		EastYgb_dataset.setFieldReadOnly("yxjgmc",true);
		EastYgb_dataset.setFieldReadOnly("xm",true);
		EastYgb_dataset.setFieldReadOnly("sfzh",true);
		EastYgb_dataset.setFieldReadOnly("wdh",true);
		EastYgb_dataset.setFieldReadOnly("lxdh",true);
		EastYgb_dataset.setFieldReadOnly("ssbm",true);
		EastYgb_dataset.setFieldReadOnly("zw",true);
		EastYgb_dataset.setFieldReadOnly("ygzt",true);
		EastYgb_dataset.setFieldReadOnly("gwbh",true);
		EastYgb_dataset.setFieldReadOnly("cjrq",true);
		$("#btModOrAdd").get(0).style.display="none";
		}
		subwindow_signWindow.show();	
	}
	
	function btDel_onClickCheck(button) {
		var rec = EastYgb_dataset.firstUnit;
		var f = false;
		while(rec) {
			if (rec.getValue('select')) {
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
		var id = EastYgb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}
		var gh = EastYgb_dataset.getValue("gh");
		if (gh == null || "" == gh) {
			alert("�ֶ�[����]����Ϊ��");
			return false;
		}

		var yxjgdm = EastYgb_dataset.getValue("yxjgdm");
		if (yxjgdm == null || "" == yxjgdm) {
			alert("�ֶ�[���л�������]����Ϊ��");
			return false;
		}

		var nbjgh = EastYgb_dataset.getValue("nbjgh");
		if (nbjgh == null || "" == nbjgh) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}

		var jrxkzh = EastYgb_dataset.getValue("jrxkzh");
		if (jrxkzh == null || "" == jrxkzh) {
			alert("�ֶ�[�������֤��]����Ϊ��");
			return false;
		}

		var yxjgmc = EastYgb_dataset.getValue("yxjgmc");
		if (yxjgmc == null || "" == yxjgmc) {
			alert("�ֶ�[���л�������]����Ϊ��");
			return false;
		}

		var xm = EastYgb_dataset.getValue("xm");
		if (xm == null || "" == xm) {
			alert("�ֶ�[����]����Ϊ��");
			return false;
		}

		var sfzh = EastYgb_dataset.getValue("sfzh");
		if (sfzh == null || "" == sfzh) {
			alert("�ֶ�[���֤��]����Ϊ��");
			return false;
		}

		var lxdh = EastYgb_dataset.getValue("lxdh");
		if (lxdh == null || "" == lxdh) {
			alert("�ֶ�[��ϵ�绰]����Ϊ��");
			return false;
		}

		var wdh = EastYgb_dataset.getValue("wdh");
		if (wdh == null || "" == wdh) {
			alert("�ֶ�[�����]����Ϊ��");
			return false;
		}

		var ssbm = EastYgb_dataset.getValue("ssbm");
		if (ssbm == null || "" == ssbm) {
			alert("�ֶ�[��������]����Ϊ��");
			return false;
		}

		var zw = EastYgb_dataset.getValue("zw");
		if (zw == null || "" == zw) {
			alert("�ֶ�[ְ��]����Ϊ��");
			return false;
		}

		var ygzt = EastYgb_dataset.getValue("ygzt");
		if (ygzt == null || "" == ygzt) {
			alert("�ֶ�[Ա��״̬]����Ϊ��");
			return false;
		}

		var gwbh = EastYgb_dataset.getValue("gwbh");
		if (gwbh == null || "" == gwbh) {
			alert("�ֶ�[��λ���]����Ϊ��");
			return false;
		}

		var cjrq = EastYgb_dataset.getValue("cjrq");
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
		EastYgb_dataset.flushData(EastYgb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>