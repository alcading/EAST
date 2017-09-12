/**
 *
 */
package com.huateng.ebank.business.workflow;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ConfigReader;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
/**
 * Title: WorkFlowParamConfigReader
 * Description: 读取配置文件workflowparam.properties。
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author chen_maik
 * @version 1.1, 2008-8-24
 */
public class WorkFlowParamConfigReader {

	private static Logger log = Logger.getLogger(WorkFlowParamConfigReader.class.getName());

//	private static final String BUNDLE_NAME = SystemConstant.WORK_FLOW_PARAM_CONFFILENAME;
	private static String bundle_name ;
	static{
    	try{
    		bundle_name=ConfigReader.getProperty("gd.workflow.param");;//用于流程参数文件配置,可参考gd.properties

    	}catch(Exception ex){
    		throw new RuntimeException(ex);
    	}
    }

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(bundle_name);
	/**
	 *
	 */
	public WorkFlowParamConfigReader() {

	}

	public static String getProperty(String key)throws CommonException{
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			ExceptionUtil.throwCommonException("配置文件错误，没有找到[" + key + "]属性参数", ErrorCode.ERROR_CODE_INTERNAL_ERROR);
			return null;
		}
	}

}
