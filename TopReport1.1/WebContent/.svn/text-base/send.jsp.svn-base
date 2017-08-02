<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" buffer="none"%>
<%
  //设置缓存为空
  response.setHeader("Pragma","No-cache");
  response.setHeader("Cache-Control","no-cache");
  response.setDateHeader("Expires",   0);
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.huateng.ebank.business.common.GlobalInfo" %>
<%@ page import="com.huateng.ebank.business.common.TransferConstant" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<%

System.out.println("send.jsp...");
System.out.println("sendUrl is:"+request.getAttribute("_sendUrl"));
System.out.println("Url is :"+request.getAttribute("_URL"));

GlobalInfo info = (GlobalInfo)session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);

System.out.println(info.getTlrno()+"--"+info.getBrno()+"--"+info.getBrcode());
System.out.println(info.getBranchBrcode()+"--"+info.getBrClass()+"--"+info.getWorkflowRoleId()+"");
System.out.println(info.getFuncCode()+"--"+info.getLanguage()+""+info.getTxdate());

System.out.println("appno is:"+info.getAppno());
%>
<script>
 	function send(){
		document.forms[0].submit();
 	}
</script>
</head>
<body onload="send()">
<form action="<%=request.getAttribute("_sendUrl") %>" method="post">

<%-- 公共参数 --%>
	<input type="hidden" name="_URL" value="<%=request.getAttribute("_URL") %>">

<%-- GlobalInfo参数 --%>
	<input type="hidden" name="tokenId" value="<%=info.getTokenId() %>">
	<input type="hidden" name="sessionId" value="<%=info.getSessionId() %>">
	<input type="hidden" name="tlrno_portal" value="<%=info.getTlrno()%>">
	<input type="hidden" name="brno_portal" value="<%=info.getBrno()%>">
	<input type="hidden" name="brcode_portal" value="<%=info.getBrcode()%>">
	<input type="hidden" name="branchBrcode_portal" value="<%=info.getBranchBrcode()==null ? "" :info.getBranchBrcode()%>">
	<input type="hidden" name="brClass_portal" value="<%=info.getBrClass()==null ? "" :info.getBrClass()%>">
	<input type="hidden" name="workflowRoleId_portal" value="<%=info.getWorkflowRoleId()==null ? "" :info.getWorkflowRoleId()%>">
	<input type="hidden" name="funcCode" value="<%=info.getFuncCode()==null ? "" :info.getFuncCode()%>">
	<input type="hidden" name="language" value="<%=info.getLanguage()==null ? "" :info.getLanguage()%>">
	<input type="hidden" name="txdate" value="<%=info.getTxdate()==null ? "" :info.getTxdate()%>">
	<input type="hidden" name="Inflag" value="true">
<%-- 业务参数 --%>
	<input type="hidden" name="_<%=TransferConstant.SEND_VALUE_MAP %>" value="<%=request.getAttribute("_"+TransferConstant.SEND_VALUE_MAP)==null ? "" : request.getAttribute("_"+TransferConstant.SEND_VALUE_MAP)%>">
</form>
</body>
</html>
