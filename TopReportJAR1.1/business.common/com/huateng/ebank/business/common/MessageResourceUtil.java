/**
 *
 */
package com.huateng.ebank.business.common;

import java.text.MessageFormat;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResources;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.exception.AppException;
import com.huateng.view.freemarker.FreeMarkerConfiguration;

/**
 * Title: ErrorCodeUtil Description: Copyright: Copyright (c) 2007 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2007-12-29
 */
public class MessageResourceUtil {
	private static final Log log = LogFactory.getLog(MessageResourceUtil.class);

	/* modify by shen_antonio 20121221 JIRA:FPP-3 begin.*/
	private static MessageResources basicResource = MessageResources
			.getMessageResources("resources.UIi18n");
	/* modify by shen_antonio 20121221 JIRA:FPP-3 end.*/
	private static MessageResources errorResource = MessageResources
			.getMessageResources("resources.errorcode");

	private static boolean ONOFF = false;

	static {
		try {
			ONOFF = "ON".equalsIgnoreCase((String) FreeMarkerConfiguration.getConfigVal("internationalization"));
			if(ONOFF){
				if(log.isInfoEnabled()){
					log.info("i18n is able to run");
				}
			}else{
				if(log.isInfoEnabled()){
					log.info("i18n is enable to run");
				}	
			}
		} catch (AppException e) {
			log.error("#############i18n init error, parameter[Internationalization] is error ############# ",e);
		}
	}
	/**
	 * 是否开启国际化
	 * @return
	 */
	public static boolean isIl8n() {
		return ONOFF;
	}
	/**
	 * 表名加上国际化后缀，以区分不同数据字典表
	 * @param tblNm
	 * @return
	 */
	public static String getDataDicTblNm(String tblNm) {
		String tableName = tblNm;
		if (ONOFF) {
			GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
			tableName += gi == null ? Locale.getDefault() : gi.getLocale();
		}
		return tableName;
		
	}

	/**
	 * 基础资源文件
	 * 
	 * @param msgCode
	 * @param args
	 * @return
	 * @throws CommonException
	 */
	public static String getBasicMessage(String msgCode, boolean nullable,
			Object... args) {
		return getMessage(basicResource, msgCode, nullable, args);
	}

	public static String getBasicMessage(String msgCode, Object... args) {
		return getBasicMessage(msgCode, false, args);
	}

	/**
	 * 异常资源文件
	 * 
	 * @param msgCode
	 * @param args
	 * @return
	 * @throws CommonException
	 */
	public static String getErrorMessage(String msgCode, boolean nullable,
			Object... args) {
		return getMessage(errorResource, msgCode, nullable, args);
	}

	public static String getErrorMessage(String msgCode, Object... args) {
		return getErrorMessage(msgCode, false, args);
	}

	/**
	 * 获取资源文件中给定的KEY对应的消息,并格式化
	 * 
	 * @param messResource
	 * @param msgCode
	 * @param args
	 * @return
	 * @throws CommonException
	 */
	private static synchronized String getMessage(
			MessageResources messResource, String msgCode, boolean nullable,
			Object... args) {
		if (!ONOFF) {
			return msgCode;
		}
		GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
		String mess = messResource.getMessage(gi == null ? Locale.getDefault()
				: gi.getLocale(), msgCode);
		if (mess == null) {
			return nullable ? mess : msgCode;
		} else {
			return MessageFormat.format(mess, args);
		}
	}
}
