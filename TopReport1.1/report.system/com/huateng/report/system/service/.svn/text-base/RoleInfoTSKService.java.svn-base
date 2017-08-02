package com.huateng.report.system.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import resource.bean.pub.RoleInfo;
import resource.bean.report.SysTaskInfo;
import resource.dao.pub.RoleInfoDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportEnum.REPORT_TASK_FUNCID;

/**
 * @author jianxue.zhang
 * @date 2008/7/2
 * @desc 岗位控制表service
 */
public class RoleInfoTSKService {
	private static final Logger logger = Logger.getLogger(RoleInfoTSKService.class);

	protected RoleInfoTSKService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static RoleInfoTSKService getInstance() {
		return (RoleInfoTSKService) ApplicationContextUtils
				.getBean("RoleInfoTSKService");
	}

	/**
	 * @author fubo
	 * @desc 岗位增删改
	 * @param insertList
	 * @param delList
	 * @param updateList
	 * @throws CommonException
	 */
	public void saveCustRole(List<RoleInfo> insertList, 
			List<RoleInfo> updateList) throws CommonException {
		RoleInfoDAO roleInfoDAO = BaseDAOUtils.getRoleInfoDAO();
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		//新增岗位
		TaskListService tls= TaskListService.getInstance();
		//不审核
		GlobalInfo  gi=GlobalInfo.getCurrentInstance();
		if(!tls.isNeedApprove(ReportEnum.REPORT_TASK_FUNCID.TASK_100299.value)){

			for (RoleInfo bean : insertList) {
				bean.setIsLock("0");
				bean.setSt(ReportEnum.REPORT__FH_ST.YES.value);
				roleInfoDAO.save(bean);
				//取出rolelist执行插入;
				String roleList=bean.getRoleList();
				tls.updateRoleFunc(bean.getId(), roleList);
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"角色的新增"});
			}

			//更新新岗位
			for (RoleInfo bean : updateList) {
				//先将数据库中的那条数据的状态更新:
				bean.setIsLock("0");
				bean.setSt(ReportEnum.REPORT__FH_ST.YES.value);
				roleInfoDAO.update(bean);
				String roleListNew = bean.getRoleList();
				// 获取菜单列表
				if (DataFormat.isEmpty(roleListNew)) {
					roleListNew = "";
				}
				tls.updateRoleFunc(bean.getId(), roleListNew);
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"角色的修改"});
				}
			
			
			
		}
		else{
		for (RoleInfo bean : insertList) {
			roleInfoDAO.save(bean);
			//取出rolelist执行插入;
			String roleList=bean.getRoleList();
			tls.updateRoleFunc(bean.getId(), roleList);
			//先保存
			String updCd= "01";
			String oldst="1";
			try {
				SysTaskInfo syst=ReportTaskUtil.getSysTaskInfoBean(REPORT_TASK_FUNCID.TASK_100299.value, updCd, bean, String.valueOf(bean.getId()), oldst);
				rootdao.saveOrUpdate(syst);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//更新新岗位
		for (RoleInfo bean : updateList) {
			//先将数据库中的那条数据的状态更新:
			RoleInfo roleInfo = null;
			roleInfo= roleInfoDAO.findById(bean.getId());
			//设为修改
			roleInfo.setSt("2");
			//设为锁定
			roleInfo.setIsLock("1");
			roleInfoDAO.update(roleInfo);
				String updCd= "02";
				String oldst="2";
				
				try {
					SysTaskInfo syst=ReportTaskUtil.getSysTaskInfoBean(REPORT_TASK_FUNCID.TASK_100299.value, updCd, bean, String.valueOf(bean.getId()), oldst);
					rootdao.saveOrUpdate(syst);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	}




