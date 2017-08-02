<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="余额信息">
<@CommonQueryMacro.CommonQuery id="BopForSameInduDepositLoadPage" init="false" submitMode="current" navigate="false">
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
	BopForSameInduDepositLoadPage_interface_dataset.setValue("qworkDate","${v_txdate}");
	function btConfirm_onClick(button){
	
		var ds = window.parent.BopForSameInduDepositBalanceInfoCol_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			
			ds.setValue2("filler1", BopForSameInduDepositLoadPage_dataset.getValue("id"));
			ds.setValue2("exdebtcode", BopForSameInduDepositLoadPage_dataset.getValue("exdebtcode"));
			ds.setValue2("creditorcode", BopForSameInduDepositLoadPage_dataset.getValue("creditorcode"));
			ds.setValue2("debtorcode", BopForSameInduDepositLoadPage_dataset.getValue("debtorcode"));
			ds.setValue2("creditorname", BopForSameInduDepositLoadPage_dataset.getValue("creditorname"));
			ds.setValue2("debtype", BopForSameInduDepositLoadPage_dataset.getValue("debtype"));
			ds.setValue2("debtypeName", BopForSameInduDepositLoadPage_dataset.getValue("debtypeName"));
			ds.setValue2("creditornamen", BopForSameInduDepositLoadPage_dataset.getValue("creditornamen"));
			//ds.setValue2("limitType", BopForSameInduDepositLoadPage_dataset.getValue("limitType"));
			ds.setValue2("creditortype", BopForSameInduDepositLoadPage_dataset.getValue("creditortype"));
			ds.setValue2("valuedate", BopForSameInduDepositLoadPage_dataset.getValue("valuedate"));
			ds.setValue2("crehqcode", BopForSameInduDepositLoadPage_dataset.getValue("crehqcode"));
			ds.setValue2("crehqcodeName", BopForSameInduDepositLoadPage_dataset.getValue("crehqcodeName"));
			ds.setValue2("contractcurr", BopForSameInduDepositLoadPage_dataset.getValue("contractcurr"));
			ds.setValue2("contractcurrName", BopForSameInduDepositLoadPage_dataset.getValue("contractcurrName"));
			ds.setValue2("opercode", BopForSameInduDepositLoadPage_dataset.getValue("opercode"));
			ds.setValue2("opercodeName", BopForSameInduDepositLoadPage_dataset.getValue("opercodeName"));
			ds.setValue2("floatrate", BopForSameInduDepositLoadPage_dataset.getValue("floatrate"));
			ds.setValue2("spapfeboindex", BopForSameInduDepositLoadPage_dataset.getValue("spapfeboindex"));
			ds.setValue2("anninrate", BopForSameInduDepositLoadPage_dataset.getValue("anninrate"));
			ds.setValue2("filler2Oth", BopForSameInduDepositLoadPage_dataset.getValue("filler2"));
			
			
			ds.setValue2("creditorcode", BopForSameInduDepositLoadPage_dataset.getValue("creditorcode"));
			ds.setValue2("creditorname", BopForSameInduDepositLoadPage_dataset.getValue("creditorname"));
			ds.setValue2("creditornamen", BopForSameInduDepositLoadPage_dataset.getValue("creditornamen"));
			ds.setValue2("creditortype", BopForSameInduDepositLoadPage_dataset.getValue("creditortype"));
			ds.setFieldReadOnly("exdebtcode",true);
			closeWin();	
		
	}
	
		function datatable1_onDbClick(table,record) {
			var ds = window.parent.BopForSameInduDepositBalanceInfoCol_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			
			ds.setValue2("filler1", BopForSameInduDepositLoadPage_dataset.getValue("id"));
			ds.setValue2("exdebtcode", BopForSameInduDepositLoadPage_dataset.getValue("exdebtcode"));
			ds.setValue2("creditorcode", BopForSameInduDepositLoadPage_dataset.getValue("creditorcode"));
			ds.setValue2("debtorcode", BopForSameInduDepositLoadPage_dataset.getValue("debtorcode"));
			ds.setValue2("creditorname", BopForSameInduDepositLoadPage_dataset.getValue("creditorname"));
			ds.setValue2("debtype", BopForSameInduDepositLoadPage_dataset.getValue("debtype"));
			ds.setValue2("debtypeName", BopForSameInduDepositLoadPage_dataset.getValue("debtypeName"));
			ds.setValue2("creditornamen", BopForSameInduDepositLoadPage_dataset.getValue("creditornamen"));
			//ds.setValue2("limitType", BopForSameInduDepositLoadPage_dataset.getValue("limitType"));
			ds.setValue2("creditortype", BopForSameInduDepositLoadPage_dataset.getValue("creditortype"));
			ds.setValue2("valuedate", BopForSameInduDepositLoadPage_dataset.getValue("valuedate"));
			ds.setValue2("crehqcode", BopForSameInduDepositLoadPage_dataset.getValue("crehqcode"));
			ds.setValue2("crehqcodeName", BopForSameInduDepositLoadPage_dataset.getValue("crehqcodeName"));
			ds.setValue2("contractcurr", BopForSameInduDepositLoadPage_dataset.getValue("contractcurr"));
			ds.setValue2("contractcurrName", BopForSameInduDepositLoadPage_dataset.getValue("contractcurrName"));
			ds.setValue2("opercode", BopForSameInduDepositLoadPage_dataset.getValue("opercode"));
			ds.setValue2("opercodeName", BopForSameInduDepositLoadPage_dataset.getValue("opercodeName"));
			ds.setValue2("floatrate", BopForSameInduDepositLoadPage_dataset.getValue("floatrate"));
			ds.setValue2("spapfeboindex", BopForSameInduDepositLoadPage_dataset.getValue("spapfeboindex"));
			ds.setValue2("anninrate", BopForSameInduDepositLoadPage_dataset.getValue("anninrate"));
			ds.setValue2("filler2Oth", BopForSameInduDepositLoadPage_dataset.getValue("filler2"));
			
			
			ds.setValue2("creditorcode", BopForSameInduDepositLoadPage_dataset.getValue("creditorcode"));
			ds.setValue2("creditorname", BopForSameInduDepositLoadPage_dataset.getValue("creditorname"));
			ds.setValue2("creditornamen", BopForSameInduDepositLoadPage_dataset.getValue("creditornamen"));
			ds.setValue2("creditortype", BopForSameInduDepositLoadPage_dataset.getValue("creditortype"));
			ds.setFieldReadOnly("exdebtcode",true);
			closeWin();	
		}
	
	function btCancel_onClick(button){
		closeWin();
	}
	
</script>
</@CommonQueryMacro.page>			
