<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.huateng.report.genupreportfile.utils.ReportSubUtils"%>
<%@page import="com.huateng.ebank.framework.report.common.ReportConstant"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成上报文件</title>
<script language="javascript" src="<%=request.getContextPath() %>/templets/lib/salert.js"></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/util.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/engine.js'> </script>
<script language="javascript" src="<%=request.getContextPath() %>/templets/lib/dwr.js"></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/interface/ReportFile.js'> </script>
<style type="text/css">
	.tablecontent {
		font-size: 12px;
		line-height:24px;
		background-color:#95b3d7;
		color: #000;
		font-family: Arial,Verdana,Vrinda,Tahoma;
	}

	.theadtr{
		color: #000;
	}

	.theadtr td {
		background-color: #b8cce4;
		text-align: center;
	}
	.theadtd {
		background-color: #b8cce4;
		text-align: center;
	}
	.tbodytr{
		color: #000;
	}

	.tdcol {
		background-color: #e6eff9;
		text-align: center;
	}

	.tdcol2 {
		background-color: #ffffff;
		text-align: center;
	}

	button {
		border: #002D96 1px solid;
		cursor: pointer;
		color: #000;
		font-size: 12px;
		font-family: Arial,Verdana,Vrinda,Tahoma;
		height: 23px;
	}
</style>
</head>
<body>
<table width="90%">
	<tr>
		<td align="left" style="font-size: 12px;" colspan="2">
		上报文件生成  &gt; 生成信息
		</td>
	</tr>
	<tr>
		<td width="100%" colspan="2">
			<hr style="height:1px;border:none;border-top:1px solid #000;"/>
		</td >
	</tr>
	<tr>
		<td valign="top" width="60%">
			<table cellpadding="0" cellspacing="1" width="100%" border="0" class="tablecontent" id="resultTable">
				<tr class="theadtr">
					<td nowrap="nowrap">文件类型</td>
					<td nowrap="nowrap">包名称</td>
					<td nowrap="nowrap">文件名称</td>
					<td nowrap="nowrap"> 备 注 </td>
				</tr>
				<tr class="tdcol2">
					<td colspan="4">暂无信息</td>
				</tr>
			</table>
			<br/>
			<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td>
				<button type="button" id="btAgain" style="background-image: url(<%=request.getContextPath() %>/login/leftnavg/images/button.gif);" onmouseover="buttonMouseOver(this)" onmouseout="buttonMouseOut(this);" onclick="toFile()"> 重新生成 </button>
				&nbsp;&nbsp;
				<button type="button" id="btBack" style="background-image: url(<%=request.getContextPath() %>/login/leftnavg/images/button.gif);" onmouseover="buttonMouseOver(this)" onmouseout="buttonMouseOut(this);" onclick="toback()"> 返回 </button>
				</td>
			<tr>
			</table>
		</td>
		<td valign="top" style="height: 24px;line-height: 24px;font-size: 12px;font-family: Arial,Helvetica,sans-serif;padding-left: 8px;" id="execMsg" width="40%">
		</td>
	</tr>
