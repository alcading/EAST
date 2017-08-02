/**
 *
 */
package com.huateng.ebank.business.workflow.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import resource.bean.pub.Bctl;
import resource.dao.base.HQLDAO;
import resource.dao.pub.BctlDAO;

import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.entity.dao.workflow.WorkflowParamDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * @author chen_maik by 2008-08-08
 *
 */
public class WorkFlowParamOperation extends BaseOperation {
	
	 public static final String ID = "WorkFlow.WorkFlowParamOP";
	 public static final String CMD = "CMD";
	 public static final String OUT_WORKFLOWPARAM_LIST = "OUT_WORKFLOWPARAM_LIST";
	 //add by GuanLin
	 public static final String IN_PARAM_PROCESSTEMPLATE = "IN_PARAM_PROCESSTEMPLATE";
	 public static final String IN_PARAM_TASKNAME = "IN_PARAM_TASKNAME";
	 public static final String IN_PARAM_APPTYPE = "IN_PARAM_APPTYPE";
	 public static final String DELETE_LIST = "DELETE_LIST";
	 public static final String UPDATE_LIST = "UPDATE_LIST";
	 public static final String INSERT_LIST = "INSERT_LIST";
	 public static final String NONE_LIST = "NONE_LIST";

	private static final Logger logger = Logger.getLogger(WorkFlowParamOperation.class);
	 
	public void afterProc(OperationContext context) throws CommonException {}
	
	public void beforeProc(OperationContext context) throws CommonException {}

