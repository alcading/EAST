<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="对外付款/承兑通知书">
<@CommonQueryMacro.CommonQuery id="BopKDsCollection" init="true" submitMode="all" navigate="false">
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
											<td class="datatd">
												<@CommonQueryMacro.SingleField fId="rptno"/>
												<input id="btLoadPage" extra="button" style='width=20px;height=17px;' onclick="loadCDsPage();" type='button' value='...'/>
											</td>
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
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup2" label="申报信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" colspan="2" nowrap class="labeltd">收款人常驻国家/地区代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="country"/></td>
											<td align="center"  colspan="2" nowrap class="labeltd">是否保税货物项下付款</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="isref"/></td>
										
										</tr>
										<tr>
										    <td align="center" rowspan="3" nowrap class="labeltd">交易信息1</td>
											<td align="center" nowrap class="labeltd">交易编码1</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="txcode"/></td>
											<td align="center" rowspan="3" nowrap class="labeltd">交易信息2</td>
											<td align="center" nowrap class="labeltd">交易编码2</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="txcode2"/></td>				
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">交易附言1</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="txrem"/></td>
											<td align="center" nowrap class="labeltd">交易附言2</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="tx2rem"/></td>
											
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">相应金额1</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="tc1amt"/></td>
											<td align="center" nowrap class="labeltd">相应金额2</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="tc2amt"/></td>
											
										</tr>
										<tr>
										    <td align="center"  colspan="2"nowrap class="labeltd">联系人</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="crtuser"/></td>
											<td align="center" colspan="2" nowrap class="labeltd">付款类型</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="paytype"/></td>
												
										</tr>
										<tr>
										
											<td align="center" colspan="2" nowrap class="labeltd">联系人电话</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="inptelc"/></td>											
											<td align="center" colspan="2" nowrap class="labeltd">申报日期</td>
											<td class="datatd" ><@CommonQueryMacro.SingleField fId="rptdate"/></td>
										</tr>
										<tr>
											<td align="center" colspan="2" nowrap class="labeltd">外汇局批件号/备案表号/业务编号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="regno"/></td>
											<td align="center" colspan="2" 	nowrap class="labeltd">业务流水号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
					</table>
				</td>

				<td width="8px"></td>
				<td width="25%"  valign="top" id="sysMsgGroup">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD1" label="系统信息"  expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td  align="center" nowrap class="labeltd">操作类型</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="actiontype"/></td>
										</tr>
										<tr>
											<td  align="center" nowrap class="labeltd">记录状态</td>
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

	 function txcode_DropDown_beforeOpen(dropDown){
         MtsInOutCodeTreeSelect_DropDownDataset.setParameter("headDataTypeNo","01");
         MtsInOutCodeTreeSelect_DropDownDataset.setParameter("codeType","BOP-OUT");
	 }
	
	 function txcode2_DropDown_beforeOpen(dropDown){
         MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("headDataTypeNo","01");
         MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("codeType","BOP-OUT");
     }
	
	

	var op = "${op}";

	function initCallGetter_post(){
		
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读  add by  huangcheng
		var subSuccess = BopKDsCollection_dataset.getValue("subSuccess");
		if(subSuccess=="0"&&"modify"==op){
			BopKDsCollection_dataset.setFieldReadOnly("actiondesc",true);			
		}
	   //end
		if(op == "new"){
			document.getElementById("sysMsgGroup").style.display="none";
		}
		if (op == "delete") {
			BopKDsCollection_dataset.setFieldReadOnly("filler2",true);
			BopKDsCollection_dataset.setFieldReadOnly("country",true);
			BopKDsCollection_dataset.setFieldReadOnly("paytype",true);
			BopKDsCollection_dataset.setFieldReadOnly("txcode",true);
			BopKDsCollection_dataset.setFieldReadOnly("tc1amt",true);
			BopKDsCollection_dataset.setFieldReadOnly("txrem",true);
			BopKDsCollection_dataset.setFieldReadOnly("txcode2",true);
			BopKDsCollection_dataset.setFieldReadOnly("tc2amt",true);
			BopKDsCollection_dataset.setFieldReadOnly("tx2rem",true);
			BopKDsCollection_dataset.setFieldReadOnly("isref",true);
			BopKDsCollection_dataset.setFieldReadOnly("crtuser",true);
			BopKDsCollection_dataset.setFieldReadOnly("inptelc",true);
			BopKDsCollection_dataset.setFieldReadOnly("rptdate",true);
			BopKDsCollection_dataset.setFieldReadOnly("regno",true);
			BopKDsCollection_dataset.setFieldReadOnly("actiondesc",false);
			document.getElementById("btLoadPage").style.display="none";
		}
		if (op == "modify") {
			BopKDsCollection_dataset.setFieldReadOnly("filler2",true);
			//document.getElementById("btLoadPage").style.display="none";
		}
		if (op == "detail"){
			BopKDsCollection_dataset.setFieldReadOnly("filler2",true);
			BopKDsCollection_dataset.setFieldReadOnly("country",true);
			BopKDsCollection_dataset.setFieldReadOnly("paytype",true);
			BopKDsCollection_dataset.setFieldReadOnly("txcode",true);
			BopKDsCollection_dataset.setFieldReadOnly("tc1amt",true);
			BopKDsCollection_dataset.setFieldReadOnly("txrem",true);
			BopKDsCollection_dataset.setFieldReadOnly("txcode2",true);
			BopKDsCollection_dataset.setFieldReadOnly("tc2amt",true);
			BopKDsCollection_dataset.setFieldReadOnly("tx2rem",true);
			BopKDsCollection_dataset.setFieldReadOnly("isref",true);
			BopKDsCollection_dataset.setFieldReadOnly("crtuser",true);
			BopKDsCollection_dataset.setFieldReadOnly("inptelc",true);
			BopKDsCollection_dataset.setFieldReadOnly("rptdate",true);
			BopKDsCollection_dataset.setFieldReadOnly("regno",true);
			BopKDsCollection_dataset.setFieldReadOnly("actiondesc",true);
			//保存按钮隐藏
			document.getElementById("btSave").style.display="none";
			document.getElementById("btLoadPage").style.display="none";
		}
		// 基础信息只读
		if( op != "new") {
			BopKDsCollection_dataset.setFieldReadOnly("filler2",true);
		}
		BopKDsCollection_dataset.setFieldReadOnly("rptno",true);
		BopKDsCollection_dataset.setFieldReadOnly("oppuser",true);
		BopKDsCollection_dataset.setFieldReadOnly("custype",true);
		BopKDsCollection_dataset.setFieldReadOnly("lcyacc",true);
		BopKDsCollection_dataset.setFieldReadOnly("idcode",true);
		BopKDsCollection_dataset.setFieldReadOnly("lcyamt",true);
		BopKDsCollection_dataset.setFieldReadOnly("custcod",true);
		BopKDsCollection_dataset.setFieldReadOnly("exrate",true);
		BopKDsCollection_dataset.setFieldReadOnly("custnm",true);
		BopKDsCollection_dataset.setFieldReadOnly("fcyacc",true);
		BopKDsCollection_dataset.setFieldReadOnly("txccy",true);
		BopKDsCollection_dataset.setFieldReadOnly("fcyamt",true);
		BopKDsCollection_dataset.setFieldReadOnly("txamt",true);
		BopKDsCollection_dataset.setFieldReadOnly("othacc",true);
		BopKDsCollection_dataset.setFieldReadOnly("buscode",true);
		BopKDsCollection_dataset.setFieldReadOnly("othamt",true);
		BopKDsCollection_dataset.setFieldReadOnly("actuccy",true);
		BopKDsCollection_dataset.setFieldReadOnly("actuamt",true);
		BopKDsCollection_dataset.setFieldReadOnly("outchargeccy",true);
		BopKDsCollection_dataset.setFieldReadOnly("outchargeamt",true);
		BopKDsCollection_dataset.setFieldReadOnly("method",true);
		BopKDsCollection_dataset.setFieldReadOnly("lcbgno",true);
		BopKDsCollection_dataset.setFieldReadOnly("issdate",true);
		BopKDsCollection_dataset.setFieldReadOnly("tenor",true);
		// 系统信息只读
		BopKDsCollection_dataset.setFieldReadOnly("actiontype",true);
		BopKDsCollection_dataset.setFieldReadOnly("recStatus",true);
		BopKDsCollection_dataset.setFieldReadOnly("approveStatus",true);
		BopKDsCollection_dataset.setFieldReadOnly("repStatus",true);
		BopKDsCollection_dataset.setFieldReadOnly("crtTm",true);
		BopKDsCollection_dataset.setFieldReadOnly("lstUpdTm",true);
		BopKDsCollection_dataset.setFieldReadOnly("approveResult",true);
		
		//TODO 判断回执详细
		var repStatus = BopKDsCollection_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
	}
	
	function loadCDsPage(){
		//弹出签约信息选择框
		showPickup("基础信息","${contextPath}/fpages/bop/collandaudit/ckp/ftl/winloadpage/BopCDsLoadPage.ftl?type=report");
	}
	
	function btSave_onClickCheck(){
		if (op == "new" || op == "modify") {
			
		}
		if (op == "delete") {
			var actiondesc = BopKDsCollection_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("请填写删除原因！");
				return false;
			}
		}
		BopKDsCollection_dataset.setParameter("op", op);
		return true;
	}
	
	function doRepDet(){
		var id = BopKDsCollection_dataset.getValue("id");
		var appType = BopKDsCollection_dataset.getValue("appType");
		var currentfile = BopKDsCollection_dataset.getValue("currentfile");
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