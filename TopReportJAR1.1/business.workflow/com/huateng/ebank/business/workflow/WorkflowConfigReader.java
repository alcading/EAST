/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.ebank.business.workflow;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: ConfigReader
 * Description: 璇诲彇閰岖疆鏂囦欢workflow.properties
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-5-9
 */
public class WorkflowConfigReader {
	private static Logger log = Logger.getLogger(WorkflowConfigReader.class.getName());

	private static final String BUNDLE_NAME = WorkFlowConstants.WORKFLOW_PROPERTIES;

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private WorkflowConfigReader() {
	}

	public static String getWorkflowProperty(String key)throws CommonException{
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			log.error(e);
			ExceptionUtil.throwCommonException("宸ヤ綔娴侀厤缃枃浠堕敊璇紝娌℃湁镓惧埌[" + key + "]镄勬祦绋??", ErrorCode.ERROR_CODE_INTERNAL_ERROR);
			return null;
		}
	}
}