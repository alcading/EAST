<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="BOPForDebtBilLoan.title">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtBalanceInfoCol" init="true" submitMode="current" navigate="false">
		<table width="90%" cellpadding="2">
			<tr>
				<td width="75%" valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup1" label="签约信息"  expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td colspan="2" align="center" nowrap class="labeltd">外债编号</td>
											<td class="datatd" >
												<@CommonQueryMacro.SingleField fId="exdebtcode"/>
												<input extra="button" id="selectLoad"  style='width=25px;height=17px;' type="button" onclick="loadNo();" value="..."/>
											</td>

											<td rowspan="6" align="center" nowrap class="labeltd">债<br>权<br>人<br>信<br>息</td>
											<td align="center" nowrap class="labeltd">代码</td>
											<td class="datatd" width="25%"><@CommonQueryMacro.SingleField  fId="creditorcode"/></td>
										</tr>
										<tr>
											<td colspan="2" align="center" nowrap class="labeltd">债务人代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField  fId="debtorcode"/></td>
											<td align="center" nowrap class="labeltd">中文名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField  fId="creditorname"/></td>
										</tr>
										<tr>
											<td colspan="2" align="center" nowrap class="labeltd">债务类型</td>
											<td class="datatd" width="30%"><@CommonQueryMacro.SingleField  fId="debtype"/></td>
											<td align="center" nowrap class="labeltd">英文名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField  fId="creditornamen"/></td>
										</tr>
										<tr>
										<td colspan="2"  align="center" nowrap class="labeltd">起息日</td>
											<td class="datatd"><@CommonQueryMacro.SingleField  fId="valuedate"/></td>

											<td align="center" nowrap class="labeltd">类型代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="creditortype"/></td>
										</tr>
										<tr>
											<td colspan="2"  align="center" nowrap class="labeltd">签约币种</td>
											<td class="datatd"><@CommonQueryMacro.SingleField	fId="contractcurr"/></td>
											<td align="center" nowrap class="labeltd">总部所在国家（地区）代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField	fId="crehqcode"/></td>
										</tr>
										<tr>
											<td colspan="2"  align="center" nowrap class="labeltd">是否浮动利率</td>
											<td class="datatd"><@CommonQueryMacro.SingleField  fId="floatrate"/></td>
											<td align="center" nowrap class="labeltd">经营地所在国家（地区）代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField	fId="opercode"/></td>
										</tr>
										<tr>
											<td colspan="2" align="center" nowrap class="labeltd">年化利率值</td>
											<td class="datatd"><@CommonQueryMacro.SingleField  fId="anninrate"/></td>
											<td colspan="2" align="center" nowrap class="labeltd">是否经外汇局特批不需占用指标</td>
											<td class="datatd"><@CommonQueryMacro.SingleField	fId="spapfeboindex"/></td>
										</tr>
										<tr>
											<td colspan="2" align="center" nowrap class="labeltd">业务流水号</td>
											<td class="datatd" colspan="4"><@CommonQueryMacro.SingleField  fId="filler2Oth"/></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup2" label="余额信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd">银行账号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="buscode"/></td>
											<td align="center" nowrap class="labeltd">变动编号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="changeno"/></td>
										</tr>
										<tr>
											<td  align="center" nowrap class="labeltd">外债余额</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="accoamount"/></td>
											<td align="center" nowrap class="labeltd">变动日期</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="chdate"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">备注</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="remark"/></td>
											<td align="center" nowrap class="labeltd">业务流水号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
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
								<@CommonQueryMacro.GroupBox id="guoup3" label="系统信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd" width="25%">操作类型</td>
											<td nowrap class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="actiontype" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" width="25%">记录状态</td>
											<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="recStatus" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">审批状态</td>
											<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="approveStatus" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">审批结果</td>
											<td nowrap class="datatd">
												<@CommonQueryMacro.SingleField fId="approveResult" />
											</td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">回执状态</td>
											<td nowrap class="datatd">
												<@CommonQueryMacro.SingleField fId="repStatus" />
												<a id="repHerf" href="javascript:doRepDet()">回执结果</a>
											</td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">创建时间</td>
											<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="crtTm" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">最后更新时间</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm" /></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
						<tr>
							<td id="deleteasc">
								<@CommonQueryMacro.GroupBox id="guoup4" label="删除原因" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd" width="25%">删除原因</td>
											<td class="datatd" width="75%"><@CommonQueryMacro.SingleField fId="actiondesc" /></td>
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

	    var balanceFileType = "${RequestParameters["balanceFileType"]?default('')}";

	    BOPForDebtBalanceInfoCol_dataset.setParameter("balanceFileType",balanceFileType);

	    //当页面初始化完之后可以调用该方法执行需要处理的操
		function initCallGetter_post()
		{
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("actiontype",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("recStatus",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("approveStatus",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("approveResult",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("repStatus",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("crtTm",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("lstUpdTm",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("actiondesc",true);

			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("exdebtcode",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("creditorcode",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("debtorcode",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("creditorname",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("debtype",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("creditornamen",true);
			//BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("limitType",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("creditortype",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("valuedate",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("crehqcode",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("contractcurr",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("opercode",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("floatrate",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("spapfeboindex",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("anninrate",true);
			BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("filler2Oth",true);
			if("new" == op){
				window.document.getElementById('deleteasc').style.display="none";
				window.document.getElementById('sysMsgGroup').style.display="none";
				<#assign v_changeno = statics["com.huateng.report.utils.ReportUtils"].getTempStr(null,4)>
				BOPForDebtBalanceInfoCol_dataset.setValue("changeno", "${v_changeno}");
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("changeno",true);
			}else if("mod" ==op){
				window.document.getElementById('deleteasc').style.display="none";
				document.getElementById('selectLoad').style.display="none";
			}else if("del" ==op){
				document.getElementById('selectLoad').style.display="none";
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("actiondesc",false);
				BOPForDebtBalanceInfoCol_dataset.getField("actiondesc").required = true;
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("changeno",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("buscode",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("accoamount",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("chdate",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("remark",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("filler2",true);
			}else if("detail" ==op){
				document.getElementById('selectLoad').style.display="none";
				document.getElementById('btSave').style.display="none";
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("changeno",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("buscode",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("accoamount",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("chdate",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("remark",true);
				BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("filler2",true);
			}
			var repStatus = BOPForDebtBalanceInfoCol_dataset.getValue("repStatus");
			if (repStatus != "02") {
				document.getElementById("repHerf").href="#";
				document.getElementById("repHerf").style.color="#999999";
			}
		}
	 	function  BOPForDebtBalanceInfoCol_dataset_afterChange(dataset,field){
    		if(field.fieldName =="accoamount"){
				var accoamount  = parseFloat(BOPForDebtBalanceInfoCol_dataset.getValue("accoamount"));
				if(accoamount <0){
					alert("外债余额值不能小于零!");
					BOPForDebtBalanceInfoCol_dataset.setValue("accoamount","");
					return false;
				}
			}
			if(field.fieldName =="debtype"){
				var debtype = BOPForDebtBalanceInfoCol_dataset.getValue("debtype");
				if(debtype =="1304"){
					BOPForDebtBalanceInfoCol_dataset.setValue("buscode","N/A");
					BOPForDebtBalanceInfoCol_dataset.setFieldReadOnly("buscode",true);
				}
			}
    	}
		function btSave_onClickCheck(button){
			var  exdebtcode =  BOPForDebtBalanceInfoCol_dataset.getValue("exdebtcode");
			if(exdebtcode ==""){
				alert("请选择外债编号!");
				return false;
			}
			var  changeno =  BOPForDebtBalanceInfoCol_dataset.getValue("changeno");
			if(changeno =="" ){
				alert("变动编号为必填项不能为空!");
				return false;
			}
			var  buscode =  BOPForDebtBalanceInfoCol_dataset.getValue("buscode");
			if(buscode ==""){
				alert("银行账号为必填项不能为空!");
				return false;
			}
			var  accoamount =  BOPForDebtBalanceInfoCol_dataset.getValue("accoamount");
			if(accoamount =="" ){
				alert("外债余额为必填项不能为空!");
				return false;
			}
			var  chdate =  BOPForDebtBalanceInfoCol_dataset.getValue("chdate");
			if(chdate =="" ){
				alert("变动日期为必填项不能为空!");
				return false;
			}
			if("delBalance" ==op){
				var actiondesc = BOPForDebtBalanceInfoCol_dataset.getValue("actiondesc");
				if(actiondesc ==""){
					alert("删除原因不能为空!");
					return false;
				}
			}
		}
		//弹出账户信息选择框
		function loadNo(){
			showPickup("变动信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BOPForDebtBalanceLoadPage.ftl?currentFile="+balanceFileType);
		}
		function btSave_postSubmit(button){
			alert("保存成功！");
			closeWin(true);
		}
		function doRepDet(){
			var id = BOPForDebtBalanceInfoCol_dataset.getValue("id");
			var appType = BOPForDebtBalanceInfoCol_dataset.getValue("appType");
			var currentfile = BOPForDebtBalanceInfoCol_dataset.getValue("currentfile");
			var busiCode = BOPForDebtBalanceInfoCol_dataset.getValue("exdebtcode");
			showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
		}
		function btBack_onClick(){
			closeWin();
		}
	</script>
</@CommonQueryMacro.page>