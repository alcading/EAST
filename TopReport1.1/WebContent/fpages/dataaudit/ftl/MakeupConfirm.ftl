<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="补录确认">
<@CommonQueryMacro.CommonQuery id="MakeupConfirm" init="false" submitMode="all">
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
			<@CommonQueryMacro.DataTable paginationbar="btConfirm" id="datatable1" fieldStr="apptype,fileType,hashNum,noNum"  width="100%" hasFrame="true" height="300"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	function initCallGetter_post(){
		MakeupConfirm_interface_dataset.setValue("workDateStart",_today_date);
		MakeupConfirm_interface_dataset.setValue("workDateEnd",_today_date);
		MakeupConfirm_interface_dataset.setValue("busiType",defaultType);
		MakeupConfirm_interface_dataset.setValue("isShowZero","0");
		btConfirm.disable(true);
		
	}
	

	function btConfirm_needCheck(button){
		return false;
	}

	function MakeupConfirm_dataset_flushDataPost(dataset){
		var len = MakeupConfirm_dataset.length;
		if(len==0){
			btConfirm.disable(true);
		}else{
		 	btConfirm.disable(false);
		}
	}

	function btConfirm_postSubmit(button){
		alert("补录完成确认执行成功！");
		//刷新当前页
		MakeupConfirm_dataset.flushData(MakeupConfirm_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>