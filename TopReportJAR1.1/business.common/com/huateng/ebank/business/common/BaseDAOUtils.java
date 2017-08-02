/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common;

import resource.dao.base.HQLDAO;
import resource.dao.pub.BctlDAO;
import resource.dao.pub.BhProcStepDAO;
import resource.dao.pub.BranchFuncRelDAO;
import resource.dao.pub.BrhWorkFlowDefDAO;
import resource.dao.pub.DataDicDAO;
import resource.dao.pub.DepartmentInfoDAO;
import resource.dao.pub.FunctionInfoDAO;
import resource.dao.pub.GlobalinfoDAO;
import resource.dao.pub.RoleFuncRelDAO;
import resource.dao.pub.RoleInfoDAO;
import resource.dao.pub.TlrInfoDAO;
import resource.dao.pub.TlrRoleRelDAO;
import resource.dao.pub.TlrWorkloadDAO;

import com.huateng.ebank.entity.dao.flowManagement.ApplydtlDAO;
import com.huateng.ebank.entity.dao.mng.BizFuncInfoDAO;
import com.huateng.ebank.entity.dao.mng.BizLogDAO;
import com.huateng.ebank.entity.dao.mng.CommLogDAO;
import com.huateng.ebank.entity.dao.mng.CurrencyDAO;
import com.huateng.ebank.entity.dao.mng.HolidayDAO;
import com.huateng.ebank.entity.dao.mng.PfSysParamDAO;
import com.huateng.ebank.entity.dao.mng.RelationCodeDAO;
import com.huateng.ebank.entity.dao.mng.ReportInfoDAO;
import com.huateng.ebank.entity.dao.mng.RoleReportParamDAO;
import com.huateng.ebank.entity.dao.mng.SeqctlDAO;
import com.huateng.ebank.entity.dao.workflow.LimitParamDAO;
import com.huateng.ebank.entity.dao.workflow.WorkFlowDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowAppInfoDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowAttitudeDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowBussTempletRelDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowInsRouteDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowParamDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowRouteBindingDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowRouteDefDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowRouteParamDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowTaskInfoDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowTaskPoolDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;


/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen </a>
 * @version $Revision: 1.23 $
 *
 * 用来获得DAO实例的工具类. 主要是避免DAO的名称在各处的使用而导致以后修改出现困难.
 */
public class BaseDAOUtils {

	final public static HQLDAO getHQLDAO() {
		return (HQLDAO) ApplicationContextUtils.getBean("HQLDAO");
	}

	final public static ApplydtlDAO getApplydtlDAO(){
		return (ApplydtlDAO) ApplicationContextUtils.getBean("ApplydtlDAO");
	}

	final public static DepartmentInfoDAO DepartmentInfoDAO() {
		return (DepartmentInfoDAO) ApplicationContextUtils.getBean("DepartmentInfoDAO");
	}

	final public static BctlDAO getBctlDAO() {
		return (BctlDAO) ApplicationContextUtils.getBean("BctlDAO");
	}

	final public static BizLogDAO getBizLogDAO(){
		return (BizLogDAO) ApplicationContextUtils.getBean("BizLogDAO");
	}

	final public static BranchFuncRelDAO getBranchFuncRelDAO() {
		return (BranchFuncRelDAO) ApplicationContextUtils.getBean("BranchFuncRelDAO");
	}

	final public static CommLogDAO getCommLogDAO() {
		return (CommLogDAO) ApplicationContextUtils.getBean("CommLogDAO");
	}


	final public static CurrencyDAO getCurrencyDAO() {
		return (CurrencyDAO) ApplicationContextUtils.getBean("CurrencyDAO");
	}


	final public static DataDicDAO getDataDicDAO() {
		return (DataDicDAO) ApplicationContextUtils.getBean("DataDicDAO");
	}
	final public static FunctionInfoDAO getFunctionInfoDAO() {
		return (FunctionInfoDAO) ApplicationContextUtils.getBean("FunctionInfoDAO");
	}

	final public static GlobalinfoDAO getGlobalinfoDAO() {
		return (GlobalinfoDAO) ApplicationContextUtils.getBean("GlobalinfoDAO");
	}

	final public static HolidayDAO getHolidayDAO() {
		return (HolidayDAO) ApplicationContextUtils.getBean("HolidayDAO");
	}


	final public static LimitParamDAO getLimitParamDAO() {
		return (LimitParamDAO) ApplicationContextUtils.getBean("LimitParamDAO");
	}

	final public static PfSysParamDAO getPfSysParamDAO() {
		return (PfSysParamDAO) ApplicationContextUtils.getBean("PfSysParamDAO");
	}


	final public static RelationCodeDAO getRelationCodeDAO(){
		return (RelationCodeDAO) ApplicationContextUtils.getBean("RelationCodeDAO");
	}

