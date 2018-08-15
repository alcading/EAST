<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="���ڹ�����Ϣ��">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastJrgjxxb" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="���ڹ�����Ϣ��" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="yxjgdm[100],nbjgh[80],zqmc[100],jrgjbh[100],zclx[60],fxjg[100],fxgb[80],cppj[60],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="yxjgdm,jrxkzh,nbjgh,yxjgmc,zqmc,jrgjbh,zclx,bz,fxjg,yxczqydm,fxgb,dbjg,cppj,pjjg,fxztpj,jyzhlx,pmll,fxjge,fxrq,ssrq,qxrq,dqrq,lllx,hqbs,zjpgjg,pgjgsj,ye,cjrq" colNm=4/>
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
    EastJrgjxxb_interface_dataset.setValue("cjrq", enddate);
}

	//��λһ�м�¼
	function locate(id) {
		var record = EastJrgjxxb_dataset.find(["id"],[id]);
		if(record) {
			EastJrgjxxb_dataset.setRecord(record);
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
		EastJrgjxxb_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//��������
	function btNewClick() {
		EastJrgjxxb_dataset.setFieldReadOnly("yxjgdm",false);
		EastJrgjxxb_dataset.setFieldReadOnly("jrxkzh",false);
		EastJrgjxxb_dataset.setFieldReadOnly("nbjgh",false);
		EastJrgjxxb_dataset.setFieldReadOnly("yxjgmc",false);
		EastJrgjxxb_dataset.setFieldReadOnly("zqmc",false);
		EastJrgjxxb_dataset.setFieldReadOnly("jrgjbh",false);
		EastJrgjxxb_dataset.setFieldReadOnly("zclx",false);
		EastJrgjxxb_dataset.setFieldReadOnly("bz",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxjg",false);
		EastJrgjxxb_dataset.setFieldReadOnly("yxczqydm",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxgb",false);
		EastJrgjxxb_dataset.setFieldReadOnly("dbjg",false);
		EastJrgjxxb_dataset.setFieldReadOnly("cppj",false);
		EastJrgjxxb_dataset.setFieldReadOnly("pjjg",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxztpj",false);
		EastJrgjxxb_dataset.setFieldReadOnly("jyzhlx",false);
		EastJrgjxxb_dataset.setFieldReadOnly("pmll",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxjge",false);
		EastJrgjxxb_dataset.setFieldReadOnly("fxrq",false);
		EastJrgjxxb_dataset.setFieldReadOnly("ssrq",false);
		EastJrgjxxb_dataset.setFieldReadOnly("qxrq",false);
		EastJrgjxxb_dataset.setFieldReadOnly("dqrq",false);
		EastJrgjxxb_dataset.setFieldReadOnly("lllx",false);
		EastJrgjxxb_dataset.setFieldReadOnly("hqbs",false);
		EastJrgjxxb_dataset.setFieldReadOnly("zjpgjg",false);
		EastJrgjxxb_dataset.setFieldReadOnly("pgjgsj",false);
		EastJrgjxxb_dataset.setFieldReadOnly("ye",false);
		EastJrgjxxb_dataset.setFieldReadOnly("cjrq",false);
		$("#btModOrAdd").get(0).style.display="";
		EastJrgjxxb_dataset.insertRecord("end");
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
			EastJrgjxxb_dataset.setFieldReadOnly("yxjgdm",false);
			EastJrgjxxb_dataset.setFieldReadOnly("jrxkzh",false);
			EastJrgjxxb_dataset.setFieldReadOnly("nbjgh",false);
			EastJrgjxxb_dataset.setFieldReadOnly("yxjgmc",false);
			EastJrgjxxb_dataset.setFieldReadOnly("zqmc",false);
			EastJrgjxxb_dataset.setFieldReadOnly("jrgjbh",true);
			EastJrgjxxb_dataset.setFieldReadOnly("zclx",false);
			EastJrgjxxb_dataset.setFieldReadOnly("bz",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxjg",false);
			EastJrgjxxb_dataset.setFieldReadOnly("yxczqydm",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxgb",false);
			EastJrgjxxb_dataset.setFieldReadOnly("dbjg",false);
			EastJrgjxxb_dataset.setFieldReadOnly("cppj",false);
			EastJrgjxxb_dataset.setFieldReadOnly("pjjg",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxztpj",false);
			EastJrgjxxb_dataset.setFieldReadOnly("jyzhlx",false);
			EastJrgjxxb_dataset.setFieldReadOnly("pmll",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxjge",false);
			EastJrgjxxb_dataset.setFieldReadOnly("fxrq",false);
			EastJrgjxxb_dataset.setFieldReadOnly("ssrq",false);
			EastJrgjxxb_dataset.setFieldReadOnly("qxrq",false);
			EastJrgjxxb_dataset.setFieldReadOnly("dqrq",false);
			EastJrgjxxb_dataset.setFieldReadOnly("lllx",false);
			EastJrgjxxb_dataset.setFieldReadOnly("hqbs",false);
			EastJrgjxxb_dataset.setFieldReadOnly("zjpgjg",false);
			EastJrgjxxb_dataset.setFieldReadOnly("pgjgsj",false);
			EastJrgjxxb_dataset.setFieldReadOnly("ye",false);
			EastJrgjxxb_dataset.setFieldReadOnly("cjrq",true);
			$("#btModOrAdd").get(0).style.display="";
		}
		if(flag==2){
			EastJrgjxxb_dataset.setFieldReadOnly("yxjgdm",true);
			EastJrgjxxb_dataset.setFieldReadOnly("jrxkzh",true);
			EastJrgjxxb_dataset.setFieldReadOnly("nbjgh",true);
			EastJrgjxxb_dataset.setFieldReadOnly("yxjgmc",true);
			EastJrgjxxb_dataset.setFieldReadOnly("zqmc",true);
			EastJrgjxxb_dataset.setFieldReadOnly("jrgjbh",true);
			EastJrgjxxb_dataset.setFieldReadOnly("zclx",true);
			EastJrgjxxb_dataset.setFieldReadOnly("bz",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxjg",true);
			EastJrgjxxb_dataset.setFieldReadOnly("yxczqydm",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxgb",true);
			EastJrgjxxb_dataset.setFieldReadOnly("dbjg",true);
			EastJrgjxxb_dataset.setFieldReadOnly("cppj",true);
			EastJrgjxxb_dataset.setFieldReadOnly("pjjg",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxztpj",true);
			EastJrgjxxb_dataset.setFieldReadOnly("jyzhlx",true);
			EastJrgjxxb_dataset.setFieldReadOnly("pmll",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxjge",true);
			EastJrgjxxb_dataset.setFieldReadOnly("fxrq",true);
			EastJrgjxxb_dataset.setFieldReadOnly("ssrq",true);
			EastJrgjxxb_dataset.setFieldReadOnly("qxrq",true);
			EastJrgjxxb_dataset.setFieldReadOnly("dqrq",true);
			EastJrgjxxb_dataset.setFieldReadOnly("lllx",true);
			EastJrgjxxb_dataset.setFieldReadOnly("hqbs",true);
			EastJrgjxxb_dataset.setFieldReadOnly("zjpgjg",true);
			EastJrgjxxb_dataset.setFieldReadOnly("pgjgsj",true);
			EastJrgjxxb_dataset.setFieldReadOnly("ye",true);
			EastJrgjxxb_dataset.setFieldReadOnly("cjrq",true);
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
		var id = EastJrgjxxb_dataset.getValue("id");
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
		EastJrgjxxb_dataset.flushData(EastJrgjxxb_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>