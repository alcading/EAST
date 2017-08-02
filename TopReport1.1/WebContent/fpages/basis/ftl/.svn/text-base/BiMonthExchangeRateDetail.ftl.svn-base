<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']}" />
<@CommonQueryMacro.page title="外汇月牌价维护">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="BiMonthExchangeRateDetail" init="true" submitMode="all" navigate="false">
	<table align="left">
	      <tr valign="top">
	  			<td valign="top">
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>外汇月牌价维护详细信息</LEGEND>
					<table frame=void width="100%" class="grouptable" id="detailTable">
					<tr>
					             
		                  <td nowrap class="labeltd" colspan=2>修改前</td>
						          
						   <td nowrap class="labeltd" colspan=2>修改后</td>
						 
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">币种</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_id"/></td>
						   <td nowrap class="labeltd">币种</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="id"/></td>
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">单位</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_rateUnit"/></td>
						   <td nowrap class="labeltd">单位</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="rateUnit"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">年月</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_yearMonth"/></td>
		                  <td nowrap class="labeltd">年月</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="yearMonth"/></td>
		                </tr>
		                <tr>
		                  <td nowrap class="labeltd">中间价</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_rateMidprice"/></td>
		                   <td nowrap class="labeltd">中间价</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="rateMidprice"/></td>
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
	<@CommonQueryMacro.CommonQuery id="BiMonthExchangeRateDetail" init="true" submitMode="all"  navigate="false">
	<table align="left">
      <tr valign="top">
  			<td valign="center">
  			<@CommonQueryMacro.Group id ="group1" label="外汇月牌价维护详细信息" fieldStr="old_id,old_rateUnit,old_yearMonth,old_rateMidprice" colNm=2/>
  			</td>
  		</tr>
  		<tr valign="top">
      		   <td valign="left">
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
