<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQuery id="BopCfaDebtBiLoanLoadPage" init="false" submitMode="all" navigate="false" >
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
					<@CommonQueryMacro.DataTable id ="BopCfaDebtBiLoanLoadPage1" hasFrame="true" fieldStr="filler2[80],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],debtorcode[120],debtype[80],contractdate[100],valuedate[100],contractcurr[160],contractamount[120],maturity[100],anninrate[100],inpriamount,spapfeboindex" readonly="true" hasFrame="true" width="900" height="205"/>

				</td>
	    	</tr>

			<tr colspan="2">
				<td>
					<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id= "btConfirmBack"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">

		function initCallGetter_post() {
			<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
			BopCfaDebtBiLoanLoadPage_interface_dataset.setValue("qStartDate", "${workdate}");
			BopCfaDebtBiLoanLoadPage_interface_dataset.setValue("qEndDate", "${workdate}");
		}

		function btConfirm_onClick(button){
			setBackValue();
		}

		function setBackValue()
		{
			var ds = window.parent.BOPForDebtChangInfoCol_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
		   	var load_dataset = BopCfaDebtBiLoanLoadPage_dataset;

			ds.setValue("exdebtcode", load_dataset.getValue("exdebtcode"));

			ds.setValue2("creditortype", load_dataset.getValue("creditortype"));

			ds.setValue("creditortypeName", load_dataset.getValue("creditortypeName"));

			ds.setValue("debtorcode", load_dataset.getValue("debtorcode"));
			ds.setValue("creditorcode", load_dataset.getValue("creditorcode"));
			ds.setValue2("debtype", load_dataset.getValue("debtype"));
			ds.setValue("debtypeName", load_dataset.getValue("debtypeName"));

			ds.setValue("creditorname", load_dataset.getValue("creditorname"));
			ds.setValue("contractdate", load_dataset.getValue("contractdate"));
			ds.setValue("creditornamen", load_dataset.getValue("creditornamen"));

			ds.setValue2("contractcurr", load_dataset.getValue("contractcurr"));
			ds.setValue2("contractcurrName", load_dataset.getValue("contractcurrName"));

			ds.setValue2("crehqcode", load_dataset.getValue("crehqcode"));
			ds.setValue2("crehqcodeName", load_dataset.getValue("crehqcodeName"));

			if(!isNaN(load_dataset.getValue("contractamount")))
			{
				ds.setValue("contractamount", load_dataset.getValue("contractamount"));
			}


			ds.setValue2("inprterm", load_dataset.getValue("inprterm"));
			ds.setValue2("opercode", load_dataset.getValue("opercode"));
			ds.setValue2("opercodeName", load_dataset.getValue("opercodeName"));

			ds.setValue("valuedate", load_dataset.getValue("valuedate"));
			ds.setValue("maturity", load_dataset.getValue("maturity"));
			ds.setValue("floatrate", load_dataset.getValue("floatrate"));

			if(!isNaN(load_dataset.getValue("anninrate")))
			{
				ds.setValue("anninrate", load_dataset.getValue("anninrate"));
			}

			if(!isNaN(load_dataset.getValue("inpriamount")))
			{
				ds.setValue("inpriamount", load_dataset.getValue("inpriamount"));
			}


			ds.setValue2("spapfeboindex", load_dataset.getValue("spapfeboindex"));

			ds.setValue("isincode", load_dataset.getValue("isincode"));

			ds.setValue("inltcabuscode", load_dataset.getValue("inltcabuscode"));
			ds.setValue("appcode", load_dataset.getValue("appcode"));
			ds.setValue("appname", load_dataset.getValue("appname"));

			ds.setValue("debtyperema", load_dataset.getValue("debtyperema"));
			ds.setValue("appname", load_dataset.getValue("appname"));
			ds.setValue("projectname", load_dataset.getValue("projectname"));
			ds.setValue("filler1", load_dataset.getValue("id"));
			ds.setValue("qFiller2", load_dataset.getValue("filler2"));

			closeWin();

		}

		function BopCfaDebtBiLoanLoadPage1_onDbClick(table,record) {
			setBackValue()
		}

		function btConfirmBack_onClick(button){
			closeWin();
		}

	</script>
</@CommonQueryMacro.page>