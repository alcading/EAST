<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op="${RequestParameters['op']?default('')}" />
<#assign info = Session["USER_SESSION_INFO"]>
<@CommonQueryMacro.page title="LoanBalanceEntry.title">
   <table align="center">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="LoanBalanceEntry" init="true" submitMode="current">
      		<table width="100%">
      			<tr>
      			  <td colspan="2" valign="top">
      			    <@CommonQueryMacro.Interface id="interface" label="finStandard.interface.label" />
      			  </td>
      			</tr>

      			<tr>
      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>
					
      			</tr>
      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id ="datatable1" fieldStr="sjrq,jrjgbm,khlx,jkrbm,dkjjbh,dkbz,dkye,llsp,dkzt,opr[120]" hasFrame="true" width="1250" height="300"  readonly="true"/>
      			  </td>
      			 </tr>
      			 <tr align="center" style="display:none">
					<td><@CommonQueryMacro.Button id= "btMod"/></td>
					<td><@CommonQueryMacro.Button id= "btDtl"/></td>
				</tr>
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
   <iframe id="filedownloadfrm"  style="display: none;"></iframe>
<script language="javascript">
	var op ="${op}";
	
	window.onload=function(){
		var date = new Date();
		var today_date = date.getDate();
	    if(today_date < 10) {
	    	today_date = "0" + date.getDate();
	    }
	    var currentDate = date.getFullYear()+"-" + (date.getMonth()+1) + "-" + today_date;
		var sjrq = GetQueryString("sjrq");
		if(sjrq != null){
			LoanBalanceEntry_interface_dataset.setValue("sjrq", sjrq);
		} else {
	    	LoanBalanceEntry_interface_dataset.setValue("sjrq", currentDate);
		}
	
	}
	
	function GetQueryString(name) { 
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null) return (r[2]); 
		return null; 
	}
	
	function initCallGetter_post(dataset) {
		LoanBalanceEntry_dataset.setParameter("op", op);
	}

	//定位一条记录
	function locate(id) {
		var record = LoanBalanceEntry_dataset.find(["id"],[id]);
		if (record) {
			LoanBalanceEntry_dataset.setRecord(record);
		}
	}

	var sjrq,jkrbm,dkjjbh;
	//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
		    sjrq = record.getValue("sjrq");
		    jkrbm=record.getValue("jkrbm");
		    dkjjbh=record.getValue("dkjjbh");	
			cell.innerHTML="<center><a href=\"JavaScript:doModify('"+value+"')\"><@bean.message key="finStandard.button.btMod" /></a>&nbsp;<a href=\"JavaScript:showDetail('"+value+"')\"><@bean.message key="finStandard.button.btDtl" /></a></center>";
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}
	}

	//修改
	function doModify(id) {
		 locate(id);
		 LoanBalanceEntry_dataset.setParameter("sjrq", sjrq);
		 LoanBalanceEntry_dataset.setParameter("jkrbm", jkrbm);
		 LoanBalanceEntry_dataset.setParameter("dkjjbh", dkjjbh);
		 btMod.click();
	}

	//详情
	function showDetail(id){
	     locate(id);
		 LoanBalanceEntry_dataset.setParameter("sjrq", sjrq);
		 LoanBalanceEntry_dataset.setParameter("jkrbm", jkrbm);
		 LoanBalanceEntry_dataset.setParameter("dkjjbh", dkjjbh);
		 btDtl.click();
	}
	
</script>
</@CommonQueryMacro.page>