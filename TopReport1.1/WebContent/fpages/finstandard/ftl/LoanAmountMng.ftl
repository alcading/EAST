<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="��������޸�">
<@CommonQueryMacro.CommonQuery id="LoanAmountEdit" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="LoanAmountEditGroup" label="��������޸�" 
				fieldStr="sjrq,jrjgbm,khlx,jkrbm,dkzthylx,jkrzcdbm,qyczrjjcf,qygm,dkjjbh,cplb,dksjtx,dkffrq,dkdqrq,dksjzzrq,dkbz,dkfsje,llsfgd,llsp,dkdbfs,dkzt,dkffshbz" 
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
		var sjrq = LoanAmountEdit_dataset.getValue("sjrq");
        var jkrbm = LoanAmountEdit_dataset.getValue("jkrbm");
        var dkjjbh = LoanAmountEdit_dataset.getValue("dkjjbh"); 
        var jrjgbm = LoanAmountEdit_dataset.getValue("jrjgbm");
        var khlx = LoanAmountEdit_dataset.getValue("khlx");
        var dkzthylx = LoanAmountEdit_dataset.getValue("dkzthylx");
        var cplb = LoanAmountEdit_dataset.getValue("cplb");
        var dkffrq = LoanAmountEdit_dataset.getValue("dkffrq");
        var dkdqrq = LoanAmountEdit_dataset.getValue("dkdqrq");
        var dksjzzrq = LoanAmountEdit_dataset.getValue("dksjzzrq");
        var dkbz = LoanAmountEdit_dataset.getValue("dkbz");
        var dkfsje = LoanAmountEdit_dataset.getValue("dkfsje");
        var llsfgd = LoanAmountEdit_dataset.getValue("llsfgd");
        var llsp = LoanAmountEdit_dataset.getValue("llsp");
        var dkdbfs = LoanAmountEdit_dataset.getValue("dkdbfs");
        var dkzt = LoanAmountEdit_dataset.getValue("dkzt");
        var dkffshbz = LoanAmountEdit_dataset.getValue("dkffshbz");
        
        LoanAmountEdit_dataset.setParameter("sjrq",sjrq);
		LoanAmountEdit_dataset.setParameter("jkrbm",jkrbm);
		LoanAmountEdit_dataset.setParameter("dkjjbh",dkjjbh);
    
        if (jrjgbm == null || "" == jrjgbm) {
            alert("���ڻ������벻��Ϊ��");
            return false;
        }
        if (khlx == null || "" == khlx) {
            alert("�ͻ����Ͳ���Ϊ��");
            return false;
        }
        if (dkzthylx == null || "" == dkzthylx) {
            alert("�������ҵ���ⲻ��Ϊ��");
            return false;
        }
        if (cplb == null || "" == cplb) {
            alert("��Ʒ�����Ϊ��");
            return false;
        }
        if (dkffrq == null || "" == dkffrq) {
            alert("��������ڲ���Ϊ��");
            return false;
        }
        if (dkbz == null || "" == dkbz) {
            alert("������ֲ���Ϊ��");
            return false;
        }
        if (dkfsje == null || "" == dkfsje) {
            alert("���������Ϊ��");
            return false;
        }
        if (llsfgd == null || "" == llsfgd) {
            alert("�����Ƿ�̶�����Ϊ��");
            return false;
        }
        if (llsp == null || "" == llsp) {
            alert("����ˮƽ����Ϊ��");
            return false;
        }
        if (dkdbfs == null || "" == dkdbfs) {
            alert("�������ʽ����Ϊ��");
            return false;
        }
        if (dkzt == null || "" == dkzt) {
            alert("����״̬����Ϊ��");
            return false;
        }
        if (dkffshbz == null || "" == dkffshbz) {
            alert("������ջر�־����Ϊ��");
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