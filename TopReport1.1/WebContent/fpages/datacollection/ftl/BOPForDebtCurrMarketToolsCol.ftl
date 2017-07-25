<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="BOPForDebtBilLoan.title">
<table width="100%">
	<tr>
		<td width="100" valign="top">
			<tr>
				<td>
					<@CommonQueryMacro.CommonQuery id="BOPForDebtCurrMarketToolsCol" init="true" submitMode="all" navigate="false">
						<table width="90%" cellpadding="2">
							<tr>
								<td width="75%" valign="top">
									<table width="100%" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<@CommonQueryMacro.GroupBox id="guoup1" label="������Ϣ" expand="true">
													<table frame=void class="grouptable" width="100%">
														<tr>
															<td colspan="2" align="center" nowrap class="labeltd">��ծ���</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="exdebtcode"/></td>
															<td rowspan="6" align="center" nowrap class="labeltd">ծ<br>Ȩ<br>��<br>��<br>Ϣ</td>
															<td align="center" nowrap class="labeltd">����</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="creditortype"/></td>
														</tr>
														<tr>
															<td colspan="2" align="center" nowrap class="labeltd">ծ���˴���</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="debtorcode"/></td>
															<td align="center" nowrap class="labeltd">����</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="creditorcode"/></td>
														</tr>
														<tr>

															<td colspan="2" align="center" nowrap class="labeltd">ծ������</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="debtype"/></td>
															<td align="center" nowrap class="labeltd">��������</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="creditorname"/></td>
														</tr>
														<tr>
															<td colspan="2" align="center" nowrap class="labeltd">ǩԼ����</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="contractcurr"/></td>
															<td align="center" nowrap class="labeltd">Ӣ������</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="creditornamen"/></td>
														</tr>
														<tr>
															<td colspan="2"  align="center" nowrap class="labeltd">ǩԼ���</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="contractamount"/></td>
															<td align="center" nowrap class="labeltd">�ܲ����ڹ��ң�����������</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="crehqcode"/></td>
														</tr>
														<tr>
															<td colspan="2"  align="center" nowrap class="labeltd">��Ϣ��</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="valuedate"/></td>
															<td align="center" nowrap class="labeltd">��Ӫ�����ڹ��ң�����������</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="opercode"/></td>
														</tr>
														<tr>
															<td colspan="2"  align="center" nowrap class="labeltd">�Ƿ񸡶�����</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="floatrate"/></td>
															<td colspan="2"  align="center" nowrap class="labeltd">������</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="maturity"/></td>
														</tr>
														<tr>
															<td colspan="2"  align="center" nowrap class="labeltd">�Ƿ�������������ռ��ָ��</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="spapfeboindex"/></td>
															<td colspan="2"  align="center" nowrap class="labeltd">�껯����ֵ</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="anninrate"/></td>
														</tr>
														<tr>
															<td colspan="2"  align="center" nowrap class="labeltd">ISIN CODE</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="isincode"/></td>
															<td colspan="2"  align="center" nowrap class="labeltd">ҵ����ˮ��</td>
															<td  class="datatd"><@CommonQueryMacro.SingleField fId="filler2"/></td>
														</tr>
														<tr>
															<td colspan="2"  align="center" nowrap class="labeltd">��ע</td>
															<td colspan="6" class="datatd"><@CommonQueryMacro.SingleField fId="remark"/></td>
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
												<@CommonQueryMacro.GroupBox id="guoup3" label="ϵͳ��Ϣ" expand="true">
						             				<table frame=void class="grouptable" width="100%">
														<tr>
															<td align="center" nowrap class="labeltd" width="25%">��������</td>
															<td nowrap class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="actiontype" /></td>
														</tr>
														<tr>
															<td align="center" nowrap class="labeltd" width="25%">��¼״̬</td>
															<td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="recStatus" /></td>
														</tr>
														<tr>
															<td align="center" nowrap class="labeltd">����״̬</td>
															<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="approveStatus" /></td>
														</tr>
														<tr>
															<td align="center" nowrap class="labeltd">�������</td>
															<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="approveResult" /></td>
														</tr>
														<tr>
															<td align="center" nowrap class="labeltd">��ִ״̬</td>
															<td nowrap class="datatd">
																<@CommonQueryMacro.SingleField fId="repStatus" /><a
																id="repHerf" href="javascript:doRepDet()">��ִ���</a>
															</td>
														</tr>
														<tr>
															<td align="center" nowrap class="labeltd">����ʱ��</td>
															<td nowrap class="datatd"><@CommonQueryMacro.SingleField fId="crtTm" /></td>
														</tr>
														<tr>
															<td align="center" nowrap class="labeltd">������ʱ��</td>
															<td class="datatd"><@CommonQueryMacro.SingleField fId="lstUpdTm" /></td>
														</tr>
													</table>
												</@CommonQueryMacro.GroupBox>
											</td>
										</tr>
										<tr>
											<td id="deleteasc">
												<@CommonQueryMacro.GroupBox id="guoup4" label="ɾ��ԭ��" expand="true">
													<table frame=void class="grouptable" width="100%">
														<tr>
															<td align="center" nowrap class="labeltd" width="25%">ɾ��ԭ��</td>
															<td class="datatd" width="75%"><@CommonQueryMacro.SingleField fId="actiondesc" /></td>
														</tr>
													</table>
												</@CommonQueryMacro.GroupBox>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</@CommonQueryMacro.CommonQuery>
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
		</td>
	</tr>
