package com.huateng.ebank.business.common.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import resource.bean.pub.DepartmentInfo;
import resource.dao.pub.DepartmentInfoDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author tanyang
 * @date 2010-10-28
 * @desc 部门控制表访问service
 */

public class DepartmentInfoService {
	/**
	 * Logger for this class
	 */

	private static final Logger logger = Logger.getLogger(DepartmentInfoService.class);

	private DepartmentInfo headDepartment = null;

	private Object headDepartmentLocker = new Object();

	/**
	 * Default constructor
	 */

	protected DepartmentInfoService(){

	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static DepartmentInfoService getInstance(){
		return (DepartmentInfoService)ApplicationContextUtils.getBean(DepartmentInfoService.class.getName());
	}

	/**
	 * 得到所有有效的部门
	 * @return
	 * @throws CommonException
	 */
	public List getAllEnableDepartment()throws CommonException{
		DepartmentInfoDAO departmentInfoDAO = BaseDAOUtils.getDepartmentInfoDAO();
		List list = departmentInfoDAO.queryByCondition("po.status='"+SystemConstant.VALID_FLAG_VALID+"' order by po.departmentCode desc");
		return list;

	}

	/**
	 * 得到当前机构下所有有效的部门
	 * @param currentCode
	 * @return
	 * @throws CommonException
	 */
	public List getAllEnableDepartment(String currentCode)throws CommonException{
		DepartmentInfoDAO departmentInfoDAO = BaseDAOUtils.getDepartmentInfoDAO();
		List list = departmentInfoDAO.queryByCondition("po.brcode='"+currentCode+"' and po.status='"+SystemConstant.VALID_FLAG_VALID+"' order by po.departmentCode desc");
		return list;

	}

	/**
	 * 增删改部门信息
	 *
	 * @author tanyang
	 * @param custcd
	 * @param insertList
	 * @param updateList
	 * @param delList
	 * @throws CommonException
	 */

	public void departmentInfo(List insertList, List updateList, List delList)
	throws CommonException {
		DepartmentInfoDAO departmentInfoDAO = BaseDAOUtils.getDepartmentInfoDAO();

		// 删除操作.把状态设置为无效
		for (Iterator it = delList.iterator(); it.hasNext();) {
			DepartmentInfo departmentInfo = (DepartmentInfo)it.next();
			DepartmentInfo departmentInfoDel = departmentInfoDAO.query(departmentInfo.getDepartmentCode());
			if(null!=departmentInfoDel){
				departmentInfoDel.setStatus(SystemConstant.FLAG_OFF);
				departmentInfoDel.setLastUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
				departmentInfoDel.setLastUpdDate(GlobalInfo.getCurrentInstance().getTxdate());
				departmentInfoDAO.update(departmentInfoDel);
			}
		}
		// 修改操作
		for(Iterator it = updateList.iterator();it.hasNext();){
			DepartmentInfo departmentInfo = (DepartmentInfo)it.next();
			DepartmentInfo departmentModify = departmentInfoDAO.query(departmentInfo.getDepartmentCode());
			if(null!=departmentModify){
				departmentModify.setDepartmentName(departmentInfo.getDepartmentName());
				departmentModify.setBrcode(departmentInfo.getBrcode());
				departmentModify.setBZ(departmentInfo.getBZ());
				departmentModify.setLastUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
				departmentModify.setLastUpdDate(GlobalInfo.getCurrentInstance().getTxdate());
				departmentInfoDAO.update(departmentModify);
			}
		}

		for(Iterator it = insertList.iterator(); it.hasNext();){
			DepartmentInfo departmentInfo = (DepartmentInfo)it.next();
			List list = departmentInfoDAO.queryByCondition("po.departmentName = '" + departmentInfo.getDepartmentName()
					+ "'" + " and po.brcode = '"+departmentInfo.getBrcode()+"'" +" and po.status = " + SystemConstant.VALID_FLAG_VALID);
			if(list.size()>0){//已存在不能添加
				ExceptionUtil.throwCommonException("同一机构下已存在相同部门",ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			else{
				departmentInfo.setStatus(SystemConstant.FLAG_ON);
				departmentInfo.setLastUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
				departmentInfo.setLastUpdDate(GlobalInfo.getCurrentInstance().getTxdate());
				departmentInfoDAO.insert(departmentInfo);
			}
		}
	}
}
