<%@ page contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ page import ="com.huateng.ebank.business.common.UserSessionInfo"  %>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/BillSysTag/xystyle.css">
<script language="javascript">


function openLink(urlLink)
{
	window.open(urlLink, "_self");
}
function submitForm()
{
	document.forms[document.myform.formindex.value].submit();
}


</script>
<style type="text/css">
<!--
.style4 {
	color: #024BB7
}
-->
</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="695" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="top" background="<%=request.getContextPath()%>/images/bg_line_02.gif"><img
			src="<%=request.getContextPath()%>/images/spacer.gif" width="1" height="2"></td>
	</tr>
</table>
<form action="/welcome.do" >
<table width="696" border="0" cellpadding="0" cellspacing="0">
	<TR>
		<TD width="10"></TD>
		<td valign="top"><img src="<%=request.getContextPath()%>/images/spacer.gif" width="1"
						height="20"></td>
		<TD width="10"></TD>
	</TR>
	<tr>
		<td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="10" height="20"></td>
		<td>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="1" cellpadding="2" cellspacing="0"
									class="table-class">
									<logic:iterate id="mywork" name="cntList">
									<tr align="right">
										<td width="100%" colspan="8" height="23" align="center"
											valign="top" nowrap bgcolor="#FFFFFF" class="tdTitle"><strong>风险预警监控列表</strong></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>1</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/menu/PLoanSysWeb/fpages/demo/ftl/LoanDueList.ftl?_cds_=0")
											>将到期贷款<U><bean:write name="mywork" property="cnt1"/></U>笔</a></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>2</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/menu/PLoanSysWeb/fpages/demo/ftl/PostLoanTraceList.ftl?_cds_=0")
											>当日应催收的逾期贷款<U><bean:write name="mywork" property="cnt2"/></U>笔</a></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>3</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/menu/PLoanSysWeb/fpages/demo/ftl/PostLoanUnTraceList.ftl?_cds_=0")
											>超时未催收的贷款<U><bean:write name="mywork" property="cnt3"/></U>笔</a></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>4</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/menu/PLoanSysWeb/fpages/demo/ftl/PostLoanMonitorList.ftl?_cds_=0")
											>需定期检查的贷款<U><bean:write name="mywork" property="cnt4"/></U>笔</a></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>5</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/menu/PLoanSysWeb/fpages/demo/ftl/PostLoanUnMonitorList.ftl?_cds_=0")
											>超时未完成定期检查的贷款<U><bean:write name="mywork" property="cnt5"/></U>笔</a></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>6</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/menu/PLoanSysWeb/fpages/demo/ftl/LoanGrantToday.ftl?_cds_=0")
											>当日已放款的贷款<U><bean:write name="mywork" property="cnt6"/></U>笔</a></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>7</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/fpages/customer/ftl/QueryIndvCustomerBlackListInfoList.ftl?_cds_=0")
											>黑名单检查客户<U><bean:write name="mywork" property="cnt7"/></U>名</a></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>8</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/menu/PLoanSysWeb/fpages/custblack/ftl/queryCustBlackList.ftl?_cds_=0")
											>风险关注客户<U><bean:write name="mywork" property="cnt8"/></U>名</a></td>
									</tr>
									<tr align="right" valign="middle" bordercolor="#CCCCCC"
										bgcolor="#FFFFFF" class="tdValue">
										<td width="5%" align="center" valign="top" nowrap><font color="#666666"><b>9</b></font></td>
										<td width="95%" colspan="7" align="left" valign="middle"
											nowrap> <a
											href='#' onClick = openLink("<%=request.getContextPath()%>/fpages/loancenter/ftl/matureLoanQuery.ftl?_cds_=0")
											>贷款到期/欠款提醒</a></td>
									</tr>
								</logic:iterate>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
		<td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="10" height="1"></td>
	</tr>
</table>
</form>
<form name="myform"><input type="hidden" name="formindex" value="-1">

<table width="697" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="697" valign="top" background="<%=request.getContextPath()%>/images/bg_line_02.gif"><img
			src="<%=request.getContextPath()%>/images/spacer.gif" width="1" height="2"></td>
	</tr>
</table>
</form>
</body>
</html>
