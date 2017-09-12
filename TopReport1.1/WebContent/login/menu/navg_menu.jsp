<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.huateng.report.utils.NavigationShowUtil"%>
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="resource.bean.pub.FunctionInfo"%>
<%
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
GlobalInfo.setCurrentInstance(globalInfo);
String reqtype = globalInfo.getMenuCode();
List navgList = NavigationShowUtil.getUserNavgFuncList(globalInfo.getTlrno());
%>
<style type="text/css">
<!--
	.navgdiv{
		position: relative;
		z-index: 999999;
		border: 1px solid #93bde7;
		background-color: #fff;
		width: 100px;
	}
	.menudiv{
		margin-top:10px;
		margin-bottom:3px;
		text-align: center;
		width: 70px;
		height:70px;
		cursor:pointer;
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
		border: 1px solid #fff;
	}
	.menudiv img{
		margin:2px;
		width:40px;
		height:40px;
		border:0px;
	}
	.menudiv div{
		margin:2px;
		font-size:12px;
		font-family: Arial,Helvetica,sans-serif;
	}

-->
</style>
<div id="navgChangeDiv" class="navgdiv" style="display:none;">
<table width="100%" cellpadding="0" cellspacing="3">
<%
for(int a=0;a<navgList.size();a++){
	FunctionInfo info = (FunctionInfo)navgList.get(a);
%>
<tr>
	<td align="center">
	<%if(info.getId().equals(reqtype)){ %>
		<div class="menudiv" title="<%="当前："+info.getFuncname() %>" style="border-left:1px solid #f7f7fe;border-top:1px solid #f7f7fe;border-bottom:1px solid #999;border-right:1px solid #999;background-color: #e1f0fa">
		<img src="<%=request.getContextPath()+"/"+info.getIconCls() %>"/>
		<div><%=info.getFuncname() %></div>
	</div>
	<%}else{ %>
	<div addtr="navg" class="menudiv" title="<%=info.getFuncname() %>" onmouseover="menudivover(this);" onmouseout="menudivout(this);" onclick="changeNavg('<%=request.getContextPath()+info.getPagepath() %>','<%=info.getId() %>')">
		<img src="<%=request.getContextPath()+"/"+info.getIconCls() %>"  addtr="navg"/>
		<div  addtr="navg"><%=info.getFuncname() %></div>
	</div>
	<%} %>
	</td>
</tr>
<%} %>
</table>
</div>

<script>
	function changeNavg(url,type){
		window.open(url+"?type="+type, "_top");
	}

	function menudivover(obj){
		obj.style.border = "1px solid #aed0ea";
		obj.style.backgroundColor = "#f7f7fe";
	}

	function menudivout(obj){
		obj.style.border = "1px solid #fff";
		obj.style.backgroundColor = "#fff";
	}

	function changNavg(){
		var ndiv = document.getElementById("navgChangeDiv");
		if(ndiv.style.display==""){
			ndiv.style.display="none";
			return;
		}
		var tp = event.clientY;
		var lf = event.clientX;
		var cw =document.body.clientWidth;//可用区域宽度
		var ch = document.body.clientHeight;//可见区域高度
		var zw = lf+105;
		var zh = tp;
		if(zw>cw){
			lf +=(cw-zw-3);
		}
		if(zh>ch){
			tp +=(ch-zh-3);
		}
		ndiv.style.top = tp+10;
	    ndiv.style.left = lf;

	    ndiv.style.display="";
	}


$(document).mousedown(function(e){
	if($(e.target).attr("addtr")=="navg") {

	} else{
		$('#navgChangeDiv').hide();
	}
});
</script>