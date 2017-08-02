package com.huateng.ebank.business.print.base;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.huateng.ebank.business.common.ConfigReader;
import com.huateng.ebank.framework.report.ReportDataSource;

import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author kangbyron
 *
 */
public class SccbaPrinter extends BasePrinter {

	@Override
	public List getPrinterList(HttpServletRequest request) throws Exception{
		List jasperPrintList=new ArrayList();  //返回的打印列表
		// 打印种类
		String flag = request.getParameter("flag");


		if(flag.equals("test")){ //打印测试
			for(int i=0; i< 10; i++){
				jasperPrintList.add(this.getTestJasper(i));
			}
		}

		return jasperPrintList;
	}


	private JasperPrint getTestJasper(Integer count) throws Exception {
		String filedir = ConfigReader.getProperty("reportJasperFilePath")+"Test.jasper";  //jasperPath
		File reportFile = new File(filedir);
		if (!reportFile.exists()) {
			throw new JRRuntimeException("File .jasper not found. The report design must be compiled first.");
			}
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());

		List jasperList = new ArrayList();
		Map parameters = new HashMap();
		parameters.put("TEST_PARAM", "Test Success "+count);

		List dataList = new ArrayList();
		dataList.add("data");
		JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport, parameters,new ReportDataSource(dataList));
		return jasperPrint;
	}


}
