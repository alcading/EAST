<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="����������">
<@CommonQueryMacro.CommonQuery id="DepositBalanceDtl" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="DepositBalanceDtlGroup" label="����������" 
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
    function btCancel_onClick() {
		closeWin();
	}
</script>
</@CommonQueryMacro.page>