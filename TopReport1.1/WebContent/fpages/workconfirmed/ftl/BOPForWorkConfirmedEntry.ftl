<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="SupplyEnterVerifyStateQueryEntry.title">
<script type="text/javascript" src="${contextPath}/js/xmlUtil.js"></script>
<script type="text/javascript" src="${contextPath}/dwr/interface/PrivAction.js"> </script>
<table width="100%">
	<tr>
		<td width="90%">
		<@CommonQueryMacro.CommonQuery id="BOPForBiExecConfirmedEntry" init="false" submitMode="all" navigate="true">
			<table width="90%" align="left" cellpadding="2">
				<tr>
					<td>
						<@CommonQueryMacro.Interface id="interface" label="CurrencyManEntry.interface.interface.label" />
					</td>
				</tr>
			</table>
		</@CommonQueryMacro.CommonQuery></td>
	</tr>
	<tr>
		<td width="90%">
		<@CommonQueryMacro.CommonQuery id="BOPForWorkConfirmedEntry" init="false" submitMode="all" navigate="false" insertOnEmpty="true">
			<table width="90%" align="left" cellpadding="2">
				<tr>
					<td>
						<@CommonQueryMacro.DataTable id = "datatable1" fieldStr="workDate[80],apptype,fileType,noedit,editWaitConfirm,confirmWaitAudit,auditWaitConfirm,confirmPass,sendreport"  hasFrame="true" height="200" width="100%"/>
					</td>
				</tr>
			</table>
		  </@CommonQueryMacro.CommonQuery>
		  </td>
	</tr>
     <tr>
     	<td width="90%">
	     	<@CommonQueryMacro.CommonQuery id="BOPForBiExecConfirmedEntry" mode="1" navigate="false">
			<table width="90%">
				<tr>
					<td>
						<@CommonQueryMacro.Group id ="group1" label="数据处理完成确认信息" fieldStr="confirmStatus,subfileStatus,confirmRemark" colNm=4/>
					</td>
				</tr>
				 <tr>
					 <td>
						<@CommonQueryMacro.Button id= "btConfirmed" />&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btCancle"/>
					 </td>
				 </tr>
			 </table>
			 </@CommonQueryMacro.CommonQuery>
     	</td>
     </tr>
</table>
	<script language="JavaScript">
	
	function BOPForBiExecConfirmedEntry_interface_dataset_btnSubmit_onClickCheck(){
		var busiType = BOPForBiExecConfirmedEntry_interface_dataset.getValue("busiType");
		var qappType = BOPForBiExecConfirmedEntry_interface_dataset.getValue("qappType");
		if(busiType != null && busiType.length > 0 && qappType != null && qappType.length > 0){
			BOPForWorkConfirmedEntry_dataset.setParameter("busiType", busiType);
			BOPForWorkConfirmedEntry_dataset.setParameter("qappType", qappType);
			BOPForWorkConfirmedEntry_dataset.flushData();
		} else {
			return true;
		}
		btConfirmed.disable(false);
	}
	
	function initCallGetter_post()
	{
		BOPForBiExecConfirmedEntry_interface_dataset.setValue("busiType","01");
		BOPForBiExecConfirmedEntry_interface_dataset.setValue("busiTypeName","01-金宏工程");
		if(BOPForBiExecConfirmedEntry_dataset.length == 0){
			btConfirmed.disable(true);	
		}
     	buttonStatus();
   	}
   	
	function btConfirmed_onClickCheck()
	{
		BOPForBiExecConfirmedEntry_dataset.setParameter("busiType", BOPForBiExecConfirmedEntry_dataset.getValue("busiType"));
		BOPForBiExecConfirmedEntry_dataset.setParameter("appType", BOPForBiExecConfirmedEntry_dataset.getValue("appType"));
		BOPForBiExecConfirmedEntry_dataset.setParameter("confirmRemark", BOPForBiExecConfirmedEntry_dataset.getValue("confirmRemark"));
		btConfirmed.click();
	}
	 
	function btCancle_onClickCheck()
	{
		BOPForBiExecConfirmedEntry_dataset.setParameter("busiType", BOPForBiExecConfirmedEntry_dataset.getValue("busiType"));
		BOPForBiExecConfirmedEntry_dataset.setParameter("appType", BOPForBiExecConfirmedEntry_dataset.getValue("appType"));
	 	BOPForBiExecConfirmedEntry_dataset.setParameter("confirmRemark", BOPForBiExecConfirmedEntry_dataset.getValue("confirmRemark"));
		btCancle.click();
	}
		
	function btConfirmed_postSubmit(){
       alert('工作完成确认成功！');
       BOPForBiExecConfirmedEntry_dataset.flushData();
 	   buttonStatus();
 	   
    }
    
    function btCancle_postSubmit(){
       alert('取消工作完成确认成功！');
       BOPForBiExecConfirmedEntry_dataset.flushData();
       buttonStatus();
    }
    
    function buttonStatus()
    {
	    var confirmstatus = BOPForBiExecConfirmedEntry_dataset.getValue("confirmStatus");
    	var subfilestatus = BOPForBiExecConfirmedEntry_dataset.getValue("subfileStatus");
    	
    	btCancle.disable(true);	
   		if('01' == subfilestatus )
		{
			btCancle.disable(true);	
			btConfirmed.disable(true);
		}
		
		if('01'== confirmstatus && '01' != subfilestatus )
		{
	    	btConfirmed.disable(true);
	    	btCancle.disable(false);	
		}
		
		if('03'== confirmstatus && '01' != subfilestatus)
		{
			btConfirmed.disable(false);
	    	btCancle.disable(true);	
		}
    }
		
	</script>
</@CommonQueryMacro.page>