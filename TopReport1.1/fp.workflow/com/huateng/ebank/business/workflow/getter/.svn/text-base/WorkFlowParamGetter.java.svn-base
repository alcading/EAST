/**
 *
 */
package com.huateng.ebank.business.workflow.getter;

import java.util.ArrayList;
import java.util.List;

import resource.bean.pub.DataDic;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.business.workflow.bean.WorkFlowConfig;
import com.huateng.ebank.business.workflow.bean.WorkFlowParamSelectBean;
import com.huateng.ebank.business.workflow.operation.WorkFlowParamOperation;
import com.huateng.ebank.entity.data.workflow.WorkflowParam;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author chen_maik
 *
 */
public class WorkFlowParamGetter extends BaseGetter {


	public Result call() throws AppException {
		try {

			PageQueryResult pageResult = getData();

			ResultMng.fillResultByList(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageResult.getQueryResult(),
					getResult());

			result.setContent(pageResult.getQueryResult());
			if (pageResult.getQueryResult().size() == 0) {
				result.getPage().setTotalPage(0);
			} else {
				result.getPage().setTotalPage(1);
			}

			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------
	protected PageQueryResult getData() throws Exception {
		PageQueryResult pageQueryResult = new PageQueryResult();
		//add 3 lines by GuanLin 20080902
		String processTemplate =(String)getCommQueryServletRequest().getParameterMap().get("processTemplate");
		String taskName =(String)getCommQueryServletRequest().getParameterMap().get("taskName");
		String appType =(String)getCommQueryServletRequest().getParameterMap().get("apptype");

		OperationContext oc = new OperationContext();
		oc.setAttribute(WorkFlowParamOperation.CMD, "SELECT");
		//add 3 lines by GuanLin
        oc.setAttribute(WorkFlowParamOperation.IN_PARAM_PROCESSTEMPLATE,processTemplate);
	    oc.setAttribute(WorkFlowParamOperation.IN_PARAM_TASKNAME,taskName);
	    oc.setAttribute(WorkFlowParamOperation.IN_PARAM_APPTYPE,appType);

		OPCaller.call(WorkFlowParamOperation.ID, oc);
		List workFlowParamList = (List) OperationContext.getValue(oc,
				WorkFlowParamOperation.OUT_WORKFLOWPARAM_LIST);

        List workflowParam =new ArrayList();
		if (workFlowParamList != null && workFlowParamList.size() > 0) {
			for (int i = 0; i < workFlowParamList.size(); i++) {
				WorkflowParam wfw = (WorkflowParam) workFlowParamList.get(i);
				String bisClassTmp = wfw.getBizClass();
				//从配置文件获取申请类型对应的中文
				String appTypePropeties = wfw.getProcessTemplate()+"_APP_TYPE";
				List appTypeValueAT = new ArrayList();
				appTypeValueAT = DataFormat.stringToList(WorkFlowConfig.getValue(appTypePropeties));
				Object obj[]=appTypeValueAT.toArray();
				//循环比对，找出当前对象的申请类型的中文
				for (int j= 0; j< obj.length; j++) {
                        String value[]=obj[j].toString().split("-");
                        if(value[0].equals(wfw.getApptype())){
                        	wfw.setAppTypeName(obj[j].toString());
                        }
				}
				//从配置文件获取流程的中文名称
				String templateName=DataFormat.trim(WorkFlowConfig.getValue(wfw.getProcessTemplate()+"_NAME"));
            	wfw.setProcessTemplateName(templateName);
            	//从配置文件获取任务的中文名称
            	String taskNameTable=DataFormat.trim(WorkFlowConfig.getValue(wfw.getTaskName()+"_NAME"));
            	wfw.setTaskNameName(taskNameTable);
            	//从数据字典里获取机构级别的中文描述
            	List listbrclass = new ArrayList();
            	String brclass=wfw.getBrclass();
            	listbrclass =DAOUtils.getDataDicDAO().queryByCondition("po.dataTypeNo="+SystemConstant.DATADIC_TYPE_BRCLASS +" and po.dataNo="+brclass );
                  for (int j = 0; j < listbrclass.size(); j++) {
						WorkFlowParamSelectBean wfpSelectBean = new WorkFlowParamSelectBean();
						DataDic dataDic = (DataDic) listbrclass.get(j);
						wfw.setBrclassName(dataDic.getDataName());
				}
              	//从数据字典里获取操作员审批类型的中文描述
				List listbizclass = new ArrayList();
				listbizclass =DAOUtils.getDataDicDAO().queryByCondition("po.dataTypeNo="+SystemConstant.DATADIC_TYPE_LIMIT_TYPE +"and po.dataNo="+wfw.getBizClass() );
				for (int m = 0; m < listbizclass.size(); m++) {
					DataDic dataDic = (DataDic) listbizclass.get(m);
					wfw.setBizClassName(dataDic.getDataName());
				}
//del by zhaozhiguo				
//				//贷款大类的转译
//				String bisSubClassTmp = wfw.getBizSubclass();
//				if (bisClassTmp.equals("1")) {
//					List list1 = new ArrayList();
//					list1 = DAOUtils.getLntypeInfoDAO().queryByCondition(
//							" po.lntype='" + bisSubClassTmp + "' ");
//					if (list1 == null || list1.size() == 0) {
//						if(bisSubClassTmp.equals("000"))
//						wfw.setBizSubclassName("000-不限");
//					} else {
//						LntypeInfo lntypeinfo = (LntypeInfo) list1.get(0);
//						wfw.setBizSubclassName(lntypeinfo.getLntype() + "-"
//								+ lntypeinfo.getName());
//					}
//				} else {
//					if (bisClassTmp.equals("2")) {
//						String bizsubclassName = DataDicService
//								.getInstance()
//								.getNameByTypeNo(
//										SystemConstant.DATADIC_TYPE_PROJECT_TYPE,
//										wfw.getBizSubclass());
//						wfw.setBizSubclassName(bizsubclassName);
//					}
//				}
				//岗位名称转译
				String roleId = wfw.getWorkflowRole();
				if(!DataFormat.isEmpty(roleId)){
					wfw.setWorkflowRoleName(roleId+"-"+DAOUtils.getRoleInfoDAO().query(new Integer(roleId)).getRoleName());
				}else{
					wfw.setWorkflowRoleName("");
				}
				workflowParam.add(wfw);
			}

			pageQueryResult.setTotalCount(workflowParam.size());
		} else {
			pageQueryResult.setTotalCount(0);
		}
		pageQueryResult.setQueryResult(workflowParam);

		return pageQueryResult;
	}

}
