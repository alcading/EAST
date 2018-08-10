<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="´û¿îÓà¶îÏêÇé">
<@CommonQueryMacro.CommonQuery id="LoanBalanceDtl" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="LoanBalanceDtlGroup" label="´û¿îÓà¶îÏêÇé" 
				fieldStr="sjrq,jrjgbm,khlx,jkrbm,dkzthylx,jkrzcdbm,qyczrjjcf,qygm,dkjjbh,cplb,dksjtx,dkffrq,dkdqrq,zqdqrq,dkbz,dkye,llsfgd,llsp,dkdbfs,dkzl,dkzt" 
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
		var sjrq = LoanBalanceDtl_dataset.getValue("sjrq").format("yyyyMMdd");
		window.location.href="${contextPath}/fpages/finstandard/ftl/LoanBalanceEntry.ftl?sjrq="+sjrq;
	}
</script>
</@CommonQueryMacro.page>