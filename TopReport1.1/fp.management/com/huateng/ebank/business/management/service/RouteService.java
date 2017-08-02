package com.huateng.ebank.business.management.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import resource.bean.pub.Bctl;
import resource.dao.base.HQLDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.DataDicUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.bean.RouteBindingView;
import com.huateng.ebank.entity.dao.workflow.WorkflowRouteBindingDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowRouteDefDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowRouteParamDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteBinding;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteDef;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class RouteService {
	private static final Logger logger = Logger.getLogger(RouteService.class);

	/**
	 * Default constructor
	 */
	protected RouteService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static RouteService getInstance() {
		return (RouteService)ApplicationContextUtils.getBean(RouteService.class.getName());
	}
	/**
	 * 查询符合条件的审批路线模板定义
	 *
	 * @param workflowRouteDef
	 * @param pageSize
	 * @param pageIndex
	 * @return pageQueryResult
	 */
	public PageQueryResult queryRouteDef(WorkflowRouteDef infwrd,int pageSize, int pageIndex)throws CommonException{
		StringBuffer sb = new StringBuffer();
		sb.append("select wrd from WorkflowRouteDef wrd ")
			.append(" where wrd.status = '" + SystemConstant.VALID_FLAG_VALID + "'");
		//机构级别
		if(!DataFormat.isEmpty(infwrd.getBrhClass())){
			sb.append(" and wrd.brhClass = '"+ infwrd.getBrhClass()+"'");
		}
		HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);
		Iterator iter = pageQueryResult.getQueryResult().iterator();
		List resultList = new ArrayList();
		WorkflowRouteDef outfwrd = null;
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();
			outfwrd =  new WorkflowRouteDef();
			outfwrd = (WorkflowRouteDef) obj[0];
//			outfwrd.setId((Integer) obj[0]);
//			outfwrd.setBrhClass((String) obj[1]);
//			outfwrd.setIsBand((String) obj[2]);
//			outfwrd.setIsSet((String) obj[3]);
//			outfwrd.setStatus((String) obj[4]);
			resultList.add(outfwrd);
		}
		pageQueryResult.setQueryResult(resultList);
		return pageQueryResult;
	}


	/**
	 * 查询适用机构的可绑定审批路线
	 *
	 * @param workflowRouteDef
	 * @param pageSize
	 * @param pageIndex
	 * @return pageQueryResult
	 */
	public PageQueryResult queryRouteBindingRouteInfo( WorkflowRouteBinding WorkflowRouteBinding,int pageSize, int pageIndex)throws CommonException{
		List routedeflist = BaseDAOUtils.getWorkflowRouteDefDAO().queryByCondition(" po.brhClass =? and po.status = ? and po.isSet = ? " ,
				new Object[] {WorkflowRouteBinding.getBrhClass(),SystemConstant.VALID_FLAG_VALID,SystemConstant.FLAG_ON},
				new Type[] {Hibernate.STRING,Hibernate.STRING,Hibernate.STRING} );

        List resultlist = new ArrayList();
        RouteBindingView outrouteBindingView = null;
        //去除限制，暂时注释
//        for(int i =0;i<routedeflist.size();i++){
//        	outrouteBindingView = new RouteBindingView();
//        	WorkflowRouteDef workflowRouteDef = (WorkflowRouteDef) routedeflist.get(i);
//        	List routeparamlist = BaseDAOUtils.getWorkflowRouteParamDAO().queryByCondition(" po.routeId = " + workflowRouteDef.getId() );
//        	for(int j =0;j<routeparamlist.size();j++){
//        		WorkflowRouteParam workflowRouteParam = (WorkflowRouteParam) routeparamlist.get(j);
//        		if(workflowRouteParam.getApproveAmt().compareTo(WorkflowRouteBinding.getMaxAmt())>=0){
//        			outrouteBindingView.setRouteId(workflowRouteDef.getId());
//                	outrouteBindingView.setRouteName(workflowRouteDef.getRouteName());
//                	//把之前已经绑定的路线id打钩显示
//                	if(WorkflowRouteBinding.getRouteId().compareTo(workflowRouteDef.getId())==0){
//                		outrouteBindingView.setSelected(true);
//                	}
//                	else{
//                		outrouteBindingView.setSelected(false);
//                	}
//                	resultlist.add(outrouteBindingView);
//                	break;
//        		}
//        		else{
//        			continue;
//        		}
//        	}
//
//        }
        /**modify by chaochao.yang bms-2543 begin*/
        /**获得发起行的机构级别*/
        int startBrhid = Integer.valueOf(WorkflowRouteBinding.getStartBrhid());
    	/**发起行的机构级别fBrhClass*/
    	String fBrhClass = null;
    	if(startBrhid < 0){
    		fBrhClass = Integer.toString(-1*startBrhid);
    	}
    	else if(startBrhid > 0) {
			fBrhClass = BaseDAOUtils.getBctlDAO().queryById(String.valueOf(startBrhid)).getBrclass();
		}
        /**modify by chaochao.yang bms-2543 end*/
        for(int i =0;i<routedeflist.size();i++){
        	outrouteBindingView = new RouteBindingView();
        	WorkflowRouteDef workflowRouteDef = (WorkflowRouteDef) routedeflist.get(i);
        	/**modify by chaochao.yang bms-2543 begin*/
        	/**审批路线是否显示的标志*/
        	boolean flag = false;
        	boolean flags = false;
        	int routeId = workflowRouteDef.getId();
        	List wrpList = BaseDAOUtils.getWorkflowRouteParamDAO().queryByCondition(" po.routeId = '" + routeId + "'");
        	for(int j = 0; j < wrpList.size(); j++){
        		WorkflowRouteParam wrp = (WorkflowRouteParam)wrpList.get(j);
        		/**审批路线适合的机构级别*/
        		String brhClass = wrp.getBrhClass();
        		/**对审批路线适合的机构级别brhClass进行判断，如果fBrhClass大于brhClass,则不显示此审批路线*/
        		if(brhClass.compareTo(fBrhClass)>0){
        			flag = true;
        			break;
        		}
        		/*if(brhClass.compareTo(fBrhClass)==0){
        			flags = true;
        		}*/

        	}
        	if(flag == true){
        		continue;
        	}
        	/*if(flags == false){
        		continue;
        	}*/
        	/**modify by chaochao.yang bms-2543 end*/
        	outrouteBindingView.setRouteId(workflowRouteDef.getId());
        	outrouteBindingView.setRouteName(workflowRouteDef.getRouteName());
        	//把之前已经绑定的路线id打钩显示
        	/** modify by shen_antonio 20091214 jira:BMS-2334 begin .*/
        	if(WorkflowRouteBinding.getRouteId().compareTo(workflowRouteDef.getId())==0){
        		outrouteBindingView.setSelect(true);
        	}
        	else{
        		outrouteBindingView.setSelect(false);
        	}
        	/** modify by shen_antonio 20091214 jira:BMS-2334 begin .*/
        	resultlist.add(outrouteBindingView);
        }
        PageQueryResult pageQueryResult = new PageQueryResult();
        pageQueryResult.setTotalCount(resultlist.size());
		pageQueryResult.setQueryResult(resultlist);
		return pageQueryResult;
	}

	/**
	 * 保存审批路线模板
	 *
	 * @param delList
	 * @param insertList
	 * @param updateList
	 *
	 */
	public void saveRouteDef(List delList,List insertList,List updateList) throws CommonException{
		WorkflowRouteDefDAO  workflowRouteDefDAO = BaseDAOUtils.getWorkflowRouteDefDAO();

		//新增
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			WorkflowRouteDef newwrd = (WorkflowRouteDef) it.next();
//			newwrd.setId(null);
			newwrd.setIsBand(SystemConstant.FLAG_OFF);
			newwrd.setIsSet(SystemConstant.FLAG_OFF);
			newwrd.setStatus(SystemConstant.FLAG_ON);
			workflowRouteDefDAO.insert(newwrd);

		}
		//修改
		for(Iterator it = updateList.iterator();it.hasNext();)
		{
			WorkflowRouteDef modifywrd = (WorkflowRouteDef) it.next();
			workflowRouteDefDAO.update(modifywrd);
		}
		//删除
		for(Iterator it = delList.iterator();it.hasNext();)
		{
			WorkflowRouteDef delwrd = (WorkflowRouteDef) it.next();
			if(delwrd.getIsBand().equals(SystemConstant.FLAG_ON)){
				ExceptionUtil.throwCommonException("审批路线模板"+ delwrd.getId() + " (" + delwrd.getRouteName() + ") 已被绑定，不能删除"
						, ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_DEF_UPDATE);
			}
			delwrd.setStatus(SystemConstant.FLAG_OFF);
			workflowRouteDefDAO.update(delwrd);
		}
	}


	/**
	 * 查询符合条件的审批路线参数
	 *
	 * @param workflowRouteDef
	 * @param pageSize
	 * @param pageIndex
	 * @return pageQueryResult
	 */
	public PageQueryResult queryRouteParam(WorkflowRouteParam infwrd,int pageSize, int pageIndex)throws CommonException{
		StringBuffer sb = new StringBuffer();
		sb.append("select wrp.stopId, wrp.routeId, wrp.brhClass, wrp.roleId, wrp.need, wrp.pass, wrp.amtType, wrp.approveAmt,wrp.id " +
				"from WorkflowRouteParam wrp ")
			.append(" where wrp.routeId = " + infwrd.getRouteId())
			.append(" order by wrp.stopId ");
		//机构级别
//		if(!DataFormat.isEmpty(infwrd.getBrhClass())){
//			sb.append(" and wrp.brhClass = '"+ infwrd.getBrhClass()+"'");
//		}
		HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);
		Iterator iter = pageQueryResult.getQueryResult().iterator();
		List resultList = new ArrayList();
		WorkflowRouteParam outfwrp = null;
