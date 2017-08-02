<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="<%=request.getContextPath()%>/js/menu.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/scrollbutton.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/poslib.js"></script>
<link href="<%=request.getContextPath()%>/css/menu.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/public.css" rel="stylesheet" type="text/css">
<style type="text/css">
.menumsg {
	PADDING-TOP: 0px;
	MARGIN-TOP: 0px;
	PADDING-LEFT: 0px;
	MARGIN-LEFT: 0px;
	font-family: 宋体;
	font-size: 14px;
	margin: 0px;
}
</style>
</head>
<body style="margin: 0; overflow: hidden ;background-color: #cae1f3;" >
<div >
<img src="<%=request.getContextPath()%>/images/tile.jpg" align="middle" width="984" height="83" />
</div>
<script language="javascript" >

Menu.prototype.mouseHoverDisabled = false;
Menu.prototype.cssFile = "<%=request.getContextPath()%>/css/menu.css";
var menuMain = new MenuBar();
<%
StringBuffer m = (StringBuffer)request.getSession().getAttribute("menu");
%>
Menu_buildMenu(new   Array(<%=m.toString()%>),menuMain);
menuMain.add( tmp = new MenuButtonUrl( "退出",function Exit(){sExit()} ));

menuMain.write();
/**
function addscj()
{

menusubSCJ.add(tmpItem =new MenuItem('1','testTag' ) );
menusubSCJ.redrawMenu();
}
*/
function sExit()
{
	window.open("<%=request.getContextPath()%>/custlogout.do", "_top");
}

</script>

<div align="right" class="welcome" >
    <marquee onmouseover="this.stop()" onmouseout="this.start()" scrollamount="1" direction="left" height="20" ;>
        <div align="right">
             欢迎：<%=request.getSession().getAttribute("custName")+" [ "+request.getSession().getAttribute("custNo")+" ]"%> &nbsp;&nbsp;&nbsp;    客户类型：<%=request.getSession().getAttribute("custDesc") %>
        </div>
    </marquee>
</div>

</body>
</html>