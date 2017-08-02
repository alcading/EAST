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
<title>网银平台</title>
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

	<%
	UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
	if(userInfo!=null)
	{
		out.println("document.loginForm.userName.value = \""+userInfo.getTlrNo()+"\";");
		out.println("document.loginForm.userName.readOnly=true;");
		out.println("document.loginForm.brCode.value = \""+userInfo.getBrCode()+"\";");
		out.println("document.loginForm.brCode.readOnly=true;");
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
/** modify by chenjinghui 2010-5-20 HTEBANK-11 begin*/
function resetForm(){
	document.loginForm.reset();
	document.loginForm.userName.value ="";
	document.loginForm.passWord.value ="";
}
/** modify by chenjinghui 2010-5-20 HTEBANK-11 end*/
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
<html:form action="/adminlogin.do" target="_top" focus="userName">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#e5f6cf">&nbsp;</td>
  </tr>
  <tr>
    <td height="608" background="<%=request.getContextPath()%>/loginImg/login_03.gif"><table width="862" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="266" background="<%=request.getContextPath()%>/loginImg/login_04.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="95"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="424" height="95" background="<%=request.getContextPath()%>/loginImg/login_06.gif">&nbsp;</td>
            <td width="183" background="<%=request.getContextPath()%>/loginImg/login_07.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="21%" height="30"><div align="center"><span class="STYLE3">用户名</span></div></td>
                <td width="79%" height="30"><html:text property="userName" style="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;" onkeypress="nextEvent('passWord')"/></td>
              </tr>
              <tr>
                <td height="30"><div align="center"><span class="STYLE3">密码</span></div></td>
                <td height="30"><html:password property="passWord" style="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;" onkeypress="nextEvent('submit')"/></td>
              </tr>
              <tr>
                <td height="30">&nbsp;</td>
                <td height="30"><img src="<%=request.getContextPath()%>/loginImg/dl.gif" width="81" height="22" border="0" usemap="#Map"></td>
              </tr>
            </table></td>
            <td width="255" background="<%=request.getContextPath()%>/loginImg/login_08.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="247" valign="top" background="<%=request.getContextPath()%>/loginImg/login_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="22%" height="30">&nbsp;</td>
            <td width="56%" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             	<font id="mistake" color="#FF0000" size="2px">
							<%=(userInfo!=null)?"用户在本机已登录，如需再次登录，请输入密码":" " %>
							&nbsp;&nbsp;
							<%= (session.getAttribute("RET_ERRMSG") == null)?" ":((String)session.getAttribute("RET_ERRMSG"))%>
				</font>
            </td>
            <td width="22%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="44%" height="20">&nbsp;</td>
                <td width="56%" class="STYLE4">版本 2010V0.9 </td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#a2d962">&nbsp;</td>
  </tr>
</table>
</html:form>
<map name="Map"><area shape="rect" coords="3,3,36,19" href="#" onclick="submitForm()">
<area shape="rect" coords="40,3,78,18" href="#" onclick="resetForm()"></map></body>
</html:html>
