package com.huateng.report.send.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import resource.bean.report.SubFileInfo;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.operation.SingleOPCaller;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.report.send.bean.ReportBeanIn;
import com.huateng.report.send.operation.ReportFileInfoOP;
import com.huateng.report.send.parse.BeanOutput;
import com.huateng.report.send.parse.BeanParser;
import com.huateng.report.send.parse.XmlBeanOutput;
import com.huateng.report.send.parse.XmlBeanParser;

public class ReportParser {

	private static Logger logger = Logger.getLogger(ReportParser.class);

	private static final int maxRecordLen = ReportConstant.SUB_FILE_REC_ROW;

	private BeanParser parser = new XmlBeanParser();
	private BeanOutput output = new XmlBeanOutput();

	private ReportParser() {

	}

	public static ReportParser getInstance() {
		// try {
		// return (Parser) ContextUtil.getBean(Parser.class.getName());
		// } catch (Exception e) {
		// throw new RuntimeException(Parser.class.getName()
		// + " class not found in spring xml");
		// }
		return new ReportParser();
	}

	public List<SubFileInfo> generateFile(ReportBeanIn bean) throws Exception {

		List<SubFileInfo> fileInfo = new ArrayList<SubFileInfo>();
		SubFileInfo fi = new SubFileInfo();
		List records = bean.getRecords();
		String beanId = bean.getBeanId();
		parser.setBuffBeanId(beanId);
		output.setValue(BeanOutput.REPORTBEAN, bean);

		int rightCnt = 0;
		String str = null;
		logger.info("###begin gen " + bean.getFileName());
		output.open();
		int size = records.size();
		for (Object obj : records) {
			// 超过5000条拆分文件
			if (++rightCnt > maxRecordLen) {
				String newFileName = output.newNextFile();
				fi = new SubFileInfo();
				fi.setApptype(bean.getAppType());
				fi.setId(newFileName);
				fi.setCurrentfile(bean.getCurrentFile());
				fi.setBrNo(bean.getBrNo());
				fi.setWorkdate(bean.getWorkDate());
				fi.setFilePack(bean.getFilePath());
				fi.setCrtTm(new Date());
				fi.setFileDate(bean.getFileDate());
				fi.setBusiType(bean.getBusiType());
				int len = fi.getId().indexOf(".");
				fi.setSubFileSeq(fi.getId().substring(len-2,len));
				size -= maxRecordLen;
				fi.setTotalrecords(size);
				fileInfo.add(fi);
				logger.info("###begin gen " + newFileName + "\t(split)");
			}
			str = parser.convert2String(obj);
			output.write(str);

		}
		output.close();
		logger.info("###end gen " + bean.getFileName());

		fi = new SubFileInfo();
		fi.setApptype(bean.getAppType());
		fi.setId(bean.getFileName());
		fi.setCurrentfile(bean.getCurrentFile());
		fi.setBrNo(bean.getBrNo());
		fi.setWorkdate(bean.getWorkDate());
		fi.setFilePack(bean.getFilePath());
		fi.setCrtTm(new Date());
		fi.setFileDate(bean.getFileDate());
		fi.setTotalrecords(size);
		fi.setBusiType(bean.getBusiType());
		int len = fi.getId().indexOf(".");
		fi.setSubFileSeq(fi.getId().substring(len-2,len));
		fileInfo.add(fi);
		return fileInfo;
	}

	public void save(List<SubFileInfo> fileInfo) {
		OperationContext oc = new OperationContext();
		try {
			SingleOPCaller.call(ReportFileInfoOP.ID, oc);
		} catch (CommonException e) {
			e.printStackTrace();
			logger.error("save file info failed", e);
		}
	}

}