//		if(!pageQueryResult.getQueryResult().isEmpty()){
			while (iter.hasNext()) {
				Object[] obj = (Object[]) iter.next();
				outfwrp =  new WorkflowRouteParam();
//				outfwrp.setId((Integer) obj[0]);
				outfwrp.setStopId((Integer) obj[0]);
				outfwrp.setRouteId((Integer) obj[1]);
				outfwrp.setBrhClass((String) obj[2]);
				outfwrp.setRoleId((Integer) obj[3]);
				outfwrp.setNeed((String) obj[4]);
				outfwrp.setPass((String) obj[5]);
				outfwrp.setAmtType((String) obj[6]);
				outfwrp.setApproveAmt(new BigDecimal(obj[7].toString()));
				outfwrp.setId((Integer) obj[8]);
				resultList.add(outfwrp);
			}

//		}
//		else{
//			outfwrp =  new WorkflowRouteParam();
//			outfwrp.setRouteId(infwrd.getRouteId());
//			resultList.add(outfwrp);
//		}

		//pageQueryResult.setTotalCount();
		pageQueryResult.setQueryResult(resultList);
		return pageQueryResult;
	}

	/**
	 * 保存审批路线参数
	 *
	 * @param delList
	 * @param insertList
	 * @param updateList
	 *
	 */
	public void saveRouteParam(List delList,List insertList,List updateList) throws CommonException{
		WorkflowRouteParamDAO  workflowRouteParamDAO = BaseDAOUtils.getWorkflowRouteParamDAO();
		WorkflowRouteDefDAO  workflowRouteDefDAO = BaseDAOUtils.getWorkflowRouteDefDAO();

		//新增
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			WorkflowRouteParam newwrp = (WorkflowRouteParam) it.next();;

			workflowRouteParamDAO.insert(newwrp);

			//更新审批路线定义,isSet已设置
			WorkflowRouteDef workflowRouteDef  = workflowRouteDefDAO.query(newwrp.getRouteId());
			String brclass = workflowRouteDef.getBrhClass();
			if(Integer.parseInt(newwrp.getBrhClass())<Integer.parseInt(brclass)){
				ExceptionUtil.throwCommonException("明细的机构级别不能高于审批路线模板的机构级别");
			}
			if(workflowRouteDef.getIsSet().equals(SystemConstant.FLAG_OFF)){
				workflowRouteDef.setIsSet(SystemConstant.FLAG_ON);
				workflowRouteDefDAO.update(workflowRouteDef);

			}

		}
		//修改
		for(Iterator it = updateList.iterator();it.hasNext();)
		{
			WorkflowRouteParam modifywrt = (WorkflowRouteParam) it.next();
			WorkflowRouteDef workflowRouteDef  = workflowRouteDefDAO.query(modifywrt.getRouteId());
			String brclass = workflowRouteDef.getBrhClass();
			if(Integer.parseInt(modifywrt.getBrhClass())<Integer.parseInt(brclass)){
				ExceptionUtil.throwCommonException("明细的机构级别不能高于审批路线模板的机构级别");
			}

//			if(modifywrt.getId()==null){
//				workflowRouteParamDAO.insert(modifywrt);
//			}
//			else{
				workflowRouteParamDAO.update(modifywrt);
//			}

		}
		//删除
		for(Iterator it = delList.iterator();it.hasNext();)
		{
			WorkflowRouteParam delwrd = (WorkflowRouteParam) it.next();
//			delwrd.setStatus(SystemConstant.FLAG_OFF);
			workflowRouteParamDAO.delete(delwrd);
		}
	}

	/**
	 * 查询符合条件的审批路线参数
	 *
	 * @param workflowRouteDef
	 * @param pageSize
	 * @param pageIndex
	 * @return pageQueryResult
	 */
	public PageQueryResult queryRouteBindingBussInfo(RouteBindingView inview,int pageSize, int pageIndex)throws CommonException{
		StringBuffer sb1 = new StringBuffer();
		sb1.append("select bind.bussType, bind.draftType, bind.maxAmt, bind.startBrhno, bind.brhClass, bind.routeId, bind.id, bind.startBrhid " +
					" from WorkflowRouteBinding bind ")
		 		.append(" where 1=1" );

		//业务种类
		if(!DataFormat.isEmpty(inview.getBussType())){
			/**mod by abudula at 20101118 start  STL-62 */
			sb1.append(" and substr(bind.bussType,0,4) = '"+ inview.getBussType()+"'");
			/**mod by abudula at 20101118 end  STL-62 s*/
		}
		//路线绑定id
		if(inview.getId()!=null&&inview.getId()!=0){
			sb1.append(" and bind.id = "+ inview.getId());
		}
		/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
		/**mod by abudula 20101121 start */
		/**mod by abudula 20101121 end */
		if(inview.getStartBrhid()!=null){
			sb1.append(" and abs(bind.startBrhid) = " + inview.getStartBrhid());
		}
		/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
		HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb1.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);
		Iterator iter = pageQueryResult.getQueryResult().iterator();
		List resultList = new ArrayList();
		RouteBindingView outview = null;
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();
			outview =  new RouteBindingView();
