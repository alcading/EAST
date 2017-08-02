<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="">
 <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="BiAccountEntry" init="true" submitMode="current">
      		<table width="1000px">

      			<tr>
      			  <td colspan="2" valign="top">
      			    <@CommonQueryMacro.Interface id="interface" label="BiAccountEntry.interface.interface.label" />
      			  </td>
      			</tr>

      			<tr>

      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>
					<td align="right">
	    				<a href="javascript:btNewClick();"><@bean.message key="BiAccountEntry.button.btNew" /></a>
	       			</td>

      			</tr>

      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" fieldStr="id[100],accountCur[60],customerId[60],accountType[150],chineseName[150],opr[80]" width="100%" hasFrame="true" height="250" readonly="true" />
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
	    BiAccountEntry_dataset.insertRecord("end");
		btNew.click();
	}

	//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
	
		if (record) {//当存在记录时		
			cell.innerHTML="<center><a href=\"JavaScript:doModify('"+value+"')\"><@bean.message key="BiAccountEntry.button.btMod" /></a>  &nbsp; <a href=\"JavaScript:doDelete('"+value+"')\"><@bean.message key="BiAccountEntry.button.btDel" />";
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}
	}

	//定位一条记录
	function locate(id) {
		
		var record = BiAccountEntry_dataset.find(["id"],[id]);
		if (record) {
			BiAccountEntry_dataset.setRecord(record);
		}
	}

	//修改
	function doModify(id) {
		
		locate(id);
		btMod.click();
	}

	//删除
	function doDelete(id) {
		locate(id);

		if(confirm('是否删除当前记录'))
		{
			btDel.click();
		}
	}


</script>
</@CommonQueryMacro.page>