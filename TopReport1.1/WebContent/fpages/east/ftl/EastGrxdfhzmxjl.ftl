<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="�����Ŵ��ֻ�����ϸ��¼">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="EastGrxdfhzmxjl" init="true" submitMode="current">
<table width="1300px">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="�����Ŵ��ֻ�����ϸ��¼" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="dkfhzh[80],zhmc[100],xdjjh[60],mxkmmc[60],jylx[80],jyje[40],zhye[40],hxjyrq[60],hxjysj[50],cjrq[50],operation[100]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="900px" height="480px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="hxjylsh,zjylsh,bcxh,dkfhzh,xdjjh,khtybh,yxjgdm,jrxkzh,nbjgh,mxkmbh,yxjgmc,mxkmmc,hxjyrq,hxjysj,bz,zhmc,jylx,jyje,zhye,dfzh,dfhm,dfxh,dfxm,jyqd,xzbz,dbrxm,dbrzjlb,dbrzjhm,jygyh,sqgyh,zy,cbmbz,jyjdbz,cjrq" colNm=4/>
        			<br/><br/><br/><br/><br/>
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
	    EastGrxdfhzmxjl_interface_dataset.setValue("cjrq", enddate);
	}

	//��λһ�м�¼
	function locate(id) {
		var record = EastGrxdfhzmxjl_dataset.find(["id"],[id]);
		if(record) {
			EastGrxdfhzmxjl_dataset.setRecord(record);
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
		EastGrxdfhzmxjl_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	


	//�޸Ĺ���
	function openModifyWindow(id,flag) {
		locate(id);
		if(flag==1){
		EastGrxdfhzmxjl_dataset.setFieldReadOnly("hxjylsh",true);
		EastGrxdfhzmxjl_dataset.setFieldReadOnly("zjylsh",true);
		EastGrxdfhzmxjl_dataset.setFieldReadOnly("bcxh",true);
		EastGrxdfhzmxjl_dataset.setFieldReadOnly("xdjjh",true);
		EastGrxdfhzmxjl_dataset.setFieldReadOnly("dkfhzh",true);
		EastGrxdfhzmxjl_dataset.setFieldReadOnly("hxjyrq",true);
		EastGrxdfhzmxjl_dataset.setFieldReadOnly("cjrq",true);
		$("#btModOrAdd").get(0).style.display="";
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
		var id = EastGrxdfhzmxjl_dataset.getValue("id");
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
		EastGrxdfhzmxjl_dataset.flushData(EastGrxdfhzmxjl_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>