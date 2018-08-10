<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign op="${RequestParameters['op']?default('')}" />
<@CommonQueryMacro.page title="贷款余额修改">
<@CommonQueryMacro.CommonQuery id="LoanBalanceEdit" init="true">
 <table align="center" width="100%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id ="LoanBalanceEditGroup" label="贷款余额修改" 
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
            alert("金融机构编码不能为空");
            return false;
        }
        if (khlx == null || "" == khlx) {
            alert("客户类型不能为空");
            return false;
        }
        if (dkzthylx == null || "" == dkzthylx) {
            alert("贷款主题行业类型不能为空");
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
        if (dkdqrq == null || "" == dkdqrq) {
            alert("贷款到期日期不能为空");
            return false;
        }
        if (dkbz == null || "" == dkbz) {
            alert("贷款币种不能为空");
            return false;
        }
        if (dkye == null || "" == dkye) {
            alert("贷款余额不能为空");
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
        if (dkzl == null || "" == dkzl) {
            alert("贷款质量不能为空");
            return false;
        }
        
        return true;
    }

    //保存后刷新当前页
    function btQueryVerify_postSubmit(button) {
    	var sjrq = LoanBalanceEdit_dataset.getValue("sjrq").format("yyyyMMdd");
		window.location.href="${contextPath}/fpages/finstandard/ftl/LoanBalanceEntry.ftl?sjrq="+sjrq;
    	alert("记录修改成功！");
    }

	function btCancel_onClick(button) {
		var sjrq = LoanBalanceEdit_dataset.getValue("sjrq").format("yyyyMMdd");
		window.location.href="${contextPath}/fpages/finstandard/ftl/LoanBalanceEntry.ftl?sjrq="+sjrq;
	}
</script>
</@CommonQueryMacro.page>