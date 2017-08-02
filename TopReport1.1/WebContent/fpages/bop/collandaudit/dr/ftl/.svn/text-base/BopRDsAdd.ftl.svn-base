<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> 
<@CommonQueryMacro.page title="管理信息">
<@CommonQueryMacro.CommonQuery id="BopRDsAdd" init="true" submitMode="all" navigate="false">
<table width="95%" cellpadding="2">
			<tr>
				<td  width="75%" valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="groupbox1" label="基础信息" expand="true">
						       <table frame="void" class="grouptable" width="100%">
									<tr>
										<td colspan="2" align="center" nowrap class="labeltd">申报号码</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="rptno"/><input id="loadLoanButton" extra="button" style='width=25px;height=17px;' onclick="loadLoan();" type='button' value='...'/></td>
																				
										<td colspan="2" align="center" nowrap class="labeltd">付款人名称</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="oppuser"/></td>		
									</tr>
									<tr>
									    <td colspan="1" rowspan="4" align="center" nowrap class="labeltd">收款人信息</td>
										<td rowspan="1" align="right" nowrap class="labeltd">收款人类型</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="custype"/></td>
										<td colspan="1" rowspan="3" align="center" nowrap class="labeltd">结汇信息</td>
		                                <td colspan="1" align="center" nowrap class="labeltd">人民币帐号/银行卡号</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyacc"/></td>								
									</tr>
									<tr>
										<td colspan="1" align="center" nowrap class="labeltd">收款人名称</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="custnm"/></td>
												
		                                <td align="center" nowrap class="labeltd">结汇金额</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="lcyamt"/></td>
											
									</tr>
									<tr>
										
									    <td colspan="1"  align="center" nowrap class="labeltd">个人身份证件号码</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="idcode"/></td>			   
										  								
		                                <td colspan="1" align="center" nowrap class="labeltd">结汇汇率</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="exrate"/></td> 
											
									</tr>
									<tr>
									    <td colspan="1" align="center" nowrap class="labeltd">组织机构代码</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="custcod"/></td>
											 
										<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">现汇信息</td>	
			                            <td colspan="1" align="center" nowrap class="labeltd">外汇帐号/银行卡号</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyacc"/></td>	
											
									</tr>
									<tr>
										<td colspan="1" rowspan="3" align="center" nowrap class="labeltd">收入款信息</td>
											
			                            <td rowspan="1" align="center" nowrap class="labeltd">收入款金额</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="txamt"/></td>
											
										<td align="center" colspan="1" nowrap class="labeltd">现汇金额</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="fcyamt"/></td>
			
									</tr>							
									<tr>					
							     		<td rowspan="1" align="center" nowrap class="labeltd">收入款币种</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="txccy"/></td>
										
										<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">其它信息</td>
										<td colspan="1" align="center" nowrap class="labeltd">其它帐号/银行卡号</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="othamt"/></td>						
									</tr>
									<tr>
																
									    <td colspan="1" align="center" nowrap class="labeltd">结算方式</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="method"/></td>	
											
										<td colspan="1" align="center" nowrap class="labeltd">其它金额</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="othacc"/></td>																			
									</tr>							
									<tr>	
									    <td colspan="1" rowspan="2" align="center" nowrap class="labeltd">国内银行扣费信息</td>	
										<td colspan="1" align="center" nowrap class="labeltd">国内银行扣费金额</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="inchargeamt"/></td>
				
										<td colspan="2" align="center" nowrap class="labeltd">银行业务编号</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="buscode"/></td>
									</tr>							
									<tr>
										<td colspan="1" align="center" nowrap class="labeltd">国内银行扣费币种</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="inchargeccy"/></td>				                     									
									</tr>
							
						       </table> 
							   </@CommonQueryMacro.GroupBox>
							</td>
						</tr>
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="groupbox1" label="管理信息"	expand="true">
								<table frame="void" class="grouptable" width="100%">
									<tr>
										<td colspan="2" align="center" nowrap class="labeltd">是否保税货物项下收汇</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="isref"/></td>
		
										<td colspan="2" align="right" nowrap class="labeltd">境内收入类型</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="payattr"/></td>
		
									</tr>
									<tr>
									    <td colspan="1" rowspan="3" align="center" nowrap class="labeltd">交易信息1</td>
										<td colspan="1" align="center" nowrap class="labeltd">交易编码1</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="txcode"/></td>
										
										<td colspan="1" rowspan="3" align="center" nowrap class="labeltd">交易信息2</td>
										<td colspan="1" align="center" nowrap class="labeltd">交易编码2</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="txcode2"/></td>	
											
									</tr>
									<tr> 	
									    <td colspan="1" align="center" nowrap class="labeltd">相应金额1</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="tc1amt"/></td>	
										<td rowspan="1" align="center" nowrap class="labeltd">相应金额2</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="tc2amt"/></td>					
									</tr>
									<tr>
										<td colspan="1" align="center" nowrap class="labeltd">交易附言1</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="txrem"/></td>
							   
										<td rowspan="1" align="center" nowrap class="labeltd">交易附言2</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="tx2rem"/></td>
									</tr>
									<tr>
										<td colspan="1" rowspan="2" align="center" nowrap class="labeltd">填报信息</td>
										<td colspan="1" align="center" nowrap class="labeltd">填报人</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="crtuser"/></td>	
											
									    <td colspan="2" align="center" nowrap class="labeltd">收款性质 </td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="paytype"/></td>
									</tr>
									<tr>
										<td align="center" nowrap class="labeltd">填报人电话</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="inptelc"/></td>
										<td colspan="2" align="center" nowrap class="labeltd">外汇局批件号/备案表号/业务编号</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="regno"/></td>
									</tr>
									<tr>
										<td colspan="2" align="center" nowrap class="labeltd">申报日期</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="rptdate"/></td>
											
										<td colspan="2" align="center" nowrap class="labeltd">业务流水号</td>
										<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>						
									</tr>
							    </table> </@CommonQueryMacro.GroupBox>
							</td>
						</tr>
					</table>
				</td>

				<td width="8px"></td>
				<td width="25%"  valign="top" id="xitong">
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
							<td id="deleteasc">
								<@CommonQueryMacro.GroupBox id="deleteasc" label="修改/删除信息"   expand="true">
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

