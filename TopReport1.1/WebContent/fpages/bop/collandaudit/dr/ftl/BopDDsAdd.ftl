<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="基础信息">
<@CommonQueryMacro.CommonQuery id="BopDDsAdd" init="true" insertOnEmpty="true" navigate="false">
<table width="90%" cellpadding="2">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td><@CommonQueryMacro.GroupBox id="groupbox1" label="基础信息"
						expand="true">
						<table frame="void" class="grouptable" width="100%">
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">申报号码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="rptno"/></td>
																		
								<td colspan="2" align="center" nowrap class="labeltd">付款人名称</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="oppuser"/></td>		
							</tr>
							<tr>
							    <td colspan="1" rowspan="4" align="center" nowrap class="labeltd">收款人信息</td>
							    <td rowspan="1" align="right" nowrap class="labeltd">收款人类型</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="custype"/></td>
								
								<td colspan="1" rowspan="3" align="center" nowrap class="labeltd">结汇信息</td>
                                <td colspan="1" align="center" nowrap class="labeltd">人民币帐号/银行卡号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyacc"/></td>								
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">收款人名称</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="custnm"/></td>
									
                                <td align="center" nowrap class="labeltd">结汇金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyamt"/></td>
								
							</tr>
							<tr>
							    <td colspan="1"  align="center" nowrap class="labeltd">个人身份证件号码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="idcode"/></td>
							  								
                                <td colspan="1" align="center" nowrap class="labeltd">结汇汇率</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="exrate"/></td> 
								
							</tr>
							<tr>
							    <td colspan="1" align="center" nowrap class="labeltd">组织机构代码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="custcod"/></td>
								 
								<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">现汇信息</td>	
                                <td colspan="1" align="center" nowrap class="labeltd">外汇帐号/银行卡号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyacc"/></td>	
								
							</tr>
							<tr>
								<td colspan="1" rowspan="3" align="center" nowrap class="labeltd">收入款信息</td>
								
                                <td rowspan="1" align="center" nowrap class="labeltd">收入款金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txamt"/></td>
								
								<td align="center" colspan="1" nowrap class="labeltd">现汇金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyamt"/></td>

							</tr>							
							<tr>					
								<td rowspan="1" align="center" nowrap class="labeltd">收入款币种</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txccy"/></td>
								
								<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">其它信息</td>
								<td colspan="1" align="center" nowrap class="labeltd">其它帐号/银行卡号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="othacc"/></td>						
							</tr>
							<tr>
													
							    <td colspan="1" align="center" nowrap class="labeltd">结算方式</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="method"/></td>	
								
								<td colspan="1" align="center" nowrap class="labeltd">其它金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="othamt"/></td>																			
							</tr>							
							<tr>	
							    <td colspan="1" rowspan="2" align="center" nowrap class="labeltd">国内银行扣费信息</td>	
								<td colspan="1" align="center" nowrap class="labeltd">国内银行扣费金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="inchargeamt"/></td>
	
								<td colspan="2" align="center" nowrap class="labeltd">银行业务编号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="buscode"/></td>
							</tr>							
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">国内银行扣费币种</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="inchargeccy"/></td>	
                                
								<td colspan="2" align="center" nowrap class="labeltd">业务流水号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
							</tr>
							
						</table> </@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>
		<td width="25%" valign="top">
										<table width="100%" cellpadding="0" cellspacing="0">
											<tr>
												<td id="xitong">
													<@CommonQueryMacro.GroupBox id="guoup3" label="系统信息" expand="true">
														<table frame=void class="grouptable" width="100%">
															<tr>
																<td align="center" nowrap class="labeltd" width="25%">操作类型</td>
																<td nowrap class="datatd" width="25%">
																	<@CommonQueryMacro.SingleField fId="actiontype" />
																</td>
															</tr>

															<tr>
																<td align="center" nowrap class="labeltd" width="25%">记录状态</td>
																<td class="datatd" width="25%">
																	<@CommonQueryMacro.SingleField fId="recStatus" />
																</td>
															</tr>

															<tr>
																<td align="center" nowrap class="labeltd">审批状态</td>
																<td nowrap class="datatd">
																	<@CommonQueryMacro.SingleField fId="approveStatus" />
																</td>
															</tr>

															<tr>
																<td align="center" nowrap class="labeltd">审批结果</td>
																<td nowrap class="datatd">
																	<@CommonQueryMacro.SingleField fId="approveResult" />
																</td>
															</tr>
															<tr>
																<td align="center" nowrap class="labeltd">回执状态</td>
																<td nowrap class="datatd">
																	<@CommonQueryMacro.SingleField fId="repStatus" />
																	<a id="repHerf" href="javascript:doRepDet()">回执结果</a>
																</td>
															</tr>
															<tr>
																<td align="center" nowrap class="labeltd">创建时间</td>
																<td nowrap class="datatd">
																	<@CommonQueryMacro.SingleField fId="crtTm" />
																</td>
															</tr>
															<tr>
																<td align="center" nowrap class="labeltd">最后更新时间</td>
																<td class="datatd">
																	<@CommonQueryMacro.SingleField fId="lstUpdTm" />
																</td>
															</tr>
														</table>
													</@CommonQueryMacro.GroupBox>
												</td>
											</tr>

											<tr>
												<td id="deleteasc">
													<@CommonQueryMacro.GroupBox id="guoup4" label="修改/删除原因信息" expand="true">
														<table frame=void class="grouptable" width="100%">
															<tr>
																<td align="center" nowrap class="labeltd" width="25%">修改/删除原因</td>
																<td class="datatd" width="75%">
																	<@CommonQueryMacro.SingleField fId="actiondesc" />
																</td>
															</tr>
														</table>
													</@CommonQueryMacro.GroupBox>
												</td>
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
	function initCallGetter_post() {
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读
		var subSuccess = BopDDsAdd_dataset.getValue("subSuccess");
		if(subSuccess=="0"&&"mod"==op){
			BopDDsAdd_dataset.setFieldReadOnly("actiondesc",true);			
		}
		var repStatus = BopDDsAdd_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").style.color="#999999";
			document.getElementById("repHerf").href="#";
		}
		//系统信息只读
		BopDDsAdd_dataset.setFieldReadOnly("actiontype",true);
		BopDDsAdd_dataset.setFieldReadOnly("recStatus",true);
		BopDDsAdd_dataset.setFieldReadOnly("approveStatus",true);
		BopDDsAdd_dataset.setFieldReadOnly("repStatus",true);
		BopDDsAdd_dataset.setFieldReadOnly("crtTm",true);
		BopDDsAdd_dataset.setFieldReadOnly("lstUpdTm",true);
		BopDDsAdd_dataset.setFieldReadOnly("approveResult",true);
		
		if("new" == op) {
			BopDDsAdd_dataset.setFieldReadOnly("rptno",true);
			BopDDsAdd_dataset.setFieldReadOnly("crtTm",true);
			window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('xitong').style.display="none";
			window.document.getElementById('repHerf').style.display="none";
		} else if("mod" == op) {
			BopDDsAdd_dataset.setFieldReadOnly("filler2",true);
			BopDDsAdd_dataset.setFieldReadOnly("rptno",true);
			BopDDsAdd_dataset.setFieldReadOnly("approveStatus",true);
			BopDDsAdd_dataset.setFieldReadOnly("actiontype",true);			
			BopDDsAdd_dataset.setFieldReadOnly("crtTm",true);
		} else if("del" == op) {
			BopDDsAdd_dataset.getField("actiondesc").required=true;
			BopDDsAdd_dataset.setFieldReadOnly("approveStatus",true);
			BopDDsAdd_dataset.setFieldReadOnly("actiontype",true);
			BopDDsAdd_dataset.setFieldReadOnly("crtTm",true);
			BopDDsAdd_dataset.setFieldReadOnly("filler2",true);
			BopDDsAdd_dataset.setFieldReadOnly("rptno",true);
			BopDDsAdd_dataset.setFieldReadOnly("custype",true);
			BopDDsAdd_dataset.setFieldReadOnly("idcode",true);
			BopDDsAdd_dataset.setFieldReadOnly("custcod",true);
			BopDDsAdd_dataset.setFieldReadOnly("custnm",true);
			BopDDsAdd_dataset.setFieldReadOnly("oppuser",true);
			BopDDsAdd_dataset.setFieldReadOnly("txccy",true);
			BopDDsAdd_dataset.setFieldReadOnly("txccyName",true);
			BopDDsAdd_dataset.setFieldReadOnly("txamt",true);
			BopDDsAdd_dataset.setFieldReadOnly("exrate",true);
			BopDDsAdd_dataset.setFieldReadOnly("lcyamt",true);			
			BopDDsAdd_dataset.setFieldReadOnly("lcyacc",true);
			BopDDsAdd_dataset.setFieldReadOnly("fcyamt",true);
			BopDDsAdd_dataset.setFieldReadOnly("fcyacc",true);
			BopDDsAdd_dataset.setFieldReadOnly("othamt",true);
			BopDDsAdd_dataset.setFieldReadOnly("othacc",true);
			BopDDsAdd_dataset.setFieldReadOnly("method",true);
			BopDDsAdd_dataset.setFieldReadOnly("buscode",true);
			BopDDsAdd_dataset.setFieldReadOnly("inchargeccy",true);
			BopDDsAdd_dataset.setFieldReadOnly("inchargeccyName",true);
			BopDDsAdd_dataset.setFieldReadOnly("inchargeamt",true);
		} else if("detail" == op) {
			BopDDsAdd_dataset.readOnly=true;
			$("#btSave").hide();
			BopDDsAdd_dataset.setFieldReadOnly("crtTm",true);
			BopDDsAdd_dataset.setFieldReadOnly("approveStatus",true);
			BopDDsAdd_dataset.setFieldReadOnly("actiontype",true);
			BopDDsAdd_dataset.setFieldReadOnly("filler2",true);
			BopDDsAdd_dataset.setFieldReadOnly("rptno",true);
			BopDDsAdd_dataset.setFieldReadOnly("custype",true);
			BopDDsAdd_dataset.setFieldReadOnly("idcode",true);
			BopDDsAdd_dataset.setFieldReadOnly("custcod",true);
			BopDDsAdd_dataset.setFieldReadOnly("custnm",true);
			BopDDsAdd_dataset.setFieldReadOnly("oppuser",true);
			BopDDsAdd_dataset.setFieldReadOnly("txccy",true);
			BopDDsAdd_dataset.setFieldReadOnly("txccyName",true);
			BopDDsAdd_dataset.setFieldReadOnly("txamt",true);
			BopDDsAdd_dataset.setFieldReadOnly("exrate",true);
			BopDDsAdd_dataset.setFieldReadOnly("lcyamt",true);			
			BopDDsAdd_dataset.setFieldReadOnly("lcyacc",true);
			BopDDsAdd_dataset.setFieldReadOnly("fcyamt",true);
			BopDDsAdd_dataset.setFieldReadOnly("fcyacc",true);
			BopDDsAdd_dataset.setFieldReadOnly("othamt",true);
			BopDDsAdd_dataset.setFieldReadOnly("othacc",true);
			BopDDsAdd_dataset.setFieldReadOnly("method",true);
			BopDDsAdd_dataset.setFieldReadOnly("buscode",true);
			BopDDsAdd_dataset.setFieldReadOnly("inchargeccy",true);
			BopDDsAdd_dataset.setFieldReadOnly("inchargeccyName",true);
			BopDDsAdd_dataset.setFieldReadOnly("inchargeamt",true);
			BopDDsAdd_dataset.setFieldReadOnly("actiondesc",true);
		}
		
	}
	
	function custype_DropDown_onSelect(dropDown,
			record, editor){
		var cus = record[0];
		if(cus=="C"){
			BopDDsAdd_dataset.setValue("idcode","");
			return true;
		}
		if(cus=="D"){
			BopDDsAdd_dataset.setValue("custcod","");
			return true;
		}
		return true;
	}
	function btBack_onClick() {
		closeWin();
	}

	//属性的只读统一设置
	if(op == "add") {
		
	}
	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {
		if(op=="del"){
			   var actiondesc = BopRDsAdd_dataset.getValue("actiondesc");
			   if(actiondesc == null || actiondesc == "") {
				  alert("字段[删除原因]不能为空");
				  return false;
			   }
			}
			BopDDsAdd_dataset.setParameter("op",op);
			return true;
	}

	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}

</script>
</@CommonQueryMacro.page>
