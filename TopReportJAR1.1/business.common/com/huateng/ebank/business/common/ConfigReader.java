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
 * Description: 读取配置文件gd.properties。
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-5-9
 */
public class ConfigReader {
	private static Logger log = Logger.getLogger(ConfigReader.class.getName());

	private static final String BUNDLE_NAME = SystemConstant.CONFFILENAME;

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private static final String GZBUNDLE_NAME = SystemConstant.GZCONFFILENAME;


	private ConfigReader() {
	}

	public static String getProperty(String key)throws CommonException{
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			ExceptionUtil.throwCommonException("配置文件错误，没有找到[" + key + "]属性参数", ErrorCode.ERROR_CODE_INTERNAL_ERROR);
			return null;
		}
	}
	public static String getGProperty(String key)throws CommonException{
		try {
			 ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(GZBUNDLE_NAME);
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			ExceptionUtil.throwCommonException("配置文件错误，没有找到[" + key + "]属性参数", ErrorCode.ERROR_CODE_INTERNAL_ERROR);
			return null;
		}
	}
}