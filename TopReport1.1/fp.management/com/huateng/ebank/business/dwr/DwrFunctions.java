package com.huateng.ebank.business.dwr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import resource.bean.pub.BranchFuncRel;
import resource.bean.pub.FunctionInfo;
import resource.bean.pub.RoleFuncRel;
import resource.bean.pub.RoleInfo;
import resource.bean.report.BiWorkdate;
import resource.bean.report.BiWorkdateConf;
import resource.bean.report.SysTaskInfo;
import resource.bean.report.SysTaskLog;
import resource.dao.pub.BranchFuncRelDAO;
import resource.dao.pub.RoleFuncRelDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.model.Constant;
import com.huateng.report.system.operation.BiWorkDateOperation;
import com.huateng.report.system.service.BiWorkDateService;
import com.huateng.report.system.service.TaskListService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.service.pub.UserMgrService;

import edu.emory.mathcs.backport.java.util.Arrays;

public class DwrFunctions {
	private Logger logger = LoggerFactory.getLogger(DwrFunctions.class);
	private void setGlobalInfo(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		if (null != httpSession) {
			Object o = httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			if (null != o && o instanceof GlobalInfo) {
				GlobalInfo globalInfo = (GlobalInfo) o;
				GlobalInfo.setCurrentInstance(globalInfo);
			}
		}
	}
	/**
	 * 通过所有获得权限
	 */
	public List<String> getFuncArray(HttpServletRequest request) {
		try {
			String str = "from FunctionInfo func";
			List<String> list = CommonFunctions.getFunctionList(DAOUtils
					.getHQLDAO().queryByQL2List(str));
			// for(int i=0;i<list.size();i++){
			// System.out.println(list.get(i).toString());
			// }
			return list;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			return new ArrayList<String>();
		}
	}

	public List<String> getFuncArrayCopram(HttpServletRequest request) {
		try {
			String str = "from FunctionInfo func";
			List<String> list = CommonFunctions.getFunctionListCompar(DAOUtils
					.getHQLDAO().queryByQL2List(str));
			// for(int i=0;i<list.size();i++){
			// System.out.println(list.get(i).toString());
			// }
			return list;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			return new ArrayList<String>();
		}
	}

	/**
	 *查询机构ID的权限
	 */
	public List<FunctionInfo> getFunctionByBranchId(String brcode) {

		try {
			// int branchid = Integer.parseInt(brcode);
			String str = "select trim(func.id) from FunctionInfo func,BranchFuncRel bfl where bfl.funcid = func.id and func.isdirectory=0 and  bfl.brcode = "
					+ brcode;
			return DAOUtils.getHQLDAO().queryByQL2List(str);
		} catch (CommonException e) {
			return null;
		}
	}

	/**
	 * 修改机构权限
	 */
	public int updateBranchFunc(String brcode, String funcs) {
		Hashtable oldfuncs = new Hashtable();
		Hashtable newfuncs = new Hashtable();
		BranchFuncRelDAO bfrd = DAOUtils.getBranchFuncRelDAO();
		// List rfuncs = bfrd.findByBranchid(Integer.parseInt(branchId));
		List rfuncs = bfrd.findByBranchid(brcode.trim());
		Iterator it = rfuncs.iterator();
		while (it.hasNext()) {
			BranchFuncRel bfr = (BranchFuncRel) it.next();
			oldfuncs.put(bfr.getFuncid().trim(), bfr);
		}
		StringTokenizer st = new StringTokenizer(funcs, ",");
		while (st.hasMoreTokens()) {
			String fid = st.nextToken();
			if (newfuncs.containsKey(fid) == false)
				newfuncs.put(fid, fid);
		}
		Iterator itnew = newfuncs.keySet().iterator();
		while (itnew.hasNext()) {
			String newfid = (String) itnew.next();
			if (oldfuncs.containsKey(newfid)) {
				oldfuncs.remove(newfid);
			} else {
				BranchFuncRel newbfr = new BranchFuncRel();
				newbfr.setFuncid(newfid);
				newbfr.setBrcode(brcode);
				bfrd.save(newbfr);
			}
		}
		Enumeration en = oldfuncs.keys();
		while (en.hasMoreElements()) {
			Object key_num = en.nextElement();
			BranchFuncRel oldbfr = (BranchFuncRel) oldfuncs.get(key_num);
			bfrd.delete(oldbfr);
		}
		return 0;
	}

