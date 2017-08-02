<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="选择">
	<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsLoadPage" init="false" submitMode="selected" navigate="false" >
		<table align="left">
			<tr>
				<td>
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
				</td>
		    </tr>
		    <tr>
		    	<td>
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],strdecode[250],branchcode[120],clientcode[100],clientname,contractdate[85],contract[250],contractamount,maturity[100],lincame[300],lincamethod[300],aginraup,aginralo,aginraloinpay[300],remark[300]" hasFrame="true" width="900" height="260" readonly="true"/>
		      	</td>
		    </tr>
			<tr>
				<td align="left">
					<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id= "btConfirmBack"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">
		

		function initCallGetter_post() {
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			bopCfaStrdeDsLoadPage_interface_dataset.setValue("qworkDateStart","${v_txdate}");
			bopCfaStrdeDsLoadPage_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
		}

		var type = "${RequestParameters["type"]?default('')}";;

		var localDs = bopCfaStrdeDsLoadPage_dataset;

		function datatable1_onDbClick(table,record) {
			btSelect(record);
		}

		function btConfirm_onClick(button) {
			btSelect(localDs);
		}

		function btSelect(localDs) {
			var ds = null;
			if(type == "terminate") {
				ds = window.parent.bopCfaStrdeDsEntryTerminateAdd_dataset;
			} else if(type == "inpay" ) {
				ds = window.parent.bopCfaStrdeDsEntryInpayAdd_dataset;
			}
			if(ds.length == 0 ) {
				ds.insertRecord("end");
			}
			//设置filler1为记录编号以及其他签约信息字段
			ds.setValue("filler1",localDs.getValue("id"));
			ds.setValue("strdecode",localDs.getValue("strdecode"));
			ds.setValue("branchcode",localDs.getValue("branchcode"));
			ds.setValue("clientcode",localDs.getValue("clientcode"));
			ds.setValue("clientname",localDs.getValue("clientname"));
			ds.setValue("contractdate",localDs.getValue("contractdate"));
			ds.setValue("contract",localDs.getValue("contract"));
			ds.setValue("contractamount",localDs.getValue("contractamount"));
			ds.setValue("maturity",localDs.getValue("maturity"));
			ds.setValue("lincame",localDs.getValue("lincame"));
			ds.setValue("lincamethod",localDs.getValue("lincamethod"));
			ds.setValue("aginraup",localDs.getValue("aginraup"));
			ds.setValue("aginralo",localDs.getValue("aginralo"));
			ds.setValue("aginraloinpay",localDs.getValue("aginraloinpay"));
			ds.setValue("remark",localDs.getValue("remark"));
			//设置只读
			ds.setFieldReadOnly("strdecode",true);
			ds.setFieldReadOnly("branchcode",true);
			ds.setFieldReadOnly("clientcode",true);
			ds.setFieldReadOnly("clientname",true);
			ds.setFieldReadOnly("contractdate",true);
			ds.setFieldReadOnly("contract",true);
			ds.setFieldReadOnly("contractamount",true);
			ds.setFieldReadOnly("maturity",true);
			ds.setFieldReadOnly("lincame",true);
			ds.setFieldReadOnly("lincamethod",true);
			ds.setFieldReadOnly("aginraup",true);
			ds.setFieldReadOnly("aginralo",true);
			ds.setFieldReadOnly("aginraloinpay",true);
			ds.setFieldReadOnly("remark",true);
			closeWin();
		}
		function btConfirmBack_onClick(button) {
			closeWin();
		}

	</script>
</@CommonQueryMacro.page>