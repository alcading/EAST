<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="56"><img src="<%=request.getContextPath()%>/images/info_f1.gif" width="56" height="44"></td>
    <td width="921" background="<%=request.getContextPath()%>/images/info_f3.gif"><img src="<%=request.getContextPath()%>/images/info_f2.gif" width="165" height="44"></td>
    <td width="26"><img src="<%=request.getContextPath()%>/images/info_f4.gif" width="26" height="44"></td>
  </tr>
  <tr>
    <td valign="top" background="<%=request.getContextPath()%>/images/info_f6.gif"><img src="<%=request.getContextPath()%>/images/info_f5.gif" width="56" height="30"></td>
    <td align="center" class="errors">
    <bean:write property="actno" name="checkActnoForm"/>
    </td>
    <td width="26" background="<%=request.getContextPath()%>/images/info_f11.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="top" background="<%=request.getContextPath()%>/images/info_f6.gif"></td>
    <td align="center" class="errors">
    <bean:write property="desc" name="checkActnoForm"/>
    </td>
    <td width="26" background="<%=request.getContextPath()%>/images/info_f11.gif">&nbsp;</td>
  </tr>
  <tr>
    <td><img src="<%=request.getContextPath()%>/images/info_f7.gif" width="56" height="36"></td>
    <td background="<%=request.getContextPath()%>/images/info_f9.gif"><img src="<%=request.getContextPath()%>/images/info_f8.gif" width="77" height="36"></td>
    <td width="26"><img src="<%=request.getContextPath()%>/images/info_f10.gif" width="25" height="35"></td>
  </tr>
</table>

</body>
</html>
