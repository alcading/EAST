/**
 *
 */
package com.huateng.ebank.business.common.operator;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.dao.mng.CommLogDAO;
import com.huateng.ebank.entity.data.mng.CommLog;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: SaveORUpdateCommLogOP
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-5-9
 */
public class SaveORUpdateCommLogOP extends BaseOperation {

	public final static String COMM_LOG = "COMM_LOG";
	public final static String UPDATE_OR_INSERT_FLAG = "UPDATE_OR_INSERT_FLAG";
	public final static String TXN_FLAG = "TXN_FLAG";
	public final static String UPDATE_FLAG = "0";
	public final static String INSERT_FLAG = "1";
	public final static String QRY_FLAG = "2";
	public final static String QRYOUT = "QRYOUT";
	public final static String TXNDATE = "TXNDATE";
	public final static String ACCTTRACENO = "ACCTTRACENO";
	public final static String ID = "Common.SaveORUpdateCommLogOP";

	/* (non-Javadoc)
	 * @see com.huateng.ebank.framework.operation.BaseOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.huateng.ebank.framework.operation.BaseOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		CommLog commLog = (CommLog)context.getAttribute(COMM_LOG);
		String updOrIns = (String)context.getAttribute(UPDATE_OR_INSERT_FLAG);
		CommLogDAO commLogDAO = BaseDAOUtils.getCommLogDAO();
		if( StringUtils.equals(updOrIns, UPDATE_FLAG) ){
			commLogDAO.update(commLog);
		}else if( StringUtils.equals(updOrIns, INSERT_FLAG) ){
			commLogDAO.insert(commLog);
		}else{
			ExceptionUtil.throwCommonException("不支持此操作", ErrorCode.ERROR_CODE_INTERNAL_ERROR);
		}

	}

}
