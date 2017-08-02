<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="申报信息">
<@CommonQueryMacro.CommonQuery id="bopGDsRecordInfo" init="true" insertOnEmpty="true" navigate="false">
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
								<td class="datatd">
									<@CommonQueryMacro.SingleField fId="rptno"/>
									<input id="btLoadPage" extra="button" style='width=25px;height=17px;' onclick="loadBase();" type='button' value='...'/>
								</td>
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
							</tr>
						</table> 
						</@CommonQueryMacro.GroupBox>
						</td>
				</tr>
				<tr>
			<td>
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
					<@CommonQueryMacro.GroupBox id="groupbox2" label="申报信息" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">是否出口核销项下收汇 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="isref" /></td>
								<td colspan="2" align="center" nowrap class="labeltd">收入类型 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="payattr" /></td>
							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">付款人常驻国家/地区代码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="country" /></td>
								<td colspan="2" align="center" nowrap class="labeltd">收款性质</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="paytype" /></td>
							</tr>
							<tr>
								<td colspan="1" rowspan="3" align="center" nowrap class="labeltd">交易信息1</td>
								<td align="center" nowrap class="labeltd">交易编码1</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txcode" /></td>
								<td colspan="1" rowspan="3" align="center" nowrap class="labeltd">交易信息2</td>
								<td align="center" nowrap class="labeltd">交易编码2</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txcode2" /></td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">相应金额1</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="tc1amt" /></td>
								<td colspan="1" align="center" nowrap class="labeltd">相应金额2</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="tc2amt" /></td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">交易附言1</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="txrem" /></td>
								<td colspan="1" align="center" nowrap class="labeltd">交易附言2</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="tx2rem" /></td>
							</tr>
							<tr>
								<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">填报信息</td>
								<td align="center" nowrap class="labeltd">填报人 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="crtuser" /></td>
								<td colspan="2" align="center" nowrap class="labeltd">外汇局批件号/备案表号/业务编号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="billno" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">填报人电话 </td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="inptelc" /></td>
								<td colspan="2" align="center" nowrap class="labeltd">申报日期</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="rptdate" /></td>
							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">业务流水号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2" /></td>
							</tr>
						</table>
						</@CommonQueryMacro.GroupBox>
					</td>
			</tr>
		</table>
	</td>
</tr>
			</table>
		     </td>
		     <td  valign="top">
			     <table width="100%" cellpadding="0" cellspacing="0">
				    <tr>
					   <td id="systemMessageTd"><@CommonQueryMacro.GroupBox id="groupbox3"
						   label="系统信息" expand="true">
						   <table frame=void class="grouptable" width="100%">
							   <tr>
								  <td align="center" nowrap class="labeltd" >操作类型</td>
								   <td nowrap class="datatd">
									<@CommonQueryMacro.SingleField fId="actiontype" /></td>
							   </tr>

							   <tr>
								  <td align="center" nowrap class="labeltd" >记录状态</td>
								  <td class="datatd">
									<@CommonQueryMacro.SingleField fId="recStatus" /></td>
							   </tr>

							   <tr>
								  <td align="center" nowrap class="labeltd">审批状态</td>
								  <td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="approveStatus" /></td>
							   </tr>

							   <tr>
								  <td align="center" nowrap class="labeltd">审批结果</td>
								  <td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="approveResult" /></td>
							   </tr>
							   <tr>
								   <td align="center" nowrap class="labeltd">回执状态</td>
								   <td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="repStatus" /> <a id="repHerf" href="javascript:doRepDet()">回执结果</a>
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
						   </table> 
						   </@CommonQueryMacro.GroupBox>
						 </td>
				    </tr>
				    <tr id="actiondescTrTd"><td>
						<@CommonQueryMacro.GroupBox id="groupbox4" label="修改/删除原因"  expand="true">
							<table frame=void class="grouptable" width="100%" >
								<tr>
									<td align="center" nowrap class="labeltd">修改/删除原因</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="actiondesc"/></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
						</td>
					</tr>
			     </table>
		     </td>
	     </tr>
	  </table>
	 </td>
   </tr>
