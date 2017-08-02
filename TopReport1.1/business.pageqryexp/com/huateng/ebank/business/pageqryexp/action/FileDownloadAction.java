/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.pageqryexp.action;

import java.io.File;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.common.Code;
import com.huateng.ebank.business.common.ConfigReader;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.ebank.framework.util.ftp.FtpUtil;
import com.huateng.ebank.framework.web.struts.BaseAction;
/**
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
			downloadInfo = Code.decode(downloadInfo);
			String[] filedesc = downloadInfo.split("[|]");
			String displayName=filedesc[0];
			String absoluteFile=filedesc[1];
			String ext = absoluteFile.substring(absoluteFile.lastIndexOf("."));
 
			file = new File(absoluteFile);
			//mod by zhaozhiguo 如果本地文件不存在,则通过Ftp同步 begin
			String ftpFlag = null;
			try {
				ftpFlag = ConfigReader.getProperty("PageQryExp_FTP");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!file.exists() && "ON".equalsIgnoreCase(ftpFlag)) {
				log.info("FileDownload [" + absoluteFile + "] not exist");
				log.info("Ftp recevie from another machine begin");
				String[] ftpurl = ConfigReader.getProperty("PageQryExp_" + InetAddress.getLocalHost().getHostName()).split(":");
				FtpUtil ftp = new FtpUtil(ftpurl[2], Integer.valueOf(ftpurl[3]), ftpurl[0], ftpurl[1]);
				ftp.connectServer(ext.toUpperCase().endsWith("CSV") ? FTP.ASCII_FILE_TYPE : FTP.BINARY_FILE_TYPE);
				ftp.downloadFile(absoluteFile, absoluteFile);
				ftp.closeServer();
				log.info("Ftp recevie from another machine end");
			}
			//mod by zhaozhiguo 如果本地文件不存在,则通过Ftp同步 end
			WebDownloadFile.downloadFile(response, file, displayName+ext);
		} catch (Exception e) {
			log.error(e);
			String errmsg =Code.encode("下载失败!");
			response.getWriter().write("<script>alert('download failed!');</script>");
		}finally{

		}
		return null;
	}
}