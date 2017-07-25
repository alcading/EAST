<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="�䶯��Ϣ">

<@CommonQueryMacro.CommonQueryTab id="bopForDebtOtherLoansQueryTabs" navigate="false" currentTab="BOPForDebtOtherLoansChangeQuery">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtChangeInfoQuery" init="false" submitMode="all" navigate="false" >
		<table align="left">
			<tr>
				<td colspan="2">
					<@CommonQueryMacro.Interface id="interface"  label="�������ѯ����" />
				</td>
			</tr>
			<tr>

  			  <td>
  			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"   pageCache="false" showArrow="true"/>
  			  </td>
  			 </tr>
  			 <tr>
		      	<td colspan="2">
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="brNo[140],filler2,brNoName[180],workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],buscode[120],changeno[100],changtype[120],chdate[100],chcurrency[160],chamount[120],fairvalue[120]" readonly="true" hasFrame="true" width="900" height="260"/>
		      	</td>

		      </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">


	function initCallGetter_post()
	{
		BOPForDebtChangeInfoQuery_dataset.setParameter("changFileType","AI");
		<#assign workdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()?default('')>
		BOPForDebtChangeInfoQuery_interface_dataset.setValue("qstartdate", "${workdate}");
		BOPForDebtChangeInfoQuery_interface_dataset.setValue("qenddate", "${workdate}");
	}

//	function locate(id) {
//		var record = BOPForDebtChangeInfoQuery_dataset.find(["id"],[id]);
//		if (record) {
//			BOPForDebtChangeInfoQuery_dataset.setRecord(record);
//		}
//	}

    function datatable1_filler2_onRefresh(cell,value,record) {
		if (record) {//�����ڼ�¼ʱ
			var id = record.getValue("id");
			var filler2 = record.getValue("filler2");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}

	//��ϸ
//	function doDetail(id) {
//		var changFileType = "AI";
//		showWin("��������䶯��Ϣ","${contextPath}/fpages/datacollection/ftl/BOPForDebtOtherLoansChangeInfoCol.ftl?id="+id+"&op=detaile&changFileType="+changFileType);
//	}

	//��ϸ
	function doDetail(id) {
		var changFileType = "AI";
		showWin("��������䶯��Ϣ","${contextPath}/fpages/datacollection/ftl/BOPForDebtOtherLoansChangeInfoCol.ftl?id="+id+"&op=detaile&changFileType="+changFileType,"report","flushPage()");
	}

    //ˢ������
	function flushPage(){
		BOPForDebtChangeInfoQuery_dataset.flushData();
	}

</script>
</@CommonQueryMacro.page>