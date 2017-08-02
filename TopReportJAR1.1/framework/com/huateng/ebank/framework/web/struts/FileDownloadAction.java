/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.web.struts;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.framework.util.WebDownloadFile;
/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-8-5
 *
 * 下载文件的Action.
 */
public class FileDownloadAction extends BaseAction {
	private static final Log log = LogFactory.getLog(FileDownloadAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		File file = null;
		try {
			//初始化GlobalInfo
			this.init(request);
			String downloadInfo = request.getParameter("downloadinfo");
			//-----------added by HuangWeijing 20090815 jira:BMS-1507 begin--------------
			downloadInfo = java.net.URLDecoder.decode(downloadInfo, "utf-8");
			//-----------added by HuangWeijing 20090815 jira:BMS-1507 end--------------
			if ( null == downloadInfo ) throw new Exception("没有获取下载信息.");
//			String[] strArray = (String[])ObjectSerialiszer.unserialize(downloadInfo);
			String displayName=new File(downloadInfo).getName();
			String absoluteFile=downloadInfo;
//			String absoluteFile = strArray[0];
//			String displayName = strArray[1];
 
			file = new File(absoluteFile);
			WebDownloadFile.downloadFile(response, file, displayName);
//			file = new File(downloadInfo);
//			WebDownloadFile.downloadFile(response, file, "test.txt");
			return null;
		} catch (Exception e) {
			log.error(e);
			String errMsg = ActionExceptionHandler.convertErrorMessage(e);

			request.setAttribute("errormsg", errMsg);
			return mapping.findForward("error");
		}finally{

		}
	}
}