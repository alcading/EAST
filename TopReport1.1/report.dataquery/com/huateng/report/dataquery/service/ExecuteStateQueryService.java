package com.huateng.report.dataquery.service;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.pub.Bctl;
import resource.bean.report.BiProcessLog;
import resource.dao.base.HQLDAO;
import resource.dao.pub.BctlDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.service.AnalyProService;

public class ExecuteStateQueryService {
//	private List<ExecuteStateQueryBean> list = new ArrayList<ExecuteStateQueryBean>();
//	{
//		ExecuteStateQueryBean bean1 = new ExecuteStateQueryBean("999999", "总行",
//				new SimpleDateFormat("yyyyMMdd").format(new Date()), "数据导入", "上报数据", new Date(System.currentTimeMillis()-24*60*60*1000), new Date(System.currentTimeMillis()-1000));
//		ExecuteStateQueryBean bean2 = new ExecuteStateQueryBean("111111", "分行", new SimpleDateFormat("yyyy-MM-dd").format(new Date()), "补录", "补录数据", new Date(System.currentTimeMillis()-24*60*60*1000), new Date(System.currentTimeMillis()-1000));
//		list.add(bean1);
//		list.add(bean2);
//	}
	/*
	 * 获得自身实例
	 */
	public synchronized static ExecuteStateQueryService getInstance() {
		return (ExecuteStateQueryService) ApplicationContextUtils.getBean(ExecuteStateQueryService.class.getName());
	}

//	/*
//	 * 分页服务
//	 */
//	public List<ExecuteStateQueryBean> pageQueryByHql(String hql) {
//		// TODO Auto-generated method stub
//		return getTestDataSet();
//	}

	@SuppressWarnings("unchecked")
	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize, String hql) throws CommonException {

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult result =  hqlDAO.pageQueryByQL(queryCondition);
		List list = result.getQueryResult();
		for(Iterator iter = list.iterator(); iter.hasNext();){
			BiProcessLog log = (BiProcessLog)(((Object[])iter.next())[0]);
			log.setBrName(AnalyProService.getInstance().getBrName("'"+log.getBrNo()+"'"));
		}
		return result;
	}

	/*
	 * 根据机构号brno查询机构名称brname
	 *
	 */
	public String getBrno(String brname) {
		BctlDAO dao = ROOTDAOUtils.getBctlDAO();
		try {
			List<Bctl> list = null;
			brname = StringUtils.trim(brname);
			if(StringUtils.isNotBlank(brname)) {
				list = dao.queryByCondition(" po.brname LIKE '%" + brname+ "%' ");
			}
			if(list.size() == 0 ) {
				return null;
			}
			return list.get(0).getBrno();
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public List<ExecuteStateQueryBean> getTestDataSet() {
//		return list;
//	}
}