</table>
</body>
<script type="text/javascript">
	<%
		String busiType = request.getParameter("busiType");
		String appType = request.getParameter("appType");
	%>
	var emsg = document.getElementById("execMsg");
	window.onload = function(){
		ReportFile.getSubFileInfoCount("<%=busiType%>", "<%=appType%>", function(data){
			if(data>0){
				dwr.engine.setActiveReverseAjax(true);//激活翻转
				execSubFile();
			}else{
				alert("没有需要生成的数据!");
				toback();
			}
		});
	}
	function execSubFile(){
		document.getElementById("btAgain").disabled = true;
		document.getElementById("btBack").disabled = true;
		<%if("0".equals(ReportSubUtils.IS_CREATE_FILE_BOP)){%>
		ReportFile.createSubFile("<%=busiType%>", "<%=appType%>",createCallBack);//开始生成文件并上传
		<%}%>
	}

	function buttonMouseOver(obj){
		obj.style.backgroundImage="";
		obj.style.backgroundColor = "#ededed";
	}

	function buttonMouseOut(obj){
		obj.style.backgroundImage = "url(<%=request.getContextPath() %>/login/leftnavg/images/button.gif)";
	}

	function showFileMsg(msg){
		emsg.innerHTML +=msg+"<br/>";
	}

	function showSubFileResult(data,type){
		//清空表格
		clearTable();
		if(data){
			var resultList = data;
			if(resultList.length>0){
				var packList = new Array();
				for(var i=0;i<resultList.length;i++){
					var obj = resultList[i];

					var otr = document.getElementById("resultTable").insertRow(-1);
					if(document.getElementById("resultTable").rows.length % 2 >0){
						otr.className = "tdcol";
					}else{
						otr.className = "tdcol2";
					}
					var td1 = document.createElement("td");
					td1.style.cssText = "text-align:left;padding-left:3px;";
					td1.innerHTML = obj.appTypeName;

					var td2 = document.createElement("td");
					td2.style.cssText = "text-align:center";
					td2.innerHTML = obj.packName;
					packList.push(obj.packName);

					var fileList = obj.fileNameList;
					var crtMsg = "";
					for(var j=0;j<fileList.length;j++){
						crtMsg+=fileList[j]+"<br/>";
					}

					var td3 = document.createElement("td");
					td3.style.cssText = "text-align:left;padding-left:3px;";
					td3.innerHTML = crtMsg;

					var td4 = document.createElement("td");
					td4.style.cssText = "text-align:left;padding-left:3px;";
					td4.innerHTML = "<div id='div_"+obj.packName+"'>&nbsp;</div>";

					otr.appendChild(td1);
					otr.appendChild(td2);
					otr.appendChild(td3);
					otr.appendChild(td4);
				}
				<%if(ReportConstant.SUB_FILE_CREATE_AUTO_SEND){%>
				if(packList.length>0){
					//上传文件
					document.getElementById("btBack").disabled = true;
					ReportFile.sendSubFileList(packList,"<%=appType%>",updateSendStatus);
				}
				<%}%>
			}else{
				var otr = document.getElementById("resultTable").insertRow(-1);
				var td = document.createElement("td");
				td.className = "tdcol2";
				td.colSpan = 4;
				td.innerHTML = "暂无信息";
				otr.appendChild(td);
			}
		}
	}

	function updateSendStatus(data){
		var str = "上传文件出错，请进入‘生成文件报送’功能进行后续处理！";
		document.getElementById("btBack").disabled = false;
		if(data){
			if(data.length>0){
				for(var i=0;i<data.length;i++){
					var obj = data[i];
					var pname = obj.packName;
					var div = document.getElementById("div_"+pname);
					if(div!=null){
						var isSendSuccess = obj.sendSuccess;
						if(isSendSuccess){
							div.innerHTML = "<font color='green'>上报成功</font>";
						}else{
							div.innerHTML = "<font color='red'>上报失败</font>";
						}
					}
				}
			}else{
				alert(str);
			}
		}else{
			alert(str);
		}
	}

	function createCallBack(data){
		if(data!=null && data.length>0){
			document.getElementById("btAgain").disabled = true;
			ReportFile.showCreateFile(data,showSubFileResult);
		}else{
			document.getElementById("btAgain").disabled = false;
		}
		document.getElementById("btBack").disabled = false;
	}

	function clearTable(){
		var tab = document.getElementById("resultTable");
		if(tab!=null&& tab != undefined && tab != "undefined"){
			var rlen = tab.rows.length;
			for(var i=rlen-1;i>=1;i--){
				tab.deleteRow(i);
			}
		}
	}

	function toback(){
		window.setTimeout("window.location.href = '<%=request.getContextPath()%>/fpages/workconfirmed/ftl/GenReportFile.ftl'",0);
	}

	function toFile(){
		clearTable();
		execSubFile();
	}

</script>
</html>