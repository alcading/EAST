<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op="${RequestParameters['op']?default('')}" />
<#assign info = Session["USER_SESSION_INFO"]>
<@CommonQueryMacro.page title="BCMS_���������">
	<@CommonQueryMacro.CommonQuery id="BcmsRequestInfo" init="false">
		<@CommonQueryMacro.ToolBar id="BcmsRequestInfo">
			<table width="100%">
				<tr>
					<td><@CommonQueryMacro.InterfaceElement elId="deliveryType"/></td>
					<td><@CommonQueryMacro.Button id= "btSave" /></td>
				</tr>
			</table>
		</@CommonQueryMacro.ToolBar>
	</@CommonQueryMacro.CommonQuery>
	<iframe id="BcmsRequestInfo"  style="display: none;"></iframe>
	
<script>
	
	function btSave_needCheck(){
		return false;
	}
	
	// �޸�
	function btSave_onClickCheck(button){
        var deliveryType = BcmsRequestInfo_interface_dataset.getValue("deliveryType");
        if(null == deliveryType || '' == deliveryType){
        	easyMsg.info("��ѡ�������");
        	return false;
        }
		document.getElementById("BcmsRequestInfo").src ="${contextPath}/BcmsRequestInfo?deliveryType="+deliveryType;
		return false;
  	}
</script>
</@CommonQueryMacro.page>

