<%@page import="java.util.List"%>
<%@page import="com.huateng.report.common.bean.ReportBackErrBean"%>
<%@page import="com.huateng.report.utils.ReportUtils"%>
<%@page import="com.huateng.ebank.framework.util.DataFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templets/easyui/themes/blue/easyui.css">
<title>回执结果</title>
</head>
<body bgcolor="white">
<%
	String recId = (String)request.getParameter("id");
	String appType = (String)request.getParameter("appType");
	String currentfile = (String)request.getParameter("currentfile");
	ReportBackErrBean reprotBackErrBean = ReportUtils.getReportBankMsg(recId, appType, currentfile);
%>
<FIELDSET name='group1' style="padding: 6px;width: 90%">
<LEGEND>回执结果</LEGEND>
<table width="99%" class="grouptable">
<%
	if (reprotBackErrBean == null) {

%>
	<tr>
		<td class="labeltd" valign=center align="right" style="width: 20%" nowrap>回执结果</td>
		<td class="datatd" colspan="1"  valign=center align="left" style="width: 20%" nowrap>没有查到回执结果</td>
	</tr>
</table>
<%} else {%>
	 <tr>
		<td class="labeltd" valign=center align="center" style="width: 20%" nowrap>
	 		错误类型
	 	</td>
	 </tr>
	 <tr>
 	<%if(reprotBackErrBean.getErrType().equals("01")){ %>
	 	<td class="datatd" colspan="1"  valign=center align="center" style="width: 20%" nowrap>
	 		格式错误
	 	</td>
 	<% } else { %>
	 	<td class="datatd" colspan="1"  valign=center align="center" style="width: 20%" nowrap>
	 		记录错误
	 	</td>
 	<%} %>
	</tr>
</table>
</FIELDSET>

<FIELDSET name='group2' style="padding: 6px;width: 90%">
<LEGEND>错误详细信息</LEGEND>
	<%if(reprotBackErrBean.getErrType().equals("01")){ //格式错误%>
	<table width="99%" class="grouptable">
		<thead>
			<tr>
				<td class="labeltd" valign=center>序号</td>
				<td class="labeltd" valign=center>错误信息</td>
			</tr>
		</thead>
		<%
			List errMsgList = reprotBackErrBean.getErrMsg();
			for(int i = 0; i < errMsgList.size(); i++){
		%>
			<tr>
			<td class="datatd" valign=center align="left" style="width: 20%" nowrap>
				 <%=i+1 %>
			</td>
			<td class="datatd" valign=center align="left" style="width: 20%" nowrap>
			 	<%=errMsgList.get(i) %>
			</td>
			</tr>
		<%} %>
	</table>
	<%} else { %>
	<table width="99%" class="grouptable">
		<thead>
			<tr>
				<td class="labeltd" valign=center>字段英文名称</td>
				<td class="labeltd" valign=center>字段中文名称</td>
				<td class="labeltd" valign=center>错误信息</td>
			</tr>
		</thead>
		<%
			Map errFiledMap = reprotBackErrBean.getErrFiledMap();
			Map errFiledContentMap = reprotBackErrBean.getErrFiledContentMap();
			Iterator it = errFiledMap.keySet().iterator();
			while(it.hasNext()){
				String fieldEnName = (String)it.next();
		%>
			<tr>
			<td class="datatd" valign=center align="left" style="width: 20%" nowrap>
				 <%=fieldEnName %>
			</td>
			<td class="datatd" colspan="1"  valign=center align="left" style="width: 20%" nowrap>
			 	<%=errFiledMap.get(fieldEnName) %>
			</td>
			<td class="datatd" colspan="1"  valign=center align="left" style="width: 20%" nowrap>
			 	<%=errFiledContentMap.get(fieldEnName) %>
			</td>
			</tr>
		<%} %>
	</table>
	<%}%>
</FIELDSET>
<%} %>
</body>

<script type="text/javascript">

</script>
</html>