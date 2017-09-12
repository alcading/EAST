<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#global contextPath = contextPath>
<@CommonQueryMacro.page title="管理信息">
<@CommonQueryMacro.CommonQuery id="BopBhnDsManageCollInfo" navigate="false" init="true" insertOnEmpty="true">
<table>
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
					<@CommonQueryMacro.GroupBox id="groupbox1" label="基础信息"
						expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td colspan="2" align="center" nowrap class="labeltd">申报号码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="rptno"/><input id="btLoadPage" extra="button" style='width=25px;height=17px;' onclick="loadAccount();" type='button' value='...'/></td>
									<td colspan="2" align="center" nowrap class="labeltd">收款人名称</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="oppuser"/></td>
								</tr>
								<tr>
									<td rowspan="4" colspan="1" align="center" nowrap class="labeltd">汇款人信息</td>
									<td colspan="1" align="center" nowrap class="labeltd">汇款人类型</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="custype"/></td>
									
									<td rowspan="3" colspan="1" align="center" nowrap class="labeltd">购汇信息</td>
									<td colspan="1" align="center" nowrap class="labeltd">购汇汇率</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="exrate"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">个人身份证件号码</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="idcode"/></td>
									<td align="center" nowrap class="labeltd">购汇金额</td> 
									<td class="datatd"><@CommonQueryMacro.SingleField 
										fId="lcyamt"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">组织机构代码 </td> 
									<td class="datatd"><@CommonQueryMacro.SingleField 
										fId="custcod"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">人民币帐号/银行卡号 </td> 
									<td class="datatd"><@CommonQueryMacro.SingleField 
											fId="lcyacc"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">汇款人名称 </td> 
									<td class="datatd"><@CommonQueryMacro.SingleField 
										fId="custnm"/></td>
										
									<td rowspan="2" colspan="1" align="center" nowrap class="labeltd">现汇信息</td>
									<td align="center" nowrap class="labeltd">现汇金额</td> 
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="fcyamt"/></td>
								</tr>
								<tr>
									<td rowspan="3" colspan="1" align="center" nowrap class="labeltd">汇款信息</td>
									<td colspan="1" align="center" nowrap class="labeltd">汇款币种</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="txccy"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">外汇帐号/银行卡号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="fcyacc"/></td>
								</tr>
								<tr>
									<td rowspan="1" align="center" nowrap class="labeltd">汇款金额</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="txamt"/></td>
									<td rowspan="2" colspan="1" align="center" nowrap class="labeltd">其他信息</td>
									<td colspan="1" align="center" nowrap class="labeltd">其它金额</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="othamt"/></td>
								</tr>
								<tr>
									<td colspan="1" align="center" nowrap class="labeltd">结算方式</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="method"/></td>
									<td colspan="1" align="center" nowrap class="labeltd">其它帐号/银行</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="othacc"/></td>
								<tr/>
								<tr>
									<td colspan="2" align="center" nowrap class="labeltd">银行业务编号</td>
									<td class="datatd"><@CommonQueryMacro.SingleField
										fId="buscode"/></td>
								</tr>
							</table> 
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox1" label="管理信息" expand="true">
			<table frame=void class="grouptable" width="900px">
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" >合同号</td>
                   <td class="datatd"><@CommonQueryMacro.SingleField fId="contrno"/> </td>

	               <td colspan="1"  align="center" nowrap class="labeltd" >发票号 </td>
		           <td class="datatd"><@CommonQueryMacro.SingleField fId="invoino"/></td>

               </tr>
               <tr>
				   <td rowspan="2" colspan="1" align="center" nowrap class="labeltd">填报人信息</td>
		           <td colspan="1" align="center" nowrap class="labeltd" >填报人</td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="crtuser"/> </td>

		           <td rowspan="1" colspan="" align="center" nowrap class="labeltd" >申报日期</td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="rptdate"/>  </td>
				</tr>
    			<tr>
    			   <td colspan="1" rowspan="1" align="center" nowrap class="labeltd" >填报人电话</td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="inptelc"/> </td>

		           <td colspan="1" align="center" nowrap class="labeltd" >业务流水号</td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="filler2"/> </td>
				</tr>
           </table>
         </@CommonQueryMacro.GroupBox>
					</td>
				</tr>
				<tr style="padding-top:15px">
					<td align="left" colspan="3"><@CommonQueryMacro.Button
						id="btSave"/>&nbsp; &nbsp;<@CommonQueryMacro.Button id="btBack"/></td>
				</tr>
			</table>
		</td>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr id="systemTableTd">
					<td>
						<@CommonQueryMacro.GroupBox id="groupbox2" label="系统信息"
						expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">操作类型</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="actiontype"/></td>
							</tr>
							<tr>
								<td rowspan="1" align="right" nowrap class="labeltd">记录状态</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="recStatus"/></td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">审批状态
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="approveStatus"/>
								</td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">审批说明
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="approveResult"/>
								</td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">回执状态
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="repStatus"/><a id="repResult" href="JavaScript:doRepDet()">回执说明<a/>
								</td>
							</tr>
							<tr>
								<td colspan="1" align="center" nowrap class="labeltd">创建时间</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="crtTm"/></td>
							</tr>
								<td colspan="1" align="center" nowrap class="labeltd">最后修改时间</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="lstUpdTm"/></td>
							</tr>
						</table> </@CommonQueryMacro.GroupBox>
					<td>
				</tr>
				<tr id="actiondescTrTd">
					<td>
										<@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD2" label="修改/删除信息" expand="true">
									<table frame=void class="grouptable" width="100%" >
										<tr>
											<td  align="center" nowrap class="labeltd">修改/删除原因</td>
											<td class="datatd" ><@CommonQueryMacro.SingleField fId="actiondesc"/></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
					<td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var op = "${RequestParameters["op"]?default('')}";
	var ds = BopBhnDsManageCollInfo_dataset;
	function initCallGetter_post(){
		//回执说明链接样式
		var repStatus = ds.getValue("repStatus");
		if(repStatus == "00" || repStatus == "01") {
			document.getElementById("repResult").href = "javascript:void(0)";
			document.getElementById("repResult").style.color = "#999999";
		}
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
		ds.setFieldReadOnly("method",true);
		ds.setFieldReadOnly("buscode",true);
		//系统信息只读
		ds.setFieldReadOnly("actiontype",true);
		ds.setFieldReadOnly("recStatus",true);
		ds.setFieldReadOnly("approveStatus",true);
		ds.setFieldReadOnly("approveResult",true);
		ds.setFieldReadOnly("repStatus",true);
		ds.setFieldReadOnly("crtTm",true);
		ds.setFieldReadOnly("lstUpdTm",true);
		//没上报修改原因只读
		var subSuccess = ds.getValue("subSuccess");
		if(subSuccess == "0") {
			if(op == "mod") {
				ds.setFieldReadOnly("actiondesc",true);
			}
		}
		if(op == "add") {
			$("#systemTableTd").get(0).style.display="none";
			$("#actiondescTrTd").hide();
		}
		if(op == "detail") {
			setManageReadOnly();
			$("#btSave").hide();
			$("#btLoadPage").hide();
			ds.setFieldReadOnly("actiondesc",true);
		}
		if(op == "del") {
			setManageReadOnly();
			$("#btLoadPage").hide();
		}
		if(op == "mod") {
			ds.setFieldReadOnly("filler2",true);
		}
	}

	function setManageReadOnly() {
		ds.setFieldReadOnly("contrno",true);
		ds.setFieldReadOnly("invoino",true);
		ds.setFieldReadOnly("crtuser",true);
		ds.setFieldReadOnly("inptelc",true);
		ds.setFieldReadOnly("rptdate",true);
		ds.setFieldReadOnly("filler2",true);
	}
	function btBack_onClick() {
		closeWin();
	}

	//弹出签约信息选择框
	function loadAccount(){
		showPickup("基础信息","${contextPath}/fpages/bop/collandaudit/bhn/ftl/winloadpage/BopBhnDsLoadPage.ftl?type=manage");
	}

	function btSave_onClickCheck(button) {
		var rptno = ds.getValue("rptno");
		if(rptno == null || "" == rptno) {
			alert("请先选择申报号码!");
			return false;
			
		}
		return true;
	}
	function btSave_postSubmit(button) {
		alert("保存成功");
		closeWin(true);
	}
	
	function doRepDet(){
		var id = ds.getValue("id");
		var appType = ds.getValue("appType");
		var currentfile = ds.getValue("currentfile");
		//var busiCode = ds.getValue("fileNumber");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile, 600, 500);
	}
</script>
</@CommonQueryMacro.page>
