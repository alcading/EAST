<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="BOPCfaLounexguRecordLoadPage" init="false" submitMode="current" navigate="false">
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
				<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="workDate[75],filler2,actiontype[75],recStatus[75],approveStatus[75],repStatus[75],lounexgucode[80],creditorcode[80],debtorcode[80],debtorname[80],debtortype[70],valuedate[80],maturity[80],dofoexlocode[80],fogucode[75],foguname[75]"   hasFrame="true" width="1000" height="260" readonly="true"/>
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

    function initCallGetter_post(){

		//工作日期
	<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
	BOPCfaLounexguRecordLoadPage_interface_dataset.setValue("workDate","${v_txdate}");
    	
    }
	
	
	function btConfirm_onClick(button){
		var ds = window.parent.BOPCfaLounexguRecordChangeInfo_dataset;
		if (ds.length==0){
			ds.insertRecord("end");
		}
		ds.setValue2("filler1", BOPCfaLounexguRecordLoadPage_dataset.getValue("id"));
		ds.setValue2("lounexgucode", BOPCfaLounexguRecordLoadPage_dataset.getValue("lounexgucode"));
		
		ds.setValue2("creditorcode",BOPCfaLounexguRecordLoadPage_dataset.getValue("creditorcode"));
		ds.setValue2("cfeogudad",BOPCfaLounexguRecordLoadPage_dataset.getValue("cfeogudad"));
		ds.setValue2("cfeogudcurr",BOPCfaLounexguRecordLoadPage_dataset.getValue("cfeogudcurr"));
		ds.setValue2("debtorcode",BOPCfaLounexguRecordLoadPage_dataset.getValue("debtorcode"));
		ds.setValue2("cfeogudamount",BOPCfaLounexguRecordLoadPage_dataset.getValue("cfeogudamount"));
		ds.setValue2("debtorname",BOPCfaLounexguRecordLoadPage_dataset.getValue("debtorname"));
		ds.setValue2("dofoexlocode",BOPCfaLounexguRecordLoadPage_dataset.getValue("dofoexlocode"));
		ds.setValue2("debtortype",BOPCfaLounexguRecordLoadPage_dataset.getValue("debtortype"));
		ds.setValue2("fogucode",BOPCfaLounexguRecordLoadPage_dataset.getValue("fogucode"));
		ds.setValue2("filler2Oth",BOPCfaLounexguRecordLoadPage_dataset.getValue("filler2"));
		ds.setValue2("credcurrcodeOth",BOPCfaLounexguRecordLoadPage_dataset.getValue("credcurrcode"));
		ds.setValue2("foguname",BOPCfaLounexguRecordLoadPage_dataset.getValue("foguname"));
		ds.setValue2("credconamount",BOPCfaLounexguRecordLoadPage_dataset.getValue("credconamount"));
		ds.setValue2("fogunamen",BOPCfaLounexguRecordLoadPage_dataset.getValue("fogunamen"));
		ds.setValue2("guaranteetype",BOPCfaLounexguRecordLoadPage_dataset.getValue("guaranteetype"));
		ds.setValue2("fogurecode",BOPCfaLounexguRecordLoadPage_dataset.getValue("fogurecode"));
		ds.setValue2("remarkOth",BOPCfaLounexguRecordLoadPage_dataset.getValue("remark"));
		ds.setValue2("valuedate",BOPCfaLounexguRecordLoadPage_dataset.getValue("valuedate"));
		ds.setValue2("maturity",BOPCfaLounexguRecordLoadPage_dataset.getValue("maturity"));
		ds.setFieldReadOnly("lounexgucode",true);
		closeWin();
		
	}
	
	
		
		function datatable1_onDbClick(table,record) {
			
			var ds = window.parent.BOPCfaLounexguRecordChangeInfo_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			ds.setValue2("filler1", BOPCfaLounexguRecordLoadPage_dataset.getValue("id"));
			ds.setValue2("lounexgucode", BOPCfaLounexguRecordLoadPage_dataset.getValue("lounexgucode"));
			
			ds.setValue2("creditorcode",BOPCfaLounexguRecordLoadPage_dataset.getValue("creditorcode"));
			ds.setValue2("cfeogudad",BOPCfaLounexguRecordLoadPage_dataset.getValue("cfeogudad"));
			ds.setValue2("cfeogudcurr",BOPCfaLounexguRecordLoadPage_dataset.getValue("cfeogudcurr"));
			ds.setValue2("cfeogudcurrName",BOPCfaLounexguRecordLoadPage_dataset.getValue("cfeogudcurrName"));
			ds.setValue2("debtorcode",BOPCfaLounexguRecordLoadPage_dataset.getValue("debtorcode"));
			ds.setValue2("cfeogudamount",BOPCfaLounexguRecordLoadPage_dataset.getValue("cfeogudamount"));
			ds.setValue2("debtorname",BOPCfaLounexguRecordLoadPage_dataset.getValue("debtorname"));
			ds.setValue2("dofoexlocode",BOPCfaLounexguRecordLoadPage_dataset.getValue("dofoexlocode"));
			ds.setValue2("debtortype",BOPCfaLounexguRecordLoadPage_dataset.getValue("debtortype"));
			ds.setValue2("fogucode",BOPCfaLounexguRecordLoadPage_dataset.getValue("fogucode"));
			ds.setValue2("filler2Oth",BOPCfaLounexguRecordLoadPage_dataset.getValue("filler2"));
			ds.setValue2("credcurrcodeOth",BOPCfaLounexguRecordLoadPage_dataset.getValue("credcurrcode"));
			ds.setValue2("credcurrcodeOthName",BOPCfaLounexguRecordLoadPage_dataset.getValue("credcurrcodeName"));
			  
			ds.setValue2("foguname",BOPCfaLounexguRecordLoadPage_dataset.getValue("foguname"));
			ds.setValue2("credconamount",BOPCfaLounexguRecordLoadPage_dataset.getValue("credconamount"));
			ds.setValue2("fogunamen",BOPCfaLounexguRecordLoadPage_dataset.getValue("fogunamen"));
			ds.setValue2("guaranteetype",BOPCfaLounexguRecordLoadPage_dataset.getValue("guaranteetype"));
			ds.setValue2("fogurecode",BOPCfaLounexguRecordLoadPage_dataset.getValue("fogurecode"));
			ds.setValue2("remarkOth",BOPCfaLounexguRecordLoadPage_dataset.getValue("remark"));
			ds.setValue2("valuedate",BOPCfaLounexguRecordLoadPage_dataset.getValue("valuedate"));
			ds.setValue2("maturity",BOPCfaLounexguRecordLoadPage_dataset.getValue("maturity"));
			ds.setFieldReadOnly("lounexgucode",true);
			closeWin();
		}
	
	function btCancel_onClick(button){
		closeWin();
	}
	
</script>
</@CommonQueryMacro.page>			
