<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#global contextPath = contextPath>
<@CommonQueryMacro.page title="资金流出入和结购汇信息新增">
<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsEntryInoutMoAdd" init="true" insertOnEmpty="true" navigate="false">
<table width="70%">
	<tr width="100%">
		<td valign="top">

			<@CommonQueryMacro.Group id ="groupbox1" label="资金流出入和结购汇信息"
				fieldStr="branchcode,buocmonth,currency,moexamusd,moamreusd,mopfexamusd,mosettamusd,filler2,remark" colNm=4/>

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
									<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm"/></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
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
	var ds = bopCfaStrdeDsEntryInoutMoAdd_dataset;
	<#assign v_branchcode = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getBrno()>
	function initCallGetter_post(){
		if (ds.length == 0) {
			ds.insertRecord("end");
		}
		//币种默认美元
		ds.setValue2("currency","USD");
		ds.setValue("currencyName","USD-美元");
		//机构号默认当前机构
		ds.setValue("branchcode","${v_branchcode}");
		ds.setFieldReadOnly("branchcode",true);
	}

	function btBack_onClick() {
		closeWin();
	}

	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {
		return addClickCheck();
	}
	//判断是不是"空"
	function isBlank(value) {
		if(value == null || value == "") {
			return true;
		}
		return false;
	}
	//利息给付信息保存按钮检查
	function addClickCheck() {
		var moexamusd = ds.getString("moexamusd");//本月汇出金额折美元
		var moamreusd = ds.getString("moamreusd");//本月汇入金额折美元
		var mosettamusd = ds.getString("mosettamusd");//本月结汇金额折美元
		var mopfexamusd = ds.getString("mopfexamusd");//本月购汇金额折美元
		//这四个字段不能都为空,至少填一个
		if(isBlank(moexamusd) && isBlank(moamreusd) && isBlank(mosettamusd) && isBlank(mopfexamusd)) {
			alert("汇出、汇入、购汇、结汇金额折美元至少填一个。");
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
