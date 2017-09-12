<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/application-tags" prefix="app" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.framework.util.DateUtil"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="<html:rewrite page='/css/style.css' />">
<%
String path = request.getContextPath();
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
GlobalInfo.setCurrentInstance(globalInfo);
%>
</head>

<body style="text-align: center;">
<br/>
<table width="80%" h border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="56" align="right"><img src="<%=path %>/images/info_f1.gif" width="56" height="44"></td>
    <td width="100%" background="<%=path %>/images/info_f3.gif"><img src="<%=path %>/images/info_f2.gif" width="165" height="44"></td>
    <td width="26"><img src="<%=path %>/images/info_f4.gif" width="26" height="44"></td>
  </tr>
   <tr>
    <td height="71" valign="top" background="<%=path %>/images/info_f6.gif"><img src="<%=path %>/images/info_f5.gif" width="56" height="30"></td>
    <td>
		<table>
			<tr>
				<td valign="top" align="center" style="padding: 15px">
				<img src="<%=path %>/login/homepage/image/info.gif" border="0"/>
				</td>
				<td style="padding-left: 10px;line-height: 28px;font-size: 12px;">
					<div>工作日期：<%=DateUtil.dateToString(globalInfo.getTxdate()) %></div>
					<div style="color: green">当前工作日期已执行‘数据处理完成确认’操作，业务已被锁定，将于下一工作日开启！</div>
					<div style="color: green">如有疑问，请联系相关人员。</div>
				</td>
			</tr>
		</table>
    </td>
    <td width="26" background="<%=path %>/images/info_f11.gif">&nbsp;</td>
  </tr>
<tr>
    <td width="56"><img src="<%=path %>/images/info_f7.gif" width="56" height="36"></td>
    <td background="<%=path %>/images/info_f9.gif"><img src="<%=path %>/images/info_f8.gif" width="77" height="36"></td>
    <td width="26"><img src="<%=path %>/images/info_f10.gif" width="25" height="35"></td>
  </tr>
</table>
</body>
</html>
