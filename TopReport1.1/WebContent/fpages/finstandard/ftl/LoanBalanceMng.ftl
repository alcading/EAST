<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="��������޸�">
<@CommonQueryMacro.CommonQuery id="LoanBalanceEdit" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="LoanBalanceEditGroup" label="��������޸�" 
				fieldStr="sjrq,jrjgbm,khlx,jkrbm,dkzthylx,jkrzcdbm,qyczrjjcf,qygm,dkjjbh,cplb,dksjtx,dkffrq,dkdqrq,zqdqrq,dkbz,dkye,llsfgd,llsp,dkdbfs,dkzl,dkzt" 
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
		var sjrq = LoanBalanceEdit_dataset.getValue("sjrq");
        var jkrbm = LoanBalanceEdit_dataset.getValue("jkrbm");
        var dkjjbh = LoanBalanceEdit_dataset.getValue("dkjjbh"); 
        var jrjgbm = LoanBalanceEdit_dataset.getValue("jrjgbm");
        var khlx = LoanBalanceEdit_dataset.getValue("khlx");
        var dkzthylx = LoanBalanceEdit_dataset.getValue("dkzthylx");
        var cplb = LoanBalanceEdit_dataset.getValue("cplb");
        var dkffrq = LoanBalanceEdit_dataset.getValue("dkffrq");
        var dkdqrq = LoanBalanceEdit_dataset.getValue("dkdqrq");
        var zqdqrq = LoanBalanceEdit_dataset.getValue("zqdqrq");
        var dkbz = LoanBalanceEdit_dataset.getValue("dkbz");
        var dkye = LoanBalanceEdit_dataset.getValue("dkye");
        var llsfgd = LoanBalanceEdit_dataset.getValue("llsfgd");
        var llsp = LoanBalanceEdit_dataset.getValue("llsp");
        var dkdbfs = LoanBalanceEdit_dataset.getValue("dkdbfs");
        var dkzt = LoanBalanceEdit_dataset.getValue("dkzt");
        var dkzl = LoanBalanceEdit_dataset.getValue("dkzl");
        
        LoanBalanceEdit_dataset.setParameter("sjrq",sjrq);
		LoanBalanceEdit_dataset.setParameter("jkrbm",jkrbm);
		LoanBalanceEdit_dataset.setParameter("dkjjbh",dkjjbh);
    
        if (jrjgbm == null || "" == jrjgbm) {
            alert("���ڻ������벻��Ϊ��");
            return false;
        }
        if (khlx == null || "" == khlx) {
            alert("�ͻ����Ͳ���Ϊ��");
            return false;
        }
        if (dkzthylx == null || "" == dkzthylx) {
            alert("����������ҵ���Ͳ���Ϊ��");
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
        if (dkdqrq == null || "" == dkdqrq) {
            alert("��������ڲ���Ϊ��");
            return false;
        }
        if (dkbz == null || "" == dkbz) {
            alert("������ֲ���Ϊ��");
            return false;
        }
        if (dkye == null || "" == dkye) {
            alert("��������Ϊ��");
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
        if (dkzl == null || "" == dkzl) {
            alert("������������Ϊ��");
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