<script language="javascript">
	var op = "${RequestParameters["op"]?default('')}";
	<#assign v_branchcode = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getBrno()>
	function doRepDet(){
		var id = ds.getValue("id");
		var appType = ds.getValue("appType");
		var currentfile = ds.getValue("currentfile");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile, 600, 500);
	}
	//系统信息只读
	BopRDsAdd_dataset.setFieldReadOnly("actiontype",true);
	BopRDsAdd_dataset.setFieldReadOnly("recStatus",true);
	BopRDsAdd_dataset.setFieldReadOnly("approveStatus",true);
	BopRDsAdd_dataset.setFieldReadOnly("repStatus",true);
	BopRDsAdd_dataset.setFieldReadOnly("crtTm",true);
	BopRDsAdd_dataset.setFieldReadOnly("lstUpdTm",true);
	BopRDsAdd_dataset.setFieldReadOnly("approveResult",true);
	//基础信息只读
	if(op != "new") {
		BopRDsAdd_dataset.setFieldReadOnly("filler2",true);
	}
	BopRDsAdd_dataset.setFieldReadOnly("rptno",true);
	BopRDsAdd_dataset.setFieldReadOnly("custype",true);
	BopRDsAdd_dataset.setFieldReadOnly("idcode",true);
	BopRDsAdd_dataset.setFieldReadOnly("custcod",true);
	BopRDsAdd_dataset.setFieldReadOnly("custnm",true);
	BopRDsAdd_dataset.setFieldReadOnly("oppuser",true);
	BopRDsAdd_dataset.setFieldReadOnly("txccy",true);
	BopRDsAdd_dataset.setFieldReadOnly("txccyName",true);
	BopRDsAdd_dataset.setFieldReadOnly("txamt",true);
	BopRDsAdd_dataset.setFieldReadOnly("exrate",true);
	BopRDsAdd_dataset.setFieldReadOnly("lcyamt",true);			
	BopRDsAdd_dataset.setFieldReadOnly("lcyacc",true);
	BopRDsAdd_dataset.setFieldReadOnly("fcyamt",true);
	BopRDsAdd_dataset.setFieldReadOnly("fcyacc",true);
	BopRDsAdd_dataset.setFieldReadOnly("othamt",true);
	BopRDsAdd_dataset.setFieldReadOnly("othacc",true);
	BopRDsAdd_dataset.setFieldReadOnly("method",true);
	BopRDsAdd_dataset.setFieldReadOnly("buscode",true);
	BopRDsAdd_dataset.setFieldReadOnly("inchargeccy",true);
	BopRDsAdd_dataset.setFieldReadOnly("inchargeccyName",true);
	BopRDsAdd_dataset.setFieldReadOnly("inchargeamt",true);	
	function initCallGetter_post() {
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读
		var subSuccess = BopRDsAdd_dataset.getValue("subSuccess");
		if(subSuccess=="0"&&"mod"==op){
			BopRDsAdd_dataset.setFieldReadOnly("actiondesc",true);			
		}
		var repStatus = BopRDsAdd_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
		if("new" == op)
		{
			BopRDsAdd_dataset.setFieldReadOnly("crtTm",true);
			window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('xitong').style.display="none";
			window.document.getElementById('repHerf').style.display="none";
			BopRDsAdd_dataset.setFieldReadOnly("crtTm",true);
		} else if("mod" == op) {
			BopRDsAdd_dataset.setFieldReadOnly("crtTm",true);
		}
		else if("del" == op)
		{
			BopRDsAdd_dataset.getField("actiondesc").required=true;
			BopRDsAdd_dataset.setFieldReadOnly("approveStatus",true);
			BopRDsAdd_dataset.setFieldReadOnly("actiontype",true);
			BopRDsAdd_dataset.setFieldReadOnly("crtTm",true);
			BopRDsAdd_dataset.setFieldReadOnly("custype",true);
			BopRDsAdd_dataset.setFieldReadOnly("isref",true);
			BopRDsAdd_dataset.setFieldReadOnly("payattr",true);
			BopRDsAdd_dataset.setFieldReadOnly("paytype",true);
			BopRDsAdd_dataset.setFieldReadOnly("txcode",true);
			BopRDsAdd_dataset.setFieldReadOnly("tc1amt",true);
			BopRDsAdd_dataset.setFieldReadOnly("txrem",true);
			BopRDsAdd_dataset.setFieldReadOnly("txcode2",true);
			BopRDsAdd_dataset.setFieldReadOnly("tc2amt",true);
			BopRDsAdd_dataset.setFieldReadOnly("tx2rem",true);
			BopRDsAdd_dataset.setFieldReadOnly("crtuser",true);			
			BopRDsAdd_dataset.setFieldReadOnly("inptelc",true);
			BopRDsAdd_dataset.setFieldReadOnly("rptdate",true);
			BopRDsAdd_dataset.setFieldReadOnly("regno",true);
			BopRDsAdd_dataset.setFieldReadOnly("filler2",true);
		}
		else if("detail" == op)
		{
			BopRDsAdd_dataset.readOnly=true;
			$("#btSave").hide();
			BopRDsAdd_dataset.setFieldReadOnly("crtTm",true);
			BopRDsAdd_dataset.setFieldReadOnly("approveStatus",true);
			BopRDsAdd_dataset.setFieldReadOnly("actiontype",true);
			BopRDsAdd_dataset.setFieldReadOnly("isref",true);
			BopRDsAdd_dataset.setFieldReadOnly("custype",true);
			BopRDsAdd_dataset.setFieldReadOnly("payattr",true);
			BopRDsAdd_dataset.setFieldReadOnly("paytype",true);
			BopRDsAdd_dataset.setFieldReadOnly("txcode",true);
			BopRDsAdd_dataset.setFieldReadOnly("tc1amt",true);
			BopRDsAdd_dataset.setFieldReadOnly("txrem",true);
			BopRDsAdd_dataset.setFieldReadOnly("txcode2",true);
			BopRDsAdd_dataset.setFieldReadOnly("tc2amt",true);
			BopRDsAdd_dataset.setFieldReadOnly("tx2rem",true);			
			BopRDsAdd_dataset.setFieldReadOnly("crtuser",true);			
			BopRDsAdd_dataset.setFieldReadOnly("inptelc",true);
			BopRDsAdd_dataset.setFieldReadOnly("rptdate",true);
			BopRDsAdd_dataset.setFieldReadOnly("regno",true);
			BopRDsAdd_dataset.setFieldReadOnly("filler2",true);
			BopRDsAdd_dataset.setFieldReadOnly("actiondesc",true);
			$("#loadLoanButton").hide();	
		}
	}
	function btBack_onClick() {
		closeWin();
	}
	//弹出境内收入申报单基础信息选择框
	function loadLoan(){		
		showPickup("境内收入申报单基础信息","${contextPath}/fpages/bop/collandaudit/dr/ftl/winloadpage/BopDLoadPage.ftl?currentfile=R");
	}
	//交易编码下拉框
    
 	 function txcode_DropDown_beforeOpen(dropDown){
        MtsInOutCodeTreeSelect_DropDownDataset.setParameter("headDataTypeNo","01");
        MtsInOutCodeTreeSelect_DropDownDataset.setParameter("codeType","BOP-IN");
	 }
	
	 function txcode2_DropDown_beforeOpen(dropDown){
        MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("headDataTypeNo","01");
        MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("codeType","BOP-IN");
    }
	
	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {
		if(op=="del"){
		   var actiondesc = BopRDsAdd_dataset.getValue("actiondesc");
		   if(actiondesc == null || actiondesc == "") {
			  alert("字段[删除原因]不能为空");
			  return false;
		   }
		}
		BopRDsAdd_dataset.setParameter("op",op);
		return true;
	}

	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}
</script> 
</@CommonQueryMacro.page>