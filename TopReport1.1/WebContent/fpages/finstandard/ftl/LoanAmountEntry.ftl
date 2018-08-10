<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op="${RequestParameters['op']?default('')}" />
<#assign info = Session["USER_SESSION_INFO"]>
<@CommonQueryMacro.page title="LoanAmountEntry.title">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="LoanAmountEntry" init="false" submitMode="current">
      		<table width="100%">
      			<tr>
      			  <td colspan="3" valign="top">
      			    <@CommonQueryMacro.Interface id="interface" label="finStandard.interface.label" />
      			  </td>
      			</tr>

      			<tr>
      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>	
      			</tr>
      			
      			<tr>
		    		<td>
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="sjrq,jrjgbm,khlx,jkrbm,dkjjbh,dksjtx,dkbz,dkfsje,llsp,dkzt,opr[120]" hasFrame="true" width="1250" height="300"  readonly="true"/>
		      		</td>
		    	</tr>
  				<tr align="center" style="display:none">
					<td><@CommonQueryMacro.Button id= "btMod"/></td>
					<td><@CommonQueryMacro.Button id= "btDtl"/></td>
				</tr>
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
   
<script language="javascript">
	var op ="${op}";
	
	function initCallGetter_post(dataset) {
		LoanAmountEntry_dataset.setParameter("op", op);
	}
	
	//��λһ����¼
	function locate(id) {
		var record = LoanAmountEntry_dataset.find(["id"],[id]);
		if (record) {
			LoanAmountEntry_dataset.setRecord(record);
		}
	}
	
	//��ϵͳˢ�µ�Ԫ�������ʱ������
	function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//�����ڼ�¼ʱ
		    var sjrq = record.getValue("sjrq");
		    var jkrbm=record.getValue("jkrbm");
		    var dkjjbh=record.getValue("dkjjbh");	
			cell.innerHTML="<center><a href=\"JavaScript:doModify('"+value+"')\"><@bean.message key="finStandard.button.btMod" /></a>&nbsp;<a href=\"JavaScript:showDetail('"+value+"')\"><@bean.message key="finStandard.button.btDtl" /></a></center>";
		} else {//�������ڼ�¼ʱ
		 cell.innerHTML="&nbsp;";
		}
	}

	//�޸�
	function doModify(id) {
		 locate(id);
		 LoanAmountEntry_dataset.setParameter("sjrq", sjrq);
		 LoanAmountEntry_dataset.setParameter("jkrbm", jkrbm);
		 LoanAmountEntry_dataset.setParameter("dkjjbh", dkjjbh);
		 btMod.click();
	}
	
	//����
	function showDetail(id){
	     locate(id);
		 LoanAmountEntry_dataset.setParameter("sjrq", sjrq);
		 LoanAmountEntry_dataset.setParameter("jkrbm", jkrbm);
		 LoanAmountEntry_dataset.setParameter("dkjjbh", dkjjbh);
		 btDtl.click();
	}
</script>
</@CommonQueryMacro.page>