<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="bopExguLoadPage" init="false" submitMode="all" navigate="false" >
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
				<@CommonQueryMacro.DataTable id ="dataTable1" hasFrame="true" fieldStr="filler2,torCodeGu,guarantorcode,torNameGu,guarantype,torEnnameGu,actiontype,appdocuno,contractdate,maturity,guarancurr,maindebtcurr,guaranamount,maindebtamount" readonly="true" hasFrame="true" width="900" height="260"/>
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

   var currentFile = "${RequestParameters["currentFile"]?default('')}";
   var localDs = bopExguLoadPage_dataset;
   function initCallGetter_post() {
   	 	<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
   		bopExguLoadPage_interface_dataset.setValue("qworkDate","${v_txdate}");
   }
   function dataTable1_onDbClick(table,record) {
	   
		btSelect(record);
	}
	
	function btConfirm_onClick(button) {
		btSelect(localDs);
	}
	
	function btSelect(localDs){
		
		var ds = null;
		if(currentFile=="BB"){
		     ds = window.parent.BopLiabilityBalanceAdd_dataset;}
		else{
			ds = window.parent.BOPForGuperDsInfoAdd_dataset;
		}
		if (ds.length==0){
			ds.insertRecord("end");
		}
		ds.setValue("exguarancode", bopExguLoadPage_dataset.getValue("exguarancode"));
		ds.setValue("torCodeGu", bopExguLoadPage_dataset.getValue("torCodeGu"));
		ds.setValue("guarantorcode", bopExguLoadPage_dataset.getValue("guarantorcode"));
		ds.setValue("torNameGu", bopExguLoadPage_dataset.getValue("torNameGu"));
		ds.setValue2("guarantype", bopExguLoadPage_dataset.getValue("guarantype"));
		ds.setValue("guarantypeName", bopExguLoadPage_dataset.getValue("guarantypeName"));
		ds.setValue("torEnnameGu", bopExguLoadPage_dataset.getValue("torEnnameGu"));
		ds.setValue("actiontype", bopExguLoadPage_dataset.getValue("actiontype"));
		ds.setValue("appdocuno", bopExguLoadPage_dataset.getValue("appdocuno"));
		ds.setValue("contractdate", bopExguLoadPage_dataset.getValue("contractdate"));
		ds.setValue("maturity", bopExguLoadPage_dataset.getValue("maturity"));
		ds.setValue2("guarancurr", bopExguLoadPage_dataset.getValue("guarancurr"));
		ds.setValue("guarancurrName", bopExguLoadPage_dataset.getValue("guarancurrName"));
		ds.setValue("guaranamount", bopExguLoadPage_dataset.getValue("guaranamount"));
		ds.setValue("maindebtamount", bopExguLoadPage_dataset.getValue("maindebtamount"));
		ds.setValue("remark", bopExguLoadPage_dataset.getValue("remark"));		
		ds.setValue2("maindebtcurr", bopExguLoadPage_dataset.getValue("maindebtcurr"));
		ds.setValue("maindebtcurrName", bopExguLoadPage_dataset.getValue("maindebtcurrName"));
		
		ds.setValue("filler1", bopExguLoadPage_dataset.getValue("recId"));
		closeWin();
	}

	function btConfirmBack_onClick(button){
		closeWin();
	}

</script>
</@CommonQueryMacro.page>