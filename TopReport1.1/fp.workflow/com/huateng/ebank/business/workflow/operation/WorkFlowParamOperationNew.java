/**
 *
 */
package com.huateng.ebank.business.workflow.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import resource.bean.pub.Bctl;
import resource.dao.base.HQLDAO;
import resource.dao.pub.BctlDAO;

import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.entity.dao.workflow.WorkflowParamDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class WorkFlowParamOperationNew extends BaseOperation {

	public static final String ID = "WorkFlow.WorkFlowParamOPNew";
	public static final String IN_DEL = "IN_DEL";
	public static final String IN_INSERT = "IN_INSERT";
	public static final String IN_UPDATE = "IN_UPDATE";

	private final static Log log = LogFactory.getLog(WorkFlowParamOperationNew.class);

	public void afterProc(OperationContext context) throws CommonException {}

	public void beforeProc(OperationContext context) throws CommonException {}

	/* (non-Javadoc)
	 * @see com.huateng.ebank.framework.operation.BaseOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
	 */
	
	public void execute(OperationContext context) throws CommonException {
		WorkflowParamDAO workflowParamDao = DAOUtils.getWorkflowParamDAO();
		List delList = (List) context.getAttribute(IN_DEL);
		List insertList = (List) context.getAttribute(IN_INSERT);
		List updateList = (List) context.getAttribute(IN_UPDATE);
		HQLDAO hqldao = DAOUtils.getHQLDAO();
		for (Iterator it = delList.iterator(); it.hasNext();) {

			WorkflowParam workflowParam = (WorkflowParam) it.next();
			workflowParamDao.delete(workflowParam.getId());
			//直接删除-----------------------
		}
		hqldao.flush();
		//--插入--------------------
		for (Iterator it = insertList.iterator(); it.hasNext();) {

			WorkflowParam workflowparam = (WorkflowParam) it.next();

			WorkflowParam wfp = new WorkflowParam();

			wfp.setProcessTemplate(workflowparam.getProcessTemplate( ));
			wfp.setTaskName(workflowparam.getTaskName( ));
			wfp.setApptype(workflowparam.getApptype( ));
			wfp.setBrclass(workflowparam.getBrclass( ));
			wfp.setBizClass(workflowparam.getBizClass( ));
			if("0".equals(workflowparam.getBizSubclass( ))){
				wfp.setBizSubclass("000");
			}else
			   wfp.setBizSubclass(workflowparam.getBizSubclass( ));
			wfp.setBrcodeType(workflowparam.getBrcodeType( ));
			wfp.setBrcodeList(inBrcodeList(workflowparam.getBrcodeList( )));
			wfp.setAssignType(workflowparam.getAssignType( ));
			wfp.setAmtType(workflowparam.getAmtType( ));
			wfp.setTlrnoList(workflowparam.getTlrnoList( ));
//			wfp.setRoleType(workflowparam.getRoleType( ));
			wfp.setAssignMode(workflowparam.getAssignMode( ));
			wfp.setPass(workflowparam.getPass() );
			wfp.setMiscflgs( workflowparam.getMiscflgs());
    	    wfp.setMisc( workflowparam.getMisc());
    	    wfp.setCreateTlr( workflowparam.getCreateTlr());
    		wfp.setCreateDate(new java.util.Date());
//    	    wfp.setLastUpdDate(new java.util.Date());
    	    wfp.setLastUpdFunc( workflowparam.getLastUpdFunc());


			workflowParamDao.insert(wfp);

		}
		hqldao.flush();
		//----更新-------
		for (Iterator it = updateList.iterator(); it.hasNext();) {

			WorkflowParam workflowparam = (WorkflowParam) it.next();

			WorkflowParam wfp = null;
			try {
				wfp = workflowParamDao.queryById(workflowparam.getId());
			} catch(Exception e) {
			}

			wfp.setId(workflowparam.getId());
			wfp.setProcessTemplate(workflowparam.getProcessTemplate()) ;
			wfp.setTaskName(workflowparam.getTaskName( ));
			wfp.setApptype(workflowparam.getApptype( ));
			wfp.setBrclass(workflowparam.getBrclass( ));
			wfp.setBizClass(workflowparam.getBizClass( ));
			if("0".equals(workflowparam.getBizSubclass( ))){
				wfp.setBizSubclass("000");
			}else
			   wfp.setBizSubclass(workflowparam.getBizSubclass( ));
			wfp.setBrcodeType(workflowparam.getBrcodeType( ));
			wfp.setBrcodeList(inBrcodeList(workflowparam.getBrcodeList( )));
			wfp.setAssignType(workflowparam.getAssignType( ));
			wfp.setAmtType(workflowparam.getAmtType( ));
			wfp.setTlrnoList(workflowparam.getTlrnoList( ));
//			wfp.setRoleType(workflowparam.getRoleType( ));
			wfp.setAssignMode(workflowparam.getAssignMode( ));
			wfp.setPass(workflowparam.getPass() );
			wfp.setMiscflgs( workflowparam.getMiscflgs());
    	    wfp.setMisc( workflowparam.getMisc());
//    	    wfp.setCreateTlr( workflowparam.getCreateTlr());
//    		wfp.setCreateDate(new java.util.Date());
    	    wfp.setLastUpdDate(new java.util.Date());
    	    wfp.setLastUpdFunc( workflowparam.getLastUpdFunc());
    	    wfp.setLastUpdTlr( workflowparam.getLastUpdTlr());
			workflowParamDao.update(wfp);

		}
		hqldao.flush();


	}

	/**
	 *
	 * @param outBrcodeList
	 * @return
	 * @title 将外部机构列表转换成内部机构列表
	 * @throws CommonException
	 */
	public String inBrcodeList(String outBrcodeList)throws CommonException {
		//67608,67604,67603

		if(outBrcodeList==null||outBrcodeList.trim().length()==0)
		{
			return "";
		}
		String [] tmpBrcodeArray=outBrcodeList.split(",");
		StringBuffer tmpBrcodeList=new StringBuffer();
		for(int i=0;i<tmpBrcodeArray.length;i++){
			List bctlList=new ArrayList();
			BctlDAO bctldao = DAOUtils.getBctlDAO();
			bctlList=bctldao.queryByCondition("po.brno='"+tmpBrcodeArray[i]+"'");
			if(bctlList.size()>0){
				Bctl bctl=(Bctl)bctlList.get(0);
				if(i==0){
					tmpBrcodeList.append(bctl.getBrcode());
				}else
				{
					tmpBrcodeList.append(",").append(bctl.getBrcode());
				}
			}

		}
		return tmpBrcodeList.toString();
	}

}
