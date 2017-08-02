/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.opermng.operation;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import resource.bean.pub.Bctl;
import resource.bean.pub.RoleInfo;
import resource.bean.pub.TlrBctlRel;
import resource.bean.pub.TlrInfo;
import resource.bean.pub.TlrRoleRel;
import resource.bean.report.SysTaskInfo;
import resource.bean.report.TlrManRel;
import resource.dao.pub.TlrInfoDAO;
import resource.dao.pub.TlrRoleRelDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.dataquery.bean.TlrMngRelBean;
import com.huateng.report.system.bean.TlrInfoAuditBean;
import com.huateng.report.system.service.TaskListService;
import com.huateng.report.utils.RepList;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.service.pub.PasswordService;
import com.huateng.service.pub.UserMgrService;
import com.huateng.view.pub.TlrRoleRelationView;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngOperation extends BaseOperation {

	private static final HtLog htlog = HtLogFactory.getLogger(OperMngOperation.class);

	public static final String ID = "management.OperMngOperation";
	public static final String CMD = "cmd";
	public static final String IN_TLRINFO = "IN_TLRINFO";
	public static final String IN_TLRNO = "IN_TLRNO";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_ROLELIST = "IN_ROLELIST";
	public static final String IN_BCTLLIST = "IN_BCTLLIST";
	//jianxue.zhang
	public static final String IN_TLRLLIST = "IN_TLRLIST";

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
	
	//jianxue.zhang
private void delUserRel(String tlrno,List<TlrBctlRel> bctls,List<TlrRoleRel> roleList,List<TlrMngRelBean> tlrList) throws CommonException{
	String key = tlrno;
	// 先删除用户的角色表和机构关联
	ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
	TlrRoleRelDAO tlrRoleRelDAO = DAOUtils.getTlrRoleRelDAO();
	List<TlrBctlRel> bctlRellist = rootdao.queryByQL2List("from TlrBctlRel where tlrNo = '" + key
			+ "'");
	for (TlrBctlRel trlbctreldel : bctlRellist) {
		rootdao.delete(trlbctreldel);
	}
	List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + key
			+ "'");
	for (TlrRoleRel trlrolereldel : roleRellist) {
		rootdao.delete(trlrolereldel);
	}
	//jianxue.zhang
//	List<TlrManRel> TlrMngRellist = rootdao.queryByQL2List("from TlrManRel where manage = '" + key
//			+ "'");
//	for (TlrManRel trlreldel : TlrMngRellist) {
//		rootdao.delete(trlreldel);
//	}
	// 给用户分配角色表：
	for (TlrRoleRel trlrolerel : roleList) {
//		rootdao.save(trlrolerel);
		tlrRoleRelDAO.insert(trlrolerel);
	}
	// 给用户分机构
	for (TlrBctlRel trlbctrel : bctls) {
		//added by xuhong 2015-3-31 手工添加id begin
		Integer id = trlbctrel.getId();
		if(id==null){
			id = 100;
			Iterator it = DAOUtils.getHQLDAO().queryByQL("select max(id) from TlrBctlRel");
			if (it.hasNext()) {
				Number num = (Number) it.next();
				id = num.intValue() + 1;
			}
			trlbctrel.setId(id);
		}
		//added by xuhong 2015-3-31 手工添加id end
		rootdao.save(trlbctrel);
	}
	//给销售分配人员
	for(TlrMngRelBean abc : tlrList){
		TlrManRel tlrrel=new TlrManRel();
		tlrrel.setManage(key);
		tlrrel.setTlrId(abc.getTlrno());
		tlrrel.setStatus("1");
		rootdao.save(tlrrel);
	}
}
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.
	 * ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		// GlobalInfo就相当于一个session
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
		TlrRoleRelDAO relationDao = DAOUtils.getTlrRoleRelDAO();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//modify by jianxue.zhang
		  TaskListService tls= TaskListService.getInstance();
			
		if ("new".equals(context.getAttribute(CMD))) {
			if (!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value)) {
				TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
				List<Bctl> bctls = (List<Bctl>) context.getAttribute(IN_BCTLLIST);
				List<TlrMngRelBean> tlrs = (List<TlrMngRelBean>) context.getAttribute(IN_TLRLLIST);
				List<RoleInfo> roles = (List<RoleInfo>) context.getAttribute(IN_ROLELIST);
				if (tlrInfoDAO.query(tlrInfo.getTlrno()) == null) {
					tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
					// 设置有效标志
					tlrInfo.setFlag(SystemConstant.FLAG_ON);
					String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
					String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");
					String password = PasswordService.getInstance().EncryptPassword(sysDefaultPwd, encMethod);
					tlrInfo.setPassword(password);// 设置默认操作员密码
					// 为操作员密码错误次数付初始值
					tlrInfo.setTotpswderrcnt(new Integer(0));
					tlrInfo.setPswderrcnt(new Integer(0));
					tlrInfo.setPasswdenc(encMethod);
					tlrInfo.setCreateDate(DateUtil.getCurrentDate());
					tlrInfo.setLastUpdTime(DateUtil.getTimestamp());
					tlrInfo.setLastUpdOperId(GlobalInfo.getCurrentInstance().getTlrno());
					tlrInfo.setIsLock(SystemConstant.FLAG_OFF);
					//tlrInfo.setIsLockModify("1");
					tlrInfo.setSt(ReportEnum.REPORT__FH_ST.YES.value);
					tlrInfoDAO.saveOrUpdate(tlrInfo);

					//保存授权机构
					RepList<TlrBctlRel> bctlRellist = new RepList<TlrBctlRel>();
					for(Bctl bc : bctls){
						TlrBctlRel tlrBctlRel = new TlrBctlRel();
						tlrBctlRel.setBrcode(bc.getBrcode());
						tlrBctlRel.setTlrNo(tlrInfo.getTlrno());
						rootdao.save(tlrBctlRel);
						//bctlRellist.add(tlrBctlRel);
					}
					//保存角色岗位
					RepList<TlrRoleRel> roleRellist = new RepList<TlrRoleRel>();
					for(RoleInfo rl : roles){
						TlrRoleRel tlrRoleRel = new TlrRoleRel();
						tlrRoleRel.setRoleId(rl.getId());
						tlrRoleRel.setTlrno(tlrInfo.getTlrno());
						tlrRoleRel.setStatus("1");
						rootdao.save(tlrRoleRel);
						//roleRellist.add(tlrRoleRel);
					}
					//保存下属信息
					for(TlrMngRelBean abc : tlrs){
						TlrManRel tlrrel=new TlrManRel();
						tlrrel.setManage(tlrInfo.getTlrno());
						tlrrel.setTlrId(abc.getTlrno());
						tlrrel.setStatus("1");
						rootdao.save(tlrrel);
					}
					
					
					
				} else {
					ExceptionUtil.throwCommonException("该操作员已经存在，不能新增", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
				}
				globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"新增用户编号[" + tlrInfo.getTlrno() + "]"});
				htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"新增用户编号[" + tlrInfo.getTlrno() + "]"});
			}
			else{
			TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
			List<Bctl> bctls = (List<Bctl>) context.getAttribute(IN_BCTLLIST);
			List<RoleInfo> roles = (List<RoleInfo>) context.getAttribute(IN_ROLELIST);
			if (tlrInfoDAO.query(tlrInfo.getTlrno()) == null) {
				tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
				// 设置有效标志
				tlrInfo.setFlag(SystemConstant.FLAG_ON);
				String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
				String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");
				String password = PasswordService.getInstance().EncryptPassword(sysDefaultPwd, encMethod);
				tlrInfo.setPassword(password);// 设置默认操作员密码
				// 为操作员密码错误次数付初始值
				tlrInfo.setTotpswderrcnt(new Integer(0));
				tlrInfo.setPswderrcnt(new Integer(0));
				tlrInfo.setPasswdenc(encMethod);
				tlrInfo.setCreateDate(DateUtil.getCurrentDate());
				tlrInfo.setLastUpdTime(DateUtil.getTimestamp());
				tlrInfo.setLastUpdOperId(GlobalInfo.getCurrentInstance().getTlrno());
				tlrInfo.setIsLock(SystemConstant.FLAG_OFF);
				tlrInfo.setIsLockModify("1");
				tlrInfo.setSt(ReportEnum.REPORT_ST1.CR.value);
				tlrInfoDAO.saveOrUpdate(tlrInfo);

				//保存授权机构
				RepList<TlrBctlRel> bctlRellist = new RepList<TlrBctlRel>();
				for(Bctl bc : bctls){
					TlrBctlRel tlrBctlRel = new TlrBctlRel();
					tlrBctlRel.setBrcode(bc.getBrcode());
					tlrBctlRel.setTlrNo(tlrInfo.getTlrno());
					rootdao.save(tlrBctlRel);
					bctlRellist.add(tlrBctlRel);
				}
				//保存角色岗位
				RepList<TlrRoleRel> roleRellist = new RepList<TlrRoleRel>();
				for(RoleInfo rl : roles){
					TlrRoleRel tlrRoleRel = new TlrRoleRel();
					tlrRoleRel.setRoleId(rl.getId());
					tlrRoleRel.setTlrno(tlrInfo.getTlrno());
					tlrRoleRel.setStatus("1");
					rootdao.save(tlrRoleRel);
					roleRellist.add(tlrRoleRel);
				}
				try {
					TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
					tlrInfoAuditBean.setTlrInfo(tlrInfo);
					tlrInfoAuditBean.setBctlRellist(bctlRellist);
					tlrInfoAuditBean.setRoleRellist(roleRellist);
					SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
							ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
							ReportEnum.REPORT_TASK_TRANS_CD.NEW.value,
							tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),null);
					rootdao.saveOrUpdate(tskInf);
				} catch (IOException e) {
					ExceptionUtil.throwCommonException("操作员新增保存，双岗复核序列化到数据库出错！");
					e.printStackTrace();
				}
			} else {
				ExceptionUtil.throwCommonException("该操作员已经存在，不能新增", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"新增用户编号[" + tlrInfo.getTlrno() + "]"});
			htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"新增用户编号[" + tlrInfo.getTlrno() + "]"});
			}
			} else if ("modify".equals(context.getAttribute(CMD))){
			TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
			List<Bctl> bctls = (List<Bctl>) context.getAttribute(IN_BCTLLIST);
			List<RoleInfo> roles = (List<RoleInfo>) context.getAttribute(IN_ROLELIST);
			List<TlrMngRelBean> tlrs = (List<TlrMngRelBean>) context.getAttribute(IN_TLRLLIST);
			//授权机构
			RepList<TlrBctlRel> bctlRellist = new RepList<TlrBctlRel>();
			for(Bctl bc : bctls){
				TlrBctlRel tlrBctlRel = new TlrBctlRel();
				tlrBctlRel.setBrcode(bc.getBrcode());
				tlrBctlRel.setTlrNo(tlrInfo.getTlrno());
				bctlRellist.add(tlrBctlRel);
			}
			//角色岗位
			RepList<TlrRoleRel> roleRellist = new RepList<TlrRoleRel>();
			for(RoleInfo rl : roles){
				TlrRoleRel tlrRoleRel = new TlrRoleRel();
				tlrRoleRel.setRoleId(rl.getId());
				tlrRoleRel.setTlrno(tlrInfo.getTlrno());
				tlrRoleRel.setStatus("1");
				roleRellist.add(tlrRoleRel);
			}
			TlrInfo dbTrlInfo = rootdao.query(TlrInfo.class, tlrInfo.getTlrno());
			dbTrlInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
			String oldTlrName = dbTrlInfo.getTlrName();
			Date oldLastUpTm = dbTrlInfo.getLastUpdTime();

			//新的值序列化数据库
			dbTrlInfo.setTlrName(tlrInfo.getTlrName());
			dbTrlInfo.setLastUpdTime(new Date());
			if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value)){
				dbTrlInfo.setSt(ReportEnum.REPORT__FH_ST.YES.value);
				rootdao.saveOrUpdate(dbTrlInfo);
				delUserRel(dbTrlInfo.getTlrno(), bctlRellist, roleRellist,tlrs);
				globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"修改用户编号[" + dbTrlInfo.getTlrno() + "]"});
			}
			else{
			try {
				TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
				tlrInfoAuditBean.setTlrInfo(dbTrlInfo);
				tlrInfoAuditBean.setBctlRellist(bctlRellist);
				tlrInfoAuditBean.setRoleRellist(roleRellist);
				SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
						ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
						ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
						tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),dbTrlInfo.getSt());
				rootdao.saveOrUpdate(tskInf);
			} catch (IOException e) {
				ExceptionUtil.throwCommonException("操作员修改保存，双岗复核序列化到数据库出错！");
				e.printStackTrace();
			}
			dbTrlInfo.setLastUpdTime(oldLastUpTm);
			dbTrlInfo.setTlrName(oldTlrName);
			rootdao.saveOrUpdate(dbTrlInfo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"修改用户编号[" + dbTrlInfo.getTlrno() + "]"});
			htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"修改用户编号[" + dbTrlInfo.getTlrno() + "]"});
			}} else if ("del".equals(context.getAttribute(CMD))) {
			String tlrno = (String) context.getAttribute(IN_TLRNO);
			tlrInfoDAO.delete(tlrno);

			List urrlist = relationDao.queryByCondition(" po.tlrno = '" + tlrno + "'");
			for (Iterator it = urrlist.iterator(); it.hasNext();) {
				TlrRoleRel ref = (TlrRoleRel) it.next();
				relationDao.delete(ref);
			}

		} else if ("mod".equals(context.getAttribute(CMD))) {
			TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
			TlrInfo ti = tlrInfoDAO.query(tlrInfo.getTlrno());
			if (ti != null) {
				ti.setTlrName(tlrInfo.getTlrName());
				ti.setBrcode(tlrInfo.getBrcode());
				ti.setEffectDate(tlrInfo.getEffectDate());
				ti.setExpireDate(tlrInfo.getExpireDate());
				ti.setEmail(tlrInfo.getEmail());
				tlrInfoDAO.saveOrUpdate(ti);
			}
		} else if ("auth".equals(context.getAttribute(CMD))) {
			List roleList = (List) context.getAttribute(IN_ROLELIST);
			TlrRoleRel rr = null;
			for (int i = 0; i < roleList.size(); i++) {
				TlrRoleRelationView inurr = (TlrRoleRelationView) roleList.get(i);
				List urrlist = relationDao.queryByCondition(" po.tlrno = '" + inurr.getTlrno() + "'  and po.roleId = " + inurr.getRoleId());
				// 选中的岗位
				if (inurr.isSelected()) {
					// 原先无数据,则插入新数据
					if (urrlist == null || urrlist.size() == 0) {
						rr = new TlrRoleRel();
						rr.setRoleId(Integer.valueOf(inurr.getRoleId()));
						rr.setTlrno(inurr.getTlrno());
						rr.setStatus("1");// 1有效 0无效
						relationDao.getHibernateTemplate().saveOrUpdate(rr);
					}
					// 原先有数据，则更新status
					else {
						for (int j = 0; j < urrlist.size(); j++) {
							rr = (TlrRoleRel) urrlist.get(j);
							if (!"1".equals(rr.getStatus())) {
								rr.setStatus("1");
								relationDao.getHibernateTemplate().saveOrUpdate(rr);
							}
						}
					}
				}
				// 没有选中的岗位
				else {
					for (int k = 0; k < urrlist.size(); k++) {
						rr = (TlrRoleRel) urrlist.get(k);
						relationDao.delete(rr);
					}
				}

			}
		} else if ("resetPwd".equals(context.getAttribute(CMD))) {
			if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value)){
				String tlrno = (String) context.getAttribute(IN_TLRNO);
				// 修改用户密码
//				UserMgrService userMgrService = new UserMgrService();
//				userMgrService.updatePassword(tlrno, SystemConstant.DEFAULT_PASSWORD);
				TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
				
				//设置可用
				//tlrInfo.setSt(ReportEnum.REPORT__FH_ST.YES.value);
				//设置充值密码标识
				//tlrInfo.setRestFlg("reset");
				UserMgrService userMgrService = new UserMgrService();

				String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);

				userMgrService.updatePassword(tlrInfo.getTlrno(), sysDefaultPwd);
				globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"重置用户编号[" + tlrInfo.getTlrno() + "]的密码"});
				htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"重置用户编号[" + tlrInfo.getTlrno() + "]的密码"});
			
				
				
				
			}
			else{
			String tlrno = (String) context.getAttribute(IN_TLRNO);
			// 修改用户密码
//			UserMgrService userMgrService = new UserMgrService();
//			userMgrService.updatePassword(tlrno, SystemConstant.DEFAULT_PASSWORD);
			TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
			List<TlrBctlRel> bctlRellist = rootdao.queryByQL2List("from TlrBctlRel where tlrNo = '" + tlrno + "'");
			List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
			//授权机构
			RepList<TlrBctlRel> repBctlList = new RepList<TlrBctlRel>();
			for(TlrBctlRel tlrBctlRel : bctlRellist){
				repBctlList.add(tlrBctlRel);
			}
			//角色岗位
			RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
			for(TlrRoleRel tlrRoleRel : roleRellist){
				repRoleList.add(tlrRoleRel);
			}

			//设置修改中
			tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
			//设置充值密码标识
			tlrInfo.setRestFlg("reset");
			try {
				TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
				tlrInfoAuditBean.setTlrInfo(tlrInfo);
				tlrInfoAuditBean.setBctlRellist(repBctlList);
				tlrInfoAuditBean.setRoleRellist(repRoleList);
				SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
						ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
						//这儿得改成修改
						ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
						tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),tlrInfo.getSt());
				rootdao.saveOrUpdate(tskInf);
			} catch (IOException e) {
				ExceptionUtil.throwCommonException("操作员重置密码，双岗复核序列化到数据库出错！");
				e.printStackTrace();
			}
			rootdao.saveOrUpdate(tlrInfo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"重置用户编号[" + tlrInfo.getTlrno() + "]的密码"});
			htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"重置用户编号[" + tlrInfo.getTlrno() + "]的密码"});
			}} else if ("unlock".equals(context.getAttribute(CMD))) {// 解锁
				if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value)){
					
					String tlrno = (String) context.getAttribute(IN_TLRNO);
					TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
					

					//设置修改中
					//tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
					//String oldIsLock = tlrInfo.getIsLock();
					//解锁
					tlrInfo.setIsLock("0");
					
					//改回原值
					//tlrInfo.setIsLock(oldIsLock);
					rootdao.saveOrUpdate(tlrInfo);
					globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]解锁操作"});
					htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]解锁操作"});
				
					
				}	
				else{	
			String tlrno = (String) context.getAttribute(IN_TLRNO);
			TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
			List<TlrBctlRel> bctlRellist = rootdao.queryByQL2List("from TlrBctlRel where tlrNo = '" + tlrno + "'");
			List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
			//授权机构
			RepList<TlrBctlRel> repBctlList = new RepList<TlrBctlRel>();
			for(TlrBctlRel tlrBctlRel : bctlRellist){
				repBctlList.add(tlrBctlRel);
			}
			//角色岗位
			RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
			for(TlrRoleRel tlrRoleRel : roleRellist){
				repRoleList.add(tlrRoleRel);
			}

			//设置修改中
			tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
			String oldIsLock = tlrInfo.getIsLock();
			tlrInfo.setIsLock("0");
			try {
				TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
				tlrInfoAuditBean.setTlrInfo(tlrInfo);
				tlrInfoAuditBean.setBctlRellist(repBctlList);
				tlrInfoAuditBean.setRoleRellist(repRoleList);
				SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
						ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
						ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
						tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),tlrInfo.getSt());
				rootdao.saveOrUpdate(tskInf);
			} catch (IOException e) {
				ExceptionUtil.throwCommonException("操作员解锁，双岗复核序列化到数据库出错！");
				e.printStackTrace();
			}
			//改回原值
			tlrInfo.setIsLock(oldIsLock);
			rootdao.saveOrUpdate(tlrInfo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]解锁操作"});
			htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]解锁操作"});
		} }
			else if ("status".equals(context.getAttribute(CMD))) {// 有效/无效  强行签退
				
				if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value)){
					
					String tlrno = (String) context.getAttribute(IN_TLRNO);
					String status = (String) context.getAttribute(IN_PARAM);

					TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
					
					//设置修改中
					//tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
					//String oldFlag = tlrInfo.getFlag();
					//String oldStatus = tlrInfo.getStatus();

					if (SystemConstant.FLAG_ON.equals(status) || SystemConstant.FLAG_OFF.equals(status)) {
						tlrInfo.setFlag(status);
					} else if ("logout".equals(status)) {
						tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
					}
					
					//改回原值
					//tlrInfo.setFlag(oldFlag);
					//tlrInfo.setStatus(oldStatus);
					rootdao.saveOrUpdate(tlrInfo);
					if("logout".equals(status)){
						globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]强行签退操作"});
						htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]强行签退操作"});
					} else {
						globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]有效无效操作"});
						htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "有效无效操作"});
					}
				
					
					
					
					
					
				}
				else{
			String tlrno = (String) context.getAttribute(IN_TLRNO);
			String status = (String) context.getAttribute(IN_PARAM);

			TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
			List<TlrBctlRel> bctlRellist = rootdao.queryByQL2List("from TlrBctlRel where tlrNo = '" + tlrno + "'");
			List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
			//授权机构
			RepList<TlrBctlRel> repBctlList = new RepList<TlrBctlRel>();
			for(TlrBctlRel tlrBctlRel : bctlRellist){
				repBctlList.add(tlrBctlRel);
			}
			//角色岗位
			RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
			for(TlrRoleRel tlrRoleRel : roleRellist){
				repRoleList.add(tlrRoleRel);
			}

			//设置修改中
			tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
			String oldFlag = tlrInfo.getFlag();
			String oldStatus = tlrInfo.getStatus();

			if (SystemConstant.FLAG_ON.equals(status) || SystemConstant.FLAG_OFF.equals(status)) {
				tlrInfo.setFlag(status);
			} else if ("logout".equals(status)) {
				tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
			}
			try {
				TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
				tlrInfoAuditBean.setTlrInfo(tlrInfo);
				tlrInfoAuditBean.setBctlRellist(repBctlList);
				tlrInfoAuditBean.setRoleRellist(repRoleList);
				SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
						ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
						ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
						tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),tlrInfo.getSt());
				rootdao.saveOrUpdate(tskInf);
			} catch (IOException e) {
				if ("logout".equals(status)){
					ExceptionUtil.throwCommonException("操作员强行签退，双岗复核序列化到数据库出错！");
				} else {
					ExceptionUtil.throwCommonException("操作员有效无效，双岗复核序列化到数据库出错！");
				}
				e.printStackTrace();
			}
			//改回原值
			tlrInfo.setFlag(oldFlag);
			tlrInfo.setStatus(oldStatus);
			rootdao.saveOrUpdate(tlrInfo);
			if("logout".equals(status)){
				globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]强行签退操作"});
				htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]强行签退操作"});
			} else {
				globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]有效无效操作"});
				htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "有效无效操作"});
			}
		}
			}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}