	/**
	 * @desc获取岗位对应的权限
	 * @author fubo
	 * @param roleId
	 * @return
	 * @throws CommonException
	 */
	public List<FunctionInfo> getRoleFuncByid(String roleId)
			throws CommonException {

		String str = "select trim(funInfo.id) from FunctionInfo funInfo,RoleFuncRel rolefun where funInfo.id= rolefun.funcid and funInfo.isdirectory=0"
				+ "and rolefun.roleId = " + roleId;
		List list = DAOUtils.getHQLDAO().queryByQL2List(str);
		return list;
	}

	/**
	 * 角色信息对比
	 * @param roleId
	 * @param st
	 * @param flag
	 * @param tskId
	 * @return
	 * @throws CommonException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<String> getRoleFuncByIdCom(String roleId, String st, String flag, String tskId) throws CommonException, IOException, ClassNotFoundException{
		List<String> list = new ArrayList<String>();
		if(flag.equals("0")){
			String str = "select trim(funInfo.id) from FunctionInfo funInfo,RoleFuncRel rolefun where funInfo.id= rolefun.funcid and funInfo.isdirectory=0"
					+ "and rolefun.roleId = " + roleId;
			list = DAOUtils.getHQLDAO().queryByQL2List(str);
		}
		if(flag.equals("1")){
			ReportTaskUtil rt=new ReportTaskUtil();
			SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
			RoleInfo oldValue = null;
			if(systasklog.getOldVal1()!=null){
				oldValue=(RoleInfo)rt.getOldObjectByTaskLog(systasklog);
			}
			if(oldValue != null && oldValue.getRoleList() != null && oldValue.getRoleList().length() > 0){
				list = Arrays.asList(oldValue.getRoleList().split(","));
			}
		}
		return list;
	}

	/**
	 * 序列化角色信息新内容
	 * @param roleId
	 * @param st
	 * @param flag
	 * @param tskId
	 * @return
	 * @throws CommonException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<String> getRoleFuncByIdComSeri(String roleId, String st, String flag, String tskId) throws CommonException, IOException, ClassNotFoundException{
		List<String> list = new ArrayList<String>();
		if(flag.equals("0")){
			if (st.equals("2")) {
				ReportTaskUtil rt = new ReportTaskUtil();
				List<SysTaskInfo> taskList = ROOTDAOUtils.getROOTDAO().queryByQL2List("from SysTaskInfo where intInsId='100299' and adtRcdPk='" + roleId + "'");
				if (taskList.size() > 0) {
					RoleInfo roleInfoSeri = (RoleInfo) rt.getObjctBySysTaskInfo(taskList.get(0));
					if(roleInfoSeri != null && roleInfoSeri.getRoleList() != null && roleInfoSeri.getRoleList().length() > 0){
						list = Arrays.asList(roleInfoSeri.getRoleList().split(","));
					}
				}
			}
		}
		if(flag.equals("1")){
			ReportTaskUtil rt=new ReportTaskUtil();
			SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
			RoleInfo newValue = null;
			if(systasklog.getNewVal1()!=null){
				newValue=(RoleInfo)rt.getNewObjectByTaskLog(systasklog);
			}
			if(newValue != null && newValue.getRoleList() != null && newValue.getRoleList().length() > 0){
				list = Arrays.asList(newValue.getRoleList().split(","));
			}
		}
		return list;
	}

	/**
	 * @desc更新角色的权限
	 * @author fubo
	 * @param rid
	 * @param funcs
	 * @return
	 */
	public int updateRoleFunc(String rid, String funcs) {

		Hashtable oldfuncs = new Hashtable();
		Hashtable newfuncs = new Hashtable();

		RoleFuncRelDAO rfrd = DAOUtils.getRoleFuncRelDAO();
		List rfuncs = rfrd.findByRoleid(Integer.parseInt(rid));

		Iterator it = rfuncs.iterator();
		while (it.hasNext()) {
			RoleFuncRel rfr = (RoleFuncRel) it.next();
			oldfuncs.put(rfr.getFuncid().toString(), rfr);
		}

		StringTokenizer st = new StringTokenizer(funcs, ",");
		while (st.hasMoreTokens()) {
			String fid = st.nextToken();
			if (newfuncs.containsKey(fid) == false)
				newfuncs.put(fid, fid);
		}

		Iterator itnew = newfuncs.keySet().iterator();
		while (itnew.hasNext()) {
			String newfid = (String) itnew.next();
			if (oldfuncs.containsKey(newfid)) {
				oldfuncs.remove(newfid);
			} else {
				RoleFuncRel newrfr = new RoleFuncRel();
				newrfr.setFuncid(newfid);
				newrfr.setRoleId(Integer.parseInt(rid));
				rfrd.save(newrfr);
			}
		}
		Enumeration en = oldfuncs.keys();
		while (en.hasMoreElements()) {
			Object key_num = en.nextElement();
			RoleFuncRel oldrfr = (RoleFuncRel) oldfuncs.get(key_num);
			rfrd.delete(oldrfr);
		}

		return 0;
	}

