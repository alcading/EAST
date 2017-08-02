<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="签约信息">

<@CommonQueryMacro.CommonQuery id="BopLiabilityBalanceAdd" init="true" submitMode="all" navigate="false" >
<table width="100%">
	<tr>
		<td width="75%" valign="top">
			<table width="100%" cellpadding="2">
				<tr>
				     <td>
					 <@CommonQueryMacro.GroupBox id="bopForCFAExgu" label="签约信息" expand="true">
                     <table frame=void class="grouptable" width="100%">
	                 <tr>
                     <td align="center" nowrap class="labeltd" colspan="2">对外担保编号</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="exguarancode" /><input id="loadLoanButton" extra="button" style='width=25px;height=17px;' onclick="loadLoan();" type='button' value='...'/></td>
                     <td align="center" nowrap class="labeltd" rowspan="3">担保申请人</td>
                     <td align="center" nowrap class="labeltd"">代码</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="torCodeGu" /></td>
                     </tr>
                     <tr>
                     <td align="center" nowrap class="labeltd" colspan="2">担保人代码</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="guarantorcode" /></td>
                     <td align="center" nowrap class="labeltd">中文名称</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="torNameGu"/></td>
                     </tr>
                     <tr>
                     <td align="center" nowrap class="labeltd" colspan="2">担保类型</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="guarantype" /></td>
                     <td align="center" nowrap class="labeltd">英文名称</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="torEnnameGu"/></td>
                     </tr>
                     <tr>
                     <td align="center" nowrap class="labeltd" colspan="2">签约日期</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="contractdate" /></td>
                     <td align="center" nowrap class="labeltd" colspan="2">到期日</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="maturity" /></td>
                     </tr>
                     <tr>
                     <td align="center" nowrap class="labeltd" colspan="2">保函币种</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="guarancurr" /></td>
                     <td align="center" nowrap class="labeltd" colspan="2">主债务币种</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="maindebtcurr" /></td>
                     </tr>
                     <tr>
                     <td align="center" nowrap class="labeltd" colspan="2">保函金额</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="guaranamount" /></td>
                     <td align="center" nowrap class="labeltd" colspan="2">主债务金额 </td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="maindebtamount" /></td>
                     </tr>
                     <tr>
                      <td colspan="2" align="center" nowrap class="labeltd">核准文件号</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="appdocuno" /></td>
                     <td colspan="2" align="center" nowrap class="labeltd">备注</td>
                     <td class="datatd"><@CommonQueryMacro.SingleField fId="remark" /></td>
                     </tr>
                     </table>
                     </@CommonQueryMacro.GroupBox>
				 	 </td>
				 </tr>
				 <tr>
				 	<td>
				 	<@CommonQueryMacro.GroupBox id="guoup1" label="责任余额信息" expand="true">
				      <table  frame=void class="grouptable" width="100%">
						<tr>
							<td align="center" nowrap class="labeltd">业务流水号</td>
                            <td class="datatd" colspan="3"><@CommonQueryMacro.SingleField fId="filler2" /></td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd">担保责任余额</td>
				            <td class="datatd"><@CommonQueryMacro.SingleField fId="basere"/></td>
				           <td align="center" nowrap class="labeltd">担保责任余额变动日期</td>
				           <td class="datatd"><@CommonQueryMacro.SingleField fId="wabachandate"/></td>
						</tr>

						<tr style="display: none">
							<td colspan="2">
								<@CommonQueryMacro.Button id= "btNew"/>&nbsp;&nbsp;
								<@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
								<@CommonQueryMacro.Button id="btMod"/>&nbsp;&nbsp;
								<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;

							</td>
						</tr>
						</table>
					 </@CommonQueryMacro.GroupBox>
				 	</td>
				 </tr>
				 <tr>
					 <td colspan="2">
						<@CommonQueryMacro.Button id= "btColSave"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btColDel"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btBack"/>
					</td>
					 </td>
				 </tr>
			</table>
		</td>
		<td width="25%"valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td id="xitong"><@CommonQueryMacro.GroupBox id="guoup3" label="系统信息"
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
								<td nowrap class="datatd">
									<@CommonQueryMacro.SingleField fId="approveStatus" />
								</td>
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
									<@CommonQueryMacro.SingleField fId="repStatus" /><a
									id="repHerf" href="javascript:doRepDet()">回执结果</a>
								</td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">创建时间</td>
								<td nowrap class="datatd">
									<@CommonQueryMacro.SingleField fId="crtTm" /></td>
							</tr>
							<tr>
								<td align="center" nowrap class="labeltd">最后更新时间</td>
								<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm" /></td>
							</tr>
						</table> </@CommonQueryMacro.GroupBox></td>
				</tr>
				<tr>
					<td id="deleteasc"><@CommonQueryMacro.GroupBox id="guoup4" label="删除原因" expand="true">
						<table frame=void class="grouptable" width="100%">
							<tr>
								<td align="center" nowrap class="labeltd" width="25%">删除原因</td>
								<td class="datatd" width="75%"><@CommonQueryMacro.SingleField fId="actiondesc" /></td>
							</tr>
						</table> </@CommonQueryMacro.GroupBox></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
