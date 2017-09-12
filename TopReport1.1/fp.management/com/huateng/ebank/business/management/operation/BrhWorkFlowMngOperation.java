/* ================================================================== *
 * The Huateng Software License
 *
 *  Copyright (c) 2004-2005 Huateng Software System.  All rights
 *  reserved.
 *  ==================================================================
 */
package com.huateng.ebank.business.management.operation;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import resource.dao.pub.BrhWorkFlowDefDAO;

import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.entity.data.workflow.BrhWorkflowDef;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * @author UU_Wu 2008-6-12
 * 机构流程设置
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BrhWorkFlowMngOperation extends BaseOperation {
	public static final String ID = "Management.BrhWorkFlowMngOperation";
    public static final String OUT_PARAM = "OUT_PARAM";
    public static final String DELETE_LIST = "DELETE_LIST";
    public static final String INSERT_LIST = "INSERT_LIST";
    public static final String UPDATE_LIST = "UPDATE_LIST";
    public static final String NONE_LIST = "NONE_LIST";
    
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BrhWorkFlowMngOperation.class);

    public void beforeProc(OperationContext context) throws CommonException {

    }
    public void execute(OperationContext context) throws CommonException {
            List deleteList = (List) context .getAttribute(BrhWorkFlowMngOperation.DELETE_LIST);
            List updateList = (List) context .getAttribute(BrhWorkFlowMngOperation.UPDATE_LIST);
            List insertList = (List) context .getAttribute(BrhWorkFlowMngOperation.INSERT_LIST);
            save(deleteList, updateList, insertList);

    }
    public void afterProc(OperationContext context) throws CommonException {

    }

    private void save(List deleteList, List updateList, List insertList) throws CommonException {
    	BrhWorkFlowDefDAO brhWorkFlowDefDAO = DAOUtils.getBrhWorkFlowDefDAO();
    	BrhWorkflowDef brhWorkflowDef;

        if (deleteList.size() > 0) {
            Iterator delit = deleteList.iterator();
            for (; delit.hasNext();) {
            	brhWorkflowDef = (BrhWorkflowDef) delit.next();
            	BrhWorkflowDef brwQuery = null;
            	if(brhWorkflowDef.getId() != 0){
            		brwQuery = brhWorkFlowDefDAO.query(brhWorkflowDef.getId());
            	}else{ //由于页面的id可能无法取到，改用联合查询
            		 brwQuery = brhWorkFlowDefDAO.queryByUk(
            				brhWorkflowDef.getBrcode(),
            				brhWorkflowDef.getApptype(), 
            				brhWorkflowDef.getBizClass());
            	}
            	
            	if(brwQuery != null){
            		brhWorkFlowDefDAO.delete(brwQuery);
            	}else{
            		logger.debug("BrhWorkFlowMngOperation 删除失败，记录不存在! id=["+brhWorkflowDef.getId()+"]"); 
            	}
            }
        }
        DAOUtils.getHQLDAO().flush();
		if (logger.isDebugEnabled()) {
			logger.debug("BrhWorkFlowMngOperation 删除完成"); 
		}

        if (updateList.size() > 0) {
            Iterator updit = updateList.iterator();
            for (; updit.hasNext();) {
            	brhWorkflowDef = (BrhWorkflowDef) updit.next();
            	//根据 机构号、申请类型、贷款种类 进行查询，如果不存在记录则新增，否则更新记录
            	BrhWorkflowDef brwQuery = brhWorkFlowDefDAO.queryByUk(
            			brhWorkflowDef.getBrcode(),brhWorkflowDef.getApptype(), brhWorkflowDef.getBizClass());
            	//处理bizSubclass 跟申请类型
            	if(brhWorkflowDef.getApptype().trim().equals(SystemConstant.APPLY_TYPE_NORMAL_LOAN ))
            		brhWorkflowDef.setBizSubclass("1");//1-一般贷款合同
            	else if(brhWorkflowDef.getApptype().trim().equals(SystemConstant.APPLY_TYPE_COMBINATION_LOAN ))
            		brhWorkflowDef.setBizSubclass("2");//2-组合贷款合同
            	else if(brhWorkflowDef.getApptype().trim().equals(SystemConstant.APPLY_TYPE_ADDITION_LOAN ))
            		brhWorkflowDef.setBizSubclass("3");//3-加按贷款合同
            	else if(brhWorkflowDef.getApptype().trim().equals(SystemConstant.APPLY_TYPE_CREDIT_APPLY ))
            		brhWorkflowDef.setBizSubclass("4");//4-授信合同
            	else
            		brhWorkflowDef.setBizSubclass("0");

                if (brwQuery == null) {
                	brhWorkFlowDefDAO.insert(brhWorkflowDef);
                }else {
                	brwQuery.setProcessTemplate(brhWorkflowDef.getProcessTemplate());
                	brhWorkFlowDefDAO.update(brwQuery);
                }
            }
        }
        DAOUtils.getHQLDAO().flush();
		if (logger.isDebugEnabled()) {
			logger.debug("BrhWorkFlowMngOperation 修改完成"); 
		}
		
        if (insertList.size() > 0) {
            Iterator insit = insertList.iterator();
            for (; insit.hasNext();) {
            	brhWorkflowDef = (BrhWorkflowDef) insit.next();
            	//根据 机构号、申请类型、贷款种类 进行查询，如果不存在记录则新增，否则更新记录
            	BrhWorkflowDef brwQuery = DAOUtils.getBrhWorkFlowDefDAO().queryByUk(
            			brhWorkflowDef.getBrcode(),brhWorkflowDef.getApptype(), brhWorkflowDef.getBizClass());
            	
                if (brwQuery == null) {
                	//处理bizSubclass 跟申请类型
                	if(brhWorkflowDef.getApptype().trim().equals(SystemConstant.APPLY_TYPE_NORMAL_LOAN ))
                		brhWorkflowDef.setBizSubclass("1");//1-一般贷款合同
                	else if(brhWorkflowDef.getApptype().trim().equals(SystemConstant.APPLY_TYPE_COMBINATION_LOAN ))
                		brhWorkflowDef.setBizSubclass("2");//2-组合贷款合同
                	else if(brhWorkflowDef.getApptype().trim().equals(SystemConstant.APPLY_TYPE_ADDITION_LOAN ))
                		brhWorkflowDef.setBizSubclass("3");//3-加按贷款合同
                	else if(brhWorkflowDef.getApptype().trim().equals(SystemConstant.APPLY_TYPE_CREDIT_APPLY ))
                		brhWorkflowDef.setBizSubclass("4");//4-授信合同
                	else
                		brhWorkflowDef.setBizSubclass("0");

                	brhWorkFlowDefDAO.insert(brhWorkflowDef);
                }
                else {
                	brwQuery.setProcessTemplate(brhWorkflowDef.getProcessTemplate());
                	brhWorkFlowDefDAO.update(brwQuery);
                }
            }
        }
        DAOUtils.getHQLDAO().flush();
		if (logger.isDebugEnabled()) {
			logger.debug("BrhWorkFlowMngOperation 新增完成"); 
		}
    }

}