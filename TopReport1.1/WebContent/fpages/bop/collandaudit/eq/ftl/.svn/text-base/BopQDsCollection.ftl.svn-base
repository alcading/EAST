<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="境内汇款申请书-管理信息">
	<@CommonQueryMacro.CommonQueryTab id="BopEQDsCollectionTabs" navigate="false" currentTab="BopQDsCollection">
		<@CommonQueryMacro.CommonQuery id="BopQDsCollection" init="false" submitMode="all" navigate="false" >
		<table align="left">
			<tr>
				<td colspan="2">
					<@CommonQueryMacro.Interface id="interface"  label="请输入查询条件" />
				</td>
			</tr>
			<tr>

  			  <td>
  			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"   pageCache="false" showArrow="true"/>
  			  </td>
  			 </tr>
  			 <tr>
		      	<td colspan="2">
					<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[100],filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[100],country[80],isref[80],paytype[80],payattr[80],txcode[80],tc1amt[80],txcode2[80],tc2amt[80],contrno[100],invoino[80],regno[80],crtuser[80],inptelc[80],rptdate[80]" readonly="true" hasFrame="true" width="900" height="260"/>
		      	</td>

		      </tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">
	function initCallGetter_post()
	{
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		BopQDsCollection_interface_dataset.setValue("qworkDateStart",currentDate);
		BopQDsCollection_interface_dataset.setValue("qworkDateEnd",currentDate);
	}
	
	//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			var recStatus = record.getValue("recStatus");
			var innerStr = "<center>";
			if (recStatus == "01" || recStatus == "02") {
				innerStr = innerStr + "<a href=\"JavaScript:doModify('"+id+"')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDelete('"+id+"')\">删除</a>"
			} else {
				innerStr = innerStr + "<a title='该记录状态不可修改' style='color:#999999'>修改</a>&nbsp;&nbsp;<a title='该记录状态不可删除' style='color:#999999'>删除</a>";
			}
			innerStr = innerStr + "</center>";
			 
			cell.innerHTML =innerStr;
		} else {//当不存在记录时
		 	cell.innerHTML="&nbsp;";
		}
	}
	
	
	function locate(id) {
		
		var record = BopQDsCollection_dataset.find(["id"],[id]);
		if (record) {
			BopQDsCollection_dataset.setRecord(record);
		}
	}
	
    function datatable1_filler2_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			var filler2 = record.getValue("filler2");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}
	
	function btAdd_onClick(button) {
		btNewClick();
	}
	
	//刷新数据
	function flushPage(){
		BopQDsCollection_dataset.flushData(1);
	}
	
	//新增
	function btNewClick(){                 
		showWin("境内汇款申请书-管理信息新增","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopQDsCollectionInfo.ftl?op=add","window","flushPage()",window);
	}
	
	//详细
	function doDetail(id) {
		showWin("境内汇款申请书-管理信息详细","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopQDsCollectionInfo.ftl?id="+id+"&op=det","window","flushPage()",window);
	}
	
	//修改
	function doModify(id) {
		showWin("境内汇款申请书-管理信息修改","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopQDsCollectionInfo.ftl?id="+id+"&op=mod","window","flushPage()",window);
	}

	//删除
	function doDelete(id) {
		showWin("境内汇款申请书-管理信息删除","${contextPath}/fpages/bop/collandaudit/eq/ftl/BopQDsCollectionInfo.ftl?id="+id+"&op=del","window","flushPage()",window);
	}
	

</script>
</@CommonQueryMacro.page>