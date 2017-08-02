<%@page import="resource.bean.report.NoticeParam"%>
<%@page import="com.huateng.report.common.service.ReportCommonService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templets/easyui/themes/blue/easyui.css">
<title>业绩考核指标</title>
<%
List noticeBeans = ReportCommonService.getInstance().getNoticeParam();
%>
</head>
<body bgcolor="white" style="margin: 0px;">
<center>
<div style="padding: 3px;">
<table width="100%" class="grouptable" cellpadding="0" cellspacing="0" border="0">
	<thead>
		<tr>
			<td class="labeltd" valign=center align="left">考核内容名</td>
			<td class="labeltd" valign=center align="left">考核所占比值</td>
			<td class="labeltd" valign=center align="left">金额指标</td>
			<td class="labeltd" valign=center align="left">数量指标</td>
			<td class="labeltd" valign=center align="left">创建日期</td>
			<td class="labeltd" valign=center align="left">更新日期</td>
			<td class="labeltd" valign=center align="left">有效标志</td>
		</tr>
	</thead>
	<%
		if(noticeBeans!=null && noticeBeans.size()>0){
		String bgcolor = "#ffffff";
		for(int i = 0; i < noticeBeans.size(); i++){
			NoticeParam bean = (NoticeParam)noticeBeans.get(i);
			if(i%2==0){
				bgcolor = "#ffffff";
			}else{
				bgcolor = "#f7f7fe";
			}
	%>
		<tr  style="line-height: 22px;">
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getNoticeName() %>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getNoticeValue() %>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getNoticeAmt() %>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getNoticeTotperi() %>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getCreatedt() %>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getUpdt()%>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getNoticeFlg()%>
		</td>
		
		</tr>
	<%}}else{ %>
		<tr bgcolor="#ffffff"><td colspan="3" align="center" class="datatd">没有业绩考核信息</td></tr>
	<%} %>
</table>
</center></div>
</body>

<script type="text/javascript">

</script>
</html>