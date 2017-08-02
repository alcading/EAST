<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="境内付款/承兑通知书">
<@CommonQueryMacro.CommonQuery id="BopFDsCollection" init="true" submitMode="all" navigate="false">
		<table width="95%" cellpadding="2">
			<tr>
				<td width="75%" valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" colspan="2" nowrap class="labeltd">申报号码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="rptno"/></td>
											<td align="center" colspan="2" nowrap class="labeltd">收款人名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="oppuser"/></td>
										</tr>
										<tr>
											<td rowspan="4" align="center" nowrap class="labeltd">付款人信息</td>
											<td align="center" nowrap class="labeltd">付款人类型</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="custype"/></td>
											<td rowspan="3" align="center" nowrap class="labeltd">购汇信息</td>
											<td align="center" nowrap class="labeltd">人民币帐号/银行卡号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyacc"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">组织机构代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="custcod"/></td>
											<td align="center" nowrap class="labeltd">购汇金额</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyamt"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">个人身份证件号码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="idcode"/></td>
											<td align="center" nowrap class="labeltd">购汇汇率</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="exrate"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">付款人名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="custnm"/></td>
											<td rowspan="2" align="center" nowrap class="labeltd">现汇信息</td>
											<td align="center" nowrap class="labeltd">外汇帐号/银行卡号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyacc"/></td>
										</tr>
										<tr>
											<td rowspan="3" align="center" nowrap class="labeltd">付款信息</td>
											<td align="center" nowrap class="labeltd">付款币种</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="txccy"/></td>
											<td align="center" nowrap class="labeltd">现汇金额</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyamt"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">付款金额</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="txamt"/></td>
											<td rowspan="2" align="center" nowrap class="labeltd">其他信息</td>
											<td align="center" nowrap class="labeltd">其它帐号/银行卡号</td>
											<td class="datatd" ><@CommonQueryMacro.SingleField fId="othacc"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">结算方式</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="method"/></td>
											<td align="center" nowrap class="labeltd">其它金额</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="othamt"/></td>
										</tr>
										<tr>
											<td rowspan="2" align="center" nowrap class="labeltd">实际付款信息</td>
											<td align="center" nowrap class="labeltd">实际付款币种</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="actuccy"/></td>
											<td rowspan="3" align="center" nowrap class="labeltd">信用证信息</td>
											<td align="center" nowrap class="labeltd">信用证编号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="lcbgno"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">实际付款金额</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="actuamt"/></td>
											<td align="center" nowrap class="labeltd">期限</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="tenor"/></td>
										</tr>
										<tr>
											<td rowspan="2" align="center" nowrap class="labeltd">扣费信息</td>
											<td align="center" nowrap class="labeltd">扣费币种</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="outchargeccy"/></td>
											<td align="center" nowrap class="labeltd">开证日期</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="issdate"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">扣费金额</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="outchargeamt"/></td>
											<td align="center" colspan="2" nowrap class="labeltd">银行业务编号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="buscode"/></td>
										</tr>
										<tr>
											<td align="center" colspan="2" nowrap class="labeltd">业务流水号</td>
											<td class="datatd" colspan="4"><@CommonQueryMacro.SingleField fId="filler2"/></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
					</table>
				</td>

				<td width="8px"></td>
				<td width="25%" valign="top" id="sysMsgGroup">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD1" label="系统信息"  expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd">操作类型</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="actiontype"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">记录状态</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="recStatus"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">审批状态 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveStatus" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">审批结果 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveResult" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">回执状态 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">创建时间</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="crtTm"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">最后更新时间</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm"/></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>

						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD2" label="修改/删除信息"   expand="true">
									<table frame=void class="grouptable" width="100%" >
										<tr>
											<td  align="center" nowrap class="labeltd">修改/删除原因</td>
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
					<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

	var op = "${op}";

	function initCallGetter_post(){
		
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读  add by  huangcheng
		var subSuccess = BopFDsCollection_dataset.getValue("subSuccess");
		if(subSuccess=="0"&&"modify"==op){
			BopFDsCollection_dataset.setFieldReadOnly("actiondesc",true);
		}
	   //end
		if(op == "new"){
			BopFDsCollection_dataset.setFieldReadOnly("rptno",true);
			document.getElementById("sysMsgGroup").style.display="none";
		}
		if (op == "delete") {
			BopFDsCollection_dataset.setFieldReadOnly("rptno",true);
			BopFDsCollection_dataset.setFieldReadOnly("oppuser",true);
			BopFDsCollection_dataset.setFieldReadOnly("custype",true);
			BopFDsCollection_dataset.setFieldReadOnly("lcyacc",true);
			BopFDsCollection_dataset.setFieldReadOnly("idcode",true);
			BopFDsCollection_dataset.setFieldReadOnly("lcyamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("custcod",true);
			BopFDsCollection_dataset.setFieldReadOnly("exrate",true);
			BopFDsCollection_dataset.setFieldReadOnly("custnm",true);
			BopFDsCollection_dataset.setFieldReadOnly("fcyacc",true);
			BopFDsCollection_dataset.setFieldReadOnly("txccy",true);
			BopFDsCollection_dataset.setFieldReadOnly("fcyamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("txamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("othacc",true);
			BopFDsCollection_dataset.setFieldReadOnly("buscode",true);
			BopFDsCollection_dataset.setFieldReadOnly("othamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("actuccy",true);
			BopFDsCollection_dataset.setFieldReadOnly("actuamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("outchargeccy",true);
			BopFDsCollection_dataset.setFieldReadOnly("outchargeamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("method",true);
			BopFDsCollection_dataset.setFieldReadOnly("lcbgno",true);
			BopFDsCollection_dataset.setFieldReadOnly("issdate",true);
			BopFDsCollection_dataset.setFieldReadOnly("tenor",true);
			BopFDsCollection_dataset.setFieldReadOnly("filler2",true);
			BopFDsCollection_dataset.setFieldReadOnly("actiondesc",false);
		}
		if (op == "modify") {
			BopFDsCollection_dataset.setFieldReadOnly("rptno",true);
			BopFDsCollection_dataset.setFieldReadOnly("filler2",true);
		}
		if (op == "detail"){
			BopFDsCollection_dataset.setFieldReadOnly("filler2",true);
			BopFDsCollection_dataset.setFieldReadOnly("rptno",true);
			BopFDsCollection_dataset.setFieldReadOnly("oppuser",true);
			BopFDsCollection_dataset.setFieldReadOnly("custype",true);
			BopFDsCollection_dataset.setFieldReadOnly("lcyacc",true);
			BopFDsCollection_dataset.setFieldReadOnly("idcode",true);
			BopFDsCollection_dataset.setFieldReadOnly("lcyamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("custcod",true);
			BopFDsCollection_dataset.setFieldReadOnly("exrate",true);
			BopFDsCollection_dataset.setFieldReadOnly("custnm",true);
			BopFDsCollection_dataset.setFieldReadOnly("fcyacc",true);
			BopFDsCollection_dataset.setFieldReadOnly("txccy",true);
			BopFDsCollection_dataset.setFieldReadOnly("fcyamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("txamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("othacc",true);
			BopFDsCollection_dataset.setFieldReadOnly("buscode",true);
			BopFDsCollection_dataset.setFieldReadOnly("othamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("actuccy",true);
			BopFDsCollection_dataset.setFieldReadOnly("actuamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("outchargeccy",true);
			BopFDsCollection_dataset.setFieldReadOnly("outchargeamt",true);
			BopFDsCollection_dataset.setFieldReadOnly("method",true);
			BopFDsCollection_dataset.setFieldReadOnly("lcbgno",true);
			BopFDsCollection_dataset.setFieldReadOnly("issdate",true);
			BopFDsCollection_dataset.setFieldReadOnly("tenor",true);
			BopFDsCollection_dataset.setFieldReadOnly("actiondesc",true);
			//保存按钮隐藏
			document.getElementById("btSave").style.display="none";
		}
		BopFDsCollection_dataset.setFieldReadOnly("actiontype",true);
		BopFDsCollection_dataset.setFieldReadOnly("recStatus",true);
		BopFDsCollection_dataset.setFieldReadOnly("approveStatus",true);
		BopFDsCollection_dataset.setFieldReadOnly("repStatus",true);
		BopFDsCollection_dataset.setFieldReadOnly("crtTm",true);
		BopFDsCollection_dataset.setFieldReadOnly("lstUpdTm",true);
		BopFDsCollection_dataset.setFieldReadOnly("approveResult",true);
		
		//TODO 判断回执详细
		var repStatus = BopFDsCollection_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
	}
	
	function btSave_onClickCheck(){
		if (op == "new" || op == "modify") {
			//新增，修改页面校验
			BopFDsCollection_dataset.getField("idcode").require=false;
			BopFDsCollection_dataset.getField("custcod").required=false;
			var custype = BopFDsCollection_dataset.getValue("custype");
			//CUSTYPE<>C时必输
			if(custype != "C"){
				BopFDsCollection_dataset.getField("idcode").required=true;
			}
			//CUSTYPE=C时必输
			if(custype == "C"){
				BopFDsCollection_dataset.getField("custcod").required=true;
			}
		}
		if (op == "delete") {
			var actiondesc = BopFDsCollection_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("请填写删除原因！");
				return false;
			}
		}
		BopFDsCollection_dataset.setParameter("op", op);
		return true;
	}
	
	function doRepDet(){
		var id = BopFDsCollection_dataset.getValue("id");
		var appType = BopFDsCollection_dataset.getValue("appType");
		var currentfile = BopFDsCollection_dataset.getValue("currentfile");
		//var busiCode = BopFDsCollection_dataset.getValue("exdebtcode");
		var busiCode = ""; //不用传，从后天处理得出业务逻辑主键
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
	}
	
	function btBack_onClick(){
		closeWin();
	}					
	
	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}
</script>
</@CommonQueryMacro.page>