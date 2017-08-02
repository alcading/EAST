<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#--jianxue.zhang-->
<@CommonQueryMacro.page title="主管确认">
<table width="800px" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="ApproveConfig" init="true" submitMode="current">
	<table width="100%">
		<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="系统复核配置" colNm=4 showButton="true" />
        	</td>
        </tr>
		<tr>
   			<td >
   				<@CommonQueryMacro.PagePilot id="PagePilot"/>
   			</td>
   			<td align="right" style="display:none">
	    		<a href="javascript:btNewClick();">新增</a>
	        </td>

  		</tr>
  		<tr>
      		<td colspan="2">
          		<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id,taskname,flag,opr" width="100%"  readonly="true"/></br>
        	</td>
        </tr>
		 <tr>
      		<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label="功能复核维护"
        			  fieldStr="id,taskname,flag" colNm=4/>
        			 </br>
      				<@CommonQueryMacro.Button id= "btSave"/>
      			</div>
     		 </@CommonQueryMacro.FloatWindow>
        			
  			</td>
  		</tr>
  		<td style="display:none">
  				<@CommonQueryMacro.Button id= "btnAdd"/>
  			</td>
  		</tr>
   </table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>

 <script language="javascript">
 

//定位一条记录
function locate(id) {
	var record = ApproveConfig_dataset.find(["id"],[id]);
	if (record) {
		ApproveConfig_dataset.setRecord(record);
	}
}
function datatable1_opr_onRefresh(cell, value, record)
	{
	
		if (record) {//当存在记录时
			var id = record.getValue("id");
				cell.innerHTML="<center><a href=\"JavaScript:modDtl('"+id+"')\">修改</a></center>";
			}
 else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}
	}
	
function modDtl(id){
		locate(id);
		ApproveConfig_dataset.setFieldReadOnly("id", true);
		
		subwindow_signWindow.show();
	}

function btNewClick(){
		subwindow_signWindow.show();
		btnAdd.click();
	}
	function signWindow_floatWindow_beforeClose(subwindow){
		ApproveConfig_dataset.cancelRecord();
		return true;
	}
		function btSave_postSubmit(button) {
		button.url="#";
		subwindow_signWindow.close();
		ApproveConfig_dataset.flushData(ApproveConfig_dataset.pageIndex);
	}

</script>

</@CommonQueryMacro.page>