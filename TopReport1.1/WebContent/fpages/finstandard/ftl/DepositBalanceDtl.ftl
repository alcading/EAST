<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="´æ¿îÓà¶îÏêÇé">
<@CommonQueryMacro.CommonQuery id="DepositBalanceDtl" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="DepositBalanceDtlGroup" label="´æ¿îÓà¶îÏêÇé" 
				fieldStr="sjrq,jrjgbm,khlx,ckzhdm,ckxydm,cplb,ckxyqsrq,ckxydqrq,ckbz,ckye,llsfgd,llsp" 
        	    colNm=4/>
		</td>
	</tr>
	<tr >
		<td  align="center">
			<@CommonQueryMacro.Button id="btCancel" />
	  	</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
    function btCancel_onClick(button) {
		var sjrq = DepositBalanceDtl_dataset.getValue("sjrq").format("yyyyMMdd");
		window.location.href="${contextPath}/fpages/finstandard/ftl/DepositBalanceEntry.ftl?sjrq="+sjrq;
	}
</script>
</@CommonQueryMacro.page>