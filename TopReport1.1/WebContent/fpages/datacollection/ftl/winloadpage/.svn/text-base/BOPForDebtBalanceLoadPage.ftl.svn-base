<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="余额信息">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtBalanceLoadPage" init="false" submitMode="current" navigate="false">
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
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="workDate[100],filler2[80],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],debtorcode[120],debtype[80],valuedate[100],contractcurr[80],floatrate[80],anninrate[80],creditorcode,creditorname,creditornamen,creditorca,creditortype,crehqcode,opercode"   hasFrame="true" width="1000" height="260" readonly="true"/>
				</td>
			</tr>

			<tr>
				<td>
					<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id= "btCancel"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="javascript">
		//工作日期
		<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
		BOPForDebtBalanceLoadPage_interface_dataset.setValue("qworkDate","${v_txdate}");
		function btConfirm_onClick(button){

			var ds = window.parent.BOPForDebtBalanceInfoCol_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}

				ds.setValue2("filler1", BOPForDebtBalanceLoadPage_dataset.getValue("id"));
				ds.setValue2("exdebtcode", BOPForDebtBalanceLoadPage_dataset.getValue("exdebtcode"));
				ds.setValue2("creditorcode", BOPForDebtBalanceLoadPage_dataset.getValue("creditorcode"));
				ds.setValue2("debtorcode", BOPForDebtBalanceLoadPage_dataset.getValue("debtorcode"));
				ds.setValue2("creditorname", BOPForDebtBalanceLoadPage_dataset.getValue("creditorname"));
				ds.setValue2("debtype", BOPForDebtBalanceLoadPage_dataset.getValue("debtype"));
				ds.setValue2("debtypeName", BOPForDebtBalanceLoadPage_dataset.getValue("debtypeName"));
				ds.setValue2("creditornamen", BOPForDebtBalanceLoadPage_dataset.getValue("creditornamen"));
				//ds.setValue2("limitType", BOPForDebtBalanceLoadPage_dataset.getValue("limitType"));
				ds.setValue2("creditortype", BOPForDebtBalanceLoadPage_dataset.getValue("creditortype"));
				ds.setValue2("valuedate", BOPForDebtBalanceLoadPage_dataset.getValue("valuedate"));
				ds.setValue2("crehqcode", BOPForDebtBalanceLoadPage_dataset.getValue("crehqcode"));
				ds.setValue2("crehqcodeName", BOPForDebtBalanceLoadPage_dataset.getValue("crehqcodeName"));
				ds.setValue2("contractcurr", BOPForDebtBalanceLoadPage_dataset.getValue("contractcurr"));
				ds.setValue2("contractcurrName", BOPForDebtBalanceLoadPage_dataset.getValue("contractcurrName"));
				ds.setValue2("opercode", BOPForDebtBalanceLoadPage_dataset.getValue("opercode"));
				ds.setValue2("opercodeName", BOPForDebtBalanceLoadPage_dataset.getValue("opercodeName"));
				ds.setValue2("floatrate", BOPForDebtBalanceLoadPage_dataset.getValue("floatrate"));
				ds.setValue2("spapfeboindex", BOPForDebtBalanceLoadPage_dataset.getValue("spapfeboindex"));
				ds.setValue2("anninrate", BOPForDebtBalanceLoadPage_dataset.getValue("anninrate"));
				ds.setValue2("filler2Oth", BOPForDebtBalanceLoadPage_dataset.getValue("filler2"));


				ds.setValue2("creditorcode", BOPForDebtBalanceLoadPage_dataset.getValue("creditorcode"));
				ds.setValue2("creditorname", BOPForDebtBalanceLoadPage_dataset.getValue("creditorname"));
				ds.setValue2("creditornamen", BOPForDebtBalanceLoadPage_dataset.getValue("creditornamen"));
				ds.setValue2("creditortype", BOPForDebtBalanceLoadPage_dataset.getValue("creditortype"));
				ds.setFieldReadOnly("exdebtcode",true);
				closeWin();

		}

			function datatable1_onDbClick(table,record) {
				var ds = window.parent.BOPForDebtBalanceInfoCol_dataset;
				if (ds.length==0){
					ds.insertRecord("end");
				}

				ds.setValue2("filler1", BOPForDebtBalanceLoadPage_dataset.getValue("id"));
				ds.setValue2("exdebtcode", BOPForDebtBalanceLoadPage_dataset.getValue("exdebtcode"));
				ds.setValue2("creditorcode", BOPForDebtBalanceLoadPage_dataset.getValue("creditorcode"));
				ds.setValue2("debtorcode", BOPForDebtBalanceLoadPage_dataset.getValue("debtorcode"));
				ds.setValue2("creditorname", BOPForDebtBalanceLoadPage_dataset.getValue("creditorname"));
				ds.setValue2("debtype", BOPForDebtBalanceLoadPage_dataset.getValue("debtype"));
				ds.setValue2("debtypeName", BOPForDebtBalanceLoadPage_dataset.getValue("debtypeName"));
				ds.setValue2("creditornamen", BOPForDebtBalanceLoadPage_dataset.getValue("creditornamen"));
				//ds.setValue2("limitType", BOPForDebtBalanceLoadPage_dataset.getValue("limitType"));
				ds.setValue2("creditortype", BOPForDebtBalanceLoadPage_dataset.getValue("creditortype"));
				ds.setValue2("valuedate", BOPForDebtBalanceLoadPage_dataset.getValue("valuedate"));
				ds.setValue2("crehqcode", BOPForDebtBalanceLoadPage_dataset.getValue("crehqcode"));
				ds.setValue2("crehqcodeName", BOPForDebtBalanceLoadPage_dataset.getValue("crehqcodeName"));
				ds.setValue2("contractcurr", BOPForDebtBalanceLoadPage_dataset.getValue("contractcurr"));
				ds.setValue2("contractcurrName", BOPForDebtBalanceLoadPage_dataset.getValue("contractcurrName"));
				ds.setValue2("opercode", BOPForDebtBalanceLoadPage_dataset.getValue("opercode"));
				ds.setValue2("opercodeName", BOPForDebtBalanceLoadPage_dataset.getValue("opercodeName"));
				ds.setValue2("floatrate", BOPForDebtBalanceLoadPage_dataset.getValue("floatrate"));
				ds.setValue2("spapfeboindex", BOPForDebtBalanceLoadPage_dataset.getValue("spapfeboindex"));
				ds.setValue2("anninrate", BOPForDebtBalanceLoadPage_dataset.getValue("anninrate"));
				ds.setValue2("filler2Oth", BOPForDebtBalanceLoadPage_dataset.getValue("filler2"));


				ds.setValue2("creditorcode", BOPForDebtBalanceLoadPage_dataset.getValue("creditorcode"));
				ds.setValue2("creditorname", BOPForDebtBalanceLoadPage_dataset.getValue("creditorname"));
				ds.setValue2("creditornamen", BOPForDebtBalanceLoadPage_dataset.getValue("creditornamen"));
				ds.setValue2("creditortype", BOPForDebtBalanceLoadPage_dataset.getValue("creditortype"));
				ds.setFieldReadOnly("exdebtcode",true);
				closeWin();
			}

		function btCancel_onClick(button){
			closeWin();
		}

	</script>
</@CommonQueryMacro.page>
