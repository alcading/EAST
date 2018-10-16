<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="������ϵ��">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastJggxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="������ϵ��" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="-,btDel" fieldStr="select,yhjgdm[100],id[60],jrxkzh[110],yhjgmc[300],yzbm[60],sjgljgdm[60],sjgljgmc[300],cjrq[60],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="yhjgdm,id,jrxkzh,yhjgmc,yzbm,sjgljgdm,sjgljgmc,cjrq" colNm=4/>
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
    EastJggxb_interface_dataset.setValue("cjrq", enddate);
}


	//��λһ�м�¼
	function locate(id) {
		var record = EastJggxb_dataset.find(["id"],[id]);
		if(record) {
			EastJggxb_dataset.setRecord(record);
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
		EastJggxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	

	//�޸Ĺ���
	function openModifyWindow(id,flag) {
		locate(id);
		if(flag==1){
		EastJggxb_dataset.setFieldReadOnly("id",true);
		$("#btModOrAdd").get(0).style.display="";
		}
		
		subwindow_signWindow.show();	
	}
	
	function btDel_onClickCheck(button) {
		var rec = EastJggxb_dataset.firstUnit;
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
		var id = EastJggxb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}
		var yhjgdm = EastJggxb_dataset.getValue("yhjgdm");
		if (yhjgdm == null || "" == yhjgdm) {
			alert("�ֶ�[���л�������]����Ϊ��");
			return false;
		}

		var nbjgh = EastJggxb_dataset.getValue("nbjgh");
		if (nbjgh == null || "" == nbjgh) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}

		var jrxkzh = EastJggxb_dataset.getValue("jrxkzh");
		if (jrxkzh == null || "" == jrxkzh) {
			alert("�ֶ�[�������֤��]����Ϊ��");
			return false;
		}

		var yhjgmc = EastJggxb_dataset.getValue("yhjgmc");
		if (yhjgmc == null || "" == yhjgmc) {
			alert("�ֶ�[���л�������]����Ϊ��");
			return false;
		}

		var yzbm = EastJggxb_dataset.getValue("yzbm");
		if (yzbm == null || "" == yzbm) {
			alert("�ֶ�[��������]����Ϊ��");
			return false;
		}

		var sjgljgdm = EastJggxb_dataset.getValue("sjgljgdm");
		if (sjgljgdm == null || "" == sjgljgdm) {
			alert("�ֶ�[�ϼ������������]����Ϊ��");
			return false;
		}

		var sjgljgmc = EastJggxb_dataset.getValue("sjgljgmc");
		if (sjgljgmc == null || "" == sjgljgmc) {
			alert("�ֶ�[�ϼ������������]����Ϊ��");
			return false;
		}

		var cjrq = EastJggxb_dataset.getValue("cjrq");
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
		EastJggxb_dataset.flushData(EastJggxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>