	final public static ReportInfoDAO getReportInfoDAO(){
		return (ReportInfoDAO) ApplicationContextUtils.getBean("ReportInfoDAO");
	}

	final public static RoleFuncRelDAO getRoleFuncRelDAO() {
		return (RoleFuncRelDAO) ApplicationContextUtils.getBean("RoleFuncRelDAO");
	}

	final public static RoleInfoDAO getRoleInfoDAO() {
		return (RoleInfoDAO) ApplicationContextUtils.getBean("RoleInfoDAO");
	}

	final public static RoleReportParamDAO getRoleReportParamDAO() {
		return (RoleReportParamDAO) ApplicationContextUtils.getBean("RoleReportParamDAO");
	}

	final public static SeqctlDAO getSeqctlDAO() {
		return (SeqctlDAO) ApplicationContextUtils.getBean("SeqctlDAO");
	}

	final public static TlrInfoDAO getTlrInfoDAO() {
		return (TlrInfoDAO) ApplicationContextUtils.getBean("TlrInfoDAO");
	}

	final public static DepartmentInfoDAO getDepartmentInfoDAO() {
		return (DepartmentInfoDAO) ApplicationContextUtils.getBean("DepartmentInfoDAO");
	}

	/** 批量处理相关表的DAO  */
	final public static BhProcStepDAO getBatchProcessStepDAO(){
		return (BhProcStepDAO)ApplicationContextUtils.getBean("BhProcStepDAO");
	}
	final public static TlrRoleRelDAO getTlrRoleRelDAO() {
		return (TlrRoleRelDAO) ApplicationContextUtils.getBean("TlrRoleRelDAO");
	}
	final public static WorkflowAppInfoDAO getWorkflowAppInfoDAO(){
		return (WorkflowAppInfoDAO) ApplicationContextUtils.getBean("WorkflowAppInfoDAO");
	}
	final public static WorkflowParamDAO getWorkflowParamDAO(){
		return (WorkflowParamDAO) ApplicationContextUtils.getBean("WorkflowParamDAO");
	}
	final public static WorkflowTaskInfoDAO getWorkflowTaskInfoDAO(){
		return (WorkflowTaskInfoDAO) ApplicationContextUtils.getBean("WorkflowTaskInfoDAO");
	}
	final public static WorkFlowDAO getWorkFlowDAO(){
		return (WorkFlowDAO) ApplicationContextUtils.getBean("WorkFlowDAO");
	}
	final public static WorkflowAttitudeDAO getWorkflowAttitudeDAO(){
		return (WorkflowAttitudeDAO) ApplicationContextUtils.getBean("WorkflowAttitudeDAO");
	}
	final public static BrhWorkFlowDefDAO getBrhWorkFlowDefDAO() {
		return (BrhWorkFlowDefDAO) ApplicationContextUtils.getBean("BrhWorkFlowDefDAO");
	}
    public static BizFuncInfoDAO getBizFuncInfoDAO() {
		return (BizFuncInfoDAO) ApplicationContextUtils.getBean("BizFuncInfoDAO");
	}

	public static WorkflowRouteBindingDAO getWorkflowRouteBindingDAO() {
		return (WorkflowRouteBindingDAO) ApplicationContextUtils
				.getBean("WorkflowRouteBindingDAO");
	}

	public static WorkflowRouteDefDAO getWorkflowRouteDefDAO() {
		return (WorkflowRouteDefDAO) ApplicationContextUtils
				.getBean("WorkflowRouteDefDAO");
	}

	public static WorkflowRouteParamDAO getWorkflowRouteParamDAO() {
		return (WorkflowRouteParamDAO) ApplicationContextUtils
				.getBean("WorkflowRouteParamDAO");
	}

	public static WorkflowInsRouteDAO getWorkflowInsRouteDAO() {
		return (WorkflowInsRouteDAO) ApplicationContextUtils
				.getBean("WorkflowInsRouteDAO");
	}
	/* add by kangbyron 2011-2-22 操作员审批阀值设置 begin */
	public static TlrWorkloadDAO getTlrWorkloadDAO() {
		return (TlrWorkloadDAO) ApplicationContextUtils
				.getBean("TlrWorkloadDAO");
	}
	/* add by kangbyron 2011-2-22 操作员审批阀值设置 end */
	/* add by kangbyron 2011-2-25 工作流任务池 begin */
	public static WorkflowTaskPoolDAO getWorkflowTaskPoolDAO() {
		return (WorkflowTaskPoolDAO) ApplicationContextUtils
				.getBean("WorkflowTaskPoolDAO");
	}
	/* add by kangbyron 2011-2-25 工作流任务池 end */
	
	public static WorkflowBussTempletRelDAO getWorkflowBussTempletRelDAO(){
		return (WorkflowBussTempletRelDAO) ApplicationContextUtils.getBean("WorkflowBussTempletRelDAO");
	}
}

