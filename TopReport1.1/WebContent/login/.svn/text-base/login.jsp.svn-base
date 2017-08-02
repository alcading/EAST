<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/application-tags" prefix="app"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import ="com.huateng.ebank.business.common.UserSessionInfo"  %>
<%@page import="java.util.List"%>
<%@page import="com.huateng.ebank.business.common.service.BctlService"%>
<%@page import="resource.bean.pub.Bctl"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/login/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/b.js"></script>
<%
List bctlList = BctlService.getInstance().getAllEnableBctl();
%>
<title>TopReport 统一申报平台</title>
<script language="JavaScript" type="text/JavaScript">
function func_check()
{
	<% if (request.getAttribute("REQ_MSG") != null) {
		String errMsg = ((String) request.getAttribute("REQ_MSG")).replace("\n","[n]");
	%>
	var errMsg = "<%= errMsg %>";
	alert(errMsg.replace("[n]","\n"));
	<% } %>
	<%
	UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
	if(userInfo!=null)
	{
		out.println("document.loginForm.userName.value = \""+userInfo.getTlrNo()+"\";");
		out.println("document.loginForm.userName.readOnly=true;");
		out.println("focus(document.loginForm.passWord);");
	}
%>

	return;
}

function submitForm(){
	if(document.loginForm.brCode.value==""){
		document.getElementById("mistake").innerHTML="机构不能为空！";
		document.getElementById("brCodeName").focus();
		return false;
	}else if(document.loginForm.userName.value==""){
		document.getElementById("mistake").innerHTML="用户名不能为空！";
		return false;
	}else if(document.loginForm.passWord.value==""){
		document.getElementById("mistake").innerHTML="密码不能为空！";
		return false;
	}
	document.loginForm.passWord.value = new _B().encode(document.loginForm.passWord.value);
	document.loginForm.submit();
}
//modify by chenjinghui 2010-5-20 HTEBANK-11 begin
function resetForm(){
	document.loginForm.reset();
	document.loginForm.brCodeName.value ="--请选择机构--";
	document.loginForm.brCode.value ="";
	document.loginForm.userName.value ="";
	document.loginForm.passWord.value ="";
}
//modify by chenjinghui 2010-5-20 HTEBANK-11 end
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
<body onload="func_check()" style="background: #2a6fa6 url('<%=request.getContextPath() %>/login/images/bg.gif');height:100%; margin:0 auto; width:100%;">
<table cellpadding="0" cellspacing="0" border="0" height="100%" width="100%">
	<tr style="line-height: 26px;height: 26px">
		<td align="right" style="padding-right: 8px;color: #ffffee;font-family:Arial,Helvetica,sans-serif;font-size: 12px; ">只供授权用户登入</td>
	</tr>
	<tr valign="top" height="232px">
		<td align="center"><img src="<%=request.getContextPath() %>/login/images/login_top.gif" border="0"/></td>
	</tr>
	<tr height="60px"><td></td></tr>
	<tr height="100%">
	<td valign="top" align="center">
	<div id="mistake" style="text-align: left;width: 360px;color: red"></div>
	<html:form action="/custlogin.do" target="_top" focus="userName">
	<input type="hidden" name="brCode" id="brCode"/>
	<table cellpadding="0" cellspacing="0" border="0" width="595px" height="210xp" background="<%=request.getContextPath() %>/login/images/bg_panel_login.png">
		<tr>
			<td align="center" valign="top">
			<table cellpadding="0" cellspacing="0" border="0" width="246px" style="margin-top: 20px;">
			<tr height="35px">
				<td width="37px"><img src="<%=request.getContextPath() %>/login/images/icon_jigou.gif"  alt="" id="brcodeImg1" title="点击选择机构"/></td>
				<td width="100%">
				<input type="text" name="brCodeName" id="brCodeName"  value="--请选择机构--" class="inputcls" readonly="readonly" style="cursor: default;"/><p>
				<div id="brCodeSelect" style="position:absolute;width:auto;">
					<ol id="brCodeOl">
					<%
					for(int i=0;i<bctlList.size();i++){
						Bctl bctl = (Bctl)bctlList.get(i);
					%>
					<li><a href="javascript:setBrCode('<%=bctl.getBrcode()+"-"+bctl.getBrname() %>','<%=bctl.getBrcode() %>');" id="bctl_<%=bctl.getBrcode() %>"><%=bctl.getBrcode()+"-"+bctl.getBrname() %></a></li>
					<%} %>
					</ol>
				</div>
				</p>
				</td>
				<td width="9px;"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif"  alt=""  id="brcodeImg2"/></td>
			</tr>
			<tr  height="35px">
				<td width="37px"><img src="<%=request.getContextPath() %>/login/images/icon_user.gif"  alt=""/></td>
				<td width="100%"> <input type="text" name="userName"  id="userName" value="99999999"	onkeypress="nextEvent('password');" maxlength="10" class="inputcls"/></td>
				<td width="9px;"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif"  alt="" /></td>
			</tr>
			<tr  height="35px">
				<td width="37px"><img src="<%=request.getContextPath() %>/login/images/icon_lock.gif"  alt=""/></td>
				<td width="100%"><input type="password" name="passWord" id="passWord" 	onkeypress="nextEvent('submit');" class="inputcls"/></td>
				<td width="9px;"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif"  alt="" /></td>
			</tr>
			<tr height="40px">
				<td colspan="3" valign="middle" align="center">
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td align="center">
						<img src="<%=request.getContextPath() %>/login/images/btn_login.png" class="hand"  alt="" onclick="submitForm()"/></li>
						</td>
						<td align="center">
						<img src="<%=request.getContextPath() %>/login/images/btn_reset.png" class="hand"  alt="" onclick="resetForm()"/>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			</table>
			</td>
		</tr>
	</table>
	</html:form>
	</td>
	</tr>
	<tr height="30px"><td></td></tr>
</table>
<script type="text/javascript">
	function setBrCode(name,code){
		var sel = document.getElementById("brCode").value;
		document.getElementById("bctl_"+code).style.backgroundColor = "highlight";
		document.getElementById("bctl_"+code).style.color = "#ffffff";
		if(sel!=null && sel.length>0 && sel!=code){
			document.getElementById("bctl_"+sel).style.backgroundColor = "";
			document.getElementById("bctl_"+sel).style.color = "";
		}
		document.getElementById("brCodeName").value = name;
		document.getElementById("brCode").value = code;
		hideOptions();
		document.getElementById("userName").focus();
	}

	function showOptions () {
		var bcHt = document.getElementById("brCodeOl");
		bcHt.style.display='block';
		var ht = bcHt.offsetHeight;
		if(ht>160){
			bcHt.style.height="160px";
		}
	}
	function hideOptions () {
		document.getElementById("brCodeOl").style.display='none';
	}
	document.onclick = function(e){
		var evt = e?e:window.event;
		var ele = evt.srcElement || evt.target;
		if(ele.id == 'brCodeName' || ele.id == "brcodeImg1" || ele.id == "brcodeImg2"){
			showOptions();
		}else{
			hideOptions();		
		}
	}

	window.onload = function(){
		setBrCode
	}
</script>
</body>
</html:html>
