<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="存折表信息维护">
<@CommonQueryMacro.CommonQuery id="EAST_CZXX_TMP" init="true" submitMode="current" navigate="false">
<table align="left" width="1000px">

   <tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1"  fieldStr="czh,cjrq,hqckzh,khtybh,yxjgdm,jrxkzh,nbjgh,zjlb,zjhm,czlx,czzt,ygbz,qyrq,qygyh,errmsg,opr"  width="100%" hasFrame="true"/>
		</td>
	</tr>

	 <tr>
      		<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label="存折信息维护"
        			  fieldStr="czh,cjrq,hqckzh,khtybh,yxjgdm,jrxkzh,nbjgh,zjlb,zjhm,czlx,czzt,ygbz,qyrq,qygyh" colNm=4/>
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
		var record = EAST_CZXX_TMP_dataset.find(["id"],[id]);
		if (record) {
			EAST_CZXX_TMP_dataset.setRecord(record); 
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
	//yxjgdm,id,jrxkzh,yxjgmc,jglb,yzbm,wdh,yyzt,clsj,jggzkssj,jggzzzsj,jgdz,fzrxm,fzrzw,fzrlxdh,cjrq
	function openBranchDtl(id){
		locate(id);
		subwindow_signWindow.show();
	}
	
	  function btSave_postSubmit(button)
      {
			button.url="#";
        	//alert("保存成功");
        	subwindow_signWindow.hide();
        	EAST_CZXX_TMP_dataset.flushData(EAST_CZXX_TMP_dataset.pageIndex);
      }
	
	function signWindow_floatWindow_beforeClose(subwindow){
		EAST_CZXX_TMP_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow){
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
</script>
</@CommonQueryMacro.page>

