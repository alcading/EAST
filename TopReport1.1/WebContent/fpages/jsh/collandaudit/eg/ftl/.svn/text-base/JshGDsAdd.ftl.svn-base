<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="基础信息">
<@CommonQueryMacro.CommonQuery id="JshGDsAdd" init="true" insertOnEmpty="true" navigate="false">
<table  width="95%" cellpadding="2">
			<tr>
				<td  width="75%" valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
									<table frame="void" class="grouptable" width="100%">
							           <tr>
								          <td colspan="2" align="center" nowrap class="labeltd">申报号码</td>
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="rptno"/><input id="loadLoanButton" extra="button" style='width=25px;height=17px;' onclick="loadLoan();" type='button' value='...'/></td>

								          <td colspan="1" rowspan="3" align="center" nowrap class="labeltd">外汇信息</td>
								          <td colspan="1" align="center" nowrap class="labeltd">外汇账户账号</td>
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="fcyacc"/></td>

							           </tr>
							           <tr>
								          <td colspan="1" rowspan="4" align="center" nowrap class="labeltd">购汇申请人信息</td>
								          <td colspan="1" align="center" nowrap class="labeltd">购汇申请人主体类型</td>
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="custype"/></td>
																
								          <td colspan="1" align="center" nowrap class="labeltd">外汇收款人名称</td>
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="oppuser"/></td>
							          								
							           </tr>
							           <tr>
							              <td colspan="1" align="center" nowrap class="labeltd">购汇申请人组织机构代码</td>
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="custcod"/></td>
								
								          <td colspan="1" align="center" nowrap class="labeltd">外汇账户开户行</td>
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="oppbank"/></td>

							           </tr>
							           <tr>
							               <td colspan="1" align="center" nowrap class="labeltd">购汇申请人个人身份证件号码</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="idcode"/></td>
							  
							               <td colspan="1" rowspan="3" align="center" nowrap class="labeltd">购汇信息</td>
										   <td colspan="1" align="center" nowrap class="labeltd">购汇币别</td>
										   <td class="datatd"><@CommonQueryMacro.SingleField fId="lcyccy"/></td>
							     
							           </tr>
							           <tr>
							               <td colspan="1" align="center" nowrap class="labeltd">购汇申请人名称</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="custnm"/></td>

								           <td colspan="1" align="center" nowrap class="labeltd">购汇金额</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="lcyamt"/></td>												    
							           </tr>
							           <tr>
								           <td colspan="2" align="center" nowrap class="labeltd">人民币账户账号</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="lcyacc"/></td>
							  
                                           <td colspan="1" align="center" nowrap class="labeltd">汇率</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="exrate"/></td>
                              
								
							           </tr>
							           <tr>					
								          <td colspan="2" align="right" nowrap class="labeltd">银行业务编号</td>
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="buscode"/></td>									
							           </tr>
							
						            </table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup2" label="管理信息" expand="true">
									<table frame="void" class="grouptable" width="100%">
							           <tr>
								           <td colspan="2" align="center" nowrap class="labeltd">外汇局批件/备案表号/业务编号</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="regno"/></td>

                                           <td colspan="1"  rowspan="2" align="center" nowrap class="labeltd">填报人信息</td>
                                           <td colspan="1" align="center" nowrap class="labeltd">填报人</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="crtuser"/></td>
							           </tr>
							           <tr>
								           <td colspan="2" align="right" nowrap class="labeltd">交易编码</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="txcode"/></td>
								
								           <td colspan="1" align="center" nowrap class="labeltd">填报人电话</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="inptelc"/></td>
							           </tr>
							           <tr>
							               <td colspan="2" align="center" nowrap class="labeltd">业务流水号</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
								
								           <td colspan="2" align="center" nowrap class="labeltd">申报日期</td>
								           <td class="datatd"><@CommonQueryMacro.SingleField fId="rptdate"/></td>						
							           </tr>					
						            </table>
								</@CommonQueryMacro.GroupBox>
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
											<td  align="center" nowrap class="labeltd" width="25%">记录状态</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="recStatus"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" > 审批状态 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveStatus" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" > 审批结果 </td>
											<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveResult" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" > 回执状态 </td>
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
	//系统信息只读
	function initCallGetter_post() {
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读  
		var subSuccess = JshGDsAdd_dataset.getValue("subSuccess");
		if(subSuccess=="0"&&"mod"==op){
			JshGDsAdd_dataset.setFieldReadOnly("actiondesc",true);			
		}
		var approveStatus = JshGDsAdd_dataset.getValue("approveStatus");
		if (approveStatus == "00") {
			//document.getElementById("approveHref").style.color="#999999";
		}
		var repStatus = JshGDsAdd_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
		// 基础信息只读
		JshGDsAdd_dataset.setFieldReadOnly("rptno",true);
		JshGDsAdd_dataset.setFieldReadOnly("buscode",true);
		JshGDsAdd_dataset.setFieldReadOnly("custype",true);
		JshGDsAdd_dataset.setFieldReadOnly("custcod",true);
		JshGDsAdd_dataset.setFieldReadOnly("idcode",true);
		JshGDsAdd_dataset.setFieldReadOnly("custnm",true);
		JshGDsAdd_dataset.setFieldReadOnly("lcyacc",true);
		JshGDsAdd_dataset.setFieldReadOnly("fcyacc",true);
		JshGDsAdd_dataset.setFieldReadOnly("oppuser",true);
		JshGDsAdd_dataset.setFieldReadOnly("oppbank",true);
		JshGDsAdd_dataset.setFieldReadOnly("lcyamt",true);			
		JshGDsAdd_dataset.setFieldReadOnly("lcyccy",true);
		JshGDsAdd_dataset.setFieldReadOnly("exrate",true);
		
		// 系统信息只读
		JshGDsAdd_dataset.setFieldReadOnly("actiontype",true);
		JshGDsAdd_dataset.setFieldReadOnly("recStatus",true);
		JshGDsAdd_dataset.setFieldReadOnly("approveStatus",true);
		JshGDsAdd_dataset.setFieldReadOnly("approveResult",true);
		JshGDsAdd_dataset.setFieldReadOnly("repStatus",true);
		JshGDsAdd_dataset.setFieldReadOnly("crtTm",true);
		JshGDsAdd_dataset.setFieldReadOnly("lstUpdTm",true);
		if("new" == op)
		{
			
			JshGDsAdd_dataset.setFieldReadOnly("crtTm",true);
			window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('xitong').style.display="none";
			window.document.getElementById('repHerf').style.display="none";
			JshGDsAdd_dataset.setFieldReadOnly("crtTm",true);
		} else if("mod" == op) {
			JshGDsAdd_dataset.setFieldReadOnly("approveStatus",true);
			JshGDsAdd_dataset.setFieldReadOnly("actiontype",true);
			JshGDsAdd_dataset.setFieldReadOnly("crtTm",true);
			JshGDsAdd_dataset.setFieldReadOnly("approveResult",true);
			JshGDsAdd_dataset.setFieldReadOnly("filler2",true);
			
		}
		else if("del" == op)
		{
			$("#loadLoanButton").hide();
			JshGDsAdd_dataset.getField("actiondesc").required=true;
			JshGDsAdd_dataset.setFieldReadOnly("filler2",true);
			JshGDsAdd_dataset.setFieldReadOnly("regno",true);
			
			JshGDsAdd_dataset.setFieldReadOnly("txcode",true);
			JshGDsAdd_dataset.setFieldReadOnly("crtuser",true);
			JshGDsAdd_dataset.setFieldReadOnly("inptelc",true);
			JshGDsAdd_dataset.setFieldReadOnly("rptdate",true);
			JshGDsAdd_dataset.setFieldReadOnly("filler2",true);
			JshGDsAdd_dataset.setFieldReadOnly("approveResult",true);
		}
		else if("detail" == op)
		{
			JshGDsAdd_dataset.readOnly=true;
			$("#btSave").hide();
			$("#loadLoanButton").hide();
			JshGDsAdd_dataset.setFieldReadOnly("actiondesc",true);
			JshGDsAdd_dataset.setFieldReadOnly("approveResult",true);
            JshGDsAdd_dataset.setFieldReadOnly("regno",true);
			
			JshGDsAdd_dataset.setFieldReadOnly("txcode",true);
			JshGDsAdd_dataset.setFieldReadOnly("crtuser",true);
			JshGDsAdd_dataset.setFieldReadOnly("inptelc",true);
			JshGDsAdd_dataset.setFieldReadOnly("rptdate",true);
			JshGDsAdd_dataset.setFieldReadOnly("filler2",true);
		}
	}
	function btBack_onClick() {
		closeWin();
	}

	//保存按钮提交前检查统一设置
	function btSave_onClickCheck(button) {
	
		if(op == "del") {
			var actiondesc = JshGDsAdd_dataset.getValue("actiondesc");
			if(actiondesc == null || actiondesc == "") {
				alert("字段[删除原因]不能为空");
				return false;
			}
		}
		JshGDsAdd_dataset.setParameter("op",op);
		return true;
	}
	
	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}
	//弹出外汇账户购汇基础信息选择框
	function loadLoan(){
		
		showPickup("境内收入申报单基础信息","${contextPath}/fpages/jsh/collandaudit/eg/ftl/winloadpage/JshELoadPage.ftl");
	}
 
	function txcode_DropDown_beforeOpen(dropDown){
     	MtsInOutCodeTreeSelect_DropDownDataset.setParameter("headDataTypeNo","01");
    	MtsInOutCodeTreeSelect_DropDownDataset.setParameter("codeType","BOP-OUT");
    }
</script>
</@CommonQueryMacro.page>