<tr>
	<td align="left" colspan="3">
		<@CommonQueryMacro.Button id="btSave"/>&nbsp;
		&nbsp;<@CommonQueryMacro.Button id="btBack"/>
	</td>
</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	var op = "${RequestParameters["op"]?default('')}";
	var ds = bopGDsRecordInfo_dataset;
	//系统信息只读
	function initCallGetter_post(){
		// 判断审核详细和回执详细
		var repStatus = bopGDsRecordInfo_dataset.getValue("repStatus");
		if (repStatus == "00" || repStatus == "01") {
			document.getElementById("repHerf").href="javascript:void(0)";
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
		ds.setFieldReadOnly("filler1",true);
		ds.setFieldReadOnly("rptno",true);
		ds.setFieldReadOnly("custype",true);
		ds.setFieldReadOnly("idcode",true);
		ds.setFieldReadOnly("custcod",true);
		ds.setFieldReadOnly("custnm",true);
		ds.setFieldReadOnly("oppuser",true);
		ds.setFieldReadOnly("txccy",true);
		ds.setFieldReadOnly("txamt",true);
		ds.setFieldReadOnly("exrate",true);
		ds.setFieldReadOnly("lcyamt",true);
		ds.setFieldReadOnly("lcyacc",true);
		ds.setFieldReadOnly("fcyamt",true);
		ds.setFieldReadOnly("fcyacc",true);
		ds.setFieldReadOnly("othamt",true);
		ds.setFieldReadOnly("othacc",true);
		ds.setFieldReadOnly("inchargeccy",true);
		ds.setFieldReadOnly("inchargeamt",true);
		ds.setFieldReadOnly("outchargeccy",true);
		ds.setFieldReadOnly("outchargeamt",true);
		ds.setFieldReadOnly("method",true);
		ds.setFieldReadOnly("buscode",true);
		
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读  add by  huangcheng
		var subSuccess = ds.getValue("subSuccess");
		if(subSuccess=="0"&&"mod"==op){
			ds.setFieldReadOnly("actiondesc",true);		
			document.getElementById("btLoadPage").style.display="none";	
		}
		if (op == "add") {
			window.document.getElementById('systemMessageTd').style.display="none";
			window.document.getElementById('actiondescTrTd').style.display="none";
		} else if (op == "del") {
			setCommonReadOnly();
			ds.getField("actiondesc").required = true;
			document.getElementById("btLoadPage").style.display="none";
		} else if (op == "det"){
			$("#btSave").get(0).style.display="none";
			document.getElementById("btLoadPage").style.display="none";
			//所有信息只读
			setCommonReadOnly();
			ds.setFieldReadOnly("actiondesc",true);
		}
	}
	//属性的只读统一设置
	function setCommonReadOnly() {
		ds.setFieldReadOnly("isref",true);
		ds.setFieldReadOnly("country",true);
		ds.setFieldReadOnly("paytype",true);
		ds.setFieldReadOnly("payattr",true);
		ds.setFieldReadOnly("txcode",true);
		ds.setFieldReadOnly("tc1amt",true);
		ds.setFieldReadOnly("txrem",true);
		ds.setFieldReadOnly("txcode2",true);
		ds.setFieldReadOnly("tc2amt",true);
		ds.setFieldReadOnly("tx2rem",true);
		ds.setFieldReadOnly("crtuser",true);
		ds.setFieldReadOnly("inptelc",true);
		ds.setFieldReadOnly("rptdate",true);
		ds.setFieldReadOnly("billno",true);
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
	
	//弹出涉外收入申报单基础信息选择框
	function loadBase(){		
		showPickup("涉外收入申报单基础信息","${contextPath}/fpages/bop/collandaudit/ag/ftl/winloadpage/BopAGLoadPage.ftl?currentfile=G");
	}
	function txcode_DropDown_beforeOpen(dropDown){
		MtsInOutCodeTreeSelect_DropDownDataset.setParameter("headDataTypeNo","01");
		MtsInOutCodeTreeSelect_DropDownDataset.setParameter("codeType","BOP-IN");
	}
	function txcode2_DropDown_beforeOpen(dropDown){
		MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("headDataTypeNo","01");
		MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("codeType","BOP-IN");
	}
</script>
</@CommonQueryMacro.page>