	public void execute(OperationContext context) throws CommonException {
		WorkflowParamDAO workFlowParamDAO = DAOUtils.getWorkflowParamDAO();
		String cmd = (String) context.getAttribute(WorkFlowParamOperation.CMD);
		if (logger.isDebugEnabled()) {
			logger.debug("WorkFlowParamOperation.CMD = "+CMD); 
		}
		//查询工作流参数配置表信息－－WORKFLOW_PARAM
		 if (cmd.equals("SELECT")) {

	            List resultList = new ArrayList();
	            List typeList = new ArrayList();
	            List objList = new ArrayList();
	            String processTemplate = (String) context.getAttribute(WorkFlowParamOperation.IN_PARAM_PROCESSTEMPLATE);
	            String taskName = (String) context.getAttribute(WorkFlowParamOperation.IN_PARAM_TASKNAME);
	            String appType = (String) context.getAttribute(WorkFlowParamOperation.IN_PARAM_APPTYPE);

	            StringBuffer hqlstr = new StringBuffer(512);
	            hqlstr.append(" 1=1 ");

	            if (!DataFormat.isEmpty(processTemplate)) {
	                hqlstr.append(" and po.processTemplate = '").append(processTemplate.trim()).append("' ");
	            }
	            if (!DataFormat.isEmpty(taskName)) {
	                hqlstr.append(" and po.taskName = '").append(taskName.trim()).append("' ");
	            }
	            if (!DataFormat.isEmpty(appType)) {
	                hqlstr.append(" and po.apptype = '").append(appType.trim()).append("' ");
	            }
//	            hqlstr.append(" and po.bizSubclass<>'000' order by po.processTemplate, po.taskName, po.appType ");

	            hqlstr.append("  order by po.processTemplate, po.taskName, po.apptype ");

	            List list = DAOUtils.getWorkflowParamDAO().queryByCondition(hqlstr.toString());

	            context.setAttribute(WorkFlowParamOperation.OUT_WORKFLOWPARAM_LIST, list);
	            
	        }else if(cmd.equals("UPDATE")){//工作流参数配置表的增删改查

	    		WorkflowParamDAO workflowParamDao = DAOUtils.getWorkflowParamDAO();
	    		List delList = (List) context.getAttribute(DELETE_LIST);
	    		List insertList = (List) context.getAttribute(INSERT_LIST);
	    		List updateList = (List) context.getAttribute(UPDATE_LIST);
	    		HQLDAO hqldao = DAOUtils.getHQLDAO();
	    		for (Iterator it = delList.iterator(); it.hasNext();) {
	    			//直接删除-----------------------
	    			WorkflowParam workflowParam = (WorkflowParam) it.next();
	    			workflowParamDao.delete(workflowParam.getId());
	    		}
	    		hqldao.flush();
	    		if (logger.isDebugEnabled()) {
	    			logger.debug("WorkFlowParamOperation delete OK"); 
	    		}
	    		//--插入--------------------
	    		for (Iterator it = insertList.iterator(); it.hasNext();) {
	    			WorkflowParam workflowparam = (WorkflowParam) it.next();
	    			WorkflowParam wfp = new WorkflowParam();

	    			wfp.setProcessTemplate(workflowparam.getProcessTemplate());
	    			wfp.setTaskName(workflowparam.getTaskName());
	    			wfp.setApptype(workflowparam.getApptype());
	    			wfp.setBrclass(workflowparam.getBrclass());
	    			wfp.setBizClass(workflowparam.getBizClass());
	    			if("0".equals(workflowparam.getBizSubclass())){
	    				wfp.setBizSubclass("000");
	    			}else{
	    				wfp.setBizSubclass(workflowparam.getBizSubclass());
	    			}
	    			wfp.setBrcodeType(workflowparam.getBrcodeType());
	    			wfp.setBrcodeList(inBrcodeList(workflowparam.getBrcodeList()));
	    			wfp.setAssignType(workflowparam.getAssignType());
	    			wfp.setAmtType(workflowparam.getAmtType());
	    			wfp.setTlrnoList(workflowparam.getTlrnoList());
	    			wfp.setWorkflowRole(workflowparam.getWorkflowRole());
	    			wfp.setAssignMode(workflowparam.getAssignMode( ));
	    			wfp.setPass(workflowparam.getPass() );
	    			wfp.setMiscflgs( workflowparam.getMiscflgs());
	        	    wfp.setMisc( workflowparam.getMisc());
	        	    wfp.setCreateTlr( workflowparam.getCreateTlr());
	        		wfp.setCreateDate(new java.util.Date());
	        	    wfp.setLastUpdFunc( workflowparam.getLastUpdFunc());

	    			workflowParamDao.insert(wfp);

	    		}
	    		hqldao.flush();
	    		if (logger.isDebugEnabled()) {
	    			logger.debug("WorkFlowParamOperation add OK"); 
	    		}
	    		//----更新-------
	    		for (Iterator it = updateList.iterator(); it.hasNext();) {
	    			WorkflowParam workflowparam = (WorkflowParam) it.next();
	    			WorkflowParam wfp = null;
	    			try {
	    				wfp = workflowParamDao.queryById(workflowparam.getId());
	    			} catch(Exception e) {
	    	    		if (logger.isDebugEnabled()) {
	    	    			logger.debug("WorkFlowParamOperation update failde,id="+workflowparam.getId()+"]"); 
	    	    		}
	    	    		continue;
	    			}

	    			wfp.setId(workflowparam.getId());
	    			wfp.setProcessTemplate(workflowparam.getProcessTemplate()) ;
	    			wfp.setTaskName(workflowparam.getTaskName());
	    			wfp.setApptype(workflowparam.getApptype());
	    			wfp.setBrclass(workflowparam.getBrclass());
	    			wfp.setBizClass(workflowparam.getBizClass( ));
	    			if("0".equals(workflowparam.getBizSubclass( ))){
	    				wfp.setBizSubclass("000");
	    			}else
	    			   wfp.setBizSubclass(workflowparam.getBizSubclass());
	    			wfp.setBrcodeType(workflowparam.getBrcodeType());
//	    			wfp.setBrcodeList(inBrcodeList(workflowparam.getBrcodeList()));
	    			wfp.setBrcodeList(workflowparam.getBrcodeList());
	    			wfp.setAssignType(workflowparam.getAssignType());
	    			wfp.setAmtType(workflowparam.getAmtType());
	    			wfp.setTlrnoList(workflowparam.getTlrnoList());
	    			wfp.setWorkflowRole(workflowparam.getWorkflowRole());
	    			wfp.setAssignMode(workflowparam.getAssignMode());
	    			wfp.setPass(workflowparam.getPass());
	    			wfp.setMiscflgs( workflowparam.getMiscflgs());
	        	    wfp.setMisc( workflowparam.getMisc());
	        	    wfp.setLastUpdDate(new java.util.Date());
	        	    wfp.setLastUpdFunc(workflowparam.getLastUpdFunc());
	        	    wfp.setLastUpdTlr(workflowparam.getLastUpdTlr());
	    			workflowParamDao.update(wfp);

	    		}
	    		hqldao.flush();
	    		if (logger.isDebugEnabled()) {
	    			logger.debug("WorkFlowParamOperation update OK"); 
	    		}
	        }
	}
	
	/**
	 *
	 * @param outBrcodeList
	 * @return
	 * @title 将外部机构列表转换成内部机构列表
	 * @throws CommonException
	 */
	public String inBrcodeList(String outBrcodeList) throws CommonException {

		if (outBrcodeList == null || outBrcodeList.trim().length() == 0) {
			return "";
		}
		String[] tmpBrcodeArray = outBrcodeList.split(",");
		StringBuffer tmpBrcodeList = new StringBuffer();
		for (int i = 0; i < tmpBrcodeArray.length; i++) {
			List bctlList = new ArrayList();
			BctlDAO bctldao = DAOUtils.getBctlDAO();
			bctlList = bctldao.queryByCondition("po.brno='" + tmpBrcodeArray[i]+ "'");
			if (bctlList.size() > 0) {
				Bctl bctl = (Bctl) bctlList.get(0);
				if (i == 0) {
					tmpBrcodeList.append(bctl.getBrcode());
				} else {
					tmpBrcodeList.append(",").append(bctl.getBrcode());
				}
			}

		}
		return tmpBrcodeList.toString();
	}

}
