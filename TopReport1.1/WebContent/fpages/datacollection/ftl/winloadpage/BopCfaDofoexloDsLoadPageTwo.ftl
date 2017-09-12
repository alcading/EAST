<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQuery id="BopCfaDofoexloDsLoadPageTwo" init="false" submitMode="all" navigate="false" >
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
						fieldStr="workDate[100],actiontype,recStatus[70],approveStatus[70],repStatus[70],dofoexlocode[130],debtorcode[80],valuedate[100],maturity[100],currence[150],contractamount[100],anninrate[80]" readonly="true" hasFrame="true" width="900" height="260"/>
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
		<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
		BopCfaDofoexloDsLoadPageTwo_interface_dataset.setValue("workDate", "${workdate}");

		function btConfirm_onClick(button){
			copy2Value();
		}

		function copy2Value() {
			var ds = window.parent.BOPCfaLounexguRecordAD_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			ds.setValue("dofoexlocode", BopCfaDofoexloDsLoadPageTwo_dataset.getValue("dofoexlocode"));
			ds.setValue("filler1",BopCfaDofoexloDsLoadPageTwo_dataset.getValue("id"));
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