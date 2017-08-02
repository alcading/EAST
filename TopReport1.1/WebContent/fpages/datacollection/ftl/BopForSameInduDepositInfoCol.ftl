<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="BopForSameInduDepositInfoCol" init="true" submitMode="all" navigate="true">
<table  width="95%" cellpadding="2">
	<tr>
		<td  width="75%" valign="top"   >
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<@CommonQueryMacro.GroupBox id="guoup1" label="签约信息"  expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">外债编号</td>
								<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="exdebtcode"/></td>

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
								<td class="datatd" ><@CommonQueryMacro.SingleField  fId="debtype"/></td>

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
								<td colspan="2" align="center" nowrap class="labeltd">备注</td>
								<td  class="datatd"><@CommonQueryMacro.SingleField fId="remark"/></td>

								<td colspan="2" align="center" nowrap class="labeltd">业务流水号</td>
								<td  class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
							</tr>
						</table>
						</@CommonQueryMacro.GroupBox>
					</td>
				</tr>
			</table>
		</td>

		<td width="8px"></td>
		<td width="25%"  valign="top" id="sysMsgGroup">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td>
					  <@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD1" label="系统信息"  expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td  align="center" nowrap class="labeltd" width="25%">操作类型</td>
								<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="actiontype"/></td>
							</tr>
							<tr>

								<td  align="center" nowrap class="labeltd" width="25%">记录状态</td>
								<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="recStatus"/></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" > 审批状态 </td>
								<td nowrap class="datatd" > <@CommonQueryMacro.SingleField fId="approveStatus" /></td>
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
						<td>
						  <@CommonQueryMacro.GroupBox id="BOPCfaLounexguRecordAD2" label="删除信息"   expand="true">
							<table frame=void class="grouptable" width="100%" >
								<tr>
									<td  align="center" nowrap class="labeltd" width="25%">删除原因</td>
									<td class="datatd"  colspan="3" width="75%"><@CommonQueryMacro.SingleField fId="actiondesc"/></td>
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

    //当页面初始化完之后可以调用该方法执行需要处理的操
    function initCallGetter_post(dataset) {
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("actiontype",true);
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("recStatus",true);
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("approveStatus",true);
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("approveResult",true);
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("repStatus",true);
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("crtTm",true);
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("lstUpdTm",true);
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("actiondesc",true);

		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("exdebtcode",true);
		BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("debtorcode",true);

		if("new"==op){
			window.document.getElementById('sysMsgGroup').style.display="none";
		}

		if("del"==op ){
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("actiondesc",false);
			BopForSameInduDepositInfoCol_dataset.getField("actiondesc").required= true;

			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("exdebtcode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("creditorcode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("debtorcode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("creditorname",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("debtype",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("creditornamen",true);
			//BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("limitType",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("creditortype",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("valuedate",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("crehqcode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("contractcurr",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("opercode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("floatrate",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("spapfeboindex",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("anninrate",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("remark",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("filler2",true);


		}else if("detail" ==op){

			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("exdebtcode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("creditorcode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("debtorcode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("creditorname",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("debtype",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("creditornamen",true);
			//BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("limitType",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("creditortype",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("valuedate",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("crehqcode",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("contractcurr",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("opercode",true);
			//BopForSameInduDepositInfoCol_dataset.disa("floatrate",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("spapfeboindex",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("anninrate",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("remark",true);
			BopForSameInduDepositInfoCol_dataset.setFieldReadOnly("filler2",true);

			document.getElementById("btSave").style.display="none";
		}
				var repStatus = BopForSameInduDepositInfoCol_dataset.getValue("repStatus");
				if (repStatus != "02") {
					document.getElementById("repHerf").href="#";
					document.getElementById("repHerf").style.color="#999999";
				}
    }

    	function  BopForSameInduDepositInfoCol_dataset_afterChange(dataset,field){
    		if(field.fieldName =="anninrate"){
				var anninrate  = parseFloat(BopForSameInduDepositInfoCol_dataset.getValue("anninrate"));
				if(anninrate <0){
					alert("年化利率值不能小于零!");
					BopForSameInduDepositInfoCol_dataset.setValue("anninrate","");
					return false;
				}
			}
    	}

    	function btSave_onClickCheck(button){
    		if("del" != op ){
				var creditorname = BopForSameInduDepositInfoCol_dataset.getValue("creditorname");
				var creditornamen = BopForSameInduDepositInfoCol_dataset.getValue("creditornamen");
				if(creditorname =="" &&  creditornamen ==""){
					alert("中文名称和英文名称至少填一个!");
					return false;
				}

				var anninrate = BopForSameInduDepositInfoCol_dataset.getValue("anninrate");//年化利率值
				if (!isNaN(anninrate) && parseFloat(anninrate) >= 1) {
					alert("[年化利率值]必须为小数");
					return false;
				}

				if(op =="del"){
					var actiondesc = BopForSameInduDepositInfoCol_dataset.getValue("actiondesc");
					if (actiondesc.length == 0) {
						alert("请填写删除原因！");
						return false;
					}
				}
			}
			return true;

		}


		function btSave_postSubmit(button){
			alert("保存成功！");
			closeWin(true);
		}

		function doRepDet(){
			var id = BopForSameInduDepositInfoCol_dataset.getValue("id");
			var appType = BopForSameInduDepositInfoCol_dataset.getValue("appType");
			var currentfile = BopForSameInduDepositInfoCol_dataset.getValue("currentfile");
			//var busiCode = BopForSameInduDepositInfoCol_dataset.getValue("fileNumber");
			showPickup("回执结果","${contextPath}/fpages/commonloadpage/ftl/ReportApproveResult.ftl?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile );
		}

   	function debtype_DropDown_beforeOpen(dropDown){

	   DataDicTreeSelect_DropDownDataset.setParameter("headDataTypeNo","24");
	}

	function creditortype_DropDown_beforeOpen(dropDown){
	   DataDicTreeSelectCor_DropDownDataset.setParameter("headDataTypeNo","23");
	}

	function btBack_onClick(button){
			closeWin();
	}
</script>
</@CommonQueryMacro.page>