	/**
	 * 根据年份获取工作日期
	 *
	 * @param year
	 * @return
	 * @throws CommonException
	 */
	public List<String> getWorkDateByYear(String year) throws CommonException {
		List<String> list = new ArrayList<String>();
		List<BiWorkdate> biwds = BiWorkDateService.getInstance()
				.getWorkDateByYear(year);
		for (BiWorkdate bi : biwds) {
			list.add(bi.getId());
		}
		return list;
	}

	/**
	 * 工作日期维护保存
	 *
	 * @param year
	 * @param workDates
	 * @return
	 * @throws CommonException
	 */
	public int saveOrUpdateWorkDate(HttpServletRequest request,String year, List<String> workDates)
			throws CommonException {
		setGlobalInfo(request);

		OperationContext oc = new OperationContext();
		oc.setAttribute(BiWorkDateOperation.CMD, BiWorkDateOperation.OP_SAVE);
		oc.setAttribute(BiWorkDateOperation.IN_YEAE, year);
		oc.setAttribute(BiWorkDateOperation.IN_WORKDATE, workDates);
		OPCaller.call(BiWorkDateOperation.ID, oc);
TaskListService tls = TaskListService.getInstance();
		if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100599.value)){
			return 2;
		}
		else{
		return 0;
		}
	}

	public List<Constant> getProgress(HttpServletRequest request) {
		List<Constant> list = (List<Constant>) request.getSession()
				.getAttribute(Constants.PROGRESS);
		for (Constant c : list) {
			if (c.stopFlag) {
				request.getSession().removeAttribute(Constants.PROGRESS);
				break;
			}
		}
		return list;
	}

	public String getcurrentFileType(String appType, String currentFileType)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String fileTypeId = "";

		PageQueryCondition queryCondition = new PageQueryCondition();

		StringBuffer hql = new StringBuffer(
				"select dd.id from DataDic dd where 1=1 ");

		if (StringUtils.isNotBlank(appType)
				&& StringUtils.isNotBlank(currentFileType)) {
			hql.append(" and dd.dataNo ='").append(appType)
					.append("' and dd.dataTypeNo= 17");
		} else
			return currentFileType;

		List list = rootdao.queryByQL2List(hql.toString());

		if (!list.isEmpty()) {
			fileTypeId = "" + (Integer) list.get(0);
		} else
			return currentFileType;

		if (!StringUtils.isEmpty(fileTypeId)
				&& !StringUtils.isEmpty(currentFileType)) {
			StringBuffer hql1 = new StringBuffer(
					"select dd.dataName from DataDic dd where 1=1 ");
			hql1.append(" and dd.miscflgs = '").append(fileTypeId).append("'");
			hql1.append(" and dd.dataNo = '").append(currentFileType)
					.append("'");
			list = rootdao.queryByQL2List(hql1.toString());

			if (!list.isEmpty()) {
				return (String) list.get(0);
			}
		}

		return currentFileType;
	}

	// jianxue.zhang
	// 工作日期检查是否锁定
	//jianxue.zhang
	//工作日期检查是否锁定
	public int checkWorkdateLock(String yr) throws CommonException{
		  ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		  BiWorkdateConf bc=null;
		  StringBuffer hql = new StringBuffer("select dd from BiWorkdateConf dd where 1=1 and dd.id='"+yr+"'");

			Iterator it=rootdao.queryByQL(hql.toString());
			while(it.hasNext()){
				bc=(BiWorkdateConf)it.next();
				//System.out.println("workdateLock?:"+bc.isLock());
				if(bc.isLock())
					return 1;
			}

		return 0;

	}

	public List<String[]> getWorkDateByDetail(String year,String type,String taskId,String flag,String st) throws CommonException, IOException, ClassNotFoundException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<String[]> list = new ArrayList<String[]>();
		ReportShowDetailService service = ReportShowDetailService.getInstance();
		if ("0".equals(flag)) {//主管确认页面
			List<BiWorkdate> wdlist = BiWorkDateService.getInstance().getWorkDateByYear(year);
			String[] oldstrs = new String[wdlist.size()];
			for (int i = 0; i < wdlist.size(); i++) {
				BiWorkdate wd = wdlist.get(i);
				oldstrs[i]=wd.getId();
			}
			list.add(oldstrs);
			if (ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value.equals(st)) {//编辑
				SysTaskInfo tskInf =  service.getSysTaskInfo(type, year);
				if(tskInf!=null){
					BiWorkdateConf conf = (BiWorkdateConf) ReportTaskUtil.getObjctBySysTaskInfo(tskInf);
					Object[] objs = conf.getWorkDateList().toArray();
					String[] newstrs = new String[objs.length];
					for (int i = 0; i < objs.length; i++) {
						newstrs[i]=objs[i].toString().trim();
					}
					list.add(newstrs);
				}
			}
		}else if ("1".equals(flag)) {//已办理
			SysTaskLog tlog = service.selectTaskLog(taskId);
			if (ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value.equals(st)) {//编辑
				BiWorkdateConf confold = (BiWorkdateConf) ReportTaskUtil.getOldObjectByTaskLog(tlog);
				String[] oldstrs = service.getTaskToWorkDateConf(confold);
				list.add(oldstrs);
				System.out.println("old="+oldstrs.toString());
			}


			BiWorkdateConf conf = (BiWorkdateConf) ReportTaskUtil.getNewObjectByTaskLog(tlog);
			String[] newstrs = service.getTaskToWorkDateConf(conf);
			list.add(newstrs);
			System.out.println("new="+newstrs.toString());
		}
		return list;
	}

	/**
	 *通过个人用户权限
	 * @throws CommonException
	 */
	public List<String> getFuncArrayByFavt(HttpServletRequest request) throws CommonException {
		HttpSession httpSession = request.getSession(false);
		GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		GlobalInfo.setCurrentInstance(globalInfo);
		Map funmap = globalInfo.getAllFunctions();
		List<FunctionInfo> funcInfoList = new ArrayList<FunctionInfo>();
		UserMgrService.getInstance().getUserFunctionsByMenuType(globalInfo.getTlrno(), globalInfo.getMenuCode(), funcInfoList);
/*		for (Iterator iterator = funmap.keySet().iterator(); iterator.hasNext();) {
			String funcId = (String) iterator.next();

			FunctionInfo fun = (FunctionInfo)funmap.get(funcId);

			//调整主管确认
			if (ReportConstant.FILTER_FUNC_ID_SET.contains(fun.getId().trim())) {
				fun.setIsdirectory(0);//调整为不是目录
			}
			if (fun.getLastdirectory()!=null && ReportConstant.FILTER_FUNC_ID_SET.contains(fun.getLastdirectory().toString())) {
				continue;
			}
			funcInfoList.add(fun);
		}*/
		List<String> list = CommonFunctions.getFunctionList(funcInfoList);
		return list;
	}

	public List<String> getFavtList(HttpServletRequest request) throws CommonException {
		List<String> selList = new ArrayList<String>();
		List list = ReportCommonService.getInstance().getFunctionInfoListByFavt(request.getSession(false));
		for (int i = 0; i < list.size(); i++) {
			FunctionInfo ft = (FunctionInfo) list.get(i);
			selList.add(ft.getId().trim());
		}
		return selList;
	}

	public void saveFavt(HttpServletRequest request,List<String> funcIds) throws CommonException {
		setGlobalInfo(request);

		OperationContext oc = new OperationContext();
		oc.setAttribute(BiWorkDateOperation.CMD, BiWorkDateOperation.OP_FAVT);
		oc.setAttribute(BiWorkDateOperation.IN_FAVT, funcIds);
		OPCaller.call(BiWorkDateOperation.ID, oc);
	}


}