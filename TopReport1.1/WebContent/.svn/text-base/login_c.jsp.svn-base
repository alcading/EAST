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
<title><bean:message key="login.title"/></title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE3 {color: #528311; font-size: 12px; }
.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function func_check()
{
	<% if (request.getAttribute("REQ_MSG") != null) {
		String errMsg = ((String) request.getAttribute("REQ_MSG")).replace("\n","[n]");
	%>
	var errMsg = "<%= errMsg %>";
	alert(errMsg.replace("[n]","\n"));
	<% } %>
	<%
	UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
	if(userInfo!=null)
	{
		out.println("document.loginForm.userName.value = \""+userInfo.getTlrNo()+"\";");
		out.println("document.loginForm.userName.readOnly=true;");
		out.println("focus(document.loginForm.passWord);");
	}
%>

	return;
}

function submitForm(){
	if(document.loginForm.userName.value==""){
		document.all.mistake.innerText="用户名不能为空！";
		return;
	}else if(document.loginForm.passWord.value==""){
		document.all.mistake.innerText="密码不能为空！";
		return;
	}
	document.loginForm.submit();
}
//modify by chenjinghui 2010-5-20 HTEBANK-11 begin
function resetForm(){
	document.loginForm.reset();
	document.loginForm.userName.value ="";
	document.loginForm.passWord.value ="";
}
//modify by chenjinghui 2010-5-20 HTEBANK-11 end
function nextEvent(strName){
	if(event.keyCode==13 || event.keyCode==9){
	 	if (strName == "submit"){
			submitForm();
		}else{
			document.getElementById(strName).focus();
		}
	}
}
</script>
</head>

<body onload="func_check()">
<html:form action="/custlogin.do" target="_top" focus="userName">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#e5f6cf">
	    <div align="right">
	    	<html:link action="/switchLanuage.do?language=zh&country=CN">中文（简体）</html:link>
	    	/<html:link action="/switchLanuage.do?language=zh&country=TW">中文（繁体）</html:link>
	    	/<html:link action="/switchLanuage.do?language=en&country=US">English</html:link>
	    </div>
    </td>
  </tr>
  <tr>
	<td height="100%" valign="center" bgcolor="#BBCEDB">
		<table width="800px" height="600px" border="0" align="center" cellpadding="0" valign="middle" cellspacing="0">
		<div style="position:absolute;z-index:0">
		<img src="<%=request.getContextPath()%>/loginImg/login.jpg" usemap="#map">
		</div>
		<div style="position:absolute;z-index:1">
		<html:text property="userName"  style="height:17px; width:110px;position:absolute;left:411px;top:332px; font-size:12px;"
			onkeypress="nextEvent('passWord');" maxlength="8"/>
		</div>
		<div style="position:absolute;z-index:1">
		<html:password property="passWord" style="height:17px; width:110px;position:absolute;left:411px;top:374px; font-size:12px; "
			onkeypress="nextEvent('submit');"/>
		</div>
		</table>
	</td>
	</tr>
</table>

</html:form>
<map name="Map">
<area shape="rect" coords="318,435,402,468" href="#" onclick="submitForm()">
<area shape="rect" coords="440,435,525,468" href="#" onclick="resetForm()">
</map>
</body>
</html:html>
