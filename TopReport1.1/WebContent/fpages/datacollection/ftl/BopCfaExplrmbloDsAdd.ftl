<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<table width="90%" align="left">
		<tr>
			<td width="75%" valign="top">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td>
							<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsAdd" init="true" submitMode="all" navigate="false" >
								<@CommonQueryMacro.GroupBox id="guoup1" label="签约信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd">外汇质押人民币贷款编号</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="explrmblono"/></td>
											<td rowspan="2" align="center" nowrap class="labeltd">债务人</td>
											<td align="center" nowrap class="labeltd">债务人代码</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="debtorcode" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">债权人代码</td>
											<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="creditorcode" /></td>
											<td align="center" nowrap class="labeltd">债务人中文名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="debtorname" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">贷款起息日</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="valuedate" /></td>
											<td align="center" nowrap class="labeltd" colspan="2">贷款到期日</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="maturity" /></td>
										</tr>

										<tr>

											<td align="center" nowrap class="labeltd">贷款签约币种</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="credconcurr" /></td>

											<td align="center" nowrap class="labeltd" colspan="2">贷款签约金额</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="credconamount" /></td>

										</tr>
										<tr>
											<td align="center" nowrap class="labeltd">业务流水号</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="filler2" /></td>

											<td align="center" nowrap class="labeltd" colspan="2">备注</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="remark" /></td>
										</tr>

									</table>
								</@CommonQueryMacro.GroupBox>
							</@CommonQueryMacro.CommonQuery>
						</td>
					</tr>

					<tr>
						<td>
							<@CommonQueryMacro.CommonQuery id="BopCfaExplcurrinfo" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
								<@CommonQueryMacro.GroupBox id="guoup2" label="质押信息" expand="true">
									<table frame=void width="100%">
										<tr>
											<td align="right">
												<#assign op=RequestParameters["op"]?default("")>
												<#if op=="new" || op == "mod">
													<@CommonQueryMacro.Button id= "btAddRecord"/>&nbsp;&nbsp;
													<@CommonQueryMacro.Button id= "btDelRecord"/>&nbsp;&nbsp;
												</#if>
											</td>
										</tr>
										<tr>
											<td>
												<@CommonQueryMacro.DataTable id="datatable1" fieldStr="explcurr,explamount" readonly="false" width="100%" hasFrame="true" height="200px" />
											</td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</@CommonQueryMacro.CommonQuery>
						</td>
					</tr>
			  	</table>
		  	</td>

		  	<td width="8px"></td>

		  	<td width="25%" valign="top">
		  		<#assign op=RequestParameters["op"]?default("")>
				<#if op != "new">

				  	<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsAdd" mode="1" navigate="false" >
						<@CommonQueryMacro.GroupBox id="guoup3" label="系统信息" expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td align="center" nowrap class="labeltd" width="25%">操作类型</td>
									<td nowrap class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="actiontype" /></td>
								</tr>

								<tr>
									<td  align="center" nowrap class="labeltd" width="25%">记录状态</td>
									<td class="datatd"  width="25%"> <@CommonQueryMacro.SingleField fId="recStatus" /></td>
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
									<td align="center" nowrap class="labeltd" >回执状态</td>
									<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a></td>
								</tr>

								<tr>
									<td align="center" nowrap class="labeltd">创建时间</td>
									<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="crtTm" /></td>
								</tr>

								<tr>
									<td align="center" nowrap class="labeltd" >最后更新时间</td>
									<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm" /></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>

						<@CommonQueryMacro.GroupBox id="guoup4" label="删除原因" expand="true">
							<table frame=void class="grouptable" width="100%">
								<tr>
									<td align="center" nowrap class="labeltd" width="25%"> 删除原因 </td>
									<td class="datatd" width="75%"><@CommonQueryMacro.SingleField fId="actiondesc" /></td>
								</tr>
							</table>
						</@CommonQueryMacro.GroupBox>
					</@CommonQueryMacro.CommonQuery>

				</#if>
			</td>
		</tr>

		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsAdd" mode="1" navigate="false">
					<#assign op=RequestParameters["op"]?default("")>
					<#if op!="detail">
						<@CommonQueryMacro.Button id="btSave"/>&nbsp;&nbsp;
					</#if>
					<@CommonQueryMacro.Button id="btBack"/>&nbsp;&nbsp;
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>

	<script language="JavaScript">
		var op = "${RequestParameters["op"]?default('')}";

		function doRepDet() {
			var id = BopCfaExplrmbloDsAdd_dataset.getValue("id");
			var appType = BopCfaExplrmbloDsAdd_dataset.getValue("appType");
			var currentfile = BopCfaExplrmbloDsAdd_dataset.getValue("currentfile");
			var explrmblono = BopCfaExplrmbloDsAdd_dataset.getValue("explrmblono");
			showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + explrmblono, 600, 500);
		}


		function btBack_onClick(){
			closeWin(true);
		}

		function btSave_postSubmit(button){
			alert("保存成功！");
			closeWin(true);
		}

		//当页面初始化完之后可以调用该方法执行需要处理的操
		function initCallGetter_post(dataset) {
			if("new" != op){
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("actiontype",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("explrmblono",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("recStatus",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("approveStatus",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("approveResult",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("crtTm",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("lstUpdTm",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("repStatus",true);
				var repStatus = BopCfaExplrmbloDsAdd_dataset.getValue("repStatus");
				if (repStatus != "02") {
					document.getElementById("repHerf").href="#";
					document.getElementById("repHerf").style.color="#999999";
				}
			}


			if("mod" == op) {
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("actiondesc",true);
			} else if ("new" == op) {
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("actiondesc",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("explrmblono",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("creditorcode",true);
				//贷款签约币种默认人民币
				BopCfaExplrmbloDsAdd_dataset.setValue2("credconcurr","CNY");
				BopCfaExplrmbloDsAdd_dataset.setValue("credconcurrName","CNY-人民币");
			} else if ("del" == op || "detail" == op) {
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("explrmblono",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("creditorcode",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("debtorcode",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("debtorname",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("valuedate",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("maturity",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("credconcurr",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("credconamount",true);
				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("remark",true);

				BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("filler2",true);

				BopCfaExplcurrinfo_dataset.setFieldReadOnly("explcurr",true);
				BopCfaExplcurrinfo_dataset.setFieldReadOnly("explamount",true);



				if ("detail" == op) {
					BopCfaExplrmbloDsAdd_dataset.setFieldReadOnly("actiondesc",true);
				}
			}
		}

		function btSave_onClickCheck(button) {
			if("D" == actiontype && (null == actiondesc || "" == actiondesc)){
				alert("[操作类型]为[删除],[删除原因]必填填写");
				return false;
			}
			if ("del" != op) {
				if (!BopCfaExplrmbloDsAdd_dataset.modified && !BopCfaExplcurrinfo_dataset.modified) {
					alert("请先修改后再保存！");
					return false;
				}
				var actiontype = BopCfaExplrmbloDsAdd_dataset.getValue("actiontype");
				var actiondesc = BopCfaExplrmbloDsAdd_dataset.getValue("actiondesc");
				var credconamount = BopCfaExplrmbloDsAdd_dataset.getValue("credconamount");

				var valuedate = BopCfaExplrmbloDsAdd_dataset.getValue("valuedate");
				var maturity = BopCfaExplrmbloDsAdd_dataset.getValue("maturity");
				var record = BopCfaExplcurrinfo_dataset.getFirstRecord();

				if(null != maturity && null != valuedate) {
					var mdat = new Date(maturity);
					var vdat = new Date(valuedate);
					if(vdat > mdat){
						alert("[贷款到期日]必须大于等于[贷款起息日]");
						return false;
					}
				}

				if(null == record){
					alert("质押信息必须填写一条");
					return false;
				}
			}
			return true;
		}
	</script>
</@CommonQueryMacro.page>