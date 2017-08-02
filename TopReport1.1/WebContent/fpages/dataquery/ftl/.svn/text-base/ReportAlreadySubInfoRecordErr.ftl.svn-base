<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="已报送记录">
<table width="900px" align="left">
	<tr>
		<td width="100%">
			<@CommonQueryMacro.CommonQuery id="ReportDataPackageDetailEntryErr" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.Group id="group1" label="报送文件信息" fieldStr="apptype,currentFileName1,crtTm,isImpRep,totalrecords,repFileName"/>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td width="100%">
			<@CommonQueryMacro.CommonQuery id="ReportAlreadySubInfo" init="true" submitMode="current" navigate="false">
			<table width="100%">
				<tr>
					<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
				</tr>
				<tr>
					<td>
					<@CommonQueryMacro.DataTable id="datatable2" fieldStr="errfield,errfieldcn,errMsg"   hasFrame="true" width="100%" height="220"/>
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.Button id="btBack"/>
					</td>
				</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script>
	ReportDataPackageDetailEntryErr_dataset.setFieldReadOnly("apptype",true);
	ReportDataPackageDetailEntryErr_dataset.setFieldReadOnly("currentFileName1",true);
	ReportDataPackageDetailEntryErr_dataset.setFieldReadOnly("crtTm",true);
	ReportDataPackageDetailEntryErr_dataset.setFieldReadOnly("isImpRep",true);
	ReportDataPackageDetailEntryErr_dataset.setFieldReadOnly("totalrecords",true);
	ReportDataPackageDetailEntryErr_dataset.setFieldReadOnly("repFileName",true);
	
	function btBack_onClick(){
		unloadPageWindows("userWin");
       	return false;
	}
</script>
</@CommonQueryMacro.page>