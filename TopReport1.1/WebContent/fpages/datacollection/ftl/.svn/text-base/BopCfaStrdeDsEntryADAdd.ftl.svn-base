<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean("bopCfaStrdeDsEntryADAdd")>
<#assign op=RequestParameters["op"]?default("")>
<#if op=="add">
	${CommonQueryConfig.setAnyValue("navigate","商业银行人民币结构性存款信息补录&gt; 签约信息 &gt; 新增")}
</#if>
<#if op=="mod">
	${CommonQueryConfig.setAnyValue("navigate","商业银行人民币结构性存款信息补录&gt; 签约信息 &gt; 修改")}
</#if>
<#if op=="del">
	${CommonQueryConfig.setAnyValue("navigate","商业银行人民币结构性存款信息补录&gt; 签约信息 &gt; 删除")}
</#if>
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsEntryADAdd" init="true"
insertOnEmpty="true" navigate="false">
<table width="72%" cellpadding="2">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td><@CommonQueryMacro.GroupBox id="groupbox1" label="基础信息"
						expand="true">
						<table frame="void" class="grouptable" width="100%">
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">人民币结构性存款编号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="strdecode"/></td>


								<td rowspan="1" align="right" nowrap class="labeltd">金融机构标识码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="branchcode"/></td>

							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">客户代码
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="clientcode"/></td>

								<td colspan="1" align="center" nowrap class="labeltd">客户名称
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="clientname"/></td>

							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">签约日期
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="contractdate"/></td>

								<td colspan="1" align="center" nowrap class="labeltd">合同号
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="contract"/></td>

							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">签约金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="contractamount"/></td>

								<td rowspan="1" align="center" nowrap class="labeltd">到期日
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="maturity"/></td>

							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">挂钩指标
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="lincame"/></td>

								<td align="center" nowrap class="labeltd">挂钩指标计算方法</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="lincamethod"/></td>

							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">约定的利率上限
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="aginraup"/></td>

								<td align="center" nowrap class="labeltd">约定的利率下限</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="aginralo"/></td>

							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">利息给付方式</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="aginraloinpay"/></td>

								<td colspan="1" align="center" nowrap class="labeltd">业务流水号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="filler2"/></td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">备注</td>
								<td class="datatd" colspan="3"><@CommonQueryMacro.SingleField
									fId="remark"/></td>
							</tr>
						</table> </@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>
		<td width="8px"></td>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0" style="display:none">
				<tr>
					<td><@CommonQueryMacro.GroupBox id="groupbox2" label="系统信息"
						expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">操作类型</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="actiontype"/></td>
							</tr>
							<tr>
								<td rowspan="1" align="right" nowrap class="labeltd">记录状态</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="recStatus"/></td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">审批状态
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="approveStatus"/>
								</td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">审批说明
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="approveResult"/>
								</td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">回执状态
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="repStatus"/>
								</td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">创建时间</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="crtTm"/></td>
							</tr>
								<td colspan="1" align="center" nowrap class="labeltd">最后修改时间</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="lstUpdTm"/></td>
							</tr>
						</table> </@CommonQueryMacro.GroupBox></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="left" colspan="3"><@CommonQueryMacro.Button
			id="btSave"/>&nbsp; &nbsp;<@CommonQueryMacro.Button id="btBack"/></td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var op = "${RequestParameters["op"]?default('')}";
	<#assign v_branchcode = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getBrno()>
	//系统信息只读
	function initCallGetter_post() {
		bopCfaStrdeDsEntryADAdd_dataset.setValue("branchcode","${v_branchcode}");
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("actiontype",true);
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("recStatus",true);
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("approveStatus",true);
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("approveResult",true);
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("repStatus",true);
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("crtTm",true);
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("lstUpdTm",true);
		//人民币结构性存款编号只读
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("strdecode",true);
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("branchcode",true);

	}
	function btBack_onClick() {
		closeWin();
	}

	//属性的只读统一设置
	if(op == "add") {
		bopCfaStrdeDsEntryADAdd_dataset.setFieldReadOnly("actiondesc",true);
	}
	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {
		if((op == "mod") || (op == "add")) return modClickCheck(button);
		if(op == "del") return delClickCheck(button);
		return true;
	}
	//新增的执行前检查
	//客户代码客户名称的校验待定
	function modClickCheck(button) {
	//需js中验证的字段[金融机构标识码],[客户代]码和[客户名称],[签约日期],[合同号]
		var branchcode = bopCfaStrdeDsEntryADAdd_dataset.getValue("branchcode");
		var contractdate = bopCfaStrdeDsEntryADAdd_dataset.getValue("contractdate");
		var contract = bopCfaStrdeDsEntryADAdd_dataset.getValue("contract");
		var maturity = bopCfaStrdeDsEntryADAdd_dataset.getValue("maturity");
		if(branchcode.length != 12) {
			alert("字段[金融机构标识码]必须是12为字符");
			return false;
		}
		if(contract.length != 32) {
			alert("合同号必须是32位");
			return false;
		}
		var currentdate = new Date();
		/*
		if((contractdate.getTime()-currentdate.getTime()) >= 0) {
			alert("签约日期不能早于当前日期");
			return false;
		}
		*/
		//到期日大于等于签约日期
		if((contractdate.getTime() - maturity.getTime()) > 0) {
			alert("到期日必须大于等于签约日期");
			return false;
		}
		var actiondesc = bopCfaStrdeDsEntryADAdd_dataset.getValue("actiondesc");
		var actiontype = bopCfaStrdeDsEntryADAdd_dataset.getValue("actiontype");
		if(actiontype == "D") {
			if(actiondesc == null || actiondesc == "") {
				alert("删除原因不能为空");
				return false;
			}
		}

		return true;
	}
	function delClickCheck(button) {
		var actiondesc = bopCfaStrdeDsEntryADAdd_dataset.getValue("actiondesc");
		if(actiondesc == null || actiondesc == "") {
			alert("字段[删除原因]不能为空");
			return false;
		}
		return true;
	}
	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}

</script>
</@CommonQueryMacro.page>
