<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="对公活期存款分户账明细记录信息维护">
<@CommonQueryMacro.CommonQuery id="EAST_DGHQCKFHZMXJL_TMP" init="true" submitMode="current" navigate="false">
<table align="left" width="1000px">

   <tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="hxjylsh,zjylsh,bcxh,hqckzh,hxjyrq,cjrq,khtybh,yxjgdm,jrxkzh,nbjgh,mxkmbh,yxjgmc,mxkmmc,hxjysj,zhmc,jylx,jyje,khhjgh,ywbljgh,zhye,dfzh,dfhm,dfxh,dfxm,jyqd,bz,xzbz,dbrxm,dbrzjlb,dbrzjhm,jygyh,gylsh,sqgyh,zy,cbmbz,jyjdbz,errmsg,opr"  width="100%" hasFrame="true"/>
		</td>
	</tr>

	 <tr>
      		<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label="对公活期存款分户账明细记录信息维护"
        			  fieldStr="hxjylsh,zjylsh,bcxh,hqckzh,hxjyrq,cjrq,khtybh,yxjgdm,jrxkzh,nbjgh,mxkmbh,yxjgmc,mxkmmc,hxjysj,zhmc,jylx,jyje,khhjgh,ywbljgh,zhye,dfzh,dfhm,dfxh,dfxm,jyqd,bz,xzbz,dbrxm,dbrzjlb,dbrzjhm,jygyh,gylsh,sqgyh,zy,cbmbz,jyjdbz" colNm=4/>
        			 </br>
      				<@CommonQueryMacro.Button id= "btSave"/>
      			</div>
     		 </@CommonQueryMacro.FloatWindow>
        			
  			</td>
  		</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
//定位一条记录
	function locate(id) {
		var record = EAST_DGHQCKFHZMXJL_TMP_dataset.find(["id"],[id]);
		if (record) {
			EAST_DGHQCKFHZMXJL_TMP_dataset.setRecord(record); 
		}
	}
	
	function datatable1_opr_onRefresh(cell, value, record)
	{
	
		if (record) {
		    var id = record.getValue("id");
		    cell.innerHTML="<center><a href=\"JavaScript:openBranchDtl('"+id+"')\">修改</a></center>";
			//cell.innerHTML="<center>修改</center>";
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}	
	}
	//hxjylsh,zjylsh,bcxh,hqckzh,hxjyrq,cjrq
	function openBranchDtl(id){
		locate(id);
		EAST_DGHQCKFHZMXJL_TMP_dataset.setFieldReadOnly("hxjylsh", true);
		EAST_DGHQCKFHZMXJL_TMP_dataset.setFieldReadOnly("zjylsh", true);
		EAST_DGHQCKFHZMXJL_TMP_dataset.setFieldReadOnly("bcxh", true);
		EAST_DGHQCKFHZMXJL_TMP_dataset.setFieldReadOnly("hqckzh", true);
		EAST_DGHQCKFHZMXJL_TMP_dataset.setFieldReadOnly("hxjyrq", true);
		EAST_DGHQCKFHZMXJL_TMP_dataset.setFieldReadOnly("cjrq", true);
		subwindow_signWindow.show();
	}
	
	  function btSave_postSubmit(button)
      {
			button.url="#";
        	//alert("保存成功");
        	subwindow_signWindow.hide();
        	EAST_DGHQCKFHZMXJL_TMP_dataset.flushData(EAST_DGHQCKFHZMXJL_TMP_dataset.pageIndex);
      }
	
	function signWindow_floatWindow_beforeClose(subwindow){
		EAST_DGHQCKFHZMXJL_TMP_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow){
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
</script>
</@CommonQueryMacro.page>

