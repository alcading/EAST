<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="对外付款/承兑通知书">
<@CommonQueryMacro.CommonQuery id="BopCDsCollection" init="true" submitMode="all" navigate="false">
		<table width="95%" cellpadding="2">
			<tr>
				<td  width="75%" valign="top">
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
											<td rowspan="2" align="center" nowrap class="labeltd">现汇信息</td>
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
											<td rowspan="3" align="center" nowrap class="labeltd">信用证/保函信息</td>
											<td align="center" nowrap class="labeltd">信用证/保函编号</td>
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
											<td align="center" nowrap class="labeltd"> 审批状态 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveStatus" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd"> 审批结果 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveResult" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd"> 回执状态 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a></td>
										</tr>
										<tr>
											<td  align="center" nowrap class="labeltd">创建时间</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="crtTm"/></td>
										</tr>
										<tr>
											<td  align="center" nowrap class="labeltd">最后更新时间</td>
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
		var subSuccess = BopCDsCollection_dataset.getValue("subSuccess");
		if(subSuccess=="0"&&"modify"==op){
			BopCDsCollection_dataset.setFieldReadOnly("actiondesc",true);			
		}
	   //end			
		if(op == "new"){
			BopCDsCollection_dataset.setFieldReadOnly("rptno",true);
			document.getElementById("sysMsgGroup").style.display="none";
		}
		if (op == "delete") {
			BopCDsCollection_dataset.setFieldReadOnly("rptno",true);
			BopCDsCollection_dataset.setFieldReadOnly("oppuser",true);
			BopCDsCollection_dataset.setFieldReadOnly("custype",true);
			BopCDsCollection_dataset.setFieldReadOnly("lcyacc",true);
			BopCDsCollection_dataset.setFieldReadOnly("idcode",true);
			BopCDsCollection_dataset.setFieldReadOnly("lcyamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("custcod",true);
			BopCDsCollection_dataset.setFieldReadOnly("exrate",true);
			BopCDsCollection_dataset.setFieldReadOnly("custnm",true);
			BopCDsCollection_dataset.setFieldReadOnly("fcyacc",true);
			BopCDsCollection_dataset.setFieldReadOnly("txccy",true);
			BopCDsCollection_dataset.setFieldReadOnly("fcyamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("txamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("othacc",true);
			BopCDsCollection_dataset.setFieldReadOnly("buscode",true);
			BopCDsCollection_dataset.setFieldReadOnly("othamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("actuccy",true);
			BopCDsCollection_dataset.setFieldReadOnly("actuamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("outchargeccy",true);
			BopCDsCollection_dataset.setFieldReadOnly("outchargeamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("method",true);
			BopCDsCollection_dataset.setFieldReadOnly("lcbgno",true);
			BopCDsCollection_dataset.setFieldReadOnly("issdate",true);
			BopCDsCollection_dataset.setFieldReadOnly("tenor",true);
			BopCDsCollection_dataset.setFieldReadOnly("filler2",true);
			BopCDsCollection_dataset.setFieldReadOnly("actiondesc",false);
		}
		if (op == "modify") {
			BopCDsCollection_dataset.setFieldReadOnly("rptno",true);
			BopCDsCollection_dataset.setFieldReadOnly("filler2",true);
		}
		if (op == "detail"){
			BopCDsCollection_dataset.setFieldReadOnly("filler2",true);
			BopCDsCollection_dataset.setFieldReadOnly("rptno",true);
			BopCDsCollection_dataset.setFieldReadOnly("oppuser",true);
			BopCDsCollection_dataset.setFieldReadOnly("custype",true);
			BopCDsCollection_dataset.setFieldReadOnly("lcyacc",true);
			BopCDsCollection_dataset.setFieldReadOnly("idcode",true);
			BopCDsCollection_dataset.setFieldReadOnly("lcyamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("custcod",true);
			BopCDsCollection_dataset.setFieldReadOnly("exrate",true);
			BopCDsCollection_dataset.setFieldReadOnly("custnm",true);
			BopCDsCollection_dataset.setFieldReadOnly("fcyacc",true);
			BopCDsCollection_dataset.setFieldReadOnly("txccy",true);
			BopCDsCollection_dataset.setFieldReadOnly("fcyamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("txamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("othacc",true);
			BopCDsCollection_dataset.setFieldReadOnly("buscode",true);
			BopCDsCollection_dataset.setFieldReadOnly("othamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("actuccy",true);
			BopCDsCollection_dataset.setFieldReadOnly("actuamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("outchargeccy",true);
			BopCDsCollection_dataset.setFieldReadOnly("outchargeamt",true);
			BopCDsCollection_dataset.setFieldReadOnly("method",true);
			BopCDsCollection_dataset.setFieldReadOnly("lcbgno",true);
			BopCDsCollection_dataset.setFieldReadOnly("issdate",true);
			BopCDsCollection_dataset.setFieldReadOnly("tenor",true);
			BopCDsCollection_dataset.setFieldReadOnly("actiondesc",true);
			//保存按钮隐藏
			document.getElementById("btSave").style.display="none";
		}
		BopCDsCollection_dataset.setFieldReadOnly("actiontype",true);
		BopCDsCollection_dataset.setFieldReadOnly("recStatus",true);
		BopCDsCollection_dataset.setFieldReadOnly("approveStatus",true);
		BopCDsCollection_dataset.setFieldReadOnly("repStatus",true);
		BopCDsCollection_dataset.setFieldReadOnly("crtTm",true);
		BopCDsCollection_dataset.setFieldReadOnly("lstUpdTm",true);
		BopCDsCollection_dataset.setFieldReadOnly("approveResult",true);
		
		//TODO 判断回执详细
		var repStatus = BopCDsCollection_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
	}
	
	function btSave_onClickCheck(){
		if (op == "new" || op == "modify") {
			//新增，修改页面校验
			BopCDsCollection_dataset.getField("idcode").require=false;
			BopCDsCollection_dataset.getField("custcod").required=false;
			var custype = BopCDsCollection_dataset.getValue("custype");
			//CUSTYPE<>C时必输
			if(custype != "C"){
				BopCDsCollection_dataset.getField("idcode").required=true;
			}
			//CUSTYPE=C时必输
			if(custype == "C"){
				BopCDsCollection_dataset.getField("custcod").required=true;
			}
			var oppuser = BopCDsCollection_dataset.getValue("oppuser");
			if(!(oppuser.substring(0,4) == "(JW)" || oppuser.substring(0,4) == "(JN)")){
				alert("收款人名称必须以大写英文字符 “(JW)”或“(JN)”开头。");
				return false;
			}
		}
		if (op == "delete") {
			var actiondesc = BopCDsCollection_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("请填写删除原因！");
				return false;
			}
		}
		BopCDsCollection_dataset.setParameter("op", op);
		return true;
	}
	
	function doRepDet(){
		var id = BopCDsCollection_dataset.getValue("id");
		var appType = BopCDsCollection_dataset.getValue("appType");
		var currentfile = BopCDsCollection_dataset.getValue("currentfile");
		var busiCode = ""; //不用传，从后天处理得出业务逻辑主键
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile, 600, 500);
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