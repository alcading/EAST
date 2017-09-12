<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>机构树</title>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jpages/businessquery/js/tree.js"></script>
  <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'> </script>
  <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'> </script>
  <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/PrivAction.js'> </script>
 <link href="<%=request.getContextPath()%>/css/public.css" rel="stylesheet" type="text/css">
<script language="javascript">

	//全选
	function funSelectAll(){
		var len = document.getElementsByName("id").length;
		for(i=0;i<len;i++){
			if (document.getElementsByName("id")[i].disabled == false){
				document.getElementsByName("id")[i].checked = true;
			}
		}
	}
	//全不选
	function funSelectNo(){
		var len = document.getElementsByName("id").length;
		for(i=0;i<len;i++){
			if (document.getElementsByName("id")[i].disabled == false){
				document.getElementsByName("id")[i].checked = false;
			}
		}
	}
	//得到所选的权限
	function getCheckDatas(){
		var len = document.getElementsByName("id").length;
		var s = "";
		var flag=0;
		for(i=0;i<len;i++){
			if(document.getElementsByName("id")[i].checked == true){
				if(flag > 0) s += ",";
				var val = document.getElementsByName("id")[i].value.split(",");
				s += val[val.length-1];
				flag++;
			}
		}
		return s;
	}

	//展开节点树
	function viewtree(){
		if(document.getElementById("expand").value=="展开节点树")
		{
			document.getElementById("expand").value="关闭节点树";
			closeAll(1);
		}
		else
		{
			document.getElementById("expand").value="展开节点树";
			closeAll(0);
		}

	}
	function save(){
		var s = getCheckDatas();
		window.returnValue=s;
		window.close();
	}
	function checkResult(data)
	{
		if(data == 0)
		{
			alert("保存成功！");
		}
		else
		{
			alert("保存失败！");
		}
	}

	function windowClose(){
	   window.returnValue='';
	   window.close();
	}

</script>
</head>
<body >
  <div class="divloca">
	主页 > 机构树
			<hr />
</div>
<table>
	<tr >
		 <td  align="left">
		 <input class="buttonBoxSmall" type="button" name="bt_spread" id="expand" value="展开节点树" onclick="viewtree()" />
			<input class="buttonBoxSmall" type="button" name="bt_allselect" value="&nbsp;全选&nbsp;" onclick="funSelectAll()" />
	  		<input class="buttonBoxSmall" type="button" name="bt_notselect" value="&nbsp;全不选&nbsp;" onclick="funSelectNo()" />
	  		<input class="buttonBoxSmall" type="button" name="bt_reset" value="&nbsp;保存&nbsp;" onclick="save()"/>
	  		<input class="buttonBoxSmall" type="button" name="bt_reset" value="&nbsp;关闭&nbsp;" onclick="windowClose();"/>
	  	</td>
	</tr>
	<tr >
		<td  align="left" >
		 <div id="tree">
			<script language="javascript">
				var branchtree = null;
				dwr.engine.setAsync(false);
				PrivAction.getBranchTree(function(data){branchtree = data});
				dwr.engine.setAsync(true);
				createTree(branchtree,-1,0);
           </script>
           </div>
		</td>
	</tr>

</table>
</body>
</html>