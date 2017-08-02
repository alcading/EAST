<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="CurrencyManEntry.title">
<@CommonQueryMacro.CommonQuery id="biAccountLoadPage" init="true" submitMode="current" navigate="false">
	<table width="800px">
		<tr>
		  <td valign="top">
		    <@CommonQueryMacro.Interface id="interface" label="BiAccountEntry.interface.interface.label" />
		  </td>
		</tr>

		<tr>
		  <td>
		    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
		  </td>
		</tr>

		<tr>
		  <td>
		     <@CommonQueryMacro.DataTable id="datatable1" fieldStr="id[100],accountCur[60],customerId[60],accountType[150],chineseName[150],debits[30],credits[30],balance[30]" width="100%" hasFrame="true" height="240" readonly="true" />
		  </td>
		</tr>
		<tr>
			<td align="left">
				<@CommonQueryMacro.Button id= "btSure"/>&nbsp;&nbsp;
				<@CommonQueryMacro.Button id= "btSureBack"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	//根据传过来的loadFromType判断是那个页面调用
	//确定时设置选择的相应的记录数据初始化调用页面的相应dataset的相应field
	function btSure_onClick(button){
		var loadFromType = "${RequestParameters["loadFromType"]?default('')}";
		if (loadFromType == "A") {
			//TODO
			if (bopAccDsRecordADAdd_dataset.length==0){
				bopAccDsRecordADAdd_dataset.insertRecord("end");
			}
			bopAccDsRecordADAdd_dataset.setValue("accountno", biAccountLoadPage_dataset.getValue("id"));
		}
		win.close();
	}
	
	function btSureBack_onClick(button){
		win.close();
		return false;
	}
</script>
</@CommonQueryMacro.page>