<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#global contextPath = contextPath>
<@CommonQueryMacro.page title="资金流出入和结购汇信息详细">
<@CommonQueryMacro.CommonQuery id="bopCfaStrdeDsEntryInoutMoAdd" init="true" insertOnEmpty="true" navigate="false">
<table width="75%">
	<tr width="100%">
		<td valign="top">
			<@CommonQueryMacro.Group id ="groupbox1" label="资金流出入和结购汇信息"
				fieldStr="branchcode,buocmonth,currency,moexamusd,moamreusd,mopfexamusd,mosettamusd,filler2,remark" colNm=4/>

			<table>
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
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var op = "${RequestParameters["op"]?default('')}";
	var ds = bopCfaStrdeDsEntryInoutMoAdd_dataset;
	function btBack_onClick() {
		closeWin();
	}
	//只读
	function initCallGetter_post() {
		ds.setFieldReadOnly("branchcode",true);
		//系统信息只读
		ds.setFieldReadOnly("actiontype",true);
		ds.setFieldReadOnly("recStatus",true);
		ds.setFieldReadOnly("approveStatus",true);
		ds.setFieldReadOnly("approveResult",true);
		ds.setFieldReadOnly("repStatus",true);
		ds.setFieldReadOnly("crtTm",true);
		ds.setFieldReadOnly("lstUpdTm",true);
		//回执说明样式
		var repStatus = ds.getValue("repStatus");
		if("00" == repStatus) {
			document.getElementById("repHref").href = "#";
			document.getElementById("repHref").style.color = "#999999";
		}
		if(op == "mod") ds.setFieldReadOnly("actiondesc",true);
		if(op == "del") {
			ds.setFieldReadOnly("branchcode",true);
			ds.setFieldReadOnly("buocmonth",true);
			ds.setFieldReadOnly("currency",true);
			ds.setFieldReadOnly("moexamusd",true);
			ds.setFieldReadOnly("moamreusd",true);
			ds.setFieldReadOnly("mopfexamusd",true);
			ds.setFieldReadOnly("filler2",true);
			ds.setFieldReadOnly("mosettamusd",true);
			ds.setFieldReadOnly("remark",true);
		}
		if(op == "detail") {
			ds.setFieldReadOnly("branchcode",true);
			ds.setFieldReadOnly("buocmonth",true);
			ds.setFieldReadOnly("currency",true);
			ds.setFieldReadOnly("moexamusd",true);
			ds.setFieldReadOnly("moamreusd",true);
			ds.setFieldReadOnly("mopfexamusd",true);
			ds.setFieldReadOnly("mosettamusd",true);
			ds.setFieldReadOnly("filler2",true);
			ds.setFieldReadOnly("remark",true);
			ds.setFieldReadOnly("actiondesc",true);

		}
	}
	//保存按钮提交前检查统一设置
	//mod 2012-10-24 已在后台验证
	function btSave_onClickCheck(button) {
		if(op = "mod") 	return modClickCheck();
		if(op = "del")	return delClickCheck(button);
		return true;
	}
	//判断是不是"空"
	function isBlank(value) {
		if(value == null || value == "") {
			return true;
		}
		return false;
	}
	//利息给付信息保存按钮检查
	function modClickCheck() {
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
	function delClickCheck(button) {
		var actiondesc = ds.getValue("actiondesc");
		if(actiondesc == null || actiondesc == "") {
			alert("字段[删除原因]不能为空");
			return false;
		}
		return true;
	}

	function btSave_postSubmit(button) {
		alert("保存成功");
		closeWin(true);
	}

	function doApproveDet(){
		var id = ds.getValue("id");
		var appType = ds.getValue("appType");
		var currentfile = ds.getValue("currentfile");
		showPickup("审核结果","${contextPath}/fpages/commonloadpage/ftl/ReportApproveResult.ftl?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile ,440,220);
	}
	function doRepDet(){
		var id = ds.getValue("id");
		var appType = ds.getValue("appType");
		var currentfile = ds.getValue("currentfile");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile, 600, 500);
	}
</script>
</@CommonQueryMacro.page>
