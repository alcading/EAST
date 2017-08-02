<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<@CommonQueryMacro.page title="销售绩效考核维护">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="NoticeParam" init="true" submitMode="current">
      		<table width="1000px">


			<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="销售绩效考核维护查询" colNm=4 showButton="true" />
        	</td>
       		 </tr>
      			<tr>

      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>
					<td align="right">
	    				<a href="javascript:btNewClick();"> 新增</a>
	       			</td>

      			</tr>

      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" fieldStr="noticeName,noticeValue,noticeAmt,noticeTotperi,noticeFlg,createdt,updt,opr" width="100%" hasFrame="true" readonly="true" />
      			  </td>
      			 </tr>
      			 <tr>
		      		<td colspan="2">
		      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
		      			<div align="center">
		      				<@CommonQueryMacro.Group id="group1" label="销售绩效考核维护"
		        			  fieldStr="noticeName,noticeValue,noticeAmt,noticeTotperi,noticeFlg" colNm=4/>
		        			 </br>
		      				<@CommonQueryMacro.Button id= "btSave"/>
		      			</div>
		     		 </@CommonQueryMacro.FloatWindow>

		  			</td>
  				</tr>
      			 <tr style="display:none">
					<td colspan="2">
						<@CommonQueryMacro.Button id= "btNew"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btMod"/>&nbsp;&nbsp;
					</td>
				</tr>
				
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">

	function btNewClick(){
		subwindow_signWindow.show();
		btNew.click();
	}
	//判断是否加起来大于1了
	function btSave_onClickCheck(){
   	var record1 = NoticeParam_dataset.getFirstRecord();
	var chk=0;
	while(record1){
			chk+= record1.getValue("noticeValue");

		record1=record1.getNextRecord();
	}

	if (chk>1) {
	   		alert("所有绩效项目比重之和不能超过1");
	   		return false;
	   	}
}
	//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			
				cell.innerHTML="<center><a href=\"JavaScript:doModify('"+value+"')\">修改</a> &nbsp; <a href=\"JavaScript:doDelete('"+value+"')\">删除</a></center>";
			
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}
	}

	//定位一条记录
	function locate(id) {

		var record = NoticeParam_dataset.find(["id"],[id]);
		if (record) {
			NoticeParam_dataset.setRecord(record);
		}
	}

	//修改
	function doModify(id) {
		locate(id);

		subwindow_signWindow.show();
	}

	//删除
	function doDelete(id) {
		locate(id);

		if(confirm('是否删除当前记录'))
		{
			btDel.click();
		}
	}

function btSave_postSubmit(button) {
		alert("保存成功");
		subwindow_signWindow.close();
		NoticeParam_dataset.flushData(NoticeParam_dataset.pageIndex);
	}
function btDel_postSubmit(button) {
		alert("删除成功");
		NoticeParam_dataset.flushData(NoticeParam_dataset.pageIndex);
	}

	function signWindow_floatWindow_beforeClose(subwindow){
		 NoticeParam_dataset.cancelRecord();
		 return true;
	}

</script>
</@CommonQueryMacro.page>