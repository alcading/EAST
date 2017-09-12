<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="基础信息">
<@CommonQueryMacro.CommonQuery id="bopADsRecordInfo" init="true" insertOnEmpty="true" navigate="false">
<table width="90%" cellpadding="2">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox1" label="基础信息" expand="true">
						<table frame="void" class="grouptable" width="100%">
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">申报号码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="rptno"/></td>
								<td colspan="2" align="center" nowrap class="labeltd">付款人名称</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="oppuser"/></td>
							</tr>
							<tr>
								<td rowspan="4" align="center" nowrap class="labeltd">收款人信息</td>
								<td align="center" nowrap class="labeltd">收款人类型 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="custype" /></td>
								<td rowspan="3" align="center" nowrap class="labeltd">结汇信息</td>
								<td align="center" nowrap class="labeltd">结汇金额 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyamt" /></td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">收款人名称</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="custnm"/></td>
								<td align="center" nowrap class="labeltd">人民币帐号/银行卡号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyacc" /></td>
								
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">个人身份证件号码 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="idcode" /></td>
								<td align="center" nowrap class="labeltd">结汇汇率</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="exrate" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">组织机构代码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="custcod" /></td>
								<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">现汇信息</td>
								<td align="center" nowrap class="labeltd">现汇金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyamt" /></td>
							</tr>
							<tr>
								<td colspan="1" rowspan="3" align="center" nowrap class="labeltd">收入款信息</td>
								<td align="center" nowrap class="labeltd">收入款金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txamt" /></td>
								<td align="center" nowrap class="labeltd">外汇帐号/银行卡号 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyacc" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">收入款币种 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txccy" /></td>
								<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">其他信息</td>
								<td align="center" nowrap class="labeltd">其他金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="othamt" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">结算方式 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="method" /></td>
								<td align="center" nowrap class="labeltd">其它帐号/银行卡号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="othacc" /></td>
							</tr>
							<tr>
								<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">国内银行扣费信息</td>
								<td align="center" nowrap class="labeltd">国内银行扣费币种 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="inchargeccy" /></td>
								<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">国外银行扣费信息</td>
								<td align="center" nowrap class="labeltd">国外银行扣费币种 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="outchargeccy" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">国内银行扣费金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="inchargeamt" /></td>
								<td align="center" nowrap class="labeltd">国外银行扣费金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="outchargeamt" /></td>
							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">银行业务编号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="buscode" /></td>
								<td colspan="2" align="center" nowrap class="labeltd">业务流水号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2" /></td>
							</tr>
						</table> 
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>
		<td width="8px"></td>
		<td valign="top">
			<table id="systemMessageTable" width="100%" cellpadding="0" cellspacing="0" style="">
				<tr>
					<td><@CommonQueryMacro.GroupBox id="groupbox2" label="系统信息"
						expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd">操作类型</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="actiontype" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" >记录状态</td>
								<td class="datatd" >
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
								<td align="center" nowrap class="labeltd">回执状态
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="repStatus"/><a id="repResult" href="JavaScript:doRepDet()">回执说明<a/>
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
								<td nowrap class="datatd">
									<@CommonQueryMacro.SingleField fId="lstUpdTm" />
								</td>
							</tr>
						</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
				<tr id="actiondescTrTd"><td>
					<@CommonQueryMacro.GroupBox id="groupbox3" label="修改/删除原因"  expand="true">
						<table frame=void class="grouptable" width="100%" >
							<tr>
								<td align="center" nowrap class="labeltd">修改/删除原因</td>
								<td class="datatd" ><@CommonQueryMacro.SingleField fId="actiondesc"/></td>
							</tr>
						</table>
					</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="left" colspan="3">
			<@CommonQueryMacro.Button id="btSave"/>&nbsp; &nbsp;<@CommonQueryMacro.Button id="btBack"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	var op = "${RequestParameters["op"]?default('')}";
	var ds = bopADsRecordInfo_dataset;
	
	function initCallGetter_post(){
		//回执说明链接样式
		var repStatus = ds.getValue("repStatus");
		if(repStatus == "00" || repStatus == "01") {
			document.getElementById("repResult").href = "javascript:void(0)";
			document.getElementById("repResult").style.color = "#999999";
		}
		//系统信息只读
		ds.setFieldReadOnly("actiontype",true);
		ds.setFieldReadOnly("recStatus",true);
		ds.setFieldReadOnly("approveStatus",true);
		ds.setFieldReadOnly("approveResult",true);
		ds.setFieldReadOnly("repStatus",true);
		ds.setFieldReadOnly("crtTm",true);
		ds.setFieldReadOnly("lstUpdTm",true);
		//申报号码只读
		ds.setFieldReadOnly("rptno",true);
		if(op == "det" || op == "mod") {
			ds.setFieldReadOnly("filler2",true);
		}
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读  add by  huangcheng
		var subSuccess = ds.getValue("subSuccess");
		if(subSuccess=="0"&&"mod"==op){
			ds.setFieldReadOnly("actiondesc",true);			
		}
		if (op == "add") {	//新增隐藏系统信息
			$("#actiondescTrTd").get(0).style.display="none";
			$("#systemMessageTable").get(0).style.display="none";
		} else if (op == "del") {	// 删除
			setCommonReadOnly();
			ds.getField("actiondesc").required = true;
		} else if (op == "det") {	// 详细
			//所有信息只读
			setCommonReadOnly();
			ds.setFieldReadOnly("actiondesc",true);
			//保存按钮隐藏
			$("#btSave").get(0).style.display="none";
		}
	}
	
	function setCommonReadOnly() {
		ds.setFieldReadOnly("workDate",true);
		ds.setFieldReadOnly("custype",true);
		ds.setFieldReadOnly("idcode",true);
		ds.setFieldReadOnly("custcod",true);
		ds.setFieldReadOnly("custnm",true);
		ds.setFieldReadOnly("oppuser",true);
		ds.setFieldReadOnly("txccy",true);
		ds.setFieldReadOnly("txamt",true);
		ds.setFieldReadOnly("method",true);
		ds.setFieldReadOnly("buscode",true);
		ds.setFieldReadOnly("inchargeccy",true);
		ds.setFieldReadOnly("inchargeamt",true);
		ds.setFieldReadOnly("outchargeccy",true);
		ds.setFieldReadOnly("outchargeamt",true);
		ds.setFieldReadOnly("lcyamt",true);
		ds.setFieldReadOnly("lcyacc",true);
		ds.setFieldReadOnly("exrate",true);
		ds.setFieldReadOnly("fcyamt",true);
		ds.setFieldReadOnly("fcyacc",true);
		ds.setFieldReadOnly("othamt",true);
		ds.setFieldReadOnly("othacc",true);
		ds.setFieldReadOnly("filler2",true);
	}
	
	function doRepDet(){
		var id = ds.getValue("id");
		var appType = ds.getValue("appType");
		var currentfile = ds.getValue("currentfile");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile, 600, 500);
	}

	function btBack_onClick(){
		closeWin();
	}
	
	function btSave_onClickCheck(button) {
		if(op == "del"){
			var actiondesc = ds.getValue("actiondesc");
			if(actiondesc == null || actiondesc == "") {
				alert("字段[修改/删除原因]不能为空");
				return false;
			}
		} 
		ds.setParameter("op",op);
		return true;
	}
	
	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}
</script>
</@CommonQueryMacro.page>