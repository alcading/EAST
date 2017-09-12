<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="变动信息">
	<table width="90%" align="left">
		<tr>
			<td width="75%" valign="top">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td>
							<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsChangeInfoAdd" init="true" submitMode="all" navigate="false" >
								<@CommonQueryMacro.GroupBox id="guoup1" label="签约信息" expand="true">
									<table frame=void class="grouptable" width="100%">
										<tr>
											<td align="center" nowrap class="labeltd" colspan="2">外汇质押人民币贷款编号</td>
											<td class="datatd">
												<@CommonQueryMacro.SingleField fId="explrmblono"/>
												<#assign op=RequestParameters["op"]?default("")>
												<#if op == "new">
													<@CommonQueryMacro.Button id="btSearch"/>&nbsp;&nbsp;
												</#if>
											</td>
											<td rowspan="2" align="center" nowrap class="labeltd">债务人</td>
											<td align="center" nowrap class="labeltd">债务人代码</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="debtorcode" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" colspan="2">债权人代码</td>
											<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="creditorcode" /></td>
											<td align="center" nowrap class="labeltd">债务人中文名称</td>
											<td class="datatd"><@CommonQueryMacro.SingleField fId="debtorname" /></td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" colspan="2">贷款起息日</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="valuedate" /></td>
											<td align="center" nowrap class="labeltd" colspan="2">贷款到期日</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="maturity" /></td>
										</tr>

										<tr>
											<td align="center" nowrap class="labeltd" colspan="2">贷款签约币种</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="credconcurr" /></td>

											<td align="center" nowrap class="labeltd" colspan="2">贷款签约金额</td>
											<td  class="datatd"><@CommonQueryMacro.SingleField fId="credconamount" /></td>

										</tr>

									</table>
								</@CommonQueryMacro.GroupBox>


								<@CommonQueryMacro.Group id ="group1" label="变动信息"
									fieldStr="buocmonth,changeno,monbeloadbal,monenloadbal,credwithamount,credrepayamount,picamount,filler2,remark" colNm=4/>

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
												<@CommonQueryMacro.DataTable id="datatable1" fieldStr="explcurr,explamount,explperamount,plcoseamount" readonly="false" width="100%" hasFrame="true" height="200px" />
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
				  	<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsChangeInfoAdd" mode="1" navigate="false" >
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
				<@CommonQueryMacro.CommonQuery id="BopCfaExplrmbloDsChangeInfoAdd" mode="1" navigate="false">
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

		function btBack_onClick(){
			closeWin(true);
		}

		function btSearch_onClick()	{
			loadPage();
		}

		//弹出账户信息选择框
		function loadPage() {
			showPickup("签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopCfaExplrmbloDsLoadPage.ftl");
		}

		function doRepDet() {
			var id = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("id");
			var appType = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("appType");
			var currentfile = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("currentfile");
			var busiCode = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("explrmblono");
			showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
		}

		function btSave_postSubmit(button){
			alert("保存成功！");
			closeWin(true);
		}

		//当页面初始化完之后可以调用该方法执行需要处理的操
		function initCallGetter_post(dataset) {

			if ("new" != op) {
				//系统属性设为只读
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("actiontype",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("recStatus",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("approveStatus",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("approveResult",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("crtTm",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("lstUpdTm",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("repStatus",true);

				var repStatus = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("repStatus");
				if (repStatus != "02") {
					document.getElementById("repHerf").href="#";
					document.getElementById("repHerf").style.color="#999999";
				}

			}
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("changeno",true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("explrmblono",true);

			//签约信息设为只读
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("debtorcode", true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("creditorcode",true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("debtorname",true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("valuedate",true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("maturity",true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("credconcurr",true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("explcurr",true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("credconamount",true);
			BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("explamount",true);



			if ("new" == op) {
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("actiondesc",true);
			} else if ("mod" == op) {
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("actiondesc",true);
			} else if ("del" == op || "detail" == op) {
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("explrmblono",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("buocmonth",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("monbeloadbal",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("monenloadbal",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("credwithamount",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("credrepayamount",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("picamount",true);
				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("remark",true);

				BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("filler2",true);

				BopCfaExplcurrinfo_dataset.setFieldReadOnly("explcurr",true);
				BopCfaExplcurrinfo_dataset.setFieldReadOnly("explamount",true);
				BopCfaExplcurrinfo_dataset.setFieldReadOnly("explperamount",true);
				BopCfaExplcurrinfo_dataset.setFieldReadOnly("plcoseamount",true);

				if ("detail" == op) {
					BopCfaExplrmbloDsChangeInfoAdd_dataset.setFieldReadOnly("actiondesc",true);
				}
			}
		}

		function btSave_onClickCheck(button) {

			if("D" == actiontype && (null == actiondesc || "" == actiondesc)){
				alert("[操作类型]为[删除],[删除原因]必填填写");
				return false;
			}

			if ("del" != op) {
				if (!BopCfaExplrmbloDsChangeInfoAdd_dataset.modified && !BopCfaExplcurrinfo_dataset.modified) {
					alert("请先修改后再保存！");
					return false;
				}
				var monbeloadbal = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("monbeloadbal");
				var credwithamount = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("credwithamount");
				var credrepayamount = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("credrepayamount");
				var picamount = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("picamount");
				var monenloadbal = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("monenloadbal");
				var actiontype = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("actiontype");
				var actiondesc = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("actiondesc");
				var explrmblono = BopCfaExplrmbloDsChangeInfoAdd_dataset.getValue("explrmblono");
				var record = BopCfaExplcurrinfo_dataset.getFirstRecord();

				if("" == explrmblono || null == explrmblono){
					alert("[外汇质押人民币贷款编号]不能为空");
					return false;
				}
				if (("C" == actiontype || "A" == actiontype) && "" != actiondesc) {
					alert("[操作类型]为[删除], [删除原因]无须填写");
					return false;
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