/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.ebank.business.common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: ConfigReader
 * Description: 读取配置文件
 * Copyright: Copyright (c) 2010
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class CommonConfigReader {
	private static Logger log = Logger.getLogger(CommonConfigReader.class.getName());

	private CommonConfigReader() {
	}

	public static String getProperty(String bundleName,String key)throws CommonException{
		ResourceBundle resourceBundle = ResourceBundle.getBundle(bundleName);
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			ExceptionUtil.throwCommonException("配置文件错误，没有找到[" + key + "]属性参数", ErrorCode.ERROR_CODE_INTERNAL_ERROR);
			return null;
		}
	}
}