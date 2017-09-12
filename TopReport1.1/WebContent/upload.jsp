<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excel导入</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templets/lib/themes/ocean/extra.css">
<style>
</style>
<body>
    <%
       String path = File.separator + "rpt_templates" + File.separator + "DATA_IMPORT_EXCEL_TEMPLATE_20100926.xls";
       String root = request.getRealPath("/");
       String realPath = root + path;
    %>
	<br/>
	<br/>
	<form method="POST" enctype="multipart/form-data" id="postForm" onsubmit="return importData();"
		action="excelDataImport.do" target="_self">
		<P>上传Excel文件：<input type="file" name="filename" class="button"></input>
		<input type="submit" class="button" value="导入"/>
	</form>
	<br>
	<table height='50px'>
	</table>
	<br>
	<table align="center">
	   <tr align="center">
	     <td align="center">
	          <form name="downloadForm" id="downloadForm" action="<%=request.getContextPath()%>/filedownload/FileDownloadAction.do?downloadinfo=<%=realPath%>" method="post">
                 <input type="submit" value="下载EXCEL模板">
             </form>
         </td>
       </tr>
	</table>
</body>
<script type="text/javascript" src="js/jquery-1.2.6.js"></script>
<script type="text/javascript"><!--
Request = {
	QueryString : function(item){
		var svalue = location.search.match(new RegExp("[\?\&]" + item + "=([^\&]*)(\&?)","i"));
		return svalue ? svalue[1] : svalue;
	}
}
var postForm = document.getElementById("postForm");
var custcd = Request.QueryString("custcd");
var areacd = Request.QueryString("areacd");
var rptNo = Request.QueryString("rptNo");
var rptPeriod = Request.QueryString("rptPeriod");
var rptType = Request.QueryString("rptType");
postForm.action+="?custcd=" + custcd + " &areacd=" + areacd + "&rptNo=" + rptNo + "&rptPeriod=" + rptPeriod + "&rptType=" + rptType;

  function importData() {

       $.ajax({url: postForm.action,

       type: "GET",

       dataType: "html",

       timeout: 20000,

       error: function(){alert("导入失败!"); },

       success: function(){

            setTimeout("closeAndRefresh()",5000);
       }
      });
  }
  function closeAndRefresh() {
        alert("Excel数据导入成功!");
        window.close();
  }
</script>
</html>