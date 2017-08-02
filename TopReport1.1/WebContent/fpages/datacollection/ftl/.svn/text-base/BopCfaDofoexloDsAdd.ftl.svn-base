<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<@CommonQueryMacro.CommonQuery id="BopCfaDofoexloDsAdd" init="true" submitMode="current" navigate="false" >
	<table width="90%">
		<tr>
			<td width="65%" valign="top">

				<@CommonQueryMacro.GroupBox id="guoup1" label="基础信息" expand="true">
					<table frame=void class="grouptable" width="100%">
						<tr>
							<td align="center" nowrap class="labeltd" colspan="2">国内外汇贷款编号</td>
							<td class="datatd" > <@CommonQueryMacro.SingleField fId="dofoexlocode"/></td>
							<td rowspan="2" align="center" nowrap class="labeltd" >债务人</td>
							<td align="center" nowrap class="labeltd">债务人代码</td>
							<td  class="datatd"> <@CommonQueryMacro.SingleField fId="debtorcode" /></td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd" colspan="2">债权人代码</td>
							<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="creditorcode" /></td>
							<td align="center" nowrap class="labeltd" >债务人中文名称</td>
							<td class="datatd" > <@CommonQueryMacro.SingleField fId="debtorname" /></td>
						</tr>
						<tr>
							<td rowspan="4" align="center" nowrap class="labeltd" >签约</td>
							<td align="center" nowrap class="labeltd">起息日</td>
							<td  class="datatd"> <@CommonQueryMacro.SingleField fId="valuedate" /></td>

							<td rowspan="3" align="center" nowrap class="labeltd" >贷款类型</td>
							<td align="center" nowrap class="labeltd" >国内外汇贷款类型</td>
							<td class="datatd" > <@CommonQueryMacro.SingleField fId="dofoexlotype" /></td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd">到期日</td>
							<td  class="datatd"> <@CommonQueryMacro.SingleField fId="maturity" /></td>

							<td align="center" nowrap class="labeltd" >转贷项目名称</td>
							<td class="datatd" > <@CommonQueryMacro.SingleField fId="lenproname" /></td>
						</tr>

						<tr>
							<td align="center" nowrap class="labeltd">贷款币种</td>
							<td  class="datatd"> <@CommonQueryMacro.SingleField fId="currence" /></td>

							<td align="center" nowrap class="labeltd" >转贷协议号</td>
							<td class="datatd" > <@CommonQueryMacro.SingleField fId="lenagree" /></td>


						</tr>

						<tr>
							<td align="center" nowrap class="labeltd">签约金额</td>
							<td  class="datatd"> <@CommonQueryMacro.SingleField fId="contractamount" /></td>

							<td align="center" nowrap class="labeltd" colspan="2">年化利率值</td>
							<td class="datatd" > <@CommonQueryMacro.SingleField fId="anninrate" /></td>

						</tr>

						<tr>
							<td align="center" nowrap class="labeltd" colspan="2">业务流水号</td>
							<td  class="datatd"><@CommonQueryMacro.SingleField fId="filler2" /></td>


							<td align="center" nowrap class="labeltd" colspan="2">备注</td>
							<td  class="datatd"><@CommonQueryMacro.SingleField fId="remark" /></td>
						</tr>

					</table>
				</@CommonQueryMacro.GroupBox>
			</td>

			<td width="8px"></td>
			<td width="35%" valign="top">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<#assign op=RequestParameters["op"]?default("")>
							<#if op!="new">
								<@CommonQueryMacro.GroupBox id="guoup3" label="系统信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd" width="25%"> 操作类型 </td>
											<td nowrap class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="actiontype" /></td>
										</tr>
										<tr>
											<td  align="center" nowrap class="labeltd" width="25%"> 记录状态 </td>
											<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="recStatus" /></td>
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
											<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a></td>
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
							</#if>
						</td>
					</tr>
					<tr>
						<td>

							<#assign op=RequestParameters["op"]?default("")>
							<#if op!="new">
								<@CommonQueryMacro.GroupBox id="guoup4" label="删除原因" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd" width="25%"> 删除原因 </td>
											<td class="datatd" width="75%"> <@CommonQueryMacro.SingleField fId="actiondesc" /></td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</#if>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td align="left">
				<#assign op=RequestParameters["op"]?default("")>
				<#if op!="detail">
					<@CommonQueryMacro.Button id="btSave"/>&nbsp;&nbsp;
				</#if>
				<@CommonQueryMacro.Button id="btBack"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">
		var op = "${RequestParameters["op"]?default('')}";


		function btBack_onClick(){
			closeWin(true);
		}

		function btSave_postSubmit(button){
			alert("保存成功！");
			closeWin(true);
		}

		function doRepDet() {
			var id = BopCfaDofoexloDsAdd_dataset.getValue("id");
			var appType = BopCfaDofoexloDsAdd_dataset.getValue("appType");
			var currentfile = BopCfaDofoexloDsAdd_dataset.getValue("currentfile");
			var busiCode = BopCfaDofoexloDsAdd_dataset.getValue("dofoexlocode");
			showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
		}

		//当页面初始化完之后可以调用该方法执行需要处理的操
		function initCallGetter_post(dataset) {
			if("new" != op) {
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("actiontype",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("dofoexlocode",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("recStatus",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("approveStatus",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("approveResult",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("crtTm",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("lstUpdTm",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("repStatus",true);
				var repStatus = BopCfaDofoexloDsAdd_dataset.getValue("repStatus");
				if (repStatus != "02") {
					document.getElementById("repHerf").href="#";
					document.getElementById("repHerf").style.color="#999999";
				}
			}


			if("mod" == op) {
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("actiondesc",true);
			} else if ("new" == op) {
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("actiondesc",true);

				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("dofoexlocode",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("creditorcode",true);

			}else if ("del" == op || "detail" == op) {
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("dofoexlocode",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("debtorcode",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("creditorcode",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("debtorname",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("valuedate",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("dofoexlotype",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("maturity",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("lenproname",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("currence",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("lenagree",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("contractamount",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("anninrate",true);
				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("remark",true);

				BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("filler2",true);


				if ("detail" == op) {
					BopCfaDofoexloDsAdd_dataset.setFieldReadOnly("actiondesc",true);
				}
			}
		}

		function dofoexlotype_DropDown_beforeOpen(dropDown){
			DataDicTreeSelect_DropDownDataset.setParameter("headDataTypeNo","43");//16根据实际的代码顶级编号替换
		}

		function btSave_onClickCheck(button) {
			if (!BopCfaDofoexloDsAdd_dataset.modified) {
				alert("请先修改后再保存！");
				return false;
			}

			var actiontype = BopCfaDofoexloDsAdd_dataset.getValue("actiontype");
			var actiondesc = BopCfaDofoexloDsAdd_dataset.getValue("actiondesc");
			var dofoexlocode = BopCfaDofoexloDsAdd_dataset.getValue("dofoexlocode");
			var creditorcode = BopCfaDofoexloDsAdd_dataset.getValue("creditorcode");
			var debtorcode = BopCfaDofoexloDsAdd_dataset.getValue("debtorcode");
			var debtorname = BopCfaDofoexloDsAdd_dataset.getValue("debtorname");
			var dofoexlotype = BopCfaDofoexloDsAdd_dataset.getValue("dofoexlotype");
			var valuedate = BopCfaDofoexloDsAdd_dataset.getValue("valuedate");
			var maturity = BopCfaDofoexloDsAdd_dataset.getValue("maturity");
			var currence = BopCfaDofoexloDsAdd_dataset.getValue("currence");
			var contractamount = BopCfaDofoexloDsAdd_dataset.getValue("contractamount");
			var anninrate = BopCfaDofoexloDsAdd_dataset.getValue("anninrate");
			var lenproname = BopCfaDofoexloDsAdd_dataset.getValue("lenproname");
			var lenagree = BopCfaDofoexloDsAdd_dataset.getValue("lenagree");

			if("D" == actiontype && "" == actiondesc) {
				alert("[操作类型]为[删除], [删除原因]必须填写");
				return false;
			}

			if ("del" != op) {
				if(("C" == actiontype || "A" == actiontype) && "" != actiondesc){
					alert("[操作类型]为[新增或修改], [删除原因]无须填写");
					return false;
				}
				if("1300" == dofoexlotype) {
					if(null == lenproname || "" == lenproname) {
						alert("[国内外汇贷款类型]为[外债转贷款], [转贷项目名称]必须填写");
						return false;
					}
					if("" == lenagree) {
						alert("[国内外汇贷款类型]为[外债转贷款], [转贷协议号]必须填写");
						return false;
					}
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
			return true;
		}
	</script>
</@CommonQueryMacro.page>