/**
 *
 */
package com.huateng.ebank.business.common.operator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class GetNextCoreReqSeqOP extends BaseOperation {

	 private static Log log = LogFactory.getLog(GetNextCoreReqSeqOP.class);

	 public final static String CORESYS_REQSEQ = "CORESYS_REQSEQ";

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
		int reqseq = CommonService.getInstance().getCoreReqSeq();
		System.out.println("reqseq=" + reqseq);
		/*
		String sReqseq = String.format("%06d", reqseq);
		System.out.println("sReqseq=" + sReqseq);
		*/
		context.setAttribute(CORESYS_REQSEQ, new Integer(reqseq));
	}
}
