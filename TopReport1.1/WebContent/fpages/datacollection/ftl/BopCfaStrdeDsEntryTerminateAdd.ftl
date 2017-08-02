<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#global contextPath = contextPath>
<@CommonQueryMacro.page title="终止信息新增">
<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsEntryTerminateAdd" navigate="false" init="true" insertOnEmpty="true">
<table>
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td><@CommonQueryMacro.GroupBox id="groupbox1" label="签约信息"
						expand="true">
						<table frame="void" class="grouptable" width="100%">
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">人民币结构性存款编号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="strdecode"/><input extra="button" style='width=25px;height=17px;' onclick="loadAccount();" type='button' value='...'/></td>


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

								<td colspan="1" align="center" nowrap class="labeltd">备注</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
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
			</table></td>

	</tr>

	<tr><#--MOD  BY HUANGCHENG   2012-8-22 BEGIN-->
		<td>
		<@CommonQueryMacro.GroupBox id="groupbox1" label="终止信息" expand="true">
			<table frame=void class="grouptable" width="900px">
               <tr>
                   <td colspan="1" align="center" nowrap class="labeltd" >终止类型</td>
                   <td class="datatd"><@CommonQueryMacro.SingleField fId="tertype"/> </td>

	               <td colspan="1"  align="center" nowrap class="labeltd" >终止支付编号 </td>
		           <td class="datatd"><@CommonQueryMacro.SingleField fId="terpaycode"/></td>

               </tr>
               <tr>

		           <td colspan="1" align="center" nowrap class="labeltd" >终止日期 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="terdate"/> </td>

                   <td colspan="1" align="center" nowrap class="labeltd" >终止支付金额合计折人民币</td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="terpayamtormb"/> </td>

    			<tr>
		           <td rowspan="1" align="center" nowrap class="labeltd" >终止人民币支付金额 </td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="terrmbpayam"/>  </td>

                   <td colspan="1" align="center" nowrap class="labeltd" >终止外币支付币种 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="terpaycurr"/> </td>
				</tr>
				<tr>
		           <td align="center" nowrap class="labeltd" >终止外币支付金额</td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="terpaycurram"/>  </td>

                   <td colspan="1" align="center" nowrap class="labeltd" >业务流水号</td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="filler2"/> </td>
              </tr>
              <tr>
                   <td colspan="1" align="center" nowrap class="labeltd" >备注</td>
                   <td class="datatd" colspan="3"><@CommonQueryMacro.SingleField fId="remark1"/> </td>
              </tr>
           </table>
         </@CommonQueryMacro.GroupBox>
       </td>
   </tr>

   <tr>
		<td>
			<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btBack"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var op = "${RequestParameters["op"]?default('')}";
	//终止编号用"****"代替
	<#assign v_terpaycode = statics["com.huateng.report.utils.ReportUtils"].getTempStr(null,4)>
	function initCallGetter_post(){
		if (bopCfaStrdeDsEntryTerminateAdd_dataset.length == 0) {
			bopCfaStrdeDsEntryTerminateAdd_dataset.insertRecord("end");
		}
		bopCfaStrdeDsEntryTerminateAdd_dataset.setValue("terpaycode","${v_terpaycode}");
		bopCfaStrdeDsEntryTerminateAdd_dataset.setFieldReadOnly("terpaycode",true);
	}

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


	function btBack_onClick() {
		closeWin();
	}

	//弹出签约信息选择框
	function loadAccount(){
		showPickup("签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopCfaStrdeDsLoadPage.ftl?type=terminate");
	}

	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {
		return addClickCheck();
	}

	//保存按钮检查
	function addClickCheck() {
		var strdecode = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("strdecode");
		var terpaycode = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("terpaycode");
		var terpayamtormb = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("terpayamtormb");
		var terpaycurram = bopCfaStrdeDsEntryTerminateAdd_dataset.getString("terpaycurram");
		var terpaycurr = bopCfaStrdeDsEntryTerminateAdd_dataset.getValue("terpaycurr");
		var terrmbpayam = bopCfaStrdeDsEntryTerminateAdd_dataset.getString("terrmbpayam");
		if(strdecode == null || strdecode == "") {
			alert("请先选择人民币结构性存款编号");
			return false;
		}
		if(terpaycode.length != 4) {
			alert("字段[终止支付编号]必须是4位字符");
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
		//人民币结构性存款合同终止后，支付金额合计折人民币值，等于终止人民币支付金额+终止外币支付金额折人民币。(在后台验证)
		return true;
	}

	function btSave_postSubmit(button) {
		alert("保存成功");
		closeWin(true);
	}

</script>
</@CommonQueryMacro.page>
