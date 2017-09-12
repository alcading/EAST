/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.3 $
 * @date 2005-8-5
 *
 * WEB方式下载文件
 */

public class WebDownloadFile {
	public WebDownloadFile() {
	}

	public static void downloadFile(HttpServletResponse response, File file,
			String displayName) throws Exception {
		OutputStream out = null;
		FileInputStream fis = null;
		try {
			response.setContentType("application/octet-stream;charset=utf-8");
			String urlFileName = URLEncoder.encode(displayName, "utf-8");

			response.setHeader("Content-Disposition", "attachment;filename=\""
					+ urlFileName);
			/* add by zhaozhiguo设置IE特殊的扩展头 保证可以直接打开*/
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			long fileLength = file.length();
			response.setContentLength((int) fileLength);

			out = response.getOutputStream();
			// read file and write stream
			fis = new FileInputStream(file);

			//Util.copyStream(fis, out);
			while (true) {
				int in = fis.read();
				if (-1 == in) {
					break;
				}
				out.write(in);
			}
			out.flush();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (Throwable ex) {
				}
			}
			if (null != fis) {
				try {
					fis.close();
				} catch (Exception e) {
				}
			}

		}//--finally
	}

}