package com.huateng.ebank.business.common.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


public class RoleSelectGetter extends BaseGetter {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */

	@Override
	public Result call() throws AppException {
//		// TODO Auto-generated method stub
//		List list = new ArrayList();
////
////		String value = DataFormat.trim(getCommQueryServletRequest()
////				.getParameter("value"));
////		int pageSize = this.getResult().getPage().getEveryPage();
////		int pageIndex = this.getResult().getPage().getCurrentPage();
//		/*Modified By Hanziyang 20100422  现在此SELECT需考虑登录的CUSTID begin*/
//		String custId = (String)getCommQueryServletRequest().getParameter("custId");
//		if(!DataFormat.isEmpty(custId)){
//			GlobalInfo gd = GlobalInfo.getCurrentInstance();
////			gd.setCustId(Integer.valueOf(custId));
//			GlobalInfo.setCurrentInstance(gd);
//		}
//
//		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//		int custid =0;// globalInfo.getCustId();//GlobalInfo中去掉了custId，编译不通过，所以注释掉！！！做该模块的人请修改该代码！！----涂缘
//
//		list = BaseDAOUtils.getRoleInfoDAO().findByStatus(SystemConstant.VALID_FLAG_VALID);
//		list = BaseDAOUtils.getRoleInfoDAO().queryByCondition(" po.custid = "
//				+ custid +" and po.status = '" + SystemConstant.VALID_FLAG_VALID + "'");
//		list = BaseDAOUtils.getRoleInfoDAO().findByStatus(SystemConstant.VALID_FLAG_VALID);
//		list = BaseDAOUtils.getRoleInfoDAO().queryByCondition(" po.custid = "
//				+ custId +" and po.status = '" + SystemConstant.VALID_FLAG_VALID + "'");
//		/*Modified By Hanziyang 20100422  现在此SELECT需考虑登录的CUSTID end*/
//		ResultMng.fillResultByList(getCommonQueryBean(),
//				getCommQueryServletRequest(), list, getResult());
//		getResult().setContent(list);
//		getResult().getPage().setTotalPage(1);
//		getResult().init();
//		return getResult();
		
		// TODO Auto-generated method stub
		List list = new ArrayList();
//
//		String value = DataFormat.trim(getCommQueryServletRequest()
//				.getParameter("value"));
//		int pageSize = this.getResult().getPage().getEveryPage();
//		int pageIndex = this.getResult().getPage().getCurrentPage();

		list = BaseDAOUtils.getRoleInfoDAO().findByStatus(SystemConstant.VALID_FLAG_VALID);


		ResultMng.fillResultByList(getCommonQueryBean(),
				getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

}
