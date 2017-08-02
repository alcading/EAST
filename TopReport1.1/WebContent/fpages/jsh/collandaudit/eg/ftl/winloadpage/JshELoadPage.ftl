<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="外汇账户内购汇基础信息">
		<@CommonQueryMacro.CommonQuery id="JshEDsLoadPage" init="false" submitMode="all" navigate="false" >
			<table align="left">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					</td>
				</tr>

				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="9" showArrow="true" />
					</td>
		    	</tr>

		    	<tr>
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[80],custype,custcod,idcode,custnm,lcyacc,fcyacc,oppuser,oppbank,lcyamt,lcyccy,exrate" hasFrame="true" width="900" height="260" readonly="true"/>
		      		</td>
		    	</tr>
		    	<tr colspan="2">
			        <td>
			        <@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
					<@CommonQueryMacro.Button id= "btConfirmBack"/>&nbsp;&nbsp;
				
			       </td>
		        </tr>
			</table>
		</@CommonQueryMacro.CommonQuery>


	<script language="JavaScript">
	
		//工作日期
		function initCallGetter_post() {
			<#assign v_txdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
			JshEDsLoadPage_interface_dataset.setValue("qworkDateStart","${v_txdate}");
			JshEDsLoadPage_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
		}
		 var localDs = JshEDsLoadPage_dataset;
		function datatable1_onDbClick(table,record) {	   
			btSelect(record);
		}
		
		function btConfirm_onClick(button) {
			btSelect(localDs);
		}	
		function btSelect(localDs){
			
			var ds = window.parent.JshGDsAdd_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			ds.setValue("rptno", localDs.getValue("rptno"));
			ds.setValue("buscode", localDs.getValue("buscode"));
			ds.setValue("custcod", localDs.getValue("custcod"));
			ds.setValue2("custype", localDs.getValue("custype"));
			ds.setValue("idcode", localDs.getValue("idcode"));
			ds.setValue("custnm", localDs.getValue("custnm"));
			ds.setValue("lcyacc", localDs.getValue("lcyacc"));
			ds.setValue("fcyacc", localDs.getValue("fcyacc"));
			ds.setValue("oppuser", localDs.getValue("oppuser"));
			ds.setValue("oppbank", localDs.getValue("oppbank"));
			ds.setValue("lcyamt", localDs.getValue("lcyamt"));
			ds.setValue2("lcyccy", localDs.getValue("lcyccy"));
			ds.setValue("exrate", localDs.getValue("exrate"));		
			ds.setValue("filler1", localDs.getValue("id"));
			closeWin();
		}

		function btConfirmBack_onClick(button){
			closeWin();
		}
	</script>
</@CommonQueryMacro.page>