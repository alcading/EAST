<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="管理信息">
 <@CommonQueryMacro.CommonQuery id="BopQDsCollectionInfo" init="true" submitMode="all" navigate="false">
<table width="90%" cellpadding="2">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td><@CommonQueryMacro.GroupBox id="group1" label="基础信息"
						expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td colspan="2" align="center" nowrap class="labeltd">申报号码</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="rptno"/>
										<input id="btLoadPage" extra="button" style='width=25px;height=17px;' onclick="loadBase();" type='button' value='...'/>
									</td>
									<td rowspan="2" colspan="1" align="center" nowrap class="labeltd">收款人信息</td>
									<td colspan="1" align="center" nowrap class="labeltd">收款人名称</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="oppuser"/></td>
								</tr>
								<tr>
									<td rowspan="4" colspan="1" align="center" nowrap class="labeltd">汇款人信息</td>
									<td colspan="1" align="center" nowrap class="labeltd">汇款人类型</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="custype"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">收款人账号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="oppacc"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">个人身份证件号码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="idcode"/></td>
									<td rowspan="3" colspan="1" align="center" nowrap class="labeltd">购汇信息</td>
									<td align="center" nowrap class="labeltd">购汇金额</td> 
									<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyamt"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">组织机构代码 </td> 
									<td class="datatd"><@CommonQueryMacro.SingleField fId="custcod"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">购汇汇率</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="exrate"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">汇款人名称 </td> 
									<td class="datatd"><@CommonQueryMacro.SingleField  fId="custnm"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">人民币帐号/银行卡号 </td> 
									<td class="datatd"><@CommonQueryMacro.SingleField  fId="lcyacc"/></td>
								</tr>
								<tr>
									<td rowspan="3" colspan="1" align="center" nowrap class="labeltd">汇款信息</td>
									<td colspan="1" align="center" nowrap class="labeltd">汇款币种</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="txccy"/></td>
									<td rowspan="2" colspan="1" align="center" nowrap class="labeltd">现汇信息</td>
									<td align="center" nowrap class="labeltd">现汇金额</td> 
									<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyamt"/></td>
								</tr>
								<tr>
									<td rowspan="1" align="center" nowrap class="labeltd">汇款金额</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="txamt"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">外汇帐号/银行卡号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyacc"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">结算方式</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="method"/></td>
									<td rowspan="2" colspan="1" align="center" nowrap class="labeltd">其他信息</td>
									<td colspan="1" align="center" nowrap class="labeltd">其它金额</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="othamt"/></td>
								</tr>
								<tr>
									<td colspan="2" align="center" nowrap class="labeltd">银行业务编号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="buscode"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">其它帐号/银行卡号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="othacc"/></td>
								</tr>
							</table> 
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
				<tr>
				<td>
					<@CommonQueryMacro.GroupBox id="group2" label="管理信息" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">收款人常驻国家/地区代码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="country"/></td>
								<td colspan="2" align="center" nowrap class="labeltd">是否保税货物项下付款</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="isref"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">付款类型</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="paytype"/></td>
								<td colspan="2" align="center" nowrap class="labeltd">付汇性质</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="payattr"/></td>
							</tr>
							<tr>
								<td rowspan="2" align="center" nowrap class="labeltd">交易信息1</td>
								<td colspan="1" align="center" nowrap class="labeltd">交易编码1</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txcode"/></td>
								<td rowspan="2" align="center" nowrap class="labeltd">交易信息2</td>
								<td colspan="1" align="center" nowrap class="labeltd">交易编码2</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txcode2"/></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">相应金额1</td>
								<td class="datatd"><@CommonQueryMacro.SingleField	fId="tc1amt"/></td>
								<td align="center" nowrap class="labeltd">相应金额2</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="tc2amt"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">合同号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="contrno"/></td>
								<td colspan="2" align="center" nowrap class="labeltd">发票号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="invoino"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">外汇局批件号/备案表号/业务编号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="regno"/></td>
								<td colspan="2" align="center" nowrap class="labeltd">填报人</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="crtuser"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">填报人电话</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="inptelc"/></td>
								<td colspan="2" align="center" nowrap class="labeltd">申报日期</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="rptdate"/></td>
							</tr>
							<tr>
							    <td colspan="2" align="center" nowrap class="labeltd">业务流水号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
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
					<td><@CommonQueryMacro.GroupBox id="groupbox3" label="系统信息"
						expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd" width="25%">操作类型</td>
								<td nowrap class="datatd" width="25%">
									<@CommonQueryMacro.SingleField fId="actiontype" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" width="25%">记录状态</td>
								<td class="datatd" width="25%">
									<@CommonQueryMacro.SingleField fId="recStatus" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">审批状态</td>
								<td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="approveStatus" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">回执状态</td>
								<td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a>
								</td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">创建时间</td>
								<td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="crtTm" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">最后更新时间</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="lstUpdTm" /></td>
							</tr>
						</table> </@CommonQueryMacro.GroupBox></td>
				</tr>
				<tr id="actiondescTrTd"><td>
					<@CommonQueryMacro.GroupBox id="groupbox4" label="修改/删除原因"  expand="true">
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
	<tr >
		<td align="left" colspan="3">
			<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="javascript">
    var op = "${RequestParameters["op"]?default('')}";
	var ds = BopQDsCollectionInfo_dataset;
    //当页面初始化完之后可以调用该方法执行需要处理的操作
	function initCallGetter_post() {
		// 判断审核详细和回执详细
		var repStatus = ds.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
		ds.setFieldReadOnly("actiontype",true);
		ds.setFieldReadOnly("recStatus",true);
		ds.setFieldReadOnly("approveStatus",true);
		ds.setFieldReadOnly("approveResult",true);
		ds.setFieldReadOnly("repStatus",true);
		ds.setFieldReadOnly("crtTm",true);
		ds.setFieldReadOnly("lstUpdTm",true);
		//基础信息只读
		ds.setFieldReadOnly("rptno",true);
		ds.setFieldReadOnly("custype",true);
		ds.setFieldReadOnly("idcode",true);
		ds.setFieldReadOnly("custcod",true);
		ds.setFieldReadOnly("custnm",true);
		ds.setFieldReadOnly("oppuser",true);
		ds.setFieldReadOnly("oppacc",true);
		ds.setFieldReadOnly("txccy",true);
		ds.setFieldReadOnly("txamt",true);
		ds.setFieldReadOnly("exrate",true);
		ds.setFieldReadOnly("lcyamt",true);
		ds.setFieldReadOnly("lcyacc",true);
		ds.setFieldReadOnly("fcyamt",true);
		ds.setFieldReadOnly("fcyacc",true);
		ds.setFieldReadOnly("othamt",true);
		ds.setFieldReadOnly("othacc",true);
		ds.setFieldReadOnly("method",true);
		ds.setFieldReadOnly("buscode",true);
		
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读  add by  huangcheng
		var subSuccess = ds.getValue("subSuccess");
		if(subSuccess=="0"&&"mod"==op){
			ds.setFieldReadOnly("actiondesc",true);			
		}
		if(op == "add") {
			$("#actiondescTrTd").get(0).style.display="none";
			$("#systemMessageTable").get(0).style.display="none";
		} else if(op == "det") {
			//所有信息只读
			setCommonReadOnly();
			ds.setFieldReadOnly("actiondesc",true);
			$("#btLoadPage").hide();
			//保存按钮隐藏
			$("#btSave").get(0).style.display="none";
		} else if(op == "del") {
			ds.getField("actiondesc").required = true;
			$("#btLoadPage").hide();
			setCommonReadOnly();
		}
	}
	
	function setCommonReadOnly() {
		ds.setFieldReadOnly("country",true);
		ds.setFieldReadOnly("isref",true);
		ds.setFieldReadOnly("paytype",true);
		ds.setFieldReadOnly("payattr",true);
		ds.setFieldReadOnly("txcode",true);
		ds.setFieldReadOnly("tc1amt",true);
		ds.setFieldReadOnly("txcode2",true);
		ds.setFieldReadOnly("tc2amt",true);
		ds.setFieldReadOnly("contrno",true);
		ds.setFieldReadOnly("invoino",true);
		ds.setFieldReadOnly("regno",true);
		ds.setFieldReadOnly("crtuser",true);
		ds.setFieldReadOnly("inptelc",true);
		ds.setFieldReadOnly("rptdate",true);
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
		ds.setParameter("op",op);
		return true;
	}
	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}
	
	//弹出境内汇款申请书-基础信息选择框
	function loadBase(){
		showPickup("境内汇款申请书-基础信息","${contextPath}/fpages/bop/collandaudit/eq/ftl/winloadpage/BopEQDsCollectionLoadPage.ftl");
	}
	function txcode_DropDown_beforeOpen(dropDown){
		MtsInOutCodeTreeSelect_DropDownDataset.setParameter("headDataTypeNo","01");
		MtsInOutCodeTreeSelect_DropDownDataset.setParameter("codeType","BOP-OUT");
	}
	function txcode2_DropDown_beforeOpen(dropDown){
		MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("headDataTypeNo","01");
		MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("codeType","BOP-OUT");
	}
</script>
</@CommonQueryMacro.page>
