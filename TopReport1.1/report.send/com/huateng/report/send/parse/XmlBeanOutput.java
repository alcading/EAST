package com.huateng.report.send.parse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.report.send.bean.ReportBeanIn;
import com.huateng.report.utils.ReportUtils;

public class XmlBeanOutput implements BeanOutput {

	private static Logger logger = Logger.getLogger(XmlBeanOutput.class);
	private Map<String, Object> data = new HashMap<String, Object>();
	private boolean closed = true;
	private StringBuffer bodyContent;
	private int size = 0;
	private boolean needFlush = false;
	private FileWriter fw;
	private String encoding = "gb18030";
	private static final String FILENAME = "fileName";
	private static final String CONTENTS = "#CONTENTS";
	private static final String LENGTH = "#LENGTH";
	private String sourceSend;

	public void setValue(String key, Object value) {
		data.put(key, value);
	}

	public ReportBeanIn getBean() {
		ReportBeanIn bean = (ReportBeanIn) data.get(REPORTBEAN);
		return bean;
	}

	public void open() throws IOException {
		if (!closed) {
			close();
			data.clear();
		}
		closed = false;
		String path = getBasePath()+ getSourceSend() + getFilePath() ;
		bodyContent = new StringBuffer("");
		File file = new File(path);
		if (!file.exists() || !file.isDirectory()) {
			file.mkdirs();
		}
		String filePathName = path + getFileName();
		logger.info("###filepath:" + filePathName);
		file = new File(filePathName);
		fw = new FileWriter(file);
		// 格式化输出流
		// xmlWriter = new XMLWriter(fw, getFormat());
	}

	public String getBodyHead() {
		ReportBeanIn bean = getBean();
		if (!"TT".equals(bean.getAppType())) {
			return "<MSG><APPTYPE>" + bean.getAppType()
					+ "</APPTYPE><CURRENTFILE>" + bean.getCurrentFile()
					+ "</CURRENTFILE><INOUT>" + bean.getInOut()
					+ "</INOUT><TOTALRECORDS>" + CONTENTS
					+ "</TOTALRECORDS><RECORDS>" + LENGTH + "</RECORDS></MSG>";
		} else {
			return "<MSG><APPTYPE>" + bean.getAppType()
					+ "</APPTYPE><CURRENTFILE>" + bean.getCurrentFile()
					+ "</CURRENTFILE>" + "<INOUT>" + bean.getInOut()
					+ "</INOUT><TOTALFILES>" + CONTENTS
					+ "</TOTALFILES><FILES>" + LENGTH + "</FILES>" + "</MSG>";
		}
	}

	public void write(String content) throws IOException {
		bodyContent.append(content);
		size++;
		needFlush = true;
	}

	public String newNextFile() throws IOException {
		close();
		String fn = getFileName();
		int ind1 = fn.lastIndexOf(".");
		String seqNo = fn.substring(ind1 - 2, ind1);
		int seq = Integer.parseInt(seqNo);
		seq++;
		if (seq < 10) {
			seqNo = "0" + seq;
		} else {
			seqNo = "" + seq;
		}
		fn = fn.substring(0, ind1 - 2) + seqNo + fn.substring(ind1);
		setValue(FILENAME, fn);
		String filePathName = getBasePath()+ getSourceSend()+ getFilePath()  + fn;
		fw = new FileWriter(new File(filePathName));
		logger.info("### new filepath:" + filePathName);
		return fn;
	}

	public void flush() throws IOException {
		String content = getContent();
		fw.write(content);
		fw.flush();
		needFlush = false;
	}

	private String getContent() {
		return "<?xml version=\"1.0\" encoding=\""
				+ encoding
				+ "\"?>"
				+ getBodyHead().replaceAll(CONTENTS, String.valueOf(size))
						.replaceAll(LENGTH, bodyContent.toString());
	}

	public void close() throws IOException {
		if (needFlush) {
			flush();
		}
		if (fw == null) {
			fw.close();
		}
		bodyContent = new StringBuffer("");
		size = 0;
		closed = true;
	}

	private String getBasePath() {
		String basePath = getBean().getBasePath();
		if (StringUtils.isNotBlank(basePath)) {
			if (!(basePath.endsWith("/") || basePath.endsWith("\\"))) {
				basePath += File.separator;
			}
		}
		return basePath;
	}

	private String getFilePath() {
		String filePath = getBean().getFilePath();
		if (StringUtils.isNotBlank(filePath)) {
			if (!(filePath.endsWith("/") || filePath.endsWith("\\"))) {
				filePath += File.separator;
			}
		}
		return filePath;
	}

	protected String getSourceSend() {
		if (sourceSend == null) {
			try {
				sourceSend = ReportUtils.getSysParamsValue("DIR", "0103", "Send/");
			} catch (Exception e) {
				logger.warn("PARAM[DIR][0103] " + e.getMessage());
				sourceSend = "Send/";
			}
		}
		return sourceSend;
	}

	private String getFileName() {
		if (!data.containsKey(FILENAME)) {
			data.put(FILENAME, getBean().getFileName());
		}
		return (String) data.get(FILENAME);
	}

}
