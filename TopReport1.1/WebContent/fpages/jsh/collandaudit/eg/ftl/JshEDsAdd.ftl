<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="基础信息">
<@CommonQueryMacro.CommonQuery id="JshEDsAdd" init="true" insertOnEmpty="true" navigate="false">
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
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="rptno"/></td>

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
								           <td colspan="2" align="right" nowrap class="labeltd">业务流水号</td>
								          <td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>									
							           </tr>
							
						            </table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
						<tr>
				            <td align="left" colspan="3">
					        <@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
					        <@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
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

			
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript"> 
	var op = "${RequestParameters["op"]?default('')}";
	<#assign v_branchcode = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getBrno()>
	//系统信息只读
	function initCallGetter_post() {
		//上报成功  删除/修改原因 必填   上报未生成  删除/修改设只读  
		var subSuccess = JshEDsAdd_dataset.getValue("subSuccess");
		if(subSuccess=="0"&&"mod"==op){
			JshEDsAdd_dataset.setFieldReadOnly("actiondesc",true);			
		}
		var approveStatus = JshEDsAdd_dataset.getValue("approveStatus");
		if (approveStatus == "00") {
			//document.getElementById("approveHref").style.color="#999999";
		}
		var repStatus = JshEDsAdd_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
		
		// 系统信息只读
		JshEDsAdd_dataset.setFieldReadOnly("actiontype",true);
		JshEDsAdd_dataset.setFieldReadOnly("recStatus",true);
		JshEDsAdd_dataset.setFieldReadOnly("approveStatus",true);
		JshEDsAdd_dataset.setFieldReadOnly("approveResult",true);
		JshEDsAdd_dataset.setFieldReadOnly("repStatus",true);
		JshEDsAdd_dataset.setFieldReadOnly("crtTm",true);
		JshEDsAdd_dataset.setFieldReadOnly("lstUpdTm",true);
		if("new" == op)
		{
			JshEDsAdd_dataset.setFieldReadOnly("crtTm",true);
			JshEDsAdd_dataset.setFieldReadOnly("rptno",true);
			window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('xitong').style.display="none";
			window.document.getElementById('repHerf').style.display="none";
			
			JshEDsAdd_dataset.setFieldReadOnly("crtTm",true);
		} else if("mod" == op) {
			JshEDsAdd_dataset.setFieldReadOnly("filler2",true);
			JshEDsAdd_dataset.setFieldReadOnly("approveStatus",true);
			JshEDsAdd_dataset.setFieldReadOnly("actiontype",true);
			JshEDsAdd_dataset.setFieldReadOnly("crtTm",true);
		}
		else if("del" == op)
		{
			JshEDsAdd_dataset.getField("actiondesc").required=true;
			JshEDsAdd_dataset.setFieldReadOnly("filler2",true);
			JshEDsAdd_dataset.setFieldReadOnly("rptno",true);			
			JshEDsAdd_dataset.setFieldReadOnly("buscode",true);
			JshEDsAdd_dataset.setFieldReadOnly("custype",true);
			JshEDsAdd_dataset.setFieldReadOnly("custcod",true);
			JshEDsAdd_dataset.setFieldReadOnly("idcode",true);
			JshEDsAdd_dataset.setFieldReadOnly("custnm",true);
			JshEDsAdd_dataset.setFieldReadOnly("lcyacc",true);
			JshEDsAdd_dataset.setFieldReadOnly("fcyacc",true);
			JshEDsAdd_dataset.setFieldReadOnly("oppuser",true);
			JshEDsAdd_dataset.setFieldReadOnly("oppbank",true);
			JshEDsAdd_dataset.setFieldReadOnly("lcyamt",true);			
			JshEDsAdd_dataset.setFieldReadOnly("lcyccy",true);
			JshEDsAdd_dataset.setFieldReadOnly("exrate",true);
		}
		else if("detail" == op)
		{
			JshEDsAdd_dataset.readOnly=true;
			$("#btSave").hide();
			JshEDsAdd_dataset.setFieldReadOnly("filler2",true);
			JshEDsAdd_dataset.setFieldReadOnly("rptno",true);
			JshEDsAdd_dataset.setFieldReadOnly("buscode",true);
			JshEDsAdd_dataset.setFieldReadOnly("custype",true);
			JshEDsAdd_dataset.setFieldReadOnly("custcod",true);
			JshEDsAdd_dataset.setFieldReadOnly("idcode",true);
			JshEDsAdd_dataset.setFieldReadOnly("custnm",true);
			JshEDsAdd_dataset.setFieldReadOnly("lcyacc",true);
			JshEDsAdd_dataset.setFieldReadOnly("fcyacc",true);
			JshEDsAdd_dataset.setFieldReadOnly("oppuser",true);
			JshEDsAdd_dataset.setFieldReadOnly("oppbank",true);
			JshEDsAdd_dataset.setFieldReadOnly("lcyamt",true);			
			JshEDsAdd_dataset.setFieldReadOnly("lcyccy",true);
			JshEDsAdd_dataset.setFieldReadOnly("exrate",true);
			JshEDsAdd_dataset.setFieldReadOnly("actiondesc",true);
		}
	}
	function btBack_onClick() {
		closeWin();
	}


	function btSave_onClickCheck(button) {
		if(op=="del"){
			var actiondesc = JshEDsAdd_dataset.getValue("actiondesc");
			if(actiondesc == null || actiondesc == "") {
				alert("字段[删除原因]不能为空");
				return false;
			}
		}
		JshEDsAdd_dataset.setParameter("op",op);
		return true;
	}	
	
	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}

</script>
</@CommonQueryMacro.page>
