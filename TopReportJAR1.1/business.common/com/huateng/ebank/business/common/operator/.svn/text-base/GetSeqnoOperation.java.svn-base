package com.huateng.ebank.business.common.operator;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.generator.GeneratorFactory;
import com.huateng.ebank.business.common.generator.GetSeqnoGenerator;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: com.huateng.ebank.business.common.operation.GetSeqnoOperation.java
 * Description: 获取序列号
 * Copyright (c) 2006 Company: Shanghai　Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version v1.0,2008-11-6
 */
public class GetSeqnoOperation extends BaseOperation {

	private static final Logger log = Logger.getLogger(GetSeqnoOperation.class);

	public final static String ID = "Common.GetSeqnoOperation";
	public final static String VALUE_NO = "VALUE_NO";
	public final static String VALUE_INDEX= "VALUE_INDEX";
	public final static String SEQNO  = "SEQNO";

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		try{
			int valueNo = ((Integer)context.getAttribute(VALUE_NO)).intValue();
			String valueIndex = (String)context.getAttribute(VALUE_INDEX);
			GetSeqnoGenerator getSeqnoGenerator = (GetSeqnoGenerator) GeneratorFactory.getGenerator("GetSeqnoGenerator");
			Map paramMap = new HashMap();
			paramMap.put("valueNo", new Integer(valueNo));
			paramMap.put("valueIndex", valueIndex);
			int seqno = Integer.parseInt(getSeqnoGenerator.gen(paramMap));
			context.setAttribute(SEQNO, new Integer(seqno));
		}catch(CommonException ex){
			throw ex;
		}catch(Exception ex){
			log.error("生成序列号错误", ex);
			ExceptionUtil.throwCommonException("生成序列号错误",ErrorCode.ERROR_CODE_INTERNAL_ERROR,ex);
		}
	}

}
