/*
 * Created on 2004-10-12
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.huateng.service.pub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import resource.bean.pub.TlrLoginLog;
import resource.dao.base.HQLDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TlrLoginLogService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TlrLoginLogService.class);

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static TlrLoginLogService getInstance() {
		return (TlrLoginLogService) ApplicationContextUtils.getBean(TlrLoginLogService.class.getName());
	}

	public TlrLoginLogService() {
	}

	public void saveTlrLoginLog(String opType, boolean successFlag, String remark) throws CommonException {
		HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		if (opType.equals("login")) {
			TlrLoginLog tlrLoginLog = new TlrLoginLog();
			tlrLoginLog.setId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
			tlrLoginLog.setBrNo(gi.getBrno());
			tlrLoginLog.setCrtTm(new Date());
			tlrLoginLog.setLoginAddr(gi.getIp());
			if(successFlag){
				tlrLoginLog.setLoginSucTm(new Date());
			} else {
				tlrLoginLog.setLoginFailTm(new Date());
			}
			tlrLoginLog.setSessionId(gi.getSessionId());
			tlrLoginLog.setTlrNo(gi.getTlrno());
			tlrLoginLog.setLoginRemark(remark);
			try {
				hqldao.getHibernateTemplate().save(tlrLoginLog);
			} catch (Exception e) {
				logger.error("update(TlrInfo)", e);
				ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
			}
		} else {
			String sessionId = gi.getSessionId();
			List<TlrLoginLog> list = hqldao.queryByQL2List("from TlrLoginLog where sessionId='" + sessionId +
					"' and crtTm=(select max(log.crtTm) from TlrLoginLog log where sessionId='" + sessionId + "')");
			try {
				if (list.size() > 0) {
					TlrLoginLog tlrLoginLog = list.get(0);
					tlrLoginLog.setLoginOutTm(new Date());
					hqldao.getHibernateTemplate().saveOrUpdate(tlrLoginLog);
				}
			} catch (Exception e) {
				logger.error("update(TlrInfo)", e); //$NON-NLS-1$
				ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
			}
		}
	}

	public PageQueryResult queryTlrLoginLOg(int pageIndex, int pageSize,
			String qtlrNo, String qbrNo, String qloginAddr, String startDate,
			String endDate) throws CommonException {
		StringBuffer sb = new StringBuffer("");
		List<Object> list=new ArrayList<Object>();
		sb.append("select log from TlrLoginLog log where 1=1");
		if(!DataFormat.isEmpty(qtlrNo)){
			sb.append(" and log.tlrNo = ? ");
			list.add(qtlrNo);
		}
		if(!DataFormat.isEmpty(qbrNo)){
			sb.append(" and log.brNo = ? ");
			list.add(qbrNo);
		}
		if(!DataFormat.isEmpty(qloginAddr)){
			sb.append(" and log.loginAddr = ? ");
			list.add(qloginAddr);
		}
		if(!DataFormat.isEmpty(startDate)){
			sb.append(" and log.crtTm>=? ");
			list.add(DateUtil.stringToDate2(startDate));
		}
		if(!DataFormat.isEmpty(endDate)){
			sb.append(" and log.crtTm<? ");
			list.add(DateUtil.getStartDateByDays(DateUtil.stringToDate2(endDate), -1));
		}
		sb.append(" order by log.crtTm desc ");
		HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(list.toArray());
		PageQueryResult pageQueryResult = hqldao.pageQueryByQL(queryCondition);
		return pageQueryResult;
	}

	public void saveTlrLoginExceptionLog(String userName, String brCode, String ip, String sessionId) throws CommonException {
		HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
		TlrLoginLog tlrLoginLog = new TlrLoginLog();
		tlrLoginLog.setId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		tlrLoginLog.setBrNo(brCode);
		tlrLoginLog.setCrtTm(new Date());
		tlrLoginLog.setLoginAddr(ip);
		tlrLoginLog.setLoginFailTm(new Date());
		tlrLoginLog.setSessionId(sessionId);
		tlrLoginLog.setTlrNo(userName);
		tlrLoginLog.setLoginRemark("系统异常");
		try {
			hqldao.getHibernateTemplate().save(tlrLoginLog);
		} catch (Exception e) {
			logger.error("update(TlrInfo)", e);
			ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}
	}


	public PageQueryResult queryTlrLogDetail(int pageIndex, int pageSize,
			String qtlrNo, String qbrNo,String stdate,String endate) throws CommonException {
		StringBuffer sb = new StringBuffer("");
		List<Object> list=new ArrayList<Object>();
		//sb.append("select log from TlrLoginLog log where 1=1");
		sb.append("select  distinct tl.tlrNo ,tl.brNo, " +
				"count(tl.tlrNo),max(tl.crtTm) , min(tl.crtTm) " +
				"  from   TlrLoginLog tl  where 1=1  " );
		if(!DataFormat.isEmpty(qtlrNo)){
			sb.append(" and  tl.tlrNo= ? ");
			list.add(qtlrNo);
		}
		if(!DataFormat.isEmpty(qbrNo)){
			sb.append(" and tl.brNo = ? ");
			list.add(qbrNo);
		}

		if(!DataFormat.isEmpty(stdate)){
			sb.append(" and tl.crtTm>=? ");
			list.add(DateUtil.stringToDate2(stdate));
		}
		if(!DataFormat.isEmpty(endate)){
			sb.append(" and tl.crtTm<? ");
			list.add(DateUtil.getStartDateByDays(DateUtil.stringToDate2(endate), -1));
		}


		sb.append(" group  by  tl.tlrNo ,tl.brNo");

		HQLDAO hqldao = BaseDAOUtils.getHQLDAO();


		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(sb.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(list.toArray());
		PageQueryResult pageQueryResult = hqldao.pageQueryByQL(queryCondition);
		return pageQueryResult;
	}

	

}
