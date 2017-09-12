<%@page import="com.huateng.report.constants.TopReportConstants"%>
<%@page import="resource.bean.report.BiExecConfirm"%>
<%@page import="com.huateng.report.common.service.ReportCommonService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templets/easyui/themes/blue/easyui.css">
<title>回执结果</title>
</head>
<body bgcolor="white" style="margin: 0px;">
<center>
<div style="padding: 3px;">
<table width="100%" class="grouptable" cellpadding="0" cellspacing="0" border="0">
	<thead>
		<tr>
			<td class="labeltd" valign=center  align="left">机构号</td>
			<td class="labeltd" valign=center  align="left">机构名称</td>
			<td class="labeltd" valign=center  align="left">完成状态</td>
		</tr>
	</thead>
	<%
		List<BiExecConfirm> biExecs = ReportCommonService.getInstance().getAllBrNoBiExecConfirm();
		String bgcolor = "#ffffff";
		for(int i = 0; i < biExecs.size(); i++){
			BiExecConfirm biExec = (BiExecConfirm)biExecs.get(i);
			if(i%2==0){
				bgcolor = "#ffffff";
			}else{
				bgcolor = "#f7f7fe";
			}
	%>
		<tr style="line-height: 22px;">
		<td class="datatd" valign=center align="left" nowrap width="25%" bgcolor="<%=bgcolor %>">
		 			<%=biExec.getId().getBrNo() %>
		</td>
		<td class="datatd" valign=center align="left" nowrap width="25%" bgcolor="<%=bgcolor %>">
		 			<%=biExec.getBrNoName() %>
		</td>
		<td class="datatd" valign=center align="left" nowrap width="25%" bgcolor="<%=bgcolor %>">
					<%if(biExec.getFinishStatus().equals("02")){ %>未完成
					<%} else { %>完成<%} %>
		</td>
		</tr>
		<%}%>
</table></center>
</div>
</body>

<script type="text/javascript">

</script>
</html>