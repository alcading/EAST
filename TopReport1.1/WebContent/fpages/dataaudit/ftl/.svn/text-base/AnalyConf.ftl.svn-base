<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign lntypeStr = statics["com.huateng.report.dataAnaly.util.ReportDataAnalyUtil"].getConfAnalyParamIds().trim()>
<@CommonQueryMacro.page title="数据分析">
<table width="98%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="analyConfEntry" init="true" submitMode="current">
	<table width="100%" cellpadding="5" cellspacing="1">
		<tr>
			<td valign="top" colspan="2" width="100%">
				<@CommonQueryMacro.Interface id="interface" label="数据分析配置查询" colNm=4 showButton="true"/>
			</td>
		</tr>
		<tr>
			<td valign="top" width="50%">
				<FIELDSET name='group' style="padding: 6px;">
				<LEGEND>配置信息</LEGEND>
				<@CommonQueryMacro.PagePilot id="pagePilot"  maxpagelink="9" showArrow="true" pageCache="false"/>
				<@CommonQueryMacro.DataTable id="dataTable1" fieldStr="id,busiType,appType,confSeq,confVaild,confType,confIsRet,errIsNext"  width="640" hasFrame="true"  />
				</FIELDSET>
			</td>
			<td width="50%">
			<FIELDSET name='group6' style="padding: 6px;">
				<LEGEND>分析配置详细信息</LEGEND>
				<table frame=void width="100%" class="grouptable">
	            	<tr>
	                  <td nowrap class="labeltd">配置编号</td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="id"/></td>
					  <td nowrap class="labeltd">有效性</td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="confVaild"/></td>
	                </tr>
	                <tr>
	                  <td nowrap class="labeltd">业务类型</td>
	                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="busiType"/></td>
	                  <td nowrap class="labeltd">应用类型</td>
	                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="appType"/></td>
	                </tr>
					<tr>
					  <td nowrap class="labeltd">执行顺序</td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="confSeq"/></td>
					  <td nowrap class="labeltd">出错继续是否向下执行</td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="errIsNext"/></td>
	                </tr>
	                <tr>
	                  <td nowrap class="labeltd">执行类型</td>
					  <td class="datatd" nowrap colspan="3"><@CommonQueryMacro.SingleField fId="confType"/>
					  </td>
					</tr>
					<tr>
	                  <td nowrap class="labeltd">执行命令</td>
					  <td class="datatd" nowrap colspan="3"><@CommonQueryMacro.SingleField fId="confClassPath"/>
					  <br/>执行类型为：java类，请输入类路径及方法名称，中间以：分隔;
					  <br/>执行类型为：存储过程，请输入存储过程名称(返回值out请放于最后1个参数列).
					  <br/>执行类型为：批处理，请输入批量任务号（JOBNO数值型).
					  </td>
					</tr>
	                <tr>
	                  <td nowrap class="labeltd">命令参数</td>
					  <td class="datatd" nowrap id="confParamIdsTd"></td>
					  <td class="labeltd" colspan="2">
					  系统可提供参数，同时请输入参数传入顺序。
					  </td>
					</tr>
					<tr>
	                  <td nowrap class="labeltd">返回值</td>
					  <td class="datatd" nowrap colspan="3"><@CommonQueryMacro.SingleField fId="confIsRet"/>
					  <li>执行类型为java类，返回值只支持返回java对象;</li>
					  <li>执行类型为存储过程，根据数据库选择,如：oracle为out参数,sqlserver为select形式；</li>
					  <li>执行类型为批处理，无返回值；</li>
					  </td>
					</tr>
					<tr>
	                  <td nowrap class="labeltd">返回值处理类</td>
					  <td class="datatd" nowrap colspan="3"><@CommonQueryMacro.SingleField fId="confRetClass"/>
					  <br/>如执行包含返回值，请输入类路径及方法名称，中间以：分隔；
					  <br/>返回值处理类方法最后一位为BiAnalyDetail对象(系统默认)；
					  </td>
					</tr>
					<tr>
	                  <td nowrap class="labeltd">配置说明</td>
					  <td class="datatd" nowrap colspan="3"><@CommonQueryMacro.SingleField fId="confInfo"/></td>
					</tr>
                </table>
                </FIELDSET>
                <br/>
                <@CommonQueryMacro.Button id= "btStatus"/>
                </td>
              </tr>
	</@CommonQueryMacro.CommonQuery>
<td>
</tr>
</table>
<script language="javascript">
	function initCallGetter_post(){
		btStatus.disable(true);
		analyConfEntry_interface_dataset.setValue("qbusiType",defaultType);
		document.getElementById("confParamIdsTd").innerHTML = report_checkbox.create("${lntypeStr}","<br/>","confParam",null,true);
	}

	function btStatus_postSubmit(button) {
		alert("保存成功");
		//刷新当前页
		analyConfEntry_dataset.flushData(analyConfEntry_dataset.pageIndex);
	}

	function btStatus_onClickCheck(button){
		var vals = report_checkbox.getCheckedValueBySeq("confParam");
		if(!vals){
			return vals;
		}
		analyConfEntry_dataset.setValue("confParamIds",vals);
		return true;
	}

	function analyConfEntry_dataset_afterScroll(dataset){
		var id = dataset.getValue("id");
	    if(id!=null&&id.length>0){
	    	btStatus.disable(false);
	    }else{
	    	btStatus.disable(true);
	    }
	    var pids = dataset.getString("confParamIds");
	    report_checkbox.setCheckBoxCheckedBySeq("confParam",pids);
	}

	function qappType_DropDown_beforeOpen(dropDown){
	     var type=analyConfEntry_interface_dataset.getValue("qbusiType");
	     if(type.length>0){
	     	AppTypeSelect_DropDownDataset.setParameter("type",type);
	     }
	     qappType_DropDown.cached=false;
	}
	function qbusiType_DropDown_onSelect(dropDown,record,editor){
	    var selId=record.getValue("data");
	    var oldId = analyConfEntry_interface_dataset.getValue("qbusiType");
	    if(selId!=oldId){
	    	analyConfEntry_interface_dataset.setValue2("qappType","");
	   	}
	    return true;
	}

</script>
</@CommonQueryMacro.page>