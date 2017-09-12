<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="变动信息">
	<@CommonQueryMacro.CommonQuery id="BopCfaDofoexloDsChangeInfoAdd" init="true" submitMode="current" navigate="false" >
		<table width="90%">

			<tr>
				<td width="65%" valign="top">

					<@CommonQueryMacro.GroupBox id="guoup1" label="签约信息" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd" colspan="2">国内外汇贷款编号</td>
								<td class="datatd" >
									<@CommonQueryMacro.SingleField fId="dofoexlocode"/>
									<#assign op=RequestParameters["op"]?default("")>
									<#if op=="new">
										<@CommonQueryMacro.Button id="btSearch"/>&nbsp;&nbsp;
									</#if>
								</td>
								<td rowspan="2" align="center" nowrap class="labeltd" >债务人</td>
								<td align="center" nowrap class="labeltd">债务人代码</td>
								<td  class="datatd"> <@CommonQueryMacro.SingleField fId="debtorcode" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" colspan="2">债权人代码</td>
								<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="creditorcode" /></td>
								<td align="center" nowrap class="labeltd" >债务人中文名称</td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="debtorname" /></td>
							</tr>
							<tr>
								<td rowspan="4" align="center" nowrap class="labeltd" >签约</td>
								<td align="center" nowrap class="labeltd">起息日</td>
								<td  class="datatd"> <@CommonQueryMacro.SingleField fId="valuedate" /></td>

								<td rowspan="3" align="center" nowrap class="labeltd" >贷款类型</td>
								<td align="center" nowrap class="labeltd" >国内外汇贷款类型</td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="dofoexlotype" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">到期日</td>
								<td  class="datatd"> <@CommonQueryMacro.SingleField fId="maturity" /></td>

								<td align="center" nowrap class="labeltd" >转贷项目名称</td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="lenproname" /></td>
							</tr>

							<tr>
								<td align="center" nowrap class="labeltd">贷款币种</td>
								<td  class="datatd"> <@CommonQueryMacro.SingleField fId="currence" /></td>

								<td align="center" nowrap class="labeltd" >转贷协议号</td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="lenagree" /></td>


							</tr>

							<tr>
								<td align="center" nowrap class="labeltd">签约金额</td>
								<td  class="datatd"> <@CommonQueryMacro.SingleField fId="contractamount" /></td>

								<td align="center" nowrap class="labeltd" colspan="2">年化利率值</td>
								<td class="datatd" > <@CommonQueryMacro.SingleField fId="anninrate" /></td>

							</tr>

						</table>
					</@CommonQueryMacro.GroupBox>

					<@CommonQueryMacro.GroupBox id="basicinfo" label="变动信息" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd" colspan="2">银行业务参号</td>
								<td class="datatd">
									<@CommonQueryMacro.SingleField fId="buscode"/>
								</td>
								<td align="center" nowrap class="labeltd" colspan="2">变动编号</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="changeno"/></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" colspan="2">变动日期</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="changedate"/></td>

								<td rowspan="2" align="center" nowrap class="labeltd">提款信息</td>
								<td align="center" nowrap class="labeltd">提款币种</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="withcurrence"/></td>

							</tr>
							<tr>

								<td align="center" nowrap class="labeltd" colspan="2">资金用途</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="useofunds"/></td>

								<td align="center" nowrap class="labeltd">提款金额</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="withamount"/></td>
							</tr>

							<tr>
								<td align="center" nowrap class="labeltd" colspan="2">期初余额</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="loanopenbalan"/></td>


								<td align="center" nowrap class="labeltd" colspan="2">期末余额</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="endbalan"/></td>

							</tr>

							<tr>
								<td rowspan="3" align="center" nowrap class="labeltd" >还本信息</td>
								<td align="center" nowrap class="labeltd" >还本币种</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="princurr"/></td>

								<td rowspan="3" align="center" nowrap class="labeltd" >付息信息</td>
								<td align="center" nowrap class="labeltd" >付息币种</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="inpaycurr"/></td>


							</tr>

							<tr>
								<td align="center" nowrap class="labeltd" >还本金额</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="repayamount"/></td>

								<td align="center" nowrap class="labeltd" >付息金额</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="inpayamount"/></td>

							</tr>

							<tr>
								<td align="center" nowrap class="labeltd">购汇还本金额</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="prepayamount"/></td>

								<td align="center" nowrap class="labeltd">购汇付息金额</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="pinpayamount"/></td>

							</tr>

							<tr>

								<td align="center" nowrap class="labeltd" colspan="2">结汇金额</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="settamount"/></td>

								<td align="center" nowrap class="labeltd" colspan="2">业务流水号</td>
								<td align="center" nowrap class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>


							</tr>

							<tr>
								<td align="center" nowrap class="labeltd" colspan="2">备注</td>
								<td align="center" nowrap class="datatd" colspan="4"><@CommonQueryMacro.SingleField fId="remark"/></td>

							</tr>

						</table>
					</@CommonQueryMacro.GroupBox>
				</td>

				<td width="8px"></td>
				<td width="35%"  valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>

								<#assign op=RequestParameters["op"]?default("")>
								<#if op!="new">
									<@CommonQueryMacro.GroupBox id="guoup3" label="系统信息" expand="true">
										<table frame=void class="grouptable" width="100%">
											<tr>
												<td align="center" nowrap class="labeltd" width="25%">操作类型</td>
												<td nowrap class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="actiontype" /></td>
											</tr>
											<tr>
												<td  align="center" nowrap class="labeltd" width="25%">记录状态</td>
												<td class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="recStatus" /></td>
											</tr>
											<tr>
												<td align="center" nowrap class="labeltd">审批状态</td>
												<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="approveStatus" /></td>
											</tr>

											<tr>
												<td align="center" nowrap class="labeltd">审批结果</td>
												<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="approveResult" /></td>
											</tr>

											<tr>
												<td align="center" nowrap class="labeltd">回执状态</td>
												<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a></td>
											</tr>
											<tr>
												<td align="center" nowrap class="labeltd">创建时间</td>
												<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="crtTm" /></td>
											</tr>
											<tr>
												<td align="center" nowrap class="labeltd" >最后更新时间</td>
												<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm" /></td>
											</tr>
										</table>
									</@CommonQueryMacro.GroupBox>

									<@CommonQueryMacro.GroupBox id="guoup4" label="删除原因" expand="true">
										<table frame=void class="grouptable" width="100%">
											<tr>
												<td align="center" nowrap class="labeltd" width="25%"> 删除原因 </td>
												<td class="datatd" width="75%"> <@CommonQueryMacro.SingleField fId="actiondesc" /></td>
											</tr>
										</table>
									</@CommonQueryMacro.GroupBox>
								</#if>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td align="left">
					<#assign op=RequestParameters["op"]?default("")>
					<#if op!="detail">
						<@CommonQueryMacro.Button id="btSave"/>&nbsp;&nbsp;
					</#if>
					<@CommonQueryMacro.Button id="btBack"/>
				</td>
			</tr>
		</table>

		<@CommonQueryMacro.WindowElement skin="web" />

		<script language="JavaScript">
			var op = "${RequestParameters["op"]?default('')}";

			function doRepDet() {
				var id = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("id");
				var appType = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("appType");
				var currentfile = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("currentfile");
				var busiCode = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("dofoexlocode");
				showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
			}

			//当页面初始化完之后可以调用该方法执行需要处理的操
			function initCallGetter_post(dataset) {
				if("new" != op) {
					var repStatus = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("repStatus");
					if (repStatus != "02") {
						document.getElementById("repHerf").href="#";
						document.getElementById("repHerf").style.color="#999999";
					}
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("actiontype",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("recStatus",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("approveStatus",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("approveResult",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("crtTm",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("lstUpdTm",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("changeno",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("repStatus",true);
				}
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("changeno",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("dofoexlocode",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("debtorcode",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("creditorcode",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("debtorname",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("valuedate",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("dofoexlotype",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("maturity",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("lenproname",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("currence",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("lenagree",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("contractamount",true);
				BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("anninrate",true);

				if ("new" == op) {
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("actiondesc",true);
				}

				if ("mod" == op) {
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("buscode",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("actiondesc",true);
				}

				if ("del" == op || "detail" == op) {
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("dofoexlocode",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("changeno",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("buscode",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("withcurrence",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("changedate",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("withamount",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("loanopenbalan",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("endbalan",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("useofunds",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("settamount",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("princurr",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("inpaycurr",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("repayamount",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("pinpayamount",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("remark",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("prepayamount",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("inpayamount",true);
					BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("filler2",true);


					if("detail" == op) {
						BopCfaDofoexloDsChangeInfoAdd_dataset.setFieldReadOnly("actiondesc",true);
					}
				}
			}

			function btSearch_onClick()	{
				loadPage();
			}

			function btBack_onClick() {
				closeWin(true);
			}

			//弹出账户信息选择框
			function loadPage(){
				showPickup("签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopCfaDofoexloDsLoadPage.ftl");
			}

			function btSave_postSubmit(button){
				alert("保存成功！");
				closeWin(true);
			}

			function btSave_onClickCheck(button) {
				if (!BopCfaDofoexloDsChangeInfoAdd_dataset.modified) {
					alert("请先修改后再保存！");
					return false;
				}

				var dofoexlocode = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("dofoexlocode");
				var actiontype = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("actiontype");
				var actiondesc = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("actiondesc");
				var withamount = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("withamount");
				var withcurrence = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("withcurrence");
				var settamount = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("settamount");
				var useofunds = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("useofunds");
				var repayamount = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("repayamount");
				var prepayamount = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("prepayamount");
				var inpayamount =  BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("inpayamount");
				var pinpayamount = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("pinpayamount");
				var inpaycurr = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("inpaycurr");

				if ("D" == actiontype && "" == actiondesc) {
					alert("[操作类型]为[删除], [删除原因]必须填写");
					return false;
				}
				if (("C" == actiontype || "A" == actiontype) && "" != actiondesc) {
					alert("[操作类型]为[新增或修改], [删除原因]无须填写");
					return false;
				}

				if ("del" != op) {
					if("" == dofoexlocode || null == dofoexlocode){
						alert("[国内外汇贷款编号]不能为空");
						return false;
					}

					if(parseFloat(withamount) > 0 && "" == withcurrence) {
						alert("[提款金额 > 0], [提款币种] 必须填写");
						return false;
					}

					if (0 < parseFloat(withamount) || 0 < parseFloat(settamount)) {
						if ("" == useofunds) {
							alert("[提款金额]或[结汇金额]大于0时,[资金用途]必须填写");
							return false;
						}
					}

					if(0 < parseFloat(repayamount)) {
						var princurr = BopCfaDofoexloDsChangeInfoAdd_dataset.getValue("princurr");
						if("" == princurr){
							alert("[还本金额]大于0时,[还本币种]必须填写");
							return false;
						}
					}

					if(parseFloat(prepayamount) > parseFloat(repayamount)){
						alert("[购汇还本金额]必须小于等于[还本金额]");
						return false;
					}

					if(parseFloat(inpayamount) < parseFloat(pinpayamount)){
						alert("[购汇付息金额],必须小于等于[付息金额]");
						return false;
					}

					if(0 < parseFloat(inpayamount) || 0 < parseFloat(pinpayamount)){
						if ("" == inpaycurr) {
							alert("[付息金额]或[购汇付息金额]>0,[付息币种]必填");
							return false;
						}
					}
				}
				return true;
			}
		</script>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>