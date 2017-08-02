<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<@CommonQueryMacro.page title="客户经理产品销售信息补录">
   <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="ProductSoldAddit" init="false" submitMode="current">
      		<table width="1000px">


			<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="产品销售信息补录查询" colNm=4 showButton="true" />
        	</td>
       		 </tr>
      			<tr>

      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>

      			</tr>

      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" paginationbar="btNew" fieldStr="brcode,moths,cmrm,dtyp,amt,updt,st,opr" width="100%" hasFrame="true" readonly="true" />
      			  </td>
      			 </tr>
      			 <tr>
		      		<td colspan="2">
		      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
		      			<div align="center">
		      				<@CommonQueryMacro.Group id="group1" label="客户经理产品销售信息补录"
		        			  fieldStr="brcode,moths,cmrm,dtyp,amt" colNm=4/>
		        			 </br>
		      				<@CommonQueryMacro.Button id= "btSave"/>
		      			</div>
		     		 </@CommonQueryMacro.FloatWindow>

		  			</td>
  				</tr>
      			 <tr style="display:none">
					<td colspan="2">
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

	function btNew_onClick(){
		subwindow_signWindow.show();
		ProductSoldAddit_dataset.setFieldReadOnly("moths", false);
		ProductSoldAddit_dataset.setFieldReadOnly("cmrm", false);
		ProductSoldAddit_dataset.setFieldReadOnly("dtyp", false);
	}

	function btSave_postSubmit(button){
		alert("保存成功！");
	}

	function datatable1_opr_onRefresh(cell,value,record) {
		//记录集存在
		if(record) {
			var months = record.getValue("moths");
			var cmrm = record.getValue("cmrm");
			var dtyp = record.getValue("dtyp");
			//防止类型自动转换，所以传一个值
			var par = ","+months+","+cmrm+","+dtyp+",";
			var lock=record.getValue("lock");
			if(isTrue(lock)){
				cell.innerHTML = "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\">修改</a><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\">删除</a> </center>";
			}else{
				cell.innerHTML="<center><a href=\"JavaScript:doModify('"+par+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDelete('"+par+"')\">删除</a></center>";

			}
		}else{
			cell.innerHTML="";
		}


	}

function locate(moths,cmrm,dtyp) {
		var record = ProductSoldAddit_dataset.find(["moths","cmrm","dtyp"],[moths,cmrm,dtyp]);
		if(record) {
			ProductSoldAddit_dataset.setRecord(record);
		}
	}
	

	//修改
	function doModify(id) {
	
	var parArra = id.split(",");
		var aaa = parArra[1];
		var bbb = parArra[2];
		var ccc = parArra[3];
		locate(aaa,bbb,ccc);
		subwindow_signWindow.show();
		ProductSoldAddit_dataset.setFieldReadOnly("moths", true);
		ProductSoldAddit_dataset.setFieldReadOnly("cmrm", true);
		ProductSoldAddit_dataset.setFieldReadOnly("dtyp", true);
	}

	//删除
	function doDelete(id) {
		var parArra = id.split(",");
		var aaa = parArra[1];
		var bbb = parArra[2];
		var ccc = parArra[3];
		locate(aaa,bbb,ccc);

		if(confirm('是否删除当前记录'))
		{
			btDel.click();
		}
	}

function btSave_postSubmit(button) {
		alert("保存成功");
		subwindow_signWindow.close();
		ProductSoldAddit_dataset.flushData(ProductSoldAddit_dataset.pageIndex);
	}
function btDel_postSubmit(button) {
		alert("删除成功");
		ProductSoldAddit_dataset.flushData(ProductSoldAddit_dataset.pageIndex);
	}

	function signWindow_floatWindow_beforeClose(subwindow){
		 ProductSoldAddit_dataset.cancelRecord();
		 return true;
	}

</script>
</@CommonQueryMacro.page>