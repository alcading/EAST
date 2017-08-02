<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtOtherDebtsCol" init="true" submitMode="current" navigate="false">
		<table width="90%" cellpadding="2">
			<tr>
				<td width="75%" valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd">外债编号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="exdebtcode"/></td>
											<td rowspan="6" align="center" nowrap class="labeltd">债<br>权<br>人<br>信<br>息</td>
											<td align="center" nowrap class="labeltd">类型</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="creditortype"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">债务人代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="debtorcode"/></td>
											<td align="center" nowrap class="labeltd">代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="creditorcode"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">债务类型</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="debtype"/></td>
											<td align="center" nowrap class="labeltd">中文名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="creditorname"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">债务类型备注</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="debtyperema"/></td>
											<td align="center" nowrap class="labeltd">英文名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="creditornamen"/></td>
										</tr>
										<tr>
							     			<td align="center" nowrap class="labeltd">签约币种</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="contractcurr"/></td>
											<td align="center" nowrap class="labeltd">总部所在国家（地区）代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="crehqcode"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">签约金额</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="contractamount"/></td>
											<td align="center" nowrap class="labeltd">经营地所在国家（地区）代码</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="opercode"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">起息日</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="valuedate"/></td>
											<td colspan="2"  align="center" nowrap class="labeltd">到期日</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="maturity"/></td>
										</tr>
										<tr>
							     			<td align="center" nowrap class="labeltd">是否浮动利率</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="floatrate"/></td>
											<td colspan="2"  align="center" nowrap class="labeltd">是否有利息本金化条款</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="inprterm"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">年化利率值</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="anninrate"/></td>
											<td colspan="2"  align="center" nowrap class="labeltd">是否经外汇局特批不需占用指标</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="spapfeboindex"/></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">业务流水号</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="filler2" /></td>
											<td colspan="2"  align="center" nowrap class="labeltd">备注</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="remark"/></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</td>
						</tr>
					</table>
				</td>
				<td width="8px"></td>
				<td width="25%" valign="top">
					<#assign op=RequestParameters["op"]?default("")>
					<#if op!="new">
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
												<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="approveResult" /></td>
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
												<td class="datatd" width="75%">
													<@CommonQueryMacro.SingleField fId="actiondesc" />
												</td>
											</tr>
										</table>
									</@CommonQueryMacro.GroupBox>
								</td>
							</tr>
						</table>
					</#if>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>
								<#assign op=RequestParameters["op"]?default("")>
								<#if op!="detaile">
									<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
								</#if>
								<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
			 				</td>
		 				</tr>
	  				</table>
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>

	<script language="javascript">
	    var op = "${RequestParameters["op"]?default('')}";
	    //当页面初始化完之后可以调用该方法执行需要处理的操
		function debtype_DropDown_beforeOpen(dropDown) {
		   DataDicTreeSelect_DropDownDataset.setParameter("headDataTypeNo","24");
		}

		function creditortype_DropDown_beforeOpen(dropDown) {
		   DataDicTreeSelectCor_DropDownDataset.setParameter("headDataTypeNo","23");
		}

		function initCallGetter_post() {
			if ("new" != op) {
				var repStatus = BOPForDebtOtherDebtsCol_dataset.getValue("repStatus");
				if (repStatus != "02") {
					document.getElementById("repHerf").href="#";
					document.getElementById("repHerf").style.color="#999999";
				}
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("approveResult", true);
			}

			if("new" == op) {
//				window.document.getElementById("newRecord").style.display = "";
//				window.document.getElementById("deleteasc").style.display = "none";
//				window.document.getElementById("repHerf").style.display = "none";

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("actiondesc", true);
			} else if ("mod" == op) {
//				window.document.getElementById("newRecord").style.display="";
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("actiondesc", true);
			} else if ("del" == op) {
//			    window.document.getElementById("delRecord").style.display="";

			    BOPForDebtOtherDebtsCol_dataset.getField("actiondesc").required=true;
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("creditortype",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("debtorcode",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("creditorcode",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("debtype",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("creditorname",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("creditornamen",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("contractcurr",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("crehqcode",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("debtyperema",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("contractamount",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("opercode",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("valuedate",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("maturity",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("floatrate",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("anninrate",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("inprterm",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("spapfeboindex",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("remark",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("filler2",true);

			} else if("detaile" == op) {

				BOPForDebtOtherDebtsCol_dataset.readOnly=true;

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("creditortype",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("debtorcode",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("creditorcode",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("debtype",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("creditorname",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("creditornamen",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("contractcurr",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("crehqcode",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("contractamount",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("opercode",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("valuedate",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("maturity",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("debtyperema",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("floatrate",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("anninrate",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("inprterm",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("spapfeboindex",true);
				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("actiondesc",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("remark",true);

				BOPForDebtOtherDebtsCol_dataset.setFieldReadOnly("filler2",true);
			}
		}

		function btSave_onClickCheck(button) {

			if ("del" != op) {
				if (!BOPForDebtOtherDebtsCol_dataset.modified) {
					alert("请先修改后再保存！");
					return false;
				}
				var actiontype = BOPForDebtOtherDebtsCol_dataset.getValue("actiontype");
				var actiondesc = BOPForDebtOtherDebtsCol_dataset.getValue("actiondesc");
				var anninrate = BOPForDebtOtherDebtsCol_dataset.getValue("anninrate");
				var creditortype = BOPForDebtOtherDebtsCol_dataset.getValue("creditortype");
				var creditorname = BOPForDebtOtherDebtsCol_dataset.getValue("creditorname");
				var creditornamen = BOPForDebtOtherDebtsCol_dataset.getValue("creditornamen");
				var valuedate = BOPForDebtOtherDebtsCol_dataset.getValue("valuedate");
				var maturity = BOPForDebtOtherDebtsCol_dataset.getValue("maturity");
				if (op == "del") {
					var actiondesc = BOPForDebtOtherDebtsCol_dataset.getValue("actiondesc");
					if (actiondesc.length == 0) {
						alert("请填写删除原因");
						return false;
					}
					BOPForDebtOtherDebtsCol_dataset.setParameter("op", op);
				}
				if(isEmtry(creditortype)) {
					alert("字段[ 债务类型 ] 不能为空!");
					return false;
				}
				if(isEmtry(creditorname) && isEmtry(creditornamen)) {
					alert("债权人中文名称和债权人英文名称至少填写一个!");
					return false;
				}
				if(null != maturity && null != valuedate) {
					var mdat = new Date(maturity);
					var vdat = new Date(valuedate);
					if(vdat > mdat){
						alert("[到期日]必须大于等于[起息日]");
						return false;
					}
				}
				if (!isNaN(anninrate) && parseFloat(anninrate) >= 1) {
					alert("[年化利率值]必须为小数");
					return false;
				}
			}
			return confirm("是否保存");
		}

		function btSave_postSubmit(button) {
			alert("保存成功！");
			closeWin(true);
		}

//		function btColDel_postSubmit(button){
//			alert("删除成功！");
//			closeWin(true);
//		}
//		function btColDel_onClickCheck(button) {
//			if(isEmtry(BOPForDebtOtherDebtsCol_dataset.getValue("creditortype") )) {
//				alert("字段[ 债务类型 ] 不能为空!");
//				return false;
//			}
//			if(isEmtry(BOPForDebtOtherDebtsCol_dataset.getValue("creditorname") ) && isEmtry(BOPForDebtOtherDebtsCol_dataset.getValue("creditornamen") )) {
//				alert("债权人中文名称和债权人英文名称至少填写一个!");
//				return false;
//			}
//			if (op == "del") {
//				var actiondesc = BOPForDebtOtherDebtsCol_dataset.getValue("actiondesc");
//				if (actiondesc.length == 0) {
//					alert("请填写删除原因！");
//					return false;
//				}
//				BOPForDebtOtherDebtsCol_dataset.setParameter("op", op);
//			}
//			return confirm("是否保存");
//		}


		function doRepDet() {
			var id = BOPForDebtOtherDebtsCol_dataset.getValue("id");
			var appType = BOPForDebtOtherDebtsCol_dataset.getValue("appType");
			var currentfile = BOPForDebtOtherDebtsCol_dataset.getValue("currentfile");
			var busiCode = BOPForDebtOtherDebtsCol_dataset.getValue("exdebtcode");
			showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
		}

		function isEmtry(value) {
			if ("" == value || null == value) {
				return true;
			} else {
				return false;
			}
		}

		function btBack_onClick(){
			closeWin(true);
		}
	</script>
</@CommonQueryMacro.page>