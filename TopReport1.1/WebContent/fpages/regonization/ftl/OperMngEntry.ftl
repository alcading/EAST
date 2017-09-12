<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="操作员管理">
<@CommonQueryMacro.CommonQuery id="operMngEntry" init="false" submitMode="current">
<table width="90%">
	<tr valign="center">
		<td valign="top" colspan="2">
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=6 />
		</td>
	</tr>
  	<tr>
  		<td valign="top">
			<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
		</td>
	
	 </tr>
	 <tr>
		 <td colspan="2">
			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="-,btAdd,-,btStatus,-,btLoginStatus,-,unLock" fieldStr="tlrno[60],tlrName[100],flag[55],status[55],isLock[55],brname,lastaccesstm[150],lastlogouttm[150],st[70],opr[85]"  readonly="true" width="100%" hasFrame="true" height="280" />
		 </td>
	 </tr>
	 <tr align="center">
		<td>
			<div style="display:none">
				<@CommonQueryMacro.Button id= "btDel" />
				<@CommonQueryMacro.Button id= "btModify"/>
				<@CommonQueryMacro.Button id= "btAuth"/>
				<@CommonQueryMacro.Button id= "btResetPwd"/>
			 </div>
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var currentTlrno = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}";
	//定位一条记录
	function locate(id) {
		var record = operMngEntry_dataset.find(["tlrno"],[id]);
		if (record) {
			operMngEntry_dataset.setRecord(record);
		}
	}

	function datatable1_opr_onRefresh(cell, value, record)
	{
		if(record&&record!=null){

			var id = record.getValue("tlrno");
			var branchId = record.getValue("tlrno");
			var st = record.getValue("st");
			var innerStr = "<PRE>";
			if (st == "1" || st == "2" || st == "3") {
				innerStr = innerStr + "<a style=\"color:#666666\" title=\"记录已锁定，不能操作\">修改</a> " +
		    		" <a style=\"color:#666666\" title=\"记录已锁定，不能操作\">密码重置</a>" +"</PRE>";
		    } else {
		    	innerStr = innerStr + " <a href=\"JavaScript:btModifyShow('"+id+"')\">修改</a>"  +
			    " <a href=\"JavaScript:resetPwd('"+id+"')\">密码重置</a>" +"</PRE>";
		    }
		    cell.innerHTML = innerStr;
		}else{
			cell.innerHTML = "";
		}
	}

	function btStatus_onClickCheck(button) {
		var status = operMngEntry_dataset.getValue("flag");
		if(status == '0'){
			if(confirm("确认将该操作员设置为有效?")){
			    operMngEntry_dataset.setParameter("statu", "1");
				return true;
			}else{
				return false;
			}
		} else {
			if(confirm("确认将该操作员设置为无效?")){
				operMngEntry_dataset.setParameter("statu", "0");
				return true;
			}else{
				return false;
			}
		}
	}
	function btStatus_postSubmit(button) {
		alert("设置成功");
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}

	function btLoginStatus_onClickCheck(button){
		if(confirm("确认将该操作员强行签退?")){
			operMngEntry_dataset.setParameter("statu","logout");
			return true;
		}else{
			return false;
		}
	}
	function btLoginStatus_postSubmit(button){
		alert("签退成功");
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}

	function operMngEntry_dataset_dataset_afterScroll(dataset){
		unLock.disable(dataset.getValue("isLock") != '1' || dataset.getValue("tlrno") == currentTlrno);
	}

	//新增
	function btAdd_onClick(){
		window.location.href = "${contextPath}/fpages/regonization/ftl/OperMngRoleInfo.ftl?op=new";
	}

	//刷新数据
	function flushPage(){
		bopAccDsRecordAD_dataset.flushData();
	}

	function winZone_onCloseCheck(){
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
		return true;
	}

	function btModifyShow(tlrno){
	  	window.location.href = "${contextPath}/fpages/regonization/ftl/OperMngRoleInfo.ftl?op=modify&tlrno=" + tlrno;
	}

	function btAuthShow(tlrno){
		var paramMap = new Map();
		var op = "auth";
	  	paramMap.put("tlrno",tlrno);
	  	paramMap.put("op",op);
	  	loadPageWindows("userWin", "角色设定", "/fpages/regonization/ftl/OperMngRoleInfo.ftl", paramMap, "winZone");
	}

	function resetPwd(tlrno) {
		if (tlrno == currentTlrno) {
			alert("不能重置自己的密码");
		} else {
			if(!confirm("确认要重置该操作员吗?")){
				return;
			}
			locate(tlrno);
			btResetPwd.click();
		}
	}

	function btResetPwd_postSubmit(button){
		var retParam = button.returnParam;

		alert("密码重置成功,初始化为"+retParam.DefaultPWD);
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}

	function unLock_onClickCheck(button) {
		operMngEntry_dataset.setParameter("tlrno",operMngEntry_dataset.getValue("tlrno"));
	}
	function unLock_postSubmit(button) {
		alert("解锁成功！");
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}


	function operMngEntry_dataset_afterScroll(dataset){
		unLock.disable(dataset.getValue("isLock") != '1');
		btLoginStatus.disable(dataset.getValue("status") != '1');
		btStatus.disable(false);
		if(dataset.getValue("tlrno") == currentTlrno){
			btStatus.disable(true);
			unLock.disable(true);
			btLoginStatus.disable(true);
		}
		var st = dataset.getValue("st");
		if (st == "1" || st == "2" || st == "3") {
			btStatus.disable(true);
			unLock.disable(true);
			btLoginStatus.disable(true);
		}
	}

	//展示对比功能的js
	function datatable1_tlrno_onRefresh(cell, value, record){
		if(record!=null){
			var sta = record.getValue("st");
			var tlrno=record.getValue("tlrno");


			cell.innerHTML = "<a href=\"Javascript:showDetail('"+tlrno+"','"+sta+"')\">"+tlrno+"</a>";

		} else {
			cell.innerHTML = ""
		}
	}


	function showDetail(tlrno,sta){
		showWin("用户详细信息","${contextPath}/fpages/regonization/ftl/OperMngRoleCompare.ftl?id=" + tlrno + "&st=" + sta + "&flag=0","","",window);
	}
</script>
</@CommonQueryMacro.page>
