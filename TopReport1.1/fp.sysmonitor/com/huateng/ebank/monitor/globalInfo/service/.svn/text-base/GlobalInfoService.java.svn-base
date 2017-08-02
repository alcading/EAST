package com.huateng.ebank.monitor.globalInfo.service;

import java.util.Date;
import java.util.List;

import resource.bean.pub.Globalinfo;
import resource.dao.pub.GlobalinfoDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;

/**
 * globalinfo
 * @author wangpeng
 *
 */
public class GlobalInfoService {
	protected GlobalInfoService() {
	}

	/* get instance */
	public static synchronized GlobalInfoService getInstance() {
		return (GlobalInfoService) ApplicationContextUtils
				.getBean(GlobalInfoService.class.getName());
	}
	
	/***/
	public Globalinfo getCurrentGlobalInfo(){
		GlobalinfoDAO dao=BaseDAOUtils.getGlobalinfoDAO();
		List result=dao.findByProperty("SystemType","01");
		return (Globalinfo)result.get(0);
	}
	
	/**
	 * 数据分析成功后，切换系统日期到下个月月底
	 * @author xuhong 2015-3-23
	 * @return true-成功 false-失败
	 */
	public boolean changeSysDate(){
		GlobalinfoDAO dao=BaseDAOUtils.getGlobalinfoDAO();
		Globalinfo globalinfo = dao.findById(1);
		if(globalinfo!=null){
			Date tbsdy = globalinfo.getTbsdy();
			Date bhdate = globalinfo.getBhdate();
			Date lbhdate = globalinfo.getLbhdate();
			
			lbhdate = tbsdy;
			/*modified by xuhong 20160331 将原来的切到下月改为每日切begin*/
			//tbsdy = DateUtil.getNextLastDate(tbsdy);
			tbsdy = DateUtil.getNextDay(tbsdy);
			/*modified by xuhong 20160331 将原来的切到下月改为每日切begin*/
			bhdate = tbsdy;
			
			globalinfo.setTbsdy(tbsdy);
			globalinfo.setBhdate(bhdate);
			globalinfo.setLbhdate(lbhdate);
			
			try {
				dao.update(globalinfo);
			} catch (CommonException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
}
