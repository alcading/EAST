package com.huateng.report.common.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.report.utils.PackZipUtil;
import com.huateng.report.utils.ReportUtils;

public class DownloadFileServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public DownloadFileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String appType = request.getParameter("apptype");
		String type = request.getParameter("type");
		String packName = request.getParameter("pack");

		String localFilePath = null;
		localFilePath = ReportUtils.getSysParamsValue(ReportConstant.REPORT_LOACL_DATA_PARAMGROUP, appType);
		if (type.equalsIgnoreCase("send")) {
			localFilePath += ReportUtils.getSysParamsValue("DIR", "0103", "Send/");
		} else if (type.equalsIgnoreCase("feedback")) {
			localFilePath += ReportUtils.getSysParamsValue("DIR", "0104", "Feedback/");
			packName += ReportConstant.BOP_SUB_FILE_FEEDBACK;// 回执文件
		}
		String tmpPath = ReportUtils.getSysParamsValue("ZIP", "PATH", "/home/");
		File tmpFile = new File(tmpPath);
		if (!tmpFile.exists() || !tmpFile.isDirectory()) {
			tmpFile.mkdirs();
		}

		String zipFile = packName + ReportConstant.DOWN_LOAD_PACK_ZIP_EXT;

		String zipPath = tmpPath + zipFile;
		if (ReportUtils.isFileExist(zipPath)) {// 文件存在直接下载
			// 直接下载
		} else {// 不存在进行压缩
			PackZipUtil zipUtil = new PackZipUtil();
			try {
				zipUtil.createZip(localFilePath, new String[] { packName }, zipPath);
			} catch (Exception e) {
				PrintWriter writer = response.getWriter();
				writer.println("<script type='text/javascript'>alert('" + packName + "打包处理失败:" + e.getMessage()+ "');</script>");
				writer.close();
				return;
			}
		}
		ServletOutputStream out = null;
		// 读取文件流
		try {
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + zipFile + "\"");
			out = response.getOutputStream();
			FileInputStream fileInputStream = new FileInputStream(zipPath);

			if (fileInputStream != null) {
				byte[] tmp = new byte[1024 * 1024];
				int i = 0;
				while ((i = fileInputStream.read(tmp)) != -1) {
					out.write(tmp, 0, i);
				}
			}
			fileInputStream.close();
			out.flush();
		} catch (IOException e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		this.doGet(request, response);
	}
}