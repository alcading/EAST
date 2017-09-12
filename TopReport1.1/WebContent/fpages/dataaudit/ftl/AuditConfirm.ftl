<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="审核完成确认">
<@CommonQueryMacro.CommonQuery id="AuditConfirm" init="false" submitMode="all">
<table width="900px">
   <tr>
      	<td>
      	   <@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
      	</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btConfirm" fieldStr="apptype,fileType,noApprove,approvePass,approveUnPass"  width="100%" hasFrame="true" height="300"/>
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	function initCallGetter_post() {
		AuditConfirm_interface_dataset.setValue("workDateStart",_today_date);
		AuditConfirm_interface_dataset.setValue("workDateEnd",_today_date);
		AuditConfirm_interface_dataset.setValue("busiType",defaultType);
		AuditConfirm_interface_dataset.setValue("isShowZero","0");
		btConfirm.disable(true);
	}
	function btConfirm_needCheck(button){
		return false;
	}

	function AuditConfirm_dataset_flushDataPost(dataset){
		var len =AuditConfirm_dataset.length;
		if(len==0){
			btConfirm.disable(true);
		}else{
		 	btConfirm.disable(false);
		}
	}

	function btConfirm_postSubmit(button){
		alert("审核确认执行成功！");
		//刷新当前页
		AuditConfirm_dataset.flushData(AuditConfirm_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>