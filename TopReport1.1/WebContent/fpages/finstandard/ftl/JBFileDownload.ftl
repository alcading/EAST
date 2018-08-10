<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op="${RequestParameters['op']?default('')}" />
<#assign info = Session["USER_SESSION_INFO"]>
<@CommonQueryMacro.page title="下载报文">
	<@CommonQueryMacro.CommonQuery id="JBFileDownload" init="false">
		<@CommonQueryMacro.ToolBar id="JBFileDownload">
			<table width="100%">
				<tr>
					<td><@CommonQueryMacro.InterfaceElement elId="sjrq"/></td>
					<td><@CommonQueryMacro.Button id= "btLoad" /></td>
				</tr>
			</table>
		</@CommonQueryMacro.ToolBar>
	</@CommonQueryMacro.CommonQuery>
	<iframe id="filedownloadfrm"  style="display: none;"></iframe>
	
<script>
	window.onload=function(){
		var date = new Date();
	    var today_date = date.getDate();
	    if(today_date < 10) {
	    	today_date = "0" + date.getDate();
	    }
	    var currentDate = date.getFullYear()+"-" + (date.getMonth()+1) + "-" + today_date;
	    JBFileDownload_interface_dataset.setValue("sjrq", currentDate);
	
	}
	// 下载
	function btLoad_onClickCheck(button){
        var sjrq = JBFileDownload_interface_dataset.getValue("sjrq");
        if(null == sjrq || '' == sjrq){
        	easyMsg.info("请选择数据日期！");
        	return false;
        }
		document.getElementById("filedownloadfrm").src ="${contextPath}/jbFileLoad?sjrq="+sjrq;
		return false;
  	}
</script>
</@CommonQueryMacro.page>