var op = "${RequestParameters["op"]?default('')}";

function btBack_onClick(){
	closeWin();
}

   //担保类型下拉框
  function guarantype_DropDown_beforeOpen(dropDown){
	DataDicTreeSelectChangType_DropDownDataset.setParameter("headDataTypeNo","39");
   }

	//新增功能
	function btNewClick() {
		btAdd.click();
	}

	function btDelClick() {
		btDel.click();
	}
	function doRepDet(){
		var id = BopLiabilityBalanceAdd_dataset.getValue("id");
		var appType = BopLiabilityBalanceAdd_dataset.getValue("appType");
		var currentfile = BopLiabilityBalanceAdd_dataset.getValue("currentfile");
		var busiCode = BopLiabilityBalanceAdd_dataset.getValue("exguarancode");
		showPickup("回执结果","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
	}
	function doApproveDet(){
		var id = BopLiabilityBalanceAdd_dataset.getValue("id");
		var appType = BopLiabilityBalanceAdd_dataset.getValue("appType");
		var currentfile = BopLiabilityBalanceAdd_dataset.getValue("currentfile");
		showPickup("审核结果","${contextPath}/fpages/commonloadpage/ftl/ReportApproveResult.ftl?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile,440,220);
	}
	function btDel_onClickCheck(button) {
		return confirm("确认删除该条记录？");
	}
	function btDel_postSubmit(button) {
		alert("删除记录成功");
		button.url="#";
		//刷新当前页
		flushCurrentPage();
	}
	function btSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}
	function initCallGetter_post()
	{
		var approveStatus = BopLiabilityBalanceAdd_dataset.getValue("approveStatus");
		if (approveStatus == "00") {
			//document.getElementById("approveHref").style.color="#999999";
		}
		var repStatus = BopLiabilityBalanceAdd_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
			}
		if('new'==op)
		{
			window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('btColDel').style.display="none";
			window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('xitong').style.display="none";
			window.document.getElementById('repHerf').style.display="none";
			window.document.getElementById('deleteasc').style.display="none";
		}
		else if('mod'==op){
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("actiondesc",true);
			document.getElementById("loadLoanButton").style.display="none";
			//window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('btColDel').style.display="none";
		}
		else if('del'==op)
		{
			BopLiabilityBalanceAdd_dataset.getField("actiondesc").required=true;
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("crtTm",true);

			window.document.getElementById('btColSave').style.display="none";
			document.getElementById("loadLoanButton").style.display="none";
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("filler2",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("basere",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("wabachandate",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("basere",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("wabachandate",true);

		}
		else if('detail'==op)
		{
			window.document.getElementById('btColDel').style.display="none";
			window.document.getElementById('btColSave').style.display="none";
			//window.document.getElementById('deleteasc').style.display="none";
			document.getElementById("loadLoanButton").style.display="none";
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("filler2",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("basere",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("wabachandate",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("actiondesc",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("basere",true);
			BopLiabilityBalanceAdd_dataset.setFieldReadOnly("wabachandate",true);
		}
	}

	//弹出账户信息选择框
	function loadLoan(){
		showPickup("对外担保签约信息","${contextPath}/fpages/datacollection/ftl/winloadpage/BopExguLoadPage.ftl?currentFile=BB");
	}
	function btColSave_postSubmit(button){
		alert("保存成功！");
		closeWin(true);
	}
	function btColSave_onClickCheck(button){
		var exguarancode = BopLiabilityBalanceAdd_dataset.getValue("exguarancode");
		if(!exguarancode){
			alert("对外担保编号不为空")
			return false;
		}
	}

	function btColDel_onClickCheck(button)
	{
		if (op == "del") {
			var actiondesc = BopLiabilityBalanceAdd_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("请填写删除原因！");
				return false;
			}
			BopLiabilityBalanceAdd_dataset.setParameter("op", op);
		}
	}
	function btColDel_postSubmit(button){
		alert("删除成功");
		closeWin(true);
	}
</script>
</@CommonQueryMacro.page>