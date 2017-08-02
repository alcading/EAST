<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean("bopCfaStrdeDsEntryTerminateAdd")>
<#assign op=RequestParameters["op"]?default("")>
<#if op=="mod">
	${CommonQueryConfig.setAnyValue("navigate","商业银行人民币结构性存款信息补录&gt; 终止信息 &gt; xxx修改")}
</#if>
<#if op=="del">
	${CommonQueryConfig.setAnyValue("navigate","商业银行人民币结构性存款信息补录&gt; 终止信息 &gt; yyy删除")} 
</#if> 
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsEntryTerminateAdd" init="true" insertOnEmpty="true" navigate="false">
<table width="97%" cellpadding="2">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox1" label="签约信息" expand="true">
							<table frame="void" class="grouptable" width="100%">
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">人民币结构性存款编号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="strdecode"/></td>
									<td rowspan="1" align="right" nowrap class="labeltd">金融机构标识码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="branchcode"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">客户代码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="clientcode"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">客户名称</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="clientname"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">签约日期</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="contractdate"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">合同号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="contract"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">签约金额</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="contractamount"/></td>
									<td rowspan="1" align="center" nowrap class="labeltd">到期日</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="maturity"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">挂钩指标</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="lincame"/></td>
									<td align="center" nowrap class="labeltd">挂钩指标计算方法</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="lincamethod"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">约定的利率上限</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="aginraup"/></td>
									<td align="center" nowrap class="labeltd">约定的利率下限</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="aginralo"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">利息给付方式</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="aginraloinpay"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">备注</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="remark"/></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>

				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox1" label="终止信息" expand="true">
							<table frame="void" class="grouptable" width="100%">
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">终止类型</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="tertype"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">终止支付编号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="terpaycode"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">终止日期</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="terdate"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">终止支付金额合计折人民币</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="terpayamtormb"/></td>
								</tr>
								<tr>
									<td rowspan="1" align="center" nowrap class="labeltd">终止人民币支付金额</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="terrmbpayam"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">终止外币支付币种</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="terpaycurr"/></td>
								</tr>
								<tr>
									<td align="center" nowrap class="labeltd">终止外币支付金额</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="terpaycurram"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">业务流水号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">备注</td>
									<td class="datatd" colspan="3"><@CommonQueryMacro.SingleField fId="remark1"/></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>

		<td width="8px"></td>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox2" label="系统信息" expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">操作类型</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="actiontype"/></td>
								</tr>
								<tr>
									<td rowspan="1" align="right" nowrap class="labeltd">记录状态</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="recStatus"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">审批状态</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="approveStatus"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">审批说明</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="approveResult"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">回执状态</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="repStatus"/>
										<a id="repHref" href="javascript:doRepDet()">回执结果</a>
									</td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">创建时间</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="crtTm"/></td>
								</tr>
									<td colspan="1" align="center" nowrap class="labeltd">最后修改时间</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm"/></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>

				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox3" label="删除信息" expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">删除原因</td>
									<td colspan="1" class="datatd"><@CommonQueryMacro.SingleField fId="actiondesc"/></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<#assign op=RequestParameters["op"]?default("")>
	<#if op!="detail">
	<tr>
		<td align="left" colspan="3">
			<@CommonQueryMacro.Button id="btSave"/>&nbsp; &nbsp;
			<@CommonQueryMacro.Button id="btBack"/>
		</td>
	</tr>
	</#if>
	<#if op="detail">
		<tr>
			<td align="left" colspan="3"><@CommonQueryMacro.Button id="btBack"/></td>
		</tr>
	</#if>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var op = "${RequestParameters["op"]?default('')}";
	//系统信息和签约信息只读
	function initCallGetter_post() {
	//回执样式
		var repStatus = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("repStatus");
		if("00" == repStatus) {
			document.getElementById("repHref").href="#";
			document.getElementById("repHref").style.color = "#999999";
		}
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("actiontype",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("recStatus",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("approveStatus",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("approveResult",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("repStatus",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("crtTm",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("lstUpdTm",true);
		//签约信息只读
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("strdecode",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("branchcode",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("clientcode",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("clientname",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("contractdate",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("contract",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("contractamount",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("maturity",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("lincame",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("lincamethod",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("aginraup",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("aginralo",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("aginraloinpay",true);
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("remark",true);
		//终止支付编号只读
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpaycode",true);

		if(op == "del") {
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("branchcode",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("tertype",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpaycode",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terdate",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpayamtormb",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terrmbpayam",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpaycurr",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpaycurram",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("remark",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("filler2",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("remark1",true);
		}
		if(op == "detail") {
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("branchcode",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("tertype",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpaycode",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terdate",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpayamtormb",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terrmbpayam",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpaycurr",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpaycurram",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("remark",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("remark1",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("filler2",true);
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("actiondesc",true);

		}
		if(op == "mod") {
			bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("actiondesc",true);
		}

	}
	function btBack_onClick() {
		closeWin(true);
	}


	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {
		if((op == "mod") || (op == "add")) return modClickCheck(button);
		if(op == "del") return delClickCheck(button);
		return true;
	}

	//修改的执行前检查
	//客户代码客户名称的校验待定
	function modClickCheck(button) {
	//需js中验证的字段[金融机构标识码],[终止支付编码]码和[合同号],[终止支付外币金额]等
		var branchcode = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("branchcode");
		var terpaycode = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("terpaycode");
		var contract = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("contract");
		var terpayamtormb = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("terpayamtormb");
		var terpaycurram = bopCfaStrdeDsEntryTerminateAdd_dataset.getString("terpaycurram");
		var terpaycurr = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("terpaycurr");
		var terrmbpayam = bopCfaStrdeDsEntryTerminateAdd_dataset.getString("terrmbpayam");
		if(branchcode.length != 12) {
			alert("字段[金融机构标识码]必须是12为字符");
			return false;
		}
		if(terpaycode.length != 4) {
			alert("字段[终止支付编码]必须是4位字符");
			return false;
		}
		if(contract.length > 32) {
			alert("合同号必须小于等于32位");
			return false;
		}
		if(terrmbpayam.length == 0 && terpaycurram.length == 0) {
			alert("终止人民币支付金额与终止外币支付金额至少填一个。");
			return false;
		}
		//终止外币支付币种和终止外币支付金额为一组数据，两者同时为空或者不为空。 terpaycurr terpaycurram
		if((terpaycurr.length == 0 && terpaycurram.length != 0) || (terpaycurr.length != 0 && terpaycurram.length == 0)) {
			alert("终止外币支付币种和终止外币支付金额必须同时为空或者不为空");
			return false;
		}
		return true;
	}

	function delClickCheck(button) {
		var actiondesc = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("actiondesc");
		if(actiondesc == null || actiondesc == "") {
			alert("字段[删除原因]不能为空");
			return false;
		}
		return true;
	}

	function btSave_postSubmit(button){
		if(op == "mod") {
			alert("保存成功！");
		}
		if(op == "del") {
			alert("删除成功");
		}
		closeWin(true);
	}

	function doApproveDet(){
		var id = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("id");
		var appType = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("appType");
		var currentfile = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("currentfile");
		var busiCode =  bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("strdecode");
		showPickup("审核结果","${contextPath}/fpages/commonloadpage/ftl/ReportApproveResult.ftl?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile +"&busiCode="+busiCode,440,220);
	}
	function doRepDet(){
		var id = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("id");
		var appType = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("appType");
		var currentfile = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("currentfile");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile, 600, 500);
	}

</script>
</@CommonQueryMacro.page>
