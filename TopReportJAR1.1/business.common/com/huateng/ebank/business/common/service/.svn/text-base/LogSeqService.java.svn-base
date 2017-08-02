/**
 *
 */
package com.huateng.ebank.business.common.service;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.operator.GetNextCoreReqSeqOP;
import com.huateng.ebank.business.common.operator.SaveORUpdateCommLogOP;
import com.huateng.ebank.entity.dao.mng.BizLogDAO;
import com.huateng.ebank.entity.data.mng.BizLog;
import com.huateng.ebank.entity.data.mng.CommLog;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.operation.SingleOPCaller;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: LogSeqService
 * Description: 日志流水服务(记录BizLog,CommLog,获取操作员流水号，获取主机流水号等)
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-5-8
 */
public class LogSeqService {

	/**
	 * Get instance of log seq service
	 *
	 * @return
	 */
	public synchronized static LogSeqService getInstance() {
		return (LogSeqService)ApplicationContextUtils.getBean(LogSeqService.class.getName());
	}

	/**
	 * 保存BizLog日志信息
	 * @param bizLog
	 * @throws CommonException
	 */
	public void saveBizLog(BizLog bizLog)throws CommonException{
		  BizLogDAO bizLogDAO = BaseDAOUtils.getBizLogDAO();
	      bizLogDAO.insert(bizLog);
	}

	/**
	 * 保存通讯日志信息
	 * @param commLog
	 * @return
	 * @throws CommonException
	 */
	public CommLog saveCommLog(CommLog commLog)throws CommonException{
		OperationContext context = new OperationContext();
		context.setAttribute(SaveORUpdateCommLogOP.COMM_LOG,commLog);
		context.setAttribute(SaveORUpdateCommLogOP.UPDATE_OR_INSERT_FLAG, SaveORUpdateCommLogOP.INSERT_FLAG);
		SingleOPCaller.call("Common.SaveORUpdateCommLogOP", context);
		return commLog;
	}

	/**
	 * 更新通讯日志信息
	 * @param commLog
	 * @return
	 * @throws CommonException
	 */
	public CommLog updateCommLog(CommLog commLog)throws CommonException{
		OperationContext context = new OperationContext();
		context.setAttribute(SaveORUpdateCommLogOP.COMM_LOG,commLog);
		context.setAttribute(SaveORUpdateCommLogOP.UPDATE_OR_INSERT_FLAG, SaveORUpdateCommLogOP.UPDATE_FLAG);
		SingleOPCaller.call("Common.SaveORUpdateCommLogOP", context);
		return commLog;
	}

	/**
	 * 获取当前操作员的流水号
	 * @return
	 * @throws CommonException
	 */
	public int getNextTlrMsrno()throws CommonException{
			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			String tlrno = DataFormat.trim(globalInfo.getTlrno());
			resource.dao.pub.TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
			resource.bean.pub.TlrInfo tlrinfo = tlrInfoDAO.query(tlrno);
			if (tlrinfo == null)
				ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_NOT_EXIST);
			tlrinfo.setMsrno( new Integer(tlrinfo.getMsrno().intValue()+ 1));
			tlrInfoDAO.update(tlrinfo);
			return tlrinfo.getMsrno().intValue();
	}

	/**
	 * 获取核心流水号
	 * @return
	 * @throws CommonException
	 */
	public int getNextCoreSeq()throws CommonException{
		OperationContext context = new OperationContext();
		SingleOPCaller.call("Common.GetNextCoreReqSeqOP", context);
		Integer seq = (Integer)context.getAttribute(GetNextCoreReqSeqOP.CORESYS_REQSEQ);
		return seq.intValue();
	}

}
