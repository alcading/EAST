<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean("bopCfaStrdeDsEntryInpayAdd")>
<#assign op=RequestParameters["op"]?default("")>
<#if op=="mod">
	${CommonQueryConfig.setAnyValue("navigate","商业银行人民币结构性存款信息补录&gt; 终止信息 &gt; 修改")}
</#if>
<#if op=="del">
	${CommonQueryConfig.setAnyValue("navigate","商业银行人民币结构性存款信息补录&gt; 终止信息 &gt; 删除")}
</#if>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsEntryInpayAdd" init="true" insertOnEmpty="true" navigate="false">
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
								<@CommonQueryMacro.Group id ="groupbox1" label="利息给付信息"
									fieldStr="inpaycode,inpaymonth,inpayrmbam,inpaycurr,inpaycurram,filler2,remark1" colNm=4/>
							</td>
						</tr>
					</table>
				</td>

				<td width="8px"></td>
				<td valign="top">
					<table width="80%" cellpadding="0" cellspacing="0">
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
											<td colspan="1" class="datatd"><@CommonQueryMacro.SingleField
												fId="actiondesc"/></td>
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
					<td align="left" colspan="3"><@CommonQueryMacro.Button id="btSave"/>&nbsp; &nbsp;<@CommonQueryMacro.Button id="btBack"/></td>
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
	var ds = bopCfaStrdeDsEntryInpayAdd_dataset;
	//系统信息和签约信息只读
	function initCallGetter_post() {
		//回执显示
		var repStatus = ds.getValue("repStatus");
		if("00" == repStatus) {
			document.getElementById("repHref").href = "#";
			document.getElementById("repHref").style.color = "#999999";
		}
		ds.setFieldReadOnly("actiontype",true);
		ds.setFieldReadOnly("recStatus",true);
		ds.setFieldReadOnly("approveStatus",true);
		ds.setFieldReadOnly("approveResult",true);
		ds.setFieldReadOnly("repStatus",true);
		ds.setFieldReadOnly("crtTm",true);
		ds.setFieldReadOnly("lstUpdTm",true);
		//签约信息只读
		ds.setFieldReadOnly("strdecode",true);
		ds.setFieldReadOnly("branchcode",true);
		ds.setFieldReadOnly("clientcode",true);
		ds.setFieldReadOnly("clientname",true);
		ds.setFieldReadOnly("contractdate",true);
		ds.setFieldReadOnly("contract",true);
		ds.setFieldReadOnly("contractamount",true);
		ds.setFieldReadOnly("maturity",true);
		ds.setFieldReadOnly("lincame",true);
		ds.setFieldReadOnly("lincamethod",true);
		ds.setFieldReadOnly("aginraup",true);
		ds.setFieldReadOnly("aginralo",true);
		ds.setFieldReadOnly("aginraloinpay",true);
		ds.setFieldReadOnly("remark",true);
		//付息编号只读
		ds.setFieldReadOnly("inpaycode",true);
	}
	function btBack_onClick() {
		closeWin();
	}

	if(op == "del") {
		ds.setFieldReadOnly("inpaycode",true);
		ds.setFieldReadOnly("inpaymonth",true);
		ds.setFieldReadOnly("inpayrmbam",true);
		ds.setFieldReadOnly("inpaycurr",true);
		ds.setFieldReadOnly("inpaycurram",true);
		ds.setFieldReadOnly("terpaycurr",true);
		ds.setFieldReadOnly("terpaycurram",true);
		ds.setFieldReadOnly("filler2",true);
		ds.setFieldReadOnly("remark1",true);
	}
	if(op == "detail") {
		ds.setFieldReadOnly("inpaycode",true);
		ds.setFieldReadOnly("inpaymonth",true);
		ds.setFieldReadOnly("inpayrmbam",true);
		ds.setFieldReadOnly("inpaycurr",true);
		ds.setFieldReadOnly("inpaycurram",true);
		ds.setFieldReadOnly("terpaycurr",true);
		ds.setFieldReadOnly("terpaycurram",true);
		ds.setFieldReadOnly("remark1",true);
		ds.setFieldReadOnly("remark",true);
		bopCfaStrdeDsEntryInpayAdd_dataset.setFieldReadOnly("filler2",true);
		ds.setFieldReadOnly("actiondesc",true);
	}
	if(op == "mod") {
		ds.setFieldReadOnly("actiondesc",true);
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
	//需js中验证的字段
		var strdecode = ds.getValue("strdecode");
		var inpaymonth = ds.getValue("inpaymonth");//付息年月
		var inpaycode = ds.getValue("inpaycode");//付息编号
		var inpayrmbam = ds.getString("inpayrmbam");//付息人民币支付金额
		var inpaycurram = ds.getString("inpaycurram");//付息外币支付金额
		var inpaycurr = ds.getValue("inpaycurr");//付息外币支付币种
		if(strdecode == null || strdecode == "") {
			alert("请先选择人民币结构性存款编号");
			return false;
		}
		if(inpaycode.length != 4) {
			alert("字段[付息编号]必须是4位字符");
			return false;
		}
		if(inpaymonth == null || inpaymonth == "") {
			alert("请选择付息年月");
			return false;
		}
		if(inpayrmbam.length == 0 && inpaycurram.length == 0) {
			alert("付息人民币支付金额与付息外币支付金额至少填一个。");
			return false;
		}
		//终止外币支付币种和终止外币支付金额为一组数据，两者同时为空或者不为空。 inpaycurr inpaycurr
		if((inpaycurr.length == 0 && inpaycurram.length != 0) || (inpaycurr.length != 0 && inpaycurram.length == 0)) {
			alert("付息人民币支付金额与付息外币支付金额必须同时为空或者不为空");
			return false;
		}
		return true;
	}

	function delClickCheck(button) {
		var actiondesc = ds.getValue("actiondesc");
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
		var id = ds.getValue("id");
		var appType = ds.getValue("appType");
		var currentfile = ds.getValue("currentfile");
		var busiCode =  ds.getValue("strdecode");
		showPickup("审核结果","${contextPath}/fpages/commonloadpage/ftl/ReportApproveResult.ftl?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile +"&busiCode="+busiCode,440,220);
	}
	function doRepDet(){
		var id = ds.getValue("id");
		var appType = ds.getValue("appType");
		var currentfile = ds.getValue("currentfile");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile, 600, 500);
	}

</script>
</@CommonQueryMacro.page>
