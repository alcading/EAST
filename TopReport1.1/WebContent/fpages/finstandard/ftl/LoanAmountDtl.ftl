<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="贷款发生额详情">
<@CommonQueryMacro.CommonQuery id="LoanAmountDtl" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="LoanAmountDtlGroup" label="贷款发生额详情" 
				fieldStr="sjrq,jrjgbm,khlx,jkrbm,dkzthylx,jkrzcdbm,qyczrjjcf,qygm,dkjjbh,cplb,dksjtx,dkffrq,dkdqrq,dksjzzrq,dkbz,dkfsje,llsfgd,llsp,dkdbfs,dkzt,dkffshbz" 
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
</script>
</@CommonQueryMacro.page>