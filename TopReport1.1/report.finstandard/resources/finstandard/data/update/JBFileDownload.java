package resources.finstandard.data.update;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.utils.ReportUtils;

public class JBFileDownload extends HttpServlet {
	private static final Logger logger = Logger.getLogger(JBFileDownload.class);
	private String headerValue = "";
	private InputStream inStream = null;
	private HttpServletResponse response = null;
	private HttpServletRequest request = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("~~~~~DepositBalanceLoad start~~~");
		this.request = req;
		this.response = resp;	
		String sjrq = request.getParameter("sjrq");
		String[] sjrqArr= sjrq.split("");
		DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.US);
		Date date;
		logger.info("数据日期====="+sjrq);
		try {
			date = df.parse(sjrq);
			sjrq = new SimpleDateFormat("MM").format(date);
			if (sjrqArr.length == 33) {
				sjrq = sjrqArr[29]+sjrqArr[30]+sjrqArr[31]+sjrqArr[32]+sjrq;
			} else {
				sjrq = sjrqArr[30]+sjrqArr[31]+sjrqArr[32]+sjrqArr[33]+sjrq;
			}
			String filePath = ReportUtils.getSysParamsValue(Constants.PARAM_DIR, Constants.PARAM_DIR_0104, "");
			filePath = filePath + File.separator + sjrq + File.separator;
			
			logger.info("报文路径===>"+filePath);
			
			String sourceFilePath = filePath;
			String zipFilePath = filePath;
			String fileName = sjrq;
			FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName); 
			inStream = new FileInputStream(zipFilePath+fileName + ".zip");
			fileName = fileName+".zip";
			setResponse(fileName);
			download();
			logger.info("~~~~~DepositBalanceLoad end~~~");
		} catch (Exception e) {
			logger.error("DepositBalanceLoad error", e);
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().write("<script type='text/javascript'>alert('当前日期数据文件还未生成！');</script>");
		}
	}
	
	private void setResponse(String fileName) {
		try {
			fileName = new String(fileName.getBytes("GBK"), "8859_1");
			headerValue = "attachment;   filename=" + fileName;
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", headerValue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
	}
	
	private void download() {
		try {
			PrintWriter pwriter = response.getWriter();
			int by = -1;
			while ((by=inStream.read()) != -1) {
				pwriter.write(by);
			}
			
			inStream.close();
			pwriter.flush();
			pwriter.close();
		} catch (IOException e) {}
	}
}
