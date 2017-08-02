<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="签约信息">
	<table  width="95%" cellpadding="2"  align="left">
		<tr>
			<td  width="70%" valign="top">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<@CommonQueryMacro.CommonQuery id="BOPCfaLounexguRecordAD" init="true"  submitMode="current" navigate="false">
								<@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD" label="基础信息" expand="true">
									<table frame=void class="grouptable" width="100%">
						  				<tr>
											<td colspan="2" align="center" nowrap class="labeltd" width="25%" >外保内贷编号 </td>
											<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="lounexgucode"/> </td>
											<td  colspan="2" align="center" nowrap class="labeltd" width="25%">国内外汇贷款编号</td>
											<td  class="datatd"  width="25%">
												<@CommonQueryMacro.SingleField fId="dofoexlocode"/>
												<input extra="button" id="selectLoad"  style='width=25px;height=17px;'  type="button" onclick="loadNo();" value="..."/>
											</td>
			  							</tr>
										<tr>
											<td colspan="2" align="center" nowrap class="labeltd" >债权人代码 </td>
						  					<td class="datatd" ><@CommonQueryMacro.SingleField fId="creditorcode"/> </td>
						  				    <td rowspan="3" align="center" nowrap class="labeltd" >中资企业<br>境外<br>担保项下</td>
						  					<td align="center" nowrap class="labeltd" >贷款业务批准文件号</td>
						  					<td class="datatd" ><@CommonQueryMacro.SingleField fId="cfeogudad"/> </td>
										</tr>
										<tr>
											<td rowspan="3" align="center" nowrap class="labeltd" >债务人</td>
						  					<td align="center" nowrap class="labeltd" >代码 </td>
						  					<td class="datatd" ><@CommonQueryMacro.SingleField fId="debtorcode"/> </td>
						  					<td align="center" nowrap class="labeltd" >境内贷款额度币种</td>
							  				<td class="datatd" ><@CommonQueryMacro.SingleField fId="cfeogudcurr"/> </td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" >中文名称</td>
							  				<td  class="datatd" ><@CommonQueryMacro.SingleField fId="debtorname"/> </td>
						  					<td align="center" nowrap class="labeltd" >境内贷款额度金额</td>
						  					<td class="datatd" ><@CommonQueryMacro.SingleField fId="cfeogudamount"/> </td>
										</tr>
										<tr>
											<td align="center" nowrap class="labeltd" >类型</td>
						  					<td  class="datatd" ><@CommonQueryMacro.SingleField fId="debtortype"/> </td>
						  					<td colspan="2" align="center" nowrap class="labeltd" >起息日</td>
							                <td class="datatd" ><@CommonQueryMacro.SingleField fId="valuedate"/> </td>
										</tr>
										<tr>
											<td  colspan="2" align="center" nowrap class="labeltd">贷款币种</td>
						  					<td class="datatd"><@CommonQueryMacro.SingleField fId="credcurrcode"/> </td>
						  					<td  align="center" colspan="2" nowrap class="labeltd" width="25%">到期日</td>
							                <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="maturity"/> </td>
										</tr>
										<tr>
											<td  colspan="2" align="center" nowrap class="labeltd" >贷款签约金额</td>
							  				<td  class="datatd" ><@CommonQueryMacro.SingleField fId="credconamount"/> </td>
							  				<td  align="center" colspan="2" nowrap class="labeltd"  >备注</td>
							                <td  class="datatd"   ><@CommonQueryMacro.SingleField fId="remark"/> </td>
										</tr>
										<tr>
											<td align="center" colspan="2" nowrap class="labeltd" >业务流水号</td>
							  				<td class="datatd" colspan="4" ><@CommonQueryMacro.SingleField fId="filler2"/> </td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
							</@CommonQueryMacro.CommonQuery>
						</td>
					</tr>
					<tr>
						<td>
							<@CommonQueryMacro.CommonQuery id="BopCfaFogucodeInfo" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
								<@CommonQueryMacro.GroupBox id="BopCfaFogucodeInfo" label="境外担保人信息" expand="true">
									<table frame=void width="100%">
										<tr>
											<td id="creMenu" align="right">
												<@CommonQueryMacro.Button id= "btCreNew"/>&nbsp;&nbsp;
												<@CommonQueryMacro.Button id= "btCreDel"/>&nbsp;&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												<@CommonQueryMacro.DataTable id="datatable2" fieldStr="fogunamen,foguname,guaranteetype,fogurecode,fogucode" width="100%" hasFrame="true" height="200px" readonly="false"/>
											</td>
										</tr>
									</table>
								</@CommonQueryMacro.GroupBox>
				  			</@CommonQueryMacro.CommonQuery>
		  				</td>
		  			</tr>

		  			<@CommonQueryMacro.CommonQuery id="BOPCfaLounexguRecordAD"  mode="1" navigate="false">
		  			<tr>
		  				<td>
		  					<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
							<@CommonQueryMacro.Button id= "btBack"/>&nbsp;&nbsp;
		  				</td>
		  			</tr>
		  		</table>
	 	 	</td>

	  		<td width="8px"></td>
	  			<td  id="newAction" width="25%" valign="top">
					<@CommonQueryMacro.GroupBox id="guoup4" label="系统信息" expand="true">
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
								<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="repStatus" />
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
					<@CommonQueryMacro.GroupBox id="guoup5" label="删除原因" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd" width="25%">删除原因</td>
								<td class="datatd" width="75%"><@CommonQueryMacro.SingleField fId="actiondesc" /></td>
							</tr>
						</table>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
