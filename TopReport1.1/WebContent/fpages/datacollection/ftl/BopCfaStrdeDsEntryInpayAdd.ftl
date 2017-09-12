<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#global contextPath = contextPath>
<@CommonQueryMacro.page title="利息给付信息新增">
<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsEntryInpayAdd" navigate="false" init="true" insertOnEmpty="true">
<table width="70%">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox1" label="签约信息" expand="true">
							<table frame="void" class="grouptable" width="100%">
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">人民币结构性存款编号</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="strdecode"/>
										<input extra="button" style='width=25px;height=17px;' onclick="loadAccount();" type='button' value='...'/>
									</td>
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
			</table>
		</td>

		<td width="8px"></td>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0" style="display:none">
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
									<td class="datatd"><@CommonQueryMacro.SingleField fId="repStatus"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">创建时间</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="crtTm"/></td>
								</tr>
									<td colspan="1" align="center" nowrap class="labeltd">最后修改时间</td>
									<td class="datatd" 	><@CommonQueryMacro.SingleField fId="lstUpdTm"/></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr><#--MOD  BY HUANGCHENG   2012-8-22 BEGIN-->
		<td>
			<@CommonQueryMacro.Group id ="groupbox1" label="利息给付信息"
				fieldStr="inpaycode,inpaymonth,inpayrmbam,inpaycurr,inpaycurram,filler2,remark1" colNm=4/>
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
	var ds = bopCfaStrdeDsEntryInpayAdd_dataset;
	//付息编号用"****"替代
	<#assign v_inpaycode = statics["com.huateng.report.utils.ReportUtils"].getTempStr(null,4)>
	function initCallGetter_post(){
		if (bopCfaStrdeDsEntryInpayAdd_dataset.length == 0) {
			bopCfaStrdeDsEntryInpayAdd_dataset.insertRecord("end");
		}
		ds.setValue("inpaycode","${v_inpaycode}");
		ds.setFieldReadOnly("inpaycode",true);
	}

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

	function btBack_onClick() {
		closeWin();
	}

	//弹出签约信息选择框
	function loadAccount(){
		showPickup("签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopCfaStrdeDsLoadPage.ftl?type=inpay");
	}

	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {
		return addClickCheck();
	}

	//利息给付信息保存按钮检查
	function addClickCheck() {
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

	function btSave_postSubmit(button) {
		alert("保存成功");
		closeWin(true);
	}

</script>
</@CommonQueryMacro.page>
