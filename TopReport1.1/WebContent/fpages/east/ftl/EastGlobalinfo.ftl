<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign op="${RequestParameters['op']?default('')}" />
<#assign info = Session["USER_SESSION_INFO"]>
<@CommonQueryMacro.page title="修改工作日期">
	<@CommonQueryMacro.CommonQuery id="EastGlobalinfo" init="false">
		<@CommonQueryMacro.ToolBar id="EastGlobalinfo">
			<table width="100%">
				<tr>
					<td><@CommonQueryMacro.InterfaceElement elId="sjrq"/></td>
					<td><@CommonQueryMacro.Button id= "btSave" /></td>
				</tr>
			</table>
		</@CommonQueryMacro.ToolBar>
	</@CommonQueryMacro.CommonQuery>
	<iframe id="EastGlobalinfoUpdate"  style="display: none;"></iframe>
	
<script>
	window.onload=function(){
		var date = new Date();
	    var today_date = date.getDate();
	    if(today_date < 10) {
	    	today_date = "0" + date.getDate();
	    }
	    var currentDate = date.getFullYear()+"-" + (date.getMonth()+1) + "-" + today_date;
	    EastGlobalinfo_interface_dataset.setValue("sjrq", currentDate);
	
	}
	
	function Todate(num) { //Fri Oct 31 18:00:00 UTC+0800 2008
        num = num + "";
        var date = "";
        var month = new Array();
        month["Jan"] = 1; month["Feb"] = 2; month["Mar"] = 3; month["Apr"] = 4; month["May"] = 5; month["Jun"] = 6;
        month["Jul"] = 7; month["Aug"] = 8; month["Sep"] = 9; month["Oct"] = 10; month["Nov"] = 11; month["Dec"] = 12;
        var week = new Array();
        week["Mon"] = "一"; week["Tue"] = "二"; week["Wed"] = "三"; week["Thu"] = "四"; week["Fri"] = "五"; week["Sat"] = "六"; week["Sun"] = "日";
        str = num.split(" ");
        date = str[5] + "-";
        date = date + month[str[1]] + "-" + str[2];
        return date;
    }
	
	
	function btSave_needCheck(){
		return false;
	}
	
	// 修改
	function btSave_onClickCheck(button){
        var sjrq = EastGlobalinfo_interface_dataset.getValue("sjrq");
        sjrq = Todate(sjrq);
        if(null == sjrq || '' == sjrq){
        	easyMsg.info("请选择工作日期！");
        	return false;
        }
		document.getElementById("EastGlobalinfoUpdate").src ="${contextPath}/EastGlobalinfoUpdate?sjrq="+sjrq;
		return false;
  	}
</script>
</@CommonQueryMacro.page>

