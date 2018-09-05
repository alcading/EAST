<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="��Ա��">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastGyb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="��Ա��" />
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

//����ѯ�����е�Ĭ��ֵΪ��ǰ�µ���һ���µ����һ��
window.onload=function(){
	var date = new Date();
    var day = new Date(date.getFullYear(), date.getMonth(), 0).getDate();
	var enddate = new Date(new Date().getFullYear(), new Date().getMonth()-1, day);
    EastGyb_interface_dataset.setValue("cjrq", enddate);
}

	//��λһ�м�¼
	function locate(id) {
		var record = EastGyb_dataset.find(["id"],[id]);
		if(record) {
			EastGyb_dataset.setRecord(record);
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
		EastGyb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//��������
	function btNewClick() {
		$("#btModOrAdd").get(0).style.display="";
		EastGyb_dataset.insertRecord("end");
		subwindow_signWindow.show();
	}
	

	//�޸Ĺ���
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
		var id = EastGyb_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}
		var gyh = EastGyb_dataset.getValue("gyh");
		if (gyh == null || "" == gyh) {
			alert("�ֶ�[��Ա��]����Ϊ��");
			return false;
		}

		var gh = EastGyb_dataset.getValue("gh");
		if (gh == null || "" == gh) {
			alert("�ֶ�[����]����Ϊ��");
			return false;
		}

		var yxjgdm = EastGyb_dataset.getValue("yxjgdm");
		if (yxjgdm == null || "" == yxjgdm) {
			alert("�ֶ�[���л�������]����Ϊ��");
			return false;
		}

		var nbjgh = EastGyb_dataset.getValue("nbjgh");
		if (nbjgh == null || "" == nbjgh) {
			alert("�ֶ�[�ڲ�������]����Ϊ��");
			return false;
		}

		var zxjgdm = EastGyb_dataset.getValue("zxjgdm");
		if (zxjgdm == null || "" == zxjgdm) {
			alert("�ֶ�[���л�������]����Ϊ��");
			return false;
		}

		var jrxkzh = EastGyb_dataset.getValue("jrxkzh");
		if (jrxkzh == null || "" == jrxkzh) {
			alert("�ֶ�[�������֤��]����Ϊ��");
			return false;
		}

		var yxjgmc = EastGyb_dataset.getValue("yxjgmc");
		if (yxjgmc == null || "" == yxjgmc) {
			alert("�ֶ�[���л�������]����Ϊ��");
			return false;
		}

		var gylx = EastGyb_dataset.getValue("gylx");
		if (gylx == null || "" == gylx) {
			alert("�ֶ�[��Ա����]����Ϊ��");
			return false;
		}

		var sfstgy = EastGyb_dataset.getValue("sfstgy");
		if (sfstgy == null || "" == sfstgy) {
			alert("�ֶ�[�Ƿ�ʵ���Ա]����Ϊ��");
			return false;
		}

		var khjlbz = EastGyb_dataset.getValue("khjlbz");
		if (khjlbz == null || "" == khjlbz) {
			alert("�ֶ�[�ͻ������־]����Ϊ��");
			return false;
		}

		var jbzwbz = EastGyb_dataset.getValue("jbzwbz");
		if (jbzwbz == null || "" == jbzwbz) {
			alert("�ֶ�[���������־]����Ϊ��");
			return false;
		}

		var qxglbz = EastGyb_dataset.getValue("qxglbz");
		if (qxglbz == null || "" == qxglbz) {
			alert("�ֶ�[Ȩ�޹����־]����Ϊ��");
			return false;
		}

		var ybglbz = EastGyb_dataset.getValue("ybglbz");
		if (ybglbz == null || "" == ybglbz) {
			alert("�ֶ�[һ������־]����Ϊ��");
			return false;
		}

		var xdybz = EastGyb_dataset.getValue("xdybz");
		if (xdybz == null || "" == xdybz) {
			alert("�ֶ�[�Ŵ�Ա��־]����Ϊ��");
			return false;
		}

		var kgybz = EastGyb_dataset.getValue("kgybz");
		if (kgybz == null || "" == kgybz) {
			alert("�ֶ�[���Ա��־]����Ϊ��");
			return false;
		}

		var zhgybz = EastGyb_dataset.getValue("zhgybz");
		if (zhgybz == null || "" == zhgybz) {
			alert("�ֶ�[�ۺϹ�Ա��־]����Ϊ��");
			return false;
		}

		var sqbz = EastGyb_dataset.getValue("sqbz");
		if (sqbz == null || "" == sqbz) {
			alert("�ֶ�[��Ȩ��־]����Ϊ��");
			return false;
		}

		var sqfw = EastGyb_dataset.getValue("sqfw");
		if (sqfw == null || "" == sqfw) {
			alert("�ֶ�[��Ȩ��Χ]����Ϊ��");
			return false;
		}

		var gwbh = EastGyb_dataset.getValue("gwbh");
		if (gwbh == null || "" == gwbh) {
			alert("�ֶ�[��λ���]����Ϊ��");
			return false;
		}

		var gyyhjb = EastGyb_dataset.getValue("gyyhjb");
		if (gyyhjb == null || "" == gyyhjb) {
			alert("�ֶ�[��Ա�û�����]����Ϊ��");
			return false;
		}

		var gyqxjb = EastGyb_dataset.getValue("gyqxjb");
		if (gyqxjb == null || "" == gyqxjb) {
			alert("�ֶ�[��ԱȨ�޼���]����Ϊ��");
			return false;
		}

		var sgrq = EastGyb_dataset.getValue("sgrq");
		if (sgrq == null || "" == sgrq) {
			alert("�ֶ�[�ϸ�����]����Ϊ��");
			return false;
		}

		var gwzt = EastGyb_dataset.getValue("gwzt");
		if (gwzt == null || "" == gwzt) {
			alert("�ֶ�[��Ա״̬]����Ϊ��");
			return false;
		}

		var cjrq = EastGyb_dataset.getValue("cjrq");
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
		EastGyb_dataset.flushData(EastGyb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>