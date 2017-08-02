<%@page import="com.huateng.ebank.framework.util.DateUtil"%>
<%@page import="resource.bean.report.BiQuartzJobLog"%>
<%@page import="com.huateng.report.common.service.ReportCommonService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templets/easyui/themes/blue/easyui.css">
<title>定时任务执行信息</title>
</head>
<body bgcolor="white" style="margin: 0px;">
<center>
<div style="padding: 3px;">
<table width="100%" class="grouptable" cellpadding="0" cellspacing="0" border="0">
	<thead>
		<tr>
			<td class="labeltd" valign=center nowrap="nowrap">定时任务名称</td>
			<td class="labeltd" valign=center nowrap="nowrap">定时任务执行时间</td>
			<td class="labeltd" valign=center nowrap="nowrap">结束时间</td>
			<td class="labeltd" valign=center nowrap="nowrap">定时任务执行结果</td>
			<td class="labeltd" valign=center nowrap="nowrap">备注</td>
		</tr>
	</thead>
	<%
		List quartzJobLogBeans = ReportCommonService.getInstance().getQuartzJobLog();
		String bgcolor = "#ffffff";
		for(int i = 0; i < quartzJobLogBeans.size(); i++){
			BiQuartzJobLog bean = (BiQuartzJobLog)quartzJobLogBeans.get(i);
			if(i%2==0){
				bgcolor = "#ffffff";
			}else{
				bgcolor = "#f7f7fe";
			}
	%>
		<tr style="line-height: 22px;">
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getQuartzName() %>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=DateUtil.Time14ToString2(bean.getExecTm())%>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%=bean.getEndTm()==null?"":DateUtil.Time14ToString2(bean.getEndTm())%>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<%if (bean.getQuartzResult().equals("01")){%>成功
		 			<%} else {%>失败<%} %>
		</td>
		<td class="datatd" valign=center align="left" nowrap bgcolor="<%=bgcolor %>">
		 			<% if (bean.getRemark()==null){%>&nbsp;
		 			<% }else { %><%=bean.getRemark() %><%} %>
		</td>
	<%} %>
</table></center>
</div>
</body>
</html>