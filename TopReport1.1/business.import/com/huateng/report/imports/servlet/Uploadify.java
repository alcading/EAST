package com.huateng.report.imports.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.imports.common.FileImportUtil;

public class Uploadify extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置接收的编码格式
		request.setCharacterEncoding("UTF-8");
		Date date = new Date();// 获取当前时间
		SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdfFolder = new SimpleDateFormat("yyMM");
		String newfileName = sdfFileName.format(date);// 文件名称
		String fileRealPath = "";// 文件存放真实地址

		String fileRealResistPath = "";// 文件存放真实相对路径
		// 名称 界面编码 必须 和request 保存一致..否则乱码
		String name = request.getParameter("name");
		String firstFileName = "";
		// 获得容器中上传文件夹所在的物理路径
		String savePath = null;

		try {
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			upload.setHeaderEncoding("UTF-8");
			// 获取多个上传文件
			List fileList = fileList = upload.parseRequest(request);
			// 遍历上传文件写入磁盘
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				// 如果item是文件上传表单域
				// 获得文件名及路径
				String fileName = item.getName();
				if (fileName != null) {
					firstFileName = item.getName();
					if (savePath == null) {
						try {
							//modified by xuhong 2015-4-24 修改上传路径 begin
//							savePath = FileImportUtil.getFilePath(firstFileName
//									.substring(
//											firstFileName.lastIndexOf("_") + 1,
//											firstFileName.lastIndexOf(".")));
							String workdate = DataFormat.dateToNumber(DateUtil.getTbsDay());
							savePath = FileImportUtil.getFilePath(workdate);
							//modified by xuhong 2015-4-24 修改上传路径 end
						} catch (CommonException e) {
							e.printStackTrace();
							return;
						}
						System.out.println("路径" + savePath);
						File file = new File(savePath);
						if (!file.exists()) {
							file.mkdir();
						}
					}
					fileRealPath = savePath + firstFileName;// 文件存放真实地址
					BufferedInputStream in = new BufferedInputStream(
							item.getInputStream());// 获得文件输入流
					File f = new File(fileRealPath);
					f.createNewFile();
					BufferedOutputStream outStream = new BufferedOutputStream(
							new FileOutputStream(f));// 获得文件输出流
					Streams.copy(in, outStream, true);// 开始把文件写到你指定的上传文件夹
					// 上传成功，则插入数据库
					if (new File(fileRealPath).exists()) {
						// //虚拟路径赋值
						// fileRealResistPath=sdfFolder.format(date)+File.separator+fileRealPath.substring(fileRealPath.lastIndexOf(File.separator)+1);
						// //保存到数据库
						// System.out.println("保存到数据库:");
						// System.out.println("name:"+name);
						// System.out.println("虚拟路径:"+fileRealResistPath);
					}

				}
			}
		} catch (FileUploadException ex) {
			ex.printStackTrace();
			System.out.println("没有上传文件");
			return;
		}
		response.getWriter().write("1");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}