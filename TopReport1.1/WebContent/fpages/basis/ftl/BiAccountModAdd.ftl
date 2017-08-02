<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="">
<@CommonQueryMacro.CommonQuery id="BiAccountModAdd" init="true" insertOnEmpty="true" >

	
<table>
	<tr>
		<td>
		<@CommonQueryMacro.GroupBox id="BiAccountModAdd" label="客户账户信息维护" expand="true">
			<table frame=void class="grouptable" width="900px">
				<tr>
					<td rowspan="5"  align="center" nowrap class="labeltd" >客<br>户<br>账<br>户<br>信<br>息</td>
					<td align="center" nowrap class="labeltd" >客户账号 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="id"/> </td>
                    
                    <td rowspan="5"  align="center" nowrap class="labeltd" >客<br>户<br>账<br>户<br>信<br>息</td>
                    
                    <td align="center" nowrap class="labeltd" >开户时间 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="openTime"/> </td>
                   
				</tr>
				<tr>
				    <td align="center" nowrap class="labeltd" >客户号 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="customerId"/> </td>
                    
				   
                     <td align="center" nowrap class="labeltd" >销户时间 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="closeTime"/> </td>
                   
				</tr>
				<tr>
				
                     <td align="center" nowrap class="labeltd" >账号类型 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="accountType"/> </td>
                    
                      <td align="center" nowrap class="labeltd" >开户单位代码 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="enCode"/> </td>
                   
				</tr>
				<tr>
				
				    <td align="center" nowrap class="labeltd" >币种 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="accountCur"/> </td>
                    
                    
				  
                    
                    <td align="center" nowrap class="labeltd" >开户单位名称 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="chineseName"/> </td>
				</tr>
				<tr>
				    <td align="center" nowrap class="labeltd" >是否NRA账户</td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="isnraFlag"/> </td>
				    <td align="center" nowrap class="labeltd" >变更核准件编号 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="fileNumber"/> </td>
                    
                   
				</tr>
				
				<tr>
                   <td colspan="2"  align="center" nowrap class="labeltd" >贷方发生额 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="debits"/> </td>
   
		           <td  colspan="2"   align="center" nowrap class="labeltd" >借方发生额 </td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="credits"/>  </td>
                </tr>
                <tr>
                   <td colspan="2"  align="center" nowrap class="labeltd" >余额 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="balance"/> </td>
                </tr>
			</table>
		 </@CommonQueryMacro.GroupBox>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btBack"/>
		</td>
	</tr>
</table>

</@CommonQueryMacro.CommonQuery>
<script language="javascript">
var op = "${RequestParameters["op"]?default('')}";
//当页面初始化完之后可以调用该方法执行需要处理的操作
	function initCallGetter_post(dataset) {
	if ("new" == op) {
	} else {
		BiAccountModAdd_dataset.setFieldReadOnly("id",true);
	}
}
</script>
</@CommonQueryMacro.page>