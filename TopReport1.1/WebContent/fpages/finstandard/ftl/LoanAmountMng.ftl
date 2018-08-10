<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="贷款发生额修改">
<@CommonQueryMacro.CommonQuery id="LoanAmountEdit" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="LoanAmountEditGroup" label="贷款发生额修改" 
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
            alert("金融机构编码不能为空");
            return false;
        }
        if (khlx == null || "" == khlx) {
            alert("客户类型不能为空");
            return false;
        }
        if (dkzthylx == null || "" == dkzthylx) {
            alert("借款人行业主题不能为空");
            return false;
        }
        if (cplb == null || "" == cplb) {
            alert("产品类别不能为空");
            return false;
        }
        if (dkffrq == null || "" == dkffrq) {
            alert("贷款发放日期不能为空");
            return false;
        }
        if (dkbz == null || "" == dkbz) {
            alert("贷款币种不能为空");
            return false;
        }
        if (dkfsje == null || "" == dkfsje) {
            alert("贷款发生金额不能为空");
            return false;
        }
        if (llsfgd == null || "" == llsfgd) {
            alert("利率是否固定不能为空");
            return false;
        }
        if (llsp == null || "" == llsp) {
            alert("利率水平不能为空");
            return false;
        }
        if (dkdbfs == null || "" == dkdbfs) {
            alert("贷款担保方式不能为空");
            return false;
        }
        if (dkzt == null || "" == dkzt) {
            alert("贷款状态不能为空");
            return false;
        }
        if (dkffshbz == null || "" == dkffshbz) {
            alert("贷款发放收回标志不能为空");
            return false;
        }
        
        return true;
    }

    //保存后刷新当前页
    function btQueryVerify_postSubmit(button) {
    	var sjrq = LoanAmountEdit_dataset.getValue("sjrq").format("yyyyMMdd");
		window.location.href="${contextPath}/fpages/finstandard/ftl/LoanAmountEntry.ftl?sjrq="+sjrq;
    	alert("记录修改成功！");
    }

	function btCancel_onClick(button) {
		var sjrq = LoanAmountEdit_dataset.getValue("sjrq").format("yyyyMMdd");
		window.location.href="${contextPath}/fpages/finstandard/ftl/LoanAmountEntry.ftl?sjrq="+sjrq;
	}
</script>
</@CommonQueryMacro.page>