//			outfwrp.setId((Integer) obj[0]);
			String bussType = (String) obj[0];
			outview.setBussType(bussType.substring(0,4));
			outview.setBizType(bussType.substring(4));
			outview.setDraftType((String) obj[1]);
			outview.setMaxAmt(new BigDecimal(obj[2].toString()));
			outview.setStartBrhno((String) obj[3]);
			outview.setBrhClass((String) obj[4]);
			Integer routeId = (Integer) obj[5];
			//如果绑定表中路线号为空或者0，则该路线肯定未绑定
			if(routeId==null||routeId==0){
				outview.setIsBand(SystemConstant.FLAG_OFF);
			}
			else{
				outview.setRouteId(routeId);
				WorkflowRouteDef workflowRouteDef = BaseDAOUtils.getWorkflowRouteDefDAO().query(routeId);
				outview.setIsBand(workflowRouteDef.getIsBand());
			}
			outview.setId((Integer) obj[6]);
			outview.setStartBrhid((String) obj[7]);
			/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
			if( (String)obj[7] != null && (Integer.valueOf((String)obj[7])).intValue() < 0){
				String brhTypeName = DataDicUtils.getDicName("28", (String)obj[7]);
				if(brhTypeName.indexOf("-")!=-1){
					outview.setStartBrhidName(brhTypeName.substring(brhTypeName.indexOf("-")+1) + "级别");
				}else{
					outview.setStartBrhidName(brhTypeName + "级别");
				}
			}
			Bctl branchInfo = BaseDAOUtils.getBctlDAO().queryById(String.valueOf(obj[7]));
			if(branchInfo!=null){
				outview.setStartBrhidName(branchInfo.getBrname());
			}
			/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
			resultList.add(outview);
		}

		pageQueryResult.setTotalCount(resultList.size());
		pageQueryResult.setQueryResult(resultList);
		return pageQueryResult;
	}


	/**
	 * 保存审批路线绑定业务信息
	 *
	 * @param delList
	 * @param insertList
	 * @param updateList
	 *
	 */
	public void saveRouteBindingEntry(List delList,List insertList,List updateList) throws CommonException{
		WorkflowRouteBindingDAO  workflowRouteBindingDAO = BaseDAOUtils.getWorkflowRouteBindingDAO();
		WorkflowRouteDefDAO  workflowRouteDefDAO = BaseDAOUtils.getWorkflowRouteDefDAO();

		//新增
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			RouteBindingView insview =(RouteBindingView) it.next();;
			WorkflowRouteBinding workflowRouteBinding = new WorkflowRouteBinding();
			workflowRouteBinding.setBrhClass(insview.getBrhClass());
			workflowRouteBinding.setBussType(insview.getBussType());
			workflowRouteBinding.setDraftType(insview.getDraftType());
			workflowRouteBinding.setMaxAmt(insview.getMaxAmt());
			workflowRouteBinding.setRouteId(insview.getRouteId());
			workflowRouteBinding.setStartBrhno(insview.getStartBrhno());
			workflowRouteBinding.setStartBrhid(insview.getStartBrhid());
//			workflowRouteBinding.setId(1);

			/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
			/** 判断发起机构与机构递归关系之间关系的判断.*/
			BctlService bctlService = BctlService.getInstance();
			/** 指定某个机构.*/
			if(workflowRouteBinding.getStartBrhid()==null){
				ExceptionUtil.throwCommonException("制定发起机构为空",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
			}
			if(Integer.valueOf(workflowRouteBinding.getStartBrhid())>0){
				Bctl branchInfo = bctlService.getBctlByBrcode(String.valueOf(workflowRouteBinding.getStartBrhid()));
				String brhClass = branchInfo.getBrclass();
				if(!NumberUtils.isNumber(brhClass)){
					ExceptionUtil.throwCommonException("制定发起机构的机构级别出错",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
				}else{
					//发起行机构级别比机构递归关系高,配置错误
					if(!NumberUtils.isNumber(insview.getBrhClass())){
						ExceptionUtil.throwCommonException("机构递归关系出错",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
					}
					if(Integer.parseInt(brhClass) < Integer.parseInt(insview.getBrhClass())){
						ExceptionUtil.throwCommonException("发起行机构级别比机构递归关系高,配置错误",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
					}
				}
			}
			/** 指定所有机构,目前UI不支持.*/
			else if(workflowRouteBinding.getStartBrhid().equals(0)){
				//此处不判断关系
			}
			/** 依据机构级别设定.*/
			else{
				Integer brhClass = Integer.valueOf(workflowRouteBinding.getStartBrhid())*-1;
				//发起行机构级别比机构递归关系高,配置错误
				if(!NumberUtils.isNumber(insview.getBrhClass())){
					ExceptionUtil.throwCommonException("机构递归关系出错",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
				}
				if(brhClass < Integer.parseInt(insview.getBrhClass())){
					ExceptionUtil.throwCommonException("发起行机构级别比机构递归关系高,配置错误",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
				}
			}
			/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
			workflowRouteBindingDAO.insert(workflowRouteBinding);


		}
		//修改
		for(Iterator it = updateList.iterator();it.hasNext();)
		{
			RouteBindingView updateView =(RouteBindingView) it.next();;
			WorkflowRouteBinding workflowRouteBinding = new WorkflowRouteBinding();
			workflowRouteBinding.setBrhClass(updateView.getBrhClass());
			workflowRouteBinding.setBussType(updateView.getBussType());
			workflowRouteBinding.setDraftType(updateView.getDraftType());
			workflowRouteBinding.setMaxAmt(updateView.getMaxAmt());
			workflowRouteBinding.setRouteId(updateView.getRouteId());
			workflowRouteBinding.setStartBrhno(updateView.getStartBrhno());
			workflowRouteBinding.setStartBrhid(updateView.getStartBrhid());
			workflowRouteBinding.setId(updateView.getId());
			/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
			/** 判断发起机构与机构递归关系之间关系的判断.*/
			BctlService bctlService = BctlService.getInstance();
			/** 指定某个机构.*/
			if(workflowRouteBinding.getStartBrhid()==null){
				ExceptionUtil.throwCommonException("制定发起机构为空",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
			}
			if(Integer.valueOf(workflowRouteBinding.getStartBrhid()).intValue()>0){
				Bctl branchInfo = bctlService.getBctlByBrcode(String.valueOf(workflowRouteBinding.getStartBrhid()));
				String brhClass = branchInfo.getBrclass();
				if(!NumberUtils.isNumber(brhClass)){
					ExceptionUtil.throwCommonException("制定发起机构的机构级别出错",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
				}else{
					//发起行机构级别比机构递归关系高,配置错误
					if(!NumberUtils.isNumber(updateView.getBrhClass())){
						ExceptionUtil.throwCommonException("机构递归关系出错",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
					}
					if(Integer.parseInt(brhClass) < Integer.parseInt(updateView.getBrhClass())){
						ExceptionUtil.throwCommonException("发起行机构级别比机构递归关系高,配置错误",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
					}
				}
			}
			/** 指定所有机构,目前UI不支持.*/
			else if(workflowRouteBinding.getStartBrhid().equals(0)){
				//此处不判断关系
			}
			/** 依据机构级别设定.*/
			else{
				Integer brhClass = Integer.valueOf(workflowRouteBinding.getStartBrhid())*-1;
				//发起行机构级别比机构递归关系高,配置错误
				if(!NumberUtils.isNumber(updateView.getBrhClass())){
					ExceptionUtil.throwCommonException("机构递归关系出错",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
				}
				if(brhClass < Integer.parseInt(updateView.getBrhClass())){
					ExceptionUtil.throwCommonException("发起行机构级别比机构递归关系高,配置错误",ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT);
				}
			}
			/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
			workflowRouteBindingDAO.update(workflowRouteBinding);


		}
		//删除
		for(Iterator it = delList.iterator();it.hasNext();)
		{
			RouteBindingView delView =(RouteBindingView) it.next();;
			WorkflowRouteBinding workflowRouteBinding = new WorkflowRouteBinding();
			workflowRouteBinding.setBrhClass(delView.getBrhClass());
			workflowRouteBinding.setBussType(delView.getBussType());
			workflowRouteBinding.setDraftType(delView.getDraftType());
			workflowRouteBinding.setMaxAmt(delView.getMaxAmt());
			workflowRouteBinding.setRouteId(delView.getRouteId());
			workflowRouteBinding.setStartBrhno(delView.getStartBrhno());
			workflowRouteBinding.setStartBrhid(delView.getStartBrhid());
			workflowRouteBinding.setId(delView.getId());
			workflowRouteBindingDAO.delete(workflowRouteBinding);

			//检查被删除的绑定记录中的路线是否被其他绑定，如果没有被其他绑定，则更新isBand字段
			if(delView.getRouteId()!=null&&delView.getRouteId()!=0){
				List routebinglist  = workflowRouteBindingDAO.queryByCondition(" po.routeId = " + delView.getRouteId());
				if(routebinglist.size()==0){
					WorkflowRouteDef workflowRouteDef = workflowRouteDefDAO.query(delView.getRouteId());
					workflowRouteDef.setIsBand(SystemConstant.FLAG_OFF);
					workflowRouteDefDAO.update(workflowRouteDef);
				}
			}

		}
	}

	/**
	 * 保存审批路线绑定信息，更新绑定的审批路线号
	 *
	 * @param delList
	 * @param insertList
	 * @param updateList
	 *
	 */
	public void saveRouteBinding(RouteBindingView routeBindingView) throws CommonException{
		WorkflowRouteBindingDAO  workflowRouteBindingDAO = BaseDAOUtils.getWorkflowRouteBindingDAO();
		WorkflowRouteBinding workflowRouteBinding = new WorkflowRouteBinding();
		workflowRouteBinding = workflowRouteBindingDAO.query(routeBindingView.getId());
		workflowRouteBinding.setRouteId(routeBindingView.getRouteId());
		workflowRouteBindingDAO.update(workflowRouteBinding);
		//更新路线定义表isSet字段
		WorkflowRouteDefDAO workflowRouteDefDAO = BaseDAOUtils.getWorkflowRouteDefDAO();
		WorkflowRouteDef workflowRouteDef =  workflowRouteDefDAO.query(routeBindingView.getRouteId());
		workflowRouteDef.setIsBand(SystemConstant.FLAG_ON);
		workflowRouteDefDAO.update(workflowRouteDef);
	}

	/**
	 * 保存审批路线绑定信息，更新绑定的审批路线号
	 *
	 * @param delList
	 * @param insertList
	 * @param updateList
	 *
	 */
	public void saveRouteBinding(List routeBindingViewlist) throws CommonException{
		WorkflowRouteBindingDAO  workflowRouteBindingDAO = BaseDAOUtils.getWorkflowRouteBindingDAO();
		WorkflowRouteDefDAO workflowRouteDefDAO = BaseDAOUtils.getWorkflowRouteDefDAO();
		/** modify by chaochao.yang BMS-2354  begin .*/
		int number = 0;
		/** modify by chaochao.yang BMS-2354  end .*/
		for(int i =0; i<routeBindingViewlist.size(); i++){
			RouteBindingView routeBindingView = (RouteBindingView) routeBindingViewlist.get(i);
			Integer routeId = routeBindingView.getRouteId();
			/** modify by shen_antonio 20091214 jira:BMS-2334 begin .*/
			if(routeBindingView.isSelect()){
				WorkflowRouteBinding workflowRouteBinding = new WorkflowRouteBinding();
				workflowRouteBinding = workflowRouteBindingDAO.query(routeBindingView.getId());
				workflowRouteBinding.setRouteId(routeId);
				workflowRouteBindingDAO.update(workflowRouteBinding);
				//更新路线定义表isSet字段
				WorkflowRouteDef workflowRouteDef =  workflowRouteDefDAO.query(routeBindingView.getRouteId());
				workflowRouteDef.setIsBand(SystemConstant.FLAG_ON);
				workflowRouteDefDAO.update(workflowRouteDef);
			}
			/** modify by shen_antonio 20091214 jira:BMS-2334 end .*/
			//判断被去除的审批路线是否被其他绑定
			else{
				/** modify by chaochao.yang BMS-2354  begin .*/
				++number;
				if(number == routeBindingViewlist.size()){
					WorkflowRouteBinding workflowRouteBinding = new WorkflowRouteBinding();
					workflowRouteBinding = workflowRouteBindingDAO.query(routeBindingView.getId());
					workflowRouteBinding.setRouteId(0);
					workflowRouteBindingDAO.update(workflowRouteBinding);
				}
				/** modify by chaochao.yang BMS-2354  end .*/
				List routebindinglist = workflowRouteBindingDAO.queryByCondition(" po.routeId = " + routeId );
				if(routebindinglist.size()==0){
					WorkflowRouteDef workflowRouteDef =  workflowRouteDefDAO.query(routeBindingView.getRouteId());
					workflowRouteDef.setIsBand(SystemConstant.FLAG_OFF);
					workflowRouteDefDAO.update(workflowRouteDef);
				}
			}

		}

	}
	
	/**
	 * 查询符合条件的审批路线参数
	 *
	 * @param workflowRouteDef
	 * @param pageSize
	 * @param pageIndex
	 * @return pageQueryResult
	 */
	public PageQueryResult queryRouteBindingBussInfoNew(RouteBindingView inview,int pageSize, int pageIndex)throws CommonException{
		StringBuffer sb1 = new StringBuffer();
		sb1.append("select bind.bussType, bind.draftType, bind.maxAmt, bind.startBrhno, bind.brhClass, bind.routeId, bind.id, bind.startBrhid " +
					" from WorkflowRouteBinding bind ")
		 		.append(" where 1=1" );

		//业务种类
		if(!DataFormat.isEmpty(inview.getBussType())){
			/**mod by abudula at 20101118 start  STL-62 */
			sb1.append(" and substr(bind.draftType,3) = '"+ inview.getBussType()+"'");
			/**mod by abudula at 20101118 end  STL-62 s*/
		}
		//路线绑定id
		if(inview.getId()!=null&&inview.getId()!=0){
			sb1.append(" and bind.id = "+ inview.getId());
		}
		/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
		/**mod by abudula 20101121 start */
		/**mod by abudula 20101121 end */
		if(inview.getStartBrhid()!=null){
			sb1.append(" and abs(bind.startBrhid) = " + inview.getStartBrhid());
		}
		/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
		HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb1.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);
		Iterator iter = pageQueryResult.getQueryResult().iterator();
		List resultList = new ArrayList();
		RouteBindingView outview = null;
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();
			outview =  new RouteBindingView();
//			outfwrp.setId((Integer) obj[0]);
			String bussType = (String) obj[1];
			outview.setBussType(bussType.substring(0,2)+"00");
			outview.setBizType(bussType.substring(2));
			outview.setDraftType((String) obj[1]);
			outview.setMaxAmt(new BigDecimal(obj[2].toString()));
			outview.setStartBrhno((String) obj[3]);
			outview.setBrhClass((String) obj[4]);
			Integer routeId = (Integer) obj[5];
			//如果绑定表中路线号为空或者0，则该路线肯定未绑定
			if(routeId==null||routeId==0){
				outview.setIsBand(SystemConstant.FLAG_OFF);
			}
			else{
				outview.setRouteId(routeId);
				WorkflowRouteDef workflowRouteDef = BaseDAOUtils.getWorkflowRouteDefDAO().query(routeId);
				outview.setIsBand(workflowRouteDef.getIsBand());
			}
			outview.setId((Integer) obj[6]);
			outview.setStartBrhid((String) obj[7]);
			/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
			if( (String)obj[7] != null && (Integer.valueOf((String)obj[7])).intValue() < 0){
				String brhTypeName = DataDicUtils.getDicName("8805", (String)obj[7]);
				if(brhTypeName.indexOf("-")!=-1){
					outview.setStartBrhidName(brhTypeName.substring(brhTypeName.indexOf("-")+1) + "级别");
				}else{
					outview.setStartBrhidName(brhTypeName + "级别");
				}
			}
			Bctl branchInfo = BaseDAOUtils.getBctlDAO().queryById(String.valueOf(obj[7]));
			if(branchInfo!=null){
				outview.setStartBrhidName(branchInfo.getBrname());
			}
			/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
			resultList.add(outview);
		}

		pageQueryResult.setTotalCount(resultList.size());
		pageQueryResult.setQueryResult(resultList);
		return pageQueryResult;
	}
	/**
	 * 查询符合条件的审批路线参数
	 *
	 * @param workflowRouteDef
	 * @param pageSize
	 * @param pageIndex
	 * @return pageQueryResult
	 */
	public PageQueryResult queryApproveNodeRouteBindingInfo(RouteBindingView inview,int pageSize, int pageIndex)throws CommonException{
		StringBuffer sb1 = new StringBuffer();
		sb1.append("select bind.bussType, bind.draftType, bind.maxAmt, bind.startBrhno, bind.brhClass, bind.routeId, bind.id, bind.startBrhid " +
					" from WorkflowRouteBinding bind ")
		 		.append(" where 1=1" );

		//业务种类
		if(!DataFormat.isEmpty(inview.getBussType())){
			/**mod by abudula at 20101118 start  STL-62 */
//			sb1.append(" and substr(bind.bussType,0,4) = '"+ inview.getBussType()+"'");
			sb1.append(" and bind.bussType = '"+ inview.getBussType()+"'");
			/**mod by abudula at 20101118 end  STL-62 s*/
		}
		if(!DataFormat.isEmpty(inview.getDraftType())){
			/**mod by abudula at 20101118 start  STL-62 */
//			sb1.append(" and substr(bind.bussType,0,4) = '"+ inview.getBussType()+"'");
			sb1.append(" and substr(bind.draftType,0,2) = '"+ inview.getDraftType()+"'");
			/**mod by abudula at 20101118 end  STL-62 s*/
		}
		//路线绑定id
//		if(inview.getId()!=null&&inview.getId()!=0){
//			sb1.append(" and bind.id = "+ inview.getId());
//		}
		/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
		/**mod by abudula 20101121 start */
		/**mod by abudula 20101121 end */
		if(inview.getStartBrhid()!=null){
			sb1.append(" and abs(bind.startBrhid) = " + inview.getStartBrhid());
		}
		/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
		HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb1.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);
		Iterator iter = pageQueryResult.getQueryResult().iterator();
		List resultList = new ArrayList();
		RouteBindingView outview = null;
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();
			outview =  new RouteBindingView();
//			outfwrp.setId((Integer) obj[0]);
			outview.setBussProc(inview.getBussProc());
			String bussType = (String) obj[1];
			outview.setBussType(bussType.substring(0,2)+"00");
			outview.setBizType(bussType.substring(2));
			outview.setDraftType((String) obj[1]);
			outview.setMaxAmt(new BigDecimal(obj[2].toString()));
			outview.setStartBrhno((String) obj[3]);
			outview.setBrhClass((String) obj[4]);
			Integer routeId = (Integer) obj[5];
			//如果绑定表中路线号为空或者0，则该路线肯定未绑定
			if(routeId==null||routeId==0){
				outview.setIsBand(SystemConstant.FLAG_OFF);
			}
			else{
				outview.setRouteId(routeId);
				WorkflowRouteDef workflowRouteDef = BaseDAOUtils.getWorkflowRouteDefDAO().query(routeId);
				outview.setIsBand(workflowRouteDef.getIsBand());
			}
			outview.setId((Integer) obj[6]);
			outview.setStartBrhid((String) obj[7]);
			/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
			if( (String)obj[7] != null && (Integer.valueOf((String)obj[7])).intValue() < 0){
				String brhTypeName = DataDicUtils.getDicName("8805", (String)obj[7]);
				if(brhTypeName.indexOf("-")!=-1){
					outview.setStartBrhidName(brhTypeName.substring(brhTypeName.indexOf("-")+1) + "级别");
				}else{
					outview.setStartBrhidName(brhTypeName + "级别");
				}
			}
			Bctl branchInfo = BaseDAOUtils.getBctlDAO().queryById(String.valueOf(obj[7]));
			if(branchInfo!=null){
				outview.setStartBrhidName(branchInfo.getBrname());
			}
			/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
			resultList.add(outview);
		}

		pageQueryResult.setTotalCount(resultList.size());
		pageQueryResult.setQueryResult(resultList);
		return pageQueryResult;
	}
}
