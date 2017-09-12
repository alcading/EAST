<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQuery id="BopForCorAndAffOrgConLoadPage" init="false" submitMode="current" navigate="false" >
	<table align="left">
		<tr>
			<td>
				<@CommonQueryMacro.Interface id="interface"  label="请输入查询条件" />
			</td>
		</tr>
		<tr>
		  	<td>
		    	<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"   pageCache="false" showArrow="true"/>
		  	</td>
		</tr>
		<tr>
	      	<td>
				<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="exdebtcode[180],debtorcode[120],debtype[100],valuedate[100],contractcurr[120],floatrate[80],anninrate[80],creditorcode[80],creditorname[120],creditornamen[120],creditortype[80],spapfeboindex[80],crehqcode,opercode" readonly="true" hasFrame="true" width="1000" height="260"/>
	      	</td>
  		</tr>
  		<tr>
			<td>
				<@CommonQueryMacro.Button id= "btConfirm"/>&nbsp;&nbsp;
				<@CommonQueryMacro.Button id= "btConfirmBack"/>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	function datatable1_onDbClick(table,record) {
		copy2Value();
	}

	function btConfirm_onClick(button){
		copy2Value();
	}

	function copy2Value(){
		var ds = window.parent.BopForCorAndAffOrgContactOver_dataset;
		if (ds.length==0){
			ds.insertRecord("end");
		}
		ds.setValue("exdebtcode", BopForCorAndAffOrgConLoadPage_dataset.getValue("exdebtcode"));
		//ds.setValue("filler2", BopForCorAndAffOrgConLoadPage_dataset.getValue("filler2"));
		ds.setValue2("debtype", BopForCorAndAffOrgConLoadPage_dataset.getValue("debtype"));
		ds.setValue2("debtypeName", BopForCorAndAffOrgConLoadPage_dataset.getValue("debtypeName"));
		ds.setValue("debtorcode", BopForCorAndAffOrgConLoadPage_dataset.getValue("debtorcode"));
		ds.setValue("creditorcode", BopForCorAndAffOrgConLoadPage_dataset.getValue("creditorcode"));
		ds.setValue("creditorname", BopForCorAndAffOrgConLoadPage_dataset.getValue("creditorname"));
		ds.setValue("creditornamen", BopForCorAndAffOrgConLoadPage_dataset.getValue("creditornamen"));
		//ds.setValue2("limitType", BopForCorAndAffOrgConLoadPage_dataset.getValue("limitType"));
		ds.setValue2("creditortype", BopForCorAndAffOrgConLoadPage_dataset.getValue("creditortype"));
		ds.setValue2("creditortypeName", BopForCorAndAffOrgConLoadPage_dataset.getValue("creditortypeName"));
		ds.setValue("valuedate", BopForCorAndAffOrgConLoadPage_dataset.getValue("valuedate"));
		ds.setValue2("crehqcode", BopForCorAndAffOrgConLoadPage_dataset.getValue("crehqcode"));
		ds.setValue2("crehqcodeName", BopForCorAndAffOrgConLoadPage_dataset.getValue("crehqcodeName"));
		ds.setValue2("contractcurr", BopForCorAndAffOrgConLoadPage_dataset.getValue("contractcurr"));
		ds.setValue2("contractcurrName", BopForCorAndAffOrgConLoadPage_dataset.getValue("contractcurrName"));
		ds.setValue2("opercode", BopForCorAndAffOrgConLoadPage_dataset.getValue("opercode"));
		ds.setValue2("opercodeName", BopForCorAndAffOrgConLoadPage_dataset.getValue("opercodeName"));
		ds.setValue2("floatrate", BopForCorAndAffOrgConLoadPage_dataset.getValue("floatrate"));
		ds.setValue("anninrate", BopForCorAndAffOrgConLoadPage_dataset.getValue("anninrate"));
		ds.setValue2("spapfeboindex", BopForCorAndAffOrgConLoadPage_dataset.getValue("spapfeboindex"));
		ds.setValue("debtyperema", BopForCorAndAffOrgConLoadPage_dataset.getValue("remark"));
		ds.setValue("filler1", BopForCorAndAffOrgConLoadPage_dataset.getValue("id"));
		closeWin();
	}

	function btConfirmBack_onClick(button){
		closeWin();
	}
	
</script>
</@CommonQueryMacro.page>