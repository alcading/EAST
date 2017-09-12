package com.huateng.report.basis.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import resource.bean.report.BiDayexchangerate;
import resource.bean.report.SysTaskInfo;
import resource.bean.report.SysTaskLog;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.basis.bean.BiDayExchangeRateDetail;
import com.huateng.report.basis.service.BiDayExchangeRateService;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;
/**
 *
 * author  by  计翔 2012.9.5
 * 外汇维护日币的getter
 */
public class BiDayExchangeRateDetailGetter  extends BaseGetter{
	public Result call() throws AppException {
	String action = this.getCommQueryServletRequest().getParameter("action");
	List list = new ArrayList();
	String id= this.getCommQueryServletRequest().getParameter("id");
	String st= this.getCommQueryServletRequest().getParameter("st");

	String flag=this.getCommQueryServletRequest().getParameter("flag");
	String  tskId=this.getCommQueryServletRequest().getParameter("tskId");

	try {

		 if("detail".equals(action)){

			//从审计任务中获取
			 ReportTaskUtil  rt=new ReportTaskUtil();
			 if("0".equals(flag)){

	            Iterator  it=ReportShowDetailService.getInstance().selectByKey(id);
			    Class cls=null;
			    BiDayExchangeRateDetail  ber=new BiDayExchangeRateDetail();
				BiDayexchangerate  oldbean=(BiDayexchangerate) BiDayExchangeRateService.getInstance().selectById(id);
			    BiDayexchangerate  newBean=null;
				ber.setOld_bidayexchangerate(oldbean);

	         while(it.hasNext()){
	        	 SysTaskInfo tem=(SysTaskInfo)it.next();
	        	 Object temp=rt.getObjctBySysTaskInfo(tem);
	        	 cls= temp.getClass();
	        	 if(cls.equals(	BiDayexchangerate.class)){
	        	 newBean=(BiDayexchangerate)temp;
	        	}

	     }

				ber.setBidayexchangerate(newBean);
				list.add(ber);
		}
			 else if("1".equals(flag)){
				  SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
				  BiDayexchangerate oldValue=null;
				  BiDayexchangerate  newValue=null;
				  BiDayExchangeRateDetail biday=new 	BiDayExchangeRateDetail();


				  if(systasklog.getOldVal1()!=null){

					  oldValue=(BiDayexchangerate)rt.getOldObjectByTaskLog(systasklog);

				  }
				  if(systasklog.getNewVal1()!=null){

				  newValue= (BiDayexchangerate)rt.getNewObjectByTaskLog(systasklog);

				  }
				  //新增的时候
				  if(st.equals("1")){
					  biday.setOld_bidayexchangerate(newValue);

				  }
				  //修改的时候
				  else if(st.equals("2")){
					  biday.setBidayexchangerate(newValue);
					  biday.setOld_bidayexchangerate(oldValue);
				  }
				  //删除的时候
				  else if(st.equals("3")){
					  biday.setOld_bidayexchangerate(oldValue);
				  }


				  list.add(biday);

			 }

		 }
		ResultMng.fillResultByList(getCommonQueryBean(),
				getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		

		return getResult();
	} catch (CommonException e) {
		throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, e.getMessage());
	} catch (AppException appEx) {
		throw appEx;
	} catch (Exception ex) {
		throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
	}

}

}