</table>
<script language="javascript">
    var op = "${RequestParameters["op"]?default('')}";
    //��ҳ���ʼ����֮����Ե��ø÷���ִ����Ҫ�����Ĳ�


	function debtype_DropDown_beforeOpen(dropDown){

	   DataDicTreeSelect_DropDownDataset.setParameter("headDataTypeNo","24");
	}

	function creditortype_DropDown_beforeOpen(dropDown){
	   DataDicTreeSelectCor_DropDownDataset.setParameter("headDataTypeNo","23");
	}

	function initCallGetter_post()
	{
		var approveStatus = BOPForDebtCurrMarketToolsCol_dataset.getValue("approveStatus");
		var repStatus = BOPForDebtCurrMarketToolsCol_dataset.getValue("repStatus");
		if (repStatus != "02") {
			document.getElementById("repHerf").href="#";
			document.getElementById("repHerf").style.color="#999999";
		}

		//ծȨ�����ʹ��룬�������������ʹ�������������г����ߡ�����ծ��ծȨ�����ʹ���ͳһ�Ϊ���ʱ��г�����
		BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditortype",true);

		if('new'==op)
		{
			window.document.getElementById('btColDel').style.display="none";
			window.document.getElementById('deleteasc').style.display="none";
			window.document.getElementById('repHerf').style.display="none";
			window.document.getElementById('sysMsgGroup').style.display="none";
		}
		else if('mod'==op)
		{
			window.document.getElementById('btColDel').style.display="none";
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("actiondesc",true);
		}
		else if('del' == op)
		{

		    BOPForDebtCurrMarketToolsCol_dataset.getField("actiondesc").required=true;

			window.document.getElementById('btColSave').style.display="none";
			//BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditortype",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("debtorcode",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditorcode",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("debtype",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditorname",true);

			//BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("contractdate",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditornamen",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("contractcurr",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("crehqcode",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("isincode",true);
			//filler2

			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("contractamount",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("opercode",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("valuedate",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("maturity",true);

			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("floatrate",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("anninrate",true);
			//BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("inprterm",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("spapfeboindex",true);

			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("remark",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("filler2",true);
		}
		else if('detaile' == op)
		{
			window.document.getElementById('btColDel').style.display="none";
			window.document.getElementById('btColSave').style.display="none";

			BOPForDebtCurrMarketToolsCol_dataset.readOnly=true;

			//BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditortype",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("debtorcode",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditorcode",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("debtype",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditorname",true);

			//BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("contractdate",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("creditornamen",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("contractcurr",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("crehqcode",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("isincode",true);

			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("contractamount",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("opercode",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("valuedate",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("maturity",true);

			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("floatrate",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("anninrate",true);
			//BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("inprterm",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("spapfeboindex",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("actiondesc",true);


			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("remark",true);
			BOPForDebtCurrMarketToolsCol_dataset.setFieldReadOnly("filler2",true);

		}
	}


   	function btNewClick(){


		btNew.click();

	}

    function doDelete()
	{
		//locate(id);
		btDel.click();
	}

		//��λһ����¼
	function locate(id) {

		var record = BOPForDebtCurrMarketToolsCol_dataset.find(["id"],[id]);
		if (record) {
			BOPForDebtCurrMarketToolsCol_dataset.setRecord(record);
		}
	}


	function btColSave_onClickCheck(button)
	{

		var anninrate = BOPForDebtCurrMarketToolsCol_dataset.getValue("anninrate");//�껯����ֵ
		if (!isNaN(anninrate) && parseFloat(anninrate) >= 1) {
				alert("[�껯����ֵ]����ΪС��");
				return false;
		}

		if(isEmtry(BOPForDebtCurrMarketToolsCol_dataset.getValue('creditortype') ))
		{
			alert("�ֶ�[ծȨ������ ]����Ϊ��!");
			return false;
		}
		if(isEmtry(BOPForDebtCurrMarketToolsCol_dataset.getValue('creditorname') ) && isEmtry(BOPForDebtCurrMarketToolsCol_dataset.getValue('creditornamen') ))
		{
			alert("ծȨ���������ƺ�ծȨ��Ӣ������������дһ��!");
			return false;
		}
		if (!BOPForDebtCurrMarketToolsCol_dataset.modified) {
				alert("�����޸ĺ��ٱ��棡");
				return false;
		 }
	}

	function btColSave_postSubmit(button){
		alert("����ɹ���");
		closeWin(true);
	}

	function btColDel_postSubmit(button){
		alert("ɾ���ɹ���");
		closeWin(true);
	}

	function btColDel_onClickCheck(button)
	{
		if (op == "del") {
			var actiondesc = BOPForDebtCurrMarketToolsCol_dataset.getValue("actiondesc");
			if (actiondesc.length == 0) {
				alert("����дɾ��ԭ��");
				return false;
			}
			BOPForDebtCurrMarketToolsCol_dataset.setParameter("op", op);
		}
	}


	function doRepDet(){
		var id = BOPForDebtCurrMarketToolsCol_dataset.getValue("id");
		var appType = BOPForDebtCurrMarketToolsCol_dataset.getValue("appType");
		var currentfile = BOPForDebtCurrMarketToolsCol_dataset.getValue("currentfile");
		var busiCode = BOPForDebtCurrMarketToolsCol_dataset.getValue("exdebtcode");
		showPickup("��ִ���","${contextPath}/fpages/commonloadpage/jsp/ReportBackErr.jsp?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile + "&busiCode=" + busiCode, 600, 500);
	}

	function doApproveDet(){
		var id = BOPForDebtCurrMarketToolsCol_dataset.getValue("id");
		var appType = BOPForDebtCurrMarketToolsCol_dataset.getValue("appType");
		var currentfile = BOPForDebtCurrMarketToolsCol_dataset.getValue("currentfile");
		showPickup("��˽��","${contextPath}/fpages/commonloadpage/ftl/ReportApproveResult.ftl?id=" + id + "&appType=" + appType + "&currentfile=" + currentfile,440,220);
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