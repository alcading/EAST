<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="�������޸�">
<@CommonQueryMacro.CommonQuery id="DepositBalanceEdit" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="DepositBalanceEditGroup" label="�������޸�" 
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
            alert("���ڻ������벻��Ϊ��");
            return false;
        }
        if (khlx == null || "" == khlx) {
            alert("�ͻ����Ͳ���Ϊ��");
            return false;
        }
        if (cplb == null || "" == cplb) {
            alert("��Ʒ�����Ϊ��");
            return false;
        }
        if (ckbz == null || "" == ckbz) {
            alert("�����ֲ���Ϊ��");
            return false;
        }
        if (ckye == null || "" == ckye) {
            alert("�������Ϊ��");
            return false;
        }
        if (llsfgd == null || "" == llsfgd) {
            alert("�����Ƿ�̶�����Ϊ��");
            return false;
        }
        
        return true;
    }

    //�����ˢ�µ�ǰҳ
    function btQueryVerify_postSubmit(button) {
    	alert("��¼�޸ĳɹ���");
    }

</script>
</@CommonQueryMacro.page>