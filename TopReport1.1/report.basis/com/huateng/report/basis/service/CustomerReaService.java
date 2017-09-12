package com.huateng.report.basis.service;


import java.util.ArrayList;
import java.util.List;

import resource.bean.report.BiAccount;
import resource.bean.report.BiCustomer;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class CustomerReaService  {
	private static final String DATASET_ID="com.huateng.report.basis.service.CustomerReaService";
	private static final HtLog htlog= HtLogFactory.getLogger(CustomerReaService.class);

	private ROOTDAO rootDao ;
	/**
	 *  获取实例
	 * @return
	 */
	public synchronized static CustomerReaService getInstance() {
		return (CustomerReaService) ApplicationContextUtils.getBean(DATASET_ID);
	}
	
	public PageQueryResult list(int pageSize,int pageIndex,String hqlString) throws CommonException {
		PageQueryResult pageQueryResult =null;
		PageQueryCondition pgc = new PageQueryCondition();
		pgc.setPageIndex(pageIndex);
		pgc.setPageSize(pageSize);
		pgc.setQueryString(hqlString);
		HQLDAO hqlDao = DAOUtils.getHQLDAO();
		pageQueryResult = hqlDao.pageQueryByQL(pgc);
		return  pageQueryResult;
	}
	
	public void delete(BiCustomer biCustomer) throws CommonException{
		
		rootDao = ROOTDAOUtils.getROOTDAO();		
		/*add by huangcheng  增加删除客户时如果客户存在账户则不能删除 作出提示*/			
		BiAccount biAccount = new BiAccount();
		List list = new ArrayList();
		list = rootDao.queryByQL2List("select bi from BiAccount bi where bi.customerId="+biCustomer.getId());
		if(list.size()>0){
				ExceptionUtil.throwCommonException("该用户下有账号不能删除" ,ErrorCode.ERROR_CODE_NORMAL);
			    return;
		}
		/*end*/
		try {
			rootDao.delete(biCustomer);

		} catch (Exception e) {
			// TODO: handle exception
			ExceptionUtil.throwCommonException("删除biCustomer实体类不存在");
		}
	}
	
	public void savaBiCustomer(BiCustomer biCustomer) throws CommonException {
		rootDao = ROOTDAOUtils.getROOTDAO();
		if(isExists(biCustomer.getId())){
			ExceptionUtil.throwCommonException("新增客户实体类已存在",ErrorCode.ERROR_CODE_DUP_INSERT);
		}
		try {
			rootDao.save(biCustomer);
		} catch (Exception e) {
			// TODO: handle exception
			htlog.error("insert biCustomer error ");
			ExceptionUtil.throwCommonException("保存biCustomer实体类失败记录已存在");
		}
	}
	
	private Boolean isExists(String id) {
		rootDao = ROOTDAOUtils.getROOTDAO();
		BiCustomer bi;
		try {
			bi = rootDao.query(BiCustomer.class,id);
			if(bi ==null){
				return false;
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			htlog.info(this.getClass().getName()+"判断实体是否重复出错");
			e.printStackTrace();
		}
		
		return true;
	}
	
	public void UpdateBiCustomer(BiCustomer biCustomer) throws CommonException{
		rootDao = ROOTDAOUtils.getROOTDAO();
		try {
			rootDao.update(biCustomer);
		} catch (Exception e) {
			// TODO: handle exception
			ExceptionUtil.throwCommonException("更新biCustomer失败记录不存在");
		}
	}
	

}
