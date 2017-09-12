/**
 *
 */
package com.huateng.ebank.business.parammng.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.workflow.operation.WorkFlowParamOperation;
import com.huateng.ebank.entity.data.workflow.WorkflowParam;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author chen_maik
 *
 */
public class WorkFlowParamUpdate extends BaseUpdate {
	
	private String BROCDE_TYPE_ON = "1";//指定机构

	/* (non-Javadoc)
	 * @see com.huateng.commquery.process.call._CallUpdate#saveOrUpdate(com.huateng.commquery.result.MultiUpdateResultBean, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("parammng_WorkFlowParam");
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();
			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			String tlrnotmp=DataFormat.trim(globalInfo.getTlrno());
			String funcCodetmp=String.valueOf(globalInfo.getFuncCode());
			while (updateResultBean.hasNext()) {

				WorkflowParam workflowParam = new WorkflowParam();
				Map map = updateResultBean.next();

				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
//					ExceptionUtil.throwCommonException("作业号只能为5,10,20,25,35,40,50", ErrorCode.ERROR_CODE_BHPROC_STEP_PARAM);

	              workflowParam.setProcessTemplate( DataFormat.trim((String)map.get("processTemplate")));
	    	      workflowParam.setTaskName( DataFormat.trim((String)map.get("taskName")));
	    	      workflowParam.setApptype( DataFormat.trim((String)map.get("apptype")));
	    	      workflowParam.setBrclass( DataFormat.trim((String)map.get("brclass")));
	    	      workflowParam.setBizClass( DataFormat.trim((String)map.get("bizClass")));
	    	      workflowParam.setBizSubclass( DataFormat.trim((String)map.get("bizSubclass")));
	    	      workflowParam.setBrcodeType( DataFormat.trim((String)map.get("brcodeType")));
	    	      if(DataFormat.trim(workflowParam.getBrcodeType()).equals(BROCDE_TYPE_ON)){//指定机构
	    	    	  workflowParam.setBrcodeList( DataFormat.trim((String)map.get("brcodeList")));
	    	      }else{//不指定机构
	    	    	  workflowParam.setBrcodeList("");
	    	      }
	    	      workflowParam.setAssignType( DataFormat.trim((String)map.get("assignType")));
	    	      workflowParam.setAmtType( DataFormat.trim((String)map.get("amtType")));
	    	      workflowParam.setTlrnoList( DataFormat.trim((String)map.get("tlrnoList")));
				  workflowParam.setWorkflowRole( DataFormat.trim((String)map.get("workflowRole")));
	    	      workflowParam.setAssignMode( DataFormat.trim((String)map.get("assignMode")));
	    	      workflowParam.setPass( DataFormat.trim((String)map.get("pass")));
	    	      workflowParam.setMiscflgs( DataFormat.trim((String)map.get("miscflgs")));
	    	      workflowParam.setMisc( DataFormat.trim((String)map.get("misc")));
	    	      workflowParam.setCreateTlr( tlrnotmp);
	    		  workflowParam.setCreateDate(new java.util.Date());
//				  workflowParam.setLastUpdDate(new java.util.Date());
	    	      workflowParam.setLastUpdFunc( DataFormat.trim((String)map.get("lastUpdFunc")));
//				  workflowParam.setLastUpdTlr( tlrnotmp);

					insertList.add(workflowParam);
					break;
				case UpdateResultBean.DELETE:
					workflowParam.setId((new Long(DataFormat.trim((String)map.get("id")))).longValue());
					delList.add(workflowParam);

					break;
				case UpdateResultBean.MODIFY:
					  workflowParam.setId((new Long(DataFormat.trim((String)map.get("id")))).longValue());
			          workflowParam.setProcessTemplate( DataFormat.trim((String)map.get("processTemplate")));
		    	      workflowParam.setTaskName( DataFormat.trim((String)map.get("taskName")));
		    	      workflowParam.setApptype( DataFormat.trim((String)map.get("apptype")));
		    	      workflowParam.setBrclass( DataFormat.trim((String)map.get("brclass")));
		    	      workflowParam.setBizClass( DataFormat.trim((String)map.get("bizClass")));
		    	      workflowParam.setBizSubclass( DataFormat.trim((String)map.get("bizSubclass")));
		    	      workflowParam.setBrcodeType( DataFormat.trim((String)map.get("brcodeType")));
		    	      if(DataFormat.trim(workflowParam.getBrcodeType()).equals(BROCDE_TYPE_ON)){//指定机构
		    	    	  workflowParam.setBrcodeList( DataFormat.trim((String)map.get("brcodeList")));
		    	      }else{//不指定机构
		    	    	  workflowParam.setBrcodeList("");
		    	      }
		    	      workflowParam.setAssignType( DataFormat.trim((String)map.get("assignType")));
		    	      workflowParam.setAmtType( DataFormat.trim((String)map.get("amtType")));
		    	      workflowParam.setTlrnoList( DataFormat.trim((String)map.get("tlrnoList")));
		    	      workflowParam.setWorkflowRole( DataFormat.trim((String)map.get("workflowRole")));
		    	      workflowParam.setAssignMode( DataFormat.trim((String)map.get("assignMode")));
		    	      workflowParam.setPass( DataFormat.trim((String)map.get("pass")));
		    	      workflowParam.setMiscflgs( DataFormat.trim((String)map.get("miscflgs")));
		    	      workflowParam.setMisc( DataFormat.trim((String)map.get("misc")));
//		    	      workflowParam.setCreateTlr( tlrnotmp);
//		    		  workflowParam.setCreateDate(new java.util.Date());
		    	      workflowParam.setLastUpdDate(new java.util.Date());
		    	      workflowParam.setLastUpdFunc( funcCodetmp);
		    	      workflowParam.setLastUpdTlr( tlrnotmp);

//use test
//						Map newMap=new HashMap();
//						newMap.put("APPTYPE","01");
//						newMap.put("PROC_NAME","LoanApplyAAA");
//						newMap.put("TASK_NAME","SubBranchAudit");
//						newMap.put("BRCLASS","5");
//						newMap.put("STARTBRCODE","0012");
//						newMap.put("BIZCLASS","1");
//						newMap.put("BIZSUBCLASS","008");
//						newMap.put("AMOUNT",200000.00);
//						newMap.put("TLR_NO", "67999002");
//						String tlrnoList=(String)WorkFlowParamService.getInstance().getTlrnoRoleTaskOperate(newMap).get("TLRNO_LIST");

					updateList.add(workflowParam);
					break;
				default:
					break;
				}
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(WorkFlowParamOperation.CMD, "UPDATE");
			oc.setAttribute(WorkFlowParamOperation.DELETE_LIST, delList);
			oc.setAttribute(WorkFlowParamOperation.INSERT_LIST, insertList);
			oc.setAttribute(WorkFlowParamOperation.UPDATE_LIST, updateList);
			OPCaller.call(WorkFlowParamOperation.ID, oc);
			return updateReturnBean;

		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}


}
