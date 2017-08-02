<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="bopForDebtFeiOrgSaveLoadPage" init="false" submitMode="current" navigate="false" >
	<table align="left">
		<tr>
			<td>
				<@CommonQueryMacro.Interface id="interface"  label="请输入查询条件" />
			</td>
		</tr>
		<tr>
		  	<td>
		    	<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"   pageCache="false" showArrow="true"/>
		  	</td>
		</tr>
		<tr>
	      	<td>
				<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="exdebtcode[180],limitType[100],debtorcode[120],debtype[100],valuedate[100],contractcurr[120],floatrate[80],anninrate[80],creditorcode[80],creditorname[120],creditornamen[120],creditortype[80],spapfeboindex[80],crehqcode,opercode" readonly="true" hasFrame="true" width="1000" height="260"/>
	      	</td>
  		</tr>
  		<tr>
			<td>
				<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
				<@CommonQueryMacro.Button id= "btConfirmBack"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

	function initCallGetter_post(){
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		bopForDebtFeiOrgSaveLoadPage_interface_dataset.setValue("qworkDate", currentDate);
	}
	
	function datatable1_onDbClick(table,record) {
		copy2Value();
	}

	function btConfirm_onClick(button){
		copy2Value();
	}

	function copy2Value(){
		var ds = window.parent.bopForDebtFeiOrgSaveOver_dataset;
		if (ds.length==0){
			ds.insertRecord("end");
		}
		ds.setValue("exdebtcode", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("exdebtcode"));
		ds.setValue2("debtype", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("debtype"));
		ds.setValue("debtypeName", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("debtypeName"));
		ds.setValue("debtorcode", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("debtorcode"));
		ds.setValue("creditorcode", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("creditorcode"));
		ds.setValue("creditorname", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("creditorname"));
		ds.setValue("creditornamen", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("creditornamen"));
		ds.setValue2("limitType", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("limitType"));
		ds.setValue2("creditortype", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("creditortype"));
		ds.setValue("creditortypeName", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("creditortypeName"));
		ds.setValue("valuedate", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("valuedate"));
		ds.setValue2("crehqcode", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("crehqcode"));
		ds.setValue("crehqcodeName", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("crehqcodeName"));
		ds.setValue2("contractcurr", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("contractcurr"));
		ds.setValue("contractcurrName", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("contractcurrName"));
		ds.setValue2("opercode", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("opercode"));
		ds.setValue("opercodeName", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("opercodeName"));
		ds.setValue("floatrate", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("floatrate"));
		ds.setValue("anninrate", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("anninrate"));
		ds.setValue("spapfeboindex", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("spapfeboindex"));
		ds.setValue("debtyperema", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("remark"));
		ds.setValue("filler1", bopForDebtFeiOrgSaveLoadPage_dataset.getValue("id"));
		closeWin();
	}

	function btConfirmBack_onClick(button){
		closeWin();
	}
	
</script>
</@CommonQueryMacro.page>