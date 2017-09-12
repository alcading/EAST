<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsLoadPage" init="false" submitMode="current" navigate="false" >
		<table align="left">
			<tr>
				<td colspan="2">
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
				</td>
	   		</tr>
	   		<tr>
	   			<td colspan="2">
					<@CommonQueryMacro.DataTable id ="BopCfaExplrmbloDsTable" hasFrame="true"
							fieldStr="filler2[100]workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],explrmblono[130],creditorcode,debtorcode[80],debtorname,valuedate[100],maturity[100],credconcurr[150],credconamount[100]" readonly="true" hasFrame="true" width="900" height="260"/>
	   			</td>
	   		</tr>
			<tr>
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
		  BopCfaExplrmbloDsLoadPage_interface_dataset.setValue("workDate", "${workdate}");
		  
	  }

		

		function btConfirm_onClick(button){
			copy2Value();
		}

		function copy2Value() {
			var ds = window.parent.BopCfaExplrmbloDsChangeInfoAdd_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			ds.setValue("explrmblono", BopCfaExplrmbloDsLoadPage_dataset.getValue("explrmblono"));
			ds.setValue("filler1", BopCfaExplrmbloDsLoadPage_dataset.getValue("id"));


			ds.setValue("debtorcode", BopCfaExplrmbloDsLoadPage_dataset.getValue("debtorcode"));
			ds.setValue("creditorcode", BopCfaExplrmbloDsLoadPage_dataset.getValue("creditorcode"));

			ds.setValue("debtorname", BopCfaExplrmbloDsLoadPage_dataset.getValue("debtorname"));


			var valuedate = BopCfaExplrmbloDsLoadPage_dataset.getValue("valuedate");
			ds.setValue("valuedate", BopCfaExplrmbloDsLoadPage_dataset.getValue("valuedate"));
			ds.setValue("maturity", BopCfaExplrmbloDsLoadPage_dataset.getValue("maturity"));

			ds.setValue2("credconcurr", BopCfaExplrmbloDsLoadPage_dataset.getValue("credconcurr"));
			ds.setValue("credconcurrName", BopCfaExplrmbloDsLoadPage_dataset.getValue("credconcurrName"));
			ds.setValue("credconamount", BopCfaExplrmbloDsLoadPage_dataset.getValue("credconamount"));

			closeWin();
		}

		function BopCfaExplrmbloDsTable_onDbClick(table,record) {
			copy2Value();
		}

		function btBack_onClick(button){
			closeWin();
		}

	</script>
</@CommonQueryMacro.page>