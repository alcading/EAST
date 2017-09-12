<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="客户信息">
<@CommonQueryMacro.CommonQuery id="customerLoadPage" init="true" submitMode="current" navigate="false">
	<table width="800px">
		<tr>
			<td valign="top">
				<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm=4 showButton="true"/>
			</td>
		</tr>
		<tr>
			<td >
				<@CommonQueryMacro.PagePilot id="pagePilot"  maxpagelink="9" showArrow="true" pageCache="false"/>
			</td>
		</tr>	
		<tr>
			<td>
				<@CommonQueryMacro.DataTable id="dataTable1" fieldStr="id[60],orgId[60],customerType[80],customerName[60],paperType[140],paperCode[100],registrationMoney[60],corporationRepname[80],stockFlag[100]" hasFrame="true" height="240" width="800"/>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
				<@CommonQueryMacro.Button id= "btCancell"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	
	//根据传过来的loadFromType判断是那个页面调用
	//确定时设置选择的相应的记录数据初始化调用页面的相应dataset的相应field
	function btConfirm_onClick(button){
		var loadFromType = "${RequestParameters["loadFromType"]?default('')}";
		//if (loadFromType == "A") {
		//	//TODO
		//	A_dataset.setVlaue("A页面的Field", customerLoadPage_dataset.getValue("customerName"));
		//}
		win.close();
	}
	
	function btCancell_onClick(button){
		win.close();
		return false;
	}
	
</script>
</@CommonQueryMacro.page>			
