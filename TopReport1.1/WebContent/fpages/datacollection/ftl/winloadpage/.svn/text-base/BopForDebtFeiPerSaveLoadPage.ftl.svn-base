<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="bopForDebtFeiPerSaveLoadPage" init="false" submitMode="current" navigate="false" >
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
				<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="actiontype,filler2,recStatus,approveStatus,repStatus,exdebtcode[180],limitType[100],debtorcode[120],debtype[100],valuedate[100],contractcurr[120],floatrate[80],anninrate[80],creditorcode[80],creditorname[120],creditornamen[120],creditortype[80],spapfeboindex[80],crehqcode,opercode" readonly="true" hasFrame="true" width="1000" height="260"/>
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

	<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
	bopForDebtFeiPerSaveLoadPage_interface_dataset.setValue("qworkDate", "${workdate}");

	function datatable1_onDbClick(table,record) {
		copy2Value();
	}

	function btConfirm_onClick(button){
		copy2Value();
	}

	function copy2Value(){
		var ds = window.parent.bopForDebtFeiPerSaveOver_dataset;
		if (ds.length==0){
			ds.insertRecord("end");
		}
		ds.setValue("exdebtcode", bopForDebtFeiPerSaveLoadPage_dataset.getValue("exdebtcode"));
		ds.setValue2("debtype", bopForDebtFeiPerSaveLoadPage_dataset.getValue("debtype"));
		ds.setValue2("debtypeName", bopForDebtFeiPerSaveLoadPage_dataset.getValue("debtypeName"));
		ds.setValue("debtorcode", bopForDebtFeiPerSaveLoadPage_dataset.getValue("debtorcode"));
		ds.setValue("creditorcode", bopForDebtFeiPerSaveLoadPage_dataset.getValue("creditorcode"));
		ds.setValue("creditorname", bopForDebtFeiPerSaveLoadPage_dataset.getValue("creditorname"));
		ds.setValue("creditornamen", bopForDebtFeiPerSaveLoadPage_dataset.getValue("creditornamen"));
		ds.setValue2("limitType", bopForDebtFeiPerSaveLoadPage_dataset.getValue("limitType"));
		ds.setValue2("creditortype", bopForDebtFeiPerSaveLoadPage_dataset.getValue("creditortype"));
		ds.setValue2("creditortypeName", bopForDebtFeiPerSaveLoadPage_dataset.getValue("creditortypeName"));
		ds.setValue("valuedate", bopForDebtFeiPerSaveLoadPage_dataset.getValue("valuedate"));
		ds.setValue2("crehqcode", bopForDebtFeiPerSaveLoadPage_dataset.getValue("crehqcode"));
		ds.setValue2("crehqcodeName", bopForDebtFeiPerSaveLoadPage_dataset.getValue("crehqcodeName"));
		ds.setValue2("contractcurr", bopForDebtFeiPerSaveLoadPage_dataset.getValue("contractcurr"));
		ds.setValue2("contractcurrName", bopForDebtFeiPerSaveLoadPage_dataset.getValue("contractcurrName"));
		ds.setValue2("opercode", bopForDebtFeiPerSaveLoadPage_dataset.getValue("opercode"));
		ds.setValue2("opercodeName", bopForDebtFeiPerSaveLoadPage_dataset.getValue("opercodeName"));
		ds.setValue2("floatrate", bopForDebtFeiPerSaveLoadPage_dataset.getValue("floatrate"));
		ds.setValue("anninrate", bopForDebtFeiPerSaveLoadPage_dataset.getValue("anninrate"));
		ds.setValue2("spapfeboindex", bopForDebtFeiPerSaveLoadPage_dataset.getValue("spapfeboindex"));
		ds.setValue("debtyperema", bopForDebtFeiPerSaveLoadPage_dataset.getValue("remark"));
		ds.setValue("filler1", bopForDebtFeiPerSaveLoadPage_dataset.getValue("id"));
		closeWin();
	}

	function btConfirmBack_onClick(button){
		closeWin();
	}

</script>
</@CommonQueryMacro.page>