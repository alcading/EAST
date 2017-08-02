<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="BOPForDebtBilLoan.title">
 <@CommonQueryMacro.CommonQuery id="BOPForDebtChangInfoCol" init="true" submitMode="all" navigate="false">
<table width="90%" cellpadding="2">
	<tr>
		<td width="75%" valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td><@CommonQueryMacro.GroupBox id="guoup1" label="签约信息"
						expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>

								<td colspan="2" align="center" nowrap class="labeltd">外债编号
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="exdebtcode"/><input id="loadLoanButton" extra="button" style='width=25px;height=17px;' onclick="loadLoan();" type='button' value='...'/></td>

								<td rowspan="6" align="center" nowrap class="labeltd">债<br>权<br>人<br>信<br>息</td>

								<td align="center" nowrap class="labeltd">类型</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="creditortype"/></td>

							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">债务人代码
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="debtorcode"/></td>

								<td align="center" nowrap class="labeltd">代码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="creditorcode"/></td>

							</tr>
							<tr>

								<td colspan="2" align="center" nowrap class="labeltd">债务类型
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="debtype"/></td>

								<td align="center" nowrap class="labeltd">中文名称</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="creditorname"/></td>

							</tr>
							<tr>
								<td colspan="2" align="center" nowrap class="labeltd">签约币种</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="contractcurr"/></td>

								<td align="center" nowrap class="labeltd">英文名称</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="creditornamen"/></td>
							</tr>
							<tr>
								<td colspan="2"  align="center" nowrap class="labeltd">签约金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="contractamount"/></td>

								<td align="center" nowrap class="labeltd">总部所在国家（地区）代码</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="crehqcode"/></td>
							</tr>

							<tr>
								<td colspan="2"  align="center" nowrap class="labeltd">起息日</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="valuedate"/></td>


								<td align="center" nowrap class="labeltd">经营地所在国家（地区）代码
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="opercode"/></td>


							</tr>

							<tr>
								<td colspan="2"  align="center" nowrap class="labeltd">是否浮动利率
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="floatrate"/></td>

								<td colspan="2"  align="center" nowrap class="labeltd">到期日</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="maturity"/></td>
							</tr>

							<tr>
								<td colspan="2"  align="center" nowrap class="labeltd">是否有利息本金化条款</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="inprterm"/></td>

								<td colspan="2"  align="center" nowrap class="labeltd">年化利率值
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="anninrate"/></td>
							</tr>
							<tr>


								<td colspan="2"  align="center" nowrap class="labeltd">是否经外汇局特批不需占用指标
								</td>
								<td class="datatd" colspan="4"><@CommonQueryMacro.SingleField
									fId="spapfeboindex"/></td>


							</tr>
							<tr>

							</tr>
					</table>
						 </@CommonQueryMacro.GroupBox>
						</td>
				</tr>
				<tr>
					<td>

					<@CommonQueryMacro.GroupBox id="guoup2" label="变动信息" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>

								<td align="center" nowrap class="labeltd">银行业务参号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="buscode"/></td>



								<td align="center" nowrap class="labeltd">变动编号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="changeno"/></td>

							</tr>
							<tr>
								<td  align="center" nowrap class="labeltd">变动类型
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="changtype"/></td>

								<td align="center" nowrap class="labeltd">变动日期</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="chdate"/></td>

							</tr>
							<tr>

								<td  align="center" nowrap class="labeltd">变动币种
								</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="chcurrency"/></td>

								<td align="center" nowrap class="labeltd">变动金额</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="chamount"/></td>

							</tr>
							<tr>


								<td align="center" nowrap class="labeltd">公允价值</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="fairvalue"/></td>

								<td align="center" nowrap class="labeltd">业务流水号</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="filler2"/></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">备注</td>
								<td class="datatd" colspan="3"><@CommonQueryMacro.SingleField
									fId="remark"/></td>
							</tr>

						</table></@CommonQueryMacro.GroupBox>
						</td>

				</tr>
			</table>
		</td>
		<td width="8px"></td>
		<td width="25%" valign="top" id="sysMsgGroup">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td><@CommonQueryMacro.GroupBox id="guoup3" label="系统信息"
						expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd" width="25%">操作类型</td>
								<td nowrap class="datatd" width="25%">
									<@CommonQueryMacro.SingleField fId="actiontype" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd" width="25%">记录状态</td>
								<td class="datatd" width="25%">
									<@CommonQueryMacro.SingleField fId="recStatus" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">审批状态</td>
								<td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="approveStatus" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">审批结果</td>
								<td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="approveResult" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">回执状态</td>
								<td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="repStatus" /><a id="repHerf" href="javascript:doRepDet()">回执结果</a>
								</td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">创建时间</td>
								<td nowrap class="datatd"><@CommonQueryMacro.SingleField
									fId="crtTm" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">最后更新时间</td>
								<td class="datatd"><@CommonQueryMacro.SingleField
									fId="lstUpdTm" /></td>
							</tr>
						</table> </@CommonQueryMacro.GroupBox></td>
				</tr>
				<tr>
					<td id="deleteasc"><@CommonQueryMacro.GroupBox id="guoup4"
						label="删除原因" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd" width="25%">删除原因</td>
								<td class="datatd" width="75%">
									<@CommonQueryMacro.SingleField fId="actiondesc" /></td>
							</tr>
						</table> </@CommonQueryMacro.GroupBox></td>
				</tr>
			</table>
			</td>
	</tr>
 	<tr>
				<td>
					<table>
						 <tr>
							 <td colspan="2">
									<@CommonQueryMacro.Button id= "btColSave"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btColDel"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btBack"/>
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

	function debtype_DropDown_beforeOpen(dropDown){

	   DataDicTreeSelect_DropDownDataset.setParameter("headDataTypeNo","24");
	}

	function creditortype_DropDown_beforeOpen(dropDown){
	   DataDicTreeSelectCor_DropDownDataset.setParameter("headDataTypeNo","23");
	}

	function changtype_DropDown_beforeOpen(dropDown){
	   DataDicTreeSelectChangType_DropDownDataset.setParameter("headDataTypeNo","31");
	}


	function initCallGetter_post()
	{

			var approveStatus = BOPForDebtChangInfoCol_dataset.getValue("approveStatus");
			var repStatus = BOPForDebtChangInfoCol_dataset.getValue("repStatus");
			if (repStatus != "02") {
				document.getElementById("repHerf").href="#";
				document.getElementById("repHerf").style.color="#999999";
				}

		if('new'==op )
		{
			window.document.getElementById('btColDel').style.display="none";
			window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('repHerf').style.display="none";
			window.document.getElementById('sysMsgGroup').style.display="none";
		}
		else if("mod"==op)
		{
			window.document.getElementById('btColDel').style.display="none";
		}
		else if("del" ==op)
		{	setReadOnly();
		window.document.getElementById('btColSave').style.display="none";
			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("filler2",true);

		}
		else if("detaile" ==op)
		{	setReadOnly();
		window.document.getElementById('btColDel').style.display="none";
		window.document.getElementById('btColSave').style.display="none";
		    BOPForDebtChangInfoCol_dataset.setFieldReadOnly("actiondesc",true);
		    BOPForDebtChangInfoCol_dataset.setFieldReadOnly("filler2",true);
		}
	}


	function setReadOnly()
	{
			BOPForDebtChangInfoCol_dataset.getField("actiondesc").required=true;



			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("buscode",true);
			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("changeno",true);
			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("changtype",true);
			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("chdate",true);
			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("chcurrency",true);

			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("chamount",true);
			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("fairvalue",true);
			BOPForDebtChangInfoCol_dataset.setFieldReadOnly("remark",true);


			document.getElementById("loadLoanButton").style.display="none";
	}

	//弹出账户信息选择框
	function loadLoan(){

		showPickup("贵金属拆借签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopCfaDebtBiLoanLoadPage.ftl?currentFile=AH");

	}

   	function btNewClick(){


		btNew.click();

	}

	function btColSave_onClickCheck(button)
	{
		if(isEmtry(BOPForDebtChangInfoCol_dataset.getValue('buscode') ))
		{
			alert("字段[ 银行业务参号 ] 不能为空!");
			return false;
		}
		 if(isEmtry(BOPForDebtChangInfoCol_dataset.getValue('exdebtcode') ))
		{
			alert("字段[ 外债编号 ] 不能为空!");
			return false;
		}

		if (!BOPForDebtChangInfoCol_dataset.modified) {
				alert("请先修改后再保存！");
				return false;
		 }
	}

	function btColSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}

	function btColDel_postSubmit(button){
		alert("删除成功！");
		closeWin(true);
	}

	function btColDel_onClickCheck(button)
	{

		if (op == "del") {
			var actiondesc = BOPForDebtChangInfoCol_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("请填写删除原因！");
				return false;
			}
			BOPForDebtChangInfoCol_dataset.setParameter("op", op);
		}

	}


	function doRepDet(){
		var id = BOPForDebtChangInfoCol_dataset.getValue("id");
		var appType = BOPForDebtChangInfoCol_dataset.getValue("appType");
		var currentfile = BOPForDebtChangInfoCol_dataset.getValue("currentfile");
		var busiCode = BOPForDebtChangInfoCol_dataset.getValue("exdebtcode");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
	}

	function doApproveDet(){
		var id = BOPForDebtChangInfoCol_dataset.getValue("id");
		var appType = BOPForDebtChangInfoCol_dataset.getValue("appType");
		var currentfile = BOPForDebtChangInfoCol_dataset.getValue("currentfile");
		showPickup("审核结果","${contextPath}/fpages/commonloadpage/ftl/ReportApproveResult.ftl?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile,440,220);
	}


	function isEmtry(value)
	{
		if (''==value || null ==value)
		{
			return true;
		}
		else return false;
	}


	function btBack_onClick(){
		closeWin();
	}
</script>
</@CommonQueryMacro.page>
