<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op="${RequestParameters['op']?default('')}" />
<#assign info = Session["USER_SESSION_INFO"]>
<@CommonQueryMacro.page title="修改工作日期">
	<@CommonQueryMacro.CommonQuery id="EastGlobalinfo" init="false">
		<@CommonQueryMacro.ToolBar id="EastGlobalinfo">
			<table width="100%">
				<tr>
					<td><@CommonQueryMacro.InterfaceElement elId="sjrq"/></td>
					<td><@CommonQueryMacro.Button id= "btSave" /></td>
				</tr>
			</table>
		</@CommonQueryMacro.ToolBar>
	</@CommonQueryMacro.CommonQuery>
	<iframe id="EastGlobalinfoUpdate"  style="display: none;"></iframe>
	
<script>
	window.onload=function(){
		var date = new Date();
	    var today_date = date.getDate();
	    if(today_date < 10) {
	    	today_date = "0" + date.getDate();
	    }
	    var currentDate = date.getFullYear()+"-" + (date.getMonth()+1) + "-" + today_date;
	    EastGlobalinfo_interface_dataset.setValue("sjrq", currentDate);
	
	}
	
function btSave_needCheck(){
	return false;
}
	
	// 修改
	function btSave_onClickCheck(button){
        var sjrq = EastGlobalinfo_interface_dataset.getValue("sjrq");
        if(null == sjrq || '' == sjrq){
        	easyMsg.info("请选择工作日期！");
        	return false;
        }
		document.getElementById("EastGlobalinfoUpdate").src ="${contextPath}/EastGlobalinfoUpdate?sjrq="+sjrq;
		return false;
  	}
</script>
</@CommonQueryMacro.page>

