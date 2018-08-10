<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="存款余额修改">
<@CommonQueryMacro.CommonQuery id="DepositBalanceEdit" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="DepositBalanceEditGroup" label="存款余额修改" 
				fieldStr="sjrq,jrjgbm,khlx,ckzhdm,ckxydm,cplb,ckxyqsrq,ckxydqrq,ckbz,ckye,llsfgd,llsp" 
        	    colNm=4/>
		</td>
	</tr>
	<tr >
		<td  align="center">
	  		<@CommonQueryMacro.Button id="btQueryVerify" />
		 	&nbsp;&nbsp;&nbsp;&nbsp;
			<@CommonQueryMacro.Button id="btCancel" />
	  	</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
    
    function btQueryVerify_onClickCheck(button) {
		var sjrq = DepositBalanceEdit_dataset.getValue("sjrq");
        var jrjgbm = DepositBalanceEdit_dataset.getValue("jrjgbm");
        var ckzhdm = DepositBalanceEdit_dataset.getValue("ckzhdm"); 
        var ckxydm = DepositBalanceEdit_dataset.getValue("ckxydm");
        var khlx = DepositBalanceEdit_dataset.getValue("khlx");
        var cplb = DepositBalanceEdit_dataset.getValue("cplb");
        var ckxyqsrq = DepositBalanceEdit_dataset.getValue("ckxyqsrq");
        var ckxydqrq = DepositBalanceEdit_dataset.getValue("ckxydqrq");
        var ckbz = DepositBalanceEdit_dataset.getValue("ckbz");
        var ckye = DepositBalanceEdit_dataset.getValue("ckye");
        var llsfgd = DepositBalanceEdit_dataset.getValue("llsfgd");
        var llsp = DepositBalanceEdit_dataset.getValue("llsp");
        
        DepositBalanceEdit_dataset.setParameter("sjrq",sjrq);
		DepositBalanceEdit_dataset.setParameter("ckzhdm",ckzhdm);
    
        if (jrjgbm == null || "" == jrjgbm) {
            alert("金融机构编码不能为空");
            return false;
        }
        if (khlx == null || "" == khlx) {
            alert("客户类型不能为空");
            return false;
        }
        if (cplb == null || "" == cplb) {
            alert("产品类别不能为空");
            return false;
        }
        if (ckbz == null || "" == ckbz) {
            alert("存款币种不能为空");
            return false;
        }
        if (ckye == null || "" == ckye) {
            alert("存款余额不能为空");
            return false;
        }
        if (llsfgd == null || "" == llsfgd) {
            alert("利率是否固定不能为空");
            return false;
        }
        
        return true;
    }

    //保存后刷新当前页
    function btQueryVerify_postSubmit(button) {
    	alert("记录修改成功！");
    }

</script>
</@CommonQueryMacro.page>