</table>
<script language="JavaScript">
	var op = "${RequestParameters["op"]?default('')}";
	function initCallGetter_post(dataset) {
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("actiontype",true);
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("recStatus",true);
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("approveStatus",true);
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("approveResult",true);
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("repStatus",true);
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("crtTm",true);
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("lstUpdTm",true);
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("actiondesc",true);
		BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("dofoexlocode",true);
		document.getElementById('selectLoad').style.display="none";
		if("delInfo" == op ){
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("actiondesc",false);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("lounexgucode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("cfeogudad",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("creditorcode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("cfeogudcurr",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("debtorcode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("cfeogudamount",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("debtorname",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("dofoexlocode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("debtortype",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("credconamount",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("credcurrcode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("valuedate",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("maturity",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("remark",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("filler2",true);

			BopCfaFogucodeInfo_dataset.setFieldReadOnly("fogucode",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("foguname",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("fogunamen",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("guaranteetype",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("fogurecode",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("crtTm",true);

			document.getElementById("creMenu").style.display="none";

		}else if("detail" ==op) {
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("lounexgucode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("cfeogudad",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("creditorcode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("cfeogudcurr",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("debtorcode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("cfeogudamount",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("debtorname",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("dofoexlocode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("debtortype",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("credcurrcode",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("credconamount",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("valuedate",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("maturity",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("remark",true);
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("filler2",true);

			BopCfaFogucodeInfo_dataset.setFieldReadOnly("fogucode",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("foguname",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("fogunamen",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("guaranteetype",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("fogurecode",true);
			BopCfaFogucodeInfo_dataset.setFieldReadOnly("crtTm",true);

			document.getElementById("creMenu").style.display="none";
			document.getElementById("btSave").style.display="none";
		}else if("mod" == op){
			BOPCfaLounexguRecordAD_dataset.setFieldReadOnly("lounexgucode",true);
			document.getElementById('selectLoad').style.display="";
		}else if("new" ==op){
			document.getElementById("newAction").style.display = "none";
			document.getElementById('selectLoad').style.display="";
		}
		var repStatus = BOPCfaLounexguRecordAD_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}
	}

	function  BOPCfaLounexguRecordAD_dataset_afterChange(dataset,field){
		if(field.fieldName =="credconamount"){
			var credconamount  = parseFloat(BOPCfaLounexguRecordAD_dataset.getValue("credconamount"));
			if(credconamount  <0){
				alert("【贷款签约】金额不能小于零!");
				BOPCfaLounexguRecordAD_dataset.setValue("credconamount","");
				return false;
			}
		}
		if(field.fieldName =="cfeogudamount"){
			var cfeogudamount  = parseFloat(BOPCfaLounexguRecordAD_dataset.getValue("cfeogudamount"));
			if(cfeogudamount  <0){
				alert("【境内贷款额度】金额不能小于零!");
				BOPCfaLounexguRecordAD_dataset.setValue("cfeogudamount","");
				return false;
			}
		}
	}

	function setRequired(field,flag){
		var f = BOPCfaLounexguRecordAD_dataset.getField(field);
		f.required = flag;
	}

	function btAddCreditor(){
		btCreNew.click();
	}

	function btDelCreditor(){
		btCreDel.click();
	}

	function setRequired(field,flag){
		var f = BOPCfaLounexguRecordAD_dataset.getField(field);
		f.required = flag;
	}

	function  btSave_onClickCheck(button){
		if ("delInfo" != op){
			var  debtortypeValue =  BOPCfaLounexguRecordAD_dataset.getValue("debtortype");
			if(debtortypeValue == "1011"){
				var cfeogudad  =  BOPCfaLounexguRecordAD_dataset.getValue("cfeogudad");
			    var cfeogudcurr =  BOPCfaLounexguRecordAD_dataset.getValue("cfeogudcurr");
			    var cfeogudamount = parseFloat(BOPCfaLounexguRecordAD_dataset.getValue("cfeogudamount"));
				if(cfeogudad ==""){
					alert("【债务人类型】为中资机构，【贷款业务批准文件号】为必填项!");
					return false;
				}
				if(cfeogudcurr ==""){
					alert("【债务人类型】为中资机构，【境内贷款额度币种】为必填项！");
					return false;
				}
				if(isNaN(cfeogudamount)){
					alert("【债务人类型】为中资机构，【境内贷款额度金额】为必填项！");
					return false;
				}
			}
			var credcurrcode = BOPCfaLounexguRecordAD_dataset.getValue("credcurrcode");
			if(credcurrcode !="CNY" && credcurrcode !=""){
				var dofoexlocode = BOPCfaLounexguRecordAD_dataset.getValue("dofoexlocode");
				if(dofoexlocode ==""){
					alert("【贷款币种】不为人民币，【国内外汇贷款编号】为必填项!");
					return false;
				}
			}
			//起息日
			var valuedate = document.getElementById("valuedate").value;
			//到期日
			var  maturity= document.getElementById("maturity").value;
			var regS = new RegExp("-","gi");
			valuedate=valuedate.replace(regS,"/");
			maturity=maturity.replace(regS,"/");
			var value1 =new Date(Date.parse(valuedate));
			var value2 = new Date(Date.parse(maturity));
			if(value2<=value1){
				alert("【到期日】不能小于【起息日】！");
				return false;
			}
			var  fogurecode  =  BopCfaFogucodeInfo_dataset.getValue("fogurecode");
			if(fogurecode.length ==0){
				alert("境外担保人注册地国家/地区代码为必填项!");
				return false;
			}
			var  guaranteetype  =  BopCfaFogucodeInfo_dataset.getValue("guaranteetype");
			if(guaranteetype.length ==0){
				alert("担保方式为必填项!");
				return false;
			}
			var foguname = BopCfaFogucodeInfo_dataset.getValue("foguname");
			var fogunamen = BopCfaFogucodeInfo_dataset.getValue("fogunamen");
			if(foguname =="" &&  fogunamen ==""){
				alert("中文名称和英文名称至少填一个!");
				return false;
			}
			if("delInfo" ==op){
				var actiondesc = BOPCfaLounexguRecordAD_dataset.getValue("actiondesc");
				if(actiondesc ==""){
					alert("删除原因不能为空!");
					return false;
				}
			}
			if (!BOPCfaLounexguRecordAD_dataset.modified && !BopCfaFogucodeInfo_dataset.modified ) {
				alert("请先修改后再保存！");
				return false;
			}
		}
		return true;
	}

	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}

	function doRepDet(){
		var id = BOPCfaLounexguRecordAD_dataset.getValue("id");
		var appType = BOPCfaLounexguRecordAD_dataset.getValue("appType");
		var currentfile = BOPCfaLounexguRecordAD_dataset.getValue("currentfile");
		//var busiCode = BOPCfaLounexguRecordAD_dataset.getValue("fileNumber");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/ftl/ReportApproveResult.ftl?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile );
	}

	//弹出账户信息选择框
	function loadNo(){
		showPickup("签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopCfaDofoexloDsLoadPageTwo.ftl");
	}

	function btBack_onClick(button){
		closeWin();
	}
</script>
</@CommonQueryMacro.page>