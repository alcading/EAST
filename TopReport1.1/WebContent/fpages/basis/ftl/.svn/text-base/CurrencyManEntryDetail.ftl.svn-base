<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']}" />
<@CommonQueryMacro.page title="币种信息维护">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="CurrencyManEntryDetail" init="true" submitMode="all" navigate="false">
	<table align="left">
	      <tr valign="top">
	  			<td valign="top">
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>币种信息维护详细信息</LEGEND>
					<table frame=void width="100%" class="grouptable" id="detailTable">
					<tr>
					             
		                  <td nowrap class="labeltd" colspan=2>修改前</td>
						          
						   <td nowrap class="labeltd" colspan=2>修改后</td>
						 
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">币种货币代码</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_id"/></td>
						   <td nowrap class="labeltd">币种货币代码</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="id"/></td>
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">币种名称</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_currencyName"/></td>
						   <td nowrap class="labeltd">币种名称</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="currencyName"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">小数点位数</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_dotNum"/></td>
		                  <td nowrap class="labeltd">小数点位数</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="dotNum"/></td>
		                </tr>   
					</table>
					</FIELDSET>
			<tr valign="top">
      		   <td valign="CENTER">
					<left><@CommonQueryMacro.Button id= "btClose"/></left>
      			</td>
      		</tr> 
      		
	  			</td>
	  		</tr>
	</table>
	</@CommonQueryMacro.CommonQuery>
<#else>
	<@CommonQueryMacro.CommonQuery id="CurrencyManEntryDetail" init="true" submitMode="all"  navigate="false">
	<table align="left">
      <tr valign="top">
  			<td valign="center">
  			<@CommonQueryMacro.Group id ="group1" label="币种信息维护详细信息" fieldStr="old_id,old_currencyName,old_dotNum" colNm=2/>
  			</td>
  		</tr>
  	<tr valign="top">
      		   <td valign="CENTER">
					<left><@CommonQueryMacro.Button id= "btClose"/></left>
      			</td>
      		</tr>
	</table>
	</@CommonQueryMacro.CommonQuery>
</#if>

 <script language="javascript">
     function btClose_onClickCheck(button){
       unloadPageWindows("partWin");
       return false;
     }
</script>
</@CommonQueryMacro.page>
