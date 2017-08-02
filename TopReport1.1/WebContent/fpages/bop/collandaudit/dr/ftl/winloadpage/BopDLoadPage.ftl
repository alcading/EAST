<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="境内收入单基础信息">
		<@CommonQueryMacro.CommonQuery id="BopDDsLoadPage" init="false" submitMode="all" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[80],buscode[100],workDate[100],recStatus[80],approveStatus[80],repStatus[80],actiontype[80],actiondesc[100],rptno[80],custype,idcode,custcod,custnm,oppuser,txccy,txamt,exrate,lcyamt,lcyacc,fcyamt,othamt,othacc,method,buscode,inchargeamt,inchargeccy,actiondesc" hasFrame="true" width="900" height="260" readonly="true"/>
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
			BopDDsLoadPage_interface_dataset.setValue("qworkDateStart","${v_txdate}");
			BopDDsLoadPage_interface_dataset.setValue("qworkDateEnd","${v_txdate}");
		}
		 var localDs = BopDDsLoadPage_dataset;
		function datatable1_onDbClick(table,record) {	   
			btSelect(record);
		}
		
		function btConfirm_onClick(button) {
			btSelect(localDs);
		}	
		function btSelect(localDs){
			
			var ds = window.parent.BopRDsAdd_dataset;
			if (ds.length==0){
				ds.insertRecord("end");
			}
			ds.setValue("rptno", localDs.getValue("rptno"));
			ds.setValue2("custype", localDs.getValue("custype"));
			ds.setValue("idcode", localDs.getValue("idcode"));
			ds.setValue("custcod", localDs.getValue("custcod"));
			ds.setValue("custnm", localDs.getValue("custnm"));
			ds.setValue("oppuser", localDs.getValue("oppuser"));
			ds.setValue("txccy", localDs.getValue("txccy"));
			ds.setValue("txccyName", localDs.getValue("txccyName"));
			ds.setValue("txamt", localDs.getValue("txamt"));
			ds.setValue("exrate", localDs.getValue("exrate"));
			ds.setValue("lcyamt", localDs.getValue("lcyamt"));
			ds.setValue("lcyacc", localDs.getValue("lcyacc"));
			ds.setValue("fcyamt", localDs.getValue("fcyamt"));
			ds.setValue("fcyacc", localDs.getValue("fcyacc"));
			ds.setValue("othamt", localDs.getValue("othamt"));
			ds.setValue("othacc", localDs.getValue("othacc"));
			ds.setValue2("method", localDs.getValue("method"));
			ds.setValue("buscode", localDs.getValue("buscode"));
			ds.setValue("inchargeccyName", localDs.getValue("inchargeccyName"));
			ds.setValue("inchargeamt", localDs.getValue("inchargeamt"));
			ds.setValue("currentfile", localDs.getValue("currentfile"));
			
			
			
			ds.setValue("filler1", localDs.getValue("id"));
			closeWin();
		}

		function btConfirmBack_onClick(button){
			closeWin();
		}
	</script>
</@CommonQueryMacro.page>