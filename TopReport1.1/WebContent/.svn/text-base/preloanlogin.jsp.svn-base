<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/application-tags" prefix="app"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import ="com.huateng.ebank.business.common.UserSessionInfo"  %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个贷预审批系统</title>
<script language="JavaScript" type="text/JavaScript">
function submitForm(){
	document.loginForm.userName.value = "";
	document.loginForm.submit();
}

function submitFormSearch(){
	document.loginForm.userName.value = "1";
	document.loginForm.submit();
}
</script>
</head>

<body>
<html:form action="/preloanlogin.do" target="_top">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<td height="100%" valign="center" bgcolor="#BBCEDB">
		<table width="800px" height="600px" border="0" align="center" cellpadding="0" valign="middle" cellspacing="0">
		<div style="position:absolute;z-index:0">
		<img src="<%=request.getContextPath()%>/loginImg/preloanlogin.jpg" usemap="#map">
		</div>
		</table>
	</td>
</table>
<div style="display:none">
		<html:text property="userName"/>
</div>
</html:form>
<map name="Map">
<area shape="rect" coords="318,435,402,468" href="#" onclick="submitForm()">
<area shape="rect" coords="440,435,525,468" href="#" onclick="submitFormSearch()">
</map>
</body>
</html:html>
