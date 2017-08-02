<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>

<frameset rows="113,*,26" framespacing="1" border="1" frameborder="1" >
  <frame name="menu"  src="<%=request.getContextPath()%>/page/frame/menu.jsp" frameborder="0" scrolling="no"   noresize>
  <frameset id="splitcol" cols="13%,87%" framespacing="1" border="1" frameborder="1" >
  	<frame name="leftwin" id="leftwin" src="<%=request.getContextPath()%>/page/frame/tree.jsp" frameborder="0" scrolling="aoto"   >
  	<frame name="rightwin" id="rightwin" src="<%=request.getContextPath()%>/page/frame/rightwin.jsp" frameborder="0" scrolling="no"   >
  </frameset>
  <frame name="bottomFrame" src="<%=request.getContextPath()%>/page/frame/footBar.jsp"  frameborder="0" scrolling="no" noresize>
</frameset>

</html>