package com.huateng.ebank.framework.web.struts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.ConfigReader;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * <p>
 * Title: WebDownload
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: CES Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 *
 * @author wuzhiwei
 * @version 1.0
 */

public class ReportInqPrintDownAction extends BaseAction {
	private String contentType = "";
	private String headerValue = "";
	private String argFilePath = "";
	private InputStream inStream = null;
	private HttpServletResponse response = null;
	private HttpServletRequest request = null;

	@Override
	public ActionForward execute(ActionMapping mapping,
			org.apache.struts.action.ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("GBK");

		String filepath = new String(request.getParameter("file").getBytes(
				"iso8859-1"), "GBK");
		String statusTmp = new String(request.getParameter("status").getBytes(
		"iso8859-1"), "GBK");
		// filepath = "C:\\2008-07-20\\bh222222222.txt";
		String path="";
		if(statusTmp.equalsIgnoreCase("BATCH")){
		    path = ConfigReader.getProperty("batch.report.file.path");
		}else
			path = ConfigReader.getProperty("reportGenPath");
		String newFilepath = path + File.separator + filepath;
		File file = new File(newFilepath);
		downloadFormFile(request, response, file);
		return null;
	}

	/**
	 * 设置response的contentType类型。
	 *
	 * @param contentType
	 *            其值可参考ResponseContentType提供的值， 如果确切不知道如何设置，可以不用调用该方法，系统会自行辨认。
	 */
	public void setContentType(String contentType) {
		this.contentType = (DataFormat.isEmpty(contentType)) ? "" : contentType;
	}

	/**
	 * 功能：设置头部信息Content-Disposition的值。
	 *
	 * @param headerValue
	 *            头部信息Content-Disposition
	 */
	public void setHeaderValue(String headerValue) {
		this.headerValue = (DataFormat.isEmpty(headerValue)) ? "" : headerValue;
	}

	/**
	 * 功能：将数据库中的值显示出来，显示字段由sql语句确定，当有多个字段时， 只显示第一个字段的值。
	 *
	 * @param request
	 *            请求对象；
	 * @param response
	 *            反馈对象；
	 * @param sqlStr
	 *            sql查询语句；
	 * @param fileName
	 *            下载时想要显示给客户端的文件名
	 * @throws SQLException
	 */
	public void downLoadFromField(HttpServletRequest request,
			HttpServletResponse response, String sqlStr, String fileName)
			throws SQLException {
		this.request = request;
		this.response = response;

	}

	/**
	 * 功能：将服务器路径下的文件下载。
	 *
	 * @param request
	 *            页面请求对象
	 * @param response
	 *            页面回馈对象
	 * @param file
	 *            要下载的文件
	 */
	public void downloadFormFile(HttpServletRequest request,
			HttpServletResponse response, File file) {
		if (file == null || !file.exists() || file.isDirectory()) {
			return;
		}
		this.request = request;
		this.response = response;
		try {
			request.setCharacterEncoding("GBK");
			String fileName = file.getName();
			inStream = new FileInputStream(file);
			setResponse(fileName);
			download();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 功能：方法重载。 <B>此方法为并不确切知道文件在服务器的确切路径，但知道其url字符串。此时可用该方法下载文件。
	 * 本方法为什么不用url直接产生输入流，原因在于中文名的文件不能正确识别，抛出
	 * java.io.FileNotFoundException的异常，不知如何解决，目前暂时以文件产生输入流。 </B>
	 *
	 * @param request
	 *            页面请求对象
	 * @param response
	 *            页面回馈对象
	 * @param fileHttp
	 *            要下载的文件
	 * @throws MalformedURLException
	 */
	public void downloadFormFile(HttpServletRequest request,
			HttpServletResponse response, String fileHttp)
			throws MalformedURLException {
		this.request = request;
		this.response = response;
		try {
			String fileName = fileHttp.substring(fileHttp.lastIndexOf("/") + 1);
			setResponse(fileName);
			request.setCharacterEncoding("GBK");
			URL url = new URL(fileHttp);
			String protocal = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort();
			String file = url.getFile();
			String urlAddr = protocal + "://" + host + ":" + port;
			if (port == -1) {
				urlAddr = protocal + "://" + host + file;
			}
			urlAddr += file.substring(0, file.lastIndexOf("/") + 1);

			urlAddr += fileName;// DataFormat.encode(fileName, "UTF-8");

			url = new URL(urlAddr);
			inStream = url.openStream();
			download();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 功能：内部调用。
	 *
	 * @param fileName
	 *            完成response的设置
	 */
	private void setResponse(String fileName) {
		try {
			fileName = new String(fileName.getBytes("GBK"), "8859_1");
			contentType = ResponseContentType.getContentType(fileName);
			headerValue = "attachment;   filename=" + fileName;
			response.setContentType(contentType);
			response.setHeader("Content-Disposition", headerValue);
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 内部调用：完成将希望显示的值输出到流中。
	 *
	 */
	private void download() {
		try {
			PrintWriter pwriter = response.getWriter();
			int by = -1;
			while ((by = inStream.read()) != -1) {
				pwriter.write(by);
			}
			inStream.close();
			pwriter.flush();
			pwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}