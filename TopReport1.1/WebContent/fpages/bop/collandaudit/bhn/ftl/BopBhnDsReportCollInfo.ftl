<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#global contextPath = contextPath>
<@CommonQueryMacro.page title="申报信息">
<@CommonQueryMacro.CommonQuery id="BopBhnDsReportCollInfo" navigate="false" init="true" insertOnEmpty="true">
<table  width="95%" cellpadding="2">
	<tr>
		<td valign="top" width="75%">
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
				<tr style="padding-top:15px">
					<td>
					<@CommonQueryMacro.GroupBox id="groupbox1" label="申报信息" expand="true">
						<table frame=void class="grouptable" width="100%">
						  	<tr>
			                	<td colspan="2" align="center" nowrap class="labeltd" >收款人常驻国家/地区代码</td>
			                  	<td colspan="1" class="datatd"><@CommonQueryMacro.SingleField fId="country"/> </td>
			
				               	<td colspan="2"  align="center" nowrap class="labeltd" >付款类型 </td>
					           	<td colspan="1" class="datatd"><@CommonQueryMacro.SingleField fId="paytype"/></td>
			
			               	</tr>
			               	
			               	<tr>
							   <td rowspan="3" align="center" nowrap class="labeltd">交易信息1</td>
					           <td colspan="1" align="center" nowrap class="labeltd" >交易编码1</td>
			                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="txcode"/> </td>
			                   
							   <td rowspan="3" align="center" nowrap class="labeltd">交易信息2</td>
			                   <td colspan="1" align="center" nowrap class="labeltd" >交易编码2</td>
			                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="txcode2"/> </td>
			
			    			</tr>
			    			
			    			<tr>
					           <td colspan="1" align="center" nowrap class="labeltd" >相应金额1</td>
					           <td class="datatd" ><@CommonQueryMacro.SingleField fId="tc1amt"/>  </td>
			
			                   <td colspan="1" align="center" nowrap class="labeltd" >相应金额2</td>
			                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="tc2amt"/> </td>
							</tr>
							<tr>
					           <td colspan="1" align="center" nowrap class="labeltd">交易附言1</td>
					           <td class="datatd" ><@CommonQueryMacro.SingleField fId="txrem"/>  </td>
							
			                   <td colspan="1" align="center" nowrap class="labeltd" >交易附言2</td>
			                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="tx2rem"/> </td>
			              	</tr>
			              	<tr>
			              	   <td rowspan="2" align="center" nowrap class="labeltd">申请人信息</td>
			                   <td colspan="1" align="center" nowrap class="labeltd" >申请人</td>
			                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="crtuser"/> </td>
			                   
					           <td colspan="2" align="center" nowrap class="labeltd">是否保税货物项下付款</td>
					           <td class="datatd" ><@CommonQueryMacro.SingleField fId="isref"/>  </td>
			              	</tr>
			              	<tr>
					           <td colspan="1" align="center" nowrap class="labeltd">申请人电话</td>
					           <td class="datatd" ><@CommonQueryMacro.SingleField fId="inptelc"/>  </td>
					           
					           <td colspan="2" align="center" nowrap class="labeltd">外汇局批件号/备案表号/业务编号</td>
					           <td class="datatd" ><@CommonQueryMacro.SingleField fId="regno"/>  </td>
			              	</tr>
			              	<tr>
			                   <td colspan="2" align="center" nowrap class="labeltd" >申报日期</td>
			                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="rptdate"/> </td>
			
			                   <td colspan="2" align="center" nowrap class="labeltd" >业务流水号</td>
			                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="filler2"/> </td>
			              	</tr>
			           </table>
			         </@CommonQueryMacro.GroupBox>
			       </td>
			   </tr>				
				
			</table>
		</td>

		<td width="8px"></td>
		<td width="25%" valign="top" id="systemTableTd">
			<table width="100%" cellpadding="0" cellspacing="0" >
				<tr>
					<td><@CommonQueryMacro.GroupBox id="groupbox2" label="系统信息"
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
						</table> </@CommonQueryMacro.GroupBox></td></tr>
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
							</td>
						</tr>
				</tr>
			</table></td>

	</tr>



   <tr>
		<td>
			<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btBack"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var op = "${RequestParameters["op"]?default('')}";
	var ds = BopBhnDsReportCollInfo_dataset;
	
	function txcode_DropDown_beforeOpen(dropDown){
     	MtsInOutCodeTreeSelect_DropDownDataset.setParameter("headDataTypeNo","01");
    	MtsInOutCodeTreeSelect_DropDownDataset.setParameter("codeType","BOP-OUT");
    }
    
	function txcode2_DropDown_beforeOpen(dropDown){
     	MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("headDataTypeNo","01");
    	MtsInOutCodeTreeSelectTwo_DropDownDataset.setParameter("codeType","BOP-OUT");
    }
	
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
				//document.getElementById("btLoadPage").style.display="none";
			}
		}
		if(op == "add") {
			$("#systemTableTd").get(0).style.display="none";
			$("#actiondescTrTd").hide();
		}
		if(op == "detail") {
			setReportReadOnly();
			ds.setFieldReadOnly("actiondesc",true);
			$("#btSave").hide();
			$("#btLoadPage").hide();
			document.getElementById("btLoadPage").style.display="none";
		}
		if(op == "del") {
			setReportReadOnly();
			document.getElementById("btLoadPage").style.display="none";
		}
		if(op == "mod") {
			//document.getElementById("btLoadPage").style.display="none";
			ds.setFieldReadOnly("filler2",true);
		}
	}

	function setReportReadOnly() {
		ds.setFieldReadOnly("country",true);
		ds.setFieldReadOnly("paytype",true);
		ds.setFieldReadOnly("txcode",true);
		ds.setFieldReadOnly("tc1amt",true);
		ds.setFieldReadOnly("txrem",true);
		ds.setFieldReadOnly("txcode2",true);
		ds.setFieldReadOnly("tc2amt",true);
		ds.setFieldReadOnly("tx2rem",true);
		ds.setFieldReadOnly("isref",true);
		ds.setFieldReadOnly("crtuser",true);
		ds.setFieldReadOnly("inptelc",true);
		ds.setFieldReadOnly("rptdate",true);
		ds.setFieldReadOnly("regno",true);
		ds.setFieldReadOnly("filler2",true);
	}
	function btBack_onClick() {
		closeWin();
	}

	//弹出签约信息选择框
	function loadAccount(){
		showPickup("基础信息","${contextPath}/fpages/bop/collandaudit/bhn/ftl/winloadpage/BopBhnDsLoadPage.ftl?type=report");
	}

	function btSave_onClickCheck(button) {
		var rptno = ds.getValue("rptno");
		if(rptno == null || "" == rptno) {
			alert("请先选择申报号码!");
			return false;
			
		}
		ds.setParameter("op",op);
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
