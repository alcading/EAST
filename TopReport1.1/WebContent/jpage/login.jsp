<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/application-tags" prefix="app"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎光临网银票据仿真系统</title>

<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #cae1f3;
}

.STYLE1 {
	color: #FFFFFF;
	line-height: 25px;
	font-size: 14px;
}

.STYLE2 {
	color: #FFFFFF
}

.font {
	font-size: 9pt;
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function initForm(){
	document.loginForm.userName.value=="";
}
function submitForm(){
	 //add by fubo 20100331 BMS-2561 去掉用户名的前后空格 start
	document.loginForm.userName.value=document.loginForm.userName.value.replace(/(^\s*)|(\s*$)/g,"");
     //add by fubo 20100331 BMS-2561 去掉用户名的前后空格 end
	if(document.loginForm.userName.value==""){
		document.all.mistake.innerText="用户名不能为空！";
		return;
	}
	document.loginForm.submit();
}

function resetForm(){
	document.all.mistake.innerText="";
	document.loginForm.reset();
}

function changeValue(){
	var custType = document.loginForm.brCode.value;
	if (custType == '1'){
		document.all.desc.innerText = "企业组织机构代码";
	}else{
// modified by qing.deng 20091217 BMS-2345 代理行用客户号登陆 begin
		document.all.desc.innerText = "客户号";
// modified by qing.deng 20091217 BMS-2345 end
	}
}
</script>
</head>

<body onload="initForm()">
<p><br />
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<html:form action="/custlogin.do" target="_top" focus="brCode">
<table width="774" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="326" background="<%=request.getContextPath()%>/images/index.jpg">
		<table width="65%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<p><br />
				<br />
				<br />
				</p>
				<table width="42%" border="0" align="right" cellpadding="0"
					cellspacing="2" class="font">
					<tbody>
						<tr>
						   <td width="31%"> 客户类型:&nbsp;&nbsp;</td>
						   <td><html:select property="brCode" onchange="changeValue();">
		                        <option value="1">企业客户</option>
		                        <option value="2">银行客户</option>
		                      </html:select>
		                 </td>
						</tr>
						<tr>
						   <td></td>
						</tr>
						<tr>
							<td width="31%"> <font id="desc"> 企业组织机构代码 </font> </td>
							<td width="69%"><font color="#336600" size="2"><font
								color="#336600" size="2"><font color="#336600" size="2"><font
								color="#336600" size="2"> <html:text property="userName"
								size="20"
								style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; FONT-SIZE: 9pt; BORDER-LEFT: #666666 1px solid; WIDTH: 88px; BORDER-BOTTOM: #666666 1px solid; BACKGROUND-COLOR: #f4faff"
								 /> </font></font></font></font></td>
						</tr>
						<tr>
						   <td></td>
						</tr>
						<tr>
							<td height="32" valign="bottom" >&nbsp;</td>
							<td ><html:link href="#" onclick="submitForm()" ><img src="<%=request.getContextPath()%>/images/icon01.jpg"
								width="45" height="18" border="0" /></html:link>

							</td>
						</tr>

						<tr>
							<td>
							   <div align="center"></div>
							</td>
							<td>
							<font id="mistake" color="#FF0000">
							     <%= (session.getAttribute("RET_ERRMSG") == null)?" ":((String)session.getAttribute("RET_ERRMSG"))%>
							</font>
							</td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>

		</table>
		</td>
	</tr>

</table>
</html:form>
</body>
</html:html>
