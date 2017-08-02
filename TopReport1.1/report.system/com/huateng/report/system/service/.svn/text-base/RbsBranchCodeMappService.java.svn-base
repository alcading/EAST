package com.huateng.report.system.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.RbsBranchCodeMapp;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

//机构信息维护service,用到的实体：RbsBranchCodeMapp
public class RbsBranchCodeMappService {

	/**
	 * //获得自身实例
	 * 
	 * @return
	 */
	public synchronized static RbsBranchCodeMappService getInstance() {
		return (RbsBranchCodeMappService) ApplicationContextUtils
				.getBean(RbsBranchCodeMappService.class.getName());
	}


	/**
	 * 分页服务
	 * @param pageIndex
	 * @param maxRows
	 * @param qrbsbranchcode
	 * @param qbusitype
	 * @param qbranchcode
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult pageQueryByHql(int pageIndex, int maxRows,
			String qrbsbranchcode, String qbusitype, String qbranchcode)
			throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer buff = new StringBuffer();
		buff.append(" from RbsBranchCodeMapp rbs where 1 = 1 ");
		if (StringUtils.isNotBlank(qrbsbranchcode)) {
			buff.append(" and rbs.rbsbranchcode like ?");
			objs.add("%"+qrbsbranchcode+"%");
		}
		if (StringUtils.isNotBlank(qbusitype)) {
			buff.append(" and rbs.busitype = ?");
			objs.add(qbusitype);
		}
		if (StringUtils.isNotBlank(qbranchcode)) {
			buff.append(" and rbs.branchcode like ?");
			objs.add("%"+qbranchcode+"%");
		}
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setObjArray(objs.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(maxRows);
		queryCondition.setQueryString(buff.toString());
		return dao.pageQueryByQL(queryCondition);
	}


	public void rbs_add(RbsBranchCodeMapp bean) throws CommonException {
		// TODO Auto-generated method stub
		//新增
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//判断是否已经存在机构+业务类型
		boolean flag = hasExistsThisRbsBranchcode(bean.getBusitype(), bean.getRbsbranchcode());
		if(flag) {
			ExceptionUtil.throwCommonException("该机构已经存在,不能保存!");
		}
		bean.setId(ReportUtils.getUUID());
		bean.setCrtTm(new Date());
		bean.setCrtTlr(globalInfo.getTlrno());
		bean.setLstUpdTlr(globalInfo.getTlrno());
		bean.setLstUpdTm(new Date());
		dao.save(bean);
	}


	public void rbs_mod(RbsBranchCodeMapp bean) throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//判断是否修改的时候改变以后的rbsbranchcode+busitype是否在表中已经存在
		//boolean flag = hasExistsThisRbsBranchcode(bean.getBusitype(), bean.getRbsbranchcode());
		RbsBranchCodeMapp beanInTable = dao.query(RbsBranchCodeMapp.class, bean.getId());
		if(!bean.getBusitype().equalsIgnoreCase(beanInTable.getBusitype()) || !bean.getRbsbranchcode().equalsIgnoreCase(beanInTable.getRbsbranchcode())) {
			//被改动过,判断是否在表中存在
			boolean flag = hasExistsThisRbsBranchcode(bean.getBusitype(), bean.getRbsbranchcode());
			if(flag) {
				//已经存在，不让修改
				String key = "要保存的RBS机构号["+bean.getRbsbranchcode()+"],"+"业务类型：[";
				String bop = TopReportConstants.REPORT_BUSITYPE_BOP.equalsIgnoreCase(bean.getBusitype()) ? "BOP" : bean.getBusitype();
				key += (bop+"]在表中已经存在,无法保存!");
				ExceptionUtil.throwCommonException(key);
			}
		}
		//beanInTable已经是托管对象，bean不能被同一个session保存
		beanInTable.setBusitype(bean.getBusitype());
		beanInTable.setRbsbranchcode(bean.getRbsbranchcode());
		beanInTable.setBranchcode(bean.getBranchcode());
		beanInTable.setStatus(bean.getStatus());
		beanInTable.setLstUpdTlr(globalInfo.getTlrno());
		beanInTable.setLstUpdTm(new Date());
		dao.update(beanInTable);
	}

	/**
	 * 设置有效性
	 * @param bean
	 * @throws CommonException
	 */
	public void rbs_valid(RbsBranchCodeMapp bean) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();

		bean.setLstUpdTlr(globalInfo.getTlrno());
		bean.setLstUpdTm(new Date());
		dao.update(bean);
	}
	
	//需要验证rbs机构号是否已经存在，如果存在，不能插入，也不能修改该rbs机构号(业务类型+rbs机构号)
	
	public boolean hasExistsThisRbsBranchcode(String busitype,String rbsBranchcode) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		String hql = "select count(rbs) from RbsBranchCodeMapp rbs where 1 = 1 ";
		hql += (" and busitype ='"+(busitype != null ? busitype : "")+"'");
		hql += (" and rbsbranchcode ='"+(rbsBranchcode != null ? rbsBranchcode : "")+"'");
		int count = dao.queryByHqlToCount(hql);
		return count == 0 ? false : true;
	}
	
	public Map queryBCMapping(String busiCode) throws CommonException
	{
		String hql = " from RbsBranchCodeMapp rbs where 1 = 1 and  busitype='"+busiCode+"' and status='1' ";
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List list = dao.queryByQL2List(hql);
		Map rbsBcMap = new HashMap();
		for(Object rbsBC : list)
		{
			RbsBranchCodeMapp rbsBCTemp = (RbsBranchCodeMapp)rbsBC;
			rbsBcMap.put(rbsBCTemp.getRbsbranchcode(), rbsBCTemp.getBranchcode());
		}
		
		return rbsBcMap;
	}
	
}
