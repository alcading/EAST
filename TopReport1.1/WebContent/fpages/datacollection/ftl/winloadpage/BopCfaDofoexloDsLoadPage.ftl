<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQuery id="BopCfaDofoexloDsLoadPage" init="false" submitMode="all" navigate="false" >
		<table align="left">
			<tr>
				<td colspan="2">
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<@CommonQueryMacro.DataTable id ="BopCfaDofoexloDsAddLoadPageTable" hasFrame="true"
						fieldStr="filler2[100],workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],dofoexlocode[130],debtorcode[80],valuedate[100],maturity[100],currence[150],contractamount[100],anninrate[80]" readonly="true" hasFrame="true" width="900" height="260"/>
				</td>
	    	</tr>

			<tr colspan="2">
				<td>
					<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">

	   function initCallGetter_post(){
		   <#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
			BopCfaDofoexloDsLoadPage_interface_dataset.setValue("workDate", "${workdate}");
		   
	   }
		

		function btConfirm_onClick(button){
			copy2Value();
		}

		function copy2Value() {
			var ds = window.parent.BopCfaDofoexloDsChangeInfoAdd_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			ds.setValue("dofoexlocode", BopCfaDofoexloDsLoadPage_dataset.getValue("dofoexlocode"));
			ds.setValue("filler1", BopCfaDofoexloDsLoadPage_dataset.getValue("id"));


			ds.setValue("debtorname", BopCfaDofoexloDsLoadPage_dataset.getValue("debtorname"));

			ds.setValue("debtorcode", BopCfaDofoexloDsLoadPage_dataset.getValue("debtorcode"));
			ds.setValue("creditorcode", BopCfaDofoexloDsLoadPage_dataset.getValue("creditorcode"));

			ds.setValue("valuedate", BopCfaDofoexloDsLoadPage_dataset.getValue("valuedate"));
			ds.setValue2("dofoexlotype", BopCfaDofoexloDsLoadPage_dataset.getValue("dofoexlotype"));
			ds.setValue2("dofoexlotypeName", BopCfaDofoexloDsLoadPage_dataset.getValue("dofoexlotypeName"));

			ds.setValue("maturity", BopCfaDofoexloDsLoadPage_dataset.getValue("maturity"));
			ds.setValue("lenproname", BopCfaDofoexloDsLoadPage_dataset.getValue("lenproname"));

			ds.setValue2("currence", BopCfaDofoexloDsLoadPage_dataset.getValue("currence"));
			ds.setValue2("currenceName", BopCfaDofoexloDsLoadPage_dataset.getValue("currenceName"));
			ds.setValue("lenagree", BopCfaDofoexloDsLoadPage_dataset.getValue("lenagree"));

			ds.setValue("contractamount", BopCfaDofoexloDsLoadPage_dataset.getValue("contractamount"));
			ds.setValue("anninrate", BopCfaDofoexloDsLoadPage_dataset.getValue("anninrate"));

			closeWin();
		}

		function BopCfaDofoexloDsAddLoadPageTable_onDbClick(table,record) {
			copy2Value();
		}


		function btBack_onClick(button){
			closeWin();
		}

	</script>
</@CommonQueryMacro.page>